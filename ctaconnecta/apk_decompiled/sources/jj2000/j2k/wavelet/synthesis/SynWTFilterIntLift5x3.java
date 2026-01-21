package jj2000.j2k.wavelet.synthesis;

/* loaded from: classes5.dex */
public class SynWTFilterIntLift5x3 extends SynWTFilterInt {
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

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilterInt
    public void synthetize_lpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8) {
        int i9;
        int i10 = i2 + i5;
        int i11 = i8 * 2;
        if (i10 > 1) {
            iArr3[i7] = iArr[i] - ((iArr2[i4] + 1) >> 1);
        } else {
            iArr3[i7] = iArr[i];
        }
        int i12 = i + i3;
        int i13 = i4 + i6;
        int i14 = i7 + i11;
        int i15 = 2;
        while (true) {
            i9 = i10 - 1;
            if (i15 >= i9) {
                break;
            }
            iArr3[i14] = iArr[i12] - (((iArr2[i13 - i6] + iArr2[i13]) + 2) >> 2);
            i12 += i3;
            i13 += i6;
            i14 += i11;
            i15 += 2;
        }
        int i16 = i10 % 2;
        if (i16 == 1 && i10 > 2) {
            iArr3[i14] = iArr[i12] - (((iArr2[i13 - i6] * 2) + 2) >> 2);
        }
        int i17 = i7 + i8;
        int i18 = i4;
        for (int i19 = 1; i19 < i9; i19 += 2) {
            iArr3[i17] = iArr2[i18] + ((iArr3[i17 - i8] + iArr3[i17 + i8]) >> 1);
            i18 += i6;
            i17 += i11;
        }
        if (i16 != 0 || i10 <= 1) {
            return;
        }
        iArr3[i17] = iArr2[i18] + iArr3[i17 - i8];
    }

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilterInt
    public void synthetize_hpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8) {
        int i9;
        int i10;
        int i11 = i2 + i5;
        int i12 = i8 * 2;
        int i13 = i7 + i8;
        int i14 = i4;
        int i15 = i13;
        int i16 = 1;
        while (true) {
            i9 = i11 - 1;
            if (i16 >= i9) {
                break;
            }
            int i17 = iArr[i];
            int i18 = iArr2[i14];
            i14 += i6;
            iArr3[i15] = i17 - (((i18 + iArr2[i14]) + 2) >> 2);
            i += i3;
            i15 += i12;
            i16 += 2;
        }
        if (i11 > 1 && i11 % 2 == 0) {
            iArr3[i15] = iArr[i] - (((iArr2[i14] * 2) + 2) >> 2);
        }
        if (i11 > 1) {
            iArr3[i7] = iArr2[i4] + iArr3[i13];
        } else {
            iArr3[i7] = iArr2[i4] >> 1;
        }
        int i19 = i4 + i6;
        int i20 = i7 + i12;
        for (i10 = 2; i10 < i9; i10 += 2) {
            iArr3[i20] = iArr2[i19] + ((iArr3[i20 - i8] + iArr3[i20 + i8]) >> 1);
            i19 += i6;
            i20 += i12;
        }
        if (i11 % 2 != 1 || i11 <= 1) {
            return;
        }
        iArr3[i20] = iArr2[i19] + iArr3[i20 - i8];
    }

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public boolean isSameAsFullWT(int i, int i2, int i3) {
        return i3 % 2 == 0 ? i >= 2 && i2 >= 1 : i >= 2 && i2 >= 2;
    }

    public String toString() {
        return "w5x3 (lifting)";
    }
}
