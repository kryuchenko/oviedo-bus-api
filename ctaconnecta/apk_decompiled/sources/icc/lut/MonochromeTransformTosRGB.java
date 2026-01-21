package icc.lut;

import colorspace.ColorSpace;
import icc.RestrictedICCProfile;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class MonochromeTransformTosRGB {
    private static final String eol = System.getProperty("line.separator");
    public static final double ksRGB8ReduceAfterExp = 14.025d;
    public static final double ksRGB8ScaleAfterExp = 269.025d;
    public static final double ksRGB8ShadowSlope = 3294.6d;
    public static final double ksRGBExponent = 0.4166666666666667d;
    public static final double ksRGBShadowCutoff = 0.0031308d;
    public static final double ksRGBShadowSlope = 12.92d;
    private int dwInputMaxValue;
    private LookUpTableFP fLut;
    private short[] lut;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[MonochromeTransformTosRGB ");
        StringBuffer stringBuffer2 = new StringBuffer("  ");
        String str = eol;
        stringBuffer2.append(str).append("ksRGBShadowSlope= ").append(String.valueOf(12.92d));
        stringBuffer2.append(str).append("ksRGBShadowCutoff= ").append(String.valueOf(0.0031308d));
        stringBuffer2.append(str).append("ksRGBShadowSlope= ").append(String.valueOf(12.92d));
        stringBuffer2.append(str).append("ksRGB8ShadowSlope= ").append(String.valueOf(3294.6d));
        stringBuffer2.append(str).append("ksRGBExponent= ").append(String.valueOf(0.4166666666666667d));
        stringBuffer2.append(str).append("ksRGB8ScaleAfterExp= ").append(String.valueOf(269.025d));
        stringBuffer2.append(str).append("ksRGB8ReduceAfterExp= ").append(String.valueOf(14.025d));
        stringBuffer2.append(str).append("dwInputMaxValue= ").append(String.valueOf(this.dwInputMaxValue));
        stringBuffer2.append(str).append("[lut = [short[" + this.lut.length + "]]]");
        stringBuffer2.append(str).append("fLut=  " + this.fLut.toString());
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2));
        return stringBuffer.append("]").toString();
    }

    public MonochromeTransformTosRGB(RestrictedICCProfile restrictedICCProfile, int i, int i2) {
        this.lut = null;
        int i3 = 0;
        this.dwInputMaxValue = 0;
        this.fLut = null;
        if (restrictedICCProfile.getType() != 0) {
            throw new IllegalArgumentException("MonochromeTransformTosRGB: wrong type ICCProfile supplied");
        }
        this.dwInputMaxValue = i;
        int i4 = i + 1;
        this.lut = new short[i4];
        this.fLut = LookUpTableFP.createInstance(restrictedICCProfile.trc[0], i4);
        while (i3 <= i && this.fLut.lut[i3] <= 0.0031308d) {
            this.lut[i3] = (short) (Math.floor((this.fLut.lut[i3] * 3294.6d) + 0.5d) - i2);
            i3++;
        }
        while (i3 <= i) {
            this.lut[i3] = (short) (Math.floor(((Math.pow(this.fLut.lut[i3], 0.4166666666666667d) * 269.025d) - 14.025d) + 0.5d) - i2);
            i3++;
        }
    }

    public void apply(DataBlkInt dataBlkInt, DataBlkInt dataBlkInt2) throws MonochromeTransformException {
        int[] iArr = (int[]) dataBlkInt.getData();
        int[] iArr2 = (int[]) dataBlkInt2.getData();
        if (iArr2 == null || iArr2.length < iArr.length) {
            iArr2 = new int[iArr.length];
            dataBlkInt2.setData(iArr2);
        }
        dataBlkInt2.uly = dataBlkInt.uly;
        dataBlkInt2.ulx = dataBlkInt.ulx;
        dataBlkInt2.h = dataBlkInt.h;
        dataBlkInt2.w = dataBlkInt.w;
        dataBlkInt2.offset = dataBlkInt.offset;
        dataBlkInt2.scanw = dataBlkInt.scanw;
        int i = dataBlkInt.offset;
        for (int i2 = 0; i2 < dataBlkInt.h * dataBlkInt.w; i2++) {
            int i3 = iArr[i2];
            if (i3 < 0) {
                i3 = 0;
            } else {
                int i4 = this.dwInputMaxValue;
                if (i3 > i4) {
                    i3 = i4;
                }
            }
            iArr2[i2] = this.lut[i3];
        }
    }

    public void apply(DataBlkFloat dataBlkFloat, DataBlkFloat dataBlkFloat2) throws MonochromeTransformException {
        float[] fArr = (float[]) dataBlkFloat.getData();
        float[] fArr2 = (float[]) dataBlkFloat2.getData();
        if (fArr2 == null || fArr2.length < fArr.length) {
            fArr2 = new float[fArr.length];
            dataBlkFloat2.setData(fArr2);
            dataBlkFloat2.uly = dataBlkFloat.uly;
            dataBlkFloat2.ulx = dataBlkFloat.ulx;
            dataBlkFloat2.h = dataBlkFloat.h;
            dataBlkFloat2.w = dataBlkFloat.w;
            dataBlkFloat2.offset = dataBlkFloat.offset;
            dataBlkFloat2.scanw = dataBlkFloat.scanw;
        }
        int i = dataBlkFloat.offset;
        for (int i2 = 0; i2 < dataBlkFloat.h * dataBlkFloat.w; i2++) {
            int i3 = (int) fArr[i2];
            if (i3 < 0) {
                i3 = 0;
            } else {
                int i4 = this.dwInputMaxValue;
                if (i3 > i4) {
                    i3 = i4;
                }
            }
            fArr2[i2] = this.lut[i3];
        }
    }
}
