package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public abstract class LookUpTable8 extends LookUpTable {
    protected final byte dwMaxOutput;
    protected final byte[] lut;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LookUpTable8 ");
        stringBuffer.append("max= " + ((int) this.dwMaxOutput));
        stringBuffer.append(", nentries= " + ((int) this.dwMaxOutput));
        return stringBuffer.append("]").toString();
    }

    public String toStringWholeLut() {
        StringBuffer stringBuffer = new StringBuffer("LookUpTable8" + eol);
        stringBuffer.append("maxOutput = " + ((int) this.dwMaxOutput) + eol);
        for (int i = 0; i < this.dwNumInput; i++) {
            stringBuffer.append("lut[" + i + "] = " + ((int) this.lut[i]) + eol);
        }
        return stringBuffer.append("]").toString();
    }

    protected LookUpTable8(int i, byte b) {
        super(null, i);
        this.lut = new byte[i];
        this.dwMaxOutput = b;
    }

    protected LookUpTable8(ICCCurveType iCCCurveType, int i, byte b) {
        super(iCCCurveType, i);
        this.dwMaxOutput = b;
        this.lut = new byte[i];
    }

    public final byte elementAt(int i) {
        return this.lut[i];
    }
}
