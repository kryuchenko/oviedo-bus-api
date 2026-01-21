package icc.tags;

import icc.ICCProfile;

/* loaded from: classes5.dex */
public class ICCTextType extends ICCTag {
    public final byte[] ascii;
    public final int reserved;
    public final int type;

    protected ICCTextType(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.type = ICCProfile.getInt(bArr, i2);
        this.reserved = ICCProfile.getInt(bArr, i2 + 4);
        int i4 = i2 + 8;
        int i5 = 0;
        while (bArr[i4 + i5] != 0) {
            i5++;
        }
        byte[] bArr2 = new byte[i5];
        this.ascii = bArr2;
        System.arraycopy(bArr, i4, bArr2, 0, i5);
    }

    @Override // icc.tags.ICCTag
    public String toString() {
        return "[" + super.toString() + " \"" + new String(this.ascii) + "\"]";
    }
}
