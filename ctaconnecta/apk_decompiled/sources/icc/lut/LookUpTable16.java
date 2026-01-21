package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public abstract class LookUpTable16 extends LookUpTable {
    protected final int dwMaxOutput;
    protected final short[] lut;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LookUpTable16 ");
        stringBuffer.append("max= " + this.dwMaxOutput);
        stringBuffer.append(", nentries= " + this.dwMaxOutput);
        return stringBuffer.append("]").toString();
    }

    public String toStringWholeLut() {
        StringBuffer stringBuffer = new StringBuffer("[LookUpTable16" + eol);
        stringBuffer.append("max output = " + this.dwMaxOutput + eol);
        int i = 0;
        while (i < this.dwNumInput / 10) {
            StringBuilder sb = new StringBuilder("lut[");
            int i2 = i * 10;
            sb.append(i2);
            sb.append("] : ");
            stringBuffer.append(sb.toString());
            for (int i3 = 0; i3 < 10; i3++) {
                stringBuffer.append((int) this.lut[i2 + i3]).append(" ");
            }
            stringBuffer.append(eol);
            i++;
        }
        StringBuilder sb2 = new StringBuilder("lut[");
        int i4 = i * 10;
        sb2.append(i4);
        sb2.append("] : ");
        stringBuffer.append(sb2.toString());
        for (int i5 = 0; i5 < this.dwNumInput % 10; i5++) {
            stringBuffer.append(((int) this.lut[i4 + i5]) + " ");
        }
        stringBuffer.append(eol + eol);
        return stringBuffer.toString();
    }

    public static LookUpTable16 createInstance(ICCCurveType iCCCurveType, int i, int i2) {
        return iCCCurveType.count == 1 ? new LookUpTable16Gamma(iCCCurveType, i, i2) : new LookUpTable16Interp(iCCCurveType, i, i2);
    }

    protected LookUpTable16(int i, int i2) {
        super(null, i);
        this.lut = new short[i];
        this.dwMaxOutput = i2;
    }

    protected LookUpTable16(ICCCurveType iCCCurveType, int i, int i2) {
        super(iCCCurveType, i);
        this.dwMaxOutput = i2;
        this.lut = new short[i];
    }

    public final short elementAt(int i) {
        return this.lut[i];
    }
}
