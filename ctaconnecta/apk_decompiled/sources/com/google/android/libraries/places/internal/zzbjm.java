package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbjm implements Runnable {
    final /* synthetic */ zzbkd zza;

    zzbjm(zzbkd zzbkdVar) {
        this.zza = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zzv.zza() == zzaze.IDLE) {
            this.zza.zzi.zza(2, "CONNECTING as requested");
            zzbkd.zzA(this.zza, zzaze.CONNECTING);
            zzbkd.zzE(this.zza);
        }
    }
}
