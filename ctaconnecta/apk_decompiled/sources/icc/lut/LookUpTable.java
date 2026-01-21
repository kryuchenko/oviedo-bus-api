package icc.lut;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public abstract class LookUpTable {
    protected static final String eol = System.getProperty("line.separator");
    protected ICCCurveType curve;
    protected int dwNumInput;

    protected LookUpTable(ICCCurveType iCCCurveType, int i) {
        this.curve = iCCCurveType;
        this.dwNumInput = i;
    }
}
