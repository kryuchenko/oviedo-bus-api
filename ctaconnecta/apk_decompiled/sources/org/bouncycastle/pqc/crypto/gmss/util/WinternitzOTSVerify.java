package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

/* loaded from: classes6.dex */
public class WinternitzOTSVerify {
    private Digest messDigestOTS;
    private int w;

    public WinternitzOTSVerify(Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
    }

    public byte[] Verify(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        int i3;
        int i4;
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        int i5 = 0;
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize2 = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.messDigestOTS.doFinal(bArr4, 0);
        int i6 = digestSize << 3;
        int i7 = this.w;
        int i8 = ((i7 - 1) + i6) / i7;
        int log = getLog((i8 << i7) + 1);
        int i9 = this.w;
        int i10 = ((((log + i9) - 1) / i9) + i8) * digestSize;
        if (i10 != bArr2.length) {
            return null;
        }
        byte[] bArr5 = new byte[i10];
        int i11 = 8;
        if (8 % i9 == 0) {
            int i12 = 8 / i9;
            int i13 = (1 << i9) - 1;
            byte[] bArr6 = new byte[digestSize];
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i14 < digestSize2) {
                while (i5 < i12) {
                    int i17 = bArr4[i14] & i13;
                    i15 += i17;
                    int i18 = digestSize2;
                    int i19 = i16 * digestSize;
                    byte[] bArr7 = bArr4;
                    System.arraycopy(bArr2, i19, bArr6, 0, digestSize);
                    int i20 = i17;
                    while (i20 < i13) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i20++;
                        i5 = i5;
                        i8 = i8;
                    }
                    System.arraycopy(bArr6, 0, bArr5, i19, digestSize);
                    bArr7[i14] = (byte) (bArr7[i14] >>> this.w);
                    i16++;
                    i5++;
                    digestSize2 = i18;
                    bArr4 = bArr7;
                    i8 = i8;
                }
                i14++;
                i5 = 0;
            }
            int i21 = (i8 << this.w) - i15;
            int i22 = 0;
            while (i22 < log) {
                int i23 = i16 * digestSize;
                System.arraycopy(bArr2, i23, bArr6, 0, digestSize);
                for (int i24 = i21 & i13; i24 < i13; i24++) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                System.arraycopy(bArr6, 0, bArr5, i23, digestSize);
                int i25 = this.w;
                i21 >>>= i25;
                i16++;
                i22 += i25;
            }
        } else if (i9 < 8) {
            int i26 = digestSize / i9;
            int i27 = (1 << i9) - 1;
            byte[] bArr8 = new byte[digestSize];
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            while (i28 < i26) {
                long j = 0;
                for (int i32 = 0; i32 < this.w; i32++) {
                    j ^= (bArr4[i29] & 255) << (i32 << 3);
                    i29++;
                }
                int i33 = 0;
                while (i33 < i11) {
                    int i34 = (int) (j & i27);
                    i30 += i34;
                    int i35 = i31 * digestSize;
                    System.arraycopy(bArr2, i35, bArr8, 0, digestSize);
                    while (true) {
                        i4 = i26;
                        if (i34 < i27) {
                            this.messDigestOTS.update(bArr8, 0, bArr8.length);
                            bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                            this.messDigestOTS.doFinal(bArr8, 0);
                            i34++;
                            i26 = i4;
                            i28 = i28;
                        }
                    }
                    System.arraycopy(bArr8, 0, bArr5, i35, digestSize);
                    j >>>= this.w;
                    i31++;
                    i33++;
                    i26 = i4;
                    i11 = 8;
                }
                i28++;
                i11 = 8;
            }
            int i36 = digestSize % this.w;
            int i37 = 0;
            long j2 = 0;
            while (i37 < i36) {
                j2 ^= (bArr4[i29] & 255) << (i37 << 3);
                i29++;
                i37++;
                bArr8 = bArr8;
            }
            int i38 = i36 << 3;
            int i39 = 0;
            while (i39 < i38) {
                int i40 = (int) (i27 & j2);
                i30 += i40;
                int i41 = i31 * digestSize;
                System.arraycopy(bArr2, i41, bArr8, 0, digestSize);
                while (true) {
                    i3 = i38;
                    if (i40 < i27) {
                        this.messDigestOTS.update(bArr8, 0, bArr8.length);
                        bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr8, 0);
                        i40++;
                        i38 = i3;
                        i39 = i39;
                    }
                }
                System.arraycopy(bArr8, 0, bArr5, i41, digestSize);
                int i42 = this.w;
                j2 >>>= i42;
                i31++;
                i39 += i42;
                i38 = i3;
            }
            int i43 = (i8 << this.w) - i30;
            int i44 = 0;
            while (i44 < log) {
                int i45 = i31 * digestSize;
                System.arraycopy(bArr2, i45, bArr8, 0, digestSize);
                for (int i46 = i43 & i27; i46 < i27; i46++) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                }
                System.arraycopy(bArr8, 0, bArr5, i45, digestSize);
                int i47 = this.w;
                i43 >>>= i47;
                i31++;
                i44 += i47;
            }
        } else if (i9 < 57) {
            int i48 = i6 - i9;
            int i49 = (1 << i9) - 1;
            byte[] bArr9 = new byte[digestSize];
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            while (i52 <= i48) {
                int i53 = i52 >>> 3;
                int i54 = i52 % 8;
                i52 += this.w;
                int i55 = 0;
                long j3 = 0;
                while (true) {
                    i2 = i48;
                    if (i53 >= ((i52 + 7) >>> 3)) {
                        break;
                    }
                    j3 ^= (bArr4[i53] & 255) << (i55 << 3);
                    i55++;
                    i53++;
                    i48 = i2;
                    i51 = i51;
                }
                int i56 = i51;
                long j4 = i49;
                long j5 = (j3 >>> i54) & j4;
                i50 = (int) (i50 + j5);
                int i57 = i56 * digestSize;
                System.arraycopy(bArr2, i57, bArr9, 0, digestSize);
                while (j5 < j4) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j5++;
                }
                System.arraycopy(bArr9, 0, bArr5, i57, digestSize);
                i51 = i56 + 1;
                i48 = i2;
            }
            int i58 = i51;
            int i59 = i52 >>> 3;
            if (i59 < digestSize) {
                int i60 = i52 % 8;
                int i61 = 0;
                long j6 = 0;
                while (i59 < digestSize) {
                    j6 ^= (bArr4[i59] & 255) << (i61 << 3);
                    i61++;
                    i59++;
                }
                long j7 = j6 >>> i60;
                long j8 = i49;
                long j9 = j7 & j8;
                i50 = (int) (i50 + j9);
                int i62 = i58 * digestSize;
                System.arraycopy(bArr2, i62, bArr9, 0, digestSize);
                while (j9 < j8) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j9++;
                    i50 = i50;
                }
                System.arraycopy(bArr9, 0, bArr5, i62, digestSize);
                i = i58 + 1;
            } else {
                i = i58;
            }
            int i63 = (i8 << this.w) - i50;
            int i64 = 0;
            while (i64 < log) {
                long j10 = i63 & i49;
                int i65 = i * digestSize;
                System.arraycopy(bArr2, i65, bArr9, 0, digestSize);
                while (j10 < i49) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j10++;
                    i49 = i49;
                }
                System.arraycopy(bArr9, 0, bArr5, i65, digestSize);
                int i66 = this.w;
                i63 >>>= i66;
                i++;
                i64 += i66;
                i49 = i49;
            }
        }
        byte[] bArr10 = new byte[digestSize];
        this.messDigestOTS.update(bArr5, 0, i10);
        byte[] bArr11 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr11, 0);
        return bArr11;
    }

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        return digestSize * (i2 + (((log + r3) - 1) / this.w));
    }
}
