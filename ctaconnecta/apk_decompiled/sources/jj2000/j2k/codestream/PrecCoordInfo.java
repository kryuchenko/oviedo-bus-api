package jj2000.j2k.codestream;

/* loaded from: classes5.dex */
public class PrecCoordInfo extends CoordInfo {
    public int xref;
    public int yref;

    public PrecCoordInfo(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4);
        this.xref = i5;
        this.yref = i6;
    }

    public PrecCoordInfo() {
    }

    @Override // jj2000.j2k.codestream.CoordInfo
    public String toString() {
        return super.toString() + ", xref=" + this.xref + ", yref=" + this.yref;
    }
}
