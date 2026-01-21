package jj2000.j2k.io;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public abstract class BufferedRandomAccessFile implements RandomAccessIO, EndianType {
    protected byte[] byteBuffer;
    protected boolean byteBufferChanged;
    protected int byteOrdering;
    private String fileName;
    protected boolean isEOFInBuffer;
    private boolean isReadOnly;
    protected int maxByte;
    protected int offset;
    protected int pos;
    private RandomAccessFile theFile;

    protected BufferedRandomAccessFile(File file, String str, int i) throws IOException {
        this.isReadOnly = true;
        this.fileName = file.getName();
        if (str.equals("rw") || str.equals("rw+")) {
            this.isReadOnly = false;
            if (str.equals("rw") && file.exists()) {
                file.delete();
            }
            str = "rw";
        }
        this.theFile = new RandomAccessFile(file, str);
        this.byteBuffer = new byte[i];
        readNewBuffer(0);
    }

    protected BufferedRandomAccessFile(File file, String str) throws IOException {
        this(file, str, 512);
    }

    protected BufferedRandomAccessFile(String str, String str2, int i) throws IOException {
        this(new File(str), str2, i);
    }

    protected BufferedRandomAccessFile(String str, String str2) throws IOException {
        this(str, str2, 512);
    }

    protected final void readNewBuffer(int i) throws IOException {
        if (this.byteBufferChanged) {
            flush();
        }
        if (this.isReadOnly && i >= this.theFile.length()) {
            throw new EOFException();
        }
        this.offset = i;
        this.theFile.seek(i);
        RandomAccessFile randomAccessFile = this.theFile;
        byte[] bArr = this.byteBuffer;
        int i2 = randomAccessFile.read(bArr, 0, bArr.length);
        this.maxByte = i2;
        this.pos = 0;
        if (i2 < this.byteBuffer.length) {
            this.isEOFInBuffer = true;
            if (i2 == -1) {
                this.maxByte = i2 + 1;
                return;
            }
            return;
        }
        this.isEOFInBuffer = false;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public void close() throws IOException {
        flush();
        this.byteBuffer = null;
        this.theFile.close();
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public int getPos() {
        return this.offset + this.pos;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public int length() throws IOException {
        int length = (int) this.theFile.length();
        int i = this.offset;
        int i2 = this.maxByte;
        return i + i2 <= length ? length : i + i2;
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public void seek(int i) throws IOException {
        int i2 = this.offset;
        if (i >= i2 && i < this.byteBuffer.length + i2) {
            if (this.isReadOnly && this.isEOFInBuffer && i > this.maxByte + i2) {
                throw new EOFException();
            }
            this.pos = i - i2;
            return;
        }
        readNewBuffer(i);
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public final int read() throws IOException {
        int i = this.pos;
        int i2 = this.maxByte;
        if (i < i2) {
            byte[] bArr = this.byteBuffer;
            this.pos = i + 1;
            return bArr[i] & 255;
        }
        if (this.isEOFInBuffer) {
            this.pos = i2 + 1;
            throw new EOFException();
        }
        readNewBuffer(this.offset + i);
        return read();
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int i3 = this.pos;
            int i4 = this.maxByte;
            if (i3 < i4) {
                int i5 = i4 - i3;
                if (i5 > i2) {
                    i5 = i2;
                }
                System.arraycopy(this.byteBuffer, i3, bArr, i, i5);
                this.pos += i5;
                i += i5;
                i2 -= i5;
            } else {
                if (this.isEOFInBuffer) {
                    this.pos = i4 + 1;
                    throw new EOFException();
                }
                readNewBuffer(this.offset + i3);
            }
        }
    }

    @Override // jj2000.j2k.io.RandomAccessIO
    public final void write(int i) throws IOException {
        int i2 = this.pos;
        byte[] bArr = this.byteBuffer;
        if (i2 < bArr.length) {
            if (this.isReadOnly) {
                throw new IOException("File is read only");
            }
            bArr[i2] = (byte) i;
            if (i2 >= this.maxByte) {
                this.maxByte = i2 + 1;
            }
            this.pos = i2 + 1;
            this.byteBufferChanged = true;
            return;
        }
        readNewBuffer(this.offset + i2);
        write(i);
    }

    public final void write(byte b) throws IOException {
        int i = this.pos;
        byte[] bArr = this.byteBuffer;
        if (i < bArr.length) {
            if (this.isReadOnly) {
                throw new IOException("File is read only");
            }
            bArr[i] = b;
            if (i >= this.maxByte) {
                this.maxByte = i + 1;
            }
            this.pos = i + 1;
            this.byteBufferChanged = true;
            return;
        }
        readNewBuffer(this.offset + i);
        write(b);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        if (i3 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException(bArr.length);
        }
        while (i < i3) {
            write(bArr[i]);
            i++;
        }
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void writeByte(int i) throws IOException {
        write(i);
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void flush() throws IOException {
        if (this.byteBufferChanged) {
            this.theFile.seek(this.offset);
            this.theFile.write(this.byteBuffer, 0, this.maxByte);
            this.byteBufferChanged = false;
        }
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final byte readByte() throws IOException {
        int i = this.pos;
        int i2 = this.maxByte;
        if (i < i2) {
            byte[] bArr = this.byteBuffer;
            this.pos = i + 1;
            return bArr[i];
        }
        if (this.isEOFInBuffer) {
            this.pos = i2 + 1;
            throw new EOFException();
        }
        readNewBuffer(this.offset + i);
        return readByte();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final int readUnsignedByte() throws IOException {
        return read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput, jj2000.j2k.io.BinaryDataOutput
    public int getByteOrdering() {
        return this.byteOrdering;
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public int skipBytes(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Can not skip negative number of bytes");
        }
        int i2 = this.maxByte;
        int i3 = this.pos;
        if (i <= i2 - i3) {
            this.pos = i3 + i;
            return i;
        }
        seek(this.offset + i3 + i);
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BufferedRandomAccessFile: ");
        sb.append(this.fileName);
        sb.append(" (");
        sb.append(this.isReadOnly ? "read only" : "read/write");
        sb.append(")");
        return sb.toString();
    }
}
