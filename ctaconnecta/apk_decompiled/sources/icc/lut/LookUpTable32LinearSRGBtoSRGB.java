package icc.lut;

/* loaded from: classes5.dex */
public class LookUpTable32LinearSRGBtoSRGB extends LookUpTable32 {
    @Override // icc.lut.LookUpTable32
    public /* bridge */ /* synthetic */ String toStringWholeLut() {
        return super.toStringWholeLut();
    }

    public static LookUpTable32LinearSRGBtoSRGB createInstance(int i, int i2, double d, double d2, double d3, double d4, double d5) {
        return new LookUpTable32LinearSRGBtoSRGB(i, i2, d, d2, d3, d4, d5);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [icc.lut.LookUpTable32, icc.lut.LookUpTable32LinearSRGBtoSRGB] */
    protected LookUpTable32LinearSRGBtoSRGB(int i, int i2, double d, double d2, double d3, double d4, double d5) {
        double d6;
        int i3 = i;
        ?? lookUpTable32 = new LookUpTable32(i3 + 1, i2);
        double d7 = i3;
        double d8 = 1.0d / d7;
        int iFloor = (int) Math.floor(d7 * d);
        double d9 = i2;
        double d10 = d2 * d9;
        int i4 = (i2 + 1) / 2;
        int i5 = 0;
        while (true) {
            d6 = 0.5d;
            if (i5 > iFloor) {
                break;
            }
            lookUpTable32.lut[i5] = (int) (Math.floor(((i5 * d8) * d10) + 0.5d) - i4);
            i5++;
        }
        double d11 = d3 * d9;
        double d12 = d9 * d5;
        LookUpTable32LinearSRGBtoSRGB lookUpTable32LinearSRGBtoSRGB = lookUpTable32;
        while (i5 <= i3) {
            double d13 = d6;
            lookUpTable32LinearSRGBtoSRGB.lut[i5] = (int) (Math.floor(((Math.pow(i5 * d8, d4) * d11) - d12) + d13) - i4);
            i5++;
            lookUpTable32LinearSRGBtoSRGB = this;
            i3 = i;
            d6 = d13;
        }
    }

    @Override // icc.lut.LookUpTable32
    public String toString() {
        return "[LookUpTable32LinearSRGBtoSRGB:]";
    }
}
