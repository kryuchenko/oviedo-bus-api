package icc;

import icc.tags.ICCCurveType;

/* loaded from: classes5.dex */
public class MonochromeInputRestrictedProfile extends RestrictedICCProfile {
    @Override // icc.RestrictedICCProfile
    public int getType() {
        return 0;
    }

    public static RestrictedICCProfile createInstance(ICCCurveType iCCCurveType) {
        return new MonochromeInputRestrictedProfile(iCCCurveType);
    }

    private MonochromeInputRestrictedProfile(ICCCurveType iCCCurveType) {
        super(iCCCurveType);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Monochrome Input Restricted ICC profile" + eol);
        stringBuffer.append("trc[GRAY]:" + eol).append(this.trc[0]).append(eol);
        return stringBuffer.toString();
    }
}
