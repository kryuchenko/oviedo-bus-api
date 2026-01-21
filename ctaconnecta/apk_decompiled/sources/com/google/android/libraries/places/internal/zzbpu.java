package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbpu extends zzbcr {
    final /* synthetic */ zzbpv zza;
    private final zzbcr zzb;

    zzbpu(zzbpv zzbpvVar, zzbcr zzbcrVar) {
        this.zza = zzbpvVar;
        this.zzb = zzbcrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbcr
    public final void zza(zzbdo zzbdoVar) {
        this.zzb.zza(zzbdoVar);
        zzbdw zzbdwVar = this.zza.zzd;
        zzbdwVar.zzc(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbpt
            @Override // java.lang.Runnable
            public final void run() {
                zzbpv zzbpvVar = this.zza.zza;
                zzbpvVar.zzc.zzc(new zzbpr(zzbpvVar));
            }
        });
        zzbdwVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbcr
    public final void zzb(zzbct zzbctVar) {
        if (zzbctVar.zza().zzc(zzbpv.zza) != null) {
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
        zzbcr zzbcrVar = this.zzb;
        zzbcs zzbcsVarZzd = zzbctVar.zzd();
        zzayb zzaybVarZzb = zzbctVar.zza().zzb();
        zzaybVarZzb.zzb(zzbpv.zza, new zzbps(this.zza));
        zzbcsVarZzd.zzb(zzaybVarZzb.zzc());
        zzblj zzbljVar = (zzblj) zzbcrVar;
        zzbli zzbliVar = new zzbli(zzbljVar, zzbcsVarZzd.zzd());
        zzbdw zzbdwVar = zzbljVar.zzc.zzf;
        zzbdwVar.zzc(zzbliVar);
        zzbdwVar.zzb();
    }
}
