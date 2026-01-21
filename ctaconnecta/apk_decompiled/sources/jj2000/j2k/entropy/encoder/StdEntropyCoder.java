package jj2000.j2k.entropy.encoder;

import androidx.core.app.FrameMetricsAggregator;
import java.lang.reflect.Array;
import java.util.Stack;
import jj2000.j2k.StringSpec;
import jj2000.j2k.entropy.CBlkSizeSpec;
import jj2000.j2k.entropy.PrecinctSizeSpec;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.image.Coord;
import jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc;
import jj2000.j2k.util.ArrayUtil;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ThreadPool;
import jj2000.j2k.wavelet.analysis.CBlkWTData;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class StdEntropyCoder extends EntropyCoder implements StdEntropyCoderOptions {
    public static final String DEF_THREADS_NUM = "0";
    private static final boolean DO_TIMING = false;
    private static final int INT_SIGN_BIT = Integer.MIN_VALUE;
    private static final int MR_LUT_BITS = 9;
    private static final int MR_MASK = 511;
    private static final int MSE_LKP_BITS = 7;
    private static final int MSE_LKP_FRAC_BITS = 13;
    private static final int NUM_CTXTS = 19;
    private static final int RLC_CTXT = 1;
    private static final int RLC_MASK_R1R2 = -536813568;
    private static final int SC_LUT_BITS = 9;
    private static final int SC_LUT_MASK = 15;
    private static final int SC_MASK = 511;
    private static final int SC_SHIFT_R1 = 4;
    private static final int SC_SHIFT_R2 = 20;
    private static final int SC_SPRED_SHIFT = 31;
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
    public static final int THREADS_PRIORITY_INC = 0;
    public static final String THREADS_PROP_NAME = "jj2000.j2k.entropy.encoder.StdEntropyCoder.nthreads";
    private static final int UNIF_CTXT = 0;
    private static final int VSTD_MASK_R1R2 = 1073758208;
    private static final int ZC_LUT_BITS = 8;
    private static final int[] ZC_LUT_LH;
    private static final int ZC_MASK = 255;
    public StringSpec bms;
    private BitToByteOutput[] boutT;
    private CBlkSizeSpec cblks;
    private Stack[] completedComps;
    public StringSpec css;
    private int[][] ctxtbufT;
    private double[][] distbufT;
    private boolean[] finishedTileComponent;
    private Stack idleComps;
    private boolean[][] istermbufT;
    public StringSpec lcs;
    private int[][] lenCalc;
    private MQCoder[] mqT;
    public StringSpec mqrs;
    private int[] nBusyComps;
    private int[][] opts;
    private ByteOutputBuffer[] outT;
    private boolean[][] precinctPartition;
    private PrecinctSizeSpec pss;
    private int[][] ratebufT;
    public StringSpec rts;
    private CBlkWTData[] srcblkT;
    public StringSpec sss;
    private int[][] stateT;
    private int[][] symbufT;
    private ThreadPool tPool;
    private int[][] tType;
    private long[] time;
    public StringSpec tts;
    private static final int[] ZC_LUT_HL = new int[256];
    private static final int[] ZC_LUT_HH = new int[256];
    private static final int[] SC_LUT = new int[512];
    private static final int[] MR_LUT = new int[512];
    private static final int[] MQ_INIT = {46, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] SEG_SYMBOLS = {1, 0, 1, 0};
    private static final int[] SEG_SYMB_CTXTS = {0, 0, 0, 0};
    private static final int[] FS_LOSSY = new int[64];
    private static final int[] FM_LOSSY = new int[128];
    private static final int[] FS_LOSSLESS = new int[64];
    private static final int[] FM_LOSSLESS = new int[128];

    static {
        int[] iArr = new int[256];
        ZC_LUT_LH = iArr;
        int i = 1;
        iArr[0] = 2;
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
        for (int i39 = 0; i39 < 64; i39++) {
            double d = (i39 / 64.0d) + 1.0d;
            double d2 = d * d;
            FS_LOSSLESS[i39] = (int) Math.floor((d2 * 8192.0d) + 0.5d);
            double d3 = d - 1.5d;
            FS_LOSSY[i39] = (int) Math.floor(((d2 - (d3 * d3)) * 8192.0d) + 0.5d);
        }
        int i40 = 0;
        while (i40 < 128) {
            double d4 = i40 / 64.0d;
            double d5 = d4 - 1.0d;
            double d6 = d5 * d5;
            FM_LOSSLESS[i40] = (int) Math.floor((d6 * 8192.0d) + 0.5d);
            double d7 = d4 - (i40 < 64 ? 0.5d : 1.5d);
            FM_LOSSY[i40] = (int) Math.floor(((d6 - (d7 * d7)) * 8192.0d) + 0.5d);
            i40++;
        }
    }

    private class Compressor implements Runnable {
        int c;
        CBlkRateDistStats ccb;
        private final int idx;
        int lcType;
        int options;
        boolean rev;
        int tType;
        private long[] time;

        Compressor(int i) {
            this.idx = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                StdEntropyCoder.compressCodeBlock(this.c, this.ccb, StdEntropyCoder.this.srcblkT[this.idx], StdEntropyCoder.this.mqT[this.idx], StdEntropyCoder.this.boutT[this.idx], StdEntropyCoder.this.outT[this.idx], StdEntropyCoder.this.stateT[this.idx], StdEntropyCoder.this.distbufT[this.idx], StdEntropyCoder.this.ratebufT[this.idx], StdEntropyCoder.this.istermbufT[this.idx], StdEntropyCoder.this.symbufT[this.idx], StdEntropyCoder.this.ctxtbufT[this.idx], this.options, this.rev, this.lcType, this.tType);
            } finally {
                StdEntropyCoder.this.completedComps[this.c].push(this);
            }
        }

        synchronized long getTiming(int i) {
            return 0L;
        }

        public int getIdx() {
            return this.idx;
        }
    }

    public StdEntropyCoder(CBlkQuantDataSrcEnc cBlkQuantDataSrcEnc, CBlkSizeSpec cBlkSizeSpec, PrecinctSizeSpec precinctSizeSpec, StringSpec stringSpec, StringSpec stringSpec2, StringSpec stringSpec3, StringSpec stringSpec4, StringSpec stringSpec5, StringSpec stringSpec6, StringSpec stringSpec7) throws NumberFormatException {
        super(cBlkQuantDataSrcEnc);
        this.opts = null;
        this.lenCalc = null;
        this.tType = null;
        this.cblks = cBlkSizeSpec;
        this.pss = precinctSizeSpec;
        this.bms = stringSpec;
        this.mqrs = stringSpec2;
        this.rts = stringSpec3;
        this.css = stringSpec4;
        this.sss = stringSpec5;
        this.lcs = stringSpec6;
        this.tts = stringSpec7;
        int maxCBlkWidth = cBlkSizeSpec.getMaxCBlkWidth();
        int maxCBlkHeight = cBlkSizeSpec.getMaxCBlkHeight();
        try {
            int i = Integer.parseInt(System.getProperty(THREADS_PROP_NAME, DEF_THREADS_NUM));
            if (i < 0) {
                throw new NumberFormatException();
            }
            if (i > 0) {
                FacilityManager.getMsgLogger().printmsg(1, "Using multithreaded entropy coder with " + i + " compressor threads.");
                this.tPool = new ThreadPool(i, Thread.currentThread().getPriority(), "StdEntropyCoder");
                this.idleComps = new Stack();
                this.completedComps = new Stack[cBlkQuantDataSrcEnc.getNumComps()];
                this.nBusyComps = new int[cBlkQuantDataSrcEnc.getNumComps()];
                this.finishedTileComponent = new boolean[cBlkQuantDataSrcEnc.getNumComps()];
                for (int numComps = cBlkQuantDataSrcEnc.getNumComps() - 1; numComps >= 0; numComps--) {
                    this.completedComps[numComps] = new Stack();
                }
                for (int i2 = 0; i2 < i; i2++) {
                    this.idleComps.push(new Compressor(i2));
                }
            } else {
                this.tPool = null;
                this.idleComps = null;
                this.completedComps = null;
                this.nBusyComps = null;
                this.finishedTileComponent = null;
                i = 1;
            }
            this.outT = new ByteOutputBuffer[i];
            this.mqT = new MQCoder[i];
            this.boutT = new BitToByteOutput[i];
            this.stateT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, (maxCBlkWidth + 2) * (((maxCBlkHeight + 1) / 2) + 2));
            int i3 = maxCBlkWidth * 10;
            this.symbufT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i3);
            this.ctxtbufT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i3);
            this.distbufT = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, 96);
            this.ratebufT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, 96);
            this.istermbufT = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i, 96);
            this.srcblkT = new CBlkWTData[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.outT[i4] = new ByteOutputBuffer();
                this.mqT[i4] = new MQCoder(this.outT[i4], 19, MQ_INIT);
            }
            this.precinctPartition = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, cBlkQuantDataSrcEnc.getNumComps(), cBlkQuantDataSrcEnc.getNumTiles());
            int numComps2 = getNumComps();
            Coord numTiles = cBlkQuantDataSrcEnc.getNumTiles(null);
            initTileComp(getNumTiles(), numComps2);
            for (int i5 = 0; i5 < numComps2; i5++) {
                for (int i6 = 0; i6 < numTiles.y; i6++) {
                    for (int i7 = 0; i7 < numTiles.x; i7++) {
                        this.precinctPartition[i5][this.tIdx] = false;
                    }
                }
            }
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("Invalid number of threads for entropy coding in property jj2000.j2k.entropy.encoder.StdEntropyCoder.nthreads");
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    @Override // jj2000.j2k.entropy.encoder.EntropyCoder
    public int getCBlkWidth(int i, int i2) {
        return this.cblks.getCBlkWidth((byte) 3, i, i2);
    }

    @Override // jj2000.j2k.entropy.encoder.EntropyCoder
    public int getCBlkHeight(int i, int i2) {
        return this.cblks.getCBlkHeight((byte) 3, i, i2);
    }

    @Override // jj2000.j2k.entropy.encoder.CodedCBlkDataSrcEnc
    public CBlkRateDistStats getNextCodeBlock(int i, CBlkRateDistStats cBlkRateDistStats) {
        CBlkRateDistStats cBlkRateDistStats2;
        if (this.tPool == null) {
            this.srcblkT[0] = this.src.getNextInternCodeBlock(i, this.srcblkT[0]);
            if (this.srcblkT[0] == null) {
                return null;
            }
            if ((this.opts[this.tIdx][i] & 1) != 0) {
                BitToByteOutput[] bitToByteOutputArr = this.boutT;
                if (bitToByteOutputArr[0] == null) {
                    bitToByteOutputArr[0] = new BitToByteOutput(this.outT[0]);
                }
            }
            CBlkRateDistStats cBlkRateDistStats3 = cBlkRateDistStats == null ? new CBlkRateDistStats() : cBlkRateDistStats;
            compressCodeBlock(i, cBlkRateDistStats3, this.srcblkT[0], this.mqT[0], this.boutT[0], this.outT[0], this.stateT[0], this.distbufT[0], this.ratebufT[0], this.istermbufT[0], this.symbufT[0], this.ctxtbufT[0], this.opts[this.tIdx][i], isReversible(this.tIdx, i), this.lenCalc[this.tIdx][i], this.tType[this.tIdx][i]);
            return cBlkRateDistStats3;
        }
        CBlkRateDistStats cBlkRateDistStats4 = cBlkRateDistStats;
        while (!this.finishedTileComponent[i] && !this.idleComps.empty()) {
            Compressor compressor = (Compressor) this.idleComps.pop();
            int idx = compressor.getIdx();
            this.srcblkT[idx] = this.src.getNextInternCodeBlock(i, this.srcblkT[idx]);
            if (this.srcblkT[idx] != null) {
                if ((this.opts[this.tIdx][i] & 1) != 0) {
                    BitToByteOutput[] bitToByteOutputArr2 = this.boutT;
                    if (bitToByteOutputArr2[idx] == null) {
                        bitToByteOutputArr2[idx] = new BitToByteOutput(this.outT[idx]);
                    }
                }
                if (cBlkRateDistStats4 == null) {
                    cBlkRateDistStats4 = new CBlkRateDistStats();
                }
                compressor.ccb = cBlkRateDistStats4;
                compressor.c = i;
                compressor.options = this.opts[this.tIdx][i];
                compressor.rev = isReversible(this.tIdx, i);
                compressor.lcType = this.lenCalc[this.tIdx][i];
                compressor.tType = this.tType[this.tIdx][i];
                int[] iArr = this.nBusyComps;
                iArr[i] = iArr[i] + 1;
                this.tPool.runTarget(compressor, this.completedComps[i]);
                cBlkRateDistStats4 = null;
            } else {
                this.idleComps.push(compressor);
                this.finishedTileComponent[i] = true;
            }
        }
        if (this.nBusyComps[i] > 0) {
            synchronized (this.completedComps[i]) {
                if (this.completedComps[i].empty()) {
                    try {
                        this.completedComps[i].wait();
                    } catch (InterruptedException unused) {
                    }
                }
                Compressor compressor2 = (Compressor) this.completedComps[i].pop();
                compressor2.getIdx();
                int[] iArr2 = this.nBusyComps;
                iArr2[i] = iArr2[i] - 1;
                this.idleComps.push(compressor2);
                this.tPool.checkTargetErrors();
                cBlkRateDistStats2 = compressor2.ccb;
            }
            return cBlkRateDistStats2;
        }
        this.tPool.checkTargetErrors();
        return null;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        super.setTile(i, i2);
        if (this.finishedTileComponent != null) {
            for (int numComps = this.src.getNumComps() - 1; numComps >= 0; numComps--) {
                this.finishedTileComponent[numComps] = false;
            }
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void nextTile() {
        if (this.finishedTileComponent != null) {
            for (int numComps = this.src.getNumComps() - 1; numComps >= 0; numComps--) {
                this.finishedTileComponent[numComps] = false;
            }
        }
        super.nextTile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void compressCodeBlock(int i, CBlkRateDistStats cBlkRateDistStats, CBlkWTData cBlkWTData, MQCoder mQCoder, BitToByteOutput bitToByteOutput, ByteOutputBuffer byteOutputBuffer, int[] iArr, double[] dArr, int[] iArr2, boolean[] zArr, int[] iArr3, int[] iArr4, int i2, boolean z, int i3, int i4) {
        int[] iArr5;
        int i5;
        int[] iArr6;
        int i6;
        int i7;
        int i8;
        int[] iArr7;
        int[] iArr8;
        int i9;
        double dSigProgPass;
        int iMagRefPass;
        int i10;
        boolean z2;
        BitToByteOutput bitToByteOutput2 = bitToByteOutput;
        int i11 = i2 & 16;
        if (i11 != 0 && i4 != 3) {
            throw new IllegalArgumentException("Embedded error-resilient info in MQ termination option specified but incorrect MQ termination policy specified");
        }
        mQCoder.setLenCalcType(i3);
        mQCoder.setTermType(i4);
        int i12 = 31 - cBlkWTData.magbits;
        if (i12 < 0) {
            i12 = 0;
        }
        ArrayUtil.intArraySet(iArr, 0);
        int iCalcSkipMSBP = calcSkipMSBP(cBlkWTData, i12);
        cBlkRateDistStats.m = cBlkWTData.m;
        cBlkRateDistStats.n = cBlkWTData.n;
        cBlkRateDistStats.sb = cBlkWTData.sb;
        cBlkRateDistStats.nROIcoeff = cBlkWTData.nROIcoeff;
        cBlkRateDistStats.skipMSBP = iCalcSkipMSBP;
        if (cBlkRateDistStats.nROIcoeff != 0) {
            cBlkRateDistStats.nROIcp = (((cBlkWTData.nROIbp - iCalcSkipMSBP) - 1) * 3) + 1;
        } else {
            cBlkRateDistStats.nROIcp = 0;
        }
        int i13 = cBlkWTData.sb.orientation;
        if (i13 == 0) {
            iArr5 = ZC_LUT_LH;
        } else if (i13 == 1) {
            iArr5 = ZC_LUT_HL;
        } else if (i13 != 2) {
            if (i13 == 3) {
                iArr5 = ZC_LUT_HH;
            } else {
                throw new Error("JJ2000 internal error");
            }
        }
        int[] iArr9 = iArr5;
        int i14 = 30 - iCalcSkipMSBP;
        int[] iArr10 = FS_LOSSY;
        int[] iArr11 = FM_LOSSY;
        double dPow = Math.pow(2.0d, ((i14 - i12) << 1) - 13) * cBlkWTData.sb.stepWMSE * cBlkWTData.wmseScaling;
        double dCleanuppass = 0.0d;
        if (i14 >= i12) {
            if (z && i14 == i12) {
                iArr10 = FM_LOSSLESS;
            }
            int[] iArr12 = iArr10;
            if ((i2 & 4) != 0 || i14 == i12 || ((i2 & 1) != 0 && 27 - iCalcSkipMSBP >= i14)) {
                i10 = i12;
                z2 = true;
            } else {
                i10 = i12;
                z2 = false;
            }
            zArr[0] = z2;
            i5 = i10;
            i6 = iCalcSkipMSBP;
            iArr6 = iArr9;
            dCleanuppass = 0.0d + (cleanuppass(cBlkWTData, mQCoder, z2, i14, iArr, iArr12, iArr9, iArr3, iArr4, iArr2, 0, -1, i2) * dPow);
            dArr[0] = dCleanuppass;
            dPow *= 0.25d;
            i14 = 29 - i6;
            iArr10 = iArr12;
            i8 = zArr[0] ? 0 : -1;
            i7 = 1;
        } else {
            i5 = i12;
            iArr6 = iArr9;
            i6 = iCalcSkipMSBP;
            i7 = 0;
            i8 = -1;
        }
        while (i14 >= i5) {
            if (z && i14 == i5) {
                iArr10 = FS_LOSSLESS;
                iArr11 = FM_LOSSLESS;
            }
            int[] iArr13 = iArr10;
            int i15 = i2 & 4;
            zArr[i7] = i15 != 0;
            int i16 = i2 & 1;
            if (i16 == 0 || 27 - i6 <= i14) {
                iArr7 = iArr13;
                iArr8 = iArr6;
                i9 = i7;
                i8 = i8;
                dSigProgPass = dCleanuppass + (sigProgPass(cBlkWTData, mQCoder, r3, i14, iArr, iArr13, r7, iArr3, iArr4, iArr2, r11, r12, i2) * dPow);
            } else {
                bitToByteOutput2.setPredTerm(i11 != 0);
                dSigProgPass = dCleanuppass + (rawSigProgPass(cBlkWTData, bitToByteOutput2, zArr[i7], i14, iArr, iArr13, iArr2, i7, i8, i2) * dPow);
                iArr7 = iArr13;
                iArr8 = iArr6;
                i9 = i7;
            }
            dArr[i9] = dSigProgPass;
            if (zArr[i9]) {
                i8 = i9;
            }
            int i17 = i9 + 1;
            boolean z3 = i15 != 0 || (i16 != 0 && 27 - i6 > i14);
            zArr[i17] = z3;
            if (i16 == 0 || 27 - i6 <= i14) {
                int i18 = i8;
                int[] iArr14 = iArr11;
                iMagRefPass = magRefPass(cBlkWTData, mQCoder, z3, i14, iArr, iArr14, iArr3, iArr4, iArr2, i17, i18, i2);
                iArr11 = iArr14;
                i17 = i17;
                i8 = i18;
            } else {
                bitToByteOutput2.setPredTerm(i11 != 0);
                iMagRefPass = rawMagRefPass(cBlkWTData, bitToByteOutput2, zArr[i17], i14, iArr, iArr11, iArr2, i17, i8, i2);
            }
            double d = dSigProgPass + (iMagRefPass * dPow);
            dArr[i17] = d;
            int i19 = zArr[i17] ? i17 : i8;
            int i20 = i9 + 2;
            zArr[i20] = i15 != 0 || i14 == i5 || (i16 != 0 && 27 - i6 >= i14);
            int i21 = i9;
            int[] iArr15 = iArr8;
            int[] iArr16 = iArr7;
            dCleanuppass = d + (cleanuppass(cBlkWTData, mQCoder, r3, i14, iArr, iArr16, iArr15, iArr3, iArr4, iArr2, i20, i19, i2) * dPow);
            dArr[i20] = dCleanuppass;
            i8 = zArr[i20] ? i20 : i19;
            i7 = i21 + 3;
            dPow *= 0.25d;
            i14--;
            bitToByteOutput2 = bitToByteOutput;
            iArr10 = iArr16;
            iArr6 = iArr15;
        }
        int i22 = i7;
        cBlkRateDistStats.data = new byte[byteOutputBuffer.size()];
        byteOutputBuffer.toByteArray(0, byteOutputBuffer.size(), cBlkRateDistStats.data, 0);
        checkEndOfPassFF(cBlkRateDistStats.data, iArr2, zArr, i22);
        cBlkRateDistStats.selectConvexHull(iArr2, dArr, (i2 & 5) != 0 ? zArr : null, i22, z);
        mQCoder.reset();
        if (bitToByteOutput != null) {
            bitToByteOutput.reset();
        }
    }

    private static int calcSkipMSBP(CBlkWTData cBlkWTData, int i) {
        int[] iArr = (int[]) cBlkWTData.getData();
        int i2 = cBlkWTData.w;
        int i3 = cBlkWTData.h;
        int i4 = (~((1 << i) - 1)) & Integer.MAX_VALUE;
        int i5 = cBlkWTData.offset;
        int i6 = 0;
        for (int i7 = i3 - 1; i7 >= 0; i7--) {
            int i8 = i5 + i2;
            while (i5 < i8) {
                int i9 = iArr[i5] & i4;
                if (i9 > i6) {
                    i6 = i9;
                }
                i5++;
            }
            i5 += cBlkWTData.scanw - i2;
        }
        int i10 = 30;
        while (((1 << i10) & i6) == 0 && i10 - 1 >= i) {
        }
        return 30 - i10;
    }

    private static int sigProgPass(CBlkWTData cBlkWTData, MQCoder mQCoder, boolean z, int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        CBlkWTData cBlkWTData2 = cBlkWTData;
        int i9 = cBlkWTData2.scanw;
        int i10 = cBlkWTData2.w;
        int i11 = i10 + 2;
        int i12 = ((i11 * 4) / 2) - cBlkWTData2.w;
        int i13 = (i9 * 4) - cBlkWTData2.w;
        int i14 = 1 << i;
        int[] iArr7 = (int[]) cBlkWTData2.getData();
        int i15 = (cBlkWTData2.h + 3) / 4;
        int i16 = i - 6;
        int i17 = i16 >= 0 ? 0 : -i16;
        if (i16 <= 0) {
            i16 = 0;
        }
        boolean z2 = (i4 & 8) != 0;
        int i18 = -i11;
        int i19 = i18 - 1;
        int i20 = i18 + 1;
        int i21 = i10 + 3;
        int i22 = i10 + 1;
        int i23 = cBlkWTData2.offset;
        int i24 = i15 - 1;
        int i25 = i24;
        int i26 = i21;
        int i27 = 0;
        while (i25 >= 0) {
            int i28 = i23;
            int i29 = i25 != 0 ? 4 : cBlkWTData2.h - (i24 * 4);
            int i30 = i22;
            int i31 = i28 + cBlkWTData2.w;
            int i32 = i28;
            int i33 = i11;
            int i34 = 0;
            while (i32 < i31) {
                int i35 = i32;
                int i36 = iArr[i26];
                int i37 = i31;
                if (((~i36) & (i36 << 2) & SIG_MASK_R1R2) != 0) {
                    i5 = i12;
                    if ((i36 & 40960) == 8192) {
                        iArr5[i34] = iArr3[i36 & 255];
                        int i38 = i34 + 1;
                        int i39 = (iArr7[i35] & i14) >>> i;
                        iArr4[i34] = i39;
                        if (i39 != 0) {
                            int i40 = iArr7[i35] >>> 31;
                            int i41 = SC_LUT[(i36 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                            iArr4[i38] = i40 ^ (i41 >>> 31);
                            i34 += 2;
                            iArr5[i38] = i41 & 15;
                            if (!z2) {
                                int i42 = i26 + i19;
                                iArr[i42] = iArr[i42] | 536936448;
                                int i43 = i26 + i20;
                                iArr[i43] = iArr[i43] | 537001984;
                            }
                            if (i40 != 0) {
                                i36 |= 606126080;
                                if (!z2) {
                                    int i44 = i26 - i33;
                                    iArr[i44] = iArr[i44] | 571473920;
                                }
                                int i45 = i26 + 1;
                                iArr[i45] = iArr[i45] | 537407616;
                                int i46 = i26 - 1;
                                iArr[i46] = iArr[i46] | 537143360;
                            } else {
                                i36 |= 539017216;
                                if (!z2) {
                                    int i47 = i26 - i33;
                                    iArr[i47] = iArr[i47] | 537919488;
                                }
                                int i48 = i26 + 1;
                                iArr[i48] = iArr[i48] | 537403520;
                                int i49 = i26 - 1;
                                iArr[i49] = iArr[i49] | 537141312;
                            }
                            i27 += iArr2[((iArr7[i35] >> i16) << i17) & 63];
                        } else {
                            i36 |= 16384;
                            i34 = i38;
                        }
                    }
                    if (i29 < 2) {
                        iArr[i26] = i36;
                        i32 = i35 + 1;
                        i26++;
                        i31 = i37;
                        i12 = i5;
                    } else {
                        if ((i36 & (-1610612736)) == 536870912) {
                            int i50 = i35 + i9;
                            iArr5[i34] = iArr3[(i36 >>> 16) & 255];
                            int i51 = i34 + 1;
                            int i52 = (iArr7[i50] & i14) >>> i;
                            iArr4[i34] = i52;
                            if (i52 != 0) {
                                int i53 = iArr7[i50] >>> 31;
                                int i54 = i36;
                                int i55 = SC_LUT[(i54 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                iArr4[i51] = i53 ^ (i55 >>> 31);
                                i34 += 2;
                                iArr5[i51] = i55 & 15;
                                int i56 = i26 + i30;
                                iArr[i56] = iArr[i56] | 8196;
                                int i57 = i26 + i21;
                                iArr[i57] = iArr[i57] | 8200;
                                if (i53 != 0) {
                                    int i58 = i26 + i33;
                                    i8 = i54 | (-1073733104);
                                    iArr[i58] = iArr[i58] | 9248;
                                    int i59 = i26 + 1;
                                    iArr[i59] = iArr[i59] | 813703170;
                                    int i60 = i26 - 1;
                                    iArr[i60] = iArr[i60] | 675291137;
                                } else {
                                    int i61 = i26 + i33;
                                    i8 = i54 | (-1073733616);
                                    iArr[i61] = iArr[i61] | 8224;
                                    int i62 = i26 + 1;
                                    iArr[i62] = iArr[i62] | 545267714;
                                    int i63 = i26 - 1;
                                    iArr[i63] = iArr[i63] | 541073409;
                                }
                                i36 = i8;
                                i27 += iArr2[((iArr7[i50] >> i16) << i17) & 63];
                            } else {
                                i36 |= 1073741824;
                                i34 = i51;
                            }
                        }
                        iArr[i26] = i36;
                    }
                } else {
                    i5 = i12;
                }
                if (i29 >= 3) {
                    int i64 = i26 + i33;
                    int i65 = iArr[i64];
                    if (((~i65) & (i65 << 2) & SIG_MASK_R1R2) != 0) {
                        int i66 = i35 + (i9 << 1);
                        if ((i65 & 40960) == 8192) {
                            iArr5[i34] = iArr3[i65 & 255];
                            int i67 = i34 + 1;
                            int i68 = (iArr7[i66] & i14) >>> i;
                            iArr4[i34] = i68;
                            if (i68 != 0) {
                                int i69 = iArr7[i66] >>> 31;
                                int i70 = SC_LUT[(i65 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                iArr4[i67] = i69 ^ (i70 >>> 31);
                                i34 += 2;
                                iArr5[i67] = i70 & 15;
                                int i71 = i64 + i19;
                                iArr[i71] = iArr[i71] | 536936448;
                                int i72 = i64 + i20;
                                iArr[i72] = iArr[i72] | 537001984;
                                if (i69 != 0) {
                                    i7 = 606126080 | i65;
                                    int i73 = i64 - i33;
                                    iArr[i73] = iArr[i73] | 571473920;
                                    int i74 = i64 + 1;
                                    iArr[i74] = iArr[i74] | 537407616;
                                    int i75 = i64 - 1;
                                    iArr[i75] = iArr[i75] | 537143360;
                                } else {
                                    i7 = 539017216 | i65;
                                    int i76 = i64 - i33;
                                    iArr[i76] = iArr[i76] | 537919488;
                                    int i77 = i64 + 1;
                                    iArr[i77] = iArr[i77] | 537403520;
                                    int i78 = i64 - 1;
                                    iArr[i78] = iArr[i78] | 537141312;
                                }
                                i65 = i7;
                                i27 += iArr2[((iArr7[i66] >> i16) << i17) & 63];
                            } else {
                                i65 |= 16384;
                                i34 = i67;
                            }
                        }
                        if (i29 < 4) {
                            iArr[i64] = i65;
                        } else {
                            if ((i65 & (-1610612736)) == 536870912) {
                                int i79 = i66 + i9;
                                iArr5[i34] = iArr3[(i65 >>> 16) & 255];
                                int i80 = i34 + 1;
                                int i81 = (iArr7[i79] & i14) >>> i;
                                iArr4[i34] = i81;
                                if (i81 != 0) {
                                    int i82 = iArr7[i79] >>> 31;
                                    int i83 = SC_LUT[(i65 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                    iArr4[i80] = i82 ^ (i83 >>> 31);
                                    i34 += 2;
                                    iArr5[i80] = i83 & 15;
                                    int i84 = i64 + i30;
                                    iArr[i84] = iArr[i84] | 8196;
                                    int i85 = i64 + i21;
                                    iArr[i85] = iArr[i85] | 8200;
                                    if (i82 != 0) {
                                        i6 = (-1073733104) | i65;
                                        int i86 = i64 + i33;
                                        iArr[i86] = iArr[i86] | 9248;
                                        int i87 = i64 + 1;
                                        iArr[i87] = iArr[i87] | 813703170;
                                        int i88 = i64 - 1;
                                        iArr[i88] = iArr[i88] | 675291137;
                                    } else {
                                        i6 = (-1073733616) | i65;
                                        int i89 = i64 + i33;
                                        iArr[i89] = iArr[i89] | 8224;
                                        int i90 = i64 + 1;
                                        iArr[i90] = iArr[i90] | 545267714;
                                        int i91 = i64 - 1;
                                        iArr[i91] = iArr[i91] | 541073409;
                                    }
                                    i65 = i6;
                                    i27 += iArr2[((iArr7[i79] >> i16) << i17) & 63];
                                } else {
                                    i65 |= 1073741824;
                                    i34 = i80;
                                }
                            }
                            iArr[i64] = i65;
                        }
                    }
                }
                i32 = i35 + 1;
                i26++;
                i31 = i37;
                i12 = i5;
            }
            mQCoder.codeSymbols(iArr4, iArr5, i34);
            i25--;
            i23 = i32 + i13;
            i26 += i12;
            cBlkWTData2 = cBlkWTData;
            i11 = i33;
            i22 = i30;
        }
        if ((i4 & 2) != 0) {
            mQCoder.resetCtxts();
        }
        if (z) {
            iArr6[i2] = mQCoder.terminate();
        } else {
            iArr6[i2] = mQCoder.getNumCodedBytes();
        }
        if (i3 >= 0) {
            iArr6[i2] = iArr6[i2] + iArr6[i3];
        }
        if (z) {
            mQCoder.finishLengthCalculation(iArr6, i2);
        }
        return i27;
    }

    private static int rawSigProgPass(CBlkWTData cBlkWTData, BitToByteOutput bitToByteOutput, boolean z, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        CBlkWTData cBlkWTData2 = cBlkWTData;
        int i9 = cBlkWTData2.scanw;
        int i10 = cBlkWTData2.w;
        int i11 = i10 + 2;
        int i12 = ((i11 * 4) / 2) - cBlkWTData2.w;
        int i13 = (i9 * 4) - cBlkWTData2.w;
        int i14 = 1 << i;
        int[] iArr4 = (int[]) cBlkWTData2.getData();
        int i15 = (cBlkWTData2.h + 3) / 4;
        int i16 = i - 6;
        int i17 = i16 >= 0 ? 0 : -i16;
        if (i16 <= 0) {
            i16 = 0;
        }
        boolean z2 = (i4 & 8) != 0;
        int i18 = -i11;
        int i19 = i18 - 1;
        int i20 = i18 + 1;
        int i21 = i10 + 3;
        int i22 = i10 + 1;
        int i23 = cBlkWTData2.offset;
        int i24 = i15 - 1;
        int i25 = i24;
        int i26 = i21;
        int i27 = 0;
        while (i25 >= 0) {
            int i28 = i25 != 0 ? 4 : cBlkWTData2.h - (i24 * 4);
            int i29 = cBlkWTData2.w + i23;
            while (i23 < i29) {
                int i30 = iArr[i26];
                int i31 = i9;
                if (((~i30) & (i30 << 2) & SIG_MASK_R1R2) != 0) {
                    i5 = i22;
                    if ((i30 & 40960) == 8192) {
                        int i32 = (iArr4[i23] & i14) >>> i;
                        bitToByteOutput.writeBit(i32);
                        if (i32 != 0) {
                            int i33 = iArr4[i23] >>> 31;
                            bitToByteOutput.writeBit(i33);
                            if (!z2) {
                                int i34 = i26 + i19;
                                iArr[i34] = iArr[i34] | 536936448;
                                int i35 = i26 + i20;
                                iArr[i35] = iArr[i35] | 537001984;
                            }
                            if (i33 != 0) {
                                i30 |= 606126080;
                                if (!z2) {
                                    int i36 = i26 - i11;
                                    iArr[i36] = iArr[i36] | 571473920;
                                }
                                int i37 = i26 + 1;
                                iArr[i37] = iArr[i37] | 537407616;
                                int i38 = i26 - 1;
                                iArr[i38] = iArr[i38] | 537143360;
                            } else {
                                i30 |= 539017216;
                                if (!z2) {
                                    int i39 = i26 - i11;
                                    iArr[i39] = iArr[i39] | 537919488;
                                }
                                int i40 = i26 + 1;
                                iArr[i40] = iArr[i40] | 537403520;
                                int i41 = i26 - 1;
                                iArr[i41] = iArr[i41] | 537141312;
                            }
                            i27 += iArr2[((iArr4[i23] >> i16) << i17) & 63];
                        } else {
                            i30 |= 16384;
                        }
                    }
                    if (i28 < 2) {
                        iArr[i26] = i30;
                        i23++;
                        i26++;
                        i22 = i5;
                        i9 = i31;
                    } else {
                        if ((i30 & (-1610612736)) == 536870912) {
                            int i42 = i23 + i31;
                            int i43 = (iArr4[i42] & i14) >>> i;
                            bitToByteOutput.writeBit(i43);
                            if (i43 != 0) {
                                int i44 = iArr4[i42] >>> 31;
                                bitToByteOutput.writeBit(i44);
                                int i45 = i26 + i5;
                                int i46 = i30;
                                iArr[i45] = iArr[i45] | 8196;
                                int i47 = i26 + i21;
                                iArr[i47] = iArr[i47] | 8200;
                                if (i44 != 0) {
                                    int i48 = i26 + i11;
                                    i8 = i46 | (-1073733104);
                                    iArr[i48] = iArr[i48] | 9248;
                                    int i49 = i26 + 1;
                                    iArr[i49] = iArr[i49] | 813703170;
                                    int i50 = i26 - 1;
                                    iArr[i50] = iArr[i50] | 675291137;
                                } else {
                                    int i51 = i26 + i11;
                                    i8 = i46 | (-1073733616);
                                    iArr[i51] = iArr[i51] | 8224;
                                    int i52 = i26 + 1;
                                    iArr[i52] = iArr[i52] | 545267714;
                                    int i53 = i26 - 1;
                                    iArr[i53] = iArr[i53] | 541073409;
                                }
                                i30 = i8;
                                i27 += iArr2[((iArr4[i42] >> i16) << i17) & 63];
                            } else {
                                i30 |= 1073741824;
                            }
                        }
                        iArr[i26] = i30;
                    }
                } else {
                    i5 = i22;
                }
                if (i28 >= 3) {
                    int i54 = i26 + i11;
                    int i55 = iArr[i54];
                    if (((~i55) & (i55 << 2) & SIG_MASK_R1R2) != 0) {
                        int i56 = (i31 << 1) + i23;
                        if ((i55 & 40960) == 8192) {
                            int i57 = (iArr4[i56] & i14) >>> i;
                            bitToByteOutput.writeBit(i57);
                            if (i57 != 0) {
                                int i58 = iArr4[i56] >>> 31;
                                bitToByteOutput.writeBit(i58);
                                int i59 = i54 + i19;
                                iArr[i59] = iArr[i59] | 536936448;
                                int i60 = i54 + i20;
                                iArr[i60] = iArr[i60] | 537001984;
                                if (i58 != 0) {
                                    i7 = i55 | 606126080;
                                    int i61 = i54 - i11;
                                    iArr[i61] = iArr[i61] | 571473920;
                                    int i62 = i54 + 1;
                                    iArr[i62] = iArr[i62] | 537407616;
                                    int i63 = i54 - 1;
                                    iArr[i63] = iArr[i63] | 537143360;
                                } else {
                                    i7 = i55 | 539017216;
                                    int i64 = i54 - i11;
                                    iArr[i64] = iArr[i64] | 537919488;
                                    int i65 = i54 + 1;
                                    iArr[i65] = iArr[i65] | 537403520;
                                    int i66 = i54 - 1;
                                    iArr[i66] = iArr[i66] | 537141312;
                                }
                                i55 = i7;
                                i27 += iArr2[((iArr4[i56] >> i16) << i17) & 63];
                            } else {
                                i55 |= 16384;
                            }
                        }
                        if (i28 < 4) {
                            iArr[i54] = i55;
                        } else {
                            if ((i55 & (-1610612736)) == 536870912) {
                                int i67 = i56 + i31;
                                int i68 = (iArr4[i67] & i14) >>> i;
                                bitToByteOutput.writeBit(i68);
                                if (i68 != 0) {
                                    int i69 = iArr4[i67] >>> 31;
                                    bitToByteOutput.writeBit(i69);
                                    int i70 = i54 + i5;
                                    iArr[i70] = iArr[i70] | 8196;
                                    int i71 = i54 + i21;
                                    iArr[i71] = iArr[i71] | 8200;
                                    if (i69 != 0) {
                                        i6 = (-1073733104) | i55;
                                        int i72 = i54 + i11;
                                        iArr[i72] = iArr[i72] | 9248;
                                        int i73 = i54 + 1;
                                        iArr[i73] = iArr[i73] | 813703170;
                                        int i74 = i54 - 1;
                                        iArr[i74] = iArr[i74] | 675291137;
                                    } else {
                                        i6 = (-1073733616) | i55;
                                        int i75 = i54 + i11;
                                        iArr[i75] = iArr[i75] | 8224;
                                        int i76 = i54 + 1;
                                        iArr[i76] = iArr[i76] | 545267714;
                                        int i77 = i54 - 1;
                                        iArr[i77] = iArr[i77] | 541073409;
                                    }
                                    i55 = i6;
                                    i27 += iArr2[((iArr4[i67] >> i16) << i17) & 63];
                                } else {
                                    i55 |= 1073741824;
                                }
                            }
                            iArr[i54] = i55;
                        }
                    }
                }
                i23++;
                i26++;
                i22 = i5;
                i9 = i31;
            }
            i25--;
            i23 += i13;
            i26 += i12;
            cBlkWTData2 = cBlkWTData;
        }
        if (z) {
            iArr3[i2] = bitToByteOutput.terminate();
        } else {
            iArr3[i2] = bitToByteOutput.length();
        }
        if (i3 >= 0) {
            iArr3[i2] = iArr3[i2] + iArr3[i3];
        }
        return i27;
    }

    private static int magRefPass(CBlkWTData cBlkWTData, MQCoder mQCoder, boolean z, int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i2, int i3, int i4) {
        int i5;
        CBlkWTData cBlkWTData2 = cBlkWTData;
        int i6 = cBlkWTData2.scanw;
        int i7 = cBlkWTData2.w;
        int i8 = i7 + 2;
        int i9 = ((i8 * 4) / 2) - cBlkWTData2.w;
        int i10 = (i6 * 4) - cBlkWTData2.w;
        int i11 = 1 << i;
        int[] iArr6 = (int[]) cBlkWTData2.getData();
        int i12 = (cBlkWTData2.h + 3) / 4;
        int i13 = i - 6;
        int i14 = i13 >= 0 ? 0 : -i13;
        if (i13 <= 0) {
            i13 = 0;
        }
        int i15 = cBlkWTData2.offset;
        int i16 = i7 + 3;
        int i17 = i12 - 1;
        int i18 = i17;
        int i19 = 0;
        while (i18 >= 0) {
            int i20 = i15;
            int i21 = i18 != 0 ? 4 : cBlkWTData2.h - (i17 * 4);
            int i22 = i16;
            int i23 = i20 + cBlkWTData2.w;
            int i24 = i20;
            int i25 = i8;
            int i26 = 0;
            while (i24 < i23) {
                int i27 = i24;
                int i28 = iArr[i22];
                int i29 = i23;
                if (((i28 >>> 1) & (~i28) & VSTD_MASK_R1R2) != 0) {
                    i5 = i9;
                    if ((i28 & 49152) == 32768) {
                        iArr3[i26] = (iArr6[i27] & i11) >>> i;
                        iArr4[i26] = MR_LUT[i28 & FrameMetricsAggregator.EVERY_DURATION];
                        i28 |= 256;
                        i19 += iArr2[((iArr6[i27] >> i13) << i14) & 127];
                        i26++;
                    }
                    if (i21 < 2) {
                        iArr[i22] = i28;
                        i24 = i27 + 1;
                        i22++;
                        i23 = i29;
                        i9 = i5;
                    } else {
                        if ((i28 & (-1073741824)) == Integer.MIN_VALUE) {
                            int i30 = i27 + i6;
                            iArr3[i26] = (iArr6[i30] & i11) >>> i;
                            int i31 = i28;
                            iArr4[i26] = MR_LUT[(i31 >>> 16) & FrameMetricsAggregator.EVERY_DURATION];
                            i28 = i31 | 16777216;
                            i19 += iArr2[((iArr6[i30] >> i13) << i14) & 127];
                            i26++;
                        }
                        iArr[i22] = i28;
                    }
                } else {
                    i5 = i9;
                }
                if (i21 >= 3) {
                    int i32 = i22 + i25;
                    int i33 = iArr[i32];
                    if (((i33 >>> 1) & (~i33) & VSTD_MASK_R1R2) != 0) {
                        int i34 = i27 + (i6 << 1);
                        if ((i33 & 49152) == 32768) {
                            iArr3[i26] = (iArr6[i34] & i11) >>> i;
                            iArr4[i26] = MR_LUT[i33 & FrameMetricsAggregator.EVERY_DURATION];
                            i33 |= 256;
                            i19 += iArr2[((iArr6[i34] >> i13) << i14) & 127];
                            i26++;
                        }
                        if (i21 < 4) {
                            iArr[i32] = i33;
                        } else {
                            if ((iArr[i32] & (-1073741824)) == Integer.MIN_VALUE) {
                                int i35 = i34 + i6;
                                iArr3[i26] = (iArr6[i35] & i11) >>> i;
                                iArr4[i26] = MR_LUT[(i33 >>> 16) & FrameMetricsAggregator.EVERY_DURATION];
                                i33 |= 16777216;
                                i19 += iArr2[((iArr6[i35] >> i13) << i14) & 127];
                                i26++;
                            }
                            iArr[i32] = i33;
                        }
                    }
                }
                i24 = i27 + 1;
                i22++;
                i23 = i29;
                i9 = i5;
            }
            int i36 = i24;
            int i37 = i9;
            if (i26 > 0) {
                mQCoder.codeSymbols(iArr3, iArr4, i26);
            }
            i18--;
            i15 = i36 + i10;
            i16 = i22 + i37;
            cBlkWTData2 = cBlkWTData;
            i8 = i25;
            i9 = i37;
        }
        if ((i4 & 2) != 0) {
            mQCoder.resetCtxts();
        }
        if (z) {
            iArr5[i2] = mQCoder.terminate();
        } else {
            iArr5[i2] = mQCoder.getNumCodedBytes();
        }
        if (i3 >= 0) {
            iArr5[i2] = iArr5[i2] + iArr5[i3];
        }
        if (z) {
            mQCoder.finishLengthCalculation(iArr5, i2);
        }
        return i19;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[PHI: r16 r20
      0x007f: PHI (r16v8 int) = (r16v3 int), (r16v3 int), (r16v9 int) binds: [B:28:0x009f, B:31:0x00ad, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]
      0x007f: PHI (r20v5 int) = (r20v3 int), (r20v3 int), (r20v6 int) binds: [B:28:0x009f, B:31:0x00ad, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int rawMagRefPass(CBlkWTData cBlkWTData, BitToByteOutput bitToByteOutput, boolean z, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        int i5;
        CBlkWTData cBlkWTData2 = cBlkWTData;
        int i6 = cBlkWTData2.scanw;
        int i7 = cBlkWTData2.w;
        int i8 = i7 + 2;
        int i9 = ((i8 * 4) / 2) - cBlkWTData2.w;
        int i10 = (i6 * 4) - cBlkWTData2.w;
        int i11 = 1 << i;
        int[] iArr4 = (int[]) cBlkWTData2.getData();
        int i12 = 4;
        int i13 = (cBlkWTData2.h + 3) / 4;
        int i14 = i - 6;
        int i15 = i14 >= 0 ? 0 : -i14;
        if (i14 <= 0) {
            i14 = 0;
        }
        int i16 = cBlkWTData2.offset;
        int i17 = i7 + 3;
        int i18 = i13 - 1;
        int i19 = i18;
        int i20 = 0;
        while (i19 >= 0) {
            if (i19 == 0) {
                i12 = cBlkWTData2.h - (i18 * 4);
            }
            int i21 = cBlkWTData2.w + i16;
            while (i16 < i21) {
                int i22 = iArr[i17];
                if (((i22 >>> 1) & (~i22) & VSTD_MASK_R1R2) != 0) {
                    i5 = i6;
                    if ((i22 & 49152) == 32768) {
                        bitToByteOutput.writeBit((iArr4[i16] & i11) >>> i);
                        i20 += iArr2[((iArr4[i16] >> i14) << i15) & 127];
                    }
                    if (i12 >= 2) {
                        if ((i22 & (-1073741824)) == Integer.MIN_VALUE) {
                            int i23 = i16 + i5;
                            bitToByteOutput.writeBit((iArr4[i23] & i11) >>> i);
                            i20 += iArr2[((iArr4[i23] >> i14) << i15) & 127];
                        }
                    }
                    i16++;
                    i17++;
                    i6 = i5;
                } else {
                    i5 = i6;
                }
                if (i12 >= 3) {
                    int i24 = i17 + i8;
                    int i25 = iArr[i24];
                    if (((i25 >>> 1) & (~i25) & VSTD_MASK_R1R2) != 0) {
                        int i26 = (i5 << 1) + i16;
                        if ((i25 & 49152) == 32768) {
                            bitToByteOutput.writeBit((iArr4[i26] & i11) >>> i);
                            i20 += iArr2[((iArr4[i26] >> i14) << i15) & 127];
                        }
                        if (i12 >= 4 && (iArr[i24] & (-1073741824)) == Integer.MIN_VALUE) {
                            int i27 = i26 + i5;
                            bitToByteOutput.writeBit((iArr4[i27] & i11) >>> i);
                            i20 += iArr2[((iArr4[i27] >> i14) << i15) & 127];
                        }
                    }
                }
                i16++;
                i17++;
                i6 = i5;
            }
            i19--;
            i16 += i10;
            i17 += i9;
            cBlkWTData2 = cBlkWTData;
            i12 = 4;
        }
        if (z) {
            iArr3[i2] = bitToByteOutput.terminate();
        } else {
            iArr3[i2] = bitToByteOutput.length();
        }
        if (i3 >= 0) {
            iArr3[i2] = iArr3[i2] + iArr3[i3];
        }
        return i20;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int cleanuppass(CBlkWTData cBlkWTData, MQCoder mQCoder, boolean z, int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        CBlkWTData cBlkWTData2 = cBlkWTData;
        int i20 = cBlkWTData2.scanw;
        int i21 = cBlkWTData2.w;
        int i22 = i21 + 2;
        int i23 = ((i22 * 4) / 2) - cBlkWTData2.w;
        int i24 = (i20 * 4) - cBlkWTData2.w;
        int i25 = 1 << i;
        int[] iArr7 = (int[]) cBlkWTData2.getData();
        int i26 = (cBlkWTData2.h + 3) / 4;
        int i27 = i - 6;
        int i28 = i27 >= 0 ? 0 : -i27;
        if (i27 <= 0) {
            i27 = 0;
        }
        boolean z3 = (i4 & 8) != 0;
        int i29 = -i22;
        int i30 = i29 - 1;
        int i31 = i29 + 1;
        int i32 = i21 + 3;
        int i33 = i21 + 1;
        int i34 = cBlkWTData2.offset;
        int i35 = i26 - 1;
        int i36 = i35;
        int i37 = i32;
        int i38 = 0;
        while (i36 >= 0) {
            int i39 = i34;
            int i40 = i36 != 0 ? 4 : cBlkWTData2.h - (i35 * 4);
            int i41 = i33;
            int i42 = i39 + cBlkWTData2.w;
            int i43 = i39;
            int i44 = i22;
            int i45 = 0;
            while (i43 < i42) {
                int i46 = iArr[i37];
                if (i46 == 0 && (i15 = iArr[(i6 = i37 + i44)]) == 0) {
                    i5 = i43;
                    if (i40 == 4) {
                        if ((iArr7[i5] & i25) != 0) {
                            i6 = i37;
                            i15 = i46;
                            i16 = i5;
                            i17 = 0;
                        } else {
                            i16 = i5 + i20;
                            if ((iArr7[i16] & i25) != 0) {
                                i6 = i37;
                                i15 = i46;
                                i17 = 1;
                            } else {
                                i16 += i20;
                                if ((iArr7[i16] & i25) != 0) {
                                    i17 = 2;
                                } else {
                                    i16 += i20;
                                    if ((iArr7[i16] & i25) != 0) {
                                        i17 = 3;
                                    } else {
                                        iArr4[i45] = 0;
                                        iArr5[i45] = 1;
                                        i45++;
                                        i8 = i42;
                                        i43 = i5 + 1;
                                        i37++;
                                        i42 = i8;
                                    }
                                }
                            }
                        }
                        iArr4[i45] = 1;
                        int i47 = i45 + 1;
                        iArr5[i45] = 1;
                        int i48 = i17 >> 1;
                        iArr4[i47] = i48;
                        int i49 = i45 + 2;
                        iArr5[i47] = 0;
                        int i50 = i17 & 1;
                        iArr4[i49] = i50;
                        int i51 = i45 + 3;
                        iArr5[i49] = 0;
                        int i52 = iArr7[i16];
                        i38 += iArr2[((i52 >> i27) << i28) & 63];
                        int i53 = i52 >>> 31;
                        if (i50 == 0) {
                            int i54 = SC_LUT[(i15 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                            iArr4[i51] = i53 ^ (i54 >>> 31);
                            i45 += 4;
                            iArr5[i51] = i54 & 15;
                            if (i17 != 0 || !z3) {
                                int i55 = i6 + i30;
                                iArr[i55] = iArr[i55] | 536936448;
                                int i56 = i6 + i31;
                                iArr[i56] = iArr[i56] | 537001984;
                            }
                            if (i53 != 0) {
                                i19 = i15 | 606126080;
                                if (i17 != 0 || !z3) {
                                    int i57 = i6 - i44;
                                    iArr[i57] = iArr[i57] | 571473920;
                                }
                                int i58 = i6 + 1;
                                iArr[i58] = iArr[i58] | 537407616;
                                int i59 = i6 - 1;
                                iArr[i59] = iArr[i59] | 537143360;
                            } else {
                                i19 = i15 | 539017216;
                                if (i17 != 0 || !z3) {
                                    int i60 = i6 - i44;
                                    iArr[i60] = iArr[i60] | 537919488;
                                }
                                int i61 = i6 + 1;
                                iArr[i61] = iArr[i61] | 537403520;
                                int i62 = i6 - 1;
                                iArr[i62] = iArr[i62] | 537141312;
                            }
                            i7 = i19;
                            if (i48 != 0) {
                            }
                            i8 = i42;
                            if (z2) {
                                int i63 = i45;
                                if ((((i7 >> 1) | i7) & VSTD_MASK_R1R2) != VSTD_MASK_R1R2) {
                                    if ((49152 & i7) == 0) {
                                        iArr5[i63] = iArr3[i7 & 255];
                                        i45 = i63 + 1;
                                        int i64 = (iArr7[i5] & i25) >>> i;
                                        iArr4[i63] = i64;
                                        if (i64 != 0) {
                                            int i65 = iArr7[i5] >>> 31;
                                            int[] iArr8 = SC_LUT;
                                            i9 = VSTD_MASK_R1R2;
                                            int i66 = iArr8[(i7 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                            iArr4[i45] = i65 ^ (i66 >>> 31);
                                            i63 += 2;
                                            iArr5[i45] = i66 & 15;
                                            if (!z3) {
                                                int i67 = i6 + i30;
                                                iArr[i67] = iArr[i67] | 536936448;
                                                int i68 = i6 + i31;
                                                iArr[i68] = iArr[i68] | 537001984;
                                            }
                                            if (i65 != 0) {
                                                i7 |= 606126080;
                                                if (!z3) {
                                                    int i69 = i6 - i44;
                                                    iArr[i69] = iArr[i69] | 571473920;
                                                }
                                                int i70 = i6 + 1;
                                                iArr[i70] = iArr[i70] | 537407616;
                                                int i71 = i6 - 1;
                                                iArr[i71] = iArr[i71] | 537143360;
                                            } else {
                                                i7 |= 539017216;
                                                if (!z3) {
                                                    int i72 = i6 - i44;
                                                    iArr[i72] = iArr[i72] | 537919488;
                                                }
                                                int i73 = i6 + 1;
                                                iArr[i73] = iArr[i73] | 537403520;
                                                int i74 = i6 - 1;
                                                iArr[i74] = iArr[i74] | 537141312;
                                            }
                                            i38 += iArr2[((iArr7[i5] >> i27) << i28) & 63];
                                        } else {
                                            i9 = VSTD_MASK_R1R2;
                                            if (i40 >= 2) {
                                                iArr[i6] = i7 & (-1073758209);
                                                i43 = i5 + 1;
                                                i37++;
                                                i42 = i8;
                                            } else if (((-1073741824) & i7) == 0) {
                                                int i75 = i5 + i20;
                                                int i76 = i7;
                                                iArr5[i45] = iArr3[(i76 >>> 16) & 255];
                                                int i77 = i45 + 1;
                                                int i78 = (iArr7[i75] & i25) >>> i;
                                                iArr4[i45] = i78;
                                                if (i78 != 0) {
                                                    int i79 = iArr7[i75] >>> 31;
                                                    int i80 = SC_LUT[(i76 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                                    iArr4[i77] = i79 ^ (i80 >>> 31);
                                                    i45 += 2;
                                                    iArr5[i77] = i80 & 15;
                                                    int i81 = i6 + i41;
                                                    iArr[i81] = iArr[i81] | 8196;
                                                    int i82 = i6 + i32;
                                                    iArr[i82] = iArr[i82] | 8200;
                                                    if (i79 != 0) {
                                                        int i83 = i76 | (-1073733104);
                                                        int i84 = i6 + i44;
                                                        i14 = i83;
                                                        iArr[i84] = iArr[i84] | 9248;
                                                        int i85 = i6 + 1;
                                                        iArr[i85] = iArr[i85] | 813703170;
                                                        int i86 = i6 - 1;
                                                        iArr[i86] = iArr[i86] | 675291137;
                                                    } else {
                                                        int i87 = i76 | (-1073733616);
                                                        int i88 = i6 + i44;
                                                        i14 = i87;
                                                        iArr[i88] = iArr[i88] | 8224;
                                                        int i89 = i6 + 1;
                                                        iArr[i89] = iArr[i89] | 545267714;
                                                        int i90 = i6 - 1;
                                                        iArr[i90] = iArr[i90] | 541073409;
                                                    }
                                                    i7 = i14;
                                                    i38 += iArr2[((iArr7[i75] >> i27) << i28) & 63];
                                                } else {
                                                    i7 = i76;
                                                    i45 = i77;
                                                }
                                            }
                                        }
                                    } else {
                                        i9 = VSTD_MASK_R1R2;
                                    }
                                    i45 = i63;
                                    if (i40 >= 2) {
                                    }
                                } else {
                                    i9 = VSTD_MASK_R1R2;
                                    i45 = i63;
                                }
                                iArr[i6] = i7 & (-1073758209);
                                if (i40 < 3) {
                                    i43 = i5 + 1;
                                    i37++;
                                    i42 = i8;
                                } else {
                                    i6 += i44;
                                    i7 = iArr[i6];
                                }
                            } else {
                                i9 = VSTD_MASK_R1R2;
                            }
                            int i91 = i45;
                            if ((((i7 >> 1) | i7) & i9) == VSTD_MASK_R1R2) {
                                int i92 = i5 + (i20 << 1);
                                if ((49152 & i7) == 0) {
                                    iArr5[i91] = iArr3[i7 & 255];
                                    i45 = i91 + 1;
                                    int i93 = (iArr7[i92] & i25) >>> i;
                                    iArr4[i91] = i93;
                                    if (i93 != 0) {
                                        int i94 = iArr7[i92] >>> 31;
                                        int i95 = i7;
                                        int i96 = SC_LUT[(i95 >>> 4) & FrameMetricsAggregator.EVERY_DURATION];
                                        iArr4[i45] = i94 ^ (i96 >>> 31);
                                        int i97 = i91 + 2;
                                        iArr5[i45] = i96 & 15;
                                        int i98 = i6 + i30;
                                        iArr[i98] = iArr[i98] | 536936448;
                                        int i99 = i6 + i31;
                                        iArr[i99] = iArr[i99] | 537001984;
                                        if (i94 != 0) {
                                            i13 = i95 | 606126080;
                                            int i100 = i6 - i44;
                                            iArr[i100] = iArr[i100] | 571473920;
                                            int i101 = i6 + 1;
                                            iArr[i101] = iArr[i101] | 537407616;
                                            int i102 = i6 - 1;
                                            iArr[i102] = iArr[i102] | 537143360;
                                        } else {
                                            i13 = i95 | 539017216;
                                            int i103 = i6 - i44;
                                            iArr[i103] = iArr[i103] | 537919488;
                                            int i104 = i6 + 1;
                                            iArr[i104] = iArr[i104] | 537403520;
                                            int i105 = i6 - 1;
                                            iArr[i105] = iArr[i105] | 537141312;
                                        }
                                        i38 += iArr2[((iArr7[i92] >> i27) << i28) & 63];
                                        i45 = i97;
                                        i11 = i13;
                                        if (i40 >= 4) {
                                            iArr[i6] = i11 & (-1073758209);
                                            i43 = i5 + 1;
                                            i37++;
                                            i42 = i8;
                                        } else if ((i11 & (-1073741824)) == 0) {
                                            int i106 = i92 + i20;
                                            iArr5[i45] = iArr3[(i11 >>> 16) & 255];
                                            int i107 = i45 + 1;
                                            int i108 = (iArr7[i106] & i25) >>> i;
                                            iArr4[i45] = i108;
                                            if (i108 != 0) {
                                                int i109 = iArr7[i106] >>> 31;
                                                int i110 = SC_LUT[(i11 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                                                iArr4[i107] = i109 ^ (i110 >>> 31);
                                                i45 += 2;
                                                iArr5[i107] = i110 & 15;
                                                int i111 = i6 + i41;
                                                iArr[i111] = iArr[i111] | 8196;
                                                int i112 = i6 + i32;
                                                iArr[i112] = iArr[i112] | 8200;
                                                if (i109 != 0) {
                                                    int i113 = i11 | (-1073733104);
                                                    int i114 = i6 + i44;
                                                    i12 = i113;
                                                    iArr[i114] = iArr[i114] | 9248;
                                                    int i115 = i6 + 1;
                                                    iArr[i115] = iArr[i115] | 813703170;
                                                    int i116 = i6 - 1;
                                                    iArr[i116] = iArr[i116] | 675291137;
                                                } else {
                                                    int i117 = i11 | (-1073733616);
                                                    int i118 = i6 + i44;
                                                    i12 = i117;
                                                    iArr[i118] = iArr[i118] | 8224;
                                                    int i119 = i6 + 1;
                                                    iArr[i119] = iArr[i119] | 545267714;
                                                    int i120 = i6 - 1;
                                                    iArr[i120] = iArr[i120] | 541073409;
                                                }
                                                i7 = i12;
                                                i38 += iArr2[((iArr7[i106] >> i27) << i28) & 63];
                                            } else {
                                                i7 = i11;
                                                i45 = i107;
                                            }
                                        } else {
                                            i7 = i11;
                                        }
                                    } else {
                                        i10 = i7;
                                    }
                                } else {
                                    i10 = i7;
                                    i45 = i91;
                                }
                                i11 = i10;
                                if (i40 >= 4) {
                                }
                            } else {
                                i45 = i91;
                            }
                            iArr[i6] = i7 & (-1073758209);
                            i43 = i5 + 1;
                            i37++;
                            i42 = i8;
                        } else {
                            int i121 = SC_LUT[(i15 >>> 20) & FrameMetricsAggregator.EVERY_DURATION];
                            iArr4[i51] = i53 ^ (i121 >>> 31);
                            i45 += 4;
                            iArr5[i51] = i121 & 15;
                            int i122 = i6 + i41;
                            iArr[i122] = iArr[i122] | 8196;
                            int i123 = i6 + i32;
                            iArr[i123] = iArr[i123] | 8200;
                            if (i53 != 0) {
                                int i124 = i6 + i44;
                                i18 = i15 | (-2147474928);
                                iArr[i124] = iArr[i124] | 9248;
                                int i125 = i6 + 1;
                                iArr[i125] = iArr[i125] | 813703170;
                                int i126 = i6 - 1;
                                iArr[i126] = iArr[i126] | 675291137;
                            } else {
                                int i127 = i6 + i44;
                                i18 = i15 | (-2147475440);
                                iArr[i127] = iArr[i127] | 8224;
                                int i128 = i6 + 1;
                                iArr[i128] = iArr[i128] | 545267714;
                                int i129 = i6 - 1;
                                iArr[i129] = iArr[i129] | 541073409;
                            }
                            iArr[i6] = i18;
                            if (i48 == 0) {
                                i6 += i44;
                                i7 = iArr[i6];
                            }
                            i8 = i42;
                            i43 = i5 + 1;
                            i37++;
                            i42 = i8;
                        }
                        z2 = true;
                        i8 = i42;
                        if (z2) {
                        }
                        int i912 = i45;
                        if ((((i7 >> 1) | i7) & i9) == VSTD_MASK_R1R2) {
                        }
                        iArr[i6] = i7 & (-1073758209);
                        i43 = i5 + 1;
                        i37++;
                        i42 = i8;
                    }
                    z2 = false;
                    i8 = i42;
                    if (z2) {
                    }
                    int i9122 = i45;
                    if ((((i7 >> 1) | i7) & i9) == VSTD_MASK_R1R2) {
                    }
                    iArr[i6] = i7 & (-1073758209);
                    i43 = i5 + 1;
                    i37++;
                    i42 = i8;
                } else {
                    i5 = i43;
                }
                i6 = i37;
                i7 = i46;
                z2 = false;
                i8 = i42;
                if (z2) {
                }
                int i91222 = i45;
                if ((((i7 >> 1) | i7) & i9) == VSTD_MASK_R1R2) {
                }
                iArr[i6] = i7 & (-1073758209);
                i43 = i5 + 1;
                i37++;
                i42 = i8;
            }
            int i130 = i43;
            if (i45 > 0) {
                mQCoder.codeSymbols(iArr4, iArr5, i45);
            }
            i36--;
            i34 = i130 + i24;
            i37 += i23;
            cBlkWTData2 = cBlkWTData;
            i22 = i44;
            i33 = i41;
        }
        if ((i4 & 32) != 0) {
            int[] iArr9 = SEG_SYMBOLS;
            mQCoder.codeSymbols(iArr9, SEG_SYMB_CTXTS, iArr9.length);
        }
        if ((i4 & 2) != 0) {
            mQCoder.resetCtxts();
        }
        if (z) {
            iArr6[i2] = mQCoder.terminate();
        } else {
            iArr6[i2] = mQCoder.getNumCodedBytes();
        }
        if (i3 >= 0) {
            iArr6[i2] = iArr6[i2] + iArr6[i3];
        }
        if (z) {
            mQCoder.finishLengthCalculation(iArr6, i2);
        }
        return i38;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 int, still in use, count: 1, list:
          (r1v1 int) from 0x0028: ARITH (r1v1 int) + (-1 int) A[WRAPPED]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.utils.InsnRemover.unbindAllArgs(InsnRemover.java:106)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:90)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:141)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:116)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    private static void checkEndOfPassFF(byte[] r3, int[] r4, boolean[] r5, int r6) {
        /*
            r0 = -1
            if (r5 != 0) goto L17
            int r6 = r6 + r0
        L4:
            if (r6 < 0) goto L2f
            r5 = r4[r6]
            int r1 = r5 + (-1)
            if (r1 < 0) goto L14
            r1 = r3[r1]
            if (r1 != r0) goto L14
            int r5 = r5 + (-1)
            r4[r6] = r5
        L14:
            int r6 = r6 + (-1)
            goto L4
        L17:
            int r6 = r6 + r0
        L18:
            if (r6 < 0) goto L2f
            boolean r1 = r5[r6]
            if (r1 != 0) goto L2c
            r1 = r4[r6]
            int r2 = r1 + (-1)
            if (r2 < 0) goto L2c
            r2 = r3[r2]
            if (r2 != r0) goto L2c
            int r1 = r1 + (-1)
            r4[r6] = r1
        L2c:
            int r6 = r6 + (-1)
            goto L18
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jj2000.j2k.entropy.encoder.StdEntropyCoder.checkEndOfPassFF(byte[], int[], boolean[], int):void");
    }

    public void initTileComp(int i, int i2) {
        this.opts = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i2);
        this.lenCalc = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i2);
        this.tType = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                this.opts[i3][i4] = 0;
                if (((String) this.bms.getTileCompVal(i3, i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    int[] iArr = this.opts[i3];
                    iArr[i4] = iArr[i4] | 1;
                }
                if (((String) this.mqrs.getTileCompVal(i3, i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    int[] iArr2 = this.opts[i3];
                    iArr2[i4] = iArr2[i4] | 2;
                }
                if (((String) this.rts.getTileCompVal(i3, i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    int[] iArr3 = this.opts[i3];
                    iArr3[i4] = iArr3[i4] | 4;
                }
                if (((String) this.css.getTileCompVal(i3, i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    int[] iArr4 = this.opts[i3];
                    iArr4[i4] = iArr4[i4] | 8;
                }
                if (((String) this.sss.getTileCompVal(i3, i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    int[] iArr5 = this.opts[i3];
                    iArr5[i4] = iArr5[i4] | 32;
                }
                String str = (String) this.lcs.getTileCompVal(i3, i4);
                if (str.equals("near_opt")) {
                    this.lenCalc[i3][i4] = 2;
                } else if (str.equals("lazy_good")) {
                    this.lenCalc[i3][i4] = 1;
                } else if (str.equals("lazy")) {
                    this.lenCalc[i3][i4] = 0;
                } else {
                    throw new IllegalArgumentException("Unrecognized or unsupported MQ length calculation.");
                }
                String str2 = (String) this.tts.getTileCompVal(i3, i4);
                if (str2.equalsIgnoreCase("easy")) {
                    this.tType[i3][i4] = 2;
                } else if (str2.equalsIgnoreCase("full")) {
                    this.tType[i3][i4] = 0;
                } else if (str2.equalsIgnoreCase("near_opt")) {
                    this.tType[i3][i4] = 1;
                } else if (str2.equalsIgnoreCase("predict")) {
                    this.tType[i3][i4] = 3;
                    int[] iArr6 = this.opts[i3];
                    int i5 = iArr6[i4] | 16;
                    iArr6[i4] = i5;
                    if ((i5 & 5) == 0) {
                        FacilityManager.getMsgLogger().printmsg(1, "Using error resilient MQ termination, but terminating only at the end of code-blocks. The error protection offered by this option will be very weak. Specify the 'Cterminate' and/or 'Cbypass' option for increased error resilience.");
                    }
                } else {
                    throw new IllegalArgumentException("Unrecognized or unsupported MQ coder termination.");
                }
            }
        }
    }

    @Override // jj2000.j2k.entropy.encoder.CodedCBlkDataSrcEnc
    public int getPPX(int i, int i2, int i3) {
        return this.pss.getPPX(i, i2, i3);
    }

    @Override // jj2000.j2k.entropy.encoder.CodedCBlkDataSrcEnc
    public int getPPY(int i, int i2, int i3) {
        return this.pss.getPPY(i, i2, i3);
    }

    @Override // jj2000.j2k.entropy.encoder.CodedCBlkDataSrcEnc
    public boolean precinctPartitionUsed(int i, int i2) {
        return this.precinctPartition[i][i2];
    }
}
