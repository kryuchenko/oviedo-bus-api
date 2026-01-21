package jj2000.j2k.codestream;

/* loaded from: classes5.dex */
public abstract class CoordInfo {
    public int h;
    public int ulx;
    public int uly;
    public int w;

    public CoordInfo(int i, int i2, int i3, int i4) {
        this.ulx = i;
        this.uly = i2;
        this.w = i3;
        this.h = i4;
    }

    public CoordInfo() {
    }

    public String toString() {
        return "ulx=" + this.ulx + ",uly=" + this.uly + ",w=" + this.w + ",h=" + this.h;
    }
}
