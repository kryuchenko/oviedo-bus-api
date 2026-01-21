package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzdg;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");
    private static final Map<String, RemoteModelLoader> zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final zzdg zzg;
    private final RemoteModelLoaderHelper zzh;
    private final ModelType zzi;
    private boolean zzj;

    private RemoteModelLoader(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zzj = true;
        this.zzg = ((zzdg.zza) MlKitContext.getInstance().get(zzdg.zza.class)).get(remoteModel);
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzh = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzi = remoteModel.getModelType();
    }

    public static synchronized RemoteModelLoader getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        String uniqueModelNameForPersist;
        Map<String, RemoteModelLoader> map;
        uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
        map = zzb;
        if (!map.containsKey(uniqueModelNameForPersist)) {
            map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
        }
        return map.get(uniqueModelNameForPersist);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x001e, B:9:0x0026, B:29:0x00d1, B:10:0x002d, B:12:0x0059, B:14:0x0061, B:16:0x0077, B:18:0x0082, B:20:0x008c, B:22:0x0094, B:17:0x007c, B:23:0x00a6, B:25:0x00ae, B:26:0x00c2), top: B:35:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized MappedByteBuffer load() throws MlKitException {
        MappedByteBuffer mappedByteBufferZza;
        GmsLogger gmsLogger = zza;
        gmsLogger.d("RemoteModelLoader", "Try to load newly downloaded model file.");
        boolean z = this.zzj;
        Long downloadingId = this.zze.getDownloadingId();
        String downloadingModelHash = this.zze.getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            gmsLogger.d("RemoteModelLoader", "No new model is downloading.");
            this.zze.removeOrCancelDownload();
        } else {
            Integer downloadingModelStatusCode = this.zze.getDownloadingModelStatusCode();
            if (downloadingModelStatusCode == null) {
                this.zze.removeOrCancelDownload();
            } else {
                String strValueOf = String.valueOf(downloadingModelStatusCode);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
                sb.append("Download Status code: ");
                sb.append(strValueOf);
                gmsLogger.d("RemoteModelLoader", sb.toString());
                if (downloadingModelStatusCode.intValue() == 8) {
                    File fileZza = this.zze.zza(downloadingModelHash);
                    if (fileZza != null) {
                        mappedByteBufferZza = zza(fileZza);
                        String strValueOf2 = String.valueOf(fileZza.getParent());
                        gmsLogger.d("RemoteModelLoader", strValueOf2.length() != 0 ? "Moved the downloaded model to private folder successfully: ".concat(strValueOf2) : new String("Moved the downloaded model to private folder successfully: "));
                        this.zze.updateLatestModelHashAndType(downloadingModelHash);
                        if (z && this.zzf.zza(fileZza)) {
                            gmsLogger.d("RemoteModelLoader", "All old models are deleted.");
                            mappedByteBufferZza = zza(this.zzf.zzc(fileZza));
                        }
                    }
                    if (mappedByteBufferZza == null) {
                        gmsLogger.d("RemoteModelLoader", "Loading existing model file.");
                        mappedByteBufferZza = zza();
                    }
                } else if (downloadingModelStatusCode.intValue() == 16) {
                    this.zzg.zza(false, this.zzi, this.zze.getFailureReason(downloadingId));
                    this.zze.removeOrCancelDownload();
                }
            }
        }
        mappedByteBufferZza = null;
        if (mappedByteBufferZza == null) {
        }
        return mappedByteBufferZza;
    }

    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    private final MappedByteBuffer zza(File file) throws MlKitException {
        try {
            return zza(file.getAbsolutePath());
        } catch (Exception e) {
            this.zzf.zzb(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e);
        }
    }

    private final MappedByteBuffer zza() throws MlKitException {
        String strZza = this.zzf.zza();
        if (strZza == null) {
            zza.d("RemoteModelLoader", "No existing model file");
            return null;
        }
        try {
            return zza(strZza);
        } catch (Exception e) {
            this.zzf.zzb(new File(strZza));
            SharedPrefManager.getInstance(this.zzc).clearLatestModelHash(this.zzd);
            throw new MlKitException("Failed to load an already downloaded model.", 14, e);
        }
    }

    private final MappedByteBuffer zza(String str) throws MlKitException {
        return this.zzh.loadModelAtPath(str);
    }
}
