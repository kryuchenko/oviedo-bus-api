package jj2000.j2k.quantization.quantizer;

import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.quantization.GuardBitsSpec;
import jj2000.j2k.quantization.QuantStepSizeSpec;
import jj2000.j2k.quantization.QuantTypeSpec;
import jj2000.j2k.wavelet.Subband;
import jj2000.j2k.wavelet.analysis.CBlkWTData;
import jj2000.j2k.wavelet.analysis.CBlkWTDataFloat;
import jj2000.j2k.wavelet.analysis.CBlkWTDataInt;
import jj2000.j2k.wavelet.analysis.CBlkWTDataSrc;
import jj2000.j2k.wavelet.analysis.SubbandAn;

/* loaded from: classes5.dex */
public class StdQuantizer extends Quantizer {
    public static final int QSTEP_EXPONENT_BITS = 5;
    public static final int QSTEP_MANTISSA_BITS = 11;
    public static final int QSTEP_MAX_EXPONENT = 31;
    public static final int QSTEP_MAX_MANTISSA = 2047;
    private static double log2 = Math.log(2.0d);
    private GuardBitsSpec gbs;
    private CBlkWTDataFloat infblk;
    private QuantStepSizeSpec qsss;
    private QuantTypeSpec qts;

    private static float convertFromExpMantissa(int i) {
        return ((-1.0f) - ((i & QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << ((i >> 11) & 31));
    }

    public StdQuantizer(CBlkWTDataSrc cBlkWTDataSrc, EncoderSpecs encoderSpecs) {
        super(cBlkWTDataSrc);
        this.qts = encoderSpecs.qts;
        this.qsss = encoderSpecs.qsss;
        this.gbs = encoderSpecs.gbs;
    }

    public QuantTypeSpec getQuantTypeSpec() {
        return this.qts;
    }

    @Override // jj2000.j2k.quantization.quantizer.Quantizer
    public int getNumGuardBits(int i, int i2) {
        return ((Integer) this.gbs.getTileCompVal(i, i2)).intValue();
    }

    @Override // jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public boolean isReversible(int i, int i2) {
        return this.qts.isReversible(i, i2);
    }

    @Override // jj2000.j2k.quantization.quantizer.Quantizer
    public boolean isDerived(int i, int i2) {
        return this.qts.isDerived(i, i2);
    }

    @Override // jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc
    public CBlkWTData getNextCodeBlock(int i, CBlkWTData cBlkWTData) {
        return getNextInternCodeBlock(i, cBlkWTData);
    }

    @Override // jj2000.j2k.quantization.quantizer.CBlkQuantDataSrcEnc
    public final CBlkWTData getNextInternCodeBlock(int i, CBlkWTData cBlkWTData) {
        int[] iArr;
        float f;
        int iIntValue = ((Integer) this.gbs.getTileCompVal(this.tIdx, i)).intValue();
        boolean z = this.src.getDataType(this.tIdx, i) == 3;
        CBlkWTData cBlkWTDataInt = cBlkWTData == null ? new CBlkWTDataInt() : cBlkWTData;
        CBlkWTDataFloat cBlkWTDataFloat = this.infblk;
        float[] fArr = null;
        if (z) {
            cBlkWTDataInt = this.src.getNextCodeBlock(i, cBlkWTDataInt);
            if (cBlkWTDataInt == null) {
                return null;
            }
            iArr = (int[]) cBlkWTDataInt.getData();
        } else {
            cBlkWTDataFloat = (CBlkWTDataFloat) this.src.getNextInternCodeBlock(i, cBlkWTDataFloat);
            if (cBlkWTDataFloat == null) {
                this.infblk.setData(null);
                return null;
            }
            this.infblk = cBlkWTDataFloat;
            fArr = (float[]) cBlkWTDataFloat.getData();
            int[] iArr2 = (int[]) cBlkWTDataInt.getData();
            if (iArr2 == null || iArr2.length < cBlkWTDataFloat.w * cBlkWTDataFloat.h) {
                iArr2 = new int[cBlkWTDataFloat.w * cBlkWTDataFloat.h];
                cBlkWTDataInt.setData(iArr2);
            }
            cBlkWTDataInt.m = cBlkWTDataFloat.m;
            cBlkWTDataInt.n = cBlkWTDataFloat.n;
            cBlkWTDataInt.sb = cBlkWTDataFloat.sb;
            cBlkWTDataInt.ulx = cBlkWTDataFloat.ulx;
            cBlkWTDataInt.uly = cBlkWTDataFloat.uly;
            cBlkWTDataInt.w = cBlkWTDataFloat.w;
            cBlkWTDataInt.h = cBlkWTDataFloat.h;
            cBlkWTDataInt.wmseScaling = cBlkWTDataFloat.wmseScaling;
            cBlkWTDataInt.offset = 0;
            cBlkWTDataInt.scanw = cBlkWTDataInt.w;
            iArr = iArr2;
        }
        int i2 = cBlkWTDataInt.w;
        int i3 = cBlkWTDataInt.h;
        SubbandAn subbandAn = cBlkWTDataInt.sb;
        if (isReversible(this.tIdx, i)) {
            cBlkWTDataInt.magbits = (iIntValue - 1) + this.src.getNomRangeBits(i) + subbandAn.anGainExp;
            int i4 = 31 - cBlkWTDataInt.magbits;
            cBlkWTDataInt.convertFactor = 1 << i4;
            for (int i5 = (i2 * i3) - 1; i5 >= 0; i5--) {
                int i6 = iArr[i5] << i4;
                if (i6 < 0) {
                    i6 = (-i6) | Integer.MIN_VALUE;
                }
                iArr[i5] = i6;
            }
        } else {
            float fFloatValue = ((Float) this.qsss.getTileCompVal(this.tIdx, i)).floatValue();
            if (isDerived(this.tIdx, i)) {
                cBlkWTDataInt.magbits = ((iIntValue - 1) + subbandAn.level) - ((int) Math.floor(Math.log(fFloatValue) / log2));
                f = 1 << subbandAn.level;
            } else {
                cBlkWTDataInt.magbits = (iIntValue - 1) - ((int) Math.floor(Math.log(fFloatValue / (subbandAn.l2Norm * (1 << subbandAn.anGainExp))) / log2));
                f = subbandAn.l2Norm * (1 << subbandAn.anGainExp);
            }
            float f2 = fFloatValue / f;
            int i7 = 31 - cBlkWTDataInt.magbits;
            float nomRangeBits = (1.0f / ((1 << (this.src.getNomRangeBits(i) + subbandAn.anGainExp)) * convertFromExpMantissa(convertToExpMantissa(f2)))) * (1 << (i7 - this.src.getFixedPoint(i)));
            CBlkWTDataFloat cBlkWTDataFloat2 = cBlkWTDataFloat;
            cBlkWTDataInt.convertFactor = nomRangeBits;
            cBlkWTDataInt.stepSize = (1 << (this.src.getNomRangeBits(i) + subbandAn.anGainExp)) * r12;
            if (z) {
                for (int i8 = (i2 * i3) - 1; i8 >= 0; i8--) {
                    int i9 = (int) (iArr[i8] * nomRangeBits);
                    if (i9 < 0) {
                        i9 = (-i9) | Integer.MIN_VALUE;
                    }
                    iArr[i8] = i9;
                }
            } else {
                int i10 = (i2 * i3) - 1;
                int i11 = i3 - 1;
                int i12 = ((cBlkWTDataFloat2.offset + (cBlkWTDataFloat2.scanw * i11)) + i2) - 1;
                int i13 = i11 * i2;
                while (i10 >= 0) {
                    while (i10 >= i13) {
                        int i14 = (int) (fArr[i12] * nomRangeBits);
                        if (i14 < 0) {
                            i14 = (-i14) | Integer.MIN_VALUE;
                        }
                        iArr[i10] = i14;
                        i12--;
                        i10--;
                    }
                    i12 -= cBlkWTDataFloat2.scanw - i2;
                    i13 -= i2;
                }
            }
        }
        return cBlkWTDataInt;
    }

    @Override // jj2000.j2k.quantization.quantizer.Quantizer
    protected void calcSbParams(SubbandAn subbandAn, int i) {
        if (subbandAn.stepWMSE > 0.0f) {
            return;
        }
        if (!subbandAn.isNode) {
            if (isReversible(this.tIdx, i)) {
                subbandAn.stepWMSE = ((float) Math.pow(2.0d, -(this.src.getNomRangeBits(i) << 1))) * subbandAn.l2Norm * subbandAn.l2Norm;
                return;
            }
            float fFloatValue = ((Float) this.qsss.getTileCompVal(this.tIdx, i)).floatValue();
            if (isDerived(this.tIdx, i)) {
                subbandAn.stepWMSE = fFloatValue * fFloatValue * ((float) Math.pow(2.0d, (subbandAn.anGainExp - subbandAn.level) << 1)) * subbandAn.l2Norm * subbandAn.l2Norm;
                return;
            } else {
                subbandAn.stepWMSE = fFloatValue * fFloatValue;
                return;
            }
        }
        calcSbParams((SubbandAn) subbandAn.getLL(), i);
        calcSbParams((SubbandAn) subbandAn.getHL(), i);
        calcSbParams((SubbandAn) subbandAn.getLH(), i);
        calcSbParams((SubbandAn) subbandAn.getHH(), i);
        subbandAn.stepWMSE = 1.0f;
    }

    public static int convertToExpMantissa(float f) {
        int iCeil = (int) Math.ceil((-Math.log(f)) / log2);
        if (iCeil > 31) {
            return 63488;
        }
        return ((int) (((((-f) * ((-1) << iCeil)) - 1.0f) * 2048.0f) + 0.5f)) | (iCeil << 11);
    }

    @Override // jj2000.j2k.quantization.quantizer.Quantizer
    public int getMaxMagBits(int i) {
        SubbandAn anSubbandTree = getAnSubbandTree(this.tIdx, i);
        if (isReversible(this.tIdx, i)) {
            return getMaxMagBitsRev(anSubbandTree, i);
        }
        if (isDerived(this.tIdx, i)) {
            return getMaxMagBitsDerived(anSubbandTree, this.tIdx, i);
        }
        return getMaxMagBitsExpounded(anSubbandTree, this.tIdx, i);
    }

    private int getMaxMagBitsRev(Subband subband, int i) {
        int iIntValue = ((Integer) this.gbs.getTileCompVal(this.tIdx, i)).intValue();
        if (!subband.isNode) {
            return (iIntValue - 1) + this.src.getNomRangeBits(i) + subband.anGainExp;
        }
        int maxMagBitsRev = getMaxMagBitsRev(subband.getLL(), i);
        int maxMagBitsRev2 = getMaxMagBitsRev(subband.getLH(), i);
        if (maxMagBitsRev2 > maxMagBitsRev) {
            maxMagBitsRev = maxMagBitsRev2;
        }
        int maxMagBitsRev3 = getMaxMagBitsRev(subband.getHL(), i);
        if (maxMagBitsRev3 > maxMagBitsRev) {
            maxMagBitsRev = maxMagBitsRev3;
        }
        int maxMagBitsRev4 = getMaxMagBitsRev(subband.getHH(), i);
        return maxMagBitsRev4 > maxMagBitsRev ? maxMagBitsRev4 : maxMagBitsRev;
    }

    private int getMaxMagBitsDerived(Subband subband, int i, int i2) {
        int iIntValue = ((Integer) this.gbs.getTileCompVal(i, i2)).intValue();
        if (!subband.isNode) {
            return ((iIntValue - 1) + subband.level) - ((int) Math.floor(Math.log(((Float) this.qsss.getTileCompVal(i, i2)).floatValue()) / log2));
        }
        int maxMagBitsDerived = getMaxMagBitsDerived(subband.getLL(), i, i2);
        int maxMagBitsDerived2 = getMaxMagBitsDerived(subband.getLH(), i, i2);
        if (maxMagBitsDerived2 > maxMagBitsDerived) {
            maxMagBitsDerived = maxMagBitsDerived2;
        }
        int maxMagBitsDerived3 = getMaxMagBitsDerived(subband.getHL(), i, i2);
        if (maxMagBitsDerived3 > maxMagBitsDerived) {
            maxMagBitsDerived = maxMagBitsDerived3;
        }
        int maxMagBitsDerived4 = getMaxMagBitsDerived(subband.getHH(), i, i2);
        return maxMagBitsDerived4 > maxMagBitsDerived ? maxMagBitsDerived4 : maxMagBitsDerived;
    }

    private int getMaxMagBitsExpounded(Subband subband, int i, int i2) {
        int iIntValue = ((Integer) this.gbs.getTileCompVal(i, i2)).intValue();
        if (!subband.isNode) {
            return (iIntValue - 1) - ((int) Math.floor(Math.log(((Float) this.qsss.getTileCompVal(i, i2)).floatValue() / (((SubbandAn) subband).l2Norm * (1 << subband.anGainExp))) / log2));
        }
        int maxMagBitsExpounded = getMaxMagBitsExpounded(subband.getLL(), i, i2);
        int maxMagBitsExpounded2 = getMaxMagBitsExpounded(subband.getLH(), i, i2);
        if (maxMagBitsExpounded2 > maxMagBitsExpounded) {
            maxMagBitsExpounded = maxMagBitsExpounded2;
        }
        int maxMagBitsExpounded3 = getMaxMagBitsExpounded(subband.getHL(), i, i2);
        if (maxMagBitsExpounded3 > maxMagBitsExpounded) {
            maxMagBitsExpounded = maxMagBitsExpounded3;
        }
        int maxMagBitsExpounded4 = getMaxMagBitsExpounded(subband.getHH(), i, i2);
        return maxMagBitsExpounded4 > maxMagBitsExpounded ? maxMagBitsExpounded4 : maxMagBitsExpounded;
    }
}
