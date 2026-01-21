package jj2000.j2k.codestream.writer;

import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class CodestreamWriter {
    protected int maxBytes;
    protected int ndata = 0;

    public abstract void close() throws IOException;

    public abstract void commitBitstreamHeader(HeaderEncoder headerEncoder) throws IOException;

    public abstract int getLength();

    public abstract int getMaxAvailableBytes();

    public abstract int getOffLastROIPkt();

    public abstract int writePacketBody(byte[] bArr, int i, boolean z, boolean z2, int i2) throws IOException;

    public abstract int writePacketHead(byte[] bArr, int i, boolean z, boolean z2, boolean z3) throws IOException;

    protected CodestreamWriter(int i) {
        this.maxBytes = i;
    }
}
