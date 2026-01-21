package jj2000.j2k.wavelet.synthesis;

import jj2000.j2k.wavelet.Subband;
import jj2000.j2k.wavelet.WaveletFilter;

/* loaded from: classes5.dex */
public class SubbandSyn extends Subband {
    public SynWTFilter hFilter;
    public int magbits;
    private SubbandSyn parent;
    private SubbandSyn subb_HH;
    private SubbandSyn subb_HL;
    private SubbandSyn subb_LH;
    private SubbandSyn subb_LL;
    public SynWTFilter vFilter;

    public SubbandSyn() {
        this.magbits = 0;
    }

    public SubbandSyn(int i, int i2, int i3, int i4, int i5, WaveletFilter[] waveletFilterArr, WaveletFilter[] waveletFilterArr2) {
        super(i, i2, i3, i4, i5, waveletFilterArr, waveletFilterArr2);
        this.magbits = 0;
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
        this.hFilter = (SynWTFilter) waveletFilter;
        this.vFilter = (SynWTFilter) waveletFilter2;
        this.subb_LL = new SubbandSyn();
        this.subb_LH = new SubbandSyn();
        this.subb_HL = new SubbandSyn();
        SubbandSyn subbandSyn = new SubbandSyn();
        this.subb_HH = subbandSyn;
        this.subb_LL.parent = this;
        this.subb_HL.parent = this;
        this.subb_LH.parent = this;
        subbandSyn.parent = this;
        initChilds();
        return this.subb_LL;
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
