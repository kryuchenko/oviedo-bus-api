package com.google.android.material.color.utilities;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes4.dex */
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    private QuantizerWsmeans() {
    }

    private static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        Distance() {
        }

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i) {
        double[] dArr;
        double[] dArr2;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr3 = new double[iArr.length][];
        int[] iArr3 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i2 = 0;
        for (int i3 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i3));
            if (num == null) {
                dArr3[i2] = pointProviderLab.fromInt(i3);
                iArr3[i2] = i3;
                i2++;
                linkedHashMap.put(Integer.valueOf(i3), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr4 = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            iArr4[i4] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr3[i4]))).intValue();
        }
        int iMin = Math.min(i, i2);
        if (iArr2.length != 0) {
            iMin = Math.min(iMin, iArr2.length);
        }
        double[][] dArr4 = new double[iMin][];
        int i5 = 0;
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            dArr4[i6] = pointProviderLab.fromInt(iArr2[i6]);
            i5++;
        }
        int i7 = iMin - i5;
        if (i7 > 0) {
            for (int i8 = 0; i8 < i7; i8++) {
            }
        }
        int[] iArr5 = new int[i2];
        for (int i9 = 0; i9 < i2; i9++) {
            iArr5[i9] = random.nextInt(iMin);
        }
        int[][] iArr6 = new int[iMin][];
        for (int i10 = 0; i10 < iMin; i10++) {
            iArr6[i10] = new int[iMin];
        }
        Distance[][] distanceArr = new Distance[iMin][];
        for (int i11 = 0; i11 < iMin; i11++) {
            distanceArr[i11] = new Distance[iMin];
            for (int i12 = 0; i12 < iMin; i12++) {
                distanceArr[i11][i12] = new Distance();
            }
        }
        int[] iArr7 = new int[iMin];
        int i13 = 0;
        while (i13 < 10) {
            int i14 = 0;
            while (i14 < iMin) {
                int i15 = i14 + 1;
                int i16 = i15;
                while (i16 < iMin) {
                    int[] iArr8 = iArr4;
                    double dDistance = pointProviderLab.distance(dArr4[i14], dArr4[i16]);
                    distanceArr[i16][i14].distance = dDistance;
                    distanceArr[i16][i14].index = i14;
                    distanceArr[i14][i16].distance = dDistance;
                    distanceArr[i14][i16].index = i16;
                    i16++;
                    iArr4 = iArr8;
                    iArr5 = iArr5;
                }
                int[] iArr9 = iArr4;
                int[] iArr10 = iArr5;
                Arrays.sort(distanceArr[i14]);
                for (int i17 = 0; i17 < iMin; i17++) {
                    iArr6[i14][i17] = distanceArr[i14][i17].index;
                }
                iArr4 = iArr9;
                iArr5 = iArr10;
                i14 = i15;
            }
            int[] iArr11 = iArr4;
            int[] iArr12 = iArr5;
            int i18 = 0;
            int i19 = 0;
            while (i18 < i2) {
                double[] dArr5 = dArr3[i18];
                int i20 = iArr12[i18];
                double dDistance2 = pointProviderLab.distance(dArr5, dArr4[i20]);
                int i21 = i18;
                double d = dDistance2;
                int i22 = -1;
                int i23 = 0;
                while (i23 < iMin) {
                    int i24 = i19;
                    int[][] iArr13 = iArr6;
                    if (distanceArr[i20][i23].distance < 4.0d * dDistance2) {
                        double dDistance3 = pointProviderLab.distance(dArr5, dArr4[i23]);
                        if (dDistance3 < d) {
                            d = dDistance3;
                            i22 = i23;
                        }
                    }
                    i23++;
                    iArr6 = iArr13;
                    i19 = i24;
                }
                int i25 = i19;
                int[][] iArr14 = iArr6;
                if (i22 == -1 || Math.abs(Math.sqrt(d) - Math.sqrt(dDistance2)) <= 3.0d) {
                    i19 = i25;
                } else {
                    i19 = i25 + 1;
                    iArr12[i21] = i22;
                }
                i18 = i21 + 1;
                iArr6 = iArr14;
            }
            int[][] iArr15 = iArr6;
            if (i19 == 0 && i13 != 0) {
                break;
            }
            double[] dArr6 = new double[iMin];
            double[] dArr7 = new double[iMin];
            double[] dArr8 = new double[iMin];
            Arrays.fill(iArr7, 0);
            for (int i26 = 0; i26 < i2; i26++) {
                int i27 = iArr12[i26];
                double[] dArr9 = dArr3[i26];
                int i28 = iArr11[i26];
                iArr7[i27] = iArr7[i27] + i28;
                double d2 = i28;
                dArr6[i27] = dArr6[i27] + (dArr9[0] * d2);
                dArr7[i27] = dArr7[i27] + (dArr9[1] * d2);
                dArr8[i27] = dArr8[i27] + (dArr9[2] * d2);
            }
            int i29 = 0;
            while (i29 < iMin) {
                int i30 = iArr7[i29];
                if (i30 == 0) {
                    dArr4[i29] = new double[]{0.0d, 0.0d, 0.0d};
                    dArr = dArr6;
                    dArr2 = dArr7;
                } else {
                    double d3 = dArr6[i29];
                    dArr = dArr6;
                    dArr2 = dArr7;
                    double d4 = i30;
                    double d5 = d3 / d4;
                    double d6 = dArr2[i29] / d4;
                    double d7 = dArr8[i29] / d4;
                    double[] dArr10 = dArr4[i29];
                    dArr10[0] = d5;
                    dArr10[1] = d6;
                    dArr10[2] = d7;
                }
                i29++;
                dArr6 = dArr;
                dArr7 = dArr2;
            }
            i13++;
            iArr4 = iArr11;
            iArr5 = iArr12;
            iArr6 = iArr15;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i31 = 0; i31 < iMin; i31++) {
            int i32 = iArr7[i31];
            if (i32 != 0) {
                int i33 = pointProviderLab.toInt(dArr4[i31]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i33))) {
                    linkedHashMap2.put(Integer.valueOf(i33), Integer.valueOf(i32));
                }
            }
        }
        return linkedHashMap2;
    }
}
