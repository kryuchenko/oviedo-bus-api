package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzakp extends zzatu implements zzavg {
    private static final zzakp zzb;
    private static volatile zzavn zze;
    private zzauc zzf = zzax();

    static {
        zzakp zzakpVar = new zzakp();
        zzb = zzakpVar;
        zzatu.zzaE(zzakp.class, zzakpVar);
    }

    private zzakp() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzala.class});
        }
        if (i2 == 3) {
            return new zzakp();
        }
        zzakn zzaknVar = null;
        if (i2 == 4) {
            return new zzako(zzaknVar);
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
        synchronized (zzakp.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
