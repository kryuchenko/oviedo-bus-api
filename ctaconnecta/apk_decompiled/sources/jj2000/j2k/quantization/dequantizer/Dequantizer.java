package jj2000.j2k.quantization.dequantizer;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.CompTransfSpec;
import jj2000.j2k.image.invcomptransf.InvCompTransf;
import jj2000.j2k.wavelet.synthesis.CBlkWTDataSrcDec;
import jj2000.j2k.wavelet.synthesis.MultiResImgDataAdapter;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;
import jj2000.j2k.wavelet.synthesis.SynWTFilterSpec;

/* loaded from: classes5.dex */
public abstract class Dequantizer extends MultiResImgDataAdapter implements CBlkWTDataSrcDec {
    public static final char OPT_PREFIX = 'Q';
    private static final String[][] pinfo = null;
    private CompTransfSpec cts;
    protected int[] rb;
    protected CBlkQuantDataSrcDec src;
    protected int[] utrb;
    private SynWTFilterSpec wfs;

    static {
    }

    public Dequantizer(CBlkQuantDataSrcDec cBlkQuantDataSrcDec, int[] iArr, DecoderSpecs decoderSpecs) {
        super(cBlkQuantDataSrcDec);
        this.rb = null;
        this.utrb = null;
        if (iArr.length != cBlkQuantDataSrcDec.getNumComps()) {
            throw new IllegalArgumentException();
        }
        this.src = cBlkQuantDataSrcDec;
        this.utrb = iArr;
        this.cts = decoderSpecs.cts;
        this.wfs = decoderSpecs.wfs;
    }

    @Override // jj2000.j2k.wavelet.synthesis.CBlkWTDataSrcDec
    public int getNomRangeBits(int i) {
        return this.rb[i];
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public SubbandSyn getSynSubbandTree(int i, int i2) {
        return this.src.getSynSubbandTree(i, i2);
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData
    public int getCbULX() {
        return this.src.getCbULX();
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData
    public int getCbULY() {
        return this.src.getCbULY();
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgDataAdapter, jj2000.j2k.wavelet.synthesis.MultiResImgData
    public void setTile(int i, int i2) {
        this.src.setTile(i, i2);
        this.tIdx = getTileIdx();
        int i3 = 0;
        if (((Integer) this.cts.getTileDef(this.tIdx)).intValue() != 0) {
            int numComps = this.src.getNumComps() > 3 ? 3 : this.src.getNumComps();
            int i4 = 0;
            while (i3 < numComps) {
                i4 += this.wfs.isReversible(this.tIdx, i3) ? 1 : 0;
                i3++;
            }
            if (i4 == 3) {
                i3 = 1;
            } else {
                if (i4 != 0) {
                    throw new IllegalArgumentException("Wavelet transformation and component transformation not coherent in tile" + this.tIdx);
                }
                i3 = 2;
            }
        }
        if (i3 == 0) {
            this.rb = this.utrb;
            return;
        }
        if (i3 == 1) {
            this.rb = InvCompTransf.calcMixedBitDepths(this.utrb, 1, null);
        } else if (i3 == 2) {
            this.rb = InvCompTransf.calcMixedBitDepths(this.utrb, 2, null);
        } else {
            throw new IllegalArgumentException("Non JPEG 2000 part I component transformation for tile: " + this.tIdx);
        }
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgDataAdapter, jj2000.j2k.wavelet.synthesis.MultiResImgData
    public void nextTile() {
        this.src.nextTile();
        this.tIdx = getTileIdx();
        int iIntValue = ((Integer) this.cts.getTileDef(this.tIdx)).intValue();
        if (iIntValue == 0) {
            this.rb = this.utrb;
            return;
        }
        if (iIntValue == 1) {
            this.rb = InvCompTransf.calcMixedBitDepths(this.utrb, 1, null);
        } else if (iIntValue == 2) {
            this.rb = InvCompTransf.calcMixedBitDepths(this.utrb, 2, null);
        } else {
            throw new IllegalArgumentException("Non JPEG 2000 part I component transformation for tile: " + this.tIdx);
        }
    }
}
