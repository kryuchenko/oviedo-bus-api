package org.spongycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;

/* loaded from: classes6.dex */
public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;
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

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(this.messDigestOTS);
        this.mdsize = this.messDigestOTS.getDigestSize();
        double d = i;
        int iCeil = (int) Math.ceil((r8 << 3) / d);
        this.messagesize = iCeil;
        int log = getLog((iCeil << i) + 1);
        this.checksumsize = log;
        int iCeil2 = this.messagesize + ((int) Math.ceil(log / d));
        this.keysize = iCeil2;
        this.privateKeyOTS = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, iCeil2, this.mdsize);
        int i2 = this.mdsize;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        for (int i3 = 0; i3 < this.keysize; i3++) {
            this.privateKeyOTS[i3] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i = this.keysize;
        int i2 = this.mdsize;
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i2];
        int i4 = 1 << this.w;
        for (int i5 = 0; i5 < this.keysize; i5++) {
            Digest digest = this.messDigestOTS;
            byte[] bArr3 = this.privateKeyOTS[i5];
            digest.update(bArr3, 0, bArr3.length);
            byte[] bArr4 = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(bArr4, 0);
            for (int i6 = 2; i6 < i4; i6++) {
                this.messDigestOTS.update(bArr4, 0, bArr4.length);
                bArr4 = new byte[this.messDigestOTS.getDigestSize()];
                this.messDigestOTS.doFinal(bArr4, 0);
            }
            int i7 = this.mdsize;
            System.arraycopy(bArr4, 0, bArr, i7 * i5, i7);
        }
        this.messDigestOTS.update(bArr, 0, i3);
        byte[] bArr5 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr5, 0);
        return bArr5;
    }

    public byte[] getSignature(byte[] bArr) {
        int i;
        int i2 = this.keysize;
        int i3 = this.mdsize;
        byte[] bArr2 = new byte[i2 * i3];
        byte[] bArr3 = new byte[i3];
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        this.messDigestOTS.doFinal(bArr4, 0);
        int i4 = this.w;
        if (8 % i4 == 0) {
            int i5 = 8 / i4;
            int i6 = (1 << i4) - 1;
            byte[] bArr5 = new byte[this.mdsize];
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < digestSize; i9++) {
                for (int i10 = 0; i10 < i5; i10++) {
                    int i11 = bArr4[i9] & i6;
                    i7 += i11;
                    System.arraycopy(this.privateKeyOTS[i8], 0, bArr5, 0, this.mdsize);
                    while (i11 > 0) {
                        this.messDigestOTS.update(bArr5, 0, bArr5.length);
                        bArr5 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr5, 0);
                        i11--;
                    }
                    int i12 = this.mdsize;
                    System.arraycopy(bArr5, 0, bArr2, i8 * i12, i12);
                    bArr4[i9] = (byte) (bArr4[i9] >>> this.w);
                    i8++;
                }
            }
            int i13 = (this.messagesize << this.w) - i7;
            int i14 = 0;
            while (i14 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i8], 0, bArr5, 0, this.mdsize);
                for (int i15 = i13 & i6; i15 > 0; i15--) {
                    this.messDigestOTS.update(bArr5, 0, bArr5.length);
                    bArr5 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr5, 0);
                }
                int i16 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr2, i8 * i16, i16);
                int i17 = this.w;
                i13 >>>= i17;
                i8++;
                i14 += i17;
            }
        } else if (i4 < 8) {
            int i18 = this.mdsize;
            int i19 = i18 / i4;
            int i20 = (1 << i4) - 1;
            byte[] bArr6 = new byte[i18];
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            for (int i24 = 0; i24 < i19; i24++) {
                long j = 0;
                for (int i25 = 0; i25 < this.w; i25++) {
                    j ^= (bArr4[i21] & 255) << (i25 << 3);
                    i21++;
                }
                for (int i26 = 0; i26 < 8; i26++) {
                    int i27 = (int) (j & i20);
                    i23 += i27;
                    System.arraycopy(this.privateKeyOTS[i22], 0, bArr6, 0, this.mdsize);
                    while (i27 > 0) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i27--;
                    }
                    int i28 = this.mdsize;
                    System.arraycopy(bArr6, 0, bArr2, i22 * i28, i28);
                    j >>>= this.w;
                    i22++;
                }
            }
            int i29 = this.mdsize % this.w;
            long j2 = 0;
            int i30 = 0;
            while (i30 < i29) {
                j2 ^= (bArr4[i21] & 255) << (i30 << 3);
                i21++;
                i30++;
                i29 = i29;
            }
            int i31 = i29 << 3;
            int i32 = 0;
            while (i32 < i31) {
                int i33 = (int) (i20 & j2);
                i23 += i33;
                System.arraycopy(this.privateKeyOTS[i22], 0, bArr6, 0, this.mdsize);
                while (i33 > 0) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                    i33--;
                }
                int i34 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr2, i22 * i34, i34);
                int i35 = this.w;
                j2 >>>= i35;
                i22++;
                i32 += i35;
            }
            int i36 = (this.messagesize << this.w) - i23;
            int i37 = 0;
            while (i37 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i22], 0, bArr6, 0, this.mdsize);
                for (int i38 = i36 & i20; i38 > 0; i38--) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                int i39 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr2, i22 * i39, i39);
                int i40 = this.w;
                i36 >>>= i40;
                i22++;
                i37 += i40;
            }
        } else if (i4 < 57) {
            int i41 = this.mdsize;
            int i42 = (i41 << 3) - i4;
            int i43 = (1 << i4) - 1;
            byte[] bArr7 = new byte[i41];
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            while (i44 <= i42) {
                int i47 = i44 % 8;
                i44 += this.w;
                long j3 = 0;
                int i48 = 0;
                for (int i49 = i44 >>> 3; i49 < ((i44 + 7) >>> 3); i49++) {
                    j3 ^= (bArr4[i49] & 255) << (i48 << 3);
                    i48++;
                }
                long j4 = (j3 >>> i47) & i43;
                i46 = (int) (i46 + j4);
                System.arraycopy(this.privateKeyOTS[i45], 0, bArr7, 0, this.mdsize);
                while (j4 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    j4--;
                }
                int i50 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i45 * i50, i50);
                i45++;
            }
            int i51 = i44 >>> 3;
            if (i51 < this.mdsize) {
                int i52 = i44 % 8;
                long j5 = 0;
                int i53 = 0;
                while (true) {
                    i = this.mdsize;
                    if (i51 >= i) {
                        break;
                    }
                    j5 ^= (bArr4[i51] & 255) << (i53 << 3);
                    i53++;
                    i51++;
                }
                long j6 = (j5 >>> i52) & i43;
                i46 = (int) (i46 + j6);
                System.arraycopy(this.privateKeyOTS[i45], 0, bArr7, 0, i);
                while (j6 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    j6--;
                }
                int i54 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i45 * i54, i54);
                i45++;
            }
            int i55 = (this.messagesize << this.w) - i46;
            int i56 = 0;
            while (i56 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i45], 0, bArr7, 0, this.mdsize);
                for (long j7 = i55 & i43; j7 > 0; j7--) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                }
                int i57 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i45 * i57, i57);
                int i58 = this.w;
                i55 >>>= i58;
                i45++;
                i56 += i58;
            }
        }
        return bArr2;
    }
}
