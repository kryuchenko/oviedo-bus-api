package com.google.android.libraries.places.internal;

import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbvu {
    private static final byte[] zza;
    private static final byte[] zzb;

    static {
        zzbwe zzbweVar = zzbwf.zza;
        zza = zzbwe.zza("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").zzn();
        zzb = zzbwe.zza("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").zzn();
    }

    public static /* synthetic */ String zza(byte[] bArr, byte[] bArr2, int i, Object obj) {
        byte[] map = zza;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        int length = bArr.length;
        int i2 = length + 2;
        int i3 = length - (length % 3);
        byte[] bArr3 = new byte[(i2 / 3) * 4];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 3;
            byte b = bArr[i4];
            int i7 = i4 + 2;
            byte b2 = bArr[i4 + 1];
            i4 += 3;
            byte b3 = bArr[i7];
            bArr3[i5] = map[(b & 255) >> 2];
            bArr3[i5 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            bArr3[i5 + 2] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i5 += 4;
            bArr3[i6] = map[b3 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - i3;
        if (length2 == 1) {
            byte b4 = bArr[i4];
            bArr3[i5] = map[(b4 & 255) >> 2];
            bArr3[i5 + 1] = map[(b4 & 3) << 4];
            bArr3[i5 + 2] = Base64.padSymbol;
            bArr3[i5 + 3] = Base64.padSymbol;
        } else if (length2 == 2) {
            int i8 = i4 + 1;
            byte b5 = bArr[i4];
            byte b6 = bArr[i8];
            bArr3[i5] = map[(b5 & 255) >> 2];
            bArr3[i5 + 1] = map[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            bArr3[i5 + 2] = map[(b6 & 15) << 2];
            bArr3[i5 + 3] = Base64.padSymbol;
        }
        return zzbww.zza(bArr3);
    }
}
