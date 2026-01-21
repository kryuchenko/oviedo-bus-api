package org.jnbis.internal;

import java.util.Arrays;
import org.jnbis.Bitmap;
import org.jnbis.internal.WsqHelper;

/* loaded from: classes6.dex */
public class InternalWsqDecoder {
    private int getCPpiWSQ() {
        return -1;
    }

    private int intSign(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = -1;
        for (int i3 = 1; i3 < i; i3++) {
            i2 *= -1;
        }
        return i2;
    }

    public Bitmap decode(byte[] bArr) {
        WsqHelper.Token token = new WsqHelper.Token(bArr);
        token.initialize();
        getCMarkerWSQ(token, 65440);
        int cMarkerWSQ = getCMarkerWSQ(token, 2);
        while (cMarkerWSQ != 65442) {
            getCTableWSQ(token, cMarkerWSQ);
            cMarkerWSQ = getCMarkerWSQ(token, 2);
        }
        WsqHelper.HeaderFrm cFrameHeaderWSQ = getCFrameHeaderWSQ(token);
        int i = cFrameHeaderWSQ.width;
        int i2 = cFrameHeaderWSQ.height;
        int cPpiWSQ = getCPpiWSQ();
        buildWSQTrees(token, i, i2);
        float[] fArrUnquantize = unquantize(token, huffmanDecodeDataMem(token, i * i2), i, i2);
        wsqReconstruct(token, fArrUnquantize, i, i2);
        return new Bitmap(convertImage2Byte(fArrUnquantize, i, i2, cFrameHeaderWSQ.mShift, cFrameHeaderWSQ.rScale), i, i2, cPpiWSQ, 8, 1);
    }

    private int getCMarkerWSQ(WsqHelper.Token token, int i) {
        if (token.pointer >= token.buffer.length) {
            throw new RuntimeException("Error, Invalid pointer : " + token.pointer);
        }
        int i2 = token.readShort();
        if (i != 2) {
            if (i != 4) {
                if (i != 65440) {
                    if (i != 65535) {
                        throw new RuntimeException("ERROR : getc_marker_wsq : Invalid marker : " + i2);
                    }
                    if ((i2 & 65280) != 65280) {
                        throw new RuntimeException("ERROR : getc_marker_wsq : no marker found : " + i2);
                    }
                    if (i2 < 65440 || i2 > 65448) {
                        throw new RuntimeException("ERROR : getc_marker_wsq : not a valid marker : " + i2);
                    }
                } else if (i2 != 65440) {
                    throw new RuntimeException("ERROR : getCMarkerWSQ : No SOI marker : " + i2);
                }
            } else if (i2 != 65444 && i2 != 65445 && i2 != 65446 && i2 != 65443 && i2 != 65448) {
                throw new RuntimeException("ERROR : getc_marker_wsq : No SOB, Table, or comment markers : " + i2);
            }
        } else if (i2 != 65444 && i2 != 65445 && i2 != 65446 && i2 != 65442 && i2 != 65448) {
            throw new RuntimeException("ERROR : getc_marker_wsq : No SOF, Table, or comment markers : " + i2);
        }
        return i2;
    }

    private void getCTableWSQ(WsqHelper.Token token, int i) {
        switch (i) {
            case 65444:
                getCTransformTable(token);
                return;
            case 65445:
                getCQuantizationTable(token);
                return;
            case 65446:
                getCHuffmanTableWSQ(token);
                return;
            case 65447:
            default:
                throw new RuntimeException("ERROR: getCTableWSQ : Invalid table defined : " + i);
            case 65448:
                getCComment(token);
                return;
        }
    }

    private String getCComment(WsqHelper.Token token) {
        return Arrays.toString(token.readBytes(token.readShort() - 2));
    }

    private void getCTransformTable(WsqHelper.Token token) {
        int i;
        int i2;
        token.readShort();
        token.tableDTT.hisz = token.readByte();
        token.tableDTT.losz = token.readByte();
        token.tableDTT.hifilt = new float[token.tableDTT.hisz];
        token.tableDTT.lofilt = new float[token.tableDTT.losz];
        if (token.tableDTT.hisz % 2 != 0) {
            i = (token.tableDTT.hisz + 1) / 2;
        } else {
            i = token.tableDTT.hisz / 2;
        }
        float[] fArr = new float[i];
        int i3 = i - 1;
        for (int i4 = 0; i4 <= i3; i4++) {
            int i5 = token.readByte();
            fArr[i4] = token.readInt();
            for (int i6 = token.readByte(); i6 > 0; i6--) {
                fArr[i4] = (float) (fArr[i4] / 10.0d);
            }
            if (i5 != 0) {
                fArr[i4] = (float) (fArr[i4] * (-1.0d));
            }
            if (token.tableDTT.hisz % 2 != 0) {
                int i7 = i4 + i3;
                token.tableDTT.hifilt[i7] = intSign(i4) * fArr[i4];
                if (i4 > 0) {
                    token.tableDTT.hifilt[i3 - i4] = token.tableDTT.hifilt[i7];
                }
            } else {
                int i8 = i4 + i3 + 1;
                token.tableDTT.hifilt[i8] = intSign(i4) * fArr[i4];
                token.tableDTT.hifilt[i3 - i4] = token.tableDTT.hifilt[i8] * (-1.0f);
            }
        }
        if (token.tableDTT.losz % 2 != 0) {
            i2 = (token.tableDTT.losz + 1) / 2;
        } else {
            i2 = token.tableDTT.losz / 2;
        }
        float[] fArr2 = new float[i2];
        int i9 = i2 - 1;
        for (int i10 = 0; i10 <= i9; i10++) {
            int i11 = token.readByte();
            fArr2[i10] = token.readInt();
            for (int i12 = token.readByte(); i12 > 0; i12--) {
                fArr2[i10] = (float) (fArr2[i10] / 10.0d);
            }
            if (i11 != 0) {
                fArr2[i10] = (float) (fArr2[i10] * (-1.0d));
            }
            if (token.tableDTT.losz % 2 != 0) {
                int i13 = i10 + i9;
                token.tableDTT.lofilt[i13] = intSign(i10) * fArr2[i10];
                if (i10 > 0) {
                    token.tableDTT.lofilt[i9 - i10] = token.tableDTT.lofilt[i13];
                }
            } else {
                int i14 = i10 + i9 + 1;
                token.tableDTT.lofilt[i14] = intSign(i10 + 1) * fArr2[i10];
                token.tableDTT.lofilt[i9 - i10] = token.tableDTT.lofilt[i14];
            }
        }
        token.tableDTT.lodef = 1;
        token.tableDTT.hidef = 1;
    }

    public void getCQuantizationTable(WsqHelper.Token token) {
        token.readShort();
        token.tableDQT.binCenter = token.readShort();
        for (int i = token.readByte(); i > 0; i--) {
            token.tableDQT.binCenter = (float) (r3.binCenter / 10.0d);
        }
        for (int i2 = 0; i2 < 64; i2++) {
            token.tableDQT.qBin[i2] = token.readShort();
            for (int i3 = token.readByte(); i3 > 0; i3--) {
                token.tableDQT.qBin[i2] = (float) (r4[i2] / 10.0d);
            }
            token.tableDQT.zBin[i2] = token.readShort();
            for (int i4 = token.readByte(); i4 > 0; i4--) {
                token.tableDQT.zBin[i2] = (float) (r4[i2] / 10.0d);
            }
        }
        token.tableDQT.dqtDef = (char) 1;
    }

    public void getCHuffmanTableWSQ(WsqHelper.Token token) {
        WsqHelper.HuffmanTable cHuffmanTable = getCHuffmanTable(token, 256, 0, true);
        int i = cHuffmanTable.tableId;
        token.tableDHT[i].huffbits = (int[]) cHuffmanTable.huffbits.clone();
        token.tableDHT[i].huffvalues = (int[]) cHuffmanTable.huffvalues.clone();
        token.tableDHT[i].tabdef = (byte) 1;
        int i2 = cHuffmanTable.bytesLeft;
        while (i2 != 0) {
            WsqHelper.HuffmanTable cHuffmanTable2 = getCHuffmanTable(token, 256, i2, false);
            int i3 = cHuffmanTable2.tableId;
            if (token.tableDHT[i3].tabdef != 0) {
                throw new RuntimeException("ERROR : getCHuffmanTableWSQ : huffman table already defined.");
            }
            token.tableDHT[i3].huffbits = (int[]) cHuffmanTable2.huffbits.clone();
            token.tableDHT[i3].huffvalues = (int[]) cHuffmanTable2.huffvalues.clone();
            token.tableDHT[i3].tabdef = (byte) 1;
            i2 = cHuffmanTable2.bytesLeft;
        }
    }

    private WsqHelper.HuffmanTable getCHuffmanTable(WsqHelper.Token token, int i, int i2, boolean z) {
        WsqHelper.HuffmanTable huffmanTable = new WsqHelper.HuffmanTable();
        if (z) {
            huffmanTable.tableLen = token.readShort();
            huffmanTable.bytesLeft = huffmanTable.tableLen - 2;
            i2 = huffmanTable.bytesLeft;
        } else {
            huffmanTable.bytesLeft = i2;
        }
        if (i2 <= 0) {
            throw new RuntimeException("ERROR : getCHuffmanTable : no huffman table bytes remaining");
        }
        huffmanTable.tableId = token.readByte();
        huffmanTable.bytesLeft--;
        huffmanTable.huffbits = new int[16];
        int i3 = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            huffmanTable.huffbits[i4] = token.readByte();
            i3 += huffmanTable.huffbits[i4];
        }
        huffmanTable.bytesLeft -= 16;
        int i5 = i + 1;
        if (i3 > i5) {
            throw new RuntimeException("ERROR : getCHuffmanTable : numHufvals is larger than MAX_HUFFCOUNTS");
        }
        huffmanTable.huffvalues = new int[i5];
        for (int i6 = 0; i6 < i3; i6++) {
            huffmanTable.huffvalues[i6] = token.readByte();
        }
        huffmanTable.bytesLeft -= i3;
        return huffmanTable;
    }

    private WsqHelper.HeaderFrm getCFrameHeaderWSQ(WsqHelper.Token token) {
        WsqHelper.HeaderFrm headerFrm = new WsqHelper.HeaderFrm();
        token.readShort();
        headerFrm.black = token.readByte();
        headerFrm.white = token.readByte();
        headerFrm.height = token.readShort();
        headerFrm.width = token.readShort();
        headerFrm.mShift = token.readShort();
        for (int i = token.readByte(); i > 0; i--) {
            headerFrm.mShift = (float) (headerFrm.mShift / 10.0d);
        }
        headerFrm.rScale = token.readShort();
        for (int i2 = token.readByte(); i2 > 0; i2--) {
            headerFrm.rScale = (float) (headerFrm.rScale / 10.0d);
        }
        headerFrm.wsqEncoder = token.readByte();
        headerFrm.software = token.readShort();
        return headerFrm;
    }

    private void buildWSQTrees(WsqHelper.Token token, int i, int i2) {
        buildWTree(token, 20, i, i2);
        buildQTree(token, 64);
    }

    private void buildWTree(WsqHelper.Token token, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        token.wtree = new WsqHelper.WavletTree[i];
        for (int i8 = 0; i8 < i; i8++) {
            token.wtree[i8] = new WsqHelper.WavletTree();
            token.wtree[i8].invrw = 0;
            token.wtree[i8].invcl = 0;
        }
        token.wtree[2].invrw = 1;
        token.wtree[4].invrw = 1;
        token.wtree[7].invrw = 1;
        token.wtree[9].invrw = 1;
        token.wtree[11].invrw = 1;
        token.wtree[13].invrw = 1;
        token.wtree[16].invrw = 1;
        token.wtree[18].invrw = 1;
        token.wtree[3].invcl = 1;
        token.wtree[5].invcl = 1;
        token.wtree[8].invcl = 1;
        token.wtree[9].invcl = 1;
        token.wtree[12].invcl = 1;
        token.wtree[13].invcl = 1;
        token.wtree[17].invcl = 1;
        token.wtree[18].invcl = 1;
        wtree4(token, 0, 1, i2, i3, 0, 0, 1);
        if (token.wtree[1].lenx % 2 == 0) {
            i5 = token.wtree[1].lenx / 2;
            i4 = i5;
        } else {
            int i9 = (token.wtree[1].lenx + 1) / 2;
            i4 = i9;
            i5 = i9 - 1;
        }
        if (token.wtree[1].leny % 2 == 0) {
            i6 = token.wtree[1].leny / 2;
            i7 = i6;
        } else {
            int i10 = (token.wtree[1].leny + 1) / 2;
            i6 = i10;
            i7 = i10 - 1;
        }
        wtree4(token, 4, 6, i5, i6, i4, 0, 0);
        int i11 = i4;
        int i12 = i6;
        wtree4(token, 5, 10, i11, i7, 0, i12, 0);
        wtree4(token, 14, 15, i11, i12, 0, 0, 0);
        token.wtree[19].x = 0;
        token.wtree[19].y = 0;
        if (token.wtree[15].lenx % 2 == 0) {
            token.wtree[19].lenx = token.wtree[15].lenx / 2;
        } else {
            token.wtree[19].lenx = (token.wtree[15].lenx + 1) / 2;
        }
        if (token.wtree[15].leny % 2 == 0) {
            token.wtree[19].leny = token.wtree[15].leny / 2;
        } else {
            token.wtree[19].leny = (token.wtree[15].leny + 1) / 2;
        }
    }

    private void wtree4(WsqHelper.Token token, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i3 % 2;
        int i9 = i4 % 2;
        token.wtree[i].x = i5;
        token.wtree[i].y = i6;
        token.wtree[i].lenx = i3;
        token.wtree[i].leny = i4;
        token.wtree[i2].x = i5;
        int i10 = i2 + 2;
        token.wtree[i10].x = i5;
        token.wtree[i2].y = i6;
        int i11 = i2 + 1;
        token.wtree[i11].y = i6;
        if (i8 == 0) {
            token.wtree[i2].lenx = i3 / 2;
            token.wtree[i11].lenx = token.wtree[i2].lenx;
        } else if (i == 4) {
            token.wtree[i2].lenx = (i3 - 1) / 2;
            token.wtree[i11].lenx = token.wtree[i2].lenx + 1;
        } else {
            token.wtree[i2].lenx = (i3 + 1) / 2;
            token.wtree[i11].lenx = token.wtree[i2].lenx - 1;
        }
        token.wtree[i11].x = token.wtree[i2].lenx + i5;
        if (i7 == 0) {
            int i12 = i2 + 3;
            token.wtree[i12].lenx = token.wtree[i11].lenx;
            token.wtree[i12].x = token.wtree[i11].x;
        }
        token.wtree[i10].lenx = token.wtree[i2].lenx;
        if (i9 == 0) {
            token.wtree[i2].leny = i4 / 2;
            token.wtree[i10].leny = token.wtree[i2].leny;
        } else if (i == 5) {
            token.wtree[i2].leny = (i4 - 1) / 2;
            token.wtree[i10].leny = token.wtree[i2].leny + 1;
        } else {
            token.wtree[i2].leny = (i4 + 1) / 2;
            token.wtree[i10].leny = token.wtree[i2].leny - 1;
        }
        token.wtree[i10].y = token.wtree[i2].leny + i6;
        if (i7 == 0) {
            int i13 = i2 + 3;
            token.wtree[i13].leny = token.wtree[i10].leny;
            token.wtree[i13].y = token.wtree[i10].y;
        }
        token.wtree[i11].leny = token.wtree[i2].leny;
    }

    private void buildQTree(WsqHelper.Token token, int i) {
        token.qtree = new WsqHelper.QuantTree[i];
        for (int i2 = 0; i2 < token.qtree.length; i2++) {
            token.qtree[i2] = new WsqHelper.QuantTree();
        }
        qtree16(token, 3, token.wtree[14].lenx, token.wtree[14].leny, token.wtree[14].x, token.wtree[14].y, 0, 0);
        qtree16(token, 19, token.wtree[4].lenx, token.wtree[4].leny, token.wtree[4].x, token.wtree[4].y, 0, 1);
        qtree16(token, 48, token.wtree[0].lenx, token.wtree[0].leny, token.wtree[0].x, token.wtree[0].y, 0, 0);
        qtree16(token, 35, token.wtree[5].lenx, token.wtree[5].leny, token.wtree[5].x, token.wtree[5].y, 1, 0);
        qtree4(token, 0, token.wtree[19].lenx, token.wtree[19].leny, token.wtree[19].x, token.wtree[19].y);
    }

    private void qtree16(WsqHelper.Token token, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i3 % 2;
        if (i2 % 2 == 0) {
            i8 = i2 / 2;
            i9 = i8;
        } else if (i7 != 0) {
            int i13 = (i2 + 1) / 2;
            i9 = i13;
            i8 = i13 - 1;
        } else {
            i8 = (i2 + 1) / 2;
            i9 = i8 - 1;
        }
        if (i12 == 0) {
            i10 = i3 / 2;
            i11 = i10;
        } else if (i6 != 0) {
            int i14 = (i3 + 1) / 2;
            i11 = i14;
            i10 = i14 - 1;
        } else {
            i10 = (i3 + 1) / 2;
            i11 = i10 - 1;
        }
        int i15 = i8 % 2;
        int i16 = i10 % 2;
        token.qtree[i].x = i4;
        int i17 = i + 2;
        token.qtree[i17].x = i4;
        token.qtree[i].y = i5;
        int i18 = i + 1;
        token.qtree[i18].y = i5;
        if (i15 == 0) {
            token.qtree[i].lenx = i8 / 2;
            token.qtree[i18].lenx = token.qtree[i].lenx;
            token.qtree[i17].lenx = token.qtree[i].lenx;
            token.qtree[i + 3].lenx = token.qtree[i].lenx;
        } else {
            token.qtree[i].lenx = (i8 + 1) / 2;
            token.qtree[i18].lenx = token.qtree[i].lenx - 1;
            token.qtree[i17].lenx = token.qtree[i].lenx;
            token.qtree[i + 3].lenx = token.qtree[i18].lenx;
        }
        token.qtree[i18].x = token.qtree[i].lenx + i4;
        int i19 = i + 3;
        token.qtree[i19].x = token.qtree[i18].x;
        if (i16 == 0) {
            token.qtree[i].leny = i10 / 2;
            token.qtree[i18].leny = token.qtree[i].leny;
            token.qtree[i17].leny = token.qtree[i].leny;
            token.qtree[i19].leny = token.qtree[i].leny;
        } else {
            token.qtree[i].leny = (i10 + 1) / 2;
            token.qtree[i18].leny = token.qtree[i].leny;
            token.qtree[i17].leny = token.qtree[i].leny - 1;
            token.qtree[i19].leny = token.qtree[i17].leny;
        }
        token.qtree[i17].y = token.qtree[i].leny + i5;
        token.qtree[i19].y = token.qtree[i17].y;
        int i20 = i9 % 2;
        int i21 = i + 4;
        token.qtree[i21].x = i8 + i4;
        int i22 = i + 6;
        token.qtree[i22].x = token.qtree[i21].x;
        token.qtree[i21].y = i5;
        int i23 = i + 5;
        token.qtree[i23].y = i5;
        token.qtree[i22].y = token.qtree[i17].y;
        int i24 = i + 7;
        token.qtree[i24].y = token.qtree[i17].y;
        token.qtree[i21].leny = token.qtree[i].leny;
        token.qtree[i23].leny = token.qtree[i].leny;
        token.qtree[i22].leny = token.qtree[i17].leny;
        token.qtree[i24].leny = token.qtree[i17].leny;
        if (i20 == 0) {
            token.qtree[i21].lenx = i9 / 2;
            token.qtree[i23].lenx = token.qtree[i21].lenx;
            token.qtree[i22].lenx = token.qtree[i21].lenx;
            token.qtree[i24].lenx = token.qtree[i21].lenx;
        } else {
            token.qtree[i23].lenx = (i9 + 1) / 2;
            token.qtree[i21].lenx = token.qtree[i23].lenx - 1;
            token.qtree[i22].lenx = token.qtree[i21].lenx;
            token.qtree[i24].lenx = token.qtree[i23].lenx;
        }
        token.qtree[i23].x = token.qtree[i21].x + token.qtree[i21].lenx;
        token.qtree[i24].x = token.qtree[i23].x;
        int i25 = i11 % 2;
        int i26 = i + 8;
        token.qtree[i26].x = i4;
        int i27 = i + 9;
        token.qtree[i27].x = token.qtree[i18].x;
        int i28 = i + 10;
        token.qtree[i28].x = i4;
        int i29 = i + 11;
        token.qtree[i29].x = token.qtree[i18].x;
        token.qtree[i26].y = i5 + i10;
        token.qtree[i27].y = token.qtree[i26].y;
        token.qtree[i26].lenx = token.qtree[i].lenx;
        token.qtree[i27].lenx = token.qtree[i18].lenx;
        token.qtree[i28].lenx = token.qtree[i].lenx;
        token.qtree[i29].lenx = token.qtree[i18].lenx;
        if (i25 == 0) {
            token.qtree[i26].leny = i11 / 2;
            token.qtree[i27].leny = token.qtree[i26].leny;
            token.qtree[i28].leny = token.qtree[i26].leny;
            token.qtree[i29].leny = token.qtree[i26].leny;
        } else {
            token.qtree[i28].leny = (i11 + 1) / 2;
            token.qtree[i29].leny = token.qtree[i28].leny;
            token.qtree[i26].leny = token.qtree[i28].leny - 1;
            token.qtree[i27].leny = token.qtree[i26].leny;
        }
        token.qtree[i28].y = token.qtree[i26].y + token.qtree[i26].leny;
        token.qtree[i29].y = token.qtree[i28].y;
        int i30 = i + 12;
        token.qtree[i30].x = token.qtree[i21].x;
        int i31 = i + 13;
        token.qtree[i31].x = token.qtree[i23].x;
        int i32 = i + 14;
        token.qtree[i32].x = token.qtree[i21].x;
        int i33 = i + 15;
        token.qtree[i33].x = token.qtree[i23].x;
        token.qtree[i30].y = token.qtree[i26].y;
        token.qtree[i31].y = token.qtree[i26].y;
        token.qtree[i32].y = token.qtree[i28].y;
        token.qtree[i33].y = token.qtree[i28].y;
        token.qtree[i30].lenx = token.qtree[i21].lenx;
        token.qtree[i31].lenx = token.qtree[i23].lenx;
        token.qtree[i32].lenx = token.qtree[i21].lenx;
        token.qtree[i33].lenx = token.qtree[i23].lenx;
        token.qtree[i30].leny = token.qtree[i26].leny;
        token.qtree[i31].leny = token.qtree[i26].leny;
        token.qtree[i32].leny = token.qtree[i28].leny;
        token.qtree[i33].leny = token.qtree[i28].leny;
    }

    private void qtree4(WsqHelper.Token token, int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 % 2;
        int i7 = i3 % 2;
        token.qtree[i].x = i4;
        int i8 = i + 2;
        token.qtree[i8].x = i4;
        token.qtree[i].y = i5;
        int i9 = i + 1;
        token.qtree[i9].y = i5;
        if (i6 == 0) {
            token.qtree[i].lenx = i2 / 2;
            token.qtree[i9].lenx = token.qtree[i].lenx;
            token.qtree[i8].lenx = token.qtree[i].lenx;
            token.qtree[i + 3].lenx = token.qtree[i].lenx;
        } else {
            token.qtree[i].lenx = (i2 + 1) / 2;
            token.qtree[i9].lenx = token.qtree[i].lenx - 1;
            token.qtree[i8].lenx = token.qtree[i].lenx;
            token.qtree[i + 3].lenx = token.qtree[i9].lenx;
        }
        token.qtree[i9].x = i4 + token.qtree[i].lenx;
        int i10 = i + 3;
        token.qtree[i10].x = token.qtree[i9].x;
        if (i7 == 0) {
            token.qtree[i].leny = i3 / 2;
            token.qtree[i9].leny = token.qtree[i].leny;
            token.qtree[i8].leny = token.qtree[i].leny;
            token.qtree[i10].leny = token.qtree[i].leny;
        } else {
            token.qtree[i].leny = (i3 + 1) / 2;
            token.qtree[i9].leny = token.qtree[i].leny;
            token.qtree[i8].leny = token.qtree[i].leny - 1;
            token.qtree[i10].leny = token.qtree[i8].leny;
        }
        token.qtree[i8].y = i5 + token.qtree[i].leny;
        token.qtree[i10].y = token.qtree[i8].y;
    }

    private int[] huffmanDecodeDataMem(WsqHelper.Token token, int i) {
        int cBlockHeader;
        int i2;
        WsqHelper.Token token2 = token;
        int[] iArr = new int[i];
        int[] iArr2 = new int[17];
        int[] iArr3 = new int[17];
        int[] iArr4 = new int[17];
        WsqHelper.IntRef intRef = new WsqHelper.IntRef(getCMarkerWSQ(token2, 4));
        WsqHelper.IntRef intRef2 = new WsqHelper.IntRef(0);
        WsqHelper.IntRef intRef3 = new WsqHelper.IntRef(0);
        int i3 = 0;
        int i4 = 0;
        while (intRef.value != 65441) {
            if (intRef.value != 0) {
                while (intRef.value != 65443) {
                    getCTableWSQ(token2, intRef.value);
                    intRef.value = getCMarkerWSQ(token2, 4);
                }
                cBlockHeader = getCBlockHeader(token);
                if (token2.tableDHT[cBlockHeader].tabdef != 1) {
                    throw new RuntimeException("ERROR : huffmanDecodeDataMem : huffman table undefined.");
                }
                WsqHelper.HuffCode[] huffCodeArrBuildHuffsizes = buildHuffsizes(token2.tableDHT[cBlockHeader].huffbits, 256);
                buildHuffcodes(huffCodeArrBuildHuffsizes);
                int[] iArr5 = iArr4;
                int[] iArr6 = iArr2;
                int[] iArr7 = iArr3;
                genDecodeTable(huffCodeArrBuildHuffsizes, iArr6, iArr7, iArr5, token2.tableDHT[cBlockHeader].huffbits);
                iArr2 = iArr6;
                iArr3 = iArr7;
                iArr4 = iArr5;
                intRef2.value = 0;
                intRef.value = 0;
            } else {
                cBlockHeader = i3;
            }
            WsqHelper.IntRef intRef4 = intRef;
            WsqHelper.IntRef intRef5 = intRef2;
            WsqHelper.IntRef intRef6 = intRef3;
            int iDecodeDataMem = decodeDataMem(token2, iArr3, iArr2, iArr4, token2.tableDHT[cBlockHeader].huffvalues, intRef5, intRef4, intRef6);
            int[] iArr8 = iArr3;
            int[] iArr9 = iArr2;
            WsqHelper.IntRef intRef7 = intRef6;
            int[] iArr10 = iArr4;
            if (iDecodeDataMem != -1) {
                if (iDecodeDataMem > 0 && iDecodeDataMem <= 100) {
                    int i5 = 0;
                    while (i5 < iDecodeDataMem) {
                        iArr[i4] = 0;
                        i5++;
                        i4++;
                    }
                } else if (iDecodeDataMem <= 106 || iDecodeDataMem >= 255) {
                    if (iDecodeDataMem == 101) {
                        i2 = i4 + 1;
                        int cNextbitsWSQ = getCNextbitsWSQ(token, intRef4, intRef5, 8, intRef7);
                        intRef7 = intRef7;
                        iArr[i4] = cNextbitsWSQ;
                    } else if (iDecodeDataMem == 102) {
                        i2 = i4 + 1;
                        int cNextbitsWSQ2 = getCNextbitsWSQ(token, intRef4, intRef5, 8, intRef7);
                        intRef7 = intRef7;
                        iArr[i4] = -cNextbitsWSQ2;
                    } else if (iDecodeDataMem == 103) {
                        i2 = i4 + 1;
                        int cNextbitsWSQ3 = getCNextbitsWSQ(token, intRef4, intRef5, 16, intRef7);
                        intRef7 = intRef7;
                        iArr[i4] = cNextbitsWSQ3;
                    } else if (iDecodeDataMem == 104) {
                        i2 = i4 + 1;
                        int cNextbitsWSQ4 = getCNextbitsWSQ(token, intRef4, intRef5, 16, intRef7);
                        intRef7 = intRef7;
                        iArr[i4] = -cNextbitsWSQ4;
                    } else if (iDecodeDataMem == 105) {
                        int cNextbitsWSQ5 = getCNextbitsWSQ(token, intRef4, intRef5, 8, intRef7);
                        intRef7 = intRef7;
                        while (true) {
                            int i6 = cNextbitsWSQ5 - 1;
                            if (cNextbitsWSQ5 > 0) {
                                iArr[i4] = 0;
                                i4++;
                                cNextbitsWSQ5 = i6;
                            }
                        }
                    } else if (iDecodeDataMem == 106) {
                        int cNextbitsWSQ6 = getCNextbitsWSQ(token, intRef4, intRef5, 16, intRef7);
                        intRef7 = intRef7;
                        while (true) {
                            int i7 = cNextbitsWSQ6 - 1;
                            if (cNextbitsWSQ6 > 0) {
                                iArr[i4] = 0;
                                i4++;
                                cNextbitsWSQ6 = i7;
                            }
                        }
                    } else {
                        throw new RuntimeException("ERROR: huffman_decode_data_mem : Invalid code (" + iDecodeDataMem + ")");
                    }
                    i4 = i2;
                } else {
                    iArr[i4] = iDecodeDataMem - 180;
                    i4++;
                }
            }
            token2 = token;
            intRef3 = intRef7;
            intRef = intRef4;
            iArr3 = iArr8;
            iArr4 = iArr10;
            i3 = cBlockHeader;
            intRef2 = intRef5;
            iArr2 = iArr9;
        }
        return iArr;
    }

    private int getCBlockHeader(WsqHelper.Token token) {
        token.readShort();
        return token.readByte();
    }

    private WsqHelper.HuffCode[] buildHuffsizes(int[] iArr, int i) {
        WsqHelper.HuffCode[] huffCodeArr = new WsqHelper.HuffCode[i + 1];
        int i2 = 0;
        for (int i3 = 1; i3 <= 16; i3++) {
            for (int i4 = 1; i4 <= iArr[i3 - 1]; i4++) {
                WsqHelper.HuffCode huffCode = new WsqHelper.HuffCode();
                huffCodeArr[i2] = huffCode;
                huffCode.size = i3;
                i2++;
            }
        }
        WsqHelper.HuffCode huffCode2 = new WsqHelper.HuffCode();
        huffCodeArr[i2] = huffCode2;
        huffCode2.size = 0;
        return huffCodeArr;
    }

    private void buildHuffcodes(WsqHelper.HuffCode[] huffCodeArr) {
        int i = 0;
        int i2 = huffCodeArr[0].size;
        if (huffCodeArr[0].size == 0) {
            return;
        }
        int i3 = i2;
        short s = 0;
        while (true) {
            huffCodeArr[i].code = s;
            s = (short) (s + 1);
            i++;
            if (huffCodeArr[i].size != i3) {
                if (huffCodeArr[i].size == 0) {
                    return;
                }
                do {
                    s = (short) (s << 1);
                    i3++;
                } while (huffCodeArr[i].size != i3);
                if (huffCodeArr[i].size != i3) {
                    return;
                }
            }
        }
    }

    private void genDecodeTable(WsqHelper.HuffCode[] huffCodeArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i = 0;
        for (int i2 = 0; i2 <= 16; i2++) {
            iArr[i2] = 0;
            iArr2[i2] = 0;
            iArr3[i2] = 0;
        }
        for (int i3 = 1; i3 <= 16; i3++) {
            int i4 = i3 - 1;
            if (iArr4[i4] == 0) {
                iArr[i3] = -1;
            } else {
                iArr3[i3] = i;
                iArr2[i3] = huffCodeArr[i].code;
                i += iArr4[i4];
                iArr[i3] = huffCodeArr[i - 1].code;
            }
        }
    }

    private int decodeDataMem(WsqHelper.Token token, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, WsqHelper.IntRef intRef, WsqHelper.IntRef intRef2, WsqHelper.IntRef intRef3) {
        short cNextbitsWSQ = (short) getCNextbitsWSQ(token, intRef2, intRef, 1, intRef3);
        if (intRef2.value != 0) {
            return -1;
        }
        int i = 1;
        while (cNextbitsWSQ > iArr2[i]) {
            cNextbitsWSQ = (short) ((cNextbitsWSQ << 1) + getCNextbitsWSQ(token, intRef2, intRef, 1, intRef3));
            if (intRef2.value != 0) {
                return -1;
            }
            i++;
        }
        return iArr4[(iArr3[i] + cNextbitsWSQ) - iArr[i]];
    }

    private int getCNextbitsWSQ(WsqHelper.Token token, WsqHelper.IntRef intRef, WsqHelper.IntRef intRef2, int i, WsqHelper.IntRef intRef3) {
        if (intRef2.value == 0) {
            intRef3.value = token.readByte();
            intRef2.value = 8;
            if (intRef3.value == 255) {
                int i2 = token.readByte();
                if (i2 != 0 && i == 1) {
                    intRef.value = (intRef3.value << 8) | i2;
                    return 1;
                }
                if (i2 != 0) {
                    throw new RuntimeException("ERROR: getCNextbitsWSQ : No stuffed zeros.");
                }
            }
        }
        if (i <= intRef2.value) {
            int i3 = (intRef3.value >> (intRef2.value - i)) & WsqHelper.BITMASK[i];
            intRef2.value -= i;
            intRef3.value &= WsqHelper.BITMASK[intRef2.value];
            return i3;
        }
        int i4 = i - intRef2.value;
        int i5 = intRef3.value << i4;
        intRef2.value = 0;
        return getCNextbitsWSQ(token, intRef, intRef2, i4, intRef3) | i5;
    }

    private float[] unquantize(WsqHelper.Token token, int[] iArr, int i, int i2) {
        float[] fArr = new float[i2 * i];
        if (token.tableDQT.dqtDef != 1) {
            throw new RuntimeException("ERROR: unquantize : quantization table parameters not defined!");
        }
        float f = token.tableDQT.binCenter;
        int i3 = 0;
        for (int i4 = 0; i4 < 60; i4++) {
            if (token.tableDQT.qBin[i4] != 0.0d) {
                int i5 = (token.qtree[i4].y * i) + token.qtree[i4].x;
                int i6 = 0;
                while (i6 < token.qtree[i4].leny) {
                    for (int i7 = 0; i7 < token.qtree[i4].lenx; i7++) {
                        int i8 = iArr[i3];
                        if (i8 == 0) {
                            fArr[i5] = 0.0f;
                        } else if (i8 > 0) {
                            fArr[i5] = (token.tableDQT.qBin[i4] * (iArr[i3] - f)) + (token.tableDQT.zBin[i4] / 2.0f);
                        } else if (i8 < 0) {
                            fArr[i5] = (token.tableDQT.qBin[i4] * (iArr[i3] + f)) - (token.tableDQT.zBin[i4] / 2.0f);
                        } else {
                            throw new RuntimeException("ERROR : unquantize : invalid quantization pixel value");
                        }
                        i5++;
                        i3++;
                    }
                    i6++;
                    i5 += i - token.qtree[i4].lenx;
                }
            }
        }
        return fArr;
    }

    private void wsqReconstruct(WsqHelper.Token token, float[] fArr, int i, int i2) {
        if (token.tableDTT.lodef != 1) {
            throw new RuntimeException("ERROR: wsq_reconstruct : Lopass filter coefficients not defined");
        }
        if (token.tableDTT.hidef != 1) {
            throw new RuntimeException("ERROR: wsq_reconstruct : Hipass filter coefficients not defined");
        }
        float[] fArr2 = new float[i * i2];
        for (int i3 = 19; i3 >= 0; i3--) {
            int i4 = (token.wtree[i3].y * i) + token.wtree[i3].x;
            joinLets(fArr2, fArr, 0, i4, token.wtree[i3].lenx, token.wtree[i3].leny, 1, i, token.tableDTT.hifilt, token.tableDTT.hisz, token.tableDTT.lofilt, token.tableDTT.losz, token.wtree[i3].invcl);
            float[] fArr3 = fArr2;
            joinLets(fArr, fArr3, i4, 0, token.wtree[i3].leny, token.wtree[i3].lenx, i, 1, token.tableDTT.hifilt, token.tableDTT.hisz, token.tableDTT.lofilt, token.tableDTT.losz, token.wtree[i3].invrw);
            fArr2 = fArr3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void joinLets(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr3, int i7, float[] fArr4, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        double d;
        boolean z2;
        boolean z3;
        int i14;
        int i15;
        boolean z4;
        float f;
        int i16;
        boolean z5;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z6;
        int i27 = i8;
        int i28 = i4 % 2;
        int i29 = i27 % 2;
        int i30 = -i6;
        if (i28 != 0) {
            i10 = (i4 + 1) / 2;
            i11 = i10 - 1;
        } else {
            i10 = i4 / 2;
            i11 = i10;
        }
        if (i29 != 0) {
            int i31 = i27 - 1;
            i15 = i31 / 4;
            int i32 = i7 + 1;
            int i33 = (i32 / 4) - 1;
            i14 = (i31 / 2) % 2;
            int i34 = (i32 / 2) % 2;
            if (i28 != 0) {
                i12 = i33;
                z3 = true;
                z2 = false;
                z4 = true;
                f = 1.0f;
                i16 = 0;
                z = false;
            } else {
                i12 = i33;
                z3 = true;
                z2 = false;
                z4 = false;
                f = 1.0f;
                i16 = 0;
                z = true;
            }
            d = -1.0d;
            z5 = false;
            i13 = i34;
        } else {
            int i35 = (i27 / 4) - 1;
            i12 = (i7 / 4) - 1;
            int i36 = (i27 / 2) % 2;
            i13 = (i7 / 2) % 2;
            z = i28 == 0;
            d = -1.0d;
            if (i35 == -1) {
                z2 = false;
                i35 = 0;
            } else {
                z2 = true;
            }
            if (i12 == -1) {
                i12 = 0;
                z3 = false;
            } else {
                z3 = true;
            }
            int i37 = 0;
            while (i37 < i7) {
                fArr3[i37] = (float) (fArr3[i37] * (-1.0d));
                i37++;
                i35 = i35;
            }
            int i38 = i35;
            i14 = i36;
            i15 = i38;
            z4 = true;
            f = -1.0f;
            i16 = 2;
            z5 = true;
        }
        int i39 = 0;
        int i40 = 0;
        while (i39 < i3) {
            int i41 = i39 * i5;
            int i42 = i + i41;
            fArr[i42] = 0.0f;
            fArr[i42 + i6] = 0.0f;
            if (i9 != 0) {
                i18 = i2 + i41;
                i17 = i18 + (i6 * i11);
            } else {
                i17 = i2 + i41;
                i18 = i17 + (i6 * i10);
            }
            int i43 = i39;
            int i44 = i18;
            int i45 = i28;
            int i46 = i17;
            int i47 = i29;
            int i48 = i46 + ((i10 - 1) * i6);
            int i49 = i30;
            int i50 = i44 + ((i11 - 1) * i6);
            int i51 = i10;
            boolean z7 = z3;
            boolean z8 = z2;
            float f2 = f;
            int i52 = i14;
            int i53 = i13;
            int i54 = i44 + (i12 * i6);
            int i55 = i49;
            int i56 = i55;
            int i57 = 0;
            int i58 = i12;
            int i59 = i46 + (i15 * i6);
            int i60 = i42;
            while (i57 < i11) {
                while (i52 >= 0) {
                    fArr[i42] = fArr2[i59] * fArr4[i52];
                    int i61 = i57;
                    boolean z9 = z;
                    int i62 = i55;
                    boolean z10 = z8;
                    int i63 = i11;
                    int i64 = i59;
                    for (int i65 = i52 + 2; i65 < i27; i65 += 2) {
                        if (i64 == i46) {
                            if (z10) {
                                z10 = false;
                                i62 = 0;
                            } else {
                                i62 = i6;
                            }
                        }
                        if (i64 == i48) {
                            if (z9) {
                                z9 = false;
                                i62 = 0;
                            } else {
                                i62 = i49;
                            }
                        }
                        i64 += i62;
                        fArr[i42] = fArr[i42] + (fArr2[i64] * fArr4[i65]);
                    }
                    i42 += i6;
                    i52--;
                    i11 = i63;
                    i57 = i61;
                }
                int i66 = i57;
                int i67 = i11;
                if (i59 == i46) {
                    if (z8) {
                        i55 = 0;
                        z8 = false;
                    } else {
                        i55 = i6;
                    }
                }
                int i68 = i59 + i55;
                while (i53 >= 0) {
                    int i69 = i54;
                    boolean z11 = z4;
                    i40 = i16;
                    int i70 = i53;
                    int i71 = i56;
                    boolean z12 = z7;
                    float f3 = f2;
                    while (i70 < i7) {
                        if (i69 == i44) {
                            if (z12) {
                                z12 = false;
                                i71 = 0;
                            } else {
                                i71 = i6;
                                f3 = 1.0f;
                            }
                        }
                        if (i69 != i50) {
                            i24 = i68;
                            i25 = i70;
                            i26 = i69;
                            z6 = z3;
                        } else if (z11) {
                            if (!z5 || i45 == 0) {
                                i24 = i68;
                                i25 = i70;
                                i26 = i69;
                                z6 = z3;
                            } else {
                                i24 = i68;
                                int i72 = i40 - 1;
                                i25 = i70;
                                float f4 = i72;
                                i26 = i69;
                                z6 = z3;
                                if (f4 == 0.0d) {
                                    i40 = i72;
                                    f3 = f4;
                                } else {
                                    i40 = i72;
                                    f3 = f4;
                                    z11 = true;
                                    i71 = 0;
                                }
                            }
                            z11 = false;
                            i71 = 0;
                        } else {
                            i24 = i68;
                            i25 = i70;
                            i26 = i69;
                            z6 = z3;
                            i71 = i49;
                            if (z5) {
                                f3 = -1.0f;
                            }
                        }
                        fArr[i60] = fArr[i60] + (fArr2[i26] * fArr3[i25] * f3);
                        i69 = i26 + i71;
                        i70 = i25 + 2;
                        i68 = i24;
                        z3 = z6;
                    }
                    i60 += i6;
                    i53--;
                }
                int i73 = i68;
                boolean z13 = z3;
                if (i54 == i44) {
                    if (z7) {
                        i56 = 0;
                        z7 = false;
                    } else {
                        i56 = i6;
                        f2 = 1.0f;
                    }
                }
                i54 += i56;
                i57 = i66 + 1;
                i11 = i67;
                i59 = i73;
                z3 = z13;
                i52 = 1;
                i53 = 1;
            }
            int i74 = i11;
            boolean z14 = z3;
            if (i45 != 0) {
                i19 = i14 != 0 ? 1 : 0;
            } else if (i14 != 0) {
                i19 = 2;
            }
            int i75 = 1;
            while (i75 >= i19) {
                fArr[i42] = fArr2[i59] * fArr4[i75];
                int i76 = i59;
                boolean z15 = z;
                int i77 = i55;
                boolean z16 = z8;
                for (int i78 = i75 + 2; i78 < i27; i78 += 2) {
                    if (i59 == i46) {
                        if (z16) {
                            z16 = false;
                            i77 = 0;
                        } else {
                            i77 = i6;
                        }
                    }
                    if (i59 == i48) {
                        if (z15) {
                            z15 = false;
                            i77 = 0;
                        } else {
                            i77 = i49;
                        }
                    }
                    i59 += i77;
                    fArr[i42] = fArr[i42] + (fArr2[i59] * fArr4[i78]);
                }
                i42 += i6;
                i75--;
                i59 = i76;
            }
            if (i45 != 0) {
                i21 = i13 != 0 ? 1 : 0;
                i20 = 2;
                if (i7 == 2) {
                    i54 -= i56;
                    i40 = 1;
                }
            } else {
                i20 = 2;
                i21 = i13 != 0 ? 2 : 1;
            }
            int i79 = 1;
            while (i79 >= i21) {
                if (i7 != i20) {
                    i40 = i16;
                }
                int i80 = i79;
                int i81 = i54;
                boolean z17 = z4;
                int i82 = i56;
                boolean z18 = z7;
                float f5 = f2;
                while (i80 < i7) {
                    if (i81 == i44) {
                        if (z18) {
                            z18 = false;
                            i82 = 0;
                        } else {
                            i82 = i6;
                            f5 = 1.0f;
                        }
                    }
                    if (i81 != i50) {
                        i22 = i44;
                        i23 = i21;
                    } else if (z17) {
                        if (!z5 || i45 == 0) {
                            i22 = i44;
                            i23 = i21;
                        } else {
                            int i83 = i40 - 1;
                            i22 = i44;
                            float f6 = i83;
                            i23 = i21;
                            f5 = f6;
                            i40 = i83;
                            if (f6 != 0.0d) {
                                z17 = true;
                            }
                            i82 = 0;
                        }
                        z17 = false;
                        i82 = 0;
                    } else {
                        i22 = i44;
                        i23 = i21;
                        i82 = i49;
                        if (z5) {
                            f5 = -1.0f;
                        }
                    }
                    fArr[i60] = fArr[i60] + (fArr2[i81] * fArr3[i80] * f5);
                    i81 += i82;
                    i80 += 2;
                    i44 = i22;
                    i21 = i23;
                }
                i60 += i6;
                i79--;
                i20 = 2;
            }
            i39 = i43 + 1;
            i27 = i8;
            i28 = i45;
            i29 = i47;
            i12 = i58;
            i30 = i49;
            i10 = i51;
            i11 = i74;
            z3 = z14;
        }
        if (i29 == 0) {
            for (int i84 = 0; i84 < i7; i84++) {
                fArr3[i84] = (float) (fArr3[i84] * d);
            }
        }
    }

    private byte[] convertImage2Byte(float[] fArr, int i, int i2, float f, float f2) {
        byte[] bArr = new byte[i * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                float f3 = (float) ((fArr[i3] * f2) + f + 0.5d);
                double d = f3;
                if (d < 0.0d) {
                    bArr[i3] = 0;
                } else if (d > 255.0d) {
                    bArr[i3] = -1;
                } else {
                    bArr[i3] = (byte) f3;
                }
                i3++;
            }
        }
        return bArr;
    }
}
