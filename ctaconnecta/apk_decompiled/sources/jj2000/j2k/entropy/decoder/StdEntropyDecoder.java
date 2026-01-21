package jj2000.j2k.entropy.decoder;

import androidx.core.app.FrameMetricsAggregator;
import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;

/* loaded from: classes5.dex */
public class StdEntropyDecoder extends EntropyDecoder implements StdEntropyCoderOptions {
    private static final boolean DO_TIMING = false;
    private static final int INT_SIGN_BIT = Integer.MIN_VALUE;
    private static final int MR_LUT_BITS = 9;
    private static final int MR_MASK = 511;
    private static final int NUM_CTXTS = 19;
    private static final int RLC_CTXT = 1;
    private static final int RLC_MASK_R1R2 = -536813568;
    private static final int SC_LUT_BITS = 9;
    private static final int SC_LUT_MASK = 15;
    private static final int SC_MASK = 511;
    private static final int SC_SHIFT_R1 = 4;
    private static final int SC_SHIFT_R2 = 20;
    private static final int SC_SPRED_SHIFT = 31;
    private static final int SEG_SYMBOL = 10;
    private static final int SIG_MASK_R1R2 = -2147450880;
    private static final int STATE_D_DL_R1 = 2;
    private static final int STATE_D_DL_R2 = 131072;
    private static final int STATE_D_DR_R1 = 1;
    private static final int STATE_D_DR_R2 = 65536;
    private static final int STATE_D_UL_R1 = 8;
    private static final int STATE_D_UL_R2 = 524288;
    private static final int STATE_D_UR_R1 = 4;
    private static final int STATE_D_UR_R2 = 262144;
    private static final int STATE_H_L_R1 = 128;
    private static final int STATE_H_L_R2 = 8388608;
    private static final int STATE_H_L_SIGN_R1 = 4096;
    private static final int STATE_H_L_SIGN_R2 = 268435456;
    private static final int STATE_H_R_R1 = 64;
    private static final int STATE_H_R_R2 = 4194304;
    private static final int STATE_H_R_SIGN_R1 = 2048;
    private static final int STATE_H_R_SIGN_R2 = 134217728;
    private static final int STATE_NZ_CTXT_R1 = 8192;
    private static final int STATE_NZ_CTXT_R2 = 536870912;
    private static final int STATE_PREV_MR_R1 = 256;
    private static final int STATE_PREV_MR_R2 = 16777216;
    private static final int STATE_SEP = 16;
    private static final int STATE_SIG_R1 = 32768;
    private static final int STATE_SIG_R2 = Integer.MIN_VALUE;
    private static final int STATE_VISITED_R1 = 16384;
    private static final int STATE_VISITED_R2 = 1073741824;
    private static final int STATE_V_D_R1 = 16;
    private static final int STATE_V_D_R2 = 1048576;
    private static final int STATE_V_D_SIGN_R1 = 512;
    private static final int STATE_V_D_SIGN_R2 = 33554432;
    private static final int STATE_V_U_R1 = 32;
    private static final int STATE_V_U_R2 = 2097152;
    private static final int STATE_V_U_SIGN_R1 = 1024;
    private static final int STATE_V_U_SIGN_R2 = 67108864;
    private static final int UNIF_CTXT = 0;
    private static final int VSTD_MASK_R1R2 = 1073758208;
    private static final int ZC_LUT_BITS = 8;
    private static final int[] ZC_LUT_LH;
    private static final int ZC_MASK = 255;
    private ByteToBitInput bin;
    private DecoderSpecs decSpec;
    private final boolean doer;
    private int mQuit;
    private MQDecoder mq;
    private int options;
    private DecLyrdCBlk srcblk;
    private final int[] state;
    private long[] time;
    private final boolean verber;
    private static final int[] ZC_LUT_HL = new int[256];
    private static final int[] ZC_LUT_HH = new int[256];
    private static final int[] SC_LUT = new int[512];
    private static final int[] MR_LUT = new int[512];
    private static final int[] MQ_INIT = {46, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static {
        int[] iArr = new int[256];
        ZC_LUT_LH = iArr;
        iArr[0] = 2;
        int i = 1;
        for (int i2 = 1; i2 < 16; i2++) {
            ZC_LUT_LH[i2] = 4;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            ZC_LUT_LH[1 << i3] = 3;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            int[] iArr2 = ZC_LUT_LH;
            iArr2[i4 | 32] = 5;
            iArr2[i4 | 16] = 5;
            iArr2[i4 | 48] = 6;
        }
        int[] iArr3 = ZC_LUT_LH;
        iArr3[128] = 7;
        iArr3[64] = 7;
        for (int i5 = 1; i5 < 16; i5++) {
            int[] iArr4 = ZC_LUT_LH;
            iArr4[i5 | 128] = 8;
            iArr4[i5 | 64] = 8;
        }
        for (int i6 = 1; i6 < 4; i6++) {
            for (int i7 = 0; i7 < 16; i7++) {
                int[] iArr5 = ZC_LUT_LH;
                int i8 = i6 << 4;
                iArr5[i8 | 128 | i7] = 9;
                iArr5[i8 | 64 | i7] = 9;
            }
        }
        for (int i9 = 0; i9 < 64; i9++) {
            ZC_LUT_LH[i9 | 192] = 10;
        }
        ZC_LUT_HL[0] = 2;
        for (int i10 = 1; i10 < 16; i10++) {
            ZC_LUT_HL[i10] = 4;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            ZC_LUT_HL[1 << i11] = 3;
        }
        for (int i12 = 0; i12 < 16; i12++) {
            int[] iArr6 = ZC_LUT_HL;
            iArr6[i12 | 128] = 5;
            iArr6[i12 | 64] = 5;
            iArr6[i12 | 192] = 6;
        }
        int[] iArr7 = ZC_LUT_HL;
        iArr7[32] = 7;
        iArr7[16] = 7;
        for (int i13 = 1; i13 < 16; i13++) {
            int[] iArr8 = ZC_LUT_HL;
            iArr8[i13 | 32] = 8;
            iArr8[i13 | 16] = 8;
        }
        for (int i14 = 1; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 16; i15++) {
                int[] iArr9 = ZC_LUT_HL;
                int i16 = i14 << 6;
                iArr9[i16 | 32 | i15] = 9;
                iArr9[i16 | 16 | i15] = 9;
            }
        }
        for (int i17 = 0; i17 < 4; i17++) {
            for (int i18 = 0; i18 < 16; i18++) {
                ZC_LUT_HL[(i17 << 6) | 48 | i18] = 10;
            }
        }
        int[] iArr10 = {3, 5, 6, 9, 10, 12};
        int[] iArr11 = {1, 2, 4, 8};
        int[] iArr12 = {3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15};
        int[] iArr13 = {7, 11, 13, 14, 15};
        ZC_LUT_HH[0] = 2;
        for (int i19 = 0; i19 < 4; i19++) {
            ZC_LUT_HH[iArr11[i19] << 4] = 3;
        }
        for (int i20 = 0; i20 < 11; i20++) {
            ZC_LUT_HH[iArr12[i20] << 4] = 4;
        }
        for (int i21 = 0; i21 < 4; i21++) {
            ZC_LUT_HH[iArr11[i21]] = 5;
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                ZC_LUT_HH[(iArr11[i22] << 4) | iArr11[i23]] = 6;
            }
        }
        for (int i24 = 0; i24 < 11; i24++) {
            for (int i25 = 0; i25 < 4; i25++) {
                ZC_LUT_HH[(iArr12[i24] << 4) | iArr11[i25]] = 7;
            }
        }
        for (int i26 = 0; i26 < 6; i26++) {
            ZC_LUT_HH[iArr10[i26]] = 8;
        }
        for (int i27 = 0; i27 < 6; i27++) {
            for (int i28 = 1; i28 < 16; i28++) {
                ZC_LUT_HH[(i28 << 4) | iArr10[i27]] = 9;
            }
        }
        for (int i29 = 0; i29 < 16; i29++) {
            for (int i30 = 0; i30 < 5; i30++) {
                ZC_LUT_HH[(i29 << 4) | iArr13[i30]] = 10;
            }
        }
        int[] iArr14 = new int[36];
        iArr14[18] = 15;
        iArr14[17] = 14;
        iArr14[16] = 13;
        iArr14[10] = 12;
        iArr14[9] = 11;
        iArr14[8] = -2147483636;
        iArr14[2] = -2147483635;
        iArr14[1] = -2147483634;
        iArr14[0] = -2147483633;
        for (int i31 = 0; i31 < 511; i31++) {
            int i32 = i31 & 1;
            int i33 = (i31 >> 1) & 1;
            int i34 = (i31 >> 5) & 1;
            int i35 = (i31 >> 6) & 1;
            int i36 = (((i31 >> 3) & 1) * (1 - (((i31 >> 8) & 1) * 2))) + (((i31 >> 2) & 1) * (1 - (((i31 >> 7) & 1) * 2)));
            if (i36 < -1) {
                i36 = -1;
            }
            if (i36 > 1) {
                i36 = 1;
            }
            int i37 = (i33 * (1 - (i35 * 2))) + (i32 * (1 - (i34 * 2)));
            int i38 = i37 >= -1 ? i37 : -1;
            if (i38 > 1) {
                i38 = 1;
            }
            SC_LUT[i31] = iArr14[((i36 + 1) << 3) | (i38 + 1)];
        }
        MR_LUT[0] = 16;
        while (i < 256) {
            MR_LUT[i] = 17;
            i++;
        }
        while (i < 512) {
            MR_LUT[i] = 18;
            i++;
        }
    }

    public StdEntropyDecoder(CodedCBlkDataSrcDec codedCBlkDataSrcDec, DecoderSpecs decoderSpecs, boolean z, boolean z2, int i) {
        super(codedCBlkDataSrcDec);
        this.decSpec = decoderSpecs;
        this.doer = z;
        this.verber = z2;
        this.mQuit = i;
        this.state = new int[(decoderSpecs.cblks.getMaxCBlkWidth() + 2) * (((decoderSpecs.cblks.getMaxCBlkHeight() + 1) / 2) + 2)];
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:70:0x0157
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
    @Override // jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public jj2000.j2k.image.DataBlk getCodeBlock(int r17, int r18, int r19, jj2000.j2k.wavelet.synthesis.SubbandSyn r20, jj2000.j2k.image.DataBlk r21) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jj2000.j2k.entropy.decoder.StdEntropyDecoder.getCodeBlock(int, int, int, jj2000.j2k.wavelet.synthesis.SubbandSyn, jj2000.j2k.image.DataBlk):jj2000.j2k.image.DataBlk");
    }

    @Override // jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec
    public DataBlk getInternCodeBlock(int i, int i2, int i3, SubbandSyn subbandSyn, DataBlk dataBlk) {
        return getCodeBlock(i, i2, i3, subbandSyn, dataBlk);
    }

    private boolean sigProgPass(DataBlk dataBlk, MQDecoder mQDecoder, int i, int[] iArr, int[] iArr2, boolean z) {
        int i2;
        DataBlk dataBlk2 = dataBlk;
        int i3 = dataBlk2.scanw;
        int i4 = dataBlk2.w;
        int i5 = i4 + 2;
        int i6 = ((i5 * 4) / 2) - dataBlk2.w;
        int i7 = (i3 * 4) - dataBlk2.w;
        int i8 = (3 << i) >> 1;
        int[] iArr3 = (int[]) dataBlk2.getData();
        int i9 = (dataBlk2.h + 3) / 4;
        boolean zCheckPredTerm = false;
        boolean z2 = (this.options & 8) != 0;
        int i10 = -i5;
        int i11 = i10 - 1;
        int i12 = i10 + 1;
        int i13 = i4 + 3;
        int i14 = i4 + 1;
        int i15 = dataBlk2.offset;
        int i16 = i9 - 1;
        int i17 = i16;
        int i18 = i13;
        while (i17 >= 0) {
            int i19 = i17 != 0 ? 4 : dataBlk2.h - (i16 * 4);
            int i20 = dataBlk2.w + i15;
            while (i15 < i20) {
                int i21 = iArr[i18];
                int i22 = i3;
                if (((~i21) & (i21 << 2) & SIG_MASK_R1R2) != 0) {
                    i2 = i14;
                    if ((i21 & 40960) == 8192) {
                        if (mQDecoder.decodeSymbol(iArr2[i21 & 255]) != 0) {
                            int i23 = SC_LUT[(i21 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                            int iDecodeSymbol = (i23 >>> 31) ^ mQDecoder.decodeSymbol(i23 & 15);
                            iArr3[i15] = (iDecodeSymbol << 31) | i8;
                            if (!z2) {
                                int i24 = i18 + i11;
                                iArr[i24] = iArr[i24] | 536936448;
                                int i25 = i18 + i12;
                                iArr[i25] = iArr[i25] | 537001984;
                            }
                            if (iDecodeSymbol != 0) {
                                i21 |= 606126080;
                                if (!z2) {
                                    int i26 = i18 - i5;
                                    iArr[i26] = iArr[i26] | 571473920;
                                }
                                int i27 = i18 + 1;
                                iArr[i27] = iArr[i27] | 537407616;
                                int i28 = i18 - 1;
                                iArr[i28] = iArr[i28] | 537143360;
                            } else {
                                i21 |= 539017216;
                                if (!z2) {
                                    int i29 = i18 - i5;
                                    iArr[i29] = iArr[i29] | 537919488;
                                }
                                int i30 = i18 + 1;
                                iArr[i30] = iArr[i30] | 537403520;
                                int i31 = i18 - 1;
                                iArr[i31] = iArr[i31] | 537141312;
                            }
                        } else {
                            i21 |= 16384;
                        }
                    }
                    if (i19 < 2) {
                        iArr[i18] = i21;
                        i15++;
                        i18++;
                        i14 = i2;
                        i3 = i22;
                    } else {
                        if ((i21 & (-1610612736)) == 536870912) {
                            int i32 = i15 + i22;
                            if (mQDecoder.decodeSymbol(iArr2[(i21 >>> 16) & 255]) != 0) {
                                int i33 = i21;
                                int i34 = SC_LUT[(i33 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                int iDecodeSymbol2 = (i34 >>> 31) ^ mQDecoder.decodeSymbol(i34 & 15);
                                iArr3[i32] = (iDecodeSymbol2 << 31) | i8;
                                int i35 = i18 + i2;
                                iArr[i35] = iArr[i35] | 8196;
                                int i36 = i18 + i13;
                                iArr[i36] = iArr[i36] | 8200;
                                if (iDecodeSymbol2 != 0) {
                                    i21 = i33 | (-1073733104);
                                    int i37 = i18 + i5;
                                    iArr[i37] = iArr[i37] | 9248;
                                    int i38 = i18 + 1;
                                    iArr[i38] = iArr[i38] | 813703170;
                                    int i39 = i18 - 1;
                                    iArr[i39] = iArr[i39] | 675291137;
                                } else {
                                    i21 = i33 | (-1073733616);
                                    int i40 = i18 + i5;
                                    iArr[i40] = iArr[i40] | 8224;
                                    int i41 = i18 + 1;
                                    iArr[i41] = iArr[i41] | 545267714;
                                    int i42 = i18 - 1;
                                    iArr[i42] = iArr[i42] | 541073409;
                                }
                            } else {
                                i21 |= 1073741824;
                            }
                        }
                        iArr[i18] = i21;
                    }
                } else {
                    i2 = i14;
                }
                if (i19 >= 3) {
                    int i43 = i18 + i5;
                    int i44 = iArr[i43];
                    if (((~i44) & (i44 << 2) & SIG_MASK_R1R2) != 0) {
                        int i45 = (i22 << 1) + i15;
                        if ((i44 & 40960) == 8192) {
                            if (mQDecoder.decodeSymbol(iArr2[i44 & 255]) != 0) {
                                int i46 = SC_LUT[(i44 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                int iDecodeSymbol3 = (i46 >>> 31) ^ mQDecoder.decodeSymbol(i46 & 15);
                                iArr3[i45] = (iDecodeSymbol3 << 31) | i8;
                                int i47 = i43 + i11;
                                iArr[i47] = iArr[i47] | 536936448;
                                int i48 = i43 + i12;
                                iArr[i48] = iArr[i48] | 537001984;
                                if (iDecodeSymbol3 != 0) {
                                    i44 |= 606126080;
                                    int i49 = i43 - i5;
                                    iArr[i49] = iArr[i49] | 571473920;
                                    int i50 = i43 + 1;
                                    iArr[i50] = iArr[i50] | 537407616;
                                    int i51 = i43 - 1;
                                    iArr[i51] = iArr[i51] | 537143360;
                                } else {
                                    i44 |= 539017216;
                                    int i52 = i43 - i5;
                                    iArr[i52] = iArr[i52] | 537919488;
                                    int i53 = i43 + 1;
                                    iArr[i53] = iArr[i53] | 537403520;
                                    int i54 = i43 - 1;
                                    iArr[i54] = iArr[i54] | 537141312;
                                }
                            } else {
                                i44 |= 16384;
                            }
                        }
                        if (i19 < 4) {
                            iArr[i43] = i44;
                        } else {
                            if ((i44 & (-1610612736)) == 536870912) {
                                int i55 = i45 + i22;
                                if (mQDecoder.decodeSymbol(iArr2[(i44 >>> 16) & 255]) != 0) {
                                    int i56 = SC_LUT[(i44 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                    int iDecodeSymbol4 = (i56 >>> 31) ^ mQDecoder.decodeSymbol(i56 & 15);
                                    iArr3[i55] = (iDecodeSymbol4 << 31) | i8;
                                    int i57 = i43 + i2;
                                    iArr[i57] = iArr[i57] | 8196;
                                    int i58 = i43 + i13;
                                    iArr[i58] = iArr[i58] | 8200;
                                    if (iDecodeSymbol4 != 0) {
                                        i44 |= -1073733104;
                                        int i59 = i43 + i5;
                                        iArr[i59] = iArr[i59] | 9248;
                                        int i60 = i43 + 1;
                                        iArr[i60] = iArr[i60] | 813703170;
                                        int i61 = i43 - 1;
                                        iArr[i61] = iArr[i61] | 675291137;
                                    } else {
                                        i44 |= -1073733616;
                                        int i62 = i43 + i5;
                                        iArr[i62] = iArr[i62] | 8224;
                                        int i63 = i43 + 1;
                                        iArr[i63] = iArr[i63] | 545267714;
                                        int i64 = i43 - 1;
                                        iArr[i64] = iArr[i64] | 541073409;
                                    }
                                } else {
                                    i44 |= 1073741824;
                                }
                            }
                            iArr[i43] = i44;
                        }
                    }
                }
                i15++;
                i18++;
                i14 = i2;
                i3 = i22;
            }
            i17--;
            i15 += i7;
            i18 += i6;
            dataBlk2 = dataBlk;
        }
        if (z && (this.options & 16) != 0) {
            zCheckPredTerm = mQDecoder.checkPredTerm();
        }
        if ((this.options & 2) != 0) {
            mQDecoder.resetCtxts();
        }
        return zCheckPredTerm;
    }

    private boolean rawSigProgPass(DataBlk dataBlk, ByteToBitInput byteToBitInput, int i, int[] iArr, boolean z) {
        int i2;
        DataBlk dataBlk2 = dataBlk;
        int i3 = dataBlk2.scanw;
        int i4 = dataBlk2.w;
        int i5 = i4 + 2;
        int i6 = ((i5 * 4) / 2) - dataBlk2.w;
        int i7 = (i3 * 4) - dataBlk2.w;
        int i8 = (3 << i) >> 1;
        int[] iArr2 = (int[]) dataBlk2.getData();
        int i9 = 4;
        int i10 = (dataBlk2.h + 3) / 4;
        boolean z2 = (this.options & 8) != 0;
        int i11 = -i5;
        int i12 = i11 - 1;
        int i13 = i11 + 1;
        int i14 = i4 + 3;
        int i15 = i4 + 1;
        int i16 = dataBlk2.offset;
        int i17 = i10 - 1;
        int i18 = i17;
        int i19 = i14;
        while (i18 >= 0) {
            if (i18 == 0) {
                i9 = dataBlk2.h - (i17 * 4);
            }
            int i20 = dataBlk2.w + i16;
            while (i16 < i20) {
                int i21 = iArr[i19];
                if (((~i21) & (i21 << 2) & SIG_MASK_R1R2) != 0) {
                    i2 = i3;
                    if ((i21 & 40960) == 8192) {
                        if (byteToBitInput.readBit() != 0) {
                            int bit = byteToBitInput.readBit();
                            iArr2[i16] = (bit << 31) | i8;
                            if (!z2) {
                                int i22 = i19 + i12;
                                iArr[i22] = iArr[i22] | 536936448;
                                int i23 = i19 + i13;
                                iArr[i23] = iArr[i23] | 537001984;
                            }
                            if (bit != 0) {
                                i21 |= 606126080;
                                if (!z2) {
                                    int i24 = i19 - i5;
                                    iArr[i24] = iArr[i24] | 571473920;
                                }
                                int i25 = i19 + 1;
                                iArr[i25] = iArr[i25] | 537407616;
                                int i26 = i19 - 1;
                                iArr[i26] = iArr[i26] | 537143360;
                            } else {
                                i21 |= 539017216;
                                if (!z2) {
                                    int i27 = i19 - i5;
                                    iArr[i27] = iArr[i27] | 537919488;
                                }
                                int i28 = i19 + 1;
                                iArr[i28] = iArr[i28] | 537403520;
                                int i29 = i19 - 1;
                                iArr[i29] = iArr[i29] | 537141312;
                            }
                        } else {
                            i21 |= 16384;
                        }
                    }
                    if (i9 < 2) {
                        iArr[i19] = i21;
                        i16++;
                        i19++;
                        i3 = i2;
                    } else {
                        if ((i21 & (-1610612736)) == 536870912) {
                            int i30 = i16 + i2;
                            if (byteToBitInput.readBit() != 0) {
                                int bit2 = byteToBitInput.readBit();
                                iArr2[i30] = (bit2 << 31) | i8;
                                int i31 = i19 + i15;
                                iArr[i31] = iArr[i31] | 8196;
                                int i32 = i19 + i14;
                                iArr[i32] = iArr[i32] | 8200;
                                if (bit2 != 0) {
                                    i21 |= -1073733104;
                                    int i33 = i19 + i5;
                                    iArr[i33] = iArr[i33] | 9248;
                                    int i34 = i19 + 1;
                                    iArr[i34] = iArr[i34] | 813703170;
                                    int i35 = i19 - 1;
                                    iArr[i35] = iArr[i35] | 675291137;
                                } else {
                                    i21 |= -1073733616;
                                    int i36 = i19 + i5;
                                    iArr[i36] = iArr[i36] | 8224;
                                    int i37 = i19 + 1;
                                    iArr[i37] = iArr[i37] | 545267714;
                                    int i38 = i19 - 1;
                                    iArr[i38] = iArr[i38] | 541073409;
                                }
                            } else {
                                i21 |= 1073741824;
                            }
                        }
                        iArr[i19] = i21;
                    }
                } else {
                    i2 = i3;
                }
                if (i9 >= 3) {
                    int i39 = i19 + i5;
                    int i40 = iArr[i39];
                    if (((~i40) & (i40 << 2) & SIG_MASK_R1R2) != 0) {
                        int i41 = (i2 << 1) + i16;
                        if ((i40 & 40960) == 8192) {
                            if (byteToBitInput.readBit() != 0) {
                                int bit3 = byteToBitInput.readBit();
                                iArr2[i41] = (bit3 << 31) | i8;
                                int i42 = i39 + i12;
                                iArr[i42] = iArr[i42] | 536936448;
                                int i43 = i39 + i13;
                                iArr[i43] = iArr[i43] | 537001984;
                                if (bit3 != 0) {
                                    i40 |= 606126080;
                                    int i44 = i39 - i5;
                                    iArr[i44] = iArr[i44] | 571473920;
                                    int i45 = i39 + 1;
                                    iArr[i45] = iArr[i45] | 537407616;
                                    int i46 = i39 - 1;
                                    iArr[i46] = iArr[i46] | 537143360;
                                } else {
                                    i40 |= 539017216;
                                    int i47 = i39 - i5;
                                    iArr[i47] = iArr[i47] | 537919488;
                                    int i48 = i39 + 1;
                                    iArr[i48] = iArr[i48] | 537403520;
                                    int i49 = i39 - 1;
                                    iArr[i49] = iArr[i49] | 537141312;
                                }
                            } else {
                                i40 |= 16384;
                            }
                        }
                        if (i9 < 4) {
                            iArr[i39] = i40;
                        } else {
                            if ((i40 & (-1610612736)) == 536870912) {
                                int i50 = i41 + i2;
                                if (byteToBitInput.readBit() != 0) {
                                    int bit4 = byteToBitInput.readBit();
                                    iArr2[i50] = (bit4 << 31) | i8;
                                    int i51 = i39 + i15;
                                    iArr[i51] = iArr[i51] | 8196;
                                    int i52 = i39 + i14;
                                    iArr[i52] = iArr[i52] | 8200;
                                    if (bit4 != 0) {
                                        i40 |= -1073733104;
                                        int i53 = i39 + i5;
                                        iArr[i53] = iArr[i53] | 9248;
                                        int i54 = i39 + 1;
                                        iArr[i54] = iArr[i54] | 813703170;
                                        int i55 = i39 - 1;
                                        iArr[i55] = iArr[i55] | 675291137;
                                    } else {
                                        i40 |= -1073733616;
                                        int i56 = i39 + i5;
                                        iArr[i56] = iArr[i56] | 8224;
                                        int i57 = i39 + 1;
                                        iArr[i57] = iArr[i57] | 545267714;
                                        int i58 = i39 - 1;
                                        iArr[i58] = iArr[i58] | 541073409;
                                    }
                                } else {
                                    i40 |= 1073741824;
                                }
                            }
                            iArr[i39] = i40;
                        }
                    }
                }
                i16++;
                i19++;
                i3 = i2;
            }
            i18--;
            i16 += i7;
            i19 += i6;
            dataBlk2 = dataBlk;
            i9 = 4;
        }
        if (!z || (this.options & 16) == 0) {
            return false;
        }
        return byteToBitInput.checkBytePadding();
    }

    private boolean magRefPass(DataBlk dataBlk, MQDecoder mQDecoder, int i, int[] iArr, boolean z) {
        int i2;
        DataBlk dataBlk2 = dataBlk;
        int i3 = dataBlk2.scanw;
        int i4 = dataBlk2.w;
        int i5 = i4 + 2;
        int i6 = ((i5 * 4) / 2) - dataBlk2.w;
        int i7 = (i3 * 4) - dataBlk2.w;
        int i8 = (1 << i) >> 1;
        int i9 = (-1) << (i + 1);
        int[] iArr2 = (int[]) dataBlk2.getData();
        int i10 = 4;
        int i11 = (dataBlk2.h + 3) / 4;
        int i12 = dataBlk2.offset;
        int i13 = i4 + 3;
        int i14 = i11 - 1;
        int i15 = i14;
        while (i15 >= 0) {
            if (i15 == 0) {
                i10 = dataBlk2.h - (i14 * 4);
            }
            int i16 = dataBlk2.w + i12;
            while (i12 < i16) {
                int i17 = iArr[i13];
                if (((i17 >>> 1) & (~i17) & VSTD_MASK_R1R2) != 0) {
                    i2 = i3;
                    if ((i17 & 49152) == 32768) {
                        int iDecodeSymbol = mQDecoder.decodeSymbol(MR_LUT[i17 & FrameMetricsAggregator.EVERY_DURATION]);
                        int i18 = iArr2[i12] & i9;
                        iArr2[i12] = i18;
                        iArr2[i12] = (iDecodeSymbol << i) | i8 | i18;
                        i17 |= 256;
                    }
                    if (i10 < 2) {
                        iArr[i13] = i17;
                        i12++;
                        i13++;
                        i3 = i2;
                    } else {
                        if ((i17 & (-1073741824)) == Integer.MIN_VALUE) {
                            int i19 = i12 + i2;
                            int iDecodeSymbol2 = mQDecoder.decodeSymbol(MR_LUT[(i17 >>> 16) & FrameMetricsAggregator.EVERY_DURATION]);
                            int i20 = iArr2[i19] & i9;
                            iArr2[i19] = i20;
                            iArr2[i19] = i20 | (iDecodeSymbol2 << i) | i8;
                            i17 |= 16777216;
                        }
                        iArr[i13] = i17;
                    }
                } else {
                    i2 = i3;
                }
                if (i10 >= 3) {
                    int i21 = i13 + i5;
                    int i22 = iArr[i21];
                    if (((i22 >>> 1) & (~i22) & VSTD_MASK_R1R2) != 0) {
                        int i23 = (i2 << 1) + i12;
                        if ((i22 & 49152) == 32768) {
                            int iDecodeSymbol3 = mQDecoder.decodeSymbol(MR_LUT[i22 & FrameMetricsAggregator.EVERY_DURATION]);
                            int i24 = iArr2[i23] & i9;
                            iArr2[i23] = i24;
                            iArr2[i23] = (iDecodeSymbol3 << i) | i8 | i24;
                            i22 |= 256;
                        }
                        if (i10 < 4) {
                            iArr[i21] = i22;
                        } else {
                            if ((iArr[i21] & (-1073741824)) == Integer.MIN_VALUE) {
                                int i25 = i23 + i2;
                                int iDecodeSymbol4 = mQDecoder.decodeSymbol(MR_LUT[(i22 >>> 16) & FrameMetricsAggregator.EVERY_DURATION]);
                                int i26 = iArr2[i25] & i9;
                                iArr2[i25] = i26;
                                iArr2[i25] = (iDecodeSymbol4 << i) | i8 | i26;
                                i22 |= 16777216;
                            }
                            iArr[i21] = i22;
                        }
                    }
                }
                i12++;
                i13++;
                i3 = i2;
            }
            i15--;
            i12 += i7;
            i13 += i6;
            dataBlk2 = dataBlk;
            i10 = 4;
        }
        boolean zCheckPredTerm = (!z || (this.options & 16) == 0) ? false : mQDecoder.checkPredTerm();
        if ((this.options & 2) != 0) {
            mQDecoder.resetCtxts();
        }
        return zCheckPredTerm;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean rawMagRefPass(DataBlk dataBlk, ByteToBitInput byteToBitInput, int i, int[] iArr, boolean z) {
        DataBlk dataBlk2 = dataBlk;
        int i2 = dataBlk2.scanw;
        int i3 = dataBlk2.w;
        int i4 = i3 + 2;
        int i5 = ((i4 * 4) / 2) - dataBlk2.w;
        int i6 = (i2 * 4) - dataBlk2.w;
        int i7 = (1 << i) >> 1;
        int i8 = (-1) << (i + 1);
        int[] iArr2 = (int[]) dataBlk2.getData();
        int i9 = (dataBlk2.h + 3) / 4;
        int i10 = dataBlk2.offset;
        int i11 = i3 + 3;
        int i12 = i9 - 1;
        int i13 = i12;
        while (i13 >= 0) {
            int i14 = i13 != 0 ? 4 : dataBlk2.h - (i12 * 4);
            int i15 = dataBlk2.w + i10;
            while (i10 < i15) {
                int i16 = iArr[i11];
                if (((i16 >>> 1) & (~i16) & VSTD_MASK_R1R2) != 0) {
                    if ((i16 & 49152) == 32768) {
                        int bit = byteToBitInput.readBit();
                        int i17 = iArr2[i10] & i8;
                        iArr2[i10] = i17;
                        iArr2[i10] = i17 | (bit << i) | i7;
                    }
                    if (i14 >= 2) {
                        if ((i16 & (-1073741824)) == Integer.MIN_VALUE) {
                            int i18 = i10 + i2;
                            int bit2 = byteToBitInput.readBit();
                            int i19 = iArr2[i18] & i8;
                            iArr2[i18] = i19;
                            iArr2[i18] = i19 | (bit2 << i) | i7;
                        }
                        if (i14 < 3) {
                        }
                    }
                } else if (i14 < 3) {
                    int i20 = i11 + i4;
                    int i21 = iArr[i20];
                    if (((i21 >>> 1) & (~i21) & VSTD_MASK_R1R2) != 0) {
                        int i22 = (i2 << 1) + i10;
                        if ((i21 & 49152) == 32768) {
                            int bit3 = byteToBitInput.readBit();
                            int i23 = iArr2[i22] & i8;
                            iArr2[i22] = i23;
                            iArr2[i22] = (bit3 << i) | i7 | i23;
                        }
                        if (i14 >= 4 && (iArr[i20] & (-1073741824)) == Integer.MIN_VALUE) {
                            int i24 = i22 + i2;
                            int bit4 = byteToBitInput.readBit();
                            int i25 = iArr2[i24] & i8;
                            iArr2[i24] = i25;
                            iArr2[i24] = i25 | (bit4 << i) | i7;
                        }
                    }
                }
                i10++;
                i11++;
            }
            i13--;
            i10 += i6;
            i11 += i5;
            dataBlk2 = dataBlk;
        }
        if (!z || (this.options & 16) == 0) {
            return false;
        }
        return byteToBitInput.checkBytePadding();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x03f0 A[PHI: r3
      0x03f0: PHI (r3v12 int) = (r3v11 int), (r3v13 int), (r3v13 int), (r3v14 int), (r3v15 int) binds: [B:98:0x02e8, B:112:0x036b, B:114:0x0379, B:118:0x03ce, B:117:0x03ab] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean cleanuppass(DataBlk dataBlk, MQDecoder mQDecoder, int i, int[] iArr, int[] iArr2, boolean z) {
        boolean zCheckPredTerm;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        DataBlk dataBlk2 = dataBlk;
        int i10 = dataBlk2.scanw;
        int i11 = dataBlk2.w;
        int i12 = i11 + 2;
        int i13 = ((i12 * 4) / 2) - dataBlk2.w;
        int i14 = (i10 * 4) - dataBlk2.w;
        int i15 = 1 << i;
        int i16 = i15 | (i15 >> 1);
        int[] iArr3 = (int[]) dataBlk2.getData();
        int i17 = (dataBlk2.h + 3) / 4;
        boolean z3 = (this.options & 8) != 0;
        int i18 = -i12;
        int i19 = i18 - 1;
        int i20 = i18 + 1;
        int i21 = i11 + 3;
        int i22 = i11 + 1;
        int i23 = dataBlk2.offset;
        int i24 = i17 - 1;
        int i25 = i24;
        int i26 = i21;
        while (i25 >= 0) {
            int i27 = i25 != 0 ? 4 : dataBlk2.h - (i24 * 4);
            int i28 = dataBlk2.w + i23;
            while (i23 < i28) {
                int i29 = iArr[i26];
                if (i29 == 0) {
                    int i30 = i26 + i12;
                    if (iArr[i30] == 0 && i27 == 4) {
                        if (mQDecoder.decodeSymbol(1) != 0) {
                            int iDecodeSymbol = (mQDecoder.decodeSymbol(0) << 1) | mQDecoder.decodeSymbol(0);
                            int i31 = i23 + (iDecodeSymbol * i10);
                            i2 = i10;
                            if (iDecodeSymbol > 1) {
                                i29 = iArr[i30];
                            } else {
                                i30 = i26;
                            }
                            if ((iDecodeSymbol & 1) == 0) {
                                int i32 = SC_LUT[(i29 >> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                int iDecodeSymbol2 = (i32 >>> 31) ^ mQDecoder.decodeSymbol(i32 & 15);
                                iArr3[i31] = (iDecodeSymbol2 << 31) | i16;
                                if (iDecodeSymbol != 0 || !z3) {
                                    int i33 = i30 + i19;
                                    iArr[i33] = iArr[i33] | 536936448;
                                    int i34 = i30 + i20;
                                    iArr[i34] = iArr[i34] | 537001984;
                                }
                                if (iDecodeSymbol2 != 0) {
                                    i9 = i29 | 606126080;
                                    if (iDecodeSymbol != 0 || !z3) {
                                        int i35 = i30 - i12;
                                        iArr[i35] = iArr[i35] | 571473920;
                                    }
                                    int i36 = i30 + 1;
                                    iArr[i36] = iArr[i36] | 537407616;
                                    int i37 = i30 - 1;
                                    iArr[i37] = iArr[i37] | 537143360;
                                } else {
                                    i9 = i29 | 539017216;
                                    if (iDecodeSymbol != 0 || !z3) {
                                        int i38 = i30 - i12;
                                        iArr[i38] = iArr[i38] | 537919488;
                                    }
                                    int i39 = i30 + 1;
                                    iArr[i39] = iArr[i39] | 537403520;
                                    int i40 = i30 - 1;
                                    iArr[i40] = iArr[i40] | 537141312;
                                }
                                i3 = i9;
                                if ((iDecodeSymbol >> 1) != 0) {
                                }
                                if (z2) {
                                    i4 = i22;
                                    i5 = VSTD_MASK_R1R2;
                                } else {
                                    i4 = i22;
                                    if ((((i3 >> 1) | i3) & VSTD_MASK_R1R2) != VSTD_MASK_R1R2) {
                                        if ((49152 & i3) != 0 || mQDecoder.decodeSymbol(iArr2[i3 & 255]) == 0) {
                                            i5 = VSTD_MASK_R1R2;
                                        } else {
                                            int[] iArr4 = SC_LUT;
                                            i5 = VSTD_MASK_R1R2;
                                            int i41 = iArr4[(i3 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                            int iDecodeSymbol3 = (i41 >>> 31) ^ mQDecoder.decodeSymbol(i41 & 15);
                                            iArr3[i23] = (iDecodeSymbol3 << 31) | i16;
                                            if (!z3) {
                                                int i42 = i30 + i19;
                                                iArr[i42] = iArr[i42] | 536936448;
                                                int i43 = i30 + i20;
                                                iArr[i43] = iArr[i43] | 537001984;
                                            }
                                            if (iDecodeSymbol3 != 0) {
                                                i7 = i3 | 606126080;
                                                if (!z3) {
                                                    int i44 = i30 - i12;
                                                    iArr[i44] = iArr[i44] | 571473920;
                                                }
                                                int i45 = i30 + 1;
                                                iArr[i45] = iArr[i45] | 537407616;
                                                int i46 = i30 - 1;
                                                iArr[i46] = iArr[i46] | 537143360;
                                            } else {
                                                i7 = i3 | 539017216;
                                                if (!z3) {
                                                    int i47 = i30 - i12;
                                                    iArr[i47] = iArr[i47] | 537919488;
                                                }
                                                int i48 = i30 + 1;
                                                iArr[i48] = iArr[i48] | 537403520;
                                                int i49 = i30 - 1;
                                                iArr[i49] = iArr[i49] | 537141312;
                                            }
                                            i3 = i7;
                                        }
                                        if (i27 < 2) {
                                            iArr[i30] = i3 & (-1073758209);
                                        } else if (((-1073741824) & i3) == 0) {
                                            int i50 = i23 + i2;
                                            if (mQDecoder.decodeSymbol(iArr2[(i3 >>> 16) & 255]) != 0) {
                                                int i51 = SC_LUT[(i3 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                                int iDecodeSymbol4 = (i51 >>> 31) ^ mQDecoder.decodeSymbol(i51 & 15);
                                                iArr3[i50] = (iDecodeSymbol4 << 31) | i16;
                                                int i52 = i30 + i4;
                                                iArr[i52] = iArr[i52] | 8196;
                                                int i53 = i30 + i21;
                                                iArr[i53] = iArr[i53] | 8200;
                                                if (iDecodeSymbol4 != 0) {
                                                    i3 |= -1073733104;
                                                    int i54 = i30 + i12;
                                                    iArr[i54] = iArr[i54] | 9248;
                                                    int i55 = i30 + 1;
                                                    iArr[i55] = iArr[i55] | 813703170;
                                                    int i56 = i30 - 1;
                                                    iArr[i56] = iArr[i56] | 675291137;
                                                } else {
                                                    i3 |= -1073733616;
                                                    int i57 = i30 + i12;
                                                    iArr[i57] = iArr[i57] | 8224;
                                                    int i58 = i30 + 1;
                                                    iArr[i58] = iArr[i58] | 545267714;
                                                    int i59 = i30 - 1;
                                                    iArr[i59] = iArr[i59] | 541073409;
                                                }
                                            }
                                        }
                                    } else {
                                        i5 = VSTD_MASK_R1R2;
                                    }
                                    iArr[i30] = i3 & (-1073758209);
                                    if (i27 >= 3) {
                                        i30 += i12;
                                        i3 = iArr[i30];
                                    }
                                }
                                if ((((i3 >> 1) | i3) & i5) != VSTD_MASK_R1R2) {
                                    int i60 = (i2 << 1) + i23;
                                    if ((49152 & i3) != 0 || mQDecoder.decodeSymbol(iArr2[i3 & 255]) == 0) {
                                        i6 = i60;
                                    } else {
                                        i6 = i60;
                                        int i61 = SC_LUT[(i3 >> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                        int iDecodeSymbol5 = (i61 >>> 31) ^ mQDecoder.decodeSymbol(i61 & 15);
                                        iArr3[i6] = (iDecodeSymbol5 << 31) | i16;
                                        int i62 = i30 + i19;
                                        iArr[i62] = iArr[i62] | 536936448;
                                        int i63 = i30 + i20;
                                        iArr[i63] = iArr[i63] | 537001984;
                                        if (iDecodeSymbol5 != 0) {
                                            i3 |= 606126080;
                                            int i64 = i30 - i12;
                                            iArr[i64] = iArr[i64] | 571473920;
                                            int i65 = i30 + 1;
                                            iArr[i65] = iArr[i65] | 537407616;
                                            int i66 = i30 - 1;
                                            iArr[i66] = iArr[i66] | 537143360;
                                        } else {
                                            i3 |= 539017216;
                                            int i67 = i30 - i12;
                                            iArr[i67] = iArr[i67] | 537919488;
                                            int i68 = i30 + 1;
                                            iArr[i68] = iArr[i68] | 537403520;
                                            int i69 = i30 - 1;
                                            iArr[i69] = iArr[i69] | 537141312;
                                        }
                                    }
                                    if (i27 < 4) {
                                        iArr[i30] = i3 & (-1073758209);
                                    } else {
                                        if (((-1073741824) & i3) == 0) {
                                            int i70 = i6 + i2;
                                            if (mQDecoder.decodeSymbol(iArr2[(i3 >>> 16) & 255]) != 0) {
                                                int i71 = SC_LUT[(i3 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                                int iDecodeSymbol6 = mQDecoder.decodeSymbol(i71 & 15) ^ (i71 >>> 31);
                                                iArr3[i70] = (iDecodeSymbol6 << 31) | i16;
                                                int i72 = i30 + i4;
                                                iArr[i72] = iArr[i72] | 8196;
                                                int i73 = i30 + i21;
                                                iArr[i73] = iArr[i73] | 8200;
                                                if (iDecodeSymbol6 != 0) {
                                                    i3 |= -1073733104;
                                                    int i74 = i30 + i12;
                                                    iArr[i74] = iArr[i74] | 9248;
                                                    int i75 = i30 + 1;
                                                    iArr[i75] = iArr[i75] | 813703170;
                                                    int i76 = i30 - 1;
                                                    iArr[i76] = iArr[i76] | 675291137;
                                                } else {
                                                    i3 |= -1073733616;
                                                    int i77 = i30 + i12;
                                                    iArr[i77] = iArr[i77] | 8224;
                                                    int i78 = i30 + 1;
                                                    iArr[i78] = iArr[i78] | 545267714;
                                                    int i79 = i30 - 1;
                                                    iArr[i79] = iArr[i79] | 541073409;
                                                }
                                            }
                                        }
                                        iArr[i30] = i3 & (-1073758209);
                                    }
                                } else {
                                    iArr[i30] = i3 & (-1073758209);
                                }
                            } else {
                                int i80 = SC_LUT[(i29 >> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                int iDecodeSymbol7 = (i80 >>> 31) ^ mQDecoder.decodeSymbol(i80 & 15);
                                iArr3[i31] = (iDecodeSymbol7 << 31) | i16;
                                int i81 = i30 + i22;
                                iArr[i81] = iArr[i81] | 8196;
                                int i82 = i30 + i21;
                                iArr[i82] = iArr[i82] | 8200;
                                if (iDecodeSymbol7 != 0) {
                                    int i83 = i30 + i12;
                                    i8 = i29 | (-2147474928);
                                    iArr[i83] = iArr[i83] | 9248;
                                    int i84 = i30 + 1;
                                    iArr[i84] = iArr[i84] | 813703170;
                                    int i85 = i30 - 1;
                                    iArr[i85] = iArr[i85] | 675291137;
                                } else {
                                    int i86 = i30 + i12;
                                    i8 = i29 | (-2147475440);
                                    iArr[i86] = iArr[i86] | 8224;
                                    int i87 = i30 + 1;
                                    iArr[i87] = iArr[i87] | 545267714;
                                    int i88 = i30 - 1;
                                    iArr[i88] = iArr[i88] | 541073409;
                                }
                                iArr[i30] = i8;
                                if ((iDecodeSymbol >> 1) == 0) {
                                    i30 += i12;
                                    i3 = iArr[i30];
                                }
                            }
                            z2 = true;
                            if (z2) {
                            }
                            if ((((i3 >> 1) | i3) & i5) != VSTD_MASK_R1R2) {
                            }
                        } else {
                            i2 = i10;
                        }
                        i4 = i22;
                    } else {
                        i2 = i10;
                        i30 = i26;
                        i3 = i29;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if ((((i3 >> 1) | i3) & i5) != VSTD_MASK_R1R2) {
                    }
                }
                i23++;
                i26++;
                i10 = i2;
                i22 = i4;
            }
            i25--;
            i23 += i14;
            i26 += i13;
            dataBlk2 = dataBlk;
        }
        if ((this.options & 32) != 0) {
            zCheckPredTerm = ((((mQDecoder.decodeSymbol(0) << 3) | (mQDecoder.decodeSymbol(0) << 2)) | (mQDecoder.decodeSymbol(0) << 1)) | mQDecoder.decodeSymbol(0)) != 10;
        } else {
            zCheckPredTerm = false;
        }
        if (z && (this.options & 16) != 0) {
            zCheckPredTerm = mQDecoder.checkPredTerm();
        }
        if ((this.options & 2) != 0) {
            mQDecoder.resetCtxts();
        }
        return zCheckPredTerm;
    }

    private void conceal(DataBlk dataBlk, int i) {
        int i2 = 1 << i;
        int i3 = (-1) << i;
        int[] iArr = (int[]) dataBlk.getData();
        int i4 = dataBlk.offset;
        for (int i5 = dataBlk.h - 1; i5 >= 0; i5--) {
            int i6 = dataBlk.w + i4;
            while (i4 < i6) {
                int i7 = iArr[i4] & i3;
                if ((Integer.MAX_VALUE & i7) != 0) {
                    iArr[i4] = i7 | i2;
                } else {
                    iArr[i4] = 0;
                }
                i4++;
            }
            i4 += dataBlk.scanw - dataBlk.w;
        }
    }
}
