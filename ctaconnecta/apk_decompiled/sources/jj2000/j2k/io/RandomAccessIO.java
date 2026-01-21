package jj2000.j2k.io;

import java.io.IOException;

/* loaded from: classes5.dex */
public interface RandomAccessIO extends BinaryDataInput, BinaryDataOutput {
    void close() throws IOException;

    int getPos() throws IOException;

    int length() throws IOException;

    int read() throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;

    void seek(int i) throws IOException;

    void write(int i) throws IOException;
}
