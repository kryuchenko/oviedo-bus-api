package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public class zzhm {
    private static final zzgi zzsa = zzgi.zzfm();
    private zzfm zzym;
    private volatile zzih zzyn;
    private volatile zzfm zzyo;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhm)) {
            return false;
        }
        zzhm zzhmVar = (zzhm) obj;
        zzih zzihVar = this.zzyn;
        zzih zzihVar2 = zzhmVar.zzyn;
        if (zzihVar == null && zzihVar2 == null) {
            return zzdl().equals(zzhmVar.zzdl());
        }
        if (zzihVar != null && zzihVar2 != null) {
            return zzihVar.equals(zzihVar2);
        }
        if (zzihVar != null) {
            return zzihVar.equals(zzhmVar.zzh(zzihVar.zzge()));
        }
        return zzh(zzihVar2.zzge()).equals(zzihVar2);
    }

    private final zzih zzh(zzih zzihVar) {
        if (this.zzyn == null) {
            synchronized (this) {
                if (this.zzyn == null) {
                    try {
                        this.zzyn = zzihVar;
                        this.zzyo = zzfm.zzsm;
                    } catch (zzhh unused) {
                        this.zzyn = zzihVar;
                        this.zzyo = zzfm.zzsm;
                    }
                }
            }
        }
        return this.zzyn;
    }

    public final zzih zzi(zzih zzihVar) {
        zzih zzihVar2 = this.zzyn;
        this.zzym = null;
        this.zzyo = null;
        this.zzyn = zzihVar;
        return zzihVar2;
    }

    public final int zzgg() {
        if (this.zzyo != null) {
            return this.zzyo.size();
        }
        if (this.zzyn != null) {
            return this.zzyn.zzgg();
        }
        return 0;
    }

    public final zzfm zzdl() {
        if (this.zzyo != null) {
            return this.zzyo;
        }
        synchronized (this) {
            if (this.zzyo != null) {
                return this.zzyo;
            }
            if (this.zzyn == null) {
                this.zzyo = zzfm.zzsm;
            } else {
                this.zzyo = this.zzyn.zzdl();
            }
            return this.zzyo;
        }
    }
}
