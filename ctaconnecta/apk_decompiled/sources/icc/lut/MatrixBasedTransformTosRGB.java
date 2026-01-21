package icc.lut;

import colorspace.ColorSpace;
import icc.RestrictedICCProfile;
import icc.tags.ICCXYZType;
import java.lang.reflect.Array;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class MatrixBasedTransformTosRGB {
    private static final int BLUE = 2;
    private static final int GREEN = 1;
    private static final int M00 = 0;
    private static final int M01 = 1;
    private static final int M02 = 2;
    private static final int M10 = 3;
    private static final int M11 = 4;
    private static final int M12 = 5;
    private static final int M20 = 6;
    private static final int M21 = 7;
    private static final int M22 = 8;
    private static final int RED = 0;
    private static final double SRGB00 = 3.1337d;
    private static final double SRGB01 = -1.6173d;
    private static final double SRGB02 = -0.4907d;
    private static final double SRGB10 = -0.9785d;
    private static final double SRGB11 = 1.9162d;
    private static final double SRGB12 = 0.0334d;
    private static final double SRGB20 = 0.072d;
    private static final double SRGB21 = -0.229d;
    private static final double SRGB22 = 1.4056d;
    private static final String eol = System.getProperty("line.separator");
    private static final double ksRGBExponent = 0.4166666666666667d;
    private static final double ksRGBReduceAfterExp = 0.055d;
    private static final double ksRGBScaleAfterExp = 1.055d;
    private static final double ksRGBShadowCutoff = 0.0031308d;
    private static final double ksRGBShadowSlope = 12.92d;
    private final int[] dwMaxValue;
    private final int[] dwShiftValue;
    private LookUpTable32LinearSRGBtoSRGB lut;
    private final double[] matrix;
    private LookUpTableFP[] fLut = new LookUpTableFP[3];
    private int dwMaxCols = 0;
    private int dwMaxRows = 0;
    private float[][] fBuf = null;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[MatrixBasedTransformTosRGB: ");
        StringBuffer stringBuffer2 = new StringBuffer("  ");
        String str = eol;
        stringBuffer2.append(str).append("ksRGBExponent= ").append(String.valueOf(0.4166666666666667d));
        stringBuffer2.append(str).append("ksRGBScaleAfterExp= ").append(String.valueOf(ksRGBScaleAfterExp));
        stringBuffer2.append(str).append("ksRGBReduceAfterExp= ").append(String.valueOf(ksRGBReduceAfterExp));
        stringBuffer2.append(str).append("dwMaxValues= ").append(String.valueOf(this.dwMaxValue[0])).append(", ").append(String.valueOf(this.dwMaxValue[1])).append(", ").append(String.valueOf(this.dwMaxValue[2]));
        stringBuffer2.append(str).append("dwShiftValues= ").append(String.valueOf(this.dwShiftValue[0])).append(", ").append(String.valueOf(this.dwShiftValue[1])).append(", ").append(String.valueOf(this.dwShiftValue[2]));
        stringBuffer2.append(str).append(str).append("fLut= ").append(str).append(ColorSpace.indent("  ", "fLut[RED]=  " + this.fLut[0].toString())).append(str).append(ColorSpace.indent("  ", "fLut[GRN]=  " + this.fLut[1].toString())).append(str).append(ColorSpace.indent("  ", "fLut[BLU]=  " + this.fLut[2].toString()));
        stringBuffer2.append(str).append(str).append("[matrix ");
        for (int i = 0; i < 3; i++) {
            stringBuffer2.append(eol).append("  ");
            for (int i2 = 0; i2 < 3; i2++) {
                stringBuffer2.append(this.matrix[(i * 3) + i2] + "   ");
            }
        }
        stringBuffer2.append("]");
        String str2 = eol;
        stringBuffer2.append(str2).append(str2).append(this.lut.toString());
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2)).append("]]");
        return stringBuffer.toString();
    }

    public MatrixBasedTransformTosRGB(RestrictedICCProfile restrictedICCProfile, int[] iArr, int[] iArr2) {
        if (restrictedICCProfile.getType() != 1) {
            throw new IllegalArgumentException("MatrixBasedTransformTosRGB: wrong type ICCProfile supplied");
        }
        this.dwMaxValue = iArr;
        this.dwShiftValue = iArr2;
        for (int i = 0; i < 3; i++) {
            this.fLut[i] = LookUpTableFP.createInstance(restrictedICCProfile.trc[i], iArr[i] + 1);
        }
        this.matrix = createMatrix(restrictedICCProfile, iArr);
        int i2 = iArr[0];
        this.lut = LookUpTable32LinearSRGBtoSRGB.createInstance(i2, i2, 0.0031308d, 12.92d, ksRGBScaleAfterExp, 0.4166666666666667d, ksRGBReduceAfterExp);
    }

    private double[] createMatrix(RestrictedICCProfile restrictedICCProfile, int[] iArr) {
        double dXYZToDouble = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[0].x);
        double dXYZToDouble2 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[1].x);
        double dXYZToDouble3 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[2].x);
        double dXYZToDouble4 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[0].y);
        double dXYZToDouble5 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[1].y);
        double dXYZToDouble6 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[2].y);
        double dXYZToDouble7 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[0].z);
        double dXYZToDouble8 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[1].z);
        double dXYZToDouble9 = ICCXYZType.XYZToDouble(restrictedICCProfile.colorant[2].z);
        int i = iArr[0];
        double d = i * ((dXYZToDouble * SRGB00) + (dXYZToDouble4 * SRGB01) + (dXYZToDouble7 * SRGB02));
        double d2 = i * ((dXYZToDouble2 * SRGB00) + (dXYZToDouble5 * SRGB01) + (dXYZToDouble8 * SRGB02));
        double d3 = i * ((SRGB00 * dXYZToDouble3) + (SRGB01 * dXYZToDouble6) + (dXYZToDouble9 * SRGB02));
        int i2 = iArr[1];
        double d4 = i2 * ((dXYZToDouble * SRGB10) + (dXYZToDouble4 * SRGB11) + (dXYZToDouble7 * SRGB12));
        double d5 = i2 * ((dXYZToDouble2 * SRGB10) + (dXYZToDouble5 * SRGB11) + (dXYZToDouble8 * SRGB12));
        double d6 = i2 * ((SRGB10 * dXYZToDouble3) + (SRGB11 * dXYZToDouble6) + (dXYZToDouble9 * SRGB12));
        int i3 = iArr[2];
        return new double[]{d, d2, d3, d4, d5, d6, i3 * ((dXYZToDouble * SRGB20) + (dXYZToDouble4 * SRGB21) + (dXYZToDouble7 * SRGB22)), i3 * ((dXYZToDouble2 * SRGB20) + (dXYZToDouble5 * SRGB21) + (dXYZToDouble8 * SRGB22)), i3 * ((dXYZToDouble3 * SRGB20) + (dXYZToDouble6 * SRGB21) + (dXYZToDouble9 * SRGB22))};
    }

    public void apply(DataBlkInt[] dataBlkIntArr, DataBlkInt[] dataBlkIntArr2) throws MatrixBasedTransformException {
        MatrixBasedTransformTosRGB matrixBasedTransformTosRGB = this;
        int[][] iArr = new int[3][];
        int[][] iArr2 = new int[3][];
        int i = dataBlkIntArr[0].h;
        int i2 = dataBlkIntArr[0].w;
        float[][] fArr = matrixBasedTransformTosRGB.fBuf;
        if (fArr == null || fArr[0].length < i2 * i) {
            matrixBasedTransformTosRGB.fBuf = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, i2 * i);
        }
        for (int i3 = 0; i3 < 3; i3++) {
            iArr[i3] = (int[]) dataBlkIntArr[i3].getData();
            int[] iArr3 = (int[]) dataBlkIntArr2[i3].getData();
            iArr2[i3] = iArr3;
            if (iArr3 == null || iArr3.length < iArr[i3].length) {
                int[] iArr4 = new int[iArr[i3].length];
                iArr2[i3] = iArr4;
                dataBlkIntArr2[i3].setData(iArr4);
            }
            standardizeMatrixLineThroughLut(dataBlkIntArr[i3], matrixBasedTransformTosRGB.fBuf[i3], matrixBasedTransformTosRGB.dwMaxValue[i3], matrixBasedTransformTosRGB.fLut[i3]);
        }
        float[][] fArr2 = matrixBasedTransformTosRGB.fBuf;
        float[] fArr3 = fArr2[0];
        float[] fArr4 = fArr2[1];
        float[] fArr5 = fArr2[2];
        int[] iArr5 = iArr2[0];
        int[] iArr6 = iArr2[1];
        int[] iArr7 = iArr2[2];
        int[] iArr8 = matrixBasedTransformTosRGB.lut.lut;
        int i4 = 0;
        int i5 = 0;
        for (char c = 0; i4 < dataBlkIntArr[c].h; c = 0) {
            int i6 = dataBlkIntArr[c].w + i5;
            while (i5 < i6) {
                float[] fArr6 = fArr5;
                double d = fArr3[i5];
                float[] fArr7 = fArr3;
                double d2 = fArr4[i5];
                double d3 = fArr6[i5];
                double[] dArr = matrixBasedTransformTosRGB.matrix;
                int i7 = (int) ((dArr[0] * d) + (dArr[1] * d2) + (dArr[2] * d3) + 0.5d);
                if (i7 < 0) {
                    iArr5[i5] = iArr8[0];
                } else if (i7 >= iArr8.length) {
                    iArr5[i5] = iArr8[iArr8.length - 1];
                } else {
                    iArr5[i5] = iArr8[i7];
                }
                int i8 = (int) ((dArr[3] * d) + (dArr[4] * d2) + (dArr[5] * d3) + 0.5d);
                if (i8 < 0) {
                    iArr6[i5] = iArr8[0];
                } else if (i8 >= iArr8.length) {
                    iArr6[i5] = iArr8[iArr8.length - 1];
                } else {
                    iArr6[i5] = iArr8[i8];
                }
                int i9 = (int) ((dArr[6] * d) + (dArr[7] * d2) + (dArr[8] * d3) + 0.5d);
                if (i9 < 0) {
                    iArr7[i5] = iArr8[0];
                } else if (i9 >= iArr8.length) {
                    iArr7[i5] = iArr8[iArr8.length - 1];
                } else {
                    iArr7[i5] = iArr8[i9];
                }
                i5++;
                matrixBasedTransformTosRGB = this;
                fArr5 = fArr6;
                fArr3 = fArr7;
            }
            i4++;
            matrixBasedTransformTosRGB = this;
        }
    }

    public void apply(DataBlkFloat[] dataBlkFloatArr, DataBlkFloat[] dataBlkFloatArr2) throws MatrixBasedTransformException {
        float[][] fArr = new float[3][];
        float[][] fArr2 = new float[3][];
        char c = 0;
        int i = dataBlkFloatArr[0].h;
        int i2 = dataBlkFloatArr[0].w;
        float[][] fArr3 = this.fBuf;
        char c2 = 1;
        if (fArr3 == null || fArr3[0].length < i2 * i) {
            this.fBuf = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, i2 * i);
        }
        for (int i3 = 0; i3 < 3; i3++) {
            fArr[i3] = (float[]) dataBlkFloatArr[i3].getData();
            float[] fArr4 = (float[]) dataBlkFloatArr2[i3].getData();
            fArr2[i3] = fArr4;
            if (fArr4 == null || fArr4.length < fArr[i3].length) {
                float[] fArr5 = new float[fArr[i3].length];
                fArr2[i3] = fArr5;
                dataBlkFloatArr2[i3].setData(fArr5);
            }
            standardizeMatrixLineThroughLut(dataBlkFloatArr[i3], this.fBuf[i3], this.dwMaxValue[i3], this.fLut[i3]);
        }
        int[] iArr = this.lut.lut;
        int i4 = 0;
        int i5 = 0;
        while (i4 < dataBlkFloatArr[c].h) {
            int i6 = dataBlkFloatArr[c].w + i5;
            while (i5 < i6) {
                double[] dArr = this.matrix;
                double d = dArr[c];
                float[][] fArr6 = this.fBuf;
                float[] fArr7 = fArr6[c];
                int i7 = i4;
                double d2 = dArr[c2];
                float[] fArr8 = fArr6[c2];
                double d3 = (d * fArr7[i5]) + (d2 * fArr8[i5]);
                double d4 = dArr[2];
                float[] fArr9 = fArr6[2];
                int i8 = (int) (d3 + (d4 * fArr9[i5]) + 0.5d);
                if (i8 < 0) {
                    fArr2[0][i5] = iArr[0];
                } else if (i8 >= iArr.length) {
                    fArr2[0][i5] = iArr[iArr.length - 1];
                } else {
                    fArr2[0][i5] = iArr[i8];
                }
                int i9 = (int) ((dArr[3] * fArr7[i5]) + (dArr[4] * fArr8[i5]) + (dArr[5] * fArr9[i5]) + 0.5d);
                if (i9 < 0) {
                    fArr2[1][i5] = iArr[0];
                } else if (i9 >= iArr.length) {
                    fArr2[1][i5] = iArr[iArr.length - 1];
                } else {
                    fArr2[1][i5] = iArr[i9];
                }
                int i10 = (int) ((dArr[6] * fArr7[i5]) + (dArr[7] * fArr8[i5]) + (dArr[8] * fArr9[i5]) + 0.5d);
                if (i10 < 0) {
                    fArr2[2][i5] = iArr[0];
                } else if (i10 >= iArr.length) {
                    fArr2[2][i5] = iArr[iArr.length - 1];
                } else {
                    fArr2[2][i5] = iArr[i10];
                }
                i5++;
                i4 = i7;
                c = 0;
                c2 = 1;
            }
            i4++;
            c = 0;
            c2 = 1;
        }
    }

    private static void standardizeMatrixLineThroughLut(DataBlkInt dataBlkInt, float[] fArr, int i, LookUpTableFP lookUpTableFP) {
        int[] iArr = (int[]) dataBlkInt.getData();
        float[] fArr2 = lookUpTableFP.lut;
        int i2 = 0;
        for (int i3 = dataBlkInt.uly; i3 < dataBlkInt.uly + dataBlkInt.h; i3++) {
            int i4 = dataBlkInt.ulx;
            while (i4 < dataBlkInt.ulx + dataBlkInt.w) {
                int i5 = iArr[dataBlkInt.offset + ((i3 - dataBlkInt.uly) * dataBlkInt.scanw) + (i4 - dataBlkInt.ulx)];
                if (i5 > i) {
                    i5 = i;
                } else if (i5 < 0) {
                    i5 = 0;
                }
                fArr[i2] = fArr2[i5];
                i4++;
                i2++;
            }
        }
    }

    private static void standardizeMatrixLineThroughLut(DataBlkFloat dataBlkFloat, float[] fArr, float f, LookUpTableFP lookUpTableFP) {
        float[] fArr2 = (float[]) dataBlkFloat.getData();
        float[] fArr3 = lookUpTableFP.lut;
        int i = 0;
        for (int i2 = dataBlkFloat.uly; i2 < dataBlkFloat.uly + dataBlkFloat.h; i2++) {
            int i3 = dataBlkFloat.ulx;
            while (i3 < dataBlkFloat.ulx + dataBlkFloat.w) {
                float f2 = fArr2[dataBlkFloat.offset + ((i2 - dataBlkFloat.uly) * dataBlkFloat.scanw) + (i3 - dataBlkFloat.ulx)];
                if (f2 > f) {
                    f2 = f;
                } else if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                fArr[i] = fArr3[(int) f2];
                i3++;
                i++;
            }
        }
    }
}
