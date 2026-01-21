package jj2000.j2k.entropy.decoder;

import jj2000.j2k.entropy.CodedCBlk;

/* loaded from: classes5.dex */
public class DecLyrdCBlk extends CodedCBlk {
    public int dl;
    public int ftpIdx;
    public int h;
    public int nTrunc;
    public int nl;
    public boolean prog;
    public int[] tsLengths;
    public int ulx;
    public int uly;
    public int w;

    @Override // jj2000.j2k.entropy.CodedCBlk
    public String toString() {
        String str = "Coded code-block (" + this.m + "," + this.n + "): " + this.skipMSBP + " MSB skipped, " + this.dl + " bytes, " + this.nTrunc + " truncation points, " + this.nl + " layers, progressive=" + this.prog + ", ulx=" + this.ulx + ", uly=" + this.uly + ", w=" + this.w + ", h=" + this.h + ", ftpIdx=" + this.ftpIdx;
        if (this.tsLengths == null) {
            return str;
        }
        String str2 = str + " {";
        for (int i = 0; i < this.tsLengths.length; i++) {
            str2 = str2 + " " + this.tsLengths[i];
        }
        return str2 + " }";
    }
}
