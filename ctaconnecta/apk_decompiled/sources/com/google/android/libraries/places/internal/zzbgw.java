package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbgw implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbcf zzb;
    final /* synthetic */ zzbgy zzc;

    zzbgw(zzbgy zzbgyVar, zzbdo zzbdoVar, zzbcf zzbcfVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbcfVar;
        this.zzc = zzbgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
