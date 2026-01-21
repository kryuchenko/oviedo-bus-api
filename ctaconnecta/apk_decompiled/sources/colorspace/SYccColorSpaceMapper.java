package colorspace;

import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.util.FacilityManager;

/* loaded from: classes.dex */
public class SYccColorSpaceMapper extends ColorSpaceMapper {
    protected static float Matrix00 = 1.0f;
    protected static float Matrix01 = 0.0f;
    protected static float Matrix02 = 1.402f;
    protected static float Matrix10 = 1.0f;
    protected static float Matrix11 = -0.34413f;
    protected static float Matrix12 = -0.71414f;
    protected static float Matrix20 = 1.0f;
    protected static float Matrix21 = 1.772f;
    protected static float Matrix22;

    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        return new SYccColorSpaceMapper(blkImgDataSrc, colorSpace);
    }

    protected SYccColorSpaceMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        super(blkImgDataSrc, colorSpace);
        initialize();
    }

    private void initialize() throws ColorSpaceException {
        if (this.ncomps == 1 || this.ncomps == 3) {
            return;
        }
        String str = "SYccColorSpaceMapper: ycc transformation _not_ applied to " + this.ncomps + " component image";
        FacilityManager.getMsgLogger().printmsg(3, str);
        throw new ColorSpaceException(str);
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        int dataType = dataBlk.getDataType();
        for (int i2 = 0; i2 < this.ncomps; i2++) {
            copyGeometry(this.workInt[i2], dataBlk);
            copyGeometry(this.workFloat[i2], dataBlk);
            copyGeometry(this.inInt[i2], dataBlk);
            copyGeometry(this.inFloat[i2], dataBlk);
            this.inInt[i2] = (DataBlkInt) this.src.getInternCompData(this.inInt[i2], i2);
        }
        if (dataType == 3) {
            if (this.ncomps == 1) {
                this.workInt[i] = this.inInt[i];
            } else {
                this.workInt = mult(this.inInt);
            }
            dataBlk.progressive = this.inInt[i].progressive;
            dataBlk.setData(this.workInt[i].getData());
        }
        if (dataType == 4) {
            if (this.ncomps == 1) {
                this.workFloat[i] = this.inFloat[i];
            } else {
                this.workFloat = mult(this.inFloat);
            }
            dataBlk.progressive = this.inFloat[i].progressive;
            dataBlk.setData(this.workFloat[i].getData());
        }
        dataBlk.offset = 0;
        dataBlk.scanw = dataBlk.w;
        return dataBlk;
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return getCompData(dataBlk, i);
    }

    private static DataBlkFloat[] mult(DataBlkFloat[] dataBlkFloatArr) {
        if (dataBlkFloatArr.length != 3) {
            throw new IllegalArgumentException("bad input array size");
        }
        int i = dataBlkFloatArr[0].h * dataBlkFloatArr[0].w;
        DataBlkFloat[] dataBlkFloatArr2 = new DataBlkFloat[3];
        float[][] fArr = new float[3][];
        float[][] fArr2 = new float[3][];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr2[i2] = dataBlkFloatArr[i2].getDataFloat();
            DataBlkFloat dataBlkFloat = new DataBlkFloat();
            dataBlkFloatArr2[i2] = dataBlkFloat;
            copyGeometry(dataBlkFloat, dataBlkFloatArr[i2]);
            dataBlkFloatArr2[i2].offset = dataBlkFloatArr[i2].offset;
            float[] fArr3 = new float[i];
            fArr[i2] = fArr3;
            dataBlkFloatArr2[i2].setData(fArr3);
        }
        for (int i3 = 0; i3 < i; i3++) {
            fArr[0][i3] = (Matrix00 * fArr2[0][dataBlkFloatArr[0].offset + i3]) + (Matrix01 * fArr2[1][dataBlkFloatArr[1].offset + i3]) + (Matrix02 * fArr2[2][dataBlkFloatArr[2].offset + i3]);
            fArr[1][i3] = (Matrix10 * fArr2[0][dataBlkFloatArr[0].offset + i3]) + (Matrix11 * fArr2[1][dataBlkFloatArr[1].offset + i3]) + (Matrix12 * fArr2[2][dataBlkFloatArr[2].offset + i3]);
            fArr[2][i3] = (Matrix20 * fArr2[0][dataBlkFloatArr[0].offset + i3]) + (Matrix21 * fArr2[1][dataBlkFloatArr[1].offset + i3]) + (Matrix22 * fArr2[2][dataBlkFloatArr[2].offset + i3]);
        }
        return dataBlkFloatArr2;
    }

    private static DataBlkInt[] mult(DataBlkInt[] dataBlkIntArr) {
        if (dataBlkIntArr.length != 3) {
            throw new IllegalArgumentException("bad input array size");
        }
        int i = dataBlkIntArr[0].h * dataBlkIntArr[0].w;
        DataBlkInt[] dataBlkIntArr2 = new DataBlkInt[3];
        int[][] iArr = new int[3][];
        int[][] iArr2 = new int[3][];
        for (int i2 = 0; i2 < 3; i2++) {
            iArr2[i2] = dataBlkIntArr[i2].getDataInt();
            DataBlkInt dataBlkInt = new DataBlkInt();
            dataBlkIntArr2[i2] = dataBlkInt;
            copyGeometry(dataBlkInt, dataBlkIntArr[i2]);
            dataBlkIntArr2[i2].offset = dataBlkIntArr[i2].offset;
            int[] iArr3 = new int[i];
            iArr[i2] = iArr3;
            dataBlkIntArr2[i2].setData(iArr3);
        }
        for (int i3 = 0; i3 < i; i3++) {
            iArr[0][i3] = (int) ((Matrix00 * iArr2[0][dataBlkIntArr[0].offset + i3]) + (Matrix01 * iArr2[1][dataBlkIntArr[1].offset + i3]) + (Matrix02 * iArr2[2][dataBlkIntArr[2].offset + i3]));
            iArr[1][i3] = (int) ((Matrix10 * iArr2[0][dataBlkIntArr[0].offset + i3]) + (Matrix11 * iArr2[1][dataBlkIntArr[1].offset + i3]) + (Matrix12 * iArr2[2][dataBlkIntArr[2].offset + i3]));
            iArr[2][i3] = (int) ((Matrix20 * iArr2[0][dataBlkIntArr[0].offset + i3]) + (Matrix21 * iArr2[1][dataBlkIntArr[1].offset + i3]) + (Matrix22 * iArr2[2][dataBlkIntArr[2].offset + i3]));
        }
        return dataBlkIntArr2;
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("ncomps= ").append(String.valueOf(this.ncomps));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.ncomps; i++) {
            stringBuffer.append("  component[").append(String.valueOf(i)).append("] height, width = (").append(this.src.getCompImgHeight(i)).append(", ").append(this.src.getCompImgWidth(i)).append(")").append(eol);
        }
        StringBuffer stringBuffer2 = new StringBuffer("[SYccColorSpaceMapper ");
        stringBuffer2.append(stringBufferAppend).append(eol);
        stringBuffer2.append(stringBuffer).append("  ]");
        return stringBuffer2.toString();
    }
}
