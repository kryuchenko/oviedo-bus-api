package jj2000.j2k.image;

import jj2000.j2k.NoNextElementException;
import jj2000.j2k.util.FacilityManager;

/* loaded from: classes5.dex */
public class Tiler extends ImgDataAdapter implements BlkImgDataSrc {
    private int[] compH;
    private int[] compW;
    private int ntX;
    private int ntY;
    private BlkImgDataSrc src;
    private int[] tcx0;
    private int[] tcy0;
    private int tileH;
    private int tileW;
    private int tx;
    private int ty;
    private int x0siz;
    private int xt0siz;
    private int xtsiz;
    private int y0siz;
    private int yt0siz;
    private int ytsiz;

    public Tiler(BlkImgDataSrc blkImgDataSrc, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        super(blkImgDataSrc);
        this.compW = null;
        this.compH = null;
        this.tcx0 = null;
        this.tcy0 = null;
        this.src = blkImgDataSrc;
        this.x0siz = i;
        this.y0siz = i2;
        this.xt0siz = i3;
        this.yt0siz = i4;
        this.xtsiz = i5;
        this.ytsiz = i6;
        if (blkImgDataSrc.getNumTiles() != 1) {
            throw new IllegalArgumentException("Source is tiled");
        }
        if (blkImgDataSrc.getImgULX() != 0 || blkImgDataSrc.getImgULY() != 0) {
            throw new IllegalArgumentException("Source is \"canvased\"");
        }
        int i11 = this.x0siz;
        if (i11 < 0 || (i7 = this.y0siz) < 0 || (i8 = this.xt0siz) < 0 || (i9 = this.yt0siz) < 0 || (i10 = this.xtsiz) < 0 || this.ytsiz < 0 || i8 > i11 || i9 > i7) {
            throw new IllegalArgumentException("Invalid image origin, tiling origin or nominal tile size");
        }
        if (i10 == 0) {
            this.xtsiz = (i11 + blkImgDataSrc.getImgWidth()) - this.xt0siz;
        }
        if (this.ytsiz == 0) {
            this.ytsiz = (this.y0siz + blkImgDataSrc.getImgHeight()) - this.yt0siz;
        }
        int i12 = this.x0siz;
        int i13 = this.xt0siz;
        int i14 = i12 - i13;
        int i15 = this.xtsiz;
        if (i14 >= i15) {
            this.xt0siz = i13 + (((i12 - i13) / i15) * i15);
        }
        int i16 = this.y0siz;
        int i17 = this.yt0siz;
        int i18 = i16 - i17;
        int i19 = this.ytsiz;
        if (i18 >= i19) {
            this.yt0siz = i17 + (((i16 - i17) / i19) * i19);
        }
        if (i12 - this.xt0siz >= i15 || i16 - this.yt0siz >= i19) {
            FacilityManager.getMsgLogger().printmsg(1, "Automatically adjusted tiling origin to equivalent one (" + this.xt0siz + "," + this.yt0siz + ") so that first tile overlaps the image");
        }
        this.ntX = (int) Math.ceil((this.x0siz + blkImgDataSrc.getImgWidth()) / this.xtsiz);
        this.ntY = (int) Math.ceil((this.y0siz + blkImgDataSrc.getImgHeight()) / this.ytsiz);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getTileWidth() {
        return this.tileW;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getTileHeight() {
        return this.tileH;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getTileCompWidth(int i, int i2) {
        if (i != getTileIdx()) {
            throw new Error("Asking the width of a tile-component which is not in the current tile (call setTile() or nextTile() methods before).");
        }
        return this.compW[i2];
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getTileCompHeight(int i, int i2) {
        if (i != getTileIdx()) {
            throw new Error("Asking the width of a tile-component which is not in the current tile (call setTile() or nextTile() methods before).");
        }
        return this.compH[i2];
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(i);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getInternCompData(DataBlk dataBlk, int i) {
        if (dataBlk.ulx < 0 || dataBlk.uly < 0 || dataBlk.w > this.compW[i] || dataBlk.h > this.compH[i]) {
            throw new IllegalArgumentException("Block is outside the tile");
        }
        int iCeil = (int) Math.ceil(this.x0siz / this.src.getCompSubsX(i));
        int iCeil2 = (int) Math.ceil(this.y0siz / this.src.getCompSubsY(i));
        dataBlk.ulx -= iCeil;
        dataBlk.uly -= iCeil2;
        DataBlk internCompData = this.src.getInternCompData(dataBlk, i);
        internCompData.ulx += iCeil;
        internCompData.uly += iCeil2;
        return internCompData;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getCompData(DataBlk dataBlk, int i) {
        if (dataBlk.ulx < 0 || dataBlk.uly < 0 || dataBlk.w > this.compW[i] || dataBlk.h > this.compH[i]) {
            throw new IllegalArgumentException("Block is outside the tile");
        }
        int iCeil = (int) Math.ceil(this.x0siz / this.src.getCompSubsX(i));
        int iCeil2 = (int) Math.ceil(this.y0siz / this.src.getCompSubsY(i));
        dataBlk.ulx -= iCeil;
        dataBlk.uly -= iCeil2;
        DataBlk compData = this.src.getCompData(dataBlk, i);
        compData.ulx += iCeil;
        compData.uly += iCeil2;
        return compData;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final void setTile(int i, int i2) {
        int i3;
        int i4;
        int imgHeight;
        if (i < 0 || i2 < 0 || i >= (i3 = this.ntX) || i2 >= this.ntY) {
            throw new IllegalArgumentException("Tile's indexes out of bounds");
        }
        this.tx = i;
        this.ty = i2;
        int i5 = i != 0 ? this.xt0siz + (this.xtsiz * i) : this.x0siz;
        int i6 = i2 != 0 ? this.yt0siz + (this.ytsiz * i2) : this.y0siz;
        int imgWidth = i != i3 + (-1) ? this.xt0siz + ((i + 1) * this.xtsiz) : this.src.getImgWidth() + this.x0siz;
        if (i2 != this.ntY - 1) {
            i4 = this.yt0siz;
            imgHeight = (i2 + 1) * this.ytsiz;
        } else {
            i4 = this.y0siz;
            imgHeight = this.src.getImgHeight();
        }
        int i7 = i4 + imgHeight;
        this.tileW = imgWidth - i5;
        this.tileH = i7 - i6;
        int numComps = this.src.getNumComps();
        if (this.compW == null) {
            this.compW = new int[numComps];
        }
        if (this.compH == null) {
            this.compH = new int[numComps];
        }
        if (this.tcx0 == null) {
            this.tcx0 = new int[numComps];
        }
        if (this.tcy0 == null) {
            this.tcy0 = new int[numComps];
        }
        for (int i8 = 0; i8 < numComps; i8++) {
            this.tcx0[i8] = (int) Math.ceil(i5 / this.src.getCompSubsX(i8));
            this.tcy0[i8] = (int) Math.ceil(i6 / this.src.getCompSubsY(i8));
            this.compW[i8] = ((int) Math.ceil(imgWidth / this.src.getCompSubsX(i8))) - this.tcx0[i8];
            this.compH[i8] = ((int) Math.ceil(i7 / this.src.getCompSubsY(i8))) - this.tcy0[i8];
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final void nextTile() {
        int i = this.tx;
        int i2 = this.ntX;
        if (i == i2 - 1 && this.ty == this.ntY - 1) {
            throw new NoNextElementException();
        }
        if (i < i2 - 1) {
            setTile(i + 1, this.ty);
        } else {
            setTile(0, this.ty + 1);
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final Coord getTile(Coord coord) {
        if (coord != null) {
            coord.x = this.tx;
            coord.y = this.ty;
            return coord;
        }
        return new Coord(this.tx, this.ty);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getTileIdx() {
        return (this.ty * this.ntX) + this.tx;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getCompULX(int i) {
        return this.tcx0[i];
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getCompULY(int i) {
        return this.tcy0[i];
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTilePartULX() {
        return this.xt0siz;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTilePartULY() {
        return this.yt0siz;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getImgULX() {
        return this.x0siz;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getImgULY() {
        return this.y0siz;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final Coord getNumTiles(Coord coord) {
        if (coord != null) {
            coord.x = this.ntX;
            coord.y = this.ntY;
            return coord;
        }
        return new Coord(this.ntX, this.ntY);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getNumTiles() {
        return this.ntX * this.ntY;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getNomTileWidth() {
        return this.xtsiz;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public final int getNomTileHeight() {
        return this.ytsiz;
    }

    public final Coord getTilingOrigin(Coord coord) {
        if (coord != null) {
            coord.x = this.xt0siz;
            coord.y = this.yt0siz;
            return coord;
        }
        return new Coord(this.xt0siz, this.yt0siz);
    }

    public String toString() {
        return "Tiler: source= " + this.src + "\n" + getNumTiles() + " tile(s), nominal width=" + this.xtsiz + ", nominal height=" + this.ytsiz;
    }
}
