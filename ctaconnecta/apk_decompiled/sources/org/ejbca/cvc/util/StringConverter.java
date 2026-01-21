package org.ejbca.cvc.util;

import jj2000.j2k.codestream.reader.BitstreamReaderAgent;
import jj2000.j2k.entropy.encoder.PostCompRateAllocator;
import jj2000.j2k.wavelet.analysis.AnWTFilter;

/* loaded from: classes6.dex */
public final class StringConverter {
    private static final char[] HEXCHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', PostCompRateAllocator.OPT_PREFIX, BitstreamReaderAgent.OPT_PREFIX, 'C', 'D', 'E', AnWTFilter.OPT_PREFIX};
    private static final String HEXINDEX = "0123456789abcdef          ABCDEF";

    private StringConverter() {
    }

    public static byte[] hexToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            int iIndexOf = (HEXINDEX.indexOf(str.charAt(i)) & 15) << 4;
            i += 2;
            bArr[i2] = (byte) (iIndexOf + (HEXINDEX.indexOf(str.charAt(i3)) & 15));
        }
        return bArr;
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, null);
    }

    public static String byteToHex(byte[] bArr, String str) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(byteToHex(bArr[i]));
            if (str != null && i + 1 < length) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    public static String byteToHex(byte b) {
        char[] cArr = HEXCHAR;
        char c = cArr[((b & 255) >> 4) & 15];
        return Character.toString(c) + cArr[b & 15];
    }
}
