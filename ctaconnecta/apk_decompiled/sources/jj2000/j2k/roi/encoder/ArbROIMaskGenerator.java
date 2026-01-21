package jj2000.j2k.roi.encoder;

import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.image.input.ImgReaderPGM;
import jj2000.j2k.quantization.quantizer.Quantizer;
import jj2000.j2k.wavelet.Subband;
import jj2000.j2k.wavelet.WaveletFilter;

/* loaded from: classes5.dex */
public class ArbROIMaskGenerator extends ROIMaskGenerator {
    private int[] maskLineHigh;
    private int[] maskLineLow;
    private int[] paddedMaskLine;
    private boolean roiInTile;
    private int[][] roiMask;
    private Quantizer src;

    public ArbROIMaskGenerator(ROI[] roiArr, int i, Quantizer quantizer) {
        super(roiArr, i);
        this.roiMask = new int[i][];
        this.src = quantizer;
    }

    @Override // jj2000.j2k.roi.encoder.ROIMaskGenerator
    public boolean getROIMask(DataBlkInt dataBlkInt, Subband subband, int i, int i2) {
        int i3 = dataBlkInt.ulx;
        int i4 = dataBlkInt.uly;
        int i5 = dataBlkInt.w;
        int i6 = dataBlkInt.h;
        int i7 = subband.w;
        int i8 = subband.h;
        int[] iArr = (int[]) dataBlkInt.getData();
        if (!this.tileMaskMade[i2]) {
            makeMask(subband, i, i2);
            this.tileMaskMade[i2] = true;
        }
        if (!this.roiInTile) {
            return false;
        }
        int[] iArr2 = this.roiMask[i2];
        int i9 = (((((i4 + i6) - 1) * i7) + i3) + i5) - 1;
        int i10 = (i5 * i6) - 1;
        int i11 = i7 - i5;
        while (i6 > 0) {
            int i12 = i5;
            while (i12 > 0) {
                iArr[i10] = iArr2[i9];
                i12--;
                i9--;
                i10--;
            }
            i9 -= i11;
            i6--;
        }
        return true;
    }

    public String toString() {
        return "Fast rectangular ROI mask generator";
    }

    @Override // jj2000.j2k.roi.encoder.ROIMaskGenerator
    public void makeMask(Subband subband, int i, int i2) {
        ROI[] roiArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ROI[] roiArr2 = this.rois;
        int i8 = subband.ulcx;
        int i9 = subband.ulcy;
        int i10 = subband.w;
        int i11 = subband.h;
        int i12 = i10 > i11 ? i10 : i11;
        int[][] iArr = this.roiMask;
        int[] iArr2 = iArr[i2];
        int i13 = 1;
        if (iArr2 == null || iArr2.length < (i7 = i10 * i11)) {
            iArr2 = new int[i10 * i11];
            iArr[i2] = iArr2;
        } else {
            for (int i14 = i7 - 1; i14 >= 0; i14--) {
                iArr2[i14] = 0;
            }
        }
        int[] iArr3 = this.maskLineLow;
        if (iArr3 == null || iArr3.length < (i12 + 1) / 2) {
            this.maskLineLow = new int[(i12 + 1) / 2];
        }
        int[] iArr4 = this.maskLineHigh;
        if (iArr4 == null || iArr4.length < (i12 + 1) / 2) {
            this.maskLineHigh = new int[(i12 + 1) / 2];
        }
        this.roiInTile = false;
        int length = roiArr2.length - 1;
        while (length >= 0) {
            if (roiArr2[length].comp == i2) {
                if (roiArr2[length].arbShape) {
                    ImgReaderPGM imgReaderPGM = roiArr2[length].maskPGM;
                    if (this.src.getImgWidth() != imgReaderPGM.getImgWidth() || this.src.getImgHeight() != imgReaderPGM.getImgHeight()) {
                        throw new IllegalArgumentException("Input image and ROI mask must have the same size");
                    }
                    int imgULX = this.src.getImgULX();
                    int imgULY = this.src.getImgULY();
                    int imgWidth = (this.src.getImgWidth() + imgULX) - i13;
                    int imgHeight = (this.src.getImgHeight() + imgULY) - 1;
                    roiArr = roiArr2;
                    if (imgULX <= i8 + i10 && imgULY <= i9 + i11 && imgWidth >= i8 && imgHeight >= i9) {
                        int i15 = imgULX - i8;
                        int i16 = imgWidth - i8;
                        int i17 = imgULY - i9;
                        int i18 = imgHeight - i9;
                        if (i15 < 0) {
                            i5 = -i15;
                            i15 = 0;
                        } else {
                            i5 = 0;
                        }
                        if (i17 < 0) {
                            i6 = -i17;
                            i17 = 0;
                        } else {
                            i6 = 0;
                        }
                        i3 = i12;
                        int i19 = i16 > i10 + (-1) ? i10 - i15 : (i16 + 1) - i15;
                        int i20 = i18 > i11 + (-1) ? i11 - i17 : (i18 + 1) - i17;
                        DataBlkInt dataBlkInt = new DataBlkInt();
                        i4 = length;
                        int i21 = -ImgReaderPGM.DC_OFFSET;
                        dataBlkInt.ulx = i5;
                        dataBlkInt.w = i19;
                        dataBlkInt.h = 1;
                        int i22 = (((((i17 + i20) - 1) * i10) + i15) + i19) - 1;
                        int i23 = i10 - i19;
                        int i24 = 0;
                        while (i20 > 0) {
                            dataBlkInt.uly = (i6 + i20) - 1;
                            dataBlkInt = (DataBlkInt) imgReaderPGM.getInternCompData(dataBlkInt, 0);
                            int[] dataInt = dataBlkInt.getDataInt();
                            int i25 = i19;
                            while (i25 > 0) {
                                if (dataInt[i25 - 1] != i21) {
                                    iArr2[i22] = i;
                                    i24++;
                                }
                                i25--;
                                i22--;
                            }
                            i22 -= i23;
                            i20--;
                        }
                        if (i24 != 0) {
                            this.roiInTile = true;
                        }
                    }
                } else {
                    roiArr = roiArr2;
                    i3 = i12;
                    i4 = length;
                    if (roiArr[i4].rect) {
                        int i26 = roiArr[i4].ulx;
                        int i27 = roiArr[i4].uly;
                        int i28 = (roiArr[i4].w + i26) - 1;
                        int i29 = (roiArr[i4].h + i27) - 1;
                        if (i26 <= i8 + i10 && i27 <= i9 + i11 && i28 >= i8 && i29 >= i9) {
                            this.roiInTile = true;
                            int i30 = i26 - i8;
                            int i31 = i28 - i8;
                            int i32 = i27 - i9;
                            int i33 = i29 - i9;
                            if (i30 < 0) {
                                i30 = 0;
                            }
                            if (i32 < 0) {
                                i32 = 0;
                            }
                            int i34 = i31 > i10 + (-1) ? i10 - i30 : (i31 + 1) - i30;
                            int i35 = i33 > i11 + (-1) ? i11 - i32 : (i33 + 1) - i32;
                            int i36 = (((((i32 + i35) - 1) * i10) + i30) + i34) - 1;
                            int i37 = i10 - i34;
                            while (i35 > 0) {
                                int i38 = i34;
                                while (i38 > 0) {
                                    iArr2[i36] = i;
                                    i38--;
                                    i36--;
                                }
                                i36 -= i37;
                                i35--;
                            }
                        }
                    } else {
                        int i39 = roiArr[i4].x - i8;
                        int i40 = roiArr[i4].y - i9;
                        int i41 = roiArr[i4].r;
                        int i42 = (i11 * i10) - 1;
                        for (int i43 = i11 - 1; i43 >= 0; i43--) {
                            int i44 = i10 - 1;
                            while (i44 >= 0) {
                                int i45 = i44 - i39;
                                int i46 = i43 - i40;
                                if ((i45 * i45) + (i46 * i46) < i41 * i41) {
                                    iArr2[i42] = i;
                                    this.roiInTile = true;
                                }
                                i44--;
                                i42--;
                            }
                        }
                    }
                }
                length = i4 - 1;
                roiArr2 = roiArr;
                i12 = i3;
                i13 = 1;
            } else {
                roiArr = roiArr2;
            }
            i3 = i12;
            i4 = length;
            length = i4 - 1;
            roiArr2 = roiArr;
            i12 = i3;
            i13 = 1;
        }
        int i47 = i12;
        if (subband.isNode) {
            WaveletFilter verWFilter = subband.getVerWFilter();
            WaveletFilter horWFilter = subband.getHorWFilter();
            int synLowNegSupport = verWFilter.getSynLowNegSupport() + verWFilter.getSynLowPosSupport();
            int synHighNegSupport = verWFilter.getSynHighNegSupport() + verWFilter.getSynHighPosSupport();
            int synLowNegSupport2 = horWFilter.getSynLowNegSupport() + horWFilter.getSynLowPosSupport();
            int synHighNegSupport2 = horWFilter.getSynHighNegSupport() + horWFilter.getSynHighPosSupport();
            if (synLowNegSupport <= synHighNegSupport) {
                synLowNegSupport = synHighNegSupport;
            }
            if (synLowNegSupport2 <= synHighNegSupport2) {
                synLowNegSupport2 = synHighNegSupport2;
            }
            if (synLowNegSupport <= synLowNegSupport2) {
                synLowNegSupport = synLowNegSupport2;
            }
            this.paddedMaskLine = new int[i47 + synLowNegSupport];
            if (this.roiInTile) {
                decomp(subband, i10, i11, i2);
            }
        }
    }

    private void decomp(Subband subband, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = subband.ulx;
        int i9 = subband.uly;
        int i10 = subband.w;
        int i11 = subband.h;
        int[] iArr = this.roiMask[i3];
        int[] iArr2 = this.maskLineLow;
        int[] iArr3 = this.maskLineHigh;
        int[] iArr4 = this.paddedMaskLine;
        if (subband.isNode) {
            WaveletFilter horWFilter = subband.getHorWFilter();
            int synLowNegSupport = horWFilter.getSynLowNegSupport();
            int synHighNegSupport = horWFilter.getSynHighNegSupport();
            int synLowPosSupport = horWFilter.getSynLowPosSupport();
            int synHighPosSupport = horWFilter.getSynHighPosSupport();
            int i12 = synLowNegSupport + synLowPosSupport + 1;
            int i13 = synHighNegSupport + synHighPosSupport + 1;
            int i14 = subband.ulcx % 2;
            if (subband.w % 2 == 0) {
                i5 = (i10 / 2) - 1;
                i4 = i5;
            } else if (i14 == 0) {
                i5 = ((i10 + 1) / 2) - 1;
                i4 = (i10 / 2) - 1;
            } else {
                i4 = ((i10 + 1) / 2) - 1;
                i5 = (i10 / 2) - 1;
            }
            if (synLowNegSupport <= synHighNegSupport) {
                synLowNegSupport = synHighNegSupport;
            }
            int i15 = synLowPosSupport > synHighPosSupport ? synLowPosSupport : synHighPosSupport;
            for (int i16 = synLowNegSupport - 1; i16 >= 0; i16--) {
                iArr4[i16] = 0;
            }
            for (int i17 = ((synLowNegSupport + i10) - 1) + i15; i17 >= i10; i17--) {
                iArr4[i17] = 0;
            }
            int i18 = i9 + i11;
            int i19 = (((i18 * i) + i8) + i10) - 1;
            int i20 = i11 - 1;
            int i21 = i20;
            while (i21 >= 0) {
                i19 -= i;
                int i22 = (i10 - 1) + synLowNegSupport;
                int i23 = i10;
                int i24 = i19;
                while (i23 > 0) {
                    iArr4[i22] = iArr[i24];
                    i23--;
                    i24--;
                    i22--;
                }
                int i25 = synLowNegSupport + i14 + (i5 * 2) + synLowPosSupport;
                int i26 = i5;
                while (i26 >= 0) {
                    int i27 = synLowPosSupport;
                    int i28 = i12;
                    int i29 = i25;
                    int i30 = 0;
                    while (i28 > 0) {
                        int i31 = i5;
                        int i32 = iArr4[i29];
                        if (i32 > i30) {
                            i30 = i32;
                        }
                        i28--;
                        i29--;
                        i5 = i31;
                    }
                    iArr2[i26] = i30;
                    i26--;
                    i25 -= 2;
                    synLowPosSupport = i27;
                }
                int i33 = synLowPosSupport;
                int i34 = i5;
                int i35 = (synLowNegSupport - i14) + (i4 * 2) + 1 + synHighPosSupport;
                int i36 = i4;
                while (i36 >= 0) {
                    int i37 = i35;
                    int i38 = i37;
                    int i39 = i13;
                    int i40 = 0;
                    while (i39 > 0) {
                        int i41 = i36;
                        int i42 = iArr4[i38];
                        if (i42 > i40) {
                            i40 = i42;
                        }
                        i39--;
                        i38--;
                        i36 = i41;
                    }
                    int i43 = i36;
                    iArr3[i43] = i40;
                    i36 = i43 - 1;
                    i35 = i37 - 2;
                }
                int i44 = i19;
                int i45 = i4;
                while (i45 >= 0) {
                    iArr[i44] = iArr3[i45];
                    i45--;
                    i44--;
                }
                int i46 = i34;
                while (i46 >= 0) {
                    iArr[i44] = iArr2[i46];
                    i46--;
                    i44--;
                }
                i21--;
                synLowPosSupport = i33;
                i5 = i34;
            }
            WaveletFilter verWFilter = subband.getVerWFilter();
            int synLowNegSupport2 = verWFilter.getSynLowNegSupport();
            int synHighNegSupport2 = verWFilter.getSynHighNegSupport();
            int synLowPosSupport2 = verWFilter.getSynLowPosSupport();
            int synHighPosSupport2 = verWFilter.getSynHighPosSupport();
            int i47 = synLowNegSupport2 + synLowPosSupport2 + 1;
            int i48 = synHighNegSupport2 + synHighPosSupport2 + 1;
            int i49 = subband.ulcy % 2;
            if (subband.h % 2 == 0) {
                i7 = (i11 / 2) - 1;
                i6 = i7;
            } else if (subband.ulcy % 2 == 0) {
                i7 = ((i11 + 1) / 2) - 1;
                i6 = (i11 / 2) - 1;
            } else {
                i6 = ((i11 + 1) / 2) - 1;
                i7 = (i11 / 2) - 1;
            }
            if (synLowNegSupport2 <= synHighNegSupport2) {
                synLowNegSupport2 = synHighNegSupport2;
            }
            int i50 = synLowPosSupport2 > synHighPosSupport2 ? synLowPosSupport2 : synHighPosSupport2;
            for (int i51 = synLowNegSupport2 - 1; i51 >= 0; i51--) {
                iArr4[i51] = 0;
            }
            for (int i52 = ((synLowNegSupport2 + i11) - 1) + i50; i52 >= i11; i52--) {
                iArr4[i52] = 0;
            }
            int i53 = ((i18 - 1) * i) + i8 + i10;
            int i54 = i10 - 1;
            while (i54 >= 0) {
                i53--;
                int i55 = i20 + synLowNegSupport2;
                int i56 = i11;
                int i57 = i53;
                while (i56 > 0) {
                    iArr4[i55] = iArr[i57];
                    i56--;
                    i57 -= i;
                    i55--;
                }
                int i58 = synLowNegSupport2 + i49 + (i7 * 2) + synLowPosSupport2;
                int i59 = i7;
                while (i59 >= 0) {
                    int i60 = synHighPosSupport2;
                    int i61 = i58;
                    int i62 = i47;
                    int i63 = 0;
                    while (i62 > 0) {
                        int i64 = synLowNegSupport2;
                        int i65 = iArr4[i61];
                        if (i65 > i63) {
                            i63 = i65;
                        }
                        i62--;
                        i61--;
                        synLowNegSupport2 = i64;
                    }
                    iArr2[i59] = i63;
                    i59--;
                    i58 -= 2;
                    synHighPosSupport2 = i60;
                }
                int i66 = synHighPosSupport2;
                int i67 = synLowNegSupport2;
                int i68 = (i67 - i49) + (i6 * 2) + 1 + i66;
                int i69 = i6;
                while (i69 >= 0) {
                    int i70 = i69;
                    int i71 = i68;
                    int i72 = i48;
                    int i73 = 0;
                    while (i72 > 0) {
                        int i74 = i68;
                        int i75 = iArr4[i71];
                        if (i75 > i73) {
                            i73 = i75;
                        }
                        i72--;
                        i71--;
                        i68 = i74;
                    }
                    iArr3[i70] = i73;
                    i69 = i70 - 1;
                    i68 -= 2;
                }
                int i76 = i53;
                int i77 = i6;
                while (i77 >= 0) {
                    iArr[i76] = iArr3[i77];
                    i77--;
                    i76 -= i;
                }
                int i78 = i7;
                while (i78 >= 0) {
                    iArr[i76] = iArr2[i78];
                    i78--;
                    i76 -= i;
                }
                i54--;
                synHighPosSupport2 = i66;
                synLowNegSupport2 = i67;
            }
            if (subband.isNode) {
                decomp(subband.getHH(), i, i2, i3);
                decomp(subband.getLH(), i, i2, i3);
                decomp(subband.getHL(), i, i2, i3);
                decomp(subband.getLL(), i, i2, i3);
            }
        }
    }
}
