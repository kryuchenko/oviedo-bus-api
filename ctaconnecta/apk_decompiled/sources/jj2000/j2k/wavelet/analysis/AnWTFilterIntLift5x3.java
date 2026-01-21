package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public class AnWTFilterIntLift5x3 extends AnWTFilterInt {
    private static final float[] LPSynthesisFilter = {0.5f, 1.0f, 0.5f};
    private static final float[] HPSynthesisFilter = {-0.125f, -0.25f, 0.75f, -0.25f, -0.125f};

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnHighNegSupport() {
        return 1;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnHighPosSupport() {
        return 1;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnLowNegSupport() {
        return 2;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getAnLowPosSupport() {
        return 2;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public int getFilterType() {
        return 1;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getImplType() {
        return 0;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynHighNegSupport() {
        return 2;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynHighPosSupport() {
        return 2;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynLowNegSupport() {
        return 1;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getSynLowPosSupport() {
        return 1;
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public boolean isReversible() {
        return true;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilterInt
    public void analyze_lpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int[] iArr3, int i6, int i7) {
        int i8;
        int i9 = i3 * 2;
        int i10 = i + i3;
        int i11 = i6;
        int i12 = 1;
        while (true) {
            i8 = i2 - 1;
            if (i12 >= i8) {
                break;
            }
            iArr3[i11] = iArr[i10] - ((iArr[i10 - i3] + iArr[i10 + i3]) >> 1);
            i10 += i9;
            i11 += i7;
            i12 += 2;
        }
        int i13 = i2 % 2;
        if (i13 == 0) {
            iArr3[i11] = iArr[i10] - ((iArr[i10 - i3] * 2) >> 1);
        }
        if (i2 > 1) {
            iArr2[i4] = iArr[i] + ((iArr3[i6] + 1) >> 1);
        } else {
            iArr2[i4] = iArr[i];
        }
        int i14 = i + i9;
        int i15 = i4 + i5;
        int i16 = i6 + i7;
        for (int i17 = 2; i17 < i8; i17 += 2) {
            iArr2[i15] = iArr[i14] + (((iArr3[i16 - i7] + iArr3[i16]) + 2) >> 2);
            i14 += i9;
            i15 += i5;
            i16 += i7;
        }
        if (i13 != 1 || i2 <= 2) {
            return;
        }
        iArr2[i15] = iArr[i14] + (((iArr3[i16 - i7] * 2) + 2) >> 2);
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilterInt
    public void analyze_hpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int[] iArr3, int i6, int i7) {
        int i8 = i3 * 2;
        if (i2 > 1) {
            iArr3[i6] = iArr[i] - iArr[i + i3];
        } else {
            iArr3[i6] = iArr[i] << 1;
        }
        int i9 = i + i8;
        int i10 = i6 + i7;
        if (i2 > 3) {
            for (int i11 = 2; i11 < i2 - 1; i11 += 2) {
                iArr3[i10] = iArr[i9] - ((iArr[i9 - i3] + iArr[i9 + i3]) >> 1);
                i9 += i8;
                i10 += i7;
            }
        }
        int i12 = i2 % 2;
        if (i12 == 1 && i2 > 1) {
            iArr3[i10] = iArr[i9] - iArr[i9 - i3];
        }
        int i13 = i + i3;
        int i14 = i4;
        int i15 = i6;
        for (int i16 = 1; i16 < i2 - 1; i16 += 2) {
            int i17 = iArr[i13];
            int i18 = iArr3[i15];
            i15 += i7;
            iArr2[i14] = i17 + (((i18 + iArr3[i15]) + 2) >> 2);
            i13 += i8;
            i14 += i5;
        }
        if (i2 <= 1 || i12 != 0) {
            return;
        }
        iArr2[i14] = iArr[i13] + (((iArr3[i15] * 2) + 2) >> 2);
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
        return i3 % 2 == 0 ? i >= 2 && i2 >= 1 : i >= 2 && i2 >= 2;
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof AnWTFilterIntLift5x3);
    }

    public String toString() {
        return "w5x3";
    }
}
