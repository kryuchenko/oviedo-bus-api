package jj2000.j2k.encoder;

import jj2000.j2k.IntegerSpec;
import jj2000.j2k.StringSpec;
import jj2000.j2k.entropy.CBlkSizeSpec;
import jj2000.j2k.entropy.PrecinctSizeSpec;
import jj2000.j2k.entropy.ProgressionSpec;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.CompTransfSpec;
import jj2000.j2k.image.forwcomptransf.ForwCompTransfSpec;
import jj2000.j2k.quantization.GuardBitsSpec;
import jj2000.j2k.quantization.QuantStepSizeSpec;
import jj2000.j2k.quantization.QuantTypeSpec;
import jj2000.j2k.quantization.quantizer.Quantizer;
import jj2000.j2k.roi.MaxShiftSpec;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.analysis.AnWTFilterSpec;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class EncoderSpecs {
    public StringSpec bms;
    public CBlkSizeSpec cblks;
    public StringSpec css;
    public CompTransfSpec cts;
    public IntegerSpec dls;
    public StringSpec ephs;
    public GuardBitsSpec gbs;
    public StringSpec lcs;
    public StringSpec mqrs;
    public int nComp;
    public int nTiles;
    public ProgressionSpec pocs;
    public PrecinctSizeSpec pss;
    public QuantStepSizeSpec qsss;
    public QuantTypeSpec qts;
    public MaxShiftSpec rois;
    public StringSpec rts;
    public StringSpec sops;
    public StringSpec sss;
    public StringSpec tts;
    public AnWTFilterSpec wfs;

    public EncoderSpecs(int i, int i2, BlkImgDataSrc blkImgDataSrc, ParameterList parameterList) {
        this.nTiles = i;
        this.nComp = i2;
        this.rois = new MaxShiftSpec(i, i2, (byte) 2);
        parameterList.checkList('Q', ParameterList.toNameArray(Quantizer.getParameterInfo()));
        this.qts = new QuantTypeSpec(i, i2, (byte) 2, parameterList);
        this.qsss = new QuantStepSizeSpec(i, i2, (byte) 2, parameterList);
        this.gbs = new GuardBitsSpec(i, i2, (byte) 2, parameterList);
        this.wfs = new AnWTFilterSpec(i, i2, (byte) 2, this.qts, parameterList);
        this.dls = new IntegerSpec(i, i2, (byte) 2, parameterList, "Wlev");
        this.cts = new ForwCompTransfSpec(i, i2, (byte) 1, this.wfs, parameterList);
        this.lcs = new StringSpec(i, i2, (byte) 2, "Clen_calc", new String[]{"near_opt", "lazy_good", "lazy"}, parameterList);
        this.tts = new StringSpec(i, i2, (byte) 2, "Cterm_type", new String[]{"near_opt", "easy", "predict", "full"}, parameterList);
        String[] strArr = {DebugKt.DEBUG_PROPERTY_VALUE_ON, DebugKt.DEBUG_PROPERTY_VALUE_OFF};
        this.sss = new StringSpec(i, i2, (byte) 2, "Cseg_symbol", strArr, parameterList);
        this.css = new StringSpec(i, i2, (byte) 2, "Ccausal", strArr, parameterList);
        this.rts = new StringSpec(i, i2, (byte) 2, "Cterminate", strArr, parameterList);
        this.mqrs = new StringSpec(i, i2, (byte) 2, "CresetMQ", strArr, parameterList);
        this.bms = new StringSpec(i, i2, (byte) 2, "Cbypass", strArr, parameterList);
        this.cblks = new CBlkSizeSpec(i, i2, (byte) 2, parameterList);
        this.pss = new PrecinctSizeSpec(i, i2, (byte) 2, blkImgDataSrc, this.dls, parameterList);
        this.sops = new StringSpec(i, i2, (byte) 1, "Psop", strArr, parameterList);
        this.ephs = new StringSpec(i, i2, (byte) 1, "Peph", strArr, parameterList);
    }
}
