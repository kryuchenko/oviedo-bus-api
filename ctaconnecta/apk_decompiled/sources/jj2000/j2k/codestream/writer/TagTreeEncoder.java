package jj2000.j2k.codestream.writer;

import jj2000.j2k.util.ArrayUtil;

/* loaded from: classes5.dex */
public class TagTreeEncoder {
    protected int h;
    protected int lvls;
    protected boolean saved;
    protected int[][] treeS;
    protected int[][] treeSbak;
    protected int[][] treeV;
    protected int[][] treeVbak;
    protected int w;

    public TagTreeEncoder(int i, int i2) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException();
        }
        init(i2, i);
        for (int length = this.treeV.length - 1; length >= 0; length--) {
            ArrayUtil.intArraySet(this.treeV[length], Integer.MAX_VALUE);
        }
    }

    public TagTreeEncoder(int i, int i2, int[] iArr) {
        int i3;
        if (i2 < 0 || i < 0 || iArr.length < (i3 = i2 * i)) {
            throw new IllegalArgumentException();
        }
        init(i2, i);
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            this.treeV[0][i4] = iArr[i4];
        }
        recalcTreeV();
    }

    public final int getWidth() {
        return this.w;
    }

    public final int getHeight() {
        return this.h;
    }

    private void init(int i, int i2) {
        this.w = i;
        this.h = i2;
        if (i == 0 || i2 == 0) {
            this.lvls = 0;
        } else {
            this.lvls = 1;
            while (true) {
                if (i2 == 1 && i == 1) {
                    break;
                }
                i = (i + 1) >> 1;
                i2 = (i2 + 1) >> 1;
                this.lvls++;
            }
        }
        int i3 = this.lvls;
        this.treeV = new int[i3][];
        this.treeS = new int[i3][];
        int i4 = this.w;
        int i5 = this.h;
        for (int i6 = 0; i6 < this.lvls; i6++) {
            int i7 = i5 * i4;
            this.treeV[i6] = new int[i7];
            this.treeS[i6] = new int[i7];
            i4 = (i4 + 1) >> 1;
            i5 = (i5 + 1) >> 1;
        }
    }

    private void recalcTreeV() {
        for (int i = 0; i < this.lvls - 1; i++) {
            int i2 = 1 << i;
            int i3 = ((this.w + i2) - 1) >> i;
            int i4 = ((this.h + i2) - 1) >> i;
            int i5 = (i4 >> 1) << 1;
            for (int i6 = i5 - 2; i6 >= 0; i6 -= 2) {
                int i7 = (i3 >> 1) << 1;
                for (int i8 = i7 - 2; i8 >= 0; i8 -= 2) {
                    int i9 = (i6 * i3) + i8;
                    int[][] iArr = this.treeV;
                    int[] iArr2 = iArr[i];
                    int i10 = iArr2[i9];
                    int i11 = iArr2[i9 + 1];
                    if (i10 >= i11) {
                        i10 = i11;
                    }
                    int i12 = i9 + i3;
                    int i13 = iArr2[i12];
                    int i14 = iArr2[i12 + 1];
                    if (i13 >= i14) {
                        i13 = i14;
                    }
                    int[] iArr3 = iArr[i + 1];
                    int i15 = ((i6 >> 1) * ((i3 + 1) >> 1)) + (i8 >> 1);
                    if (i10 >= i13) {
                        i10 = i13;
                    }
                    iArr3[i15] = i10;
                }
                if (i3 % 2 != 0) {
                    int i16 = (i6 * i3) + i7;
                    int[][] iArr4 = this.treeV;
                    int[] iArr5 = iArr4[i + 1];
                    int i17 = ((i6 >> 1) * ((i3 + 1) >> 1)) + (i7 >> 1);
                    int[] iArr6 = iArr4[i];
                    int i18 = iArr6[i16];
                    int i19 = iArr6[i16 + i3];
                    if (i18 >= i19) {
                        i18 = i19;
                    }
                    iArr5[i17] = i18;
                }
            }
            if (i4 % 2 != 0) {
                int i20 = (i3 >> 1) << 1;
                for (int i21 = i20 - 2; i21 >= 0; i21 -= 2) {
                    int i22 = (i5 * i3) + i21;
                    int[][] iArr7 = this.treeV;
                    int[] iArr8 = iArr7[i + 1];
                    int i23 = ((i5 >> 1) * ((i3 + 1) >> 1)) + (i21 >> 1);
                    int[] iArr9 = iArr7[i];
                    int i24 = iArr9[i22];
                    int i25 = iArr9[i22 + 1];
                    if (i24 >= i25) {
                        i24 = i25;
                    }
                    iArr8[i23] = i24;
                }
                if (i3 % 2 != 0) {
                    int[][] iArr10 = this.treeV;
                    iArr10[i + 1][((i5 >> 1) * ((i3 + 1) >> 1)) + (i20 >> 1)] = iArr10[i][(i5 * i3) + i20];
                }
            }
        }
    }

    public void setValue(int i, int i2, int i3) {
        int i4;
        int i5 = this.lvls;
        if (i5 != 0 && i2 >= 0 && i2 < (i4 = this.w)) {
            int[][] iArr = this.treeS;
            if (i3 >= iArr[i5 - 1][0]) {
                int[] iArr2 = this.treeV[0];
                if (iArr2[(i * i4) + i2] >= iArr[i5 - 1][0]) {
                    iArr2[(i4 * i) + i2] = i3;
                    for (int i6 = 1; i6 < this.lvls; i6++) {
                        int i7 = ((i >> i6) * (((this.w + (1 << i6)) - 1) >> i6)) + (i2 >> i6);
                        int[] iArr3 = this.treeV[i6];
                        if (i3 >= iArr3[i7]) {
                            return;
                        }
                        iArr3[i7] = i3;
                    }
                    return;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public void setValues(int[] iArr) {
        int i = this.lvls;
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        int i2 = this.treeS[i - 1][0];
        for (int i3 = (this.w * this.h) - 1; i3 >= 0; i3--) {
            int[] iArr2 = this.treeV[0];
            int i4 = iArr2[i3];
            if ((i4 < i2 || iArr[i3] < i2) && i4 != iArr[i3]) {
                throw new IllegalArgumentException();
            }
            iArr2[i3] = iArr[i3];
        }
        recalcTreeV();
    }

    public void encode(int i, int i2, int i3, BitOutputBuffer bitOutputBuffer) {
        if (i >= this.h || i2 >= this.w || i3 < 0) {
            throw new IllegalArgumentException();
        }
        int i4 = this.lvls - 1;
        int i5 = this.treeS[i4][0];
        while (true) {
            int i6 = ((i >> i4) * (((this.w + (1 << i4)) - 1) >> i4)) + (i2 >> i4);
            int i7 = this.treeS[i4][i6];
            if (i7 >= i5) {
                i5 = i7;
            }
            while (true) {
                if (i3 <= i5) {
                    break;
                }
                int i8 = this.treeV[i4][i6];
                if (i8 <= i5) {
                    if (i8 != i5) {
                        i5 = i3;
                        break;
                    }
                    bitOutputBuffer.writeBit(1);
                } else {
                    bitOutputBuffer.writeBit(0);
                }
                i5++;
            }
            this.treeS[i4][i6] = i5;
            if (i4 <= 0) {
                return;
            }
            int i9 = this.treeV[i4][i6];
            if (i5 >= i9) {
                i5 = i9;
            }
            i4--;
        }
    }

    public void save() {
        if (this.treeVbak == null) {
            int i = this.lvls;
            this.treeVbak = new int[i][];
            this.treeSbak = new int[i][];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                int[][] iArr = this.treeVbak;
                int[][] iArr2 = this.treeV;
                iArr[i2] = new int[iArr2[i2].length];
                this.treeSbak[i2] = new int[iArr2[i2].length];
            }
        }
        for (int length = this.treeV.length - 1; length >= 0; length--) {
            int[] iArr3 = this.treeV[length];
            System.arraycopy(iArr3, 0, this.treeVbak[length], 0, iArr3.length);
            int[] iArr4 = this.treeS[length];
            System.arraycopy(iArr4, 0, this.treeSbak[length], 0, iArr4.length);
        }
        this.saved = true;
    }

    public void restore() {
        if (!this.saved) {
            throw new IllegalArgumentException();
        }
        for (int i = this.lvls - 1; i >= 0; i--) {
            int[] iArr = this.treeVbak[i];
            int[] iArr2 = this.treeV[i];
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            int[] iArr3 = this.treeSbak[i];
            int[] iArr4 = this.treeS[i];
            System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        }
    }

    public void reset() {
        int i = this.lvls;
        while (true) {
            i--;
            if (i >= 0) {
                ArrayUtil.intArraySet(this.treeV[i], Integer.MAX_VALUE);
                ArrayUtil.intArraySet(this.treeS[i], 0);
            } else {
                this.saved = false;
                return;
            }
        }
    }

    public void reset(int[] iArr) {
        int i = this.w * this.h;
        while (true) {
            i--;
            if (i < 0) {
                break;
            } else {
                this.treeV[0][i] = iArr[i];
            }
        }
        recalcTreeV();
        for (int i2 = this.lvls - 1; i2 >= 0; i2--) {
            ArrayUtil.intArraySet(this.treeS[i2], 0);
        }
        this.saved = false;
    }
}
