package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;
import kotlin.text.Typography;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzhx {

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zza extends zzek<zza, C0051zza> implements zzfx {
        private static final zza zzf;
        private static volatile zzgf<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
            UNKNOWN_ENGINE(0),
            TFLITE(1);

            private static final zzeo<zzb> zzc = new zzhy();
            private final int zzd;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzd;
            }

            public static zzer zzb() {
                return zzhz.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzd = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhx$zza$zza, reason: collision with other inner class name */
        public static final class C0051zza extends zzek.zzb<zza, C0051zza> implements zzfx {
            private C0051zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0051zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zza>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zza> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0051zza(zzhwVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzb.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zza> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zza.class) {
                        zzgf<zza> zzgfVar3 = zzg;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzf);
                            zzg = zzaVar;
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
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzek.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzb extends zzek<zzb, zza> implements zzfx {
        private static final zzb zzn;
        private static volatile zzgf<zzb> zzo;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzb, zza> implements zzfx {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzb> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzgf<zzb> zzgfVar2 = zzo;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzb.class) {
                        zzgf<zzb> zzgfVar3 = zzo;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzn);
                            zzo = zzaVar;
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
            zzn = zzbVar;
            zzek.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzc extends zzek<zzc, zzb> implements zzfx {
        private static final zzc zzm;
        private static volatile zzgf<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private int zzl;
        private String zzf = "";
        private String zzg = "";
        private zzes<zzg> zzk = zzl();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4);

            private static final zzeo<zza> zzf = new zzia();
            private final int zzg;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzg;
            }

            public static zzer zzb() {
                return zzib.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzg = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc, reason: collision with other inner class name */
        public static final class C0052zzc extends zzek<C0052zzc, zza> implements zzfx {
            private static final C0052zzc zzf;
            private static volatile zzgf<C0052zzc> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            private C0052zzc() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc$zza */
            public static final class zza extends zzek.zzb<C0052zzc, zza> implements zzfx {
                private zza() {
                    super(C0052zzc.zzf);
                }

                /* synthetic */ zza(zzhw zzhwVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<C0052zzc> zzgfVar;
                zzhw zzhwVar = null;
                switch (zzhw.zza[i - 1]) {
                    case 1:
                        return new C0052zzc();
                    case 2:
                        return new zza(zzhwVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                    case 4:
                        return zzf;
                    case 5:
                        zzgf<C0052zzc> zzgfVar2 = zzg;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (C0052zzc.class) {
                            zzgf<C0052zzc> zzgfVar3 = zzg;
                            zzgfVar = zzgfVar3;
                            if (zzgfVar3 == null) {
                                ?? zzaVar = new zzek.zza(zzf);
                                zzg = zzaVar;
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
                C0052zzc c0052zzc = new C0052zzc();
                zzf = c0052zzc;
                zzek.zza((Class<C0052zzc>) C0052zzc.class, c0052zzc);
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzd extends zzek<zzd, zza> implements zzfx {
            private static final zzd zzg;
            private static volatile zzgf<zzd> zzh;
            private int zzc;
            private C0052zzc zzd;
            private C0052zzc zze;
            private boolean zzf;

            private zzd() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            public static final class zza extends zzek.zzb<zzd, zza> implements zzfx {
                private zza() {
                    super(zzd.zzg);
                }

                /* synthetic */ zza(zzhw zzhwVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zzd> zzgfVar;
                zzhw zzhwVar = null;
                switch (zzhw.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzhwVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzgf<zzd> zzgfVar2 = zzh;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zzd.class) {
                            zzgf<zzd> zzgfVar3 = zzh;
                            zzgfVar = zzgfVar3;
                            if (zzgfVar3 == null) {
                                ?? zzaVar = new zzek.zza(zzg);
                                zzh = zzaVar;
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
                zzd zzdVar = new zzd();
                zzg = zzdVar;
                zzek.zza((Class<zzd>) zzd.class, zzdVar);
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zze implements zzep {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);

            private static final zzeo<zze> zzg = new zzic();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzh;
            }

            public static zzer zzb() {
                return zzie.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzc, zzb> implements zzfx {
            private zzb() {
                super(zzc.zzm);
            }

            /* synthetic */ zzb(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v23, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzc> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb(zzhwVar);
                case 3:
                    return zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zze.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzg.class, "zzl"});
                case 4:
                    return zzm;
                case 5:
                    zzgf<zzc> zzgfVar2 = zzn;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzc.class) {
                        zzgf<zzc> zzgfVar3 = zzn;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzm);
                            zzn = zzaVar;
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
            zzc zzcVar = new zzc();
            zzm = zzcVar;
            zzek.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzd extends zzek<zzd, zza> implements zzfx {
        private static final zzd zzk;
        private static volatile zzgf<zzd> zzl;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzd, zza> implements zzfx {
            private zza() {
                super(zzd.zzk);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzd> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgf<zzd> zzgfVar2 = zzl;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzd.class) {
                        zzgf<zzd> zzgfVar3 = zzl;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzk);
                            zzl = zzaVar;
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
            zzd zzdVar = new zzd();
            zzk = zzdVar;
            zzek.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zze extends zzek<zze, zza> implements zzfx {
        private static final zze zze;
        private static volatile zzgf<zze> zzf;
        private int zzc;
        private int zzd;

        private zze() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zze, zza> implements zzfx {
            private zza() {
                super(zze.zze);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zze>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zze> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzgf<zze> zzgfVar2 = zzf;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zze.class) {
                        zzgf<zze> zzgfVar3 = zzf;
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

        static {
            zze zzeVar = new zze();
            zze = zzeVar;
            zzek.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzf extends zzek<zzf, zza> implements zzfx {
        private static final zzf zzo;
        private static volatile zzgf<zzf> zzp;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzf, zza> implements zzfx {
            private zza() {
                super(zzf.zzo);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v20, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzf> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzg", zzid.zzb(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzf"});
                case 4:
                    return zzo;
                case 5:
                    zzgf<zzf> zzgfVar2 = zzp;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzf.class) {
                        zzgf<zzf> zzgfVar3 = zzp;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzo);
                            zzp = zzaVar;
                            zzgfVar = zzaVar;
                        }
                    }
                    return zzgfVar;
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
            zzek.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzg extends zzek<zzg, zza> implements zzfx {
        private static final zzg zzd;
        private static volatile zzgf<zzg> zze;
        private zzeq zzc = zzk();

        private zzg() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzg, zza> implements zzfx {
            private zza() {
                super(zzg.zzd);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzg> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", new Object[]{"zzc"});
                case 4:
                    return zzd;
                case 5:
                    zzgf<zzg> zzgfVar2 = zze;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzg.class) {
                        zzgf<zzg> zzgfVar3 = zze;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzd);
                            zze = zzaVar;
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
            zzg zzgVar = new zzg();
            zzd = zzgVar;
            zzek.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzh extends zzek<zzh, zza> implements zzfx {
        private static final zzh zzf;
        private static volatile zzgf<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        private zzh() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzh, zza> implements zzfx {
            private zza() {
                super(zzh.zzf);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzh> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzh> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzh.class) {
                        zzgf<zzh> zzgfVar3 = zzg;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzf);
                            zzg = zzaVar;
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
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzek.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzi extends zzek<zzi, zza> implements zzfx {
        private static final zzi zzd;
        private static volatile zzgf<zzi> zze;
        private zzes<zzb> zzc = zzl();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek<zzb, zza> implements zzfx {
            private static final zzb zzh;
            private static volatile zzgf<zzb> zzi;
            private int zzc;
            private int zze;
            private long zzg;
            private String zzd = "";
            private String zzf = "";

            private zzb() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            public static final class zza extends zzek.zzb<zzb, zza> implements zzfx {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzhw zzhwVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zzb> zzgfVar;
                zzhw zzhwVar = null;
                switch (zzhw.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzhwVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgf<zzb> zzgfVar2 = zzi;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zzb.class) {
                            zzgf<zzb> zzgfVar3 = zzi;
                            zzgfVar = zzgfVar3;
                            if (zzgfVar3 == null) {
                                ?? zzaVar = new zzek.zza(zzh);
                                zzi = zzaVar;
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
                zzh = zzbVar;
                zzek.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zzi() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzi, zza> implements zzfx {
            private zza() {
                super(zzi.zzd);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzi> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzb.class});
                case 4:
                    return zzd;
                case 5:
                    zzgf<zzi> zzgfVar2 = zze;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzi.class) {
                        zzgf<zzi> zzgfVar3 = zze;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzd);
                            zze = zzaVar;
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
            zzi zziVar = new zzi();
            zzd = zziVar;
            zzek.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzj extends zzek<zzj, zza> implements zzfx {
        private static final zzj zzg;
        private static volatile zzgf<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3);

            private static final zzeo<zzb> zze = new zzih();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzf;
            }

            public static zzer zzb() {
                return zzii.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzf = i;
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzj, zza> implements zzfx {
            private zza() {
                super(zzj.zzg);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzj> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzj> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzj.class) {
                        zzgf<zzj> zzgfVar3 = zzh;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzg);
                            zzh = zzaVar;
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
            zzj zzjVar = new zzj();
            zzg = zzjVar;
            zzek.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzk extends zzek.zzc<zzk, zza> implements zzfx {
        private static final zzk zze;
        private static volatile zzgf<zzk> zzf;
        private byte zzd = 2;

        private zzk() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzd<zzk, zza> implements zzfx {
            private zza() {
                super(zzk.zze);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v12, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzk> zzgfVar;
            zzhw zzhwVar = null;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzhwVar);
                case 3:
                    return zza(zze, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zze;
                case 5:
                    zzgf<zzk> zzgfVar2 = zzf;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzk.class) {
                        zzgf<zzk> zzgfVar3 = zzf;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zze);
                            zzf = zzaVar;
                            zzgfVar = zzaVar;
                        }
                    }
                    return zzgfVar;
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
            zzek.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }
}
