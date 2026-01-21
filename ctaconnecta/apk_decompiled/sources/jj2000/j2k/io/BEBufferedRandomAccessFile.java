package jj2000.j2k.io;

import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public class BEBufferedRandomAccessFile extends BufferedRandomAccessFile implements RandomAccessIO, EndianType {
    public BEBufferedRandomAccessFile(File file, String str, int i) throws IOException {
        super(file, str, i);
        this.byteOrdering = 0;
    }

    public BEBufferedRandomAccessFile(File file, String str) throws IOException {
        super(file, str);
        this.byteOrdering = 0;
    }

    public BEBufferedRandomAccessFile(String str, String str2, int i) throws IOException {
        super(str, str2, i);
        this.byteOrdering = 0;
    }

    public BEBufferedRandomAccessFile(String str, String str2) throws IOException {
        super(str, str2);
        this.byteOrdering = 0;
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void writeShort(int i) throws IOException {
        write(i >>> 8);
        write(i);
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void writeInt(int i) throws IOException {
        write(i >>> 24);
        write(i >>> 16);
        write(i >>> 8);
        write(i);
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void writeLong(long j) throws IOException {
        write((int) (j >>> 56));
        write((int) (j >>> 48));
        write((int) (j >>> 40));
        write((int) (j >>> 32));
        write((int) (j >>> 24));
        write((int) (j >>> 16));
        write((int) (j >>> 8));
        write((int) j);
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void writeFloat(float f) throws IOException {
        int iFloatToIntBits = Float.floatToIntBits(f);
        write(iFloatToIntBits >>> 24);
        write(iFloatToIntBits >>> 16);
        write(iFloatToIntBits >>> 8);
        write(iFloatToIntBits);
    }

    @Override // jj2000.j2k.io.BinaryDataOutput
    public final void writeDouble(double d) throws IOException {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        write((int) (jDoubleToLongBits >>> 56));
        write((int) (jDoubleToLongBits >>> 48));
        write((int) (jDoubleToLongBits >>> 40));
        write((int) (jDoubleToLongBits >>> 32));
        write((int) (jDoubleToLongBits >>> 24));
        write((int) (jDoubleToLongBits >>> 16));
        write((int) (jDoubleToLongBits >>> 8));
        write((int) jDoubleToLongBits);
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final short readShort() throws IOException {
        return (short) ((read() << 8) | read());
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final int readUnsignedShort() throws IOException {
        return (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final int readInt() throws IOException {
        return (read() << 24) | (read() << 16) | (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final long readUnsignedInt() throws IOException {
        return (read() << 24) | (read() << 16) | (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final long readLong() throws IOException {
        return (read() << 56) | (read() << 48) | (read() << 40) | (read() << 32) | (read() << 24) | (read() << 16) | (read() << 8) | read();
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat((read() << 24) | (read() << 16) | (read() << 8) | read());
    }

    @Override // jj2000.j2k.io.BinaryDataInput
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble((read() << 56) | (read() << 48) | (read() << 40) | (read() << 32) | (read() << 24) | (read() << 16) | (read() << 8) | read());
    }

    @Override // jj2000.j2k.io.BufferedRandomAccessFile
    public String toString() {
        return super.toString() + "\nBig-Endian ordering";
    }
}
