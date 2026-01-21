package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes3.dex */
final class zzgf implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgg zzb;

    zzgf(zzgg zzggVar, boolean z) {
        this.zza = z;
        this.zzb = zzggVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza.zza(this.zza);
    }
}
