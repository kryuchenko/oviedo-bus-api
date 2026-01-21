package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzjw implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zziv zzb;

    zzjw(zziv zzivVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzivVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziv.zza(this.zzb, this.zza);
    }
}
