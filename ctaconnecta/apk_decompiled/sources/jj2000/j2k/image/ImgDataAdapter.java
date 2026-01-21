package jj2000.j2k.image;

/* loaded from: classes5.dex */
public abstract class ImgDataAdapter implements ImgData {
    protected ImgData imgdatasrc;
    protected int tIdx = 0;

    protected ImgDataAdapter(ImgData imgData) {
        this.imgdatasrc = imgData;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileWidth() {
        return this.imgdatasrc.getTileWidth();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileHeight() {
        return this.imgdatasrc.getTileHeight();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomTileWidth() {
        return this.imgdatasrc.getNomTileWidth();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomTileHeight() {
        return this.imgdatasrc.getNomTileHeight();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgWidth() {
        return this.imgdatasrc.getImgWidth();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgHeight() {
        return this.imgdatasrc.getImgHeight();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNumComps() {
        return this.imgdatasrc.getNumComps();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsX(int i) {
        return this.imgdatasrc.getCompSubsX(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return this.imgdatasrc.getCompSubsY(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        return this.imgdatasrc.getTileCompWidth(i, i2);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        return this.imgdatasrc.getTileCompHeight(i, i2);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.imgdatasrc.getCompImgWidth(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.imgdatasrc.getCompImgHeight(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        return this.imgdatasrc.getNomRangeBits(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        this.imgdatasrc.setTile(i, i2);
        this.tIdx = getTileIdx();
    }

    @Override // jj2000.j2k.image.ImgData
    public void nextTile() {
        this.imgdatasrc.nextTile();
        this.tIdx = getTileIdx();
    }

    @Override // jj2000.j2k.image.ImgData
    public Coord getTile(Coord coord) {
        return this.imgdatasrc.getTile(coord);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileIdx() {
        return this.imgdatasrc.getTileIdx();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompULX(int i) {
        return this.imgdatasrc.getCompULX(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompULY(int i) {
        return this.imgdatasrc.getCompULY(i);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTilePartULX() {
        return this.imgdatasrc.getTilePartULX();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTilePartULY() {
        return this.imgdatasrc.getTilePartULY();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgULX() {
        return this.imgdatasrc.getImgULX();
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgULY() {
        return this.imgdatasrc.getImgULY();
    }

    @Override // jj2000.j2k.image.ImgData
    public Coord getNumTiles(Coord coord) {
        return this.imgdatasrc.getNumTiles(coord);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNumTiles() {
        return this.imgdatasrc.getNumTiles();
    }
}
