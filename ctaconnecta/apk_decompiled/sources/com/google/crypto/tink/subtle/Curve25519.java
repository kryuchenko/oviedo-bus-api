package com.google.crypto.tink.subtle;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

/* loaded from: classes4.dex */
final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{ISO7816.INS_CREATE_FILE, -21, 122, 124, 59, 65, -72, -82, Ascii.SYN, 86, -29, -6, -15, -97, -60, 106, ISO7816.INS_PUT_DATA, 9, ISOFileInfo.ENV_TEMP_EF, -21, -100, ISO7816.INS_INCREASE, ISO7816.INS_READ_BINARY2, -3, -122, ISOFileInfo.FCP_BYTE, 5, Ascii.SYN, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_CHANGE_CHV, ISO7816.INS_READ_BINARY2, ISO7816.INS_WRITE_BINARY, ISO7816.INS_READ_BINARY2, 85, -100, ISOFileInfo.FILE_IDENTIFIER, ByteSourceJsonBootstrapper.UTF8_BOM_1, 91, 4, ISO7816.INS_REHABILITATE_CHV, 92, -60, 88, 28, ISOFileInfo.CHANNEL_SECURITY, -122, ISO7816.INS_LOAD_KEY_FILE, ISO7816.INS_MSE, 78, -35, ISO7816.INS_WRITE_BINARY, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    Curve25519() {
    }

    private static void monty(long[] x2, long[] z2, long[] x3, long[] z3, long[] x, long[] z, long[] xprime, long[] zprime, long[] qmqp) {
        long[] jArrCopyOf = Arrays.copyOf(x, 10);
        long[] jArr = new long[19];
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        long[] jArr4 = new long[19];
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        Field25519.sum(x, z);
        Field25519.sub(z, jArrCopyOf);
        long[] jArrCopyOf2 = Arrays.copyOf(xprime, 10);
        Field25519.sum(xprime, zprime);
        Field25519.sub(zprime, jArrCopyOf2);
        Field25519.product(jArr4, xprime, z);
        Field25519.product(jArr5, x, zprime);
        Field25519.reduceSizeByModularReduction(jArr4);
        Field25519.reduceCoefficients(jArr4);
        Field25519.reduceSizeByModularReduction(jArr5);
        Field25519.reduceCoefficients(jArr5);
        System.arraycopy(jArr4, 0, jArrCopyOf2, 0, 10);
        Field25519.sum(jArr4, jArr5);
        Field25519.sub(jArr5, jArrCopyOf2);
        Field25519.square(jArr7, jArr4);
        Field25519.square(jArr6, jArr5);
        Field25519.product(jArr5, jArr6, qmqp);
        Field25519.reduceSizeByModularReduction(jArr5);
        Field25519.reduceCoefficients(jArr5);
        System.arraycopy(jArr7, 0, x3, 0, 10);
        System.arraycopy(jArr5, 0, z3, 0, 10);
        Field25519.square(jArr2, x);
        Field25519.square(jArr3, z);
        Field25519.product(x2, jArr2, jArr3);
        Field25519.reduceSizeByModularReduction(x2);
        Field25519.reduceCoefficients(x2);
        Field25519.sub(jArr3, jArr2);
        Arrays.fill(jArr, 10, 18, 0L);
        Field25519.scalarProduct(jArr, jArr3, 121665L);
        Field25519.reduceCoefficients(jArr);
        Field25519.sum(jArr, jArr2);
        Field25519.product(z2, jArr3, jArr);
        Field25519.reduceSizeByModularReduction(z2);
        Field25519.reduceCoefficients(z2);
    }

    static void swapConditional(long[] a, long[] b, int iswap) {
        int i = -iswap;
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = (((int) a[i2]) ^ ((int) b[i2])) & i;
            a[i2] = ((int) r1) ^ i3;
            b[i2] = ((int) b[i2]) ^ i3;
        }
    }

    static void copyConditional(long[] a, long[] b, int icopy) {
        int i = -icopy;
        for (int i2 = 0; i2 < 10; i2++) {
            long j = a[i2];
            a[i2] = ((int) j) ^ ((((int) j) ^ ((int) b[i2])) & i);
        }
    }

    static void curveMult(long[] resultx, byte[] n, byte[] qBytes) throws InvalidKeyException {
        validatePubKeyAndClearMsb(qBytes);
        long[] jArrExpand = Field25519.expand(qBytes);
        long[] jArr = new long[19];
        long[] jArr2 = new long[19];
        jArr2[0] = 1;
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        jArr6[0] = 1;
        long[] jArr7 = new long[19];
        long[] jArr8 = new long[19];
        jArr8[0] = 1;
        System.arraycopy(jArrExpand, 0, jArr, 0, 10);
        int i = 0;
        while (i < 32) {
            int i2 = n[31 - i] & 255;
            long[] jArr9 = jArr5;
            long[] jArr10 = jArr2;
            long[] jArr11 = jArr9;
            long[] jArr12 = jArr3;
            long[] jArr13 = jArr4;
            long[] jArr14 = jArr6;
            int i3 = 0;
            long[] jArr15 = jArr;
            long[] jArr16 = jArr8;
            long[] jArr17 = jArr7;
            while (i3 < 8) {
                int i4 = (i2 >> (7 - i3)) & 1;
                swapConditional(jArr12, jArr15, i4);
                swapConditional(jArr13, jArr10, i4);
                monty(jArr17, jArr16, jArr11, jArr14, jArr12, jArr13, jArr15, jArr10, jArrExpand);
                swapConditional(jArr17, jArr11, i4);
                swapConditional(jArr16, jArr14, i4);
                i3++;
                long[] jArr18 = jArr12;
                jArr12 = jArr17;
                jArr17 = jArr18;
                long[] jArr19 = jArr13;
                jArr13 = jArr16;
                jArr16 = jArr19;
                long[] jArr20 = jArr15;
                jArr15 = jArr11;
                jArr11 = jArr20;
                long[] jArr21 = jArr10;
                jArr10 = jArr14;
                jArr14 = jArr21;
            }
            i++;
            long[] jArr22 = jArr10;
            jArr5 = jArr11;
            jArr2 = jArr22;
            jArr7 = jArr17;
            jArr8 = jArr16;
            jArr6 = jArr14;
            jArr = jArr15;
            jArr4 = jArr13;
            jArr3 = jArr12;
        }
        long[] jArr23 = new long[10];
        Field25519.inverse(jArr23, jArr4);
        Field25519.mult(resultx, jArr3, jArr23);
        if (isCollinear(jArrExpand, resultx, jArr, jArr2)) {
            return;
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + Hex.encode(qBytes));
    }

    private static void validatePubKeyAndClearMsb(byte[] pubKey) throws InvalidKeyException {
        if (pubKey.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        pubKey[31] = (byte) (pubKey[31] & Byte.MAX_VALUE);
        int i = 0;
        while (true) {
            byte[][] bArr = BANNED_PUBLIC_KEYS;
            if (i >= bArr.length) {
                return;
            }
            if (Bytes.equal(bArr[i], pubKey)) {
                throw new InvalidKeyException("Banned public key: " + Hex.encode(bArr[i]));
            }
            i++;
        }
    }

    private static boolean isCollinear(long[] x1, long[] x2, long[] x3, long[] z3) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[11];
        long[] jArr4 = new long[11];
        long[] jArr5 = new long[11];
        Field25519.mult(jArr, x1, x2);
        Field25519.sum(jArr2, x1, x2);
        long[] jArr6 = new long[10];
        jArr6[0] = 486662;
        Field25519.sum(jArr4, jArr2, jArr6);
        Field25519.mult(jArr4, jArr4, z3);
        Field25519.sum(jArr4, x3);
        Field25519.mult(jArr4, jArr4, jArr);
        Field25519.mult(jArr4, jArr4, x3);
        Field25519.scalarProduct(jArr3, jArr4, 4L);
        Field25519.reduceCoefficients(jArr3);
        Field25519.mult(jArr4, jArr, z3);
        Field25519.sub(jArr4, jArr4, z3);
        Field25519.mult(jArr5, jArr2, x3);
        Field25519.sum(jArr4, jArr4, jArr5);
        Field25519.square(jArr4, jArr4);
        return Bytes.equal(Field25519.contract(jArr3), Field25519.contract(jArr4));
    }
}
