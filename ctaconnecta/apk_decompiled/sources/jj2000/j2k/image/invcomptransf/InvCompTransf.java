package jj2000.j2k.image.invcomptransf;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.CompTransfSpec;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.synthesis.SynWTFilterSpec;

/* loaded from: classes5.dex */
public class InvCompTransf extends ImgDataAdapter implements BlkImgDataSrc {
    public static final int INV_ICT = 2;
    public static final int INV_RCT = 1;
    public static final int NONE = 0;
    public static final char OPT_PREFIX = 'M';
    private static final String[][] pinfo = null;
    private DataBlk block0;
    private DataBlk block1;
    private DataBlk block2;
    private CompTransfSpec cts;
    private DataBlkInt dbi;
    private boolean noCompTransf;
    private int[][] outdata;
    private BlkImgDataSrc src;
    private int transfType;
    private int[] utdepth;
    private SynWTFilterSpec wfs;

    static {
    }

    public InvCompTransf(BlkImgDataSrc blkImgDataSrc, DecoderSpecs decoderSpecs, int[] iArr, ParameterList parameterList) {
        super(blkImgDataSrc);
        this.transfType = 0;
        this.outdata = new int[3][];
        this.dbi = new DataBlkInt();
        this.noCompTransf = false;
        this.cts = decoderSpecs.cts;
        this.wfs = decoderSpecs.wfs;
        this.src = blkImgDataSrc;
        this.utdepth = iArr;
        this.noCompTransf = !parameterList.getBooleanParameter("comp_transf");
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public String toString() {
        int i = this.transfType;
        if (i == 0) {
            return "No component transformation";
        }
        if (i == 1) {
            return "Inverse RCT";
        }
        if (i == 2) {
            return "Inverse ICT";
        }
        throw new IllegalArgumentException("Non JPEG 2000 part I component transformation");
    }

    public boolean isReversible() {
        int i = this.transfType;
        if (i == 0 || i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("Non JPEG 2000 part I component transformation");
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(i);
    }

    public static int[] calcMixedBitDepths(int[] iArr, int i, int[] iArr2) {
        if (iArr.length < 3 && i != 0) {
            throw new IllegalArgumentException();
        }
        if (iArr2 == null) {
            iArr2 = new int[iArr.length];
        }
        if (i == 0) {
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        if (i == 1) {
            if (iArr.length > 3) {
                System.arraycopy(iArr, 3, iArr2, 3, iArr.length - 3);
            }
            iArr2[0] = MathUtil.log2((((1 << iArr[0]) + (2 << iArr[1])) + (1 << iArr[2])) - 1) - 1;
            iArr2[1] = MathUtil.log2(((1 << iArr[2]) + (1 << iArr[1])) - 1) + 1;
            iArr2[2] = MathUtil.log2(((1 << iArr[0]) + (1 << iArr[1])) - 1) + 1;
            return iArr2;
        }
        if (i != 2) {
            return iArr2;
        }
        if (iArr.length > 3) {
            System.arraycopy(iArr, 3, iArr2, 3, iArr.length - 3);
        }
        iArr2[0] = MathUtil.log2(((int) Math.floor((((1 << iArr[0]) * 0.299072d) + ((1 << iArr[1]) * 0.586914d)) + ((1 << iArr[2]) * 0.114014d))) - 1) + 1;
        iArr2[1] = MathUtil.log2(((int) Math.floor((((1 << iArr[0]) * 0.168701d) + ((1 << iArr[1]) * 0.331299d)) + ((1 << iArr[2]) * 0.5d))) - 1) + 1;
        iArr2[2] = MathUtil.log2(((int) Math.floor((((1 << iArr[0]) * 0.5d) + ((1 << iArr[1]) * 0.418701d)) + ((1 << iArr[2]) * 0.081299d))) - 1) + 1;
        return iArr2;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        return this.utdepth[i];
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        if (i >= 3 || this.transfType == 0 || this.noCompTransf) {
            return this.src.getCompData(dataBlk, i);
        }
        return getInternCompData(dataBlk, i);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        if (this.noCompTransf) {
            return this.src.getInternCompData(dataBlk, i);
        }
        int i2 = this.transfType;
        if (i2 == 0) {
            return this.src.getInternCompData(dataBlk, i);
        }
        if (i2 == 1) {
            return invRCT(dataBlk, i);
        }
        if (i2 == 2) {
            return invICT(dataBlk, i);
        }
        throw new IllegalArgumentException("Non JPEG 2000 part I component transformation");
    }

    private DataBlk invRCT(DataBlk dataBlk, int i) {
        if (i >= 3 && i < getNumComps()) {
            return this.src.getInternCompData(dataBlk, i);
        }
        if (this.outdata[i] != null && this.dbi.ulx <= dataBlk.ulx && this.dbi.uly <= dataBlk.uly && this.dbi.ulx + this.dbi.w >= dataBlk.ulx + dataBlk.w && this.dbi.uly + this.dbi.h >= dataBlk.uly + dataBlk.h) {
            if (i >= 0 && i < 3) {
                dataBlk.setData(this.outdata[i]);
                dataBlk.progressive = this.dbi.progressive;
                dataBlk.offset = (((dataBlk.uly - this.dbi.uly) * this.dbi.w) + dataBlk.ulx) - this.dbi.ulx;
                dataBlk.scanw = this.dbi.w;
                this.outdata[i] = null;
                return dataBlk;
            }
            throw new IllegalArgumentException();
        }
        int i2 = dataBlk.w;
        int i3 = dataBlk.h;
        this.outdata[i] = (int[]) dataBlk.getData();
        int[][] iArr = this.outdata;
        int[] iArr2 = iArr[i];
        if (iArr2 == null || iArr2.length != i3 * i2) {
            int[] iArr3 = new int[i3 * i2];
            iArr[i] = iArr3;
            dataBlk.setData(iArr3);
        }
        int[][] iArr4 = this.outdata;
        iArr4[(i + 1) % 3] = new int[iArr4[i].length];
        iArr4[(i + 2) % 3] = new int[iArr4[i].length];
        DataBlk dataBlk2 = this.block0;
        if (dataBlk2 == null || dataBlk2.getDataType() != 3) {
            this.block0 = new DataBlkInt();
        }
        DataBlk dataBlk3 = this.block1;
        if (dataBlk3 == null || dataBlk3.getDataType() != 3) {
            this.block1 = new DataBlkInt();
        }
        DataBlk dataBlk4 = this.block2;
        if (dataBlk4 == null || dataBlk4.getDataType() != 3) {
            this.block2 = new DataBlkInt();
        }
        DataBlk dataBlk5 = this.block0;
        DataBlk dataBlk6 = this.block1;
        DataBlk dataBlk7 = this.block2;
        int i4 = dataBlk.w;
        dataBlk7.w = i4;
        dataBlk6.w = i4;
        dataBlk5.w = i4;
        DataBlk dataBlk8 = this.block0;
        DataBlk dataBlk9 = this.block1;
        DataBlk dataBlk10 = this.block2;
        int i5 = dataBlk.h;
        dataBlk10.h = i5;
        dataBlk9.h = i5;
        dataBlk8.h = i5;
        DataBlk dataBlk11 = this.block0;
        DataBlk dataBlk12 = this.block1;
        DataBlk dataBlk13 = this.block2;
        int i6 = dataBlk.ulx;
        dataBlk13.ulx = i6;
        dataBlk12.ulx = i6;
        dataBlk11.ulx = i6;
        DataBlk dataBlk14 = this.block0;
        DataBlk dataBlk15 = this.block1;
        DataBlk dataBlk16 = this.block2;
        int i7 = dataBlk.uly;
        dataBlk16.uly = i7;
        dataBlk15.uly = i7;
        dataBlk14.uly = i7;
        DataBlkInt dataBlkInt = (DataBlkInt) this.src.getInternCompData(this.block0, 0);
        this.block0 = dataBlkInt;
        int[] iArr5 = (int[]) dataBlkInt.getData();
        DataBlkInt dataBlkInt2 = (DataBlkInt) this.src.getInternCompData(this.block1, 1);
        this.block1 = dataBlkInt2;
        int[] iArr6 = (int[]) dataBlkInt2.getData();
        DataBlkInt dataBlkInt3 = (DataBlkInt) this.src.getInternCompData(this.block2, 2);
        this.block2 = dataBlkInt3;
        int[] iArr7 = (int[]) dataBlkInt3.getData();
        dataBlk.progressive = this.block0.progressive || this.block1.progressive || this.block2.progressive;
        dataBlk.offset = 0;
        dataBlk.scanw = i2;
        this.dbi.progressive = dataBlk.progressive;
        this.dbi.ulx = dataBlk.ulx;
        this.dbi.uly = dataBlk.uly;
        this.dbi.w = dataBlk.w;
        this.dbi.h = dataBlk.h;
        int i8 = (i2 * i3) - 1;
        int i9 = i3 - 1;
        int i10 = ((this.block0.offset + (this.block0.scanw * i9)) + i2) - 1;
        int i11 = ((this.block1.offset + (this.block1.scanw * i9)) + i2) - 1;
        int i12 = ((this.block2.offset + (this.block2.scanw * i9)) + i2) - 1;
        while (i9 >= 0) {
            int i13 = i8 - i2;
            while (i8 > i13) {
                int[][] iArr8 = this.outdata;
                int[] iArr9 = iArr8[1];
                int i14 = iArr5[i10] - ((iArr6[i11] + iArr7[i12]) >> 2);
                iArr9[i8] = i14;
                iArr8[0][i8] = iArr7[i12] + i14;
                iArr8[2][i8] = iArr6[i11] + iArr9[i8];
                i8--;
                i10--;
                i11--;
                i12--;
            }
            i10 -= this.block0.scanw - i2;
            i11 -= this.block1.scanw - i2;
            i12 -= this.block2.scanw - i2;
            i9--;
        }
        this.outdata[i] = null;
        return dataBlk;
    }

    private DataBlk invICT(DataBlk dataBlk, int i) {
        if (i >= 3 && i < getNumComps()) {
            int i2 = dataBlk.w;
            int i3 = dataBlk.h;
            int[] iArr = (int[]) dataBlk.getData();
            if (iArr == null) {
                iArr = new int[i3 * i2];
                dataBlk.setData(iArr);
            }
            DataBlkFloat dataBlkFloat = new DataBlkFloat(dataBlk.ulx, dataBlk.uly, i2, i3);
            this.src.getInternCompData(dataBlkFloat, i);
            float[] fArr = (float[]) dataBlkFloat.getData();
            int i4 = (i2 * i3) - 1;
            int i5 = i3 - 1;
            int i6 = ((dataBlkFloat.offset + (dataBlkFloat.scanw * i5)) + i2) - 1;
            while (i5 >= 0) {
                int i7 = i4 - i2;
                while (i4 > i7) {
                    iArr[i4] = (int) fArr[i6];
                    i4--;
                    i6--;
                }
                i6 -= dataBlkFloat.scanw - i2;
                i5--;
            }
            dataBlk.progressive = dataBlkFloat.progressive;
            dataBlk.offset = 0;
            dataBlk.scanw = i2;
            return dataBlk;
        }
        int[] iArr2 = null;
        if (this.outdata[i] != null && this.dbi.ulx <= dataBlk.ulx && this.dbi.uly <= dataBlk.uly && this.dbi.ulx + this.dbi.w >= dataBlk.ulx + dataBlk.w && this.dbi.uly + this.dbi.h >= dataBlk.uly + dataBlk.h) {
            if (i >= 0 && i <= 3) {
                dataBlk.setData(this.outdata[i]);
                dataBlk.progressive = this.dbi.progressive;
                dataBlk.offset = (((dataBlk.uly - this.dbi.uly) * this.dbi.w) + dataBlk.ulx) - this.dbi.ulx;
                dataBlk.scanw = this.dbi.w;
                this.outdata[i] = null;
                return dataBlk;
            }
            throw new IllegalArgumentException();
        }
        int i8 = dataBlk.w;
        int i9 = dataBlk.h;
        this.outdata[i] = (int[]) dataBlk.getData();
        int[][] iArr3 = this.outdata;
        int[] iArr4 = iArr3[i];
        if (iArr4 == null || iArr4.length != i8 * i9) {
            Object obj = new int[i9 * i8];
            iArr3[i] = obj;
            dataBlk.setData(obj);
        }
        int[][] iArr5 = this.outdata;
        iArr5[(i + 1) % 3] = new int[iArr5[i].length];
        iArr5[(i + 2) % 3] = new int[iArr5[i].length];
        DataBlk dataBlk2 = this.block0;
        if (dataBlk2 == null || dataBlk2.getDataType() != 4) {
            this.block0 = new DataBlkFloat();
        }
        DataBlk dataBlk3 = this.block2;
        if (dataBlk3 == null || dataBlk3.getDataType() != 4) {
            this.block2 = new DataBlkFloat();
        }
        DataBlk dataBlk4 = this.block1;
        if (dataBlk4 == null || dataBlk4.getDataType() != 4) {
            this.block1 = new DataBlkFloat();
        }
        DataBlk dataBlk5 = this.block0;
        DataBlk dataBlk6 = this.block2;
        DataBlk dataBlk7 = this.block1;
        int i10 = dataBlk.w;
        dataBlk7.w = i10;
        dataBlk6.w = i10;
        dataBlk5.w = i10;
        DataBlk dataBlk8 = this.block0;
        DataBlk dataBlk9 = this.block2;
        DataBlk dataBlk10 = this.block1;
        int i11 = dataBlk.h;
        dataBlk10.h = i11;
        dataBlk9.h = i11;
        dataBlk8.h = i11;
        DataBlk dataBlk11 = this.block0;
        DataBlk dataBlk12 = this.block2;
        DataBlk dataBlk13 = this.block1;
        int i12 = dataBlk.ulx;
        dataBlk13.ulx = i12;
        dataBlk12.ulx = i12;
        dataBlk11.ulx = i12;
        DataBlk dataBlk14 = this.block0;
        DataBlk dataBlk15 = this.block2;
        DataBlk dataBlk16 = this.block1;
        int i13 = dataBlk.uly;
        dataBlk16.uly = i13;
        dataBlk15.uly = i13;
        dataBlk14.uly = i13;
        DataBlkFloat dataBlkFloat2 = (DataBlkFloat) this.src.getInternCompData(this.block0, 0);
        this.block0 = dataBlkFloat2;
        float[] fArr2 = (float[]) dataBlkFloat2.getData();
        DataBlkFloat dataBlkFloat3 = (DataBlkFloat) this.src.getInternCompData(this.block2, 1);
        this.block2 = dataBlkFloat3;
        float[] fArr3 = (float[]) dataBlkFloat3.getData();
        DataBlkFloat dataBlkFloat4 = (DataBlkFloat) this.src.getInternCompData(this.block1, 2);
        this.block1 = dataBlkFloat4;
        float[] fArr4 = (float[]) dataBlkFloat4.getData();
        dataBlk.progressive = this.block0.progressive || this.block1.progressive || this.block2.progressive;
        dataBlk.offset = 0;
        dataBlk.scanw = i8;
        this.dbi.progressive = dataBlk.progressive;
        this.dbi.ulx = dataBlk.ulx;
        this.dbi.uly = dataBlk.uly;
        this.dbi.w = dataBlk.w;
        this.dbi.h = dataBlk.h;
        int i14 = (i8 * i9) - 1;
        int i15 = i9 - 1;
        int i16 = ((this.block0.offset + (this.block0.scanw * i15)) + i8) - 1;
        int i17 = ((this.block2.offset + (this.block2.scanw * i15)) + i8) - 1;
        int i18 = ((this.block1.offset + (this.block1.scanw * i15)) + i8) - 1;
        while (i15 >= 0) {
            int i19 = i14 - i8;
            while (i14 > i19) {
                int[][] iArr6 = this.outdata;
                int[] iArr7 = iArr6[0];
                float f = fArr2[i16];
                float f2 = fArr4[i18];
                int[] iArr8 = iArr2;
                iArr7[i14] = (int) (f + (1.402f * f2) + 0.5f);
                int[] iArr9 = iArr6[1];
                float f3 = fArr3[i17];
                iArr9[i14] = (int) (((f - (0.34413f * f3)) - (f2 * 0.71414f)) + 0.5f);
                iArr6[2][i14] = (int) (f + (f3 * 1.772f) + 0.5f);
                i14--;
                i16--;
                i17--;
                i18--;
                iArr2 = iArr8;
            }
            i16 -= this.block0.scanw - i8;
            i17 -= this.block2.scanw - i8;
            i18 -= this.block1.scanw - i8;
            i15--;
        }
        this.outdata[i] = iArr2;
        return dataBlk;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        this.src.setTile(i, i2);
        this.tIdx = getTileIdx();
        if (((Integer) this.cts.getTileDef(this.tIdx)).intValue() == 0) {
            this.transfType = 0;
            return;
        }
        int numComps = this.src.getNumComps() > 3 ? 3 : this.src.getNumComps();
        int i3 = 0;
        for (int i4 = 0; i4 < numComps; i4++) {
            i3 += this.wfs.isReversible(this.tIdx, i4) ? 1 : 0;
        }
        if (i3 == 3) {
            this.transfType = 1;
        } else if (i3 == 0) {
            this.transfType = 2;
        } else {
            throw new IllegalArgumentException("Wavelet transformation and component transformation not coherent in tile" + this.tIdx);
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void nextTile() {
        this.src.nextTile();
        this.tIdx = getTileIdx();
        if (((Integer) this.cts.getTileDef(this.tIdx)).intValue() == 0) {
            this.transfType = 0;
            return;
        }
        int numComps = this.src.getNumComps() > 3 ? 3 : this.src.getNumComps();
        int i = 0;
        for (int i2 = 0; i2 < numComps; i2++) {
            i += this.wfs.isReversible(this.tIdx, i2) ? 1 : 0;
        }
        if (i == 3) {
            this.transfType = 1;
        } else if (i == 0) {
            this.transfType = 2;
        } else {
            throw new IllegalArgumentException("Wavelet transformation and component transformation not coherent in tile" + this.tIdx);
        }
    }
}
