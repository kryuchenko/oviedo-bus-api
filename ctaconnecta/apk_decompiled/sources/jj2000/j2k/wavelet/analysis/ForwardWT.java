package jj2000.j2k.wavelet.analysis;

import java.util.StringTokenizer;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.ImgData;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public abstract class ForwardWT extends ImgDataAdapter implements ForwWT, CBlkWTDataSrc {
    public static final char OPT_PREFIX = 'W';
    public static final int WT_DECOMP_DYADIC = 0;
    private static final String[][] pinfo = {new String[]{"Wlev", "<number of decomposition levels>", "Specifies the number of wavelet decomposition levels to apply to the image. If 0 no wavelet transform is performed. All components and all tiles have the same number of decomposition levels.", "5"}, new String[]{"Wwt", "[full]", "Specifies the wavelet transform to be used. Possible value is: 'full' (full page). The value 'full' performs a normal DWT.", "full"}, new String[]{"Wcboff", "<x y>", "Code-blocks partition offset in the reference grid. Allowed for <x> and <y> are 0 and 1.\nNote: This option is defined in JPEG 2000 part 2 and may not be supported by all JPEG 2000 decoders.", "0 0"}};

    protected ForwardWT(ImgData imgData) {
        super(imgData);
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public static ForwardWT createInstance(BlkImgDataSrc blkImgDataSrc, ParameterList parameterList, EncoderSpecs encoderSpecs) {
        parameterList.checkList(OPT_PREFIX, ParameterList.toNameArray(pinfo));
        ((Integer) encoderSpecs.dls.getDefault()).intValue();
        if (parameterList.getParameter("Wcboff") == null) {
            throw new Error("You must specify an argument to the '-Wcboff' option. See usage with the '-u' option");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameterList.getParameter("Wcboff"));
        if (stringTokenizer.countTokens() != 2) {
            throw new IllegalArgumentException("'-Wcboff' option needs two arguments. See usage with the '-u' option.");
        }
        String strNextToken = stringTokenizer.nextToken();
        try {
            int iIntValue = new Integer(strNextToken).intValue();
            if (iIntValue < 0 || iIntValue > 1) {
                throw new IllegalArgumentException("Invalid horizontal code-block partition origin.");
            }
            String strNextToken2 = stringTokenizer.nextToken();
            try {
                int iIntValue2 = new Integer(strNextToken2).intValue();
                if (iIntValue2 < 0 || iIntValue2 > 1) {
                    throw new IllegalArgumentException("Invalid vertical code-block partition origin.");
                }
                if (iIntValue != 0 || iIntValue2 != 0) {
                    FacilityManager.getMsgLogger().printmsg(2, "Code-blocks partition origin is different from (0,0). This is defined in JPEG 2000 part 2 and may be not supported by all JPEG 2000 decoders.");
                }
                return new ForwWTFull(blkImgDataSrc, encoderSpecs, iIntValue, iIntValue2);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Bad second parameter for the '-Wcboff' option: " + strNextToken2);
            }
        } catch (NumberFormatException unused2) {
            throw new IllegalArgumentException("Bad first parameter for the '-Wcboff' option: " + strNextToken);
        }
    }
}
