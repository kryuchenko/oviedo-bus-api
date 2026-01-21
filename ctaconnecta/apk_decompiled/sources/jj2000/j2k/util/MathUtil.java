package jj2000.j2k.util;

/* loaded from: classes5.dex */
public class MathUtil {
    public static int log2(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("" + i + " <= 0");
        }
        int i2 = -1;
        while (i > 0) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    public static final int lcm(int i, int i2) {
        int i3;
        int i4;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Cannot compute the least common multiple of two numbers if one, at least,is negative.");
        }
        if (i > i2) {
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        for (int i5 = 1; i5 <= i3; i5++) {
            int i6 = i4 * i5;
            if (i6 % i3 == 0) {
                return i6;
            }
        }
        throw new Error("Cannot find the least common multiple of numbers " + i + " and " + i2);
    }

    public static final int lcm(int[] iArr) {
        if (iArr.length < 2) {
            throw new Error("Do not use this method if there are less than two numbers.");
        }
        int iLcm = lcm(iArr[iArr.length - 1], iArr[iArr.length - 2]);
        for (int length = iArr.length - 3; length >= 0; length--) {
            int i = iArr[length];
            if (i <= 0) {
                throw new IllegalArgumentException("Cannot compute the least common multiple of several numbers where one, at least,is negative.");
            }
            iLcm = lcm(iLcm, i);
        }
        return iLcm;
    }

    public static final int gcd(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Cannot compute the GCD if one integer is negative.");
        }
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        if (i == 0) {
            return 0;
        }
        while (i != 0) {
            int i3 = i2 % i;
            i2 = i;
            i = i3;
        }
        return i2;
    }

    public static final int gcd(int[] iArr) {
        if (iArr.length < 2) {
            throw new Error("Do not use this method if there are less than two numbers.");
        }
        int iGcd = gcd(iArr[iArr.length - 1], iArr[iArr.length - 2]);
        for (int length = iArr.length - 3; length >= 0; length--) {
            int i = iArr[length];
            if (i < 0) {
                throw new IllegalArgumentException("Cannot compute the least common multiple of several numbers where one, at least,is negative.");
            }
            iGcd = gcd(iGcd, i);
        }
        return iGcd;
    }
}
