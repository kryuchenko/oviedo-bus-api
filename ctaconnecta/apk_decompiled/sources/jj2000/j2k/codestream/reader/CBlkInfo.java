package jj2000.j2k.codestream.reader;

/* loaded from: classes5.dex */
public class CBlkInfo {
    public int ctp;
    public int h;
    public int[] len;
    public int msbSkipped;
    public int[] ntp;
    public int[] off;
    public int[] pktIdx;
    public int[][] segLen;
    public int ulx;
    public int uly;
    public int w;

    public CBlkInfo(int i, int i2, int i3, int i4, int i5) {
        this.ulx = i;
        this.uly = i2;
        this.w = i3;
        this.h = i4;
        this.off = new int[i5];
        this.len = new int[i5];
        this.ntp = new int[i5];
        this.segLen = new int[i5][];
        this.pktIdx = new int[i5];
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            this.pktIdx[i6] = -1;
        }
    }

    public void addNTP(int i, int i2) {
        this.ntp[i] = i2;
        this.ctp = 0;
        for (int i3 = 0; i3 <= i; i3++) {
            this.ctp += this.ntp[i3];
        }
    }

    public String toString() {
        String str = ("(ulx,uly,w,h)= (" + this.ulx + "," + this.uly + "," + this.w + "," + this.h) + ") " + this.msbSkipped + " MSB bit(s) skipped\n";
        if (this.len != null) {
            for (int i = 0; i < this.len.length; i++) {
                String str2 = str + "\tl:" + i + ", start:" + this.off[i] + ", len:" + this.len[i] + ", ntp:" + this.ntp[i] + ", pktIdx=" + this.pktIdx[i];
                int[][] iArr = this.segLen;
                if (iArr != null && iArr[i] != null) {
                    String str3 = str2 + " { ";
                    for (int i2 = 0; i2 < this.segLen[i].length; i2++) {
                        str3 = str3 + this.segLen[i][i2] + " ";
                    }
                    str2 = str3 + "}";
                }
                str = str2 + "\n";
            }
        }
        return str + "\tctp=" + this.ctp;
    }
}
