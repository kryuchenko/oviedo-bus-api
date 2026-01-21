package jj2000.j2k.image.output;

import java.io.IOException;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public abstract class ImgWriter {
    public static final int DEF_STRIP_HEIGHT = 64;
    protected int h;
    protected BlkImgDataSrc src;
    protected int w;

    public abstract void close() throws IOException;

    public abstract void flush() throws IOException;

    public abstract void write() throws IOException;

    public abstract void write(int i, int i2, int i3, int i4) throws IOException;

    public void finalize() throws IOException {
        flush();
    }

    public void writeAll() throws IOException {
        Coord numTiles = this.src.getNumTiles(null);
        for (int i = 0; i < numTiles.y; i++) {
            for (int i2 = 0; i2 < numTiles.x; i2++) {
                this.src.setTile(i2, i);
                write();
            }
        }
    }
}
