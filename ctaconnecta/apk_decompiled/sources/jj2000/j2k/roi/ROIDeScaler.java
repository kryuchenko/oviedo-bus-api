package jj2000.j2k.roi;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.synthesis.MultiResImgDataAdapter;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;

/* loaded from: classes5.dex */
public class ROIDeScaler extends MultiResImgDataAdapter implements CBlkQuantDataSrcDec {
    public static final char OPT_PREFIX = 'R';
    private static final String[][] pinfo = {new String[]{"Rno_roi", null, "This argument makes sure that the no ROI de-scaling is performed. Decompression is done like there is no ROI in the image", null}};
    private MaxShiftSpec mss;
    private CBlkQuantDataSrcDec src;

    public ROIDeScaler(CBlkQuantDataSrcDec cBlkQuantDataSrcDec, MaxShiftSpec maxShiftSpec) {
        super(cBlkQuantDataSrcDec);
        this.src = cBlkQuantDataSrcDec;
        this.mss = maxShiftSpec;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public SubbandSyn getSynSubbandTree(int i, int i2) {
        return this.src.getSynSubbandTree(i, i2);
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData
    public int getCbULX() {
        return this.src.getCbULX();
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData
    public int getCbULY() {
        return this.src.getCbULY();
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    @Override // jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec
    public DataBlk getCodeBlock(int i, int i2, int i3, SubbandSyn subbandSyn, DataBlk dataBlk) {
        return getInternCodeBlock(i, i2, i3, subbandSyn, dataBlk);
    }

    @Override // jj2000.j2k.quantization.dequantizer.CBlkQuantDataSrcDec
    public DataBlk getInternCodeBlock(int i, int i2, int i3, SubbandSyn subbandSyn, DataBlk dataBlk) {
        DataBlk internCodeBlock = this.src.getInternCodeBlock(i, i2, i3, subbandSyn, dataBlk);
        MaxShiftSpec maxShiftSpec = this.mss;
        if (maxShiftSpec != null && maxShiftSpec.getTileCompVal(getTileIdx(), i) != null && internCodeBlock != null) {
            int[] iArr = (int[]) internCodeBlock.getData();
            int i4 = internCodeBlock.ulx;
            int i5 = internCodeBlock.uly;
            int i6 = internCodeBlock.w;
            int i7 = internCodeBlock.h;
            int iIntValue = ((Integer) this.mss.getTileCompVal(getTileIdx(), i)).intValue();
            int i8 = ((1 << subbandSyn.magbits) - 1) << (31 - subbandSyn.magbits);
            int i9 = (~i8) & Integer.MAX_VALUE;
            int i10 = internCodeBlock.scanw - i6;
            int i11 = ((internCodeBlock.offset + (internCodeBlock.scanw * (i7 - 1))) + i6) - 1;
            while (i7 > 0) {
                int i12 = i6;
                while (i12 > 0) {
                    int i13 = iArr[i11];
                    if ((i13 & i8) == 0) {
                        iArr[i11] = (i13 << iIntValue) | (Integer.MIN_VALUE & i13);
                    } else if ((i13 & i9) != 0) {
                        iArr[i11] = (i13 & (~i9)) | (1 << (30 - subbandSyn.magbits));
                    }
                    i12--;
                    i11--;
                }
                i11 -= i10;
                i7--;
            }
        }
        return internCodeBlock;
    }

    public static ROIDeScaler createInstance(CBlkQuantDataSrcDec cBlkQuantDataSrcDec, ParameterList parameterList, DecoderSpecs decoderSpecs) {
        parameterList.checkList('R', ParameterList.toNameArray(pinfo));
        if (parameterList.getParameter("Rno_roi") != null || decoderSpecs.rois == null) {
            return new ROIDeScaler(cBlkQuantDataSrcDec, null);
        }
        return new ROIDeScaler(cBlkQuantDataSrcDec, decoderSpecs.rois);
    }
}
