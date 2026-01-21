package jj2000.j2k.wavelet.synthesis;

import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public abstract class MultiResImgDataAdapter implements MultiResImgData {
    protected MultiResImgData mressrc;
    protected int tIdx = 0;

    protected MultiResImgDataAdapter(MultiResImgData multiResImgData) {
        this.mressrc = multiResImgData;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileWidth(int i) {
        return this.mressrc.getTileWidth(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileHeight(int i) {
        return this.mressrc.getTileHeight(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getNomTileWidth() {
        return this.mressrc.getNomTileWidth();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getNomTileHeight() {
        return this.mressrc.getNomTileHeight();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgWidth(int i) {
        return this.mressrc.getImgWidth(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgHeight(int i) {
        return this.mressrc.getImgHeight(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getNumComps() {
        return this.mressrc.getNumComps();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getCompSubsX(int i) {
        return this.mressrc.getCompSubsX(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getCompSubsY(int i) {
        return this.mressrc.getCompSubsY(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileCompWidth(int i, int i2, int i3) {
        return this.mressrc.getTileCompWidth(i, i2, i3);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileCompHeight(int i, int i2, int i3) {
        return this.mressrc.getTileCompHeight(i, i2, i3);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getCompImgWidth(int i, int i2) {
        return this.mressrc.getCompImgWidth(i, i2);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getCompImgHeight(int i, int i2) {
        return this.mressrc.getCompImgHeight(i, i2);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public void setTile(int i, int i2) {
        this.mressrc.setTile(i, i2);
        this.tIdx = getTileIdx();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public void nextTile() {
        this.mressrc.nextTile();
        this.tIdx = getTileIdx();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public Coord getTile(Coord coord) {
        return this.mressrc.getTile(coord);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileIdx() {
        return this.mressrc.getTileIdx();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getResULX(int i, int i2) {
        return this.mressrc.getResULX(i, i2);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getResULY(int i, int i2) {
        return this.mressrc.getResULY(i, i2);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTilePartULX() {
        return this.mressrc.getTilePartULX();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTilePartULY() {
        return this.mressrc.getTilePartULY();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgULX(int i) {
        return this.mressrc.getImgULX(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgULY(int i) {
        return this.mressrc.getImgULY(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public Coord getNumTiles(Coord coord) {
        return this.mressrc.getNumTiles(coord);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getNumTiles() {
        return this.mressrc.getNumTiles();
    }
}
