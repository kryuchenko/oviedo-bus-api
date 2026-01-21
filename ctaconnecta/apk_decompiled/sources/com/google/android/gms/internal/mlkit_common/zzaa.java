package com.google.android.gms.internal.mlkit_common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.mlkit_common.zzck;
import com.google.android.gms.internal.mlkit_common.zzez;
import com.google.android.gms.internal.mlkit_common.zzij;
import com.google.api.client.http.HttpStatusCodes;
import kotlin.text.Typography;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzaa {

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zza extends zzez<zza, zzb> implements zzgj {
        private static final zza zzg;
        private static volatile zzgr<zza> zzh;
        private int zzc;
        private C0029zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zza$zza, reason: collision with other inner class name */
        public static final class C0029zza extends zzez<C0029zza, C0030zza> implements zzgj {
            private static final C0029zza zzh;
            private static volatile zzgr<C0029zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            private C0029zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zza$zza$zza, reason: collision with other inner class name */
            public static final class C0030zza extends zzez.zza<C0029zza, C0030zza> implements zzgj {
                private C0030zza() {
                    super(C0029zza.zzh);
                }

                /* synthetic */ C0030zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<C0029zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new C0029zza();
                    case 2:
                        return new C0030zza(zzacVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgr<C0029zza> zzgrVar2 = zzi;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (C0029zza.class) {
                            zzgr<C0029zza> zzgrVar3 = zzi;
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
                C0029zza c0029zza = new C0029zza();
                zzh = c0029zza;
                zzez.zza((Class<C0029zza>) C0029zza.class, c0029zza);
            }
        }

        private zza() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zza, zzb> implements zzgj {
            private zzb() {
                super(zza.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zza> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zza> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zza.class) {
                        zzgr<zza> zzgrVar3 = zzh;
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
            zza zzaVar = new zza();
            zzg = zzaVar;
            zzez.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzaa, reason: collision with other inner class name */
    public static final class C0031zzaa extends zzez<C0031zzaa, zza> implements zzgj {
        private static final C0031zzaa zzf;
        private static volatile zzgr<C0031zzaa> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        private C0031zzaa() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzaa$zza */
        public static final class zza extends zzez.zza<C0031zzaa, zza> implements zzgj {
            private zza() {
                super(C0031zzaa.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaa>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<C0031zzaa> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new C0031zzaa();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzc", "zzd", zzal.zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<C0031zzaa> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (C0031zzaa.class) {
                        zzgr<C0031zzaa> zzgrVar3 = zzg;
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
            C0031zzaa c0031zzaa = new C0031zzaa();
            zzf = c0031zzaa;
            zzez.zza((Class<C0031zzaa>) C0031zzaa.class, c0031zzaa);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzab extends zzez<zzab, zza> implements zzgj {
        private static final zzab zzj;
        private static volatile zzgr<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        private zzab() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzab, zza> implements zzgj {
            private zza() {
                super(zzab.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzab>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzab> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzab> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzab.class) {
                        zzgr<zzab> zzgrVar3 = zzk;
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
            zzab zzabVar = new zzab();
            zzj = zzabVar;
            zzez.zza((Class<zzab>) zzab.class, zzabVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzac extends zzez<zzac, zzb> implements zzgj {
        private static final zzac zzj;
        private static volatile zzgr<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);

            private static final zzfe<zza> zzd = new com.google.android.gms.internal.mlkit_common.zzas();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzar.zza;
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
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);

            private static final zzfe<zzc> zzd = new com.google.android.gms.internal.mlkit_common.zzat();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzau.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzd implements zzfb {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);

            private static final zzfe<zzd> zzd = new com.google.android.gms.internal.mlkit_common.zzaw();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzav.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzd(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zze implements zzfb {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);

            private static final zzfe<zze> zzd = new com.google.android.gms.internal.mlkit_common.zzax();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzay.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zze(int i) {
                this.zze = i;
            }
        }

        private zzac() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzac, zzb> implements zzgj {
            private zzb() {
                super(zzac.zzj);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r6v21, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzac>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzac> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zza.zzb(), "zzf", zze.zzb(), "zzg", zzc.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzac> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzac.class) {
                        zzgr<zzac> zzgrVar3 = zzk;
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
            zzac zzacVar = new zzac();
            zzj = zzacVar;
            zzez.zza((Class<zzac>) zzac.class, zzacVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzad extends zzez.zze<zzad, zza> implements zzgj {
        private static final zzad zzbd;
        private static volatile zzgr<zzad> zzbe;
        private zzp zzaa;
        private zzm zzab;
        private zzo zzac;
        private zzr zzad;
        private zzq zzae;
        private zzs zzaf;
        private zzt zzag;
        private zzu zzah;
        private zzv zzai;
        private zzw zzaj;
        private zzj zzak;
        private zzl zzal;
        private zzk zzam;
        private zzah zzan;
        private C0031zzaa zzao;
        private zza zzap;
        private zzb zzaq;
        private zzd zzar;
        private zzc zzas;
        private zze zzat;
        private zzf zzau;
        private zzi zzav;
        private zzg zzaw;
        private zzh zzax;
        private zzbf zzaz;
        private zzag zzba;
        private zzaj zzbb;
        private int zzd;
        private int zze;
        private zzbg zzf;
        private int zzg;
        private boolean zzh;
        private zzak zzi;
        private zzz zzj;
        private zzy zzk;
        private zzx zzl;
        private zzap zzm;
        private zzbd zzn;
        private zzao zzo;
        private zzaq zzp;
        private zzas zzq;
        private zzar zzr;
        private zzav zzs;
        private zzay zzt;
        private zzax zzu;
        private zzaz zzv;
        private zzbb zzw;
        private zzbc zzx;
        private zzau zzy;
        private zzbe zzz;
        private byte zzbc = 2;
        private zzfi<zzij.zzf> zzay = zzl();

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zzb<zzad, zza> implements zzgj {
            private zza() {
                super(zzad.zzbd);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }

            public final zzbg zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzbg.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbg) ((zzez) zzaVar.zzh()));
                return this;
            }

            public final zza zza(com.google.android.gms.internal.mlkit_common.zzap zzapVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzapVar);
                return this;
            }

            public final zza zza(zzak.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzak) ((zzez) zzaVar.zzh()));
                return this;
            }

            public final zza zza(zzaj.zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzaj) ((zzez) zzbVar.zzh()));
                return this;
            }
        }

        static {
            zzad zzadVar = new zzad();
            zzbd = zzadVar;
            zzez.zza((Class<zzad>) zzad.class, zzadVar);
        }

        private zzad() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static zza zza(zzad zzadVar) {
            return (zza) zzbd.zza(zzadVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzaj zzajVar) {
            zzajVar.getClass();
            this.zzbb = zzajVar;
            this.zze |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzak zzakVar) {
            zzakVar.getClass();
            this.zzi = zzakVar;
            this.zzd |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzf = zzbgVar;
            this.zzd |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(com.google.android.gms.internal.mlkit_common.zzap zzapVar) {
            this.zzg = zzapVar.zza();
            this.zzd |= 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbg zza() {
            zzbg zzbgVar = this.zzf;
            return zzbgVar == null ? zzbg.zzc() : zzbgVar;
        }

        /* JADX WARN: Type inference failed for: r3v61, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzad>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzad> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzbd, "\u00011\u0000\u0002\u000131\u0000\u0001\u0001\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0003\u0004ဉ\u0005\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဉ\u0015\tဉ\u0016\nဉ\u0017\u000bဉ\u0018\fဉ\u0019\rဉ\u001a\u000eဉ\u001b\u000fဉ\u001c\u0010ဉ\u001d\u0011ဉ\u001e\u0012ဉ\f\u0013ဉ\u0012\u0014ဉ\u0004\u0015ဉ\u0013\u0016ဉ\u0014\u0017ဉ\u001f\u0018ဉ \u0019ဉ!\u001aဉ\r\u001bဉ\u000e\u001cဉ\u000f\u001dဉ\u0006\u001eဉ$\u001fဉ% ဉ&!ဉ'\"ဉ(#ဉ)$ဉ*%ဇ\u0002'ဉ\"(ဉ#)Л*ဉ-,ဉ\u0010-ဉ\u0011.ဉ+/ဉ,0ဉ\n1ဉ\u000b2ဉ.3ဉ/", new Object[]{"zzd", "zze", "zzf", "zzg", com.google.android.gms.internal.mlkit_common.zzap.zzb(), "zzi", "zzk", "zzm", "zzn", "zzo", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzr", "zzx", "zzj", "zzy", "zzz", "zzak", "zzal", "zzam", "zzs", "zzt", "zzu", "zzl", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzh", "zzan", "zzao", "zzay", zzij.zzf.class, "zzaz", "zzv", "zzw", "zzaw", "zzax", "zzp", "zzq", "zzba", "zzbb"});
                case 4:
                    return zzbd;
                case 5:
                    zzgr<zzad> zzgrVar2 = zzbe;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzad.class) {
                        zzgr<zzad> zzgrVar3 = zzbe;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzbd);
                            zzbe = zzcVar;
                            zzgrVar = zzcVar;
                        }
                    }
                    return zzgrVar;
                case 6:
                    return Byte.valueOf(this.zzbc);
                case 7:
                    this.zzbc = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzae extends zzez<zzae, zzb> implements zzgj {
        private static final zzae zzg;
        private static volatile zzgr<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);

            private static final zzfe<zza> zzj = new com.google.android.gms.internal.mlkit_common.zzba();
            private final int zzk;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzk;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzaz.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzk = i;
            }
        }

        private zzae() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzae, zzb> implements zzgj {
            private zzb() {
                super(zzae.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzae>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzae> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzae> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzae.class) {
                        zzgr<zzae> zzgrVar3 = zzh;
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
            zzae zzaeVar = new zzae();
            zzg = zzaeVar;
            zzez.zza((Class<zzae>) zzae.class, zzaeVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzaf extends zzez<zzaf, zza> implements zzgj {
        private static final zzaf zzk;
        private static volatile zzgr<zzaf> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;

        private zzaf() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzaf, zza> implements zzgj {
            private zza() {
                super(zzaf.zzk);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaf>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzaf> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzaf();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgr<zzaf> zzgrVar2 = zzl;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzaf.class) {
                        zzgr<zzaf> zzgrVar3 = zzl;
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
            zzaf zzafVar = new zzaf();
            zzk = zzafVar;
            zzez.zza((Class<zzaf>) zzaf.class, zzafVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzag extends zzez<zzag, zza> implements zzgj {
        private static final zzag zzk;
        private static volatile zzgr<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzb implements zzfb {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);

            private static final zzfe<zzb> zzg = new com.google.android.gms.internal.mlkit_common.zzbb();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzh;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzbc.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzh = i;
            }
        }

        private zzag() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzag, zza> implements zzgj {
            private zza() {
                super(zzag.zzk);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v19, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzag>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzag> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzag();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", zzb.zzb(), "zzf", zzae.zza.zzb(), "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgr<zzag> zzgrVar2 = zzl;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzag.class) {
                        zzgr<zzag> zzgrVar3 = zzl;
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
            zzag zzagVar = new zzag();
            zzk = zzagVar;
            zzez.zza((Class<zzag>) zzag.class, zzagVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzah extends zzez<zzah, zza> implements zzgj {
        private static final zzah zzf;
        private static volatile zzgr<zzah> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        private zzah() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzah, zza> implements zzgj {
            private zza() {
                super(zzah.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzah>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzah> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzah();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzc", "zzd", zzal.zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzah> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzah.class) {
                        zzgr<zzah> zzgrVar3 = zzg;
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
            zzah zzahVar = new zzah();
            zzf = zzahVar;
            zzez.zza((Class<zzah>) zzah.class, zzahVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzai extends zzez<zzai, zza> implements zzgj {
        private static final zzai zzg;
        private static volatile zzgr<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        private zzai() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzai, zza> implements zzgj {
            private zza() {
                super(zzai.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzai>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzai> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzai();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzai> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzai.class) {
                        zzgr<zzai> zzgrVar3 = zzh;
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
            zzai zzaiVar = new zzai();
            zzg = zzaiVar;
            zzez.zza((Class<zzai>) zzai.class, zzaiVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzan extends zzez<zzan, zzb> implements zzgj {
        private static final zzan zzh;
        private static volatile zzgr<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);

            private static final zzfe<zza> zzh = new zzbm();
            private final int zzi;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzi;
            }

            public static zzfd zzb() {
                return zzbl.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzi = i;
            }
        }

        private zzan() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzan, zzb> implements zzgj {
            private zzb() {
                super(zzan.zzh);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzan>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzan> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzan();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgr<zzan> zzgrVar2 = zzi;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzan.class) {
                        zzgr<zzan> zzgrVar3 = zzi;
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
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zzez.zza((Class<zzan>) zzan.class, zzanVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzao extends zzez<zzao, zzc> implements zzgj {
        private static final zzff<Integer, zza> zzg = new zzbn();
        private static final zzff<Integer, zzb> zzi = new zzbo();
        private static final zzao zzk;
        private static volatile zzgr<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzck.zza zze;
        private zzfg zzf = zzk();
        private zzfg zzh = zzk();
        private zzae zzj;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            FORMAT_UNKNOWN(0),
            FORMAT_CODE_128(1),
            FORMAT_CODE_39(2),
            FORMAT_CODE_93(4),
            FORMAT_CODABAR(8),
            FORMAT_DATA_MATRIX(16),
            FORMAT_EAN_13(32),
            FORMAT_EAN_8(64),
            FORMAT_ITF(128),
            FORMAT_QR_CODE(256),
            FORMAT_UPC_A(512),
            FORMAT_UPC_E(1024),
            FORMAT_PDF417(2048),
            FORMAT_AZTEC(4096);

            private static final zzfe<zza> zzo = new zzbq();
            private final int zzp;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzp;
            }

            public static zzfd zzb() {
                return zzbp.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzp = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzb implements zzfb {
            TYPE_UNKNOWN(0),
            TYPE_CONTACT_INFO(1),
            TYPE_EMAIL(2),
            TYPE_ISBN(3),
            TYPE_PHONE(4),
            TYPE_PRODUCT(5),
            TYPE_SMS(6),
            TYPE_TEXT(7),
            TYPE_URL(8),
            TYPE_WIFI(9),
            TYPE_GEO(10),
            TYPE_CALENDAR_EVENT(11),
            TYPE_DRIVER_LICENSE(12);

            private static final zzfe<zzb> zzn = new zzbr();
            private final int zzo;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzo;
            }

            public static zzfd zzb() {
                return zzbs.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzo = i;
            }
        }

        private zzao() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzc extends zzez.zza<zzao, zzc> implements zzgj {
            private zzc() {
                super(zzao.zzk);
            }

            /* synthetic */ zzc(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v16, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzao>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzao> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzao();
                case 2:
                    return new zzc(zzacVar);
                case 3:
                    return zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.zzb(), "zzh", zzb.zzb(), "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgr<zzao> zzgrVar2 = zzl;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzao.class) {
                        zzgr<zzao> zzgrVar3 = zzl;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzbn, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzbo, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zzb>] */
        static {
            zzao zzaoVar = new zzao();
            zzk = zzaoVar;
            zzez.zza((Class<zzao>) zzao.class, zzaoVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzap extends zzez<zzap, zza> implements zzgj {
        private static final zzap zzj;
        private static volatile zzgr<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzck.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        private zzap() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzap, zza> implements zzgj {
            private zza() {
                super(zzap.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzap>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzap> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzap();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzap> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzap.class) {
                        zzgr<zzap> zzgrVar3 = zzk;
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
            zzap zzapVar = new zzap();
            zzj = zzapVar;
            zzez.zza((Class<zzap>) zzap.class, zzapVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzaq extends zzez<zzaq, zza> implements zzgj {
        private static final zzaq zzf;
        private static volatile zzgr<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        private zzaq() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzaq, zza> implements zzgj {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaq>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzaq> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzaq();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_common.zzal.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzaq> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzaq.class) {
                        zzgr<zzaq> zzgrVar3 = zzg;
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
            zzaq zzaqVar = new zzaq();
            zzf = zzaqVar;
            zzez.zza((Class<zzaq>) zzaq.class, zzaqVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzar extends zzez<zzar, zza> implements zzgj {
        private static final zzar zzi;
        private static volatile zzgr<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        private zzar() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzar, zza> implements zzgj {
            private zza() {
                super(zzar.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzar>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzar> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzar();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgr<zzar> zzgrVar2 = zzj;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzar.class) {
                        zzgr<zzar> zzgrVar3 = zzj;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzi);
                            zzj = zzcVar;
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
            zzar zzarVar = new zzar();
            zzi = zzarVar;
            zzez.zza((Class<zzar>) zzar.class, zzarVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzas extends zzez<zzas, zza> implements zzgj {
        private static final zzff<Integer, com.google.android.gms.internal.mlkit_common.zzal> zzf = new zzbt();
        private static final zzas zzi;
        private static volatile zzgr<zzas> zzj;
        private int zzc;
        private zzat zzd;
        private zzfg zze = zzk();
        private long zzg;
        private long zzh;

        private zzas() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzas, zza> implements zzgj {
            private zza() {
                super(zzas.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzas>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzas> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzas();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgr<zzas> zzgrVar2 = zzj;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzas.class) {
                        zzgr<zzas> zzgrVar3 = zzj;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzi);
                            zzj = zzcVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzbt, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzal>] */
        static {
            zzas zzasVar = new zzas();
            zzi = zzasVar;
            zzez.zza((Class<zzas>) zzas.class, zzasVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzat extends zzez<zzat, zza> implements zzgj {
        private static final zzat zzg;
        private static volatile zzgr<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        private zzat() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzat, zza> implements zzgj {
            private zza() {
                super(zzat.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzat>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzat> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzat();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzat> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzat.class) {
                        zzgr<zzat> zzgrVar3 = zzh;
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
            zzat zzatVar = new zzat();
            zzg = zzatVar;
            zzez.zza((Class<zzat>) zzat.class, zzatVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzau extends zzez<zzau, zzb> implements zzgj {
        private static final zzau zzh;
        private static volatile zzgr<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0033zza> implements zzgj {
            private static final zza zzf;
            private static volatile zzgr<zza> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza$zza, reason: collision with other inner class name */
            public static final class C0033zza extends zzez.zza<zza, C0033zza> implements zzgj {
                private C0033zza() {
                    super(zza.zzf);
                }

                /* synthetic */ C0033zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0033zza(zzacVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
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
        public static final class zzc extends zzez<zzc, zza> implements zzgj {
            private static final zzc zze;
            private static volatile zzgr<zzc> zzf;
            private int zzc;
            private zza zzd;

            private zzc() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            public static final class zza extends zzez.zza<zzc, zza> implements zzgj {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zzc> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zzacVar);
                    case 3:
                        return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzgr<zzc> zzgrVar2 = zzf;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zzc.class) {
                            zzgr<zzc> zzgrVar3 = zzf;
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
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzez.zza((Class<zzc>) zzc.class, zzcVar);
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzd extends zzez<zzd, zza> implements zzgj {
            private static final zzd zzd;
            private static volatile zzgr<zzd> zze;
            private zzfi<zza> zzc = zzl();

            private zzd() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            public static final class zza extends zzez.zza<zzd, zza> implements zzgj {
                private zza() {
                    super(zzd.zzd);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zzd> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzacVar);
                    case 3:
                        return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zza.class});
                    case 4:
                        return zzd;
                    case 5:
                        zzgr<zzd> zzgrVar2 = zze;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zzd.class) {
                            zzgr<zzd> zzgrVar3 = zze;
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
                zzd zzdVar = new zzd();
                zzd = zzdVar;
                zzez.zza((Class<zzd>) zzd.class, zzdVar);
            }
        }

        private zzau() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzau, zzb> implements zzgj {
            private zzb() {
                super(zzau.zzh);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzau> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzau();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgr<zzau> zzgrVar2 = zzi;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzau.class) {
                        zzgr<zzau> zzgrVar3 = zzi;
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
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zzez.zza((Class<zzau>) zzau.class, zzauVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzav extends zzez<zzav, zza> implements zzgj {
        private static final zzav zzf;
        private static volatile zzgr<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        private zzav() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzav, zza> implements zzgj {
            private zza() {
                super(zzav.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzav>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzav> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzav();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_common.zzal.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzav> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzav.class) {
                        zzgr<zzav> zzgrVar3 = zzg;
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
            zzav zzavVar = new zzav();
            zzf = zzavVar;
            zzez.zza((Class<zzav>) zzav.class, zzavVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzaw extends zzez<zzaw, zzb> implements zzgj {
        private static final zzaw zzj;
        private static volatile zzgr<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);

            private static final zzfe<zza> zzd = new zzbv();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return zzbu.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zze = i;
            }
        }

        private zzaw() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzaw, zzb> implements zzgj {
            private zzb() {
                super(zzaw.zzj);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaw>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzaw> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzaw();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzaw> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzaw.class) {
                        zzgr<zzaw> zzgrVar3 = zzk;
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
            zzaw zzawVar = new zzaw();
            zzj = zzawVar;
            zzez.zza((Class<zzaw>) zzaw.class, zzawVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzax extends zzez<zzax, zza> implements zzgj {
        private static final zzax zzh;
        private static volatile zzgr<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzfi<zzan> zzg = zzl();

        private zzax() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzax, zza> implements zzgj {
            private zza() {
                super(zzax.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzax>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzax> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzax();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzan.class});
                case 4:
                    return zzh;
                case 5:
                    zzgr<zzax> zzgrVar2 = zzi;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzax.class) {
                        zzgr<zzax> zzgrVar3 = zzi;
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
            zzax zzaxVar = new zzax();
            zzh = zzaxVar;
            zzez.zza((Class<zzax>) zzax.class, zzaxVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzay extends zzez<zzay, zza> implements zzgj {
        private static final zzay zzh;
        private static volatile zzgr<zzay> zzi;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;

        private zzay() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzay, zza> implements zzgj {
            private zza() {
                super(zzay.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzay>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzay> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzay();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgr<zzay> zzgrVar2 = zzi;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzay.class) {
                        zzgr<zzay> zzgrVar3 = zzi;
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
            zzay zzayVar = new zzay();
            zzh = zzayVar;
            zzez.zza((Class<zzay>) zzay.class, zzayVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzaz extends zzez<zzaz, zza> implements zzgj {
        private static final zzaz zzg;
        private static volatile zzgr<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        private zzaz() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzaz, zza> implements zzgj {
            private zza() {
                super(zzaz.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaz>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzaz> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzaz();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzaz> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzaz.class) {
                        zzgr<zzaz> zzgrVar3 = zzh;
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
            zzaz zzazVar = new zzaz();
            zzg = zzazVar;
            zzez.zza((Class<zzaz>) zzaz.class, zzazVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzb extends zzez<zzb, C0035zzb> implements zzgj {
        private static final zzb zzg;
        private static volatile zzgr<zzb> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0034zza> implements zzgj {
            private static final zza zzi;
            private static volatile zzgr<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzfi<zzy.zza> zzf = zzl();
            private zzfi<zzy.zza> zzg = zzl();
            private zzam zzh;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza$zza, reason: collision with other inner class name */
            public static final class C0034zza extends zzez.zza<zza, C0034zza> implements zzgj {
                private C0034zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0034zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0034zza(zzacVar);
                    case 3:
                        return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", zzy.zza.class, "zzg", zzy.zza.class, "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzgr<zza> zzgrVar2 = zzj;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zza.class) {
                            zzgr<zza> zzgrVar3 = zzj;
                            zzgrVar = zzgrVar3;
                            if (zzgrVar3 == null) {
                                ?? zzcVar = new zzez.zzc(zzi);
                                zzj = zzcVar;
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
                zzi = zzaVar;
                zzez.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzb$zzb, reason: collision with other inner class name */
        public static final class C0035zzb extends zzez.zza<zzb, C0035zzb> implements zzgj {
            private C0035zzb() {
                super(zzb.zzg);
            }

            /* synthetic */ C0035zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzb> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0035zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzb> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzb.class) {
                        zzgr<zzb> zzgrVar3 = zzh;
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
            zzb zzbVar = new zzb();
            zzg = zzbVar;
            zzez.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzba extends zzez<zzba, zza> implements zzgj {
        private static final zzba zzf;
        private static volatile zzgr<zzba> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzb implements zzfb {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);

            private static final zzfe<zzb> zzd = new zzbw();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return zzbx.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzc implements zzfb {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);

            private static final zzfe<zzc> zzd = new zzbz();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return zzby.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zze = i;
            }
        }

        private zzba() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzba, zza> implements zzgj {
            private zza() {
                super(zzba.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzba>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzba> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzba();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzc.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzba> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzba.class) {
                        zzgr<zzba> zzgrVar3 = zzg;
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
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzez.zza((Class<zzba>) zzba.class, zzbaVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbb extends zzez<zzbb, zza> implements zzgj {
        private static final zzbb zzf;
        private static volatile zzgr<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        private zzbb() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzbb, zza> implements zzgj {
            private zza() {
                super(zzbb.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbb>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbb> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbb();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzbb> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbb.class) {
                        zzgr<zzbb> zzgrVar3 = zzg;
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
            zzbb zzbbVar = new zzbb();
            zzf = zzbbVar;
            zzez.zza((Class<zzbb>) zzbb.class, zzbbVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbc extends zzez<zzbc, zza> implements zzgj {
        private static final zzbc zzi;
        private static volatile zzgr<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzfi<zzc> zze = zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzb implements zzfb {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);

            private static final zzfe<zzb> zzh = new zzca();
            private final int zzi;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzi;
            }

            public static zzfd zzb() {
                return zzcb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzi = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzc extends zzez<zzc, zza> implements zzgj {
            private static final zzc zze;
            private static volatile zzgr<zzc> zzf;
            private int zzc;
            private float zzd;

            private zzc() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            public static final class zza extends zzez.zza<zzc, zza> implements zzgj {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zzc> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zzacVar);
                    case 3:
                        return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzgr<zzc> zzgrVar2 = zzf;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zzc.class) {
                            zzgr<zzc> zzgrVar3 = zzf;
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
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzez.zza((Class<zzc>) zzc.class, zzcVar);
            }
        }

        private zzbc() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzbc, zza> implements zzgj {
            private zza() {
                super(zzbc.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbc> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbc();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzc.class, "zzf", zzb.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgr<zzbc> zzgrVar2 = zzj;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbc.class) {
                        zzgr<zzbc> zzgrVar3 = zzj;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzi);
                            zzj = zzcVar;
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
            zzbc zzbcVar = new zzbc();
            zzi = zzbcVar;
            zzez.zza((Class<zzbc>) zzbc.class, zzbcVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbd extends zzez<zzbd, zza> implements zzgj {
        private static final zzbd zzf;
        private static volatile zzgr<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        private zzbd() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzbd, zza> implements zzgj {
            private zza() {
                super(zzbd.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbd>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbd> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbd();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzbd> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbd.class) {
                        zzgr<zzbd> zzgrVar3 = zzg;
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
            zzbd zzbdVar = new zzbd();
            zzf = zzbdVar;
            zzez.zza((Class<zzbd>) zzbd.class, zzbdVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbe extends zzez<zzbe, zzb> implements zzgj {
        private static final zzbe zzl;
        private static volatile zzgr<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbh zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            NO_ERROR(0),
            METADATA_FILE_UNAVAILABLE(1),
            METADATA_ENTRY_NOT_FOUND(2),
            METADATA_JSON_INVALID(3),
            METADATA_HASH_NOT_FOUND(4),
            DOWNLOAD_MANAGER_SERVICE_MISSING(5),
            DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS(6),
            DOWNLOAD_MANAGER_HTTP_BAD_REQUEST(400),
            DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED(401),
            DOWNLOAD_MANAGER_HTTP_FORBIDDEN(403),
            DOWNLOAD_MANAGER_HTTP_NOT_FOUND(HttpStatusCodes.STATUS_CODE_NOT_FOUND),
            DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT(408),
            DOWNLOAD_MANAGER_HTTP_ABORTED(HttpStatusCodes.STATUS_CODE_CONFLICT),
            DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS(429),
            DOWNLOAD_MANAGER_HTTP_CANCELLED(499),
            DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED(TypedValues.PositionType.TYPE_TRANSITION_EASING),
            DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR(500),
            DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE(503),
            DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED(TypedValues.PositionType.TYPE_PERCENT_HEIGHT),
            DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED(FrameMetricsAggregator.EVERY_DURATION),
            DOWNLOAD_MANAGER_FILE_ERROR(7),
            DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE(8),
            DOWNLOAD_MANAGER_HTTP_DATA_ERROR(9),
            DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS(10),
            DOWNLOAD_MANAGER_INSUFFICIENT_SPACE(11),
            DOWNLOAD_MANAGER_DEVICE_NOT_FOUND(12),
            DOWNLOAD_MANAGER_CANNOT_RESUME(13),
            DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS(14),
            DOWNLOAD_MANAGER_UNKNOWN_ERROR(15),
            POST_DOWNLOAD_FILE_NOT_FOUND(16),
            POST_DOWNLOAD_MOVE_FILE_FAILED(17),
            POST_DOWNLOAD_UNZIP_FAILED(18),
            RAPID_RESPONSE_COULD_NOT_BE_WRITTEN(19),
            DRIVER_OBJECT_DEALLOCATED(20);

            private static final zzfe<zza> zzai = new zzcd();
            private final int zzaj;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzaj;
            }

            public static zzfd zzb() {
                return zzcc.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzaj = i;
            }
        }

        private zzbe() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzbe, zzb> implements zzgj {
            private zzb() {
                super(zzbe.zzl);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbe>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbe> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbe();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zza.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgr<zzbe> zzgrVar2 = zzm;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbe.class) {
                        zzgr<zzbe> zzgrVar3 = zzm;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzl);
                            zzm = zzcVar;
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
            zzbe zzbeVar = new zzbe();
            zzl = zzbeVar;
            zzez.zza((Class<zzbe>) zzbe.class, zzbeVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbf extends zzez<zzbf, zzb> implements zzgj {
        private static final zzff<Integer, zza> zzf = new zzce();
        private static final zzff<Integer, zza> zzh = new zzcg();
        private static final zzff<Integer, zza> zzj = new zzcf();
        private static final zzbf zzl;
        private static volatile zzgr<zzbf> zzm;
        private int zzc;
        private long zzd;
        private zzfg zze = zzk();
        private zzfg zzg = zzk();
        private zzfg zzi = zzk();
        private int zzk;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            UNKNOWN_ERROR(0),
            NO_CONNECTION(1),
            RPC_ERROR(2),
            RPC_RETURNED_INVALID_RESULT(3),
            RPC_RETURNED_MALFORMED_RESULT(4),
            RPC_EXPONENTIAL_BACKOFF_FAILED(5),
            DIRECTORY_CREATION_FAILED(10),
            FILE_WRITE_FAILED_DISK_FULL(11),
            FILE_WRITE_FAILED(12),
            FILE_READ_FAILED(13),
            FILE_READ_RETURNED_INVALID_DATA(14),
            FILE_READ_RETURNED_MALFORMED_DATA(15);

            private static final zzfe<zza> zzm = new zzci();
            private final int zzn;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzn;
            }

            public static zzfd zzb() {
                return zzch.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzn = i;
            }
        }

        private zzbf() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzbf, zzb> implements zzgj {
            private zzb() {
                super(zzbf.zzl);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbf>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbf> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbf();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzg", zza.zzb(), "zzi", zza.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgr<zzbf> zzgrVar2 = zzm;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbf.class) {
                        zzgr<zzbf> zzgrVar3 = zzm;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzl);
                            zzm = zzcVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzce, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzcg, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zza>] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_common.zzcf, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zza>] */
        static {
            zzbf zzbfVar = new zzbf();
            zzl = zzbfVar;
            zzez.zza((Class<zzbf>) zzbf.class, zzbfVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbh extends zzez<zzbh, zza> implements zzgj {
        private static final zzbh zzf;
        private static volatile zzgr<zzbh> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzbh() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzbh, zza> implements zzgj {
            private zza() {
                super(zzbh.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbh>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbh> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbh();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzbh> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbh.class) {
                        zzgr<zzbh> zzgrVar3 = zzg;
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
            zzbh zzbhVar = new zzbh();
            zzf = zzbhVar;
            zzez.zza((Class<zzbh>) zzbh.class, zzbhVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzc extends zzez<zzc, zzb> implements zzgj {
        private static final zzc zzg;
        private static volatile zzgr<zzc> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0036zza> implements zzgj {
            private static final zzff<Integer, zzao.zza> zzj = new com.google.android.gms.internal.mlkit_common.zzae();
            private static final zzff<Integer, zzao.zzb> zzl = new com.google.android.gms.internal.mlkit_common.zzad();
            private static final zza zzm;
            private static volatile zzgr<zza> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzck.zza zzh;
            private zzfg zzi = zzk();
            private zzfg zzk = zzk();

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza$zza, reason: collision with other inner class name */
            public static final class C0036zza extends zzez.zza<zza, C0036zza> implements zzgj {
                private C0036zza() {
                    super(zza.zzm);
                }

                /* synthetic */ C0036zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r5v21, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0036zza(zzacVar);
                    case 3:
                        return zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", zzao.zza.zzb(), "zzk", zzao.zzb.zzb()});
                    case 4:
                        return zzm;
                    case 5:
                        zzgr<zza> zzgrVar2 = zzn;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zza.class) {
                            zzgr<zza> zzgrVar3 = zzn;
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

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzae, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zza>] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzad, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zzb>] */
            static {
                zza zzaVar = new zza();
                zzm = zzaVar;
                zzez.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzc() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzc, zzb> implements zzgj {
            private zzb() {
                super(zzc.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzc> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzc> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzc.class) {
                        zzgr<zzc> zzgrVar3 = zzh;
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
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzez.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzd extends zzez<zzd, zzb> implements zzgj {
        private static final zzd zzg;
        private static volatile zzgr<zzd> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0037zza> implements zzgj {
            private static final zza zzj;
            private static volatile zzgr<zza> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza$zza, reason: collision with other inner class name */
            public static final class C0037zza extends zzez.zza<zza, C0037zza> implements zzgj {
                private C0037zza() {
                    super(zza.zzj);
                }

                /* synthetic */ C0037zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0037zza(zzacVar);
                    case 3:
                        return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
                    case 4:
                        return zzj;
                    case 5:
                        zzgr<zza> zzgrVar2 = zzk;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zza.class) {
                            zzgr<zza> zzgrVar3 = zzk;
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
                zza zzaVar = new zza();
                zzj = zzaVar;
                zzez.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzd, zzb> implements zzgj {
            private zzb() {
                super(zzd.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzd> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
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
    public static final class zze extends zzez<zze, zzb> implements zzgj {
        private static final zze zzg;
        private static volatile zzgr<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0038zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zze$zza$zza, reason: collision with other inner class name */
            public static final class C0038zza extends zzez.zza<zza, C0038zza> implements zzgj {
                private C0038zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0038zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0038zza(zzacVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg"});
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

        private zze() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zze, zzb> implements zzgj {
            private zzb() {
                super(zze.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zze> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zze> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zze.class) {
                        zzgr<zze> zzgrVar3 = zzh;
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
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzez.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzf extends zzez<zzf, zzb> implements zzgj {
        private static final zzf zzg;
        private static volatile zzgr<zzf> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0039zza> implements zzgj {
            private static final zza zzi;
            private static volatile zzgr<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza$zza, reason: collision with other inner class name */
            public static final class C0039zza extends zzez.zza<zza, C0039zza> implements zzgj {
                private C0039zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0039zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0039zza(zzacVar);
                    case 3:
                        return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg", "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzgr<zza> zzgrVar2 = zzj;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zza.class) {
                            zzgr<zza> zzgrVar3 = zzj;
                            zzgrVar = zzgrVar3;
                            if (zzgrVar3 == null) {
                                ?? zzcVar = new zzez.zzc(zzi);
                                zzj = zzcVar;
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
                zzi = zzaVar;
                zzez.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzf, zzb> implements zzgj {
            private zzb() {
                super(zzf.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzf> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzf> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzf.class) {
                        zzgr<zzf> zzgrVar3 = zzh;
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
            zzf zzfVar = new zzf();
            zzg = zzfVar;
            zzez.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzg extends zzez<zzg, zzb> implements zzgj {
        private static final zzg zzg;
        private static volatile zzgr<zzg> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0040zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza$zza, reason: collision with other inner class name */
            public static final class C0040zza extends zzez.zza<zza, C0040zza> implements zzgj {
                private C0040zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0040zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0040zza(zzacVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg"});
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

        private zzg() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzg, zzb> implements zzgj {
            private zzb() {
                super(zzg.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzg> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzg> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzg.class) {
                        zzgr<zzg> zzgrVar3 = zzh;
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
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzez.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzh extends zzez<zzh, zzb> implements zzgj {
        private static final zzh zzg;
        private static volatile zzgr<zzh> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0041zza> implements zzgj {
            private static final zza zzg;
            private static volatile zzgr<zza> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza$zza, reason: collision with other inner class name */
            public static final class C0041zza extends zzez.zza<zza, C0041zza> implements zzgj {
                private C0041zza() {
                    super(zza.zzg);
                }

                /* synthetic */ C0041zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0041zza(zzacVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzgr<zza> zzgrVar2 = zzh;
                        if (zzgrVar2 != null) {
                            return zzgrVar2;
                        }
                        synchronized (zza.class) {
                            zzgr<zza> zzgrVar3 = zzh;
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
                zza zzaVar = new zza();
                zzg = zzaVar;
                zzez.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzh, zzb> implements zzgj {
            private zzb() {
                super(zzh.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzh> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzh> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzh.class) {
                        zzgr<zzh> zzgrVar3 = zzh;
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
            zzh zzhVar = new zzh();
            zzg = zzhVar;
            zzez.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzi extends zzez<zzi, zzb> implements zzgj {
        private static final zzi zzg;
        private static volatile zzgr<zzi> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0042zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza$zza, reason: collision with other inner class name */
            public static final class C0042zza extends zzez.zza<zza, C0042zza> implements zzgj {
                private C0042zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0042zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0042zza(zzacVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zze", "zzf", "zzg"});
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
                super(zzi.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzi> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzi> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzi.class) {
                        zzgr<zzi> zzgrVar3 = zzh;
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
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzez.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzj extends zzez<zzj, zza> implements zzgj {
        private static final zzj zze;
        private static volatile zzgr<zzj> zzf;
        private int zzc;
        private int zzd;

        private zzj() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzj, zza> implements zzgj {
            private zza() {
                super(zzj.zze);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzj>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzj> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_common.zzal.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzgr<zzj> zzgrVar2 = zzf;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzj.class) {
                        zzgr<zzj> zzgrVar3 = zzf;
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
            zzj zzjVar = new zzj();
            zze = zzjVar;
            zzez.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzk extends zzez<zzk, zza> implements zzgj {
        private static final zzk zzi;
        private static volatile zzgr<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        private zzk() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzk, zza> implements zzgj {
            private zza() {
                super(zzk.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzk>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzk> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgr<zzk> zzgrVar2 = zzj;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzk.class) {
                        zzgr<zzk> zzgrVar3 = zzj;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzi);
                            zzj = zzcVar;
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
            zzk zzkVar = new zzk();
            zzi = zzkVar;
            zzez.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzl extends zzez<zzl, zza> implements zzgj {
        private static final zzff<Integer, com.google.android.gms.internal.mlkit_common.zzal> zzg = new com.google.android.gms.internal.mlkit_common.zzaf();
        private static final zzl zzi;
        private static volatile zzgr<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzfg zzf = zzk();
        private long zzh;

        private zzl() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzl, zza> implements zzgj {
            private zza() {
                super(zzl.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzl>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzl> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgr<zzl> zzgrVar2 = zzj;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzl.class) {
                        zzgr<zzl> zzgrVar3 = zzj;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzi);
                            zzj = zzcVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzaf, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzal>] */
        static {
            zzl zzlVar = new zzl();
            zzi = zzlVar;
            zzez.zza((Class<zzl>) zzl.class, zzlVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzm extends zzez<zzm, zza> implements zzgj {
        private static final zzm zzg;
        private static volatile zzgr<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzm() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzm, zza> implements zzgj {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzm>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzm> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzm> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzm.class) {
                        zzgr<zzm> zzgrVar3 = zzh;
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
            zzm zzmVar = new zzm();
            zzg = zzmVar;
            zzez.zza((Class<zzm>) zzm.class, zzmVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzn extends zzez<zzn, zza> implements zzgj {
        private static final zzn zzf;
        private static volatile zzgr<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzb implements zzfb {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);

            private static final zzfe<zzb> zzd = new com.google.android.gms.internal.mlkit_common.zzag();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzah.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zze = i;
            }
        }

        private zzn() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzn, zza> implements zzgj {
            private zza() {
                super(zzn.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzn>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzn> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzb.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzn> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzn.class) {
                        zzgr<zzn> zzgrVar3 = zzg;
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
            zzn zznVar = new zzn();
            zzf = zznVar;
            zzez.zza((Class<zzn>) zzn.class, zznVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzo extends zzez<zzo, zza> implements zzgj {
        private static final zzo zzg;
        private static volatile zzgr<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzo() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzo, zza> implements zzgj {
            private zza() {
                super(zzo.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzo>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzo> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzo> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzo.class) {
                        zzgr<zzo> zzgrVar3 = zzh;
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
            zzo zzoVar = new zzo();
            zzg = zzoVar;
            zzez.zza((Class<zzo>) zzo.class, zzoVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzp extends zzez<zzp, zza> implements zzgj {
        private static final zzp zzg;
        private static volatile zzgr<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzp() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzp, zza> implements zzgj {
            private zza() {
                super(zzp.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzp>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzp> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzp> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzp.class) {
                        zzgr<zzp> zzgrVar3 = zzh;
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
            zzp zzpVar = new zzp();
            zzg = zzpVar;
            zzez.zza((Class<zzp>) zzp.class, zzpVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzq extends zzez<zzq, zza> implements zzgj {
        private static final zzq zzg;
        private static volatile zzgr<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzq() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzq, zza> implements zzgj {
            private zza() {
                super(zzq.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzq>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzq> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzq> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzq.class) {
                        zzgr<zzq> zzgrVar3 = zzh;
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
            zzq zzqVar = new zzq();
            zzg = zzqVar;
            zzez.zza((Class<zzq>) zzq.class, zzqVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzr extends zzez<zzr, zza> implements zzgj {
        private static final zzr zzg;
        private static volatile zzgr<zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzr() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzr, zza> implements zzgj {
            private zza() {
                super(zzr.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzr>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzr> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzr> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzr.class) {
                        zzgr<zzr> zzgrVar3 = zzh;
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
            zzr zzrVar = new zzr();
            zzg = zzrVar;
            zzez.zza((Class<zzr>) zzr.class, zzrVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzs extends zzez<zzs, zza> implements zzgj {
        private static final zzs zzg;
        private static volatile zzgr<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzs() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzs, zza> implements zzgj {
            private zza() {
                super(zzs.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzs>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzs> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzs> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzs.class) {
                        zzgr<zzs> zzgrVar3 = zzh;
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
            zzs zzsVar = new zzs();
            zzg = zzsVar;
            zzez.zza((Class<zzs>) zzs.class, zzsVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzt extends zzez<zzt, zza> implements zzgj {
        private static final zzt zzg;
        private static volatile zzgr<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzt() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzt, zza> implements zzgj {
            private zza() {
                super(zzt.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzt>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzt> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzt> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzt.class) {
                        zzgr<zzt> zzgrVar3 = zzh;
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
            zzt zztVar = new zzt();
            zzg = zztVar;
            zzez.zza((Class<zzt>) zzt.class, zztVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzu extends zzez<zzu, zza> implements zzgj {
        private static final zzu zzg;
        private static volatile zzgr<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzu() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzu, zza> implements zzgj {
            private zza() {
                super(zzu.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzu>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzu> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzu> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzu.class) {
                        zzgr<zzu> zzgrVar3 = zzh;
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
            zzu zzuVar = new zzu();
            zzg = zzuVar;
            zzez.zza((Class<zzu>) zzu.class, zzuVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzv extends zzez<zzv, zza> implements zzgj {
        private static final zzv zzg;
        private static volatile zzgr<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzv() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzv, zza> implements zzgj {
            private zza() {
                super(zzv.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzv>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzv> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzv> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzv.class) {
                        zzgr<zzv> zzgrVar3 = zzh;
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
            zzv zzvVar = new zzv();
            zzg = zzvVar;
            zzez.zza((Class<zzv>) zzv.class, zzvVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzw extends zzez<zzw, zza> implements zzgj {
        private static final zzw zzg;
        private static volatile zzgr<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzw() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzw, zza> implements zzgj {
            private zza() {
                super(zzw.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzw>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzw> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgr<zzw> zzgrVar2 = zzh;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzw.class) {
                        zzgr<zzw> zzgrVar3 = zzh;
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
            zzw zzwVar = new zzw();
            zzg = zzwVar;
            zzez.zza((Class<zzw>) zzw.class, zzwVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzx extends zzez<zzx, zza> implements zzgj {
        private static final zzx zzf;
        private static volatile zzgr<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        private zzx() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzx, zza> implements zzgj {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzx>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzx> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_common.zzal.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgr<zzx> zzgrVar2 = zzg;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzx.class) {
                        zzgr<zzx> zzgrVar3 = zzg;
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
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zzez.zza((Class<zzx>) zzx.class, zzxVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzy extends zzez<zzy, zzb> implements zzgj {
        private static final zzy zzi;
        private static volatile zzgr<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzfi<zza> zzf = zzl();
        private zzfi<zza> zzg = zzl();
        private long zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, zzb> implements zzgj {
            private static final zza zzf;
            private static volatile zzgr<zza> zzg;
            private int zzc;
            private int zzd;
            private zzfg zze = zzk();

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza$zza, reason: collision with other inner class name */
            public enum EnumC0043zza implements zzfb {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);

                private static final zzfe<EnumC0043zza> zzf = new com.google.android.gms.internal.mlkit_common.zzaj();
                private final int zzg;

                @Override // com.google.android.gms.internal.mlkit_common.zzfb
                public final int zza() {
                    return this.zzg;
                }

                public static zzfd zzb() {
                    return com.google.android.gms.internal.mlkit_common.zzai.zza;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
                }

                EnumC0043zza(int i) {
                    this.zzg = i;
                }
            }

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            public static final class zzb extends zzez.zza<zza, zzb> implements zzgj {
                private zzb() {
                    super(zza.zzf);
                }

                /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new zzb(zzacVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzc", "zzd", EnumC0043zza.zzb(), "zze"});
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

        private zzy() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzy, zzb> implements zzgj {
            private zzb() {
                super(zzy.zzi);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzy> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.class, "zzg", zza.class, "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgr<zzy> zzgrVar2 = zzj;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzy.class) {
                        zzgr<zzy> zzgrVar3 = zzj;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzi);
                            zzj = zzcVar;
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
            zzy zzyVar = new zzy();
            zzi = zzyVar;
            zzez.zza((Class<zzy>) zzy.class, zzyVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzz extends zzez<zzz, zza> implements zzgj {
        private static final zzff<Integer, com.google.android.gms.internal.mlkit_common.zzal> zzg = new com.google.android.gms.internal.mlkit_common.zzak();
        private static final zzz zzj;
        private static volatile zzgr<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzfg zzf = zzk();
        private long zzh;
        private boolean zzi;

        private zzz() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzz, zza> implements zzgj {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzz>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzz> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzz> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzz.class) {
                        zzgr<zzz> zzgrVar3 = zzk;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzak, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzal>] */
        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zzez.zza((Class<zzz>) zzz.class, zzzVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzaj extends zzez<zzaj, zzb> implements zzgj {
        private static final zzaj zze;
        private static volatile zzgr<zzaj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            UNKNOWN(0),
            TRANSLATE(1);

            private static final zzfe<zza> zzc = new com.google.android.gms.internal.mlkit_common.zzbd();
            private final int zzd;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzd;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i != 1) {
                    return null;
                }
                return TRANSLATE;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzbe.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzd = i;
            }
        }

        private zzaj() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzaj, zzb> implements zzgj {
            private zzb() {
                super(zzaj.zze);
            }

            public final zzb zza(zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaj) this.zza).zza(zzaVar);
                return this;
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            this.zzd = zzaVar.zza();
            this.zzc |= 1;
        }

        public static zzb zza() {
            return zze.zzh();
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaj>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzaj> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzaj();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", zza.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzgr<zzaj> zzgrVar2 = zzf;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzaj.class) {
                        zzgr<zzaj> zzgrVar3 = zzf;
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
            zzaj zzajVar = new zzaj();
            zze = zzajVar;
            zzez.zza((Class<zzaj>) zzaj.class, zzajVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzak extends zzez<zzak, zza> implements zzgj {
        private static final zzak zzj;
        private static volatile zzgr<zzak> zzk;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzb implements zzfb {
            UNKNOWN_STATUS(0),
            EXPLICITLY_REQUESTED(1),
            IMPLICITLY_REQUESTED(2),
            MODEL_INFO_RETRIEVAL_SUCCEEDED(3),
            MODEL_INFO_RETRIEVAL_FAILED(4),
            SCHEDULED(5),
            DOWNLOADING(6),
            SUCCEEDED(7),
            FAILED(8),
            LIVE(9),
            UPDATE_AVAILABLE(10),
            DOWNLOADED(11);

            private static final zzfe<zzb> zzm = new com.google.android.gms.internal.mlkit_common.zzbf();
            private final int zzn;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzn;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzbg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzn = i;
            }
        }

        private zzak() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzak, zza> implements zzgj {
            private zza() {
                super(zzak.zzj);
            }

            public final zza zza(zzam zzamVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzamVar);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(j);
                return this;
            }

            public final zza zza(com.google.android.gms.internal.mlkit_common.zzal zzalVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzalVar);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zzb(j);
                return this;
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zzc(j);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzam zzamVar) {
            zzamVar.getClass();
            this.zzd = zzamVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(com.google.android.gms.internal.mlkit_common.zzal zzalVar) {
            this.zzf = zzalVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zzh = zzbVar.zza();
            this.zzc |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 32;
            this.zzi = j;
        }

        public static zza zza() {
            return zzj.zzh();
        }

        /* JADX WARN: Type inference failed for: r4v17, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzak>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzak> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzak();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", com.google.android.gms.internal.mlkit_common.zzal.zzb(), "zzg", "zzh", zzb.zzb(), "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgr<zzak> zzgrVar2 = zzk;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzak.class) {
                        zzgr<zzak> zzgrVar3 = zzk;
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
            zzak zzakVar = new zzak();
            zzj = zzakVar;
            zzez.zza((Class<zzak>) zzak.class, zzakVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzal extends zzez<zzal, zzb> implements zzgj {
        private static final zzal zzl;
        private static volatile zzgr<zzal> zzm;
        private int zzc;
        private int zzf;
        private int zzi;
        private long zzj;
        private boolean zzk;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zza implements zzfb {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5);

            private static final zzfe<zza> zzg = new zzbi();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzh;
            }

            public static zzfd zzb() {
                return com.google.android.gms.internal.mlkit_common.zzbh.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzh = i;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public enum zzc implements zzfb {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);

            private static final zzfe<zzc> zzf = new zzbj();
            private final int zzg;

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzg;
            }

            public static zzfd zzb() {
                return zzbk.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zzg = i;
            }
        }

        private zzal() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzal, zzb> implements zzgj {
            private zzb() {
                super(zzal.zzl);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(str);
                return this;
            }

            public final zzb zza(zzc zzcVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(zzcVar);
                return this;
            }

            public final zzb zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zzb(str);
                return this;
            }

            public final zzb zza(zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(zzaVar);
                return this;
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzf = zzcVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            this.zzi = zzaVar.zza();
            this.zzc |= 32;
        }

        public static zzb zza() {
            return zzl.zzh();
        }

        /* JADX WARN: Type inference failed for: r4v19, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzal>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzal> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzal();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.zzb(), "zzg", "zzh", "zzi", zza.zzb(), "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgr<zzal> zzgrVar2 = zzm;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzal.class) {
                        zzgr<zzal> zzgrVar3 = zzm;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzl);
                            zzm = zzcVar;
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
            zzal zzalVar = new zzal();
            zzl = zzalVar;
            zzez.zza((Class<zzal>) zzal.class, zzalVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzam extends zzez<zzam, zzb> implements zzgj {
        private static final zzam zzh;
        private static volatile zzgr<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zza zze;
        private zza zzf;
        private boolean zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez<zza, C0032zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza$zza, reason: collision with other inner class name */
            public static final class C0032zza extends zzez.zza<zza, C0032zza> implements zzgj {
                private C0032zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0032zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza>] */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgr<zza> zzgrVar;
                com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
                switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0032zza(zzacVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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

        private zzam() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zzb extends zzez.zza<zzam, zzb> implements zzgj {
            private zzb() {
                super(zzam.zzh);
            }

            public final zzb zza(zzal.zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzam) this.zza).zza((zzal) ((zzez) zzbVar.zzh()));
                return this;
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzal zzalVar) {
            zzalVar.getClass();
            this.zzd = zzalVar;
            this.zzc |= 1;
        }

        public static zzb zza() {
            return zzh.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzam> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzam();
                case 2:
                    return new zzb(zzacVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgr<zzam> zzgrVar2 = zzi;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzam.class) {
                        zzgr<zzam> zzgrVar3 = zzi;
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
            zzam zzamVar = new zzam();
            zzh = zzamVar;
            zzez.zza((Class<zzam>) zzam.class, zzamVar);
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static final class zzbg extends zzez<zzbg, zza> implements zzgj {
        private static final zzbg zzo;
        private static volatile zzgr<zzbg> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzfi<String> zzk = zzez.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        private zzbg() {
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        public static final class zza extends zzez.zza<zzbg, zza> implements zzgj {
            private zza() {
                super(zzbg.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzd(str);
                return this;
            }

            public final zza zza(Iterable<String> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zza(iterable);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zze(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zza(true);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzb(true);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_common.zzac zzacVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        public final String zza() {
            return this.zzh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<String> iterable) {
            zzfi<String> zzfiVar = this.zzk;
            if (!zzfiVar.zza()) {
                int size = zzfiVar.size();
                this.zzk = zzfiVar.zzb(size == 0 ? 10 : size << 1);
            }
            zzdq.zza(iterable, this.zzk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 256;
            this.zzm = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 512;
            this.zzn = z;
        }

        public static zza zzb() {
            return zzo.zzh();
        }

        public static zza zza(zzbg zzbgVar) {
            return zzo.zza(zzbgVar);
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbg>] */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgr<zzbg> zzgrVar;
            com.google.android.gms.internal.mlkit_common.zzac zzacVar = null;
            switch (com.google.android.gms.internal.mlkit_common.zzac.zza[i - 1]) {
                case 1:
                    return new zzbg();
                case 2:
                    return new zza(zzacVar);
                case 3:
                    return zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzgr<zzbg> zzgrVar2 = zzp;
                    if (zzgrVar2 != null) {
                        return zzgrVar2;
                    }
                    synchronized (zzbg.class) {
                        zzgr<zzbg> zzgrVar3 = zzp;
                        zzgrVar = zzgrVar3;
                        if (zzgrVar3 == null) {
                            ?? zzcVar = new zzez.zzc(zzo);
                            zzp = zzcVar;
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

        public static zzbg zzc() {
            return zzo;
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzo = zzbgVar;
            zzez.zza((Class<zzbg>) zzbg.class, zzbgVar);
        }
    }
}
