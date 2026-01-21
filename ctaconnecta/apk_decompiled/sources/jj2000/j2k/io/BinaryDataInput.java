package jj2000.j2k.io;

import java.io.IOException;

/* loaded from: classes5.dex */
public interface BinaryDataInput {
    int getByteOrdering();

    byte readByte() throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    int readUnsignedByte() throws IOException;

    long readUnsignedInt() throws IOException;

    int readUnsignedShort() throws IOException;

    int skipBytes(int i) throws IOException;
}
