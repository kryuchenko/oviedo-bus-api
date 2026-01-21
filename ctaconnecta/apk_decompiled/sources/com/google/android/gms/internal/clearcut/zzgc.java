package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* loaded from: classes3.dex */
public final class zzgc extends zzcg.zzd<zzgc, zza> implements zzdq {
    private static volatile zzdz<zzgc> zzbg;
    private static final zzgc zzsg;
    private byte zzsf = 2;

    public static final class zza extends zzcg.zzc<zzgc, zza> implements zzdq {
        private zza() {
            super(zzgc.zzsg);
        }

        /* synthetic */ zza(zzgd zzgdVar) {
            this();
        }
    }

    static {
        zzgc zzgcVar = new zzgc();
        zzsg = zzgcVar;
        zzcg.zza((Class<zzgc>) zzgc.class, zzgcVar);
    }

    private zzgc() {
    }

    public static zzgc zzer() {
        return zzsg;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgc>] */
    @Override // com.google.android.gms.internal.clearcut.zzcg
    protected final Object zza(int i, Object obj, Object obj2) {
        zzdz<zzgc> zzdzVar;
        zzgd zzgdVar = null;
        switch (zzgd.zzba[i - 1]) {
            case 1:
                return new zzgc();
            case 2:
                return new zza(zzgdVar);
            case 3:
                return zza(zzsg, "\u0003\u0000", (Object[]) null);
            case 4:
                return zzsg;
            case 5:
                zzdz<zzgc> zzdzVar2 = zzbg;
                if (zzdzVar2 != null) {
                    return zzdzVar2;
                }
                synchronized (zzgc.class) {
                    zzdz<zzgc> zzdzVar3 = zzbg;
                    zzdzVar = zzdzVar3;
                    if (zzdzVar3 == null) {
                        ?? zzbVar = new zzcg.zzb(zzsg);
                        zzbg = zzbVar;
                        zzdzVar = zzbVar;
                    }
                }
                return zzdzVar;
            case 6:
                return Byte.valueOf(this.zzsf);
            case 7:
                this.zzsf = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
