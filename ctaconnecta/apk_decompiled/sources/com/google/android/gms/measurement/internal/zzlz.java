package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzlz implements Runnable {
    private final /* synthetic */ zzlw zza;

    zzlz(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zza.zza.zzb = null;
        this.zza.zza.zzap();
    }
}
