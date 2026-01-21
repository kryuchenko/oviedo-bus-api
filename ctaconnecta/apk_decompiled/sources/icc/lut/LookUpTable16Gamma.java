package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTable16Gamma extends LookUpTable16 {
    public LookUpTable16Gamma(ICCCurveType iCCCurveType, int i, int i2) {
        super(iCCCurveType, i, i2);
        double dCurveGammaToDouble = ICCCurveType.CurveGammaToDouble(iCCCurveType.entry(0));
        for (int i3 = 0; i3 < i; i3++) {
            this.lut[i3] = (short) Math.floor((Math.pow(i3 / (i - 1), dCurveGammaToDouble) * i2) + 0.5d);
        }
    }
}
