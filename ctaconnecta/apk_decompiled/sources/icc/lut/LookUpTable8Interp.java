package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTable8Interp extends LookUpTable8 {
    public LookUpTable8Interp(ICCCurveType iCCCurveType, int i, byte b) {
        double dCurveToDouble;
        super(iCCCurveType, i, b);
        double d = (iCCCurveType.count - 1) / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            double d2 = i2 * d;
            double dFloor = Math.floor(d2);
            int i3 = (int) dFloor;
            int iCeil = (int) Math.ceil(d2);
            if (i3 == iCeil) {
                dCurveToDouble = ICCCurveType.CurveToDouble(iCCCurveType.entry(i3));
            } else {
                double dCurveToDouble2 = ICCCurveType.CurveToDouble(iCCCurveType.entry(i3));
                dCurveToDouble = dCurveToDouble2 + ((ICCCurveType.CurveToDouble(iCCCurveType.entry(iCeil)) - dCurveToDouble2) * (d2 - dFloor));
            }
            this.lut[i2] = (byte) Math.floor((dCurveToDouble * b) + 0.5d);
        }
    }
}
