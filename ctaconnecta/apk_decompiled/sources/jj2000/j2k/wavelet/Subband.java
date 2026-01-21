package jj2000.j2k.wavelet;

import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public abstract class Subband {
    public static final int WT_ORIENT_HH = 3;
    public static final int WT_ORIENT_HL = 1;
    public static final int WT_ORIENT_LH = 2;
    public static final int WT_ORIENT_LL = 0;
    public int anGainExp;
    public int h;
    public boolean isNode;
    public int level;
    public int nomCBlkH;
    public int nomCBlkW;
    public int orientation;
    public int resLvl;
    public int ulcx;
    public int ulcy;
    public int ulx;
    public int uly;
    public int w;
    public Coord numCb = null;
    public int sbandIdx = 0;

    public abstract Subband getHH();

    public abstract Subband getHL();

    public abstract WaveletFilter getHorWFilter();

    public abstract Subband getLH();

    public abstract Subband getLL();

    public abstract Subband getParent();

    public abstract WaveletFilter getVerWFilter();

    protected abstract Subband split(WaveletFilter waveletFilter, WaveletFilter waveletFilter2);

    protected void initChilds() {
        Subband ll = getLL();
        Subband hl = getHL();
        Subband lh = getLH();
        Subband hh = getHH();
        int i = this.level + 1;
        ll.level = i;
        int i2 = (this.ulcx + 1) >> 1;
        ll.ulcx = i2;
        int i3 = (this.ulcy + 1) >> 1;
        ll.ulcy = i3;
        ll.ulx = this.ulx;
        ll.uly = this.uly;
        int i4 = this.ulcx;
        int i5 = (((this.w + i4) + 1) >> 1) - i2;
        ll.w = i5;
        int i6 = (((this.ulcy + this.h) + 1) >> 1) - i3;
        ll.h = i6;
        ll.resLvl = this.orientation == 0 ? this.resLvl - 1 : this.resLvl;
        ll.anGainExp = this.anGainExp;
        ll.sbandIdx = this.sbandIdx << 2;
        hl.orientation = 1;
        hl.level = i;
        int i7 = i4 >> 1;
        hl.ulcx = i7;
        hl.ulcy = i3;
        hl.ulx = this.ulx + i5;
        hl.uly = this.uly;
        hl.w = ((this.ulcx + this.w) >> 1) - i7;
        hl.h = i6;
        hl.resLvl = this.resLvl;
        hl.anGainExp = this.anGainExp + 1;
        hl.sbandIdx = (this.sbandIdx << 2) + 1;
        lh.orientation = 2;
        lh.level = ll.level;
        lh.ulcx = ll.ulcx;
        int i8 = this.ulcy >> 1;
        lh.ulcy = i8;
        lh.ulx = this.ulx;
        int i9 = this.uly + ll.h;
        lh.uly = i9;
        lh.w = ll.w;
        int i10 = ((this.ulcy + this.h) >> 1) - i8;
        lh.h = i10;
        lh.resLvl = this.resLvl;
        lh.anGainExp = this.anGainExp + 1;
        lh.sbandIdx = (this.sbandIdx << 2) + 2;
        hh.orientation = 3;
        hh.level = ll.level;
        hh.ulcx = hl.ulcx;
        hh.ulcy = i8;
        hh.ulx = hl.ulx;
        hh.uly = i9;
        hh.w = hl.w;
        hh.h = i10;
        hh.resLvl = this.resLvl;
        hh.anGainExp = this.anGainExp + 2;
        hh.sbandIdx = (this.sbandIdx << 2) + 3;
    }

    public Subband() {
    }

    public Subband(int i, int i2, int i3, int i4, int i5, WaveletFilter[] waveletFilterArr, WaveletFilter[] waveletFilterArr2) {
        this.w = i;
        this.h = i2;
        this.ulcx = i3;
        this.ulcy = i4;
        this.resLvl = i5;
        Subband subbandSplit = this;
        for (int i6 = 0; i6 < i5; i6++) {
            int length = subbandSplit.resLvl;
            int length2 = length <= waveletFilterArr.length ? length - 1 : waveletFilterArr.length - 1;
            if (length > waveletFilterArr2.length) {
                length = waveletFilterArr2.length;
            }
            subbandSplit = subbandSplit.split(waveletFilterArr[length2], waveletFilterArr2[length - 1]);
        }
    }

    public Subband nextSubband() {
        int i;
        Subband hl;
        if (this.isNode) {
            throw new IllegalArgumentException();
        }
        int i2 = this.orientation;
        if (i2 == 0) {
            Subband parent = getParent();
            if (parent == null || parent.resLvl != this.resLvl) {
                return null;
            }
            return parent.getHL();
        }
        if (i2 == 1) {
            return getParent().getLH();
        }
        if (i2 == 2) {
            return getParent().getHH();
        }
        if (i2 == 3) {
            Subband parent2 = this;
            while (true) {
                i = parent2.orientation;
                if (i != 3) {
                    break;
                }
                parent2 = parent2.getParent();
            }
            if (i == 0) {
                Subband parent3 = parent2.getParent();
                if (parent3 == null || parent3.resLvl != this.resLvl) {
                    return null;
                }
                hl = parent3.getHL();
            } else if (i == 1) {
                hl = parent2.getParent().getLH();
            } else if (i == 2) {
                hl = parent2.getParent().getHH();
            } else {
                throw new Error("You have found a bug in JJ2000");
            }
            while (hl.isNode) {
                hl = hl.getLL();
            }
            return hl;
        }
        throw new Error("You have found a bug in JJ2000");
    }

    public Subband getNextResLevel() {
        if (this.level == 0) {
            return null;
        }
        Subband parent = this;
        do {
            parent = parent.getParent();
            if (parent == null) {
                return null;
            }
        } while (parent.resLvl == this.resLvl);
        Subband hl = parent.getHL();
        while (hl.isNode) {
            hl = hl.getLL();
        }
        return hl;
    }

    public Subband getSubbandByIdx(int i, int i2) {
        int i3 = this.resLvl;
        if (i > i3 || i < 0) {
            throw new IllegalArgumentException("Resolution level index out of range");
        }
        if (i == i3 && i2 == this.sbandIdx) {
            return this;
        }
        Subband parent = this.sbandIdx != 0 ? getParent() : this;
        while (parent.resLvl > i) {
            parent = parent.getLL();
        }
        while (parent.resLvl < i) {
            parent = parent.getParent();
        }
        if (i2 == 1) {
            return parent.getHL();
        }
        if (i2 != 2) {
            return i2 != 3 ? parent : parent.getHH();
        }
        return parent.getLH();
    }

    public Subband getSubband(int i, int i2) {
        int i3;
        int i4 = this.ulx;
        if (i < i4 || i2 < (i3 = this.uly) || i >= i4 + this.w || i2 >= i3 + this.h) {
            throw new IllegalArgumentException();
        }
        Subband ll = this;
        while (ll.isNode) {
            Subband hh = ll.getHH();
            if (i < hh.ulx) {
                if (i2 < hh.uly) {
                    ll = ll.getLL();
                } else {
                    ll = ll.getLH();
                }
            } else if (i2 < hh.uly) {
                ll = ll.getHL();
            } else {
                ll = ll.getHH();
            }
        }
        return ll;
    }

    public String toString() {
        return "w=" + this.w + ",h=" + this.h + ",ulx=" + this.ulx + ",uly=" + this.uly + ",ulcx=" + this.ulcx + ",ulcy=" + this.ulcy + ",idx=" + this.sbandIdx + ",orient=" + this.orientation + ",node=" + this.isNode + ",level=" + this.level + ",resLvl=" + this.resLvl + ",nomCBlkW=" + this.nomCBlkW + ",nomCBlkH=" + this.nomCBlkH + ",numCb=" + this.numCb;
    }
}
