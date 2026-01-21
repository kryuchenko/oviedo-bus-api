package jj2000.j2k.entropy.encoder;

/* loaded from: classes5.dex */
public class ByteOutputBuffer {
    public static final int BUF_DEF_LEN = 256;
    public static final int BUF_INC = 512;
    byte[] buf;
    int count;

    public ByteOutputBuffer() {
        this.buf = new byte[256];
    }

    public ByteOutputBuffer(int i) {
        this.buf = new byte[i];
    }

    public final void write(int i) {
        int i2 = this.count;
        byte[] bArr = this.buf;
        if (i2 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length + 512];
            this.buf = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, i2);
        }
        byte[] bArr3 = this.buf;
        int i3 = this.count;
        this.count = i3 + 1;
        bArr3[i3] = (byte) i;
    }

    public void toByteArray(int i, int i2, byte[] bArr, int i3) {
        System.arraycopy(this.buf, i, bArr, i3, i2);
    }

    public int size() {
        return this.count;
    }

    public void reset() {
        this.count = 0;
    }

    public int getByte(int i) {
        if (i >= this.count) {
            throw new IllegalArgumentException();
        }
        return this.buf[i] & 255;
    }
}
