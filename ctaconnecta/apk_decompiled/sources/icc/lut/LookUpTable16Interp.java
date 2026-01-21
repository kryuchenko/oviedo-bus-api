package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTable16Interp extends LookUpTable16 {
    public LookUpTable16Interp(ICCCurveType iCCCurveType, int i, int i2) {
        double dCurveToDouble;
        super(iCCCurveType, i, i2);
        double d = (iCCCurveType.count - 1) / (i - 1);
        for (int i3 = 0; i3 < i; i3++) {
            double d2 = i3 * d;
            double dFloor = Math.floor(d2);
            int i4 = (int) dFloor;
            int iCeil = (int) Math.ceil(d2);
            if (i4 == iCeil) {
                dCurveToDouble = ICCCurveType.CurveToDouble(iCCCurveType.entry(i4));
            } else {
                double dCurveToDouble2 = ICCCurveType.CurveToDouble(iCCCurveType.entry(i4));
                dCurveToDouble = dCurveToDouble2 + ((ICCCurveType.CurveToDouble(iCCCurveType.entry(iCeil)) - dCurveToDouble2) * (d2 - dFloor));
            }
            this.lut[i3] = (short) Math.floor((dCurveToDouble * i2) + 0.5d);
        }
    }
}
