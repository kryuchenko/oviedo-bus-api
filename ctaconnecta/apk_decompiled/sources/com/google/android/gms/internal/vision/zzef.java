package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzef {

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzb extends zzgx<zzb, zza> implements zzij {
        private static volatile zziq<zzb> zzbk;
        private static final zzhf<Integer, zzet> zzna = new zzeg();
        private static final zzb zznb;
        private zzhc zzmz = zzgh();

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzb, zza> implements zzij {
            private zza() {
                super(zzb.zznb);
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzb>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzb> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zznb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzmz", zzet.zzai()});
                case 4:
                    return zznb;
                case 5:
                    zziq<zzb> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzb.class) {
                        zziq<zzb> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zznb);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzeg, com.google.android.gms.internal.vision.zzhf<java.lang.Integer, com.google.android.gms.internal.vision.zzet>] */
        static {
            zzb zzbVar = new zzb();
            zznb = zzbVar;
            zzgx.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzc extends zzgx<zzc, zza> implements zzij {
        private static volatile zziq<zzc> zzbk;
        private static final zzc zznf;
        private int zzbm;
        private int zznc;
        private int zznd;
        private String zzne = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzc, zza> implements zzij {
            private zza() {
                super(zzc.zznf);
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r4v16, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzc>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzc> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zznf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzbm", "zznc", zzet.zzai(), "zznd", zzex.zzai(), "zzne"});
                case 4:
                    return zznf;
                case 5:
                    zziq<zzc> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzc.class) {
                        zziq<zzc> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zznf);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zznf = zzcVar;
            zzgx.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zze extends zzgx<zze, zzb> implements zzij {
        private static volatile zziq<zze> zzbk;
        private static final zze zznq;
        private int zzbm;
        private boolean zznj;
        private int zznk;
        private long zznl;
        private long zznm;
        private long zznn;
        private boolean zznp;
        private String zzni = "";
        private String zzno = "";

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public enum zza implements zzhb {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);

            private static final zzha<zza> zzhl = new zzei();
            private final int value;

            @Override // com.google.android.gms.internal.vision.zzhb
            public final int zzah() {
                return this.value;
            }

            public static zza zzt(int i) {
                if (i == 0) {
                    return REASON_UNKNOWN;
                }
                if (i == 1) {
                    return REASON_MISSING;
                }
                if (i == 2) {
                    return REASON_UPGRADE;
                }
                if (i != 3) {
                    return null;
                }
                return REASON_INVALID;
            }

            public static zzhd zzai() {
                return zzeh.zzho;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.value = i;
            }
        }

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zzb extends zzgx.zza<zze, zzb> implements zzij {
            private zzb() {
                super(zze.zznq);
            }

            /* synthetic */ zzb(zzee zzeeVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zze>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zze> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(zzeeVar);
                case 3:
                    return zza(zznq, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007", new Object[]{"zzbm", "zzni", "zznj", "zznk", zza.zzai(), "zznl", "zznm", "zznn", "zzno", "zznp"});
                case 4:
                    return zznq;
                case 5:
                    zziq<zze> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zze.class) {
                        zziq<zze> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zznq);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zznq = zzeVar;
            zzgx.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzl extends zzgx<zzl, zza> implements zzij {
        private static volatile zziq<zzl> zzbk;
        private static final zzl zzqd;
        private int zzbm;
        private long zzob;
        private long zzoc;

        private zzl() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzl, zza> implements zzij {
            private zza() {
                super(zzl.zzqd);
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzl>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzl> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzqd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzbm", "zzob", "zzoc"});
                case 4:
                    return zzqd;
                case 5:
                    zziq<zzl> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzl.class) {
                        zziq<zzl> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzqd);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzl zzlVar = new zzl();
            zzqd = zzlVar;
            zzgx.zza((Class<zzl>) zzl.class, zzlVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zza extends zzgx<zza, C0078zza> implements zzij {
        private static volatile zziq<zza> zzbk;
        private static final zza zzmy;
        private int zzbm;
        private String zzmw = "";
        private String zzmx = "";

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        /* renamed from: com.google.android.gms.internal.vision.zzef$zza$zza, reason: collision with other inner class name */
        public static final class C0078zza extends zzgx.zza<zza, C0078zza> implements zzij {
            private C0078zza() {
                super(zza.zzmy);
            }

            public final C0078zza zzl(String str) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zza) this.zzwq).zzn(str);
                return this;
            }

            public final C0078zza zzm(String str) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zza) this.zzwq).zzo(str);
                return this;
            }

            /* synthetic */ C0078zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzbm |= 1;
            this.zzmw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzbm |= 2;
            this.zzmx = str;
        }

        public static C0078zza zzck() {
            return zzmy.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zza>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zza> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0078zza(zzeeVar);
                case 3:
                    return zza(zzmy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzbm", "zzmw", "zzmx"});
                case 4:
                    return zzmy;
                case 5:
                    zziq<zza> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zza.class) {
                        zziq<zza> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzmy);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzmy = zzaVar;
            zzgx.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzd extends zzgx<zzd, zza> implements zzij {
        private static volatile zziq<zzd> zzbk;
        private static final zzd zznh;
        private zzhe<zzm> zzng = zzgi();

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzd, zza> implements zzij {
            private zza() {
                super(zzd.zznh);
            }

            public final zza zzb(zzm zzmVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzd) this.zzwq).zza(zzmVar);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzm zzmVar) {
            zzmVar.getClass();
            zzhe<zzm> zzheVar = this.zzng;
            if (!zzheVar.zzdp()) {
                this.zzng = zzgx.zza(zzheVar);
            }
            this.zzng.add(zzmVar);
        }

        public static zza zzco() {
            return zznh.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzd>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzd> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zznh, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzng", zzm.class});
                case 4:
                    return zznh;
                case 5:
                    zziq<zzd> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzd.class) {
                        zziq<zzd> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zznh);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zznh = zzdVar;
            zzgx.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzf extends zzgx<zzf, zza> implements zzij {
        private static volatile zziq<zzf> zzbk;
        private static final zzf zzoe;
        private int zzbm;
        private int zznz;
        private long zzob;
        private long zzoc;
        private String zznw = "";
        private String zznx = "";
        private zzhe<String> zzny = zzgx.zzgi();
        private String zzoa = "";
        private zzhe<zzn> zzod = zzgi();

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public enum zzb implements zzhb {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);

            private static final zzha<zzb> zzhl = new zzej();
            private final int value;

            @Override // com.google.android.gms.internal.vision.zzhb
            public final int zzah() {
                return this.value;
            }

            public static zzb zzu(int i) {
                if (i == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i == 1) {
                    return RESULT_SUCCESS;
                }
                if (i == 2) {
                    return RESULT_FAIL;
                }
                if (i != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }

            public static zzhd zzai() {
                return zzek.zzho;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzf, zza> implements zzij {
            private zza() {
                super(zzf.zzoe);
            }

            public final zza zzp(String str) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzf) this.zzwq).setName(str);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzf) this.zzwq).zzr(str);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzf) this.zzwq).zzf(j);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzf) this.zzwq).zzg(j);
                return this;
            }

            public final zza zzc(Iterable<? extends zzn> iterable) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzf) this.zzwq).zzd(iterable);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzbm |= 1;
            this.zznw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzbm |= 8;
            this.zzoa = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzbm |= 16;
            this.zzob = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzbm |= 32;
            this.zzoc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzn> iterable) {
            zzhe<zzn> zzheVar = this.zzod;
            if (!zzheVar.zzdp()) {
                this.zzod = zzgx.zza(zzheVar);
            }
            zzey.zza(iterable, this.zzod);
        }

        public static zza zzcr() {
            return zzoe.zzgf();
        }

        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzf>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzf> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzoe, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzbm", "zznw", "zznx", "zzny", "zznz", zzb.zzai(), "zzoa", "zzob", "zzoc", "zzod", zzn.class});
                case 4:
                    return zzoe;
                case 5:
                    zziq<zzf> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzf.class) {
                        zziq<zzf> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzoe);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzoe = zzfVar;
            zzgx.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzg extends zzgx<zzg, zzb> implements zzij {
        private static volatile zziq<zzg> zzbk;
        private static final zzg zzoo;
        private int zzbm;
        private float zzkj;
        private boolean zzkn;
        private int zzok;
        private int zzol;
        private int zzom;
        private boolean zzon;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public enum zza implements zzhb {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);

            private static final zzha<zza> zzhl = new zzem();
            private final int value;

            @Override // com.google.android.gms.internal.vision.zzhb
            public final int zzah() {
                return this.value;
            }

            public static zza zzv(int i) {
                if (i == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }

            public static zzhd zzai() {
                return zzel.zzho;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public enum zzc implements zzhb {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);

            private static final zzha<zzc> zzhl = new zzen();
            private final int value;

            @Override // com.google.android.gms.internal.vision.zzhb
            public final int zzah() {
                return this.value;
            }

            public static zzc zzw(int i) {
                if (i == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 1) {
                    return LANDMARK_NONE;
                }
                if (i == 2) {
                    return LANDMARK_ALL;
                }
                if (i != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }

            public static zzhd zzai() {
                return zzeo.zzho;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            zzc(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public enum zzd implements zzhb {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);

            private static final zzha<zzd> zzhl = new zzeq();
            private final int value;

            @Override // com.google.android.gms.internal.vision.zzhb
            public final int zzah() {
                return this.value;
            }

            public static zzd zzx(int i) {
                if (i == 0) {
                    return MODE_UNKNOWN;
                }
                if (i == 1) {
                    return MODE_ACCURATE;
                }
                if (i == 2) {
                    return MODE_FAST;
                }
                if (i != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }

            public static zzhd zzai() {
                return zzep.zzho;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            zzd(int i) {
                this.value = i;
            }
        }

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zzb extends zzgx.zza<zzg, zzb> implements zzij {
            private zzb() {
                super(zzg.zzoo);
            }

            public final zzb zzb(zzd zzdVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzg) this.zzwq).zza(zzdVar);
                return this;
            }

            public final zzb zzb(zzc zzcVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzg) this.zzwq).zza(zzcVar);
                return this;
            }

            public final zzb zzb(zza zzaVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzg) this.zzwq).zza(zzaVar);
                return this;
            }

            public final zzb zzh(boolean z) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzg) this.zzwq).zza(z);
                return this;
            }

            public final zzb zzi(boolean z) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzg) this.zzwq).zzg(z);
                return this;
            }

            public final zzb zzf(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzg) this.zzwq).zzd(f);
                return this;
            }

            /* synthetic */ zzb(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzd zzdVar) {
            this.zzok = zzdVar.zzah();
            this.zzbm |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzol = zzcVar.zzah();
            this.zzbm |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            this.zzom = zzaVar.zzah();
            this.zzbm |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzbm |= 8;
            this.zzkn = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(boolean z) {
            this.zzbm |= 16;
            this.zzon = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(float f) {
            this.zzbm |= 32;
            this.zzkj = f;
        }

        public static zzb zzct() {
            return zzoo.zzgf();
        }

        /* JADX WARN: Type inference failed for: r5v20, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzg>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzg> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zzb(zzeeVar);
                case 3:
                    return zza(zzoo, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzbm", "zzok", zzd.zzai(), "zzol", zzc.zzai(), "zzom", zza.zzai(), "zzkn", "zzon", "zzkj"});
                case 4:
                    return zzoo;
                case 5:
                    zziq<zzg> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzg.class) {
                        zziq<zzg> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzoo);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzoo = zzgVar;
            zzgx.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzh extends zzgx<zzh, zza> implements zzij {
        private static volatile zziq<zzh> zzbk;
        private static final zzh zzpj;
        private int zzbm;
        private float zzpd;
        private float zzpe;
        private float zzpf;
        private float zzpg;
        private float zzph;
        private float zzpi;

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzh, zza> implements zzij {
            private zza() {
                super(zzh.zzpj);
            }

            public final zza zzg(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzh) this.zzwq).zzm(f);
                return this;
            }

            public final zza zzh(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzh) this.zzwq).zzn(f);
                return this;
            }

            public final zza zzi(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzh) this.zzwq).zzo(f);
                return this;
            }

            public final zza zzj(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzh) this.zzwq).zzp(f);
                return this;
            }

            public final zza zzk(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzh) this.zzwq).zzq(f);
                return this;
            }

            public final zza zzl(float f) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzh) this.zzwq).zzr(f);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(float f) {
            this.zzbm |= 1;
            this.zzpd = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(float f) {
            this.zzbm |= 2;
            this.zzpe = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(float f) {
            this.zzbm |= 4;
            this.zzpf = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(float f) {
            this.zzbm |= 8;
            this.zzpg = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(float f) {
            this.zzbm |= 16;
            this.zzph = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(float f) {
            this.zzbm |= 32;
            this.zzpi = f;
        }

        public static zza zzcv() {
            return zzpj.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzh>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzh> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzpj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzbm", "zzpd", "zzpe", "zzpf", "zzpg", "zzph", "zzpi"});
                case 4:
                    return zzpj;
                case 5:
                    zziq<zzh> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzh.class) {
                        zziq<zzh> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzpj);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzpj = zzhVar;
            zzgx.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzi extends zzgx<zzi, zza> implements zzij {
        private static volatile zziq<zzi> zzbk;
        private static final zzi zzpn;
        private int zzbm;
        private zzj zzpk;
        private zzl zzpl;
        private zzhe<zzf> zzpm = zzgi();

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzi, zza> implements zzij {
            private zza() {
                super(zzi.zzpn);
            }

            public final zza zza(zzj zzjVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzi) this.zzwq).zzb(zzjVar);
                return this;
            }

            public final zza zza(zzf.zza zzaVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzi) this.zzwq).zza((zzf) ((zzgx) zzaVar.zzgd()));
                return this;
            }

            public final zza zze(Iterable<? extends zzf> iterable) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzi) this.zzwq).zzf(iterable);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzj zzjVar) {
            zzjVar.getClass();
            this.zzpk = zzjVar;
            this.zzbm |= 1;
        }

        private final void zzcx() {
            zzhe<zzf> zzheVar = this.zzpm;
            if (zzheVar.zzdp()) {
                return;
            }
            this.zzpm = zzgx.zza(zzheVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            zzcx();
            this.zzpm.add(zzfVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(Iterable<? extends zzf> iterable) {
            zzcx();
            zzey.zza(iterable, this.zzpm);
        }

        public static zza zzcy() {
            return zzpn.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzi>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzi> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzpn, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzbm", "zzpk", "zzpl", "zzpm", zzf.class});
                case 4:
                    return zzpn;
                case 5:
                    zziq<zzi> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzi.class) {
                        zziq<zzi> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzpn);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzpn = zziVar;
            zzgx.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzj extends zzgx<zzj, zza> implements zzij {
        private static volatile zziq<zzj> zzbk;
        private static final zzj zzps;
        private int zzbm;
        private int zznc;
        private long zzpo;
        private long zzpp;
        private long zzpq;
        private long zzpr;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public enum zzb implements zzhb {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);

            private static final zzha<zzb> zzhl = new zzer();
            private final int value;

            @Override // com.google.android.gms.internal.vision.zzhb
            public final int zzah() {
                return this.value;
            }

            public static zzb zzy(int i) {
                if (i == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i == 2) {
                    return FORMAT_RGB8;
                }
                if (i != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }

            public static zzhd zzai() {
                return zzes.zzho;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzj, zza> implements zzij {
            private zza() {
                super(zzj.zzps);
            }

            public final zza zzh(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzj) this.zzwq).zzl(j);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzj) this.zzwq).zzm(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzj) this.zzwq).zzn(j);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzj) this.zzwq).zzo(j);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzbm |= 2;
            this.zzpo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(long j) {
            this.zzbm |= 4;
            this.zzpp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(long j) {
            this.zzbm |= 8;
            this.zzpq = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzbm |= 16;
            this.zzpr = j;
        }

        public static zza zzda() {
            return zzps.zzgf();
        }

        /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzj>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzj> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzps, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzbm", "zznc", zzb.zzai(), "zzpo", "zzpp", "zzpr", "zzpq"});
                case 4:
                    return zzps;
                case 5:
                    zziq<zzj> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzj.class) {
                        zziq<zzj> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzps);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzps = zzjVar;
            zzgx.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzk extends zzgx<zzk, zza> implements zzij {
        private static volatile zziq<zzk> zzbk;
        private static final zzk zzqc;
        private int zzbm;
        private long zzpy;
        private zza zzpz;
        private zzg zzqa;
        private zzb zzqb;
        private String zznw = "";
        private String zzno = "";

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzk, zza> implements zzij {
            private zza() {
                super(zzk.zzqc);
            }

            public final zza zzt(String str) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzk) this.zzwq).setName(str);
                return this;
            }

            public final zza zzq(long j) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzk) this.zzwq).zzp(j);
                return this;
            }

            public final zza zzb(zza zzaVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzk) this.zzwq).zza(zzaVar);
                return this;
            }

            public final zza zzu(String str) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzk) this.zzwq).zzs(str);
                return this;
            }

            public final zza zza(zzg.zzb zzbVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzk) this.zzwq).zza((zzg) ((zzgx) zzbVar.zzgd()));
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzbm |= 1;
            this.zznw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzbm |= 2;
            this.zzpy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            zzaVar.getClass();
            this.zzpz = zzaVar;
            this.zzbm |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zzbm |= 8;
            this.zzno = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            this.zzqa = zzgVar;
            this.zzbm |= 16;
        }

        public static zza zzdc() {
            return zzqc.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzk>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzk> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzqc, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005", new Object[]{"zzbm", "zznw", "zzpy", "zzpz", "zzno", "zzqa", "zzqb"});
                case 4:
                    return zzqc;
                case 5:
                    zziq<zzk> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzk.class) {
                        zziq<zzk> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzqc);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzqc = zzkVar;
            zzgx.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzm extends zzgx<zzm, zza> implements zzij {
        private static volatile zziq<zzm> zzbk;
        private static final zzm zzqg;
        private int zzbm;
        private int zzqe;
        private int zzqf;

        private zzm() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzm, zza> implements zzij {
            private zza() {
                super(zzm.zzqg);
            }

            public final zza zzz(int i) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzm) this.zzwq).setX(i);
                return this;
            }

            public final zza zzaa(int i) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzm) this.zzwq).setY(i);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setX(int i) {
            this.zzbm |= 1;
            this.zzqe = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setY(int i) {
            this.zzbm |= 2;
            this.zzqf = i;
        }

        public static zza zzdf() {
            return zzqg.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzm>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzm> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzqg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzbm", "zzqe", "zzqf"});
                case 4:
                    return zzqg;
                case 5:
                    zziq<zzm> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzm.class) {
                        zziq<zzm> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzqg);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzqg = zzmVar;
            zzgx.zza((Class<zzm>) zzm.class, zzmVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzn extends zzgx<zzn, zza> implements zzij {
        private static volatile zziq<zzn> zzbk;
        private static final zzn zzql;
        private int zzbm;
        private zzd zzqh;
        private int zzqi;
        private zzh zzqj;
        private zzc zzqk;

        private zzn() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzn, zza> implements zzij {
            private zza() {
                super(zzn.zzql);
            }

            public final zza zza(zzd.zza zzaVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzn) this.zzwq).zza((zzd) ((zzgx) zzaVar.zzgd()));
                return this;
            }

            public final zza zzab(int i) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzn) this.zzwq).setId(i);
                return this;
            }

            public final zza zzb(zzh zzhVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzn) this.zzwq).zza(zzhVar);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzd zzdVar) {
            zzdVar.getClass();
            this.zzqh = zzdVar;
            this.zzbm |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setId(int i) {
            this.zzbm |= 2;
            this.zzqi = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzh zzhVar) {
            zzhVar.getClass();
            this.zzqj = zzhVar;
            this.zzbm |= 4;
        }

        public static zza zzdh() {
            return zzql.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzn>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzn> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzql, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzbm", "zzqh", "zzqi", "zzqj", "zzqk"});
                case 4:
                    return zzql;
                case 5:
                    zziq<zzn> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzn.class) {
                        zziq<zzn> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzql);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzql = zznVar;
            zzgx.zza((Class<zzn>) zzn.class, zznVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static final class zzo extends zzgx<zzo, zza> implements zzij {
        private static volatile zziq<zzo> zzbk;
        private static final zzo zzqq;
        private int zzbm;
        private zze zzqm;
        private zzk zzqn;
        private zzi zzqo;
        private int zzqp;

        private zzo() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
        public static final class zza extends zzgx.zza<zzo, zza> implements zzij {
            private zza() {
                super(zzo.zzqq);
            }

            public final zza zza(zzk.zza zzaVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzo) this.zzwq).zza((zzk) ((zzgx) zzaVar.zzgd()));
                return this;
            }

            public final zza zzb(zzi zziVar) {
                if (this.zzwr) {
                    zzfz();
                    this.zzwr = false;
                }
                ((zzo) this.zzwq).zza(zziVar);
                return this;
            }

            /* synthetic */ zza(zzee zzeeVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzk zzkVar) {
            zzkVar.getClass();
            this.zzqn = zzkVar;
            this.zzbm |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzi zziVar) {
            zziVar.getClass();
            this.zzqo = zziVar;
            this.zzbm |= 4;
        }

        public static zza zzdj() {
            return zzqq.zzgf();
        }

        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.vision.zzgx$zzc, com.google.android.gms.internal.vision.zziq<com.google.android.gms.internal.vision.zzef$zzo>] */
        @Override // com.google.android.gms.internal.vision.zzgx
        protected final Object zza(int i, Object obj, Object obj2) {
            zziq<zzo> zziqVar;
            zzee zzeeVar = null;
            switch (zzee.zzbl[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zzeeVar);
                case 3:
                    return zza(zzqq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003", new Object[]{"zzbm", "zzqm", "zzqn", "zzqo", "zzqp"});
                case 4:
                    return zzqq;
                case 5:
                    zziq<zzo> zziqVar2 = zzbk;
                    if (zziqVar2 != null) {
                        return zziqVar2;
                    }
                    synchronized (zzo.class) {
                        zziq<zzo> zziqVar3 = zzbk;
                        zziqVar = zziqVar3;
                        if (zziqVar3 == null) {
                            ?? zzcVar = new zzgx.zzc(zzqq);
                            zzbk = zzcVar;
                            zziqVar = zzcVar;
                        }
                    }
                    return zziqVar;
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
            zzqq = zzoVar;
            zzgx.zza((Class<zzo>) zzo.class, zzoVar);
        }
    }
}
