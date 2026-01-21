package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public abstract class zzgz<T> {
    private static final Object zza = new Object();

    @Nullable
    private static volatile zzhg zzb = null;
    private static volatile boolean zzc = false;
    private static zzhk zzd;
    private static final AtomicInteger zze;
    private final zzhh zzf;
    private final String zzg;
    private Object zzh;
    private volatile int zzi;
    private volatile T zzj;
    private final boolean zzk;
    private volatile boolean zzl;

    static /* synthetic */ boolean zzd() {
        return true;
    }

    abstract T zza(Object obj);

    static /* synthetic */ zzgz zza(zzhh zzhhVar, String str, Boolean bool, boolean z) {
        return new zzhc(zzhhVar, str, bool, true);
    }

    static /* synthetic */ zzgz zza(zzhh zzhhVar, String str, Double d, boolean z) {
        return new zzhf(zzhhVar, str, d, true);
    }

    static /* synthetic */ zzgz zza(zzhh zzhhVar, String str, Long l, boolean z) {
        return new zzhd(zzhhVar, str, l, true);
    }

    static /* synthetic */ zzgz zza(zzhh zzhhVar, String str, String str2, boolean z) {
        return new zzhe(zzhhVar, str, str2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007d A[Catch: all -> 0x0098, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:12:0x0029, B:14:0x0039, B:18:0x0056, B:20:0x0061, B:33:0x0081, B:36:0x0089, B:37:0x008e, B:38:0x0092, B:23:0x0068, B:32:0x007d, B:26:0x006f, B:29:0x0076, B:39:0x0096), top: B:46:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T zza() {
        T tZzb;
        if (!this.zzk) {
            Preconditions.checkState(zzd.zza(this.zzg), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i = zze.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    zzhg zzhgVar = zzb;
                    Optional<zzgt> optionalAbsent = Optional.absent();
                    String strZza = null;
                    if (zzhgVar != null) {
                        optionalAbsent = zzhgVar.zzb().get();
                        if (optionalAbsent.isPresent()) {
                            strZza = optionalAbsent.get().zza(this.zzf.zzb, this.zzf.zza, this.zzf.zzd, this.zzg);
                        }
                    }
                    Preconditions.checkState(zzhgVar != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    if (this.zzf.zzf) {
                        tZzb = zza(zzhgVar);
                        if (tZzb == null && (tZzb = zzb(zzhgVar)) == null) {
                            tZzb = zze();
                        }
                        if (optionalAbsent.isPresent()) {
                            tZzb = strZza == null ? zze() : zza((Object) strZza);
                        }
                        this.zzj = tZzb;
                        this.zzi = i;
                    } else {
                        tZzb = zzb(zzhgVar);
                        if (tZzb == null && (tZzb = zza(zzhgVar)) == null) {
                        }
                        if (optionalAbsent.isPresent()) {
                        }
                        this.zzj = tZzb;
                        this.zzi = i;
                    }
                }
            }
        }
        return this.zzj;
    }

    private final T zze() {
        return (T) this.zzh;
    }

    @Nullable
    private final T zza(zzhg zzhgVar) {
        if (!this.zzf.zze && (this.zzf.zzh == null || this.zzf.zzh.apply(zzhgVar.zza()).booleanValue())) {
            Object objZza = zzgs.zza(zzhgVar.zza()).zza(this.zzf.zze ? null : zza(this.zzf.zzc));
            if (objZza != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    @Nullable
    private final T zzb(zzhg zzhgVar) {
        zzgn zzgnVarZza;
        Object objZza;
        if (this.zzf.zzb != null) {
            if (!zzgx.zza(zzhgVar.zza(), this.zzf.zzb)) {
                zzgnVarZza = null;
            } else if (this.zzf.zzg) {
                zzgnVarZza = zzgk.zza(zzhgVar.zza().getContentResolver(), zzgw.zza(zzgw.zza(zzhgVar.zza(), this.zzf.zzb.getLastPathSegment())), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzgy
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzgz.zzc();
                    }
                });
            } else {
                zzgnVarZza = zzgk.zza(zzhgVar.zza().getContentResolver(), this.zzf.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzgy
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzgz.zzc();
                    }
                });
            }
        } else {
            zzgnVarZza = zzhi.zza(zzhgVar.zza(), this.zzf.zza, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzgy
                @Override // java.lang.Runnable
                public final void run() {
                    zzgz.zzc();
                }
            });
        }
        if (zzgnVarZza == null || (objZza = zzgnVarZza.zza(zzb())) == null) {
            return null;
        }
        return zza(objZza);
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        return str + this.zzg;
    }

    static {
        new AtomicReference();
        zzd = new zzhk(new zzhn() { // from class: com.google.android.gms.internal.measurement.zzha
            @Override // com.google.android.gms.internal.measurement.zzhn
            public final boolean zza() {
                return zzgz.zzd();
            }
        });
        zze = new AtomicInteger();
    }

    private zzgz(zzhh zzhhVar, String str, T t, boolean z) {
        this.zzi = -1;
        if (zzhhVar.zza == null && zzhhVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (zzhhVar.zza != null && zzhhVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzhhVar;
        this.zzg = str;
        this.zzh = t;
        this.zzk = z;
        this.zzl = false;
    }

    public static void zzc() {
        zze.incrementAndGet();
    }

    public static void zzb(final Context context) {
        if (zzb != null || context == null) {
            return;
        }
        Object obj = zza;
        synchronized (obj) {
            if (zzb == null && context != null) {
                synchronized (obj) {
                    zzhg zzhgVar = zzb;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzhgVar == null || zzhgVar.zza() != context) {
                        if (zzhgVar != null) {
                            zzgk.zzc();
                            zzhi.zza();
                            zzgs.zza();
                        }
                        zzb = new zzgh(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzhb
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                return zzgv.zza.zza(context);
                            }
                        }));
                        zze.incrementAndGet();
                    }
                }
            }
        }
    }
}
