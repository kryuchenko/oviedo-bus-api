package jj2000.j2k.entropy.encoder;

/* loaded from: classes5.dex */
public class LayersInfo {
    private static final int SZ_INCR = 5;
    private static final int SZ_INIT = 10;
    int nopt;
    float totbrate;
    int totlyrs = 1;
    float[] optbrate = new float[10];
    int[] extralyrs = new int[10];

    public LayersInfo(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Overall target bitrate must be a positive number");
        }
        this.totbrate = f;
    }

    public float getTotBitrate() {
        return this.totbrate;
    }

    public int getTotNumLayers() {
        return this.totlyrs;
    }

    public int getNOptPoints() {
        return this.nopt + 1;
    }

    public float getTargetBitrate(int i) {
        return i < this.nopt ? this.optbrate[i] : this.totbrate;
    }

    public int getExtraLayers(int i) {
        if (i < this.nopt) {
            return this.extralyrs[i];
        }
        return 0;
    }

    public void addOptPoint(float f, int i) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Target bitrate must be positive");
        }
        if (i < 0) {
            throw new IllegalArgumentException("The number of extra layers must be 0 or more");
        }
        int i2 = this.nopt;
        if (i2 > 0 && this.optbrate[i2 - 1] >= f) {
            throw new IllegalArgumentException("New optimization point must have a target bitrate higher than the preceding one");
        }
        float[] fArr = this.optbrate;
        if (fArr.length == i2) {
            int[] iArr = this.extralyrs;
            float[] fArr2 = new float[fArr.length + 5];
            this.optbrate = fArr2;
            this.extralyrs = new int[iArr.length + 5];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(iArr, 0, this.extralyrs, 0, this.nopt);
        }
        float[] fArr3 = this.optbrate;
        int i3 = this.nopt;
        fArr3[i3] = f;
        this.extralyrs[i3] = i;
        this.nopt = i3 + 1;
        this.totlyrs += i + 1;
    }
}
