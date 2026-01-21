package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class LegacyModelMigrator {
    protected final ModelFileHelper modelFileHelper;
    private final Context zzb;
    private final TaskCompletionSource<Void> zza = new TaskCompletionSource<>();
    private final Executor zzc = MLTaskExecutor.workerThreadExecutor();

    protected LegacyModelMigrator(Context context, ModelFileHelper modelFileHelper) {
        this.zzb = context;
        this.modelFileHelper = modelFileHelper;
    }

    protected abstract String getLegacyModelDirName();

    protected abstract void migrateAllModelDirs(File file);

    public void start() {
        this.zzc.execute(new Runnable(this) { // from class: com.google.mlkit.common.sdkinternal.model.zza
            private final LegacyModelMigrator zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza();
            }
        });
    }

    public Task<Void> getMigrationTask() {
        return this.zza.getTask();
    }

    public static void migrateFile(File file, File file2) {
        if (file.exists()) {
            if (!file2.exists() && !file.renameTo(file2)) {
                String strValueOf = String.valueOf(file);
                String strValueOf2 = String.valueOf(file2);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 28 + String.valueOf(strValueOf2).length());
                sb.append("Error moving model file ");
                sb.append(strValueOf);
                sb.append(" to ");
                sb.append(strValueOf2);
                Log.e("MlKitLegacyMigration", sb.toString());
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            String strValueOf3 = String.valueOf(file);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf3).length() + 26);
            sb2.append("Error deleting model file ");
            sb2.append(strValueOf3);
            Log.e("MlKitLegacyMigration", sb2.toString());
        }
    }

    public File getLegacyRootDir() {
        return new File(this.zzb.getNoBackupFilesDir(), getLegacyModelDirName());
    }

    protected static boolean isValidFirebasePersistenceKey(String str) {
        String[] strArrSplit = str.split("\\+", -1);
        if (strArrSplit.length != 2) {
            return false;
        }
        try {
            Base64Utils.decodeUrlSafeNoPadding(strArrSplit[0]);
            Base64Utils.decodeUrlSafeNoPadding(strArrSplit[1]);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    protected static void deleteIfEmpty(File file) {
        if ((file.listFiles() == null || file.listFiles().length == 0) && !file.delete()) {
            String strValueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 31);
            sb.append("Error deleting model directory ");
            sb.append(strValueOf);
            Log.e("MlKitLegacyMigration", sb.toString());
        }
    }

    final /* synthetic */ void zza() {
        File legacyRootDir = getLegacyRootDir();
        File[] fileArrListFiles = legacyRootDir.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                migrateAllModelDirs(file);
            }
            deleteIfEmpty(legacyRootDir);
        }
        this.zza.setResult(null);
    }
}
