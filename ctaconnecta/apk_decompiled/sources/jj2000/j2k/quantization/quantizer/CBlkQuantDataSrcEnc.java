package jj2000.j2k.quantization.quantizer;

import jj2000.j2k.wavelet.analysis.CBlkWTData;
import jj2000.j2k.wavelet.analysis.ForwWTDataProps;

/* loaded from: classes5.dex */
public interface CBlkQuantDataSrcEnc extends ForwWTDataProps {
    CBlkWTData getNextCodeBlock(int i, CBlkWTData cBlkWTData);

    CBlkWTData getNextInternCodeBlock(int i, CBlkWTData cBlkWTData);
}
