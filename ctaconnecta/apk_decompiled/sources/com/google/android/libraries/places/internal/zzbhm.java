package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbhm implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbhy zzb;

    zzbhm(zzbhy zzbhyVar, int i) {
        this.zza = i;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzn(this.zza);
    }
}
