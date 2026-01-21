package jj2000.j2k.entropy;

/* loaded from: classes5.dex */
public class CodedCBlk {
    public byte[] data;
    public int m;
    public int n;
    public int skipMSBP;

    public CodedCBlk() {
    }

    public CodedCBlk(int i, int i2, int i3, byte[] bArr) {
        this.m = i;
        this.n = i2;
        this.skipMSBP = i3;
        this.data = bArr;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("m=");
        sb.append(this.m);
        sb.append(", n=");
        sb.append(this.n);
        sb.append(", skipMSBP=");
        sb.append(this.skipMSBP);
        sb.append(", data.length=");
        if (this.data != null) {
            str = "" + this.data.length;
        } else {
            str = "(null)";
        }
        sb.append(str);
        return sb.toString();
    }
}
