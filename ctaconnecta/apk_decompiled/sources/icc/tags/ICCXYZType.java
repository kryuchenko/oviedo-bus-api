package icc.tags;

import icc.ICCProfile;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public class ICCXYZType extends ICCTag {
    public final long x;
    public final long y;
    public final long z;

    public static double XYZToDouble(long j) {
        return j / 65536.0d;
    }

    public static long DoubleToXYZ(double d) {
        return (long) Math.floor((d * 65536.0d) + 0.5d);
    }

    protected ICCXYZType(int i, byte[] bArr, int i2, int i3) {
        super(i, bArr, i2, i3);
        this.x = ICCProfile.getInt(bArr, i2 + 8);
        this.y = ICCProfile.getInt(bArr, i2 + 12);
        this.z = ICCProfile.getInt(bArr, i2 + 16);
    }

    @Override // icc.tags.ICCTag
    public String toString() {
        return "[" + super.toString() + "(" + this.x + ", " + this.y + ", " + this.z + ")]";
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = ICCProfile.setLong(this.x);
        byte[] bArr2 = ICCProfile.setLong(this.y);
        byte[] bArr3 = ICCProfile.setLong(this.z);
        randomAccessFile.write(bArr, 4, 0);
        randomAccessFile.write(bArr2, 4, 0);
        randomAccessFile.write(bArr3, 4, 0);
    }
}
