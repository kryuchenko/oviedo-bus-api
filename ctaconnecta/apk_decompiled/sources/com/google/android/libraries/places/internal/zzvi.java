package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzvi extends zzatu implements zzavg {
    private static final zzvi zzb;
    private static volatile zzavn zze;
    private int zzf;
    private zzauc zzg = zzax();
    private zzco zzh;

    static {
        zzvi zzviVar = new zzvi();
        zzb = zzviVar;
        zzatu.zzaE(zzvi.class, zzviVar);
    }

    private zzvi() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzf", "zzg", zzvg.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzvi();
        }
        zzup zzupVar = null;
        if (i2 == 4) {
            return new zzvh(zzupVar);
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
        synchronized (zzvi.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
