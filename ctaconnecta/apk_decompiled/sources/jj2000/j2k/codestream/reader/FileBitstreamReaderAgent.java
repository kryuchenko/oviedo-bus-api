package jj2000.j2k.codestream.reader;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Vector;
import jj2000.j2k.JJ2KExceptionHandler;
import jj2000.j2k.NoNextElementException;
import jj2000.j2k.NotImplementedError;
import jj2000.j2k.codestream.CorruptedCodestreamException;
import jj2000.j2k.codestream.HeaderInfo;
import jj2000.j2k.codestream.Markers;
import jj2000.j2k.codestream.PrecInfo;
import jj2000.j2k.codestream.ProgressionType;
import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.entropy.decoder.DecLyrdCBlk;
import jj2000.j2k.image.Coord;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.quantization.dequantizer.StdDequantizerParams;
import jj2000.j2k.util.ArrayUtil;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;

/* loaded from: classes5.dex */
public class FileBitstreamReaderAgent extends BitstreamReaderAgent implements Markers, ProgressionType, StdEntropyCoderOptions {
    private int[] baknBytes;
    private CBlkInfo[][][][][] cbI;
    private int curTilePart;
    private int[][] firstPackOff;
    private int firstTilePartHeadLen;
    private int headLen;
    private HeaderInfo hi;
    private RandomAccessIO in;
    private boolean isEOCFound;
    private boolean isPsotEqualsZero;
    private boolean isTruncMode;
    private int lQuit;
    private int mainHeadLen;
    private int[] nBytes;
    public PktDecoder pktDec;
    private Vector pktHL;
    private ParameterList pl;
    private boolean printInfo;
    private int remainingTileParts;
    private int[][] tilePartHeadLen;
    private int[][] tilePartLen;
    private int[][] tilePartNum;
    private int[] tileParts;
    private int[] tilePartsRead;
    private double totAllTileLen;
    private int[] totTileHeadLen;
    private int[] totTileLen;
    private int totTilePartsRead;
    private boolean usePOCQuit;

    public int getNumTileParts(int i) {
        int[] iArr;
        int[][] iArr2 = this.firstPackOff;
        if (iArr2 == null || (iArr = iArr2[i]) == null) {
            throw new Error("Tile " + i + " not found in input codestream.");
        }
        return iArr.length;
    }

    public CBlkInfo[][][][][] getCBlkInfo() {
        return this.cbI;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:35|(1:37)|38|(7:(1:46)(3:42|(2:191|44)(0)|45)|178|50|(2:52|(3:192|54|45)(1:55))(2:56|(3:193|58|66)(1:59))|(1:61)|62|(3:194|(1:65)(0)|66)(1:67))|47|176|48|49) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0406, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().printmsg(1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x042e, code lost:
    
        r25.tnbytes = r0;
        r25.trate = ((r25.tnbytes * 8.0f) / r26.getMaxCompImgWidth()) / r26.getMaxCompImgHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0447, code lost:
    
        allocateRate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0450, code lost:
    
        r25.targetRes = r28.dls.getMin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0459, code lost:
    
        r25.targetRes = r29.getIntParameter("res");
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0461, code lost:
    
        if (r25.targetRes < 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x046d, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().printmsg(2, "Specified resolution level (" + r25.targetRes + ") is larger than the maximum value. Setting it to " + r0 + " (maximum value)");
        r25.targetRes = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0497, code lost:
    
        r25.baknBytes[r14] = r25.nBytes[r14];
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x04b9, code lost:
    
        throw new java.lang.IllegalArgumentException("Specified negative resolution level index: " + r25.targetRes);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x04cf, code lost:
    
        throw new java.lang.IllegalArgumentException("Invalid resolution level index ('-res' option) " + r29.getParameter("res"));
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0497 A[LOOP:2: B:137:0x0493->B:139:0x0497, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0459 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileBitstreamReaderAgent(HeaderDecoder headerDecoder, RandomAccessIO randomAccessIO, DecoderSpecs decoderSpecs, ParameterList parameterList, boolean z, HeaderInfo headerInfo) throws IOException {
        boolean z2;
        int i;
        int i2;
        boolean z3;
        int i3;
        int i4;
        super(headerDecoder, decoderSpecs);
        this.isPsotEqualsZero = true;
        this.headLen = 0;
        this.totTilePartsRead = 0;
        this.isEOCFound = false;
        this.usePOCQuit = false;
        this.pl = parameterList;
        this.printInfo = z;
        this.hi = headerInfo;
        this.usePOCQuit = parameterList.getBooleanParameter("poc_quit");
        parameterList.getBooleanParameter("parsing");
        try {
            this.trate = parameterList.getFloatParameter("rate");
            if (this.trate == -1.0f) {
                this.trate = Float.MAX_VALUE;
            }
            try {
                this.tnbytes = parameterList.getIntParameter("nbytes");
                if (this.tnbytes != parameterList.getDefaultParameterList().getFloatParameter("nbytes")) {
                    this.trate = ((this.tnbytes * 8.0f) / headerDecoder.getMaxCompImgWidth()) / headerDecoder.getMaxCompImgHeight();
                } else {
                    this.tnbytes = ((int) ((this.trate * headerDecoder.getMaxCompImgWidth()) * headerDecoder.getMaxCompImgHeight())) / 8;
                }
                this.isTruncMode = !parameterList.getBooleanParameter("parsing");
                try {
                    int intParameter = parameterList.getIntParameter("ncb_quit");
                    if (intParameter != -1 && !this.isTruncMode) {
                        throw new Error("Cannot use -parsing and -ncb_quit condition at the same time.");
                    }
                    try {
                        this.lQuit = parameterList.getIntParameter("l_quit");
                        this.in = randomAccessIO;
                        this.pktDec = new PktDecoder(decoderSpecs, headerDecoder, randomAccessIO, this, this.isTruncMode, intParameter);
                        this.tileParts = new int[this.nt];
                        this.totTileLen = new int[this.nt];
                        this.tilePartLen = new int[this.nt][];
                        this.tilePartNum = new int[this.nt][];
                        this.firstPackOff = new int[this.nt][];
                        this.tilePartsRead = new int[this.nt];
                        this.totTileHeadLen = new int[this.nt];
                        this.tilePartHeadLen = new int[this.nt][];
                        this.nBytes = new int[this.nt];
                        this.baknBytes = new int[this.nt];
                        headerDecoder.nTileParts = new int[this.nt];
                        this.isTruncMode = this.isTruncMode;
                        int i5 = headerDecoder.mainHeadOff;
                        int pos = this.in.getPos() - i5;
                        this.mainHeadLen = pos;
                        this.headLen = pos;
                        if (intParameter == -1) {
                            this.anbytes = pos;
                        } else {
                            this.anbytes = 0;
                        }
                        String str = "Codestream elements information in bytes (offset, total length, header length):\n\nMain header length    : " + i5 + ", " + this.mainHeadLen + ", " + this.mainHeadLen + "\n";
                        if (this.anbytes > this.tnbytes) {
                            throw new Error("Requested bitrate is too small.");
                        }
                        this.totAllTileLen = 0.0d;
                        this.remainingTileParts = this.nt;
                        int i6 = this.nt;
                        int tilePartHeader = 0;
                        int i7 = 0;
                        int i8 = 0;
                        while (this.remainingTileParts != 0) {
                            try {
                                try {
                                    int pos2 = this.in.getPos();
                                    try {
                                        tilePartHeader = readTilePartHeader();
                                        int i9 = i5;
                                        if (this.isEOCFound) {
                                            break;
                                        }
                                        i7 = this.tilePartsRead[tilePartHeader];
                                        if (this.isPsotEqualsZero) {
                                            this.tilePartLen[tilePartHeader][i7] = (this.in.length() - 2) - pos2;
                                        }
                                        int pos3 = this.in.getPos();
                                        try {
                                            if (this.isTruncMode && intParameter == -1) {
                                                i4 = intParameter;
                                                if (pos3 - i9 > this.tnbytes) {
                                                    this.firstPackOff[tilePartHeader][i7] = this.in.length();
                                                }
                                                i = 0;
                                                z2 = true;
                                                break;
                                            }
                                            i4 = intParameter;
                                            this.totAllTileLen += r0[i7];
                                            if (this.isTruncMode) {
                                                if (this.anbytes + this.tilePartLen[tilePartHeader][i7] > this.tnbytes) {
                                                    this.anbytes += this.tilePartHeadLen[tilePartHeader][i7];
                                                    this.headLen += this.tilePartHeadLen[tilePartHeader][i7];
                                                    int[] iArr = this.nBytes;
                                                    iArr[tilePartHeader] = iArr[tilePartHeader] + (this.tnbytes - this.anbytes);
                                                    str = str;
                                                    i = 0;
                                                    z2 = true;
                                                    break;
                                                }
                                                this.anbytes += this.tilePartHeadLen[tilePartHeader][i7];
                                                int i10 = this.headLen;
                                                int i11 = this.tilePartHeadLen[tilePartHeader][i7];
                                                this.headLen = i10 + i11;
                                                int[] iArr2 = this.nBytes;
                                                iArr2[tilePartHeader] = iArr2[tilePartHeader] + (this.tilePartLen[tilePartHeader][i7] - i11);
                                            } else if (this.anbytes + this.tilePartHeadLen[tilePartHeader][i7] > this.tnbytes) {
                                                str = str;
                                                break;
                                            } else {
                                                this.anbytes += this.tilePartHeadLen[tilePartHeader][i7];
                                                this.headLen += this.tilePartHeadLen[tilePartHeader][i7];
                                            }
                                            if (i8 == 0) {
                                                this.firstTilePartHeadLen = this.tilePartHeadLen[tilePartHeader][i7];
                                            }
                                            int[] iArr3 = this.tilePartsRead;
                                            iArr3[tilePartHeader] = iArr3[tilePartHeader] + 1;
                                            this.in.seek(pos2 + this.tilePartLen[tilePartHeader][i7]);
                                            int i12 = this.remainingTileParts - 1;
                                            this.remainingTileParts = i12;
                                            i8++;
                                            if (this.isPsotEqualsZero) {
                                                if (i12 != 0) {
                                                    FacilityManager.getMsgLogger().printmsg(2, "Some tile-parts have not been found. The codestream may be corrupted.");
                                                }
                                                str = str;
                                                break;
                                            } else {
                                                str = str;
                                                i5 = i9;
                                                intParameter = i4;
                                            }
                                        } catch (EOFException unused) {
                                            str = str;
                                            if (this.printInfo) {
                                            }
                                            FacilityManager.getMsgLogger().printmsg(2, "Codestream truncated in tile " + tilePartHeader);
                                            int length = this.in.length();
                                            if (length < this.tnbytes) {
                                            }
                                            if (!this.isTruncMode) {
                                            }
                                            if (parameterList.getParameter("res") != null) {
                                            }
                                            int min = decoderSpecs.dls.getMin();
                                            if (this.targetRes > min) {
                                            }
                                            int i13 = 0;
                                            while (i13 < this.nt) {
                                            }
                                            return;
                                        }
                                        this.firstPackOff[tilePartHeader][i7] = pos3;
                                        this.tilePartHeadLen[tilePartHeader][i7] = pos3 - pos2;
                                        str = str + "Tile-part " + i7 + " of tile " + tilePartHeader + " : " + pos2 + ", " + this.tilePartLen[tilePartHeader][i7] + ", " + this.tilePartHeadLen[tilePartHeader][i7] + "\n";
                                        int[] iArr4 = this.totTileLen;
                                        iArr4[tilePartHeader] = iArr4[tilePartHeader] + this.tilePartLen[tilePartHeader][i7];
                                        int[] iArr5 = this.totTileHeadLen;
                                        iArr5[tilePartHeader] = iArr5[tilePartHeader] + this.tilePartHeadLen[tilePartHeader][i7];
                                    } catch (EOFException e) {
                                        this.firstPackOff[tilePartHeader][i7] = this.in.length();
                                        throw e;
                                    }
                                } catch (EOFException unused2) {
                                }
                            } catch (EOFException unused3) {
                            }
                        }
                        i = 0;
                        z2 = false;
                        this.remainingTileParts = i;
                        if (parameterList.getParameter("res") == null) {
                            this.targetRes = decoderSpecs.dls.getMin();
                        } else {
                            try {
                                this.targetRes = parameterList.getIntParameter("res");
                                if (this.targetRes < 0) {
                                    throw new IllegalArgumentException("Specified negative resolution level index: " + this.targetRes);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new IllegalArgumentException("Invalid resolution level index ('-res' option) " + parameterList.getParameter("res"));
                            }
                        }
                        int min2 = decoderSpecs.dls.getMin();
                        if (this.targetRes > min2) {
                            FacilityManager.getMsgLogger().printmsg(2, "Specified resolution level (" + this.targetRes + ") is larger than the maximum possible. Setting it to " + min2 + " (maximum possible)");
                            this.targetRes = min2;
                        }
                        if (this.printInfo) {
                            FacilityManager.getMsgLogger().printmsg(1, str);
                        }
                        if (!this.isEOCFound && !(z3 = this.isPsotEqualsZero) && !z2 && !z3) {
                            try {
                                if (this.in.readShort() != -39) {
                                    i3 = 2;
                                    try {
                                        FacilityManager.getMsgLogger().printmsg(2, "EOC marker not found. Codestream is corrupted.");
                                    } catch (EOFException unused5) {
                                        FacilityManager.getMsgLogger().printmsg(i3, "EOC marker is missing");
                                        if (this.isTruncMode) {
                                        }
                                        while (i2 < this.nt) {
                                        }
                                    }
                                }
                            } catch (EOFException unused6) {
                                i3 = 2;
                            }
                        }
                        if (this.isTruncMode) {
                            allocateRate();
                        } else if (this.in.getPos() >= this.tnbytes) {
                            this.anbytes += 2;
                        }
                        for (i2 = 0; i2 < this.nt; i2++) {
                            this.baknBytes[i2] = this.nBytes[i2];
                            if (this.printInfo) {
                                FacilityManager.getMsgLogger().println("" + headerInfo.toStringTileHeader(i2, this.tilePartLen[i2].length), 2, 2);
                            }
                        }
                    } catch (NumberFormatException unused7) {
                        throw new Error("Invalid value in 'l_quit' option: " + parameterList.getParameter("l_quit"));
                    } catch (IllegalArgumentException unused8) {
                        throw new Error("'l_quit' option is missing");
                    }
                } catch (NumberFormatException unused9) {
                    throw new Error("Invalid value in 'ncb_quit' option: " + parameterList.getParameter("ncb_quit"));
                } catch (IllegalArgumentException unused10) {
                    throw new Error("'ncb_quit' option is missing");
                }
            } catch (NumberFormatException unused11) {
                throw new Error("Invalid value in 'nbytes' option: " + parameterList.getParameter("nbytes"));
            } catch (IllegalArgumentException unused12) {
                throw new Error("'nbytes' option is missing");
            }
        } catch (NumberFormatException unused13) {
            throw new Error("Invalid value in 'rate' option: " + parameterList.getParameter("rate"));
        } catch (IllegalArgumentException unused14) {
            throw new Error("'rate' option is missing");
        }
    }

    private void allocateRate() {
        int i = this.tnbytes;
        this.anbytes += 2;
        if (this.anbytes > i) {
            throw new Error("Requested bitrate is too small for parsing");
        }
        int i2 = i - this.anbytes;
        int i3 = i2;
        for (int i4 = this.nt - 1; i4 > 0; i4--) {
            int[] iArr = this.nBytes;
            int i5 = (int) (i2 * (this.totTileLen[i4] / this.totAllTileLen));
            iArr[i4] = i5;
            i3 -= i5;
        }
        this.nBytes[0] = i3;
    }

    private int readTilePartHeader() throws IOException {
        int numFoundMarkSeg;
        int i;
        int i2;
        HeaderInfo.SOT newSOT = this.hi.getNewSOT();
        short s = this.in.readShort();
        if (s != -112) {
            if (s == -39) {
                this.isEOCFound = true;
                return -1;
            }
            throw new CorruptedCodestreamException("SOT tag not found in tile-part start");
        }
        int i3 = 0;
        this.isEOCFound = false;
        int unsignedShort = this.in.readUnsignedShort();
        newSOT.lsot = unsignedShort;
        if (unsignedShort != 10) {
            throw new CorruptedCodestreamException("Wrong length for SOT marker segment: " + unsignedShort);
        }
        int unsignedShort2 = this.in.readUnsignedShort();
        newSOT.isot = unsignedShort2;
        if (unsignedShort2 > 65534) {
            throw new CorruptedCodestreamException("Tile index too high in tile-part.");
        }
        int i4 = this.in.readInt();
        newSOT.psot = i4;
        this.isPsotEqualsZero = i4 == 0;
        if (i4 < 0) {
            throw new NotImplementedError("Tile length larger than maximum supported");
        }
        int i5 = this.in.read();
        newSOT.tpsot = i5;
        if (i5 != this.tilePartsRead[unsignedShort2] || i5 < 0 || i5 > 254) {
            throw new CorruptedCodestreamException("Out of order tile-part");
        }
        int i6 = this.in.read();
        newSOT.tnsot = i6;
        this.hi.sot.put("t" + unsignedShort2 + "_tp" + i5, newSOT);
        if (i6 == 0) {
            int[] iArr = this.tileParts;
            int i7 = iArr[unsignedShort2];
            if (i7 == 0 || i7 == this.tilePartLen.length) {
                this.remainingTileParts++;
                i = 2;
            } else {
                i = 1;
            }
            i6 = i7 + i;
            iArr[unsignedShort2] = i6;
            FacilityManager.getMsgLogger().printmsg(2, "Header of tile-part " + i5 + " of tile " + unsignedShort2 + ", does not indicate the total number of tile-parts. Assuming that there are " + i6 + " tile-parts for this tile.");
            int[][] iArr2 = this.tilePartLen;
            int[] iArr3 = iArr2[unsignedShort2];
            iArr2[unsignedShort2] = new int[i6];
            int i8 = 0;
            while (true) {
                i2 = i6 - i;
                if (i8 >= i2) {
                    break;
                }
                this.tilePartLen[unsignedShort2][i8] = iArr3[i8];
                i8++;
            }
            int[][] iArr4 = this.tilePartNum;
            int[] iArr5 = iArr4[unsignedShort2];
            iArr4[unsignedShort2] = new int[i6];
            for (int i9 = 0; i9 < i2; i9++) {
                this.tilePartNum[unsignedShort2][i9] = iArr5[i9];
            }
            int[][] iArr6 = this.firstPackOff;
            int[] iArr7 = iArr6[unsignedShort2];
            iArr6[unsignedShort2] = new int[i6];
            for (int i10 = 0; i10 < i2; i10++) {
                this.firstPackOff[unsignedShort2][i10] = iArr7[i10];
            }
            int[][] iArr8 = this.tilePartHeadLen;
            int[] iArr9 = iArr8[unsignedShort2];
            iArr8[unsignedShort2] = new int[i6];
            while (i3 < i2) {
                this.tilePartHeadLen[unsignedShort2][i3] = iArr9[i3];
                i3++;
            }
        } else {
            int[] iArr10 = this.tileParts;
            int i11 = iArr10[unsignedShort2];
            if (i11 == 0) {
                this.remainingTileParts += i6 - 1;
                iArr10[unsignedShort2] = i6;
                this.tilePartLen[unsignedShort2] = new int[i6];
                this.tilePartNum[unsignedShort2] = new int[i6];
                this.firstPackOff[unsignedShort2] = new int[i6];
                this.tilePartHeadLen[unsignedShort2] = new int[i6];
            } else {
                if (i11 > i6) {
                    throw new CorruptedCodestreamException("Invalid number of tile-parts in tile " + unsignedShort2 + ": " + i6);
                }
                this.remainingTileParts += i6 - i11;
                if (i11 != i6) {
                    int[][] iArr11 = this.tilePartLen;
                    int[] iArr12 = iArr11[unsignedShort2];
                    iArr11[unsignedShort2] = new int[i6];
                    for (int i12 = 0; i12 < this.tileParts[unsignedShort2] - 1; i12++) {
                        this.tilePartLen[unsignedShort2][i12] = iArr12[i12];
                    }
                    int[][] iArr13 = this.tilePartNum;
                    int[] iArr14 = iArr13[unsignedShort2];
                    iArr13[unsignedShort2] = new int[i6];
                    for (int i13 = 0; i13 < this.tileParts[unsignedShort2] - 1; i13++) {
                        this.tilePartNum[unsignedShort2][i13] = iArr14[i13];
                    }
                    int[][] iArr15 = this.firstPackOff;
                    int[] iArr16 = iArr15[unsignedShort2];
                    iArr15[unsignedShort2] = new int[i6];
                    for (int i14 = 0; i14 < this.tileParts[unsignedShort2] - 1; i14++) {
                        this.firstPackOff[unsignedShort2][i14] = iArr16[i14];
                    }
                    int[][] iArr17 = this.tilePartHeadLen;
                    int[] iArr18 = iArr17[unsignedShort2];
                    iArr17[unsignedShort2] = new int[i6];
                    while (i3 < this.tileParts[unsignedShort2] - 1) {
                        this.tilePartHeadLen[unsignedShort2][i3] = iArr18[i3];
                        i3++;
                    }
                }
            }
        }
        this.hd.resetHeaderMarkers();
        this.hd.nTileParts[unsignedShort2] = i6;
        do {
            this.hd.extractTilePartMarkSeg(this.in.readShort(), this.in, unsignedShort2, i5);
            numFoundMarkSeg = this.hd.getNumFoundMarkSeg();
            HeaderDecoder headerDecoder = this.hd;
        } while ((numFoundMarkSeg & 8192) == 0);
        this.hd.readFoundTilePartMarkSeg(unsignedShort2, i5);
        this.tilePartLen[unsignedShort2][i5] = i4;
        int[] iArr19 = this.tilePartNum[unsignedShort2];
        int i15 = this.totTilePartsRead;
        iArr19[i5] = i15;
        this.totTilePartsRead = i15 + 1;
        this.hd.setTileOfTileParts(unsignedShort2);
        return unsignedShort2;
    }

    private boolean readLyResCompPos(int[][] iArr, int i, int i2, int i3, int i4, int i5) throws IOException {
        int i6;
        int i7;
        int i8;
        int i9 = i3;
        int i10 = 10000;
        for (int i11 = i4; i11 < i5; i11++) {
            if (i11 < this.mdl.length) {
                for (int i12 = i2; i12 < i9; i12++) {
                    int[] iArr2 = iArr[i11];
                    if (iArr2 != null && i12 < iArr2.length && (i8 = iArr2[i12]) < i10) {
                        i10 = i8;
                    }
                }
            }
        }
        int tileIdx = getTileIdx();
        int[] iArr3 = this.firstPackOff[tileIdx];
        int i13 = this.curTilePart;
        int i14 = ((iArr3[i13] + this.tilePartLen[tileIdx][i13]) - 1) - this.tilePartHeadLen[tileIdx][i13];
        int iIntValue = ((Integer) this.decSpec.nls.getTileDef(tileIdx)).intValue();
        String str = "Tile " + getTileIdx() + " (tile-part:" + this.curTilePart + "): offset, length, header length\n";
        boolean zBooleanValue = ((Boolean) this.decSpec.pphs.getTileDef(tileIdx)).booleanValue();
        int i15 = i10;
        while (i15 < i) {
            int i16 = i2;
            while (i16 < i9) {
                for (int i17 = i4; i17 < i5; i17++) {
                    if (i17 < this.mdl.length && i16 < iArr[i17].length && i16 <= this.mdl[i17] && i15 >= iArr[i17][i16] && i15 < iIntValue) {
                        int numPrecinct = this.pktDec.getNumPrecinct(i17, i16);
                        int i18 = 0;
                        while (i18 < numPrecinct) {
                            int pos = this.in.getPos();
                            if (zBooleanValue) {
                                i6 = numPrecinct;
                                i7 = i18;
                                this.pktDec.readPktHead(i15, i16, i17, i7, this.cbI[i17][i16], this.nBytes);
                            } else {
                                i6 = numPrecinct;
                                i7 = i18;
                            }
                            if (pos > i14) {
                                int i19 = this.curTilePart;
                                int[] iArr4 = this.firstPackOff[tileIdx];
                                if (i19 < iArr4.length - 1) {
                                    int i20 = i19 + 1;
                                    this.curTilePart = i20;
                                    this.in.seek(iArr4[i20]);
                                    int pos2 = this.in.getPos();
                                    int[] iArr5 = this.tilePartLen[tileIdx];
                                    i14 = ((pos2 + iArr5[r10]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
                                }
                            }
                            boolean sOPMarker = this.pktDec.readSOPMarker(this.nBytes, i7, i17, i16);
                            if (sOPMarker) {
                                if (!this.printInfo) {
                                    return true;
                                }
                                FacilityManager.getMsgLogger().printmsg(1, str);
                                return true;
                            }
                            if (!zBooleanValue) {
                                sOPMarker = this.pktDec.readPktHead(i15, i16, i17, i7, this.cbI[i17][i16], this.nBytes);
                            }
                            if (sOPMarker) {
                                if (!this.printInfo) {
                                    return true;
                                }
                                FacilityManager.getMsgLogger().printmsg(1, str);
                                return true;
                            }
                            int pos3 = this.in.getPos() - pos;
                            this.pktHL.addElement(new Integer(pos3));
                            int i21 = i6;
                            boolean pktBody = this.pktDec.readPktBody(i15, i16, i17, i7, this.cbI[i17][i16], this.nBytes);
                            str = str + " Pkt l=" + i15 + ",r=" + i16 + ",c=" + i17 + ",p=" + i7 + ": " + pos + ", " + (this.in.getPos() - pos) + ", " + pos3 + "\n";
                            if (pktBody) {
                                if (!this.printInfo) {
                                    return true;
                                }
                                FacilityManager.getMsgLogger().printmsg(1, str);
                                return true;
                            }
                            i18 = i7 + 1;
                            numPrecinct = i21;
                        }
                    }
                }
                i16++;
                i9 = i3;
            }
            i15++;
            i9 = i3;
        }
        if (this.printInfo) {
            FacilityManager.getMsgLogger().printmsg(1, str);
        }
        return false;
    }

    private boolean readResLyCompPos(int[][] iArr, int i, int i2, int i3, int i4, int i5) throws IOException {
        int i6;
        int i7;
        int i8;
        int[] iArr2;
        int i9;
        int i10 = i3;
        int i11 = i5;
        int tileIdx = getTileIdx();
        int[] iArr3 = this.firstPackOff[tileIdx];
        int i12 = this.curTilePart;
        int i13 = ((iArr3[i12] + this.tilePartLen[tileIdx][i12]) - 1) - this.tilePartHeadLen[tileIdx][i12];
        int i14 = 10000;
        for (int i15 = i4; i15 < i11; i15++) {
            if (i15 < this.mdl.length) {
                for (int i16 = i2; i16 < i10; i16++) {
                    if (i16 <= this.mdl[i15] && (iArr2 = iArr[i15]) != null && i16 < iArr2.length && (i9 = iArr2[i16]) < i14) {
                        i14 = i9;
                    }
                }
            }
        }
        String str = "Tile " + getTileIdx() + " (tile-part:" + this.curTilePart + "): offset, length, header length\n";
        int iIntValue = ((Integer) this.decSpec.nls.getTileDef(tileIdx)).intValue();
        boolean zBooleanValue = ((Boolean) this.decSpec.pphs.getTileDef(tileIdx)).booleanValue();
        int i17 = i2;
        while (i17 < i10) {
            int i18 = i14;
            while (i18 < i) {
                int i19 = i4;
                while (i19 < i11) {
                    if (i19 < this.mdl.length && i17 <= this.mdl[i19]) {
                        int[] iArr4 = iArr[i19];
                        if (i17 < iArr4.length && i18 >= iArr4[i17] && i18 < iIntValue) {
                            int numPrecinct = this.pktDec.getNumPrecinct(i19, i17);
                            int i20 = 0;
                            while (i20 < numPrecinct) {
                                int pos = this.in.getPos();
                                if (zBooleanValue) {
                                    i6 = numPrecinct;
                                    i7 = i20;
                                    this.pktDec.readPktHead(i18, i17, i19, i7, this.cbI[i19][i17], this.nBytes);
                                } else {
                                    i6 = numPrecinct;
                                    i7 = i20;
                                }
                                if (pos > i13) {
                                    int i21 = this.curTilePart;
                                    int[] iArr5 = this.firstPackOff[tileIdx];
                                    i8 = i6;
                                    if (i21 < iArr5.length - 1) {
                                        int i22 = i21 + 1;
                                        this.curTilePart = i22;
                                        this.in.seek(iArr5[i22]);
                                        int pos2 = this.in.getPos();
                                        int[] iArr6 = this.tilePartLen[tileIdx];
                                        i13 = ((pos2 + iArr6[r10]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
                                    }
                                } else {
                                    i8 = i6;
                                }
                                boolean sOPMarker = this.pktDec.readSOPMarker(this.nBytes, i7, i19, i17);
                                if (sOPMarker) {
                                    if (!this.printInfo) {
                                        return true;
                                    }
                                    FacilityManager.getMsgLogger().printmsg(1, str);
                                    return true;
                                }
                                if (!zBooleanValue) {
                                    sOPMarker = this.pktDec.readPktHead(i18, i17, i19, i7, this.cbI[i19][i17], this.nBytes);
                                }
                                if (sOPMarker) {
                                    if (!this.printInfo) {
                                        return true;
                                    }
                                    FacilityManager.getMsgLogger().printmsg(1, str);
                                    return true;
                                }
                                int pos3 = this.in.getPos() - pos;
                                this.pktHL.addElement(new Integer(pos3));
                                boolean pktBody = this.pktDec.readPktBody(i18, i17, i19, i7, this.cbI[i19][i17], this.nBytes);
                                str = str + " Pkt l=" + i18 + ",r=" + i17 + ",c=" + i19 + ",p=" + i7 + ": " + pos + ", " + (this.in.getPos() - pos) + ", " + pos3 + "\n";
                                if (pktBody) {
                                    if (!this.printInfo) {
                                        return true;
                                    }
                                    FacilityManager.getMsgLogger().printmsg(1, str);
                                    return true;
                                }
                                i20 = i7 + 1;
                                numPrecinct = i8;
                            }
                        }
                    }
                    i19++;
                    i11 = i5;
                }
                i18++;
                i11 = i5;
            }
            i17++;
            i10 = i3;
            i11 = i5;
        }
        if (this.printInfo) {
            FacilityManager.getMsgLogger().printmsg(1, str);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x026a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readResPosCompLy(int[][] iArr, int i, int i2, int i3, int i4, int i5) throws IOException {
        int i6;
        int i7;
        int i8;
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
        int i20;
        boolean sOPMarker;
        int i21;
        int i22;
        int[][] iArr2;
        int iGcd;
        int iGcd2;
        int i23;
        int i24 = i3;
        int i25 = i5;
        Coord numTiles = getNumTiles(null);
        Coord tile = getTile(null);
        int imgULX = this.hd.getImgULX();
        int imgULY = this.hd.getImgULY();
        int imgWidth = this.hd.getImgWidth() + imgULX;
        int imgHeight = this.hd.getImgHeight() + imgULY;
        int tilePartULX = getTilePartULX();
        int tilePartULY = getTilePartULY();
        int nomTileWidth = getNomTileWidth();
        int nomTileHeight = getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        if (tile.y != 0) {
            imgULY = (tile.y * nomTileHeight) + tilePartULY;
        }
        if (tile.x != numTiles.x - 1) {
            imgWidth = ((tile.x + 1) * nomTileWidth) + tilePartULX;
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int tileIdx = getTileIdx();
        int[][] iArr3 = new int[i25][];
        int i26 = 100000;
        int i27 = imgULX;
        int i28 = imgULY;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        for (int i32 = i4; i32 < i25; i32++) {
            int i33 = i2;
            while (i33 < i24) {
                if (i32 < this.mdl.length && i33 <= this.mdl[i32]) {
                    iArr3[i32] = new int[this.mdl[i32] + 1];
                    int[] iArr4 = iArr[i32];
                    iArr2 = iArr3;
                    if (iArr4 != null && i33 < iArr4.length && (i23 = iArr4[i33]) < i26) {
                        i26 = i23;
                    }
                    int numPrecinct = this.pktDec.getNumPrecinct(i32, i33) - 1;
                    int i34 = i26;
                    int i35 = i27;
                    int i36 = i31;
                    while (true) {
                        int i37 = i29;
                        if (numPrecinct < 0) {
                            break;
                        }
                        PrecInfo precInfo = this.pktDec.getPrecInfo(i32, i33, numPrecinct);
                        int i38 = numPrecinct;
                        if (precInfo.rgulx != imgULX) {
                            if (precInfo.rgulx < imgWidth) {
                                imgWidth = precInfo.rgulx;
                            }
                            if (precInfo.rgulx > i35) {
                                i35 = precInfo.rgulx;
                            }
                        }
                        if (precInfo.rguly != imgULY) {
                            if (precInfo.rguly < imgHeight) {
                                imgHeight = precInfo.rguly;
                            }
                            if (precInfo.rguly > i28) {
                                i28 = precInfo.rguly;
                            }
                        }
                        if (i37 == 0) {
                            iGcd = precInfo.rgw;
                            iGcd2 = precInfo.rgh;
                        } else {
                            iGcd = MathUtil.gcd(i36, precInfo.rgw);
                            iGcd2 = MathUtil.gcd(i30, precInfo.rgh);
                        }
                        i30 = iGcd2;
                        i36 = iGcd;
                        i29 = i37 + 1;
                        numPrecinct = i38 - 1;
                    }
                    i31 = i36;
                    i26 = i34;
                    i27 = i35;
                } else {
                    iArr2 = iArr3;
                }
                i33++;
                iArr3 = iArr2;
            }
        }
        int[][] iArr5 = iArr3;
        if (i29 == 0) {
            throw new Error("Image cannot have no precinct");
        }
        int i39 = ((i28 - imgHeight) / i30) + 1;
        int i40 = ((i27 - imgWidth) / i31) + 1;
        int[] iArr6 = this.firstPackOff[tileIdx];
        int i41 = ((iArr6[r11] + this.tilePartLen[tileIdx][r11]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
        int iIntValue = ((Integer) this.decSpec.nls.getTileDef(tileIdx)).intValue();
        String str = "Tile " + getTileIdx() + " (tile-part:" + this.curTilePart + "): offset, length, header length\n";
        boolean zBooleanValue = ((Boolean) this.decSpec.pphs.getTileDef(tileIdx)).booleanValue();
        String str2 = str;
        int i42 = i41;
        int i43 = i2;
        while (i43 < i24) {
            String str3 = str2;
            int i44 = imgULX;
            int i45 = imgULY;
            int i46 = 0;
            while (i46 <= i39) {
                int i47 = imgULX;
                int i48 = imgULY;
                int i49 = i44;
                int i50 = 0;
                int i51 = i42;
                String str4 = str3;
                while (i50 <= i40) {
                    int i52 = imgWidth;
                    int i53 = i4;
                    while (i53 < i25) {
                        if (i53 < this.mdl.length && i43 <= this.mdl[i53]) {
                            i6 = imgHeight;
                            if (iArr5[i53][i43] >= this.pktDec.getNumPrecinct(i53, i43)) {
                                i7 = i45;
                                i8 = i49;
                                i9 = i53;
                                i10 = i43;
                                i11 = i26;
                            } else {
                                PrecInfo precInfo2 = this.pktDec.getPrecInfo(i53, i43, iArr5[i53][i43]);
                                if (precInfo2.rgulx == i49 && precInfo2.rguly == i45) {
                                    i7 = i45;
                                    int i54 = i26;
                                    int i55 = i51;
                                    while (i54 < i) {
                                        int i56 = i49;
                                        int[] iArr7 = iArr[i53];
                                        int i57 = i53;
                                        if (i43 < iArr7.length && i54 >= iArr7[i43] && i54 < iIntValue) {
                                            int pos = this.in.getPos();
                                            if (zBooleanValue) {
                                                i17 = i54;
                                                int i58 = i43;
                                                this.pktDec.readPktHead(i17, i58, i57, iArr5[i57][i43], this.cbI[i57][i43], this.nBytes);
                                                i18 = i58;
                                            } else {
                                                i17 = i54;
                                                i18 = i43;
                                            }
                                            if (pos > i55) {
                                                int i59 = this.curTilePart;
                                                i19 = i55;
                                                int[] iArr8 = this.firstPackOff[tileIdx];
                                                if (i59 < iArr8.length - 1) {
                                                    int i60 = i59 + 1;
                                                    this.curTilePart = i60;
                                                    this.in.seek(iArr8[i60]);
                                                    int pos2 = this.in.getPos();
                                                    int[] iArr9 = this.tilePartLen[tileIdx];
                                                    i20 = ((pos2 + iArr9[r9]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
                                                }
                                                i16 = i20;
                                                sOPMarker = this.pktDec.readSOPMarker(this.nBytes, iArr5[i57][i18], i57, i18);
                                                if (!sOPMarker) {
                                                    if (!this.printInfo) {
                                                        return true;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str4);
                                                    return true;
                                                }
                                                if (zBooleanValue) {
                                                    i21 = i18;
                                                    i22 = i57;
                                                } else {
                                                    i21 = i18;
                                                    i22 = i57;
                                                    sOPMarker = this.pktDec.readPktHead(i17, i21, i22, iArr5[i57][i18], this.cbI[i57][i18], this.nBytes);
                                                }
                                                if (sOPMarker) {
                                                    if (!this.printInfo) {
                                                        return true;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str4);
                                                    return true;
                                                }
                                                int pos3 = this.in.getPos() - pos;
                                                this.pktHL.addElement(new Integer(pos3));
                                                boolean pktBody = this.pktDec.readPktBody(i17, i21, i22, iArr5[i22][i21], this.cbI[i22][i21], this.nBytes);
                                                i15 = i17;
                                                i12 = i21;
                                                i14 = i22;
                                                i13 = i26;
                                                str4 = str4 + " Pkt l=" + i15 + ",r=" + i12 + ",c=" + i14 + ",p=" + iArr5[i14][i12] + ": " + pos + ", " + (this.in.getPos() - pos) + ", " + pos3 + "\n";
                                                if (pktBody) {
                                                    if (!this.printInfo) {
                                                        return true;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str4);
                                                    return true;
                                                }
                                            } else {
                                                i19 = i55;
                                            }
                                            i20 = i19;
                                            i16 = i20;
                                            sOPMarker = this.pktDec.readSOPMarker(this.nBytes, iArr5[i57][i18], i57, i18);
                                            if (!sOPMarker) {
                                            }
                                        } else {
                                            i12 = i43;
                                            i13 = i26;
                                            i14 = i57;
                                            i15 = i54;
                                            i16 = i55;
                                        }
                                        i54 = i15 + 1;
                                        i49 = i56;
                                        i43 = i12;
                                        i53 = i14;
                                        i26 = i13;
                                        i55 = i16;
                                    }
                                    i51 = i55;
                                    i8 = i49;
                                    i9 = i53;
                                    i10 = i43;
                                    i11 = i26;
                                    int[] iArr10 = iArr5[i9];
                                    iArr10[i10] = iArr10[i10] + 1;
                                }
                            }
                        } else {
                            i7 = i45;
                            i8 = i49;
                            i6 = imgHeight;
                            i11 = i26;
                            i9 = i53;
                            i10 = i43;
                        }
                        int i61 = i9 + 1;
                        i49 = i8;
                        i43 = i10;
                        i26 = i11;
                        imgHeight = i6;
                        i45 = i7;
                        i53 = i61;
                        i25 = i5;
                    }
                    int i62 = i45;
                    int i63 = imgHeight;
                    int i64 = i43;
                    int i65 = i26;
                    i49 = i50 != i40 ? i52 + (i50 * i31) : i47;
                    i50++;
                    i25 = i5;
                    i43 = i64;
                    i26 = i65;
                    imgWidth = i52;
                    imgHeight = i63;
                    i45 = i62;
                }
                int i66 = i49;
                int i67 = imgWidth;
                int i68 = imgHeight;
                int i69 = i43;
                int i70 = i26;
                i45 = i46 != i39 ? i68 + (i46 * i30) : i48;
                i46++;
                int i71 = i51;
                i44 = i66;
                str3 = str4;
                i42 = i71;
                i25 = i5;
                i43 = i69;
                i26 = i70;
                imgULX = i47;
                imgULY = i48;
                imgWidth = i67;
                imgHeight = i68;
            }
            i43++;
            str2 = str3;
            i24 = i3;
            i25 = i5;
            imgWidth = imgWidth;
        }
        if (this.printInfo) {
            FacilityManager.getMsgLogger().printmsg(1, str2);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0271 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readPosCompResLy(int[][] iArr, int i, int i2, int i3, int i4, int i5) throws IOException {
        int i6;
        int i7;
        int i8;
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
        int i20;
        int i21;
        boolean sOPMarker;
        int i22;
        int i23;
        int[][] iArr2;
        int iGcd;
        int iGcd2;
        int i24;
        int i25 = i3;
        int i26 = i5;
        Coord numTiles = getNumTiles(null);
        Coord tile = getTile(null);
        int imgULX = this.hd.getImgULX();
        int imgULY = this.hd.getImgULY();
        int imgWidth = this.hd.getImgWidth() + imgULX;
        int imgHeight = this.hd.getImgHeight() + imgULY;
        int tilePartULX = getTilePartULX();
        int tilePartULY = getTilePartULY();
        int nomTileWidth = getNomTileWidth();
        int nomTileHeight = getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        if (tile.y != 0) {
            imgULY = (tile.y * nomTileHeight) + tilePartULY;
        }
        if (tile.x != numTiles.x - 1) {
            imgWidth = ((tile.x + 1) * nomTileWidth) + tilePartULX;
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int tileIdx = getTileIdx();
        int[][] iArr3 = new int[i26][];
        int i27 = 100000;
        int i28 = imgULX;
        int i29 = imgULY;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        for (int i33 = i4; i33 < i26; i33++) {
            int i34 = i2;
            while (i34 < i25) {
                if (i33 < this.mdl.length && i34 <= this.mdl[i33]) {
                    iArr3[i33] = new int[this.mdl[i33] + 1];
                    int[] iArr4 = iArr[i33];
                    iArr2 = iArr3;
                    if (iArr4 != null && i34 < iArr4.length && (i24 = iArr4[i34]) < i27) {
                        i27 = i24;
                    }
                    int numPrecinct = this.pktDec.getNumPrecinct(i33, i34) - 1;
                    int i35 = i27;
                    int i36 = i28;
                    int i37 = i32;
                    while (true) {
                        int i38 = i30;
                        if (numPrecinct < 0) {
                            break;
                        }
                        PrecInfo precInfo = this.pktDec.getPrecInfo(i33, i34, numPrecinct);
                        int i39 = numPrecinct;
                        if (precInfo.rgulx != imgULX) {
                            if (precInfo.rgulx < imgWidth) {
                                imgWidth = precInfo.rgulx;
                            }
                            if (precInfo.rgulx > i36) {
                                i36 = precInfo.rgulx;
                            }
                        }
                        if (precInfo.rguly != imgULY) {
                            if (precInfo.rguly < imgHeight) {
                                imgHeight = precInfo.rguly;
                            }
                            if (precInfo.rguly > i29) {
                                i29 = precInfo.rguly;
                            }
                        }
                        if (i38 == 0) {
                            iGcd = precInfo.rgw;
                            iGcd2 = precInfo.rgh;
                        } else {
                            iGcd = MathUtil.gcd(i37, precInfo.rgw);
                            iGcd2 = MathUtil.gcd(i31, precInfo.rgh);
                        }
                        i31 = iGcd2;
                        i37 = iGcd;
                        i30 = i38 + 1;
                        numPrecinct = i39 - 1;
                    }
                    i32 = i37;
                    i27 = i35;
                    i28 = i36;
                } else {
                    iArr2 = iArr3;
                }
                i34++;
                iArr3 = iArr2;
            }
        }
        int[][] iArr5 = iArr3;
        if (i30 == 0) {
            throw new Error("Image cannot have no precinct");
        }
        int i40 = ((i29 - imgHeight) / i31) + 1;
        int i41 = ((i28 - imgWidth) / i32) + 1;
        int[] iArr6 = this.firstPackOff[tileIdx];
        int i42 = ((iArr6[r11] + this.tilePartLen[tileIdx][r11]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
        int iIntValue = ((Integer) this.decSpec.nls.getTileDef(tileIdx)).intValue();
        String str = "Tile " + getTileIdx() + " (tile-part:" + this.curTilePart + "): offset, length, header length\n";
        boolean zBooleanValue = ((Boolean) this.decSpec.pphs.getTileDef(tileIdx)).booleanValue();
        int i43 = imgULX;
        int i44 = imgULY;
        int i45 = 0;
        while (i45 <= i40) {
            int i46 = i43;
            int i47 = imgULY;
            int i48 = i46;
            int i49 = imgWidth;
            int i50 = 0;
            while (i50 <= i41) {
                int i51 = imgHeight;
                int i52 = i4;
                while (i52 < i26) {
                    if (i52 < this.mdl.length) {
                        int i53 = i2;
                        while (i53 < i25) {
                            if (i53 > this.mdl[i52]) {
                                i7 = i44;
                                i8 = i48;
                                i9 = i52;
                                i6 = i42;
                            } else {
                                i6 = i42;
                                if (iArr5[i52][i53] < this.pktDec.getNumPrecinct(i52, i53)) {
                                    PrecInfo precInfo2 = this.pktDec.getPrecInfo(i52, i53, iArr5[i52][i53]);
                                    if (precInfo2.rgulx == i48 && precInfo2.rguly == i44) {
                                        i7 = i44;
                                        int i54 = i27;
                                        i42 = i6;
                                        while (i54 < i) {
                                            int[] iArr7 = iArr[i52];
                                            int i55 = i48;
                                            if (i53 < iArr7.length && i54 >= iArr7[i53] && i54 < iIntValue) {
                                                int pos = this.in.getPos();
                                                if (zBooleanValue) {
                                                    int i56 = i53;
                                                    i17 = i54;
                                                    int i57 = i52;
                                                    this.pktDec.readPktHead(i17, i56, i57, iArr5[i52][i53], this.cbI[i52][i56], this.nBytes);
                                                    i18 = i56;
                                                    i19 = i57;
                                                } else {
                                                    i17 = i54;
                                                    i18 = i53;
                                                    i19 = i52;
                                                }
                                                if (pos > i42) {
                                                    int i58 = this.curTilePart;
                                                    int[] iArr8 = this.firstPackOff[tileIdx];
                                                    i20 = i42;
                                                    if (i58 < iArr8.length - 1) {
                                                        int i59 = i58 + 1;
                                                        this.curTilePart = i59;
                                                        this.in.seek(iArr8[i59]);
                                                        int pos2 = this.in.getPos();
                                                        int[] iArr9 = this.tilePartLen[tileIdx];
                                                        i21 = ((pos2 + iArr9[r9]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
                                                    }
                                                    i16 = i21;
                                                    sOPMarker = this.pktDec.readSOPMarker(this.nBytes, iArr5[i19][i18], i19, i18);
                                                    if (!sOPMarker) {
                                                        if (!this.printInfo) {
                                                            return true;
                                                        }
                                                        FacilityManager.getMsgLogger().printmsg(1, str);
                                                        return true;
                                                    }
                                                    if (zBooleanValue) {
                                                        i22 = i19;
                                                        i23 = i18;
                                                    } else {
                                                        i22 = i19;
                                                        i23 = i18;
                                                        sOPMarker = this.pktDec.readPktHead(i17, i23, i22, iArr5[i19][i18], this.cbI[i19][i18], this.nBytes);
                                                    }
                                                    if (sOPMarker) {
                                                        if (!this.printInfo) {
                                                            return true;
                                                        }
                                                        FacilityManager.getMsgLogger().printmsg(1, str);
                                                        return true;
                                                    }
                                                    int pos3 = this.in.getPos() - pos;
                                                    this.pktHL.addElement(new Integer(pos3));
                                                    boolean pktBody = this.pktDec.readPktBody(i17, i23, i22, iArr5[i22][i23], this.cbI[i22][i23], this.nBytes);
                                                    i15 = i17;
                                                    i14 = i23;
                                                    i12 = i22;
                                                    i13 = i27;
                                                    String str2 = str + " Pkt l=" + i15 + ",r=" + i14 + ",c=" + i12 + ",p=" + iArr5[i12][i14] + ": " + pos + ", " + (this.in.getPos() - pos) + ", " + pos3 + "\n";
                                                    if (pktBody) {
                                                        if (!this.printInfo) {
                                                            return true;
                                                        }
                                                        FacilityManager.getMsgLogger().printmsg(1, str2);
                                                        return true;
                                                    }
                                                    str = str2;
                                                } else {
                                                    i20 = i42;
                                                }
                                                i21 = i20;
                                                i16 = i21;
                                                sOPMarker = this.pktDec.readSOPMarker(this.nBytes, iArr5[i19][i18], i19, i18);
                                                if (!sOPMarker) {
                                                }
                                            } else {
                                                i12 = i52;
                                                int i60 = i42;
                                                i13 = i27;
                                                i14 = i53;
                                                i15 = i54;
                                                i16 = i60;
                                            }
                                            i54 = i15 + 1;
                                            i53 = i14;
                                            i27 = i13;
                                            i42 = i16;
                                            i52 = i12;
                                            i48 = i55;
                                        }
                                        i8 = i48;
                                        i9 = i52;
                                        i10 = i27;
                                        i11 = i53;
                                        int[] iArr10 = iArr5[i9];
                                        iArr10[i11] = iArr10[i11] + 1;
                                        i53 = i11 + 1;
                                        i25 = i3;
                                        i52 = i9;
                                        i27 = i10;
                                        i44 = i7;
                                        i48 = i8;
                                    }
                                }
                                i7 = i44;
                                i8 = i48;
                                i9 = i52;
                            }
                            i10 = i27;
                            i11 = i53;
                            i42 = i6;
                            i53 = i11 + 1;
                            i25 = i3;
                            i52 = i9;
                            i27 = i10;
                            i44 = i7;
                            i48 = i8;
                        }
                    }
                    i52++;
                    i25 = i3;
                    i26 = i5;
                    i27 = i27;
                    i44 = i44;
                    i48 = i48;
                }
                int i61 = i44;
                int i62 = i27;
                i48 = i50 != i41 ? i49 + (i50 * i32) : i43;
                i50++;
                i25 = i3;
                i26 = i5;
                i27 = i62;
                imgHeight = i51;
                i44 = i61;
            }
            int i63 = i48;
            int i64 = imgHeight;
            int i65 = i27;
            i44 = i45 != i40 ? i64 + (i45 * i31) : i47;
            i45++;
            i25 = i3;
            i26 = i5;
            imgULY = i47;
            imgWidth = i49;
            i27 = i65;
            imgHeight = i64;
            i43 = i63;
        }
        if (this.printInfo) {
            FacilityManager.getMsgLogger().printmsg(1, str);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0369  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readCompPosResLy(int[][] iArr, int i, int i2, int i3, int i4, int i5) throws IOException {
        int i6;
        int i7;
        int i8;
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
        int i20;
        int i21;
        int[][] iArr2;
        int iGcd;
        int iGcd2;
        int i22;
        int i23 = i3;
        int i24 = i5;
        Coord numTiles = getNumTiles(null);
        Coord tile = getTile(null);
        int imgULX = this.hd.getImgULX();
        int imgULY = this.hd.getImgULY();
        int imgWidth = this.hd.getImgWidth() + imgULX;
        int imgHeight = this.hd.getImgHeight() + imgULY;
        int tilePartULX = getTilePartULX();
        int tilePartULY = getTilePartULY();
        int nomTileWidth = getNomTileWidth();
        int nomTileHeight = getNomTileHeight();
        if (tile.x != 0) {
            imgULX = (tile.x * nomTileWidth) + tilePartULX;
        }
        if (tile.y != 0) {
            imgULY = (tile.y * nomTileHeight) + tilePartULY;
        }
        if (tile.x != numTiles.x - 1) {
            imgWidth = ((tile.x + 1) * nomTileWidth) + tilePartULX;
        }
        if (tile.y != numTiles.y - 1) {
            imgHeight = tilePartULY + ((tile.y + 1) * nomTileHeight);
        }
        int tileIdx = getTileIdx();
        int[][] iArr3 = new int[i24][];
        int i25 = 100000;
        int i26 = imgULX;
        int i27 = imgULY;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        for (int i31 = i4; i31 < i24; i31++) {
            int i32 = i2;
            while (i32 < i23) {
                if (i31 < this.mdl.length && i32 <= this.mdl[i31]) {
                    iArr3[i31] = new int[this.mdl[i31] + 1];
                    int[] iArr4 = iArr[i31];
                    iArr2 = iArr3;
                    if (iArr4 != null && i32 < iArr4.length && (i22 = iArr4[i32]) < i25) {
                        i25 = i22;
                    }
                    int numPrecinct = this.pktDec.getNumPrecinct(i31, i32) - 1;
                    int i33 = i25;
                    int i34 = i26;
                    int i35 = i30;
                    while (true) {
                        int i36 = i28;
                        if (numPrecinct < 0) {
                            break;
                        }
                        PrecInfo precInfo = this.pktDec.getPrecInfo(i31, i32, numPrecinct);
                        int i37 = numPrecinct;
                        if (precInfo.rgulx != imgULX) {
                            if (precInfo.rgulx < imgWidth) {
                                imgWidth = precInfo.rgulx;
                            }
                            if (precInfo.rgulx > i34) {
                                i34 = precInfo.rgulx;
                            }
                        }
                        if (precInfo.rguly != imgULY) {
                            if (precInfo.rguly < imgHeight) {
                                imgHeight = precInfo.rguly;
                            }
                            if (precInfo.rguly > i27) {
                                i27 = precInfo.rguly;
                            }
                        }
                        if (i36 == 0) {
                            iGcd = precInfo.rgw;
                            iGcd2 = precInfo.rgh;
                        } else {
                            iGcd = MathUtil.gcd(i35, precInfo.rgw);
                            iGcd2 = MathUtil.gcd(i29, precInfo.rgh);
                        }
                        i29 = iGcd2;
                        i35 = iGcd;
                        i28 = i36 + 1;
                        numPrecinct = i37 - 1;
                    }
                    i30 = i35;
                    i25 = i33;
                    i26 = i34;
                } else {
                    iArr2 = iArr3;
                }
                i32++;
                iArr3 = iArr2;
            }
        }
        int[][] iArr5 = iArr3;
        if (i28 == 0) {
            throw new Error("Image cannot have no precinct");
        }
        int i38 = ((i27 - imgHeight) / i29) + 1;
        int i39 = ((i26 - imgWidth) / i30) + 1;
        int[] iArr6 = this.firstPackOff[tileIdx];
        int i40 = ((iArr6[r11] + this.tilePartLen[tileIdx][r11]) - 1) - this.tilePartHeadLen[tileIdx][this.curTilePart];
        ((Integer) this.decSpec.nls.getTileDef(tileIdx)).intValue();
        String str = "Tile " + getTileIdx() + " (tile-part:" + this.curTilePart + "): offset, length, header length\n";
        boolean zBooleanValue = ((Boolean) this.decSpec.pphs.getTileDef(tileIdx)).booleanValue();
        String str2 = str;
        int i41 = i40;
        int i42 = i4;
        while (i42 < i24) {
            if (i42 >= this.mdl.length) {
                i6 = tileIdx;
            } else {
                i6 = tileIdx;
                int i43 = imgULX;
                int i44 = imgULY;
                int i45 = 0;
                while (i45 <= i38) {
                    int i46 = i43;
                    int i47 = imgULX;
                    int i48 = i46;
                    int i49 = imgULY;
                    int i50 = 0;
                    while (i50 <= i39) {
                        int i51 = imgWidth;
                        int i52 = i2;
                        while (i52 < i23) {
                            if (i52 > this.mdl[i42]) {
                                i8 = i44;
                                i9 = i48;
                                i7 = imgHeight;
                                i12 = i25;
                                i10 = i52;
                                i11 = i42;
                            } else {
                                i7 = imgHeight;
                                if (iArr5[i42][i52] >= this.pktDec.getNumPrecinct(i42, i52)) {
                                    i8 = i44;
                                    i9 = i48;
                                    i10 = i52;
                                    i11 = i42;
                                    i12 = i25;
                                } else {
                                    PrecInfo precInfo2 = this.pktDec.getPrecInfo(i42, i52, iArr5[i42][i52]);
                                    if (precInfo2.rgulx == i48 && precInfo2.rguly == i44) {
                                        int i53 = i25;
                                        while (i53 < i) {
                                            int[] iArr7 = iArr[i42];
                                            int i54 = i44;
                                            if (i52 < iArr7.length && i53 >= iArr7[i52]) {
                                                int pos = this.in.getPos();
                                                if (zBooleanValue) {
                                                    i18 = i53;
                                                    int i55 = i42;
                                                    this.pktDec.readPktHead(i18, i52, i55, iArr5[i42][i52], this.cbI[i42][i52], this.nBytes);
                                                    i19 = i55;
                                                } else {
                                                    i18 = i53;
                                                    i19 = i42;
                                                }
                                                if (pos > i41) {
                                                    int i56 = this.curTilePart;
                                                    int[] iArr8 = this.firstPackOff[i6];
                                                    i16 = i48;
                                                    if (i56 < iArr8.length - 1) {
                                                        int i57 = i56 + 1;
                                                        this.curTilePart = i57;
                                                        this.in.seek(iArr8[i57]);
                                                        int pos2 = this.in.getPos();
                                                        int[] iArr9 = this.tilePartLen[i6];
                                                        i41 = ((pos2 + iArr9[r9]) - 1) - this.tilePartHeadLen[i6][this.curTilePart];
                                                    }
                                                } else {
                                                    i16 = i48;
                                                }
                                                boolean sOPMarker = this.pktDec.readSOPMarker(this.nBytes, iArr5[i19][i52], i19, i52);
                                                if (sOPMarker) {
                                                    if (!this.printInfo) {
                                                        return true;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str2);
                                                    return true;
                                                }
                                                if (zBooleanValue) {
                                                    i20 = i19;
                                                    i21 = i52;
                                                } else {
                                                    i20 = i19;
                                                    i21 = i52;
                                                    sOPMarker = this.pktDec.readPktHead(i18, i21, i20, iArr5[i19][i52], this.cbI[i19][i52], this.nBytes);
                                                }
                                                if (sOPMarker) {
                                                    if (!this.printInfo) {
                                                        return true;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str2);
                                                    return true;
                                                }
                                                int pos3 = this.in.getPos() - pos;
                                                this.pktHL.addElement(new Integer(pos3));
                                                boolean pktBody = this.pktDec.readPktBody(i18, i21, i20, iArr5[i20][i21], this.cbI[i20][i21], this.nBytes);
                                                i15 = i18;
                                                i13 = i21;
                                                i14 = i20;
                                                i17 = i25;
                                                String str3 = str2 + " Pkt l=" + i15 + ",r=" + i13 + ",c=" + i14 + ",p=" + iArr5[i14][i13] + ": " + pos + ", " + (this.in.getPos() - pos) + ", " + pos3 + "\n";
                                                if (pktBody) {
                                                    if (!this.printInfo) {
                                                        return true;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str3);
                                                    return true;
                                                }
                                                str2 = str3;
                                            } else {
                                                int i58 = i53;
                                                i13 = i52;
                                                i14 = i42;
                                                i15 = i58;
                                                i16 = i48;
                                                i17 = i25;
                                            }
                                            int i59 = i15 + 1;
                                            i44 = i54;
                                            i42 = i14;
                                            i52 = i13;
                                            i25 = i17;
                                            i48 = i16;
                                            i53 = i59;
                                        }
                                        i8 = i44;
                                        i9 = i48;
                                        i10 = i52;
                                        i11 = i42;
                                        i12 = i25;
                                        int[] iArr10 = iArr5[i11];
                                        iArr10[i10] = iArr10[i10] + 1;
                                    }
                                }
                            }
                            int i60 = i10 + 1;
                            i44 = i8;
                            i42 = i11;
                            i25 = i12;
                            imgHeight = i7;
                            i48 = i9;
                            i52 = i60;
                            i23 = i3;
                        }
                        int i61 = i44;
                        int i62 = imgHeight;
                        int i63 = i42;
                        int i64 = i25;
                        i48 = i50 != i39 ? i51 + (i50 * i30) : i47;
                        i50++;
                        i23 = i3;
                        i44 = i61;
                        i42 = i63;
                        i25 = i64;
                        imgWidth = i51;
                        imgHeight = i62;
                    }
                    int i65 = i48;
                    int i66 = imgWidth;
                    int i67 = imgHeight;
                    int i68 = i42;
                    int i69 = i25;
                    i44 = i45 != i38 ? i67 + (i45 * i29) : i49;
                    i45++;
                    i23 = i3;
                    i42 = i68;
                    imgULX = i47;
                    i25 = i69;
                    imgULY = i49;
                    imgWidth = i66;
                    imgHeight = i67;
                    i43 = i65;
                }
            }
            i42++;
            i23 = i3;
            i24 = i5;
            imgULX = imgULX;
            i25 = i25;
            tileIdx = i6;
            imgULY = imgULY;
            imgWidth = imgWidth;
            imgHeight = imgHeight;
        }
        if (this.printInfo) {
            FacilityManager.getMsgLogger().printmsg(1, str2);
        }
        return false;
    }

    private void readTilePkts(int i) throws IOException {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        CBlkInfo[][][] cBlkInfoArr;
        CBlkInfo[][] cBlkInfoArr2;
        CBlkInfo[] cBlkInfoArr3;
        CBlkInfo cBlkInfo;
        int i5;
        CBlkInfo[][][] cBlkInfoArr4;
        CBlkInfo[][] cBlkInfoArr5;
        CBlkInfo[] cBlkInfoArr6;
        CBlkInfo[][][] cBlkInfoArr7;
        CBlkInfo[][] cBlkInfoArr8;
        CBlkInfo[][][] cBlkInfoArr9;
        int i6;
        int i7;
        boolean lyResCompPos;
        FileBitstreamReaderAgent fileBitstreamReaderAgent = this;
        fileBitstreamReaderAgent.pktHL = new Vector();
        int iIntValue = ((Integer) fileBitstreamReaderAgent.decSpec.nls.getTileDef(i)).intValue();
        if (((Boolean) fileBitstreamReaderAgent.decSpec.pphs.getTileDef(i)).booleanValue()) {
            fileBitstreamReaderAgent.cbI = fileBitstreamReaderAgent.pktDec.restart(fileBitstreamReaderAgent.nc, fileBitstreamReaderAgent.mdl, iIntValue, fileBitstreamReaderAgent.cbI, true, fileBitstreamReaderAgent.hd.getPackedPktHead(i));
        } else {
            fileBitstreamReaderAgent.cbI = fileBitstreamReaderAgent.pktDec.restart(fileBitstreamReaderAgent.nc, fileBitstreamReaderAgent.mdl, iIntValue, fileBitstreamReaderAgent.cbI, false, null);
        }
        int[][] iArr2 = (int[][]) fileBitstreamReaderAgent.decSpec.pcs.getTileDef(i);
        int i8 = 1;
        int length = iArr2 == null ? 1 : iArr2.length;
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, 6);
        int[] iArr4 = iArr3[0];
        iArr4[1] = 0;
        char c = 5;
        int i9 = 4;
        int i10 = 3;
        if (iArr2 == null) {
            iArr4[0] = ((Integer) fileBitstreamReaderAgent.decSpec.pos.getTileDef(i)).intValue();
            int[] iArr5 = iArr3[0];
            iArr5[1] = iIntValue;
            iArr5[2] = 0;
            iArr5[3] = fileBitstreamReaderAgent.decSpec.dls.getMaxInTile(i) + 1;
            int[] iArr6 = iArr3[0];
            iArr6[4] = 0;
            iArr6[5] = fileBitstreamReaderAgent.nc;
        } else {
            for (int i11 = 0; i11 < length; i11++) {
                int[] iArr7 = iArr3[i11];
                int[] iArr8 = iArr2[i11];
                iArr7[0] = iArr8[5];
                iArr7[1] = iArr8[2];
                iArr7[2] = iArr8[0];
                iArr7[3] = iArr8[3];
                iArr7[4] = iArr8[1];
                iArr7[5] = iArr8[4];
            }
        }
        try {
            if ((!fileBitstreamReaderAgent.isTruncMode || fileBitstreamReaderAgent.firstPackOff != null) && (iArr = fileBitstreamReaderAgent.firstPackOff[i]) != null) {
                fileBitstreamReaderAgent.in.seek(iArr[0]);
                fileBitstreamReaderAgent.curTilePart = 0;
                int i12 = fileBitstreamReaderAgent.nBytes[i];
                int i13 = fileBitstreamReaderAgent.nc;
                int[][] iArr9 = new int[i13][];
                for (int i14 = 0; i14 < fileBitstreamReaderAgent.nc; i14++) {
                    iArr9[i14] = new int[((Integer) fileBitstreamReaderAgent.decSpec.dls.getTileCompVal(i, i14)).intValue() + 1];
                }
                int i15 = 0;
                boolean z = false;
                while (i15 < length) {
                    int[] iArr10 = iArr3[i15];
                    int i16 = i13;
                    int i17 = iArr10[i8];
                    int i18 = iArr10[2];
                    int i19 = i15;
                    int i20 = iArr10[i10];
                    int i21 = iArr10[i9];
                    int i22 = iArr10[c];
                    i2 = 0;
                    int i23 = iArr10[0];
                    if (i23 != 0) {
                        if (i23 == i8) {
                            i6 = i18;
                            i7 = i16;
                            lyResCompPos = fileBitstreamReaderAgent.readResLyCompPos(iArr9, i17, i6, i20, i21, i22);
                        } else if (i23 == 2) {
                            i6 = i18;
                            i7 = i16;
                            lyResCompPos = fileBitstreamReaderAgent.readResPosCompLy(iArr9, i17, i6, i20, i21, i22);
                        } else if (i23 == i10) {
                            i6 = i18;
                            i7 = i16;
                            lyResCompPos = fileBitstreamReaderAgent.readPosCompResLy(iArr9, i17, i6, i20, i21, i22);
                        } else if (i23 == i9) {
                            i6 = i18;
                            i7 = i16;
                            lyResCompPos = fileBitstreamReaderAgent.readCompPosResLy(iArr9, i17, i6, i20, i21, i22);
                        } else {
                            throw new IllegalArgumentException("Not recognized progression type");
                        }
                        fileBitstreamReaderAgent = this;
                    } else {
                        i6 = i18;
                        i7 = i16;
                        lyResCompPos = fileBitstreamReaderAgent.readLyResCompPos(iArr9, i17, i6, i20, i21, i22);
                    }
                    while (i21 < i22) {
                        if (i21 < i7) {
                            for (int i24 = i6; i24 < i20; i24++) {
                                int[] iArr11 = iArr9[i21];
                                if (i24 < iArr11.length) {
                                    iArr11[i24] = i17;
                                }
                            }
                        }
                        i21++;
                    }
                    if (lyResCompPos || fileBitstreamReaderAgent.usePOCQuit) {
                        z = lyResCompPos;
                        break;
                    }
                    i15 = i19 + 1;
                    i13 = i7;
                    z = lyResCompPos;
                    i10 = 3;
                    i8 = 1;
                    c = 5;
                    i9 = 4;
                }
                i2 = 0;
                if (fileBitstreamReaderAgent.isTruncMode) {
                    fileBitstreamReaderAgent.anbytes += i12 - fileBitstreamReaderAgent.nBytes[i];
                    if (z) {
                        fileBitstreamReaderAgent.nBytes[i] = i2;
                        return;
                    }
                    return;
                }
                if (fileBitstreamReaderAgent.nBytes[i] < fileBitstreamReaderAgent.totTileLen[i] - fileBitstreamReaderAgent.totTileHeadLen[i]) {
                    int[] iArr12 = new int[fileBitstreamReaderAgent.pktHL.size()];
                    for (int size = fileBitstreamReaderAgent.pktHL.size() - 1; size >= 0; size--) {
                        iArr12[size] = ((Integer) fileBitstreamReaderAgent.pktHL.elementAt(size)).intValue();
                    }
                    int i25 = 0;
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i25 < iIntValue) {
                        CBlkInfo[][][][][] cBlkInfoArr10 = fileBitstreamReaderAgent.cbI;
                        if (cBlkInfoArr10 != null) {
                            int length2 = cBlkInfoArr10.length;
                            int length3 = 0;
                            for (int i26 = 0; i26 < length2; i26++) {
                                CBlkInfo[][][][] cBlkInfoArr11 = fileBitstreamReaderAgent.cbI[i26];
                                if (cBlkInfoArr11 != null && cBlkInfoArr11.length > length3) {
                                    length3 = cBlkInfoArr11.length;
                                }
                            }
                            for (int i27 = 0; i27 < length3; i27++) {
                                int length4 = 0;
                                for (int i28 = 0; i28 < length2; i28++) {
                                    CBlkInfo[][][][] cBlkInfoArr12 = fileBitstreamReaderAgent.cbI[i28];
                                    if (cBlkInfoArr12 != null && (cBlkInfoArr9 = cBlkInfoArr12[i27]) != null && cBlkInfoArr9.length > length4) {
                                        length4 = cBlkInfoArr9.length;
                                    }
                                }
                                int i29 = 0;
                                while (i29 < length4) {
                                    if ((i27 != 0 || i29 == 0) && (i27 == 0 || i29 != 0)) {
                                        int length5 = 0;
                                        for (int i30 = 0; i30 < length2; i30++) {
                                            CBlkInfo[][][][] cBlkInfoArr13 = fileBitstreamReaderAgent.cbI[i30];
                                            if (cBlkInfoArr13 != null && (cBlkInfoArr7 = cBlkInfoArr13[i27]) != null && (cBlkInfoArr8 = cBlkInfoArr7[i29]) != null && cBlkInfoArr8.length > length5) {
                                                length5 = cBlkInfoArr8.length;
                                            }
                                        }
                                        int i31 = 0;
                                        while (i31 < length5) {
                                            int i32 = 0;
                                            int length6 = 0;
                                            while (i32 < length2) {
                                                int[] iArr13 = iArr12;
                                                CBlkInfo[][][][] cBlkInfoArr14 = fileBitstreamReaderAgent.cbI[i32];
                                                if (cBlkInfoArr14 == null || (cBlkInfoArr4 = cBlkInfoArr14[i27]) == null || (cBlkInfoArr5 = cBlkInfoArr4[i29]) == null || (cBlkInfoArr6 = cBlkInfoArr5[i31]) == null) {
                                                    i5 = i25;
                                                } else {
                                                    i5 = i25;
                                                    if (cBlkInfoArr6.length > length6) {
                                                        length6 = cBlkInfoArr6.length;
                                                    }
                                                }
                                                i32++;
                                                iArr12 = iArr13;
                                                i25 = i5;
                                            }
                                            int[] iArr14 = iArr12;
                                            int i33 = i25;
                                            int i34 = 0;
                                            while (i34 < length6) {
                                                int i35 = 0;
                                                while (i35 < length2) {
                                                    CBlkInfo[][][][] cBlkInfoArr15 = fileBitstreamReaderAgent.cbI[i35];
                                                    if (cBlkInfoArr15 == null || (cBlkInfoArr = cBlkInfoArr15[i27]) == null || (cBlkInfoArr2 = cBlkInfoArr[i29]) == null || (cBlkInfoArr3 = cBlkInfoArr2[i31]) == null || (cBlkInfo = cBlkInfoArr3[i34]) == null) {
                                                        i3 = i34;
                                                        i4 = i35;
                                                    } else {
                                                        i3 = i34;
                                                        if (z2) {
                                                            i4 = i35;
                                                        } else {
                                                            i4 = i35;
                                                            if (fileBitstreamReaderAgent.nBytes[i] < iArr14[cBlkInfo.pktIdx[i33]]) {
                                                                z2 = true;
                                                                z3 = true;
                                                            } else if (!z3) {
                                                                int[] iArr15 = fileBitstreamReaderAgent.nBytes;
                                                                iArr15[i] = iArr15[i] - iArr14[cBlkInfo.pktIdx[i33]];
                                                                fileBitstreamReaderAgent.anbytes += iArr14[cBlkInfo.pktIdx[i33]];
                                                                iArr14[cBlkInfo.pktIdx[i33]] = i2;
                                                            }
                                                        }
                                                        if (cBlkInfo.len[i33] != 0) {
                                                            int i36 = cBlkInfo.len[i33];
                                                            int[] iArr16 = fileBitstreamReaderAgent.nBytes;
                                                            int i37 = iArr16[i];
                                                            if (i36 < i37 && !z2) {
                                                                iArr16[i] = i37 - cBlkInfo.len[i33];
                                                                fileBitstreamReaderAgent.anbytes += cBlkInfo.len[i33];
                                                            } else {
                                                                int[] iArr17 = cBlkInfo.len;
                                                                int[] iArr18 = cBlkInfo.off;
                                                                cBlkInfo.ntp[i33] = i2;
                                                                iArr18[i33] = i2;
                                                                iArr17[i33] = i2;
                                                                z2 = true;
                                                            }
                                                        }
                                                    }
                                                    i35 = i4 + 1;
                                                    i34 = i3;
                                                }
                                                i34++;
                                            }
                                            i31++;
                                            iArr12 = iArr14;
                                            i25 = i33;
                                        }
                                    }
                                    i29++;
                                    iArr12 = iArr12;
                                    i25 = i25;
                                }
                            }
                        }
                        i25++;
                        iArr12 = iArr12;
                    }
                    return;
                }
                fileBitstreamReaderAgent.anbytes += fileBitstreamReaderAgent.totTileLen[i] - fileBitstreamReaderAgent.totTileHeadLen[i];
                if (i < fileBitstreamReaderAgent.getNumTiles() - 1) {
                    int[] iArr19 = fileBitstreamReaderAgent.nBytes;
                    int i38 = i + 1;
                    iArr19[i38] = iArr19[i38] + (iArr19[i] - (fileBitstreamReaderAgent.totTileLen[i] - fileBitstreamReaderAgent.totTileHeadLen[i]));
                }
            }
        } catch (EOFException unused) {
            FacilityManager.getMsgLogger().printmsg(2, "Codestream truncated in tile " + i);
        }
    }

    @Override // jj2000.j2k.codestream.reader.BitstreamReaderAgent, jj2000.j2k.wavelet.synthesis.MultiResImgData
    public void setTile(int i, int i2) {
        if (i < 0 || i2 < 0 || i >= this.ntX || i2 >= this.ntY) {
            throw new IllegalArgumentException();
        }
        int i3 = (this.ntX * i2) + i;
        if (i3 == 0) {
            this.anbytes = this.headLen;
            if (!this.isTruncMode) {
                this.anbytes += 2;
            }
            for (int i4 = 0; i4 < this.nt; i4++) {
                this.nBytes[i4] = this.baknBytes[i4];
            }
        }
        this.ctX = i;
        this.ctY = i2;
        int i5 = i == 0 ? this.ax : this.px + (this.ntW * i);
        int i6 = i2 == 0 ? this.ay : this.py + (this.ntH * i2);
        for (int i7 = this.nc - 1; i7 >= 0; i7--) {
            this.culx[i7] = ((this.hd.getCompSubsX(i7) + i5) - 1) / this.hd.getCompSubsX(i7);
            this.culy[i7] = ((this.hd.getCompSubsY(i7) + i6) - 1) / this.hd.getCompSubsY(i7);
            this.offX[i7] = (((this.px + (this.ntW * i)) + this.hd.getCompSubsX(i7)) - 1) / this.hd.getCompSubsX(i7);
            this.offY[i7] = (((this.py + (this.ntH * i2)) + this.hd.getCompSubsY(i7)) - 1) / this.hd.getCompSubsY(i7);
        }
        this.subbTrees = new SubbandSyn[this.nc];
        this.mdl = new int[this.nc];
        this.derived = new boolean[this.nc];
        this.params = new StdDequantizerParams[this.nc];
        this.gb = new int[this.nc];
        for (int i8 = 0; i8 < this.nc; i8++) {
            this.derived[i8] = this.decSpec.qts.isDerived(i3, i8);
            this.params[i8] = (StdDequantizerParams) this.decSpec.qsss.getTileCompVal(i3, i8);
            this.gb[i8] = ((Integer) this.decSpec.gbs.getTileCompVal(i3, i8)).intValue();
            this.mdl[i8] = ((Integer) this.decSpec.dls.getTileCompVal(i3, i8)).intValue();
            this.subbTrees[i8] = new SubbandSyn(getTileCompWidth(i3, i8, this.mdl[i8]), getTileCompHeight(i3, i8, this.mdl[i8]), getResULX(i8, this.mdl[i8]), getResULY(i8, this.mdl[i8]), this.mdl[i8], this.decSpec.wfs.getHFilters(i3, i8), this.decSpec.wfs.getVFilters(i3, i8));
            initSubbandsFields(i8, this.subbTrees[i8]);
        }
        try {
            readTilePkts(i3);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("IO Error when reading tile " + i + " x " + i2);
        }
    }

    @Override // jj2000.j2k.codestream.reader.BitstreamReaderAgent, jj2000.j2k.wavelet.synthesis.MultiResImgData
    public void nextTile() {
        if (this.ctX == this.ntX - 1 && this.ctY == this.ntY - 1) {
            throw new NoNextElementException();
        }
        if (this.ctX < this.ntX - 1) {
            setTile(this.ctX + 1, this.ctY);
        } else {
            setTile(0, this.ctY + 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x024c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019e  */
    @Override // jj2000.j2k.entropy.decoder.CodedCBlkDataSrcDec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecLyrdCBlk getCodeBlock(int i, int i2, int i3, SubbandSyn subbandSyn, int i4, int i5, DecLyrdCBlk decLyrdCBlk) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        FileBitstreamReaderAgent fileBitstreamReaderAgent = this;
        int tileIdx = fileBitstreamReaderAgent.getTileIdx();
        int i12 = subbandSyn.resLvl;
        int i13 = subbandSyn.sbandIdx;
        int iIntValue = ((Integer) fileBitstreamReaderAgent.decSpec.nls.getTileDef(tileIdx)).intValue();
        int iIntValue2 = ((Integer) fileBitstreamReaderAgent.decSpec.ecopts.getTileCompVal(tileIdx, i)).intValue();
        int i14 = i5 < 0 ? (iIntValue - i4) + 1 : i5;
        int i15 = fileBitstreamReaderAgent.lQuit;
        if (i15 != -1 && i4 + i14 > i15) {
            i14 = i15 - i4;
        }
        if (i12 > (fileBitstreamReaderAgent.targetRes + fileBitstreamReaderAgent.getSynSubbandTree(tileIdx, i).resLvl) - fileBitstreamReaderAgent.decSpec.dls.getMin()) {
            throw new Error("JJ2000 error: requesting a code-block disallowed by the '-res' option.");
        }
        try {
            CBlkInfo cBlkInfo = fileBitstreamReaderAgent.cbI[i][i12][i13][i2][i3];
            if (i4 < 1 || i4 > iIntValue || (i4 + i14) - 1 > iIntValue) {
                throw new IllegalArgumentException();
            }
            DecLyrdCBlk decLyrdCBlk2 = decLyrdCBlk == null ? new DecLyrdCBlk() : decLyrdCBlk;
            decLyrdCBlk2.m = i2;
            decLyrdCBlk2.n = i3;
            decLyrdCBlk2.nl = 0;
            decLyrdCBlk2.dl = 0;
            decLyrdCBlk2.nTrunc = 0;
            if (cBlkInfo == null) {
                decLyrdCBlk2.skipMSBP = 0;
                decLyrdCBlk2.prog = false;
                decLyrdCBlk2.uly = 0;
                decLyrdCBlk2.ulx = 0;
                decLyrdCBlk2.h = 0;
                decLyrdCBlk2.w = 0;
                return decLyrdCBlk2;
            }
            decLyrdCBlk2.skipMSBP = cBlkInfo.msbSkipped;
            decLyrdCBlk2.ulx = cBlkInfo.ulx;
            decLyrdCBlk2.uly = cBlkInfo.uly;
            decLyrdCBlk2.w = cBlkInfo.w;
            decLyrdCBlk2.h = cBlkInfo.h;
            decLyrdCBlk2.ftpIdx = 0;
            for (int i16 = 0; i16 < cBlkInfo.len.length && cBlkInfo.len[i16] == 0; i16++) {
                decLyrdCBlk2.ftpIdx += cBlkInfo.ntp[i16];
            }
            int i17 = i4 - 1;
            for (int i18 = i17; i18 < i6; i18++) {
                decLyrdCBlk2.nl++;
                decLyrdCBlk2.dl += cBlkInfo.len[i18];
                decLyrdCBlk2.nTrunc += cBlkInfo.ntp[i18];
            }
            int i19 = iIntValue2 & 4;
            if (i19 != 0) {
                i7 = decLyrdCBlk2.nTrunc - decLyrdCBlk2.ftpIdx;
            } else if ((iIntValue2 & 1) == 0 || decLyrdCBlk2.nTrunc <= 10) {
                i7 = 1;
            } else {
                int i20 = 1;
                for (int i21 = decLyrdCBlk2.ftpIdx; i21 < decLyrdCBlk2.nTrunc; i21++) {
                    if (i21 >= 9 && ((i8 = (i21 + 2) % 3) == 1 || i8 == 2)) {
                        i20++;
                    }
                }
                i7 = i20;
            }
            if (decLyrdCBlk2.data == null || decLyrdCBlk2.data.length < decLyrdCBlk2.dl) {
                decLyrdCBlk2.data = new byte[decLyrdCBlk2.dl];
            }
            int i22 = 1;
            if (i7 <= 1) {
                if (i7 > i22 && (iIntValue2 & 5) == i22) {
                    ArrayUtil.intArraySet(decLyrdCBlk2.tsLengths, 0);
                }
            } else if (decLyrdCBlk2.tsLengths == null || decLyrdCBlk2.tsLengths.length < i7) {
                decLyrdCBlk2.tsLengths = new int[i7];
            } else {
                i22 = 1;
                if (i7 > i22) {
                    ArrayUtil.intArraySet(decLyrdCBlk2.tsLengths, 0);
                }
            }
            int i23 = decLyrdCBlk2.ftpIdx;
            int i24 = 0;
            int i25 = i17;
            int i26 = decLyrdCBlk2.ftpIdx;
            int i27 = -1;
            while (i25 < i6) {
                int i28 = cBlkInfo.ntp[i25] + i26;
                if (cBlkInfo.len[i25] != 0) {
                    try {
                        i10 = 0;
                    } catch (IOException e) {
                        e = e;
                        i10 = 0;
                    }
                    try {
                        fileBitstreamReaderAgent.in.seek(cBlkInfo.off[i25]);
                        fileBitstreamReaderAgent.in.readFully(decLyrdCBlk2.data, i27 + 1, cBlkInfo.len[i25]);
                        i27 += cBlkInfo.len[i25];
                    } catch (IOException e2) {
                        e = e2;
                        JJ2KExceptionHandler.handleException(e);
                        if (i7 != 1) {
                        }
                        i25++;
                        fileBitstreamReaderAgent = this;
                        i26 = i28;
                    }
                    if (i7 != 1) {
                        if (i19 != 0) {
                            int i29 = 0;
                            while (i23 < i28) {
                                if (cBlkInfo.segLen[i25] != null) {
                                    i11 = i24 + 1;
                                    decLyrdCBlk2.tsLengths[i24] = cBlkInfo.segLen[i25][i29];
                                } else {
                                    i11 = i24 + 1;
                                    decLyrdCBlk2.tsLengths[i24] = cBlkInfo.len[i25];
                                }
                                i24 = i11;
                                i29++;
                                i23++;
                            }
                        } else {
                            int i30 = 0;
                            while (i23 < i28) {
                                if (i23 >= 9 && (i23 + 2) % 3 != 0) {
                                    if (cBlkInfo.segLen[i25] != null) {
                                        int[] iArr = decLyrdCBlk2.tsLengths;
                                        iArr[i24] = iArr[i24] + cBlkInfo.segLen[i25][i30];
                                        int[] iArr2 = cBlkInfo.len;
                                        iArr2[i25] = iArr2[i25] - cBlkInfo.segLen[i25][i30];
                                        i24++;
                                        i30++;
                                    } else {
                                        int[] iArr3 = decLyrdCBlk2.tsLengths;
                                        iArr3[i24] = iArr3[i24] + cBlkInfo.len[i25];
                                        cBlkInfo.len[i25] = i10;
                                        i24++;
                                    }
                                }
                                i23++;
                            }
                            if (cBlkInfo.segLen[i25] != null && i30 < cBlkInfo.segLen[i25].length) {
                                int[] iArr4 = decLyrdCBlk2.tsLengths;
                                iArr4[i24] = iArr4[i24] + cBlkInfo.segLen[i25][i30];
                                int[] iArr5 = cBlkInfo.len;
                                iArr5[i25] = iArr5[i25] - cBlkInfo.segLen[i25][i30];
                            } else if (i24 < i7) {
                                int[] iArr6 = decLyrdCBlk2.tsLengths;
                                iArr6[i24] = iArr6[i24] + cBlkInfo.len[i25];
                                cBlkInfo.len[i25] = i10;
                            }
                        }
                    }
                }
                i25++;
                fileBitstreamReaderAgent = this;
                i26 = i28;
            }
            if (i7 == 1 && decLyrdCBlk2.tsLengths != null) {
                decLyrdCBlk2.tsLengths[0] = decLyrdCBlk2.dl;
            }
            if (i6 < iIntValue - 1) {
                while (i9 < iIntValue) {
                    if (cBlkInfo.len[i9] != 0) {
                        decLyrdCBlk2.prog = true;
                    }
                    i9++;
                }
            }
            return decLyrdCBlk2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Code-block (t:" + tileIdx + ", c:" + i + ", r:" + i12 + ", s:" + i13 + ", " + i2 + "x" + i3 + ") not found in codestream");
        } catch (NullPointerException unused2) {
            throw new IllegalArgumentException("Code-block (t:" + tileIdx + ", c:" + i + ", r:" + i12 + ", s:" + i13 + ", " + i2 + "x" + i3 + ") not found in bit stream");
        }
    }
}
