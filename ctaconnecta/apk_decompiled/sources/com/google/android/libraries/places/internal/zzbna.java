package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbna implements Runnable {
    final /* synthetic */ zzbnj zza;

    zzbna(zzbnj zzbnjVar) {
        this.zza = zzbnjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzl = null;
        if (this.zza.zzi.zzf()) {
            this.zza.zzd();
        }
    }
}
