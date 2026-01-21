package jj2000.j2k.entropy.decoder;

import jj2000.j2k.util.ArrayUtil;

/* loaded from: classes5.dex */
public class MQDecoder {
    int[] I;
    int a;
    int b;
    int c;
    int cT;
    ByteInputBuffer in;
    final int[] initStates;
    int[] mPS;
    boolean markerFound;
    static final int[] qe = {22017, 13313, 6145, 2753, 1313, 545, 22017, 21505, 18433, 14337, 12289, 9217, 7169, 5633, 22017, 21505, 20737, 18433, 14337, 13313, 12289, 10241, 9217, 8705, 7169, 6145, 5633, 5121, 4609, 4353, 2753, 2497, 2209, 1313, 1089, 673, 545, 321, 273, 133, 73, 37, 21, 9, 5, 1, 22017};
    static final int[] nMPS = {1, 2, 3, 4, 5, 38, 7, 8, 9, 10, 11, 12, 13, 29, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 45, 46};
    static final int[] nLPS = {1, 6, 9, 12, 29, 33, 6, 14, 14, 14, 17, 18, 20, 21, 14, 14, 15, 16, 17, 18, 19, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 46};
    static final int[] switchLM = {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public MQDecoder(ByteInputBuffer byteInputBuffer, int i, int[] iArr) {
        this.in = byteInputBuffer;
        this.I = new int[i];
        this.mPS = new int[i];
        this.initStates = iArr;
        init();
        resetCtxts();
    }

    public final boolean fastDecodeSymbols(int[] iArr, int i, int i2) {
        int[] iArr2 = this.I;
        int i3 = iArr2[i];
        int i4 = qe[i3];
        if (i4 < 16384) {
            int i5 = this.a;
            if (i2 <= ((i5 - (this.c >>> 16)) - 1) / i4 && i2 <= ((i5 - 32768) / i4) + 1) {
                int i6 = i5 - (i2 * i4);
                this.a = i6;
                if (i6 >= 32768) {
                    iArr[0] = this.mPS[i];
                    return true;
                }
                iArr2[i] = nMPS[i3];
                if (this.cT == 0) {
                    byteIn();
                }
                this.a <<= 1;
                this.c <<= 1;
                this.cT--;
                iArr[0] = this.mPS[i];
                return true;
            }
        }
        int i7 = this.a;
        for (int i8 = 0; i8 < i2; i8++) {
            i7 -= i4;
            int i9 = this.c;
            if ((i9 >>> 16) >= i7) {
                this.c = i9 - (i7 << 16);
                if (i7 < i4) {
                    iArr[i8] = this.mPS[i];
                    int i10 = nMPS[i3];
                    int i11 = qe[i10];
                    if (this.cT == 0) {
                        byteIn();
                    }
                    this.c <<= 1;
                    this.cT--;
                    i3 = i10;
                    i7 = i4 << 1;
                    i4 = i11;
                } else {
                    int[] iArr3 = this.mPS;
                    iArr[i8] = 1 - iArr3[i];
                    if (switchLM[i3] == 1) {
                        iArr3[i] = 1 - iArr3[i];
                    }
                    int i12 = nLPS[i3];
                    int i13 = qe[i12];
                    do {
                        if (this.cT == 0) {
                            byteIn();
                        }
                        i4 <<= 1;
                        this.c <<= 1;
                        this.cT--;
                    } while (i4 < 32768);
                    i7 = i4;
                    i3 = i12;
                    i4 = i13;
                }
            } else if (i7 >= 32768) {
                iArr[i8] = this.mPS[i];
            } else if (i7 >= i4) {
                iArr[i8] = this.mPS[i];
                i3 = nMPS[i3];
                i4 = qe[i3];
                if (this.cT == 0) {
                    byteIn();
                }
                i7 <<= 1;
                this.c <<= 1;
                this.cT--;
            } else {
                int[] iArr4 = this.mPS;
                iArr[i8] = 1 - iArr4[i];
                if (switchLM[i3] == 1) {
                    iArr4[i] = 1 - iArr4[i];
                }
                int i14 = nLPS[i3];
                int i15 = qe[i14];
                do {
                    if (this.cT == 0) {
                        byteIn();
                    }
                    i7 <<= 1;
                    this.c <<= 1;
                    this.cT--;
                } while (i7 < 32768);
                i3 = i14;
                i4 = i15;
            }
        }
        this.a = i7;
        this.I[i] = i3;
        return false;
    }

    public final void decodeSymbols(int[] iArr, int[] iArr2, int i) {
        int i2;
        int i3;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = iArr2[i4];
            int[] iArr3 = this.I;
            int i6 = iArr3[i5];
            int i7 = qe[i6];
            int i8 = this.a - i7;
            this.a = i8;
            int i9 = this.c;
            if ((i9 >>> 16) >= i8) {
                this.c = i9 - (i8 << 16);
                if (i8 < i7) {
                    iArr[i4] = this.mPS[i5];
                    iArr3[i5] = nMPS[i6];
                    if (this.cT == 0) {
                        byteIn();
                    }
                    i2 = i7 << 1;
                    this.c <<= 1;
                    this.cT--;
                } else {
                    int[] iArr4 = this.mPS;
                    iArr[i4] = 1 - iArr4[i5];
                    if (switchLM[i6] == 1) {
                        iArr4[i5] = 1 - iArr4[i5];
                    }
                    iArr3[i5] = nLPS[i6];
                    do {
                        if (this.cT == 0) {
                            byteIn();
                        }
                        i7 <<= 1;
                        this.c <<= 1;
                        this.cT--;
                    } while (i7 < 32768);
                    i2 = i7;
                }
                this.a = i2;
            } else if (i8 >= 32768) {
                iArr[i4] = this.mPS[i5];
            } else {
                if (i8 >= i7) {
                    iArr[i4] = this.mPS[i5];
                    iArr3[i5] = nMPS[i6];
                    if (this.cT == 0) {
                        byteIn();
                    }
                    i3 = i8 << 1;
                    this.c <<= 1;
                    this.cT--;
                } else {
                    int[] iArr5 = this.mPS;
                    iArr[i4] = 1 - iArr5[i5];
                    if (switchLM[i6] == 1) {
                        iArr5[i5] = 1 - iArr5[i5];
                    }
                    iArr3[i5] = nLPS[i6];
                    do {
                        if (this.cT == 0) {
                            byteIn();
                        }
                        i8 <<= 1;
                        this.c <<= 1;
                        this.cT--;
                    } while (i8 < 32768);
                    i3 = i8;
                }
                this.a = i3;
            }
        }
    }

    public final int decodeSymbol(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.I;
        int i6 = iArr[i];
        int i7 = qe[i6];
        int i8 = this.a - i7;
        this.a = i8;
        int i9 = this.c;
        if ((i9 >>> 16) >= i8) {
            this.c = i9 - (i8 << 16);
            if (i8 < i7) {
                i3 = this.mPS[i];
                iArr[i] = nMPS[i6];
                if (this.cT == 0) {
                    byteIn();
                }
                i2 = i7 << 1;
                this.c <<= 1;
                this.cT--;
            } else {
                int[] iArr2 = this.mPS;
                int i10 = iArr2[i];
                int i11 = 1 - i10;
                if (switchLM[i6] == 1) {
                    iArr2[i] = 1 - i10;
                }
                iArr[i] = nLPS[i6];
                do {
                    if (this.cT == 0) {
                        byteIn();
                    }
                    i7 <<= 1;
                    this.c <<= 1;
                    this.cT--;
                } while (i7 < 32768);
                i2 = i7;
                i3 = i11;
            }
            this.a = i2;
            return i3;
        }
        if (i8 >= 32768) {
            return this.mPS[i];
        }
        if (i8 >= i7) {
            i5 = this.mPS[i];
            iArr[i] = nMPS[i6];
            if (this.cT == 0) {
                byteIn();
            }
            i4 = i8 << 1;
            this.c <<= 1;
            this.cT--;
        } else {
            int[] iArr3 = this.mPS;
            int i12 = iArr3[i];
            int i13 = 1 - i12;
            if (switchLM[i6] == 1) {
                iArr3[i] = 1 - i12;
            }
            iArr[i] = nLPS[i6];
            do {
                if (this.cT == 0) {
                    byteIn();
                }
                i8 <<= 1;
                this.c <<= 1;
                this.cT--;
            } while (i8 < 32768);
            i4 = i8;
            i5 = i13;
        }
        this.a = i4;
        return i5;
    }

    public boolean checkPredTerm() {
        int i;
        if (this.b != 255 && !this.markerFound) {
            return true;
        }
        int i2 = this.cT;
        if (i2 != 0 && !this.markerFound) {
            return true;
        }
        if (i2 == 1) {
            return false;
        }
        if (i2 == 0) {
            if (!this.markerFound) {
                int i3 = this.in.read() & 255;
                this.b = i3;
                if (i3 <= 143) {
                    return true;
                }
            }
            this.cT = 8;
        }
        int i4 = 32768 >> (this.cT - 1);
        int i5 = this.a - i4;
        this.a = i5;
        int i6 = this.c;
        if ((i6 >>> 16) < i5) {
            return true;
        }
        this.c = i6 - (i5 << 16);
        this.a = i4;
        do {
            if (this.cT == 0) {
                byteIn();
            }
            i = this.a << 1;
            this.a = i;
            this.c <<= 1;
            this.cT--;
        } while (i < 32768);
        return false;
    }

    private void byteIn() {
        if (!this.markerFound) {
            if (this.b == 255) {
                int i = this.in.read() & 255;
                this.b = i;
                if (i > 143) {
                    this.markerFound = true;
                    this.cT = 8;
                    return;
                } else {
                    this.c += 65024 - (i << 9);
                    this.cT = 7;
                    return;
                }
            }
            int i2 = this.in.read() & 255;
            this.b = i2;
            this.c += 65280 - (i2 << 8);
            this.cT = 8;
            return;
        }
        this.cT = 8;
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

    public final void nextSegment(byte[] bArr, int i, int i2) {
        this.in.setByteArray(bArr, i, i2);
        init();
    }

    public ByteInputBuffer getByteInputBuffer() {
        return this.in;
    }

    private void init() {
        this.markerFound = false;
        int i = this.in.read() & 255;
        this.b = i;
        this.c = (i ^ 255) << 16;
        byteIn();
        this.c <<= 7;
        this.cT -= 7;
        this.a = 32768;
    }
}
