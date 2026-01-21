package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzfq {
    private static final zzen zza = zzen.zza();
    private zzdv zzb;
    private volatile zzgh zzc;
    private volatile zzdv zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfq)) {
            return false;
        }
        zzfq zzfqVar = (zzfq) obj;
        zzgh zzghVar = this.zzc;
        zzgh zzghVar2 = zzfqVar.zzc;
        if (zzghVar == null && zzghVar2 == null) {
            return zzc().equals(zzfqVar.zzc());
        }
        if (zzghVar != null && zzghVar2 != null) {
            return zzghVar.equals(zzghVar2);
        }
        if (zzghVar != null) {
            return zzghVar.equals(zzfqVar.zzb(zzghVar.zzi()));
        }
        return zzb(zzghVar2.zzi()).equals(zzghVar2);
    }

    private final zzgh zzb(zzgh zzghVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzghVar;
                        this.zzd = zzdv.zza;
                    } catch (zzfh unused) {
                        this.zzc = zzghVar;
                        this.zzd = zzdv.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzgh zza(zzgh zzghVar) {
        zzgh zzghVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzghVar;
        return zzghVar2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzj();
        }
        return 0;
    }

    public final zzdv zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzdv.zza;
            } else {
                this.zzd = this.zzc.zze();
            }
            return this.zzd;
        }
    }
}
