package jj2000.j2k.entropy.encoder;

import java.io.IOException;
import java.lang.reflect.Array;
import jj2000.j2k.codestream.PrecInfo;
import jj2000.j2k.codestream.writer.BitOutputBuffer;
import jj2000.j2k.codestream.writer.CodestreamWriter;
import jj2000.j2k.codestream.writer.PktEncoder;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.entropy.Progression;
import jj2000.j2k.image.Coord;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.util.ProgressWatch;
import jj2000.j2k.wavelet.analysis.SubbandAn;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class EBCOTRateAllocator extends PostCompRateAllocator {
    private static final boolean DO_TIMING = false;
    private static final float FLOAT_ABS_PRECISION = 1.0E-10f;
    private static final float FLOAT_REL_PRECISION = 1.0E-4f;
    private static final double LOG2 = Math.log(2.0d);
    private static final int MIN_AVG_PACKET_SZ = 32;
    private static final int RD_SUMMARY_OFF = 24;
    private static final int RD_SUMMARY_SIZE = 64;
    private int[] RDSlopesRates;
    private long buildTime;
    private CBlkRateDistStats[][][][][] cblks;
    private long initTime;
    private EBCOTLayer[] layers;
    private LayersInfo lyrSpec;
    private float maxSlope;
    private float minSlope;
    private Coord[][][] numPrec;
    private PktEncoder pktEnc;
    private int[][][][][][] truncIdxs;
    private long writeTime;

    public EBCOTRateAllocator(CodedCBlkDataSrcEnc codedCBlkDataSrcEnc, LayersInfo layersInfo, CodestreamWriter codestreamWriter, EncoderSpecs encoderSpecs, ParameterList parameterList) {
        int i;
        int i2;
        super(codedCBlkDataSrcEnc, layersInfo.getTotNumLayers(), codestreamWriter, encoderSpecs);
        this.lyrSpec = layersInfo;
        this.RDSlopesRates = new int[64];
        int numTiles = codedCBlkDataSrcEnc.getNumTiles();
        int numComps = getNumComps();
        this.cblks = (CBlkRateDistStats[][][][][]) Array.newInstance((Class<?>) CBlkRateDistStats[][][].class, numTiles, numComps);
        this.truncIdxs = (int[][][][][][]) Array.newInstance((Class<?>) int[][][].class, numTiles, this.numLayers, numComps);
        int cbULX = codedCBlkDataSrcEnc.getCbULX();
        int cbULY = codedCBlkDataSrcEnc.getCbULY();
        codedCBlkDataSrcEnc.setTile(0, 0);
        Coord coord = null;
        Coord coord2 = null;
        int i3 = 0;
        while (i3 < numTiles) {
            Coord numTiles2 = codedCBlkDataSrcEnc.getNumTiles(coord);
            Coord tile = codedCBlkDataSrcEnc.getTile(coord2);
            int imgULX = getImgULX();
            int imgULY = getImgULY();
            int imgWidth = getImgWidth() + imgULX;
            int imgHeight = imgULY + getImgHeight();
            int tilePartULX = codedCBlkDataSrcEnc.getTilePartULX();
            int tilePartULY = codedCBlkDataSrcEnc.getTilePartULY();
            int nomTileWidth = codedCBlkDataSrcEnc.getNomTileWidth();
            int nomTileHeight = codedCBlkDataSrcEnc.getNomTileHeight();
            imgULX = tile.x != 0 ? tilePartULX + (tile.x * nomTileWidth) : imgULX;
            imgULY = tile.y != 0 ? tilePartULY + (tile.y * nomTileHeight) : imgULY;
            char c = 0;
            imgWidth = tile.x != numTiles2.x + (-1) ? tilePartULX + ((tile.x + 1) * nomTileWidth) : imgWidth;
            int i4 = tile.y != numTiles2.y + (-1) ? tilePartULY + ((tile.y + 1) * nomTileHeight) : imgHeight;
            int i5 = 0;
            while (i5 < numComps) {
                SubbandAn anSubbandTree = codedCBlkDataSrcEnc.getAnSubbandTree(i3, i5);
                int i6 = numTiles;
                int i7 = anSubbandTree.resLvl;
                int i8 = i7 + 1;
                int i9 = numComps;
                int i10 = cbULX;
                if (this.numPrec == null) {
                    int[] iArr = new int[2];
                    iArr[1] = i9;
                    iArr[c] = i6;
                    this.numPrec = (Coord[][][]) Array.newInstance((Class<?>) Coord[].class, iArr);
                }
                Coord[][] coordArr = this.numPrec[i3];
                if (coordArr[i5] == null) {
                    coordArr[i5] = new Coord[i8];
                }
                int compSubsX = codedCBlkDataSrcEnc.getCompSubsX(i5);
                int compSubsY = codedCBlkDataSrcEnc.getCompSubsY(i5);
                int i11 = cbULY;
                Coord coord3 = numTiles2;
                double d = compSubsX;
                int iCeil = (int) Math.ceil(imgULX / d);
                double d2 = compSubsY;
                int iCeil2 = (int) Math.ceil(imgULY / d2);
                int iCeil3 = (int) Math.ceil(imgWidth / d);
                Coord coord4 = tile;
                int iCeil4 = (int) Math.ceil(i4 / d2);
                int i12 = i4;
                this.cblks[i3][i5] = new CBlkRateDistStats[i8][][];
                for (int i13 = 0; i13 < this.numLayers; i13++) {
                    this.truncIdxs[i3][i13][i5] = new int[i8][][];
                }
                int i14 = 0;
                while (i14 < i8) {
                    int i15 = imgULX;
                    int i16 = imgULY;
                    int i17 = i8;
                    int i18 = iCeil;
                    double d3 = 1 << (i7 - i14);
                    int iCeil5 = (int) Math.ceil(iCeil / d3);
                    int iCeil6 = (int) Math.ceil(iCeil2 / d3);
                    int i19 = imgWidth;
                    int iCeil7 = (int) Math.ceil(iCeil3 / d3);
                    SubbandAn subbandAn = anSubbandTree;
                    int iCeil8 = (int) Math.ceil(iCeil4 / d3);
                    int i20 = iCeil2;
                    double ppx = encoderSpecs.pss.getPPX(i3, i5, i14);
                    double ppy = encoderSpecs.pss.getPPY(i3, i5, i14);
                    this.numPrec[i3][i5][i14] = new Coord();
                    if (iCeil7 > iCeil5) {
                        i = i5;
                        i2 = iCeil3;
                        this.numPrec[i3][i5][i14].x = ((int) Math.ceil((iCeil7 - i10) / ppx)) - ((int) Math.floor((iCeil5 - i10) / ppx));
                    } else {
                        i = i5;
                        i2 = iCeil3;
                        this.numPrec[i3][i][i14].x = 0;
                    }
                    if (iCeil8 > iCeil6) {
                        this.numPrec[i3][i][i14].y = ((int) Math.ceil((iCeil8 - i11) / ppy)) - ((int) Math.floor((iCeil6 - i11) / ppy));
                    } else {
                        this.numPrec[i3][i][i14].y = 0;
                    }
                    int i21 = i14 == 0 ? 1 : 4;
                    this.cblks[i3][i][i14] = new CBlkRateDistStats[i21][];
                    for (int i22 = 0; i22 < this.numLayers; i22++) {
                        this.truncIdxs[i3][i22][i][i14] = new int[i21][];
                    }
                    for (int i23 = i14 == 0 ? 0 : 1; i23 < i21; i23++) {
                        Coord coord5 = ((SubbandAn) subbandAn.getSubbandByIdx(i14, i23)).numCb;
                        int i24 = coord5.x * coord5.y;
                        this.cblks[i3][i][i14][i23] = new CBlkRateDistStats[i24];
                        for (int i25 = 0; i25 < this.numLayers; i25++) {
                            this.truncIdxs[i3][i25][i][i14][i23] = new int[i24];
                            for (int i26 = 0; i26 < i24; i26++) {
                                this.truncIdxs[i3][i25][i][i14][i23][i26] = -1;
                            }
                        }
                    }
                    i14++;
                    i5 = i;
                    imgULX = i15;
                    anSubbandTree = subbandAn;
                    imgULY = i16;
                    iCeil = i18;
                    i8 = i17;
                    iCeil2 = i20;
                    iCeil3 = i2;
                    imgWidth = i19;
                }
                i5++;
                cbULX = i10;
                numTiles = i6;
                numComps = i9;
                cbULY = i11;
                numTiles2 = coord3;
                tile = coord4;
                i4 = i12;
                c = 0;
            }
            int i27 = numTiles;
            int i28 = numComps;
            int i29 = cbULX;
            int i30 = cbULY;
            Coord coord6 = numTiles2;
            Coord coord7 = tile;
            if (i3 != i27 - 1) {
                codedCBlkDataSrcEnc.nextTile();
            }
            i3++;
            cbULX = i29;
            numTiles = i27;
            numComps = i28;
            cbULY = i30;
            coord = coord6;
            coord2 = coord7;
        }
        this.pktEnc = new PktEncoder(codedCBlkDataSrcEnc, encoderSpecs, this.numPrec, parameterList);
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    @Override // jj2000.j2k.entropy.encoder.PostCompRateAllocator
    public void runAndWrite() throws IOException {
        buildAndWriteLayers();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01a8, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // jj2000.j2k.entropy.encoder.PostCompRateAllocator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initialize() throws IOException {
        int i;
        int i2;
        ?? r7;
        int targetBitrate;
        int numTiles = this.src.getNumTiles();
        int numComps = this.src.getNumComps();
        getAllCodeBlocks();
        int i3 = this.RDSlopesRates[0];
        int i4 = 0;
        while (true) {
            if (i4 >= numTiles) {
                break;
            }
            int i5 = ((String) this.encSpec.sops.getTileDef(i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON) ? 8 : 2;
            if (((String) this.encSpec.ephs.getTileDef(i4)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                i5 += 2;
            }
            for (int i6 = 0; i6 < numComps; i6++) {
                int i7 = this.src.getAnSubbandTree(i4, i6).resLvl + 1;
                if (this.src.precinctPartitionUsed(i6, i4)) {
                    for (int i8 = 0; i8 < i7; i8++) {
                        i3 += this.numLayers * i5 * this.numPrec[i4][i6][i8].x * this.numPrec[i4][i6][i8].y;
                    }
                } else {
                    i3 += this.numLayers * i5 * i7;
                }
            }
            i4++;
        }
        int length = this.headEnc.getLength();
        float imgWidth = (this.src.getImgWidth() * this.src.getImgHeight()) / 8.0f;
        for (int i9 = 0; i9 < numTiles; i9++) {
            this.headEnc.reset();
            this.headEnc.encodeTilePartHeader(0, i9);
            length += this.headEnc.getLength();
        }
        this.layers = new EBCOTLayer[this.numLayers];
        for (int i10 = this.numLayers - 1; i10 >= 0; i10--) {
            this.layers[i10] = new EBCOTLayer();
        }
        int i11 = 0;
        for (int i12 = 0; i12 < numTiles; i12++) {
            for (int i13 = 0; i13 < numComps; i13++) {
                int i14 = this.src.getAnSubbandTree(i12, i13).resLvl + 1;
                if (this.src.precinctPartitionUsed(i13, i12)) {
                    for (int i15 = 0; i15 < i14; i15++) {
                        i11 += this.numPrec[i12][i13][i15].x * this.numPrec[i12][i13][i15].y * 32;
                    }
                } else {
                    i11 += i14 * 32;
                }
            }
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        for (i = 1; i16 < this.numLayers - i; i = 1) {
            double dFloor = Math.floor(this.lyrSpec.getTargetBitrate(i17) * imgWidth);
            if (i17 < this.lyrSpec.getNOptPoints() - i) {
                targetBitrate = (int) (this.lyrSpec.getTargetBitrate(i17 + 1) * imgWidth);
                if (targetBitrate > i3) {
                    targetBitrate = i3;
                }
            } else {
                targetBitrate = 1;
            }
            int extraLayers = this.lyrSpec.getExtraLayers(i17) + i;
            int i19 = length;
            double dExp = Math.exp(Math.log(targetBitrate / dFloor) / extraLayers);
            this.layers[i16].optimize = true;
            for (int i20 = 0; i20 < extraLayers; i20++) {
                int i21 = (int) dFloor;
                if ((i21 - i18) - i19 < i11) {
                    dFloor *= dExp;
                    this.numLayers--;
                } else {
                    int i22 = i21 - i19;
                    this.layers[i16].maxBytes = i22;
                    dFloor *= dExp;
                    i16++;
                    i18 = i22;
                }
            }
            i17++;
            length = i19;
        }
        int i23 = this.numLayers - 2;
        int totBitrate = ((int) (this.lyrSpec.getTotBitrate() * imgWidth)) - length;
        if (i23 >= 0) {
            i2 = this.layers[i23].maxBytes;
            while (true) {
                int i24 = totBitrate - i2;
                if (i24 >= i11) {
                    r7 = 1;
                    break;
                }
                r7 = 1;
                if (this.numLayers != 1) {
                    this.numLayers--;
                    i23--;
                    if (i23 >= 0) {
                        i2 = this.layers[i23].maxBytes;
                    }
                } else if (i24 <= 0) {
                    throw new IllegalArgumentException("Overall target bitrate too low, given the current bit stream header overhead");
                }
            }
            int i25 = i23 + r7;
            this.layers[i25].maxBytes = totBitrate;
            this.layers[i25].optimize = r7;
            Progression[] progressionArr = (Progression[]) this.encSpec.pocs.getDefault();
            int length2 = progressionArr.length;
            for (int i26 = 0; i26 < progressionArr.length; i26++) {
                if (progressionArr[i26].lye > this.numLayers) {
                    progressionArr[i26].lye = this.numLayers;
                }
            }
            if (length2 == 0) {
                throw new Error("Unable to initialize rate allocator: No default progression type has been defined.");
            }
            for (int i27 = 0; i27 < numTiles; i27++) {
                if (this.encSpec.pocs.isTileSpecified(i27)) {
                    Progression[] progressionArr2 = (Progression[]) this.encSpec.pocs.getTileDef(i27);
                    int length3 = progressionArr2.length;
                    for (int i28 = 0; i28 < progressionArr2.length; i28++) {
                        if (progressionArr2[i28].lye > this.numLayers) {
                            progressionArr2[i28].lye = this.numLayers;
                        }
                    }
                    if (length3 == 0) {
                        throw new Error("Unable to initialize rate allocator: No default progression type has been defined for tile " + i27);
                    }
                }
            }
            return;
        }
        i2 = 0;
    }

    private void getAllCodeBlocks() {
        int i;
        int i2;
        int i3;
        this.maxSlope = 0.0f;
        this.minSlope = Float.MAX_VALUE;
        int numComps = this.src.getNumComps();
        int numTiles = this.src.getNumTiles();
        ProgressWatch progressWatch = FacilityManager.getProgressWatch();
        int i4 = 0;
        this.src.setTile(0, 0);
        String str = null;
        CBlkRateDistStats nextCodeBlock = null;
        int i5 = 0;
        while (i5 < numTiles) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i = 1;
                if (i6 >= numComps) {
                    break;
                }
                SubbandAn anSubbandTree = this.src.getAnSubbandTree(i5, i6);
                for (int i8 = 0; i8 <= anSubbandTree.resLvl; i8++) {
                    if (i8 == 0) {
                        SubbandAn subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(i4, i4);
                        if (subbandAn != null) {
                            i2 = subbandAn.numCb.x;
                            i3 = subbandAn.numCb.y;
                            i7 += i2 * i3;
                        }
                    } else {
                        SubbandAn subbandAn2 = (SubbandAn) anSubbandTree.getSubbandByIdx(i8, 1);
                        if (subbandAn2 != null) {
                            i7 += subbandAn2.numCb.x * subbandAn2.numCb.y;
                        }
                        SubbandAn subbandAn3 = (SubbandAn) anSubbandTree.getSubbandByIdx(i8, 2);
                        if (subbandAn3 != null) {
                            i7 += subbandAn3.numCb.x * subbandAn3.numCb.y;
                        }
                        SubbandAn subbandAn4 = (SubbandAn) anSubbandTree.getSubbandByIdx(i8, 3);
                        if (subbandAn4 != null) {
                            i2 = subbandAn4.numCb.x;
                            i3 = subbandAn4.numCb.y;
                            i7 += i2 * i3;
                        }
                    }
                }
                i6++;
            }
            if (progressWatch != null) {
                progressWatch.initProgressWatch(i4, i7, "Encoding tile " + i5 + "...");
            }
            int i9 = 0;
            int i10 = 0;
            while (i9 < numComps) {
                while (true) {
                    nextCodeBlock = this.src.getNextCodeBlock(i9, nextCodeBlock);
                    if (nextCodeBlock != null) {
                        if (progressWatch != null) {
                            i10++;
                            progressWatch.updateProgressWatch(i10, str);
                        }
                        SubbandAn subbandAn5 = nextCodeBlock.sb;
                        int i11 = subbandAn5.resLvl;
                        int i12 = subbandAn5.sbandIdx;
                        Coord coord = subbandAn5.numCb;
                        int limitedSIndexFromSlope = -1;
                        for (int i13 = nextCodeBlock.nVldTrunc - i; i13 >= 0; i13--) {
                            float f = nextCodeBlock.truncSlopes[i13];
                            if (f > this.maxSlope) {
                                this.maxSlope = f;
                            }
                            if (f < this.minSlope) {
                                this.minSlope = f;
                            }
                            int limitedSIndexFromSlope2 = getLimitedSIndexFromSlope(f);
                            while (limitedSIndexFromSlope2 > limitedSIndexFromSlope) {
                                int[] iArr = this.RDSlopesRates;
                                iArr[limitedSIndexFromSlope2] = iArr[limitedSIndexFromSlope2] + nextCodeBlock.truncRates[nextCodeBlock.truncIdxs[i13]];
                                limitedSIndexFromSlope2--;
                                numComps = numComps;
                            }
                            limitedSIndexFromSlope = getLimitedSIndexFromSlope(f);
                        }
                        this.cblks[i5][i9][i11][i12][(nextCodeBlock.m * coord.x) + nextCodeBlock.n] = nextCodeBlock;
                        numComps = numComps;
                        str = null;
                        nextCodeBlock = null;
                        i = 1;
                    }
                }
                i9++;
                str = null;
                i = 1;
            }
            int i14 = numComps;
            if (progressWatch != null) {
                progressWatch.terminateProgressWatch();
            }
            if (i5 < numTiles - 1) {
                this.src.nextTile();
            }
            i5++;
            numComps = i14;
            str = null;
            i4 = 0;
        }
    }

    private void buildAndWriteLayers() throws IOException {
        float fEstimateLayerThreshold;
        boolean z;
        boolean z2;
        EBCOTRateAllocator eBCOTRateAllocator = this;
        int numComps = eBCOTRateAllocator.src.getNumComps();
        int numTiles = eBCOTRateAllocator.src.getNumTiles();
        float f = eBCOTRateAllocator.maxSlope;
        int[] iArr = new int[numTiles];
        BitOutputBuffer bitOutputBuffer = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < eBCOTRateAllocator.numLayers) {
            int i4 = eBCOTRateAllocator.layers[i2].maxBytes;
            if (eBCOTRateAllocator.layers[i2].optimize) {
                fEstimateLayerThreshold = eBCOTRateAllocator.optimizeBitstreamLayer(i2, f, i4, i3);
            } else {
                if (i2 <= 0 || i2 >= eBCOTRateAllocator.numLayers - 1) {
                    throw new IllegalArgumentException("The first and the last layer thresholds must be optimized");
                }
                fEstimateLayerThreshold = eBCOTRateAllocator.estimateLayerThreshold(i4, eBCOTRateAllocator.layers[i2 - 1]);
            }
            float f2 = fEstimateLayerThreshold;
            int i5 = 0;
            while (i5 < numTiles) {
                if (i2 == 0) {
                    eBCOTRateAllocator.headEnc.reset();
                    eBCOTRateAllocator.headEnc.encodeTilePartHeader(i, i5);
                    iArr[i5] = iArr[i5] + eBCOTRateAllocator.headEnc.getLength();
                }
                int i6 = 0;
                while (i6 < numComps) {
                    boolean zEqualsIgnoreCase = ((String) eBCOTRateAllocator.encSpec.sops.getTileDef(i5)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                    boolean zEqualsIgnoreCase2 = ((String) eBCOTRateAllocator.encSpec.ephs.getTileDef(i5)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                    SubbandAn anSubbandTree = eBCOTRateAllocator.src.getAnSubbandTree(i5, i6);
                    int i7 = anSubbandTree.resLvl + 1;
                    while (anSubbandTree.subb_LL != null) {
                        anSubbandTree = anSubbandTree.subb_LL;
                    }
                    int i8 = i5;
                    int i9 = i2;
                    int i10 = 0;
                    while (i10 < i7) {
                        int i11 = eBCOTRateAllocator.numPrec[i8][i6][i10].y * eBCOTRateAllocator.numPrec[i8][i6][i10].x;
                        BitOutputBuffer bitOutputBuffer2 = bitOutputBuffer;
                        int i12 = i3;
                        int i13 = 0;
                        while (i13 < i11) {
                            eBCOTRateAllocator.findTruncIndices(i9, i6, i10, i8, anSubbandTree, f2, i13);
                            int i14 = i10;
                            int i15 = i13;
                            int i16 = i7;
                            int i17 = i11;
                            BitOutputBuffer bitOutputBufferEncodePacket = eBCOTRateAllocator.pktEnc.encodePacket(i9 + 1, i6, i14, i8, eBCOTRateAllocator.cblks[i8][i6][i14], eBCOTRateAllocator.truncIdxs[i8][i9][i6][i14], bitOutputBuffer2, null, i15);
                            int i18 = i8;
                            if (eBCOTRateAllocator.pktEnc.isPacketWritable()) {
                                z = zEqualsIgnoreCase;
                                z2 = zEqualsIgnoreCase2;
                                int iWritePacketHead = eBCOTRateAllocator.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), true, z, z2) + eBCOTRateAllocator.bsWriter.writePacketBody(eBCOTRateAllocator.pktEnc.getLastBodyBuf(), eBCOTRateAllocator.pktEnc.getLastBodyLen(), true, eBCOTRateAllocator.pktEnc.isROIinPkt(), eBCOTRateAllocator.pktEnc.getROILen());
                                i12 += iWritePacketHead;
                                iArr[i18] = iArr[i18] + iWritePacketHead;
                            } else {
                                z = zEqualsIgnoreCase;
                                z2 = zEqualsIgnoreCase2;
                            }
                            i11 = i17;
                            i8 = i18;
                            zEqualsIgnoreCase = z;
                            zEqualsIgnoreCase2 = z2;
                            bitOutputBuffer2 = bitOutputBufferEncodePacket;
                            i10 = i14;
                            i7 = i16;
                            i13 = i15 + 1;
                        }
                        anSubbandTree = anSubbandTree.parent;
                        i10++;
                        bitOutputBuffer = bitOutputBuffer2;
                        i8 = i8;
                        i3 = i12;
                        i7 = i7;
                    }
                    i6++;
                    i2 = i9;
                    i5 = i8;
                }
                i2 = i2;
                i5++;
                i = 0;
            }
            int i19 = i2;
            eBCOTRateAllocator.layers[i19].rdThreshold = f2;
            eBCOTRateAllocator.layers[i19].actualBytes = i3;
            i2 = i19 + 1;
            f = f2;
            i = 0;
        }
        eBCOTRateAllocator.pktEnc.reset();
        int[] iArr2 = new int[numComps];
        int i20 = 0;
        while (i20 < numTiles) {
            int[][] iArr3 = new int[numComps][];
            for (int i21 = 0; i21 < numComps; i21++) {
                int i22 = eBCOTRateAllocator.src.getAnSubbandTree(i20, i21).resLvl;
                iArr2[i21] = i22;
                iArr3[i21] = new int[i22 + 1];
            }
            eBCOTRateAllocator.headEnc.reset();
            eBCOTRateAllocator.headEnc.encodeTilePartHeader(iArr[i20], i20);
            eBCOTRateAllocator.bsWriter.commitBitstreamHeader(eBCOTRateAllocator.headEnc);
            Progression[] progressionArr = (Progression[]) eBCOTRateAllocator.encSpec.pocs.getTileDef(i20);
            int i23 = 0;
            while (i23 < progressionArr.length) {
                int i24 = progressionArr[i23].lye;
                int i25 = progressionArr[i23].cs;
                int i26 = progressionArr[i23].ce;
                int i27 = progressionArr[i23].rs;
                int i28 = progressionArr[i23].re;
                int i29 = progressionArr[i23].type;
                if (i29 == 0) {
                    eBCOTRateAllocator.writeLyResCompPos(i20, i27, i28, i25, i26, iArr3, i24);
                } else if (i29 == 1) {
                    eBCOTRateAllocator.writeResLyCompPos(i20, i27, i28, i25, i26, iArr3, i24);
                } else if (i29 == 2) {
                    eBCOTRateAllocator.writeResPosCompLy(i20, i27, i28, i25, i26, iArr3, i24);
                } else if (i29 == 3) {
                    eBCOTRateAllocator.writePosCompResLy(i20, i27, i28, i25, i26, iArr3, i24);
                } else if (i29 == 4) {
                    eBCOTRateAllocator.writeCompPosResLy(i20, i27, i28, i25, i26, iArr3, i24);
                } else {
                    throw new Error("Unsupported bit stream progression type");
                }
                while (i25 < i26) {
                    for (int i30 = i27; i30 < i28; i30++) {
                        if (i30 <= iArr2[i25]) {
                            iArr3[i25][i30] = i24;
                        }
                    }
                    i25++;
                }
                i23++;
                eBCOTRateAllocator = this;
            }
            i20++;
            eBCOTRateAllocator = this;
        }
    }

    public void writeResLyCompPos(int i, int i2, int i3, int i4, int i5, int[][] iArr, int i6) throws IOException {
        int i7;
        EBCOTRateAllocator eBCOTRateAllocator = this;
        int i8 = i;
        int numComps = eBCOTRateAllocator.src.getNumComps();
        int[] iArr2 = new int[numComps];
        int i9 = 0;
        for (int i10 = 0; i10 < numComps; i10++) {
            int i11 = eBCOTRateAllocator.src.getAnSubbandTree(i8, i10).resLvl;
            iArr2[i10] = i11;
            if (i11 > i9) {
                i9 = i11;
            }
        }
        BitOutputBuffer bitOutputBuffer = null;
        int i12 = i2;
        while (i12 < i3) {
            if (i12 <= i9) {
                int i13 = 100000;
                for (int i14 = i4; i14 < i5; i14++) {
                    int[] iArr3 = iArr[i14];
                    if (i12 < iArr3.length && (i7 = iArr3[i12]) < i13) {
                        i13 = i7;
                    }
                }
                while (i13 < i6) {
                    int i15 = i4;
                    while (i15 < i5) {
                        int[] iArr4 = iArr[i15];
                        if (i12 < iArr4.length && i13 >= iArr4[i12] && i12 <= iArr2[i15]) {
                            int i16 = eBCOTRateAllocator.numPrec[i8][i15][i12].x * eBCOTRateAllocator.numPrec[i8][i15][i12].y;
                            BitOutputBuffer bitOutputBuffer2 = bitOutputBuffer;
                            int i17 = 0;
                            while (i17 < i16) {
                                boolean zEquals = ((String) eBCOTRateAllocator.encSpec.sops.getTileDef(i8)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                boolean zEquals2 = ((String) eBCOTRateAllocator.encSpec.ephs.getTileDef(i8)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                SubbandAn anSubbandTree = eBCOTRateAllocator.src.getAnSubbandTree(i8, i15);
                                for (int i18 = iArr2[i15]; i18 > i12; i18--) {
                                    anSubbandTree = anSubbandTree.subb_LL;
                                }
                                int i19 = i15;
                                SubbandAn subbandAn = anSubbandTree;
                                int i20 = i13;
                                eBCOTRateAllocator.findTruncIndices(i20, i19, i12, i8, subbandAn, eBCOTRateAllocator.layers[i13].rdThreshold, i17);
                                int i21 = i16;
                                BitOutputBuffer bitOutputBuffer3 = bitOutputBuffer2;
                                int i22 = i17;
                                EBCOTRateAllocator eBCOTRateAllocator2 = eBCOTRateAllocator;
                                BitOutputBuffer bitOutputBufferEncodePacket = eBCOTRateAllocator.pktEnc.encodePacket(i20 + 1, i19, i12, i, eBCOTRateAllocator.cblks[i][i19][i12], eBCOTRateAllocator.truncIdxs[i][i20][i19][i12], bitOutputBuffer3, null, i22);
                                if (eBCOTRateAllocator2.pktEnc.isPacketWritable()) {
                                    eBCOTRateAllocator2.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), false, zEquals, zEquals2);
                                    eBCOTRateAllocator2.bsWriter.writePacketBody(eBCOTRateAllocator2.pktEnc.getLastBodyBuf(), eBCOTRateAllocator2.pktEnc.getLastBodyLen(), false, eBCOTRateAllocator2.pktEnc.isROIinPkt(), eBCOTRateAllocator2.pktEnc.getROILen());
                                }
                                i17 = i22 + 1;
                                i8 = i;
                                bitOutputBuffer2 = bitOutputBufferEncodePacket;
                                i15 = i19;
                                eBCOTRateAllocator = eBCOTRateAllocator2;
                                i13 = i20;
                                i16 = i21;
                            }
                            bitOutputBuffer = bitOutputBuffer2;
                        }
                        i15++;
                        i8 = i;
                        eBCOTRateAllocator = eBCOTRateAllocator;
                        i13 = i13;
                    }
                    i13++;
                    i8 = i;
                }
            }
            i12++;
            i8 = i;
            eBCOTRateAllocator = eBCOTRateAllocator;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeLyResCompPos(int i, int i2, int i3, int i4, int i5, int[][] iArr, int i6) throws IOException {
        BitOutputBuffer bitOutputBuffer;
        int i7;
        EBCOTRateAllocator eBCOTRateAllocator = this;
        int i8 = i;
        eBCOTRateAllocator.src.getNumComps();
        int i9 = 100000;
        for (int i10 = i4; i10 < i5; i10++) {
            for (int i11 = 0; i11 < iArr.length; i11++) {
                int[] iArr2 = iArr[i10];
                if (iArr2 != null && i11 < iArr2.length && (i7 = iArr2[i11]) < i9) {
                    i9 = i7;
                }
            }
        }
        BitOutputBuffer bitOutputBuffer2 = null;
        while (i9 < i6) {
            int i12 = i2;
            while (i12 < i3) {
                int i13 = i4;
                while (i13 < i5) {
                    int i14 = eBCOTRateAllocator.src.getAnSubbandTree(i8, i13).resLvl;
                    if (i12 > i14) {
                        bitOutputBuffer = bitOutputBuffer2;
                    } else {
                        int[] iArr3 = iArr[i13];
                        if (i12 < iArr3.length && i9 >= iArr3[i12]) {
                            int i15 = eBCOTRateAllocator.numPrec[i8][i13][i12].x * eBCOTRateAllocator.numPrec[i8][i13][i12].y;
                            BitOutputBuffer bitOutputBuffer3 = bitOutputBuffer2;
                            int i16 = 0;
                            while (i16 < i15) {
                                boolean zEquals = ((String) eBCOTRateAllocator.encSpec.sops.getTileDef(i8)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                boolean zEquals2 = ((String) eBCOTRateAllocator.encSpec.ephs.getTileDef(i8)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                SubbandAn anSubbandTree = eBCOTRateAllocator.src.getAnSubbandTree(i8, i13);
                                for (int i17 = i14; i17 > i12; i17--) {
                                    anSubbandTree = anSubbandTree.subb_LL;
                                }
                                int i18 = i13;
                                eBCOTRateAllocator.findTruncIndices(i9, i18, i12, i8, anSubbandTree, eBCOTRateAllocator.layers[i9].rdThreshold, i16);
                                int i19 = i9;
                                int i20 = i15;
                                BitOutputBuffer bitOutputBuffer4 = bitOutputBuffer3;
                                int i21 = i16;
                                EBCOTRateAllocator eBCOTRateAllocator2 = eBCOTRateAllocator;
                                BitOutputBuffer bitOutputBufferEncodePacket = eBCOTRateAllocator.pktEnc.encodePacket(i19 + 1, i18, i12, i, eBCOTRateAllocator.cblks[i][i18][i12], eBCOTRateAllocator.truncIdxs[i][i19][i18][i12], bitOutputBuffer4, null, i21);
                                if (eBCOTRateAllocator2.pktEnc.isPacketWritable()) {
                                    eBCOTRateAllocator2.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), false, zEquals, zEquals2);
                                    eBCOTRateAllocator2.bsWriter.writePacketBody(eBCOTRateAllocator2.pktEnc.getLastBodyBuf(), eBCOTRateAllocator2.pktEnc.getLastBodyLen(), false, eBCOTRateAllocator2.pktEnc.isROIinPkt(), eBCOTRateAllocator2.pktEnc.getROILen());
                                }
                                i16 = i21 + 1;
                                i8 = i;
                                bitOutputBuffer3 = bitOutputBufferEncodePacket;
                                i13 = i18;
                                eBCOTRateAllocator = eBCOTRateAllocator2;
                                i9 = i19;
                                i15 = i20;
                            }
                            bitOutputBuffer = bitOutputBuffer3;
                        }
                    }
                    i13++;
                    i8 = i;
                    bitOutputBuffer2 = bitOutputBuffer;
                    eBCOTRateAllocator = eBCOTRateAllocator;
                    i9 = i9;
                }
                i12++;
                i8 = i;
            }
            i9++;
            i8 = i;
        }
    }

    public void writePosCompResLy(int i, int i2, int i3, int i4, int i5, int[][] iArr, int i6) throws IOException {
        BitOutputBuffer bitOutputBuffer;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        EBCOTRateAllocator eBCOTRateAllocator;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        EBCOTRateAllocator eBCOTRateAllocator2;
        int i22;
        int i23;
        int i24;
        int[][] iArr2;
        int iGcd;
        int i25;
        EBCOTRateAllocator eBCOTRateAllocator3 = this;
        int i26 = i;
        eBCOTRateAllocator3.src.getNumComps();
        Coord numTiles = eBCOTRateAllocator3.src.getNumTiles(null);
        Coord tile = eBCOTRateAllocator3.src.getTile(null);
        int imgULX = eBCOTRateAllocator3.src.getImgULX();
        int imgULY = eBCOTRateAllocator3.src.getImgULY();
        int imgWidth = eBCOTRateAllocator3.src.getImgWidth() + imgULX;
        int imgHeight = eBCOTRateAllocator3.src.getImgHeight() + imgULY;
        int tilePartULX = eBCOTRateAllocator3.src.getTilePartULX();
        int tilePartULY = eBCOTRateAllocator3.src.getTilePartULY();
        int nomTileWidth = eBCOTRateAllocator3.src.getNomTileWidth();
        int nomTileHeight = eBCOTRateAllocator3.src.getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        int i27 = imgULX;
        if (tile.y != 0) {
            imgULY = tilePartULY + (tile.y * nomTileHeight);
        }
        int i28 = imgULY;
        if (tile.x != numTiles.x - 1) {
            imgWidth = tilePartULX + ((tile.x + 1) * nomTileWidth);
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int[][] iArr3 = new int[i5][];
        int i29 = i4;
        int i30 = i28;
        int i31 = imgWidth;
        int i32 = imgHeight;
        int i33 = i27;
        int i34 = 0;
        int i35 = 100000;
        int i36 = 0;
        int i37 = 0;
        while (i29 < i5) {
            int i38 = eBCOTRateAllocator3.src.getAnSubbandTree(i26, i29).resLvl;
            iArr3[i29] = new int[i38 + 1];
            int i39 = i2;
            while (i39 < i3) {
                if (i39 > i38) {
                    i24 = i38;
                    iArr2 = iArr3;
                } else {
                    int[] iArr4 = iArr[i29];
                    if (i39 < iArr4.length && (i25 = iArr4[i39]) < i35) {
                        i35 = i25;
                    }
                    int i40 = (eBCOTRateAllocator3.numPrec[i26][i29][i39].y * eBCOTRateAllocator3.numPrec[i26][i29][i39].x) - 1;
                    i24 = i38;
                    iArr2 = iArr3;
                    int i41 = i31;
                    int iGcd2 = i36;
                    int i42 = i37;
                    int i43 = i34;
                    int i44 = i32;
                    while (true) {
                        int i45 = i35;
                        if (i40 < 0) {
                            break;
                        }
                        PrecInfo precInfo = eBCOTRateAllocator3.pktEnc.getPrecInfo(i26, i29, i39, i40);
                        int i46 = i29;
                        if (precInfo.rgulx != i27) {
                            if (precInfo.rgulx < i41) {
                                i41 = precInfo.rgulx;
                            }
                            if (precInfo.rgulx > i33) {
                                i33 = precInfo.rgulx;
                            }
                        }
                        if (precInfo.rguly != i28) {
                            if (precInfo.rguly < i44) {
                                i44 = precInfo.rguly;
                            }
                            if (precInfo.rguly > i30) {
                                i30 = precInfo.rguly;
                            }
                        }
                        if (i43 == 0) {
                            iGcd = precInfo.rgw;
                            iGcd2 = precInfo.rgh;
                        } else {
                            iGcd = MathUtil.gcd(i42, precInfo.rgw);
                            iGcd2 = MathUtil.gcd(iGcd2, precInfo.rgh);
                        }
                        i42 = iGcd;
                        i43++;
                        i40--;
                        i35 = i45;
                        i29 = i46;
                    }
                    i32 = i44;
                    i36 = iGcd2;
                    i37 = i42;
                    i34 = i43;
                    i31 = i41;
                }
                i39++;
                i38 = i24;
                iArr3 = iArr2;
                i29 = i29;
            }
            i29++;
        }
        int[][] iArr5 = iArr3;
        if (i34 == 0) {
            throw new Error("Image cannot have no precinct");
        }
        int i47 = ((i30 - i32) / i36) + 1;
        int i48 = ((i33 - i31) / i37) + 1;
        int i49 = i28;
        int i50 = i27;
        BitOutputBuffer bitOutputBuffer2 = null;
        int i51 = 0;
        while (i51 <= i47) {
            int i52 = 0;
            while (i52 <= i48) {
                int i53 = i4;
                while (i53 < i5) {
                    int i54 = eBCOTRateAllocator3.src.getAnSubbandTree(i26, i53).resLvl;
                    int i55 = i52;
                    int i56 = i2;
                    while (i56 < i3) {
                        if (i56 > i54) {
                            i8 = i50;
                            bitOutputBuffer = bitOutputBuffer2;
                            i7 = i28;
                        } else {
                            bitOutputBuffer = bitOutputBuffer2;
                            i7 = i28;
                            if (iArr5[i53][i56] < eBCOTRateAllocator3.numPrec[i26][i53][i56].y * eBCOTRateAllocator3.numPrec[i26][i53][i56].x) {
                                PrecInfo precInfo2 = eBCOTRateAllocator3.pktEnc.getPrecInfo(i26, i53, i56, iArr5[i53][i56]);
                                if (precInfo2.rgulx == i50 && precInfo2.rguly == i49) {
                                    int i57 = i50;
                                    int i58 = i35;
                                    while (i58 < i6) {
                                        int[] iArr6 = iArr[i53];
                                        int i59 = i57;
                                        if (i56 < iArr6.length && i58 >= iArr6[i56]) {
                                            boolean zEquals = ((String) eBCOTRateAllocator3.encSpec.sops.getTileDef(i26)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                            boolean zEquals2 = ((String) eBCOTRateAllocator3.encSpec.ephs.getTileDef(i26)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                            SubbandAn anSubbandTree = eBCOTRateAllocator3.src.getAnSubbandTree(i26, i53);
                                            for (int i60 = i54; i60 > i56; i60--) {
                                                anSubbandTree = anSubbandTree.subb_LL;
                                            }
                                            i17 = i53;
                                            i21 = i55;
                                            i22 = i54;
                                            eBCOTRateAllocator3.findTruncIndices(i58, i17, i56, i26, anSubbandTree, eBCOTRateAllocator3.layers[i58].rdThreshold, iArr5[i53][i56]);
                                            i16 = i58;
                                            i18 = i49;
                                            i19 = i35;
                                            i20 = i27;
                                            i23 = i51;
                                            eBCOTRateAllocator2 = eBCOTRateAllocator3;
                                            i26 = i;
                                            BitOutputBuffer bitOutputBufferEncodePacket = eBCOTRateAllocator3.pktEnc.encodePacket(i16 + 1, i17, i56, i26, eBCOTRateAllocator3.cblks[i][i17][i56], eBCOTRateAllocator3.truncIdxs[i][i16][i17][i56], bitOutputBuffer, null, iArr5[i17][i56]);
                                            if (eBCOTRateAllocator2.pktEnc.isPacketWritable()) {
                                                eBCOTRateAllocator2.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), false, zEquals, zEquals2);
                                                eBCOTRateAllocator2.bsWriter.writePacketBody(eBCOTRateAllocator2.pktEnc.getLastBodyBuf(), eBCOTRateAllocator2.pktEnc.getLastBodyLen(), false, eBCOTRateAllocator2.pktEnc.isROIinPkt(), eBCOTRateAllocator2.pktEnc.getROILen());
                                            }
                                            bitOutputBuffer = bitOutputBufferEncodePacket;
                                        } else {
                                            i16 = i58;
                                            i17 = i53;
                                            i18 = i49;
                                            i19 = i35;
                                            i20 = i27;
                                            i21 = i55;
                                            eBCOTRateAllocator2 = eBCOTRateAllocator3;
                                            i22 = i54;
                                            i23 = i51;
                                        }
                                        i58 = i16 + 1;
                                        i53 = i17;
                                        eBCOTRateAllocator3 = eBCOTRateAllocator2;
                                        i51 = i23;
                                        i54 = i22;
                                        i57 = i59;
                                        i55 = i21;
                                        i35 = i19;
                                        i27 = i20;
                                        i49 = i18;
                                    }
                                    i8 = i57;
                                    i9 = i53;
                                    i10 = i49;
                                    i11 = i35;
                                    i12 = i27;
                                    i13 = i55;
                                    eBCOTRateAllocator = eBCOTRateAllocator3;
                                    i14 = i54;
                                    i15 = i51;
                                    int[] iArr7 = iArr5[i9];
                                    iArr7[i56] = iArr7[i56] + 1;
                                    i56++;
                                    i53 = i9;
                                    eBCOTRateAllocator3 = eBCOTRateAllocator;
                                    i51 = i15;
                                    i54 = i14;
                                    i28 = i7;
                                    bitOutputBuffer2 = bitOutputBuffer;
                                    i50 = i8;
                                    i55 = i13;
                                    i35 = i11;
                                    i27 = i12;
                                    i49 = i10;
                                }
                            }
                            i8 = i50;
                        }
                        i9 = i53;
                        i10 = i49;
                        i11 = i35;
                        i12 = i27;
                        i13 = i55;
                        eBCOTRateAllocator = eBCOTRateAllocator3;
                        i14 = i54;
                        i15 = i51;
                        i56++;
                        i53 = i9;
                        eBCOTRateAllocator3 = eBCOTRateAllocator;
                        i51 = i15;
                        i54 = i14;
                        i28 = i7;
                        bitOutputBuffer2 = bitOutputBuffer;
                        i50 = i8;
                        i55 = i13;
                        i35 = i11;
                        i27 = i12;
                        i49 = i10;
                    }
                    i53++;
                    bitOutputBuffer2 = bitOutputBuffer2;
                    i52 = i55;
                    i35 = i35;
                    i27 = i27;
                }
                int i61 = i28;
                int i62 = i49;
                int i63 = i35;
                int i64 = i27;
                EBCOTRateAllocator eBCOTRateAllocator4 = eBCOTRateAllocator3;
                int i65 = i52;
                int i66 = i51;
                i50 = i65 != i48 ? i31 + (i65 * i37) : i64;
                i52 = i65 + 1;
                eBCOTRateAllocator3 = eBCOTRateAllocator4;
                i51 = i66;
                i28 = i61;
                i35 = i63;
                i27 = i64;
                i49 = i62;
            }
            int i67 = i50;
            int i68 = i28;
            int i69 = i35;
            int i70 = i27;
            EBCOTRateAllocator eBCOTRateAllocator5 = eBCOTRateAllocator3;
            int i71 = i51;
            i49 = i71 != i47 ? i32 + (i71 * i36) : i68;
            i51 = i71 + 1;
            eBCOTRateAllocator3 = eBCOTRateAllocator5;
            i28 = i68;
            i50 = i67;
            i35 = i69;
            i27 = i70;
        }
        EBCOTRateAllocator eBCOTRateAllocator6 = eBCOTRateAllocator3;
        for (int i72 = i4; i72 < i5; i72++) {
            int i73 = eBCOTRateAllocator6.src.getAnSubbandTree(i26, i72).resLvl;
            for (int i74 = i2; i74 < i3; i74++) {
                if (i74 <= i73 && iArr5[i72][i74] < (eBCOTRateAllocator6.numPrec[i26][i72][i74].x * eBCOTRateAllocator6.numPrec[i26][i72][i74].y) - 1) {
                    throw new Error("JJ2000 bug: One precinct at least has not been written for resolution level " + i74 + " of component " + i72 + " in tile " + i26 + ".");
                }
            }
        }
    }

    public void writeCompPosResLy(int i, int i2, int i3, int i4, int i5, int[][] iArr, int i6) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        EBCOTRateAllocator eBCOTRateAllocator;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        EBCOTRateAllocator eBCOTRateAllocator2;
        int i22;
        int i23;
        int i24;
        int[][] iArr2;
        int iGcd;
        int i25;
        EBCOTRateAllocator eBCOTRateAllocator3 = this;
        int i26 = i;
        eBCOTRateAllocator3.src.getNumComps();
        Coord numTiles = eBCOTRateAllocator3.src.getNumTiles(null);
        Coord tile = eBCOTRateAllocator3.src.getTile(null);
        int imgULX = eBCOTRateAllocator3.src.getImgULX();
        int imgULY = eBCOTRateAllocator3.src.getImgULY();
        int imgWidth = eBCOTRateAllocator3.src.getImgWidth() + imgULX;
        int imgHeight = eBCOTRateAllocator3.src.getImgHeight() + imgULY;
        int tilePartULX = eBCOTRateAllocator3.src.getTilePartULX();
        int tilePartULY = eBCOTRateAllocator3.src.getTilePartULY();
        int nomTileWidth = eBCOTRateAllocator3.src.getNomTileWidth();
        int nomTileHeight = eBCOTRateAllocator3.src.getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        int i27 = imgULX;
        if (tile.y != 0) {
            imgULY = tilePartULY + (tile.y * nomTileHeight);
        }
        int i28 = imgULY;
        if (tile.x != numTiles.x - 1) {
            imgWidth = tilePartULX + ((tile.x + 1) * nomTileWidth);
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int[][] iArr3 = new int[i5][];
        int i29 = i4;
        int i30 = i28;
        int i31 = imgWidth;
        int i32 = imgHeight;
        int i33 = i27;
        int i34 = 0;
        int i35 = 100000;
        int i36 = 0;
        int i37 = 0;
        while (i29 < i5) {
            int i38 = eBCOTRateAllocator3.src.getAnSubbandTree(i26, i29).resLvl;
            int i39 = i2;
            while (i39 < i3) {
                if (i39 > i38) {
                    i24 = i38;
                    iArr2 = iArr3;
                } else {
                    iArr3[i29] = new int[i38 + 1];
                    int[] iArr4 = iArr[i29];
                    if (i39 < iArr4.length && (i25 = iArr4[i39]) < i35) {
                        i35 = i25;
                    }
                    int i40 = (eBCOTRateAllocator3.numPrec[i26][i29][i39].y * eBCOTRateAllocator3.numPrec[i26][i29][i39].x) - 1;
                    i24 = i38;
                    iArr2 = iArr3;
                    int i41 = i31;
                    int iGcd2 = i36;
                    int i42 = i37;
                    int i43 = i34;
                    int i44 = i32;
                    while (true) {
                        int i45 = i35;
                        if (i40 < 0) {
                            break;
                        }
                        PrecInfo precInfo = eBCOTRateAllocator3.pktEnc.getPrecInfo(i26, i29, i39, i40);
                        int i46 = i29;
                        if (precInfo.rgulx != i27) {
                            if (precInfo.rgulx < i41) {
                                i41 = precInfo.rgulx;
                            }
                            if (precInfo.rgulx > i33) {
                                i33 = precInfo.rgulx;
                            }
                        }
                        if (precInfo.rguly != i28) {
                            if (precInfo.rguly < i44) {
                                i44 = precInfo.rguly;
                            }
                            if (precInfo.rguly > i30) {
                                i30 = precInfo.rguly;
                            }
                        }
                        if (i43 == 0) {
                            iGcd = precInfo.rgw;
                            iGcd2 = precInfo.rgh;
                        } else {
                            iGcd = MathUtil.gcd(i42, precInfo.rgw);
                            iGcd2 = MathUtil.gcd(iGcd2, precInfo.rgh);
                        }
                        i42 = iGcd;
                        i43++;
                        i40--;
                        i35 = i45;
                        i29 = i46;
                    }
                    i32 = i44;
                    i36 = iGcd2;
                    i37 = i42;
                    i34 = i43;
                    i31 = i41;
                }
                i39++;
                i38 = i24;
                iArr3 = iArr2;
                i29 = i29;
            }
            i29++;
        }
        int[][] iArr5 = iArr3;
        if (i34 == 0) {
            throw new Error("Image cannot have no precinct");
        }
        int i47 = ((i30 - i32) / i36) + 1;
        int i48 = ((i33 - i31) / i37) + 1;
        int i49 = i4;
        BitOutputBuffer bitOutputBuffer = null;
        while (i49 < i5) {
            int i50 = eBCOTRateAllocator3.src.getAnSubbandTree(i26, i49).resLvl;
            int i51 = i28;
            int i52 = i27;
            int i53 = 0;
            while (i53 <= i47) {
                int i54 = 0;
                while (i54 <= i48) {
                    BitOutputBuffer bitOutputBuffer2 = bitOutputBuffer;
                    int i55 = i2;
                    while (i55 < i3) {
                        if (i55 > i50) {
                            i8 = i52;
                            i7 = i28;
                            i14 = i51;
                            i12 = i54;
                            i9 = i50;
                            i10 = i35;
                            i11 = i27;
                            eBCOTRateAllocator = eBCOTRateAllocator3;
                            i13 = i55;
                        } else {
                            i7 = i28;
                            int i56 = i54;
                            if (iArr5[i49][i55] < eBCOTRateAllocator3.numPrec[i26][i49][i55].y * eBCOTRateAllocator3.numPrec[i26][i49][i55].x) {
                                PrecInfo precInfo2 = eBCOTRateAllocator3.pktEnc.getPrecInfo(i26, i49, i55, iArr5[i49][i55]);
                                if (precInfo2.rgulx == i52 && precInfo2.rguly == i51) {
                                    int i57 = i35;
                                    while (i57 < i6) {
                                        int i58 = i52;
                                        int[] iArr6 = iArr[i49];
                                        if (i55 < iArr6.length && i57 >= iArr6[i55]) {
                                            boolean zEquals = ((String) eBCOTRateAllocator3.encSpec.sops.getTileDef(i26)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                            boolean zEquals2 = ((String) eBCOTRateAllocator3.encSpec.ephs.getTileDef(i26)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                            SubbandAn anSubbandTree = eBCOTRateAllocator3.src.getAnSubbandTree(i26, i49);
                                            for (int i59 = i50; i59 > i55; i59--) {
                                                anSubbandTree = anSubbandTree.subb_LL;
                                            }
                                            float f = eBCOTRateAllocator3.layers[i57].rdThreshold;
                                            int i60 = iArr5[i49][i55];
                                            i21 = i56;
                                            i22 = i51;
                                            i16 = i55;
                                            int i61 = i49;
                                            int i62 = i57;
                                            eBCOTRateAllocator3.findTruncIndices(i62, i61, i16, i26, anSubbandTree, f, i60);
                                            i17 = i62;
                                            i19 = i35;
                                            i20 = i27;
                                            i18 = i50;
                                            eBCOTRateAllocator2 = eBCOTRateAllocator3;
                                            i23 = i53;
                                            i26 = i;
                                            BitOutputBuffer bitOutputBufferEncodePacket = eBCOTRateAllocator3.pktEnc.encodePacket(i17 + 1, i61, i16, i26, eBCOTRateAllocator3.cblks[i][i61][i16], eBCOTRateAllocator3.truncIdxs[i][i17][i61][i16], bitOutputBuffer2, null, iArr5[i61][i16]);
                                            i49 = i61;
                                            if (eBCOTRateAllocator2.pktEnc.isPacketWritable()) {
                                                eBCOTRateAllocator2.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), false, zEquals, zEquals2);
                                                eBCOTRateAllocator2.bsWriter.writePacketBody(eBCOTRateAllocator2.pktEnc.getLastBodyBuf(), eBCOTRateAllocator2.pktEnc.getLastBodyLen(), false, eBCOTRateAllocator2.pktEnc.isROIinPkt(), eBCOTRateAllocator2.pktEnc.getROILen());
                                            }
                                            bitOutputBuffer2 = bitOutputBufferEncodePacket;
                                        } else {
                                            i16 = i55;
                                            i17 = i57;
                                            i18 = i50;
                                            i19 = i35;
                                            i20 = i27;
                                            i21 = i56;
                                            eBCOTRateAllocator2 = eBCOTRateAllocator3;
                                            i22 = i51;
                                            i23 = i53;
                                        }
                                        i57 = i17 + 1;
                                        i55 = i16;
                                        eBCOTRateAllocator3 = eBCOTRateAllocator2;
                                        i53 = i23;
                                        i51 = i22;
                                        i52 = i58;
                                        i56 = i21;
                                        i35 = i19;
                                        i50 = i18;
                                        i27 = i20;
                                    }
                                    i8 = i52;
                                    i9 = i50;
                                    i10 = i35;
                                    i11 = i27;
                                    i12 = i56;
                                    eBCOTRateAllocator = eBCOTRateAllocator3;
                                    i13 = i55;
                                    i14 = i51;
                                    i15 = i53;
                                    int[] iArr7 = iArr5[i49];
                                    iArr7[i13] = iArr7[i13] + 1;
                                    i55 = i13 + 1;
                                    eBCOTRateAllocator3 = eBCOTRateAllocator;
                                    i53 = i15;
                                    i51 = i14;
                                    i28 = i7;
                                    i52 = i8;
                                    i54 = i12;
                                    i35 = i10;
                                    i50 = i9;
                                    i27 = i11;
                                }
                            }
                            i8 = i52;
                            i9 = i50;
                            i10 = i35;
                            i11 = i27;
                            i12 = i56;
                            eBCOTRateAllocator = eBCOTRateAllocator3;
                            i13 = i55;
                            i14 = i51;
                        }
                        i15 = i53;
                        i55 = i13 + 1;
                        eBCOTRateAllocator3 = eBCOTRateAllocator;
                        i53 = i15;
                        i51 = i14;
                        i28 = i7;
                        i52 = i8;
                        i54 = i12;
                        i35 = i10;
                        i50 = i9;
                        i27 = i11;
                    }
                    int i63 = i28;
                    int i64 = i51;
                    int i65 = i50;
                    int i66 = i35;
                    int i67 = i27;
                    EBCOTRateAllocator eBCOTRateAllocator4 = eBCOTRateAllocator3;
                    int i68 = i54;
                    int i69 = i53;
                    i52 = i68 != i48 ? i31 + (i68 * i37) : i67;
                    i54 = i68 + 1;
                    eBCOTRateAllocator3 = eBCOTRateAllocator4;
                    i53 = i69;
                    bitOutputBuffer = bitOutputBuffer2;
                    i51 = i64;
                    i28 = i63;
                    i35 = i66;
                    i50 = i65;
                    i27 = i67;
                }
                int i70 = i52;
                int i71 = i28;
                int i72 = i50;
                int i73 = i35;
                int i74 = i27;
                EBCOTRateAllocator eBCOTRateAllocator5 = eBCOTRateAllocator3;
                int i75 = i53;
                i51 = i75 != i47 ? i32 + (i75 * i36) : i71;
                i53 = i75 + 1;
                eBCOTRateAllocator3 = eBCOTRateAllocator5;
                i28 = i71;
                i52 = i70;
                i35 = i73;
                i50 = i72;
                i27 = i74;
            }
            i49++;
            i35 = i35;
        }
        EBCOTRateAllocator eBCOTRateAllocator6 = eBCOTRateAllocator3;
        for (int i76 = i4; i76 < i5; i76++) {
            int i77 = eBCOTRateAllocator6.src.getAnSubbandTree(i26, i76).resLvl;
            for (int i78 = i2; i78 < i3; i78++) {
                if (i78 <= i77 && iArr5[i76][i78] < (eBCOTRateAllocator6.numPrec[i26][i76][i78].x * eBCOTRateAllocator6.numPrec[i26][i76][i78].y) - 1) {
                    throw new Error("JJ2000 bug: One precinct at least has not been written for resolution level " + i78 + " of component " + i76 + " in tile " + i26 + ".");
                }
            }
        }
    }

    public void writeResPosCompLy(int i, int i2, int i3, int i4, int i5, int[][] iArr, int i6) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        EBCOTRateAllocator eBCOTRateAllocator;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        EBCOTRateAllocator eBCOTRateAllocator2;
        int i21;
        int i22;
        int[][] iArr2;
        int iGcd;
        int i23;
        EBCOTRateAllocator eBCOTRateAllocator3 = this;
        int i24 = i;
        eBCOTRateAllocator3.src.getNumComps();
        Coord numTiles = eBCOTRateAllocator3.src.getNumTiles(null);
        Coord tile = eBCOTRateAllocator3.src.getTile(null);
        int imgULX = eBCOTRateAllocator3.src.getImgULX();
        int imgULY = eBCOTRateAllocator3.src.getImgULY();
        int imgWidth = eBCOTRateAllocator3.src.getImgWidth() + imgULX;
        int imgHeight = eBCOTRateAllocator3.src.getImgHeight() + imgULY;
        int tilePartULX = eBCOTRateAllocator3.src.getTilePartULX();
        int tilePartULY = eBCOTRateAllocator3.src.getTilePartULY();
        int nomTileWidth = eBCOTRateAllocator3.src.getNomTileWidth();
        int nomTileHeight = eBCOTRateAllocator3.src.getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        int i25 = imgULX;
        if (tile.y != 0) {
            imgULY = tilePartULY + (tile.y * nomTileHeight);
        }
        int i26 = imgULY;
        if (tile.x != numTiles.x - 1) {
            imgWidth = tilePartULX + ((tile.x + 1) * nomTileWidth);
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int[][] iArr3 = new int[i5][];
        int i27 = i4;
        int i28 = i26;
        int i29 = imgWidth;
        int i30 = imgHeight;
        int i31 = i25;
        int i32 = 0;
        int i33 = 100000;
        int i34 = 0;
        int i35 = 0;
        while (i27 < i5) {
            int i36 = eBCOTRateAllocator3.src.getAnSubbandTree(i24, i27).resLvl;
            iArr3[i27] = new int[i36 + 1];
            int i37 = i2;
            while (i37 < i3) {
                if (i37 > i36) {
                    i22 = i36;
                    iArr2 = iArr3;
                } else {
                    int[] iArr4 = iArr[i27];
                    if (i37 < iArr4.length && (i23 = iArr4[i37]) < i33) {
                        i33 = i23;
                    }
                    int i38 = (eBCOTRateAllocator3.numPrec[i24][i27][i37].y * eBCOTRateAllocator3.numPrec[i24][i27][i37].x) - 1;
                    i22 = i36;
                    iArr2 = iArr3;
                    int i39 = i29;
                    int iGcd2 = i34;
                    int i40 = i35;
                    int i41 = i32;
                    int i42 = i30;
                    while (true) {
                        int i43 = i33;
                        if (i38 < 0) {
                            break;
                        }
                        PrecInfo precInfo = eBCOTRateAllocator3.pktEnc.getPrecInfo(i24, i27, i37, i38);
                        int i44 = i27;
                        if (precInfo.rgulx != i25) {
                            if (precInfo.rgulx < i39) {
                                i39 = precInfo.rgulx;
                            }
                            if (precInfo.rgulx > i31) {
                                i31 = precInfo.rgulx;
                            }
                        }
                        if (precInfo.rguly != i26) {
                            if (precInfo.rguly < i42) {
                                i42 = precInfo.rguly;
                            }
                            if (precInfo.rguly > i28) {
                                i28 = precInfo.rguly;
                            }
                        }
                        if (i41 == 0) {
                            iGcd = precInfo.rgw;
                            iGcd2 = precInfo.rgh;
                        } else {
                            iGcd = MathUtil.gcd(i40, precInfo.rgw);
                            iGcd2 = MathUtil.gcd(iGcd2, precInfo.rgh);
                        }
                        i40 = iGcd;
                        i41++;
                        i38--;
                        i33 = i43;
                        i27 = i44;
                    }
                    i30 = i42;
                    i34 = iGcd2;
                    i35 = i40;
                    i32 = i41;
                    i29 = i39;
                }
                i37++;
                i36 = i22;
                iArr3 = iArr2;
                i27 = i27;
            }
            i27++;
        }
        int[][] iArr5 = iArr3;
        if (i32 == 0) {
            throw new Error("Image cannot have no precinct");
        }
        int i45 = ((i28 - i30) / i34) + 1;
        int i46 = ((i31 - i29) / i35) + 1;
        int i47 = i2;
        BitOutputBuffer bitOutputBuffer = null;
        while (i47 < i3) {
            int i48 = i26;
            int i49 = i25;
            int i50 = 0;
            while (i50 <= i45) {
                int i51 = 0;
                while (i51 <= i46) {
                    int i52 = i4;
                    while (i52 < i5) {
                        BitOutputBuffer bitOutputBuffer2 = bitOutputBuffer;
                        int i53 = eBCOTRateAllocator3.src.getAnSubbandTree(i24, i52).resLvl;
                        if (i47 > i53) {
                            i8 = i49;
                            i7 = i26;
                        } else {
                            i7 = i26;
                            if (iArr5[i52][i47] < eBCOTRateAllocator3.numPrec[i24][i52][i47].y * eBCOTRateAllocator3.numPrec[i24][i52][i47].x) {
                                PrecInfo precInfo2 = eBCOTRateAllocator3.pktEnc.getPrecInfo(i24, i52, i47, iArr5[i52][i47]);
                                if (precInfo2.rgulx == i49 && precInfo2.rguly == i48) {
                                    int i54 = i49;
                                    int i55 = i33;
                                    while (i55 < i6) {
                                        int[] iArr6 = iArr[i52];
                                        int i56 = i54;
                                        if (i47 < iArr6.length && i55 >= iArr6[i47]) {
                                            boolean zEquals = ((String) eBCOTRateAllocator3.encSpec.sops.getTileDef(i24)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                            boolean zEquals2 = ((String) eBCOTRateAllocator3.encSpec.ephs.getTileDef(i24)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                            SubbandAn anSubbandTree = eBCOTRateAllocator3.src.getAnSubbandTree(i24, i52);
                                            for (int i57 = i53; i57 > i47; i57--) {
                                                anSubbandTree = anSubbandTree.subb_LL;
                                            }
                                            i16 = i51;
                                            i17 = i52;
                                            eBCOTRateAllocator3.findTruncIndices(i55, i17, i47, i24, anSubbandTree, eBCOTRateAllocator3.layers[i55].rdThreshold, iArr5[i52][i47]);
                                            i15 = i55;
                                            i18 = i48;
                                            i19 = i33;
                                            i20 = i25;
                                            i21 = i50;
                                            eBCOTRateAllocator2 = eBCOTRateAllocator3;
                                            i24 = i;
                                            BitOutputBuffer bitOutputBufferEncodePacket = eBCOTRateAllocator3.pktEnc.encodePacket(i15 + 1, i17, i47, i24, eBCOTRateAllocator3.cblks[i][i17][i47], eBCOTRateAllocator3.truncIdxs[i][i15][i17][i47], bitOutputBuffer2, null, iArr5[i17][i47]);
                                            if (eBCOTRateAllocator2.pktEnc.isPacketWritable()) {
                                                eBCOTRateAllocator2.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), false, zEquals, zEquals2);
                                                eBCOTRateAllocator2.bsWriter.writePacketBody(eBCOTRateAllocator2.pktEnc.getLastBodyBuf(), eBCOTRateAllocator2.pktEnc.getLastBodyLen(), false, eBCOTRateAllocator2.pktEnc.isROIinPkt(), eBCOTRateAllocator2.pktEnc.getROILen());
                                            }
                                            bitOutputBuffer2 = bitOutputBufferEncodePacket;
                                        } else {
                                            i15 = i55;
                                            i16 = i51;
                                            i17 = i52;
                                            i18 = i48;
                                            i19 = i33;
                                            i20 = i25;
                                            eBCOTRateAllocator2 = eBCOTRateAllocator3;
                                            i21 = i50;
                                        }
                                        i55 = i15 + 1;
                                        i52 = i17;
                                        eBCOTRateAllocator3 = eBCOTRateAllocator2;
                                        i50 = i21;
                                        i54 = i56;
                                        i51 = i16;
                                        i33 = i19;
                                        i25 = i20;
                                        i48 = i18;
                                    }
                                    i8 = i54;
                                    i9 = i51;
                                    i10 = i52;
                                    i11 = i48;
                                    i12 = i33;
                                    i13 = i25;
                                    eBCOTRateAllocator = eBCOTRateAllocator3;
                                    i14 = i50;
                                    int[] iArr7 = iArr5[i10];
                                    iArr7[i47] = iArr7[i47] + 1;
                                    i52 = i10 + 1;
                                    eBCOTRateAllocator3 = eBCOTRateAllocator;
                                    i50 = i14;
                                    bitOutputBuffer = bitOutputBuffer2;
                                    i26 = i7;
                                    i49 = i8;
                                    i51 = i9;
                                    i33 = i12;
                                    i25 = i13;
                                    i48 = i11;
                                }
                            }
                            i8 = i49;
                        }
                        i9 = i51;
                        i10 = i52;
                        i11 = i48;
                        i12 = i33;
                        i13 = i25;
                        eBCOTRateAllocator = eBCOTRateAllocator3;
                        i14 = i50;
                        i52 = i10 + 1;
                        eBCOTRateAllocator3 = eBCOTRateAllocator;
                        i50 = i14;
                        bitOutputBuffer = bitOutputBuffer2;
                        i26 = i7;
                        i49 = i8;
                        i51 = i9;
                        i33 = i12;
                        i25 = i13;
                        i48 = i11;
                    }
                    BitOutputBuffer bitOutputBuffer3 = bitOutputBuffer;
                    int i58 = i26;
                    int i59 = i48;
                    int i60 = i33;
                    int i61 = i25;
                    EBCOTRateAllocator eBCOTRateAllocator4 = eBCOTRateAllocator3;
                    int i62 = i51;
                    int i63 = i50;
                    i49 = i62 != i46 ? i29 + (i62 * i35) : i61;
                    i51 = i62 + 1;
                    eBCOTRateAllocator3 = eBCOTRateAllocator4;
                    i50 = i63;
                    bitOutputBuffer = bitOutputBuffer3;
                    i26 = i58;
                    i33 = i60;
                    i25 = i61;
                    i48 = i59;
                }
                int i64 = i49;
                int i65 = i26;
                int i66 = i33;
                int i67 = i25;
                EBCOTRateAllocator eBCOTRateAllocator5 = eBCOTRateAllocator3;
                int i68 = i50;
                i48 = i68 != i45 ? i30 + (i68 * i34) : i65;
                i50 = i68 + 1;
                eBCOTRateAllocator3 = eBCOTRateAllocator5;
                i26 = i65;
                i49 = i64;
                i33 = i66;
                i25 = i67;
            }
            i47++;
            i33 = i33;
        }
        EBCOTRateAllocator eBCOTRateAllocator6 = eBCOTRateAllocator3;
        for (int i69 = i4; i69 < i5; i69++) {
            int i70 = eBCOTRateAllocator6.src.getAnSubbandTree(i24, i69).resLvl;
            for (int i71 = i2; i71 < i3; i71++) {
                if (i71 <= i70 && iArr5[i69][i71] < (eBCOTRateAllocator6.numPrec[i24][i69][i71].x * eBCOTRateAllocator6.numPrec[i24][i69][i71].y) - 1) {
                    throw new Error("JJ2000 bug: One precinct at least has not been written for resolution level " + i71 + " of component " + i69 + " in tile " + i24 + ".");
                }
            }
        }
    }

    private float optimizeBitstreamLayer(int i, float f, int i2, int i3) throws IOException {
        float f2;
        float f3;
        int i4;
        boolean z;
        boolean z2;
        this.pktEnc.save();
        int numTiles = this.src.getNumTiles();
        int numComps = this.src.getNumComps();
        int i5 = 63;
        while (i5 > 0 && this.RDSlopesRates[i5] < i2) {
            i5--;
        }
        float slopeFromSIndex = getSlopeFromSIndex(i5);
        if (slopeFromSIndex >= f) {
            i5--;
            slopeFromSIndex = getSlopeFromSIndex(i5);
        }
        if (i5 <= 0) {
            slopeFromSIndex = 0.0f;
        }
        float f4 = (f + slopeFromSIndex) / 2.0f;
        BitOutputBuffer bitOutputBuffer = null;
        if (f4 <= slopeFromSIndex) {
            f3 = f;
            f2 = f3;
        } else {
            f2 = f;
            f3 = f4;
        }
        float f5 = slopeFromSIndex;
        byte[] bArr = null;
        do {
            int i6 = 0;
            this.src.setTile(0, 0);
            int i7 = i3;
            int i8 = 0;
            while (i8 < numTiles) {
                int i9 = 0;
                while (i9 < numComps) {
                    boolean zEqualsIgnoreCase = ((String) this.encSpec.sops.getTileDef(i8)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                    boolean zEqualsIgnoreCase2 = ((String) this.encSpec.ephs.getTileDef(i8)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                    SubbandAn anSubbandTree = this.src.getAnSubbandTree(i8, i9);
                    int i10 = anSubbandTree.resLvl + 1;
                    SubbandAn subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(i6, i6);
                    while (i6 < i10) {
                        byte[] bArr2 = bArr;
                        int i11 = this.numPrec[i8][i9][i6].y * this.numPrec[i8][i9][i6].x;
                        int iWritePacketHead = i7;
                        BitOutputBuffer bitOutputBufferEncodePacket = bitOutputBuffer;
                        int i12 = i9;
                        SubbandAn subbandAn2 = subbandAn;
                        byte[] bArr3 = bArr2;
                        int i13 = 0;
                        while (i13 < i11) {
                            int i14 = i6;
                            int i15 = i11;
                            findTruncIndices(i, i12, i14, i8, subbandAn2, f3, i13);
                            int i16 = i12;
                            bitOutputBufferEncodePacket = this.pktEnc.encodePacket(i + 1, i16, i14, i8, this.cblks[i8][i12][i14], this.truncIdxs[i8][i][i12][i14], bitOutputBufferEncodePacket, bArr3, i13);
                            if (this.pktEnc.isPacketWritable()) {
                                byte[] lastBodyBuf = this.pktEnc.getLastBodyBuf();
                                i4 = i16;
                                boolean z3 = zEqualsIgnoreCase2;
                                boolean z4 = zEqualsIgnoreCase;
                                z2 = z4;
                                z = z3;
                                iWritePacketHead = iWritePacketHead + this.bsWriter.writePacketHead(bitOutputBufferEncodePacket.getBuffer(), bitOutputBufferEncodePacket.getLength(), true, z4, z3) + this.bsWriter.writePacketBody(lastBodyBuf, this.pktEnc.getLastBodyLen(), true, this.pktEnc.isROIinPkt(), this.pktEnc.getROILen());
                                bArr3 = lastBodyBuf;
                            } else {
                                i4 = i16;
                                z = zEqualsIgnoreCase2;
                                z2 = zEqualsIgnoreCase;
                            }
                            i13++;
                            zEqualsIgnoreCase = z2;
                            i11 = i15;
                            i12 = i4;
                            zEqualsIgnoreCase2 = z;
                            i6 = i14;
                        }
                        subbandAn = subbandAn2.parent;
                        i6++;
                        i9 = i12;
                        bitOutputBuffer = bitOutputBufferEncodePacket;
                        bArr = bArr3;
                        zEqualsIgnoreCase2 = zEqualsIgnoreCase2;
                        i7 = iWritePacketHead;
                    }
                    i9++;
                    i6 = 0;
                }
                i8++;
                i6 = 0;
            }
            if (i7 > i2) {
                f5 = f3;
            } else {
                f2 = f3;
            }
            float f6 = (f2 + f5) / 2.0f;
            f3 = f6 <= f5 ? f2 : f6;
            this.pktEnc.restore();
            if (f3 >= 0.9999f * f2) {
                break;
            }
        } while (f3 < f2 - FLOAT_ABS_PRECISION);
        if (f3 <= FLOAT_ABS_PRECISION) {
            return 0.0f;
        }
        return f2;
    }

    private float estimateLayerThreshold(int i, EBCOTLayer eBCOTLayer) {
        float fLog;
        float fLog2;
        double dLog;
        float fLog3;
        float fLog4;
        double dLog2;
        float f = eBCOTLayer.rdThreshold;
        float f2 = this.maxSlope;
        if (f > f2) {
            f = f2;
        }
        if (f < FLOAT_ABS_PRECISION) {
            return 0.0f;
        }
        int limitedSIndexFromSlope = getLimitedSIndexFromSlope(f);
        if (limitedSIndexFromSlope >= 63) {
            limitedSIndexFromSlope = 62;
        }
        if (this.RDSlopesRates[limitedSIndexFromSlope + 1] == 0) {
            fLog = (float) Math.log((r5[limitedSIndexFromSlope] << 1) + 1);
            fLog2 = (float) Math.log(this.RDSlopesRates[limitedSIndexFromSlope] + 1);
            dLog = Math.log(eBCOTLayer.actualBytes + this.RDSlopesRates[limitedSIndexFromSlope] + 1);
        } else {
            fLog = (float) Math.log(r5[limitedSIndexFromSlope]);
            fLog2 = (float) Math.log(this.RDSlopesRates[r6]);
            dLog = Math.log(eBCOTLayer.actualBytes);
        }
        float fLog5 = (float) Math.log(getSlopeFromSIndex(limitedSIndexFromSlope));
        float fLog6 = ((float) dLog) - (fLog + (((((float) Math.log(f)) - fLog5) * (fLog - fLog2)) / (fLog5 - ((float) Math.log(getSlopeFromSIndex(r6))))));
        if (fLog6 < 0.0f) {
            fLog6 = 0.0f;
        }
        int iExp = (int) (i / ((float) Math.exp(fLog6)));
        int i2 = 63;
        while (i2 >= 0 && this.RDSlopesRates[i2] < iExp) {
            i2--;
        }
        int i3 = i2 + 1;
        int i4 = i3 < 64 ? i3 : 63;
        if (i4 <= 0) {
            i4 = 1;
        }
        int i5 = this.RDSlopesRates[i4];
        if (i5 == 0) {
            int i6 = i4 - 1;
            fLog3 = (float) Math.log(r13[i6] + 1);
            fLog4 = (float) Math.log((this.RDSlopesRates[i6] << 1) + 1);
            dLog2 = Math.log(iExp + this.RDSlopesRates[i6] + 1);
        } else {
            fLog3 = (float) Math.log(i5);
            fLog4 = (float) Math.log(this.RDSlopesRates[i4 - 1]);
            dLog2 = Math.log(iExp);
        }
        float fLog7 = (float) Math.log(getSlopeFromSIndex(i4));
        float fExp = (float) Math.exp(fLog7 + (((((float) dLog2) - fLog3) * (fLog7 - ((float) Math.log(getSlopeFromSIndex(i4 - 1))))) / (fLog3 - fLog4)));
        if (fExp <= f) {
            f = fExp;
        }
        if (f < FLOAT_ABS_PRECISION) {
            return 0.0f;
        }
        return f;
    }

    private void findTruncIndices(int i, int i2, int i3, int i4, SubbandAn subbandAn, float f, int i5) {
        PrecInfo precInfo = this.pktEnc.getPrecInfo(i4, i2, i3, i5);
        for (SubbandAn subbandAn2 = subbandAn; subbandAn2.subb_HH != null; subbandAn2 = subbandAn2.subb_HH) {
        }
        int i6 = i3 == 0 ? 0 : 1;
        int i7 = i3 != 0 ? 4 : 1;
        SubbandAn subbandAn3 = (SubbandAn) subbandAn.getSubbandByIdx(i3, i6);
        while (i6 < i7) {
            int length = precInfo.cblk[i6] != null ? precInfo.cblk[i6].length : 0;
            for (int i8 = 0; i8 < length; i8++) {
                int length2 = precInfo.cblk[i6][i8] != null ? precInfo.cblk[i6][i8].length : 0;
                for (int i9 = 0; i9 < length2; i9++) {
                    Coord coord = precInfo.cblk[i6][i8][i9].idx;
                    int i10 = coord.x + (coord.y * subbandAn3.numCb.x);
                    CBlkRateDistStats cBlkRateDistStats = this.cblks[i4][i2][i3][i6][i10];
                    int i11 = 0;
                    while (i11 < cBlkRateDistStats.nVldTrunc && cBlkRateDistStats.truncSlopes[i11] >= f) {
                        i11++;
                    }
                    this.truncIdxs[i4][i][i2][i3][i6][i10] = i11 - 1;
                }
            }
            subbandAn3 = (SubbandAn) subbandAn3.nextSubband();
            i6++;
        }
    }

    private static int getLimitedSIndexFromSlope(float f) {
        int iFloor = ((int) Math.floor(Math.log(f) / LOG2)) + 24;
        if (iFloor < 0) {
            return 0;
        }
        if (iFloor >= 64) {
            return 63;
        }
        return iFloor;
    }

    private static float getSlopeFromSIndex(int i) {
        return (float) Math.pow(2.0d, i - 24);
    }
}
