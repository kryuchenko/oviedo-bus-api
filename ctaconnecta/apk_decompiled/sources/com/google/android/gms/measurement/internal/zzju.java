package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzju implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zziv zzb;

    zzju(zziv zzivVar, long j) {
        this.zza = j;
        this.zzb = zzivVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzb(this.zza);
        this.zzb.zzo().zza(new AtomicReference<>());
    }
}
