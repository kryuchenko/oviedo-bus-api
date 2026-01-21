package colorspace;

import colorspace.boxes.PaletteBox;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.util.FacilityManager;

/* loaded from: classes.dex */
public class PalettizedColorSpaceMapper extends ColorSpaceMapper {
    int[] outShiftValueArray;
    private PaletteBox pbox;
    int srcChannel;

    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        return new PalettizedColorSpaceMapper(blkImgDataSrc, colorSpace);
    }

    protected PalettizedColorSpaceMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        super(blkImgDataSrc, colorSpace);
        this.srcChannel = 0;
        this.pbox = colorSpace.getPaletteBox();
        initialize();
    }

    private void initialize() throws ColorSpaceException {
        if (this.ncomps != 1 && this.ncomps != 3) {
            throw new ColorSpaceException("wrong number of components (" + this.ncomps + ") for palettized image");
        }
        int numComps = getNumComps();
        this.outShiftValueArray = new int[numComps];
        for (int i = 0; i < numComps; i++) {
            this.outShiftValueArray[i] = 1 << (getNomRangeBits(i) - 1);
        }
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        if (this.pbox == null) {
            return this.src.getCompData(dataBlk, i);
        }
        if (this.ncomps != 1) {
            FacilityManager.getMsgLogger().printmsg(2, "PalettizedColorSpaceMapper: color palette _not_ applied, incorrect number (" + String.valueOf(this.ncomps) + ") of components");
            return this.src.getCompData(dataBlk, i);
        }
        setInternalBuffer(dataBlk);
        int dataType = dataBlk.getDataType();
        if (dataType == 3) {
            copyGeometry(this.inInt[0], dataBlk);
            this.inInt[0] = (DataBlkInt) this.src.getInternCompData(this.inInt[0], 0);
            this.dataInt[0] = (int[]) this.inInt[0].getData();
            int[] dataInt = ((DataBlkInt) dataBlk).getDataInt();
            for (int i2 = 0; i2 < dataBlk.h; i2++) {
                int i3 = this.inInt[0].offset + (this.inInt[0].scanw * i2);
                int i4 = this.inInt[0].w + i3;
                int i5 = dataBlk.offset + (dataBlk.scanw * i2);
                int i6 = dataBlk.w;
                while (i3 < i4) {
                    dataInt[i5] = this.pbox.getEntry(i, this.dataInt[0][i3] + this.shiftValueArray[0]) - this.outShiftValueArray[i];
                    i3++;
                    i5++;
                }
            }
            dataBlk.progressive = this.inInt[0].progressive;
        } else if (dataType == 4) {
            copyGeometry(this.inFloat[0], dataBlk);
            this.inFloat[0] = (DataBlkFloat) this.src.getInternCompData(this.inFloat[0], 0);
            this.dataFloat[0] = (float[]) this.inFloat[0].getData();
            float[] dataFloat = ((DataBlkFloat) dataBlk).getDataFloat();
            for (int i7 = 0; i7 < dataBlk.h; i7++) {
                int i8 = this.inFloat[0].offset + (this.inFloat[0].scanw * i7);
                int i9 = this.inFloat[0].w + i8;
                int i10 = dataBlk.offset + (dataBlk.scanw * i7);
                int i11 = dataBlk.w;
                while (i8 < i9) {
                    dataFloat[i10] = this.pbox.getEntry(i, ((int) this.dataFloat[0][i8]) + this.shiftValueArray[0]) - this.outShiftValueArray[i];
                    i8++;
                    i10++;
                }
            }
            dataBlk.progressive = this.inFloat[0].progressive;
        } else {
            throw new IllegalArgumentException("invalid source datablock type");
        }
        dataBlk.offset = 0;
        dataBlk.scanw = dataBlk.w;
        return dataBlk;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PalettizedColorSpaceMapper ");
        StringBuffer stringBuffer2 = new StringBuffer("  " + eol);
        if (this.pbox != null) {
            stringBuffer2.append("ncomps= ").append(getNumComps()).append(", scomp= ").append(this.srcChannel);
            for (int i = 0; i < getNumComps(); i++) {
                stringBuffer2.append(eol).append("column= ").append(i).append(", ").append((int) this.pbox.getBitDepth(i)).append(" bit ").append(this.pbox.isSigned(i) ? "signed entry" : "unsigned entry");
            }
        } else {
            stringBuffer2.append("image does not contain a palette box");
        }
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2));
        return stringBuffer.append("]").toString();
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return getCompData(dataBlk, i);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        PaletteBox paletteBox = this.pbox;
        return paletteBox == null ? this.src.getNomRangeBits(i) : paletteBox.getBitDepth(i);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getNumComps() {
        PaletteBox paletteBox = this.pbox;
        return paletteBox == null ? this.src.getNumComps() : paletteBox.getNumColumns();
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompSubsX(int i) {
        return this.imgdatasrc.getCompSubsX(this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return this.imgdatasrc.getCompSubsY(this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        return this.imgdatasrc.getTileCompWidth(i, this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        return this.imgdatasrc.getTileCompHeight(i, this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.imgdatasrc.getCompImgWidth(this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.imgdatasrc.getCompImgHeight(this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompULX(int i) {
        return this.imgdatasrc.getCompULX(this.srcChannel);
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompULY(int i) {
        return this.imgdatasrc.getCompULY(this.srcChannel);
    }
}
