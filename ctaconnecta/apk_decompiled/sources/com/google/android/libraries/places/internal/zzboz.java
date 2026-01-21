package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzboz implements Runnable {
    final /* synthetic */ zzbpm zza;
    final /* synthetic */ zzbpa zzb;

    zzboz(zzbpa zzbpaVar, zzbpm zzbpmVar) {
        this.zza = zzbpmVar;
        this.zzb = zzbpaVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[Catch: all -> 0x00b9, TryCatch #0 {, blocks: (B:4:0x0009, B:16:0x006e, B:7:0x0014, B:9:0x0032, B:11:0x003c, B:13:0x0046, B:14:0x0057), top: B:27:0x0009 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        zzboy zzboyVar;
        boolean z;
        synchronized (this.zzb.zzb.zzm) {
            zzbpa zzbpaVar = this.zzb;
            zzboyVar = null;
            if (!zzbpaVar.zza.zzc) {
                zzbpo zzbpoVar = zzbpaVar.zzb;
                zzbpoVar.zzs = zzbpoVar.zzs.zza(this.zza);
                zzbpo zzbpoVar2 = this.zzb.zzb;
                if (zzbpoVar2.zzal(zzbpoVar2.zzs)) {
                    zzbpo zzbpoVar3 = this.zzb.zzb;
                    if (zzbpoVar3.zzq == null || zzbpoVar3.zzq.zza()) {
                        zzbpo zzbpoVar4 = this.zzb.zzb;
                        zzboyVar = new zzboy(zzbpoVar4.zzm);
                        zzbpoVar4.zzA = zzboyVar;
                    } else {
                        zzbpo zzbpoVar5 = this.zzb.zzb;
                        zzbpoVar5.zzs = zzbpoVar5.zzs.zzb();
                        this.zzb.zzb.zzA = null;
                    }
                    z = false;
                }
            }
            z = true;
        }
        if (z) {
            zzbpm zzbpmVar = this.zza;
            zzbpmVar.zza.zzo(new zzbpl(this.zzb.zzb, zzbpmVar));
            this.zza.zza.zzh(zzbdo.zzb.zzg("Unneeded hedging"));
            return;
        }
        if (zzboyVar != null) {
            zzbpo zzbpoVar6 = this.zzb.zzb;
            zzboyVar.zzb(zzbpoVar6.zzf.schedule(new zzbpa(zzbpoVar6, zzboyVar), zzbpoVar6.zzk.zzb, TimeUnit.NANOSECONDS));
        }
        zzbpa zzbpaVar2 = this.zzb;
        zzbpaVar2.zzb.zzai(this.zza);
    }
}
