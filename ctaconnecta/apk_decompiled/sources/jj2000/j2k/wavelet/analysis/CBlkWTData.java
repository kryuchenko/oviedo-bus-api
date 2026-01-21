package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public abstract class CBlkWTData {
    public int h;
    public int m;
    public int magbits;
    public int n;
    public int offset;
    public SubbandAn sb;
    public int scanw;
    public int ulx;
    public int uly;
    public int w;
    public float wmseScaling = 1.0f;
    public double convertFactor = 1.0d;
    public double stepSize = 1.0d;
    public int nROIcoeff = 0;
    public int nROIbp = 0;

    public abstract Object getData();

    public abstract int getDataType();

    public abstract void setData(Object obj);

    public String toString() {
        String str;
        int dataType = getDataType();
        if (dataType == 0) {
            str = "Unsigned Byte";
        } else if (dataType == 1) {
            str = "Short";
        } else if (dataType == 3) {
            str = "Integer";
        } else {
            str = dataType != 4 ? "" : "Float";
        }
        return "ulx=" + this.ulx + ", uly=" + this.uly + ", idx=(" + this.m + "," + this.n + "), w=" + this.w + ", h=" + this.h + ", off=" + this.offset + ", scanw=" + this.scanw + ", wmseScaling=" + this.wmseScaling + ", convertFactor=" + this.convertFactor + ", stepSize=" + this.stepSize + ", type=" + str + ", magbits=" + this.magbits + ", nROIcoeff=" + this.nROIcoeff + ", nROIbp=" + this.nROIbp;
    }
}
