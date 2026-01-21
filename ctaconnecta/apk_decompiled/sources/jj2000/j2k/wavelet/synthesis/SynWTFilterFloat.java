package jj2000.j2k.wavelet.synthesis;

/* loaded from: classes5.dex */
public abstract class SynWTFilterFloat extends SynWTFilter {
    @Override // jj2000.j2k.wavelet.WaveletFilter
    public int getDataType() {
        return 4;
    }

    public abstract void synthetize_hpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8);

    public abstract void synthetize_lpf(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8);

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilter
    public void synthetize_lpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        synthetize_lpf((float[]) obj, i, i2, i3, (float[]) obj2, i4, i5, i6, (float[]) obj3, i7, i8);
    }

    @Override // jj2000.j2k.wavelet.synthesis.SynWTFilter
    public void synthetize_hpf(Object obj, int i, int i2, int i3, Object obj2, int i4, int i5, int i6, Object obj3, int i7, int i8) {
        synthetize_hpf((float[]) obj, i, i2, i3, (float[]) obj2, i4, i5, i6, (float[]) obj3, i7, i8);
    }
}
