package com.google.android.libraries.places.internal;

import okhttp3.internal.http2.Header;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbtt {
    public static final zzbwf zza;
    public static final zzbwf zzb;
    public static final zzbwf zzc;
    public static final zzbwf zzd;
    public static final zzbwf zze;
    public static final zzbwf zzf;
    public static final zzbwf zzg;
    public final zzbwf zzh;
    public final zzbwf zzi;
    final int zzj;

    static {
        zzbwe zzbweVar = zzbwf.zza;
        zza = zzbwe.zza(Header.RESPONSE_STATUS_UTF8);
        zzb = zzbwe.zza(Header.TARGET_METHOD_UTF8);
        zzc = zzbwe.zza(Header.TARGET_PATH_UTF8);
        zzd = zzbwe.zza(Header.TARGET_SCHEME_UTF8);
        zze = zzbwe.zza(Header.TARGET_AUTHORITY_UTF8);
        zzf = zzbwe.zza(":host");
        zzg = zzbwe.zza(":version");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzbtt(String str, String str2) {
        this(zzbwe.zza(str), zzbwe.zza(str2));
        zzbwe zzbweVar = zzbwf.zza;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbtt) {
            zzbtt zzbttVar = (zzbtt) obj;
            if (this.zzh.equals(zzbttVar.zzh) && this.zzi.equals(zzbttVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzh.hashCode() + 527) * 31) + this.zzi.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", this.zzh.zzf(), this.zzi.zzf());
    }

    public zzbtt(zzbwf zzbwfVar, zzbwf zzbwfVar2) {
        this.zzh = zzbwfVar;
        this.zzi = zzbwfVar2;
        this.zzj = zzbwfVar.zzc() + 32 + zzbwfVar2.zzc();
    }
}
