package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class LookUpTable32Gamma extends LookUpTable32 {
    @Override // icc.lut.LookUpTable32
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // icc.lut.LookUpTable32
    public /* bridge */ /* synthetic */ String toStringWholeLut() {
        return super.toStringWholeLut();
    }

    public LookUpTable32Gamma(ICCCurveType iCCCurveType, int i, int i2) {
        super(iCCCurveType, i, i2);
        double dCurveGammaToDouble = ICCCurveType.CurveGammaToDouble(iCCCurveType.entry(0));
        for (int i3 = 0; i3 < i; i3++) {
            this.lut[i3] = (int) Math.floor((Math.pow(i3 / (i - 1), dCurveGammaToDouble) * i2) + 0.5d);
        }
    }
}
