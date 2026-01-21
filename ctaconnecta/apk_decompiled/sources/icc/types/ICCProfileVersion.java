package icc.types;

import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public class ICCProfileVersion {
    public static final int size = 4;
    private byte reserved1;
    private byte reserved2;
    public byte uMajor;
    public byte uMinor;

    public ICCProfileVersion(byte b, byte b2, byte b3, byte b4) {
        this.uMajor = b;
        this.uMinor = b2;
        this.reserved1 = b3;
        this.reserved2 = b4;
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.write(this.uMajor);
        randomAccessFile.write(this.uMinor);
        randomAccessFile.write(this.reserved1);
        randomAccessFile.write(this.reserved2);
    }

    public String toString() {
        return "Version " + ((int) this.uMajor) + "." + ((int) this.uMinor);
    }
}
