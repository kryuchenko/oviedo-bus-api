package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzly implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzlw zzb;

    zzly(zzlw zzlwVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzkx.zza(this.zzb.zza, this.zza);
    }
}
