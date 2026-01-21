package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzamj extends zzatu implements zzavg {
    private static final zzamj zzb;
    private static volatile zzavn zze;
    private int zzf;
    private int zzg;

    static {
        zzamj zzamjVar = new zzamj();
        zzb = zzamjVar;
        zzatu.zzaE(zzamj.class, zzamjVar);
    }

    private zzamj() {
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzc() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaB(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzamj();
        }
        zzalz zzalzVar = null;
        if (i2 == 4) {
            return new zzami(zzalzVar);
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
        synchronized (zzamj.class) {
            zzatpVar = zze;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zzb);
                zze = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
