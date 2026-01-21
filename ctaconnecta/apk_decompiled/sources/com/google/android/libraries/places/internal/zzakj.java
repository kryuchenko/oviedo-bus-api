package com.google.android.libraries.places.internal;

import okio.Utf8;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzakj {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String zza(String str, int i) {
        int length;
        int length2 = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (i2 != length2) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt <= '~') {
                if (cCharAt < ' ') {
                    if (cCharAt >= 55296) {
                        if (cCharAt <= 57343) {
                            int iCodePointAt = Character.codePointAt(str, i2);
                            if (iCodePointAt >= 65536 && (iCodePointAt & 65534) != 65534) {
                                i2 += 2;
                            }
                        } else if (cCharAt >= 64976 && (cCharAt <= 65007 || cCharAt >= 65534)) {
                        }
                        length = str.length();
                        StringBuilder sb = new StringBuilder(length);
                        while (iCharCount < length) {
                        }
                        return sb.toString();
                    }
                    if (cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t' && cCharAt != '\f') {
                        length = str.length();
                        StringBuilder sb2 = new StringBuilder(length);
                        while (iCharCount < length) {
                            char cCharAt2 = str.charAt(iCharCount);
                            if (zzb(cCharAt2)) {
                                sb2.append(cCharAt2);
                                iCharCount++;
                            } else {
                                int iCodePointAt2 = Character.codePointAt(str, iCharCount);
                                sb2.appendCodePoint(true != zzb(iCodePointAt2) ? Utf8.REPLACEMENT_CODE_POINT : iCodePointAt2);
                                iCharCount += Character.charCount(iCodePointAt2);
                            }
                        }
                        return sb2.toString();
                    }
                }
                i2 = i3;
            } else {
                if (cCharAt >= 55296 || cCharAt < 160) {
                }
                i2 = i3;
            }
        }
        return str;
    }

    public static boolean zzb(int i) {
        return i <= 126 ? i >= 32 || i == 10 || i == 13 || i == 9 || i == 12 : i < 55296 ? i >= 160 : i < 64976 ? i > 57343 : i > 65007 && (i & 65534) != 65534 && i <= 1114111;
    }
}
