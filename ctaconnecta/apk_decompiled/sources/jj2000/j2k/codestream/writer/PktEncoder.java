package jj2000.j2k.codestream.writer;

import java.lang.reflect.Array;
import jj2000.j2k.codestream.CBlkCoordInfo;
import jj2000.j2k.codestream.PrecInfo;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.entropy.encoder.CBlkRateDistStats;
import jj2000.j2k.entropy.encoder.CodedCBlkDataSrcEnc;
import jj2000.j2k.image.Coord;
import jj2000.j2k.util.ArrayUtil;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.analysis.SubbandAn;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class PktEncoder {
    private static final int INIT_LBLOCK = 3;
    public static final char OPT_PREFIX = 'P';
    private static final String[][] pinfo = {new String[]{"Psop", "[<tile idx>] on|off[ [<tile idx>] on|off ...]", "Specifies whether start of packet (SOP) markers should be used. 'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"Peph", "[<tile idx>] on|off[ [<tile  idx>] on|off ...]", "Specifies whether end of packet header (EPH) markers should be  used. 'on' enables, 'off' disables it.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}};
    private int[][][][][] bak_lblock;
    private int[][][][][] bak_prevtIdxs;
    private EncoderSpecs encSpec;
    private CodedCBlkDataSrcEnc infoSrc;
    private byte[] lbbuf;
    private int lblen;
    private int[][][][][] lblock;
    private boolean packetWritable;
    private PrecInfo[][][][] ppinfo;
    private int[][][][][] prevtIdxs;
    private boolean roiInPkt = false;
    private int roiLen = 0;
    private boolean saved;
    private TagTreeEncoder[][][][][] ttIncl;
    private TagTreeEncoder[][][][][] ttMaxBP;

    public PktEncoder(CodedCBlkDataSrcEnc codedCBlkDataSrcEnc, EncoderSpecs encoderSpecs, Coord[][][] coordArr, ParameterList parameterList) {
        this.infoSrc = codedCBlkDataSrcEnc;
        this.encSpec = encoderSpecs;
        parameterList.checkList(OPT_PREFIX, ParameterList.toNameArray(pinfo));
        int numComps = codedCBlkDataSrcEnc.getNumComps();
        int numTiles = codedCBlkDataSrcEnc.getNumTiles();
        char c = 1;
        this.ttIncl = (TagTreeEncoder[][][][][]) Array.newInstance((Class<?>) TagTreeEncoder[][][].class, numTiles, numComps);
        this.ttMaxBP = (TagTreeEncoder[][][][][]) Array.newInstance((Class<?>) TagTreeEncoder[][][].class, numTiles, numComps);
        this.lblock = (int[][][][][]) Array.newInstance((Class<?>) int[][][].class, numTiles, numComps);
        this.prevtIdxs = (int[][][][][]) Array.newInstance((Class<?>) int[][][].class, numTiles, numComps);
        this.ppinfo = (PrecInfo[][][][]) Array.newInstance((Class<?>) PrecInfo[][].class, numTiles, numComps);
        codedCBlkDataSrcEnc.setTile(0, 0);
        int i = 0;
        while (i < numTiles) {
            int i2 = 0;
            while (i2 < numComps) {
                SubbandAn anSubbandTree = codedCBlkDataSrcEnc.getAnSubbandTree(i, i2);
                int i3 = anSubbandTree.resLvl;
                int i4 = i3 + 1;
                this.lblock[i][i2] = new int[i4][][];
                this.ttIncl[i][i2] = new TagTreeEncoder[i4][][];
                this.ttMaxBP[i][i2] = new TagTreeEncoder[i4][][];
                this.prevtIdxs[i][i2] = new int[i4][][];
                this.ppinfo[i][i2] = new PrecInfo[i4][];
                int i5 = 0;
                while (i5 <= i3) {
                    int i6 = i5 == 0 ? 1 : 4;
                    int i7 = coordArr[i][i2][i5].x * coordArr[i][i2][i5].y;
                    TagTreeEncoder[][][] tagTreeEncoderArr = this.ttIncl[i][i2];
                    int[] iArr = new int[2];
                    iArr[c] = i6;
                    iArr[0] = i7;
                    tagTreeEncoderArr[i5] = (TagTreeEncoder[][]) Array.newInstance((Class<?>) TagTreeEncoder.class, iArr);
                    this.ttMaxBP[i][i2][i5] = (TagTreeEncoder[][]) Array.newInstance((Class<?>) TagTreeEncoder.class, i7, i6);
                    this.prevtIdxs[i][i2][i5] = new int[i6][];
                    this.lblock[i][i2][i5] = new int[i6][];
                    this.ppinfo[i][i2][i5] = new PrecInfo[i7];
                    fillPrecInfo(i, i2, i5);
                    for (int i8 = i5 == 0 ? 0 : 1; i8 < i6; i8++) {
                        SubbandAn subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(i5, i8);
                        int i9 = subbandAn.numCb.x * subbandAn.numCb.y;
                        int[][][][][] iArr2 = this.lblock;
                        iArr2[i][i2][i5][i8] = new int[i9];
                        ArrayUtil.intArraySet(iArr2[i][i2][i5][i8], 3);
                        int[][][][][] iArr3 = this.prevtIdxs;
                        iArr3[i][i2][i5][i8] = new int[i9];
                        ArrayUtil.intArraySet(iArr3[i][i2][i5][i8], -1);
                    }
                    i5++;
                    c = 1;
                }
                i2++;
                c = 1;
            }
            if (i != numTiles - 1) {
                codedCBlkDataSrcEnc.nextTile();
            }
            i++;
            c = 1;
        }
    }

    private void fillPrecInfo(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.ppinfo[i][i2][i3].length == 0) {
            return;
        }
        Coord tile = this.infoSrc.getTile(null);
        Coord numTiles = this.infoSrc.getNumTiles(null);
        int imgULX = this.infoSrc.getImgULX();
        int imgULY = this.infoSrc.getImgULY();
        int imgWidth = this.infoSrc.getImgWidth() + imgULX;
        int imgHeight = this.infoSrc.getImgHeight() + imgULY;
        int tilePartULX = this.infoSrc.getTilePartULX();
        int tilePartULY = this.infoSrc.getTilePartULY();
        int nomTileWidth = this.infoSrc.getNomTileWidth();
        int nomTileHeight = this.infoSrc.getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        int i11 = imgULX;
        if (tile.y != 0) {
            imgULY = tilePartULY + (tile.y * nomTileHeight);
        }
        int i12 = imgULY;
        if (tile.x != numTiles.x - 1) {
            imgWidth = tilePartULX + ((tile.x + 1) * nomTileWidth);
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int compSubsX = this.infoSrc.getCompSubsX(i2);
        int compSubsY = this.infoSrc.getCompSubsY(i2);
        double d = compSubsX;
        int iCeil = (int) Math.ceil(i11 / d);
        char c = 1;
        double d2 = compSubsY;
        int iCeil2 = (int) Math.ceil(i12 / d2);
        int iCeil3 = (int) Math.ceil(imgWidth / d);
        int iCeil4 = (int) Math.ceil(imgHeight / d2);
        int i13 = this.infoSrc.getAnSubbandTree(i, i2).resLvl - i3;
        double d3 = 1 << i13;
        int iCeil5 = (int) Math.ceil(iCeil / d3);
        int iCeil6 = (int) Math.ceil(iCeil2 / d3);
        int iCeil7 = (int) Math.ceil(iCeil3 / d3);
        int iCeil8 = (int) Math.ceil(iCeil4 / d3);
        int cbULX = this.infoSrc.getCbULX();
        int cbULY = this.infoSrc.getCbULY();
        double ppx = this.encSpec.pss.getPPX(i, i2, i3);
        double ppy = this.encSpec.pss.getPPY(i, i2, i3);
        int i14 = (int) (ppx / 2.0d);
        int i15 = (int) (ppy / 2.0d);
        int length = this.ppinfo[i][i2][i3].length;
        int i16 = iCeil6 - cbULY;
        int iFloor = (int) Math.floor(i16 / ppy);
        int iFloor2 = (int) Math.floor(((iCeil8 - 1) - cbULY) / ppy);
        int i17 = iCeil5 - cbULX;
        int iFloor3 = (int) Math.floor(i17 / ppx);
        int iFloor4 = (int) Math.floor(((iCeil7 - 1) - cbULX) / ppx);
        SubbandAn anSubbandTree = this.infoSrc.getAnSubbandTree(i, i2);
        int i18 = (int) ppx;
        int i19 = i18 << i13;
        int i20 = (int) ppy;
        int i21 = i20 << i13;
        int i22 = iFloor;
        int i23 = 0;
        while (i22 <= iFloor2) {
            int i24 = iFloor3;
            while (i24 <= iFloor4) {
                int i25 = (i24 != iFloor3 || i17 % (compSubsX * i18) == 0) ? cbULX + (i24 * compSubsX * i19) : i11;
                int i26 = (i22 != iFloor || i16 % (compSubsY * i20) == 0) ? cbULY + (i22 * compSubsY * i21) : i12;
                double d4 = ppy;
                int i27 = (int) (cbULX + (i24 * ppx));
                int i28 = i24;
                int i29 = (int) (cbULY + (i22 * d4));
                int i30 = iFloor4;
                int i31 = iFloor;
                int i32 = i18;
                int i33 = i21;
                int i34 = iFloor2;
                int i35 = i20;
                int i36 = i22;
                SubbandAn subbandAn = anSubbandTree;
                int i37 = i25;
                int i38 = iFloor3;
                this.ppinfo[i][i2][i3][i23] = new PrecInfo(i3, i27, i29, i32, i35, i37, i26, i19, i33);
                if (i3 == 0) {
                    int i39 = (i28 * i32) + cbULX;
                    int i40 = i39 + i32;
                    int i41 = (i36 * i35) + cbULY;
                    int i42 = i41 + i35;
                    SubbandAn subbandAn2 = (SubbandAn) subbandAn.getSubbandByIdx(0, 0);
                    i4 = i31;
                    if (i39 < subbandAn2.ulcx) {
                        i39 = subbandAn2.ulcx;
                    }
                    if (i40 > subbandAn2.ulcx + subbandAn2.w) {
                        i40 = subbandAn2.w + subbandAn2.ulcx;
                    }
                    if (i41 < subbandAn2.ulcy) {
                        i41 = subbandAn2.ulcy;
                    }
                    if (i42 > subbandAn2.ulcy + subbandAn2.h) {
                        i42 = subbandAn2.h + subbandAn2.ulcy;
                    }
                    int i43 = subbandAn2.nomCBlkW;
                    int i44 = i39;
                    int i45 = i41;
                    i5 = i32;
                    double d5 = subbandAn2.nomCBlkH;
                    int iFloor5 = (int) Math.floor((subbandAn2.ulcy - cbULY) / d5);
                    int iFloor6 = (int) Math.floor((i45 - cbULY) / d5);
                    int iFloor7 = (int) Math.floor(((i42 - 1) - cbULY) / d5);
                    double d6 = i43;
                    int iFloor8 = (int) Math.floor((subbandAn2.ulcx - cbULX) / d6);
                    int iFloor9 = (int) Math.floor((i44 - cbULX) / d6);
                    int iFloor10 = (int) Math.floor(((i40 - 1) - cbULX) / d6);
                    if (i40 - i44 <= 0 || i42 - i45 <= 0) {
                        this.ppinfo[i][i2][i3][i23].nblk[0] = 0;
                        this.ttIncl[i][i2][i3][i23][0] = new TagTreeEncoder(0, 0);
                        this.ttMaxBP[i][i2][i3][i23][0] = new TagTreeEncoder(0, 0);
                        i6 = i35;
                        i7 = i19;
                        i8 = i33;
                        i9 = cbULX;
                        i10 = cbULY;
                    } else {
                        int i46 = (iFloor7 - iFloor6) + 1;
                        int i47 = (iFloor10 - iFloor9) + 1;
                        this.ttIncl[i][i2][i3][i23][0] = new TagTreeEncoder(i46, i47);
                        this.ttMaxBP[i][i2][i3][i23][0] = new TagTreeEncoder(i46, i47);
                        CBlkCoordInfo[][][] cBlkCoordInfoArr = this.ppinfo[i][i2][i3][i23].cblk;
                        int[] iArr = new int[2];
                        iArr[c] = i47;
                        iArr[0] = i46;
                        cBlkCoordInfoArr[0] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, iArr);
                        this.ppinfo[i][i2][i3][i23].nblk[0] = i46 * i47;
                        for (int i48 = iFloor6; i48 <= iFloor7; i48++) {
                            int i49 = iFloor9;
                            while (i49 <= iFloor10) {
                                this.ppinfo[i][i2][i3][i23].cblk[0][i48 - iFloor6][i49 - iFloor9] = new CBlkCoordInfo(i48 - iFloor5, i49 - iFloor8);
                                i49++;
                                iFloor10 = iFloor10;
                            }
                        }
                        i6 = i35;
                        i7 = i19;
                        i8 = i33;
                        i9 = cbULX;
                        i10 = cbULY;
                    }
                } else {
                    i4 = i31;
                    i5 = i32;
                    int i50 = i28 * i14;
                    int i51 = i50 + i14;
                    int i52 = i36 * i15;
                    int i53 = cbULY + i52;
                    int i54 = i53 + i15;
                    SubbandAn subbandAn3 = (SubbandAn) subbandAn.getSubbandByIdx(i3, 1);
                    int i55 = i50 < subbandAn3.ulcx ? subbandAn3.ulcx : i50;
                    i6 = i35;
                    int i56 = i51 > subbandAn3.ulcx + subbandAn3.w ? subbandAn3.ulcx + subbandAn3.w : i51;
                    if (i53 < subbandAn3.ulcy) {
                        i53 = subbandAn3.ulcy;
                    }
                    int i57 = i53;
                    if (i54 > subbandAn3.ulcy + subbandAn3.h) {
                        i54 = subbandAn3.h + subbandAn3.ulcy;
                    }
                    int i58 = subbandAn3.nomCBlkW;
                    int i59 = i54;
                    i7 = i19;
                    i8 = i33;
                    double d7 = subbandAn3.nomCBlkH;
                    int iFloor11 = (int) Math.floor((subbandAn3.ulcy - cbULY) / d7);
                    int iFloor12 = (int) Math.floor((i57 - cbULY) / d7);
                    int iFloor13 = (int) Math.floor(((i59 - 1) - cbULY) / d7);
                    double d8 = subbandAn3.ulcx;
                    double d9 = i58;
                    int iFloor14 = (int) Math.floor(d8 / d9);
                    int iFloor15 = (int) Math.floor(i55 / d9);
                    int iFloor16 = (int) Math.floor((i56 - 1) / d9);
                    if (i56 - i55 <= 0 || i59 - i57 <= 0) {
                        this.ppinfo[i][i2][i3][i23].nblk[1] = 0;
                        this.ttIncl[i][i2][i3][i23][1] = new TagTreeEncoder(0, 0);
                        this.ttMaxBP[i][i2][i3][i23][1] = new TagTreeEncoder(0, 0);
                    } else {
                        int i60 = (iFloor13 - iFloor12) + 1;
                        int i61 = (iFloor16 - iFloor15) + 1;
                        this.ttIncl[i][i2][i3][i23][1] = new TagTreeEncoder(i60, i61);
                        this.ttMaxBP[i][i2][i3][i23][1] = new TagTreeEncoder(i60, i61);
                        this.ppinfo[i][i2][i3][i23].cblk[1] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, i60, i61);
                        this.ppinfo[i][i2][i3][i23].nblk[1] = i61 * i60;
                        int i62 = iFloor12;
                        while (i62 <= iFloor13) {
                            int i63 = iFloor15;
                            while (i63 <= iFloor16) {
                                int i64 = i62;
                                this.ppinfo[i][i2][i3][i23].cblk[1][i64 - iFloor12][i63 - iFloor15] = new CBlkCoordInfo(i62 - iFloor11, i63 - iFloor14);
                                i63++;
                                i62 = i64;
                            }
                            i62++;
                        }
                    }
                    int i65 = cbULX + i50;
                    int i66 = i65 + i14;
                    int i67 = i52 + i15;
                    SubbandAn subbandAn4 = (SubbandAn) subbandAn.getSubbandByIdx(i3, 2);
                    if (i65 < subbandAn4.ulcx) {
                        i65 = subbandAn4.ulcx;
                    }
                    if (i66 > subbandAn4.ulcx + subbandAn4.w) {
                        i66 = subbandAn4.ulcx + subbandAn4.w;
                    }
                    int i68 = i52 < subbandAn4.ulcy ? subbandAn4.ulcy : i52;
                    int i69 = i67 > subbandAn4.ulcy + subbandAn4.h ? subbandAn4.ulcy + subbandAn4.h : i67;
                    int i70 = subbandAn4.nomCBlkW;
                    int i71 = i65;
                    int i72 = i66;
                    i9 = cbULX;
                    i10 = cbULY;
                    double d10 = subbandAn4.nomCBlkH;
                    int iFloor17 = (int) Math.floor(subbandAn4.ulcy / d10);
                    int iFloor18 = (int) Math.floor(i68 / d10);
                    int iFloor19 = (int) Math.floor((i69 - 1) / d10);
                    int i73 = i68;
                    double d11 = i70;
                    int iFloor20 = (int) Math.floor((subbandAn4.ulcx - i9) / d11);
                    int iFloor21 = (int) Math.floor((i71 - i9) / d11);
                    int iFloor22 = (int) Math.floor(((i72 - 1) - i9) / d11);
                    if (i72 - i71 <= 0 || i69 - i73 <= 0) {
                        this.ppinfo[i][i2][i3][i23].nblk[2] = 0;
                        this.ttIncl[i][i2][i3][i23][2] = new TagTreeEncoder(0, 0);
                        this.ttMaxBP[i][i2][i3][i23][2] = new TagTreeEncoder(0, 0);
                    } else {
                        int i74 = (iFloor19 - iFloor18) + 1;
                        int i75 = (iFloor22 - iFloor21) + 1;
                        this.ttIncl[i][i2][i3][i23][2] = new TagTreeEncoder(i74, i75);
                        this.ttMaxBP[i][i2][i3][i23][2] = new TagTreeEncoder(i74, i75);
                        this.ppinfo[i][i2][i3][i23].cblk[2] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, i74, i75);
                        this.ppinfo[i][i2][i3][i23].nblk[2] = i74 * i75;
                        int i76 = iFloor18;
                        while (i76 <= iFloor19) {
                            int i77 = iFloor21;
                            while (i77 <= iFloor22) {
                                int i78 = i76;
                                this.ppinfo[i][i2][i3][i23].cblk[2][i78 - iFloor18][i77 - iFloor21] = new CBlkCoordInfo(i76 - iFloor17, i77 - iFloor20);
                                i77++;
                                iFloor19 = iFloor19;
                                i76 = i78;
                            }
                            i76++;
                        }
                    }
                    SubbandAn subbandAn5 = (SubbandAn) subbandAn.getSubbandByIdx(i3, 3);
                    if (i50 < subbandAn5.ulcx) {
                        i50 = subbandAn5.ulcx;
                    }
                    if (i51 > subbandAn5.ulcx + subbandAn5.w) {
                        i51 = subbandAn5.ulcx + subbandAn5.w;
                    }
                    if (i52 < subbandAn5.ulcy) {
                        i52 = subbandAn5.ulcy;
                    }
                    if (i67 > subbandAn5.ulcy + subbandAn5.h) {
                        i67 = subbandAn5.ulcy + subbandAn5.h;
                    }
                    int i79 = subbandAn5.nomCBlkW;
                    double d12 = subbandAn5.nomCBlkH;
                    int iFloor23 = (int) Math.floor(subbandAn5.ulcy / d12);
                    int iFloor24 = (int) Math.floor(i52 / d12);
                    int iFloor25 = (int) Math.floor((i67 - 1) / d12);
                    double d13 = subbandAn5.ulcx;
                    int i80 = i52;
                    double d14 = i79;
                    int iFloor26 = (int) Math.floor(d13 / d14);
                    int iFloor27 = (int) Math.floor(i50 / d14);
                    int iFloor28 = (int) Math.floor((i51 - 1) / d14);
                    if (i51 - i50 <= 0 || i67 - i80 <= 0) {
                        c = 1;
                        this.ppinfo[i][i2][i3][i23].nblk[3] = 0;
                        this.ttIncl[i][i2][i3][i23][3] = new TagTreeEncoder(0, 0);
                        this.ttMaxBP[i][i2][i3][i23][3] = new TagTreeEncoder(0, 0);
                    } else {
                        int i81 = (iFloor25 - iFloor24) + 1;
                        int i82 = (iFloor28 - iFloor27) + 1;
                        this.ttIncl[i][i2][i3][i23][3] = new TagTreeEncoder(i81, i82);
                        this.ttMaxBP[i][i2][i3][i23][3] = new TagTreeEncoder(i81, i82);
                        c = 1;
                        this.ppinfo[i][i2][i3][i23].cblk[3] = (CBlkCoordInfo[][]) Array.newInstance((Class<?>) CBlkCoordInfo.class, i81, i82);
                        this.ppinfo[i][i2][i3][i23].nblk[3] = i81 * i82;
                        for (int i83 = iFloor24; i83 <= iFloor25; i83++) {
                            for (int i84 = iFloor27; i84 <= iFloor28; i84++) {
                                this.ppinfo[i][i2][i3][i23].cblk[3][i83 - iFloor24][i84 - iFloor27] = new CBlkCoordInfo(i83 - iFloor23, i84 - iFloor26);
                            }
                        }
                    }
                }
                i24 = i28 + 1;
                i23++;
                anSubbandTree = subbandAn;
                iFloor2 = i34;
                iFloor3 = i38;
                iFloor4 = i30;
                ppy = d4;
                i22 = i36;
                iFloor = i4;
                i20 = i6;
                i18 = i5;
                cbULX = i9;
                i19 = i7;
                i21 = i8;
                cbULY = i10;
            }
            i22++;
            ppy = ppy;
            i21 = i21;
        }
    }

    public BitOutputBuffer encodePacket(int i, int i2, int i3, int i4, CBlkRateDistStats[][] cBlkRateDistStatsArr, int[][] iArr, BitOutputBuffer bitOutputBuffer, byte[] bArr, int i5) {
        BitOutputBuffer bitOutputBuffer2;
        BitOutputBuffer bitOutputBuffer3;
        CBlkRateDistStats[] cBlkRateDistStatsArr2;
        int i6;
        int i7;
        boolean z;
        int i8;
        TagTreeEncoder tagTreeEncoder;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i12 == 0 ? 0 : 1;
        int i16 = i12 == 0 ? 1 : 4;
        SubbandAn anSubbandTree = this.infoSrc.getAnSubbandTree(i13, i11);
        this.roiInPkt = false;
        this.roiLen = 0;
        PrecInfo[] precInfoArr = this.ppinfo[i13][i11][i12];
        if (i14 >= precInfoArr.length) {
            this.packetWritable = false;
            return bitOutputBuffer;
        }
        PrecInfo precInfo = precInfoArr[i14];
        for (int i17 = i15; i17 < i16; i17++) {
            if (precInfo.nblk[i17] != 0) {
                if (bitOutputBuffer == null) {
                    bitOutputBuffer3 = new BitOutputBuffer();
                } else {
                    bitOutputBuffer.reset();
                    bitOutputBuffer3 = bitOutputBuffer;
                }
                this.lbbuf = null;
                this.lblen = 0;
                bitOutputBuffer3.writeBit(1);
                int i18 = i15;
                while (i18 < i16) {
                    SubbandAn subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(i12, i18);
                    if (precInfo.nblk[i18] == 0) {
                        i8 = i15;
                    } else {
                        TagTreeEncoder tagTreeEncoder2 = this.ttIncl[i13][i11][i12][i14][i18];
                        TagTreeEncoder tagTreeEncoder3 = this.ttMaxBP[i13][i11][i12][i14][i18];
                        int[] iArr2 = this.prevtIdxs[i13][i2][i12][i18];
                        CBlkRateDistStats[] cBlkRateDistStatsArr3 = cBlkRateDistStatsArr[i18];
                        int[] iArr3 = iArr[i18];
                        int length = precInfo.cblk[i18] == null ? 0 : precInfo.cblk[i18].length;
                        int i19 = 0;
                        while (i19 < length) {
                            int i20 = length;
                            int length2 = precInfo.cblk[i18][i19] == null ? 0 : precInfo.cblk[i18][i19].length;
                            int i21 = 0;
                            while (i21 < length2) {
                                int i22 = length2;
                                Coord coord = precInfo.cblk[i18][i19][i21].idx;
                                int i23 = i15;
                                int i24 = coord.x + (subbandAn.numCb.x * coord.y);
                                int i25 = iArr3[i24];
                                int i26 = iArr2[i24];
                                if (i25 > i26 && i26 < 0) {
                                    tagTreeEncoder2.setValue(i19, i21, i - 1);
                                }
                                if (i == 1) {
                                    tagTreeEncoder3.setValue(i19, i21, cBlkRateDistStatsArr3[i24].skipMSBP);
                                }
                                i21++;
                                length2 = i22;
                                i15 = i23;
                            }
                            i19++;
                            length = i20;
                        }
                        i8 = i15;
                        for (int i27 = 0; i27 < precInfo.cblk[i18].length; i27++) {
                            int i28 = 0;
                            while (i28 < precInfo.cblk[i18][i27].length) {
                                Coord coord2 = precInfo.cblk[i18][i27][i28].idx;
                                int i29 = coord2.x + (subbandAn.numCb.x * coord2.y);
                                int i30 = iArr3[i29];
                                SubbandAn subbandAn2 = subbandAn;
                                int i31 = iArr2[i29];
                                if (i30 > i31) {
                                    if (i31 < 0) {
                                        tagTreeEncoder2.encode(i27, i28, i, bitOutputBuffer3);
                                        int i32 = cBlkRateDistStatsArr3[i29].skipMSBP + 1;
                                        for (int i33 = 1; i33 <= i32; i33++) {
                                            tagTreeEncoder3.encode(i27, i28, i33, bitOutputBuffer3);
                                        }
                                        this.lblen += cBlkRateDistStatsArr3[i29].truncRates[cBlkRateDistStatsArr3[i29].truncIdxs[iArr3[i29]]];
                                    } else {
                                        bitOutputBuffer3.writeBit(1);
                                        this.lblen += cBlkRateDistStatsArr3[i29].truncRates[cBlkRateDistStatsArr3[i29].truncIdxs[iArr3[i29]]] - cBlkRateDistStatsArr3[i29].truncRates[cBlkRateDistStatsArr3[i29].truncIdxs[iArr2[i29]]];
                                    }
                                    if (iArr2[i29] < 0) {
                                        i10 = cBlkRateDistStatsArr3[i29].truncIdxs[iArr3[i29]];
                                        i9 = 1;
                                    } else {
                                        i9 = 1;
                                        i10 = (cBlkRateDistStatsArr3[i29].truncIdxs[iArr3[i29]] - cBlkRateDistStatsArr3[i29].truncIdxs[iArr2[i29]]) - 1;
                                    }
                                    if (i10 != 0) {
                                        tagTreeEncoder = tagTreeEncoder3;
                                        if (i10 == i9) {
                                            bitOutputBuffer3.writeBits(2, 2);
                                        } else if (i10 == 2 || i10 == 3 || i10 == 4) {
                                            bitOutputBuffer3.writeBits((i10 - 2) | 12, 4);
                                        } else if (i10 <= 35) {
                                            bitOutputBuffer3.writeBits((i10 - 5) | 480, 9);
                                        } else if (i10 <= 163) {
                                            bitOutputBuffer3.writeBits((i10 - 36) | 65408, 16);
                                        } else {
                                            throw new ArithmeticException("Maximum number of truncation points exceeded");
                                        }
                                    } else {
                                        tagTreeEncoder = tagTreeEncoder3;
                                        bitOutputBuffer3.writeBit(0);
                                    }
                                    int i34 = cBlkRateDistStatsArr3[i29].truncIdxs[iArr3[i29]];
                                    int i35 = iArr2[i29] < 0 ? 0 : cBlkRateDistStatsArr3[i29].truncRates[cBlkRateDistStatsArr3[i29].truncIdxs[iArr2[i29]]];
                                    int i36 = iArr2[i29] < 0 ? 0 : cBlkRateDistStatsArr3[i29].truncIdxs[iArr2[i29]] + 1;
                                    int i37 = 1;
                                    while (i36 < i34) {
                                        int i38 = i34;
                                        if (cBlkRateDistStatsArr3[i29].isTermPass != null && cBlkRateDistStatsArr3[i29].isTermPass[i36]) {
                                            int i39 = cBlkRateDistStatsArr3[i29].truncRates[i36] - i35;
                                            int iLog2 = this.lblock[i4][i2][i12][i18][i29] + MathUtil.log2(i37);
                                            int iLog22 = (i39 > 0 ? MathUtil.log2(i39) : 0) + 1;
                                            while (iLog2 < iLog22) {
                                                int i40 = iLog22;
                                                int[] iArr4 = this.lblock[i4][i2][i12][i18];
                                                iArr4[i29] = iArr4[i29] + 1;
                                                bitOutputBuffer3.writeBit(1);
                                                iLog2++;
                                                iLog22 = i40;
                                            }
                                            i35 = cBlkRateDistStatsArr3[i29].truncRates[i36];
                                            i37 = 0;
                                        }
                                        i36++;
                                        i37++;
                                        i34 = i38;
                                    }
                                    int i41 = cBlkRateDistStatsArr3[i29].truncRates[i36] - i35;
                                    int iLog23 = (i41 > 0 ? MathUtil.log2(i41) : 0) + 1;
                                    for (int iLog24 = this.lblock[i4][i2][i12][i18][i29] + MathUtil.log2(i37); iLog24 < iLog23; iLog24++) {
                                        int[] iArr5 = this.lblock[i4][i2][i12][i18];
                                        iArr5[i29] = iArr5[i29] + 1;
                                        bitOutputBuffer3.writeBit(1);
                                    }
                                    bitOutputBuffer3.writeBit(0);
                                    int i42 = cBlkRateDistStatsArr3[i29].truncIdxs[iArr3[i29]];
                                    int i43 = iArr2[i29] < 0 ? 0 : cBlkRateDistStatsArr3[i29].truncRates[cBlkRateDistStatsArr3[i29].truncIdxs[iArr2[i29]]];
                                    int i44 = iArr2[i29] < 0 ? 0 : cBlkRateDistStatsArr3[i29].truncIdxs[iArr2[i29]] + 1;
                                    int i45 = 1;
                                    while (i44 < i42) {
                                        int i46 = i42;
                                        if (cBlkRateDistStatsArr3[i29].isTermPass != null && cBlkRateDistStatsArr3[i29].isTermPass[i44]) {
                                            bitOutputBuffer3.writeBits(cBlkRateDistStatsArr3[i29].truncRates[i44] - i43, MathUtil.log2(i45) + this.lblock[i4][i2][i12][i18][i29]);
                                            i43 = cBlkRateDistStatsArr3[i29].truncRates[i44];
                                            i45 = 0;
                                        }
                                        i44++;
                                        i45++;
                                        i42 = i46;
                                    }
                                    bitOutputBuffer3.writeBits(cBlkRateDistStatsArr3[i29].truncRates[i44] - i43, MathUtil.log2(i45) + this.lblock[i4][i2][i12][i18][i29]);
                                } else {
                                    tagTreeEncoder = tagTreeEncoder3;
                                    if (i31 >= 0) {
                                        bitOutputBuffer3.writeBit(0);
                                    } else {
                                        tagTreeEncoder2.encode(i27, i28, i, bitOutputBuffer3);
                                    }
                                }
                                i28++;
                                subbandAn = subbandAn2;
                                tagTreeEncoder3 = tagTreeEncoder;
                            }
                        }
                    }
                    i18++;
                    i11 = i2;
                    i13 = i4;
                    i14 = i5;
                    i15 = i8;
                }
                int i47 = i15;
                this.lbbuf = (bArr == null || bArr.length < this.lblen) ? new byte[this.lblen] : bArr;
                this.lblen = 0;
                int i48 = i47;
                while (i48 < i16) {
                    SubbandAn subbandAn3 = (SubbandAn) anSubbandTree.getSubbandByIdx(i12, i48);
                    int[] iArr6 = this.prevtIdxs[i4][i2][i12][i48];
                    CBlkRateDistStats[] cBlkRateDistStatsArr4 = cBlkRateDistStatsArr[i48];
                    int[] iArr7 = iArr[i48];
                    int length3 = iArr6.length;
                    int length4 = precInfo.cblk[i48] == null ? 0 : precInfo.cblk[i48].length;
                    for (int i49 = 0; i49 < length4; i49++) {
                        int length5 = precInfo.cblk[i48][i49] == null ? 0 : precInfo.cblk[i48][i49].length;
                        int i50 = 0;
                        while (i50 < length5) {
                            Coord coord3 = precInfo.cblk[i48][i49][i50].idx;
                            int[] iArr8 = iArr6;
                            int i51 = coord3.x + (coord3.y * subbandAn3.numCb.x);
                            int i52 = iArr7[i51];
                            SubbandAn subbandAn4 = subbandAn3;
                            int i53 = iArr8[i51];
                            if (i52 > i53) {
                                if (i53 < 0) {
                                    i7 = cBlkRateDistStatsArr4[i51].truncRates[cBlkRateDistStatsArr4[i51].truncIdxs[iArr7[i51]]];
                                    i6 = i51;
                                    cBlkRateDistStatsArr2 = cBlkRateDistStatsArr4;
                                    System.arraycopy(cBlkRateDistStatsArr4[i51].data, 0, this.lbbuf, this.lblen, i7);
                                } else {
                                    i6 = i51;
                                    cBlkRateDistStatsArr2 = cBlkRateDistStatsArr4;
                                    i7 = cBlkRateDistStatsArr2[i6].truncRates[cBlkRateDistStatsArr2[i6].truncIdxs[iArr7[i6]]] - cBlkRateDistStatsArr2[i6].truncRates[cBlkRateDistStatsArr2[i6].truncIdxs[iArr8[i6]]];
                                    System.arraycopy(cBlkRateDistStatsArr2[i6].data, cBlkRateDistStatsArr2[i6].truncRates[cBlkRateDistStatsArr2[i6].truncIdxs[iArr8[i6]]], this.lbbuf, this.lblen, i7);
                                }
                                this.lblen += i7;
                                if (cBlkRateDistStatsArr2[i6].nROIcoeff != 0) {
                                    if (iArr8[i6] != -1) {
                                        z = true;
                                        if (cBlkRateDistStatsArr2[i6].truncIdxs[iArr8[i6]] <= cBlkRateDistStatsArr2[i6].nROIcp - 1) {
                                        }
                                    } else {
                                        z = true;
                                    }
                                    this.roiInPkt = z;
                                    this.roiLen = this.lblen;
                                }
                                iArr8[i6] = iArr7[i6];
                            } else {
                                cBlkRateDistStatsArr2 = cBlkRateDistStatsArr4;
                            }
                            i50++;
                            iArr6 = iArr8;
                            subbandAn3 = subbandAn4;
                            cBlkRateDistStatsArr4 = cBlkRateDistStatsArr2;
                        }
                    }
                    i48++;
                    i12 = i3;
                }
                this.packetWritable = true;
                if (bitOutputBuffer3.getLength() != 0) {
                    return bitOutputBuffer3;
                }
                throw new Error("You have found a bug in PktEncoder, method: encodePacket");
            }
        }
        this.packetWritable = true;
        if (bitOutputBuffer == null) {
            bitOutputBuffer2 = new BitOutputBuffer();
        } else {
            bitOutputBuffer.reset();
            bitOutputBuffer2 = bitOutputBuffer;
        }
        if (bArr == null) {
            this.lbbuf = new byte[1];
        }
        bitOutputBuffer2.writeBit(0);
        this.lblen = 0;
        return bitOutputBuffer2;
    }

    public byte[] getLastBodyBuf() {
        byte[] bArr = this.lbbuf;
        if (bArr != null) {
            return bArr;
        }
        throw new IllegalArgumentException();
    }

    public int getLastBodyLen() {
        return this.lblen;
    }

    public void save() {
        int i = 1;
        if (this.bak_lblock == null) {
            TagTreeEncoder[][][][][] tagTreeEncoderArr = this.ttIncl;
            this.bak_lblock = new int[tagTreeEncoderArr.length][][][][];
            this.bak_prevtIdxs = new int[tagTreeEncoderArr.length][][][][];
            for (int length = tagTreeEncoderArr.length - 1; length >= 0; length--) {
                int[][][][][] iArr = this.bak_lblock;
                TagTreeEncoder[][][][][] tagTreeEncoderArr2 = this.ttIncl;
                iArr[length] = new int[tagTreeEncoderArr2[length].length][][][];
                this.bak_prevtIdxs[length] = new int[tagTreeEncoderArr2[length].length][][][];
                for (int length2 = tagTreeEncoderArr2[length].length - 1; length2 >= 0; length2--) {
                    int[][][][] iArr2 = this.bak_lblock[length];
                    int[][][][][] iArr3 = this.lblock;
                    iArr2[length2] = new int[iArr3[length][length2].length][][];
                    this.bak_prevtIdxs[length][length2] = new int[this.ttIncl[length][length2].length][][];
                    int length3 = iArr3[length][length2].length - 1;
                    while (length3 >= 0) {
                        this.bak_lblock[length][length2][length3] = new int[this.lblock[length][length2][length3].length][];
                        this.bak_prevtIdxs[length][length2][length3] = new int[this.prevtIdxs[length][length2][length3].length][];
                        int i2 = length3 == 0 ? 1 : 4;
                        for (int i3 = length3 == 0 ? 0 : 1; i3 < i2; i3++) {
                            this.bak_lblock[length][length2][length3][i3] = new int[this.lblock[length][length2][length3][i3].length];
                            this.bak_prevtIdxs[length][length2][length3][i3] = new int[this.prevtIdxs[length][length2][length3][i3].length];
                        }
                        length3--;
                    }
                }
            }
        }
        int length4 = this.ttIncl.length - 1;
        while (length4 >= 0) {
            int length5 = this.ttIncl[length4].length - i;
            while (length5 >= 0) {
                int[][][] iArr4 = this.lblock[length4][length5];
                int[][][] iArr5 = this.bak_lblock[length4][length5];
                TagTreeEncoder[][][] tagTreeEncoderArr3 = this.ttIncl[length4][length5];
                TagTreeEncoder[][][] tagTreeEncoderArr4 = this.ttMaxBP[length4][length5];
                int length6 = iArr4.length - i;
                while (length6 >= 0) {
                    TagTreeEncoder[][] tagTreeEncoderArr5 = tagTreeEncoderArr3[length6];
                    TagTreeEncoder[][] tagTreeEncoderArr6 = tagTreeEncoderArr4[length6];
                    int[][] iArr6 = this.prevtIdxs[length4][length5][length6];
                    int[][] iArr7 = this.bak_prevtIdxs[length4][length5][length6];
                    int i4 = length6 == 0 ? 0 : 1;
                    int i5 = length6 == 0 ? 1 : 4;
                    int i6 = i4;
                    while (i6 < i5) {
                        int[] iArr8 = iArr4[length6][i6];
                        int i7 = length4;
                        int i8 = i6;
                        System.arraycopy(iArr8, 0, iArr5[length6][i6], 0, iArr8.length);
                        int[] iArr9 = iArr6[i8];
                        System.arraycopy(iArr9, 0, iArr7[i8], 0, iArr9.length);
                        i6 = i8 + 1;
                        length4 = i7;
                        length5 = length5;
                    }
                    int i9 = length4;
                    int i10 = length5;
                    for (int length7 = this.ppinfo[i9][i10][length6].length - 1; length7 >= 0; length7--) {
                        if (length7 < tagTreeEncoderArr5.length) {
                            for (int i11 = i4; i11 < i5; i11++) {
                                tagTreeEncoderArr5[length7][i11].save();
                                tagTreeEncoderArr6[length7][i11].save();
                            }
                        }
                    }
                    length6--;
                    length4 = i9;
                    length5 = i10;
                }
                length5--;
                length4 = length4;
                i = 1;
            }
            length4--;
            i = 1;
        }
        this.saved = true;
    }

    public void restore() {
        if (!this.saved) {
            throw new IllegalArgumentException();
        }
        this.lbbuf = null;
        int i = 1;
        int length = this.ttIncl.length - 1;
        while (length >= 0) {
            int length2 = this.ttIncl[length].length - i;
            while (length2 >= 0) {
                int[][][] iArr = this.lblock[length][length2];
                int[][][] iArr2 = this.bak_lblock[length][length2];
                TagTreeEncoder[][][] tagTreeEncoderArr = this.ttIncl[length][length2];
                TagTreeEncoder[][][] tagTreeEncoderArr2 = this.ttMaxBP[length][length2];
                int length3 = iArr.length - i;
                while (length3 >= 0) {
                    TagTreeEncoder[][] tagTreeEncoderArr3 = tagTreeEncoderArr[length3];
                    TagTreeEncoder[][] tagTreeEncoderArr4 = tagTreeEncoderArr2[length3];
                    int[][] iArr3 = this.prevtIdxs[length][length2][length3];
                    int[][] iArr4 = this.bak_prevtIdxs[length][length2][length3];
                    int i2 = length3 == 0 ? 0 : 1;
                    int i3 = length3 == 0 ? 1 : 4;
                    int i4 = i2;
                    while (i4 < i3) {
                        int[] iArr5 = iArr2[length3][i4];
                        int i5 = length;
                        int[] iArr6 = iArr[length3][i4];
                        int i6 = i4;
                        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
                        int[] iArr7 = iArr4[i6];
                        int[] iArr8 = iArr3[i6];
                        System.arraycopy(iArr7, 0, iArr8, 0, iArr8.length);
                        i4 = i6 + 1;
                        length = i5;
                        length2 = length2;
                    }
                    int i7 = length;
                    int i8 = length2;
                    for (int length4 = this.ppinfo[i7][i8][length3].length - 1; length4 >= 0; length4--) {
                        if (length4 < tagTreeEncoderArr3.length) {
                            for (int i9 = i2; i9 < i3; i9++) {
                                tagTreeEncoderArr3[length4][i9].restore();
                                tagTreeEncoderArr4[length4][i9].restore();
                            }
                        }
                    }
                    length3--;
                    length = i7;
                    length2 = i8;
                }
                length2--;
                i = 1;
            }
            length--;
            i = 1;
        }
    }

    public void reset() {
        this.saved = false;
        this.lbbuf = null;
        for (int length = this.ttIncl.length - 1; length >= 0; length--) {
            for (int length2 = this.ttIncl[length].length - 1; length2 >= 0; length2--) {
                int[][][] iArr = this.lblock[length][length2];
                TagTreeEncoder[][][] tagTreeEncoderArr = this.ttIncl[length][length2];
                TagTreeEncoder[][][] tagTreeEncoderArr2 = this.ttMaxBP[length][length2];
                int length3 = iArr.length - 1;
                while (length3 >= 0) {
                    TagTreeEncoder[][] tagTreeEncoderArr3 = tagTreeEncoderArr[length3];
                    TagTreeEncoder[][] tagTreeEncoderArr4 = tagTreeEncoderArr2[length3];
                    int[][] iArr2 = this.prevtIdxs[length][length2][length3];
                    int i = length3 == 0 ? 0 : 1;
                    int i2 = length3 == 0 ? 1 : 4;
                    for (int i3 = i; i3 < i2; i3++) {
                        ArrayUtil.intArraySet(iArr2[i3], -1);
                        ArrayUtil.intArraySet(iArr[length3][i3], 3);
                    }
                    for (int length4 = this.ppinfo[length][length2][length3].length - 1; length4 >= 0; length4--) {
                        if (length4 < tagTreeEncoderArr3.length) {
                            for (int i4 = i; i4 < i2; i4++) {
                                tagTreeEncoderArr3[length4][i4].reset();
                                tagTreeEncoderArr4[length4][i4].reset();
                            }
                        }
                    }
                    length3--;
                }
            }
        }
    }

    public boolean isPacketWritable() {
        return this.packetWritable;
    }

    public boolean isROIinPkt() {
        return this.roiInPkt;
    }

    public int getROILen() {
        return this.roiLen;
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public PrecInfo getPrecInfo(int i, int i2, int i3, int i4) {
        return this.ppinfo[i][i2][i3][i4];
    }
}
