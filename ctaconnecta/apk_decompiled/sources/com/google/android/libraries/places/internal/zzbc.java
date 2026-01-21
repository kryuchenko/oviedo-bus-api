package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbc extends zzatu implements zzavg {
    private static final zzaua zzb = new zzaz();
    private static final zzbc zze;
    private static volatile zzavn zzf;
    private int zzg;
    private int zzh;
    private long zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private zzatz zzm = zzau();
    private int zzn;

    static {
        zzbc zzbcVar = new zzbc();
        zze = zzbcVar;
        zzatu.zzaE(zzbc.class, zzbcVar);
    }

    private zzbc() {
    }

    @Override // com.google.android.libraries.places.internal.zzatu
    protected final Object zzb(int i, Object obj, Object obj2) {
        zzavn zzatpVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaty zzatyVar = zzbb.zza;
            return zzaB(zze, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004င\u0003\u0005င\u0004\u0006ࠞ\u0007᠌\u0005", new Object[]{"zzg", "zzh", zzas.zza, "zzi", "zzj", "zzk", "zzl", "zzm", zzatyVar, "zzn", zzatyVar});
        }
        if (i2 == 3) {
            return new zzbc();
        }
        zzaw zzawVar = null;
        if (i2 == 4) {
            return new zzba(zzawVar);
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
        synchronized (zzbc.class) {
            zzatpVar = zzf;
            if (zzatpVar == null) {
                zzatpVar = new zzatp(zze);
                zzf = zzatpVar;
            }
        }
        return zzatpVar;
    }
}
