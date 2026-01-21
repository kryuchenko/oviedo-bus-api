package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbni {
    private final zzbbj zza;
    private zzaze zzb;
    private final zzbnc zzc;
    private boolean zzd = false;

    public zzbni(zzbbj zzbbjVar, zzaze zzazeVar, zzbnc zzbncVar) {
        this.zza = zzbbjVar;
        this.zzb = zzazeVar;
        this.zzc = zzbncVar;
    }

    static /* bridge */ /* synthetic */ zzaze zzb(zzbni zzbniVar) {
        return zzbniVar.zzc.zzb.zza();
    }

    static /* bridge */ /* synthetic */ void zzg(zzbni zzbniVar, zzaze zzazeVar) {
        boolean z;
        zzbniVar.zzb = zzazeVar;
        if (zzazeVar == zzaze.READY || zzazeVar == zzaze.TRANSIENT_FAILURE) {
            z = true;
        } else if (zzazeVar != zzaze.IDLE) {
            return;
        } else {
            z = false;
        }
        zzbniVar.zzd = z;
    }

    public final zzaze zzc() {
        return this.zzb;
    }

    public final zzbbj zze() {
        return this.zza;
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
