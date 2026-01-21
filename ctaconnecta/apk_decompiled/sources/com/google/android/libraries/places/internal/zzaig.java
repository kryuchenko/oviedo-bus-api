package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzaig extends zzatu implements zzavg {
    private static final zzaig zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private zzauc zzh = zzatu.zzax();
    private zzauc zzi = zzatu.zzax();
    private zzauc zzj = zzatu.zzax();
    private zzauc zzk = zzatu.zzax();
    private int zzl;
    private zzaho zzm;

    static {
        zzaig zzaigVar = new zzaig();
        zzb = zzaigVar;
        zzatu.zzaE(zzaig.class, zzaigVar);
    }

    private zzaig() {
    }

    public static zzaie zza() {
        return (zzaie) zzb.zzar();
    }

    static /* synthetic */ void zzd(zzaig zzaigVar, Iterable iterable) {
        zzauc zzaucVar = zzaigVar.zzh;
        if (!zzaucVar.zzc()) {
            zzaigVar.zzh = zzatu.zzay(zzaucVar);
        }
        zzart.zzam(iterable, zzaigVar.zzh);
    }

    static /* synthetic */ void zze(zzaig zzaigVar, Iterable iterable) {
        zzauc zzaucVar = zzaigVar.zzi;
        if (!zzaucVar.zzc()) {
            zzaigVar.zzi = zzatu.zzay(zzaucVar);
        }
        zzart.zzam(iterable, zzaigVar.zzi);
    }

    static /* synthetic */ void zzf(zzaig zzaigVar, Iterable iterable) {
        zzauc zzaucVar = zzaigVar.zzj;
        if (!zzaucVar.zzc()) {
            zzaigVar.zzj = zzatu.zzay(zzaucVar);
        }
        zzart.zzam(iterable, zzaigVar.zzj);
    }

    static /* synthetic */ void zzg(zzaig zzaigVar, Iterable iterable) {
        zzauc zzaucVar = zzaigVar.zzk;
        if (!zzaucVar.zzc()) {
            zzaigVar.zzk = zzatu.zzay(zzaucVar);
        }
        zzart.zzam(iterable, zzaigVar.zzk);
    }

    static /* synthetic */ void zzh(zzaig zzaigVar, int i) {
        zzaigVar.zzf |= 2;
        zzaigVar.zzl = i;
    }

    static /* synthetic */ void zzi(zzaig zzaigVar, zzaho zzahoVar) {
        zzahoVar.getClass();
        zzaigVar.zzm = zzahoVar;
        zzaigVar.zzf |= 4;
    }

    static /* synthetic */ void zzj(zzaig zzaigVar, int i) {
        zzaigVar.zzg = i - 1;
        zzaigVar.zzf |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001᠌\u0000\u0002\u001a\u0003\u001a\u0004\u001a\u0005\u001a\u0006င\u0001\u0007ဉ\u0002", new Object[]{"zzf", "zzg", zzaif.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzaig();
        }
        zzadu zzaduVar = null;
        if (i2 == 4) {
            return new zzaie(zzaduVar);
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
        synchronized (zzaig.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
