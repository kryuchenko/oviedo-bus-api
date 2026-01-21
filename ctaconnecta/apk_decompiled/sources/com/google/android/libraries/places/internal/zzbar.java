package com.google.android.libraries.places.internal;

import java.nio.charset.Charset;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbar {
    public static final Charset zza = Charset.forName("US-ASCII");
    public static final zzsi zzb = zzbcf.zzc;

    public static int zza(zzbcf zzbcfVar) {
        return zzbcfVar.zza();
    }

    public static zzbca zzb(String str, zzbaq zzbaqVar) {
        boolean z = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return new zzbcd(str, z, zzbaqVar, null);
    }

    public static zzbcf zzc(byte[]... bArr) {
        return new zzbcf(bArr.length >> 1, bArr);
    }

    public static byte[][] zzd(zzbcf zzbcfVar) {
        return zzbcfVar.zzg();
    }
}
