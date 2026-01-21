package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public class AnWTFilterFloatLift9x7 extends AnWTFilterFloat {
    public static final float ALPHA = -1.5861343f;
    public static final float BETA = -0.052980117f;
    public static final float DELTA = 0.44350687f;
    public static final float GAMMA = 0.8829111f;
    public static final float KH = 1.2301741f;
    public static final float KL = 0.8128931f;
    private static final float[] LPSynthesisFilter = {-0.091272f, -0.057544f, 0.591272f, 1.115087f, 0.591272f, -0.057544f, -0.091272f};
    private static final float[] HPSynthesisFilter = {0.026749f, 0.016864f, -0.078223f, -0.266864f, 0.602949f, -0.266864f, -0.078223f, 0.016864f, 0.026749f};

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnHighNegSupport() {
        return 3;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnHighPosSupport() {
        return 3;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnLowNegSupport() {
        return 4;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnLowPosSupport() {
        return 4;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public int getFilterType() {
        return 0;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getImplType() {
        return 1;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynHighNegSupport() {
        return 4;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynHighPosSupport() {
        return 4;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynLowNegSupport() {
        return 3;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynLowPosSupport() {
        return 3;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public boolean isReversible() {
        return false;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilterFloat
    public void analyze_lpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, float[] fArr3, int i6, int i7) {
        int i8 = i3 * 2;
        int i9 = i + i3;
        int i10 = i2 - 1;
        int i11 = i6;
        for (int i12 = 1; i12 < i10; i12 += 2) {
            fArr3[i11] = fArr[i9] + ((fArr[i9 - i3] + fArr[i9 + i3]) * (-1.5861343f));
            i9 += i8;
            i11 += i7;
        }
        int i13 = i2 % 2;
        if (i13 == 0) {
            fArr3[i11] = fArr[i9] + (fArr[i9 - i3] * (-3.1722686f));
        }
        if (i2 > 1) {
            fArr2[i4] = fArr[i] + (fArr3[i6] * (-0.105960235f));
        } else {
            fArr2[i4] = fArr[i];
        }
        int i14 = i + i8;
        int i15 = i4 + i5;
        int i16 = i6 + i7;
        int i17 = i15;
        int i18 = i16;
        for (int i19 = 2; i19 < i10; i19 += 2) {
            fArr2[i17] = fArr[i14] + ((fArr3[i18 - i7] + fArr3[i18]) * (-0.052980117f));
            i14 += i8;
            i17 += i5;
            i18 += i7;
        }
        if (i13 == 1 && i2 > 2) {
            fArr2[i17] = fArr[i14] + (fArr3[i18 - i7] * (-0.105960235f));
        }
        int i20 = i4;
        int i21 = i6;
        for (int i22 = 1; i22 < i10; i22 += 2) {
            float f = fArr3[i21];
            float f2 = fArr2[i20];
            i20 += i5;
            fArr3[i21] = f + ((f2 + fArr2[i20]) * 0.8829111f);
            i21 += i7;
        }
        if (i13 == 0) {
            fArr3[i21] = fArr3[i21] + (fArr2[i20] * 1.7658222f);
        }
        if (i2 > 1) {
            fArr2[i4] = fArr2[i4] + (fArr3[i6] * 0.88701373f);
        }
        for (int i23 = 2; i23 < i10; i23 += 2) {
            fArr2[i15] = fArr2[i15] + ((fArr3[i16 - i7] + fArr3[i16]) * 0.44350687f);
            i15 += i5;
            i16 += i7;
        }
        if (i13 == 1 && i2 > 2) {
            fArr2[i15] = fArr2[i15] + (fArr3[i16 - i7] * 0.88701373f);
        }
        int i24 = i4;
        int i25 = i6;
        for (int i26 = 0; i26 < (i2 >> 1); i26++) {
            fArr2[i24] = fArr2[i24] * 0.8128931f;
            fArr3[i25] = fArr3[i25] * 1.2301741f;
            i24 += i5;
            i25 += i7;
        }
        if (i13 != 1 || i2 == 1) {
            return;
        }
        fArr2[i24] = fArr2[i24] * 0.8128931f;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilterFloat
    public void analyze_hpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, float[] fArr3, int i6, int i7) {
        int i8;
        int i9 = i3 * 2;
        if (i2 > 1) {
            fArr3[i6] = fArr[i] + (fArr[i + i3] * (-3.1722686f));
        } else {
            fArr3[i6] = fArr[i] * 2.0f;
        }
        int i10 = i + i9;
        int i11 = i6 + i7;
        int i12 = i11;
        int i13 = 2;
        while (true) {
            i8 = i2 - 1;
            if (i13 >= i8) {
                break;
            }
            fArr3[i12] = fArr[i10] + ((fArr[i10 - i3] + fArr[i10 + i3]) * (-1.5861343f));
            i10 += i9;
            i12 += i7;
            i13 += 2;
        }
        int i14 = i2 % 2;
        if (i14 == 1 && i2 > 1) {
            fArr3[i12] = fArr[i10] + (fArr[i10 - i3] * (-3.1722686f));
        }
        int i15 = i + i3;
        int i16 = i4;
        int i17 = i6;
        for (int i18 = 1; i18 < i8; i18 += 2) {
            float f = fArr[i15];
            float f2 = fArr3[i17];
            i17 += i7;
            fArr2[i16] = f + ((f2 + fArr3[i17]) * (-0.052980117f));
            i15 += i9;
            i16 += i5;
        }
        if (i2 > 1 && i14 == 0) {
            fArr2[i16] = fArr[i15] + (fArr3[i17] * (-0.105960235f));
        }
        if (i2 > 1) {
            fArr3[i6] = fArr3[i6] + (fArr2[i4] * 1.7658222f);
        }
        int i19 = i4;
        for (int i20 = 2; i20 < i8; i20 += 2) {
            float f3 = fArr3[i11];
            float f4 = fArr2[i19];
            i19 += i5;
            fArr3[i11] = f3 + ((f4 + fArr2[i19]) * 0.8829111f);
            i11 += i7;
        }
        if (i2 > 1 && i14 == 1) {
            fArr3[i11] = fArr3[i11] + (fArr2[i19] * 1.7658222f);
        }
        int i21 = i4;
        int i22 = i6;
        for (int i23 = 1; i23 < i8; i23 += 2) {
            float f5 = fArr2[i21];
            float f6 = fArr3[i22];
            i22 += i7;
            fArr2[i21] = f5 + ((f6 + fArr3[i22]) * 0.44350687f);
            i21 += i5;
        }
        if (i2 > 1 && i14 == 0) {
            fArr2[i21] = fArr2[i21] + (fArr3[i22] * 0.88701373f);
        }
        int i24 = i4;
        int i25 = i6;
        for (int i26 = 0; i26 < (i2 >> 1); i26++) {
            fArr2[i24] = fArr2[i24] * 0.8128931f;
            fArr3[i25] = fArr3[i25] * 1.2301741f;
            i24 += i5;
            i25 += i7;
        }
        if (i14 != 1 || i2 == 1) {
            return;
        }
        fArr3[i25] = fArr3[i25] * 1.2301741f;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public float[] getLPSynthesisFilter() {
        return LPSynthesisFilter;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public float[] getHPSynthesisFilter() {
        return HPSynthesisFilter;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public boolean isSameAsFullWT(int i, int i2, int i3) {
        return i3 % 2 == 0 ? i >= 4 && i2 >= 3 : i >= 4 && i2 >= 4;
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof AnWTFilterFloatLift9x7);
    }

    public String toString() {
        return "w9x7";
    }
}
