package jj2000.j2k.wavelet.analysis;

import jj2000.j2k.wavelet.WaveletFilter;

/* loaded from: classes5.dex */
public abstract class AnWTFilter implements WaveletFilter {
    public static final char OPT_PREFIX = 'F';
    private static final String[][] pinfo = {new String[]{"Ffilters", "[<tile-component idx>] <id> [ [<tile-component idx>] <id> ...]", "Specifies which filters to use for specified tile-component. If this option is not used, the encoder choses the filters  of the tile-components according to their quantization  type. If this option is used, a component transformation is applied to the three first components.\n<tile-component idx>: see general note\n<id>: ',' separates horizontal and vertical filters, ':' separates decomposition levels filters. JPEG 2000 part 1 only supports w5x3 and w9x7 filters.", null}};

    public abstract void analyze_hpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, Object obj3, int i6, int i7);

    public abstract void analyze_lpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, Object obj3, int i6, int i7);

    public abstract int getFilterType();

    public abstract float[] getHPSynthesisFilter();

    public abstract float[] getLPSynthesisFilter();

    public float[] getLPSynWaveForm(float[] fArr, float[] fArr2) {
        return upsampleAndConvolve(fArr, getLPSynthesisFilter(), fArr2);
    }

    public float[] getHPSynWaveForm(float[] fArr, float[] fArr2) {
        return upsampleAndConvolve(fArr, getHPSynthesisFilter(), fArr2);
    }

    private static float[] upsampleAndConvolve(float[] fArr, float[] fArr2, float[] fArr3) {
        if (fArr == null) {
            fArr = new float[]{1.0f};
        }
        if (fArr3 == null) {
            fArr3 = new float[((fArr.length * 2) + fArr2.length) - 2];
        }
        int length = ((fArr.length * 2) + fArr2.length) - 2;
        for (int i = 0; i < length; i++) {
            int length2 = ((i - fArr2.length) + 2) / 2;
            if (length2 < 0) {
                length2 = 0;
            }
            int length3 = (i / 2) + 1;
            if (length3 > fArr.length) {
                length3 = fArr.length;
            }
            int length4 = (((length2 * 2) - i) + fArr2.length) - 1;
            float f = 0.0f;
            while (length2 < length3) {
                f += fArr[length2] * fArr2[length4];
                length2++;
                length4 += 2;
            }
            fArr3[i] = f;
        }
        return fArr3;
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }
}
