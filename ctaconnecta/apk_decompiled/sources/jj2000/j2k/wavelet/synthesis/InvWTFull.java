package jj2000.j2k.wavelet.synthesis;

import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.image.Coord;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ProgressWatch;
import jj2000.j2k.wavelet.Subband;

/* loaded from: classes5.dex */
public class InvWTFull extends InverseWT {
    private int cblkToDecode;
    private int dtype;
    private int nDecCblk;
    private int[] ndl;
    private ProgressWatch pw;
    private DataBlk[] reconstructedComps;
    private boolean[][] reversible;
    private CBlkWTDataSrcDec src;

    @Override // jj2000.j2k.wavelet.WaveletTransform
    public int getImplementationType(int i) {
        return 2;
    }

    public InvWTFull(CBlkWTDataSrcDec cBlkWTDataSrcDec, DecoderSpecs decoderSpecs) {
        super(cBlkWTDataSrcDec, decoderSpecs);
        this.pw = null;
        this.cblkToDecode = 0;
        this.nDecCblk = 0;
        this.src = cBlkWTDataSrcDec;
        int numComps = cBlkWTDataSrcDec.getNumComps();
        this.reconstructedComps = new DataBlk[numComps];
        this.ndl = new int[numComps];
        this.pw = FacilityManager.getProgressWatch();
    }

    private boolean isSubbandReversible(Subband subband) {
        if (!subband.isNode) {
            return true;
        }
        if (!isSubbandReversible(subband.getLL()) || !isSubbandReversible(subband.getHL()) || !isSubbandReversible(subband.getLH()) || !isSubbandReversible(subband.getHH())) {
            return false;
        }
        SubbandSyn subbandSyn = (SubbandSyn) subband;
        return subbandSyn.hFilter.isReversible() && subbandSyn.vFilter.isReversible();
    }

    @Override // jj2000.j2k.wavelet.WaveletTransform, jj2000.j2k.wavelet.analysis.ForwWTDataProps
    public boolean isReversible(int i, int i2) {
        boolean[][] zArr = this.reversible;
        if (zArr[i] == null) {
            zArr[i] = new boolean[getNumComps()];
            for (int length = this.reversible.length - 1; length >= 0; length--) {
                this.reversible[i][length] = isSubbandReversible(this.src.getSynSubbandTree(i, length));
            }
        }
        return this.reversible[i][i2];
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        return this.src.getNomRangeBits(i);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(i);
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getInternCompData(DataBlk dataBlk, int i) {
        DataBlk dataBlkFloat;
        int tileIdx = getTileIdx();
        if (this.src.getSynSubbandTree(tileIdx, i).getHorWFilter() == null) {
            this.dtype = 3;
        } else {
            this.dtype = this.src.getSynSubbandTree(tileIdx, i).getHorWFilter().getDataType();
        }
        DataBlk[] dataBlkArr = this.reconstructedComps;
        if (dataBlkArr[i] == null) {
            int i2 = this.dtype;
            if (i2 == 3) {
                dataBlkArr[i] = new DataBlkInt(0, 0, getTileCompWidth(tileIdx, i), getTileCompHeight(tileIdx, i));
            } else if (i2 == 4) {
                dataBlkArr[i] = new DataBlkFloat(0, 0, getTileCompWidth(tileIdx, i), getTileCompHeight(tileIdx, i));
            }
            waveletTreeReconstruction(this.reconstructedComps[i], this.src.getSynSubbandTree(tileIdx, i), i);
            if (this.pw != null && i == this.src.getNumComps() - 1) {
                this.pw.terminateProgressWatch();
            }
        }
        int dataType = dataBlk.getDataType();
        int i3 = this.dtype;
        if (dataType != i3) {
            if (i3 == 3) {
                dataBlkFloat = new DataBlkInt(dataBlk.ulx, dataBlk.uly, dataBlk.w, dataBlk.h);
            } else {
                dataBlkFloat = new DataBlkFloat(dataBlk.ulx, dataBlk.uly, dataBlk.w, dataBlk.h);
            }
            dataBlk = dataBlkFloat;
        }
        dataBlk.setData(this.reconstructedComps[i].getData());
        dataBlk.offset = (this.reconstructedComps[i].w * dataBlk.uly) + dataBlk.ulx;
        dataBlk.scanw = this.reconstructedComps[i].w;
        dataBlk.progressive = false;
        return dataBlk;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    @Override // jj2000.j2k.image.BlkImgDataSrc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        float[] fArr;
        int dataType = dataBlk.getDataType();
        if (dataType == 3) {
            int[] iArr = (int[]) dataBlk.getData();
            if (iArr != null) {
                int length = iArr.length;
                fArr = iArr;
                if (length < dataBlk.w * dataBlk.h) {
                    fArr = new int[dataBlk.w * dataBlk.h];
                }
            }
        } else if (dataType != 4) {
            fArr = null;
        } else {
            float[] fArr2 = (float[]) dataBlk.getData();
            if (fArr2 != null) {
                int length2 = fArr2.length;
                fArr = fArr2;
                if (length2 < dataBlk.w * dataBlk.h) {
                    fArr = new float[dataBlk.w * dataBlk.h];
                }
            }
        }
        DataBlk internCompData = getInternCompData(dataBlk, i);
        internCompData.setData(fArr);
        internCompData.offset = 0;
        internCompData.scanw = internCompData.w;
        return internCompData;
    }

    private void wavelet2DReconstruction(DataBlk dataBlk, SubbandSyn subbandSyn, int i) {
        float[] fArr;
        int i2;
        int i3;
        float[] fArr2;
        int i4;
        int i5;
        if (subbandSyn.w == 0 || subbandSyn.h == 0) {
            return;
        }
        Object data = dataBlk.getData();
        int i6 = subbandSyn.ulx;
        int i7 = subbandSyn.uly;
        int i8 = subbandSyn.w;
        int i9 = subbandSyn.h;
        int dataType = subbandSyn.getHorWFilter().getDataType();
        if (dataType == 3) {
            fArr = new int[i8 >= i9 ? i8 : i9];
        } else if (dataType != 4) {
            fArr = null;
        } else {
            fArr = new float[i8 >= i9 ? i8 : i9];
        }
        int i10 = (((i7 - dataBlk.uly) * dataBlk.w) + i6) - dataBlk.ulx;
        int i11 = 0;
        if (subbandSyn.ulcx % 2 == 0) {
            int i12 = i10;
            int i13 = 0;
            while (i13 < i9) {
                System.arraycopy(data, i12, fArr, i11, i8);
                int i14 = i8;
                int i15 = (i14 + 1) / 2;
                int i16 = i9;
                float[] fArr3 = fArr;
                subbandSyn.hFilter.synthetize_lpf(fArr3, 0, i15, 1, fArr3, i15, i14 / 2, 1, data, i12, 1);
                i13++;
                i12 += dataBlk.w;
                fArr = fArr3;
                i8 = i14;
                i7 = i7;
                i11 = 0;
                i9 = i16;
                i6 = i6;
            }
            i2 = i6;
            i3 = i9;
            i4 = i7;
            i5 = i8;
            fArr2 = fArr;
        } else {
            i2 = i6;
            i3 = i9;
            fArr2 = fArr;
            i4 = i7;
            i5 = i8;
            int i17 = i10;
            int i18 = 0;
            while (i18 < i3) {
                System.arraycopy(data, i17, fArr2, 0, i5);
                int i19 = i5 / 2;
                subbandSyn.hFilter.synthetize_hpf(fArr2, 0, i19, 1, fArr2, i19, (i5 + 1) / 2, 1, data, i17, 1);
                i18++;
                i17 += dataBlk.w;
            }
        }
        int i20 = (((i4 - dataBlk.uly) * dataBlk.w) + i2) - dataBlk.ulx;
        int dataType2 = subbandSyn.getVerWFilter().getDataType();
        if (dataType2 == 3) {
            int[] iArr = (int[]) data;
            int[] iArr2 = (int[]) fArr2;
            if (subbandSyn.ulcy % 2 == 0) {
                int i21 = i20;
                int i22 = 0;
                while (i22 < i5) {
                    int i23 = i3 - 1;
                    int i24 = (dataBlk.w * i23) + i21;
                    while (i23 >= 0) {
                        iArr2[i23] = iArr[i24];
                        i23--;
                        i24 -= dataBlk.w;
                    }
                    int i25 = (i3 + 1) / 2;
                    subbandSyn.vFilter.synthetize_lpf(fArr2, 0, i25, 1, fArr2, i25, i3 / 2, 1, data, i21, dataBlk.w);
                    i22++;
                    i21++;
                }
                return;
            }
            int i26 = i20;
            int i27 = 0;
            while (i27 < i5) {
                int i28 = i3 - 1;
                int i29 = (dataBlk.w * i28) + i26;
                while (i28 >= 0) {
                    iArr2[i28] = iArr[i29];
                    i28--;
                    i29 -= dataBlk.w;
                }
                int i30 = i3 / 2;
                subbandSyn.vFilter.synthetize_hpf(fArr2, 0, i30, 1, fArr2, i30, (i3 + 1) / 2, 1, data, i26, dataBlk.w);
                i27++;
                i26++;
            }
            return;
        }
        if (dataType2 != 4) {
            return;
        }
        float[] fArr4 = (float[]) data;
        float[] fArr5 = fArr2;
        if (subbandSyn.ulcy % 2 == 0) {
            int i31 = i20;
            int i32 = 0;
            while (i32 < i5) {
                int i33 = i3 - 1;
                int i34 = (dataBlk.w * i33) + i31;
                while (i33 >= 0) {
                    fArr5[i33] = fArr4[i34];
                    i33--;
                    i34 -= dataBlk.w;
                }
                int i35 = (i3 + 1) / 2;
                subbandSyn.vFilter.synthetize_lpf(fArr2, 0, i35, 1, fArr2, i35, i3 / 2, 1, data, i31, dataBlk.w);
                i32++;
                i31++;
            }
            return;
        }
        int i36 = i20;
        int i37 = 0;
        while (i37 < i5) {
            int i38 = i3 - 1;
            int i39 = (dataBlk.w * i38) + i36;
            while (i38 >= 0) {
                fArr5[i38] = fArr4[i39];
                i38--;
                i39 -= dataBlk.w;
            }
            int i40 = i3 / 2;
            subbandSyn.vFilter.synthetize_hpf(fArr2, 0, i40, 1, fArr2, i40, (i3 + 1) / 2, 1, data, i36, dataBlk.w);
            i37++;
            i36++;
        }
    }

    private void waveletTreeReconstruction(DataBlk dataBlk, SubbandSyn subbandSyn, int i) {
        DataBlk dataBlkFloat;
        if (!subbandSyn.isNode) {
            if (subbandSyn.w == 0 || subbandSyn.h == 0) {
                return;
            }
            if (this.dtype == 3) {
                dataBlkFloat = new DataBlkInt();
            } else {
                dataBlkFloat = new DataBlkFloat();
            }
            Coord coord = subbandSyn.numCb;
            Object data = dataBlk.getData();
            int i2 = 0;
            while (i2 < coord.y) {
                DataBlk internCodeBlock = dataBlkFloat;
                int i3 = 0;
                while (i3 < coord.x) {
                    SubbandSyn subbandSyn2 = subbandSyn;
                    int i4 = i;
                    internCodeBlock = this.src.getInternCodeBlock(i4, i2, i3, subbandSyn2, internCodeBlock);
                    Object data2 = internCodeBlock.getData();
                    ProgressWatch progressWatch = this.pw;
                    if (progressWatch != null) {
                        int i5 = this.nDecCblk + 1;
                        this.nDecCblk = i5;
                        progressWatch.updateProgressWatch(i5, null);
                    }
                    for (int i6 = internCodeBlock.h - 1; i6 >= 0; i6--) {
                        System.arraycopy(data2, internCodeBlock.offset + (internCodeBlock.scanw * i6), data, ((internCodeBlock.uly + i6) * dataBlk.w) + internCodeBlock.ulx, internCodeBlock.w);
                    }
                    i3++;
                    i = i4;
                    subbandSyn = subbandSyn2;
                }
                i2++;
                dataBlkFloat = internCodeBlock;
            }
            return;
        }
        if (subbandSyn.isNode) {
            waveletTreeReconstruction(dataBlk, (SubbandSyn) subbandSyn.getLL(), i);
            if (subbandSyn.resLvl <= (this.reslvl - this.maxImgRes) + this.ndl[i]) {
                waveletTreeReconstruction(dataBlk, (SubbandSyn) subbandSyn.getHL(), i);
                waveletTreeReconstruction(dataBlk, (SubbandSyn) subbandSyn.getLH(), i);
                waveletTreeReconstruction(dataBlk, (SubbandSyn) subbandSyn.getHH(), i);
                wavelet2DReconstruction(dataBlk, subbandSyn, i);
            }
        }
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTAdapter, jj2000.j2k.image.ImgData
    public void setTile(int i, int i2) {
        super.setTile(i, i2);
        int numComps = this.src.getNumComps();
        int tileIdx = this.src.getTileIdx();
        for (int i3 = 0; i3 < numComps; i3++) {
            this.ndl[i3] = this.src.getSynSubbandTree(tileIdx, i3).resLvl;
        }
        DataBlk[] dataBlkArr = this.reconstructedComps;
        if (dataBlkArr != null) {
            for (int length = dataBlkArr.length - 1; length >= 0; length--) {
                this.reconstructedComps[length] = null;
            }
        }
        this.cblkToDecode = 0;
        for (int i4 = 0; i4 < numComps; i4++) {
            SubbandSyn synSubbandTree = this.src.getSynSubbandTree(tileIdx, i4);
            for (int i5 = 0; i5 <= (this.reslvl - this.maxImgRes) + synSubbandTree.resLvl; i5++) {
                if (i5 == 0) {
                    SubbandSyn subbandSyn = (SubbandSyn) synSubbandTree.getSubbandByIdx(0, 0);
                    if (subbandSyn != null) {
                        this.cblkToDecode += subbandSyn.numCb.x * subbandSyn.numCb.y;
                    }
                } else {
                    SubbandSyn subbandSyn2 = (SubbandSyn) synSubbandTree.getSubbandByIdx(i5, 1);
                    if (subbandSyn2 != null) {
                        this.cblkToDecode += subbandSyn2.numCb.x * subbandSyn2.numCb.y;
                    }
                    SubbandSyn subbandSyn3 = (SubbandSyn) synSubbandTree.getSubbandByIdx(i5, 2);
                    if (subbandSyn3 != null) {
                        this.cblkToDecode += subbandSyn3.numCb.x * subbandSyn3.numCb.y;
                    }
                    SubbandSyn subbandSyn4 = (SubbandSyn) synSubbandTree.getSubbandByIdx(i5, 3);
                    if (subbandSyn4 != null) {
                        this.cblkToDecode += subbandSyn4.numCb.x * subbandSyn4.numCb.y;
                    }
                }
            }
        }
        this.nDecCblk = 0;
        ProgressWatch progressWatch = this.pw;
        if (progressWatch != null) {
            progressWatch.initProgressWatch(0, this.cblkToDecode, "Decoding tile " + tileIdx + "...");
        }
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTAdapter, jj2000.j2k.image.ImgData
    public void nextTile() {
        super.nextTile();
        int numComps = this.src.getNumComps();
        int tileIdx = this.src.getTileIdx();
        for (int i = 0; i < numComps; i++) {
            this.ndl[i] = this.src.getSynSubbandTree(tileIdx, i).resLvl;
        }
        DataBlk[] dataBlkArr = this.reconstructedComps;
        if (dataBlkArr != null) {
            for (int length = dataBlkArr.length - 1; length >= 0; length--) {
                this.reconstructedComps[length] = null;
            }
        }
    }
}
