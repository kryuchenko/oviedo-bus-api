package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.ktx.BuildConfig;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class ModelLoader {
    private static final GmsLogger zza = new GmsLogger("ModelLoader", "");
    public final LocalModelLoader localModelLoader;
    protected ModelLoadingState modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
    public final RemoteModelLoader remoteModelLoader;
    private final ModelLoadingLogger zzb;

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public interface ModelContentHandler {
        void zza(MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public interface ModelLoadingLogger {
        void zza(List<Integer> list);
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    public ModelLoader(RemoteModelLoader remoteModelLoader, LocalModelLoader localModelLoader, ModelLoadingLogger modelLoadingLogger) {
        Preconditions.checkArgument((remoteModelLoader == null && localModelLoader == null) ? false : true, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader;
        this.localModelLoader = localModelLoader;
        this.zzb = modelLoadingLogger;
    }

    public synchronized void loadWithModelContentHandler(ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean zZza;
        ArrayList arrayList = new ArrayList();
        boolean zZzb = false;
        Exception e = null;
        try {
            zZza = zza(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e2) {
            exc = e2;
            zZza = false;
        }
        if (zZza) {
            this.zzb.zza(arrayList);
            this.modelLoadingState = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            zZzb = zzb(modelContentHandler, arrayList);
        } catch (Exception e3) {
            e = e3;
        }
        if (zZzb) {
            this.zzb.zza(arrayList);
            this.modelLoadingState = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.zzb.zza(arrayList);
        this.modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
        if (exc != null) {
            String strValueOf = String.valueOf(zza());
            throw new MlKitException(strValueOf.length() != 0 ? "Remote model load failed with the model options: ".concat(strValueOf) : new String("Remote model load failed with the model options: "), 14, exc);
        }
        if (e != null) {
            String strValueOf2 = String.valueOf(zza());
            throw new MlKitException(strValueOf2.length() != 0 ? "Local model load failed with the model options: ".concat(strValueOf2) : new String("Local model load failed with the model options: "), 14, e);
        }
        String strValueOf3 = String.valueOf(zza());
        throw new MlKitException(strValueOf3.length() != 0 ? "Cannot load any model with the model options: ".concat(strValueOf3) : new String("Cannot load any model with the model options: "), 14);
    }

    public synchronized boolean isRemoteModelLoaded() {
        return this.modelLoadingState == ModelLoadingState.REMOTE_MODEL_LOADED;
    }

    private final synchronized boolean zza(ModelContentHandler modelContentHandler, List<Integer> list) throws MlKitException {
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        if (remoteModelLoader != null) {
            try {
                MappedByteBuffer mappedByteBufferLoad = remoteModelLoader.load();
                if (mappedByteBufferLoad != null) {
                    try {
                        modelContentHandler.zza(mappedByteBufferLoad);
                        zza.d("ModelLoader", "Remote model source is loaded successfully");
                        return true;
                    } catch (RuntimeException e) {
                        list.add(19);
                        throw e;
                    }
                }
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(21);
            } catch (MlKitException e2) {
                zza.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e2;
            }
        }
        return false;
    }

    private final synchronized boolean zzb(ModelContentHandler modelContentHandler, List<Integer> list) throws MlKitException {
        MappedByteBuffer mappedByteBufferLoad;
        LocalModelLoader localModelLoader = this.localModelLoader;
        if (localModelLoader == null || (mappedByteBufferLoad = localModelLoader.load()) == null) {
            return false;
        }
        try {
            modelContentHandler.zza(mappedByteBufferLoad);
            zza.d("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e) {
            list.add(18);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zza() {
        String absoluteFilePath;
        String uniqueModelNameForPersist;
        LocalModelLoader localModelLoader = this.localModelLoader;
        if (localModelLoader == null) {
            absoluteFilePath = null;
        } else if (localModelLoader.getLocalModel().getAssetFilePath() != null) {
            absoluteFilePath = this.localModelLoader.getLocalModel().getAssetFilePath();
        } else if (this.localModelLoader.getLocalModel().getAbsoluteFilePath() != null) {
            absoluteFilePath = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
        }
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        if (remoteModelLoader == null) {
            uniqueModelNameForPersist = BuildConfig.VERSION_NAME;
        } else {
            uniqueModelNameForPersist = remoteModelLoader.getRemoteModel().getUniqueModelNameForPersist();
        }
        return String.format("Local model path: %s. Remote model name: %s. ", absoluteFilePath, uniqueModelNameForPersist);
    }
}
