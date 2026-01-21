package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzmk implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzmh zzb;

    zzmk(zzmh zzmhVar, long j) {
        this.zza = j;
        this.zzb = zzmhVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzmh.zzb(this.zzb, this.zza);
    }
}
