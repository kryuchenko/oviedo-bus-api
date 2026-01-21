package jj2000.j2k.codestream.reader;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Vector;
import jj2000.j2k.codestream.CBlkCoordInfo;
import jj2000.j2k.codestream.PrecInfo;
import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.image.Coord;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.util.ArrayUtil;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;

/* loaded from: classes5.dex */
public class PktDecoder implements StdEntropyCoderOptions {
    private PktHeaderBitReader bin;
    private int cQuit;
    private Vector[] cblks;
    private DecoderSpecs decSpec;
    private RandomAccessIO ehs;
    private HeaderDecoder hd;
    private boolean isTruncMode;
    private int[][][][][] lblock;
    private int maxCB;
    private int nc;
    private Coord[][] numPrec;
    private int pktIdx;
    private ByteArrayInputStream pphbais;
    private PrecInfo[][][] ppinfo;
    private int rQuit;
    private int sQuit;
    private BitstreamReaderAgent src;
    private int tIdx;
    private int tQuit;
    private TagTreeDecoder[][][][] ttIncl;
    private TagTreeDecoder[][][][] ttMaxBP;
    private int xQuit;
    private int yQuit;
    private boolean pph = false;
    private final int INIT_LBLOCK = 3;
    private int nl = 0;
    private boolean sopUsed = false;
    private boolean ephUsed = false;
    private int ncb = 0;
    private boolean ncbQuit = false;

    public PktDecoder(DecoderSpecs decoderSpecs, HeaderDecoder headerDecoder, RandomAccessIO randomAccessIO, BitstreamReaderAgent bitstreamReaderAgent, boolean z, int i) {
        this.decSpec = decoderSpecs;
        this.hd = headerDecoder;
        this.ehs = randomAccessIO;
        this.isTruncMode = z;
        this.bin = new PktHeaderBitReader(randomAccessIO);
        this.src = bitstreamReaderAgent;
        this.maxCB = i;
    }

    public CBlkInfo[][][][][] restart(int i, int[] iArr, int i2, CBlkInfo[][][][][] cBlkInfoArr, boolean z, ByteArrayInputStream byteArrayInputStream) {
        int i3 = i;
        this.nc = i3;
        this.nl = i2;
        this.tIdx = this.src.getTileIdx();
        this.pph = z;
        this.pphbais = byteArrayInputStream;
        this.sopUsed = ((Boolean) this.decSpec.sops.getTileDef(this.tIdx)).booleanValue();
        this.pktIdx = 0;
        this.ephUsed = ((Boolean) this.decSpec.ephs.getTileDef(this.tIdx)).booleanValue();
        CBlkInfo[][][][][] cBlkInfoArr2 = new CBlkInfo[i3][][][][];
        this.lblock = new int[i3][][][][];
        this.ttIncl = new TagTreeDecoder[i3][][][];
        this.ttMaxBP = new TagTreeDecoder[i3][][][];
        this.numPrec = new Coord[i3][];
        this.ppinfo = new PrecInfo[i3][][];
        int cbULX = this.src.getCbULX();
        int cbULY = this.src.getCbULY();
        int i4 = 0;
        while (i4 < i3) {
            int i5 = iArr[i4];
            cBlkInfoArr2[i4] = new CBlkInfo[i5 + 1][][][];
            this.lblock[i4] = new int[i5 + 1][][][];
            this.ttIncl[i4] = new TagTreeDecoder[i5 + 1][][];
            this.ttMaxBP[i4] = new TagTreeDecoder[i5 + 1][][];
            this.numPrec[i4] = new Coord[i5 + 1];
            this.ppinfo[i4] = new PrecInfo[i5 + 1][];
            int resULX = this.src.getResULX(i4, i5);
            int resULY = this.src.getResULY(i4, iArr[i4]);
            int tileCompWidth = this.src.getTileCompWidth(this.tIdx, i4, iArr[i4]) + resULX;
            int tileCompHeight = this.src.getTileCompHeight(this.tIdx, i4, iArr[i4]) + resULY;
            int i6 = 0;
            while (true) {
                if (i6 <= iArr[i4]) {
                    CBlkInfo[][][][][] cBlkInfoArr3 = cBlkInfoArr2;
                    int iCeil = (int) Math.ceil(resULX / (1 << (r12 - i6)));
                    int i7 = cbULX;
                    int iCeil2 = (int) Math.ceil(resULY / (1 << (iArr[i4] - i6)));
                    int i8 = cbULY;
                    int iCeil3 = (int) Math.ceil(tileCompWidth / (1 << (iArr[i4] - i6)));
                    int i9 = resULX;
                    int i10 = resULY;
                    int iCeil4 = (int) Math.ceil(tileCompHeight / (1 << (iArr[i4] - i6)));
                    double ppx = getPPX(this.tIdx, i4, i6);
                    double ppy = getPPY(this.tIdx, i4, i6);
                    this.numPrec[i4][i6] = new Coord();
                    if (iCeil3 > iCeil) {
                        this.numPrec[i4][i6].x = ((int) Math.ceil((iCeil3 - i7) / ppx)) - ((int) Math.floor((iCeil - i7) / ppx));
                    } else {
                        this.numPrec[i4][i6].x = 0;
                    }
                    if (iCeil4 > iCeil2) {
                        this.numPrec[i4][i6].y = ((int) Math.ceil((iCeil4 - i8) / ppy)) - ((int) Math.floor((iCeil2 - i8) / ppy));
                    } else {
                        this.numPrec[i4][i6].y = 0;
                    }
                    int i11 = i6 == 0 ? 1 : 4;
                    int i12 = this.numPrec[i4][i6].x * this.numPrec[i4][i6].y;
                    int i13 = i11 + 1;
                    this.ttIncl[i4][i6] = (TagTreeDecoder[][]) Array.newInstance((Class<?>) TagTreeDecoder.class, i12, i13);
                    this.ttMaxBP[i4][i6] = (TagTreeDecoder[][]) Array.newInstance((Class<?>) TagTreeDecoder.class, i12, i13);
                    cBlkInfoArr3[i4][i6] = new CBlkInfo[i13][][];
                    this.lblock[i4][i6] = new int[i13][][];
                    this.ppinfo[i4][i6] = new PrecInfo[i12];
                    fillPrecInfo(i4, i6, iArr[i4]);
                    SubbandSyn synSubbandTree = this.src.getSynSubbandTree(this.tIdx, i4);
                    for (int i14 = i6 == 0 ? 0 : 1; i14 < i11; i14++) {
                        Coord coord = ((SubbandSyn) synSubbandTree.getSubbandByIdx(i6, i14)).numCb;
                        cBlkInfoArr3[i4][i6][i14] = (CBlkInfo[][]) Array.newInstance((Class<?>) CBlkInfo.class, coord.y, coord.x);
                        this.lblock[i4][i6][i14] = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, coord.y, coord.x);
                        for (int i15 = coord.y - 1; i15 >= 0; i15--) {
                            ArrayUtil.intArraySet(this.lblock[i4][i6][i14][i15], 3);
                        }
                    }
                    i6++;
                    cBlkInfoArr2 = cBlkInfoArr3;
                    cbULX = i7;
                    cbULY = i8;
                    resULX = i9;
                    resULY = i10;
                }
            }
            i4++;
            i3 = i;
        }
        return cBlkInfoArr2;
    }

    private void fillPrecInfo(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        SubbandSyn subbandSyn;
        if (this.ppinfo[i][i2].length == 0) {
            return;
        }
        Coord tile = this.src.getTile(null);
        Coord numTiles = this.src.getNumTiles(null);
        int tilePartULX = this.src.getTilePartULX();
        int tilePartULY = this.src.getTilePartULY();
        int nomTileWidth = this.src.getNomTileWidth();
        int nomTileHeight = this.src.getNomTileHeight();
        int imgULX = this.hd.getImgULX();
        int imgULY = this.hd.getImgULY();
        this.hd.getImgWidth();
        this.hd.getImgHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        int i12 = imgULX;
        if (tile.y != 0) {
            imgULY = tilePartULY + (tile.y * nomTileHeight);
        }
        int i13 = imgULY;
        if (tile.x != numTiles.x - 1) {
            int i14 = tile.x;
        }
        if (tile.y != numTiles.y - 1) {
            int i15 = tile.y;
        }
        int compSubsX = this.hd.getCompSubsX(i);
        int compSubsY = this.hd.getCompSubsY(i);
        int resULX = this.src.getResULX(i, i3);
        int resULY = this.src.getResULY(i, i3);
        int tileCompWidth = this.src.getTileCompWidth(this.tIdx, i, i3) + resULX;
        int tileCompHeight = this.src.getTileCompHeight(this.tIdx, i, i3) + resULY;
        int i16 = i3 - i2;
        double d = 1 << i16;
        int iCeil = (int) Math.ceil(resULX / d);
        int iCeil2 = (int) Math.ceil(resULY / d);
        int iCeil3 = (int) Math.ceil(tileCompWidth / d);
        int iCeil4 = (int) Math.ceil(tileCompHeight / d);
        int cbULX = this.src.getCbULX();
        int cbULY = this.src.getCbULY();
        double ppx = getPPX(this.tIdx, i, i2);
        char c = 1;
        double ppy = getPPY(this.tIdx, i, i2);
        int i17 = (int) (ppx / 2.0d);
        int length = this.ppinfo[i][i2].length;
        int i18 = iCeil2 - cbULY;
        int iFloor = (int) Math.floor(i18 / ppy);
        int i19 = i18;
        int iFloor2 = (int) Math.floor(((iCeil4 - 1) - cbULY) / ppy);
        int i20 = iCeil - cbULX;
        int i21 = (int) (ppy / 2.0d);
        int iFloor3 = (int) Math.floor(i20 / ppx);
        int iFloor4 = (int) Math.floor(((iCeil3 - 1) - cbULX) / ppx);
        int i22 = i20;
        SubbandSyn synSubbandTree = this.src.getSynSubbandTree(this.tIdx, i);
        int i23 = (int) ppx;
        int i24 = i23 << i16;
        int i25 = i23;
        int i26 = (int) ppy;
        int i27 = i26 << i16;
        int i28 = iFloor;
        int i29 = 0;
        while (i28 <= iFloor2) {
            double d2 = ppy;
            int i30 = iFloor3;
            while (i30 <= iFloor4) {
                int i31 = (i30 != iFloor3 || i22 % (compSubsX * i25) == 0) ? (i30 * compSubsX * i24) + cbULX : i12;
                int i32 = (i28 != iFloor || i19 % (compSubsY * i26) == 0) ? cbULY + (i28 * compSubsY * i27) : i13;
                int i33 = iFloor2;
                SubbandSyn subbandSyn2 = synSubbandTree;
                int i34 = (int) (cbULY + (i28 * d2));
                int i35 = i28;
                int i36 = iFloor3;
                int i37 = iFloor4;
                int i38 = i25;
                int i39 = i27;
                int i40 = iFloor;
                int i41 = i31;
                int i42 = cbULX;
                int i43 = i21;
                int i44 = cbULY;
                int i45 = i32;
                int i46 = i22;
                int i47 = i19;
                this.ppinfo[i][i2][i29] = new PrecInfo(i2, (int) (cbULX + (i30 * ppx)), i34, i38, i26, i41, i45, i24, i39);
                if (i2 == 0) {
                    int i48 = i42 + (i30 * i38);
                    int i49 = i48 + i38;
                    int i50 = i44 + (i35 * i26);
                    int i51 = i50 + i26;
                    SubbandSyn subbandSyn3 = (SubbandSyn) subbandSyn2.getSubbandByIdx(0, 0);
                    i4 = i38;
                    if (i48 < subbandSyn3.ulcx) {
                        i48 = subbandSyn3.ulcx;
                    }
                    if (i49 > subbandSyn3.ulcx + subbandSyn3.w) {
                        i49 = subbandSyn3.ulcx + subbandSyn3.w;
                    }
                    if (i50 < subbandSyn3.ulcy) {
                        i50 = subbandSyn3.ulcy;
                    }
                    int i52 = i49;
                    if (i51 > subbandSyn3.ulcy + subbandSyn3.h) {
                        i51 = subbandSyn3.h + subbandSyn3.ulcy;
                    }
                    int i53 = subbandSyn3.nomCBlkW;
                    int i54 = subbandSyn3.nomCBlkH;
                    int i55 = i51;
                    i5 = i26;
                    int i56 = i48;
                    double d3 = i54;
                    int iFloor5 = (int) Math.floor((subbandSyn3.ulcy - i44) / d3);
                    int iFloor6 = (int) Math.floor((i50 - i44) / d3);
                    int iFloor7 = (int) Math.floor(((i55 - 1) - i44) / d3);
                    int i57 = i50;
                    double d4 = i53;
                    int iFloor8 = (int) Math.floor((subbandSyn3.ulcx - i42) / d4);
                    i6 = i24;
                    int iFloor9 = (int) Math.floor((i56 - i42) / d4);
                    int iFloor10 = (int) Math.floor(((i52 - 1) - i42) / d4);
                    if (i52 - i56 <= 0 || i55 - i57 <= 0) {
                        this.ppinfo[i][i2][i29].nblk[0] = 0;
                        this.ttIncl[i][i2][i29][0] = new TagTreeDecoder(0, 0);
                        this.ttMaxBP[i][i2][i29][0] = new TagTreeDecoder(0, 0);
                    } else {
                        int i58 = (iFloor7 - iFloor6) + 1;
                        int i59 = (iFloor10 - iFloor9) + 1;
                        this.ttIncl[i][i2][i29][0] = new TagTreeDecoder(i58, i59);
                        this.ttMaxBP[i][i2][i29][0] = new TagTreeDecoder(i58, i59);
                        CBlkCoordInfo[][][] cBlkCoordInfoArr = this.ppinfo[i][i2][i29].cblk;
                        int[] iArr = new int[2];
                        iArr[c] = i59;
                        iArr[0] = i58;
                        cBlkCoordInfoArr[0] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, iArr);
                        this.ppinfo[i][i2][i29].nblk[0] = i58 * i59;
                        int i60 = iFloor6;
                        while (i60 <= iFloor7) {
                            int i61 = iFloor9;
                            while (i61 <= iFloor10) {
                                int i62 = iFloor7;
                                int i63 = iFloor10;
                                CBlkCoordInfo cBlkCoordInfo = new CBlkCoordInfo(i60 - iFloor5, i61 - iFloor8);
                                if (i61 == iFloor8) {
                                    cBlkCoordInfo.ulx = subbandSyn3.ulx;
                                } else {
                                    cBlkCoordInfo.ulx = (subbandSyn3.ulx + (i61 * i53)) - (subbandSyn3.ulcx - i42);
                                }
                                if (i60 == iFloor5) {
                                    cBlkCoordInfo.uly = subbandSyn3.uly;
                                } else {
                                    cBlkCoordInfo.uly = (subbandSyn3.uly + (i60 * i54)) - (subbandSyn3.ulcy - i44);
                                }
                                int i64 = (i61 * i53) + i42;
                                if (i64 <= subbandSyn3.ulcx) {
                                    i64 = subbandSyn3.ulcx;
                                }
                                int i65 = i61 + 1;
                                int i66 = i60;
                                int i67 = i42 + (i65 * i53);
                                int i68 = iFloor5;
                                if (i67 > subbandSyn3.ulcx + subbandSyn3.w) {
                                    i67 = subbandSyn3.ulcx + subbandSyn3.w;
                                }
                                cBlkCoordInfo.w = i67 - i64;
                                int i69 = i44 + (i66 * i54);
                                if (i69 <= subbandSyn3.ulcy) {
                                    i69 = subbandSyn3.ulcy;
                                }
                                int i70 = i44 + ((i66 + 1) * i54);
                                int i71 = i69;
                                if (i70 > subbandSyn3.ulcy + subbandSyn3.h) {
                                    i70 = subbandSyn3.h + subbandSyn3.ulcy;
                                }
                                cBlkCoordInfo.h = i70 - i71;
                                this.ppinfo[i][i2][i29].cblk[0][i66 - iFloor6][i61 - iFloor9] = cBlkCoordInfo;
                                i61 = i65;
                                iFloor7 = i62;
                                iFloor10 = i63;
                                iFloor5 = i68;
                                i60 = i66;
                            }
                            i60++;
                        }
                    }
                    i7 = i39;
                    i8 = i30;
                    i9 = i42;
                    i10 = i17;
                    i11 = compSubsX;
                    subbandSyn = subbandSyn2;
                } else {
                    i4 = i38;
                    i5 = i26;
                    i6 = i24;
                    int i72 = i30 * i17;
                    int i73 = i72 + i17;
                    int i74 = i35 * i43;
                    int i75 = i44 + i74;
                    int i76 = i75 + i43;
                    SubbandSyn subbandSyn4 = (SubbandSyn) subbandSyn2.getSubbandByIdx(i2, 1);
                    int i77 = i72 < subbandSyn4.ulcx ? subbandSyn4.ulcx : i72;
                    int i78 = i73 > subbandSyn4.ulcx + subbandSyn4.w ? subbandSyn4.ulcx + subbandSyn4.w : i73;
                    if (i75 < subbandSyn4.ulcy) {
                        i75 = subbandSyn4.ulcy;
                    }
                    int i79 = i75;
                    if (i76 > subbandSyn4.ulcy + subbandSyn4.h) {
                        i76 = subbandSyn4.ulcy + subbandSyn4.h;
                    }
                    int i80 = subbandSyn4.nomCBlkW;
                    int i81 = subbandSyn4.nomCBlkH;
                    int i82 = i76;
                    i7 = i39;
                    i8 = i30;
                    double d5 = i81;
                    int iFloor11 = (int) Math.floor((subbandSyn4.ulcy - i44) / d5);
                    int iFloor12 = (int) Math.floor((i79 - i44) / d5);
                    int iFloor13 = (int) Math.floor(((i82 - 1) - i44) / d5);
                    i9 = i42;
                    double d6 = i80;
                    int iFloor14 = (int) Math.floor(subbandSyn4.ulcx / d6);
                    i10 = i17;
                    int iFloor15 = (int) Math.floor(i77 / d6);
                    int iFloor16 = (int) Math.floor((i78 - 1) / d6);
                    if (i78 - i77 <= 0 || i82 - i79 <= 0) {
                        this.ppinfo[i][i2][i29].nblk[1] = 0;
                        this.ttIncl[i][i2][i29][1] = new TagTreeDecoder(0, 0);
                        this.ttMaxBP[i][i2][i29][1] = new TagTreeDecoder(0, 0);
                    } else {
                        int i83 = (iFloor13 - iFloor12) + 1;
                        int i84 = (iFloor16 - iFloor15) + 1;
                        this.ttIncl[i][i2][i29][1] = new TagTreeDecoder(i83, i84);
                        this.ttMaxBP[i][i2][i29][1] = new TagTreeDecoder(i83, i84);
                        this.ppinfo[i][i2][i29].cblk[1] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, i83, i84);
                        this.ppinfo[i][i2][i29].nblk[1] = i84 * i83;
                        int i85 = iFloor12;
                        while (i85 <= iFloor13) {
                            int i86 = iFloor15;
                            while (i86 <= iFloor16) {
                                int i87 = iFloor16;
                                CBlkCoordInfo cBlkCoordInfo2 = new CBlkCoordInfo(i85 - iFloor11, i86 - iFloor14);
                                if (i86 == iFloor14) {
                                    cBlkCoordInfo2.ulx = subbandSyn4.ulx;
                                } else {
                                    cBlkCoordInfo2.ulx = (subbandSyn4.ulx + (i86 * i80)) - subbandSyn4.ulcx;
                                }
                                if (i85 == iFloor11) {
                                    cBlkCoordInfo2.uly = subbandSyn4.uly;
                                } else {
                                    cBlkCoordInfo2.uly = (subbandSyn4.uly + (i85 * i81)) - (subbandSyn4.ulcy - i44);
                                }
                                int i88 = i86 * i80;
                                if (i88 <= subbandSyn4.ulcx) {
                                    i88 = subbandSyn4.ulcx;
                                }
                                int i89 = i86 + 1;
                                int i90 = i88;
                                int i91 = i89 * i80;
                                int i92 = i85;
                                if (i91 > subbandSyn4.ulcx + subbandSyn4.w) {
                                    i91 = subbandSyn4.ulcx + subbandSyn4.w;
                                }
                                cBlkCoordInfo2.w = i91 - i90;
                                int i93 = i44 + (i92 * i81);
                                if (i93 <= subbandSyn4.ulcy) {
                                    i93 = subbandSyn4.ulcy;
                                }
                                int i94 = i44 + ((i92 + 1) * i81);
                                int i95 = i93;
                                if (i94 > subbandSyn4.ulcy + subbandSyn4.h) {
                                    i94 = subbandSyn4.h + subbandSyn4.ulcy;
                                }
                                cBlkCoordInfo2.h = i94 - i95;
                                this.ppinfo[i][i2][i29].cblk[1][i92 - iFloor12][i86 - iFloor15] = cBlkCoordInfo2;
                                i86 = i89;
                                iFloor16 = i87;
                                i85 = i92;
                            }
                            i85++;
                        }
                    }
                    int i96 = i9 + i72;
                    int i97 = i96 + i10;
                    int i98 = i74 + i43;
                    SubbandSyn subbandSyn5 = (SubbandSyn) subbandSyn2.getSubbandByIdx(i2, 2);
                    if (i96 < subbandSyn5.ulcx) {
                        i96 = subbandSyn5.ulcx;
                    }
                    if (i97 > subbandSyn5.ulcx + subbandSyn5.w) {
                        i97 = subbandSyn5.ulcx + subbandSyn5.w;
                    }
                    int i99 = i74 < subbandSyn5.ulcy ? subbandSyn5.ulcy : i74;
                    int i100 = i98 > subbandSyn5.ulcy + subbandSyn5.h ? subbandSyn5.ulcy + subbandSyn5.h : i98;
                    int i101 = subbandSyn5.nomCBlkW;
                    int i102 = subbandSyn5.nomCBlkH;
                    int i103 = i97;
                    double d7 = i102;
                    int iFloor17 = (int) Math.floor(subbandSyn5.ulcy / d7);
                    int iFloor18 = (int) Math.floor(i99 / d7);
                    int i104 = i99;
                    int i105 = i96;
                    int iFloor19 = (int) Math.floor((i100 - 1) / d7);
                    double d8 = i101;
                    int i106 = i100;
                    int iFloor20 = (int) Math.floor((subbandSyn5.ulcx - i9) / d8);
                    int iFloor21 = (int) Math.floor((i105 - i9) / d8);
                    int iFloor22 = (int) Math.floor(((i103 - 1) - i9) / d8);
                    if (i103 - i105 <= 0 || i106 - i104 <= 0) {
                        this.ppinfo[i][i2][i29].nblk[2] = 0;
                        this.ttIncl[i][i2][i29][2] = new TagTreeDecoder(0, 0);
                        this.ttMaxBP[i][i2][i29][2] = new TagTreeDecoder(0, 0);
                    } else {
                        int i107 = (iFloor19 - iFloor18) + 1;
                        int i108 = (iFloor22 - iFloor21) + 1;
                        this.ttIncl[i][i2][i29][2] = new TagTreeDecoder(i107, i108);
                        this.ttMaxBP[i][i2][i29][2] = new TagTreeDecoder(i107, i108);
                        this.ppinfo[i][i2][i29].cblk[2] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, i107, i108);
                        this.ppinfo[i][i2][i29].nblk[2] = i107 * i108;
                        int i109 = iFloor18;
                        while (i109 <= iFloor19) {
                            int i110 = iFloor21;
                            while (i110 <= iFloor22) {
                                int i111 = iFloor19;
                                int i112 = iFloor22;
                                CBlkCoordInfo cBlkCoordInfo3 = new CBlkCoordInfo(i109 - iFloor17, i110 - iFloor20);
                                if (i110 == iFloor20) {
                                    cBlkCoordInfo3.ulx = subbandSyn5.ulx;
                                } else {
                                    cBlkCoordInfo3.ulx = (subbandSyn5.ulx + (i110 * i101)) - (subbandSyn5.ulcx - i9);
                                }
                                if (i109 == iFloor17) {
                                    cBlkCoordInfo3.uly = subbandSyn5.uly;
                                } else {
                                    cBlkCoordInfo3.uly = (subbandSyn5.uly + (i109 * i102)) - subbandSyn5.ulcy;
                                }
                                int i113 = i9 + (i110 * i101);
                                if (i113 <= subbandSyn5.ulcx) {
                                    i113 = subbandSyn5.ulcx;
                                }
                                int i114 = i110 + 1;
                                int i115 = i113;
                                int i116 = i9 + (i114 * i101);
                                int i117 = i109;
                                if (i116 > subbandSyn5.ulcx + subbandSyn5.w) {
                                    i116 = subbandSyn5.ulcx + subbandSyn5.w;
                                }
                                cBlkCoordInfo3.w = i116 - i115;
                                int i118 = i117 * i102;
                                if (i118 <= subbandSyn5.ulcy) {
                                    i118 = subbandSyn5.ulcy;
                                }
                                int i119 = (i117 + 1) * i102;
                                int i120 = i118;
                                if (i119 > subbandSyn5.ulcy + subbandSyn5.h) {
                                    i119 = subbandSyn5.ulcy + subbandSyn5.h;
                                }
                                cBlkCoordInfo3.h = i119 - i120;
                                this.ppinfo[i][i2][i29].cblk[2][i117 - iFloor18][i110 - iFloor21] = cBlkCoordInfo3;
                                i110 = i114;
                                iFloor19 = i111;
                                iFloor22 = i112;
                                i109 = i117;
                            }
                            i109++;
                        }
                    }
                    SubbandSyn subbandSyn6 = (SubbandSyn) subbandSyn2.getSubbandByIdx(i2, 3);
                    if (i72 < subbandSyn6.ulcx) {
                        i72 = subbandSyn6.ulcx;
                    }
                    if (i73 > subbandSyn6.ulcx + subbandSyn6.w) {
                        i73 = subbandSyn6.ulcx + subbandSyn6.w;
                    }
                    if (i74 < subbandSyn6.ulcy) {
                        i74 = subbandSyn6.ulcy;
                    }
                    if (i98 > subbandSyn6.ulcy + subbandSyn6.h) {
                        i98 = subbandSyn6.ulcy + subbandSyn6.h;
                    }
                    int i121 = subbandSyn6.nomCBlkW;
                    int i122 = subbandSyn6.nomCBlkH;
                    double d9 = i122;
                    int iFloor23 = (int) Math.floor(subbandSyn6.ulcy / d9);
                    int iFloor24 = (int) Math.floor(i74 / d9);
                    int iFloor25 = (int) Math.floor((i98 - 1) / d9);
                    i11 = compSubsX;
                    int i123 = i73;
                    double d10 = i121;
                    int iFloor26 = (int) Math.floor(subbandSyn6.ulcx / d10);
                    int iFloor27 = (int) Math.floor(i72 / d10);
                    subbandSyn = subbandSyn2;
                    int iFloor28 = (int) Math.floor((i123 - 1) / d10);
                    if (i123 - i72 <= 0 || i98 - i74 <= 0) {
                        c = 1;
                        this.ppinfo[i][i2][i29].nblk[3] = 0;
                        this.ttIncl[i][i2][i29][3] = new TagTreeDecoder(0, 0);
                        this.ttMaxBP[i][i2][i29][3] = new TagTreeDecoder(0, 0);
                    } else {
                        int i124 = (iFloor25 - iFloor24) + 1;
                        int i125 = (iFloor28 - iFloor27) + 1;
                        this.ttIncl[i][i2][i29][3] = new TagTreeDecoder(i124, i125);
                        this.ttMaxBP[i][i2][i29][3] = new TagTreeDecoder(i124, i125);
                        c = 1;
                        this.ppinfo[i][i2][i29].cblk[3] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, i124, i125);
                        this.ppinfo[i][i2][i29].nblk[3] = i124 * i125;
                        int i126 = iFloor24;
                        while (i126 <= iFloor25) {
                            int i127 = iFloor27;
                            while (i127 <= iFloor28) {
                                CBlkCoordInfo cBlkCoordInfo4 = new CBlkCoordInfo(i126 - iFloor23, i127 - iFloor26);
                                if (i127 == iFloor26) {
                                    cBlkCoordInfo4.ulx = subbandSyn6.ulx;
                                } else {
                                    cBlkCoordInfo4.ulx = (subbandSyn6.ulx + (i127 * i121)) - subbandSyn6.ulcx;
                                }
                                if (i126 == iFloor23) {
                                    cBlkCoordInfo4.uly = subbandSyn6.uly;
                                } else {
                                    cBlkCoordInfo4.uly = (subbandSyn6.uly + (i126 * i122)) - subbandSyn6.ulcy;
                                }
                                int i128 = i127 * i121;
                                if (i128 <= subbandSyn6.ulcx) {
                                    i128 = subbandSyn6.ulcx;
                                }
                                int i129 = i127 + 1;
                                int i130 = iFloor28;
                                int i131 = i129 * i121;
                                int i132 = i126;
                                if (i131 > subbandSyn6.ulcx + subbandSyn6.w) {
                                    i131 = subbandSyn6.ulcx + subbandSyn6.w;
                                }
                                cBlkCoordInfo4.w = i131 - i128;
                                int i133 = i132 * i122;
                                if (i133 <= subbandSyn6.ulcy) {
                                    i133 = subbandSyn6.ulcy;
                                }
                                int i134 = (i132 + 1) * i122;
                                int i135 = i133;
                                if (i134 > subbandSyn6.ulcy + subbandSyn6.h) {
                                    i134 = subbandSyn6.ulcy + subbandSyn6.h;
                                }
                                cBlkCoordInfo4.h = i134 - i135;
                                this.ppinfo[i][i2][i29].cblk[3][i132 - iFloor24][i127 - iFloor27] = cBlkCoordInfo4;
                                i127 = i129;
                                iFloor28 = i130;
                                i126 = i132;
                            }
                            i126++;
                        }
                    }
                }
                i30 = i8 + 1;
                i29++;
                synSubbandTree = subbandSyn;
                cbULY = i44;
                i21 = i43;
                i19 = i47;
                iFloor = i40;
                i22 = i46;
                iFloor2 = i33;
                iFloor3 = i36;
                iFloor4 = i37;
                i28 = i35;
                i25 = i4;
                compSubsX = i11;
                i26 = i5;
                i24 = i6;
                i27 = i7;
                cbULX = i9;
                i17 = i10;
            }
            i28++;
            i21 = i21;
            i19 = i19;
            ppy = d2;
            i22 = i22;
            compSubsX = compSubsX;
            i27 = i27;
            i17 = i17;
        }
    }

    public int getNumPrecinct(int i, int i2) {
        return this.numPrec[i][i2].x * this.numPrec[i][i2].y;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x020e A[Catch: EOFException -> 0x015b, TryCatch #0 {EOFException -> 0x015b, blocks: (B:88:0x01b3, B:93:0x01cf, B:94:0x01d6, B:96:0x01eb, B:99:0x01f1, B:100:0x0204, B:102:0x020e, B:104:0x0214, B:106:0x021d, B:108:0x0227, B:111:0x0232, B:134:0x0290, B:136:0x0296, B:139:0x02b0, B:160:0x0377, B:162:0x037f, B:164:0x0384, B:166:0x0390, B:168:0x0396, B:170:0x03a3, B:140:0x02cb, B:142:0x02d3, B:143:0x02d8, B:145:0x02dc, B:147:0x02ff, B:148:0x030b, B:152:0x0315, B:158:0x034c, B:155:0x031e, B:159:0x0351, B:114:0x0258, B:116:0x025c, B:119:0x0263, B:120:0x0267, B:124:0x0275, B:130:0x0285, B:132:0x028b), top: B:196:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0258 A[Catch: EOFException -> 0x015b, TryCatch #0 {EOFException -> 0x015b, blocks: (B:88:0x01b3, B:93:0x01cf, B:94:0x01d6, B:96:0x01eb, B:99:0x01f1, B:100:0x0204, B:102:0x020e, B:104:0x0214, B:106:0x021d, B:108:0x0227, B:111:0x0232, B:134:0x0290, B:136:0x0296, B:139:0x02b0, B:160:0x0377, B:162:0x037f, B:164:0x0384, B:166:0x0390, B:168:0x0396, B:170:0x03a3, B:140:0x02cb, B:142:0x02d3, B:143:0x02d8, B:145:0x02dc, B:147:0x02ff, B:148:0x030b, B:152:0x0315, B:158:0x034c, B:155:0x031e, B:159:0x0351, B:114:0x0258, B:116:0x025c, B:119:0x0263, B:120:0x0267, B:124:0x0275, B:130:0x0285, B:132:0x028b), top: B:196:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0296 A[Catch: EOFException -> 0x015b, LOOP:6: B:134:0x0290->B:136:0x0296, LOOP_END, TryCatch #0 {EOFException -> 0x015b, blocks: (B:88:0x01b3, B:93:0x01cf, B:94:0x01d6, B:96:0x01eb, B:99:0x01f1, B:100:0x0204, B:102:0x020e, B:104:0x0214, B:106:0x021d, B:108:0x0227, B:111:0x0232, B:134:0x0290, B:136:0x0296, B:139:0x02b0, B:160:0x0377, B:162:0x037f, B:164:0x0384, B:166:0x0390, B:168:0x0396, B:170:0x03a3, B:140:0x02cb, B:142:0x02d3, B:143:0x02d8, B:145:0x02dc, B:147:0x02ff, B:148:0x030b, B:152:0x0315, B:158:0x034c, B:155:0x031e, B:159:0x0351, B:114:0x0258, B:116:0x025c, B:119:0x0263, B:120:0x0267, B:124:0x0275, B:130:0x0285, B:132:0x028b), top: B:196:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b0 A[Catch: EOFException -> 0x015b, TryCatch #0 {EOFException -> 0x015b, blocks: (B:88:0x01b3, B:93:0x01cf, B:94:0x01d6, B:96:0x01eb, B:99:0x01f1, B:100:0x0204, B:102:0x020e, B:104:0x0214, B:106:0x021d, B:108:0x0227, B:111:0x0232, B:134:0x0290, B:136:0x0296, B:139:0x02b0, B:160:0x0377, B:162:0x037f, B:164:0x0384, B:166:0x0390, B:168:0x0396, B:170:0x03a3, B:140:0x02cb, B:142:0x02d3, B:143:0x02d8, B:145:0x02dc, B:147:0x02ff, B:148:0x030b, B:152:0x0315, B:158:0x034c, B:155:0x031e, B:159:0x0351, B:114:0x0258, B:116:0x025c, B:119:0x0263, B:120:0x0267, B:124:0x0275, B:130:0x0285, B:132:0x028b), top: B:196:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02cb A[Catch: EOFException -> 0x015b, TryCatch #0 {EOFException -> 0x015b, blocks: (B:88:0x01b3, B:93:0x01cf, B:94:0x01d6, B:96:0x01eb, B:99:0x01f1, B:100:0x0204, B:102:0x020e, B:104:0x0214, B:106:0x021d, B:108:0x0227, B:111:0x0232, B:134:0x0290, B:136:0x0296, B:139:0x02b0, B:160:0x0377, B:162:0x037f, B:164:0x0384, B:166:0x0390, B:168:0x0396, B:170:0x03a3, B:140:0x02cb, B:142:0x02d3, B:143:0x02d8, B:145:0x02dc, B:147:0x02ff, B:148:0x030b, B:152:0x0315, B:158:0x034c, B:155:0x031e, B:159:0x0351, B:114:0x0258, B:116:0x025c, B:119:0x0263, B:120:0x0267, B:124:0x0275, B:130:0x0285, B:132:0x028b), top: B:196:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean readPktHead(int i, int i2, int i3, int i4, CBlkInfo[][][] cBlkInfoArr, int[] iArr) throws IOException {
        PktHeaderBitReader pktHeaderBitReader;
        int i5;
        int i6;
        SubbandSyn subbandSyn;
        int bits;
        int i7;
        int i8;
        int i9;
        int bits2;
        int i10 = i;
        int i11 = i2;
        int i12 = i4;
        int pos = this.ehs.getPos();
        if (pos >= this.ehs.length()) {
            return true;
        }
        int tileIdx = this.src.getTileIdx();
        SubbandSyn synSubbandTree = this.src.getSynSubbandTree(tileIdx, i3);
        if (this.pph) {
            pktHeaderBitReader = new PktHeaderBitReader(this.pphbais);
        } else {
            pktHeaderBitReader = this.bin;
        }
        int i13 = i11 == 0 ? 0 : 1;
        int i14 = i11 == 0 ? 1 : 4;
        boolean z = false;
        for (int i15 = i13; i15 < i14; i15++) {
            if (i12 < this.ppinfo[i3][i11].length) {
                z = true;
            }
        }
        if (!z) {
            return false;
        }
        PrecInfo precInfo = this.ppinfo[i3][i11][i12];
        pktHeaderBitReader.sync();
        if (pktHeaderBitReader.readBit() == 0) {
            this.cblks = new Vector[i14 + 1];
            while (i13 < i14) {
                this.cblks[i13] = new Vector();
                i13++;
            }
            this.pktIdx++;
            if (this.isTruncMode && this.maxCB == -1) {
                int pos2 = this.ehs.getPos() - pos;
                int i16 = iArr[tileIdx];
                if (pos2 > i16) {
                    iArr[tileIdx] = 0;
                    return true;
                }
                iArr[tileIdx] = i16 - pos2;
            }
            if (this.ephUsed) {
                readEPHMarker(pktHeaderBitReader);
            }
            return false;
        }
        Vector[] vectorArr = this.cblks;
        if (vectorArr == null || vectorArr.length < i14 + 1) {
            this.cblks = new Vector[i14 + 1];
        }
        while (i13 < i14) {
            Vector[] vectorArr2 = this.cblks;
            Vector vector = vectorArr2[i13];
            if (vector == null) {
                vectorArr2[i13] = new Vector();
            } else {
                vector.removeAllElements();
            }
            SubbandSyn subbandSyn2 = (SubbandSyn) synSubbandTree.getSubbandByIdx(i11, i13);
            if (precInfo.nblk[i13] != 0) {
                TagTreeDecoder tagTreeDecoder = this.ttIncl[i3][i11][i12][i13];
                TagTreeDecoder tagTreeDecoder2 = this.ttMaxBP[i3][i11][i12][i13];
                int length = precInfo.cblk[i13] == null ? 0 : precInfo.cblk[i13].length;
                int i17 = 0;
                while (i17 < length) {
                    int i18 = pos;
                    int length2 = precInfo.cblk[i13][i17] == null ? 0 : precInfo.cblk[i13][i17].length;
                    int i19 = length;
                    int i20 = 0;
                    while (i20 < length2) {
                        int i21 = length2;
                        Coord coord = precInfo.cblk[i13][i17][i20].idx;
                        SubbandSyn subbandSyn3 = synSubbandTree;
                        int i22 = coord.x;
                        int i23 = coord.y;
                        int i24 = subbandSyn2.numCb.x;
                        CBlkInfo cBlkInfo = cBlkInfoArr[i13][coord.y][coord.x];
                        try {
                            if (cBlkInfo != null) {
                                i5 = i14;
                                try {
                                    if (cBlkInfo.ctp != 0) {
                                        cBlkInfo.pktIdx[i10] = this.pktIdx;
                                        if (pktHeaderBitReader.readBit() != 1) {
                                            i6 = i17;
                                            subbandSyn = subbandSyn2;
                                            i20++;
                                            i10 = i;
                                            i11 = i2;
                                            length2 = i21;
                                            synSubbandTree = subbandSyn3;
                                            i14 = i5;
                                            subbandSyn2 = subbandSyn;
                                            i17 = i6;
                                        } else {
                                            i6 = i17;
                                            cBlkInfo = cBlkInfo;
                                            subbandSyn = subbandSyn2;
                                            if (pktHeaderBitReader.readBit() == 1) {
                                                bits = 1;
                                            } else if (pktHeaderBitReader.readBit() == 1) {
                                                int bits3 = pktHeaderBitReader.readBits(2);
                                                bits = 3 + bits3;
                                                if (bits3 == 3) {
                                                    int bits4 = pktHeaderBitReader.readBits(5);
                                                    bits += bits4;
                                                    if (bits4 == 31) {
                                                        bits = pktHeaderBitReader.readBits(7) + bits;
                                                    }
                                                }
                                            } else {
                                                bits = 2;
                                            }
                                            cBlkInfo.addNTP(i10, bits);
                                            this.cblks[i13].addElement(precInfo.cblk[i13][i6][i20]);
                                            int iIntValue = ((Integer) this.decSpec.ecopts.getTileCompVal(tileIdx, i3)).intValue();
                                            i7 = iIntValue & 4;
                                            if (i7 == 0) {
                                                i8 = bits;
                                            } else if ((iIntValue & 1) == 0 || cBlkInfo.ctp <= 10) {
                                                i8 = 1;
                                            } else {
                                                int i25 = cBlkInfo.ctp - bits;
                                                i8 = 1;
                                                while (i25 < cBlkInfo.ctp - 1) {
                                                    if (i25 >= 9) {
                                                        int i26 = (i25 + 2) % 3;
                                                        i9 = i25;
                                                        if (i26 == 1 || i26 == 2) {
                                                            i8++;
                                                        }
                                                    } else {
                                                        i9 = i25;
                                                    }
                                                    i25 = i9 + 1;
                                                }
                                            }
                                            while (pktHeaderBitReader.readBit() != 0) {
                                                int[] iArr2 = this.lblock[i3][i2][i13][coord.y];
                                                int i27 = coord.x;
                                                iArr2[i27] = iArr2[i27] + 1;
                                            }
                                            if (i8 != 1) {
                                                bits2 = pktHeaderBitReader.readBits(this.lblock[i3][i2][i13][coord.y][coord.x] + MathUtil.log2(bits));
                                            } else {
                                                cBlkInfo.segLen[i] = new int[i8];
                                                if (i7 != 0) {
                                                    int i28 = cBlkInfo.ctp - bits;
                                                    int i29 = 0;
                                                    int i30 = 0;
                                                    while (i28 < cBlkInfo.ctp) {
                                                        int bits5 = pktHeaderBitReader.readBits(this.lblock[i3][i2][i13][coord.y][coord.x]);
                                                        cBlkInfo.segLen[i][i29] = bits5;
                                                        i30 += bits5;
                                                        i28++;
                                                        i29++;
                                                    }
                                                    bits2 = i30;
                                                } else {
                                                    int i31 = (cBlkInfo.ctp - bits) - 1;
                                                    int i32 = cBlkInfo.ctp - bits;
                                                    int i33 = 0;
                                                    int i34 = 0;
                                                    while (i32 < cBlkInfo.ctp - 1) {
                                                        if (i32 < 9 || (i32 + 2) % 3 == 0) {
                                                            i31 = i31;
                                                            i32++;
                                                        } else {
                                                            int bits6 = pktHeaderBitReader.readBits(this.lblock[i3][i2][i13][coord.y][coord.x] + MathUtil.log2(i32 - i31));
                                                            cBlkInfo.segLen[i][i34] = bits6;
                                                            i33 += bits6;
                                                            i34++;
                                                            i31 = i32;
                                                            i32++;
                                                        }
                                                    }
                                                    int bits7 = pktHeaderBitReader.readBits(this.lblock[i3][i2][i13][coord.y][coord.x] + MathUtil.log2(i32 - i31));
                                                    cBlkInfo.segLen[i][i34] = bits7;
                                                    bits2 = i33 + bits7;
                                                }
                                            }
                                            cBlkInfo.len[i] = bits2;
                                            if (this.isTruncMode && this.maxCB == -1 && this.ehs.getPos() - i18 > iArr[tileIdx]) {
                                                iArr[tileIdx] = 0;
                                                if (i == 0) {
                                                    cBlkInfoArr[i13][coord.y][coord.x] = null;
                                                } else {
                                                    int[] iArr3 = cBlkInfo.off;
                                                    cBlkInfo.len[i] = 0;
                                                    iArr3[i] = 0;
                                                    cBlkInfo.ctp -= cBlkInfo.ntp[i];
                                                    cBlkInfo.ntp[i] = 0;
                                                    cBlkInfo.pktIdx[i] = -1;
                                                }
                                                return true;
                                            }
                                            i20++;
                                            i10 = i;
                                            i11 = i2;
                                            length2 = i21;
                                            synSubbandTree = subbandSyn3;
                                            i14 = i5;
                                            subbandSyn2 = subbandSyn;
                                            i17 = i6;
                                        }
                                    }
                                } catch (EOFException unused) {
                                    if (i == 0) {
                                    }
                                }
                            } else {
                                i5 = i14;
                            }
                            cBlkInfo.pktIdx[i10] = this.pktIdx;
                            if (tagTreeDecoder.update(i17, i20, i10 + 1, pktHeaderBitReader) <= i10) {
                                subbandSyn = subbandSyn2;
                                int iUpdate = 1;
                                int i35 = 1;
                                while (iUpdate >= i35) {
                                    iUpdate = tagTreeDecoder2.update(i17, i20, i35, pktHeaderBitReader);
                                    i35++;
                                }
                                cBlkInfo.msbSkipped = i35 - 2;
                                cBlkInfo.addNTP(i10, 0);
                                int i36 = this.ncb + 1;
                                this.ncb = i36;
                                int i37 = this.maxCB;
                                i6 = i17;
                                if (i37 != -1 && !this.ncbQuit && i36 == i37) {
                                    this.ncbQuit = true;
                                    this.tQuit = tileIdx;
                                    this.cQuit = i3;
                                    this.sQuit = i13;
                                    this.rQuit = i11;
                                    this.xQuit = coord.x;
                                    this.yQuit = coord.y;
                                }
                                if (pktHeaderBitReader.readBit() == 1) {
                                }
                                cBlkInfo.addNTP(i10, bits);
                                this.cblks[i13].addElement(precInfo.cblk[i13][i6][i20]);
                                int iIntValue2 = ((Integer) this.decSpec.ecopts.getTileCompVal(tileIdx, i3)).intValue();
                                i7 = iIntValue2 & 4;
                                if (i7 == 0) {
                                }
                                while (pktHeaderBitReader.readBit() != 0) {
                                }
                                if (i8 != 1) {
                                }
                                cBlkInfo.len[i] = bits2;
                                if (this.isTruncMode) {
                                    continue;
                                }
                                i20++;
                                i10 = i;
                                i11 = i2;
                                length2 = i21;
                                synSubbandTree = subbandSyn3;
                                i14 = i5;
                                subbandSyn2 = subbandSyn;
                                i17 = i6;
                            }
                            i6 = i17;
                            subbandSyn = subbandSyn2;
                            i20++;
                            i10 = i;
                            i11 = i2;
                            length2 = i21;
                            synSubbandTree = subbandSyn3;
                            i14 = i5;
                            subbandSyn2 = subbandSyn;
                            i17 = i6;
                        } catch (EOFException unused2) {
                            if (i == 0) {
                                cBlkInfoArr[i13][coord.y][coord.x] = null;
                                return true;
                            }
                            int[] iArr4 = cBlkInfo.off;
                            cBlkInfo.len[i] = 0;
                            iArr4[i] = 0;
                            cBlkInfo.ctp -= cBlkInfo.ntp[i];
                            cBlkInfo.ntp[i] = 0;
                            cBlkInfo.pktIdx[i] = -1;
                            return true;
                        }
                        if (cBlkInfo == null) {
                            try {
                                CBlkInfo[] cBlkInfoArr2 = cBlkInfoArr[i13][coord.y];
                                int i38 = coord.x;
                                CBlkInfo cBlkInfo2 = new CBlkInfo(precInfo.cblk[i13][i17][i20].ulx, precInfo.cblk[i13][i17][i20].uly, precInfo.cblk[i13][i17][i20].w, precInfo.cblk[i13][i17][i20].h, this.nl);
                                cBlkInfoArr2[i38] = cBlkInfo2;
                                cBlkInfo = cBlkInfo2;
                            } catch (EOFException unused3) {
                                cBlkInfo = cBlkInfo;
                                if (i == 0) {
                                }
                            }
                        } else {
                            cBlkInfo = cBlkInfo;
                        }
                    }
                    i17++;
                    i10 = i;
                    i11 = i2;
                    pos = i18;
                    length = i19;
                }
            }
            i13++;
            i10 = i;
            i11 = i2;
            i12 = i4;
            pos = pos;
            synSubbandTree = synSubbandTree;
            i14 = i14;
        }
        int i39 = pos;
        if (this.ephUsed) {
            readEPHMarker(pktHeaderBitReader);
        }
        this.pktIdx++;
        if (!this.isTruncMode || this.maxCB != -1) {
            return false;
        }
        int pos3 = this.ehs.getPos() - i39;
        int i40 = iArr[tileIdx];
        if (pos3 > i40) {
            iArr[tileIdx] = 0;
            return true;
        }
        iArr[tileIdx] = i40 - pos3;
        return false;
    }

    public boolean readPktBody(int i, int i2, int i3, int i4, CBlkInfo[][][] cBlkInfoArr, int[] iArr) throws IOException {
        int pos = this.ehs.getPos();
        int tileIdx = this.src.getTileIdx();
        int i5 = i2 == 0 ? 0 : 1;
        int i6 = i2 == 0 ? 1 : 4;
        boolean z = false;
        for (int i7 = i5; i7 < i6; i7++) {
            if (i4 < this.ppinfo[i3][i2].length) {
                z = true;
            }
        }
        if (!z) {
            return false;
        }
        boolean z2 = false;
        while (i5 < i6) {
            for (int i8 = 0; i8 < this.cblks[i5].size(); i8++) {
                Coord coord = ((CBlkCoordInfo) this.cblks[i5].elementAt(i8)).idx;
                CBlkInfo cBlkInfo = cBlkInfoArr[i5][coord.y][coord.x];
                cBlkInfo.off[i] = pos;
                pos += cBlkInfo.len[i];
                try {
                    this.ehs.seek(pos);
                    if (this.isTruncMode) {
                        if (z2 || cBlkInfo.len[i] > iArr[tileIdx]) {
                            if (i == 0) {
                                cBlkInfoArr[i5][coord.y][coord.x] = null;
                            } else {
                                int[] iArr2 = cBlkInfo.off;
                                cBlkInfo.len[i] = 0;
                                iArr2[i] = 0;
                                cBlkInfo.ctp -= cBlkInfo.ntp[i];
                                cBlkInfo.ntp[i] = 0;
                                cBlkInfo.pktIdx[i] = -1;
                            }
                            z2 = true;
                        }
                        if (!z2) {
                            iArr[tileIdx] = iArr[tileIdx] - cBlkInfo.len[i];
                        }
                    }
                    if (this.ncbQuit && i2 == this.rQuit && i5 == this.sQuit && coord.x == this.xQuit && coord.y == this.yQuit && tileIdx == this.tQuit && i3 == this.cQuit) {
                        cBlkInfoArr[i5][coord.y][coord.x] = null;
                        z2 = true;
                    }
                } catch (EOFException unused) {
                    if (i == 0) {
                        cBlkInfoArr[i5][coord.y][coord.x] = null;
                    } else {
                        int[] iArr3 = cBlkInfo.off;
                        cBlkInfo.len[i] = 0;
                        iArr3[i] = 0;
                        cBlkInfo.ctp -= cBlkInfo.ntp[i];
                        cBlkInfo.ntp[i] = 0;
                        cBlkInfo.pktIdx[i] = -1;
                    }
                    throw new EOFException();
                }
            }
            i5++;
        }
        this.ehs.seek(pos);
        return z2;
    }

    public final int getPPX(int i, int i2, int i3) {
        return this.decSpec.pss.getPPX(i, i2, i3);
    }

    public final int getPPY(int i, int i2, int i3) {
        return this.decSpec.pss.getPPY(i, i2, i3);
    }

    public boolean readSOPMarker(int[] iArr, int i, int i2, int i3) throws IOException {
        byte[] bArr = new byte[6];
        int tileIdx = this.src.getTileIdx();
        int i4 = i3 == 0 ? 1 : 4;
        boolean z = false;
        for (int i5 = i3 == 0 ? 0 : 1; i5 < i4; i5++) {
            if (i < this.ppinfo[i2][i3].length) {
                z = true;
            }
        }
        if (!z || !this.sopUsed) {
            return false;
        }
        int pos = this.ehs.getPos();
        if (((short) ((this.ehs.read() << 8) | this.ehs.read())) != -111) {
            this.ehs.seek(pos);
            return false;
        }
        this.ehs.seek(pos);
        int i6 = iArr[tileIdx];
        if (i6 < 6) {
            return true;
        }
        iArr[tileIdx] = i6 - 6;
        this.ehs.readFully(bArr, 0, 6);
        if (((bArr[0] << 8) | bArr[1]) != -111) {
            throw new Error("Corrupted Bitstream: Could not parse SOP marker !");
        }
        if ((((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 4) {
            throw new Error("Corrupted Bitstream: Corrupted SOP marker !");
        }
        int i7 = ((bArr[4] & 255) << 8) | (bArr[5] & 255);
        boolean z2 = this.pph;
        if (!z2 && i7 != this.pktIdx) {
            throw new Error("Corrupted Bitstream: SOP marker out of sequence !");
        }
        if (!z2 || i7 == this.pktIdx - 1) {
            return false;
        }
        throw new Error("Corrupted Bitstream: SOP marker out of sequence !");
    }

    public void readEPHMarker(PktHeaderBitReader pktHeaderBitReader) throws IOException {
        byte[] bArr = new byte[2];
        if (pktHeaderBitReader.usebais) {
            pktHeaderBitReader.bais.read(bArr, 0, 2);
        } else {
            pktHeaderBitReader.in.readFully(bArr, 0, 2);
        }
        if (((bArr[0] << 8) | bArr[1]) != -110) {
            throw new Error("Corrupted Bitstream: Could not parse EPH marker ! ");
        }
    }

    public PrecInfo getPrecInfo(int i, int i2, int i3) {
        return this.ppinfo[i][i2][i3];
    }
}
