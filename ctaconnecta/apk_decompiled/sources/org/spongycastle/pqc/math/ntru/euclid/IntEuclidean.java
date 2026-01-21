package org.spongycastle.pqc.math.ntru.euclid;

/* loaded from: classes6.dex */
public class IntEuclidean {
    public int gcd;
    public int x;
    public int y;

    private IntEuclidean() {
    }

    public static IntEuclidean calculate(int i, int i2) {
        int i3 = 0;
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        while (i5 != 0) {
            int i9 = i4 / i5;
            int i10 = i4 % i5;
            int i11 = i8 - (i9 * i6);
            i4 = i5;
            i5 = i10;
            int i12 = i7;
            i7 = i3 - (i9 * i7);
            i3 = i12;
            i8 = i6;
            i6 = i11;
        }
        IntEuclidean intEuclidean = new IntEuclidean();
        intEuclidean.x = i8;
        intEuclidean.y = i3;
        intEuclidean.gcd = i4;
        return intEuclidean;
    }
}
