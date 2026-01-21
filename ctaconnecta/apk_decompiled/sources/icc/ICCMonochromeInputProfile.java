package icc;

import colorspace.ColorSpace;
import colorspace.ColorSpaceException;

/* loaded from: classes5.dex */
public class ICCMonochromeInputProfile extends ICCProfile {
    public static ICCMonochromeInputProfile createInstance(ColorSpace colorSpace) throws ColorSpaceException, ICCProfileInvalidException {
        return new ICCMonochromeInputProfile(colorSpace);
    }

    protected ICCMonochromeInputProfile(ColorSpace colorSpace) throws ColorSpaceException, ICCProfileInvalidException {
        super(colorSpace);
    }
}
