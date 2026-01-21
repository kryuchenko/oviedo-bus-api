package com.google.android.libraries.places.internal;

import java.io.IOException;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbsq {
    final /* synthetic */ zzbsu zza;
    private final int zzc;
    private int zzd;
    private int zze;
    private final zzbsp zzf;
    private final zzbwb zzb = new zzbwb();
    private boolean zzg = false;

    zzbsq(zzbsu zzbsuVar, int i, int i2, zzbsp zzbspVar) {
        this.zza = zzbsuVar;
        this.zzc = i;
        this.zzd = i2;
        this.zzf = zzbspVar;
    }

    final int zza() {
        return this.zze;
    }

    final int zzb(int i) {
        if (i <= 0 || Integer.MAX_VALUE - i >= this.zzd) {
            int i2 = this.zzd + i;
            this.zzd = i2;
            return i2;
        }
        throw new IllegalArgumentException("Window size overflow for stream: " + this.zzc);
    }

    final int zzc() {
        return Math.max(0, Math.min(this.zzd, (int) this.zzb.zzg())) - this.zze;
    }

    final int zzd() {
        return this.zzd;
    }

    final int zze() {
        return Math.min(this.zzd, this.zza.zzd.zzd);
    }

    final int zzf(int i, zzbst zzbstVar) {
        int iMin = Math.min(i, zze());
        int iZzg = 0;
        while (zzk() && iMin > 0) {
            zzbwb zzbwbVar = this.zzb;
            if (iMin >= zzbwbVar.zzg()) {
                iZzg += (int) zzbwbVar.zzg();
                zzj(zzbwbVar, (int) zzbwbVar.zzg(), this.zzg);
            } else {
                iZzg += iMin;
                zzj(zzbwbVar, iMin, false);
            }
            zzbstVar.zza++;
            iMin = Math.min(i - iZzg, zze());
        }
        return iZzg;
    }

    final void zzg(int i) {
        this.zze += i;
    }

    final void zzh() {
        this.zze = 0;
    }

    final void zzi(zzbwb zzbwbVar, int i, boolean z) {
        this.zzb.zzn(zzbwbVar, i);
        this.zzg |= z;
    }

    final void zzj(zzbwb zzbwbVar, int i, boolean z) {
        do {
            int iMin = Math.min(i, this.zza.zzb.zzd());
            int i2 = -iMin;
            this.zza.zzd.zzb(i2);
            zzb(i2);
            try {
                boolean z2 = false;
                if (zzbwbVar.zzg() == iMin && z) {
                    z2 = true;
                }
                this.zza.zzb.zzf(z2, this.zzc, zzbwbVar, iMin);
                this.zzf.zzs(iMin);
                i -= iMin;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (i > 0);
    }

    final boolean zzk() {
        return this.zzb.zzg() > 0;
    }
}
