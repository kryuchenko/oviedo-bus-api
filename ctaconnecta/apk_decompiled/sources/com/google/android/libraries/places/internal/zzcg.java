package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzcg extends zzatu implements zzavg {
    private static final zzcg zzb;
    private static volatile zzavn zze;
    private zzauc zzf = zzax();

    static {
        zzcg zzcgVar = new zzcg();
        zzb = zzcgVar;
        zzatu.zzaE(zzcg.class, zzcgVar);
    }

    private zzcg() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzcl.class});
        }
        if (i2 == 3) {
            return new zzcg();
        }
        zzce zzceVar = null;
        if (i2 == 4) {
            return new zzcf(zzceVar);
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
        synchronized (zzcg.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
