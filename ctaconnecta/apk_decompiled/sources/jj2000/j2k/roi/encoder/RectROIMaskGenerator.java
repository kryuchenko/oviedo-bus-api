package jj2000.j2k.roi.encoder;

import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.wavelet.Subband;

/* loaded from: classes5.dex */
public class RectROIMaskGenerator extends ROIMaskGenerator {
    private int[] lrxs;
    private int[] lrys;
    private int[] nrROIs;
    private SubbandRectROIMask[] sMasks;
    private int[] ulxs;
    private int[] ulys;

    public RectROIMaskGenerator(ROI[] roiArr, int i) {
        super(roiArr, i);
        int length = roiArr.length;
        this.nrROIs = new int[i];
        this.sMasks = new SubbandRectROIMask[i];
        for (int i2 = length - 1; i2 >= 0; i2--) {
            int[] iArr = this.nrROIs;
            int i3 = roiArr[i2].comp;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // jj2000.j2k.roi.encoder.ROIMaskGenerator
    public boolean getROIMask(DataBlkInt dataBlkInt, Subband subband, int i, int i2) {
        int i3 = dataBlkInt.ulx;
        int i4 = dataBlkInt.uly;
        int i5 = dataBlkInt.w;
        int i6 = dataBlkInt.h;
        int[] dataInt = dataBlkInt.getDataInt();
        if (!this.tileMaskMade[i2]) {
            makeMask(subband, i, i2);
            this.tileMaskMade[i2] = true;
        }
        if (!this.roiInTile) {
            return false;
        }
        SubbandRectROIMask subbandRectROIMask = (SubbandRectROIMask) this.sMasks[i2].getSubbandRectROIMask(i3, i4);
        int[] iArr = subbandRectROIMask.ulxs;
        int[] iArr2 = subbandRectROIMask.ulys;
        int[] iArr3 = subbandRectROIMask.lrxs;
        int[] iArr4 = subbandRectROIMask.lrys;
        int i7 = i3 - subbandRectROIMask.ulx;
        int i8 = i4 - subbandRectROIMask.uly;
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i9 = iArr[length] - i7;
            if (i9 < 0) {
                i9 = 0;
            } else if (i9 >= i5) {
                i9 = i5;
            }
            int i10 = iArr2[length] - i8;
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= i6) {
                i10 = i6;
            }
            int i11 = iArr3[length] - i7;
            if (i11 < 0) {
                i11 = -1;
            } else if (i11 >= i5) {
                i11 = i5 - 1;
            }
            int i12 = iArr4[length] - i8;
            int i13 = i12 >= 0 ? i12 >= i6 ? i6 - 1 : i12 : -1;
            int i14 = (i5 * i13) + i11;
            int i15 = i11 - i9;
            int i16 = (i5 - i15) - 1;
            for (int i17 = i13 - i10; i17 >= 0; i17--) {
                int i18 = i15;
                while (i18 >= 0) {
                    dataInt[i14] = i;
                    i18--;
                    i14--;
                }
                i14 -= i16;
            }
        }
        return true;
    }

    public String toString() {
        return "Fast rectangular ROI mask generator";
    }

    @Override // jj2000.j2k.roi.encoder.ROIMaskGenerator
    public void makeMask(Subband subband, int i, int i2) {
        int i3 = this.nrROIs[i2];
        int i4 = subband.ulcx;
        int i5 = subband.ulcy;
        int i6 = subband.w;
        int i7 = subband.h;
        ROI[] roiArr = this.rois;
        this.ulxs = new int[i3];
        this.ulys = new int[i3];
        this.lrxs = new int[i3];
        this.lrys = new int[i3];
        int i8 = 1;
        int length = roiArr.length - 1;
        int i9 = 0;
        while (length >= 0) {
            if (roiArr[length].comp == i2) {
                int i10 = roiArr[length].ulx;
                int i11 = roiArr[length].uly;
                int i12 = (roiArr[length].w + i10) - i8;
                int i13 = (roiArr[length].h + i11) - i8;
                if (i10 <= (i4 + i6) - 1 && i11 <= (i5 + i7) - 1 && i12 >= i4 && i13 >= i5) {
                    int i14 = i10 - i4;
                    int i15 = i12 - i4;
                    int i16 = i11 - i5;
                    int i17 = i13 - i5;
                    if (i14 < 0) {
                        i14 = 0;
                    }
                    if (i16 < 0) {
                        i16 = 0;
                    }
                    int i18 = i6 - 1;
                    if (i15 > i18) {
                        i15 = i18;
                    }
                    int i19 = i7 - 1;
                    if (i17 > i19) {
                        i17 = i19;
                    }
                    this.ulxs[i9] = i14;
                    this.ulys[i9] = i16;
                    this.lrxs[i9] = i15;
                    this.lrys[i9] = i17;
                    i9++;
                }
            }
            length--;
            i8 = 1;
        }
        if (i9 == 0) {
            this.roiInTile = false;
        } else {
            this.roiInTile = true;
        }
        this.sMasks[i2] = new SubbandRectROIMask(subband, this.ulxs, this.ulys, this.lrxs, this.lrys, i9);
    }
}
