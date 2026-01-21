package colorspace;

import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes.dex */
public class Resampler extends ColorSpaceMapper {
    final int hspan;
    private final int maxCompSubsX;
    private final int maxCompSubsY;
    private final int minCompSubsX;
    private final int minCompSubsY;
    final int wspan;

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompSubsX(int i) {
        return 1;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return 1;
    }

    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        return new Resampler(blkImgDataSrc, colorSpace);
    }

    protected Resampler(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        super(blkImgDataSrc, colorSpace);
        this.wspan = 0;
        this.hspan = 0;
        int compSubsX = blkImgDataSrc.getCompSubsX(0);
        int compSubsY = blkImgDataSrc.getCompSubsY(0);
        int iMax = compSubsX;
        int iMin = iMax;
        int iMax2 = compSubsY;
        for (int i = 1; i < this.ncomps; i++) {
            iMin = Math.min(iMin, blkImgDataSrc.getCompSubsX(i));
            compSubsY = Math.min(compSubsY, blkImgDataSrc.getCompSubsY(i));
            iMax = Math.max(iMax, blkImgDataSrc.getCompSubsX(i));
            iMax2 = Math.max(iMax2, blkImgDataSrc.getCompSubsY(i));
        }
        if ((iMax != 1 && iMax != 2) || (iMax2 != 1 && iMax2 != 2)) {
            throw new ColorSpaceException("Upsampling by other than 2:1 not supported");
        }
        this.minCompSubsX = iMin;
        this.minCompSubsY = compSubsY;
        this.maxCompSubsX = iMax;
        this.maxCompSubsY = iMax2;
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        if (this.src.getCompSubsX(i) == 1 && this.src.getCompSubsY(i) == 1) {
            return this.src.getInternCompData(dataBlk, i);
        }
        int compSubsX = this.src.getCompSubsX(i);
        int compSubsY = this.src.getCompSubsY(i);
        if ((compSubsX != 2 && compSubsX != 1) || (compSubsY != 2 && compSubsY != 1)) {
            throw new IllegalArgumentException("Upsampling by other than 2:1 not supported");
        }
        int i2 = dataBlk.uly;
        int i3 = (dataBlk.h + i2) - 1;
        int i4 = dataBlk.ulx;
        int i5 = (dataBlk.w + i4) - 1;
        int i6 = i2 / compSubsY;
        int i7 = i4 / compSubsX;
        int i8 = ((i5 / compSubsX) - i7) + 1;
        int i9 = ((i3 / compSubsY) - i6) + 1;
        int dataType = dataBlk.getDataType();
        if (dataType == 3) {
            DataBlkInt dataBlkInt = (DataBlkInt) this.src.getInternCompData(new DataBlkInt(i7, i6, i8, i9), i);
            this.dataInt[i] = dataBlkInt.getDataInt();
            int[] iArr = (int[]) dataBlk.getData();
            if (iArr == null || iArr.length != dataBlk.w * dataBlk.h) {
                iArr = new int[dataBlk.h * dataBlk.w];
                dataBlk.setData(iArr);
            }
            for (int i10 = i2; i10 <= i3; i10++) {
                int i11 = dataBlkInt.offset + (((i10 / compSubsY) - i6) * dataBlkInt.scanw);
                int i12 = dataBlkInt.w;
                int i13 = dataBlk.offset + ((i10 - i2) * dataBlk.scanw);
                int i14 = dataBlk.w + i13;
                if ((i4 & 1) == 1) {
                    iArr[i13] = this.dataInt[i][i11];
                    i13++;
                    i11++;
                }
                int i15 = i5 & 1;
                if (i15 == 0) {
                    i14--;
                }
                while (i13 < i14) {
                    int i16 = i13 + 1;
                    iArr[i13] = this.dataInt[i][i11];
                    i13 += 2;
                    iArr[i16] = this.dataInt[i][i11];
                    i15 = i15;
                    i11++;
                }
                if (i15 == 0) {
                    iArr[i13] = this.dataInt[i][i11];
                }
            }
            dataBlk.progressive = dataBlkInt.progressive;
            return dataBlk;
        }
        if (dataType == 4) {
            DataBlkFloat dataBlkFloat = (DataBlkFloat) this.src.getInternCompData(new DataBlkFloat(i7, i6, i8, i9), i);
            this.dataFloat[i] = dataBlkFloat.getDataFloat();
            float[] fArr = (float[]) dataBlk.getData();
            if (fArr == null || fArr.length != dataBlk.w * dataBlk.h) {
                fArr = new float[dataBlk.h * dataBlk.w];
                dataBlk.setData(fArr);
            }
            for (int i17 = i2; i17 <= i3; i17++) {
                int i18 = dataBlkFloat.offset + (((i17 / compSubsY) - i6) * dataBlkFloat.scanw);
                int i19 = dataBlkFloat.w;
                int i20 = dataBlk.offset + ((i17 - i2) * dataBlk.scanw);
                int i21 = dataBlk.w + i20;
                if ((i4 & 1) == 1) {
                    fArr[i20] = this.dataFloat[i][i18];
                    i20++;
                    i18++;
                }
                int i22 = i5 & 1;
                int i23 = i22 == 0 ? i21 - 1 : i21;
                while (i20 < i23) {
                    int i24 = i20 + 1;
                    fArr[i20] = this.dataFloat[i][i18];
                    i20 += 2;
                    fArr[i24] = this.dataFloat[i][i18];
                    i22 = i22;
                    i18++;
                }
                if (i22 == 0) {
                    fArr[i20] = this.dataFloat[i][i18];
                }
            }
            dataBlk.progressive = dataBlkFloat.progressive;
            return dataBlk;
        }
        throw new IllegalArgumentException("invalid source datablock type");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[Resampler: ncomps= " + this.ncomps);
        StringBuffer stringBuffer2 = new StringBuffer("  ");
        for (int i = 0; i < this.ncomps; i++) {
            stringBuffer2.append(eol);
            stringBuffer2.append("comp[");
            stringBuffer2.append(i);
            stringBuffer2.append("] xscale= ");
            stringBuffer2.append(this.imgdatasrc.getCompSubsX(i));
            stringBuffer2.append(", yscale= ");
            stringBuffer2.append(this.imgdatasrc.getCompSubsY(i));
        }
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2));
        return stringBuffer.append("]").toString();
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return getInternCompData(dataBlk, i);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.src.getCompImgHeight(i) * this.src.getCompSubsY(i);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.src.getCompImgWidth(i) * this.src.getCompSubsX(i);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        return this.src.getTileCompHeight(i, i2) * this.src.getCompSubsY(i2);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        return this.src.getTileCompWidth(i, i2) * this.src.getCompSubsX(i2);
    }
}
