package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbrm {
    public static final zzbtt zza;
    public static final zzbtt zzb;
    public static final zzbtt zzc;
    public static final zzbtt zzd;
    public static final zzbtt zze;
    public static final zzbtt zzf;

    static {
        zzbwf zzbwfVar = zzbtt.zzd;
        zzbwe zzbweVar = zzbwf.zza;
        zza = new zzbtt(zzbwfVar, zzbwe.zza("https"));
        zzb = new zzbtt(zzbtt.zzd, zzbwe.zza("http"));
        zzc = new zzbtt(zzbtt.zzb, zzbwe.zza("POST"));
        zzd = new zzbtt(zzbtt.zzb, zzbwe.zza("GET"));
        zze = new zzbtt(zzbjd.zzh.zzd(), "application/grpc");
        zzf = new zzbtt("te", "trailers");
    }
}
