package jj2000.j2k.entropy.decoder;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes5.dex */
public class ByteInputBuffer {
    private byte[] buf;
    private int count;
    private int pos;

    public ByteInputBuffer(byte[] bArr) {
        this.buf = bArr;
        this.count = bArr.length;
    }

    public ByteInputBuffer(byte[] bArr, int i, int i2) {
        this.buf = bArr;
        this.pos = i;
        this.count = i + i2;
    }

    public void setByteArray(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null) {
            if (i2 >= 0) {
                int i4 = this.count;
                if (i4 + i2 <= this.buf.length) {
                    if (i < 0) {
                        this.pos = i4;
                        this.count = i4 + i2;
                        return;
                    } else {
                        this.count = i2 + i;
                        this.pos = i;
                        return;
                    }
                }
            }
            throw new IllegalArgumentException();
        }
        if (i < 0 || i2 < 0 || (i3 = i2 + i) > bArr.length) {
            throw new IllegalArgumentException();
        }
        this.buf = bArr;
        this.count = i3;
        this.pos = i;
    }

    public synchronized void addByteArray(byte[] bArr, int i, int i2) {
        if (i2 >= 0 && i >= 0) {
            int i3 = i2 + i;
            byte[] bArr2 = this.buf;
            if (i3 <= bArr2.length) {
                int i4 = this.count;
                if (i4 + i2 <= bArr2.length) {
                    System.arraycopy(bArr, i, bArr2, i4, i2);
                    this.count += i2;
                } else {
                    int i5 = this.pos;
                    if ((i4 - i5) + i2 <= bArr2.length) {
                        System.arraycopy(bArr2, i5, bArr2, 0, i4 - i5);
                    } else {
                        byte[] bArr3 = new byte[(i4 - i5) + i2];
                        this.buf = bArr3;
                        System.arraycopy(bArr2, i4, bArr3, 0, i4 - i5);
                    }
                    int i6 = this.count - this.pos;
                    this.count = i6;
                    this.pos = 0;
                    System.arraycopy(bArr, i, this.buf, i6, i2);
                    this.count += i2;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public int readChecked() throws IOException {
        int i = this.pos;
        if (i < this.count) {
            byte[] bArr = this.buf;
            this.pos = i + 1;
            return bArr[i] & 255;
        }
        throw new EOFException();
    }

    public int read() {
        int i = this.pos;
        if (i >= this.count) {
            return -1;
        }
        byte[] bArr = this.buf;
        this.pos = i + 1;
        return bArr[i] & 255;
    }
}
