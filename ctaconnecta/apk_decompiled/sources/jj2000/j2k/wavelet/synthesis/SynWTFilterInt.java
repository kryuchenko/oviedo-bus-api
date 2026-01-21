package jj2000.j2k.wavelet.synthesis;

/* loaded from: classes5.dex */
public abstract class SynWTFilterInt extends SynWTFilter {
    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getDataType() {
        return 3;
    }

    public abstract void synthetize_hpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8);

    public abstract void synthetize_lpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8);

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilter
    public void synthetize_lpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        synthetize_lpf((int[]) obj, i, i2, i3, (int[]) obj2, i4, i5, i6, (int[]) obj3, i7, i8);
    }

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilter
    public void synthetize_hpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        synthetize_hpf((int[]) obj, i, i2, i3, (int[]) obj2, i4, i5, i6, (int[]) obj3, i7, i8);
    }
}
