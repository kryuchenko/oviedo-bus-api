package jj2000.j2k.wavelet.synthesis;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public abstract class InvWTAdapter implements InvWT {
    protected DecoderSpecs decSpec;
    protected int maxImgRes;
    protected MultiResImgData mressrc;
    protected int reslvl;

    protected InvWTAdapter(MultiResImgData multiResImgData, DecoderSpecs decoderSpecs) {
        this.mressrc = multiResImgData;
        this.decSpec = decoderSpecs;
        this.maxImgRes = decoderSpecs.dls.getMin();
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWT
    public void setImgResLevel(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Resolution level index cannot be negative.");
        }
        this.reslvl = i;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileWidth() {
        int tileIdx = getTileIdx();
        int numComps = this.mressrc.getNumComps();
        int i = 10000;
        for (int i2 = 0; i2 < numComps; i2++) {
            int i3 = this.mressrc.getSynSubbandTree(tileIdx, i2).resLvl;
            if (i3 < i) {
                i = i3;
            }
        }
        return this.mressrc.getTileWidth(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileHeight() {
        int tileIdx = getTileIdx();
        int numComps = this.mressrc.getNumComps();
        int i = 10000;
        for (int i2 = 0; i2 < numComps; i2++) {
            int i3 = this.mressrc.getSynSubbandTree(tileIdx, i2).resLvl;
            if (i3 < i) {
                i = i3;
            }
        }
        return this.mressrc.getTileHeight(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomTileWidth() {
        return this.mressrc.getNomTileWidth();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomTileHeight() {
        return this.mressrc.getNomTileHeight();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgWidth() {
        return this.mressrc.getImgWidth(this.reslvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgHeight() {
        return this.mressrc.getImgHeight(this.reslvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNumComps() {
        return this.mressrc.getNumComps();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsX(int i) {
        return this.mressrc.getCompSubsX(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return this.mressrc.getCompSubsY(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        return this.mressrc.getTileCompWidth(i, i2, this.mressrc.getSynSubbandTree(i, i2).resLvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        return this.mressrc.getTileCompHeight(i, i2, this.mressrc.getSynSubbandTree(i, i2).resLvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.mressrc.getCompImgWidth(i, this.decSpec.dls.getMinInComp(i));
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.mressrc.getCompImgHeight(i, this.decSpec.dls.getMinInComp(i));
    }

    @Override // jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        this.mressrc.setTile(i, i2);
    }

    @Override // jj2000.j2k.image.ImgData
    public void nextTile() {
        this.mressrc.nextTile();
    }

    @Override // jj2000.j2k.image.ImgData
    public Coord getTile(Coord coord) {
        return this.mressrc.getTile(coord);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileIdx() {
        return this.mressrc.getTileIdx();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompULX(int i) {
        return this.mressrc.getResULX(i, this.mressrc.getSynSubbandTree(getTileIdx(), i).resLvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompULY(int i) {
        return this.mressrc.getResULY(i, this.mressrc.getSynSubbandTree(getTileIdx(), i).resLvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgULX() {
        return this.mressrc.getImgULX(this.reslvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgULY() {
        return this.mressrc.getImgULY(this.reslvl);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTilePartULX() {
        return this.mressrc.getTilePartULX();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTilePartULY() {
        return this.mressrc.getTilePartULY();
    }

    @Override // jj2000.j2k.image.ImgData
    public Coord getNumTiles(Coord coord) {
        return this.mressrc.getNumTiles(coord);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNumTiles() {
        return this.mressrc.getNumTiles();
    }

    public SubbandSyn getSynSubbandTree(int i, int i2) {
        return this.mressrc.getSynSubbandTree(i, i2);
    }
}
