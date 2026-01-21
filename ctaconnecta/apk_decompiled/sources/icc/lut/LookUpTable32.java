package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
abstract class LookUpTable32 extends LookUpTable {
    protected final int dwMaxOutput;
    public final int[] lut;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LookUpTable32 ");
        stringBuffer.append("max= " + this.dwMaxOutput);
        stringBuffer.append(", nentries= " + this.dwNumInput);
        return stringBuffer.append("]").toString();
    }

    public String toStringWholeLut() {
        StringBuffer stringBuffer = new StringBuffer("[LookUpTable32" + eol);
        stringBuffer.append("max output = " + this.dwMaxOutput + eol);
        int i = 0;
        while (i < this.dwNumInput / 10) {
            StringBuilder sb = new StringBuilder("lut[");
            int i2 = i * 10;
            sb.append(i2);
            sb.append("] : ");
            stringBuffer.append(sb.toString());
            for (int i3 = 0; i3 < 10; i3++) {
                stringBuffer.append(this.lut[i2 + i3] + " ");
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
            stringBuffer.append(this.lut[i4 + i5] + " ");
        }
        stringBuffer.append(eol + eol);
        return stringBuffer.toString();
    }

    public static LookUpTable32 createInstance(ICCCurveType iCCCurveType, int i, int i2) {
        return iCCCurveType.count == 1 ? new LookUpTable32Gamma(iCCCurveType, i, i2) : new LookUpTable32Interp(iCCCurveType, i, i2);
    }

    protected LookUpTable32(int i, int i2) {
        super(null, i);
        this.lut = new int[i];
        this.dwMaxOutput = i2;
    }

    protected LookUpTable32(ICCCurveType iCCCurveType, int i, int i2) {
        super(iCCCurveType, i);
        this.dwMaxOutput = i2;
        this.lut = new int[i];
    }

    public final int elementAt(int i) {
        return this.lut[i];
    }
}
