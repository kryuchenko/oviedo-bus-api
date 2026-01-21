package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes3.dex */
final class zzie implements Runnable {
    private final /* synthetic */ zzno zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzhn zzc;

    zzie(zzhn zzhnVar, zzno zznoVar, zzo zzoVar) {
        this.zza = zznoVar;
        this.zzb = zzoVar;
        this.zzc = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zza.zzr();
        if (this.zza.zza() == null) {
            this.zzc.zza.zza(this.zza.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
