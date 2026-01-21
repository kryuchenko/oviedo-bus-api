package jj2000.j2k.roi.encoder;

import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.wavelet.Subband;

/* loaded from: classes5.dex */
public abstract class ROIMaskGenerator {
    protected int nrc;
    protected boolean roiInTile;
    protected ROI[] rois;
    protected boolean[] tileMaskMade;

    public abstract boolean getROIMask(DataBlkInt dataBlkInt, Subband subband, int i, int i2);

    public abstract void makeMask(Subband subband, int i, int i2);

    public ROIMaskGenerator(ROI[] roiArr, int i) {
        this.rois = roiArr;
        this.nrc = i;
        this.tileMaskMade = new boolean[i];
    }

    public ROI[] getROIs() {
        return this.rois;
    }

    public void tileChanged() {
        for (int i = 0; i < this.nrc; i++) {
            this.tileMaskMade[i] = false;
        }
    }
}
