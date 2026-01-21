package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzll extends zzat {
    private final /* synthetic */ zzkx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzll(zzkx zzkxVar, zzil zzilVar) {
        super(zzilVar);
        this.zza = zzkxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzat
    public final void zzb() throws IllegalStateException {
        this.zza.zzj().zzu().zza("Tasks have been queued for a long time");
    }
}
