package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbph implements Runnable {
    final /* synthetic */ zzbpl zza;

    zzbph(zzbpl zzbplVar) {
        this.zza = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zzD = true;
        zzbpo zzbpoVar = this.zza.zzb;
        zzbpoVar.zzy.zzd(zzbpoVar.zzw.zza, this.zza.zzb.zzw.zzb, this.zza.zzb.zzw.zzc);
    }
}
