package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzaip extends zzatu implements zzavg {
    private static final zzaip zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzaip zzaipVar = new zzaip();
        zzb = zzaipVar;
        zzatu.zzaE(zzaip.class, zzaipVar);
    }

    private zzaip() {
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
            return new zzaip();
        }
        zzadu zzaduVar = null;
        if (i2 == 4) {
            return new zzaio(zzaduVar);
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
        synchronized (zzaip.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
