package jj2000.j2k.image;

import jj2000.j2k.NoNextElementException;

/* loaded from: classes5.dex */
public class ImgDataJoiner implements BlkImgDataSrc {
    private int[] compIdx;
    private int h;
    private BlkImgDataSrc[] imageData;
    private int nc;
    private int[] subsX;
    private int[] subsY;
    private int w;

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

    public ImgDataJoiner(BlkImgDataSrc[] blkImgDataSrcArr, int[] iArr) {
        this.imageData = blkImgDataSrcArr;
        this.compIdx = iArr;
        if (blkImgDataSrcArr.length != iArr.length) {
            throw new IllegalArgumentException("imD and cIdx must have the same length");
        }
        int length = blkImgDataSrcArr.length;
        this.nc = length;
        this.subsX = new int[length];
        this.subsY = new int[length];
        for (int i = 0; i < this.nc; i++) {
            if (blkImgDataSrcArr[i].getNumTiles() != 1 || blkImgDataSrcArr[i].getCompULX(iArr[i]) != 0 || blkImgDataSrcArr[i].getCompULY(iArr[i]) != 0) {
                throw new IllegalArgumentException("All input components must, not use tiles and must have the origin at the canvas origin");
            }
        }
        int compImgWidth = 0;
        int compImgHeight = 0;
        for (int i2 = 0; i2 < this.nc; i2++) {
            compImgWidth = blkImgDataSrcArr[i2].getCompImgWidth(iArr[i2]) > compImgWidth ? blkImgDataSrcArr[i2].getCompImgWidth(iArr[i2]) : compImgWidth;
            if (blkImgDataSrcArr[i2].getCompImgHeight(iArr[i2]) > compImgHeight) {
                compImgHeight = blkImgDataSrcArr[i2].getCompImgHeight(iArr[i2]);
            }
        }
        this.w = compImgWidth;
        this.h = compImgHeight;
        for (int i3 = 0; i3 < this.nc; i3++) {
            this.subsX[i3] = ((blkImgDataSrcArr[i3].getCompImgWidth(iArr[i3]) + compImgWidth) - 1) / blkImgDataSrcArr[i3].getCompImgWidth(iArr[i3]);
            this.subsY[i3] = ((blkImgDataSrcArr[i3].getCompImgHeight(iArr[i3]) + compImgHeight) - 1) / blkImgDataSrcArr[i3].getCompImgHeight(iArr[i3]);
            int i4 = this.subsX[i3];
            if (((compImgWidth + i4) - 1) / i4 == blkImgDataSrcArr[i3].getCompImgWidth(iArr[i3])) {
                int i5 = this.subsY[i3];
                if (((compImgHeight + i5) - 1) / i5 == blkImgDataSrcArr[i3].getCompImgHeight(iArr[i3])) {
                }
            }
            throw new Error("Can not compute component subsampling factors: strange subsampling.");
        }
    }

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
    public int getCompSubsX(int i) {
        return this.subsX[i];
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return this.subsY[i];
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        return this.imageData[i2].getTileCompWidth(i, this.compIdx[i2]);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        return this.imageData[i2].getTileCompHeight(i, this.compIdx[i2]);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.imageData[i].getCompImgWidth(this.compIdx[i]);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.imageData[i].getCompImgHeight(this.compIdx[i]);
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        return this.imageData[i].getNomRangeBits(this.compIdx[i]);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.imageData[i].getFixedPoint(this.compIdx[i]);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return this.imageData[i].getInternCompData(dataBlk, this.compIdx[i]);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return this.imageData[i].getCompData(dataBlk, this.compIdx[i]);
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

    public String toString() {
        String str = "ImgDataJoiner: WxH = " + this.w + "x" + this.h;
        for (int i = 0; i < this.nc; i++) {
            str = str + "\n- Component " + i + " " + this.imageData[i];
        }
        return str;
    }
}
