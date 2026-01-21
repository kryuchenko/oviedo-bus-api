package jj2000.j2k.util;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import jj2000.j2k.io.RandomAccessIO;

/* loaded from: classes5.dex */
public class ISRandomAccessIO implements RandomAccessIO {
    private byte[] buf;
    private boolean complete;
    private int inc;
    private InputStream is;
    private int len;
    private int maxsize;
    private int pos;

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void flush() {
    }

    @Override // jj2000.j2k.io.BinaryDataInput, jj2000.j2k.io.BinaryDataOutput
    public int getByteOrdering() {
        return 0;
    }

    public ISRandomAccessIO(InputStream inputStream, int i, int i2, int i3) {
        if (i < 0 || i2 <= 0 || i3 <= 0 || inputStream == null) {
            throw new IllegalArgumentException();
        }
        this.is = inputStream;
        this.buf = new byte[i < Integer.MAX_VALUE ? i + 1 : i];
        this.inc = i2;
        this.maxsize = i3 < Integer.MAX_VALUE ? i3 + 1 : i3;
        this.pos = 0;
        this.len = 0;
        this.complete = false;
    }

    public ISRandomAccessIO(InputStream inputStream) {
        this(inputStream, 262144, 262144, Integer.MAX_VALUE);
    }

    private void growBuffer() throws IOException {
        int i = this.inc;
        byte[] bArr = this.buf;
        int length = bArr.length + i;
        int i2 = this.maxsize;
        if ((length > i2 ? i2 - bArr.length : i) <= 0) {
            throw new IOException("Reached maximum cache size (" + this.maxsize + ")");
        }
        try {
            byte[] bArr2 = new byte[bArr.length + i];
            System.arraycopy(bArr, 0, bArr2, 0, this.len);
            this.buf = bArr2;
        } catch (OutOfMemoryError unused) {
            throw new IOException("Out of memory to cache input data");
        }
    }

    private void readInput() throws IOException {
        int i;
        if (this.complete) {
            throw new IllegalArgumentException("Already reached EOF");
        }
        int iAvailable = this.is.available();
        if (iAvailable == 0) {
            iAvailable = 1;
        }
        while (this.len + iAvailable > this.buf.length) {
            growBuffer();
        }
        do {
            i = this.is.read(this.buf, this.len, iAvailable);
            if (i > 0) {
                this.len += i;
                iAvailable -= i;
            }
            if (iAvailable <= 0) {
                break;
            }
        } while (i > 0);
        if (i <= 0) {
            this.complete = true;
            this.is.close();
            this.is = null;
        }
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public void close() throws IOException {
        this.buf = null;
        if (this.complete) {
            return;
        }
        this.is.close();
        this.is = null;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public int getPos() throws IOException {
        return this.pos;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public void seek(int i) throws IOException {
        if (this.complete && i > this.len) {
            throw new EOFException();
        }
        this.pos = i;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public int length() throws IOException {
        while (!this.complete) {
            readInput();
        }
        return this.len;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public int read() throws IOException {
        byte b;
        int i = this.pos;
        if (i < this.len) {
            byte[] bArr = this.buf;
            this.pos = i + 1;
            b = bArr[i];
        } else {
            while (!this.complete && this.pos >= this.len) {
                readInput();
            }
            int i2 = this.pos;
            int i3 = this.len;
            if (i2 == i3) {
                throw new EOFException();
            }
            if (i2 > i3) {
                throw new IOException("Position beyond EOF");
            }
            byte[] bArr2 = this.buf;
            this.pos = i2 + 1;
            b = bArr2[i2];
        }
        return b & 255;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.pos;
        if (i3 + i2 <= this.len) {
            System.arraycopy(this.buf, i3, bArr, i, i2);
            this.pos += i2;
            return;
        }
        while (!this.complete && this.pos + i2 > this.len) {
            readInput();
        }
        int i4 = this.pos;
        if (i4 + i2 > this.len) {
            throw new EOFException();
        }
        System.arraycopy(this.buf, i4, bArr, i, i2);
        this.pos += i2;
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public byte readByte() throws IOException {
        int i = this.pos;
        if (i < this.len) {
            byte[] bArr = this.buf;
            this.pos = i + 1;
            return bArr[i];
        }
        return (byte) read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public int readUnsignedByte() throws IOException {
        int i = this.pos;
        if (i < this.len) {
            byte[] bArr = this.buf;
            this.pos = i + 1;
            return bArr[i] & 255;
        }
        return read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public short readShort() throws IOException {
        int i;
        int i2 = this.pos;
        if (i2 + 1 < this.len) {
            byte[] bArr = this.buf;
            int i3 = i2 + 1;
            this.pos = i3;
            int i4 = bArr[i2] << 8;
            this.pos = i2 + 2;
            i = (bArr[i3] & 255) | i4;
        } else {
            i = (read() << 8) | read();
        }
        return (short) i;
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public int readUnsignedShort() throws IOException {
        int i = this.pos;
        if (i + 1 < this.len) {
            byte[] bArr = this.buf;
            int i2 = i + 1;
            this.pos = i2;
            int i3 = (bArr[i] & 255) << 8;
            this.pos = i + 2;
            return (bArr[i2] & 255) | i3;
        }
        return (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public int readInt() throws IOException {
        int i = this.pos;
        if (i + 3 < this.len) {
            byte[] bArr = this.buf;
            int i2 = i + 1;
            this.pos = i2;
            int i3 = bArr[i] << Ascii.CAN;
            int i4 = i + 2;
            this.pos = i4;
            int i5 = ((bArr[i2] & 255) << 16) | i3;
            int i6 = i + 3;
            this.pos = i6;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            this.pos = i + 4;
            return (bArr[i6] & 255) | i7;
        }
        return (read() << 24) | (read() << 16) | (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public long readUnsignedInt() throws IOException {
        int i;
        int i2 = this.pos;
        if (i2 + 3 < this.len) {
            byte[] bArr = this.buf;
            int i3 = i2 + 1;
            this.pos = i3;
            int i4 = bArr[i2] << Ascii.CAN;
            int i5 = i2 + 2;
            this.pos = i5;
            int i6 = ((bArr[i3] & 255) << 16) | i4;
            int i7 = i2 + 3;
            this.pos = i7;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            this.pos = i2 + 4;
            i = (bArr[i7] & 255) | i8;
        } else {
            i = (read() << 24) | (read() << 16) | (read() << 8) | read();
        }
        return i & 4294967295L;
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public long readLong() throws IOException {
        int i = this.pos;
        if (i + 7 < this.len) {
            byte[] bArr = this.buf;
            this.pos = i + 1;
            this.pos = i + 2;
            long j = (bArr[i] << 56) | ((bArr[r2] & 255) << 48);
            this.pos = i + 3;
            long j2 = ((bArr[r8] & 255) << 40) | j;
            this.pos = i + 4;
            long j3 = j2 | ((bArr[r2] & 255) << 32);
            this.pos = i + 5;
            long j4 = ((bArr[r8] & 255) << 24) | j3;
            this.pos = i + 6;
            long j5 = ((bArr[r2] & 255) << 16) | j4;
            this.pos = i + 7;
            long j6 = j5 | ((bArr[r6] & 255) << 8);
            this.pos = i + 8;
            return (bArr[r4] & 255) | j6;
        }
        return (read() << 56) | (read() << 48) | (read() << 40) | (read() << 32) | (read() << 24) | (read() << 16) | (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public float readFloat() throws IOException {
        int i = this.pos;
        if (i + 3 < this.len) {
            byte[] bArr = this.buf;
            int i2 = i + 1;
            this.pos = i2;
            int i3 = bArr[i] << Ascii.CAN;
            int i4 = i + 2;
            this.pos = i4;
            int i5 = ((bArr[i2] & 255) << 16) | i3;
            int i6 = i + 3;
            this.pos = i6;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            this.pos = i + 4;
            return Float.intBitsToFloat((bArr[i6] & 255) | i7);
        }
        return Float.intBitsToFloat((read() << 24) | (read() << 16) | (read() << 8) | read());
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public double readDouble() throws IOException {
        int i = this.pos;
        if (i + 7 < this.len) {
            byte[] bArr = this.buf;
            this.pos = i + 1;
            this.pos = i + 2;
            long j = (bArr[i] << 56) | ((bArr[r2] & 255) << 48);
            this.pos = i + 3;
            long j2 = ((bArr[r8] & 255) << 40) | j;
            this.pos = i + 4;
            long j3 = j2 | ((bArr[r2] & 255) << 32);
            this.pos = i + 5;
            long j4 = ((bArr[r8] & 255) << 24) | j3;
            this.pos = i + 6;
            long j5 = ((bArr[r2] & 255) << 16) | j4;
            this.pos = i + 7;
            long j6 = j5 | ((bArr[r6] & 255) << 8);
            this.pos = i + 8;
            return Double.longBitsToDouble((bArr[r4] & 255) | j6);
        }
        return Double.longBitsToDouble((read() << 56) | (read() << 48) | (read() << 40) | (read() << 32) | (read() << 24) | (read() << 16) | (read() << 8) | read());
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public int skipBytes(int i) throws IOException {
        if (this.complete && this.pos + i > this.len) {
            throw new EOFException();
        }
        this.pos += i;
        return i;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public void write(int i) throws IOException {
        throw new IOException("read-only");
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void writeByte(int i) throws IOException {
        throw new IOException("read-only");
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void writeShort(int i) throws IOException {
        throw new IOException("read-only");
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void writeInt(int i) throws IOException {
        throw new IOException("read-only");
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void writeLong(long j) throws IOException {
        throw new IOException("read-only");
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void writeFloat(float f) throws IOException {
        throw new IOException("read-only");
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public void writeDouble(double d) throws IOException {
        throw new IOException("read-only");
    }
}
