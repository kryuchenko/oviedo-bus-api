package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzdg {
    private final zzdb zzc;
    private final RemoteModel zzd;
    private final SharedPrefManager zze;
    private static final GmsLogger zzb = new GmsLogger("ModelDownloadLogger", "");
    public static final Component<?> zza = Component.builder(zza.class).add(Dependency.required((Class<?>) zzdb.class)).add(Dependency.required((Class<?>) SharedPrefManager.class)).factory(zzdf.zza).build();

    private zzdg(zzdb zzdbVar, SharedPrefManager sharedPrefManager, RemoteModel remoteModel) {
        this.zzc = zzdbVar;
        this.zzd = remoteModel;
        this.zze = sharedPrefManager;
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static class zza extends LazyInstanceMap<RemoteModel, zzdg> {
        private final zzdb zza;
        private final SharedPrefManager zzb;

        private zza(zzdb zzdbVar, SharedPrefManager sharedPrefManager) {
            this.zza = zzdbVar;
            this.zzb = sharedPrefManager;
        }

        @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
        protected /* synthetic */ zzdg create(RemoteModel remoteModel) {
            return new zzdg(this.zza, this.zzb, remoteModel);
        }
    }

    private final void zza(zzal zzalVar, String str, boolean z, boolean z2, ModelType modelType, zzaa.zzak.zzb zzbVar, int i) {
        RemoteModel remoteModel = this.zzd;
        String modelHash = remoteModel.getModelHash();
        zzaa.zzal.zza zzaVarZza = zzdj.zza(modelType);
        zzaa.zzam.zzb zzbVarZza = zzaa.zzam.zza();
        zzaa.zzal.zzb zzbVarZza2 = zzaa.zzal.zza().zza(remoteModel.getModelNameForBackend()).zza(zzaa.zzal.zzc.CLOUD);
        if (modelHash == null) {
            modelHash = "";
        }
        zzaa.zzak.zza zzaVarZza2 = zzaa.zzak.zza().zza(zzalVar).zza(zzbVar).zzc(i).zza((zzaa.zzam) ((zzez) zzbVarZza.zza(zzbVarZza2.zzb(modelHash).zza(zzaVarZza)).zzh()));
        if (z) {
            long modelDownloadBeginTimeMs = this.zze.getModelDownloadBeginTimeMs(this.zzd);
            if (modelDownloadBeginTimeMs == 0) {
                zzb.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = this.zze.getModelFirstUseTimeMs(this.zzd);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    this.zze.setModelFirstUseTimeMs(this.zzd, modelFirstUseTimeMs);
                }
                zzaVarZza2.zza(modelFirstUseTimeMs - modelDownloadBeginTimeMs);
            }
        }
        if (z2) {
            long modelDownloadBeginTimeMs2 = this.zze.getModelDownloadBeginTimeMs(this.zzd);
            if (modelDownloadBeginTimeMs2 == 0) {
                zzb.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
            } else {
                zzaVarZza2.zzb(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2);
            }
        }
        this.zzc.zza(zzaa.zzad.zzb().zza(zzaa.zzbg.zzb().zzd(str)).zza(zzaVarZza2), zzap.MODEL_DOWNLOAD);
    }

    public final void zza(int i, boolean z, ModelType modelType, int i2) {
        zza(zzdk.zza(i), "NA", z, false, modelType, zzdi.zza(i2), 0);
    }

    public final void zza(int i, ModelType modelType, int i2) {
        zza(zzdk.zza(0), "NA", false, true, modelType, zzdi.zza(6), 0);
    }

    public final void zza(boolean z, ModelType modelType, int i) {
        zza(zzal.DOWNLOAD_FAILED, "NA", false, false, modelType, zzaa.zzak.zzb.FAILED, i);
    }

    static final /* synthetic */ zza zza(ComponentContainer componentContainer) {
        return new zza((zzdb) componentContainer.get(zzdb.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class));
    }
}
