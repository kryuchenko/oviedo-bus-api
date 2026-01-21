package com.google.android.libraries.places.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbvv {
    private static final zzbwa zza = new zzbwa();

    public static final String zza(int i) {
        int i2 = 0;
        char[] cArr = {zzbwy.zza()[i >> 28], zzbwy.zza()[(i >> 24) & 15], zzbwy.zza()[(i >> 20) & 15], zzbwy.zza()[(i >> 16) & 15], zzbwy.zza()[(i >> 12) & 15], zzbwy.zza()[(i >> 8) & 15], zzbwy.zza()[(i >> 4) & 15], zzbwy.zza()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return StringsKt.concatToString(cArr, i2, 8);
    }

    public static final void zzb(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final boolean zzc(byte[] a, int i, byte[] b, int i2, int i3) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (a[i4 + i] != b[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
