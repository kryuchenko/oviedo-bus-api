package com.google.android.gms.internal.mlkit_vision_text;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.internal.mlkit_vision_text.zzbh;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.LibraryVersion;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzeg {
    public static final Component<?> zza = Component.builder(zzeg.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) SharedPrefManager.class)).add(Dependency.required((Class<?>) zzb.class)).factory(zzej.zza).build();
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zzb zze;
    private final SharedPrefManager zzf;
    private final Task<String> zzh;
    private final Map<zzbs, Long> zzi = new HashMap();
    private final Map<zzbs, zzap<Object, Long>> zzj = new HashMap();
    private final Task<String> zzg = MLTaskExecutor.getInstance().scheduleCallable(zzef.zza);

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public interface zza<K> {
        zzbh.zzad.zza zza(K k, int i, zzbh.zzab zzabVar);
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public interface zzb {
        void zza(zzbh.zzad zzadVar);
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
    public interface zzc {
        zzbh.zzad.zza zza();
    }

    private zzeg(Context context, SharedPrefManager sharedPrefManager, zzb zzbVar) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzbVar;
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(zzei.zza(sharedPrefManager));
    }

    public final void zza(final zzbh.zzad.zza zzaVar, final zzbs zzbsVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zzaVar, zzbsVar) { // from class: com.google.android.gms.internal.mlkit_vision_text.zzeh
            private final zzeg zza;
            private final zzbh.zzad.zza zzb;
            private final zzbs zzc;

            {
                this.zza = this;
                this.zzb = zzaVar;
                this.zzc = zzbsVar;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.zza.zzb(this.zzb, this.zzc);
            }
        });
    }

    public final void zza(zzc zzcVar, zzbs zzbsVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zza(zzbsVar, jElapsedRealtime, 30L)) {
            this.zzi.put(zzbsVar, Long.valueOf(jElapsedRealtime));
            zza(zzcVar.zza(), zzbsVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K> void zza(K k, long j, zzbs zzbsVar, zza<K> zzaVar) {
        if (zzk) {
            if (!this.zzj.containsKey(zzbsVar)) {
                this.zzj.put(zzbsVar, zzs.zzf());
            }
            zzap<Object, Long> zzapVar = this.zzj.get(zzbsVar);
            zzapVar.zza(k, Long.valueOf(j));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (zza(zzbsVar, jElapsedRealtime, 30L)) {
                this.zzi.put(zzbsVar, Long.valueOf(jElapsedRealtime));
                for (Object obj : zzapVar.zzh()) {
                    List<Long> listZza = zzapVar.zza(obj);
                    Collections.sort(listZza);
                    zzbh.zzab.zza zzaVarZza = zzbh.zzab.zza();
                    Iterator<Long> it = listZza.iterator();
                    long jLongValue = 0;
                    while (it.hasNext()) {
                        jLongValue += it.next().longValue();
                    }
                    zza(zzaVar.zza(obj, zzapVar.zza(obj).size(), (zzbh.zzab) ((zzfy) zzaVarZza.zzc(jLongValue / listZza.size()).zza(zza(listZza, 100.0d)).zzf(zza(listZza, 75.0d)).zze(zza(listZza, 50.0d)).zzd(zza(listZza, 25.0d)).zzb(zza(listZza, 0.0d)).zzh())), zzbsVar);
                }
                this.zzj.remove(zzbsVar);
            }
        }
    }

    private static long zza(List<Long> list, double d) {
        return list.get(Math.max(((int) Math.ceil((d / 100.0d) * list.size())) - 1, 0)).longValue();
    }

    private final boolean zza(zzbs zzbsVar, long j, long j2) {
        return this.zzi.get(zzbsVar) == null || j - this.zzi.get(zzbsVar).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    private static synchronized List<String> zzb() {
        List<String> list = zzb;
        if (list != null) {
            return list;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzb = new ArrayList(locales.size());
        for (int i = 0; i < locales.size(); i++) {
            zzb.add(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        return zzb;
    }

    final /* synthetic */ void zzb(zzbh.zzad.zza zzaVar, zzbs zzbsVar) throws IOException {
        String version;
        String mlSdkInstanceId;
        String strZza = zzaVar.zza().zza();
        if ("NA".equals(strZza) || "".equals(strZza)) {
            strZza = "NA";
        }
        zzbh.zzbg.zza zzaVarZzb = zzbh.zzbg.zzb().zza(this.zzc).zzb(this.zzd).zzd(strZza).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            version = this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion("text-recognition");
        }
        zzbh.zzbg.zza zzaVarZzc = zzaVarZzb.zzc(version);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                mlSdkInstanceId = this.zzh.getResult();
            } else {
                mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
            }
            zzaVarZzc.zze(mlSdkInstanceId);
        }
        zzaVar.zza(zzbsVar).zza(zzaVarZzc);
        this.zze.zza((zzbh.zzad) ((zzfy) zzaVar.zzh()));
    }

    static final /* synthetic */ zzeg zza(ComponentContainer componentContainer) {
        return new zzeg((Context) componentContainer.get(Context.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class), (zzb) componentContainer.get(zzb.class));
    }
}
