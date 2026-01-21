package colorspace.boxes;

import colorspace.ColorSpace;
import colorspace.ColorSpaceException;
import icc.ICCProfile;
import java.io.IOException;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.util.FacilityManager;

/* loaded from: classes.dex */
public final class ColorSpecificationBox extends JP2Box {
    private ColorSpace.CSEnum colorSpace;
    private byte[] iccProfile;
    private ColorSpace.MethodEnum method;

    static {
        type = FileFormatBoxes.COLOUR_SPECIFICATION_BOX;
    }

    public ColorSpecificationBox(RandomAccessIO randomAccessIO, int i) throws ColorSpaceException, IOException {
        super(randomAccessIO, i);
        this.method = null;
        this.colorSpace = null;
        this.iccProfile = null;
        readBox();
    }

    private void readBox() throws ColorSpaceException, IOException {
        byte[] bArr = new byte[256];
        this.in.seek(this.dataStart);
        this.in.readFully(bArr, 0, 11);
        byte b = bArr[0];
        if (b != 1) {
            if (b == 2) {
                this.method = ColorSpace.ICC_PROFILED;
                int i = ICCProfile.getInt(bArr, 3);
                this.iccProfile = new byte[i];
                this.in.seek(this.dataStart + 3);
                this.in.readFully(this.iccProfile, 0, i);
                return;
            }
            throw new ColorSpaceException("Bad specification method (" + ((int) bArr[0]) + ") in " + this);
        }
        this.method = ColorSpace.ENUMERATED;
        int i2 = ICCProfile.getInt(bArr, 3);
        switch (i2) {
            case 16:
                this.colorSpace = ColorSpace.sRGB;
                return;
            case 17:
                this.colorSpace = ColorSpace.GreyScale;
                return;
            case 18:
                this.colorSpace = ColorSpace.sYCC;
                return;
            default:
                FacilityManager.getMsgLogger().printmsg(2, "Unknown enumerated colorspace (" + i2 + ") in color specification box");
                this.colorSpace = ColorSpace.Unknown;
                return;
        }
    }

    public ColorSpace.MethodEnum getMethod() {
        return this.method;
    }

    public ColorSpace.CSEnum getColorSpace() {
        return this.colorSpace;
    }

    public String getColorSpaceString() {
        return this.colorSpace.value;
    }

    public String getMethodString() {
        return this.method.value;
    }

    public byte[] getICCProfile() {
        return this.iccProfile;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ColorSpecificationBox method= ");
        stringBuffer.append(String.valueOf(this.method)).append(", colorspace= ");
        stringBuffer.append(String.valueOf(this.colorSpace)).append("]");
        return stringBuffer.toString();
    }
}
