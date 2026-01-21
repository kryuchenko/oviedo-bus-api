package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzaen extends zzatu implements zzavg {
    private static final zzaen zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzaen zzaenVar = new zzaen();
        zzb = zzaenVar;
        zzatu.zzaE(zzaen.class, zzaenVar);
    }

    private zzaen() {
    }

    public static zzaem zza() {
        return (zzaem) zzb.zzar();
    }

    static /* synthetic */ void zzd(zzaen zzaenVar, int i) {
        zzaenVar.zzf |= 1;
        zzaenVar.zzg = 1;
    }

    static /* synthetic */ void zze(zzaen zzaenVar, int i) {
        zzaenVar.zzf |= 2;
        zzaenVar.zzh = i;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzaen();
        }
        zzadu zzaduVar = null;
        if (i2 == 4) {
            return new zzaem(zzaduVar);
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
        synchronized (zzaen.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
