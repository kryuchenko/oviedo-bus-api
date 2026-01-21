package jj2000.j2k.codestream.reader;

import colorspace.ChannelDefinitionMapper;
import colorspace.ColorSpace;
import colorspace.ColorSpaceException;
import colorspace.ColorSpaceMapper;
import colorspace.PalettizedColorSpaceMapper;
import colorspace.Resampler;
import icc.ICCProfileException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Vector;
import jj2000.j2k.IntegerSpec;
import jj2000.j2k.NotImplementedError;
import jj2000.j2k.codestream.CorruptedCodestreamException;
import jj2000.j2k.codestream.HeaderInfo;
import jj2000.j2k.codestream.Markers;
import jj2000.j2k.codestream.ProgressionType;
import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.entropy.decoder.CodedCBlkDataSrcDec;
import jj2000.j2k.entropy.decoder.EntropyDecoder;
import jj2000.j2k.entropy.decoder.StdEntropyDecoder;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.Coord;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec;
import jj2000.j2k.quantization.dequantizer.Dequantizer;
import jj2000.j2k.quantization.dequantizer.StdDequantizer;
import jj2000.j2k.quantization.dequantizer.StdDequantizerParams;
import jj2000.j2k.quantization.quantizer.StdQuantizer;
import jj2000.j2k.roi.MaxShiftSpec;
import jj2000.j2k.roi.ROIDeScaler;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.synthesis.SynWTFilter;
import jj2000.j2k.wavelet.synthesis.SynWTFilterFloatLift9x7;
import jj2000.j2k.wavelet.synthesis.SynWTFilterIntLift5x3;

/* loaded from: classes5.dex */
public class HeaderDecoder implements ProgressionType, Markers, StdEntropyCoderOptions {
    private static final int COC_FOUND = 4;
    private static final int COD_FOUND = 2;
    private static final int COM_FOUND = 2048;
    public static final int CRG_FOUND = 65536;
    public static final char OPT_PREFIX = 'H';
    private static final int PLM_FOUND = 32;
    private static final int PLT_FOUND = 128;
    private static final int POC_FOUND = 1024;
    public static final int PPM_FOUND = 16384;
    public static final int PPT_FOUND = 32768;
    private static final int QCC_FOUND = 256;
    private static final int QCD_FOUND = 8;
    private static final int RGN_FOUND = 512;
    private static final int SIZ_FOUND = 1;
    public static final int SOD_FOUND = 8192;
    private static final int SOT_FOUND = 64;
    private static final int TILE_RESET = -546;
    private static final int TLM_FOUND = 16;
    private static final String[][] pinfo = null;
    private DecoderSpecs decSpec;
    private HeaderInfo hi;
    public int mainHeadOff;
    private int nComp;
    public int[] nTileParts;
    private int nTiles;
    private int nfMarkSeg;
    private byte[][] pPMMarkerData;
    private ByteArrayOutputStream[] pkdPktHeaders;
    boolean precinctPartitionIsUsed;
    public Vector tileOfTileParts;
    private byte[][][][] tilePartPkdPktHeaders;
    private String hdStr = "";
    private int nCOCMarkSeg = 0;
    private int nQCCMarkSeg = 0;
    private int nCOMMarkSeg = 0;
    private int nRGNMarkSeg = 0;
    private int nPPMMarkSeg = 0;
    private int[][] nPPTMarkSeg = null;
    private Hashtable ht = null;
    private int cb0x = -1;
    private int cb0y = -1;
    private boolean verbose = this.verbose;
    private boolean verbose = this.verbose;

    static {
    }

    public int getMaxCompImgHeight() {
        return this.hi.siz.getMaxCompHeight();
    }

    public int getMaxCompImgWidth() {
        return this.hi.siz.getMaxCompWidth();
    }

    public final int getImgWidth() {
        return this.hi.siz.xsiz - this.hi.siz.x0siz;
    }

    public final int getImgHeight() {
        return this.hi.siz.ysiz - this.hi.siz.y0siz;
    }

    public final int getImgULX() {
        return this.hi.siz.x0siz;
    }

    public final int getImgULY() {
        return this.hi.siz.y0siz;
    }

    public final int getNomTileWidth() {
        return this.hi.siz.xtsiz;
    }

    public final int getNomTileHeight() {
        return this.hi.siz.ytsiz;
    }

    public final Coord getTilingOrigin(Coord coord) {
        if (coord != null) {
            coord.x = this.hi.siz.xt0siz;
            coord.y = this.hi.siz.yt0siz;
            return coord;
        }
        return new Coord(this.hi.siz.xt0siz, this.hi.siz.yt0siz);
    }

    public final boolean isOriginalSigned(int i) {
        return this.hi.siz.isOrigSigned(i);
    }

    public final int getOriginalBitDepth(int i) {
        return this.hi.siz.getOrigBitDepth(i);
    }

    public final int getNumComps() {
        return this.nComp;
    }

    public final int getCompSubsX(int i) {
        return this.hi.siz.xrsiz[i];
    }

    public final int getCompSubsY(int i) {
        return this.hi.siz.yrsiz[i];
    }

    public final Dequantizer createDequantizer(CBlkQuantDataSrcDec cBlkQuantDataSrcDec, int[] iArr, DecoderSpecs decoderSpecs) {
        return new StdDequantizer(cBlkQuantDataSrcDec, iArr, decoderSpecs);
    }

    public final int getCbULX() {
        return this.cb0x;
    }

    public final int getCbULY() {
        return this.cb0y;
    }

    public final int getPPX(int i, int i2, int i3) {
        return this.decSpec.pss.getPPX(i, i2, i3);
    }

    public final int getPPY(int i, int i2, int i3) {
        return this.decSpec.pss.getPPY(i, i2, i3);
    }

    public final boolean precinctPartitionUsed() {
        return this.precinctPartitionIsUsed;
    }

    private SynWTFilter readFilter(DataInputStream dataInputStream, int[] iArr) throws IOException {
        int unsignedByte = dataInputStream.readUnsignedByte();
        iArr[0] = unsignedByte;
        if (unsignedByte >= 128) {
            throw new NotImplementedError("Custom filters not supported");
        }
        if (unsignedByte == 0) {
            return new SynWTFilterFloatLift9x7();
        }
        if (unsignedByte == 1) {
            return new SynWTFilterIntLift5x3();
        }
        throw new CorruptedCodestreamException("Specified wavelet filter not JPEG 2000 part I compliant");
    }

    public void checkMarkerLength(DataInputStream dataInputStream, String str) throws IOException {
        if (dataInputStream.available() != 0) {
            FacilityManager.getMsgLogger().printmsg(2, str + " length was short, attempting to resync.");
        }
    }

    private void readSIZ(DataInputStream dataInputStream) throws IOException {
        HeaderInfo.SIZ newSIZ = this.hi.getNewSIZ();
        this.hi.siz = newSIZ;
        newSIZ.lsiz = dataInputStream.readUnsignedShort();
        newSIZ.rsiz = dataInputStream.readUnsignedShort();
        if (newSIZ.rsiz > 2) {
            throw new Error("Codestream capabiities not JPEG 2000 - Part I compliant");
        }
        newSIZ.xsiz = dataInputStream.readInt();
        newSIZ.ysiz = dataInputStream.readInt();
        if (newSIZ.xsiz <= 0 || newSIZ.ysiz <= 0) {
            throw new IOException("JJ2000 does not support images whose width and/or height not in the range: 1 -- (2^31)-1");
        }
        newSIZ.x0siz = dataInputStream.readInt();
        newSIZ.y0siz = dataInputStream.readInt();
        if (newSIZ.x0siz < 0 || newSIZ.y0siz < 0) {
            throw new IOException("JJ2000 does not support images offset not in the range: 0 -- (2^31)-1");
        }
        newSIZ.xtsiz = dataInputStream.readInt();
        newSIZ.ytsiz = dataInputStream.readInt();
        if (newSIZ.xtsiz <= 0 || newSIZ.ytsiz <= 0) {
            throw new IOException("JJ2000 does not support tiles whose width and/or height are not in  the range: 1 -- (2^31)-1");
        }
        newSIZ.xt0siz = dataInputStream.readInt();
        newSIZ.yt0siz = dataInputStream.readInt();
        if (newSIZ.xt0siz < 0 || newSIZ.yt0siz < 0) {
            throw new IOException("JJ2000 does not support tiles whose offset is not in  the range: 0 -- (2^31)-1");
        }
        int unsignedShort = dataInputStream.readUnsignedShort();
        newSIZ.csiz = unsignedShort;
        this.nComp = unsignedShort;
        if (unsignedShort < 1 || unsignedShort > 16384) {
            throw new IllegalArgumentException("Number of component out of range 1--16384: " + this.nComp);
        }
        newSIZ.ssiz = new int[unsignedShort];
        newSIZ.xrsiz = new int[this.nComp];
        newSIZ.yrsiz = new int[this.nComp];
        for (int i = 0; i < this.nComp; i++) {
            newSIZ.ssiz[i] = dataInputStream.readUnsignedByte();
            newSIZ.xrsiz[i] = dataInputStream.readUnsignedByte();
            newSIZ.yrsiz[i] = dataInputStream.readUnsignedByte();
        }
        checkMarkerLength(dataInputStream, "SIZ marker");
        this.nTiles = newSIZ.getNumTiles();
        this.decSpec = new DecoderSpecs(this.nTiles, this.nComp);
    }

    private void readCRG(DataInputStream dataInputStream) throws IOException {
        HeaderInfo.CRG newCRG = this.hi.getNewCRG();
        this.hi.crg = newCRG;
        newCRG.lcrg = dataInputStream.readUnsignedShort();
        newCRG.xcrg = new int[this.nComp];
        newCRG.ycrg = new int[this.nComp];
        FacilityManager.getMsgLogger().printmsg(2, "Information in CRG marker segment not taken into account. This may affect the display of the decoded image.");
        for (int i = 0; i < this.nComp; i++) {
            newCRG.xcrg[i] = dataInputStream.readUnsignedShort();
            newCRG.ycrg[i] = dataInputStream.readUnsignedShort();
        }
        checkMarkerLength(dataInputStream, "CRG marker");
    }

    private void readCOM(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        HeaderInfo.COM newCOM = this.hi.getNewCOM();
        newCOM.lcom = dataInputStream.readUnsignedShort();
        newCOM.rcom = dataInputStream.readUnsignedShort();
        if (newCOM.rcom == 1) {
            newCOM.ccom = new byte[newCOM.lcom - 4];
            for (int i3 = 0; i3 < newCOM.lcom - 4; i3++) {
                newCOM.ccom[i3] = dataInputStream.readByte();
            }
        } else {
            FacilityManager.getMsgLogger().printmsg(2, "COM marker registered as 0x" + Integer.toHexString(newCOM.rcom) + " unknown, ignoring (this might crash the decoder or decode a quality degraded or even useless image)");
            dataInputStream.skipBytes(newCOM.lcom + (-4));
        }
        if (z) {
            this.hi.f5com.put("main_" + i2, newCOM);
        } else {
            this.hi.f5com.put("t" + i + "_" + i2, newCOM);
        }
        checkMarkerLength(dataInputStream, "COM marker");
    }

    private void readQCD(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        int iIntValue;
        int i3;
        int i4;
        int i5;
        int i6;
        HeaderInfo.QCD newQCD = this.hi.getNewQCD();
        newQCD.lqcd = dataInputStream.readUnsignedShort();
        newQCD.sqcd = dataInputStream.readUnsignedByte();
        int numGuardBits = newQCD.getNumGuardBits();
        int quantType = newQCD.getQuantType();
        if (z) {
            this.hi.qcd.put("main", newQCD);
            if (quantType == 0) {
                this.decSpec.qts.setDefault("reversible");
            } else if (quantType == 1) {
                this.decSpec.qts.setDefault("derived");
            } else if (quantType == 2) {
                this.decSpec.qts.setDefault("expounded");
            } else {
                throw new CorruptedCodestreamException("Unknown or unsupported quantization style in Sqcd field, QCD marker main header");
            }
        } else {
            this.hi.qcd.put("t" + i, newQCD);
            if (quantType == 0) {
                this.decSpec.qts.setTileDef(i, "reversible");
            } else if (quantType == 1) {
                this.decSpec.qts.setTileDef(i, "derived");
            } else if (quantType == 2) {
                this.decSpec.qts.setTileDef(i, "expounded");
            } else {
                throw new CorruptedCodestreamException("Unknown or unsupported quantization style in Sqcd field, QCD marker, tile header");
            }
        }
        StdDequantizerParams stdDequantizerParams = new StdDequantizerParams();
        if (quantType == 0) {
            IntegerSpec integerSpec = this.decSpec.dls;
            int iIntValue2 = ((Integer) (z ? integerSpec.getDefault() : integerSpec.getTileDef(i))).intValue();
            int i7 = iIntValue2 + 1;
            int[][] iArr = new int[i7][];
            stdDequantizerParams.exp = iArr;
            newQCD.spqcd = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 4);
            for (int i8 = 0; i8 <= iIntValue2; i8++) {
                if (i8 == 0) {
                    i6 = 1;
                    i5 = 0;
                } else {
                    int i9 = iIntValue2 - i8;
                    int i10 = 1 > i9 ? 1 - i9 : 1;
                    i5 = 1 << ((i10 - 1) << 1);
                    i6 = 1 << (i10 << 1);
                }
                iArr[i8] = new int[i6];
                while (i5 < i6) {
                    int[] iArr2 = newQCD.spqcd[i8];
                    int unsignedByte = dataInputStream.readUnsignedByte();
                    iArr2[i5] = unsignedByte;
                    iArr[i8][i5] = (unsignedByte >> 3) & 31;
                    i5++;
                }
            }
        } else {
            if (quantType == 1) {
                iIntValue = 0;
            } else {
                IntegerSpec integerSpec2 = this.decSpec.dls;
                iIntValue = ((Integer) (z ? integerSpec2.getDefault() : integerSpec2.getTileDef(i))).intValue();
            }
            int i11 = iIntValue + 1;
            int[][] iArr3 = new int[i11][];
            stdDequantizerParams.exp = iArr3;
            float[][] fArr = new float[i11][];
            stdDequantizerParams.nStep = fArr;
            newQCD.spqcd = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, 4);
            for (int i12 = 0; i12 <= iIntValue; i12++) {
                if (i12 == 0) {
                    i4 = 1;
                    i3 = 0;
                } else {
                    int i13 = iIntValue - i12;
                    int i14 = 1 > i13 ? 1 - i13 : 1;
                    i3 = 1 << ((i14 - 1) << 1);
                    i4 = 1 << (i14 << 1);
                }
                iArr3[i12] = new int[i4];
                fArr[i12] = new float[i4];
                while (i3 < i4) {
                    int[] iArr4 = newQCD.spqcd[i12];
                    int unsignedShort = dataInputStream.readUnsignedShort();
                    iArr4[i3] = unsignedShort;
                    iArr3[i12][i3] = (unsignedShort >> 11) & 31;
                    fArr[i12][i3] = ((-1.0f) - ((unsignedShort & StdQuantizer.QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << r15);
                    i3++;
                }
            }
        }
        if (z) {
            this.decSpec.qsss.setDefault(stdDequantizerParams);
            this.decSpec.gbs.setDefault(new Integer(numGuardBits));
        } else {
            this.decSpec.qsss.setTileDef(i, stdDequantizerParams);
            this.decSpec.gbs.setTileDef(i, new Integer(numGuardBits));
        }
        checkMarkerLength(dataInputStream, "QCD marker");
    }

    private void readQCC(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        int unsignedShort;
        int iIntValue;
        int i3;
        int i4;
        int i5;
        int i6;
        HeaderInfo.QCC newQCC = this.hi.getNewQCC();
        newQCC.lqcc = dataInputStream.readUnsignedShort();
        if (this.nComp < 257) {
            unsignedShort = dataInputStream.readUnsignedByte();
            newQCC.cqcc = unsignedShort;
        } else {
            unsignedShort = dataInputStream.readUnsignedShort();
            newQCC.cqcc = unsignedShort;
        }
        if (unsignedShort >= this.nComp) {
            throw new CorruptedCodestreamException("Invalid component index in QCC marker");
        }
        newQCC.sqcc = dataInputStream.readUnsignedByte();
        int numGuardBits = newQCC.getNumGuardBits();
        int quantType = newQCC.getQuantType();
        if (z) {
            this.hi.qcc.put("main_c" + unsignedShort, newQCC);
            if (quantType == 0) {
                this.decSpec.qts.setCompDef(unsignedShort, "reversible");
            } else if (quantType == 1) {
                this.decSpec.qts.setCompDef(unsignedShort, "derived");
            } else if (quantType == 2) {
                this.decSpec.qts.setCompDef(unsignedShort, "expounded");
            } else {
                throw new CorruptedCodestreamException("Unknown or unsupported quantization style in Sqcd field, QCD marker, main header");
            }
        } else {
            this.hi.qcc.put("t" + i + "_c" + unsignedShort, newQCC);
            if (quantType == 0) {
                this.decSpec.qts.setTileCompVal(i, unsignedShort, "reversible");
            } else if (quantType == 1) {
                this.decSpec.qts.setTileCompVal(i, unsignedShort, "derived");
            } else if (quantType == 2) {
                this.decSpec.qts.setTileCompVal(i, unsignedShort, "expounded");
            } else {
                throw new CorruptedCodestreamException("Unknown or unsupported quantization style in Sqcd field, QCD marker, main header");
            }
        }
        StdDequantizerParams stdDequantizerParams = new StdDequantizerParams();
        if (quantType == 0) {
            IntegerSpec integerSpec = this.decSpec.dls;
            int iIntValue2 = ((Integer) (z ? integerSpec.getCompDef(unsignedShort) : integerSpec.getTileCompVal(i, unsignedShort))).intValue();
            int i7 = iIntValue2 + 1;
            int[][] iArr = new int[i7][];
            stdDequantizerParams.exp = iArr;
            newQCC.spqcc = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 4);
            for (int i8 = 0; i8 <= iIntValue2; i8++) {
                if (i8 == 0) {
                    i6 = 1;
                    i5 = 0;
                } else {
                    int i9 = iIntValue2 - i8;
                    int i10 = 1 > i9 ? 1 - i9 : 1;
                    i5 = 1 << ((i10 - 1) << 1);
                    i6 = 1 << (i10 << 1);
                }
                iArr[i8] = new int[i6];
                while (i5 < i6) {
                    int[] iArr2 = newQCC.spqcc[i8];
                    int unsignedByte = dataInputStream.readUnsignedByte();
                    iArr2[i5] = unsignedByte;
                    iArr[i8][i5] = (unsignedByte >> 3) & 31;
                    i5++;
                }
            }
        } else {
            if (quantType == 1) {
                iIntValue = 0;
            } else {
                IntegerSpec integerSpec2 = this.decSpec.dls;
                iIntValue = ((Integer) (z ? integerSpec2.getCompDef(unsignedShort) : integerSpec2.getTileCompVal(i, unsignedShort))).intValue();
            }
            int i11 = iIntValue + 1;
            float[][] fArr = new float[i11][];
            stdDequantizerParams.nStep = fArr;
            int[][] iArr3 = new int[i11][];
            stdDequantizerParams.exp = iArr3;
            newQCC.spqcc = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, 4);
            for (int i12 = 0; i12 <= iIntValue; i12++) {
                if (i12 == 0) {
                    i4 = 1;
                    i3 = 0;
                } else {
                    int i13 = iIntValue - i12;
                    int i14 = 1 > i13 ? 1 - i13 : 1;
                    i3 = 1 << ((i14 - 1) << 1);
                    i4 = 1 << (i14 << 1);
                }
                iArr3[i12] = new int[i4];
                fArr[i12] = new float[i4];
                while (i3 < i4) {
                    int[] iArr4 = newQCC.spqcc[i12];
                    int unsignedShort2 = dataInputStream.readUnsignedShort();
                    iArr4[i3] = unsignedShort2;
                    iArr3[i12][i3] = (unsignedShort2 >> 11) & 31;
                    fArr[i12][i3] = ((-1.0f) - ((unsignedShort2 & StdQuantizer.QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << r16);
                    i3++;
                }
            }
        }
        if (z) {
            this.decSpec.qsss.setCompDef(unsignedShort, stdDequantizerParams);
            this.decSpec.gbs.setCompDef(unsignedShort, new Integer(numGuardBits));
        } else {
            this.decSpec.qsss.setTileCompVal(i, unsignedShort, stdDequantizerParams);
            this.decSpec.gbs.setTileCompVal(i, unsignedShort, new Integer(numGuardBits));
        }
        checkMarkerLength(dataInputStream, "QCC marker");
    }

    private void readCOD(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        HeaderInfo.COD newCOD = this.hi.getNewCOD();
        newCOD.lcod = dataInputStream.readUnsignedShort();
        int unsignedByte = dataInputStream.readUnsignedByte();
        newCOD.scod = unsignedByte;
        if ((unsignedByte & 1) != 0) {
            this.precinctPartitionIsUsed = true;
            unsignedByte &= -2;
        } else {
            this.precinctPartitionIsUsed = false;
        }
        if (z) {
            this.hi.cod.put("main", newCOD);
            if ((unsignedByte & 2) != 0) {
                this.decSpec.sops.setDefault(new Boolean("true"));
                unsignedByte &= -3;
            } else {
                this.decSpec.sops.setDefault(new Boolean("false"));
            }
        } else {
            this.hi.cod.put("t" + i, newCOD);
            if ((unsignedByte & 2) != 0) {
                this.decSpec.sops.setTileDef(i, new Boolean("true"));
                unsignedByte &= -3;
            } else {
                this.decSpec.sops.setTileDef(i, new Boolean("false"));
            }
        }
        if (z) {
            if ((unsignedByte & 4) != 0) {
                this.decSpec.ephs.setDefault(new Boolean("true"));
                unsignedByte &= -5;
            } else {
                this.decSpec.ephs.setDefault(new Boolean("false"));
            }
        } else if ((unsignedByte & 4) != 0) {
            this.decSpec.ephs.setTileDef(i, new Boolean("true"));
            unsignedByte &= -5;
        } else {
            this.decSpec.ephs.setTileDef(i, new Boolean("false"));
        }
        if ((unsignedByte & 24) != 0) {
            FacilityManager.getMsgLogger().printmsg(2, "Code-block partition origin different from (0,0). This is defined in JPEG 2000 part 2 and may not be supported by all JPEG 2000 decoders.");
        }
        if ((unsignedByte & 8) != 0) {
            int i3 = this.cb0x;
            if (i3 != -1 && i3 == 0) {
                throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
            }
            this.cb0x = 1;
            unsignedByte &= -9;
        } else {
            int i4 = this.cb0x;
            if (i4 != -1 && i4 == 1) {
                throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
            }
            this.cb0x = 0;
        }
        if ((unsignedByte & 16) != 0) {
            int i5 = this.cb0y;
            if (i5 != -1 && i5 == 0) {
                throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
            }
            this.cb0y = 1;
        } else {
            int i6 = this.cb0y;
            if (i6 != -1 && i6 == 1) {
                throw new IllegalArgumentException("Code-block partition origin redefined in new COD marker segment. Not supported by JJ2000");
            }
            this.cb0y = 0;
        }
        newCOD.sgcod_po = dataInputStream.readUnsignedByte();
        newCOD.sgcod_nl = dataInputStream.readUnsignedShort();
        if (newCOD.sgcod_nl <= 0 || newCOD.sgcod_nl > 65535) {
            throw new CorruptedCodestreamException("Number of layers out of range: 1--65535");
        }
        newCOD.sgcod_mct = dataInputStream.readUnsignedByte();
        int unsignedByte2 = dataInputStream.readUnsignedByte();
        newCOD.spcod_ndl = unsignedByte2;
        if (unsignedByte2 > 32) {
            throw new CorruptedCodestreamException("Number of decomposition levels out of range: 0--32");
        }
        Integer[] numArr = new Integer[2];
        newCOD.spcod_cw = dataInputStream.readUnsignedByte();
        Integer num = new Integer(1 << (newCOD.spcod_cw + 2));
        numArr[0] = num;
        if (num.intValue() < 4 || numArr[0].intValue() > 1024) {
            throw new CorruptedCodestreamException("Non-valid code-block width in SPcod field, COD marker");
        }
        newCOD.spcod_ch = dataInputStream.readUnsignedByte();
        Integer num2 = new Integer(1 << (newCOD.spcod_ch + 2));
        numArr[1] = num2;
        if (num2.intValue() < 4 || numArr[1].intValue() > 1024) {
            throw new CorruptedCodestreamException("Non-valid code-block height in SPcod field, COD marker");
        }
        if (numArr[0].intValue() * numArr[1].intValue() > 4096) {
            throw new CorruptedCodestreamException("Non-valid code-block area in SPcod field, COD marker");
        }
        if (z) {
            this.decSpec.cblks.setDefault(numArr);
        } else {
            this.decSpec.cblks.setTileDef(i, numArr);
        }
        int unsignedByte3 = dataInputStream.readUnsignedByte();
        newCOD.spcod_cs = unsignedByte3;
        if ((unsignedByte3 & (-64)) != 0) {
            throw new CorruptedCodestreamException("Unknown \"code-block style\" in SPcod field, COD marker: 0x" + Integer.toHexString(unsignedByte3));
        }
        SynWTFilter filter = readFilter(dataInputStream, newCOD.spcod_t);
        SynWTFilter[][] synWTFilterArr = {new SynWTFilter[]{filter}, new SynWTFilter[]{filter}};
        Vector[] vectorArr = {new Vector(), new Vector()};
        if (!this.precinctPartitionIsUsed) {
            vectorArr[0].addElement(new Integer(32768));
            vectorArr[1].addElement(new Integer(32768));
        } else {
            newCOD.spcod_ps = new int[unsignedByte2 + 1];
            for (int i7 = unsignedByte2; i7 >= 0; i7--) {
                int unsignedByte4 = dataInputStream.readUnsignedByte();
                newCOD.spcod_ps[unsignedByte2 - i7] = unsignedByte4;
                vectorArr[0].insertElementAt(new Integer(1 << (unsignedByte4 & 15)), 0);
                vectorArr[1].insertElementAt(new Integer(1 << ((unsignedByte4 & 240) >> 4)), 0);
            }
        }
        if (z) {
            this.decSpec.pss.setDefault(vectorArr);
        } else {
            this.decSpec.pss.setTileDef(i, vectorArr);
        }
        this.precinctPartitionIsUsed = true;
        checkMarkerLength(dataInputStream, "COD marker");
        if (z) {
            this.decSpec.wfs.setDefault(synWTFilterArr);
            this.decSpec.dls.setDefault(new Integer(unsignedByte2));
            this.decSpec.ecopts.setDefault(new Integer(unsignedByte3));
            this.decSpec.cts.setDefault(new Integer(newCOD.sgcod_mct));
            this.decSpec.nls.setDefault(new Integer(newCOD.sgcod_nl));
            this.decSpec.pos.setDefault(new Integer(newCOD.sgcod_po));
            return;
        }
        this.decSpec.wfs.setTileDef(i, synWTFilterArr);
        this.decSpec.dls.setTileDef(i, new Integer(unsignedByte2));
        this.decSpec.ecopts.setTileDef(i, new Integer(unsignedByte3));
        this.decSpec.cts.setTileDef(i, new Integer(newCOD.sgcod_mct));
        this.decSpec.nls.setTileDef(i, new Integer(newCOD.sgcod_nl));
        this.decSpec.pos.setTileDef(i, new Integer(newCOD.sgcod_po));
    }

    private void readCOC(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        int unsignedShort;
        HeaderInfo.COC newCOC = this.hi.getNewCOC();
        newCOC.lcoc = dataInputStream.readUnsignedShort();
        if (this.nComp < 257) {
            unsignedShort = dataInputStream.readUnsignedByte();
            newCOC.ccoc = unsignedShort;
        } else {
            unsignedShort = dataInputStream.readUnsignedShort();
            newCOC.ccoc = unsignedShort;
        }
        if (unsignedShort >= this.nComp) {
            throw new CorruptedCodestreamException("Invalid component index in QCC marker");
        }
        int unsignedByte = dataInputStream.readUnsignedByte();
        newCOC.scoc = unsignedByte;
        if ((unsignedByte & 1) != 0) {
            this.precinctPartitionIsUsed = true;
        } else {
            this.precinctPartitionIsUsed = false;
        }
        int unsignedByte2 = dataInputStream.readUnsignedByte();
        newCOC.spcoc_ndl = unsignedByte2;
        Integer[] numArr = new Integer[2];
        newCOC.spcoc_cw = dataInputStream.readUnsignedByte();
        Integer num = new Integer(1 << (newCOC.spcoc_cw + 2));
        numArr[0] = num;
        if (num.intValue() < 4 || numArr[0].intValue() > 1024) {
            throw new CorruptedCodestreamException("Non-valid code-block width in SPcod field, COC marker");
        }
        newCOC.spcoc_ch = dataInputStream.readUnsignedByte();
        Integer num2 = new Integer(1 << (newCOC.spcoc_ch + 2));
        numArr[1] = num2;
        if (num2.intValue() < 4 || numArr[1].intValue() > 1024) {
            throw new CorruptedCodestreamException("Non-valid code-block height in SPcod field, COC marker");
        }
        if (numArr[0].intValue() * numArr[1].intValue() > 4096) {
            throw new CorruptedCodestreamException("Non-valid code-block area in SPcod field, COC marker");
        }
        if (z) {
            this.decSpec.cblks.setCompDef(unsignedShort, numArr);
        } else {
            this.decSpec.cblks.setTileCompVal(i, unsignedShort, numArr);
        }
        int unsignedByte3 = dataInputStream.readUnsignedByte();
        newCOC.spcoc_cs = unsignedByte3;
        if ((unsignedByte3 & (-64)) != 0) {
            throw new CorruptedCodestreamException("Unknown \"code-block context\" in SPcoc field, COC marker: 0x" + Integer.toHexString(unsignedByte3));
        }
        SynWTFilter filter = readFilter(dataInputStream, newCOC.spcoc_t);
        SynWTFilter[][] synWTFilterArr = {new SynWTFilter[]{filter}, new SynWTFilter[]{filter}};
        Vector[] vectorArr = {new Vector(), new Vector()};
        if (!this.precinctPartitionIsUsed) {
            vectorArr[0].addElement(new Integer(32768));
            vectorArr[1].addElement(new Integer(32768));
        } else {
            newCOC.spcoc_ps = new int[unsignedByte2 + 1];
            for (int i3 = unsignedByte2; i3 >= 0; i3--) {
                int[] iArr = newCOC.spcoc_ps;
                int unsignedByte4 = dataInputStream.readUnsignedByte();
                iArr[i3] = unsignedByte4;
                vectorArr[0].insertElementAt(new Integer(1 << (unsignedByte4 & 15)), 0);
                vectorArr[1].insertElementAt(new Integer(1 << ((unsignedByte4 & 240) >> 4)), 0);
            }
        }
        if (z) {
            this.decSpec.pss.setCompDef(unsignedShort, vectorArr);
        } else {
            this.decSpec.pss.setTileCompVal(i, unsignedShort, vectorArr);
        }
        this.precinctPartitionIsUsed = true;
        checkMarkerLength(dataInputStream, "COD marker");
        if (z) {
            this.hi.coc.put("main_c" + unsignedShort, newCOC);
            this.decSpec.wfs.setCompDef(unsignedShort, synWTFilterArr);
            this.decSpec.dls.setCompDef(unsignedShort, new Integer(unsignedByte2));
            this.decSpec.ecopts.setCompDef(unsignedShort, new Integer(unsignedByte3));
            return;
        }
        this.hi.coc.put("t" + i + "_c" + unsignedShort, newCOC);
        this.decSpec.wfs.setTileCompVal(i, unsignedShort, synWTFilterArr);
        this.decSpec.dls.setTileCompVal(i, unsignedShort, new Integer(unsignedByte2));
        this.decSpec.ecopts.setTileCompVal(i, unsignedShort, new Integer(unsignedByte3));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readPOC(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        HeaderInfo.POC newPOC;
        int length;
        boolean z2;
        int i3;
        char c;
        char c2;
        char c3;
        int[][] iArr;
        boolean z3 = this.nComp >= 256;
        if (!z) {
            if (this.hi.poc.get("t" + i) == null) {
                newPOC = this.hi.getNewPOC();
                length = 0;
            } else {
                newPOC = (HeaderInfo.POC) this.hi.poc.get("t" + i);
                length = newPOC.rspoc.length;
            }
        }
        newPOC.lpoc = dataInputStream.readUnsignedShort();
        int i4 = (newPOC.lpoc - 2) / ((z3 ? 4 : 2) + 5);
        int i5 = length + i4;
        if (length != 0) {
            iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5, 6);
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            i3 = 0;
            int[] iArr4 = new int[i5];
            c = 4;
            int[] iArr5 = new int[i5];
            c2 = 5;
            int[] iArr6 = new int[i5];
            c3 = 1;
            int[] iArr7 = new int[i5];
            int[][] iArr8 = (int[][]) this.decSpec.pcs.getTileDef(i);
            z2 = z3;
            int i6 = 0;
            while (i6 < length) {
                iArr[i6] = iArr8[i6];
                int i7 = i6;
                iArr2[i7] = newPOC.rspoc[i7];
                iArr3[i7] = newPOC.cspoc[i7];
                iArr4[i7] = newPOC.lyepoc[i7];
                iArr5[i7] = newPOC.repoc[i7];
                iArr6[i7] = newPOC.cepoc[i7];
                iArr7[i7] = newPOC.ppoc[i7];
                i6 = i7 + 1;
            }
            newPOC.rspoc = iArr2;
            newPOC.cspoc = iArr3;
            newPOC.lyepoc = iArr4;
            newPOC.repoc = iArr5;
            newPOC.cepoc = iArr6;
            newPOC.ppoc = iArr7;
        } else {
            z2 = z3;
            i3 = 0;
            c = 4;
            c2 = 5;
            c3 = 1;
            int[][] iArr9 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i4, 6);
            newPOC.rspoc = new int[i4];
            newPOC.cspoc = new int[i4];
            newPOC.lyepoc = new int[i4];
            newPOC.repoc = new int[i4];
            newPOC.cepoc = new int[i4];
            newPOC.ppoc = new int[i4];
            iArr = iArr9;
        }
        while (length < i5) {
            int[] iArr10 = iArr[length];
            int[] iArr11 = newPOC.rspoc;
            int unsignedByte = dataInputStream.readUnsignedByte();
            iArr11[length] = unsignedByte;
            iArr10[i3] = unsignedByte;
            if (z2) {
                int[] iArr12 = iArr[length];
                int[] iArr13 = newPOC.cspoc;
                int unsignedShort = dataInputStream.readUnsignedShort();
                iArr13[length] = unsignedShort;
                iArr12[c3] = unsignedShort;
            } else {
                int[] iArr14 = iArr[length];
                int[] iArr15 = newPOC.cspoc;
                int unsignedByte2 = dataInputStream.readUnsignedByte();
                iArr15[length] = unsignedByte2;
                iArr14[c3] = unsignedByte2;
            }
            int[] iArr16 = iArr[length];
            int[] iArr17 = newPOC.lyepoc;
            int unsignedShort2 = dataInputStream.readUnsignedShort();
            iArr17[length] = unsignedShort2;
            iArr16[2] = unsignedShort2;
            int[] iArr18 = iArr[length];
            if (iArr18[2] < 1) {
                throw new CorruptedCodestreamException("LYEpoc value must be greater than 1 in POC marker segment of tile " + i + ", tile-part " + i2);
            }
            int[] iArr19 = newPOC.repoc;
            int unsignedByte3 = dataInputStream.readUnsignedByte();
            iArr19[length] = unsignedByte3;
            iArr18[3] = unsignedByte3;
            int[] iArr20 = iArr[length];
            if (iArr20[3] <= iArr20[i3]) {
                throw new CorruptedCodestreamException("REpoc value must be greater than RSpoc in POC marker segment of tile " + i + ", tile-part " + i2);
            }
            if (z2) {
                int[] iArr21 = newPOC.cepoc;
                int unsignedShort3 = dataInputStream.readUnsignedShort();
                iArr21[length] = unsignedShort3;
                iArr20[c] = unsignedShort3;
            } else {
                int[] iArr22 = newPOC.cepoc;
                int unsignedByte4 = dataInputStream.readUnsignedByte();
                iArr22[length] = unsignedByte4;
                if (unsignedByte4 == 0) {
                    iArr[length][c] = i3;
                } else {
                    iArr[length][c] = unsignedByte4;
                }
            }
            int[] iArr23 = iArr[length];
            c3 = 1;
            if (iArr23[c] <= iArr23[1]) {
                throw new CorruptedCodestreamException("CEpoc value must be greater than CSpoc in POC marker segment of tile " + i + ", tile-part " + i2);
            }
            int[] iArr24 = newPOC.ppoc;
            int unsignedByte5 = dataInputStream.readUnsignedByte();
            iArr24[length] = unsignedByte5;
            iArr23[c2] = unsignedByte5;
            length++;
        }
        checkMarkerLength(dataInputStream, "POC marker");
        if (z) {
            this.hi.poc.put("main", newPOC);
            this.decSpec.pcs.setDefault(iArr);
            return;
        }
        this.hi.poc.put("t" + i, newPOC);
        this.decSpec.pcs.setTileDef(i, iArr);
    }

    private void readTLM(DataInputStream dataInputStream) throws IOException {
        dataInputStream.skipBytes(dataInputStream.readUnsignedShort() - 2);
        FacilityManager.getMsgLogger().printmsg(1, "Skipping unsupported TLM marker");
    }

    private void readPLM(DataInputStream dataInputStream) throws IOException {
        dataInputStream.skipBytes(dataInputStream.readUnsignedShort() - 2);
        FacilityManager.getMsgLogger().printmsg(1, "Skipping unsupported PLM marker");
    }

    private void readPLTFields(DataInputStream dataInputStream) throws IOException {
        dataInputStream.skipBytes(dataInputStream.readUnsignedShort() - 2);
        FacilityManager.getMsgLogger().printmsg(1, "Skipping unsupported PLT marker");
    }

    private void readRGN(DataInputStream dataInputStream, boolean z, int i, int i2) throws IOException {
        HeaderInfo.RGN newRGN = this.hi.getNewRGN();
        newRGN.lrgn = dataInputStream.readUnsignedShort();
        int unsignedByte = this.nComp < 257 ? dataInputStream.readUnsignedByte() : dataInputStream.readUnsignedShort();
        newRGN.crgn = unsignedByte;
        if (unsignedByte >= this.nComp) {
            throw new CorruptedCodestreamException("Invalid component index in RGN marker" + unsignedByte);
        }
        newRGN.srgn = dataInputStream.readUnsignedByte();
        if (newRGN.srgn != 0) {
            throw new CorruptedCodestreamException("Unknown or unsupported Srgn parameter in ROI marker");
        }
        if (this.decSpec.rois == null) {
            this.decSpec.rois = new MaxShiftSpec(this.nTiles, this.nComp, (byte) 2);
        }
        newRGN.sprgn = dataInputStream.readUnsignedByte();
        if (z) {
            this.hi.rgn.put("main_c" + unsignedByte, newRGN);
            this.decSpec.rois.setCompDef(unsignedByte, new Integer(newRGN.sprgn));
        } else {
            this.hi.rgn.put("t" + i + "_c" + unsignedByte, newRGN);
            this.decSpec.rois.setTileCompVal(i, unsignedByte, new Integer(newRGN.sprgn));
        }
        checkMarkerLength(dataInputStream, "RGN marker");
    }

    private void readPPM(DataInputStream dataInputStream) throws IOException {
        if (this.pPMMarkerData == null) {
            this.pPMMarkerData = new byte[this.nPPMMarkSeg][];
            this.tileOfTileParts = new Vector();
            this.decSpec.pphs.setDefault(new Boolean(true));
        }
        int unsignedShort = dataInputStream.readUnsignedShort() - 3;
        byte[] bArr = new byte[unsignedShort];
        this.pPMMarkerData[dataInputStream.readUnsignedByte()] = bArr;
        dataInputStream.read(bArr, 0, unsignedShort);
        checkMarkerLength(dataInputStream, "PPM marker");
    }

    private void readPPT(DataInputStream dataInputStream, int i, int i2) throws IOException {
        if (this.tilePartPkdPktHeaders == null) {
            this.tilePartPkdPktHeaders = new byte[this.nTiles][][][];
        }
        byte[][][][] bArr = this.tilePartPkdPktHeaders;
        if (bArr[i] == null) {
            bArr[i] = new byte[this.nTileParts[i]][][];
        }
        byte[][][] bArr2 = bArr[i];
        if (bArr2[i2] == null) {
            bArr2[i2] = new byte[this.nPPTMarkSeg[i][i2]][];
        }
        int unsignedShort = dataInputStream.readUnsignedShort();
        int unsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr3 = new byte[unsignedShort - 3];
        dataInputStream.read(bArr3);
        this.tilePartPkdPktHeaders[i][i2][unsignedByte] = bArr3;
        checkMarkerLength(dataInputStream, "PPT marker");
        this.decSpec.pphs.setTileDef(i, new Boolean(true));
    }

    private void extractMainMarkSeg(short s, RandomAccessIO randomAccessIO) throws IOException {
        String string;
        if (this.nfMarkSeg == 0 && s != -175) {
            throw new CorruptedCodestreamException("First marker after SOC must be SIZ " + Integer.toHexString(s));
        }
        if (this.ht == null) {
            this.ht = new Hashtable();
        }
        if (s == -171) {
            int i = this.nfMarkSeg;
            if ((i & 16) != 0) {
                throw new CorruptedCodestreamException("More than one TLM marker found in main header");
            }
            this.nfMarkSeg = i | 16;
            string = "";
        } else {
            if (s == -112) {
                int i2 = this.nfMarkSeg;
                if ((i2 & 64) != 0) {
                    throw new CorruptedCodestreamException("More than one SOT marker found right after main or tile header");
                }
                this.nfMarkSeg = i2 | 64;
                return;
            }
            if (s == -109) {
                throw new CorruptedCodestreamException("SOD found in main header");
            }
            if (s == -39) {
                throw new CorruptedCodestreamException("EOC found in main header");
            }
            if (s != -169) {
                if (s == -168) {
                    throw new CorruptedCodestreamException("PLT found in main header");
                }
                if (s == -157) {
                    int i3 = this.nfMarkSeg;
                    if ((i3 & 65536) != 0) {
                        throw new CorruptedCodestreamException("More than one CRG marker found in main header");
                    }
                    this.nfMarkSeg = i3 | 65536;
                    string = "CRG";
                } else if (s != -156) {
                    switch (s) {
                        case -175:
                            int i4 = this.nfMarkSeg;
                            if ((i4 & 1) != 0) {
                                throw new CorruptedCodestreamException("More than one SIZ marker segment found in main header");
                            }
                            this.nfMarkSeg = i4 | 1;
                            string = "SIZ";
                            break;
                        case -174:
                            int i5 = this.nfMarkSeg;
                            if ((i5 & 2) != 0) {
                                throw new CorruptedCodestreamException("More than one COD marker found in main header");
                            }
                            this.nfMarkSeg = i5 | 2;
                            string = "COD";
                            break;
                        case -173:
                            this.nfMarkSeg |= 4;
                            StringBuilder sb = new StringBuilder("COC");
                            int i6 = this.nCOCMarkSeg;
                            this.nCOCMarkSeg = i6 + 1;
                            sb.append(i6);
                            string = sb.toString();
                            break;
                        default:
                            switch (s) {
                                case -164:
                                    int i7 = this.nfMarkSeg;
                                    if ((i7 & 8) != 0) {
                                        throw new CorruptedCodestreamException("More than one QCD marker found in main header");
                                    }
                                    this.nfMarkSeg = i7 | 8;
                                    string = "QCD";
                                    break;
                                case -163:
                                    this.nfMarkSeg |= 256;
                                    StringBuilder sb2 = new StringBuilder("QCC");
                                    int i8 = this.nQCCMarkSeg;
                                    this.nQCCMarkSeg = i8 + 1;
                                    sb2.append(i8);
                                    string = sb2.toString();
                                    break;
                                case -162:
                                    this.nfMarkSeg |= 512;
                                    StringBuilder sb3 = new StringBuilder("RGN");
                                    int i9 = this.nRGNMarkSeg;
                                    this.nRGNMarkSeg = i9 + 1;
                                    sb3.append(i9);
                                    string = sb3.toString();
                                    break;
                                case -161:
                                    int i10 = this.nfMarkSeg;
                                    if ((i10 & 1024) != 0) {
                                        throw new CorruptedCodestreamException("More than one POC marker segment found in main header");
                                    }
                                    this.nfMarkSeg = i10 | 1024;
                                    string = "POC";
                                    break;
                                case -160:
                                    this.nfMarkSeg |= 16384;
                                    StringBuilder sb4 = new StringBuilder("PPM");
                                    int i11 = this.nPPMMarkSeg;
                                    this.nPPMMarkSeg = i11 + 1;
                                    sb4.append(i11);
                                    string = sb4.toString();
                                    break;
                                case -159:
                                    throw new CorruptedCodestreamException("PPT found in main header");
                                default:
                                    FacilityManager.getMsgLogger().printmsg(2, "Non recognized marker segment (0x" + Integer.toHexString(s) + ") in main header!");
                                    string = "UNKNOWN";
                                    break;
                            }
                    }
                } else {
                    this.nfMarkSeg |= 2048;
                    StringBuilder sb5 = new StringBuilder("COM");
                    int i12 = this.nCOMMarkSeg;
                    this.nCOMMarkSeg = i12 + 1;
                    sb5.append(i12);
                    string = sb5.toString();
                }
            } else {
                if ((this.nfMarkSeg & 32) != 0) {
                    throw new CorruptedCodestreamException("More than one PLM marker found in main header");
                }
                FacilityManager.getMsgLogger().printmsg(2, "PLM marker segment found but not used by by JJ2000 decoder.");
                this.nfMarkSeg |= 32;
                string = "PLM";
            }
        }
        if (s < -208 || s > -193) {
            int unsignedShort = randomAccessIO.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            bArr[0] = (byte) ((unsignedShort >> 8) & 255);
            bArr[1] = (byte) (unsignedShort & 255);
            randomAccessIO.readFully(bArr, 2, unsignedShort - 2);
            if (string.equals("UNKNOWN")) {
                return;
            }
            this.ht.put(string, bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractTilePartMarkSeg(short s, RandomAccessIO randomAccessIO, int i, int i2) throws IOException {
        String string;
        if (this.ht == null) {
            this.ht = new Hashtable();
        }
        if (s == -171) {
            throw new CorruptedCodestreamException("TLM found in tile-part header");
        }
        if (s == -112) {
            throw new CorruptedCodestreamException("Second SOT marker segment found in tile-part header");
        }
        if (s == -109) {
            this.nfMarkSeg |= 8192;
            return;
        }
        if (s == -39) {
            throw new CorruptedCodestreamException("EOC found in tile-part header");
        }
        if (s != -169) {
            if (s != -168) {
                if (s == -157) {
                    throw new CorruptedCodestreamException("CRG marker found in tile-part header");
                }
                if (s != -156) {
                    switch (s) {
                        case -175:
                            throw new CorruptedCodestreamException("SIZ found in tile-part header");
                        case -174:
                            int i3 = this.nfMarkSeg;
                            if ((i3 & 2) != 0) {
                                throw new CorruptedCodestreamException("More than one COD marker found in tile-part header");
                            }
                            this.nfMarkSeg = i3 | 2;
                            string = "COD";
                            break;
                        case -173:
                            this.nfMarkSeg |= 4;
                            StringBuilder sb = new StringBuilder("COC");
                            int i4 = this.nCOCMarkSeg;
                            this.nCOCMarkSeg = i4 + 1;
                            sb.append(i4);
                            string = sb.toString();
                            break;
                        default:
                            switch (s) {
                                case -164:
                                    int i5 = this.nfMarkSeg;
                                    if ((i5 & 8) != 0) {
                                        throw new CorruptedCodestreamException("More than one QCD marker found in tile-part header");
                                    }
                                    this.nfMarkSeg = i5 | 8;
                                    string = "QCD";
                                    break;
                                case -163:
                                    this.nfMarkSeg |= 256;
                                    StringBuilder sb2 = new StringBuilder("QCC");
                                    int i6 = this.nQCCMarkSeg;
                                    this.nQCCMarkSeg = i6 + 1;
                                    sb2.append(i6);
                                    string = sb2.toString();
                                    break;
                                case -162:
                                    this.nfMarkSeg |= 512;
                                    StringBuilder sb3 = new StringBuilder("RGN");
                                    int i7 = this.nRGNMarkSeg;
                                    this.nRGNMarkSeg = i7 + 1;
                                    sb3.append(i7);
                                    string = sb3.toString();
                                    break;
                                case -161:
                                    int i8 = this.nfMarkSeg;
                                    if ((i8 & 1024) != 0) {
                                        throw new CorruptedCodestreamException("More than one POC marker segment found in tile-part header");
                                    }
                                    this.nfMarkSeg = i8 | 1024;
                                    string = "POC";
                                    break;
                                case -160:
                                    throw new CorruptedCodestreamException("PPM found in tile-part header");
                                case -159:
                                    this.nfMarkSeg |= 32768;
                                    if (this.nPPTMarkSeg == null) {
                                        this.nPPTMarkSeg = new int[this.nTiles][];
                                    }
                                    int[][] iArr = this.nPPTMarkSeg;
                                    if (iArr[i] == null) {
                                        iArr[i] = new int[this.nTileParts[i]];
                                    }
                                    StringBuilder sb4 = new StringBuilder("PPT");
                                    int[] iArr2 = this.nPPTMarkSeg[i];
                                    int i9 = iArr2[i2];
                                    iArr2[i2] = i9 + 1;
                                    sb4.append(i9);
                                    string = sb4.toString();
                                    break;
                                default:
                                    FacilityManager.getMsgLogger().printmsg(2, "Non recognized marker segment (0x" + Integer.toHexString(s) + ") in tile-part header of tile " + i + " !");
                                    break;
                            }
                    }
                } else {
                    this.nfMarkSeg |= 2048;
                    StringBuilder sb5 = new StringBuilder("COM");
                    int i10 = this.nCOMMarkSeg;
                    this.nCOMMarkSeg = i10 + 1;
                    sb5.append(i10);
                    string = sb5.toString();
                }
                int unsignedShort = randomAccessIO.readUnsignedShort();
                byte[] bArr = new byte[unsignedShort];
                bArr[0] = (byte) ((unsignedShort >> 8) & 255);
                bArr[1] = (byte) (unsignedShort & 255);
                randomAccessIO.readFully(bArr, 2, unsignedShort - 2);
                if (string.equals("UNKNOWN")) {
                    this.ht.put(string, bArr);
                    return;
                }
                return;
            }
            if ((this.nfMarkSeg & 32) != 0) {
                throw new CorruptedCodestreamException("PLT marker found eventhough PLM marker found in main header");
            }
            FacilityManager.getMsgLogger().printmsg(2, "PLT marker segment found but not used by JJ2000 decoder.");
            string = "UNKNOWN";
            int unsignedShort2 = randomAccessIO.readUnsignedShort();
            byte[] bArr2 = new byte[unsignedShort2];
            bArr2[0] = (byte) ((unsignedShort2 >> 8) & 255);
            bArr2[1] = (byte) (unsignedShort2 & 255);
            randomAccessIO.readFully(bArr2, 2, unsignedShort2 - 2);
            if (string.equals("UNKNOWN")) {
            }
        } else {
            throw new CorruptedCodestreamException("PLM found in tile-part header");
        }
    }

    private void readFoundMainMarkSeg() throws IOException {
        if ((this.nfMarkSeg & 1) != 0) {
            readSIZ(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("SIZ"))));
        }
        if ((this.nfMarkSeg & 2048) != 0) {
            for (int i = 0; i < this.nCOMMarkSeg; i++) {
                readCOM(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("COM" + i))), true, 0, i);
            }
        }
        if ((this.nfMarkSeg & 65536) != 0) {
            readCRG(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("CRG"))));
        }
        if ((this.nfMarkSeg & 2) != 0) {
            readCOD(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("COD"))), true, 0, 0);
        }
        if ((this.nfMarkSeg & 4) != 0) {
            for (int i2 = 0; i2 < this.nCOCMarkSeg; i2++) {
                readCOC(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("COC" + i2))), true, 0, 0);
            }
        }
        if ((this.nfMarkSeg & 512) != 0) {
            for (int i3 = 0; i3 < this.nRGNMarkSeg; i3++) {
                readRGN(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("RGN" + i3))), true, 0, 0);
            }
        }
        if ((this.nfMarkSeg & 8) != 0) {
            readQCD(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("QCD"))), true, 0, 0);
        }
        if ((this.nfMarkSeg & 256) != 0) {
            for (int i4 = 0; i4 < this.nQCCMarkSeg; i4++) {
                readQCC(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("QCC" + i4))), true, 0, 0);
            }
        }
        if ((this.nfMarkSeg & 1024) != 0) {
            readPOC(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("POC"))), true, 0, 0);
        }
        if ((this.nfMarkSeg & 16384) != 0) {
            for (int i5 = 0; i5 < this.nPPMMarkSeg; i5++) {
                readPPM(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("PPM" + i5))));
            }
        }
        this.ht = null;
    }

    public void readFoundTilePartMarkSeg(int i, int i2) throws IOException {
        if ((this.nfMarkSeg & 2) != 0) {
            readCOD(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("COD"))), false, i, i2);
        }
        if ((this.nfMarkSeg & 4) != 0) {
            for (int i3 = 0; i3 < this.nCOCMarkSeg; i3++) {
                readCOC(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("COC" + i3))), false, i, i2);
            }
        }
        if ((this.nfMarkSeg & 512) != 0) {
            for (int i4 = 0; i4 < this.nRGNMarkSeg; i4++) {
                readRGN(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("RGN" + i4))), false, i, i2);
            }
        }
        if ((this.nfMarkSeg & 8) != 0) {
            readQCD(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("QCD"))), false, i, i2);
        }
        if ((this.nfMarkSeg & 256) != 0) {
            for (int i5 = 0; i5 < this.nQCCMarkSeg; i5++) {
                readQCC(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("QCC" + i5))), false, i, i2);
            }
        }
        if ((this.nfMarkSeg & 1024) != 0) {
            readPOC(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("POC"))), false, i, i2);
        }
        if ((this.nfMarkSeg & 2048) != 0) {
            for (int i6 = 0; i6 < this.nCOMMarkSeg; i6++) {
                readCOM(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("COM" + i6))), false, i, i6);
            }
        }
        if ((this.nfMarkSeg & 32768) != 0) {
            for (int i7 = 0; i7 < this.nPPTMarkSeg[i][i2]; i7++) {
                readPPT(new DataInputStream(new ByteArrayInputStream((byte[]) this.ht.get("PPT" + i7))), i, i2);
            }
        }
        this.ht = null;
    }

    public DecoderSpecs getDecoderSpecs() {
        return this.decSpec;
    }

    public HeaderDecoder(RandomAccessIO randomAccessIO, ParameterList parameterList, HeaderInfo headerInfo) throws IOException {
        this.nfMarkSeg = 0;
        this.hi = headerInfo;
        parameterList.checkList('H', ParameterList.toNameArray(pinfo));
        this.mainHeadOff = randomAccessIO.getPos();
        if (randomAccessIO.readShort() != -177) {
            throw new CorruptedCodestreamException("SOC marker segment not  found at the beginning of the codestream.");
        }
        this.nfMarkSeg = 0;
        do {
            extractMainMarkSeg(randomAccessIO.readShort(), randomAccessIO);
        } while ((this.nfMarkSeg & 64) == 0);
        randomAccessIO.seek(randomAccessIO.getPos() - 2);
        readFoundMainMarkSeg();
    }

    public EntropyDecoder createEntropyDecoder(CodedCBlkDataSrcDec codedCBlkDataSrcDec, ParameterList parameterList) {
        parameterList.checkList('C', ParameterList.toNameArray(EntropyDecoder.getParameterInfo()));
        return new StdEntropyDecoder(codedCBlkDataSrcDec, this.decSpec, parameterList.getBooleanParameter("Cer"), parameterList.getBooleanParameter("Cverber"), parameterList.getIntParameter("m_quit"));
    }

    public BlkImgDataSrc createColorSpaceMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException, ICCProfileException {
        return ColorSpaceMapper.createInstance(blkImgDataSrc, colorSpace);
    }

    public BlkImgDataSrc createChannelDefinitionMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException {
        return ChannelDefinitionMapper.createInstance(blkImgDataSrc, colorSpace);
    }

    public BlkImgDataSrc createPalettizedColorSpaceMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException {
        return PalettizedColorSpaceMapper.createInstance(blkImgDataSrc, colorSpace);
    }

    public BlkImgDataSrc createResampler(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException {
        return Resampler.createInstance(blkImgDataSrc, colorSpace);
    }

    public ROIDeScaler createROIDeScaler(CBlkQuantDataSrcDec cBlkQuantDataSrcDec, ParameterList parameterList, DecoderSpecs decoderSpecs) {
        return ROIDeScaler.createInstance(cBlkQuantDataSrcDec, parameterList, decoderSpecs);
    }

    public void resetHeaderMarkers() {
        this.nfMarkSeg &= 16416;
        this.nCOCMarkSeg = 0;
        this.nQCCMarkSeg = 0;
        this.nCOMMarkSeg = 0;
        this.nRGNMarkSeg = 0;
    }

    public String toString() {
        return this.hdStr;
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public int getNumTiles() {
        return this.nTiles;
    }

    public ByteArrayInputStream getPackedPktHead(int i) throws IOException {
        if (this.pkdPktHeaders == null) {
            int i2 = this.nTiles;
            this.pkdPktHeaders = new ByteArrayOutputStream[i2];
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                this.pkdPktHeaders[i3] = new ByteArrayOutputStream();
            }
            if (this.nPPMMarkSeg != 0) {
                int size = this.tileOfTileParts.size();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i4 = 0; i4 < this.nPPMMarkSeg; i4++) {
                    byteArrayOutputStream.write(this.pPMMarkerData[i4]);
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                for (int i5 = 0; i5 < size; i5++) {
                    int iIntValue = ((Integer) this.tileOfTileParts.elementAt(i5)).intValue();
                    byte[] bArr = new byte[(byteArrayInputStream.read() << 24) | (byteArrayInputStream.read() << 16) | (byteArrayInputStream.read() << 8) | byteArrayInputStream.read()];
                    byteArrayInputStream.read(bArr);
                    this.pkdPktHeaders[iIntValue].write(bArr);
                }
            } else {
                for (int i6 = this.nTiles - 1; i6 >= 0; i6--) {
                    for (int i7 = 0; i7 < this.nTileParts[i6]; i7++) {
                        for (int i8 = 0; i8 < this.nPPTMarkSeg[i6][i7]; i8++) {
                            this.pkdPktHeaders[i6].write(this.tilePartPkdPktHeaders[i6][i7][i8]);
                        }
                    }
                }
            }
        }
        return new ByteArrayInputStream(this.pkdPktHeaders[i].toByteArray());
    }

    public void setTileOfTileParts(int i) {
        if (this.nPPMMarkSeg != 0) {
            this.tileOfTileParts.addElement(new Integer(i));
        }
    }

    public int getNumFoundMarkSeg() {
        return this.nfMarkSeg;
    }
}
