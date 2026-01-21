package jj2000.j2k.image;

/* loaded from: classes5.dex */
public class DataBlkInt extends DataBlk {
    public int[] data;

    @Override // jj2000.j2k.image.DataBlk
    public final int getDataType() {
        return 3;
    }

    public DataBlkInt() {
    }

    public DataBlkInt(int i, int i2, int i3, int i4) {
        this.ulx = i;
        this.uly = i2;
        this.w = i3;
        this.h = i4;
        this.offset = 0;
        this.scanw = i3;
        this.data = new int[i3 * i4];
    }

    public DataBlkInt(DataBlkInt dataBlkInt) {
        this.ulx = dataBlkInt.ulx;
        this.uly = dataBlkInt.uly;
        this.w = dataBlkInt.w;
        this.h = dataBlkInt.h;
        this.offset = 0;
        this.scanw = this.w;
        this.data = new int[this.w * this.h];
        for (int i = 0; i < this.h; i++) {
            System.arraycopy(dataBlkInt.data, dataBlkInt.scanw * i, this.data, this.scanw * i, this.w);
        }
    }

    @Override // jj2000.j2k.image.DataBlk
    public final Object getData() {
        return this.data;
    }

    public final int[] getDataInt() {
        return this.data;
    }

    @Override // jj2000.j2k.image.DataBlk
    public final void setData(Object obj) {
        this.data = (int[]) obj;
    }

    public final void setDataInt(int[] iArr) {
        this.data = iArr;
    }

    @Override // jj2000.j2k.image.DataBlk
    public String toString() {
        String string = super.toString();
        if (this.data == null) {
            return string;
        }
        return string + ",data=" + this.data.length + " bytes";
    }
}
