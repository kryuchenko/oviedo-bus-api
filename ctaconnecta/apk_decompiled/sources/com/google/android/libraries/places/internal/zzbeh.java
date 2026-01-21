package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbeh implements Runnable {
    final /* synthetic */ zzbvq zza;
    final /* synthetic */ zzbei zzb;

    zzbeh(zzbei zzbeiVar, zzbvq zzbvqVar, int i) {
        this.zza = zzbvqVar;
        this.zzb = zzbeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = zzbvr.zza;
            this.zzb.zzr.zzc(2);
        } catch (Throwable th) {
            this.zzb.zzF(th);
        }
    }
}
