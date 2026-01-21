package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzke implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zziv zzb;

    zzke(zziv zzivVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zzivVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza(this.zza, true);
    }
}
