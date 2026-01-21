package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int parseInt(char[] cArr, int i, int i2) {
        int i3;
        char c;
        int i4 = cArr[i] - '0';
        if (i2 <= 4) {
            if (i2 > 1) {
            }
            return i4;
        }
        int i5 = i + 4;
        i4 = (((((((i4 * 10) + (cArr[i + 1] - '0')) * 10) + (cArr[i + 2] - '0')) * 10) + (cArr[i + 3] - '0')) * 10) + (cArr[i5] - '0');
        i2 -= 4;
        if (i2 <= 4) {
            i = i5;
            if (i2 > 1) {
                i4 = (i4 * 10) + (cArr[i + 1] - '0');
                if (i2 > 2) {
                    i4 = (i4 * 10) + (cArr[i + 2] - '0');
                    if (i2 > 3) {
                        i3 = i4 * 10;
                        c = cArr[i + 3];
                    }
                }
            }
            return i4;
        }
        i3 = ((((((i4 * 10) + (cArr[i + 5] - '0')) * 10) + (cArr[i + 6] - '0')) * 10) + (cArr[i + 7] - '0')) * 10;
        c = cArr[i + 8];
        return i3 + (c - '0');
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
    
        return java.lang.Integer.parseInt(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int parseInt(String str) {
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i = 1;
        boolean z = cCharAt == '-';
        if (z) {
            if (length == 1 || length > 10) {
                return Integer.parseInt(str);
            }
            cCharAt = str.charAt(1);
            i = 2;
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (cCharAt > '9' || cCharAt < '0') {
            return Integer.parseInt(str);
        }
        int i2 = cCharAt - '0';
        if (i < length) {
            int i3 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return Integer.parseInt(str);
            }
            i2 = (i2 * 10) + (cCharAt2 - '0');
            if (i3 < length) {
                int i4 = i + 2;
                char cCharAt3 = str.charAt(i3);
                if (cCharAt3 > '9' || cCharAt3 < '0') {
                    return Integer.parseInt(str);
                }
                i2 = (i2 * 10) + (cCharAt3 - '0');
                if (i4 < length) {
                    while (true) {
                        int i5 = i4 + 1;
                        char cCharAt4 = str.charAt(i4);
                        if (cCharAt4 > '9' || cCharAt4 < '0') {
                            break;
                        }
                        i2 = (i2 * 10) + (cCharAt4 - '0');
                        if (i5 >= length) {
                            break;
                        }
                        i4 = i5;
                    }
                }
            }
        }
        return z ? -i2 : i2;
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (parseInt(cArr, i, i3) * L_BILLION) + parseInt(cArr, i + i3, 9);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int iCharAt = cArr[i + i3] - str.charAt(i3);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static int parseAsInt(String str, int i) {
        String strTrim;
        int length;
        if (str != null && (length = (strTrim = str.trim()).length()) != 0) {
            int i2 = 0;
            if (length > 0) {
                char cCharAt = strTrim.charAt(0);
                if (cCharAt == '+') {
                    strTrim = strTrim.substring(1);
                    length = strTrim.length();
                } else if (cCharAt == '-') {
                    i2 = 1;
                }
            }
            while (i2 < length) {
                try {
                    char cCharAt2 = strTrim.charAt(i2);
                    if (cCharAt2 > '9' || cCharAt2 < '0') {
                        return (int) parseDouble(strTrim);
                    }
                    i2++;
                } catch (NumberFormatException unused) {
                }
            }
            return Integer.parseInt(strTrim);
        }
        return i;
    }

    public static long parseAsLong(String str, long j) {
        String strTrim;
        int length;
        if (str != null && (length = (strTrim = str.trim()).length()) != 0) {
            int i = 0;
            if (length > 0) {
                char cCharAt = strTrim.charAt(0);
                if (cCharAt == '+') {
                    strTrim = strTrim.substring(1);
                    length = strTrim.length();
                } else if (cCharAt == '-') {
                    i = 1;
                }
            }
            while (i < length) {
                try {
                    char cCharAt2 = strTrim.charAt(i);
                    if (cCharAt2 > '9' || cCharAt2 < '0') {
                        return (long) parseDouble(strTrim);
                    }
                    i++;
                } catch (NumberFormatException unused) {
                }
            }
            return Long.parseLong(strTrim);
        }
        return j;
    }

    public static double parseAsDouble(String str, double d) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() != 0) {
                try {
                    return parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return d;
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if (NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw _badBD(str);
        }
    }

    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return parseBigDecimal(cArr, 0, cArr.length);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i, i2);
        } catch (NumberFormatException unused) {
            throw _badBD(new String(cArr, i, i2));
        }
    }

    private static NumberFormatException _badBD(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }
}
