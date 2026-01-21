package jj2000.j2k.codestream.writer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import jj2000.j2k.codestream.Markers;

/* loaded from: classes5.dex */
public class FileCodestreamWriter extends CodestreamWriter implements Markers {
    public static int DEF_BUF_LEN = 1024;
    private static final int SOP_MARKER_LIMIT = 65535;
    byte[] ephMarker;
    private int lenLastNoROI;
    int ndata;
    private int offLastROIPkt;
    private OutputStream out;
    int packetIdx;
    byte[] sopMarker;
    private int tileIdx;

    public FileCodestreamWriter(File file, int i) throws IOException {
        super(i);
        this.tileIdx = 0;
        this.ndata = 0;
        this.packetIdx = 0;
        this.offLastROIPkt = 0;
        this.lenLastNoROI = 0;
        this.out = new BufferedOutputStream(new FileOutputStream(file), DEF_BUF_LEN);
        initSOP_EPHArrays();
    }

    public FileCodestreamWriter(String str, int i) throws IOException {
        super(i);
        this.tileIdx = 0;
        this.ndata = 0;
        this.packetIdx = 0;
        this.offLastROIPkt = 0;
        this.lenLastNoROI = 0;
        this.out = new BufferedOutputStream(new FileOutputStream(str), DEF_BUF_LEN);
        initSOP_EPHArrays();
    }

    public FileCodestreamWriter(OutputStream outputStream, int i) throws IOException {
        super(i);
        this.tileIdx = 0;
        this.ndata = 0;
        this.packetIdx = 0;
        this.offLastROIPkt = 0;
        this.lenLastNoROI = 0;
        this.out = outputStream;
        initSOP_EPHArrays();
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public final int getMaxAvailableBytes() {
        return this.maxBytes - this.ndata;
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public int getLength() {
        if (getMaxAvailableBytes() >= 0) {
            return this.ndata;
        }
        return this.maxBytes;
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public int writePacketHead(byte[] bArr, int i, boolean z, boolean z2, boolean z3) throws IOException {
        int maxAvailableBytes = (z2 ? 6 : 0) + i + (z3 ? 2 : 0);
        if (!z) {
            if (getMaxAvailableBytes() < maxAvailableBytes) {
                maxAvailableBytes = getMaxAvailableBytes();
            }
            if (maxAvailableBytes > 0) {
                if (z2) {
                    byte[] bArr2 = this.sopMarker;
                    int i2 = this.packetIdx;
                    bArr2[4] = (byte) (i2 >> 8);
                    bArr2[5] = (byte) i2;
                    this.out.write(bArr2, 0, 6);
                    int i3 = this.packetIdx + 1;
                    this.packetIdx = i3;
                    if (i3 > 65535) {
                        this.packetIdx = 0;
                    }
                }
                this.out.write(bArr, 0, i);
                this.ndata += maxAvailableBytes;
                if (z3) {
                    this.out.write(this.ephMarker, 0, 2);
                }
                this.lenLastNoROI += maxAvailableBytes;
            }
        }
        return maxAvailableBytes;
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public int writePacketBody(byte[] bArr, int i, boolean z, boolean z2, int i2) throws IOException {
        if (z) {
            return i;
        }
        int maxAvailableBytes = getMaxAvailableBytes() < i ? getMaxAvailableBytes() : i;
        if (i > 0) {
            this.out.write(bArr, 0, maxAvailableBytes);
        }
        this.ndata += maxAvailableBytes;
        if (z2) {
            this.offLastROIPkt += this.lenLastNoROI + i2;
            this.lenLastNoROI = maxAvailableBytes - i2;
            return maxAvailableBytes;
        }
        this.lenLastNoROI += maxAvailableBytes;
        return maxAvailableBytes;
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public void close() throws IOException {
        this.out.write(-1);
        this.out.write(-39);
        this.ndata += 2;
        this.out.close();
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public int getOffLastROIPkt() {
        return this.offLastROIPkt;
    }

    @Override // jj2000.j2k.codestream.writer.CodestreamWriter
    public void commitBitstreamHeader(HeaderEncoder headerEncoder) throws IOException {
        this.ndata += headerEncoder.getLength();
        headerEncoder.writeTo(this.out);
        this.packetIdx = 0;
        this.lenLastNoROI += headerEncoder.getLength();
    }

    private void initSOP_EPHArrays() {
        this.sopMarker = new byte[]{-1, -111, 0, 4, 0, 0};
        this.ephMarker = new byte[]{-1, -110};
    }
}
