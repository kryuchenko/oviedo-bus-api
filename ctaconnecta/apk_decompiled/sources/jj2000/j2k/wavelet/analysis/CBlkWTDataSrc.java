package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public interface CBlkWTDataSrc extends ForwWTDataProps {
    int getDataType(int i, int i2);

    int getFixedPoint(int i);

    CBlkWTData getNextCodeBlock(int i, CBlkWTData cBlkWTData);

    CBlkWTData getNextInternCodeBlock(int i, CBlkWTData cBlkWTData);
}
