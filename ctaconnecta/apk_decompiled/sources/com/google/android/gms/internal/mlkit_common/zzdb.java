package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.internal.mlkit_common.zzaa;
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

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzdb {
    public static final Component<?> zza = Component.builder(zzdb.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) SharedPrefManager.class)).add(Dependency.required((Class<?>) zza.class)).factory(zzde.zza).build();
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zza zze;
    private final SharedPrefManager zzf;
    private final Task<String> zzh;
    private final Map<zzap, Long> zzi = new HashMap();
    private final Map<zzap, Object> zzj = new HashMap();
    private final Task<String> zzg = MLTaskExecutor.getInstance().scheduleCallable(zzda.zza);

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public interface zza {
        void zza(zzaa.zzad zzadVar);
    }

    private zzdb(Context context, SharedPrefManager sharedPrefManager, zza zzaVar) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzaVar;
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(zzdd.zza(sharedPrefManager));
    }

    public final void zza(final zzaa.zzad.zza zzaVar, final zzap zzapVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zzaVar, zzapVar) { // from class: com.google.android.gms.internal.mlkit_common.zzdc
            private final zzdb zza;
            private final zzaa.zzad.zza zzb;
            private final zzap zzc;

            {
                this.zza = this;
                this.zzb = zzaVar;
                this.zzc = zzapVar;
            }

            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.zza.zzb(this.zzb, this.zzc);
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

    final /* synthetic */ void zzb(zzaa.zzad.zza zzaVar, zzap zzapVar) throws IOException {
        String version;
        String mlSdkInstanceId;
        String strZza = zzaVar.zza().zza();
        if ("NA".equals(strZza) || "".equals(strZza)) {
            strZza = "NA";
        }
        zzaa.zzbg.zza zzaVarZzb = zzaa.zzbg.zzb().zza(this.zzc).zzb(this.zzd).zzd(strZza).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            version = this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion("common");
        }
        zzaa.zzbg.zza zzaVarZzc = zzaVarZzb.zzc(version);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                mlSdkInstanceId = this.zzh.getResult();
            } else {
                mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
            }
            zzaVarZzc.zze(mlSdkInstanceId);
        }
        zzaVar.zza(zzapVar).zza(zzaVarZzc);
        this.zze.zza((zzaa.zzad) ((zzez) zzaVar.zzh()));
    }

    static final /* synthetic */ zzdb zza(ComponentContainer componentContainer) {
        return new zzdb((Context) componentContainer.get(Context.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class), (zza) componentContainer.get(zza.class));
    }
}
