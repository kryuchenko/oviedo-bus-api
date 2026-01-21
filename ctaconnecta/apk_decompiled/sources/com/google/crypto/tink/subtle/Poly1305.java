package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    private static long load32(byte[] in, int idx) {
        return (((in[idx + 3] & 255) << 24) | (in[idx] & 255) | ((in[idx + 1] & 255) << 8) | ((in[idx + 2] & 255) << 16)) & 4294967295L;
    }

    private static long load26(byte[] in, int idx, int shift) {
        return (load32(in, idx) >> shift) & 67108863;
    }

    private static void toByteArray(byte[] output, long num, int idx) {
        int i = 0;
        while (i < 4) {
            output[idx + i] = (byte) (255 & num);
            i++;
            num >>= 8;
        }
    }

    private static void copyBlockSize(byte[] output, byte[] in, int idx) {
        int iMin = Math.min(16, in.length - idx);
        System.arraycopy(in, idx, output, 0, iMin);
        output[iMin] = 1;
        if (iMin != 16) {
            Arrays.fill(output, iMin + 1, output.length, (byte) 0);
        }
    }

    static byte[] computeMac(final byte[] key, byte[] data) {
        if (key.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long jLoad26 = load26(key, 0, 0) & 67108863;
        int i = 3;
        int i2 = 2;
        long jLoad262 = load26(key, 3, 2) & 67108611;
        long jLoad263 = load26(key, 6, 4) & 67092735;
        long jLoad264 = load26(key, 9, 6) & 66076671;
        long jLoad265 = load26(key, 12, 8) & 1048575;
        long j = jLoad262 * 5;
        long j2 = jLoad263 * 5;
        long j3 = jLoad264 * 5;
        long j4 = jLoad265 * 5;
        byte[] bArr = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i3 = 0;
        while (i3 < data.length) {
            copyBlockSize(bArr, data, i3);
            long jLoad266 = j9 + load26(bArr, 0, 0);
            long jLoad267 = j5 + load26(bArr, i, i2);
            long jLoad268 = j6 + load26(bArr, 6, 4);
            long jLoad269 = j7 + load26(bArr, 9, 6);
            long j10 = jLoad262;
            long jLoad2610 = j8 + (load26(bArr, 12, 8) | (bArr[16] << Ascii.CAN));
            long j11 = (jLoad266 * jLoad26) + (jLoad267 * j4) + (jLoad268 * j3) + (jLoad269 * j2) + (jLoad2610 * j);
            long j12 = (jLoad266 * j10) + (jLoad267 * jLoad26) + (jLoad268 * j4) + (jLoad269 * j3) + (jLoad2610 * j2);
            long j13 = (jLoad266 * jLoad263) + (jLoad267 * j10) + (jLoad268 * jLoad26) + (jLoad269 * j4) + (jLoad2610 * j3);
            long j14 = (jLoad266 * jLoad264) + (jLoad267 * jLoad263) + (jLoad268 * j10) + (jLoad269 * jLoad26) + (jLoad2610 * j4);
            long j15 = (jLoad266 * jLoad265) + (jLoad267 * jLoad264) + (jLoad268 * jLoad263) + (jLoad269 * j10) + (jLoad2610 * jLoad26);
            long j16 = j12 + (j11 >> 26);
            long j17 = j13 + (j16 >> 26);
            j6 = j17 & 67108863;
            long j18 = j14 + (j17 >> 26);
            j7 = j18 & 67108863;
            long j19 = j15 + (j18 >> 26);
            j8 = j19 & 67108863;
            long j20 = (j11 & 67108863) + ((j19 >> 26) * 5);
            j9 = j20 & 67108863;
            j5 = (j16 & 67108863) + (j20 >> 26);
            i3 += 16;
            jLoad262 = j10;
            i = 3;
            i2 = 2;
        }
        long j21 = j6 + (j5 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j7 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j8 + (j23 >> 26);
        long j26 = j25 & 67108863;
        long j27 = j9 + ((j25 >> 26) * 5);
        long j28 = j27 & 67108863;
        long j29 = (j5 & 67108863) + (j27 >> 26);
        long j30 = j28 + 5;
        long j31 = j30 & 67108863;
        long j32 = (j30 >> 26) + j29;
        long j33 = j22 + (j32 >> 26);
        long j34 = j24 + (j33 >> 26);
        long j35 = j34 & 67108863;
        long j36 = (j26 + (j34 >> 26)) - 67108864;
        long j37 = j36 >> 63;
        long j38 = j28 & j37;
        long j39 = j29 & j37;
        long j40 = j22 & j37;
        long j41 = j24 & j37;
        long j42 = j26 & j37;
        long j43 = ~j37;
        long j44 = (j32 & 67108863 & j43) | j39;
        long j45 = (j33 & 67108863 & j43) | j40;
        long j46 = (j35 & j43) | j41;
        long j47 = j42 | (j36 & j43);
        long j48 = (j38 | (j31 & j43) | (j44 << 26)) & 4294967295L;
        long j49 = ((j44 >> 6) | (j45 << 20)) & 4294967295L;
        long j50 = ((j45 >> 12) | (j46 << 14)) & 4294967295L;
        long j51 = ((j46 >> 18) | (j47 << 8)) & 4294967295L;
        long jLoad32 = j48 + load32(key, 16);
        long j52 = jLoad32 & 4294967295L;
        long jLoad322 = j49 + load32(key, 20) + (jLoad32 >> 32);
        long j53 = jLoad322 & 4294967295L;
        long jLoad323 = j50 + load32(key, 24) + (jLoad322 >> 32);
        long j54 = jLoad323 & 4294967295L;
        long jLoad324 = (j51 + load32(key, 28) + (jLoad323 >> 32)) & 4294967295L;
        byte[] bArr2 = new byte[16];
        toByteArray(bArr2, j52, 0);
        toByteArray(bArr2, j53, 4);
        toByteArray(bArr2, j54, 8);
        toByteArray(bArr2, jLoad324, 12);
        return bArr2;
    }

    static void verifyMac(final byte[] key, byte[] data, byte[] mac) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(key, data), mac)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
