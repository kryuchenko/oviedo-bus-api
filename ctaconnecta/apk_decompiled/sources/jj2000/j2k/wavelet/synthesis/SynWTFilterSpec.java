package jj2000.j2k.wavelet.synthesis;

import jj2000.j2k.ModuleSpec;

/* loaded from: classes5.dex */
public class SynWTFilterSpec extends ModuleSpec {
    public SynWTFilterSpec(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public int getWTDataType(int i, int i2) {
        return ((SynWTFilter[][]) getSpec(i, i2))[0][0].getDataType();
    }

    public SynWTFilter[] getHFilters(int i, int i2) {
        return ((SynWTFilter[][]) getSpec(i, i2))[0];
    }

    public SynWTFilter[] getVFilters(int i, int i2) {
        return ((SynWTFilter[][]) getSpec(i, i2))[1];
    }

    public String toString() {
        String str = "nTiles=" + this.nTiles + "\nnComp=" + this.nComp + "\n\n";
        for (int i = 0; i < this.nTiles; i++) {
            for (int i2 = 0; i2 < this.nComp; i2++) {
                SynWTFilter[][] synWTFilterArr = (SynWTFilter[][]) getSpec(i, i2);
                String str2 = (str + "(t:" + i + ",c:" + i2 + ")\n") + "\tH:";
                for (int i3 = 0; i3 < synWTFilterArr[0].length; i3++) {
                    str2 = str2 + " " + synWTFilterArr[0][i3];
                }
                String str3 = str2 + "\n\tV:";
                for (int i4 = 0; i4 < synWTFilterArr[1].length; i4++) {
                    str3 = str3 + " " + synWTFilterArr[1][i4];
                }
                str = str3 + "\n";
            }
        }
        return str;
    }

    public boolean isReversible(int i, int i2) {
        SynWTFilter[] hFilters = getHFilters(i, i2);
        SynWTFilter[] vFilters = getVFilters(i, i2);
        for (int length = hFilters.length - 1; length >= 0; length--) {
            if (!hFilters[length].isReversible() || !vFilters[length].isReversible()) {
                return false;
            }
        }
        return true;
    }
}
