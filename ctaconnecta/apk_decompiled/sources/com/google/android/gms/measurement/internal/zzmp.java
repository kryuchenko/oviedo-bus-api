package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzmp {
    final /* synthetic */ zzmh zza;

    zzmp(zzmh zzmhVar) {
        this.zza = zzmhVar;
    }

    final void zza() {
        this.zza.zzt();
        if (this.zza.zzk().zza(this.zza.zzb().currentTimeMillis())) {
            this.zza.zzk().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzj().zzp().zza("Detected application was in foreground");
                zzb(this.zza.zzb().currentTimeMillis(), false);
            }
        }
    }

    final void zza(long j, boolean z) {
        this.zza.zzt();
        this.zza.zzab();
        if (this.zza.zzk().zza(j)) {
            this.zza.zzk().zzg.zza(true);
            this.zza.zzg().zzag();
        }
        this.zza.zzk().zzk.zza(j);
        if (this.zza.zzk().zzg.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.zza.zzt();
        if (this.zza.zzu.zzac()) {
            this.zza.zzk().zzk.zza(j);
            this.zza.zzj().zzp().zza("Session started, time", Long.valueOf(this.zza.zzb().elapsedRealtime()));
            long j2 = j / 1000;
            Long lValueOf = Long.valueOf(j2);
            this.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", lValueOf, j);
            zzgm zzgmVar = this.zza.zzk().zzl;
            lValueOf.getClass();
            zzgmVar.zza(j2);
            this.zza.zzk().zzg.zza(false);
            Bundle bundle = new Bundle();
            lValueOf.getClass();
            bundle.putLong("_sid", j2);
            this.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
            String strZza = this.zza.zzk().zzq.zza();
            if (TextUtils.isEmpty(strZza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strZza);
            this.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
        }
    }
}
