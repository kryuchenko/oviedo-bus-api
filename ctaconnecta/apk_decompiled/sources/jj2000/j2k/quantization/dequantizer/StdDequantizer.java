package jj2000.j2k.quantization.dequantizer;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.quantization.GuardBitsSpec;
import jj2000.j2k.quantization.QuantStepSizeSpec;
import jj2000.j2k.quantization.QuantTypeSpec;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;

/* loaded from: classes5.dex */
public class StdDequantizer extends Dequantizer {
    private GuardBitsSpec gbs;
    private DataBlkInt inblk;
    private int outdtype;
    private StdDequantizerParams params;
    private QuantStepSizeSpec qsss;
    private QuantTypeSpec qts;

    @Override // jj2000.j2k.wavelet.synthesis.CBlkWTDataSrcDec
    public int getFixedPoint(int i) {
        return 0;
    }

    public StdDequantizer(CBlkQuantDataSrcDec cBlkQuantDataSrcDec, int[] iArr, DecoderSpecs decoderSpecs) {
        super(cBlkQuantDataSrcDec, iArr, decoderSpecs);
        if (iArr.length != cBlkQuantDataSrcDec.getNumComps()) {
            throw new IllegalArgumentException("Invalid rb argument");
        }
        this.qsss = decoderSpecs.qsss;
        this.qts = decoderSpecs.qts;
        this.gbs = decoderSpecs.gbs;
    }

    @Override // jj2000.j2k.wavelet.synthesis.CBlkWTDataSrcDec
    public final DataBlk getCodeBlock(int i, int i2, int i3, SubbandSyn subbandSyn, DataBlk dataBlk) {
        return getInternCodeBlock(i, i2, i3, subbandSyn, dataBlk);
    }

    @Override // jj2000.j2k.wavelet.synthesis.CBlkWTDataSrcDec
    public final DataBlk getInternCodeBlock(int i, int i2, int i3, SubbandSyn subbandSyn, DataBlk dataBlk) {
        SubbandSyn subbandSyn2;
        DataBlk codeBlock;
        int[] iArr;
        float[] fArr;
        int i4;
        int i5;
        float f;
        int i6 = i;
        boolean zIsReversible = this.qts.isReversible(this.tIdx, i6);
        boolean zIsDerived = this.qts.isDerived(this.tIdx, i6);
        StdDequantizerParams stdDequantizerParams = (StdDequantizerParams) this.qsss.getTileCompVal(this.tIdx, i6);
        ((Integer) this.gbs.getTileCompVal(this.tIdx, i6)).intValue();
        int dataType = dataBlk.getDataType();
        this.outdtype = dataType;
        if (zIsReversible && dataType != 3) {
            throw new IllegalArgumentException("Reversible quantizations must use int data");
        }
        int[] iArr2 = null;
        if (dataType == 3) {
            i6 = i;
            subbandSyn2 = subbandSyn;
            codeBlock = this.src.getCodeBlock(i6, i2, i3, subbandSyn2, dataBlk);
            iArr = null;
            iArr2 = (int[]) codeBlock.getData();
            fArr = null;
        } else if (dataType != 4) {
            subbandSyn2 = subbandSyn;
            codeBlock = dataBlk;
            fArr = null;
            iArr = null;
        } else {
            DataBlkInt dataBlkInt = (DataBlkInt) this.src.getInternCodeBlock(i6, i2, i3, subbandSyn, this.inblk);
            this.inblk = dataBlkInt;
            int[] dataInt = dataBlkInt.getDataInt();
            DataBlk dataBlkFloat = dataBlk == null ? new DataBlkFloat() : dataBlk;
            dataBlkFloat.ulx = this.inblk.ulx;
            dataBlkFloat.uly = this.inblk.uly;
            dataBlkFloat.w = this.inblk.w;
            dataBlkFloat.h = this.inblk.h;
            dataBlkFloat.offset = 0;
            dataBlkFloat.scanw = dataBlkFloat.w;
            dataBlkFloat.progressive = this.inblk.progressive;
            fArr = (float[]) dataBlkFloat.getData();
            if (fArr == null || fArr.length < dataBlkFloat.w * dataBlkFloat.h) {
                fArr = new float[dataBlkFloat.w * dataBlkFloat.h];
                dataBlkFloat.setData(fArr);
            }
            subbandSyn2 = subbandSyn;
            iArr = dataInt;
            codeBlock = dataBlkFloat;
            i6 = i;
        }
        int i7 = subbandSyn2.magbits;
        if (zIsReversible) {
            int i8 = 31 - i7;
            for (int length = iArr2.length - 1; length >= 0; length--) {
                int i9 = iArr2[length];
                iArr2[length] = i9 >= 0 ? i9 >> i8 : -((i9 & Integer.MAX_VALUE) >> i8);
            }
        } else {
            if (zIsDerived) {
                i4 = Integer.MAX_VALUE;
                i5 = 1;
                f = stdDequantizerParams.nStep[0][0] * (1 << (((this.rb[i6] + subbandSyn2.anGainExp) + this.src.getSynSubbandTree(getTileIdx(), i6).resLvl) - subbandSyn2.level));
            } else {
                i4 = Integer.MAX_VALUE;
                i5 = 1;
                f = stdDequantizerParams.nStep[subbandSyn2.resLvl][subbandSyn2.sbandIdx] * (1 << (this.rb[i6] + subbandSyn2.anGainExp));
            }
            float f2 = f / (i5 << (31 - i7));
            int i10 = this.outdtype;
            if (i10 == 3) {
                for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
                    int i11 = iArr2[length2];
                    if (i11 < 0) {
                        i11 = -(i11 & i4);
                    }
                    iArr2[length2] = (int) (i11 * f2);
                }
            } else if (i10 == 4) {
                int i12 = codeBlock.w;
                int i13 = codeBlock.h;
                int i14 = (i12 * i13) - 1;
                int i15 = i13 - 1;
                int i16 = ((this.inblk.offset + (this.inblk.scanw * i15)) + i12) - 1;
                int i17 = i15 * i12;
                while (i14 >= 0) {
                    while (i14 >= i17) {
                        int i18 = iArr[i16];
                        if (i18 < 0) {
                            i18 = -(i18 & i4);
                        }
                        fArr[i14] = i18 * f2;
                        i16--;
                        i14--;
                    }
                    i16 -= this.inblk.scanw - i12;
                    i17 -= i12;
                }
            }
        }
        return codeBlock;
    }
}
