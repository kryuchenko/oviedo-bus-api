package icc.lut;

/* loaded from: classes5.dex */
public class LookUpTable16LinearSRGBtoSRGB extends LookUpTable16 {
    public static LookUpTable16LinearSRGBtoSRGB createInstance(int i, double d, int i2, double d2, double d3, double d4) {
        return new LookUpTable16LinearSRGBtoSRGB(i, d, i2, d2, d3, d4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected LookUpTable16LinearSRGBtoSRGB(int i, double d, int i2, double d2, double d3, double d4) {
        super(i2 + 1, 0);
        int i3 = 0;
        double d5 = 1.0d / i2;
        while (i3 <= i) {
            this.lut[i3] = (byte) Math.floor((i3 * d) + 0.5d);
            i3++;
        }
        while (i3 <= i2) {
            this.lut[i3] = (byte) Math.floor(((Math.pow(i3 * d5, d3) * d2) - d4) + 0.5d);
            i3++;
        }
    }
}
