package jj2000.j2k.image.forwcomptransf;

import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.CompTransfSpec;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.wavelet.analysis.AnWTFilterSpec;

/* loaded from: classes5.dex */
public class ForwCompTransf extends ImgDataAdapter implements BlkImgDataSrc {
    public static final int FORW_ICT = 2;
    public static final int FORW_RCT = 1;
    public static final int NONE = 0;
    public static final char OPT_PREFIX = 'M';
    private static final String[][] pinfo = {new String[]{"Mct", "[<tile index>] [on|off] ...", "Specifies in which tiles to use a multiple component transform. Note that this multiple component transform can only be applied in tiles that contain at least three components and whose components are processed with the same wavelet filters and quantization type. If the wavelet transform is reversible (w5x3 filter), the Reversible Component Transformation (RCT) is applied. If not (w9x7 filter), the Irreversible Component Transformation (ICT) is used.", null}};
    private DataBlkInt block0;
    private DataBlkInt block1;
    private DataBlkInt block2;
    private CompTransfSpec cts;
    private DataBlk outBlk;
    private BlkImgDataSrc src;
    private int[] tdepth;
    private int transfType;
    private AnWTFilterSpec wfs;

    public ForwCompTransf(BlkImgDataSrc blkImgDataSrc, EncoderSpecs encoderSpecs) {
        super(blkImgDataSrc);
        this.transfType = 0;
        this.cts = encoderSpecs.cts;
        this.wfs = encoderSpecs.wfs;
        this.src = blkImgDataSrc;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(i);
    }

    public static String[][] getParameterInfo() {
        return pinfo;
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

    private void initForwRCT() {
        int tileIdx = getTileIdx();
        if (this.src.getNumComps() < 3) {
            throw new IllegalArgumentException();
        }
        if (this.src.getTileCompWidth(tileIdx, 0) != this.src.getTileCompWidth(tileIdx, 1) || this.src.getTileCompWidth(tileIdx, 0) != this.src.getTileCompWidth(tileIdx, 2) || this.src.getTileCompHeight(tileIdx, 0) != this.src.getTileCompHeight(tileIdx, 1) || this.src.getTileCompHeight(tileIdx, 0) != this.src.getTileCompHeight(tileIdx, 2)) {
            throw new IllegalArgumentException("Can not use RCT on components with different dimensions");
        }
        int numComps = this.src.getNumComps();
        int[] iArr = new int[numComps];
        for (int i = numComps - 1; i >= 0; i--) {
            iArr[i] = this.src.getNomRangeBits(i);
        }
        this.tdepth = calcMixedBitDepths(iArr, 1, null);
    }

    private void initForwICT() {
        int tileIdx = getTileIdx();
        if (this.src.getNumComps() < 3) {
            throw new IllegalArgumentException();
        }
        if (this.src.getTileCompWidth(tileIdx, 0) != this.src.getTileCompWidth(tileIdx, 1) || this.src.getTileCompWidth(tileIdx, 0) != this.src.getTileCompWidth(tileIdx, 2) || this.src.getTileCompHeight(tileIdx, 0) != this.src.getTileCompHeight(tileIdx, 1) || this.src.getTileCompHeight(tileIdx, 0) != this.src.getTileCompHeight(tileIdx, 2)) {
            throw new IllegalArgumentException("Can not use ICT on components with different dimensions");
        }
        int numComps = this.src.getNumComps();
        int[] iArr = new int[numComps];
        for (int i = numComps - 1; i >= 0; i--) {
            iArr[i] = this.src.getNomRangeBits(i);
        }
        this.tdepth = calcMixedBitDepths(iArr, 2, null);
    }

    public String toString() {
        int i = this.transfType;
        if (i == 0) {
            return "No component transformation";
        }
        if (i == 1) {
            return "Forward RCT";
        }
        if (i == 2) {
            return "Forward ICT";
        }
        throw new IllegalArgumentException("Non JPEG 2000 part I component transformation");
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        int i2 = this.transfType;
        if (i2 == 0) {
            return this.src.getNomRangeBits(i);
        }
        if (i2 == 1 || i2 == 2) {
            return this.tdepth[i];
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
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        if (i >= 3 || this.transfType == 0) {
            return this.src.getCompData(dataBlk, i);
        }
        return getInternCompData(dataBlk, i);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        int i2 = this.transfType;
        if (i2 == 0) {
            return this.src.getInternCompData(dataBlk, i);
        }
        if (i2 == 1) {
            return forwRCT(dataBlk, i);
        }
        if (i2 == 2) {
            return forwICT(dataBlk, i);
        }
        throw new IllegalArgumentException("Non JPEG 2000 part 1 component transformation for tile: " + this.tIdx);
    }

    private DataBlk forwRCT(DataBlk dataBlk, int i) {
        int i2 = dataBlk.w;
        int i3 = dataBlk.h;
        if (i < 0 || i > 2) {
            if (i >= 3) {
                return this.src.getInternCompData(dataBlk, i);
            }
            throw new IllegalArgumentException();
        }
        if (dataBlk.getDataType() != 3) {
            DataBlk dataBlk2 = this.outBlk;
            if (dataBlk2 == null || dataBlk2.getDataType() != 3) {
                this.outBlk = new DataBlkInt();
            }
            this.outBlk.w = i2;
            this.outBlk.h = i3;
            this.outBlk.ulx = dataBlk.ulx;
            this.outBlk.uly = dataBlk.uly;
            dataBlk = this.outBlk;
        }
        int[] iArr = (int[]) dataBlk.getData();
        if (iArr == null || iArr.length < i3 * i2) {
            iArr = new int[i3 * i2];
            dataBlk.setData(iArr);
        }
        if (this.block0 == null) {
            this.block0 = new DataBlkInt();
        }
        if (this.block1 == null) {
            this.block1 = new DataBlkInt();
        }
        if (this.block2 == null) {
            this.block2 = new DataBlkInt();
        }
        DataBlkInt dataBlkInt = this.block0;
        DataBlkInt dataBlkInt2 = this.block1;
        DataBlkInt dataBlkInt3 = this.block2;
        int i4 = dataBlk.w;
        dataBlkInt3.w = i4;
        dataBlkInt2.w = i4;
        dataBlkInt.w = i4;
        DataBlkInt dataBlkInt4 = this.block0;
        DataBlkInt dataBlkInt5 = this.block1;
        DataBlkInt dataBlkInt6 = this.block2;
        int i5 = dataBlk.h;
        dataBlkInt6.h = i5;
        dataBlkInt5.h = i5;
        dataBlkInt4.h = i5;
        DataBlkInt dataBlkInt7 = this.block0;
        DataBlkInt dataBlkInt8 = this.block1;
        DataBlkInt dataBlkInt9 = this.block2;
        int i6 = dataBlk.ulx;
        dataBlkInt9.ulx = i6;
        dataBlkInt8.ulx = i6;
        dataBlkInt7.ulx = i6;
        DataBlkInt dataBlkInt10 = this.block0;
        DataBlkInt dataBlkInt11 = this.block1;
        DataBlkInt dataBlkInt12 = this.block2;
        int i7 = dataBlk.uly;
        dataBlkInt12.uly = i7;
        dataBlkInt11.uly = i7;
        dataBlkInt10.uly = i7;
        DataBlkInt dataBlkInt13 = (DataBlkInt) this.src.getInternCompData(this.block0, 0);
        this.block0 = dataBlkInt13;
        int[] iArr2 = (int[]) dataBlkInt13.getData();
        DataBlkInt dataBlkInt14 = (DataBlkInt) this.src.getInternCompData(this.block1, 1);
        this.block1 = dataBlkInt14;
        int[] iArr3 = (int[]) dataBlkInt14.getData();
        DataBlkInt dataBlkInt15 = (DataBlkInt) this.src.getInternCompData(this.block2, 2);
        this.block2 = dataBlkInt15;
        int[] iArr4 = (int[]) dataBlkInt15.getData();
        dataBlk.progressive = this.block0.progressive || this.block1.progressive || this.block2.progressive;
        dataBlk.offset = 0;
        dataBlk.scanw = i2;
        int i8 = (i2 * i3) - 1;
        int i9 = i3 - 1;
        int i10 = ((this.block0.offset + (this.block0.scanw * i9)) + i2) - 1;
        int i11 = ((this.block1.offset + (this.block1.scanw * i9)) + i2) - 1;
        int i12 = ((this.block2.offset + (this.block2.scanw * i9)) + i2) - 1;
        if (i == 0) {
            while (i9 >= 0) {
                int i13 = i8 - i2;
                while (i8 > i13) {
                    iArr[i8] = ((iArr2[i8] + (iArr3[i8] * 2)) + iArr4[i8]) >> 2;
                    i8--;
                }
                int i14 = this.block0.scanw;
                int i15 = this.block1.scanw;
                int i16 = this.block2.scanw;
                i9--;
            }
        } else if (i == 1) {
            while (i9 >= 0) {
                int i17 = i8 - i2;
                while (i8 > i17) {
                    iArr[i8] = iArr4[i12] - iArr3[i11];
                    i8--;
                    i11--;
                    i12--;
                }
                i11 -= this.block1.scanw - i2;
                i12 -= this.block2.scanw - i2;
                i9--;
            }
        } else if (i == 2) {
            while (i9 >= 0) {
                int i18 = i8 - i2;
                while (i8 > i18) {
                    iArr[i8] = iArr2[i10] - iArr3[i11];
                    i8--;
                    i10--;
                    i11--;
                }
                i10 -= this.block0.scanw - i2;
                i11 -= this.block1.scanw - i2;
                i9--;
            }
        }
        return dataBlk;
    }

    private DataBlk forwICT(DataBlk dataBlk, int i) {
        DataBlk dataBlk2 = dataBlk;
        int i2 = dataBlk2.w;
        int i3 = dataBlk2.h;
        if (dataBlk2.getDataType() != 4) {
            DataBlk dataBlk3 = this.outBlk;
            if (dataBlk3 == null || dataBlk3.getDataType() != 4) {
                this.outBlk = new DataBlkFloat();
            }
            this.outBlk.w = i2;
            this.outBlk.h = i3;
            this.outBlk.ulx = dataBlk2.ulx;
            this.outBlk.uly = dataBlk2.uly;
            dataBlk2 = this.outBlk;
        }
        float[] fArr = (float[]) dataBlk2.getData();
        if (fArr == null || fArr.length < i2 * i3) {
            fArr = new float[i3 * i2];
            dataBlk2.setData(fArr);
        }
        if (i < 0 || i > 2) {
            if (i >= 3) {
                DataBlkInt dataBlkInt = new DataBlkInt(dataBlk2.ulx, dataBlk2.uly, i2, i3);
                this.src.getInternCompData(dataBlkInt, i);
                int[] iArr = (int[]) dataBlkInt.getData();
                int i4 = (i2 * i3) - 1;
                int i5 = i3 - 1;
                int i6 = ((dataBlkInt.offset + (dataBlkInt.scanw * i5)) + i2) - 1;
                while (i5 >= 0) {
                    int i7 = i4 - i2;
                    while (i4 > i7) {
                        fArr[i4] = iArr[i6];
                        i4--;
                        i6--;
                    }
                    i6 += dataBlkInt.w - i2;
                    i5--;
                }
                dataBlk2.progressive = dataBlkInt.progressive;
                dataBlk2.offset = 0;
                dataBlk2.scanw = i2;
                return dataBlk2;
            }
            throw new IllegalArgumentException();
        }
        if (this.block0 == null) {
            this.block0 = new DataBlkInt();
        }
        if (this.block1 == null) {
            this.block1 = new DataBlkInt();
        }
        if (this.block2 == null) {
            this.block2 = new DataBlkInt();
        }
        DataBlkInt dataBlkInt2 = this.block0;
        DataBlkInt dataBlkInt3 = this.block1;
        DataBlkInt dataBlkInt4 = this.block2;
        int i8 = dataBlk2.w;
        dataBlkInt4.w = i8;
        dataBlkInt3.w = i8;
        dataBlkInt2.w = i8;
        DataBlkInt dataBlkInt5 = this.block0;
        DataBlkInt dataBlkInt6 = this.block1;
        DataBlkInt dataBlkInt7 = this.block2;
        int i9 = dataBlk2.h;
        dataBlkInt7.h = i9;
        dataBlkInt6.h = i9;
        dataBlkInt5.h = i9;
        DataBlkInt dataBlkInt8 = this.block0;
        DataBlkInt dataBlkInt9 = this.block1;
        DataBlkInt dataBlkInt10 = this.block2;
        int i10 = dataBlk2.ulx;
        dataBlkInt10.ulx = i10;
        dataBlkInt9.ulx = i10;
        dataBlkInt8.ulx = i10;
        DataBlkInt dataBlkInt11 = this.block0;
        DataBlkInt dataBlkInt12 = this.block1;
        DataBlkInt dataBlkInt13 = this.block2;
        int i11 = dataBlk2.uly;
        dataBlkInt13.uly = i11;
        dataBlkInt12.uly = i11;
        dataBlkInt11.uly = i11;
        DataBlkInt dataBlkInt14 = (DataBlkInt) this.src.getInternCompData(this.block0, 0);
        this.block0 = dataBlkInt14;
        int[] iArr2 = (int[]) dataBlkInt14.getData();
        DataBlkInt dataBlkInt15 = (DataBlkInt) this.src.getInternCompData(this.block1, 1);
        this.block1 = dataBlkInt15;
        int[] iArr3 = (int[]) dataBlkInt15.getData();
        DataBlkInt dataBlkInt16 = (DataBlkInt) this.src.getInternCompData(this.block2, 2);
        this.block2 = dataBlkInt16;
        int[] iArr4 = (int[]) dataBlkInt16.getData();
        dataBlk2.progressive = this.block0.progressive || this.block1.progressive || this.block2.progressive;
        dataBlk2.offset = 0;
        dataBlk2.scanw = i2;
        int i12 = (i2 * i3) - 1;
        int i13 = i3 - 1;
        int i14 = ((this.block0.offset + (this.block0.scanw * i13)) + i2) - 1;
        int i15 = ((this.block1.offset + (this.block1.scanw * i13)) + i2) - 1;
        int i16 = ((this.block2.offset + (this.block2.scanw * i13)) + i2) - 1;
        if (i == 0) {
            while (i13 >= 0) {
                int i17 = i12 - i2;
                while (i12 > i17) {
                    fArr[i12] = (iArr2[i14] * 0.299f) + (iArr3[i15] * 0.587f) + (iArr4[i16] * 0.114f);
                    i12--;
                    i14--;
                    i15--;
                    i16--;
                }
                i14 -= this.block0.scanw - i2;
                i15 -= this.block1.scanw - i2;
                i16 -= this.block2.scanw - i2;
                i13--;
            }
        } else if (i == 1) {
            while (i13 >= 0) {
                int i18 = i12 - i2;
                while (i12 > i18) {
                    fArr[i12] = ((iArr2[i14] * (-0.16875f)) - (iArr3[i15] * 0.33126f)) + (iArr4[i16] * 0.5f);
                    i12--;
                    i14--;
                    i15--;
                    i16--;
                }
                i14 -= this.block0.scanw - i2;
                i15 -= this.block1.scanw - i2;
                i16 -= this.block2.scanw - i2;
                i13--;
            }
        } else if (i == 2) {
            while (i13 >= 0) {
                int i19 = i12 - i2;
                while (i12 > i19) {
                    fArr[i12] = ((iArr2[i14] * 0.5f) - (iArr3[i15] * 0.41869f)) - (iArr4[i16] * 0.08131f);
                    i12--;
                    i14--;
                    i15--;
                    i16--;
                }
                i14 -= this.block0.scanw - i2;
                i15 -= this.block1.scanw - i2;
                i16 -= this.block2.scanw - i2;
                i13--;
            }
        }
        return dataBlk2;
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        this.src.setTile(i, i2);
        this.tIdx = getTileIdx();
        String str = (String) this.cts.getTileDef(this.tIdx);
        if (str.equals("none")) {
            this.transfType = 0;
            return;
        }
        if (str.equals("rct")) {
            this.transfType = 1;
            initForwRCT();
        } else {
            if (str.equals("ict")) {
                this.transfType = 2;
                initForwICT();
                return;
            }
            throw new IllegalArgumentException("Component transformation not recognized");
        }
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public void nextTile() {
        this.src.nextTile();
        this.tIdx = getTileIdx();
        String str = (String) this.cts.getTileDef(this.tIdx);
        if (str.equals("none")) {
            this.transfType = 0;
            return;
        }
        if (str.equals("rct")) {
            this.transfType = 1;
            initForwRCT();
        } else {
            if (str.equals("ict")) {
                this.transfType = 2;
                initForwICT();
                return;
            }
            throw new IllegalArgumentException("Component transformation not recognized");
        }
    }
}
