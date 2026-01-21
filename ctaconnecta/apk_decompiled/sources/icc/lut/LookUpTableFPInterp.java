package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTableFPInterp extends LookUpTableFP {
    public String toString() {
        return new StringBuffer("[LookUpTable32 ").append(" nentries= " + this.lut.length).append("]").toString();
    }

    public LookUpTableFPInterp(ICCCurveType iCCCurveType, int i) {
        super(iCCCurveType, i);
        double d = (iCCCurveType.nEntries - 1) / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            double d2 = i2 * d;
            double dFloor = Math.floor(d2);
            int i3 = (int) dFloor;
            int iCeil = (int) Math.ceil(d2);
            if (i3 == iCeil) {
                this.lut[i2] = (float) ICCCurveType.CurveToDouble(iCCCurveType.entry(i3));
            } else {
                double dCurveToDouble = ICCCurveType.CurveToDouble(iCCCurveType.entry(i3));
                this.lut[i2] = (float) (dCurveToDouble + ((ICCCurveType.CurveToDouble(iCCCurveType.entry(iCeil)) - dCurveToDouble) * (d2 - dFloor)));
            }
        }
    }
}
