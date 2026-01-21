package icc.tags;

import icc.ICCProfile;
import kotlin.UShort;

/* loaded from: classes5.dex */
public class ICCCurveType extends ICCTag {
    private static final String eol = System.getProperty("line.separator");
    public final int[] entry;
    public final int nEntries;
    public final int reserved;
    public final int type;

    public static double CurveGammaToDouble(int i) {
        return i / 256.0d;
    }

    public static double CurveToDouble(int i) {
        return i / 65535.0d;
    }

    @Override // icc.tags.ICCTag
    public String toString() {
        return new StringBuffer("[").append(super.toString()).append(" nentries = ").append(String.valueOf(this.nEntries)).append(", length = " + String.valueOf(this.entry.length) + " ... ").append("]").toString();
    }

    public static short DoubleToCurve(double d) {
        return (short) Math.floor((d * 65535.0d) + 0.5d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected ICCCurveType(int i, byte[] bArr, int i2, int i3) {
        int i4 = i2 + 8;
        super(i, bArr, i2, i4);
        this.type = ICCProfile.getInt(bArr, i2);
        this.reserved = ICCProfile.getInt(bArr, i2 + 4);
        int i5 = ICCProfile.getInt(bArr, i4);
        this.nEntries = i5;
        this.entry = new int[i5];
        for (int i6 = 0; i6 < this.nEntries; i6++) {
            this.entry[i6] = ICCProfile.getShort(bArr, i2 + 12 + (i6 * 2)) & UShort.MAX_VALUE;
        }
    }

    public final int entry(int i) {
        return this.entry[i];
    }
}
