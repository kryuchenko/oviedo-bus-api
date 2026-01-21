package jj2000.j2k.entropy.encoder;

import jj2000.j2k.entropy.CodedCBlk;
import jj2000.j2k.wavelet.analysis.SubbandAn;

/* loaded from: classes5.dex */
public class CBlkRateDistStats extends CodedCBlk {
    public boolean[] isTermPass;
    public int nROIcoeff;
    public int nROIcp;
    public int nTotTrunc;
    public int nVldTrunc;
    public SubbandAn sb;
    public double[] truncDists;
    public int[] truncIdxs;
    public int[] truncRates;
    public float[] truncSlopes;

    public CBlkRateDistStats() {
        this.nROIcoeff = 0;
        this.nROIcp = 0;
    }

    public CBlkRateDistStats(int i, int i2, int i3, byte[] bArr, int[] iArr, double[] dArr, boolean[] zArr, int i4, boolean z) {
        super(i, i2, i3, bArr);
        this.nROIcoeff = 0;
        this.nROIcp = 0;
        selectConvexHull(iArr, dArr, zArr, i4, z);
    }

    public void selectConvexHull(int[] iArr, double[] dArr, boolean[] zArr, int i, boolean z) {
        int i2;
        int i3;
        double d;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (i7 < i && iArr[i7] <= 0) {
            i7++;
        }
        int i8 = i - i7;
        float f = 0.0f;
        loop1: while (true) {
            int i9 = i7;
            int i10 = -1;
            while (i9 < i) {
                int i11 = iArr[i9];
                if (i11 < 0) {
                    i5 = i9;
                } else {
                    if (i10 >= 0) {
                        i4 = i11 - iArr[i10];
                        d = dArr[i9] - dArr[i10];
                    } else {
                        d = dArr[i9];
                        i4 = i11;
                    }
                    if (d < 0.0d || (d == 0.0d && i4 > 0)) {
                        i5 = i9;
                        iArr[i5] = -i11;
                        i8--;
                    } else {
                        i5 = i9;
                        float f2 = (float) (d / i4);
                        if (i10 < 0 || (i4 > 0 && f2 < f)) {
                            f = f2;
                            i10 = i5;
                        }
                    }
                }
                i9 = i5 + 1;
            }
            iArr[i10] = -iArr[i10];
            i8--;
        }
        if (z && i > 0 && (i3 = iArr[i - 1]) < 0) {
            iArr[i2] = -i3;
            i8++;
        }
        this.nTotTrunc = i;
        this.nVldTrunc = i8;
        this.truncRates = new int[i];
        this.truncDists = new double[i];
        this.truncSlopes = new float[i8];
        this.truncIdxs = new int[i8];
        if (zArr != null) {
            boolean[] zArr2 = new boolean[i];
            this.isTermPass = zArr2;
            System.arraycopy(zArr, 0, zArr2, 0, i);
        } else {
            this.isTermPass = null;
        }
        System.arraycopy(iArr, 0, this.truncRates, 0, i);
        int i12 = -1;
        while (i7 < i) {
            int i13 = iArr[i7];
            if (i13 > 0) {
                this.truncDists[i7] = dArr[i7];
                if (i12 < 0) {
                    this.truncSlopes[i6] = (float) (dArr[i7] / i13);
                } else {
                    this.truncSlopes[i6] = (float) ((dArr[i7] - dArr[i12]) / (i13 - iArr[i12]));
                }
                this.truncIdxs[i6] = i7;
                i6++;
                i12 = i7;
            } else {
                this.truncDists[i7] = -1.0d;
                int[] iArr2 = this.truncRates;
                iArr2[i7] = -iArr2[i7];
            }
            i7++;
        }
    }

    @Override // jj2000.j2k.entropy.CodedCBlk
    public String toString() {
        return super.toString() + "\n nVldTrunc=" + this.nVldTrunc + ", nTotTrunc=" + this.nTotTrunc + ", num. ROI coeff=" + this.nROIcoeff + ", num. ROI coding passes=" + this.nROIcp + ", sb=" + this.sb.sbandIdx;
    }
}
