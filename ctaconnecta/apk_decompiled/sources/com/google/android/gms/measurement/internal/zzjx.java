package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzjx implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdg zza;
    private final /* synthetic */ zziv zzb;

    zzjx(zziv zzivVar, com.google.android.gms.internal.measurement.zzdg zzdgVar) {
        this.zza = zzdgVar;
        this.zzb = zzivVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws IllegalStateException {
        Long lValueOf;
        zzmh zzmhVarZzp = this.zzb.zzp();
        if (zzmhVarZzp.zzk().zzn().zzj()) {
            if (!zzmhVarZzp.zzk().zza(zzmhVarZzp.zzb().currentTimeMillis()) && zzmhVarZzp.zzk().zzl.zza() != 0) {
                lValueOf = Long.valueOf(zzmhVarZzp.zzk().zzl.zza());
            }
            if (lValueOf == null) {
                this.zzb.zzu.zzt().zza(this.zza, lValueOf.longValue());
                return;
            }
            try {
                this.zza.zza(null);
                return;
            } catch (RemoteException e) {
                this.zzb.zzu.zzj().zzg().zza("getSessionId failed with exception", e);
                return;
            }
        }
        zzmhVarZzp.zzj().zzv().zza("Analytics storage consent denied; will not get session id");
        lValueOf = null;
        if (lValueOf == null) {
        }
    }
}
