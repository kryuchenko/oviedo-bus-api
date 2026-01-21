package jj2000.j2k.roi.encoder;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.image.input.ImgReaderPGM;
import jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc;
import jj2000.j2k.quantization.quantizer.Quantizer;
import jj2000.j2k.roi.MaxShiftSpec;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.analysis.CBlkWTData;
import jj2000.j2k.wavelet.analysis.SubbandAn;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class ROIScaler extends ImgDataAdapter implements CBlkQuantDataSrcEnc {
    public static final char OPT_PREFIX = 'R';
    private static final String[][] pinfo = {new String[]{"Rroi", "[<component idx>] R <left> <top> <width> <height> or [<component idx>] C <centre column> <centre row> <radius> or [<component idx>] A <filename>", "Specifies ROIs shape and location. The shape can be either rectangular 'R', or circular 'C' or arbitrary 'A'. Each new occurrence of an 'R', a 'C' or an 'A' is a new ROI. For circular and rectangular ROIs, all values are given as their pixel values relative to the canvas origin. Arbitrary shapes must be included in a PGM file where non 0 values correspond to ROI coefficients. The PGM file must have the size as the image. The component idx specifies which components contain the ROI. The component index is specified as described by points 3 and 4 in the general comment on tile-component idx. If this option is used, the codestream is layer progressive by default unless it is overridden by the 'Aptype' option.", null}, new String[]{"Ralign", "[on|off]", "By specifying this argument, the ROI mask will be limited to covering only entire code-blocks. The ROI coding can then be performed without any actual scaling of the coefficients but by instead scaling the distortion estimates.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"Rstart_level", "<level>", "This argument forces the lowest <level> resolution levels to belong to the ROI. By doing this, it is possible to avoid only getting information for the ROI at an early stage of transmission.<level> = 0 means the lowest resolution level belongs to the ROI, 1 means the two lowest etc. (-1 deactivates the option)", "-1"}, new String[]{"Rno_rect", "[on|off]", "This argument makes sure that the ROI mask generation is not done using the fast ROI mask generation for rectangular ROIs regardless of whether the specified ROIs are rectangular or not", DebugKt.DEBUG_PROPERTY_VALUE_OFF}};
    private boolean blockAligned;
    private int[][] maxMagBits;
    private ROIMaskGenerator mg;
    private boolean roi;
    private DataBlkInt roiMask;
    private Quantizer src;
    private int useStartLevel;

    public ROIScaler(Quantizer quantizer, ROIMaskGenerator rOIMaskGenerator, boolean z, int i, boolean z2, EncoderSpecs encoderSpecs) {
        super(quantizer);
        this.src = quantizer;
        this.roi = z;
        this.useStartLevel = i;
        if (z) {
            this.mg = rOIMaskGenerator;
            this.roiMask = new DataBlkInt();
            calcMaxMagBits(encoderSpecs);
            this.blockAligned = z2;
        }
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public boolean isReversible(int i, int i2) {
        return this.src.isReversible(i, i2);
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public SubbandAn getAnSubbandTree(int i, int i2) {
        return this.src.getAnSubbandTree(i, i2);
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public int getCbULX() {
        return this.src.getCbULX();
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public int getCbULY() {
        return this.src.getCbULY();
    }

    public static ROIScaler createInstance(Quantizer quantizer, ParameterList parameterList, EncoderSpecs encoderSpecs) {
        ROIMaskGenerator arbROIMaskGenerator;
        Vector vector = new Vector();
        parameterList.checkList('R', ParameterList.toNameArray(pinfo));
        String parameter = parameterList.getParameter("Rroi");
        if (parameter == null) {
            return new ROIScaler(quantizer, null, false, -1, false, encoderSpecs);
        }
        int intParameter = parameterList.getIntParameter("Rstart_level");
        boolean booleanParameter = parameterList.getBooleanParameter("Ralign");
        boolean booleanParameter2 = parameterList.getBooleanParameter("Rno_rect");
        boolean z = !booleanParameter2;
        parseROIs(parameter, quantizer.getNumComps(), vector);
        int size = vector.size();
        ROI[] roiArr = new ROI[size];
        vector.copyInto(roiArr);
        if (!booleanParameter2) {
            int i = size - 1;
            while (true) {
                if (i < 0) {
                    break;
                }
                if (!roiArr[i].rect) {
                    z = false;
                    break;
                }
                i--;
            }
        }
        if (z) {
            arbROIMaskGenerator = new RectROIMaskGenerator(roiArr, quantizer.getNumComps());
        } else {
            arbROIMaskGenerator = new ArbROIMaskGenerator(roiArr, quantizer.getNumComps(), quantizer);
        }
        return new ROIScaler(quantizer, arbROIMaskGenerator, true, intParameter, booleanParameter, encoderSpecs);
    }

    protected static Vector parseROIs(String str, int i, Vector vector) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        boolean[] idx = null;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int i2 = 0;
            char cCharAt = strNextToken.charAt(0);
            if (cCharAt == 'A') {
                try {
                    try {
                        ImgReaderPGM imgReaderPGM = new ImgReaderPGM(stringTokenizer.nextToken());
                        if (idx != null) {
                            while (i2 < i) {
                                if (idx[i2]) {
                                    vector.addElement(new ROI(i2, imgReaderPGM));
                                }
                                i2++;
                            }
                        } else {
                            while (i2 < i) {
                                vector.addElement(new ROI(i2, imgReaderPGM));
                                i2++;
                            }
                        }
                    } catch (IOException unused) {
                        throw new Error("Cannot read PGM file with ROI");
                    }
                } catch (NoSuchElementException unused2) {
                    throw new IllegalArgumentException("Wrong number of parameters for '-Rroi A' option.");
                }
            } else if (cCharAt == 'C') {
                try {
                    int iIntValue = new Integer(stringTokenizer.nextToken()).intValue();
                    int iIntValue2 = new Integer(stringTokenizer.nextToken()).intValue();
                    int iIntValue3 = new Integer(stringTokenizer.nextToken()).intValue();
                    if (idx != null) {
                        while (i2 < i) {
                            if (idx[i2]) {
                                vector.addElement(new ROI(i2, iIntValue, iIntValue2, iIntValue3));
                            }
                            i2++;
                        }
                    } else {
                        while (i2 < i) {
                            vector.addElement(new ROI(i2, iIntValue, iIntValue2, iIntValue3));
                            i2++;
                        }
                    }
                } catch (NumberFormatException unused3) {
                    throw new IllegalArgumentException("Bad parameter for '-Rroi C' option : " + strNextToken);
                } catch (NoSuchElementException unused4) {
                    throw new IllegalArgumentException("Wrong number of parameters for '-Rroi C' option.");
                }
            } else if (cCharAt == 'R') {
                try {
                    int iIntValue4 = new Integer(stringTokenizer.nextToken()).intValue();
                    int iIntValue5 = new Integer(stringTokenizer.nextToken()).intValue();
                    int iIntValue6 = new Integer(stringTokenizer.nextToken()).intValue();
                    strNextToken = stringTokenizer.nextToken();
                    int iIntValue7 = new Integer(strNextToken).intValue();
                    if (idx != null) {
                        for (int i3 = 0; i3 < i; i3++) {
                            if (idx[i3]) {
                                vector.addElement(new ROI(i3, iIntValue4, iIntValue5, iIntValue6, iIntValue7));
                            }
                        }
                    } else {
                        for (int i4 = 0; i4 < i; i4++) {
                            vector.addElement(new ROI(i4, iIntValue4, iIntValue5, iIntValue6, iIntValue7));
                        }
                    }
                } catch (NumberFormatException unused5) {
                    throw new IllegalArgumentException("Bad parameter for '-Rroi R' option : " + strNextToken);
                } catch (NoSuchElementException unused6) {
                    throw new IllegalArgumentException("Wrong number of parameters for  h'-Rroi R' option.");
                }
            } else if (cCharAt == 'c') {
                idx = ModuleSpec.parseIdx(strNextToken, i);
            } else {
                throw new Error("Bad parameters for ROI nr " + vector.size());
            }
        }
        return vector;
    }

    @Override // jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc
    public CBlkWTData getNextCodeBlock(int i, CBlkWTData cBlkWTData) {
        return getNextInternCodeBlock(i, cBlkWTData);
    }

    @Override // jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc
    public CBlkWTData getNextInternCodeBlock(int i, CBlkWTData cBlkWTData) {
        int i2;
        DataBlkInt dataBlkInt = this.roiMask;
        CBlkWTData nextCodeBlock = this.src.getNextCodeBlock(i, cBlkWTData);
        if (this.roi && nextCodeBlock != null) {
            int[] iArr = (int[]) nextCodeBlock.getData();
            SubbandAn subbandAn = nextCodeBlock.sb;
            int i3 = nextCodeBlock.ulx;
            int i4 = nextCodeBlock.uly;
            int i5 = nextCodeBlock.w;
            int i6 = nextCodeBlock.h;
            int i7 = 0;
            boolean z = subbandAn.resLvl <= this.useStartLevel;
            int[] dataInt = dataBlkInt.getDataInt();
            if (dataInt == null || (i2 = i5 * i6) > dataInt.length) {
                dataInt = new int[i5 * i6];
                dataBlkInt.setDataInt(dataInt);
            } else {
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    dataInt[i8] = 0;
                }
            }
            dataBlkInt.ulx = i3;
            dataBlkInt.uly = i4;
            dataBlkInt.w = i5;
            dataBlkInt.h = i6;
            SubbandAn anSubbandTree = this.src.getAnSubbandTree(this.tIdx, i);
            int i9 = this.maxMagBits[this.tIdx][i];
            if (!this.mg.getROIMask(dataBlkInt, anSubbandTree, i9, i) && !z) {
                nextCodeBlock.nROIbp = 0;
                return nextCodeBlock;
            }
            nextCodeBlock.nROIbp = nextCodeBlock.magbits;
            if (z) {
                nextCodeBlock.wmseScaling *= 1 << (i9 << 1);
                nextCodeBlock.nROIcoeff = i5 * i6;
                return nextCodeBlock;
            }
            if (this.blockAligned) {
                int i10 = nextCodeBlock.scanw;
                int i11 = i6 * i5;
                int i12 = i11 - 1;
                int i13 = nextCodeBlock.offset;
                int i14 = nextCodeBlock.scanw;
                while (i6 > 0) {
                    int i15 = i5 - 1;
                    while (i15 >= 0) {
                        if (dataInt[i12] != 0) {
                            i7++;
                        }
                        i15--;
                        i12--;
                    }
                    i6--;
                }
                if (i7 != 0) {
                    nextCodeBlock.wmseScaling *= 1 << (i9 << 1);
                    nextCodeBlock.nROIcoeff = i11;
                    return nextCodeBlock;
                }
            } else {
                int i16 = ((1 << nextCodeBlock.magbits) - 1) << (31 - nextCodeBlock.magbits);
                int i17 = nextCodeBlock.scanw - i5;
                int i18 = (i6 * i5) - 1;
                int i19 = ((nextCodeBlock.offset + (nextCodeBlock.scanw * (i6 - 1))) + i5) - 1;
                while (i6 > 0) {
                    int i20 = i5;
                    while (i20 > 0) {
                        int i21 = iArr[i19];
                        if (dataInt[i18] != 0) {
                            iArr[i19] = i21 & (i16 | Integer.MIN_VALUE);
                            i7++;
                        } else {
                            iArr[i19] = ((i21 & Integer.MAX_VALUE) >> i9) | (i21 & Integer.MIN_VALUE);
                        }
                        i20--;
                        i19--;
                        i18--;
                    }
                    i19 -= i17;
                    i6--;
                }
                nextCodeBlock.magbits += i9;
                nextCodeBlock.nROIcoeff = i7;
            }
        }
        return nextCodeBlock;
    }

    public ROIMaskGenerator getROIMaskGenerator() {
        return this.mg;
    }

    public boolean getBlockAligned() {
        return this.blockAligned;
    }

    public boolean useRoi() {
        return this.roi;
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        super.setTile(i, i2);
        if (this.roi) {
            this.mg.tileChanged();
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void nextTile() {
        super.nextTile();
        if (this.roi) {
            this.mg.tileChanged();
        }
    }

    private void calcMaxMagBits(EncoderSpecs encoderSpecs) {
        MaxShiftSpec maxShiftSpec = encoderSpecs.rois;
        int numTiles = this.src.getNumTiles();
        int numComps = this.src.getNumComps();
        this.maxMagBits = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, numTiles, numComps);
        this.src.setTile(0, 0);
        for (int i = 0; i < numTiles; i++) {
            for (int i2 = numComps - 1; i2 >= 0; i2--) {
                int maxMagBits = this.src.getMaxMagBits(i2);
                this.maxMagBits[i][i2] = maxMagBits;
                maxShiftSpec.setTileCompVal(i, i2, new Integer(maxMagBits));
            }
            if (i < numTiles - 1) {
                this.src.nextTile();
            }
        }
        this.src.setTile(0, 0);
    }
}
