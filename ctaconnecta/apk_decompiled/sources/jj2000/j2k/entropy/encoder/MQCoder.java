package jj2000.j2k.entropy.encoder;

import jj2000.j2k.util.ArrayUtil;

/* loaded from: classes5.dex */
public class MQCoder {
    public static final int LENGTH_LAZY = 0;
    public static final int LENGTH_LAZY_GOOD = 1;
    public static final int LENGTH_NEAR_OPT = 2;
    static final int SAVED_INC = 12;
    static final int SAVED_LEN = 96;
    public static final int TERM_EASY = 2;
    public static final int TERM_FULL = 0;
    public static final int TERM_NEAR_OPT = 1;
    public static final int TERM_PRED_ER = 3;
    int[] I;
    int b;
    int cT;
    boolean delFF;
    int[] initStates;
    int ltype;
    int[] mPS;
    int nSaved;
    ByteOutputBuffer out;
    int[] savedA;
    int[] savedB;
    int[] savedC;
    int[] savedCT;
    boolean[] savedDelFF;
    int ttype;
    static final int[] qe = {22017, 13313, 6145, 2753, 1313, 545, 22017, 21505, 18433, 14337, 12289, 9217, 7169, 5633, 22017, 21505, 20737, 18433, 14337, 13313, 12289, 10241, 9217, 8705, 7169, 6145, 5633, 5121, 4609, 4353, 2753, 2497, 2209, 1313, 1089, 673, 545, 321, 273, 133, 73, 37, 21, 9, 5, 1, 22017};
    static final int[] nMPS = {1, 2, 3, 4, 5, 38, 7, 8, 9, 10, 11, 12, 13, 29, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 45, 46};
    static final int[] nLPS = {1, 6, 9, 12, 29, 33, 6, 14, 14, 14, 17, 18, 20, 21, 14, 14, 15, 16, 17, 18, 19, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 46};
    static final int[] switchLM = {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int nrOfWrittenBytes = -1;
    int a = 32768;
    int c = 0;

    public void setLenCalcType(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Unrecognized length calculation type code: " + i);
        }
        if (i == 2) {
            if (this.savedC == null) {
                this.savedC = new int[96];
            }
            if (this.savedCT == null) {
                this.savedCT = new int[96];
            }
            if (this.savedA == null) {
                this.savedA = new int[96];
            }
            if (this.savedB == null) {
                this.savedB = new int[96];
            }
            if (this.savedDelFF == null) {
                this.savedDelFF = new boolean[96];
            }
        }
        this.ltype = i;
    }

    public void setTermType(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException("Unrecognized termination type code: " + i);
        }
        this.ttype = i;
    }

    public MQCoder(ByteOutputBuffer byteOutputBuffer, int i, int[] iArr) {
        this.out = byteOutputBuffer;
        this.I = new int[i];
        this.mPS = new int[i];
        this.initStates = iArr;
        if (this.b == 255) {
            this.cT = 13;
        } else {
            this.cT = 12;
        }
        resetCtxts();
        this.b = 0;
    }

    public final void fastCodeSymbols(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = this.I[i2];
        int i8 = qe[i7];
        if (i8 <= 16384 && i == this.mPS[i2] && (i6 = ((this.a - 32768) / i8) + 1) > 1) {
            while (i3 > i6) {
                int i9 = i8 * i6;
                int i10 = this.c + i9;
                this.c = i10;
                int i11 = this.a - i9;
                this.a = i11;
                i7 = nMPS[i7];
                i8 = qe[i7];
                this.a = i11 << 1;
                this.c = i10 << 1;
                int i12 = this.cT - 1;
                this.cT = i12;
                if (i12 == 0) {
                    byteOut();
                }
                i3 -= i6;
                i6 = ((this.a - 32768) / i8) + 1;
                if (i3 <= 0) {
                    return;
                }
            }
            int i13 = i3 * i8;
            int i14 = this.a - i13;
            this.a = i14;
            int i15 = this.c + i13;
            this.c = i15;
            if (i14 >= 32768) {
                this.I[i2] = i7;
                return;
            }
            this.I[i2] = nMPS[i7];
            this.a = i14 << 1;
            this.c = i15 << 1;
            int i16 = this.cT - 1;
            this.cT = i16;
            if (i16 == 0) {
                byteOut();
                return;
            }
            return;
        }
        int i17 = this.a;
        do {
            int[] iArr = this.mPS;
            int i18 = iArr[i2];
            if (i == i18) {
                i17 -= i8;
                if (i17 >= 32768) {
                    this.c += i8;
                    i3--;
                } else {
                    if (i17 >= i8) {
                        this.c += i8;
                        i8 = i17;
                    }
                    i7 = nMPS[i7];
                    i4 = qe[i7];
                    i8 <<= 1;
                    this.c <<= 1;
                    int i19 = this.cT - 1;
                    this.cT = i19;
                    if (i19 == 0) {
                        byteOut();
                    }
                }
            } else {
                int i20 = i17 - i8;
                if (i20 < i8) {
                    this.c += i8;
                    i8 = i20;
                }
                if (switchLM[i7] != 0) {
                    iArr[i2] = 1 - i18;
                }
                i7 = nLPS[i7];
                i4 = qe[i7];
                int i21 = 0;
                do {
                    i8 <<= 1;
                    i21++;
                } while (i8 < 32768);
                int i22 = this.cT;
                if (i22 > i21) {
                    this.c <<= i21;
                    this.cT = i22 - i21;
                } else {
                    do {
                        int i23 = this.c;
                        int i24 = this.cT;
                        this.c = i23 << i24;
                        i21 -= i24;
                        byteOut();
                        i5 = this.cT;
                    } while (i5 <= i21);
                    this.c <<= i21;
                    this.cT = i5 - i21;
                }
            }
            int i25 = i4;
            i17 = i8;
            i8 = i25;
            i3--;
        } while (i3 > 0);
        this.I[i2] = i7;
        this.a = i17;
    }

    public final void codeSymbols(int[] iArr, int[] iArr2, int i) {
        int i2;
        int i3 = this.a;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = iArr2[i4];
            int[] iArr3 = this.I;
            int i6 = iArr3[i5];
            int i7 = qe[i6];
            int i8 = iArr[i4];
            int[] iArr4 = this.mPS;
            int i9 = iArr4[i5];
            if (i8 == i9) {
                i3 -= i7;
                if (i3 >= 32768) {
                    this.c += i7;
                } else {
                    if (i3 >= i7) {
                        this.c += i7;
                        i7 = i3;
                    }
                    iArr3[i5] = nMPS[i6];
                    i3 = i7 << 1;
                    this.c <<= 1;
                    int i10 = this.cT - 1;
                    this.cT = i10;
                    if (i10 == 0) {
                        byteOut();
                    }
                }
            } else {
                int i11 = i3 - i7;
                if (i11 < i7) {
                    this.c += i7;
                    i7 = i11;
                }
                if (switchLM[i6] != 0) {
                    iArr4[i5] = 1 - i9;
                }
                iArr3[i5] = nLPS[i6];
                int i12 = 0;
                do {
                    i7 <<= 1;
                    i12++;
                } while (i7 < 32768);
                int i13 = this.cT;
                if (i13 > i12) {
                    this.c <<= i12;
                    this.cT = i13 - i12;
                } else {
                    do {
                        int i14 = this.c;
                        int i15 = this.cT;
                        this.c = i14 << i15;
                        i12 -= i15;
                        byteOut();
                        i2 = this.cT;
                    } while (i2 <= i12);
                    this.c <<= i12;
                    this.cT = i2 - i12;
                }
                i3 = i7;
            }
        }
        this.a = i3;
    }

    public final void codeSymbol(int i, int i2) {
        int i3;
        int[] iArr = this.I;
        int i4 = iArr[i2];
        int i5 = qe[i4];
        int[] iArr2 = this.mPS;
        int i6 = iArr2[i2];
        if (i == i6) {
            int i7 = this.a - i5;
            this.a = i7;
            if (i7 >= 32768) {
                this.c += i5;
                return;
            }
            if (i7 < i5) {
                this.a = i5;
            } else {
                this.c += i5;
            }
            iArr[i2] = nMPS[i4];
            this.a <<= 1;
            this.c <<= 1;
            int i8 = this.cT - 1;
            this.cT = i8;
            if (i8 == 0) {
                byteOut();
                return;
            }
            return;
        }
        int i9 = this.a - i5;
        if (i9 < i5) {
            this.c += i5;
            i5 = i9;
        }
        if (switchLM[i4] != 0) {
            iArr2[i2] = 1 - i6;
        }
        iArr[i2] = nLPS[i4];
        int i10 = 0;
        do {
            i5 <<= 1;
            i10++;
        } while (i5 < 32768);
        int i11 = this.cT;
        if (i11 > i10) {
            this.c <<= i10;
            this.cT = i11 - i10;
        } else {
            do {
                int i12 = this.c;
                int i13 = this.cT;
                this.c = i12 << i13;
                i10 -= i13;
                byteOut();
                i3 = this.cT;
            } while (i3 <= i10);
            this.c <<= i10;
            this.cT = i3 - i10;
        }
        this.a = i5;
    }

    private void byteOut() {
        int i = this.nrOfWrittenBytes;
        if (i >= 0) {
            int i2 = this.b;
            if (i2 == 255) {
                this.delFF = true;
                int i3 = this.c;
                this.b = i3 >>> 20;
                this.c = i3 & 1048575;
                this.cT = 7;
                return;
            }
            int i4 = this.c;
            if (i4 < 134217728) {
                if (this.delFF) {
                    this.out.write(255);
                    this.delFF = false;
                    this.nrOfWrittenBytes++;
                }
                this.out.write(this.b);
                this.nrOfWrittenBytes++;
                int i5 = this.c;
                this.b = i5 >>> 19;
                this.c = i5 & 524287;
                this.cT = 8;
                return;
            }
            int i6 = i2 + 1;
            this.b = i6;
            if (i6 == 255) {
                this.delFF = true;
                this.b = (134217727 & i4) >>> 20;
                this.c = i4 & 1048575;
                this.cT = 7;
                return;
            }
            if (this.delFF) {
                this.out.write(255);
                this.delFF = false;
                this.nrOfWrittenBytes++;
            }
            this.out.write(this.b);
            this.nrOfWrittenBytes++;
            int i7 = this.c;
            this.b = (i7 >>> 19) & 255;
            this.c = i7 & 524287;
            this.cT = 8;
            return;
        }
        int i8 = this.c;
        this.b = i8 >>> 19;
        this.c = 524287 & i8;
        this.cT = 8;
        this.nrOfWrittenBytes = i + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int terminate() {
        int i;
        int i2 = this.ttype;
        if (i2 == 0) {
            int i3 = this.c;
            int i4 = this.a + i3;
            int i5 = i3 | 65535;
            this.c = i5;
            if (i5 >= i4) {
                this.c = i5 - 32768;
            }
            int i6 = 27 - this.cT;
            do {
                this.c <<= this.cT;
                i6 = this.b != 255 ? i6 - 8 : i6 - 7;
                byteOut();
            } while (i6 > 0);
            int i7 = ((1 << (-i6)) - 1) | this.b;
            this.b = i7;
            if (i7 == 255) {
                this.delFF = true;
            } else {
                if (this.delFF) {
                    this.out.write(255);
                    this.delFF = false;
                    this.nrOfWrittenBytes++;
                }
                this.out.write(this.b);
                this.nrOfWrittenBytes++;
            }
        } else if (i2 == 1) {
            int i8 = this.c;
            int i9 = this.a + i8;
            int i10 = this.b;
            int i11 = this.cT;
            int i12 = i8 << i11;
            int i13 = i9 << i11;
            if ((i12 & 134217728) == 0) {
                i = i10;
            } else if (i10 == 255) {
                this.delFF = true;
                int i14 = i12 >>> 20;
                int i15 = i13 >>> 20;
                i12 = (i12 & 1048575) << 7;
                i13 = (i13 & 1048575) << 7;
                i = i14;
                i10 = i15;
            } else {
                i = i10 + 1;
                i12 &= -134217729;
            }
            if ((134217728 & i13) != 0) {
                i10++;
                i13 &= -134217729;
            }
            while (true) {
                if (!this.delFF) {
                    if (i <= 255 && i10 > 255) {
                        break;
                    }
                    if (i >= 255) {
                    }
                } else {
                    if (i <= 127 && i10 > 127) {
                        break;
                    }
                    this.out.write(255);
                    this.nrOfWrittenBytes++;
                    this.delFF = false;
                    if (i >= 255) {
                        if (this.nrOfWrittenBytes >= 0) {
                            this.out.write(i);
                        }
                        this.nrOfWrittenBytes++;
                        i10 = ((i10 - i) << 8) | ((i13 >>> 19) & 255);
                        i = (i12 >>> 19) & 255;
                        i12 = (i12 & 524287) << 8;
                        i13 = (i13 & 524287) << 8;
                    } else {
                        this.delFF = true;
                        i10 = ((i10 - i) << 7) | ((i13 >> 20) & 127);
                        i = (i12 >> 20) & 127;
                        i12 = (i12 & 1048575) << 7;
                        i13 = (i13 & 1048575) << 7;
                    }
                }
            }
        } else if (i2 == 2 || i2 == 3) {
            int i16 = this.cT;
            int i17 = 12 - i16;
            this.c <<= i16;
            while (i17 > 0) {
                byteOut();
                int i18 = this.cT;
                i17 -= i18;
                this.c <<= i18;
            }
            if (i17 < 0 && this.ttype == 2) {
                this.b |= (1 << (-i17)) - 1;
            }
            byteOut();
        } else {
            throw new Error("Illegal termination type code");
        }
        int i19 = this.nrOfWrittenBytes;
        this.a = 32768;
        this.c = 0;
        this.b = 0;
        this.cT = 12;
        this.delFF = false;
        this.nrOfWrittenBytes = -1;
        return i19;
    }

    public final int getNumCtxts() {
        return this.I.length;
    }

    public final void resetCtxt(int i) {
        this.I[i] = this.initStates[i];
        this.mPS[i] = 0;
    }

    public final void resetCtxts() {
        int[] iArr = this.initStates;
        int[] iArr2 = this.I;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        ArrayUtil.intArraySet(this.mPS, 0);
    }

    public final int getNumCodedBytes() {
        int i = this.ltype;
        if (i == 0) {
            if (27 - this.cT <= 22) {
                return this.nrOfWrittenBytes + (this.delFF ? 1 : 0) + 4;
            }
            return this.nrOfWrittenBytes + (this.delFF ? 1 : 0) + 5;
        }
        if (i == 1) {
            if (27 - this.cT <= (this.b < 254 ? 23 : 22)) {
                return this.nrOfWrittenBytes + (this.delFF ? 1 : 0) + 4;
            }
            return this.nrOfWrittenBytes + (this.delFF ? 1 : 0) + 5;
        }
        if (i == 2) {
            saveState();
            return this.nrOfWrittenBytes;
        }
        throw new Error("Illegal length calculation type code");
    }

    public final void reset() {
        this.out.reset();
        this.a = 32768;
        this.c = 0;
        this.b = 0;
        this.cT = 12;
        resetCtxts();
        this.nrOfWrittenBytes = -1;
        this.delFF = false;
        this.nSaved = 0;
    }

    private void saveState() {
        int i = this.nSaved;
        int[] iArr = this.savedC;
        if (i == iArr.length) {
            int[] iArr2 = new int[i + 12];
            this.savedC = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            int[] iArr3 = this.savedCT;
            int i2 = this.nSaved;
            int[] iArr4 = new int[i2 + 12];
            this.savedCT = iArr4;
            System.arraycopy(iArr3, 0, iArr4, 0, i2);
            int[] iArr5 = this.savedA;
            int i3 = this.nSaved;
            int[] iArr6 = new int[i3 + 12];
            this.savedA = iArr6;
            System.arraycopy(iArr5, 0, iArr6, 0, i3);
            int[] iArr7 = this.savedB;
            int i4 = this.nSaved;
            int[] iArr8 = new int[i4 + 12];
            this.savedB = iArr8;
            System.arraycopy(iArr7, 0, iArr8, 0, i4);
            boolean[] zArr = this.savedDelFF;
            int i5 = this.nSaved;
            boolean[] zArr2 = new boolean[i5 + 12];
            this.savedDelFF = zArr2;
            System.arraycopy(zArr, 0, zArr2, 0, i5);
        }
        int[] iArr9 = this.savedC;
        int i6 = this.nSaved;
        iArr9[i6] = this.c;
        this.savedCT[i6] = this.cT;
        this.savedA[i6] = this.a;
        this.savedB[i6] = this.b;
        this.savedDelFF[i6] = this.delFF;
        this.nSaved = i6 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void finishLengthCalculation(int[] iArr, int i) {
        int i2;
        int i3;
        if (this.ltype == 2) {
            int i4 = i - this.nSaved;
            int i5 = i4 - 1;
            int i6 = i5 >= 0 ? iArr[i5] : 0;
            int i7 = iArr[i];
            int i8 = 0;
            while (i4 < i) {
                int i9 = this.savedC[i8];
                int i10 = this.savedA[i8] + i9;
                int i11 = this.savedB[i8];
                int i12 = this.savedCT[i8];
                int i13 = i9 << i12;
                if ((i13 & 134217728) != 0) {
                    i2 = i11 + 1;
                    i13 &= 134217727;
                } else {
                    i2 = i11;
                }
                int i14 = i10 << i12;
                if ((i14 & 134217728) != 0) {
                    i11++;
                    i14 &= 134217727;
                }
                boolean z = this.savedDelFF[i8];
                int i15 = iArr[i4] + (z ? 1 : 0);
                while (true) {
                    if (i15 >= i7) {
                        i15 = i7;
                        break;
                    }
                    if (z) {
                        if (i2 < 128 && i11 >= 128) {
                            i15--;
                            break;
                        }
                        i3 = i15 < i6 ? this.out.getByte(i15) : 0;
                        int i16 = i2 - i3;
                        int i17 = i11 - i3;
                        i15++;
                        if (i3 != 255) {
                            i2 = ((i13 >> 20) & 127) | (i16 << 7);
                            i13 = (i13 & 1048575) << 7;
                            i11 = (i17 << 7) | ((i14 >> 20) & 127);
                            i14 = (i14 & 1048575) << 7;
                            z = true;
                        } else {
                            i2 = ((i13 >> 19) & 255) | (i16 << 8);
                            i13 = (i13 & 524287) << 8;
                            i11 = (i17 << 8) | (255 & (i14 >> 19));
                            i14 = (i14 & 524287) << 8;
                            z = false;
                        }
                    } else {
                        if (i2 < 256 && i11 >= 256) {
                            break;
                        }
                        if (i15 < i6) {
                        }
                        int i162 = i2 - i3;
                        int i172 = i11 - i3;
                        i15++;
                        if (i3 != 255) {
                        }
                    }
                }
                if (i15 < i6) {
                    i15 = i6;
                }
                iArr[i4] = i15;
                i4++;
                i8++;
            }
            this.nSaved = 0;
            return;
        }
        if (i <= 0) {
            return;
        }
        int i18 = iArr[i - 1];
        int i19 = iArr[i];
        if (i18 <= i19) {
            return;
        }
        int i20 = i - 1;
        while (true) {
            int i21 = i20 - 1;
            iArr[i20] = i19;
            if (i21 < 0 || iArr[i21] <= i19) {
                return;
            } else {
                i20 = i21;
            }
        }
    }
}
