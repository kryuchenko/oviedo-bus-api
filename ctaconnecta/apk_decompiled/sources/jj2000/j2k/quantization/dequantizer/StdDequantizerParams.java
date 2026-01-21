package jj2000.j2k.quantization.dequantizer;

/* loaded from: classes5.dex */
public class StdDequantizerParams extends DequantizerParams {
    public int[][] exp;
    public float[][] nStep;

    @Override // jj2000.j2k.quantization.dequantizer.DequantizerParams
    public int getDequantizerType() {
        return 0;
    }
}
