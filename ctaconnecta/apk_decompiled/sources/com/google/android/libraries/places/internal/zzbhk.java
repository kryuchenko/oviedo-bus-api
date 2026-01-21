package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbhk implements Runnable {
    final /* synthetic */ zzazq zza;
    final /* synthetic */ zzbhy zzb;

    zzbhk(zzbhy zzbhyVar, zzazq zzazqVar) {
        this.zza = zzazqVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzl(this.zza);
    }
}
