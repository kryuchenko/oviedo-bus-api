package jj2000.j2k.image;

/* loaded from: classes5.dex */
public class ImgDataConverter extends ImgDataAdapter implements BlkImgDataSrc {
    private int fp;
    private BlkImgDataSrc src;
    private DataBlk srcBlk;

    public ImgDataConverter(BlkImgDataSrc blkImgDataSrc, int i) {
        super(blkImgDataSrc);
        this.srcBlk = new DataBlkInt();
        this.src = blkImgDataSrc;
        this.fp = i;
    }

    public ImgDataConverter(BlkImgDataSrc blkImgDataSrc) {
        super(blkImgDataSrc);
        this.srcBlk = new DataBlkInt();
        this.src = blkImgDataSrc;
        this.fp = 0;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.fp;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return getData(dataBlk, i, false);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return getData(dataBlk, i, true);
    }

    private DataBlk getData(DataBlk dataBlk, int i, boolean z) {
        DataBlk dataBlk2;
        int dataType = dataBlk.getDataType();
        if (dataType == this.srcBlk.getDataType()) {
            dataBlk2 = dataBlk;
        } else {
            dataBlk2 = this.srcBlk;
            dataBlk2.ulx = dataBlk.ulx;
            dataBlk2.uly = dataBlk.uly;
            dataBlk2.w = dataBlk.w;
            dataBlk2.h = dataBlk.h;
        }
        if (z) {
            this.srcBlk = this.src.getInternCompData(dataBlk2, i);
        } else {
            this.srcBlk = this.src.getCompData(dataBlk2, i);
        }
        if (this.srcBlk.getDataType() == dataType) {
            return this.srcBlk;
        }
        int i2 = this.srcBlk.w;
        int i3 = this.srcBlk.h;
        if (dataType == 3) {
            int[] iArr = (int[]) dataBlk.getData();
            if (iArr == null || iArr.length < i2 * i3) {
                iArr = new int[i2 * i3];
                dataBlk.setData(iArr);
            }
            dataBlk.scanw = this.srcBlk.w;
            dataBlk.offset = 0;
            dataBlk.progressive = this.srcBlk.progressive;
            float[] fArr = (float[]) this.srcBlk.getData();
            int i4 = this.fp;
            if (i4 != 0) {
                float f = 1 << i4;
                int i5 = i3 - 1;
                int i6 = (i3 * i2) - 1;
                int i7 = ((this.srcBlk.offset + (this.srcBlk.scanw * i5)) + i2) - 1;
                while (i5 >= 0) {
                    int i8 = i6 - i2;
                    while (i6 > i8) {
                        float f2 = fArr[i7];
                        if (f2 > 0.0f) {
                            iArr[i6] = (int) ((f2 * f) + 0.5f);
                        } else {
                            iArr[i6] = (int) ((f2 * f) - 0.5f);
                        }
                        i6--;
                        i7--;
                    }
                    i7 -= this.srcBlk.scanw - i2;
                    i5--;
                }
            } else {
                int i9 = i3 - 1;
                int i10 = (i3 * i2) - 1;
                int i11 = ((this.srcBlk.offset + (this.srcBlk.scanw * i9)) + i2) - 1;
                while (i9 >= 0) {
                    int i12 = i10 - i2;
                    while (i10 > i12) {
                        float f3 = fArr[i11];
                        if (f3 > 0.0f) {
                            iArr[i10] = (int) (f3 + 0.5f);
                        } else {
                            iArr[i10] = (int) (f3 - 0.5f);
                        }
                        i10--;
                        i11--;
                    }
                    i11 -= this.srcBlk.scanw - i2;
                    i9--;
                }
            }
        } else if (dataType == 4) {
            float[] fArr2 = (float[]) dataBlk.getData();
            if (fArr2 == null || fArr2.length < i2 * i3) {
                fArr2 = new float[i2 * i3];
                dataBlk.setData(fArr2);
            }
            dataBlk.scanw = this.srcBlk.w;
            dataBlk.offset = 0;
            dataBlk.progressive = this.srcBlk.progressive;
            int[] iArr2 = (int[]) this.srcBlk.getData();
            int fixedPoint = this.src.getFixedPoint(i);
            this.fp = fixedPoint;
            if (fixedPoint != 0) {
                float f4 = 1.0f / (1 << fixedPoint);
                int i13 = i3 - 1;
                int i14 = (i3 * i2) - 1;
                int i15 = ((this.srcBlk.offset + (this.srcBlk.scanw * i13)) + i2) - 1;
                while (i13 >= 0) {
                    int i16 = i14 - i2;
                    while (i14 > i16) {
                        fArr2[i14] = iArr2[i15] * f4;
                        i14--;
                        i15--;
                    }
                    i15 -= this.srcBlk.scanw - i2;
                    i13--;
                }
            } else {
                int i17 = i3 - 1;
                int i18 = (i3 * i2) - 1;
                int i19 = ((this.srcBlk.offset + (this.srcBlk.scanw * i17)) + i2) - 1;
                while (i17 >= 0) {
                    int i20 = i18 - i2;
                    while (i18 > i20) {
                        fArr2[i18] = iArr2[i19];
                        i18--;
                        i19--;
                    }
                    i19 -= this.srcBlk.scanw - i2;
                    i17--;
                }
            }
        } else {
            throw new IllegalArgumentException("Only integer and float data are supported by JJ2000");
        }
        return dataBlk;
    }
}
