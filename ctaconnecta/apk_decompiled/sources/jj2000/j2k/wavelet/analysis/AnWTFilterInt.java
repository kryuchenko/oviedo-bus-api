package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public abstract class AnWTFilterInt extends AnWTFilter {
    public abstract void analyze_hpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int[] iArr3, int i6, int i7);

    public abstract void analyze_lpf(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int[] iArr3, int i6, int i7);

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getDataType() {
        return 3;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public void analyze_lpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, Object obj3, int i6, int i7) {
        analyze_lpf((int[]) obj, i, i2, i3, (int[]) obj2, i4, i5, (int[]) obj3, i6, i7);
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public void analyze_hpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, Object obj3, int i6, int i7) {
        analyze_hpf((int[]) obj, i, i2, i3, (int[]) obj2, i4, i5, (int[]) obj3, i6, i7);
    }
}
