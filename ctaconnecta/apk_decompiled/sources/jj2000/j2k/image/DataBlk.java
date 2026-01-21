package jj2000.j2k.image;

/* loaded from: classes5.dex */
public abstract class DataBlk {
    public static final int TYPE_BYTE = 0;
    public static final int TYPE_FLOAT = 4;
    public static final int TYPE_INT = 3;
    public static final int TYPE_SHORT = 1;
    public int h;
    public int offset;
    public boolean progressive;
    public int scanw;
    public int ulx;
    public int uly;
    public int w;

    public abstract Object getData();

    public abstract int getDataType();

    public abstract void setData(Object obj);

    public static int getSize(int i) {
        if (i == 0) {
            return 8;
        }
        if (i == 1) {
            return 16;
        }
        if (i == 3 || i == 4) {
            return 32;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        String str;
        int dataType = getDataType();
        if (dataType == 0) {
            str = "Unsigned Byte";
        } else if (dataType == 1) {
            str = "Short";
        } else if (dataType == 3) {
            str = "Integer";
        } else {
            str = dataType != 4 ? "" : "Float";
        }
        return "DataBlk: upper-left(" + this.ulx + "," + this.uly + "), width=" + this.w + ", height=" + this.h + ", progressive=" + this.progressive + ", offset=" + this.offset + ", scanw=" + this.scanw + ", type=" + str;
    }
}
