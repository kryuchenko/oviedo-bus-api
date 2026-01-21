package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzble implements Runnable {
    final /* synthetic */ zzbbk zza;
    final /* synthetic */ zzaze zzb;
    final /* synthetic */ zzblg zzc;

    zzble(zzblg zzblgVar, zzbbk zzbbkVar, zzaze zzazeVar) {
        this.zza = zzbbkVar;
        this.zzb = zzazeVar;
        this.zzc = zzblgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzblg zzblgVar = this.zzc;
        zzbma zzbmaVar = zzblgVar.zzb;
        if (zzblgVar != zzbmaVar.zzG) {
            return;
        }
        zzbmaVar.zzai(this.zza);
        if (this.zzb != zzaze.SHUTDOWN) {
            this.zzc.zzb.zzW.zzb(2, "Entering {0} state with picker: {1}", this.zzb, this.zza);
            this.zzc.zzb.zzB.zza(this.zzb);
        }
    }
}
