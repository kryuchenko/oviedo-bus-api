package icc.tags;

import icc.ICCProfile;

/* loaded from: classes5.dex */
public class ICCTextDescriptionType extends ICCTag {
    public final byte[] ascii;
    public final int reserved;
    public final int size;
    public final int type;

    protected ICCTextDescriptionType(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.type = ICCProfile.getInt(bArr, i2);
        this.reserved = ICCProfile.getInt(bArr, i2 + 4);
        int i4 = ICCProfile.getInt(bArr, i2 + 8);
        this.size = i4;
        byte[] bArr2 = new byte[i4 - 1];
        this.ascii = bArr2;
        System.arraycopy(bArr, i2 + 12, bArr2, 0, i4 - 1);
    }

    @Override // icc.tags.ICCTag
    public String toString() {
        return "[" + super.toString() + " \"" + new String(this.ascii) + "\"]";
    }
}
