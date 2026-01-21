package icc.types;

import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public class XYZNumber {
    public static final int size = 12;
    public int dwX;
    public int dwY;
    public int dwZ;

    public static double XYZToDouble(int i) {
        return i / 65536.0d;
    }

    public XYZNumber(int i, int i2, int i3) {
        this.dwX = i;
        this.dwY = i2;
        this.dwZ = i3;
    }

    public static int DoubleToXYZ(double d) {
        return (int) Math.floor((d * 65536.0d) + 0.5d);
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.writeInt(this.dwX);
        randomAccessFile.writeInt(this.dwY);
        randomAccessFile.writeInt(this.dwZ);
    }

    public String toString() {
        return "[" + this.dwX + ", " + this.dwY + ", " + this.dwZ + "]";
    }
}
