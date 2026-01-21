package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbod implements Runnable {
    final /* synthetic */ zzboe zza;

    /* synthetic */ zzbod(zzboe zzboeVar, zzboc zzbocVar) {
        this.zza = zzboeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzboe zzboeVar = this.zza;
        zzbdw zzbdwVar = (zzbdw) zzboeVar.zzb;
        zzbdwVar.zzc(new zzbob(zzboeVar, null));
        zzbdwVar.zzb();
    }
}
