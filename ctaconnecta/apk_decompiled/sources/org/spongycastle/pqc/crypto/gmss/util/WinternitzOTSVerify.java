package org.spongycastle.pqc.crypto.gmss.util;

import org.spongycastle.crypto.Digest;

/* loaded from: classes6.dex */
public class WinternitzOTSVerify {
    private Digest messDigestOTS;
    private int w;

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public WinternitzOTSVerify(Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        return digestSize * (i2 + (((log + r3) - 1) / this.w));
    }

    public byte[] Verify(byte[] bArr, byte[] bArr2) {
        int i;
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        int i2 = 0;
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize2 = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.messDigestOTS.doFinal(bArr4, 0);
        int i3 = digestSize << 3;
        int i4 = this.w;
        int i5 = ((i4 - 1) + i3) / i4;
        int log = getLog((i5 << i4) + 1);
        int i6 = this.w;
        int i7 = ((((log + i6) - 1) / i6) + i5) * digestSize;
        if (i7 != bArr2.length) {
            return null;
        }
        byte[] bArr5 = new byte[i7];
        int i8 = 8;
        if (8 % i6 == 0) {
            int i9 = 8 / i6;
            int i10 = (1 << i6) - 1;
            byte[] bArr6 = new byte[digestSize];
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i11 < digestSize2) {
                while (i2 < i9) {
                    int i14 = bArr4[i11] & i10;
                    i12 += i14;
                    int i15 = digestSize2;
                    int i16 = i13 * digestSize;
                    byte[] bArr7 = bArr4;
                    System.arraycopy(bArr2, i16, bArr6, 0, digestSize);
                    int i17 = i14;
                    while (i17 < i10) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i17++;
                        i2 = i2;
                        i5 = i5;
                    }
                    System.arraycopy(bArr6, 0, bArr5, i16, digestSize);
                    bArr7[i11] = (byte) (bArr7[i11] >>> this.w);
                    i13++;
                    i2++;
                    digestSize2 = i15;
                    bArr4 = bArr7;
                    i5 = i5;
                }
                i11++;
                i2 = 0;
            }
            int i18 = (i5 << this.w) - i12;
            int i19 = 0;
            while (i19 < log) {
                int i20 = i13 * digestSize;
                System.arraycopy(bArr2, i20, bArr6, 0, digestSize);
                for (int i21 = i18 & i10; i21 < i10; i21++) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                System.arraycopy(bArr6, 0, bArr5, i20, digestSize);
                int i22 = this.w;
                i18 >>>= i22;
                i13++;
                i19 += i22;
            }
        } else if (i6 < 8) {
            int i23 = digestSize / i6;
            int i24 = (1 << i6) - 1;
            byte[] bArr8 = new byte[digestSize];
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            while (i25 < i23) {
                long j = 0;
                for (int i29 = 0; i29 < this.w; i29++) {
                    j ^= (bArr4[i26] & 255) << (i29 << 3);
                    i26++;
                }
                int i30 = 0;
                while (i30 < i8) {
                    int i31 = (int) (j & i24);
                    i27 += i31;
                    int i32 = i28 * digestSize;
                    System.arraycopy(bArr2, i32, bArr8, 0, digestSize);
                    while (i31 < i24) {
                        this.messDigestOTS.update(bArr8, 0, bArr8.length);
                        bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr8, 0);
                        i31++;
                        i23 = i23;
                        i25 = i25;
                    }
                    System.arraycopy(bArr8, 0, bArr5, i32, digestSize);
                    j >>>= this.w;
                    i28++;
                    i30++;
                    i23 = i23;
                    i8 = 8;
                }
                i25++;
                i8 = 8;
            }
            int i33 = digestSize % this.w;
            int i34 = 0;
            long j2 = 0;
            while (i34 < i33) {
                j2 ^= (bArr4[i26] & 255) << (i34 << 3);
                i26++;
                i34++;
                bArr8 = bArr8;
            }
            int i35 = i33 << 3;
            int i36 = 0;
            while (i36 < i35) {
                int i37 = (int) (i24 & j2);
                i27 += i37;
                int i38 = i28 * digestSize;
                System.arraycopy(bArr2, i38, bArr8, 0, digestSize);
                while (i37 < i24) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                    i37++;
                    i35 = i35;
                    i36 = i36;
                }
                int i39 = i35;
                System.arraycopy(bArr8, 0, bArr5, i38, digestSize);
                int i40 = this.w;
                j2 >>>= i40;
                i28++;
                i36 += i40;
                i35 = i39;
            }
            int i41 = (i5 << this.w) - i27;
            int i42 = 0;
            while (i42 < log) {
                int i43 = i28 * digestSize;
                System.arraycopy(bArr2, i43, bArr8, 0, digestSize);
                for (int i44 = i41 & i24; i44 < i24; i44++) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                }
                System.arraycopy(bArr8, 0, bArr5, i43, digestSize);
                int i45 = this.w;
                i41 >>>= i45;
                i28++;
                i42 += i45;
            }
        } else if (i6 < 57) {
            int i46 = i3 - i6;
            int i47 = (1 << i6) - 1;
            byte[] bArr9 = new byte[digestSize];
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            while (i50 <= i46) {
                int i51 = i50 >>> 3;
                int i52 = i50 % 8;
                i50 += this.w;
                int i53 = 0;
                long j3 = 0;
                while (i51 < ((i50 + 7) >>> 3)) {
                    j3 ^= (bArr4[i51] & 255) << (i53 << 3);
                    i53++;
                    i51++;
                    i46 = i46;
                    i49 = i49;
                }
                int i54 = i46;
                int i55 = i49;
                long j4 = i47;
                long j5 = (j3 >>> i52) & j4;
                i48 = (int) (i48 + j5);
                int i56 = i55 * digestSize;
                System.arraycopy(bArr2, i56, bArr9, 0, digestSize);
                while (j5 < j4) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j5++;
                }
                System.arraycopy(bArr9, 0, bArr5, i56, digestSize);
                i49 = i55 + 1;
                i46 = i54;
            }
            int i57 = i49;
            int i58 = i50 >>> 3;
            if (i58 < digestSize) {
                int i59 = i50 % 8;
                int i60 = 0;
                long j6 = 0;
                while (i58 < digestSize) {
                    j6 ^= (bArr4[i58] & 255) << (i60 << 3);
                    i60++;
                    i58++;
                }
                long j7 = j6 >>> i59;
                long j8 = i47;
                long j9 = j7 & j8;
                i48 = (int) (i48 + j9);
                int i61 = i57 * digestSize;
                System.arraycopy(bArr2, i61, bArr9, 0, digestSize);
                while (j9 < j8) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j9++;
                    i48 = i48;
                }
                System.arraycopy(bArr9, 0, bArr5, i61, digestSize);
                i = i57 + 1;
            } else {
                i = i57;
            }
            int i62 = (i5 << this.w) - i48;
            int i63 = 0;
            while (i63 < log) {
                long j10 = i62 & i47;
                int i64 = i * digestSize;
                System.arraycopy(bArr2, i64, bArr9, 0, digestSize);
                while (j10 < i47) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j10++;
                    i47 = i47;
                }
                System.arraycopy(bArr9, 0, bArr5, i64, digestSize);
                int i65 = this.w;
                i62 >>>= i65;
                i++;
                i63 += i65;
                i47 = i47;
            }
        }
        byte[] bArr10 = new byte[digestSize];
        this.messDigestOTS.update(bArr5, 0, i7);
        byte[] bArr11 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr11, 0);
        return bArr11;
    }
}
