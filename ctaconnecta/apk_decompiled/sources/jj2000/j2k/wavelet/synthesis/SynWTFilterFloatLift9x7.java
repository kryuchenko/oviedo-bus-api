package jj2000.j2k.wavelet.synthesis;

/* loaded from: classes5.dex */
public class SynWTFilterFloatLift9x7 extends SynWTFilterFloat {
    public static final float ALPHA = -1.5861343f;
    public static final float BETA = -0.052980117f;
    public static final float DELTA = 0.44350687f;
    public static final float GAMMA = 0.8829111f;
    public static final float KH = 1.2301741f;
    public static final float KL = 0.8128931f;

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

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilterFloat
    public void synthetize_lpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8) {
        int i9;
        int i10 = i2 + i5;
        int i11 = i8 * 2;
        int i12 = 1;
        if (i10 > 1) {
            fArr3[i7] = (fArr[i] / 0.8128931f) - ((fArr2[i4] * 0.88701373f) / 1.2301741f);
        } else {
            fArr3[i7] = fArr[i];
        }
        int i13 = i + i3;
        int i14 = i4 + i6;
        int i15 = i7 + i11;
        int i16 = i15;
        int i17 = 2;
        while (true) {
            i9 = i10 - 1;
            if (i17 >= i9) {
                break;
            }
            fArr3[i16] = (fArr[i13] / 0.8128931f) - (((fArr2[i14 - i6] + fArr2[i14]) * 0.44350687f) / 1.2301741f);
            i17 += 2;
            i16 += i11;
            i13 += i3;
            i14 += i6;
        }
        int i18 = i10 % 2;
        if (i18 == 1 && i10 > 2) {
            fArr3[i16] = (fArr[i13] / 0.8128931f) - ((fArr2[i14 - i6] * 0.88701373f) / 1.2301741f);
        }
        int i19 = i7 + i8;
        int i20 = i4;
        int i21 = i19;
        int i22 = 1;
        while (i22 < i9) {
            fArr3[i21] = (fArr2[i20] / 1.2301741f) - ((fArr3[i21 - i8] + fArr3[i21 + i8]) * 0.8829111f);
            i22 += 2;
            i21 += i11;
            i20 += i6;
        }
        if (i18 == 0) {
            fArr3[i21] = (fArr2[i20] / 1.2301741f) - (fArr3[i21 - i8] * 1.7658222f);
        }
        if (i10 > 1) {
            fArr3[i7] = fArr3[i7] - (fArr3[i19] * (-0.105960235f));
        }
        int i23 = 2;
        while (i23 < i9) {
            fArr3[i15] = fArr3[i15] - ((fArr3[i15 - i8] + fArr3[i15 + i8]) * (-0.052980117f));
            i23 += 2;
            i15 += i11;
        }
        if (i18 == 1 && i10 > 2) {
            fArr3[i15] = fArr3[i15] - (fArr3[i15 - i8] * (-0.105960235f));
        }
        while (i12 < i9) {
            fArr3[i19] = fArr3[i19] - ((fArr3[i19 - i8] + fArr3[i19 + i8]) * (-1.5861343f));
            i12 += 2;
            i19 += i11;
        }
        if (i18 == 0) {
            fArr3[i19] = fArr3[i19] - (fArr3[i19 - i8] * (-3.1722686f));
        }
    }

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilterFloat
    public void synthetize_hpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8) {
        int i9;
        int i10 = i2 + i5;
        int i11 = i8 * 2;
        if (i10 != 1) {
            int i12 = i10 >> 1;
            int i13 = i;
            int i14 = i4;
            for (int i15 = 0; i15 < i12; i15++) {
                fArr[i13] = fArr[i13] / 0.8128931f;
                fArr2[i14] = fArr2[i14] / 1.2301741f;
                i13 += i3;
                i14 += i6;
            }
            if (i10 % 2 == 1) {
                fArr2[i14] = fArr2[i14] / 1.2301741f;
            }
        } else {
            fArr2[i4] = fArr2[i4] / 2.0f;
        }
        int i16 = i7 + i8;
        int i17 = i;
        int i18 = i4;
        int i19 = i16;
        int i20 = 1;
        while (true) {
            i9 = i10 - 1;
            if (i20 >= i9) {
                break;
            }
            float f = fArr[i17];
            float f2 = fArr2[i18];
            i18 += i6;
            fArr3[i19] = f - ((f2 + fArr2[i18]) * 0.44350687f);
            i19 += i11;
            i17 += i3;
            i20 += 2;
        }
        int i21 = i10 % 2;
        if (i21 == 0 && i10 > 1) {
            fArr3[i19] = fArr[i17] - (fArr2[i18] * 0.88701373f);
        }
        if (i10 > 1) {
            fArr3[i7] = fArr2[i4] - (fArr3[i16] * 1.7658222f);
        } else {
            fArr3[i7] = fArr2[i4];
        }
        int i22 = i7 + i11;
        int i23 = i4 + i6;
        int i24 = i22;
        for (int i25 = 2; i25 < i9; i25 += 2) {
            fArr3[i24] = fArr2[i23] - ((fArr3[i24 - i8] + fArr3[i24 + i8]) * 0.8829111f);
            i24 += i11;
            i23 += i6;
        }
        if (i21 == 1 && i10 > 1) {
            fArr3[i24] = fArr2[i23] - (fArr3[i24 - i8] * 1.7658222f);
        }
        int i26 = i16;
        for (int i27 = 1; i27 < i9; i27 += 2) {
            fArr3[i26] = fArr3[i26] - ((fArr3[i26 - i8] + fArr3[i26 + i8]) * (-0.052980117f));
            i26 += i11;
        }
        if (i21 == 0 && i10 > 1) {
            fArr3[i26] = fArr3[i26] - (fArr3[i26 - i8] * (-0.105960235f));
        }
        if (i10 > 1) {
            fArr3[i7] = fArr3[i7] - (fArr3[i16] * (-3.1722686f));
        }
        for (int i28 = 2; i28 < i9; i28 += 2) {
            fArr3[i22] = fArr3[i22] - ((fArr3[i22 - i8] + fArr3[i22 + i8]) * (-1.5861343f));
            i22 += i11;
        }
        if (i21 != 1 || i10 <= 1) {
            return;
        }
        fArr3[i22] = fArr3[i22] - (fArr3[i22 - i8] * (-3.1722686f));
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public boolean isSameAsFullWT(int i, int i2, int i3) {
        return i3 % 2 == 0 ? i >= 2 && i2 >= 1 : i >= 2 && i2 >= 2;
    }

    public String toString() {
        return "w9x7 (lifting)";
    }
}
