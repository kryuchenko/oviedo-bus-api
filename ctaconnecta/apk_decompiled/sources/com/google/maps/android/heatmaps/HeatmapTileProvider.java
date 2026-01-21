package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.LongSparseArray;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 22;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 512;
    static final double WORLD_WIDTH = 1.0d;
    private Bounds mBounds;
    private int[] mColorMap;
    private double mCustomMaxIntensity;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private PointQuadTree<WeightedLatLng> mTree;

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 20;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.7d;
        private double intensity = 0.0d;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.wrapData(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            return this;
        }

        public Builder radius(int i) {
            this.radius = i;
            if (i < 10 || i > 50) {
                throw new IllegalArgumentException("Radius not within bounds.");
            }
            return this;
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder opacity(double d) {
            this.opacity = d;
            if (d < 0.0d || d > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder maxIntensity(double d) {
            this.intensity = d;
            return this;
        }

        public HeatmapTileProvider build() {
            if (this.data == null) {
                throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
            }
            return new HeatmapTileProvider(this);
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        this.mGradient = builder.gradient;
        this.mOpacity = builder.opacity;
        this.mCustomMaxIntensity = builder.intensity;
        int i = this.mRadius;
        this.mKernel = generateKernel(i, i / 3.0d);
        setGradient(this.mGradient);
        setWeightedData(this.mData);
    }

    public void setWeightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        this.mBounds = getBounds(this.mData);
        this.mTree = new PointQuadTree<>(this.mBounds);
        Iterator<WeightedLatLng> it = this.mData.iterator();
        while (it.hasNext()) {
            this.mTree.add(it.next());
        }
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setData(Collection<LatLng> collection) {
        setWeightedData(wrapData(collection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) {
        double d = 1.0d;
        double dPow = 1.0d / Math.pow(2.0d, i3);
        double d2 = (this.mRadius * dPow) / 512.0d;
        double d3 = ((2.0d * d2) + dPow) / ((r10 * 2) + 512);
        double d4 = (i * dPow) - d2;
        double d5 = ((i + 1) * dPow) + d2;
        double d6 = (i2 * dPow) - d2;
        double d7 = ((i2 + 1) * dPow) + d2;
        Collection<WeightedLatLng> arrayList = new ArrayList();
        if (d4 < 0.0d) {
            arrayList = this.mTree.search(new Bounds(d4 + 1.0d, 1.0d, d6, d7));
            d = -1.0d;
        } else if (d5 > 1.0d) {
            arrayList = this.mTree.search(new Bounds(0.0d, d5 - 1.0d, d6, d7));
        } else {
            d = 0.0d;
        }
        Bounds bounds = new Bounds(d4, d5, d6, d7);
        if (!bounds.intersects(new Bounds(this.mBounds.minX - d2, this.mBounds.maxX + d2, this.mBounds.minY - d2, this.mBounds.maxY + d2))) {
            return TileProvider.NO_TILE;
        }
        Collection<T> collectionSearch = this.mTree.search(bounds);
        if (collectionSearch.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        int i4 = this.mRadius;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (i4 * 2) + 512, (i4 * 2) + 512);
        for (T t : collectionSearch) {
            Point point = t.getPoint();
            int i5 = (int) ((point.x - d4) / d3);
            int i6 = (int) ((point.y - d6) / d3);
            double[] dArr2 = dArr[i5];
            dArr2[i6] = dArr2[i6] + t.getIntensity();
        }
        for (WeightedLatLng weightedLatLng : arrayList) {
            Point point2 = weightedLatLng.getPoint();
            int i7 = (int) (((point2.x + d) - d4) / d3);
            int i8 = (int) ((point2.y - d6) / d3);
            double[] dArr3 = dArr[i7];
            dArr3[i8] = dArr3[i8] + weightedLatLng.getIntensity();
        }
        return convertBitmap(colorize(convolve(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i3]));
    }

    public void setGradient(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    public void setRadius(int i) {
        this.mRadius = i;
        this.mKernel = generateKernel(i, i / 3.0d);
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setOpacity(double d) {
        this.mOpacity = d;
        setGradient(this.mGradient);
    }

    public void setMaxIntensity(double d) {
        this.mCustomMaxIntensity = d;
        setWeightedData(this.mData);
    }

    private double[] getMaxIntensities(int i) {
        int i2;
        double[] dArr = new double[22];
        if (this.mCustomMaxIntensity != 0.0d) {
            for (int i3 = 0; i3 < 22; i3++) {
                dArr[i3] = this.mCustomMaxIntensity;
            }
        } else {
            int i4 = 5;
            while (true) {
                if (i4 >= 11) {
                    break;
                }
                dArr[i4] = getMaxValue(this.mData, this.mBounds, i, (int) (Math.pow(2.0d, i4 - 3) * 1280.0d));
                if (i4 == 5) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        dArr[i5] = dArr[i4];
                    }
                }
                i4++;
            }
            for (i2 = 11; i2 < 22; i2++) {
                dArr[i2] = dArr[10];
            }
        }
        return dArr;
    }

    private static Tile convertBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(512, 512, byteArrayOutputStream.toByteArray());
    }

    static Bounds getBounds(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().x;
        double d2 = next.getPoint().x;
        double d3 = d;
        double d4 = d2;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new Bounds(d3, d4, d5, d6);
    }

    static double[] generateKernel(int i, double d) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((-i2) * i2) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] convolve(double[][] dArr, double[] dArr2) {
        int iFloor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i = length - (iFloor * 2);
        int i2 = iFloor + i;
        int i3 = i2 - 1;
        int i4 = 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
        int i5 = 0;
        while (i5 < length) {
            int i6 = 0;
            while (i6 < length) {
                double d = dArr[i5][i6];
                if (d != 0.0d) {
                    int i7 = i5 + iFloor;
                    if (i3 < i7) {
                        i7 = i3;
                    }
                    int i8 = i7 + i4;
                    int i9 = i5 - iFloor;
                    for (int i10 = iFloor > i9 ? iFloor : i9; i10 < i8; i10++) {
                        double[] dArr4 = dArr3[i10];
                        dArr4[i6] = dArr4[i6] + (dArr2[i10 - i9] * d);
                    }
                }
                i6++;
                i4 = 1;
            }
            i5++;
            i4 = 1;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, i);
        for (int i11 = iFloor; i11 < i2; i11++) {
            for (int i12 = 0; i12 < length; i12++) {
                double d2 = dArr3[i11][i12];
                if (d2 != 0.0d) {
                    int i13 = i12 + iFloor;
                    if (i3 < i13) {
                        i13 = i3;
                    }
                    int i14 = i13 + 1;
                    int i15 = i12 - iFloor;
                    for (int i16 = iFloor > i15 ? iFloor : i15; i16 < i14; i16++) {
                        double[] dArr6 = dArr5[i11 - iFloor];
                        int i17 = i16 - iFloor;
                        dArr6[i17] = dArr6[i17] + (dArr2[i16 - i15] * d2);
                    }
                }
            }
        }
        return dArr5;
    }

    static Bitmap colorize(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 != 0.0d) {
                    if (i5 < iArr.length) {
                        iArr2[i4] = iArr[i5];
                    } else {
                        iArr2[i4] = i;
                    }
                } else {
                    iArr2[i4] = 0;
                }
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return bitmapCreateBitmap;
    }

    static double getMaxValue(Collection<WeightedLatLng> collection, Bounds bounds, int i, int i2) {
        double d = bounds.minX;
        double d2 = bounds.maxX;
        double d3 = bounds.minY;
        double d4 = d2 - d;
        double d5 = bounds.maxY - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((int) ((i2 / (i * 2)) + 0.5d)) / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d7 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d8 = weightedLatLng.getPoint().x;
            int i3 = (int) ((weightedLatLng.getPoint().y - d3) * d6);
            long j = (int) ((d8 - d) * d6);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i3;
            Double dValueOf = (Double) longSparseArray2.get(j2);
            if (dValueOf == null) {
                dValueOf = Double.valueOf(0.0d);
            }
            double dDoubleValue = dValueOf.doubleValue() + weightedLatLng.getIntensity();
            Double dValueOf2 = Double.valueOf(dDoubleValue);
            longSparseArray2.put(j2, dValueOf2);
            dValueOf2.getClass();
            if (dDoubleValue > d7) {
                dValueOf2.getClass();
                d7 = dDoubleValue;
            }
        }
        return d7;
    }
}
