package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* loaded from: classes3.dex */
public final class zzgt {

    public static final class zza extends zzcg<zza, C0018zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        private static final zza zzbil;

        /* renamed from: com.google.android.gms.internal.clearcut.zzgt$zza$zza, reason: collision with other inner class name */
        public static final class C0018zza extends zzcg.zza<zza, C0018zza> implements zzdq {
            private C0018zza() {
                super(zza.zzbil);
            }

            /* synthetic */ C0018zza(zzgu zzguVar) {
                this();
            }
        }

        public enum zzb implements zzcj {
            NO_RESTRICTION(0),
            SIDEWINDER_DEVICE(1),
            LATCHSKY_DEVICE(2);

            private static final zzck<zzb> zzbq = new zzgv();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzb zzbe(int i) {
                if (i == 0) {
                    return NO_RESTRICTION;
                }
                if (i == 1) {
                    return SIDEWINDER_DEVICE;
                }
                if (i != 2) {
                    return null;
                }
                return LATCHSKY_DEVICE;
            }

            public static zzck<zzb> zzd() {
                return zzbq;
            }

            @Override // com.google.android.gms.internal.clearcut.zzcj
            public final int zzc() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzbil = zzaVar;
            zzcg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgt$zza>] */
        @Override // com.google.android.gms.internal.clearcut.zzcg
        protected final Object zza(int i, Object obj, Object obj2) {
            zzdz<zza> zzdzVar;
            zzgu zzguVar = null;
            switch (zzgu.zzba[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0018zza(zzguVar);
                case 3:
                    return zza(zzbil, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbil;
                case 5:
                    zzdz<zza> zzdzVar2 = zzbg;
                    if (zzdzVar2 != null) {
                        return zzdzVar2;
                    }
                    synchronized (zza.class) {
                        zzdz<zza> zzdzVar3 = zzbg;
                        zzdzVar = zzdzVar3;
                        if (zzdzVar3 == null) {
                            ?? zzbVar = new zzcg.zzb(zzbil);
                            zzbg = zzbVar;
                            zzdzVar = zzbVar;
                        }
                    }
                    return zzdzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
