package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzdo {

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zza extends zzfy<zza, C0073zza> implements zzhi {
        private static final zzge<Integer, zzel> zzd = new zzdq();
        private static final zza zze;
        private static volatile zzhq<zza> zzf;
        private zzgf zzc = zzk();

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzdo$zza$zza, reason: collision with other inner class name */
        public static final class C0073zza extends zzfy.zza<zza, C0073zza> implements zzhi {
            private C0073zza() {
                super(zza.zze);
            }

            /* synthetic */ C0073zza(zzdp zzdpVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzdo$zza>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zza> zzhqVar;
            zzdp zzdpVar = null;
            switch (zzdp.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0073zza(zzdpVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzel.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzhq<zza> zzhqVar2 = zzf;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zza.class) {
                        zzhq<zza> zzhqVar3 = zzf;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zze);
                            zzf = zzcVar;
                            zzhqVar = zzcVar;
                        }
                    }
                    return zzhqVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzdq, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzel>] */
        static {
            zza zzaVar = new zza();
            zze = zzaVar;
            zzfy.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzb extends zzfy<zzb, zza> implements zzhi {
        private static final zzb zzj;
        private static volatile zzhq<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzdo$zzb$zzb, reason: collision with other inner class name */
        public enum EnumC0074zzb implements zzga {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);

            private static final zzgd<EnumC0074zzb> zzd = new zzdr();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
                return zzds.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            EnumC0074zzb(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzc implements zzga {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);

            private static final zzgd<zzc> zze = new zzdu();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzf;
            }

            public static zzgc zzb() {
                return zzdt.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zzf = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzd implements zzga {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);

            private static final zzgd<zzd> zze = new zzdv();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzf;
            }

            public static zzgc zzb() {
                return zzdw.zza;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
            private zza() {
                super(zzb.zzj);
            }

            /* synthetic */ zza(zzdp zzdpVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r5v20, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzdo$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzb> zzhqVar;
            zzdp zzdpVar = null;
            switch (zzdp.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzdpVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", EnumC0074zzb.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzb> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzb.class) {
                        zzhq<zzb> zzhqVar3 = zzk;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzj);
                            zzk = zzcVar;
                            zzhqVar = zzcVar;
                        }
                    }
                    return zzhqVar;
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
            zzfy.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }
}
