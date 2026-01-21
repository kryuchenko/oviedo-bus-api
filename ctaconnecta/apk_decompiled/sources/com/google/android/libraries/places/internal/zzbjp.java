package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbjp implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbkd zzb;

    zzbjp(zzbkd zzbkdVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbkdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzv.zza() == zzaze.SHUTDOWN) {
            return;
        }
        this.zzb.zzw = this.zza;
        zzbkd zzbkdVar = this.zzb;
        zzbml zzbmlVar = zzbkdVar.zzu;
        zzbgf zzbgfVar = zzbkdVar.zzt;
        zzbkdVar.zzu = null;
        this.zzb.zzt = null;
        zzbkd.zzA(this.zzb, zzaze.SHUTDOWN);
        this.zzb.zzl.zzd();
        if (this.zzb.zzr.isEmpty()) {
            zzbkd.zzB(this.zzb);
        }
        zzbkd.zzz(this.zzb);
        zzbkd zzbkdVar2 = this.zzb;
        if (zzbkdVar2.zzp != null) {
            zzbkdVar2.zzp.zza();
            zzbkd zzbkdVar3 = this.zzb;
            zzbkdVar3.zzq.zzd(this.zza);
            this.zzb.zzp = null;
            this.zzb.zzq = null;
        }
        if (zzbmlVar != null) {
            zzbmlVar.zzd(this.zza);
        }
        if (zzbgfVar != null) {
            zzbgfVar.zzd(this.zza);
        }
    }
}
