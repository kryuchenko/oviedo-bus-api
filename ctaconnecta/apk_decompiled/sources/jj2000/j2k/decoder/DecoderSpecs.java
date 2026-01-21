package jj2000.j2k.decoder;

import jj2000.j2k.IntegerSpec;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.entropy.CBlkSizeSpec;
import jj2000.j2k.entropy.PrecinctSizeSpec;
import jj2000.j2k.image.CompTransfSpec;
import jj2000.j2k.quantization.GuardBitsSpec;
import jj2000.j2k.quantization.QuantStepSizeSpec;
import jj2000.j2k.quantization.QuantTypeSpec;
import jj2000.j2k.roi.MaxShiftSpec;
import jj2000.j2k.wavelet.synthesis.SynWTFilterSpec;

/* loaded from: classes5.dex */
public class DecoderSpecs implements Cloneable {
    public CBlkSizeSpec cblks;
    public CompTransfSpec cts;
    public IntegerSpec dls;
    public ModuleSpec ecopts;
    public ModuleSpec ephs;
    public ModuleSpec ers;
    public GuardBitsSpec gbs;
    public ModuleSpec iccs;
    public IntegerSpec nls;
    public ModuleSpec pcs;
    public IntegerSpec pos;
    public ModuleSpec pphs;
    public PrecinctSizeSpec pss;
    public QuantStepSizeSpec qsss;
    public QuantTypeSpec qts;
    public MaxShiftSpec rois;
    public ModuleSpec sops;
    public SynWTFilterSpec wfs;

    public DecoderSpecs getCopy() {
        try {
            DecoderSpecs decoderSpecs = (DecoderSpecs) clone();
            decoderSpecs.qts = (QuantTypeSpec) this.qts.getCopy();
            decoderSpecs.qsss = (QuantStepSizeSpec) this.qsss.getCopy();
            decoderSpecs.gbs = (GuardBitsSpec) this.gbs.getCopy();
            decoderSpecs.wfs = (SynWTFilterSpec) this.wfs.getCopy();
            decoderSpecs.dls = (IntegerSpec) this.dls.getCopy();
            decoderSpecs.cts = (CompTransfSpec) this.cts.getCopy();
            MaxShiftSpec maxShiftSpec = this.rois;
            if (maxShiftSpec != null) {
                decoderSpecs.rois = (MaxShiftSpec) maxShiftSpec.getCopy();
            }
            return decoderSpecs;
        } catch (CloneNotSupportedException unused) {
            throw new Error("Cannot clone the DecoderSpecs instance");
        }
    }

    public DecoderSpecs(int i, int i2) {
        this.qts = new QuantTypeSpec(i, i2, (byte) 2);
        this.qsss = new QuantStepSizeSpec(i, i2, (byte) 2);
        this.gbs = new GuardBitsSpec(i, i2, (byte) 2);
        this.wfs = new SynWTFilterSpec(i, i2, (byte) 2);
        this.dls = new IntegerSpec(i, i2, (byte) 2);
        this.cts = new CompTransfSpec(i, i2, (byte) 2);
        this.ecopts = new ModuleSpec(i, i2, (byte) 2);
        this.ers = new ModuleSpec(i, i2, (byte) 2);
        this.cblks = new CBlkSizeSpec(i, i2, (byte) 2);
        this.pss = new PrecinctSizeSpec(i, i2, (byte) 2, this.dls);
        this.nls = new IntegerSpec(i, i2, (byte) 1);
        this.pos = new IntegerSpec(i, i2, (byte) 1);
        this.pcs = new ModuleSpec(i, i2, (byte) 1);
        this.sops = new ModuleSpec(i, i2, (byte) 1);
        this.ephs = new ModuleSpec(i, i2, (byte) 1);
        this.pphs = new ModuleSpec(i, i2, (byte) 1);
        this.iccs = new ModuleSpec(i, i2, (byte) 1);
        this.pphs.setDefault(new Boolean(false));
    }
}
