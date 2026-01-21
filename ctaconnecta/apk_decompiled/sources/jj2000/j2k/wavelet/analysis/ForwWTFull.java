package jj2000.j2k.wavelet.analysis;

import java.lang.reflect.Array;
import jj2000.j2k.IntegerSpec;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.entropy.CBlkSizeSpec;
import jj2000.j2k.entropy.PrecinctSizeSpec;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.Coord;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.wavelet.Subband;

/* loaded from: classes5.dex */
public class ForwWTFull extends ForwardWT {
    private int cb0x;
    private int cb0y;
    private CBlkSizeSpec cblks;
    SubbandAn[] currentSubband;
    private DataBlk[] decomposedComps;
    private IntegerSpec dls;
    private AnWTFilterSpec filters;
    private boolean intData;
    private int[] lastm;
    private int[] lastn;
    Coord ncblks;
    private PrecinctSizeSpec pss;
    private BlkImgDataSrc src;
    private SubbandAn[][] subbTrees;

    @Override // jj2000.j2k.wavelet.analysis.ForwWT
    public int getDecomp(int i, int i2) {
        return 0;
    }

    @Override // jj2000.j2k.wavelet.WaveletTransform
    public int getImplementationType(int i) {
        return 2;
    }

    public ForwWTFull(BlkImgDataSrc blkImgDataSrc, EncoderSpecs encoderSpecs, int i, int i2) {
        super(blkImgDataSrc);
        this.src = blkImgDataSrc;
        this.cb0x = i;
        this.cb0y = i2;
        this.dls = encoderSpecs.dls;
        this.filters = encoderSpecs.wfs;
        this.cblks = encoderSpecs.cblks;
        this.pss = encoderSpecs.pss;
        int numComps = blkImgDataSrc.getNumComps();
        int numTiles = blkImgDataSrc.getNumTiles();
        this.currentSubband = new SubbandAn[numComps];
        this.decomposedComps = new DataBlk[numComps];
        this.subbTrees = (SubbandAn[][]) Array.newInstance((Class<?>) SubbandAn.class, numTiles, numComps);
        this.lastn = new int[numComps];
        this.lastm = new int[numComps];
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWT
    public int getDecompLevels(int i, int i2) {
        return ((Integer) this.dls.getTileCompVal(i, i2)).intValue();
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWT
    public AnWTFilter[] getHorAnWaveletFilters(int i, int i2) {
        return this.filters.getHFilters(i, i2);
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWT
    public AnWTFilter[] getVertAnWaveletFilters(int i, int i2) {
        return this.filters.getVFilters(i, i2);
    }

    @Override // jj2000.j2k.wavelet.WaveletTransform, jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public boolean isReversible(int i, int i2) {
        return this.filters.isReversible(i, i2);
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public int getCbULX() {
        return this.cb0x;
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public int getCbULY() {
        return this.cb0y;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTDataSrc
    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(i);
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTDataSrc
    public CBlkWTData getNextInternCodeBlock(int i, CBlkWTData cBlkWTData) {
        CBlkWTData cBlkWTDataFloat;
        DataBlk dataBlkFloat;
        int i2 = 0;
        this.intData = this.filters.getWTDataType(this.tIdx, i) == 3;
        if (this.decomposedComps[i] == null) {
            int tileCompWidth = getTileCompWidth(this.tIdx, i);
            int tileCompHeight = getTileCompHeight(this.tIdx, i);
            if (this.intData) {
                this.decomposedComps[i] = new DataBlkInt(0, 0, tileCompWidth, tileCompHeight);
                dataBlkFloat = new DataBlkInt();
            } else {
                this.decomposedComps[i] = new DataBlkFloat(0, 0, tileCompWidth, tileCompHeight);
                dataBlkFloat = new DataBlkFloat();
            }
            Object data = this.decomposedComps[i].getData();
            int compULX = getCompULX(i);
            dataBlkFloat.ulx = compULX;
            dataBlkFloat.w = tileCompWidth;
            dataBlkFloat.h = 1;
            int compULY = getCompULY(i);
            int i3 = 0;
            while (i3 < tileCompHeight) {
                dataBlkFloat.uly = compULY;
                dataBlkFloat.ulx = compULX;
                dataBlkFloat = this.src.getInternCompData(dataBlkFloat, i);
                System.arraycopy(dataBlkFloat.getData(), dataBlkFloat.offset, data, i3 * tileCompWidth, tileCompWidth);
                i3++;
                compULY++;
            }
            waveletTreeDecomposition(this.decomposedComps[i], getAnSubbandTree(this.tIdx, i), i);
            this.currentSubband[i] = getNextSubband(i);
            this.lastn[i] = -1;
            this.lastm[i] = 0;
        }
        do {
            Coord coord = this.currentSubband[i].numCb;
            this.ncblks = coord;
            int[] iArr = this.lastn;
            int i4 = iArr[i] + 1;
            iArr[i] = i4;
            if (i4 == coord.x) {
                this.lastn[i] = 0;
                int[] iArr2 = this.lastm;
                iArr2[i] = iArr2[i] + 1;
            }
            if (this.lastm[i] >= this.ncblks.y) {
                this.currentSubband[i] = getNextSubband(i);
                this.lastn[i] = -1;
                this.lastm[i] = 0;
            } else {
                int i5 = this.cb0x;
                int i6 = this.cb0y;
                int i7 = this.currentSubband[i].sbandIdx;
                if (i7 == 0) {
                    i2 = i5;
                } else if (i7 != 1) {
                    if (i7 == 2) {
                        i2 = i5;
                    } else if (i7 != 3) {
                        throw new Error("Internal JJ2000 error");
                    }
                    i6 = 0;
                }
                if (cBlkWTData != null) {
                    cBlkWTDataFloat = cBlkWTData;
                } else if (this.intData) {
                    cBlkWTDataFloat = new CBlkWTDataInt();
                } else {
                    cBlkWTDataFloat = new CBlkWTDataFloat();
                }
                int i8 = this.lastn[i];
                int i9 = this.lastm[i];
                SubbandAn subbandAn = this.currentSubband[i];
                cBlkWTDataFloat.n = i8;
                cBlkWTDataFloat.m = i9;
                cBlkWTDataFloat.sb = subbandAn;
                int i10 = (((subbandAn.ulcx - i2) + subbandAn.nomCBlkW) / subbandAn.nomCBlkW) - 1;
                int i11 = (((subbandAn.ulcy - i6) + subbandAn.nomCBlkH) / subbandAn.nomCBlkH) - 1;
                if (i8 == 0) {
                    cBlkWTDataFloat.ulx = subbandAn.ulx;
                } else {
                    cBlkWTDataFloat.ulx = (((i10 + i8) * subbandAn.nomCBlkW) - (subbandAn.ulcx - i2)) + subbandAn.ulx;
                }
                if (i9 == 0) {
                    cBlkWTDataFloat.uly = subbandAn.uly;
                } else {
                    cBlkWTDataFloat.uly = (((i11 + i9) * subbandAn.nomCBlkH) - (subbandAn.ulcy - i6)) + subbandAn.uly;
                }
                if (i8 < this.ncblks.x - 1) {
                    cBlkWTDataFloat.w = (((((i10 + i8) + 1) * subbandAn.nomCBlkW) - (subbandAn.ulcx - i2)) + subbandAn.ulx) - cBlkWTDataFloat.ulx;
                } else {
                    cBlkWTDataFloat.w = (subbandAn.ulx + subbandAn.w) - cBlkWTDataFloat.ulx;
                }
                if (i9 < this.ncblks.y - 1) {
                    cBlkWTDataFloat.h = (((((i11 + i9) + 1) * subbandAn.nomCBlkH) - (subbandAn.ulcy - i6)) + subbandAn.uly) - cBlkWTDataFloat.uly;
                } else {
                    cBlkWTDataFloat.h = (subbandAn.uly + subbandAn.h) - cBlkWTDataFloat.uly;
                }
                cBlkWTDataFloat.wmseScaling = 1.0f;
                cBlkWTDataFloat.offset = (cBlkWTDataFloat.uly * this.decomposedComps[i].w) + cBlkWTDataFloat.ulx;
                cBlkWTDataFloat.scanw = this.decomposedComps[i].w;
                cBlkWTDataFloat.setData(this.decomposedComps[i].getData());
                return cBlkWTDataFloat;
            }
        } while (this.currentSubband[i] != null);
        this.decomposedComps[i] = null;
        return null;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTDataSrc
    public CBlkWTData getNextCodeBlock(int i, CBlkWTData cBlkWTData) {
        this.intData = this.filters.getWTDataType(this.tIdx, i) == 3;
        Object data = cBlkWTData != null ? cBlkWTData.getData() : null;
        CBlkWTData nextInternCodeBlock = getNextInternCodeBlock(i, cBlkWTData);
        if (nextInternCodeBlock == null) {
            return null;
        }
        if (this.intData) {
            int[] iArr = (int[]) data;
            if (iArr == null || iArr.length < nextInternCodeBlock.w * nextInternCodeBlock.h) {
                data = new int[nextInternCodeBlock.w * nextInternCodeBlock.h];
            }
        } else {
            float[] fArr = (float[]) data;
            if (fArr == null || fArr.length < nextInternCodeBlock.w * nextInternCodeBlock.h) {
                data = new float[nextInternCodeBlock.w * nextInternCodeBlock.h];
            }
        }
        Object data2 = nextInternCodeBlock.getData();
        int i2 = nextInternCodeBlock.w;
        int i3 = (nextInternCodeBlock.h - 1) * i2;
        int i4 = nextInternCodeBlock.offset + ((nextInternCodeBlock.h - 1) * nextInternCodeBlock.scanw);
        while (i3 >= 0) {
            System.arraycopy(data2, i4, data, i3, i2);
            i3 -= i2;
            i4 -= nextInternCodeBlock.scanw;
        }
        nextInternCodeBlock.setData(data);
        nextInternCodeBlock.offset = 0;
        nextInternCodeBlock.scanw = i2;
        return nextInternCodeBlock;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTDataSrc
    public int getDataType(int i, int i2) {
        return this.filters.getWTDataType(i, i2);
    }

    private SubbandAn getNextSubband(int i) {
        SubbandAn subbandAn;
        SubbandAn anSubbandTree = this.currentSubband[i];
        if (anSubbandTree == null) {
            anSubbandTree = getAnSubbandTree(this.tIdx, i);
            if (!anSubbandTree.isNode) {
                return anSubbandTree;
            }
        }
        boolean z = true;
        while (anSubbandTree != null) {
            if (!anSubbandTree.isNode) {
                int i2 = anSubbandTree.orientation;
                if (i2 != 0) {
                    if (i2 == 1) {
                        anSubbandTree = (SubbandAn) anSubbandTree.getParent().getLL();
                    } else if (i2 == 2) {
                        anSubbandTree = (SubbandAn) anSubbandTree.getParent().getHL();
                    } else if (i2 == 3) {
                        anSubbandTree = (SubbandAn) anSubbandTree.getParent().getLH();
                    }
                    z = true;
                } else {
                    anSubbandTree = (SubbandAn) anSubbandTree.getParent();
                    z = false;
                }
            } else if (anSubbandTree.isNode) {
                if (z) {
                    anSubbandTree = (SubbandAn) anSubbandTree.getHH();
                } else if (!z) {
                    int i3 = anSubbandTree.orientation;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            subbandAn = (SubbandAn) anSubbandTree.getParent().getLL();
                        } else if (i3 == 2) {
                            subbandAn = (SubbandAn) anSubbandTree.getParent().getHL();
                        } else if (i3 == 3) {
                            subbandAn = (SubbandAn) anSubbandTree.getParent().getLH();
                        }
                        anSubbandTree = subbandAn;
                        z = true;
                    } else {
                        anSubbandTree = (SubbandAn) anSubbandTree.getParent();
                        z = false;
                    }
                }
            }
            if (anSubbandTree == null || !anSubbandTree.isNode) {
                return anSubbandTree;
            }
        }
        return anSubbandTree;
    }

    private void waveletTreeDecomposition(DataBlk dataBlk, SubbandAn subbandAn, int i) {
        if (subbandAn.isNode) {
            wavelet2DDecomposition(dataBlk, subbandAn, i);
            waveletTreeDecomposition(dataBlk, (SubbandAn) subbandAn.getHH(), i);
            waveletTreeDecomposition(dataBlk, (SubbandAn) subbandAn.getLH(), i);
            waveletTreeDecomposition(dataBlk, (SubbandAn) subbandAn.getHL(), i);
            waveletTreeDecomposition(dataBlk, (SubbandAn) subbandAn.getLL(), i);
        }
    }

    private void wavelet2DDecomposition(DataBlk dataBlk, SubbandAn subbandAn, int i) {
        int i2;
        if (subbandAn.w == 0 || subbandAn.h == 0) {
            return;
        }
        int i3 = subbandAn.ulx;
        int i4 = subbandAn.uly;
        int i5 = subbandAn.w;
        int i6 = subbandAn.h;
        int tileCompWidth = getTileCompWidth(this.tIdx, i);
        getTileCompHeight(this.tIdx, i);
        if (this.intData) {
            int[] iArr = new int[Math.max(i5, i6)];
            int[] dataInt = ((DataBlkInt) dataBlk).getDataInt();
            if (subbandAn.ulcy % 2 == 0) {
                for (int i7 = 0; i7 < i5; i7++) {
                    int i8 = (i4 * tileCompWidth) + i3 + i7;
                    for (int i9 = 0; i9 < i6; i9++) {
                        iArr[i9] = dataInt[(i9 * tileCompWidth) + i8];
                    }
                    subbandAn.vFilter.analyze_lpf(iArr, 0, i6, 1, dataInt, i8, tileCompWidth, dataInt, i8 + (((i6 + 1) / 2) * tileCompWidth), tileCompWidth);
                }
            } else {
                for (int i10 = 0; i10 < i5; i10++) {
                    int i11 = (i4 * tileCompWidth) + i3 + i10;
                    for (int i12 = 0; i12 < i6; i12++) {
                        iArr[i12] = dataInt[(i12 * tileCompWidth) + i11];
                    }
                    subbandAn.vFilter.analyze_hpf(iArr, 0, i6, 1, dataInt, i11, tileCompWidth, dataInt, i11 + ((i6 / 2) * tileCompWidth), tileCompWidth);
                }
            }
            int i13 = i6;
            if (subbandAn.ulcx % 2 != 0) {
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = ((i4 + i14) * tileCompWidth) + i3;
                    for (int i16 = 0; i16 < i5; i16++) {
                        iArr[i16] = dataInt[i15 + i16];
                    }
                    int[] iArr2 = dataInt;
                    subbandAn.hFilter.analyze_hpf(iArr, 0, i5, 1, iArr2, i15, 1, iArr2, (i5 / 2) + i15, 1);
                    dataInt = iArr2;
                }
                return;
            }
            int i17 = 0;
            while (i17 < i13) {
                int i18 = ((i4 + i17) * tileCompWidth) + i3;
                for (int i19 = 0; i19 < i5; i19++) {
                    iArr[i19] = dataInt[i18 + i19];
                }
                int[] iArr3 = dataInt;
                subbandAn.hFilter.analyze_lpf(iArr, 0, i5, 1, iArr3, i18, 1, iArr3, ((i5 + 1) / 2) + i18, 1);
                dataInt = iArr3;
                i17++;
                i13 = i13;
            }
            return;
        }
        float[] fArr = new float[Math.max(i5, i6)];
        float[] dataFloat = ((DataBlkFloat) dataBlk).getDataFloat();
        if (subbandAn.ulcy % 2 == 0) {
            for (int i20 = 0; i20 < i5; i20++) {
                int i21 = (i4 * tileCompWidth) + i3 + i20;
                for (int i22 = 0; i22 < i6; i22++) {
                    fArr[i22] = dataFloat[(i22 * tileCompWidth) + i21];
                }
                subbandAn.vFilter.analyze_lpf(fArr, 0, i6, 1, dataFloat, i21, tileCompWidth, dataFloat, i21 + (((i6 + 1) / 2) * tileCompWidth), tileCompWidth);
            }
            i2 = i6;
        } else {
            for (int i23 = 0; i23 < i5; i23++) {
                int i24 = (i4 * tileCompWidth) + i3 + i23;
                for (int i25 = 0; i25 < i6; i25++) {
                    fArr[i25] = dataFloat[(i25 * tileCompWidth) + i24];
                }
                subbandAn.vFilter.analyze_hpf(fArr, 0, i6, 1, dataFloat, i24, tileCompWidth, dataFloat, i24 + ((i6 / 2) * tileCompWidth), tileCompWidth);
            }
            i2 = i6;
        }
        if (subbandAn.ulcx % 2 == 0) {
            for (int i26 = 0; i26 < i2; i26++) {
                int i27 = ((i4 + i26) * tileCompWidth) + i3;
                for (int i28 = 0; i28 < i5; i28++) {
                    fArr[i28] = dataFloat[i27 + i28];
                }
                float[] fArr2 = dataFloat;
                subbandAn.hFilter.analyze_lpf(fArr, 0, i5, 1, fArr2, i27, 1, fArr2, ((i5 + 1) / 2) + i27, 1);
                dataFloat = fArr2;
            }
            return;
        }
        for (int i29 = 0; i29 < i2; i29++) {
            int i30 = ((i4 + i29) * tileCompWidth) + i3;
            for (int i31 = 0; i31 < i5; i31++) {
                fArr[i31] = dataFloat[i30 + i31];
            }
            float[] fArr3 = dataFloat;
            subbandAn.hFilter.analyze_hpf(fArr, 0, i5, 1, fArr3, i30, 1, fArr3, (i5 / 2) + i30, 1);
            dataFloat = fArr3;
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        super.setTile(i, i2);
        DataBlk[] dataBlkArr = this.decomposedComps;
        if (dataBlkArr != null) {
            for (int length = dataBlkArr.length - 1; length >= 0; length--) {
                this.decomposedComps[length] = null;
                this.currentSubband[length] = null;
            }
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void nextTile() {
        super.nextTile();
        DataBlk[] dataBlkArr = this.decomposedComps;
        if (dataBlkArr != null) {
            for (int length = dataBlkArr.length - 1; length >= 0; length--) {
                this.decomposedComps[length] = null;
                this.currentSubband[length] = null;
            }
        }
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public SubbandAn getAnSubbandTree(int i, int i2) {
        SubbandAn[] subbandAnArr = this.subbTrees[i];
        if (subbandAnArr[i2] == null) {
            subbandAnArr[i2] = new SubbandAn(getTileCompWidth(i, i2), getTileCompHeight(i, i2), getCompULX(i2), getCompULY(i2), getDecompLevels(i, i2), getHorAnWaveletFilters(i, i2), getVertAnWaveletFilters(i, i2));
            initSubbandsFields(i, i2, this.subbTrees[i][i2]);
        }
        return this.subbTrees[i][i2];
    }

    private void initSubbandsFields(int i, int i2, Subband subband) {
        int cBlkWidth = this.cblks.getCBlkWidth((byte) 3, i, i2);
        int cBlkHeight = this.cblks.getCBlkHeight((byte) 3, i, i2);
        if (!subband.isNode) {
            int ppx = this.pss.getPPX(i, i2, subband.resLvl);
            int ppy = this.pss.getPPY(i, i2, subband.resLvl);
            if (ppx != 65535 || ppy != 65535) {
                int iLog2 = MathUtil.log2(ppx);
                int iLog22 = MathUtil.log2(ppy);
                int iLog23 = MathUtil.log2(cBlkWidth);
                int iLog24 = MathUtil.log2(cBlkHeight);
                if (subband.resLvl == 0) {
                    subband.nomCBlkW = iLog23 < iLog2 ? 1 << iLog23 : 1 << iLog2;
                    subband.nomCBlkH = iLog24 < iLog22 ? 1 << iLog24 : 1 << iLog22;
                } else {
                    int i3 = iLog2 - 1;
                    subband.nomCBlkW = iLog23 < i3 ? 1 << iLog23 : 1 << i3;
                    int i4 = iLog22 - 1;
                    subband.nomCBlkH = iLog24 < i4 ? 1 << iLog24 : 1 << i4;
                }
            } else {
                subband.nomCBlkW = cBlkWidth;
                subband.nomCBlkH = cBlkHeight;
            }
            if (subband.numCb == null) {
                subband.numCb = new Coord();
            }
            int i5 = 0;
            if (subband.w != 0 && subband.h != 0) {
                int i6 = this.cb0x;
                int i7 = this.cb0y;
                int i8 = subband.sbandIdx;
                if (i8 == 0) {
                    i5 = i6;
                } else if (i8 != 1) {
                    if (i8 == 2) {
                        i5 = i6;
                    } else if (i8 != 3) {
                        throw new Error("Internal JJ2000 error");
                    }
                    i7 = 0;
                }
                if (subband.ulcx - i5 < 0 || subband.ulcy - i7 < 0) {
                    throw new IllegalArgumentException("Invalid code-blocks partition origin or image offset in the reference grid.");
                }
                int i9 = (subband.ulcx - i5) + subband.nomCBlkW;
                subband.numCb.x = (((subband.w + i9) - 1) / subband.nomCBlkW) - ((i9 / subband.nomCBlkW) - 1);
                int i10 = (subband.ulcy - i7) + subband.nomCBlkH;
                subband.numCb.y = (((subband.h + i10) - 1) / subband.nomCBlkH) - ((i10 / subband.nomCBlkH) - 1);
                return;
            }
            Coord coord = subband.numCb;
            subband.numCb.y = 0;
            coord.x = 0;
            return;
        }
        initSubbandsFields(i, i2, subband.getLL());
        initSubbandsFields(i, i2, subband.getHL());
        initSubbandsFields(i, i2, subband.getLH());
        initSubbandsFields(i, i2, subband.getHH());
    }
}
