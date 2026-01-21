package org.bouncycastle.math.raw;

/* loaded from: classes6.dex */
public abstract class Mont256 {
    private static final long M = 4294967295L;

    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    public static void multAdd(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        char c = 0;
        long j = 4294967295L;
        long j2 = iArr2[0] & 4294967295L;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            long j3 = iArr[i2] & j;
            long j4 = j3 * j2;
            long j5 = (j4 & j) + (iArr3[c] & j);
            long j6 = j;
            long j7 = (((int) j5) * i) & j6;
            long j8 = (iArr4[0] & j6) * j7;
            long j9 = ((j5 + (j8 & j6)) >>> 32) + (j4 >>> 32) + (j8 >>> 32);
            int i4 = 1;
            while (i4 < 8) {
                long j10 = (iArr2[i4] & j6) * j3;
                long j11 = (iArr4[i4] & j6) * j7;
                long j12 = j9 + (j10 & j6) + (j11 & j6) + (iArr3[i4] & j6);
                iArr3[i4 - 1] = (int) j12;
                j9 = (j12 >>> 32) + (j10 >>> 32) + (j11 >>> 32);
                i4++;
                j2 = j2;
                j7 = j7;
            }
            long j13 = j9 + (i3 & j6);
            iArr3[7] = (int) j13;
            i3 = (int) (j13 >>> 32);
            i2++;
            j = j6;
            j2 = j2;
            c = 0;
        }
        if (i3 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void multAddXF(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        char c = 0;
        long j = 4294967295L;
        long j2 = iArr2[0] & 4294967295L;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= 8) {
                break;
            }
            long j3 = iArr[i] & j;
            long j4 = (j3 * j2) + (iArr3[c] & j);
            long j5 = j4 & j;
            long j6 = (j4 >>> 32) + j5;
            int i3 = 1;
            for (int i4 = 8; i3 < i4; i4 = 8) {
                long j7 = j;
                long j8 = (iArr2[i3] & j7) * j3;
                int i5 = i3;
                long j9 = (iArr4[i3] & j7) * j5;
                long j10 = j6 + (j8 & j7) + (j9 & j7) + (iArr3[i5] & j7);
                iArr3[i5 - 1] = (int) j10;
                j6 = (j10 >>> 32) + (j8 >>> 32) + (j9 >>> 32);
                i3 = i5 + 1;
                j = j7;
                j2 = j2;
            }
            long j11 = j6 + (i2 & j);
            iArr3[7] = (int) j11;
            i2 = (int) (j11 >>> 32);
            i++;
            j2 = j2;
            c = 0;
        }
        if (i2 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2, int i) {
        char c = 0;
        int i2 = 0;
        while (i2 < 8) {
            long j = (r5 * i) & 4294967295L;
            long j2 = (((iArr2[c] & 4294967295L) * j) + (iArr[c] & 4294967295L)) >>> 32;
            int i3 = 1;
            while (i3 < 8) {
                long j3 = j2 + ((iArr2[i3] & 4294967295L) * j) + (iArr[i3] & 4294967295L);
                iArr[i3 - 1] = (int) j3;
                j2 = j3 >>> 32;
                i3++;
                i2 = i2;
            }
            iArr[7] = (int) j2;
            i2++;
            c = 0;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }

    public static void reduceXF(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 8; i++) {
            long j = iArr[0] & 4294967295L;
            long j2 = j;
            for (int i2 = 1; i2 < 8; i2++) {
                long j3 = j2 + ((iArr2[i2] & 4294967295L) * j) + (iArr[i2] & 4294967295L);
                iArr[i2 - 1] = (int) j3;
                j2 = j3 >>> 32;
            }
            iArr[7] = (int) j2;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }
}
