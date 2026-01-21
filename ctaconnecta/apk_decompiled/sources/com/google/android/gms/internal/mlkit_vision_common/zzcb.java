package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;
import kotlin.text.Typography;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzcb {

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zza extends zzek<zza, C0049zza> implements zzfx {
        private static final zzet<Integer, zzcz> zzd = new zzcc();
        private static final zza zze;
        private static volatile zzgf<zza> zzf;
        private zzeq zzc = zzk();

        private zza() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzcb$zza$zza, reason: collision with other inner class name */
        public static final class C0049zza extends zzek.zzb<zza, C0049zza> implements zzfx {
            private C0049zza() {
                super(zza.zze);
            }

            /* synthetic */ C0049zza(zzca zzcaVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzcb$zza>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zza> zzgfVar;
            zzca zzcaVar = null;
            switch (zzca.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0049zza(zzcaVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzcz.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzgf<zza> zzgfVar2 = zzf;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zza.class) {
                        zzgf<zza> zzgfVar3 = zzf;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zze);
                            zzf = zzaVar;
                            zzgfVar = zzaVar;
                        }
                    }
                    return zzgfVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzcc, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzcz>] */
        static {
            zza zzaVar = new zza();
            zze = zzaVar;
            zzek.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzb extends zzek<zzb, C0050zzb> implements zzfx {
        private static final zzb zzj;
        private static volatile zzgf<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);

            private static final zzeo<zza> zzd = new zzce();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return zzcd.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzc implements zzep {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);

            private static final zzeo<zzc> zze = new zzcf();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzf;
            }

            public static zzer zzb() {
                return zzcg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zzf = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzd implements zzep {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);

            private static final zzeo<zzd> zze = new zzci();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzf;
            }

            public static zzer zzb() {
                return zzch.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzcb$zzb$zzb, reason: collision with other inner class name */
        public static final class C0050zzb extends zzek.zzb<zzb, C0050zzb> implements zzfx {
            private C0050zzb() {
                super(zzb.zzj);
            }

            /* synthetic */ C0050zzb(zzca zzcaVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r5v20, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzcb$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzb> zzgfVar;
            zzca zzcaVar = null;
            switch (zzca.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0050zzb(zzcaVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzb> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzb.class) {
                        zzgf<zzb> zzgfVar3 = zzk;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzj);
                            zzk = zzaVar;
                            zzgfVar = zzaVar;
                        }
                    }
                    return zzgfVar;
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
            zzek.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }
}
