package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzarh extends zzatu implements zzavg {
    private static final zzaua zzb = new zzarf();
    private static final zzarh zze;
    private static volatile zzavn zzf;
    private double zzg;
    private zzatz zzh = zzau();
    private zzauc zzi = zzatu.zzax();

    static {
        zzarh zzarhVar = new zzarh();
        zze = zzarhVar;
        zzatu.zzaE(zzarh.class, zzarhVar);
    }

    private zzarh() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zze, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0000\u0002,\u0003Ț", new Object[]{"zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzarh();
        }
        zzard zzardVar = null;
        if (i2 == 4) {
            return new zzarg(zzardVar);
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
        synchronized (zzarh.class) {
            zzatpVar = zzf;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zze);
                zzf = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
