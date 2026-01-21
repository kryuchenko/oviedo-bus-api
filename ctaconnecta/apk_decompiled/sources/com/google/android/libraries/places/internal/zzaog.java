package com.google.android.libraries.places.internal;

import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzaog extends zzatu implements zzavg {
    private static final zzaog zzb;
    private static volatile zzavn zze;
    private int zzg;
    private int zzh;
    private String zzf = "";
    private zzauc zzi = zzax();

    static {
        zzaog zzaogVar = new zzaog();
        zzb = zzaogVar;
        zzatu.zzaE(zzaog.class, zzaogVar);
    }

    private zzaog() {
    }

    public final int zza() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzi;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u001b", new Object[]{"zzf", "zzg", "zzh", "zzi", zzalr.class});
        }
        if (i2 == 3) {
            return new zzaog();
        }
        zzaoe zzaoeVar = null;
        if (i2 == 4) {
            return new zzaof(zzaoeVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzavn zzavnVar = zze;
        if (zzavnVar != null) {
            return zzavnVar;
        }
        synchronized (zzaog.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
