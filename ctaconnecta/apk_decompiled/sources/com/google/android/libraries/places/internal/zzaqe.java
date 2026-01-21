package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzaqe extends zzatu implements zzavg {
    private static final zzaqe zzb;
    private static volatile zzavn zze;
    private zzauc zzf = zzax();
    private zzauc zzg = zzatu.zzax();

    static {
        zzaqe zzaqeVar = new zzaqe();
        zzb = zzaqeVar;
        zzatu.zzaE(zzaqe.class, zzaqeVar);
    }

    private zzaqe() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002Ț", new Object[]{"zzf", zzaqh.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzaqe();
        }
        zzaqc zzaqcVar = null;
        if (i2 == 4) {
            return new zzaqd(zzaqcVar);
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
        synchronized (zzaqe.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
