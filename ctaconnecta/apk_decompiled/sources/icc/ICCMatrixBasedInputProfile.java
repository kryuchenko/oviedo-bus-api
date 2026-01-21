package icc;

import colorspace.ColorSpace;
import colorspace.ColorSpaceException;

/* loaded from: classes5.dex */
public class ICCMatrixBasedInputProfile extends ICCProfile {
    public static ICCMatrixBasedInputProfile createInstance(ColorSpace colorSpace) throws ColorSpaceException, ICCProfileInvalidException {
        return new ICCMatrixBasedInputProfile(colorSpace);
    }

    protected ICCMatrixBasedInputProfile(ColorSpace colorSpace) throws ColorSpaceException, ICCProfileInvalidException {
        super(colorSpace);
    }
}
