package jj2000.j2k.wavelet.synthesis;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.BlkImgDataSrc;

/* loaded from: classes5.dex */
public abstract class InverseWT extends InvWTAdapter implements BlkImgDataSrc {
    public InverseWT(MultiResImgData multiResImgData, DecoderSpecs decoderSpecs) {
        super(multiResImgData, decoderSpecs);
    }

    public static InverseWT createInstance(CBlkWTDataSrcDec cBlkWTDataSrcDec, DecoderSpecs decoderSpecs) {
        return new InvWTFull(cBlkWTDataSrcDec, decoderSpecs);
    }
}
