package jj2000.j2k.quantization.quantizer;

import androidx.exifinterface.media.ExifInterface;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.wavelet.analysis.CBlkWTDataSrc;
import jj2000.j2k.wavelet.analysis.SubbandAn;

/* loaded from: classes5.dex */
public abstract class Quantizer extends ImgDataAdapter implements CBlkQuantDataSrcEnc {
    public static final char OPT_PREFIX = 'Q';
    private static final String[][] pinfo = {new String[]{"Qtype", "[<tile-component idx>] <id> [ [<tile-component idx>] <id> ...]", "Specifies which quantization type to use for specified tile-component. The default type is either 'reversible' or 'expounded' depending on whether or not the '-lossless' option  is specified.\n<tile-component idx> : see general note.\n<id>: Supported quantization types specification are : 'reversible' (no quantization), 'derived' (derived quantization step size) and 'expounded'.\nExample: -Qtype reversible or -Qtype t2,4-8 c2 reversible t9 derived.", null}, new String[]{"Qstep", "[<tile-component idx>] <bnss> [ [<tile-component idx>] <bnss> ...]", "This option specifies the base normalized quantization step size (bnss) for tile-components. It is normalized to a dynamic range of 1 in the image domain. This parameter is ignored in reversible coding. The default value is '1/128' (i.e. 0.0078125).", "0.0078125"}, new String[]{"Qguard_bits", "[<tile-component idx>] <gb> [ [<tile-component idx>] <gb> ...]", "The number of bits used for each tile-component in the quantizer to avoid overflow (gb).", ExifInterface.GPS_MEASUREMENT_2D}};
    protected CBlkWTDataSrc src;

    protected abstract void calcSbParams(SubbandAn subbandAn, int i);

    public abstract int getMaxMagBits(int i);

    public abstract int getNumGuardBits(int i, int i2);

    public abstract boolean isDerived(int i, int i2);

    public Quantizer(CBlkWTDataSrc cBlkWTDataSrc) {
        super(cBlkWTDataSrc);
        this.src = cBlkWTDataSrc;
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public SubbandAn getAnSubbandTree(int i, int i2) {
        SubbandAn anSubbandTree = this.src.getAnSubbandTree(i, i2);
        calcSbParams(anSubbandTree, i2);
        return anSubbandTree;
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public int getCbULX() {
        return this.src.getCbULX();
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public int getCbULY() {
        return this.src.getCbULY();
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public static Quantizer createInstance(CBlkWTDataSrc cBlkWTDataSrc, EncoderSpecs encoderSpecs) {
        return new StdQuantizer(cBlkWTDataSrc, encoderSpecs);
    }
}
