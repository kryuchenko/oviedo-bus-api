package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzaeg extends zzatu implements zzavg {
    private static final zzaua zzb = new zzaed();
    private static final zzaeg zze;
    private static volatile zzavn zzf;
    private int zzg;
    private zzatz zzh = zzau();
    private int zzi;

    static {
        zzaeg zzaegVar = new zzaeg();
        zze = zzaegVar;
        zzatu.zzaE(zzaeg.class, zzaegVar);
    }

    private zzaeg() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zze, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ࠞ\u0002င\u0000", new Object[]{"zzg", "zzh", zzaee.zza, "zzi"});
        }
        if (i2 == 3) {
            return new zzaeg();
        }
        zzadu zzaduVar = null;
        if (i2 == 4) {
            return new zzaef(zzaduVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzavn zzavnVar = zzf;
        if (zzavnVar != null) {
            return zzavnVar;
        }
        synchronized (zzaeg.class) {
            zzatpVar = zzf;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zze);
                zzf = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
