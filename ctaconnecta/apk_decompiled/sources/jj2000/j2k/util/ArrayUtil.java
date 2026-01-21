package jj2000.j2k.util;

/* loaded from: classes5.dex */
public class ArrayUtil {
    public static final int INIT_EL_COPYING = 4;
    public static final int MAX_EL_COPYING = 8;

    public static void intArraySet(int[] iArr, int i) {
        int length = iArr.length;
        if (length < 8) {
            for (int i2 = length - 1; i2 >= 0; i2--) {
                iArr[i2] = i;
            }
            return;
        }
        int i3 = length >> 1;
        int i4 = 0;
        while (i4 < 4) {
            iArr[i4] = i;
            i4++;
        }
        while (i4 <= i3) {
            System.arraycopy(iArr, 0, iArr, i4, i4);
            i4 <<= 1;
        }
        if (i4 < length) {
            System.arraycopy(iArr, 0, iArr, i4, length - i4);
        }
    }

    public static void byteArraySet(byte[] bArr, byte b) {
        int length = bArr.length;
        if (length < 8) {
            for (int i = length - 1; i >= 0; i--) {
                bArr[i] = b;
            }
            return;
        }
        int i2 = length >> 1;
        int i3 = 0;
        while (i3 < 4) {
            bArr[i3] = b;
            i3++;
        }
        while (i3 <= i2) {
            System.arraycopy(bArr, 0, bArr, i3, i3);
            i3 <<= 1;
        }
        if (i3 < length) {
            System.arraycopy(bArr, 0, bArr, i3, length - i3);
        }
    }
}
