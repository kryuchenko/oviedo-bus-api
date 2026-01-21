package icc.tags;

import icc.ICCProfile;

/* loaded from: classes5.dex */
public abstract class ICCTag {
    private static final String sdwDescSignature = "desc";
    private static final String sdwTextDescType = "desc";
    private static final String sdwTextType = "text";
    public final int count;
    public final byte[] data;
    public final int offset;
    public final int signature;
    public final int type;
    private static final String sdwCprtSignature = "cprt";
    private static final int kdwCprtSignature = ICCProfile.getInt(sdwCprtSignature.getBytes(), 0);
    private static final int kdwDescSignature = ICCProfile.getInt("desc".getBytes(), 0);
    private static final String sdwWtPtSignature = "wtpt";
    private static final int kdwWtPtSignature = ICCProfile.getInt(sdwWtPtSignature.getBytes(), 0);
    private static final String sdwBkPtSignature = "bkpt";
    private static final int kdwBkPtSignature = ICCProfile.getInt(sdwBkPtSignature.getBytes(), 0);
    private static final String sdwRXYZSignature = "rXYZ";
    private static final int kdwRXYZSignature = ICCProfile.getInt(sdwRXYZSignature.getBytes(), 0);
    private static final String sdwGXYZSignature = "gXYZ";
    private static final int kdwGXYZSignature = ICCProfile.getInt(sdwGXYZSignature.getBytes(), 0);
    private static final String sdwBXYZSignature = "bXYZ";
    private static final int kdwBXYZSignature = ICCProfile.getInt(sdwBXYZSignature.getBytes(), 0);
    private static final String sdwKXYZSignature = "kXYZ";
    private static final int kdwKXYZSignature = ICCProfile.getInt(sdwKXYZSignature.getBytes(), 0);
    private static final String sdwRTRCSignature = "rTRC";
    private static final int kdwRTRCSignature = ICCProfile.getInt(sdwRTRCSignature.getBytes(), 0);
    private static final String sdwGTRCSignature = "gTRC";
    private static final int kdwGTRCSignature = ICCProfile.getInt(sdwGTRCSignature.getBytes(), 0);
    private static final String sdwBTRCSignature = "bTRC";
    private static final int kdwBTRCSignature = ICCProfile.getInt(sdwBTRCSignature.getBytes(), 0);
    private static final String sdwKTRCSignature = "kTRC";
    private static final int kdwKTRCSignature = ICCProfile.getInt(sdwKTRCSignature.getBytes(), 0);
    private static final String sdwDmndSignature = "dmnd";
    private static final int kdwDmndSignature = ICCProfile.getInt(sdwDmndSignature.getBytes(), 0);
    private static final String sdwDmddSignature = "dmdd";
    private static final int kdwDmddSignature = ICCProfile.getInt(sdwDmddSignature.getBytes(), 0);
    private static final int kdwTextDescType = ICCProfile.getInt("desc".getBytes(), 0);
    private static final int kdwTextType = ICCProfile.getInt("text".getBytes(), 0);
    private static final String sdwCurveType = "curv";
    private static final int kdwCurveType = ICCProfile.getInt(sdwCurveType.getBytes(), 0);
    private static final String sdwCurveTypeReverse = "vruc";
    private static final int kdwCurveTypeReverse = ICCProfile.getInt(sdwCurveTypeReverse.getBytes(), 0);
    private static final String sdwXYZType = "XYZ ";
    private static final int kdwXYZType = ICCProfile.getInt(sdwXYZType.getBytes(), 0);
    private static final String sdwXYZTypeReverse = " ZYX";
    private static final int kdwXYZTypeReverse = ICCProfile.getInt(sdwXYZTypeReverse.getBytes(), 0);

    public static String typeString(int i) {
        return (i == kdwTextDescType || i == kdwTextType) ? "desc" : i == kdwCurveType ? sdwCurveType : i == kdwCurveTypeReverse ? sdwCurveTypeReverse : i == kdwXYZType ? sdwXYZType : i == kdwXYZTypeReverse ? sdwXYZTypeReverse : "bad tag type";
    }

    public static String signatureString(int i) {
        return i == kdwCprtSignature ? sdwCprtSignature : i == kdwDescSignature ? "desc" : i == kdwWtPtSignature ? sdwWtPtSignature : i == kdwBkPtSignature ? sdwBkPtSignature : i == kdwRXYZSignature ? sdwRXYZSignature : i == kdwGXYZSignature ? sdwGXYZSignature : i == kdwBXYZSignature ? sdwBXYZSignature : i == kdwRTRCSignature ? sdwRTRCSignature : i == kdwGTRCSignature ? sdwGTRCSignature : i == kdwBTRCSignature ? sdwBTRCSignature : i == kdwKTRCSignature ? sdwKTRCSignature : i == kdwDmndSignature ? sdwDmndSignature : i == kdwDmddSignature ? sdwDmddSignature : "bad tag signature";
    }

    public static ICCTag createInstance(int i, byte[] bArr, int i2, int i3) {
        int i4 = ICCProfile.getInt(bArr, i2);
        if (i4 == kdwTextDescType) {
            return new ICCTextDescriptionType(i, bArr, i2, i3);
        }
        if (i4 == kdwTextType) {
            return new ICCTextType(i, bArr, i2, i3);
        }
        if (i4 == kdwXYZType) {
            return new ICCXYZType(i, bArr, i2, i3);
        }
        if (i4 == kdwXYZTypeReverse) {
            return new ICCXYZTypeReverse(i, bArr, i2, i3);
        }
        if (i4 == kdwCurveType) {
            return new ICCCurveType(i, bArr, i2, i3);
        }
        if (i4 == kdwCurveTypeReverse) {
            return new ICCCurveTypeReverse(i, bArr, i2, i3);
        }
        throw new IllegalArgumentException("bad tag type");
    }

    protected ICCTag(int i, byte[] bArr, int i2, int i3) {
        this.signature = i;
        this.data = bArr;
        this.offset = i2;
        this.count = i3;
        this.type = ICCProfile.getInt(bArr, i2);
    }

    public String toString() {
        return signatureString(this.signature) + ":" + typeString(this.type);
    }
}
