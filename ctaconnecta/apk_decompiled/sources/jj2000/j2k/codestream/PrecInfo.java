package jj2000.j2k.codestream;

/* loaded from: classes5.dex */
public class PrecInfo {
    public CBlkCoordInfo[][][] cblk;
    public int h;
    public int[] nblk;
    public int r;
    public int rgh;
    public int rgulx;
    public int rguly;
    public int rgw;
    public int ulx;
    public int uly;
    public int w;

    public PrecInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.r = i;
        this.ulx = i2;
        this.uly = i3;
        this.w = i4;
        this.h = i5;
        this.rgulx = i6;
        this.rguly = i7;
        this.rgw = i8;
        this.rgh = i9;
        if (i == 0) {
            this.cblk = new CBlkCoordInfo[1][][];
            this.nblk = new int[1];
        } else {
            this.cblk = new CBlkCoordInfo[4][][];
            this.nblk = new int[4];
        }
    }

    public String toString() {
        return "ulx=" + this.ulx + ",uly=" + this.uly + ",w=" + this.w + ",h=" + this.h + ",rgulx=" + this.rgulx + ",rguly=" + this.rguly + ",rgw=" + this.rgw + ",rgh=" + this.rgh;
    }
}
