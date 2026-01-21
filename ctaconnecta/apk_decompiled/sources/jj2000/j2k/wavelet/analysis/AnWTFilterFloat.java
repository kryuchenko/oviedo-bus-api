package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public abstract class AnWTFilterFloat extends AnWTFilter {
    public abstract void analyze_hpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, float[] fArr3, int i6, int i7);

    public abstract void analyze_lpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, float[] fArr3, int i6, int i7);

    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getDataType() {
        return 4;
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public void analyze_lpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, Object obj3, int i6, int i7) {
        analyze_lpf((float[]) obj, i, i2, i3, (float[]) obj2, i4, i5, (float[]) obj3, i6, i7);
    }

    @Override // jj2000.j2k.wavelet.analysis.AnWTFilter
    public void analyze_hpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, Object obj3, int i6, int i7) {
        analyze_hpf((float[]) obj, i, i2, i3, (float[]) obj2, i4, i5, (float[]) obj3, i6, i7);
    }
}
