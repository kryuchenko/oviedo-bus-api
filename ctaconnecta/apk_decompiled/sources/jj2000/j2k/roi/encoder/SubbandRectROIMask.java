package jj2000.j2k.roi.encoder;

import jj2000.j2k.wavelet.Subband;
import jj2000.j2k.wavelet.WaveletFilter;

/* loaded from: classes5.dex */
public class SubbandRectROIMask extends SubbandROIMask {
    public int[] lrxs;
    public int[] lrys;
    public int[] ulxs;
    public int[] ulys;

    public SubbandRectROIMask(Subband subband, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        super(subband.ulx, subband.uly, subband.w, subband.h);
        this.ulxs = iArr;
        this.ulys = iArr2;
        this.lrxs = iArr3;
        this.lrys = iArr4;
        if (subband.isNode) {
            this.isNode = true;
            int i2 = subband.ulcx % 2;
            int i3 = subband.ulcy % 2;
            WaveletFilter horWFilter = subband.getHorWFilter();
            WaveletFilter verWFilter = subband.getVerWFilter();
            int synLowNegSupport = horWFilter.getSynLowNegSupport();
            int synHighNegSupport = horWFilter.getSynHighNegSupport();
            int synLowPosSupport = horWFilter.getSynLowPosSupport();
            int synHighPosSupport = horWFilter.getSynHighPosSupport();
            int synLowNegSupport2 = verWFilter.getSynLowNegSupport();
            int synHighNegSupport2 = verWFilter.getSynHighNegSupport();
            int synLowPosSupport2 = verWFilter.getSynLowPosSupport();
            int synHighPosSupport2 = verWFilter.getSynHighPosSupport();
            int[] iArr5 = new int[i];
            int[] iArr6 = new int[i];
            int[] iArr7 = new int[i];
            int[] iArr8 = new int[i];
            int[] iArr9 = new int[i];
            int[] iArr10 = new int[i];
            int[] iArr11 = new int[i];
            int[] iArr12 = new int[i];
            for (int i4 = i - 1; i4 >= 0; i4--) {
                int i5 = iArr[i4];
                if (i2 == 0) {
                    iArr5[i4] = ((i5 + 1) - synLowNegSupport) / 2;
                    iArr9[i4] = (i5 - synHighNegSupport) / 2;
                } else {
                    iArr5[i4] = (i5 - synLowNegSupport) / 2;
                    iArr9[i4] = ((i5 + 1) - synHighNegSupport) / 2;
                }
                int i6 = iArr2[i4];
                if (i3 == 0) {
                    iArr6[i4] = ((i6 + 1) - synLowNegSupport2) / 2;
                    iArr10[i4] = (i6 - synHighNegSupport2) / 2;
                } else {
                    iArr6[i4] = (i6 - synLowNegSupport2) / 2;
                    iArr10[i4] = ((i6 + 1) - synHighNegSupport2) / 2;
                }
                int i7 = iArr3[i4];
                if (i2 == 0) {
                    iArr7[i4] = (i7 + synLowPosSupport) / 2;
                    iArr11[i4] = ((i7 - 1) + synHighPosSupport) / 2;
                } else {
                    iArr7[i4] = ((i7 - 1) + synLowPosSupport) / 2;
                    iArr11[i4] = (i7 + synHighPosSupport) / 2;
                }
                int i8 = iArr4[i4];
                if (i3 == 0) {
                    iArr8[i4] = (i8 + synLowPosSupport2) / 2;
                    iArr12[i4] = ((i8 - 1) + synHighPosSupport2) / 2;
                } else {
                    iArr8[i4] = ((i8 - 1) + synLowPosSupport2) / 2;
                    iArr12[i4] = (i8 + synHighPosSupport2) / 2;
                }
            }
            this.hh = new SubbandRectROIMask(subband.getHH(), iArr9, iArr10, iArr11, iArr12, i);
            this.lh = new SubbandRectROIMask(subband.getLH(), iArr5, iArr10, iArr7, iArr12, i);
            this.hl = new SubbandRectROIMask(subband.getHL(), iArr9, iArr6, iArr11, iArr8, i);
            this.ll = new SubbandRectROIMask(subband.getLL(), iArr5, iArr6, iArr7, iArr8, i);
        }
    }
}
