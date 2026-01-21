package jj2000.j2k.codestream;

import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public class CBlkCoordInfo extends CoordInfo {
    public Coord idx;

    public CBlkCoordInfo() {
        this.idx = new Coord();
    }

    public CBlkCoordInfo(int i, int i2) {
        this.idx = new Coord(i2, i);
    }

    @Override // jj2000.j2k.codestream.CoordInfo
    public String toString() {
        return super.toString() + ",idx=" + this.idx;
    }
}
