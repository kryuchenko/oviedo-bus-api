package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzji {

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zza extends zzfy<zza, zzb> implements zzhi {
        private static final zza zzf;
        private static volatile zzhq<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzji$zza$zza, reason: collision with other inner class name */
        public enum EnumC0075zza implements zzga {
            UNKNOWN_ENGINE(0),
            TFLITE(1);

            private static final zzgd<EnumC0075zza> zzc = new zzjm();
            private final int zzd;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzd;
            }

            public static zzgc zzb() {
                return zzjl.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            EnumC0075zza(int i) {
                this.zzd = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zza, zzb> implements zzhi {
            private zzb() {
                super(zza.zzf);
            }

            /* synthetic */ zzb(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zza>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zza> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzjkVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", EnumC0075zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zza> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zza.class) {
                        zzhq<zza> zzhqVar3 = zzg;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzf);
                            zzg = zzcVar;
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
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzfy.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzb extends zzfy<zzb, zza> implements zzhi {
        private static final zzb zzn;
        private static volatile zzhq<zzb> zzo;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzb> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzhq<zzb> zzhqVar2 = zzo;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzb.class) {
                        zzhq<zzb> zzhqVar3 = zzo;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzn);
                            zzo = zzcVar;
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
            zzn = zzbVar;
            zzfy.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzc extends zzfy<zzc, C0076zzc> implements zzhi {
        private static final zzc zzm;
        private static volatile zzhq<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private int zzl;
        private String zzf = "";
        private String zzg = "";
        private zzgh<zzg> zzk = zzl();

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4);

            private static final zzgd<zza> zzf = new zzjo();
            private final int zzg;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzg;
            }

            public static zzgc zzb() {
                return zzjn.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzg = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzf;
            private static volatile zzhq<zzb> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(zzjk zzjkVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzc$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                zzjk zzjkVar = null;
                switch (zzjk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzjkVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                    case 4:
                        return zzf;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzg;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzg;
                            zzhqVar = zzhqVar3;
                            if (zzhqVar3 == null) {
                                ?? zzcVar = new zzfy.zzc(zzf);
                                zzg = zzcVar;
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
                zzf = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzd extends zzfy<zzd, zza> implements zzhi {
            private static final zzd zzg;
            private static volatile zzhq<zzd> zzh;
            private int zzc;
            private zzb zzd;
            private zzb zze;
            private boolean zzf;

            private zzd() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzd, zza> implements zzhi {
                private zza() {
                    super(zzd.zzg);
                }

                /* synthetic */ zza(zzjk zzjkVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzc$zzd>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzd> zzhqVar;
                zzjk zzjkVar = null;
                switch (zzjk.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzjkVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzhq<zzd> zzhqVar2 = zzh;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzd.class) {
                            zzhq<zzd> zzhqVar3 = zzh;
                            zzhqVar = zzhqVar3;
                            if (zzhqVar3 == null) {
                                ?? zzcVar = new zzfy.zzc(zzg);
                                zzh = zzcVar;
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
                zzd zzdVar = new zzd();
                zzg = zzdVar;
                zzfy.zza((Class<zzd>) zzd.class, zzdVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zze implements zzga {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);

            private static final zzgd<zze> zzg = new zzjq();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzh;
            }

            public static zzgc zzb() {
                return zzjp.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zze(int i) {
                this.zzh = i;
            }
        }

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzji$zzc$zzc, reason: collision with other inner class name */
        public static final class C0076zzc extends zzfy.zza<zzc, C0076zzc> implements zzhi {
            private C0076zzc() {
                super(zzc.zzm);
            }

            /* synthetic */ C0076zzc(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v23, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzc>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzc> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new C0076zzc(zzjkVar);
                case 3:
                    return zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zze.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzg.class, "zzl"});
                case 4:
                    return zzm;
                case 5:
                    zzhq<zzc> zzhqVar2 = zzn;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzc.class) {
                        zzhq<zzc> zzhqVar3 = zzn;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzm);
                            zzn = zzcVar;
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
            zzc zzcVar = new zzc();
            zzm = zzcVar;
            zzfy.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzd extends zzfy<zzd, zza> implements zzhi {
        private static final zzd zzk;
        private static volatile zzhq<zzd> zzl;
        private int zzc;
        private int zzg;
        private int zzh;
        private int zzj;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzi = "";

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzd, zza> implements zzhi {
            private zza() {
                super(zzd.zzk);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzd>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzd> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhq<zzd> zzhqVar2 = zzl;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzd.class) {
                        zzhq<zzd> zzhqVar3 = zzl;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzk);
                            zzl = zzcVar;
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
            zzd zzdVar = new zzd();
            zzk = zzdVar;
            zzfy.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zze extends zzfy<zze, zza> implements zzhi {
        private static final zze zze;
        private static volatile zzhq<zze> zzf;
        private int zzc;
        private int zzd;

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zze, zza> implements zzhi {
            private zza() {
                super(zze.zze);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zze>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zze> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzhq<zze> zzhqVar2 = zzf;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zze.class) {
                        zzhq<zze> zzhqVar3 = zzf;
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

        static {
            zze zzeVar = new zze();
            zze = zzeVar;
            zzfy.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzf extends zzfy<zzf, zza> implements zzhi {
        private static final zzf zzo;
        private static volatile zzhq<zzf> zzp;
        private int zzc;
        private zzb zzd;
        private zzi zze;
        private zzd zzf;
        private int zzg;
        private zzc zzh;
        private zzk zzi;
        private long zzj;
        private long zzk;
        private boolean zzl;
        private int zzm;
        private byte zzn = 2;

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzf, zza> implements zzhi {
            private zza() {
                super(zzf.zzo);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v20, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzf> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzg", zzjs.zzb(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzf"});
                case 4:
                    return zzo;
                case 5:
                    zzhq<zzf> zzhqVar2 = zzp;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzf.class) {
                        zzhq<zzf> zzhqVar3 = zzp;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzo);
                            zzp = zzcVar;
                            zzhqVar = zzcVar;
                        }
                    }
                    return zzhqVar;
                case 6:
                    return Byte.valueOf(this.zzn);
                case 7:
                    this.zzn = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzo = zzfVar;
            zzfy.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzg extends zzfy<zzg, zza> implements zzhi {
        private static final zzg zzd;
        private static volatile zzhq<zzg> zze;
        private zzgf zzc = zzk();

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzg, zza> implements zzhi {
            private zza() {
                super(zzg.zzd);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzg>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzg> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", new Object[]{"zzc"});
                case 4:
                    return zzd;
                case 5:
                    zzhq<zzg> zzhqVar2 = zze;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzg.class) {
                        zzhq<zzg> zzhqVar3 = zze;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzd);
                            zze = zzcVar;
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
            zzg zzgVar = new zzg();
            zzd = zzgVar;
            zzfy.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzh extends zzfy<zzh, zza> implements zzhi {
        private static final zzh zzf;
        private static volatile zzhq<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzh, zza> implements zzhi {
            private zza() {
                super(zzh.zzf);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzh>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzh> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzh> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzh.class) {
                        zzhq<zzh> zzhqVar3 = zzg;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzf);
                            zzg = zzcVar;
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
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzfy.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzi extends zzfy<zzi, zzb> implements zzhi {
        private static final zzi zzd;
        private static volatile zzhq<zzi> zze;
        private zzgh<zza> zzc = zzl();

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy<zza, C0077zza> implements zzhi {
            private static final zza zzh;
            private static volatile zzhq<zza> zzi;
            private int zzc;
            private int zze;
            private long zzg;
            private String zzd = "";
            private String zzf = "";

            private zza() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzji$zzi$zza$zza, reason: collision with other inner class name */
            public static final class C0077zza extends zzfy.zza<zza, C0077zza> implements zzhi {
                private C0077zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0077zza(zzjk zzjkVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzi$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zza> zzhqVar;
                zzjk zzjkVar = null;
                switch (zzjk.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0077zza(zzjkVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhq<zza> zzhqVar2 = zzi;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zza.class) {
                            zzhq<zza> zzhqVar3 = zzi;
                            zzhqVar = zzhqVar3;
                            if (zzhqVar3 == null) {
                                ?? zzcVar = new zzfy.zzc(zzh);
                                zzi = zzcVar;
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
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzfy.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzi, zzb> implements zzhi {
            private zzb() {
                super(zzi.zzd);
            }

            /* synthetic */ zzb(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzi>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzi> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(zzjkVar);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zza.class});
                case 4:
                    return zzd;
                case 5:
                    zzhq<zzi> zzhqVar2 = zze;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzi.class) {
                        zzhq<zzi> zzhqVar3 = zze;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzd);
                            zze = zzcVar;
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
            zzi zziVar = new zzi();
            zzd = zziVar;
            zzfy.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzj extends zzfy<zzj, zzb> implements zzhi {
        private static final zzj zzg;
        private static volatile zzhq<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3);

            private static final zzgd<zza> zze = new zzjv();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzf;
            }

            public static zzgc zzb() {
                return zzju.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzf = i;
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzj, zzb> implements zzhi {
            private zzb() {
                super(zzj.zzg);
            }

            /* synthetic */ zzb(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzj>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzj> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb(zzjkVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzj> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzj.class) {
                        zzhq<zzj> zzhqVar3 = zzh;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzg);
                            zzh = zzcVar;
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
            zzj zzjVar = new zzj();
            zzg = zzjVar;
            zzfy.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzk extends zzfy.zze<zzk, zza> implements zzhi {
        private static final zzk zze;
        private static volatile zzhq<zzk> zzf;
        private byte zzd = 2;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zzb<zzk, zza> implements zzhi {
            private zza() {
                super(zzk.zze);
            }

            /* synthetic */ zza(zzjk zzjkVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v12, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzji$zzk>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzk> zzhqVar;
            zzjk zzjkVar = null;
            switch (zzjk.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzjkVar);
                case 3:
                    return zza(zze, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zze;
                case 5:
                    zzhq<zzk> zzhqVar2 = zzf;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzk.class) {
                        zzhq<zzk> zzhqVar3 = zzf;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zze);
                            zzf = zzcVar;
                            zzhqVar = zzcVar;
                        }
                    }
                    return zzhqVar;
                case 6:
                    return Byte.valueOf(this.zzd);
                case 7:
                    this.zzd = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zze = zzkVar;
            zzfy.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }
}
