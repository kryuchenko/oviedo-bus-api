package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbfn extends zzbgi {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbfo zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbfn(zzbfo zzbfoVar, zzbvq zzbvqVar) {
        super(zzbfoVar.zza.zzi);
        this.zza = zzbvqVar;
        this.zzb = zzbfoVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbgi
    public final void zza() {
        int i = zzbvr.zza;
        zzbfo zzbfoVar = this.zzb;
        if (zzbfoVar.zzc != null) {
            return;
        }
        try {
            zzbfoVar.zzb.zzd();
        } catch (Throwable th) {
            zzbfo.zzc(this.zzb, zzbdo.zzb.zzf(th).zzg("Failed to call onReady."));
        }
    }
}
