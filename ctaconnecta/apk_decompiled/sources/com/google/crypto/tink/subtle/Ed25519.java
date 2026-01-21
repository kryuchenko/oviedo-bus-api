package com.google.crypto.tink.subtle;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;

/* loaded from: classes4.dex */
final class Ed25519 {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, ISO7816.INS_UPDATE_BINARY, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    private static int eq(int a, int b) {
        int i = (~(a ^ b)) & 255;
        int i2 = i & (i << 4);
        int i3 = i2 & (i2 << 2);
        return ((i3 & (i3 << 1)) >> 7) & 1;
    }

    Ed25519() {
    }

    private static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] x, long[] y, long[] z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ out, PartialXYZT in) {
            Field25519.mult(out.x, in.xyz.x, in.t);
            Field25519.mult(out.y, in.xyz.y, in.xyz.z);
            Field25519.mult(out.z, in.xyz.z, in.t);
            return out;
        }

        byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.z);
            Field25519.mult(jArr2, this.x, jArr);
            Field25519.mult(jArr3, this.y, jArr);
            byte[] bArrContract = Field25519.contract(jArr3);
            bArrContract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ bArrContract[31]);
            return bArrContract;
        }

        boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }
    }

    private static class XYZT {
        final long[] t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.t = t;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT out, PartialXYZT in) {
            Field25519.mult(out.xyz.x, in.xyz.x, in.t);
            Field25519.mult(out.xyz.y, in.xyz.y, in.xyz.z);
            Field25519.mult(out.xyz.z, in.xyz.z, in.t);
            Field25519.mult(out.t, in.xyz.x, in.xyz.y);
            return out;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] s) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] jArrExpand = Field25519.expand(s);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, jArrExpand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((s[31] & 255) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((s[31] & 255) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, jArrExpand);
                return new XYZT(new XYZ(jArr, jArrExpand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }
    }

    private static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] t) {
            this.xyz = xyz;
            this.t = t;
        }

        PartialXYZT(PartialXYZT other) {
            this.xyz = new XYZ(other.xyz);
            this.t = Arrays.copyOf(other.t, 10);
        }
    }

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(long[] yPlusX, long[] yMinusX, long[] t2d) {
            this.yPlusX = yPlusX;
            this.yMinusX = yMinusX;
            this.t2d = t2d;
        }

        CachedXYT(CachedXYT other) {
            this.yPlusX = Arrays.copyOf(other.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(other.yMinusX, 10);
            this.t2d = Arrays.copyOf(other.t2d, 10);
        }

        void multByZ(long[] output, long[] in) {
            System.arraycopy(in, 0, output, 0, 10);
        }

        void copyConditional(CachedXYT other, int icopy) {
            Curve25519.copyConditional(this.yPlusX, other.yPlusX, icopy);
            Curve25519.copyConditional(this.yMinusX, other.yMinusX, icopy);
            Curve25519.copyConditional(this.t2d, other.t2d, icopy);
        }
    }

    private static class CachedXYZT extends CachedXYT {
        private final long[] z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            Field25519.sum(this.yPlusX, xyzt.xyz.y, xyzt.xyz.x);
            Field25519.sub(this.yMinusX, xyzt.xyz.y, xyzt.xyz.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] yPlusX, long[] yMinusX, long[] z, long[] t2d) {
            super(yPlusX, yMinusX, t2d);
            this.z = z;
        }

        @Override // com.google.crypto.tink.subtle.Ed25519.CachedXYT
        public void multByZ(long[] output, long[] in) {
            Field25519.mult(output, in, this.z);
        }
    }

    private static void add(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.x, extended.xyz.y, extended.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, extended.xyz.y, extended.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cached.yMinusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cached.yPlusX);
        Field25519.mult(partialXYZT.t, extended.t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.x, extended.xyz.z);
        Field25519.sum(jArr, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.z, jArr, partialXYZT.t);
        Field25519.sub(partialXYZT.t, jArr, partialXYZT.t);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT extended, CachedXYT cached) {
        long[] jArr = new long[10];
        Field25519.sum(partialXYZT.xyz.x, extended.xyz.y, extended.xyz.x);
        Field25519.sub(partialXYZT.xyz.y, extended.xyz.y, extended.xyz.x);
        Field25519.mult(partialXYZT.xyz.y, partialXYZT.xyz.y, cached.yPlusX);
        Field25519.mult(partialXYZT.xyz.z, partialXYZT.xyz.x, cached.yMinusX);
        Field25519.mult(partialXYZT.t, extended.t, cached.t2d);
        cached.multByZ(partialXYZT.xyz.x, extended.xyz.z);
        Field25519.sum(jArr, partialXYZT.xyz.x, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.xyz.z, jArr, partialXYZT.t);
        Field25519.sum(partialXYZT.t, jArr, partialXYZT.t);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ p) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.x, p.x);
        Field25519.square(partialXYZT.xyz.z, p.y);
        Field25519.square(partialXYZT.t, p.z);
        Field25519.sum(partialXYZT.t, partialXYZT.t, partialXYZT.t);
        Field25519.sum(partialXYZT.xyz.y, p.x, p.y);
        Field25519.square(jArr, partialXYZT.xyz.y);
        Field25519.sum(partialXYZT.xyz.y, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.z, partialXYZT.xyz.z, partialXYZT.xyz.x);
        Field25519.sub(partialXYZT.xyz.x, jArr, partialXYZT.xyz.y);
        Field25519.sub(partialXYZT.t, partialXYZT.t, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT p) {
        doubleXYZ(partialXYZT, p.xyz);
    }

    private static void select(CachedXYT t, int pos, byte b) {
        int i = (b & 255) >> 7;
        int i2 = b - (((-i) & b) << 1);
        t.copyConditional(Ed25519Constants.B_TABLE[pos][0], eq(i2, 1));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][1], eq(i2, 2));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][2], eq(i2, 3));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][3], eq(i2, 4));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][4], eq(i2, 5));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][5], eq(i2, 6));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][6], eq(i2, 7));
        t.copyConditional(Ed25519Constants.B_TABLE[pos][7], eq(i2, 8));
        long[] jArrCopyOf = Arrays.copyOf(t.yMinusX, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(t.yPlusX, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(t.t2d, 10);
        neg(jArrCopyOf3, jArrCopyOf3);
        t.copyConditional(new CachedXYT(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i);
    }

    private static XYZ scalarMultWithBase(byte[] a) {
        int i;
        byte[] bArr = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr[i3] = (byte) (a[i2] & 15);
            bArr[i3 + 1] = (byte) (((a[i2] & 255) >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr[i4] + i5);
            bArr[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr[63] = (byte) (bArr[63] + i5);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i7 = 0; i7 < 64; i7 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i7 / 2, bArr[i7]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    static byte[] scalarMultWithBaseToBytes(byte[] a) {
        return scalarMultWithBase(a).toBytes();
    }

    private static byte[] slide(byte[] a) {
        int i;
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) (1 & ((a[i2 >> 3] & 255) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr[i];
                    if (b != 0) {
                        byte b2 = bArr[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr[i3] = (byte) (b2 + (b << i4));
                            bArr[i] = 0;
                        } else if (b2 - (b << i4) >= -15) {
                            bArr[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr[i] == 0) {
                                    bArr[i] = 1;
                                    break;
                                }
                                bArr[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr;
    }

    private static XYZ doubleScalarMultVarTime(byte[] a, XYZT pointA, byte[] b) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(pointA);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, pointA);
        XYZT xyzt = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] bArrSlide = slide(a);
        byte[] bArrSlide2 = slide(b);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt2 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && bArrSlide[i2] == 0 && bArrSlide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b2 = bArrSlide[i2];
            if (b2 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), cachedXYZTArr[bArrSlide[i2] / 2]);
            } else if (b2 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), cachedXYZTArr[(-bArrSlide[i2]) / 2]);
            }
            byte b3 = bArrSlide2[i2];
            if (b3 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), Ed25519Constants.B2[bArrSlide2[i2] / 2]);
            } else if (b3 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt2, partialXYZT2), Ed25519Constants.B2[(-bArrSlide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] in) {
        long[] jArr = new long[in.length + 1];
        System.arraycopy(in, 0, jArr, 0, in.length);
        Field25519.reduceCoefficients(jArr);
        for (byte b : Field25519.contract(jArr)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] in) {
        return Field25519.contract(in)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] out, long[] in) {
        for (int i = 0; i < in.length; i++) {
            out[i] = -in[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] out, long[] in) {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        Field25519.square(jArr, in);
        Field25519.square(jArr2, jArr);
        Field25519.square(jArr2, jArr2);
        Field25519.mult(jArr2, in, jArr2);
        Field25519.mult(jArr, jArr, jArr2);
        Field25519.square(jArr, jArr);
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i2 = 1; i2 < 10; i2++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr2, jArr2, jArr);
        Field25519.square(jArr3, jArr2);
        for (int i3 = 1; i3 < 20; i3++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr2, jArr3, jArr2);
        Field25519.square(jArr2, jArr2);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr2, jArr);
        for (int i5 = 1; i5 < 50; i5++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr2, jArr2, jArr);
        Field25519.square(jArr3, jArr2);
        for (int i6 = 1; i6 < 100; i6++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr2, jArr3, jArr2);
        Field25519.square(jArr2, jArr2);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.square(jArr2, jArr2);
        }
        Field25519.mult(jArr, jArr2, jArr);
        Field25519.square(jArr, jArr);
        Field25519.square(jArr, jArr);
        Field25519.mult(out, jArr, in);
    }

    private static long load3(byte[] in, int idx) {
        return ((in[idx + 2] & 255) << 16) | (in[idx] & 255) | ((in[idx + 1] & 255) << 8);
    }

    private static long load4(byte[] in, int idx) {
        return ((in[idx + 3] & 255) << 24) | load3(in, idx);
    }

    private static void reduce(byte[] s) {
        long jLoad3 = load3(s, 0) & 2097151;
        long jLoad4 = (load4(s, 2) >> 5) & 2097151;
        long jLoad32 = (load3(s, 5) >> 2) & 2097151;
        long jLoad42 = (load4(s, 7) >> 7) & 2097151;
        long jLoad43 = (load4(s, 10) >> 4) & 2097151;
        long jLoad33 = (load3(s, 13) >> 1) & 2097151;
        long jLoad44 = (load4(s, 15) >> 6) & 2097151;
        long jLoad34 = (load3(s, 18) >> 3) & 2097151;
        long jLoad35 = load3(s, 21) & 2097151;
        long jLoad45 = (load4(s, 23) >> 5) & 2097151;
        long jLoad36 = (load3(s, 26) >> 2) & 2097151;
        long jLoad46 = (load4(s, 28) >> 7) & 2097151;
        long jLoad47 = (load4(s, 31) >> 4) & 2097151;
        long jLoad37 = (load3(s, 34) >> 1) & 2097151;
        long jLoad48 = (load4(s, 36) >> 6) & 2097151;
        long jLoad38 = (load3(s, 39) >> 3) & 2097151;
        long jLoad39 = load3(s, 42) & 2097151;
        long jLoad49 = (load4(s, 44) >> 5) & 2097151;
        long jLoad310 = (load3(s, 47) >> 2) & 2097151;
        long jLoad410 = (load4(s, 49) >> 7) & 2097151;
        long jLoad411 = (load4(s, 52) >> 4) & 2097151;
        long jLoad311 = (load3(s, 55) >> 1) & 2097151;
        long jLoad412 = (load4(s, 57) >> 6) & 2097151;
        long jLoad413 = load4(s, 60) >> 3;
        long j = jLoad39 - (jLoad413 * 683901);
        long j2 = ((jLoad48 - (jLoad413 * 997805)) + (jLoad412 * 136657)) - (jLoad311 * 683901);
        long j3 = ((((jLoad47 + (jLoad413 * 470296)) + (jLoad412 * 654183)) - (jLoad311 * 997805)) + (jLoad411 * 136657)) - (jLoad410 * 683901);
        long j4 = jLoad44 + (jLoad310 * 666643);
        long j5 = jLoad34 + (jLoad410 * 666643) + (jLoad310 * 470296);
        long j6 = jLoad35 + (jLoad411 * 666643) + (jLoad410 * 470296) + (jLoad310 * 654183);
        long j7 = (((jLoad45 + (jLoad311 * 666643)) + (jLoad411 * 470296)) + (jLoad410 * 654183)) - (jLoad310 * 997805);
        long j8 = ((((jLoad36 + (jLoad412 * 666643)) + (jLoad311 * 470296)) + (jLoad411 * 654183)) - (jLoad410 * 997805)) + (jLoad310 * 136657);
        long j9 = (((((jLoad46 + (jLoad413 * 666643)) + (jLoad412 * 470296)) + (jLoad311 * 654183)) - (jLoad411 * 997805)) + (jLoad410 * 136657)) - (jLoad310 * 683901);
        long j10 = (j4 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j11 = j5 + j10;
        long j12 = j4 - (j10 << 21);
        long j13 = (j6 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j14 = j7 + j13;
        long j15 = j6 - (j13 << 21);
        long j16 = (j8 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j17 = j9 + j16;
        long j18 = j8 - (j16 << 21);
        long j19 = (j3 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j20 = ((((jLoad37 + (jLoad413 * 654183)) - (jLoad412 * 997805)) + (jLoad311 * 136657)) - (jLoad411 * 683901)) + j19;
        long j21 = j3 - (j19 << 21);
        long j22 = (j2 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j23 = ((jLoad38 + (jLoad413 * 136657)) - (jLoad412 * 683901)) + j22;
        long j24 = j2 - (j22 << 21);
        long j25 = (j + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j26 = jLoad49 + j25;
        long j27 = j - (j25 << 21);
        long j28 = (j11 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j29 = j15 + j28;
        long j30 = j11 - (j28 << 21);
        long j31 = (j14 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j32 = j18 + j31;
        long j33 = j14 - (j31 << 21);
        long j34 = (j17 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j35 = j21 + j34;
        long j36 = j17 - (j34 << 21);
        long j37 = (j20 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j38 = j24 + j37;
        long j39 = j20 - (j37 << 21);
        long j40 = (j23 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j41 = j27 + j40;
        long j42 = j23 - (j40 << 21);
        long j43 = j32 - (j26 * 683901);
        long j44 = ((j29 - (j26 * 997805)) + (j41 * 136657)) - (j42 * 683901);
        long j45 = ((((j12 + (j26 * 470296)) + (j41 * 654183)) - (j42 * 997805)) + (j38 * 136657)) - (j39 * 683901);
        long j46 = jLoad3 + (j35 * 666643);
        long j47 = jLoad4 + (j39 * 666643) + (j35 * 470296);
        long j48 = jLoad32 + (j38 * 666643) + (j39 * 470296) + (j35 * 654183);
        long j49 = (((jLoad42 + (j42 * 666643)) + (j38 * 470296)) + (j39 * 654183)) - (j35 * 997805);
        long j50 = ((((jLoad43 + (j41 * 666643)) + (j42 * 470296)) + (j38 * 654183)) - (j39 * 997805)) + (j35 * 136657);
        long j51 = (((((jLoad33 + (j26 * 666643)) + (j41 * 470296)) + (j42 * 654183)) - (j38 * 997805)) + (j39 * 136657)) - (j35 * 683901);
        long j52 = (j46 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j53 = j47 + j52;
        long j54 = j46 - (j52 << 21);
        long j55 = (j48 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j56 = j49 + j55;
        long j57 = j48 - (j55 << 21);
        long j58 = (j50 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j59 = j51 + j58;
        long j60 = j50 - (j58 << 21);
        long j61 = (j45 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j62 = ((((j30 + (j26 * 654183)) - (j41 * 997805)) + (j42 * 136657)) - (j38 * 683901)) + j61;
        long j63 = j45 - (j61 << 21);
        long j64 = (j44 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j65 = ((j33 + (j26 * 136657)) - (j41 * 683901)) + j64;
        long j66 = j44 - (j64 << 21);
        long j67 = (j43 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j68 = j36 + j67;
        long j69 = j43 - (j67 << 21);
        long j70 = (j53 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j71 = j57 + j70;
        long j72 = j53 - (j70 << 21);
        long j73 = (j56 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j74 = j60 + j73;
        long j75 = j56 - (j73 << 21);
        long j76 = (j59 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j77 = j63 + j76;
        long j78 = j59 - (j76 << 21);
        long j79 = (j62 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j80 = j66 + j79;
        long j81 = j62 - (j79 << 21);
        long j82 = (j65 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j83 = (j68 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j84 = j68 - (j83 << 21);
        long j85 = j54 + (j83 * 666643);
        long j86 = j72 + (j83 * 470296);
        long j87 = j71 + (j83 * 654183);
        long j88 = j75 - (j83 * 997805);
        long j89 = j74 + (j83 * 136657);
        long j90 = j78 - (j83 * 683901);
        long j91 = j85 >> 21;
        long j92 = j86 + j91;
        long j93 = j85 - (j91 << 21);
        long j94 = j92 >> 21;
        long j95 = j87 + j94;
        long j96 = j92 - (j94 << 21);
        long j97 = j95 >> 21;
        long j98 = j88 + j97;
        long j99 = j95 - (j97 << 21);
        long j100 = j98 >> 21;
        long j101 = j89 + j100;
        long j102 = j98 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j90 + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = j77 + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j81 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = j80 + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = (j65 - (j82 << 21)) + j115;
        long j117 = j113 - (j115 << 21);
        long j118 = j116 >> 21;
        long j119 = j69 + j82 + j118;
        long j120 = j116 - (j118 << 21);
        long j121 = j119 >> 21;
        long j122 = j84 + j121;
        long j123 = j119 - (j121 << 21);
        long j124 = j122 >> 21;
        long j125 = j122 - (j124 << 21);
        long j126 = j93 + (666643 * j124);
        long j127 = j96 + (470296 * j124);
        long j128 = j99 + (654183 * j124);
        long j129 = j102 - (997805 * j124);
        long j130 = j105 + (136657 * j124);
        long j131 = j108 - (j124 * 683901);
        long j132 = j126 >> 21;
        long j133 = j127 + j132;
        long j134 = j126 - (j132 << 21);
        long j135 = j133 >> 21;
        long j136 = j128 + j135;
        long j137 = j133 - (j135 << 21);
        long j138 = j136 >> 21;
        long j139 = j129 + j138;
        long j140 = j136 - (j138 << 21);
        long j141 = j139 >> 21;
        long j142 = j130 + j141;
        long j143 = j139 - (j141 << 21);
        long j144 = j142 >> 21;
        long j145 = j131 + j144;
        long j146 = j142 - (j144 << 21);
        long j147 = j145 >> 21;
        long j148 = j111 + j147;
        long j149 = j145 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j114 + j150;
        long j152 = j148 - (j150 << 21);
        long j153 = j151 >> 21;
        long j154 = j117 + j153;
        long j155 = j151 - (j153 << 21);
        long j156 = j154 >> 21;
        long j157 = j120 + j156;
        long j158 = j154 - (j156 << 21);
        long j159 = j157 >> 21;
        long j160 = j123 + j159;
        long j161 = j157 - (j159 << 21);
        long j162 = j160 >> 21;
        long j163 = j125 + j162;
        long j164 = j160 - (j162 << 21);
        s[0] = (byte) j134;
        s[1] = (byte) (j134 >> 8);
        s[2] = (byte) ((j134 >> 16) | (j137 << 5));
        s[3] = (byte) (j137 >> 3);
        s[4] = (byte) (j137 >> 11);
        s[5] = (byte) ((j137 >> 19) | (j140 << 2));
        s[6] = (byte) (j140 >> 6);
        s[7] = (byte) ((j140 >> 14) | (j143 << 7));
        s[8] = (byte) (j143 >> 1);
        s[9] = (byte) (j143 >> 9);
        s[10] = (byte) ((j143 >> 17) | (j146 << 4));
        s[11] = (byte) (j146 >> 4);
        s[12] = (byte) (j146 >> 12);
        s[13] = (byte) ((j146 >> 20) | (j149 << 1));
        s[14] = (byte) (j149 >> 7);
        s[15] = (byte) ((j149 >> 15) | (j152 << 6));
        s[16] = (byte) (j152 >> 2);
        s[17] = (byte) (j152 >> 10);
        s[18] = (byte) ((j152 >> 18) | (j155 << 3));
        s[19] = (byte) (j155 >> 5);
        s[20] = (byte) (j155 >> 13);
        s[21] = (byte) j158;
        s[22] = (byte) (j158 >> 8);
        s[23] = (byte) ((j158 >> 16) | (j161 << 5));
        s[24] = (byte) (j161 >> 3);
        s[25] = (byte) (j161 >> 11);
        s[26] = (byte) ((j161 >> 19) | (j164 << 2));
        s[27] = (byte) (j164 >> 6);
        s[28] = (byte) ((j164 >> 14) | (j163 << 7));
        s[29] = (byte) (j163 >> 1);
        s[30] = (byte) (j163 >> 9);
        s[31] = (byte) (j163 >> 17);
    }

    private static void mulAdd(byte[] s, byte[] a, byte[] b, byte[] c) {
        long jLoad3 = load3(a, 0) & 2097151;
        long jLoad4 = (load4(a, 2) >> 5) & 2097151;
        long jLoad32 = (load3(a, 5) >> 2) & 2097151;
        long jLoad42 = (load4(a, 7) >> 7) & 2097151;
        long jLoad43 = (load4(a, 10) >> 4) & 2097151;
        long jLoad33 = (load3(a, 13) >> 1) & 2097151;
        long jLoad44 = (load4(a, 15) >> 6) & 2097151;
        long jLoad34 = (load3(a, 18) >> 3) & 2097151;
        long jLoad35 = load3(a, 21) & 2097151;
        long jLoad45 = (load4(a, 23) >> 5) & 2097151;
        long jLoad36 = (load3(a, 26) >> 2) & 2097151;
        long jLoad46 = load4(a, 28) >> 7;
        long jLoad37 = load3(b, 0) & 2097151;
        long jLoad47 = (load4(b, 2) >> 5) & 2097151;
        long jLoad38 = (load3(b, 5) >> 2) & 2097151;
        long jLoad48 = (load4(b, 7) >> 7) & 2097151;
        long jLoad49 = (load4(b, 10) >> 4) & 2097151;
        long jLoad39 = (load3(b, 13) >> 1) & 2097151;
        long jLoad410 = (load4(b, 15) >> 6) & 2097151;
        long jLoad310 = (load3(b, 18) >> 3) & 2097151;
        long jLoad311 = load3(b, 21) & 2097151;
        long jLoad411 = (load4(b, 23) >> 5) & 2097151;
        long jLoad312 = (load3(b, 26) >> 2) & 2097151;
        long jLoad412 = load4(b, 28) >> 7;
        long jLoad313 = load3(c, 0) & 2097151;
        long jLoad413 = (load4(c, 2) >> 5) & 2097151;
        long jLoad314 = (load3(c, 5) >> 2) & 2097151;
        long jLoad414 = (load4(c, 7) >> 7) & 2097151;
        long jLoad415 = (load4(c, 10) >> 4) & 2097151;
        long jLoad315 = (load3(c, 13) >> 1) & 2097151;
        long jLoad416 = (load4(c, 15) >> 6) & 2097151;
        long jLoad316 = (load3(c, 18) >> 3) & 2097151;
        long jLoad317 = load3(c, 21) & 2097151;
        long j = jLoad313 + (jLoad3 * jLoad37);
        long j2 = jLoad413 + (jLoad3 * jLoad47) + (jLoad4 * jLoad37);
        long j3 = jLoad314 + (jLoad3 * jLoad38) + (jLoad4 * jLoad47) + (jLoad32 * jLoad37);
        long j4 = jLoad414 + (jLoad3 * jLoad48) + (jLoad4 * jLoad38) + (jLoad32 * jLoad47) + (jLoad42 * jLoad37);
        long j5 = jLoad415 + (jLoad3 * jLoad49) + (jLoad4 * jLoad48) + (jLoad32 * jLoad38) + (jLoad42 * jLoad47) + (jLoad43 * jLoad37);
        long j6 = jLoad315 + (jLoad3 * jLoad39) + (jLoad4 * jLoad49) + (jLoad32 * jLoad48) + (jLoad42 * jLoad38) + (jLoad43 * jLoad47) + (jLoad33 * jLoad37);
        long j7 = jLoad416 + (jLoad3 * jLoad410) + (jLoad4 * jLoad39) + (jLoad32 * jLoad49) + (jLoad42 * jLoad48) + (jLoad43 * jLoad38) + (jLoad33 * jLoad47) + (jLoad44 * jLoad37);
        long j8 = jLoad316 + (jLoad3 * jLoad310) + (jLoad4 * jLoad410) + (jLoad32 * jLoad39) + (jLoad42 * jLoad49) + (jLoad43 * jLoad48) + (jLoad33 * jLoad38) + (jLoad44 * jLoad47) + (jLoad34 * jLoad37);
        long j9 = jLoad317 + (jLoad3 * jLoad311) + (jLoad4 * jLoad310) + (jLoad32 * jLoad410) + (jLoad42 * jLoad39) + (jLoad43 * jLoad49) + (jLoad33 * jLoad48) + (jLoad44 * jLoad38) + (jLoad34 * jLoad47) + (jLoad35 * jLoad37);
        long jLoad417 = ((load4(c, 23) >> 5) & 2097151) + (jLoad3 * jLoad411) + (jLoad4 * jLoad311) + (jLoad32 * jLoad310) + (jLoad42 * jLoad410) + (jLoad43 * jLoad39) + (jLoad33 * jLoad49) + (jLoad44 * jLoad48) + (jLoad34 * jLoad38) + (jLoad35 * jLoad47) + (jLoad45 * jLoad37);
        long jLoad318 = ((load3(c, 26) >> 2) & 2097151) + (jLoad3 * jLoad312) + (jLoad4 * jLoad411) + (jLoad32 * jLoad311) + (jLoad42 * jLoad310) + (jLoad43 * jLoad410) + (jLoad33 * jLoad39) + (jLoad44 * jLoad49) + (jLoad34 * jLoad48) + (jLoad35 * jLoad38) + (jLoad45 * jLoad47) + (jLoad36 * jLoad37);
        long jLoad418 = (load4(c, 28) >> 7) + (jLoad3 * jLoad412) + (jLoad4 * jLoad312) + (jLoad32 * jLoad411) + (jLoad42 * jLoad311) + (jLoad43 * jLoad310) + (jLoad33 * jLoad410) + (jLoad44 * jLoad39) + (jLoad34 * jLoad49) + (jLoad35 * jLoad48) + (jLoad45 * jLoad38) + (jLoad36 * jLoad47) + (jLoad37 * jLoad46);
        long j10 = (jLoad4 * jLoad412) + (jLoad32 * jLoad312) + (jLoad42 * jLoad411) + (jLoad43 * jLoad311) + (jLoad33 * jLoad310) + (jLoad44 * jLoad410) + (jLoad34 * jLoad39) + (jLoad35 * jLoad49) + (jLoad45 * jLoad48) + (jLoad36 * jLoad38) + (jLoad47 * jLoad46);
        long j11 = (jLoad32 * jLoad412) + (jLoad42 * jLoad312) + (jLoad43 * jLoad411) + (jLoad33 * jLoad311) + (jLoad44 * jLoad310) + (jLoad34 * jLoad410) + (jLoad35 * jLoad39) + (jLoad45 * jLoad49) + (jLoad36 * jLoad48) + (jLoad38 * jLoad46);
        long j12 = (jLoad42 * jLoad412) + (jLoad43 * jLoad312) + (jLoad33 * jLoad411) + (jLoad44 * jLoad311) + (jLoad34 * jLoad310) + (jLoad35 * jLoad410) + (jLoad45 * jLoad39) + (jLoad36 * jLoad49) + (jLoad48 * jLoad46);
        long j13 = (jLoad43 * jLoad412) + (jLoad33 * jLoad312) + (jLoad44 * jLoad411) + (jLoad34 * jLoad311) + (jLoad35 * jLoad310) + (jLoad45 * jLoad410) + (jLoad36 * jLoad39) + (jLoad49 * jLoad46);
        long j14 = (jLoad33 * jLoad412) + (jLoad44 * jLoad312) + (jLoad34 * jLoad411) + (jLoad35 * jLoad311) + (jLoad45 * jLoad310) + (jLoad36 * jLoad410) + (jLoad39 * jLoad46);
        long j15 = (jLoad44 * jLoad412) + (jLoad34 * jLoad312) + (jLoad35 * jLoad411) + (jLoad45 * jLoad311) + (jLoad36 * jLoad310) + (jLoad410 * jLoad46);
        long j16 = (jLoad34 * jLoad412) + (jLoad35 * jLoad312) + (jLoad45 * jLoad411) + (jLoad36 * jLoad311) + (jLoad310 * jLoad46);
        long j17 = (jLoad35 * jLoad412) + (jLoad45 * jLoad312) + (jLoad36 * jLoad411) + (jLoad311 * jLoad46);
        long j18 = (jLoad45 * jLoad412) + (jLoad36 * jLoad312) + (jLoad411 * jLoad46);
        long j19 = (jLoad36 * jLoad412) + (jLoad312 * jLoad46);
        long j20 = jLoad46 * jLoad412;
        long j21 = (j + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j22 = j2 + j21;
        long j23 = j - (j21 << 21);
        long j24 = (j3 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j25 = j4 + j24;
        long j26 = j3 - (j24 << 21);
        long j27 = (j5 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j28 = j6 + j27;
        long j29 = j5 - (j27 << 21);
        long j30 = (j7 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j31 = j8 + j30;
        long j32 = j7 - (j30 << 21);
        long j33 = (j9 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j34 = jLoad417 + j33;
        long j35 = j9 - (j33 << 21);
        long j36 = (jLoad318 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j37 = jLoad418 + j36;
        long j38 = jLoad318 - (j36 << 21);
        long j39 = (j10 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j40 = j11 + j39;
        long j41 = j10 - (j39 << 21);
        long j42 = (j12 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j43 = j13 + j42;
        long j44 = j12 - (j42 << 21);
        long j45 = (j14 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j46 = j15 + j45;
        long j47 = j14 - (j45 << 21);
        long j48 = (j16 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j49 = j17 + j48;
        long j50 = j16 - (j48 << 21);
        long j51 = (j18 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j52 = j19 + j51;
        long j53 = j18 - (j51 << 21);
        long j54 = (j20 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j55 = (j22 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j56 = j26 + j55;
        long j57 = j22 - (j55 << 21);
        long j58 = (j25 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j59 = j29 + j58;
        long j60 = j25 - (j58 << 21);
        long j61 = (j28 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j62 = j32 + j61;
        long j63 = j28 - (j61 << 21);
        long j64 = (j31 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j65 = j35 + j64;
        long j66 = j31 - (j64 << 21);
        long j67 = (j34 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j68 = j38 + j67;
        long j69 = j34 - (j67 << 21);
        long j70 = (j37 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j71 = j41 + j70;
        long j72 = j37 - (j70 << 21);
        long j73 = (j40 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j74 = j44 + j73;
        long j75 = j40 - (j73 << 21);
        long j76 = (j43 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j77 = j47 + j76;
        long j78 = j43 - (j76 << 21);
        long j79 = (j46 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j80 = j50 + j79;
        long j81 = j46 - (j79 << 21);
        long j82 = (j49 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j83 = j53 + j82;
        long j84 = j49 - (j82 << 21);
        long j85 = (j52 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j86 = (j20 - (j54 << 21)) + j85;
        long j87 = j52 - (j85 << 21);
        long j88 = j78 + (j54 * 136657);
        long j89 = j77 - (j54 * 683901);
        long j90 = ((j75 + (j54 * 654183)) - (j86 * 997805)) + (j87 * 136657);
        long j91 = ((j74 - (j54 * 997805)) + (j86 * 136657)) - (j87 * 683901);
        long j92 = ((((j72 + (j54 * 666643)) + (j86 * 470296)) + (j87 * 654183)) - (j83 * 997805)) + (j84 * 136657);
        long j93 = ((((j71 + (j54 * 470296)) + (j86 * 654183)) - (j87 * 997805)) + (j83 * 136657)) - (j84 * 683901);
        long j94 = j62 + (j80 * 666643);
        long j95 = j65 + (j83 * 666643) + (j84 * 470296) + (j80 * 654183);
        long j96 = ((((j68 + (j86 * 666643)) + (j87 * 470296)) + (j83 * 654183)) - (j84 * 997805)) + (j80 * 136657);
        long j97 = (j94 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j98 = j66 + (j84 * 666643) + (j80 * 470296) + j97;
        long j99 = j94 - (j97 << 21);
        long j100 = (j95 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j101 = ((((j69 + (j87 * 666643)) + (j83 * 470296)) + (j84 * 654183)) - (j80 * 997805)) + j100;
        long j102 = j95 - (j100 << 21);
        long j103 = (j96 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j104 = (j92 - (j80 * 683901)) + j103;
        long j105 = j96 - (j103 << 21);
        long j106 = (j93 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j107 = (j90 - (j83 * 683901)) + j106;
        long j108 = j93 - (j106 << 21);
        long j109 = (j91 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j110 = (j88 - (j86 * 683901)) + j109;
        long j111 = j91 - (j109 << 21);
        long j112 = (j89 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j113 = j81 + j112;
        long j114 = j89 - (j112 << 21);
        long j115 = (j98 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j116 = j102 + j115;
        long j117 = j98 - (j115 << 21);
        long j118 = (j101 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j119 = j105 + j118;
        long j120 = j101 - (j118 << 21);
        long j121 = (j104 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j122 = j108 + j121;
        long j123 = j104 - (j121 << 21);
        long j124 = (j107 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j125 = j111 + j124;
        long j126 = j107 - (j124 << 21);
        long j127 = (j110 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j128 = j114 + j127;
        long j129 = j110 - (j127 << 21);
        long j130 = j119 - (j113 * 683901);
        long j131 = ((j116 - (j113 * 997805)) + (j128 * 136657)) - (j129 * 683901);
        long j132 = ((((j99 + (j113 * 470296)) + (j128 * 654183)) - (j129 * 997805)) + (j125 * 136657)) - (j126 * 683901);
        long j133 = j23 + (j122 * 666643);
        long j134 = j56 + (j125 * 666643) + (j126 * 470296) + (j122 * 654183);
        long j135 = ((((j59 + (j128 * 666643)) + (j129 * 470296)) + (j125 * 654183)) - (j126 * 997805)) + (j122 * 136657);
        long j136 = (j133 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j137 = j57 + (j126 * 666643) + (j122 * 470296) + j136;
        long j138 = j133 - (j136 << 21);
        long j139 = (j134 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j140 = ((((j60 + (j129 * 666643)) + (j125 * 470296)) + (j126 * 654183)) - (j122 * 997805)) + j139;
        long j141 = j134 - (j139 << 21);
        long j142 = (j135 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j143 = ((((((j63 + (j113 * 666643)) + (j128 * 470296)) + (j129 * 654183)) - (j125 * 997805)) + (j126 * 136657)) - (j122 * 683901)) + j142;
        long j144 = j135 - (j142 << 21);
        long j145 = (j132 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j146 = ((((j117 + (j113 * 654183)) - (j128 * 997805)) + (j129 * 136657)) - (j125 * 683901)) + j145;
        long j147 = j132 - (j145 << 21);
        long j148 = (j131 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j149 = ((j120 + (j113 * 136657)) - (j128 * 683901)) + j148;
        long j150 = j131 - (j148 << 21);
        long j151 = (j130 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j152 = j123 + j151;
        long j153 = j130 - (j151 << 21);
        long j154 = (j137 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j155 = j141 + j154;
        long j156 = j137 - (j154 << 21);
        long j157 = (j140 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j158 = j144 + j157;
        long j159 = j140 - (j157 << 21);
        long j160 = (j143 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j161 = j147 + j160;
        long j162 = j143 - (j160 << 21);
        long j163 = (j146 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j164 = j150 + j163;
        long j165 = j146 - (j163 << 21);
        long j166 = (j149 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j167 = (j152 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j168 = j152 - (j167 << 21);
        long j169 = j138 + (j167 * 666643);
        long j170 = j156 + (j167 * 470296);
        long j171 = j155 + (j167 * 654183);
        long j172 = j159 - (j167 * 997805);
        long j173 = j158 + (j167 * 136657);
        long j174 = j162 - (j167 * 683901);
        long j175 = j169 >> 21;
        long j176 = j170 + j175;
        long j177 = j169 - (j175 << 21);
        long j178 = j176 >> 21;
        long j179 = j171 + j178;
        long j180 = j176 - (j178 << 21);
        long j181 = j179 >> 21;
        long j182 = j172 + j181;
        long j183 = j179 - (j181 << 21);
        long j184 = j182 >> 21;
        long j185 = j173 + j184;
        long j186 = j182 - (j184 << 21);
        long j187 = j185 >> 21;
        long j188 = j174 + j187;
        long j189 = j185 - (j187 << 21);
        long j190 = j188 >> 21;
        long j191 = j161 + j190;
        long j192 = j188 - (j190 << 21);
        long j193 = j191 >> 21;
        long j194 = j165 + j193;
        long j195 = j191 - (j193 << 21);
        long j196 = j194 >> 21;
        long j197 = j164 + j196;
        long j198 = j194 - (j196 << 21);
        long j199 = j197 >> 21;
        long j200 = (j149 - (j166 << 21)) + j199;
        long j201 = j197 - (j199 << 21);
        long j202 = j200 >> 21;
        long j203 = j153 + j166 + j202;
        long j204 = j200 - (j202 << 21);
        long j205 = j203 >> 21;
        long j206 = j168 + j205;
        long j207 = j203 - (j205 << 21);
        long j208 = j206 >> 21;
        long j209 = j206 - (j208 << 21);
        long j210 = j177 + (666643 * j208);
        long j211 = j180 + (470296 * j208);
        long j212 = j183 + (654183 * j208);
        long j213 = j186 - (997805 * j208);
        long j214 = j189 + (136657 * j208);
        long j215 = j192 - (j208 * 683901);
        long j216 = j210 >> 21;
        long j217 = j211 + j216;
        long j218 = j217 >> 21;
        long j219 = j212 + j218;
        long j220 = j217 - (j218 << 21);
        long j221 = j219 >> 21;
        long j222 = j213 + j221;
        long j223 = j219 - (j221 << 21);
        long j224 = j222 >> 21;
        long j225 = j214 + j224;
        long j226 = j222 - (j224 << 21);
        long j227 = j225 >> 21;
        long j228 = j215 + j227;
        long j229 = j225 - (j227 << 21);
        long j230 = j228 >> 21;
        long j231 = j195 + j230;
        long j232 = j228 - (j230 << 21);
        long j233 = j231 >> 21;
        long j234 = j198 + j233;
        long j235 = j231 - (j233 << 21);
        long j236 = j234 >> 21;
        long j237 = j201 + j236;
        long j238 = j234 - (j236 << 21);
        long j239 = j237 >> 21;
        long j240 = j204 + j239;
        long j241 = j240 >> 21;
        long j242 = j207 + j241;
        long j243 = j240 - (j241 << 21);
        long j244 = j242 >> 21;
        long j245 = j209 + j244;
        long j246 = j242 - (j244 << 21);
        s[0] = (byte) (j210 - (j216 << 21));
        s[1] = (byte) (r0 >> 8);
        s[2] = (byte) ((r0 >> 16) | (j220 << 5));
        s[3] = (byte) (j220 >> 3);
        s[4] = (byte) (j220 >> 11);
        s[5] = (byte) ((j220 >> 19) | (j223 << 2));
        s[6] = (byte) (j223 >> 6);
        s[7] = (byte) ((j223 >> 14) | (j226 << 7));
        s[8] = (byte) (j226 >> 1);
        s[9] = (byte) (j226 >> 9);
        s[10] = (byte) ((j226 >> 17) | (j229 << 4));
        s[11] = (byte) (j229 >> 4);
        s[12] = (byte) (j229 >> 12);
        s[13] = (byte) ((j229 >> 20) | (j232 << 1));
        s[14] = (byte) (j232 >> 7);
        s[15] = (byte) ((j232 >> 15) | (j235 << 6));
        s[16] = (byte) (j235 >> 2);
        s[17] = (byte) (j235 >> 10);
        s[18] = (byte) ((j235 >> 18) | (j238 << 3));
        s[19] = (byte) (j238 >> 5);
        s[20] = (byte) (j238 >> 13);
        s[21] = (byte) (j237 - (j239 << 21));
        s[22] = (byte) (r4 >> 8);
        s[23] = (byte) ((r4 >> 16) | (j243 << 5));
        s[24] = (byte) (j243 >> 3);
        s[25] = (byte) (j243 >> 11);
        s[26] = (byte) ((j243 >> 19) | (j246 << 2));
        s[27] = (byte) (j246 >> 6);
        s[28] = (byte) ((j246 >> 14) | (j245 << 7));
        s[29] = (byte) (j245 >> 1);
        s[30] = (byte) (j245 >> 9);
        s[31] = (byte) (j245 >> 17);
    }

    static byte[] getHashedScalar(final byte[] privateKey) throws GeneralSecurityException {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(privateKey, 0, 32);
        byte[] bArrDigest = engineFactory.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        byte b = (byte) (bArrDigest[31] & Byte.MAX_VALUE);
        bArrDigest[31] = b;
        bArrDigest[31] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        return bArrDigest;
    }

    static byte[] sign(final byte[] message, final byte[] publicKey, final byte[] hashedPrivateKey) throws GeneralSecurityException {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(message, 0, message.length);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(hashedPrivateKey, 32, 32);
        engineFactory.update(bArrCopyOfRange);
        byte[] bArrDigest = engineFactory.digest();
        reduce(bArrDigest);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(bArrDigest).toBytes(), 0, 32);
        engineFactory.reset();
        engineFactory.update(bArrCopyOfRange2);
        engineFactory.update(publicKey);
        engineFactory.update(bArrCopyOfRange);
        byte[] bArrDigest2 = engineFactory.digest();
        reduce(bArrDigest2);
        byte[] bArr = new byte[32];
        mulAdd(bArr, bArrDigest2, hashedPrivateKey, bArrDigest);
        return Bytes.concat(bArrCopyOfRange2, bArr);
    }

    private static boolean isSmallerThanGroupOrder(byte[] s) {
        for (int i = 31; i >= 0; i--) {
            int i2 = s[i] & 255;
            int i3 = GROUP_ORDER[i] & 255;
            if (i2 != i3) {
                return i2 < i3;
            }
        }
        return false;
    }

    static boolean verify(final byte[] message, final byte[] signature, final byte[] publicKey) throws GeneralSecurityException {
        if (signature.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(signature, 32, 64);
        if (!isSmallerThanGroupOrder(bArrCopyOfRange)) {
            return false;
        }
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(signature, 0, 32);
        engineFactory.update(publicKey);
        engineFactory.update(message);
        byte[] bArrDigest = engineFactory.digest();
        reduce(bArrDigest);
        byte[] bytes = doubleScalarMultVarTime(bArrDigest, XYZT.fromBytesNegateVarTime(publicKey), bArrCopyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != signature[i]) {
                return false;
            }
        }
        return true;
    }
}
