package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTableFPGamma extends LookUpTableFP {
    private static final String eol = System.getProperty("line.separator");
    double dfE;

    public LookUpTableFPGamma(ICCCurveType iCCCurveType, int i) {
        super(iCCCurveType, i);
        this.dfE = -1.0d;
        this.dfE = ICCCurveType.CurveGammaToDouble(iCCCurveType.entry(0));
        for (int i2 = 0; i2 < i; i2++) {
            this.lut[i2] = (float) Math.pow(i2 / (i - 1), this.dfE);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LookUpTableGamma ");
        stringBuffer.append("dfe= " + this.dfE);
        stringBuffer.append(", nentries= " + this.lut.length);
        return stringBuffer.append("]").toString();
    }
}
