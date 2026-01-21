package jj2000.j2k.wavelet.analysis;

import jj2000.j2k.wavelet.WaveletTransform;

/* loaded from: classes5.dex */
public interface ForwWT extends WaveletTransform, ForwWTDataProps {
    int getDecomp(int i, int i2);

    int getDecompLevels(int i, int i2);

    AnWTFilter[] getHorAnWaveletFilters(int i, int i2);

    AnWTFilter[] getVertAnWaveletFilters(int i, int i2);
}
