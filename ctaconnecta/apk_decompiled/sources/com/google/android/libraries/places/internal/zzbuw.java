package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbuw extends zzbuu {
    private final zzbus zza;
    private Object zzb;
    private boolean zzc;

    zzbuw(zzbus zzbusVar) {
        super(null);
        this.zzc = false;
        this.zza = zzbusVar;
    }

    @Override // com.google.android.libraries.places.internal.zzayn
    public final void zza(zzbdo zzbdoVar, zzbcf zzbcfVar) {
        if (!zzbdoVar.zzl()) {
            this.zza.zzm(new zzbdq(zzbdoVar, zzbcfVar));
            return;
        }
        if (!this.zzc) {
            this.zza.zzm(new zzbdq(zzbdo.zzo.zzg("No value received for unary call"), zzbcfVar));
        }
        this.zza.zzl(this.zzb);
    }

    @Override // com.google.android.libraries.places.internal.zzayn
    public final void zzb(zzbcf zzbcfVar) {
    }

    @Override // com.google.android.libraries.places.internal.zzayn
    public final void zzc(Object obj) {
        if (this.zzc) {
            throw new zzbdq(zzbdo.zzo.zzg("More than one value received for unary call"), null);
        }
        this.zzb = obj;
        this.zzc = true;
    }

    @Override // com.google.android.libraries.places.internal.zzbuu
    final void zze() {
        this.zza.zzc.zzc(2);
    }
}
