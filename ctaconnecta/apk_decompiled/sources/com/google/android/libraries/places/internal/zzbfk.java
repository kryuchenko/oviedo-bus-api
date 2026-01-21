package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbfk extends zzbgi {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzbfo zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbfk(zzbfo zzbfoVar, zzbvq zzbvqVar, zzbcf zzbcfVar) {
        super(zzbfoVar.zza.zzi);
        this.zza = zzbvqVar;
        this.zzb = zzbcfVar;
        this.zzc = zzbfoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbgi
    public final void zza() {
        int i = zzbvr.zza;
        zzbfo zzbfoVar = this.zzc;
        if (zzbfoVar.zzc != null) {
            return;
        }
        try {
            zzbfoVar.zzb.zzb(this.zzb);
        } catch (Throwable th) {
            zzbfo.zzc(this.zzc, zzbdo.zzb.zzf(th).zzg("Failed to read headers"));
        }
    }
}
