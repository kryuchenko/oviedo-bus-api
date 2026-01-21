package com.google.android.gms.internal.mlkit_vision_text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.mlkit_vision_text.zzdo;
import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import com.google.android.gms.internal.mlkit_vision_text.zzji;
import com.google.api.client.http.HttpStatusCodes;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzbh {

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zza extends zzfy<zza, C0068zza> implements zzhi {
        private static final zza zzg;
        private static volatile zzhq<zza> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, C0069zza> implements zzhi {
            private static final zzb zzh;
            private static volatile zzhq<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zza$zzb$zza, reason: collision with other inner class name */
            public static final class C0069zza extends zzfy.zza<zzb, C0069zza> implements zzhi {
                private C0069zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ C0069zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zza$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0069zza(zzbgVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzi;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzi;
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
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zza$zza, reason: collision with other inner class name */
        public static final class C0068zza extends zzfy.zza<zza, C0068zza> implements zzhi {
            private C0068zza() {
                super(zza.zzg);
            }

            /* synthetic */ C0068zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zza>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zza> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0068zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zza> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zza.class) {
                        zzhq<zza> zzhqVar3 = zzh;
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
            zza zzaVar = new zza();
            zzg = zzaVar;
            zzfy.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzaa extends zzfy<zzaa, zza> implements zzhi {
        private static final zzaa zzf;
        private static volatile zzhq<zzaa> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        private zzaa() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzaa, zza> implements zzhi {
            private zza() {
                super(zzaa.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzaa>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzaa> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzc", "zzd", zzal.zzb.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzaa> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzaa.class) {
                        zzhq<zzaa> zzhqVar3 = zzg;
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
            zzaa zzaaVar = new zzaa();
            zzf = zzaaVar;
            zzfy.zza((Class<zzaa>) zzaa.class, zzaaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzac extends zzfy<zzac, zza> implements zzhi {
        private static final zzac zzj;
        private static volatile zzhq<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);

            private static final zzgd<zzb> zzd = new zzbw();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzc implements zzga {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);

            private static final zzgd<zzc> zzd = new zzbz();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzd implements zzga {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);

            private static final zzgd<zzd> zzd = new zzca();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
                return zzcb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzd(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zze implements zzga {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);

            private static final zzgd<zze> zzd = new zzcd();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
                return zzcc.zza;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzac, zza> implements zzhi {
            private zza() {
                super(zzac.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r6v21, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzac>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzac> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzb.zzb(), "zzf", zze.zzb(), "zzg", zzc.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzac> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzac.class) {
                        zzhq<zzac> zzhqVar3 = zzk;
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
            zzac zzacVar = new zzac();
            zzj = zzacVar;
            zzfy.zza((Class<zzac>) zzac.class, zzacVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzad extends zzfy.zze<zzad, zza> implements zzhi {
        private static final zzad zzbd;
        private static volatile zzhq<zzad> zzbe;
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
        private zzgh<zzji.zzf> zzay = zzl();

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zzb<zzad, zza> implements zzhi {
            private zza() {
                super(zzad.zzbd);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
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
                ((zzad) this.zza).zza((zzbg) ((zzfy) zzaVar.zzh()));
                return this;
            }

            public final zza zza(zzbs zzbsVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzbsVar);
                return this;
            }

            public final zza zza(zzbd zzbdVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzbdVar);
                return this;
            }

            public final zza zza(zzi.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzi) ((zzfy) zzaVar.zzh()));
                return this;
            }
        }

        static {
            zzad zzadVar = new zzad();
            zzbd = zzadVar;
            zzfy.zza((Class<zzad>) zzad.class, zzadVar);
        }

        private zzad() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static zza zza(zzad zzadVar) {
            return (zza) zzbd.zza(zzadVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbd zzbdVar) {
            zzbdVar.getClass();
            this.zzn = zzbdVar;
            this.zzd |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzf = zzbgVar;
            this.zzd |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzi zziVar) {
            zziVar.getClass();
            this.zzav = zziVar;
            this.zze |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbs zzbsVar) {
            this.zzg = zzbsVar.zza();
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

        /* JADX WARN: Type inference failed for: r3v61, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzad>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzad> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzbd, "\u00011\u0000\u0002\u000131\u0000\u0001\u0001\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0003\u0004ဉ\u0005\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဉ\u0015\tဉ\u0016\nဉ\u0017\u000bဉ\u0018\fဉ\u0019\rဉ\u001a\u000eဉ\u001b\u000fဉ\u001c\u0010ဉ\u001d\u0011ဉ\u001e\u0012ဉ\f\u0013ဉ\u0012\u0014ဉ\u0004\u0015ဉ\u0013\u0016ဉ\u0014\u0017ဉ\u001f\u0018ဉ \u0019ဉ!\u001aဉ\r\u001bဉ\u000e\u001cဉ\u000f\u001dဉ\u0006\u001eဉ$\u001fဉ% ဉ&!ဉ'\"ဉ(#ဉ)$ဉ*%ဇ\u0002'ဉ\"(ဉ#)Л*ဉ-,ဉ\u0010-ဉ\u0011.ဉ+/ဉ,0ဉ\n1ဉ\u000b2ဉ.3ဉ/", new Object[]{"zzd", "zze", "zzf", "zzg", zzbs.zzb(), "zzi", "zzk", "zzm", "zzn", "zzo", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzr", "zzx", "zzj", "zzy", "zzz", "zzak", "zzal", "zzam", "zzs", "zzt", "zzu", "zzl", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzh", "zzan", "zzao", "zzay", zzji.zzf.class, "zzaz", "zzv", "zzw", "zzaw", "zzax", "zzp", "zzq", "zzba", "zzbb"});
                case 4:
                    return zzbd;
                case 5:
                    zzhq<zzad> zzhqVar2 = zzbe;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzad.class) {
                        zzhq<zzad> zzhqVar3 = zzbe;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzbd);
                            zzbe = zzcVar;
                            zzhqVar = zzcVar;
                        }
                    }
                    return zzhqVar;
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

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzag extends zzfy<zzag, zzb> implements zzhi {
        private static final zzag zzk;
        private static volatile zzhq<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);

            private static final zzgd<zza> zzg = new zzch();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzh;
            }

            public static zzgc zzb() {
                return zzcg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzh = i;
            }
        }

        private zzag() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzag, zzb> implements zzhi {
            private zzb() {
                super(zzag.zzk);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v19, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzag>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzag> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzag();
                case 2:
                    return new zzb(zzbgVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzf", zzae.zzb.zzb(), "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhq<zzag> zzhqVar2 = zzl;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzag.class) {
                        zzhq<zzag> zzhqVar3 = zzl;
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
            zzag zzagVar = new zzag();
            zzk = zzagVar;
            zzfy.zza((Class<zzag>) zzag.class, zzagVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzah extends zzfy<zzah, zza> implements zzhi {
        private static final zzah zzf;
        private static volatile zzhq<zzah> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        private zzah() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzah, zza> implements zzhi {
            private zza() {
                super(zzah.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzah>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzah> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzah();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzc", "zzd", zzal.zzb.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzah> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzah.class) {
                        zzhq<zzah> zzhqVar3 = zzg;
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
            zzah zzahVar = new zzah();
            zzf = zzahVar;
            zzfy.zza((Class<zzah>) zzah.class, zzahVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzai extends zzfy<zzai, zza> implements zzhi {
        private static final zzai zzg;
        private static volatile zzhq<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        private zzai() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzai, zza> implements zzhi {
            private zza() {
                super(zzai.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzai>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzai> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzai();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzai> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzai.class) {
                        zzhq<zzai> zzhqVar3 = zzh;
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
            zzai zzaiVar = new zzai();
            zzg = zzaiVar;
            zzfy.zza((Class<zzai>) zzai.class, zzaiVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzaj extends zzfy<zzaj, zzb> implements zzhi {
        private static final zzaj zze;
        private static volatile zzhq<zzaj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            UNKNOWN(0),
            TRANSLATE(1);

            private static final zzgd<zza> zzc = new zzcj();
            private final int zzd;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzd;
            }

            public static zzgc zzb() {
                return zzci.zza;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzaj, zzb> implements zzhi {
            private zzb() {
                super(zzaj.zze);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzaj>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzaj> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzaj();
                case 2:
                    return new zzb(zzbgVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", zza.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzhq<zzaj> zzhqVar2 = zzf;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzaj.class) {
                        zzhq<zzaj> zzhqVar3 = zzf;
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
            zzaj zzajVar = new zzaj();
            zze = zzajVar;
            zzfy.zza((Class<zzaj>) zzaj.class, zzajVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzak extends zzfy<zzak, zzb> implements zzhi {
        private static final zzak zzj;
        private static volatile zzhq<zzak> zzk;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
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

            private static final zzgd<zza> zzm = new zzcl();
            private final int zzn;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzn;
            }

            public static zzgc zzb() {
                return zzck.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzn = i;
            }
        }

        private zzak() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzak, zzb> implements zzhi {
            private zzb() {
                super(zzak.zzj);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v17, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzak>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzak> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzak();
                case 2:
                    return new zzb(zzbgVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", zzbr.zzb(), "zzg", "zzh", zza.zzb(), "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzak> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzak.class) {
                        zzhq<zzak> zzhqVar3 = zzk;
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
            zzak zzakVar = new zzak();
            zzj = zzakVar;
            zzfy.zza((Class<zzak>) zzak.class, zzakVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzal extends zzfy<zzal, zza> implements zzhi {
        private static final zzal zzl;
        private static volatile zzhq<zzal> zzm;
        private int zzc;
        private int zzf;
        private int zzi;
        private long zzj;
        private boolean zzk;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5);

            private static final zzgd<zzb> zzg = new zzcm();
            private final int zzh;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzh;
            }

            public static zzgc zzb() {
                return zzcn.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzh = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzc implements zzga {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);

            private static final zzgd<zzc> zzf = new zzcp();
            private final int zzg;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzg;
            }

            public static zzgc zzb() {
                return zzco.zza;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzal, zza> implements zzhi {
            private zza() {
                super(zzal.zzl);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v19, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzal>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzal> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzal();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.zzb(), "zzg", "zzh", "zzi", zzb.zzb(), "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhq<zzal> zzhqVar2 = zzm;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzal.class) {
                        zzhq<zzal> zzhqVar3 = zzm;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzl);
                            zzm = zzcVar;
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
            zzal zzalVar = new zzal();
            zzl = zzalVar;
            zzfy.zza((Class<zzal>) zzal.class, zzalVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzam extends zzfy<zzam, zza> implements zzhi {
        private static final zzam zzh;
        private static volatile zzhq<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zzb zze;
        private zzb zzf;
        private boolean zzg;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzh;
            private static volatile zzhq<zzb> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzam$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzi;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzi;
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
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zzam() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzam, zza> implements zzhi {
            private zza() {
                super(zzam.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzam>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzam> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzam();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhq<zzam> zzhqVar2 = zzi;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzam.class) {
                        zzhq<zzam> zzhqVar3 = zzi;
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
            zzam zzamVar = new zzam();
            zzh = zzamVar;
            zzfy.zza((Class<zzam>) zzam.class, zzamVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzan extends zzfy<zzan, zza> implements zzhi {
        private static final zzan zzh;
        private static volatile zzhq<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);

            private static final zzgd<zzb> zzh = new zzcq();
            private final int zzi;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzi;
            }

            public static zzgc zzb() {
                return zzcr.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzi = i;
            }
        }

        private zzan() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzan, zza> implements zzhi {
            private zza() {
                super(zzan.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzan>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzan> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzan();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhq<zzan> zzhqVar2 = zzi;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzan.class) {
                        zzhq<zzan> zzhqVar3 = zzi;
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
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zzfy.zza((Class<zzan>) zzan.class, zzanVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzao extends zzfy<zzao, zzc> implements zzhi {
        private static final zzge<Integer, zza> zzg = new zzct();
        private static final zzge<Integer, zzb> zzi = new zzcs();
        private static final zzao zzk;
        private static volatile zzhq<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzdo.zza zze;
        private zzgf zzf = zzk();
        private zzgf zzh = zzk();
        private zzae zzj;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
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

            private static final zzgd<zza> zzo = new zzcu();
            private final int zzp;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzp;
            }

            public static zzgc zzb() {
                return zzcv.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzp = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
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

            private static final zzgd<zzb> zzn = new zzcx();
            private final int zzo;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzo;
            }

            public static zzgc zzb() {
                return zzcw.zza;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzc extends zzfy.zza<zzao, zzc> implements zzhi {
            private zzc() {
                super(zzao.zzk);
            }

            /* synthetic */ zzc(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v16, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzao>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzao> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzao();
                case 2:
                    return new zzc(zzbgVar);
                case 3:
                    return zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.zzb(), "zzh", zzb.zzb(), "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhq<zzao> zzhqVar2 = zzl;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzao.class) {
                        zzhq<zzao> zzhqVar3 = zzl;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzct, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzao$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_text.zzcs, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzao$zzb>] */
        static {
            zzao zzaoVar = new zzao();
            zzk = zzaoVar;
            zzfy.zza((Class<zzao>) zzao.class, zzaoVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzap extends zzfy<zzap, zza> implements zzhi {
        private static final zzap zzj;
        private static volatile zzhq<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzdo.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        private zzap() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzap, zza> implements zzhi {
            private zza() {
                super(zzap.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzap>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzap> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzap();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzap> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzap.class) {
                        zzhq<zzap> zzhqVar3 = zzk;
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
            zzap zzapVar = new zzap();
            zzj = zzapVar;
            zzfy.zza((Class<zzap>) zzap.class, zzapVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzaq extends zzfy<zzaq, zza> implements zzhi {
        private static final zzaq zzf;
        private static volatile zzhq<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        private zzaq() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzaq, zza> implements zzhi {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzaq>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzaq> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzaq();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzbr.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzaq> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzaq.class) {
                        zzhq<zzaq> zzhqVar3 = zzg;
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
            zzaq zzaqVar = new zzaq();
            zzf = zzaqVar;
            zzfy.zza((Class<zzaq>) zzaq.class, zzaqVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzar extends zzfy<zzar, zza> implements zzhi {
        private static final zzar zzi;
        private static volatile zzhq<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        private zzar() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzar, zza> implements zzhi {
            private zza() {
                super(zzar.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzar>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzar> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzar();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhq<zzar> zzhqVar2 = zzj;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzar.class) {
                        zzhq<zzar> zzhqVar3 = zzj;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzi);
                            zzj = zzcVar;
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
            zzar zzarVar = new zzar();
            zzi = zzarVar;
            zzfy.zza((Class<zzar>) zzar.class, zzarVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzas extends zzfy<zzas, zza> implements zzhi {
        private static final zzge<Integer, zzbr> zzf = new zzcy();
        private static final zzas zzi;
        private static volatile zzhq<zzas> zzj;
        private int zzc;
        private zzat zzd;
        private zzgf zze = zzk();
        private long zzg;
        private long zzh;

        private zzas() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzas, zza> implements zzhi {
            private zza() {
                super(zzas.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzas>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzas> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzas();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", zzbr.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhq<zzas> zzhqVar2 = zzj;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzas.class) {
                        zzhq<zzas> zzhqVar3 = zzj;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzi);
                            zzj = zzcVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzcy, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbr>] */
        static {
            zzas zzasVar = new zzas();
            zzi = zzasVar;
            zzfy.zza((Class<zzas>) zzas.class, zzasVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzat extends zzfy<zzat, zza> implements zzhi {
        private static final zzat zzg;
        private static volatile zzhq<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        private zzat() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzat, zza> implements zzhi {
            private zza() {
                super(zzat.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzat>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzat> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzat();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzat> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzat.class) {
                        zzhq<zzat> zzhqVar3 = zzh;
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
            zzat zzatVar = new zzat();
            zzg = zzatVar;
            zzfy.zza((Class<zzat>) zzat.class, zzatVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzau extends zzfy<zzau, zza> implements zzhi {
        private static final zzau zzh;
        private static volatile zzhq<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzf;
            private static volatile zzhq<zzb> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzau$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
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
        public static final class zzc extends zzfy<zzc, zza> implements zzhi {
            private static final zzc zze;
            private static volatile zzhq<zzc> zzf;
            private int zzc;
            private zzb zzd;

            private zzc() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzc, zza> implements zzhi {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzau$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzc> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzhq<zzc> zzhqVar2 = zzf;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzc.class) {
                            zzhq<zzc> zzhqVar3 = zzf;
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
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzfy.zza((Class<zzc>) zzc.class, zzcVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzd extends zzfy<zzd, zza> implements zzhi {
            private static final zzd zzd;
            private static volatile zzhq<zzd> zze;
            private zzgh<zzb> zzc = zzl();

            private zzd() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzd, zza> implements zzhi {
                private zza() {
                    super(zzd.zzd);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzau$zzd>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzd> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzb.class});
                    case 4:
                        return zzd;
                    case 5:
                        zzhq<zzd> zzhqVar2 = zze;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzd.class) {
                            zzhq<zzd> zzhqVar3 = zze;
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
                zzd zzdVar = new zzd();
                zzd = zzdVar;
                zzfy.zza((Class<zzd>) zzd.class, zzdVar);
            }
        }

        private zzau() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzau, zza> implements zzhi {
            private zza() {
                super(zzau.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzau>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzau> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzau();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhq<zzau> zzhqVar2 = zzi;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzau.class) {
                        zzhq<zzau> zzhqVar3 = zzi;
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
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zzfy.zza((Class<zzau>) zzau.class, zzauVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzav extends zzfy<zzav, zza> implements zzhi {
        private static final zzav zzf;
        private static volatile zzhq<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        private zzav() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzav, zza> implements zzhi {
            private zza() {
                super(zzav.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzav>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzav> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzav();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzbr.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzav> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzav.class) {
                        zzhq<zzav> zzhqVar3 = zzg;
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
            zzav zzavVar = new zzav();
            zzf = zzavVar;
            zzfy.zza((Class<zzav>) zzav.class, zzavVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzaw extends zzfy<zzaw, zza> implements zzhi {
        private static final zzaw zzj;
        private static volatile zzhq<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);

            private static final zzgd<zzb> zzd = new zzcz();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
                return zzda.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zze = i;
            }
        }

        private zzaw() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzaw, zza> implements zzhi {
            private zza() {
                super(zzaw.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzaw>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzaw> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzaw();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzaw> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzaw.class) {
                        zzhq<zzaw> zzhqVar3 = zzk;
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
            zzaw zzawVar = new zzaw();
            zzj = zzawVar;
            zzfy.zza((Class<zzaw>) zzaw.class, zzawVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzax extends zzfy<zzax, zza> implements zzhi {
        private static final zzax zzh;
        private static volatile zzhq<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzgh<zzan> zzg = zzl();

        private zzax() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzax, zza> implements zzhi {
            private zza() {
                super(zzax.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzax>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzax> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzax();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzan.class});
                case 4:
                    return zzh;
                case 5:
                    zzhq<zzax> zzhqVar2 = zzi;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzax.class) {
                        zzhq<zzax> zzhqVar3 = zzi;
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
            zzax zzaxVar = new zzax();
            zzh = zzaxVar;
            zzfy.zza((Class<zzax>) zzax.class, zzaxVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzay extends zzfy<zzay, zza> implements zzhi {
        private static final zzay zzh;
        private static volatile zzhq<zzay> zzi;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;

        private zzay() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzay, zza> implements zzhi {
            private zza() {
                super(zzay.zzh);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzay>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzay> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzay();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003", new Object[]{"zzc", "zzd", "zze", zzbr.zzb(), "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhq<zzay> zzhqVar2 = zzi;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzay.class) {
                        zzhq<zzay> zzhqVar3 = zzi;
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
            zzay zzayVar = new zzay();
            zzh = zzayVar;
            zzfy.zza((Class<zzay>) zzay.class, zzayVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzaz extends zzfy<zzaz, zza> implements zzhi {
        private static final zzaz zzg;
        private static volatile zzhq<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        private zzaz() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzaz, zza> implements zzhi {
            private zza() {
                super(zzaz.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzaz>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzaz> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzaz();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzaz> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzaz.class) {
                        zzhq<zzaz> zzhqVar3 = zzh;
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
            zzaz zzazVar = new zzaz();
            zzg = zzazVar;
            zzfy.zza((Class<zzaz>) zzaz.class, zzazVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzb extends zzfy<zzb, zza> implements zzhi {
        private static final zzb zzg;
        private static volatile zzhq<zzb> zzh;
        private int zzc;
        private C0070zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zzb$zzb, reason: collision with other inner class name */
        public static final class C0070zzb extends zzfy<C0070zzb, zza> implements zzhi {
            private static final C0070zzb zzi;
            private static volatile zzhq<C0070zzb> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzgh<zzy.zzb> zzf = zzl();
            private zzgh<zzy.zzb> zzg = zzl();
            private zzam zzh;

            private C0070zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zzb$zzb$zza */
            public static final class zza extends zzfy.zza<C0070zzb, zza> implements zzhi {
                private zza() {
                    super(C0070zzb.zzi);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzb$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<C0070zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new C0070zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", zzy.zzb.class, "zzg", zzy.zzb.class, "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzhq<C0070zzb> zzhqVar2 = zzj;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (C0070zzb.class) {
                            zzhq<C0070zzb> zzhqVar3 = zzj;
                            zzhqVar = zzhqVar3;
                            if (zzhqVar3 == null) {
                                ?? zzcVar = new zzfy.zzc(zzi);
                                zzj = zzcVar;
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
                C0070zzb c0070zzb = new C0070zzb();
                zzi = c0070zzb;
                zzfy.zza((Class<C0070zzb>) C0070zzb.class, c0070zzb);
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
            private zza() {
                super(zzb.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzb> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzb> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzb.class) {
                        zzhq<zzb> zzhqVar3 = zzh;
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
            zzb zzbVar = new zzb();
            zzg = zzbVar;
            zzfy.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzba extends zzfy<zzba, zzb> implements zzhi {
        private static final zzba zzf;
        private static volatile zzhq<zzba> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);

            private static final zzgd<zza> zzd = new zzdc();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
                return zzdb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzc implements zzga {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);

            private static final zzgd<zzc> zzd = new zzdd();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
                return zzde.zza;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzba, zzb> implements zzhi {
            private zzb() {
                super(zzba.zzf);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzba>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzba> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzba();
                case 2:
                    return new zzb(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zzc.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzba> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzba.class) {
                        zzhq<zzba> zzhqVar3 = zzg;
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
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzfy.zza((Class<zzba>) zzba.class, zzbaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzbb extends zzfy<zzbb, zza> implements zzhi {
        private static final zzbb zzf;
        private static volatile zzhq<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        private zzbb() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzbb, zza> implements zzhi {
            private zza() {
                super(zzbb.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbb>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzbb> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzbb();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzbb> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzbb.class) {
                        zzhq<zzbb> zzhqVar3 = zzg;
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
            zzbb zzbbVar = new zzbb();
            zzf = zzbbVar;
            zzfy.zza((Class<zzbb>) zzbb.class, zzbbVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzbc extends zzfy<zzbc, zzb> implements zzhi {
        private static final zzbc zzi;
        private static volatile zzhq<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzgh<zzc> zze = zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);

            private static final zzgd<zza> zzh = new zzdg();
            private final int zzi;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzi;
            }

            public static zzgc zzb() {
                return zzdf.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.zzi = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzc extends zzfy<zzc, zza> implements zzhi {
            private static final zzc zze;
            private static volatile zzhq<zzc> zzf;
            private int zzc;
            private float zzd;

            private zzc() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzc, zza> implements zzhi {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbc$zzc>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzc> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzhq<zzc> zzhqVar2 = zzf;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzc.class) {
                            zzhq<zzc> zzhqVar3 = zzf;
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
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzfy.zza((Class<zzc>) zzc.class, zzcVar);
            }
        }

        private zzbc() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzbc, zzb> implements zzhi {
            private zzb() {
                super(zzbc.zzi);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbc>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzbc> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzbc();
                case 2:
                    return new zzb(zzbgVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzc.class, "zzf", zza.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhq<zzbc> zzhqVar2 = zzj;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzbc.class) {
                        zzhq<zzbc> zzhqVar3 = zzj;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzi);
                            zzj = zzcVar;
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
            zzbc zzbcVar = new zzbc();
            zzi = zzbcVar;
            zzfy.zza((Class<zzbc>) zzbc.class, zzbcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzbe extends zzfy<zzbe, zza> implements zzhi {
        private static final zzbe zzl;
        private static volatile zzhq<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private C0071zzbh zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
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

            private static final zzgd<zzb> zzai = new zzdh();
            private final int zzaj;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzaj;
            }

            public static zzgc zzb() {
                return zzdi.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzaj = i;
            }
        }

        private zzbe() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzbe, zza> implements zzhi {
            private zza() {
                super(zzbe.zzl);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbe>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzbe> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzbe();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzb.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhq<zzbe> zzhqVar2 = zzm;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzbe.class) {
                        zzhq<zzbe> zzhqVar3 = zzm;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzl);
                            zzm = zzcVar;
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
            zzbe zzbeVar = new zzbe();
            zzl = zzbeVar;
            zzfy.zza((Class<zzbe>) zzbe.class, zzbeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzbf extends zzfy<zzbf, zza> implements zzhi {
        private static final zzge<Integer, zzb> zzf = new zzdk();
        private static final zzge<Integer, zzb> zzh = new zzdj();
        private static final zzge<Integer, zzb> zzj = new zzdl();
        private static final zzbf zzl;
        private static volatile zzhq<zzbf> zzm;
        private int zzc;
        private long zzd;
        private zzgf zze = zzk();
        private zzgf zzg = zzk();
        private zzgf zzi = zzk();
        private int zzk;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
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

            private static final zzgd<zzb> zzm = new zzdm();
            private final int zzn;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzn;
            }

            public static zzgc zzb() {
                return zzdn.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzn = i;
            }
        }

        private zzbf() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzbf, zza> implements zzhi {
            private zza() {
                super(zzbf.zzl);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzbf> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzbf();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001", new Object[]{"zzc", "zzd", "zze", zzb.zzb(), "zzg", zzb.zzb(), "zzi", zzb.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhq<zzbf> zzhqVar2 = zzm;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzbf.class) {
                        zzhq<zzbf> zzhqVar3 = zzm;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzl);
                            zzm = zzcVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzdk, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbf$zzb>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_text.zzdj, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbf$zzb>] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_vision_text.zzdl, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbf$zzb>] */
        static {
            zzbf zzbfVar = new zzbf();
            zzl = zzbfVar;
            zzfy.zza((Class<zzbf>) zzbf.class, zzbfVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbh, reason: collision with other inner class name */
    public static final class C0071zzbh extends zzfy<C0071zzbh, zza> implements zzhi {
        private static final C0071zzbh zzf;
        private static volatile zzhq<C0071zzbh> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private C0071zzbh() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbh$zza */
        public static final class zza extends zzfy.zza<C0071zzbh, zza> implements zzhi {
            private zza() {
                super(C0071zzbh.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbh>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<C0071zzbh> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new C0071zzbh();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<C0071zzbh> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (C0071zzbh.class) {
                        zzhq<C0071zzbh> zzhqVar3 = zzg;
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
            C0071zzbh c0071zzbh = new C0071zzbh();
            zzf = c0071zzbh;
            zzfy.zza((Class<C0071zzbh>) C0071zzbh.class, c0071zzbh);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzc extends zzfy<zzc, zza> implements zzhi {
        private static final zzc zzg;
        private static volatile zzhq<zzc> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzge<Integer, zzao.zza> zzj = new zzbi();
            private static final zzge<Integer, zzao.zzb> zzl = new zzbj();
            private static final zzb zzm;
            private static volatile zzhq<zzb> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzdo.zza zzh;
            private zzgf zzi = zzk();
            private zzgf zzk = zzk();

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzm);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r5v21, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzc$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", zzao.zza.zzb(), "zzk", zzao.zzb.zzb()});
                    case 4:
                        return zzm;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzn;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzn;
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

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzbi, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzao$zza>] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_text.zzbj, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbh$zzao$zzb>] */
            static {
                zzb zzbVar = new zzb();
                zzm = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzc, zza> implements zzhi {
            private zza() {
                super(zzc.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzc>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzc> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzc> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzc.class) {
                        zzhq<zzc> zzhqVar3 = zzh;
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
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzfy.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzd extends zzfy<zzd, zza> implements zzhi {
        private static final zzd zzg;
        private static volatile zzhq<zzd> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzj;
            private static volatile zzhq<zzb> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzj);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzd$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
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

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzd, zza> implements zzhi {
            private zza() {
                super(zzd.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzd>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzd> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
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
    public static final class zze extends zzfy<zze, zza> implements zzhi {
        private static final zze zzg;
        private static volatile zzhq<zze> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzh;
            private static volatile zzhq<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zze$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzi;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzi;
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
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zze, zza> implements zzhi {
            private zza() {
                super(zze.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zze>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zze> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zze> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zze.class) {
                        zzhq<zze> zzhqVar3 = zzh;
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
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzfy.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzf extends zzfy<zzf, zza> implements zzhi {
        private static final zzf zzg;
        private static volatile zzhq<zzf> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzi;
            private static volatile zzhq<zzb> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzi);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzf$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg", "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzj;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzj;
                            zzhqVar = zzhqVar3;
                            if (zzhqVar3 == null) {
                                ?? zzcVar = new zzfy.zzc(zzi);
                                zzj = zzcVar;
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
                zzi = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzf, zza> implements zzhi {
            private zza() {
                super(zzf.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzf> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzf> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzf.class) {
                        zzhq<zzf> zzhqVar3 = zzh;
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
            zzf zzfVar = new zzf();
            zzg = zzfVar;
            zzfy.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzg extends zzfy<zzg, zza> implements zzhi {
        private static final zzg zzg;
        private static volatile zzhq<zzg> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzh;
            private static volatile zzhq<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzg$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzi;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzi;
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
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzg, zza> implements zzhi {
            private zza() {
                super(zzg.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzg>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzg> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzg> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzg.class) {
                        zzhq<zzg> zzhqVar3 = zzh;
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
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzfy.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzh extends zzfy<zzh, zza> implements zzhi {
        private static final zzh zzg;
        private static volatile zzhq<zzh> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzg;
            private static volatile zzhq<zzb> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzg);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzh$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzh;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzh;
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
                zzb zzbVar = new zzb();
                zzg = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzh, zza> implements zzhi {
            private zza() {
                super(zzh.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzh>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzh> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzh> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzh.class) {
                        zzhq<zzh> zzhqVar3 = zzh;
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
            zzh zzhVar = new zzh();
            zzg = zzhVar;
            zzfy.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzi extends zzfy<zzi, zza> implements zzhi {
        private static final zzi zzg;
        private static volatile zzhq<zzi> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzh;
            private static volatile zzhq<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzh);
                }

                public final zza zza(zzbr zzbrVar) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(zzbrVar);
                    return this;
                }

                public final zza zza(boolean z) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(z);
                    return this;
                }

                public final zza zza(zzae zzaeVar) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(zzaeVar);
                    return this;
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzbr zzbrVar) {
                this.zzd = zzbrVar.zza();
                this.zzc |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(boolean z) {
                this.zzc |= 4;
                this.zzf = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzae zzaeVar) {
                zzaeVar.getClass();
                this.zzg = zzaeVar;
                this.zzc |= 8;
            }

            public static zza zza() {
                return zzh.zzh();
            }

            /* JADX WARN: Type inference failed for: r3v16, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzi$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbr.zzb(), "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhq<zzb> zzhqVar2 = zzi;
                        if (zzhqVar2 != null) {
                            return zzhqVar2;
                        }
                        synchronized (zzb.class) {
                            zzhq<zzb> zzhqVar3 = zzi;
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
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzfy.zza((Class<zzb>) zzb.class, zzbVar);
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzi, zza> implements zzhi {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb(i);
                return this;
            }

            public final zza zza(zzab zzabVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(zzabVar);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            zzbVar.getClass();
            this.zzd = zzbVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzab zzabVar) {
            zzabVar.getClass();
            this.zzf = zzabVar;
            this.zzc |= 4;
        }

        public static zza zza() {
            return zzg.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzi>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzi> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzi> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzi.class) {
                        zzhq<zzi> zzhqVar3 = zzh;
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
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzfy.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzj extends zzfy<zzj, zza> implements zzhi {
        private static final zzj zze;
        private static volatile zzhq<zzj> zzf;
        private int zzc;
        private int zzd;

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzj, zza> implements zzhi {
            private zza() {
                super(zzj.zze);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzj>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzj> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", zzbr.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzhq<zzj> zzhqVar2 = zzf;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzj.class) {
                        zzhq<zzj> zzhqVar3 = zzf;
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
            zzj zzjVar = new zzj();
            zze = zzjVar;
            zzfy.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzk extends zzfy<zzk, zza> implements zzhi {
        private static final zzk zzi;
        private static volatile zzhq<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzk, zza> implements zzhi {
            private zza() {
                super(zzk.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzk>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzk> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhq<zzk> zzhqVar2 = zzj;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzk.class) {
                        zzhq<zzk> zzhqVar3 = zzj;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzi);
                            zzj = zzcVar;
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
            zzk zzkVar = new zzk();
            zzi = zzkVar;
            zzfy.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzl extends zzfy<zzl, zza> implements zzhi {
        private static final zzge<Integer, zzbr> zzg = new zzbk();
        private static final zzl zzi;
        private static volatile zzhq<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzgf zzf = zzk();
        private long zzh;

        private zzl() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzl, zza> implements zzhi {
            private zza() {
                super(zzl.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzl>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzl> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzbr.zzb(), "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhq<zzl> zzhqVar2 = zzj;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzl.class) {
                        zzhq<zzl> zzhqVar3 = zzj;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzi);
                            zzj = zzcVar;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzbk, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbr>] */
        static {
            zzl zzlVar = new zzl();
            zzi = zzlVar;
            zzfy.zza((Class<zzl>) zzl.class, zzlVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzm extends zzfy<zzm, zza> implements zzhi {
        private static final zzm zzg;
        private static volatile zzhq<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzm() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzm, zza> implements zzhi {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzm>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzm> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzm> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzm.class) {
                        zzhq<zzm> zzhqVar3 = zzh;
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
            zzm zzmVar = new zzm();
            zzg = zzmVar;
            zzfy.zza((Class<zzm>) zzm.class, zzmVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzn extends zzfy<zzn, zzb> implements zzhi {
        private static final zzn zzf;
        private static volatile zzhq<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zza implements zzga {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);

            private static final zzgd<zza> zzd = new zzbm();
            private final int zze;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zze;
            }

            public static zzgc zzb() {
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

        private zzn() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy.zza<zzn, zzb> implements zzhi {
            private zzb() {
                super(zzn.zzf);
            }

            /* synthetic */ zzb(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzn>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzn> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zzb(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zza.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzn> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzn.class) {
                        zzhq<zzn> zzhqVar3 = zzg;
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
            zzn zznVar = new zzn();
            zzf = zznVar;
            zzfy.zza((Class<zzn>) zzn.class, zznVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzo extends zzfy<zzo, zza> implements zzhi {
        private static final zzo zzg;
        private static volatile zzhq<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzo() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzo, zza> implements zzhi {
            private zza() {
                super(zzo.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzo>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzo> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzo> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzo.class) {
                        zzhq<zzo> zzhqVar3 = zzh;
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
            zzo zzoVar = new zzo();
            zzg = zzoVar;
            zzfy.zza((Class<zzo>) zzo.class, zzoVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzp extends zzfy<zzp, zza> implements zzhi {
        private static final zzp zzg;
        private static volatile zzhq<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzp() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzp, zza> implements zzhi {
            private zza() {
                super(zzp.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzp>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzp> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzp> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzp.class) {
                        zzhq<zzp> zzhqVar3 = zzh;
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
            zzp zzpVar = new zzp();
            zzg = zzpVar;
            zzfy.zza((Class<zzp>) zzp.class, zzpVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzq extends zzfy<zzq, zza> implements zzhi {
        private static final zzq zzg;
        private static volatile zzhq<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzq() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzq, zza> implements zzhi {
            private zza() {
                super(zzq.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzq>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzq> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzq> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzq.class) {
                        zzhq<zzq> zzhqVar3 = zzh;
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
            zzq zzqVar = new zzq();
            zzg = zzqVar;
            zzfy.zza((Class<zzq>) zzq.class, zzqVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzr extends zzfy<zzr, zza> implements zzhi {
        private static final zzr zzg;
        private static volatile zzhq<zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzr() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzr, zza> implements zzhi {
            private zza() {
                super(zzr.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzr>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzr> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzr> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzr.class) {
                        zzhq<zzr> zzhqVar3 = zzh;
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
            zzr zzrVar = new zzr();
            zzg = zzrVar;
            zzfy.zza((Class<zzr>) zzr.class, zzrVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzs extends zzfy<zzs, zza> implements zzhi {
        private static final zzs zzg;
        private static volatile zzhq<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzs() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzs, zza> implements zzhi {
            private zza() {
                super(zzs.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzs>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzs> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzs> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzs.class) {
                        zzhq<zzs> zzhqVar3 = zzh;
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
            zzs zzsVar = new zzs();
            zzg = zzsVar;
            zzfy.zza((Class<zzs>) zzs.class, zzsVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzt extends zzfy<zzt, zza> implements zzhi {
        private static final zzt zzg;
        private static volatile zzhq<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzt() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzt, zza> implements zzhi {
            private zza() {
                super(zzt.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzt>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzt> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzt> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzt.class) {
                        zzhq<zzt> zzhqVar3 = zzh;
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
            zzt zztVar = new zzt();
            zzg = zztVar;
            zzfy.zza((Class<zzt>) zzt.class, zztVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzu extends zzfy<zzu, zza> implements zzhi {
        private static final zzu zzg;
        private static volatile zzhq<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzu() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzu, zza> implements zzhi {
            private zza() {
                super(zzu.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzu>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzu> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzu> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzu.class) {
                        zzhq<zzu> zzhqVar3 = zzh;
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
            zzu zzuVar = new zzu();
            zzg = zzuVar;
            zzfy.zza((Class<zzu>) zzu.class, zzuVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzv extends zzfy<zzv, zza> implements zzhi {
        private static final zzv zzg;
        private static volatile zzhq<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzv() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzv, zza> implements zzhi {
            private zza() {
                super(zzv.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzv>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzv> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzv> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzv.class) {
                        zzhq<zzv> zzhqVar3 = zzh;
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
            zzv zzvVar = new zzv();
            zzg = zzvVar;
            zzfy.zza((Class<zzv>) zzv.class, zzvVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzw extends zzfy<zzw, zza> implements zzhi {
        private static final zzw zzg;
        private static volatile zzhq<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        private zzw() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzw, zza> implements zzhi {
            private zza() {
                super(zzw.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzw>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzw> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzw> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzw.class) {
                        zzhq<zzw> zzhqVar3 = zzh;
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
            zzw zzwVar = new zzw();
            zzg = zzwVar;
            zzfy.zza((Class<zzw>) zzw.class, zzwVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzx extends zzfy<zzx, zza> implements zzhi {
        private static final zzx zzf;
        private static volatile zzhq<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        private zzx() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzx, zza> implements zzhi {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzx>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzx> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzbr.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzx> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzx.class) {
                        zzhq<zzx> zzhqVar3 = zzg;
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
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zzfy.zza((Class<zzx>) zzx.class, zzxVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzy extends zzfy<zzy, zza> implements zzhi {
        private static final zzy zzi;
        private static volatile zzhq<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzgh<zzb> zzf = zzl();
        private zzgh<zzb> zzg = zzl();
        private long zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zzb extends zzfy<zzb, zza> implements zzhi {
            private static final zzb zzf;
            private static volatile zzhq<zzb> zzg;
            private int zzc;
            private int zzd;
            private zzgf zze = zzk();

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_text.zzbh$zzy$zzb$zzb, reason: collision with other inner class name */
            public enum EnumC0072zzb implements zzga {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);

                private static final zzgd<EnumC0072zzb> zzf = new zzbn();
                private final int zzg;

                @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
                public final int zza() {
                    return this.zzg;
                }

                public static zzgc zzb() {
                    return zzbo.zza;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
                }

                EnumC0072zzb(int i) {
                    this.zzg = i;
                }
            }

            private zzb() {
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
            public static final class zza extends zzfy.zza<zzb, zza> implements zzhi {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzy$zzb>] */
            @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
            protected final Object zza(int i, Object obj, Object obj2) {
                zzhq<zzb> zzhqVar;
                com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
                switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(zzbgVar);
                    case 3:
                        return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzc", "zzd", EnumC0072zzb.zzb(), "zze"});
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

        private zzy() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzy, zza> implements zzhi {
            private zza() {
                super(zzy.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzy>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzy> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzb.class, "zzg", zzb.class, "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhq<zzy> zzhqVar2 = zzj;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzy.class) {
                        zzhq<zzy> zzhqVar3 = zzj;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzi);
                            zzj = zzcVar;
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
            zzy zzyVar = new zzy();
            zzi = zzyVar;
            zzfy.zza((Class<zzy>) zzy.class, zzyVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzz extends zzfy<zzz, zza> implements zzhi {
        private static final zzge<Integer, zzbr> zzg = new zzbp();
        private static final zzz zzj;
        private static volatile zzhq<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzgf zzf = zzk();
        private long zzh;
        private boolean zzi;

        private zzz() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzz, zza> implements zzhi {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzz>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzz> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", zzbr.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzz> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzz.class) {
                        zzhq<zzz> zzhqVar3 = zzk;
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_text.zzbp, com.google.android.gms.internal.mlkit_vision_text.zzge<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_text.zzbr>] */
        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zzfy.zza((Class<zzz>) zzz.class, zzzVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzab extends zzfy<zzab, zza> implements zzhi {
        private static final zzab zzj;
        private static volatile zzhq<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        private zzab() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzab, zza> implements zzhi {
            private zza() {
                super(zzab.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zza(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzb(j);
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzd(j);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zze(j);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzf(j);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 16;
            this.zzh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 32;
            this.zzi = j;
        }

        public static zza zza() {
            return zzj.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzab>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzab> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhq<zzab> zzhqVar2 = zzk;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzab.class) {
                        zzhq<zzab> zzhqVar3 = zzk;
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
            zzab zzabVar = new zzab();
            zzj = zzabVar;
            zzfy.zza((Class<zzab>) zzab.class, zzabVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzae extends zzfy<zzae, zza> implements zzhi {
        private static final zzae zzg;
        private static volatile zzhq<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public enum zzb implements zzga {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);

            private static final zzgd<zzb> zzj = new zzce();
            private final int zzk;

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
            public final int zza() {
                return this.zzk;
            }

            public static zzgc zzb() {
                return zzcf.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.zzk = i;
            }
        }

        private zzae() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzae, zza> implements zzhi {
            private zza() {
                super(zzae.zzg);
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzae) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzae) this.zza).zzb(i);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zzd = zzbVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zza zza() {
            return zzg.zzh();
        }

        /* JADX WARN: Type inference failed for: r3v15, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzae>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzae> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhq<zzae> zzhqVar2 = zzh;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzae.class) {
                        zzhq<zzae> zzhqVar3 = zzh;
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
            zzae zzaeVar = new zzae();
            zzg = zzaeVar;
            zzfy.zza((Class<zzae>) zzae.class, zzaeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzaf extends zzfy<zzaf, zza> implements zzhi {
        private static final zzaf zzk;
        private static volatile zzhq<zzaf> zzl;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzaf, zza> implements zzhi {
            private zza() {
                super(zzaf.zzk);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(j);
                return this;
            }

            public final zza zza(zzbr zzbrVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(zzbrVar);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(z);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zzb(true);
                return this;
            }

            public final zza zzc(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zzc(true);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbr zzbrVar) {
            this.zze = zzbrVar.zza();
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        public static zza zza() {
            return zzk.zzh();
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzaf>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzaf> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzaf();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", zzbr.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhq<zzaf> zzhqVar2 = zzl;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzaf.class) {
                        zzhq<zzaf> zzhqVar3 = zzl;
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
            zzaf zzafVar = new zzaf();
            zzk = zzafVar;
            zzfy.zza((Class<zzaf>) zzaf.class, zzafVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzbd extends zzfy<zzbd, zza> implements zzhi {
        private static final zzbd zzf;
        private static volatile zzhq<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        private zzbd() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzbd, zza> implements zzhi {
            private zza() {
                super(zzbd.zzf);
            }

            public final zza zza(zzaf.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbd) this.zza).zza((zzaf) ((zzfy) zzaVar.zzh()));
                return this;
            }

            public final zza zza(zzae zzaeVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbd) this.zza).zza(zzaeVar);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzaf zzafVar) {
            zzafVar.getClass();
            this.zzd = zzafVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzae zzaeVar) {
            zzaeVar.getClass();
            this.zze = zzaeVar;
            this.zzc |= 2;
        }

        public static zza zza() {
            return zzf.zzh();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbd>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzbd> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzbd();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhq<zzbd> zzhqVar2 = zzg;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzbd.class) {
                        zzhq<zzbd> zzhqVar3 = zzg;
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

        public static zzbd zzb() {
            return zzf;
        }

        static {
            zzbd zzbdVar = new zzbd();
            zzf = zzbdVar;
            zzfy.zza((Class<zzbd>) zzbd.class, zzbdVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public static final class zzbg extends zzfy<zzbg, zza> implements zzhi {
        private static final zzbg zzo;
        private static volatile zzhq<zzbg> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzgh<String> zzk = zzfy.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        private zzbg() {
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
        public static final class zza extends zzfy.zza<zzbg, zza> implements zzhi {
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

            /* synthetic */ zza(com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar) {
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
            zzgh<String> zzghVar = this.zzk;
            if (!zzghVar.zza()) {
                int size = zzghVar.size();
                this.zzk = zzghVar.zzb(size == 0 ? 10 : size << 1);
            }
            zzep.zza(iterable, this.zzk);
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

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_text.zzfy$zzc, com.google.android.gms.internal.mlkit_vision_text.zzhq<com.google.android.gms.internal.mlkit_vision_text.zzbh$zzbg>] */
        @Override // com.google.android.gms.internal.mlkit_vision_text.zzfy
        protected final Object zza(int i, Object obj, Object obj2) {
            zzhq<zzbg> zzhqVar;
            com.google.android.gms.internal.mlkit_vision_text.zzbg zzbgVar = null;
            switch (com.google.android.gms.internal.mlkit_vision_text.zzbg.zza[i - 1]) {
                case 1:
                    return new zzbg();
                case 2:
                    return new zza(zzbgVar);
                case 3:
                    return zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzhq<zzbg> zzhqVar2 = zzp;
                    if (zzhqVar2 != null) {
                        return zzhqVar2;
                    }
                    synchronized (zzbg.class) {
                        zzhq<zzbg> zzhqVar3 = zzp;
                        zzhqVar = zzhqVar3;
                        if (zzhqVar3 == null) {
                            ?? zzcVar = new zzfy.zzc(zzo);
                            zzp = zzcVar;
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

        public static zzbg zzc() {
            return zzo;
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzo = zzbgVar;
            zzfy.zza((Class<zzbg>) zzbg.class, zzbgVar);
        }
    }
}
