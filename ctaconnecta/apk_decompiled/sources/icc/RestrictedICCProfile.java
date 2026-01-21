package icc;

import icc.tags.ICCCurveType;
import icc.tags.ICCXYZType;

/* loaded from: classes5.dex */
public abstract class RestrictedICCProfile {
    protected static final int BLUE = 2;
    protected static final int GRAY = 0;
    protected static final int GREEN = 1;
    protected static final int RED = 0;
    protected static final String eol = System.getProperty("line.separator");
    public static final int kMonochromeInput = 0;
    public static final int kThreeCompInput = 1;
    public ICCXYZType[] colorant;
    public ICCCurveType[] trc;

    public abstract int getType();

    public static RestrictedICCProfile createInstance(ICCCurveType iCCCurveType, ICCCurveType iCCCurveType2, ICCCurveType iCCCurveType3, ICCXYZType iCCXYZType, ICCXYZType iCCXYZType2, ICCXYZType iCCXYZType3) {
        return MatrixBasedRestrictedProfile.createInstance(iCCCurveType, iCCCurveType2, iCCCurveType3, iCCXYZType, iCCXYZType2, iCCXYZType3);
    }

    public static RestrictedICCProfile createInstance(ICCCurveType iCCCurveType) {
        return MonochromeInputRestrictedProfile.createInstance(iCCCurveType);
    }

    protected RestrictedICCProfile(ICCCurveType iCCCurveType) {
        this.trc = new ICCCurveType[]{iCCCurveType};
        this.colorant = null;
    }

    protected RestrictedICCProfile(ICCCurveType iCCCurveType, ICCCurveType iCCCurveType2, ICCCurveType iCCCurveType3, ICCXYZType iCCXYZType, ICCXYZType iCCXYZType2, ICCXYZType iCCXYZType3) {
        this.trc = new ICCCurveType[]{iCCCurveType, iCCCurveType2, iCCCurveType3};
        this.colorant = new ICCXYZType[]{iCCXYZType, iCCXYZType2, iCCXYZType3};
    }
}
