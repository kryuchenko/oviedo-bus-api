package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import java.io.File;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class ModelFileHelper {
    public static final int INVALID_INDEX = -1;
    private static final GmsLogger zza = new GmsLogger("ModelFileHelper", "");
    private static final String zzb = String.format("com.google.mlkit.%s.models", "automl");
    private static final String zzc = String.format("com.google.mlkit.%s.models", "translate");
    private static final String zzd = String.format("com.google.mlkit.%s.models", "base");
    private final MlKitContext zze;

    public ModelFileHelper(MlKitContext mlKitContext) {
        this.zze = mlKitContext;
    }

    public final String zza(String str, ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        String absolutePath = modelDir.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(latestCachedModelVersion);
        return sb.toString();
    }

    public void deleteTempFilesInPrivateFolder(String str, ModelType modelType) throws MlKitException {
        File fileZza = zza(str, modelType, true);
        if (deleteRecursively(fileZza)) {
            return;
        }
        GmsLogger gmsLogger = zza;
        String strValueOf = String.valueOf(fileZza != null ? fileZza.getAbsolutePath() : null);
        gmsLogger.e("ModelFileHelper", strValueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(strValueOf) : new String("Failed to delete the temp labels file directory: "));
    }

    public boolean modelExistsLocally(String str, ModelType modelType) throws MlKitException {
        String strZza;
        if (modelType == ModelType.UNKNOWN || (strZza = zza(str, modelType)) == null) {
            return false;
        }
        File file = new File(strZza);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, Constants.MODEL_FILE_NAME);
        if (modelType != ModelType.AUTOML) {
            return file2.exists();
        }
        if (file2.exists()) {
            File file3 = new File(file, Constants.AUTOML_IMAGE_LABELING_LABELS_FILE_NAME);
            File file4 = new File(file, Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME);
            if (file3.exists() && file4.exists()) {
                return true;
            }
        }
        return false;
    }

    public File getModelDir(String str, ModelType modelType) throws MlKitException {
        return zza(str, modelType, false);
    }

    public File getModelTempDir(String str, ModelType modelType) throws MlKitException {
        return zza(str, modelType, true);
    }

    private final File zza(String str, ModelType modelType, boolean z) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z);
        if (!modelDirUnsafe.exists()) {
            GmsLogger gmsLogger = zza;
            String strValueOf = String.valueOf(modelDirUnsafe.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", strValueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(strValueOf) : new String("model folder does not exist, creating one: "));
            if (!modelDirUnsafe.mkdirs()) {
                String strValueOf2 = String.valueOf(modelDirUnsafe);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf2).length() + 31);
                sb.append("Failed to create model folder: ");
                sb.append(strValueOf2);
                throw new MlKitException(sb.toString(), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            String strValueOf3 = String.valueOf(modelDirUnsafe);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf3).length() + 71);
            sb2.append("Can not create model folder, since an existing file has the same name: ");
            sb2.append(strValueOf3);
            throw new MlKitException(sb2.toString(), 6);
        }
        return modelDirUnsafe;
    }

    public File getModelDirUnsafe(String str, ModelType modelType, boolean z) {
        String str2;
        int i = zzb.zza[modelType.ordinal()];
        if (i == 1) {
            str2 = zzd;
        } else if (i == 2) {
            str2 = zzb;
        } else if (i == 3) {
            str2 = zzc;
        } else {
            String strName = modelType.name();
            StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 69);
            sb.append("Unknown model type ");
            sb.append(strName);
            sb.append(". Cannot find a dir to store the downloaded model.");
            throw new IllegalArgumentException(sb.toString());
        }
        File file = new File(this.zze.getApplicationContext().getNoBackupFilesDir(), str2);
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    public synchronized void deleteAllModels(ModelType modelType, String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    public final File zzb(String str, ModelType modelType) throws MlKitException {
        return zza(str, modelType, true);
    }

    public File getTempFileInPrivateFolder(String str, ModelType modelType, String str2) throws MlKitException {
        File fileZza = zza(str, modelType, true);
        if (fileZza.exists() && fileZza.isFile() && !fileZza.delete()) {
            String strValueOf = String.valueOf(fileZza.getAbsolutePath());
            throw new MlKitException(strValueOf.length() != 0 ? "Failed to delete the temp labels file: ".concat(strValueOf) : new String("Failed to delete the temp labels file: "), 13);
        }
        if (!fileZza.exists()) {
            GmsLogger gmsLogger = zza;
            String strValueOf2 = String.valueOf(fileZza.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", strValueOf2.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(strValueOf2) : new String("Temp labels folder does not exist, creating one: "));
            if (!fileZza.mkdirs()) {
                throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
            }
        }
        return new File(fileZza, str2);
    }

    public int getLatestCachedModelVersion(File file) {
        File[] fileArrListFiles = file.listFiles();
        int iMax = -1;
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                try {
                    iMax = Math.max(iMax, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = zza;
                    String strValueOf = String.valueOf(file2.getName());
                    gmsLogger.d("ModelFileHelper", strValueOf.length() != 0 ? "Contains non-integer file name ".concat(strValueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return iMax;
    }

    public boolean deleteRecursively(File file) {
        boolean z;
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            z = true;
            for (File file2 : (File[]) Preconditions.checkNotNull(file.listFiles())) {
                z = z && deleteRecursively(file2);
            }
        } else {
            z = true;
        }
        return z && file.delete();
    }
}
