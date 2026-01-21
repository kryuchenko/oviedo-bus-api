package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzays extends zzayk {
    private final zzayk zza;
    private final zzayp zzb;

    /* synthetic */ zzays(zzayk zzaykVar, zzayp zzaypVar, zzayr zzayrVar) {
        this.zza = zzaykVar;
        zzmt.zzc(zzaypVar, "interceptor");
        this.zzb = zzaypVar;
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final zzayo zza(zzbcl zzbclVar, zzayj zzayjVar) {
        return this.zzb.zza(zzbclVar, zzayjVar, this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzayk
    public final String zzb() {
        return this.zza.zzb();
    }
}
