package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbhn implements Runnable {
    final /* synthetic */ zzazn zza;
    final /* synthetic */ zzbhy zzb;

    zzbhn(zzbhy zzbhyVar, zzazn zzaznVar) {
        this.zza = zzaznVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzk(this.zza);
    }
}
