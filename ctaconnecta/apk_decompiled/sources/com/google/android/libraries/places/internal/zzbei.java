package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class zzbei implements zzbel, zzbmm {
    private zzbgj zzr;
    private final Object zzs = new Object();
    private final zzbqo zzt;
    private final zzbqz zzu;
    private final zzbmq zzv;
    private int zzw;
    private boolean zzx;
    private boolean zzy;
    private final int zzz;

    protected zzbei(int i, zzbqo zzbqoVar, zzbqz zzbqzVar) {
        this.zzt = zzbqoVar;
        this.zzu = zzbqzVar;
        zzbmq zzbmqVar = new zzbmq(this, zzaza.zza, i, zzbqoVar, zzbqzVar);
        this.zzv = zzbmqVar;
        this.zzr = zzbmqVar;
        this.zzz = 32768;
    }

    private final void zzb() {
        boolean zZzc;
        synchronized (this.zzs) {
            zZzc = zzc();
        }
        if (zZzc) {
            zza().zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc() {
        boolean z;
        synchronized (this.zzs) {
            z = false;
            if (this.zzx && this.zzw < this.zzz && !this.zzy) {
                z = true;
            }
        }
        return z;
    }

    static /* bridge */ /* synthetic */ void zzn(zzbei zzbeiVar, int i) {
        synchronized (zzbeiVar.zzs) {
            zzbeiVar.zzw += i;
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzbei zzbeiVar, int i) {
        zzbgj zzbgjVar = zzbeiVar.zzr;
        zzbeiVar.zzz(new zzbeh(zzbeiVar, zzbvr.zza(), 2));
    }

    protected abstract zzbqr zza();

    protected final zzbqz zzm() {
        return this.zzu;
    }

    protected final void zzp(boolean z) {
        if (z) {
            this.zzr.close();
        } else {
            this.zzr.zza();
        }
    }

    protected final void zzq(zzbnv zzbnvVar) {
        try {
            this.zzr.zzb(zzbnvVar);
        } catch (Throwable th) {
            zzF(th);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmm
    public final void zzr(zzbqq zzbqqVar) {
        zza().zzf(zzbqqVar);
    }

    public final void zzs(int i) {
        boolean z;
        synchronized (this.zzs) {
            zzmt.zzp(this.zzx, "onStreamAllocated was not called, but it seems the stream is active");
            int i2 = this.zzw;
            int i3 = this.zzz;
            int i4 = i2 - i;
            this.zzw = i4;
            z = false;
            if (i2 >= i3 && i4 < i3) {
                z = true;
            }
        }
        if (z) {
            zzb();
        }
    }

    protected final void zzt() {
        zzmt.zzo(zza() != null);
        synchronized (this.zzs) {
            zzmt.zzp(!this.zzx, "Already allocated");
            this.zzx = true;
        }
        zzb();
    }

    protected final void zzu() {
        synchronized (this.zzs) {
            this.zzy = true;
        }
    }

    final void zzv() {
        this.zzv.zzf(this);
        this.zzr = this.zzv;
    }

    protected final void zzw(zzazo zzazoVar) {
        this.zzr.zzd(zzazoVar);
    }

    final void zzx(int i) {
        this.zzr.zze(i);
    }
}
