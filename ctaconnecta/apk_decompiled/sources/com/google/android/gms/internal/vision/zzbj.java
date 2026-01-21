package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzbj<T> {
    private static volatile Context zzg = null;
    private static volatile boolean zzgh = false;
    private static volatile zzcz<zzcs<zzbf>> zzgj;
    private final String name;
    private final zzbp zzgk;
    private final T zzgl;
    private volatile int zzgn;
    private volatile T zzgo;
    private final boolean zzgp;
    private static final Object zzgg = new Object();
    private static final AtomicReference<Collection<zzbj<?>>> zzgi = new AtomicReference<>();
    private static final AtomicInteger zzgm = new AtomicInteger();

    public static void init(Context context) {
        synchronized (zzgg) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzg != context) {
                zzav.zzy();
                zzbo.zzy();
                zzba.zzab();
                zzgj = zzdc.zza(zzbi.zzgf);
                zzg = context;
                zzgm.incrementAndGet();
            }
        }
    }

    abstract T zza(Object obj);

    public static void maybeInit(Context context) {
        if (zzg != null) {
            return;
        }
        synchronized (zzgg) {
            if (zzg == null) {
                init(context);
            }
        }
    }

    static void zzac() {
        zzgm.incrementAndGet();
    }

    private zzbj(zzbp zzbpVar, String str, T t, boolean z) {
        this.zzgn = -1;
        if (zzbpVar.zzgu == null && zzbpVar.zzgv == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (zzbpVar.zzgu != null && zzbpVar.zzgv != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzgk = zzbpVar;
        this.name = str;
        this.zzgl = t;
        this.zzgp = z;
    }

    private final String zze(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.name);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    public final String zzad() {
        return zze(this.zzgk.zzgx);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0035 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0019, B:24:0x0037, B:26:0x0045, B:28:0x005f, B:29:0x0062, B:30:0x0066, B:14:0x0020, B:23:0x0035, B:17:0x0027, B:20:0x002e, B:31:0x006b, B:32:0x0072, B:33:0x0073), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045 A[Catch: all -> 0x0075, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0019, B:24:0x0037, B:26:0x0045, B:28:0x005f, B:29:0x0062, B:30:0x0066, B:14:0x0020, B:23:0x0035, B:17:0x0027, B:20:0x002e, B:31:0x006b, B:32:0x0072, B:33:0x0073), top: B:40:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T get() {
        T tZzae;
        zzcs<zzbf> zzcsVar;
        int i = zzgm.get();
        if (this.zzgn < i) {
            synchronized (this) {
                if (this.zzgn < i) {
                    if (zzg == null) {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                    if (this.zzgk.zzgz) {
                        tZzae = zzaf();
                        if (tZzae == null && (tZzae = zzae()) == null) {
                            tZzae = this.zzgl;
                        }
                        zzcsVar = zzgj.get();
                        if (zzcsVar.isPresent()) {
                            String strZza = zzcsVar.get().zza(this.zzgk.zzgv, this.zzgk.zzgu, this.zzgk.zzgx, this.name);
                            tZzae = strZza == null ? this.zzgl : zza(strZza);
                        }
                        this.zzgo = tZzae;
                        this.zzgn = i;
                    } else {
                        tZzae = zzae();
                        if (tZzae == null && (tZzae = zzaf()) == null) {
                        }
                        zzcsVar = zzgj.get();
                        if (zzcsVar.isPresent()) {
                        }
                        this.zzgo = tZzae;
                        this.zzgn = i;
                    }
                }
            }
        }
        return this.zzgo;
    }

    @Nullable
    private final T zzae() {
        zzaz zzazVarZzb;
        Object objZzb;
        String str;
        if (this.zzgk.zzha || (str = (String) zzba.zze(zzg).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype")) == null || !zzaq.zzfc.matcher(str).matches()) {
            if (this.zzgk.zzgv != null) {
                if (!zzbh.zza(zzg, this.zzgk.zzgv)) {
                    zzazVarZzb = null;
                } else if (this.zzgk.zzhb) {
                    ContentResolver contentResolver = zzg.getContentResolver();
                    String lastPathSegment = this.zzgk.zzgv.getLastPathSegment();
                    String packageName = zzg.getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                    sb.append(lastPathSegment);
                    sb.append("#");
                    sb.append(packageName);
                    zzazVarZzb = zzav.zza(contentResolver, zzbg.getContentProviderUri(sb.toString()));
                } else {
                    zzazVarZzb = zzav.zza(zzg.getContentResolver(), this.zzgk.zzgv);
                }
            } else {
                zzazVarZzb = zzbo.zzb(zzg, this.zzgk.zzgu);
            }
            if (zzazVarZzb != null && (objZzb = zzazVarZzb.zzb(zzad())) != null) {
                return zza(objZzb);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String strValueOf = String.valueOf(zzad());
            Log.d("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zzaf() {
        if (!this.zzgk.zzgy && (this.zzgk.zzhc == null || this.zzgk.zzhc.apply(zzg).booleanValue())) {
            Object objZzb = zzba.zze(zzg).zzb(this.zzgk.zzgy ? null : zze(this.zzgk.zzgw));
            if (objZzb != null) {
                return zza(objZzb);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzbj<Long> zza(zzbp zzbpVar, String str, long j, boolean z) {
        return new zzbl(zzbpVar, str, Long.valueOf(j), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzbj<Boolean> zza(zzbp zzbpVar, String str, boolean z, boolean z2) {
        return new zzbk(zzbpVar, str, Boolean.valueOf(z), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> zzbj<T> zza(zzbp zzbpVar, String str, T t, zzbm<T> zzbmVar, boolean z) {
        return new zzbn(zzbpVar, str, t, true, zzbmVar);
    }

    static final /* synthetic */ zzcs zzag() {
        new zzbe();
        return zzbe.zzf(zzg);
    }

    /* synthetic */ zzbj(zzbp zzbpVar, String str, Object obj, boolean z, zzbl zzblVar) {
        this(zzbpVar, str, obj, z);
    }
}
