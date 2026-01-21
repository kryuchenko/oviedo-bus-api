package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public abstract class LookUpTableFP extends LookUpTable {
    public final float[] lut;

    public static LookUpTableFP createInstance(ICCCurveType iCCCurveType, int i) {
        return iCCCurveType.nEntries == 1 ? new LookUpTableFPGamma(iCCCurveType, i) : new LookUpTableFPInterp(iCCCurveType, i);
    }

    protected LookUpTableFP(ICCCurveType iCCCurveType, int i) {
        super(iCCCurveType, i);
        this.lut = new float[i];
    }

    public final float elementAt(int i) {
        return this.lut[i];
    }
}
