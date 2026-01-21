package com.google.android.gms.internal.mlkit_vision_common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.mlkit_vision_common.zzcb;
import com.google.android.gms.internal.mlkit_vision_common.zzek;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;
import com.google.api.client.http.HttpStatusCodes;
import kotlin.text.Typography;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzr {

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zza extends zzek<zza, zzb> implements zzfx {
        private static final zza zzg;
        private static volatile zzgf<zza> zzh;
        private int zzc;
        private C0053zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza, reason: collision with other inner class name */
        public static final class C0053zza extends zzek<C0053zza, C0054zza> implements zzfx {
            private static final C0053zza zzh;
            private static volatile zzgf<C0053zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            private C0053zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza, reason: collision with other inner class name */
            public static final class C0054zza extends zzek.zzb<C0053zza, C0054zza> implements zzfx {
                private C0054zza() {
                    super(C0053zza.zzh);
                }

                /* synthetic */ C0054zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<C0053zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new C0053zza();
                    case 2:
                        return new C0054zza(zztVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgf<C0053zza> zzgfVar2 = zzi;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (C0053zza.class) {
                            zzgf<C0053zza> zzgfVar3 = zzi;
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
                C0053zza c0053zza = new C0053zza();
                zzh = c0053zza;
                zzek.zza((Class<C0053zza>) C0053zza.class, c0053zza);
            }
        }

        private zza() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zza, zzb> implements zzfx {
            private zzb() {
                super(zza.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zza> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zza> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zza.class) {
                        zzgf<zza> zzgfVar3 = zzh;
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
            zza zzaVar = new zza();
            zzg = zzaVar;
            zzek.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzaa extends zzek<zzaa, zza> implements zzfx {
        private static final zzaa zzf;
        private static volatile zzgf<zzaa> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        private zzaa() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzaa, zza> implements zzfx {
            private zza() {
                super(zzaa.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzaa> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzc", "zzd", zzal.zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzaa> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzaa.class) {
                        zzgf<zzaa> zzgfVar3 = zzg;
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
            zzaa zzaaVar = new zzaa();
            zzf = zzaaVar;
            zzek.zza((Class<zzaa>) zzaa.class, zzaaVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzab extends zzek<zzab, zza> implements zzfx {
        private static final zzab zzj;
        private static volatile zzgf<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        private zzab() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzab, zza> implements zzfx {
            private zza() {
                super(zzab.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzab> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzab> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzab.class) {
                        zzgf<zzab> zzgfVar3 = zzk;
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
            zzab zzabVar = new zzab();
            zzj = zzabVar;
            zzek.zza((Class<zzab>) zzab.class, zzabVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzac extends zzek<zzac, zzb> implements zzfx {
        private static final zzac zzj;
        private static volatile zzgf<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);

            private static final zzeo<zza> zzd = new com.google.android.gms.internal.mlkit_vision_common.zzaj();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzai.zza;
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
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);

            private static final zzeo<zzc> zzd = new com.google.android.gms.internal.mlkit_vision_common.zzak();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzal.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzd implements zzep {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);

            private static final zzeo<zzd> zzd = new com.google.android.gms.internal.mlkit_vision_common.zzan();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzam.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzd(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zze implements zzep {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);

            private static final zzeo<zze> zzd = new com.google.android.gms.internal.mlkit_vision_common.zzao();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzap.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzac, zzb> implements zzfx {
            private zzb() {
                super(zzac.zzj);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r6v21, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzac> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zza.zzb(), "zzf", zze.zzb(), "zzg", zzc.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzac> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzac.class) {
                        zzgf<zzac> zzgfVar3 = zzk;
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
            zzac zzacVar = new zzac();
            zzj = zzacVar;
            zzek.zza((Class<zzac>) zzac.class, zzacVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzad extends zzek.zzc<zzad, zza> implements zzfx {
        private static final zzad zzbd;
        private static volatile zzgf<zzad> zzbe;
        private zzp zzaa;
        private zzm zzab;
        private zzo zzac;
        private C0066zzr zzad;
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
        private zzaa zzao;
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
        private zzes<zzhx.zzf> zzay = zzl();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzd<zzad, zza> implements zzfx {
            private zza() {
                super(zzad.zzbd);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
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
                ((zzad) this.zza).zza((zzbg) ((zzek) zzaVar.zzg()));
                return this;
            }

            public final zza zza(com.google.android.gms.internal.mlkit_vision_common.zzag zzagVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzagVar);
                return this;
            }

            public final zza zza(zzag.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzag) ((zzek) zzaVar.zzg()));
                return this;
            }
        }

        static {
            zzad zzadVar = new zzad();
            zzbd = zzadVar;
            zzek.zza((Class<zzad>) zzad.class, zzadVar);
        }

        private zzad() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static zza zza(zzad zzadVar) {
            return (zza) zzbd.zza(zzadVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(com.google.android.gms.internal.mlkit_vision_common.zzag zzagVar) {
            this.zzg = zzagVar.zza();
            this.zzd |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzag zzagVar) {
            zzagVar.getClass();
            this.zzba = zzagVar;
            this.zze |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzf = zzbgVar;
            this.zzd |= 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbg zza() {
            zzbg zzbgVar = this.zzf;
            return zzbgVar == null ? zzbg.zzc() : zzbgVar;
        }

        /* JADX WARN: Type inference failed for: r3v61, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzad>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzad> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzbd, "\u00011\u0000\u0002\u000131\u0000\u0001\u0001\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0003\u0004ဉ\u0005\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဉ\u0015\tဉ\u0016\nဉ\u0017\u000bဉ\u0018\fဉ\u0019\rဉ\u001a\u000eဉ\u001b\u000fဉ\u001c\u0010ဉ\u001d\u0011ဉ\u001e\u0012ဉ\f\u0013ဉ\u0012\u0014ဉ\u0004\u0015ဉ\u0013\u0016ဉ\u0014\u0017ဉ\u001f\u0018ဉ \u0019ဉ!\u001aဉ\r\u001bဉ\u000e\u001cဉ\u000f\u001dဉ\u0006\u001eဉ$\u001fဉ% ဉ&!ဉ'\"ဉ(#ဉ)$ဉ*%ဇ\u0002'ဉ\"(ဉ#)Л*ဉ-,ဉ\u0010-ဉ\u0011.ဉ+/ဉ,0ဉ\n1ဉ\u000b2ဉ.3ဉ/", new Object[]{"zzd", "zze", "zzf", "zzg", com.google.android.gms.internal.mlkit_vision_common.zzag.zzb(), "zzi", "zzk", "zzm", "zzn", "zzo", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzr", "zzx", "zzj", "zzy", "zzz", "zzak", "zzal", "zzam", "zzs", "zzt", "zzu", "zzl", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzh", "zzan", "zzao", "zzay", zzhx.zzf.class, "zzaz", "zzv", "zzw", "zzaw", "zzax", "zzp", "zzq", "zzba", "zzbb"});
                case 4:
                    return zzbd;
                case 5:
                    zzgf<zzad> zzgfVar2 = zzbe;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzad.class) {
                        zzgf<zzad> zzgfVar3 = zzbe;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzbd);
                            zzbe = zzaVar;
                            zzgfVar = zzaVar;
                        }
                    }
                    return zzgfVar;
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

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzae extends zzek<zzae, zzb> implements zzfx {
        private static final zzae zzg;
        private static volatile zzgf<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);

            private static final zzeo<zza> zzj = new com.google.android.gms.internal.mlkit_vision_common.zzar();
            private final int zzk;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzk;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzaq.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzae, zzb> implements zzfx {
            private zzb() {
                super(zzae.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzae> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzae> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzae.class) {
                        zzgf<zzae> zzgfVar3 = zzh;
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
            zzae zzaeVar = new zzae();
            zzg = zzaeVar;
            zzek.zza((Class<zzae>) zzae.class, zzaeVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzaf extends zzek<zzaf, zza> implements zzfx {
        private static final zzaf zzk;
        private static volatile zzgf<zzaf> zzl;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzaf, zza> implements zzfx {
            private zza() {
                super(zzaf.zzk);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzaf> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzaf();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgf<zzaf> zzgfVar2 = zzl;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzaf.class) {
                        zzgf<zzaf> zzgfVar3 = zzl;
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
            zzaf zzafVar = new zzaf();
            zzk = zzafVar;
            zzek.zza((Class<zzaf>) zzaf.class, zzafVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzah extends zzek<zzah, zza> implements zzfx {
        private static final zzah zzf;
        private static volatile zzgf<zzah> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        private zzah() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzah, zza> implements zzfx {
            private zza() {
                super(zzah.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzah> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzah();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzc", "zzd", zzal.zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzah> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzah.class) {
                        zzgf<zzah> zzgfVar3 = zzg;
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
            zzah zzahVar = new zzah();
            zzf = zzahVar;
            zzek.zza((Class<zzah>) zzah.class, zzahVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzai extends zzek<zzai, zza> implements zzfx {
        private static final zzai zzg;
        private static volatile zzgf<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        private zzai() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzai, zza> implements zzfx {
            private zza() {
                super(zzai.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzai> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzai();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzai> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzai.class) {
                        zzgf<zzai> zzgfVar3 = zzh;
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
            zzai zzaiVar = new zzai();
            zzg = zzaiVar;
            zzek.zza((Class<zzai>) zzai.class, zzaiVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzaj extends zzek<zzaj, zzb> implements zzfx {
        private static final zzaj zze;
        private static volatile zzgf<zzaj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            UNKNOWN(0),
            TRANSLATE(1);

            private static final zzeo<zza> zzc = new com.google.android.gms.internal.mlkit_vision_common.zzau();
            private final int zzd;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzd;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzav.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzaj, zzb> implements zzfx {
            private zzb() {
                super(zzaj.zze);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzaj> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzaj();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", zza.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzgf<zzaj> zzgfVar2 = zzf;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzaj.class) {
                        zzgf<zzaj> zzgfVar3 = zzf;
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
            zzaj zzajVar = new zzaj();
            zze = zzajVar;
            zzek.zza((Class<zzaj>) zzaj.class, zzajVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzak extends zzek<zzak, zza> implements zzfx {
        private static final zzak zzj;
        private static volatile zzgf<zzak> zzk;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
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

            private static final zzeo<zzb> zzm = new com.google.android.gms.internal.mlkit_vision_common.zzaw();
            private final int zzn;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzn;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzax.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzak, zza> implements zzfx {
            private zza() {
                super(zzak.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v17, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzak> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzak();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zzg", "zzh", zzb.zzb(), "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzak> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzak.class) {
                        zzgf<zzak> zzgfVar3 = zzk;
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
            zzak zzakVar = new zzak();
            zzj = zzakVar;
            zzek.zza((Class<zzak>) zzak.class, zzakVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzal extends zzek<zzal, zzb> implements zzfx {
        private static final zzal zzl;
        private static volatile zzgf<zzal> zzm;
        private int zzc;
        private int zzf;
        private int zzi;
        private long zzj;
        private boolean zzk;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5);

            private static final zzeo<zza> zzg = new com.google.android.gms.internal.mlkit_vision_common.zzaz();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzh;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzay.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzh = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzc implements zzep {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);

            private static final zzeo<zzc> zzf = new com.google.android.gms.internal.mlkit_vision_common.zzba();
            private final int zzg;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzg;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzbb.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzal, zzb> implements zzfx {
            private zzb() {
                super(zzal.zzl);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v19, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzal> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzal();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.zzb(), "zzg", "zzh", "zzi", zza.zzb(), "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgf<zzal> zzgfVar2 = zzm;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzal.class) {
                        zzgf<zzal> zzgfVar3 = zzm;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzl);
                            zzm = zzaVar;
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
            zzal zzalVar = new zzal();
            zzl = zzalVar;
            zzek.zza((Class<zzal>) zzal.class, zzalVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzam extends zzek<zzam, zzb> implements zzfx {
        private static final zzam zzh;
        private static volatile zzgf<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zza zze;
        private zza zzf;
        private boolean zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0055zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza, reason: collision with other inner class name */
            public static final class C0055zza extends zzek.zzb<zza, C0055zza> implements zzfx {
                private C0055zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0055zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0055zza(zztVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzi;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzi;
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
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzam() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzam, zzb> implements zzfx {
            private zzb() {
                super(zzam.zzh);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzam> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzam();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgf<zzam> zzgfVar2 = zzi;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzam.class) {
                        zzgf<zzam> zzgfVar3 = zzi;
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
            zzam zzamVar = new zzam();
            zzh = zzamVar;
            zzek.zza((Class<zzam>) zzam.class, zzamVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzan extends zzek<zzan, zzb> implements zzfx {
        private static final zzan zzh;
        private static volatile zzgf<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);

            private static final zzeo<zza> zzh = new com.google.android.gms.internal.mlkit_vision_common.zzbd();
            private final int zzi;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzi;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzbc.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzan, zzb> implements zzfx {
            private zzb() {
                super(zzan.zzh);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzan> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzan();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgf<zzan> zzgfVar2 = zzi;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzan.class) {
                        zzgf<zzan> zzgfVar3 = zzi;
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
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zzek.zza((Class<zzan>) zzan.class, zzanVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzao extends zzek<zzao, zzc> implements zzfx {
        private static final zzet<Integer, zza> zzg = new com.google.android.gms.internal.mlkit_vision_common.zzbe();
        private static final zzet<Integer, zzb> zzi = new com.google.android.gms.internal.mlkit_vision_common.zzbf();
        private static final zzao zzk;
        private static volatile zzgf<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzcb.zza zze;
        private zzeq zzf = zzk();
        private zzeq zzh = zzk();
        private zzae zzj;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
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

            private static final zzeo<zza> zzo = new com.google.android.gms.internal.mlkit_vision_common.zzbh();
            private final int zzp;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzp;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzbg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzp = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
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

            private static final zzeo<zzb> zzn = new zzbi();
            private final int zzo;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzo;
            }

            public static zzer zzb() {
                return zzbj.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzc extends zzek.zzb<zzao, zzc> implements zzfx {
            private zzc() {
                super(zzao.zzk);
            }

            /* synthetic */ zzc(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v16, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzao> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzao();
                case 2:
                    return new zzc(zztVar);
                case 3:
                    return zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.zzb(), "zzh", zzb.zzb(), "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgf<zzao> zzgfVar2 = zzl;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzao.class) {
                        zzgf<zzao> zzgfVar3 = zzl;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzbe, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzbf, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb>] */
        static {
            zzao zzaoVar = new zzao();
            zzk = zzaoVar;
            zzek.zza((Class<zzao>) zzao.class, zzaoVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzap extends zzek<zzap, zza> implements zzfx {
        private static final zzap zzj;
        private static volatile zzgf<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzcb.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        private zzap() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzap, zza> implements zzfx {
            private zza() {
                super(zzap.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzap> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzap();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzap> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzap.class) {
                        zzgf<zzap> zzgfVar3 = zzk;
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
            zzap zzapVar = new zzap();
            zzj = zzapVar;
            zzek.zza((Class<zzap>) zzap.class, zzapVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzaq extends zzek<zzaq, zza> implements zzfx {
        private static final zzaq zzf;
        private static volatile zzgf<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        private zzaq() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzaq, zza> implements zzfx {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzaq> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzaq();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzaq> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzaq.class) {
                        zzgf<zzaq> zzgfVar3 = zzg;
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
            zzaq zzaqVar = new zzaq();
            zzf = zzaqVar;
            zzek.zza((Class<zzaq>) zzaq.class, zzaqVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzar extends zzek<zzar, zza> implements zzfx {
        private static final zzar zzi;
        private static volatile zzgf<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        private zzar() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzar, zza> implements zzfx {
            private zza() {
                super(zzar.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzar> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzar();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgf<zzar> zzgfVar2 = zzj;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzar.class) {
                        zzgf<zzar> zzgfVar3 = zzj;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzi);
                            zzj = zzaVar;
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
            zzar zzarVar = new zzar();
            zzi = zzarVar;
            zzek.zza((Class<zzar>) zzar.class, zzarVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzas extends zzek<zzas, zza> implements zzfx {
        private static final zzet<Integer, com.google.android.gms.internal.mlkit_vision_common.zzac> zzf = new zzbk();
        private static final zzas zzi;
        private static volatile zzgf<zzas> zzj;
        private int zzc;
        private zzat zzd;
        private zzeq zze = zzk();
        private long zzg;
        private long zzh;

        private zzas() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzas, zza> implements zzfx {
            private zza() {
                super(zzas.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzas> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzas();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgf<zzas> zzgfVar2 = zzj;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzas.class) {
                        zzgf<zzas> zzgfVar3 = zzj;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzi);
                            zzj = zzaVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzbk, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzas zzasVar = new zzas();
            zzi = zzasVar;
            zzek.zza((Class<zzas>) zzas.class, zzasVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzat extends zzek<zzat, zza> implements zzfx {
        private static final zzat zzg;
        private static volatile zzgf<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        private zzat() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzat, zza> implements zzfx {
            private zza() {
                super(zzat.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzat> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzat();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzat> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzat.class) {
                        zzgf<zzat> zzgfVar3 = zzh;
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
            zzat zzatVar = new zzat();
            zzg = zzatVar;
            zzek.zza((Class<zzat>) zzat.class, zzatVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzau extends zzek<zzau, zzb> implements zzfx {
        private static final zzau zzh;
        private static volatile zzgf<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0056zza> implements zzfx {
            private static final zza zzf;
            private static volatile zzgf<zza> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza, reason: collision with other inner class name */
            public static final class C0056zza extends zzek.zzb<zza, C0056zza> implements zzfx {
                private C0056zza() {
                    super(zza.zzf);
                }

                /* synthetic */ C0056zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0056zza(zztVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
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
        public static final class zzc extends zzek<zzc, zza> implements zzfx {
            private static final zzc zze;
            private static volatile zzgf<zzc> zzf;
            private int zzc;
            private zza zzd;

            private zzc() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            public static final class zza extends zzek.zzb<zzc, zza> implements zzfx {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zzc> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zztVar);
                    case 3:
                        return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzgf<zzc> zzgfVar2 = zzf;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zzc.class) {
                            zzgf<zzc> zzgfVar3 = zzf;
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
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzek.zza((Class<zzc>) zzc.class, zzcVar);
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzd extends zzek<zzd, zza> implements zzfx {
            private static final zzd zzd;
            private static volatile zzgf<zzd> zze;
            private zzes<zza> zzc = zzl();

            private zzd() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            public static final class zza extends zzek.zzb<zzd, zza> implements zzfx {
                private zza() {
                    super(zzd.zzd);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zzd> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zztVar);
                    case 3:
                        return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zza.class});
                    case 4:
                        return zzd;
                    case 5:
                        zzgf<zzd> zzgfVar2 = zze;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zzd.class) {
                            zzgf<zzd> zzgfVar3 = zze;
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
                zzd zzdVar = new zzd();
                zzd = zzdVar;
                zzek.zza((Class<zzd>) zzd.class, zzdVar);
            }
        }

        private zzau() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzau, zzb> implements zzfx {
            private zzb() {
                super(zzau.zzh);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzau> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzau();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgf<zzau> zzgfVar2 = zzi;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzau.class) {
                        zzgf<zzau> zzgfVar3 = zzi;
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
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zzek.zza((Class<zzau>) zzau.class, zzauVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzav extends zzek<zzav, zza> implements zzfx {
        private static final zzav zzf;
        private static volatile zzgf<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        private zzav() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzav, zza> implements zzfx {
            private zza() {
                super(zzav.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzav> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzav();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzav> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzav.class) {
                        zzgf<zzav> zzgfVar3 = zzg;
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
            zzav zzavVar = new zzav();
            zzf = zzavVar;
            zzek.zza((Class<zzav>) zzav.class, zzavVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzaw extends zzek<zzaw, zzb> implements zzfx {
        private static final zzaw zzj;
        private static volatile zzgf<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);

            private static final zzeo<zza> zzd = new zzbm();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return zzbl.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzaw, zzb> implements zzfx {
            private zzb() {
                super(zzaw.zzj);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzaw> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzaw();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzaw> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzaw.class) {
                        zzgf<zzaw> zzgfVar3 = zzk;
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
            zzaw zzawVar = new zzaw();
            zzj = zzawVar;
            zzek.zza((Class<zzaw>) zzaw.class, zzawVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzax extends zzek<zzax, zza> implements zzfx {
        private static final zzax zzh;
        private static volatile zzgf<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzes<zzan> zzg = zzl();

        private zzax() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzax, zza> implements zzfx {
            private zza() {
                super(zzax.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzax> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzax();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzan.class});
                case 4:
                    return zzh;
                case 5:
                    zzgf<zzax> zzgfVar2 = zzi;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzax.class) {
                        zzgf<zzax> zzgfVar3 = zzi;
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
            zzax zzaxVar = new zzax();
            zzh = zzaxVar;
            zzek.zza((Class<zzax>) zzax.class, zzaxVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzay extends zzek<zzay, zza> implements zzfx {
        private static final zzay zzh;
        private static volatile zzgf<zzay> zzi;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;

        private zzay() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzay, zza> implements zzfx {
            private zza() {
                super(zzay.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzay> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzay();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgf<zzay> zzgfVar2 = zzi;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzay.class) {
                        zzgf<zzay> zzgfVar3 = zzi;
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
            zzay zzayVar = new zzay();
            zzh = zzayVar;
            zzek.zza((Class<zzay>) zzay.class, zzayVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzaz extends zzek<zzaz, zza> implements zzfx {
        private static final zzaz zzg;
        private static volatile zzgf<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        private zzaz() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzaz, zza> implements zzfx {
            private zza() {
                super(zzaz.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzaz> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzaz();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzaz> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzaz.class) {
                        zzgf<zzaz> zzgfVar3 = zzh;
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
            zzaz zzazVar = new zzaz();
            zzg = zzazVar;
            zzek.zza((Class<zzaz>) zzaz.class, zzazVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzb extends zzek<zzb, C0058zzb> implements zzfx {
        private static final zzb zzg;
        private static volatile zzgf<zzb> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0057zza> implements zzfx {
            private static final zza zzi;
            private static volatile zzgf<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzes<zzy.zza> zzf = zzl();
            private zzes<zzy.zza> zzg = zzl();
            private zzam zzh;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza, reason: collision with other inner class name */
            public static final class C0057zza extends zzek.zzb<zza, C0057zza> implements zzfx {
                private C0057zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0057zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0057zza(zztVar);
                    case 3:
                        return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", zzy.zza.class, "zzg", zzy.zza.class, "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzj;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzj;
                            zzgfVar = zzgfVar3;
                            if (zzgfVar3 == null) {
                                ?? zzaVar = new zzek.zza(zzi);
                                zzj = zzaVar;
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
                zzi = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb, reason: collision with other inner class name */
        public static final class C0058zzb extends zzek.zzb<zzb, C0058zzb> implements zzfx {
            private C0058zzb() {
                super(zzb.zzg);
            }

            /* synthetic */ C0058zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzb> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0058zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzb> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzb.class) {
                        zzgf<zzb> zzgfVar3 = zzh;
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
            zzb zzbVar = new zzb();
            zzg = zzbVar;
            zzek.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzba extends zzek<zzba, zza> implements zzfx {
        private static final zzba zzf;
        private static volatile zzgf<zzba> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);

            private static final zzeo<zzb> zzd = new zzbn();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return zzbo.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzc implements zzep {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);

            private static final zzeo<zzc> zzd = new zzbq();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return zzbp.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzba, zza> implements zzfx {
            private zza() {
                super(zzba.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzba> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzba();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzc.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzba> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzba.class) {
                        zzgf<zzba> zzgfVar3 = zzg;
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
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzek.zza((Class<zzba>) zzba.class, zzbaVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbb extends zzek<zzbb, zza> implements zzfx {
        private static final zzbb zzf;
        private static volatile zzgf<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        private zzbb() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzbb, zza> implements zzfx {
            private zza() {
                super(zzbb.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbb> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbb();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzbb> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbb.class) {
                        zzgf<zzbb> zzgfVar3 = zzg;
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
            zzbb zzbbVar = new zzbb();
            zzf = zzbbVar;
            zzek.zza((Class<zzbb>) zzbb.class, zzbbVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbc extends zzek<zzbc, zza> implements zzfx {
        private static final zzbc zzi;
        private static volatile zzgf<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzes<zzc> zze = zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);

            private static final zzeo<zzb> zzh = new zzbr();
            private final int zzi;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzi;
            }

            public static zzer zzb() {
                return zzbs.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzi = i;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzc extends zzek<zzc, zza> implements zzfx {
            private static final zzc zze;
            private static volatile zzgf<zzc> zzf;
            private int zzc;
            private float zzd;

            private zzc() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            public static final class zza extends zzek.zzb<zzc, zza> implements zzfx {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zzc> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zztVar);
                    case 3:
                        return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzgf<zzc> zzgfVar2 = zzf;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zzc.class) {
                            zzgf<zzc> zzgfVar3 = zzf;
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
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzek.zza((Class<zzc>) zzc.class, zzcVar);
            }
        }

        private zzbc() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzbc, zza> implements zzfx {
            private zza() {
                super(zzbc.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbc> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbc();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzc.class, "zzf", zzb.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgf<zzbc> zzgfVar2 = zzj;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbc.class) {
                        zzgf<zzbc> zzgfVar3 = zzj;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzi);
                            zzj = zzaVar;
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
            zzbc zzbcVar = new zzbc();
            zzi = zzbcVar;
            zzek.zza((Class<zzbc>) zzbc.class, zzbcVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbd extends zzek<zzbd, zza> implements zzfx {
        private static final zzbd zzf;
        private static volatile zzgf<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        private zzbd() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzbd, zza> implements zzfx {
            private zza() {
                super(zzbd.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbd> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbd();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzbd> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbd.class) {
                        zzgf<zzbd> zzgfVar3 = zzg;
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
            zzbd zzbdVar = new zzbd();
            zzf = zzbdVar;
            zzek.zza((Class<zzbd>) zzbd.class, zzbdVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbe extends zzek<zzbe, zzb> implements zzfx {
        private static final zzbe zzl;
        private static volatile zzgf<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbh zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
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

            private static final zzeo<zza> zzai = new zzbu();
            private final int zzaj;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzaj;
            }

            public static zzer zzb() {
                return zzbt.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzbe, zzb> implements zzfx {
            private zzb() {
                super(zzbe.zzl);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbe> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbe();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zza.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgf<zzbe> zzgfVar2 = zzm;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbe.class) {
                        zzgf<zzbe> zzgfVar3 = zzm;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzl);
                            zzm = zzaVar;
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
            zzbe zzbeVar = new zzbe();
            zzl = zzbeVar;
            zzek.zza((Class<zzbe>) zzbe.class, zzbeVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbf extends zzek<zzbf, zzb> implements zzfx {
        private static final zzet<Integer, zza> zzf = new zzbv();
        private static final zzet<Integer, zza> zzh = new zzbx();
        private static final zzet<Integer, zza> zzj = new zzbw();
        private static final zzbf zzl;
        private static volatile zzgf<zzbf> zzm;
        private int zzc;
        private long zzd;
        private zzeq zze = zzk();
        private zzeq zzg = zzk();
        private zzeq zzi = zzk();
        private int zzk;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zza implements zzep {
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

            private static final zzeo<zza> zzm = new zzbz();
            private final int zzn;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzn;
            }

            public static zzer zzb() {
                return zzby.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzbf, zzb> implements zzfx {
            private zzb() {
                super(zzbf.zzl);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbf> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbf();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzg", zza.zzb(), "zzi", zza.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgf<zzbf> zzgfVar2 = zzm;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbf.class) {
                        zzgf<zzbf> zzgfVar3 = zzm;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzl);
                            zzm = zzaVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzbv, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzbx, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza>] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_vision_common.zzbw, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza>] */
        static {
            zzbf zzbfVar = new zzbf();
            zzl = zzbfVar;
            zzek.zza((Class<zzbf>) zzbf.class, zzbfVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbh extends zzek<zzbh, zza> implements zzfx {
        private static final zzbh zzf;
        private static volatile zzgf<zzbh> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzbh() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzbh, zza> implements zzfx {
            private zza() {
                super(zzbh.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbh> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbh();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzbh> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbh.class) {
                        zzgf<zzbh> zzgfVar3 = zzg;
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
            zzbh zzbhVar = new zzbh();
            zzf = zzbhVar;
            zzek.zza((Class<zzbh>) zzbh.class, zzbhVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzc extends zzek<zzc, zzb> implements zzfx {
        private static final zzc zzg;
        private static volatile zzgf<zzc> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0059zza> implements zzfx {
            private static final zzet<Integer, zzao.zza> zzj = new com.google.android.gms.internal.mlkit_vision_common.zzv();
            private static final zzet<Integer, zzao.zzb> zzl = new com.google.android.gms.internal.mlkit_vision_common.zzu();
            private static final zza zzm;
            private static volatile zzgf<zza> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzcb.zza zzh;
            private zzeq zzi = zzk();
            private zzeq zzk = zzk();

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza, reason: collision with other inner class name */
            public static final class C0059zza extends zzek.zzb<zza, C0059zza> implements zzfx {
                private C0059zza() {
                    super(zza.zzm);
                }

                /* synthetic */ C0059zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r5v21, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0059zza(zztVar);
                    case 3:
                        return zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", zzao.zza.zzb(), "zzk", zzao.zzb.zzb()});
                    case 4:
                        return zzm;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzn;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzn;
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

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza>, com.google.android.gms.internal.mlkit_vision_common.zzv] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb>, com.google.android.gms.internal.mlkit_vision_common.zzu] */
            static {
                zza zzaVar = new zza();
                zzm = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzc() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzc, zzb> implements zzfx {
            private zzb() {
                super(zzc.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzc> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzc> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzc.class) {
                        zzgf<zzc> zzgfVar3 = zzh;
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
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzek.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzd extends zzek<zzd, zzb> implements zzfx {
        private static final zzd zzg;
        private static volatile zzgf<zzd> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0060zza> implements zzfx {
            private static final zza zzj;
            private static volatile zzgf<zza> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza, reason: collision with other inner class name */
            public static final class C0060zza extends zzek.zzb<zza, C0060zza> implements zzfx {
                private C0060zza() {
                    super(zza.zzj);
                }

                /* synthetic */ C0060zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0060zza(zztVar);
                    case 3:
                        return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
                    case 4:
                        return zzj;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzk;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzk;
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
                zza zzaVar = new zza();
                zzj = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzd, zzb> implements zzfx {
            private zzb() {
                super(zzd.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzd> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
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
    public static final class zze extends zzek<zze, zzb> implements zzfx {
        private static final zze zzg;
        private static volatile zzgf<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0061zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza, reason: collision with other inner class name */
            public static final class C0061zza extends zzek.zzb<zza, C0061zza> implements zzfx {
                private C0061zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0061zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0061zza(zztVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzi;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzi;
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
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zze() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zze, zzb> implements zzfx {
            private zzb() {
                super(zze.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zze> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zze> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zze.class) {
                        zzgf<zze> zzgfVar3 = zzh;
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
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzek.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzf extends zzek<zzf, zzb> implements zzfx {
        private static final zzf zzg;
        private static volatile zzgf<zzf> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0062zza> implements zzfx {
            private static final zza zzi;
            private static volatile zzgf<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza, reason: collision with other inner class name */
            public static final class C0062zza extends zzek.zzb<zza, C0062zza> implements zzfx {
                private C0062zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0062zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0062zza(zztVar);
                    case 3:
                        return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg", "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzj;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzj;
                            zzgfVar = zzgfVar3;
                            if (zzgfVar3 == null) {
                                ?? zzaVar = new zzek.zza(zzi);
                                zzj = zzaVar;
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
                zzi = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzf, zzb> implements zzfx {
            private zzb() {
                super(zzf.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzf> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzf> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzf.class) {
                        zzgf<zzf> zzgfVar3 = zzh;
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
            zzf zzfVar = new zzf();
            zzg = zzfVar;
            zzek.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzg extends zzek<zzg, zzb> implements zzfx {
        private static final zzg zzg;
        private static volatile zzgf<zzg> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0063zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza, reason: collision with other inner class name */
            public static final class C0063zza extends zzek.zzb<zza, C0063zza> implements zzfx {
                private C0063zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0063zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0063zza(zztVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzi;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzi;
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
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzg() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzg, zzb> implements zzfx {
            private zzb() {
                super(zzg.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzg> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzg> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzg.class) {
                        zzgf<zzg> zzgfVar3 = zzh;
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
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzek.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzh extends zzek<zzh, zzb> implements zzfx {
        private static final zzh zzg;
        private static volatile zzgf<zzh> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0064zza> implements zzfx {
            private static final zza zzg;
            private static volatile zzgf<zza> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza, reason: collision with other inner class name */
            public static final class C0064zza extends zzek.zzb<zza, C0064zza> implements zzfx {
                private C0064zza() {
                    super(zza.zzg);
                }

                /* synthetic */ C0064zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0064zza(zztVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzh;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzh;
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
                zza zzaVar = new zza();
                zzg = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzh, zzb> implements zzfx {
            private zzb() {
                super(zzh.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzh> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzh> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzh.class) {
                        zzgf<zzh> zzgfVar3 = zzh;
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
            zzh zzhVar = new zzh();
            zzg = zzhVar;
            zzek.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzi extends zzek<zzi, zzb> implements zzfx {
        private static final zzi zzg;
        private static volatile zzgf<zzi> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, C0065zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza, reason: collision with other inner class name */
            public static final class C0065zza extends zzek.zzb<zza, C0065zza> implements zzfx {
                private C0065zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0065zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0065zza(zztVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzgf<zza> zzgfVar2 = zzi;
                        if (zzgfVar2 != null) {
                            return zzgfVar2;
                        }
                        synchronized (zza.class) {
                            zzgf<zza> zzgfVar3 = zzi;
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
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzi() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzi, zzb> implements zzfx {
            private zzb() {
                super(zzi.zzg);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzi> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzi> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzi.class) {
                        zzgf<zzi> zzgfVar3 = zzh;
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
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzek.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzj extends zzek<zzj, zza> implements zzfx {
        private static final zzj zze;
        private static volatile zzgf<zzj> zzf;
        private int zzc;
        private int zzd;

        private zzj() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzj, zza> implements zzfx {
            private zza() {
                super(zzj.zze);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzj> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzgf<zzj> zzgfVar2 = zzf;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzj.class) {
                        zzgf<zzj> zzgfVar3 = zzf;
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
            zzj zzjVar = new zzj();
            zze = zzjVar;
            zzek.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzk extends zzek<zzk, zza> implements zzfx {
        private static final zzk zzi;
        private static volatile zzgf<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        private zzk() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzk, zza> implements zzfx {
            private zza() {
                super(zzk.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzk> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgf<zzk> zzgfVar2 = zzj;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzk.class) {
                        zzgf<zzk> zzgfVar3 = zzj;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzi);
                            zzj = zzaVar;
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
            zzk zzkVar = new zzk();
            zzi = zzkVar;
            zzek.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzl extends zzek<zzl, zza> implements zzfx {
        private static final zzet<Integer, com.google.android.gms.internal.mlkit_vision_common.zzac> zzg = new com.google.android.gms.internal.mlkit_vision_common.zzw();
        private static final zzl zzi;
        private static volatile zzgf<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzeq zzf = zzk();
        private long zzh;

        private zzl() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzl, zza> implements zzfx {
            private zza() {
                super(zzl.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzl> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgf<zzl> zzgfVar2 = zzj;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzl.class) {
                        zzgf<zzl> zzgfVar3 = zzj;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzi);
                            zzj = zzaVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>, com.google.android.gms.internal.mlkit_vision_common.zzw] */
        static {
            zzl zzlVar = new zzl();
            zzi = zzlVar;
            zzek.zza((Class<zzl>) zzl.class, zzlVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzm extends zzek<zzm, zza> implements zzfx {
        private static final zzm zzg;
        private static volatile zzgf<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzm() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzm, zza> implements zzfx {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzm> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzm> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzm.class) {
                        zzgf<zzm> zzgfVar3 = zzh;
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
            zzm zzmVar = new zzm();
            zzg = zzmVar;
            zzek.zza((Class<zzm>) zzm.class, zzmVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzn extends zzek<zzn, zza> implements zzfx {
        private static final zzn zzf;
        private static volatile zzgf<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);

            private static final zzeo<zzb> zzd = new com.google.android.gms.internal.mlkit_vision_common.zzx();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzy.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzn, zza> implements zzfx {
            private zza() {
                super(zzn.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzn> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzb.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzn> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzn.class) {
                        zzgf<zzn> zzgfVar3 = zzg;
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
            zzn zznVar = new zzn();
            zzf = zznVar;
            zzek.zza((Class<zzn>) zzn.class, zznVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzo extends zzek<zzo, zza> implements zzfx {
        private static final zzo zzg;
        private static volatile zzgf<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzo() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzo, zza> implements zzfx {
            private zza() {
                super(zzo.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzo> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzo> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzo.class) {
                        zzgf<zzo> zzgfVar3 = zzh;
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
            zzo zzoVar = new zzo();
            zzg = zzoVar;
            zzek.zza((Class<zzo>) zzo.class, zzoVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzp extends zzek<zzp, zza> implements zzfx {
        private static final zzp zzg;
        private static volatile zzgf<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzp() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzp, zza> implements zzfx {
            private zza() {
                super(zzp.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzp> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzp> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzp.class) {
                        zzgf<zzp> zzgfVar3 = zzh;
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
            zzp zzpVar = new zzp();
            zzg = zzpVar;
            zzek.zza((Class<zzp>) zzp.class, zzpVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzq extends zzek<zzq, zza> implements zzfx {
        private static final zzq zzg;
        private static volatile zzgf<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzq() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzq, zza> implements zzfx {
            private zza() {
                super(zzq.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzq> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzq> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzq.class) {
                        zzgf<zzq> zzgfVar3 = zzh;
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
            zzq zzqVar = new zzq();
            zzg = zzqVar;
            zzek.zza((Class<zzq>) zzq.class, zzqVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzr, reason: collision with other inner class name */
    public static final class C0066zzr extends zzek<C0066zzr, zza> implements zzfx {
        private static final C0066zzr zzg;
        private static volatile zzgf<C0066zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private C0066zzr() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza */
        public static final class zza extends zzek.zzb<C0066zzr, zza> implements zzfx {
            private zza() {
                super(C0066zzr.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<C0066zzr> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new C0066zzr();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<C0066zzr> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (C0066zzr.class) {
                        zzgf<C0066zzr> zzgfVar3 = zzh;
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
            C0066zzr c0066zzr = new C0066zzr();
            zzg = c0066zzr;
            zzek.zza((Class<C0066zzr>) C0066zzr.class, c0066zzr);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzs extends zzek<zzs, zza> implements zzfx {
        private static final zzs zzg;
        private static volatile zzgf<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzs() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzs, zza> implements zzfx {
            private zza() {
                super(zzs.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzs> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzs> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzs.class) {
                        zzgf<zzs> zzgfVar3 = zzh;
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
            zzs zzsVar = new zzs();
            zzg = zzsVar;
            zzek.zza((Class<zzs>) zzs.class, zzsVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzt extends zzek<zzt, zza> implements zzfx {
        private static final zzt zzg;
        private static volatile zzgf<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzt() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzt, zza> implements zzfx {
            private zza() {
                super(zzt.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzt> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzt> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzt.class) {
                        zzgf<zzt> zzgfVar3 = zzh;
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
            zzt zztVar = new zzt();
            zzg = zztVar;
            zzek.zza((Class<zzt>) zzt.class, zztVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzu extends zzek<zzu, zza> implements zzfx {
        private static final zzu zzg;
        private static volatile zzgf<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzu() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzu, zza> implements zzfx {
            private zza() {
                super(zzu.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzu> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzu> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzu.class) {
                        zzgf<zzu> zzgfVar3 = zzh;
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
            zzu zzuVar = new zzu();
            zzg = zzuVar;
            zzek.zza((Class<zzu>) zzu.class, zzuVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzv extends zzek<zzv, zza> implements zzfx {
        private static final zzv zzg;
        private static volatile zzgf<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzv() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzv, zza> implements zzfx {
            private zza() {
                super(zzv.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzv> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzv> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzv.class) {
                        zzgf<zzv> zzgfVar3 = zzh;
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
            zzv zzvVar = new zzv();
            zzg = zzvVar;
            zzek.zza((Class<zzv>) zzv.class, zzvVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzw extends zzek<zzw, zza> implements zzfx {
        private static final zzw zzg;
        private static volatile zzgf<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzw() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzw, zza> implements zzfx {
            private zza() {
                super(zzw.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzw> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzgf<zzw> zzgfVar2 = zzh;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzw.class) {
                        zzgf<zzw> zzgfVar3 = zzh;
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
            zzw zzwVar = new zzw();
            zzg = zzwVar;
            zzek.zza((Class<zzw>) zzw.class, zzwVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzx extends zzek<zzx, zza> implements zzfx {
        private static final zzx zzf;
        private static volatile zzgf<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        private zzx() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzx, zza> implements zzfx {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzx> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzgf<zzx> zzgfVar2 = zzg;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzx.class) {
                        zzgf<zzx> zzgfVar3 = zzg;
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
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zzek.zza((Class<zzx>) zzx.class, zzxVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzy extends zzek<zzy, zzb> implements zzfx {
        private static final zzy zzi;
        private static volatile zzgf<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzes<zza> zzf = zzl();
        private zzes<zza> zzg = zzl();
        private long zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek<zza, zzb> implements zzfx {
            private static final zza zzf;
            private static volatile zzgf<zza> zzg;
            private int zzc;
            private int zzd;
            private zzeq zze = zzk();

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zza, reason: collision with other inner class name */
            public enum EnumC0067zza implements zzep {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);

                private static final zzeo<EnumC0067zza> zzf = new com.google.android.gms.internal.mlkit_vision_common.zzaa();
                private final int zzg;

                @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
                public final int zza() {
                    return this.zzg;
                }

                public static zzer zzb() {
                    return com.google.android.gms.internal.mlkit_vision_common.zzz.zza;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
                }

                EnumC0067zza(int i) {
                    this.zzg = i;
                }
            }

            private zza() {
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            public static final class zzb extends zzek.zzb<zza, zzb> implements zzfx {
                private zzb() {
                    super(zza.zzf);
                }

                /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza>] */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            protected final Object zza(int i, Object obj, Object obj2) {
                zzgf<zza> zzgfVar;
                com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new zzb(zztVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzc", "zzd", EnumC0067zza.zzb(), "zze"});
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

        private zzy() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zzb extends zzek.zzb<zzy, zzb> implements zzfx {
            private zzb() {
                super(zzy.zzi);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzy> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zzb(zztVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.class, "zzg", zza.class, "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgf<zzy> zzgfVar2 = zzj;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzy.class) {
                        zzgf<zzy> zzgfVar3 = zzj;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzi);
                            zzj = zzaVar;
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
            zzy zzyVar = new zzy();
            zzi = zzyVar;
            zzek.zza((Class<zzy>) zzy.class, zzyVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzz extends zzek<zzz, zza> implements zzfx {
        private static final zzet<Integer, com.google.android.gms.internal.mlkit_vision_common.zzac> zzg = new com.google.android.gms.internal.mlkit_vision_common.zzab();
        private static final zzz zzj;
        private static volatile zzgf<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzeq zzf = zzk();
        private long zzh;
        private boolean zzi;

        private zzz() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzz, zza> implements zzfx {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzz> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", com.google.android.gms.internal.mlkit_vision_common.zzac.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgf<zzz> zzgfVar2 = zzk;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzz.class) {
                        zzgf<zzz> zzgfVar3 = zzk;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzab, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zzek.zza((Class<zzz>) zzz.class, zzzVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzag extends zzek<zzag, zza> implements zzfx {
        private static final zzag zzk;
        private static volatile zzgf<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public enum zzb implements zzep {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);

            private static final zzeo<zzb> zzg = new com.google.android.gms.internal.mlkit_vision_common.zzas();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzh;
            }

            public static zzer zzb() {
                return com.google.android.gms.internal.mlkit_vision_common.zzat.zza;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzag, zza> implements zzfx {
            private zza() {
                super(zzag.zzk);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(j);
                return this;
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zza(zzae.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(zzaVar);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzb(i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzc(i);
                return this;
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzd(i);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zze = zzbVar.zza();
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzae.zza zzaVar) {
            this.zzf = zzaVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 8;
            this.zzg = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(int i) {
            this.zzc |= 16;
            this.zzh = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 32;
            this.zzi = i;
        }

        public static zza zza() {
            return zzk.zzh();
        }

        /* JADX WARN: Type inference failed for: r4v19, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzag> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzag();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", zzb.zzb(), "zzf", zzae.zza.zzb(), "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzgf<zzag> zzgfVar2 = zzl;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzag.class) {
                        zzgf<zzag> zzgfVar3 = zzl;
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
            zzag zzagVar = new zzag();
            zzk = zzagVar;
            zzek.zza((Class<zzag>) zzag.class, zzagVar);
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static final class zzbg extends zzek<zzbg, zza> implements zzfx {
        private static final zzbg zzo;
        private static volatile zzgf<zzbg> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzes<String> zzk = zzek.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        private zzbg() {
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        public static final class zza extends zzek.zzb<zzbg, zza> implements zzfx {
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

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_common.zzt zztVar) {
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
            zzes<String> zzesVar = this.zzk;
            if (!zzesVar.zza()) {
                int size = zzesVar.size();
                this.zzk = zzesVar.zzb(size == 0 ? 10 : size << 1);
            }
            zzda.zza(iterable, this.zzk);
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

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg>] */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgf<zzbg> zzgfVar;
            com.google.android.gms.internal.mlkit_vision_common.zzt zztVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_common.zzt.zza[i - 1]) {
                case 1:
                    return new zzbg();
                case 2:
                    return new zza(zztVar);
                case 3:
                    return zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzgf<zzbg> zzgfVar2 = zzp;
                    if (zzgfVar2 != null) {
                        return zzgfVar2;
                    }
                    synchronized (zzbg.class) {
                        zzgf<zzbg> zzgfVar3 = zzp;
                        zzgfVar = zzgfVar3;
                        if (zzgfVar3 == null) {
                            ?? zzaVar = new zzek.zza(zzo);
                            zzp = zzaVar;
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

        public static zzbg zzc() {
            return zzo;
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzo = zzbgVar;
            zzek.zza((Class<zzbg>) zzbg.class, zzbgVar);
        }
    }
}
