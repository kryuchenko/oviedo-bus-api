package icc;

import icc.tags.ICCCurveType;
import icc.tags.ICCXYZType;

/* loaded from: classes5.dex */
public class MatrixBasedRestrictedProfile extends RestrictedICCProfile {
    @Override // icc.RestrictedICCProfile
    public int getType() {
        return 1;
    }

    public static RestrictedICCProfile createInstance(ICCCurveType iCCCurveType, ICCCurveType iCCCurveType2, ICCCurveType iCCCurveType3, ICCXYZType iCCXYZType, ICCXYZType iCCXYZType2, ICCXYZType iCCXYZType3) {
        return new MatrixBasedRestrictedProfile(iCCCurveType, iCCCurveType2, iCCCurveType3, iCCXYZType, iCCXYZType2, iCCXYZType3);
    }

    protected MatrixBasedRestrictedProfile(ICCCurveType iCCCurveType, ICCCurveType iCCCurveType2, ICCCurveType iCCCurveType3, ICCXYZType iCCXYZType, ICCXYZType iCCXYZType2, ICCXYZType iCCXYZType3) {
        super(iCCCurveType, iCCCurveType2, iCCCurveType3, iCCXYZType, iCCXYZType2, iCCXYZType3);
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[Matrix-Based Input Restricted ICC profile").append(eol);
        stringBufferAppend.append("trc[RED]:").append(eol).append(this.trc[0]).append(eol);
        stringBufferAppend.append("trc[RED]:").append(eol).append(this.trc[1]).append(eol);
        stringBufferAppend.append("trc[RED]:").append(eol).append(this.trc[2]).append(eol);
        stringBufferAppend.append("Red colorant:  ").append(this.colorant[0]).append(eol);
        stringBufferAppend.append("Red colorant:  ").append(this.colorant[1]).append(eol);
        stringBufferAppend.append("Red colorant:  ").append(this.colorant[2]).append(eol);
        return stringBufferAppend.append("]").toString();
    }
}
