package jj2000.j2k.entropy.encoder;

import jj2000.j2k.StringSpec;
import jj2000.j2k.entropy.CBlkSizeSpec;
import jj2000.j2k.entropy.PrecinctSizeSpec;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.analysis.SubbandAn;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public abstract class EntropyCoder extends ImgDataAdapter implements CodedCBlkDataSrcEnc, StdEntropyCoderOptions {
    public static final char OPT_PREFIX = 'C';
    private static final String[][] pinfo = {new String[]{"Cblksiz", "[<tile-component idx>] <width> <height> [[<tile-component idx>] <width> <height>]", "Specifies the maximum code-block size to use for tile-component. The maximum width and height is 1024, however the surface area (i.e. width x height) must not exceed 4096. The minimum width and height is 4.", "64 64"}, new String[]{"Cbypass", "[<tile-component idx>] on|off[ [<tile-component idx>] on|off ...]", "Uses the lazy coding mode with the entropy coder. This will bypass the MQ coder for some of the coding passes, where the distribution is often close to uniform. Since the MQ codeword will be terminated at least once per lazy pass, it is important to use an efficient termination algorithm, see the 'Cterm_type' option.'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"CresetMQ", "[<tile-component idx>] on|off[ [<tile-component idx>] on|off ...]", "If this is enabled the probability estimates of the MQ coder are reset after each arithmetically coded (i.e. non-lazy) coding pass. 'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"Cterminate", "[<tile-component idx>] on|off[ [<tile-component idx>] on|off ...]", "If this is enabled the codeword (raw or MQ) is terminated on a byte boundary after each coding pass. In this case it is important to use an efficient termination algorithm, see the 'Cterm' option. 'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"Ccausal", "[<tile-component idx>] on|off[ [<tile-component idx>] on|off ...]", "Uses vertically stripe causal context formation. If this is enabled the context formation process in one stripe is independant of the next stripe (i.e. the one below it). 'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"Cseg_symbol", "[<tile-component idx>] on|off[ [<tile-component idx>] on|off ...]", "Inserts an error resilience segmentation symbol in the MQ codeword at the end of each bit-plane (cleanup pass). Decoders can use this information to detect and conceal errors.'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"Cterm_type", "[<tile-component idx>] near_opt|easy|predict|full[ [<tile-component idx>] near_opt|easy|predict|full ...]", "Specifies the algorithm used to terminate the MQ codeword. The most efficient one is 'near_opt', which delivers a codeword which in almost all cases is the shortest possible. The 'easy' is a simpler algorithm that delivers a codeword length that is close to the previous one (in average 1 bit longer). The 'predict' is almost the same as the 'easy' but it leaves error resilient information on the spare least significant bits (in average 3.5 bits), which can be used by a decoder to detect errors. The 'full' algorithm performs a full flush of the MQ coder and is highly inefficient.\nIt is important to use a good termination policy since the MQ codeword can be terminated quite often, specially if the 'Cbypass' or 'Cterminate' options are enabled (in the normal case it would be terminated once per code-block, while if 'Cterminate' is specified it will be done almost 3 times per bit-plane in each code-block).", "near_opt"}, new String[]{"Clen_calc", "[<tile-component idx>] near_opt|lazy_good|lazy[ [<tile-component idx>] ...]", "Specifies the algorithm to use in calculating the necessary MQ length for each decoding pass. The best one is 'near_opt', which performs a rather sophisticated calculation and provides the best results. The 'lazy_good' and 'lazy' are very simple algorithms that provide rather conservative results, 'lazy_good' one being slightly better. Do not change this option unless you want to experiment the effect of different length calculation algorithms.", "near_opt"}, new String[]{"Cpp", "[<tile-component idx>] <dim> <dim> [<dim> <dim>] [ [<tile-component idx>] ...]", "Specifies precinct partition dimensions for tile-component. The first two values apply to the highest resolution and the following ones (if any) apply to the remaining resolutions in decreasing order. If less values than the number of decomposition levels are specified, then the last two values are used for the remaining resolutions.", null}};
    protected CBlkQuantDataSrcEnc src;

    public abstract int getCBlkHeight(int i, int i2);

    public abstract int getCBlkWidth(int i, int i2);

    public EntropyCoder(CBlkQuantDataSrcEnc cBlkQuantDataSrcEnc) {
        super(cBlkQuantDataSrcEnc);
        this.src = cBlkQuantDataSrcEnc;
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public boolean isReversible(int i, int i2) {
        return this.src.isReversible(i, i2);
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public SubbandAn getAnSubbandTree(int i, int i2) {
        return this.src.getAnSubbandTree(i, i2);
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

    public static EntropyCoder createInstance(CBlkQuantDataSrcEnc cBlkQuantDataSrcEnc, ParameterList parameterList, CBlkSizeSpec cBlkSizeSpec, PrecinctSizeSpec precinctSizeSpec, StringSpec stringSpec, StringSpec stringSpec2, StringSpec stringSpec3, StringSpec stringSpec4, StringSpec stringSpec5, StringSpec stringSpec6, StringSpec stringSpec7) {
        parameterList.checkList('C', ParameterList.toNameArray(pinfo));
        return new StdEntropyCoder(cBlkQuantDataSrcEnc, cBlkSizeSpec, precinctSizeSpec, stringSpec, stringSpec2, stringSpec3, stringSpec4, stringSpec5, stringSpec6, stringSpec7);
    }
}
