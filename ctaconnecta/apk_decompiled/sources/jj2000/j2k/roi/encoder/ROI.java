package jj2000.j2k.roi.encoder;

import jj2000.j2k.image.input.ImgReaderPGM;

/* loaded from: classes5.dex */
public class ROI {
    public boolean arbShape;
    public int comp;
    public int h;
    public ImgReaderPGM maskPGM;
    public int r;
    public boolean rect;
    public int ulx;
    public int uly;
    public int w;
    public int x;
    public int y;

    public ROI(int i, ImgReaderPGM imgReaderPGM) {
        this.arbShape = true;
        this.rect = false;
        this.comp = i;
        this.maskPGM = imgReaderPGM;
    }

    public ROI(int i, int i2, int i3, int i4, int i5) {
        this.maskPGM = null;
        this.arbShape = false;
        this.comp = i;
        this.ulx = i2;
        this.uly = i3;
        this.w = i4;
        this.h = i5;
        this.rect = true;
    }

    public ROI(int i, int i2, int i3, int i4) {
        this.maskPGM = null;
        this.arbShape = false;
        this.comp = i;
        this.x = i2;
        this.y = i3;
        this.r = i4;
    }

    public String toString() {
        if (this.arbShape) {
            return "ROI with arbitrary shape, PGM file= " + this.maskPGM;
        }
        if (this.rect) {
            return "Rectangular ROI, comp=" + this.comp + " ulx=" + this.ulx + " uly=" + this.uly + " w=" + this.w + " h=" + this.h;
        }
        return "Circular ROI,  comp=" + this.comp + " x=" + this.x + " y=" + this.y + " radius=" + this.r;
    }
}
