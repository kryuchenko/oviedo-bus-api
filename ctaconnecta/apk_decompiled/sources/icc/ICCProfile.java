package icc;

import colorspace.ColorSpace;
import colorspace.ColorSpaceException;
import com.cexmobility.core.data.ApiMessages;
import icc.tags.ICCCurveType;
import icc.tags.ICCTagTable;
import icc.tags.ICCXYZType;
import icc.types.ICCDateTime;
import icc.types.ICCProfileHeader;
import icc.types.ICCProfileVersion;
import icc.types.XYZNumber;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Hashtable;
import jj2000.j2k.entropy.encoder.StdEntropyCoder;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ParameterList;
import kotlin.UShort;

/* loaded from: classes5.dex */
public abstract class ICCProfile {
    public static final int BITS_PER_BYTE = 8;
    public static final int BITS_PER_INT = 32;
    public static final int BITS_PER_LONG = 64;
    public static final int BITS_PER_SHORT = 16;
    public static final int BLUE = 2;
    public static final int BYTES_PER_INT = 4;
    public static final int BYTES_PER_LONG = 8;
    public static final int BYTES_PER_SHORT = 2;
    public static final int GRAY = 0;
    public static final int GREEN = 1;
    public static final int RED = 0;
    public static final int boolean_size = 1;
    public static final int byte_size = 1;
    public static final int char_size = 2;
    public static final int double_size = 8;
    public static final int float_size = 4;
    public static final int int_size = 4;
    public static final int kMonochromeInput = 0;
    public static final int kThreeCompInput = 1;
    public static final int long_size = 8;
    public static final int short_size = 2;
    private byte[] data;
    private ICCProfileHeader header;
    private ParameterList pl;
    private byte[] profile;
    private ICCTagTable tags;
    private static final String eol = System.getProperty("line.separator");
    public static final int kdwProfileSignature = getInt(new String("acsp").getBytes(), 0);
    public static final int kdwProfileSigReverse = getInt(new String("psca").getBytes(), 0);
    public static final int kdwInputProfile = getInt(new String("scnr").getBytes(), 0);
    public static final int kdwDisplayProfile = getInt(new String("mntr").getBytes(), 0);
    public static final int kdwRGBData = getInt(new String("RGB ").getBytes(), 0);
    public static final int kdwGrayData = getInt(new String("GRAY").getBytes(), 0);
    public static final int kdwXYZData = getInt(new String("XYZ ").getBytes(), 0);
    public static final int kdwGrayTRCTag = getInt(new String("kTRC").getBytes(), 0);
    public static final int kdwRedColorantTag = getInt(new String("rXYZ").getBytes(), 0);
    public static final int kdwGreenColorantTag = getInt(new String("gXYZ").getBytes(), 0);
    public static final int kdwBlueColorantTag = getInt(new String("bXYZ").getBytes(), 0);
    public static final int kdwRedTRCTag = getInt(new String("rTRC").getBytes(), 0);
    public static final int kdwGreenTRCTag = getInt(new String("gTRC").getBytes(), 0);
    public static final int kdwBlueTRCTag = getInt(new String("bTRC").getBytes(), 0);
    public static final int kdwCopyrightTag = getInt(new String("cprt").getBytes(), 0);
    public static final int kdwMediaWhiteTag = getInt(new String("wtpt").getBytes(), 0);
    public static final int kdwProfileDescTag = getInt(new String("desc").getBytes(), 0);

    private static class BoxType extends Hashtable {
        private static Hashtable map = new Hashtable();

        private BoxType() {
        }

        static {
            put(FileFormatBoxes.BITS_PER_COMPONENT_BOX, "BITS_PER_COMPONENT_BOX");
            put(FileFormatBoxes.CAPTURE_RESOLUTION_BOX, "CAPTURE_RESOLUTION_BOX");
            put(FileFormatBoxes.CHANNEL_DEFINITION_BOX, "CHANNEL_DEFINITION_BOX");
            put(FileFormatBoxes.COLOUR_SPECIFICATION_BOX, "COLOUR_SPECIFICATION_BOX");
            put(FileFormatBoxes.COMPONENT_MAPPING_BOX, "COMPONENT_MAPPING_BOX");
            put(FileFormatBoxes.CONTIGUOUS_CODESTREAM_BOX, "CONTIGUOUS_CODESTREAM_BOX");
            put(FileFormatBoxes.DEFAULT_DISPLAY_RESOLUTION_BOX, "DEFAULT_DISPLAY_RESOLUTION_BOX");
            put(FileFormatBoxes.FILE_TYPE_BOX, "FILE_TYPE_BOX");
            put(FileFormatBoxes.IMAGE_HEADER_BOX, "IMAGE_HEADER_BOX");
            put(FileFormatBoxes.INTELLECTUAL_PROPERTY_BOX, "INTELLECTUAL_PROPERTY_BOX");
            put(FileFormatBoxes.JP2_HEADER_BOX, "JP2_HEADER_BOX");
            put(FileFormatBoxes.JP2_SIGNATURE_BOX, "JP2_SIGNATURE_BOX");
            put(FileFormatBoxes.PALETTE_BOX, "PALETTE_BOX");
            put(FileFormatBoxes.RESOLUTION_BOX, "RESOLUTION_BOX");
            put(FileFormatBoxes.URL_BOX, "URL_BOX");
            put(FileFormatBoxes.UUID_BOX, "UUID_BOX");
            put(FileFormatBoxes.UUID_INFO_BOX, "UUID_INFO_BOX");
            put(FileFormatBoxes.UUID_LIST_BOX, "UUID_LIST_BOX");
            put(FileFormatBoxes.XML_BOX, "XML_BOX");
        }

        public static void put(int i, String str) {
            map.put(new Integer(i), str);
        }

        public static String get(int i) {
            return (String) map.get(new Integer(i));
        }

        public static String colorSpecMethod(int i) {
            if (i == 1) {
                return "Enumerated Color Space";
            }
            if (i == 2) {
                return "Restricted ICC Profile";
            }
            return "Undefined Color Spec Method";
        }
    }

    public static int getIntFromString(String str) {
        return getInt(str.getBytes(), 0);
    }

    public static XYZNumber getXYZNumber(byte[] bArr, int i) {
        return new XYZNumber(getInt(bArr, i), getInt(bArr, i + 4), getInt(bArr, i + 8));
    }

    public static ICCProfileVersion getICCProfileVersion(byte[] bArr, int i) {
        return new ICCProfileVersion(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3]);
    }

    public static ICCDateTime getICCDateTime(byte[] bArr, int i) {
        return new ICCDateTime(getShort(bArr, i), getShort(bArr, i + 2), getShort(bArr, i + 4), getShort(bArr, i + 6), getShort(bArr, i + 8), getShort(bArr, i + 10));
    }

    public static String getString(byte[] bArr, int i, int i2, boolean z) {
        byte[] bArr2 = new byte[i2];
        int i3 = z ? -1 : 1;
        if (z) {
            i = (i + i2) - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = bArr[i];
            i += i3;
        }
        return new String(bArr2);
    }

    public static short getShort(byte[] bArr, int i, boolean z) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        return (short) (z ? (i3 << 8) | i2 : i3 | (i2 << 8));
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static byte[] setInt(int i) {
        return setInt(i, new byte[4]);
    }

    public static byte[] setInt(int i, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i & 255);
            i >>= 8;
        }
        return bArr;
    }

    public static byte[] setLong(long j) {
        return setLong(j, new byte[4]);
    }

    public static byte[] setLong(long j, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[8];
        }
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    public static int getInt(byte[] bArr, int i, boolean z) {
        int i2 = getShort(bArr, i, z) & UShort.MAX_VALUE;
        int i3 = getShort(bArr, i + 2, z) & UShort.MAX_VALUE;
        return z ? (i3 << 16) | i2 : i3 | (i2 << 16);
    }

    public static int getInt(byte[] bArr, int i) {
        return (getShort(bArr, i + 2) & UShort.MAX_VALUE) | ((getShort(bArr, i) & UShort.MAX_VALUE) << 16);
    }

    public static long getLong(byte[] bArr, int i) {
        return getInt(bArr, i + 4) | (getInt(bArr, i) << 32);
    }

    private int getProfileSize() {
        return this.header.dwProfileSize;
    }

    private int getCMMTypeSignature() {
        return this.header.dwCMMTypeSignature;
    }

    private int getProfileClass() {
        return this.header.dwProfileClass;
    }

    private int getColorSpaceType() {
        return this.header.dwColorSpaceType;
    }

    private int getPCSType() {
        return this.header.dwPCSType;
    }

    private int getProfileSignature() {
        return this.header.dwProfileSignature;
    }

    private int getPlatformSignature() {
        return this.header.dwPlatformSignature;
    }

    private int getCMMFlags() {
        return this.header.dwCMMFlags;
    }

    private int getDeviceManufacturer() {
        return this.header.dwDeviceManufacturer;
    }

    private int getDeviceModel() {
        return this.header.dwDeviceModel;
    }

    private int getDeviceAttributes1() {
        return this.header.dwDeviceAttributes1;
    }

    private int getDeviceAttributesReserved() {
        return this.header.dwDeviceAttributesReserved;
    }

    private int getRenderingIntent() {
        return this.header.dwRenderingIntent;
    }

    private int getCreatorSig() {
        return this.header.dwCreatorSig;
    }

    private ICCProfileVersion getProfileVersion() {
        return this.header.profileVersion;
    }

    private void setProfileSignature(int i) {
        this.header.dwProfileSignature = i;
    }

    private void setProfileSize(int i) {
        this.header.dwProfileSize = i;
    }

    private void setCMMTypeSignature(int i) {
        this.header.dwCMMTypeSignature = i;
    }

    private void setProfileClass(int i) {
        this.header.dwProfileClass = i;
    }

    private void setColorSpaceType(int i) {
        this.header.dwColorSpaceType = i;
    }

    private void setPCSIlluminant(XYZNumber xYZNumber) {
        this.header.PCSIlluminant = xYZNumber;
    }

    private void setPCSType(int i) {
        this.header.dwPCSType = i;
    }

    private void setPlatformSignature(int i) {
        this.header.dwPlatformSignature = i;
    }

    private void setCMMFlags(int i) {
        this.header.dwCMMFlags = i;
    }

    private void setDeviceManufacturer(int i) {
        this.header.dwDeviceManufacturer = i;
    }

    private void setDeviceModel(int i) {
        this.header.dwDeviceModel = i;
    }

    private void setDeviceAttributes1(int i) {
        this.header.dwDeviceAttributes1 = i;
    }

    private void setDeviceAttributesReserved(int i) {
        this.header.dwDeviceAttributesReserved = i;
    }

    private void setRenderingIntent(int i) {
        this.header.dwRenderingIntent = i;
    }

    private void setCreatorSig(int i) {
        this.header.dwCreatorSig = i;
    }

    private void setProfileVersion(ICCProfileVersion iCCProfileVersion) {
        this.header.profileVersion = iCCProfileVersion;
    }

    private void setDateTime(ICCDateTime iCCDateTime) {
        this.header.dateTime = iCCDateTime;
    }

    private ICCProfile() throws ICCProfileException {
        this.header = null;
        this.tags = null;
        this.profile = null;
        this.data = null;
        this.pl = null;
        throw new ICCProfileException("illegal to invoke empty constructor");
    }

    protected ICCProfile(ColorSpace colorSpace) throws ColorSpaceException, ICCProfileInvalidException {
        this.header = null;
        this.tags = null;
        this.profile = null;
        this.data = null;
        this.pl = null;
        this.pl = colorSpace.pl;
        byte[] iCCProfile = colorSpace.getICCProfile();
        this.profile = iCCProfile;
        initProfile(iCCProfile);
    }

    private void initProfile(byte[] bArr) throws ICCProfileInvalidException {
        this.header = new ICCProfileHeader(bArr);
        this.tags = ICCTagTable.createInstance(bArr);
        int profileClass = getProfileClass();
        int i = kdwDisplayProfile;
        if (profileClass == i) {
            FacilityManager.getMsgLogger().printmsg(2, "NOTE!! Technically, this profile is a Display profile, not an Input Profile, and thus is not a valid Restricted ICC profile. However, it is quite possible that this profile is usable as a Restricted ICC profile, so this code will ignore this state and proceed with processing.");
        }
        if (getProfileSignature() != kdwProfileSignature || ((getProfileClass() != kdwInputProfile && getProfileClass() != i) || getPCSType() != kdwXYZData)) {
            throw new ICCProfileInvalidException();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ICCProfile:");
        StringBuffer stringBuffer2 = new StringBuffer();
        String str = eol;
        stringBuffer2.append(str).append(this.header);
        stringBuffer2.append(str).append(str).append(this.tags);
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2));
        return stringBuffer.append("]").toString();
    }

    public static String toHexString(byte b) {
        StringBuilder sb = new StringBuilder();
        sb.append((b < 0 || b >= 16) ? "" : StdEntropyCoder.DEF_THREADS_NUM);
        sb.append(Integer.toHexString(b));
        String string = sb.toString();
        return string.length() > 2 ? string.substring(string.length() - 2) : string;
    }

    public static String toHexString(short s) {
        String str;
        if (s >= 0 && s < 16) {
            str = "000" + Integer.toHexString(s);
        } else if (s >= 0 && s < 256) {
            str = "00" + Integer.toHexString(s);
        } else if (s >= 0 && s < 4096) {
            str = StdEntropyCoder.DEF_THREADS_NUM + Integer.toHexString(s);
        } else {
            str = "" + Integer.toHexString(s);
        }
        return str.length() > 4 ? str.substring(str.length() - 4) : str;
    }

    public static String toHexString(int i) {
        String str;
        if (i >= 0 && i < 16) {
            str = "0000000" + Integer.toHexString(i);
        } else if (i >= 0 && i < 256) {
            str = "000000" + Integer.toHexString(i);
        } else if (i >= 0 && i < 4096) {
            str = "00000" + Integer.toHexString(i);
        } else if (i >= 0 && i < 65536) {
            str = ApiMessages.GeneralResponseCode.CODE_SUCCESS + Integer.toHexString(i);
        } else if (i >= 0 && i < 1048576) {
            str = "000" + Integer.toHexString(i);
        } else if (i >= 0 && i < 16777216) {
            str = "00" + Integer.toHexString(i);
        } else if (i >= 0 && i < 268435456) {
            str = StdEntropyCoder.DEF_THREADS_NUM + Integer.toHexString(i);
        } else {
            str = "" + Integer.toHexString(i);
        }
        return str.length() > 8 ? str.substring(str.length() - 8) : str;
    }

    public static String toString(byte[] bArr) {
        int i;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length / 16;
        int length2 = bArr.length % 16;
        int i2 = 8;
        byte[] bArr2 = new byte[8];
        int i3 = 0;
        while (i3 < length) {
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i4 = 0;
            while (i4 < i2) {
                bArr2[i4] = 0;
                i4++;
            }
            byte[] bytes = Integer.toHexString(i3 * 16).getBytes();
            int length3 = 8 - bytes.length;
            int i5 = length;
            for (byte b : bytes) {
                bArr2[length3] = b;
                length3++;
            }
            StringBuffer stringBuffer4 = new StringBuffer(new String(bArr2));
            int i6 = 0;
            while (i6 < 16) {
                int i7 = i4 + 1;
                byte b2 = bArr[i4];
                StringBuffer stringBufferAppend = stringBuffer2.append(toHexString(b2));
                if (i7 % 2 == 0) {
                    i = i6;
                    str = " ";
                } else {
                    i = i6;
                    str = "";
                }
                stringBufferAppend.append(str);
                char c = (char) b2;
                if (Character.isJavaIdentifierStart(c)) {
                    stringBuffer3.append(c);
                } else {
                    stringBuffer3.append(".");
                }
                i6 = i + 1;
                i4 = i7;
            }
            stringBuffer.append(stringBuffer4).append(" :  ").append(stringBuffer2).append(":  ").append(stringBuffer3).append(eol);
            i3++;
            length = i5;
            i2 = 8;
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        StringBuffer stringBuffer6 = new StringBuffer();
        int i8 = 0;
        while (i8 < 8) {
            bArr2[i8] = 0;
            i8++;
        }
        byte[] bytes2 = Integer.toHexString(i3 * 16).getBytes();
        int length4 = 8 - bytes2.length;
        for (byte b3 : bytes2) {
            bArr2[length4] = b3;
            length4++;
        }
        StringBuffer stringBuffer7 = new StringBuffer(new String(bArr2));
        int i9 = 0;
        while (i9 < length2) {
            int i10 = i8 + 1;
            byte b4 = bArr[i8];
            stringBuffer5.append(toHexString(b4)).append(i10 % 2 == 0 ? " " : "");
            char c2 = (char) b4;
            if (Character.isJavaIdentifierStart(c2)) {
                stringBuffer6.append(c2);
            } else {
                stringBuffer6.append(".");
            }
            i9++;
            i8 = i10;
        }
        while (length2 < 16) {
            stringBuffer5.append("  ").append(length2 % 2 == 0 ? " " : "");
            length2++;
        }
        stringBuffer.append(stringBuffer7).append(" :  ").append(stringBuffer5).append(":  ").append(stringBuffer6).append(eol);
        return stringBuffer.toString();
    }

    public ICCProfileHeader getHeader() {
        return this.header;
    }

    public ICCTagTable getTagTable() {
        return this.tags;
    }

    public RestrictedICCProfile parse() throws ICCProfileInvalidException {
        ICCCurveType iCCCurveType = (ICCCurveType) this.tags.get(new Integer(kdwGrayTRCTag));
        if (iCCCurveType != null) {
            return RestrictedICCProfile.createInstance(iCCCurveType);
        }
        ICCCurveType iCCCurveType2 = (ICCCurveType) this.tags.get(new Integer(kdwRedTRCTag));
        if (iCCCurveType2 != null) {
            return RestrictedICCProfile.createInstance(iCCCurveType2, (ICCCurveType) this.tags.get(new Integer(kdwGreenTRCTag)), (ICCCurveType) this.tags.get(new Integer(kdwBlueTRCTag)), (ICCXYZType) this.tags.get(new Integer(kdwRedColorantTag)), (ICCXYZType) this.tags.get(new Integer(kdwGreenColorantTag)), (ICCXYZType) this.tags.get(new Integer(kdwBlueColorantTag)));
        }
        throw new ICCProfileInvalidException("curve data not found in profile");
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        getHeader().write(randomAccessFile);
        getTagTable().write(randomAccessFile);
    }
}
