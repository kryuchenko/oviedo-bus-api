package jj2000.j2k.wavelet.synthesis;

/* loaded from: classes5.dex */
public interface InvWTData extends MultiResImgData {
    int getCbULX();

    int getCbULY();

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    SubbandSyn getSynSubbandTree(int i, int i2);
}
