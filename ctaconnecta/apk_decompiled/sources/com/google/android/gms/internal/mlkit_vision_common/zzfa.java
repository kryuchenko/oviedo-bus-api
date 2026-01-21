package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzfa {
    private static final zzeb zza = zzeb.zza();
    private zzdj zzb;
    private volatile zzfv zzc;
    private volatile zzdj zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfa)) {
            return false;
        }
        zzfa zzfaVar = (zzfa) obj;
        zzfv zzfvVar = this.zzc;
        zzfv zzfvVar2 = zzfaVar.zzc;
        if (zzfvVar == null && zzfvVar2 == null) {
            return zzc().equals(zzfaVar.zzc());
        }
        if (zzfvVar != null && zzfvVar2 != null) {
            return zzfvVar.equals(zzfvVar2);
        }
        if (zzfvVar != null) {
            return zzfvVar.equals(zzfaVar.zzb(zzfvVar.zzn()));
        }
        return zzb(zzfvVar2.zzn()).equals(zzfvVar2);
    }

    private final zzfv zzb(zzfv zzfvVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzfvVar;
                        this.zzd = zzdj.zza;
                    } catch (zzev unused) {
                        this.zzc = zzfvVar;
                        this.zzd = zzdj.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzfv zza(zzfv zzfvVar) {
        zzfv zzfvVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzfvVar;
        return zzfvVar2;
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

    public final zzdj zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzdj.zza;
            } else {
                this.zzd = this.zzc.zze();
            }
            return this.zzd;
        }
    }
}
