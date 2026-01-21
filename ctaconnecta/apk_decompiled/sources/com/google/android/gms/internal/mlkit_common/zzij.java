package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import kotlin.text.Typography;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzij {

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zza extends zzez<zza, zzb> implements zzgj {
        private static final zza zzf;
        private static volatile zzgr<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzij$zza$zza, reason: collision with other inner class name */
        public enum EnumC0046zza implements zzfb {
            UNKNOWN_ENGINE(0),
            TFLITE(1);

            private static final zzfe<EnumC0046zza> zzc = new zzin();
            private final int zzd;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzd;
            }

            public static zzfd zzb() {
                return zzim.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            EnumC0046zza(int i) {
                this.zzd = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zza, zzb> implements zzgj {
            private zzb() {
                super(zza.zzf);
            }

            /* synthetic */ zzb(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zza>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zza> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzilVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", EnumC0046zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zza> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zza.class) {
                        zzgr<zza> zzgrVar3 = zzg;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzf);
                            zzg = zzcVar;
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
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzez.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzb extends zzez<zzb, zza> implements zzgj {
        private static final zzb zzn;
        private static volatile zzgr<zzb> zzo;
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

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzb, zza> implements zzgj {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzb> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzgr<zzb> zzgrVar2 = zzo;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzb.class) {
                        zzgr<zzb> zzgrVar3 = zzo;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzn);
                            zzo = zzcVar;
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
            zzn = zzbVar;
            zzez.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzc extends zzez<zzc, C0047zzc> implements zzgj {
        private static final zzc zzm;
        private static volatile zzgr<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private int zzl;
        private String zzf = "";
        private String zzg = "";
        private zzfi<zzg> zzk = zzl();

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4);

            private static final zzfe<zza> zzf = new zzip();
            private final int zzg;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzg;
            }

            public static zzfd zzb() {
                return zzio.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzg = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez<zzb, zza> implements zzgj {
            private static final zzb zzf;
            private static volatile zzgr<zzb> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            private zzb() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            public static final class zza extends zzez.zza<zzb, zza> implements zzgj {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(zzil zzilVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzc$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zzb> zzgrVar;
                zzil zzilVar = null;
                switch (zzil.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzilVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                    case 4:
                        return zzf;
                    case 5:
                        zzgr<zzb> zzgrVar2 = zzg;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zzb.class) {
                            zzgr<zzb> zzgrVar3 = zzg;
                            zzgrVar = zzgrVar3;
                            if (zzgrVar3 == null) {
                                ?? zzcVar = new zzez.zzc(zzf);
                                zzg = zzcVar;
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
                zzf = zzbVar;
                zzez.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzd extends zzez<zzd, zza> implements zzgj {
            private static final zzd zzg;
            private static volatile zzgr<zzd> zzh;
            private int zzc;
            private zzb zzd;
            private zzb zze;
            private boolean zzf;

            private zzd() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            public static final class zza extends zzez.zza<zzd, zza> implements zzgj {
                private zza() {
                    super(zzd.zzg);
                }

                /* synthetic */ zza(zzil zzilVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzc$zzd>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zzd> zzgrVar;
                zzil zzilVar = null;
                switch (zzil.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzilVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzgr<zzd> zzgrVar2 = zzh;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zzd.class) {
                            zzgr<zzd> zzgrVar3 = zzh;
                            zzgrVar = zzgrVar3;
                            if (zzgrVar3 == null) {
                                ?? zzcVar = new zzez.zzc(zzg);
                                zzh = zzcVar;
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
                zzd zzdVar = new zzd();
                zzg = zzdVar;
                zzez.zza((Class<zzd>) zzd.class, zzdVar);
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zze implements zzfb {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);

            private static final zzfe<zze> zzg = new zzir();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzh;
            }

            public static zzfd zzb() {
                return zziq.zza;
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

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzij$zzc$zzc, reason: collision with other inner class name */
        public static final class C0047zzc extends zzez.zza<zzc, C0047zzc> implements zzgj {
            private C0047zzc() {
                super(zzc.zzm);
            }

            /* synthetic */ C0047zzc(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v23, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzc>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzc> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new C0047zzc(zzilVar);
                case 3:
                    return zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zze.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzg.class, "zzl"});
                case 4:
                    return zzm;
                case 5:
                    zzgr<zzc> zzgrVar2 = zzn;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzc.class) {
                        zzgr<zzc> zzgrVar3 = zzn;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzm);
                            zzn = zzcVar;
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
            zzc zzcVar = new zzc();
            zzm = zzcVar;
            zzez.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzd extends zzez<zzd, zza> implements zzgj {
        private static final zzd zzk;
        private static volatile zzgr<zzd> zzl;
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

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzd, zza> implements zzgj {
            private zza() {
                super(zzd.zzk);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzd>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzd> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgr<zzd> zzgrVar2 = zzl;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzd.class) {
                        zzgr<zzd> zzgrVar3 = zzl;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzk);
                            zzl = zzcVar;
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
            zzd zzdVar = new zzd();
            zzk = zzdVar;
            zzez.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zze extends zzez<zze, zza> implements zzgj {
        private static final zze zze;
        private static volatile zzgr<zze> zzf;
        private int zzc;
        private int zzd;

        private zze() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zze, zza> implements zzgj {
            private zza() {
                super(zze.zze);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zze>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zze> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzgr<zze> zzgrVar2 = zzf;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zze.class) {
                        zzgr<zze> zzgrVar3 = zzf;
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

        static {
            zze zzeVar = new zze();
            zze = zzeVar;
            zzez.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzf extends zzez<zzf, zza> implements zzgj {
        private static final zzf zzo;
        private static volatile zzgr<zzf> zzp;
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

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzf, zza> implements zzgj {
            private zza() {
                super(zzf.zzo);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v20, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzf>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzf> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzg", zzit.zzb(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzf"});
                case 4:
                    return zzo;
                case 5:
                    zzgr<zzf> zzgrVar2 = zzp;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzf.class) {
                        zzgr<zzf> zzgrVar3 = zzp;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzo);
                            zzp = zzcVar;
                            zzgrVar = zzcVar;
                        }
                    }
                    return zzgrVar;
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
            zzez.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzg extends zzez<zzg, zza> implements zzgj {
        private static final zzg zzd;
        private static volatile zzgr<zzg> zze;
        private zzfg zzc = zzk();

        private zzg() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzg, zza> implements zzgj {
            private zza() {
                super(zzg.zzd);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzg>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzg> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", new Object[]{"zzc"});
                case 4:
                    return zzd;
                case 5:
                    zzgr<zzg> zzgrVar2 = zze;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzg.class) {
                        zzgr<zzg> zzgrVar3 = zze;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzd);
                            zze = zzcVar;
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
            zzg zzgVar = new zzg();
            zzd = zzgVar;
            zzez.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzh extends zzez<zzh, zza> implements zzgj {
        private static final zzh zzf;
        private static volatile zzgr<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        private zzh() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzh, zza> implements zzgj {
            private zza() {
                super(zzh.zzf);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzh>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzh> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzh> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzh.class) {
                        zzgr<zzh> zzgrVar3 = zzg;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzf);
                            zzg = zzcVar;
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
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzez.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzi extends zzez<zzi, zzb> implements zzgj {
        private static final zzi zzd;
        private static volatile zzgr<zzi> zze;
        private zzfi<zza> zzc = zzl();

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0048zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zze;
            private long zzg;
            private String zzd = "";
            private String zzf = "";

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzij$zzi$zza$zza, reason: collision with other inner class name */
            public static final class C0048zza extends zzez.zza<zza, C0048zza> implements zzgj {
                private C0048zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0048zza(zzil zzilVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzi$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                zzil zzilVar = null;
                switch (zzil.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0048zza(zzilVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgr<zza> zzgrVar2 = zzi;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zza.class) {
                            zzgr<zza> zzgrVar3 = zzi;
                            zzgrVar = zzgrVar3;
                            if (zzgrVar3 == null) {
                                ?? zzcVar = new zzez.zzc(zzh);
                                zzi = zzcVar;
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
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzez.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzi() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzi, zzb> implements zzgj {
            private zzb() {
                super(zzi.zzd);
            }

            /* synthetic */ zzb(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzi>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzi> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(zzilVar);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zza.class});
                case 4:
                    return zzd;
                case 5:
                    zzgr<zzi> zzgrVar2 = zze;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzi.class) {
                        zzgr<zzi> zzgrVar3 = zze;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzd);
                            zze = zzcVar;
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
            zzi zziVar = new zzi();
            zzd = zziVar;
            zzez.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzj extends zzez<zzj, zzb> implements zzgj {
        private static final zzj zzg;
        private static volatile zzgr<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3);

            private static final zzfe<zza> zze = new zziw();
            private final int zzf;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzf;
            }

            public static zzfd zzb() {
                return zziv.zza;
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

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzj, zzb> implements zzgj {
            private zzb() {
                super(zzj.zzg);
            }

            /* synthetic */ zzb(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzj>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzj> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb(zzilVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzj> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzj.class) {
                        zzgr<zzj> zzgrVar3 = zzh;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzg);
                            zzh = zzcVar;
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
            zzj zzjVar = new zzj();
            zzg = zzjVar;
            zzez.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzk extends zzez.zze<zzk, zza> implements zzgj {
        private static final zzk zze;
        private static volatile zzgr<zzk> zzf;
        private byte zzd = 2;

        private zzk() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zzb<zzk, zza> implements zzgj {
            private zza() {
                super(zzk.zze);
            }

            /* synthetic */ zza(zzil zzilVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v12, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzij$zzk>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzk> zzgrVar;
            zzil zzilVar = null;
            switch (zzil.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzilVar);
                case 3:
                    return zza(zze, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zze;
                case 5:
                    zzgr<zzk> zzgrVar2 = zzf;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzk.class) {
                        zzgr<zzk> zzgrVar3 = zzf;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zze);
                            zzf = zzcVar;
                            zzgrVar = zzcVar;
                        }
                    }
                    return zzgrVar;
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
            zzez.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }
}
