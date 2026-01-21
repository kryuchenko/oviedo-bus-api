package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbou implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbfs zzb;
    final /* synthetic */ zzbcf zzc;
    final /* synthetic */ zzbpo zzd;

    zzbou(zzbpo zzbpoVar, zzbdo zzbdoVar, zzbfs zzbfsVar, zzbcf zzbcfVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbfsVar;
        this.zzc = zzbcfVar;
        this.zzd = zzbpoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzD = true;
        this.zzd.zzy.zzd(this.zza, this.zzb, this.zzc);
    }
}
