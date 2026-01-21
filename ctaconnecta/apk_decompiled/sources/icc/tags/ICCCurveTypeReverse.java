package icc.tags;

import icc.ICCProfile;
import kotlin.UShort;

/* loaded from: classes5.dex */
public class ICCCurveTypeReverse extends ICCTag {
    private static final String eol = System.getProperty("line.separator");
    public final int[] entry;
    public final int nEntries;
    public final int reserved;
    public final int type;

    @Override // icc.tags.ICCTag
    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[").append(super.toString());
        String str = eol;
        StringBuffer stringBufferAppend2 = stringBufferAppend.append(str);
        stringBufferAppend2.append("num entries = " + String.valueOf(this.nEntries) + str);
        stringBufferAppend2.append("data length = " + String.valueOf(this.entry.length) + str);
        for (int i = 0; i < this.nEntries; i++) {
            stringBufferAppend2.append(ICCProfile.toHexString(this.entry[i]) + eol);
        }
        return stringBufferAppend2.append("]").toString();
    }

    public static double CurveToDouble(int i) {
        return ICCCurveType.CurveToDouble(i);
    }

    public static short DoubleToCurve(int i) {
        return ICCCurveType.DoubleToCurve(i);
    }

    public static double CurveGammaToDouble(int i) {
        return ICCCurveType.CurveGammaToDouble(i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected ICCCurveTypeReverse(int i, byte[] bArr, int i2, int i3) {
        int i4 = i2 + 8;
        super(i, bArr, i2, i4);
        this.type = ICCProfile.getInt(bArr, i2);
        this.reserved = ICCProfile.getInt(bArr, i2 + 4);
        int i5 = ICCProfile.getInt(bArr, i4);
        this.nEntries = i5;
        this.entry = new int[i5];
        int i6 = 0;
        while (true) {
            int i7 = this.nEntries;
            if (i6 >= i7) {
                return;
            }
            this.entry[(i7 - 1) + i6] = ICCProfile.getShort(bArr, i2 + 12 + (i6 * 2)) & UShort.MAX_VALUE;
            i6++;
        }
    }

    public final int entry(int i) {
        return this.entry[i];
    }
}
