package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class zzgp {
    private static final zzfm zza = zzfm.zza();
    private zzeu zzb;
    private volatile zzhg zzc;
    private volatile zzeu zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgp)) {
            return false;
        }
        zzgp zzgpVar = (zzgp) obj;
        zzhg zzhgVar = this.zzc;
        zzhg zzhgVar2 = zzgpVar.zzc;
        if (zzhgVar == null && zzhgVar2 == null) {
            return zzc().equals(zzgpVar.zzc());
        }
        if (zzhgVar != null && zzhgVar2 != null) {
            return zzhgVar.equals(zzhgVar2);
        }
        if (zzhgVar != null) {
            return zzhgVar.equals(zzgpVar.zzb(zzhgVar.zzi()));
        }
        return zzb(zzhgVar2.zzi()).equals(zzhgVar2);
    }

    private final zzhg zzb(zzhg zzhgVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzhgVar;
                        this.zzd = zzeu.zza;
                    } catch (zzgg unused) {
                        this.zzc = zzhgVar;
                        this.zzd = zzeu.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzhg zza(zzhg zzhgVar) {
        zzhg zzhgVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzhgVar;
        return zzhgVar2;
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

    public final zzeu zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzeu.zza;
            } else {
                this.zzd = this.zzc.zze();
            }
            return this.zzd;
        }
    }
}
