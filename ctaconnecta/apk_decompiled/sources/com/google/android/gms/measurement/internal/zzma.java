package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzma implements Runnable {
    private final /* synthetic */ zzlw zza;

    zzma(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzkx.zza(this.zza.zza, new ComponentName(this.zza.zza.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
