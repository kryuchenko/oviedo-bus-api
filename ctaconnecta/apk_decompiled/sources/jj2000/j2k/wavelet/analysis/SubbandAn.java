package jj2000.j2k.wavelet.analysis;

import jj2000.j2k.wavelet.Subband;
import jj2000.j2k.wavelet.WaveletFilter;

/* loaded from: classes5.dex */
public class SubbandAn extends Subband {
    public AnWTFilter hFilter;
    public float l2Norm;
    public SubbandAn parent;
    public float stepWMSE;
    public SubbandAn subb_HH;
    public SubbandAn subb_HL;
    public SubbandAn subb_LH;
    public SubbandAn subb_LL;
    public AnWTFilter vFilter;

    public SubbandAn() {
        this.parent = null;
        this.l2Norm = -1.0f;
    }

    public SubbandAn(int i, int i2, int i3, int i4, int i5, WaveletFilter[] waveletFilterArr, WaveletFilter[] waveletFilterArr2) {
        super(i, i2, i3, i4, i5, waveletFilterArr, waveletFilterArr2);
        this.parent = null;
        this.l2Norm = -1.0f;
        calcL2Norms();
    }

    @Override // jj2000.j2k.wavelet.Subband
    public Subband getParent() {
        return this.parent;
    }

    @Override // jj2000.j2k.wavelet.Subband
    public Subband getLL() {
        return this.subb_LL;
    }

    @Override // jj2000.j2k.wavelet.Subband
    public Subband getHL() {
        return this.subb_HL;
    }

    @Override // jj2000.j2k.wavelet.Subband
    public Subband getLH() {
        return this.subb_LH;
    }

    @Override // jj2000.j2k.wavelet.Subband
    public Subband getHH() {
        return this.subb_HH;
    }

    @Override // jj2000.j2k.wavelet.Subband
    protected Subband split(WaveletFilter waveletFilter, WaveletFilter waveletFilter2) {
        if (this.isNode) {
            throw new IllegalArgumentException();
        }
        this.isNode = true;
        this.hFilter = (AnWTFilter) waveletFilter;
        this.vFilter = (AnWTFilter) waveletFilter2;
        this.subb_LL = new SubbandAn();
        this.subb_LH = new SubbandAn();
        this.subb_HL = new SubbandAn();
        SubbandAn subbandAn = new SubbandAn();
        this.subb_HH = subbandAn;
        this.subb_LL.parent = this;
        this.subb_HL.parent = this;
        this.subb_LH.parent = this;
        subbandAn.parent = this;
        initChilds();
        return this.subb_LL;
    }

    private void calcBasisWaveForms(float[][] fArr) {
        if (this.l2Norm < 0.0f) {
            if (this.isNode) {
                SubbandAn subbandAn = this.subb_LL;
                if (subbandAn.l2Norm < 0.0f) {
                    subbandAn.calcBasisWaveForms(fArr);
                    fArr[0] = this.hFilter.getLPSynWaveForm(fArr[0], null);
                    fArr[1] = this.vFilter.getLPSynWaveForm(fArr[1], null);
                    return;
                }
                SubbandAn subbandAn2 = this.subb_HL;
                if (subbandAn2.l2Norm < 0.0f) {
                    subbandAn2.calcBasisWaveForms(fArr);
                    fArr[0] = this.hFilter.getHPSynWaveForm(fArr[0], null);
                    fArr[1] = this.vFilter.getLPSynWaveForm(fArr[1], null);
                    return;
                }
                SubbandAn subbandAn3 = this.subb_LH;
                if (subbandAn3.l2Norm < 0.0f) {
                    subbandAn3.calcBasisWaveForms(fArr);
                    fArr[0] = this.hFilter.getLPSynWaveForm(fArr[0], null);
                    fArr[1] = this.vFilter.getHPSynWaveForm(fArr[1], null);
                    return;
                } else {
                    SubbandAn subbandAn4 = this.subb_HH;
                    if (subbandAn4.l2Norm < 0.0f) {
                        subbandAn4.calcBasisWaveForms(fArr);
                        fArr[0] = this.hFilter.getHPSynWaveForm(fArr[0], null);
                        fArr[1] = this.vFilter.getHPSynWaveForm(fArr[1], null);
                        return;
                    }
                    throw new Error("You have found a bug in JJ2000!");
                }
            }
            fArr[0] = new float[]{1.0f};
            fArr[1] = new float[]{1.0f};
            return;
        }
        throw new Error("You have found a bug in JJ2000!");
    }

    private void assignL2Norm(float f) {
        if (this.l2Norm < 0.0f) {
            if (this.isNode) {
                SubbandAn subbandAn = this.subb_LL;
                if (subbandAn.l2Norm < 0.0f) {
                    subbandAn.assignL2Norm(f);
                    return;
                }
                SubbandAn subbandAn2 = this.subb_HL;
                if (subbandAn2.l2Norm < 0.0f) {
                    subbandAn2.assignL2Norm(f);
                    return;
                }
                SubbandAn subbandAn3 = this.subb_LH;
                if (subbandAn3.l2Norm < 0.0f) {
                    subbandAn3.assignL2Norm(f);
                    return;
                }
                SubbandAn subbandAn4 = this.subb_HH;
                if (subbandAn4.l2Norm < 0.0f) {
                    subbandAn4.assignL2Norm(f);
                    if (this.subb_HH.l2Norm >= 0.0f) {
                        this.l2Norm = 0.0f;
                        return;
                    }
                    return;
                }
                throw new Error("You have found a bug in JJ2000!");
            }
            this.l2Norm = f;
            return;
        }
        throw new Error("You have found a bug in JJ2000!");
    }

    private void calcL2Norms() {
        float[][] fArr = new float[2][];
        while (this.l2Norm < 0.0f) {
            calcBasisWaveForms(fArr);
            double d = 0.0d;
            double d2 = 0.0d;
            for (int length = fArr[0].length - 1; length >= 0; length--) {
                float f = fArr[0][length];
                d2 += f * f;
            }
            float fSqrt = (float) Math.sqrt(d2);
            for (int length2 = fArr[1].length - 1; length2 >= 0; length2--) {
                float f2 = fArr[1][length2];
                d += f2 * f2;
            }
            float fSqrt2 = fSqrt * ((float) Math.sqrt(d));
            fArr[0] = null;
            fArr[1] = null;
            assignL2Norm(fSqrt2);
        }
    }

    @Override // jj2000.j2k.wavelet.Subband
    public WaveletFilter getHorWFilter() {
        return this.hFilter;
    }

    @Override // jj2000.j2k.wavelet.Subband
    public WaveletFilter getVerWFilter() {
        return this.hFilter;
    }
}
