package jj2000.j2k.roi.encoder;

/* loaded from: classes5.dex */
public abstract class SubbandROIMask {
    public int h;
    protected SubbandROIMask hh;
    protected SubbandROIMask hl;
    protected boolean isNode;
    protected SubbandROIMask lh;
    protected SubbandROIMask ll;
    public int ulx;
    public int uly;
    public int w;

    public SubbandROIMask(int i, int i2, int i3, int i4) {
        this.ulx = i;
        this.uly = i2;
        this.w = i3;
        this.h = i4;
    }

    public SubbandROIMask getSubbandRectROIMask(int i, int i2) {
        int i3;
        int i4 = this.ulx;
        if (i < i4 || i2 < (i3 = this.uly) || i >= i4 + this.w || i2 >= i3 + this.h) {
            throw new IllegalArgumentException();
        }
        SubbandROIMask subbandROIMask = this;
        while (subbandROIMask.isNode) {
            SubbandROIMask subbandROIMask2 = subbandROIMask.hh;
            if (i < subbandROIMask2.ulx) {
                if (i2 < subbandROIMask2.uly) {
                    subbandROIMask = subbandROIMask.ll;
                } else {
                    subbandROIMask = subbandROIMask.lh;
                }
            } else {
                subbandROIMask = i2 < subbandROIMask2.uly ? subbandROIMask.hl : subbandROIMask2;
            }
        }
        return subbandROIMask;
    }
}
