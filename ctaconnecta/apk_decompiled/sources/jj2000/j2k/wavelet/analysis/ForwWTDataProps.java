package jj2000.j2k.wavelet.analysis;

import jj2000.j2k.image.ImgData;

/* loaded from: classes5.dex */
public interface ForwWTDataProps extends ImgData {
    SubbandAn getAnSubbandTree(int i, int i2);

    int getCbULX();

    int getCbULY();

    boolean isReversible(int i, int i2);
}
