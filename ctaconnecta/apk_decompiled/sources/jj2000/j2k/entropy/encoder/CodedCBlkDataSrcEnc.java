package jj2000.j2k.entropy.encoder;

import jj2000.j2k.wavelet.analysis.ForwWTDataProps;

/* loaded from: classes5.dex */
public interface CodedCBlkDataSrcEnc extends ForwWTDataProps {
    CBlkRateDistStats getNextCodeBlock(int i, CBlkRateDistStats cBlkRateDistStats);

    int getPPX(int i, int i2, int i3);

    int getPPY(int i, int i2, int i3);

    boolean precinctPartitionUsed(int i, int i2);
}
