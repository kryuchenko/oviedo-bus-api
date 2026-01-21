package jj2000.j2k.image;

/* loaded from: classes5.dex */
public class DataBlkFloat extends DataBlk {
    public float[] data;

    @Override // jj2000.j2k.image.DataBlk
    public final int getDataType() {
        return 4;
    }

    public DataBlkFloat() {
    }

    public DataBlkFloat(int i, int i2, int i3, int i4) {
        this.ulx = i;
        this.uly = i2;
        this.w = i3;
        this.h = i4;
        this.offset = 0;
        this.scanw = i3;
        this.data = new float[i3 * i4];
    }

    public DataBlkFloat(DataBlkFloat dataBlkFloat) {
        this.ulx = dataBlkFloat.ulx;
        this.uly = dataBlkFloat.uly;
        this.w = dataBlkFloat.w;
        this.h = dataBlkFloat.h;
        this.offset = 0;
        this.scanw = this.w;
        this.data = new float[this.w * this.h];
        for (int i = 0; i < this.h; i++) {
            System.arraycopy(dataBlkFloat.data, dataBlkFloat.scanw * i, this.data, this.scanw * i, this.w);
        }
    }

    @Override // jj2000.j2k.image.DataBlk
    public final Object getData() {
        return this.data;
    }

    public final float[] getDataFloat() {
        return this.data;
    }

    @Override // jj2000.j2k.image.DataBlk
    public final void setData(Object obj) {
        this.data = (float[]) obj;
    }

    public final void setDataFloat(float[] fArr) {
        this.data = fArr;
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
