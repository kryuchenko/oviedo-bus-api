package icc.types;

import icc.ICCProfile;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public class ICCProfileHeader {
    private static final String kdwBlueColorantTag = "bXYZ";
    private static final String kdwBlueTRCTag = "bTRC";
    private static final String kdwDisplayProfile = "mntr";
    private static final String kdwGrayData = "GRAY";
    private static final String kdwGrayTRCTag = "kTRC";
    private static final String kdwGreenColorantTag = "gXYZ";
    private static final String kdwGreenTRCTag = "gTRC";
    private static final String kdwInputProfile = "scnr";
    private static final String kdwRGBData = "RGB ";
    private static final String kdwRedColorantTag = "rXYZ";
    private static final String kdwRedTRCTag = "rTRC";
    private static final String kdwXYZData = "XYZ ";
    private static final int offCMMFlags = 44;
    private static final int offCMMTypeSignature = 4;
    private static final int offColorSpaceType = 16;
    private static final int offCreatorSig = 80;
    private static final int offDateTime = 24;
    private static final int offDeviceAttributes1 = 56;
    private static final int offDeviceAttributesReserved = 60;
    private static final int offDeviceManufacturer = 48;
    private static final int offDeviceModel = 52;
    private static final int offPCSIlluminant = 68;
    private static final int offPCSType = 20;
    private static final int offPlatformSignature = 40;
    private static final int offProfileClass = 12;
    private static final int offProfileSignature = 36;
    private static final int offProfileSize = 0;
    private static final int offProfileVersion = 8;
    private static final int offRenderingIntent = 64;
    private static final int offReserved = 84;
    public static final int size = 128;
    public XYZNumber PCSIlluminant;
    public ICCDateTime dateTime;
    public int dwCMMFlags;
    public int dwCMMTypeSignature;
    public int dwColorSpaceType;
    public int dwCreatorSig;
    public int dwDeviceAttributes1;
    public int dwDeviceAttributesReserved;
    public int dwDeviceManufacturer;
    public int dwDeviceModel;
    public int dwPCSType;
    public int dwPlatformSignature;
    public int dwProfileClass;
    public int dwProfileSignature;
    public int dwProfileSize;
    public int dwRenderingIntent;
    private byte[] header;
    public ICCProfileVersion profileVersion;
    public byte[] reserved;
    private static final String eol = System.getProperty("line.separator");
    public static int kdwProfileSignature = ICCProfile.getInt(new String("acsp").getBytes(), 0);
    public static int kdwProfileSigReverse = ICCProfile.getInt(new String("psca").getBytes(), 0);

    public ICCProfileHeader() {
        this.header = null;
        this.reserved = new byte[44];
    }

    public ICCProfileHeader(byte[] bArr) {
        this.header = null;
        this.reserved = new byte[44];
        int i = 0;
        this.dwProfileSize = ICCProfile.getInt(bArr, 0);
        this.dwCMMTypeSignature = ICCProfile.getInt(bArr, 4);
        this.dwProfileClass = ICCProfile.getInt(bArr, 12);
        this.dwColorSpaceType = ICCProfile.getInt(bArr, 16);
        this.dwPCSType = ICCProfile.getInt(bArr, 20);
        this.dwProfileSignature = ICCProfile.getInt(bArr, 36);
        this.dwPlatformSignature = ICCProfile.getInt(bArr, 40);
        this.dwCMMFlags = ICCProfile.getInt(bArr, 44);
        this.dwDeviceManufacturer = ICCProfile.getInt(bArr, 48);
        this.dwDeviceModel = ICCProfile.getInt(bArr, 52);
        this.dwDeviceAttributes1 = ICCProfile.getInt(bArr, 60);
        this.dwDeviceAttributesReserved = ICCProfile.getInt(bArr, 60);
        this.dwRenderingIntent = ICCProfile.getInt(bArr, 64);
        this.dwCreatorSig = ICCProfile.getInt(bArr, 80);
        this.profileVersion = ICCProfile.getICCProfileVersion(bArr, 8);
        this.dateTime = ICCProfile.getICCDateTime(bArr, 24);
        this.PCSIlluminant = ICCProfile.getXYZNumber(bArr, 68);
        while (true) {
            byte[] bArr2 = this.reserved;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = bArr[i + 84];
            i++;
        }
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.seek(0L);
        randomAccessFile.write(this.dwProfileSize);
        randomAccessFile.seek(4L);
        randomAccessFile.write(this.dwCMMTypeSignature);
        randomAccessFile.seek(8L);
        this.profileVersion.write(randomAccessFile);
        randomAccessFile.seek(12L);
        randomAccessFile.write(this.dwProfileClass);
        randomAccessFile.seek(16L);
        randomAccessFile.write(this.dwColorSpaceType);
        randomAccessFile.seek(20L);
        randomAccessFile.write(this.dwPCSType);
        randomAccessFile.seek(24L);
        this.dateTime.write(randomAccessFile);
        randomAccessFile.seek(36L);
        randomAccessFile.write(this.dwProfileSignature);
        randomAccessFile.seek(40L);
        randomAccessFile.write(this.dwPlatformSignature);
        randomAccessFile.seek(44L);
        randomAccessFile.write(this.dwCMMFlags);
        randomAccessFile.seek(48L);
        randomAccessFile.write(this.dwDeviceManufacturer);
        randomAccessFile.seek(52L);
        randomAccessFile.write(this.dwDeviceModel);
        randomAccessFile.seek(56L);
        randomAccessFile.write(this.dwDeviceAttributes1);
        randomAccessFile.seek(60L);
        randomAccessFile.write(this.dwDeviceAttributesReserved);
        randomAccessFile.seek(64L);
        randomAccessFile.write(this.dwRenderingIntent);
        randomAccessFile.seek(68L);
        this.PCSIlluminant.write(randomAccessFile);
        randomAccessFile.seek(80L);
        randomAccessFile.write(this.dwCreatorSig);
        randomAccessFile.seek(84L);
        randomAccessFile.write(this.reserved);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ICCProfileHeader: ");
        StringBuilder sb = new StringBuilder();
        String str = eol;
        sb.append(str);
        sb.append("         ProfileSize: ");
        sb.append(Integer.toHexString(this.dwProfileSize));
        stringBuffer.append(sb.toString());
        stringBuffer.append(str + "    CMMTypeSignature: " + Integer.toHexString(this.dwCMMTypeSignature));
        stringBuffer.append(str + "        ProfileClass: " + Integer.toHexString(this.dwProfileClass));
        stringBuffer.append(str + "      ColorSpaceType: " + Integer.toHexString(this.dwColorSpaceType));
        stringBuffer.append(str + "           dwPCSType: " + Integer.toHexString(this.dwPCSType));
        stringBuffer.append(str + "  dwProfileSignature: " + Integer.toHexString(this.dwProfileSignature));
        stringBuffer.append(str + " dwPlatformSignature: " + Integer.toHexString(this.dwPlatformSignature));
        stringBuffer.append(str + "          dwCMMFlags: " + Integer.toHexString(this.dwCMMFlags));
        stringBuffer.append(str + "dwDeviceManufacturer: " + Integer.toHexString(this.dwDeviceManufacturer));
        stringBuffer.append(str + "       dwDeviceModel: " + Integer.toHexString(this.dwDeviceModel));
        stringBuffer.append(str + " dwDeviceAttributes1: " + Integer.toHexString(this.dwDeviceAttributes1));
        stringBuffer.append(str + "   dwRenderingIntent: " + Integer.toHexString(this.dwRenderingIntent));
        stringBuffer.append(str + "        dwCreatorSig: " + Integer.toHexString(this.dwCreatorSig));
        stringBuffer.append(str + "      profileVersion: " + this.profileVersion);
        stringBuffer.append(str + "            dateTime: " + this.dateTime);
        stringBuffer.append(str + "       PCSIlluminant: " + this.PCSIlluminant);
        return stringBuffer.append("]").toString();
    }
}
