package jj2000.j2k.entropy.decoder;

import jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec;
import jj2000.j2k.wavelet.synthesis.MultiResImgDataAdapter;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public abstract class EntropyDecoder extends MultiResImgDataAdapter implements CBlkQuantDataSrcDec {
    public static final char OPT_PREFIX = 'C';
    private static final String[][] pinfo = {new String[]{"Cverber", "[on|off]", "Specifies if the entropy decoder should be verbose about detected errors. If 'on' a message is printed whenever an error is detected.", DebugKt.DEBUG_PROPERTY_VALUE_ON}, new String[]{"Cer", "[on|off]", "Specifies if error detection should be performed by the entropy decoder engine. If errors are detected they will be concealed and the resulting distortion will be less important. Note that errors can only be detected if the encoder that generated the data included error resilience information.", DebugKt.DEBUG_PROPERTY_VALUE_ON}};
    protected CodedCBlkDataSrcDec src;

    public EntropyDecoder(CodedCBlkDataSrcDec codedCBlkDataSrcDec) {
        super(codedCBlkDataSrcDec);
        this.src = codedCBlkDataSrcDec;
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
}
