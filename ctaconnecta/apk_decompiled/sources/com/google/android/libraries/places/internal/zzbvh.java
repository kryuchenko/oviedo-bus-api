package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbvh extends zzbvc {
    final /* synthetic */ zzbvi zza;

    protected zzbvh(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbvc, com.google.android.libraries.places.internal.zzbbd
    public final void zze(zzaze zzazeVar, zzbbk zzbbkVar) {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar.zza.zzj.containsKey(zzbviVar.zzb)) {
            this.zza.zzf = zzazeVar;
            this.zza.zzg = zzbbkVar;
            if (this.zza.zzh || this.zza.zza.zzf) {
                return;
            }
            if (zzazeVar == zzaze.IDLE) {
                this.zza.zzd.zzg().zzd();
            }
            this.zza.zza.zzl();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbvc
    protected final zzbbd zzf() {
        return this.zza.zza.zzk;
    }
}
