package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzagn extends zzatu implements zzavg {
    private static final zzaua zzb = new zzagl();
    private static final zzagn zze;
    private static volatile zzavn zzf;
    private zzatz zzg = zzau();

    static {
        zzagn zzagnVar = new zzagn();
        zze = zzagnVar;
        zzatu.zzaE(zzagn.class, zzagnVar);
    }

    private zzagn() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001ࠞ", new Object[]{"zzg", zzadw.zza});
        }
        if (i2 == 3) {
            return new zzagn();
        }
        zzadu zzaduVar = null;
        if (i2 == 4) {
            return new zzagm(zzaduVar);
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
        synchronized (zzagn.class) {
            zzatpVar = zzf;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zze);
                zzf = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
