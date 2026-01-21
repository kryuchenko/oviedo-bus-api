package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzji implements Executor {
    private final /* synthetic */ zziv zza;

    zzji(zziv zzivVar) {
        this.zza = zzivVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) throws IllegalStateException {
        this.zza.zzl().zzb(runnable);
    }
}
