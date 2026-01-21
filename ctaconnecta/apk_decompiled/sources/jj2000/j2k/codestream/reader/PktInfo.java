package jj2000.j2k.codestream.reader;

/* loaded from: classes5.dex */
public class PktInfo {
    public int cbLength;
    public int cbOff = 0;
    public int layerIdx;
    public int numTruncPnts;
    public int packetIdx;
    public int[] segLengths;

    public PktInfo(int i, int i2) {
        this.layerIdx = i;
        this.packetIdx = i2;
    }

    public String toString() {
        return "packet " + this.packetIdx + " (lay:" + this.layerIdx + ", off:" + this.cbOff + ", len:" + this.cbLength + ", numTruncPnts:" + this.numTruncPnts + ")\n";
    }
}
