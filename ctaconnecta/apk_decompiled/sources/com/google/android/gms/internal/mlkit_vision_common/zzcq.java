package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzcq {
    public static final Component<?> zza = Component.builder(zzcq.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) SharedPrefManager.class)).add(Dependency.required((Class<?>) zza.class)).factory(zzcu.zza).build();
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zza zze;
    private final SharedPrefManager zzf;
    private final Task<String> zzh;
    private final Map<zzag, Long> zzi = new HashMap();
    private final Map<zzag, Object> zzj = new HashMap();
    private final Task<String> zzg = MLTaskExecutor.getInstance().scheduleCallable(zzct.zza);

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public interface zza {
        void zza(zzr.zzad zzadVar);
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public interface zzb {
        zzr.zzad.zza zza();
    }

    private zzcq(Context context, SharedPrefManager sharedPrefManager, zza zzaVar) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzaVar;
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(zzcs.zza(sharedPrefManager));
    }

    public final void zza(zzb zzbVar, final zzag zzagVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzi.get(zzagVar) != null && jElapsedRealtime - this.zzi.get(zzagVar).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzi.put(zzagVar, Long.valueOf(jElapsedRealtime));
        final zzr.zzad.zza zzaVarZza = zzbVar.zza();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zzaVarZza, zzagVar) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzcv
            private final zzcq zza;
            private final zzr.zzad.zza zzb;
            private final zzag zzc;

            {
                this.zza = this;
                this.zzb = zzaVarZza;
                this.zzc = zzagVar;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.zza.zza(this.zzb, this.zzc);
            }
        });
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

    final /* synthetic */ void zza(zzr.zzad.zza zzaVar, zzag zzagVar) throws IOException {
        String version;
        String mlSdkInstanceId;
        String strZza = zzaVar.zza().zza();
        if ("NA".equals(strZza) || "".equals(strZza)) {
            strZza = "NA";
        }
        zzr.zzbg.zza zzaVarZzb = zzr.zzbg.zzb().zza(this.zzc).zzb(this.zzd).zzd(strZza).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            version = this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion("vision-common");
        }
        zzr.zzbg.zza zzaVarZzc = zzaVarZzb.zzc(version);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                mlSdkInstanceId = this.zzh.getResult();
            } else {
                mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
            }
            zzaVarZzc.zze(mlSdkInstanceId);
        }
        zzaVar.zza(zzagVar).zza(zzaVarZzc);
        this.zze.zza((zzr.zzad) ((zzek) zzaVar.zzg()));
    }

    static final /* synthetic */ zzcq zza(ComponentContainer componentContainer) {
        return new zzcq((Context) componentContainer.get(Context.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class), (zza) componentContainer.get(zza.class));
    }
}
