package jj2000.j2k.image.input;

import java.io.IOException;
import jj2000.j2k.NoNextElementException;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public abstract class ImgReader implements BlkImgDataSrc {
    protected int h;
    protected int nc;
    protected int w;

    public abstract void close() throws IOException;

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsX(int i) {
        return 1;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return 1;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompULX(int i) {
        return 0;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompULY(int i) {
        return 0;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgULX() {
        return 0;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgULY() {
        return 0;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNumTiles() {
        return 1;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileIdx() {
        return 0;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTilePartULX() {
        return 0;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTilePartULY() {
        return 0;
    }

    public abstract boolean isOrigSigned(int i);

    @Override // jj2000.j2k.image.ImgData
    public int getTileWidth() {
        return this.w;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileHeight() {
        return this.h;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomTileWidth() {
        return this.w;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomTileHeight() {
        return this.h;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgWidth() {
        return this.w;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getImgHeight() {
        return this.h;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNumComps() {
        return this.nc;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        if (i != 0) {
            throw new Error("Asking a tile-component width for a tile index greater than 0 whereas there is only one tile");
        }
        return this.w;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        if (i != 0) {
            throw new Error("Asking a tile-component width for a tile index greater than 0 whereas there is only one tile");
        }
        return this.h;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.w;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.h;
    }

    @Override // jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        if (i != 0 || i2 != 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override // jj2000.j2k.image.ImgData
    public void nextTile() {
        throw new NoNextElementException();
    }

    @Override // jj2000.j2k.image.ImgData
    public Coord getTile(Coord coord) {
        if (coord != null) {
            coord.x = 0;
            coord.y = 0;
            return coord;
        }
        return new Coord(0, 0);
    }

    @Override // jj2000.j2k.image.ImgData
    public Coord getNumTiles(Coord coord) {
        if (coord != null) {
            coord.x = 1;
            coord.y = 1;
            return coord;
        }
        return new Coord(1, 1);
    }
}
