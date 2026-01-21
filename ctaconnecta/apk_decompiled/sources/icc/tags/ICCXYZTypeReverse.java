package icc.tags;

import icc.ICCProfile;

/* loaded from: classes5.dex */
public class ICCXYZTypeReverse extends ICCXYZType {
    public final long x;
    public final long y;
    public final long z;

    protected ICCXYZTypeReverse(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.z = ICCProfile.getInt(bArr, i2 + 8);
        this.y = ICCProfile.getInt(bArr, i2 + 12);
        this.x = ICCProfile.getInt(bArr, i2 + 16);
    }

    @Override // icc.tags.ICCXYZType, icc.tags.ICCTag
    public String toString() {
        return "[" + super.toString() + "(" + this.x + ", " + this.y + ", " + this.z + ")]";
    }
}
