package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTable8Gamma extends LookUpTable8 {
    public LookUpTable8Gamma(ICCCurveType iCCCurveType, int i, byte b) {
        super(iCCCurveType, i, b);
        double dCurveGammaToDouble = ICCCurveType.CurveGammaToDouble(iCCCurveType.entry(0));
        for (int i2 = 0; i2 < i; i2++) {
            this.lut[i2] = (byte) Math.floor((Math.pow(i2 / (i - 1), dCurveGammaToDouble) * b) + 0.5d);
        }
    }
}
