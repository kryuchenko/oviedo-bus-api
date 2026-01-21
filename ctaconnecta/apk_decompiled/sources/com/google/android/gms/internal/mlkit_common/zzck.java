package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import kotlin.text.Typography;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzck {

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zza extends zzez<zza, C0044zza> implements zzgj {
        private static final zzff<Integer, zzdm> zzd = new zzcl();
        private static final zza zze;
        private static volatile zzgr<zza> zzf;
        private zzfg zzc = zzk();

        private zza() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzck$zza$zza, reason: collision with other inner class name */
        public static final class C0044zza extends zzez.zza<zza, C0044zza> implements zzgj {
            private C0044zza() {
                super(zza.zze);
            }

            /* synthetic */ C0044zza(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzck$zza>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zza> zzgrVar;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0044zza(zzcjVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzdm.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzgr<zza> zzgrVar2 = zzf;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zza.class) {
                        zzgr<zza> zzgrVar3 = zzf;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zze);
                            zzf = zzcVar;
                            zzgrVar = zzcVar;
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzcl, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzdm>] */
        static {
            zza zzaVar = new zza();
            zze = zzaVar;
            zzez.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzb extends zzez<zzb, C0045zzb> implements zzgj {
        private static final zzb zzj;
        private static volatile zzgr<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);

            private static final zzfe<zza> zzd = new zzcn();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return zzcm.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzc implements zzfb {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);

            private static final zzfe<zzc> zze = new zzco();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzf;
            }

            public static zzfd zzb() {
                return zzcp.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zzf = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzd implements zzfb {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);

            private static final zzfe<zzd> zze = new zzcr();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzf;
            }

            public static zzfd zzb() {
                return zzcq.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zzd(int i) {
                this.zzf = i;
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzck$zzb$zzb, reason: collision with other inner class name */
        public static final class C0045zzb extends zzez.zza<zzb, C0045zzb> implements zzgj {
            private C0045zzb() {
                super(zzb.zzj);
            }

            /* synthetic */ C0045zzb(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r5v20, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzck$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzb> zzgrVar;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0045zzb(zzcjVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzb> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzb.class) {
                        zzgr<zzb> zzgrVar3 = zzk;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzj);
                            zzk = zzcVar;
                            zzgrVar = zzcVar;
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzj = zzbVar;
            zzez.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }
}
