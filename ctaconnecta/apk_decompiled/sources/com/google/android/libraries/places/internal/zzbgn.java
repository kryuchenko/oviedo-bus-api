package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbgn implements Runnable {
    final /* synthetic */ zzayn zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzbgz zzc;

    zzbgn(zzbgz zzbgzVar, zzayn zzaynVar, zzbcf zzbcfVar) {
        this.zza = zzaynVar;
        this.zzb = zzbcfVar;
        this.zzc = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzh.zze(this.zza, this.zzb);
    }
}
