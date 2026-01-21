package com.google.mlkit.common.internal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzh;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static abstract class ModelLoggingInfo {
        public abstract String getHash();

        public abstract long getSize();

        static ModelLoggingInfo zza(long j, String str) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzh.zza(str));
        }
    }

    public static ModelLoggingInfo getModelLoggingInfo(Context context, LocalModel localModel) throws IOException {
        long length;
        String assetFilePath = localModel.getAssetFilePath();
        String absoluteFilePath = localModel.getAbsoluteFilePath();
        if (assetFilePath != null) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(assetFilePath);
                try {
                    length = assetFileDescriptorOpenFd.getLength();
                    if (assetFileDescriptorOpenFd != null) {
                        assetFileDescriptorOpenFd.close();
                    }
                } finally {
                }
            } catch (IOException e) {
                zza.e("ModelUtils", "Failed to open model file", e);
                return null;
            }
        } else {
            length = new File(absoluteFilePath).length();
        }
        SharedPrefManager sharedPrefManager = (SharedPrefManager) MlKitContext.getInstance().get(SharedPrefManager.class);
        String cachedLocalModelHash = sharedPrefManager.getCachedLocalModelHash(localModel, length);
        if (cachedLocalModelHash != null) {
            return ModelLoggingInfo.zza(length, cachedLocalModelHash);
        }
        try {
            InputStream inputStreamOpen = assetFilePath != null ? context.getAssets().open(assetFilePath) : new FileInputStream(new File(absoluteFilePath));
            try {
                String strZza = zza(inputStreamOpen);
                if (strZza != null) {
                    sharedPrefManager.setCachedLocalModelHash(localModel, length, strZza);
                }
                ModelLoggingInfo modelLoggingInfoZza = ModelLoggingInfo.zza(length, strZza);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return modelLoggingInfoZza;
            } finally {
            }
        } catch (IOException e2) {
            zza.e("ModelUtils", "Failed to open model file", e2);
            return null;
        }
    }

    public static boolean zza(File file, String str) throws IOException {
        String sha256 = getSHA256(file);
        GmsLogger gmsLogger = zza;
        String strValueOf = String.valueOf(sha256);
        gmsLogger.d("ModelUtils", strValueOf.length() != 0 ? "Calculated hash value is: ".concat(strValueOf) : new String("Calculated hash value is: "));
        return str.equals(sha256);
    }

    public static String getSHA256(File file) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZza = zza(fileInputStream);
                fileInputStream.close();
                return strZza;
            } finally {
            }
        } catch (IOException unused) {
            GmsLogger gmsLogger = zza;
            String strValueOf = String.valueOf(file.getAbsolutePath());
            gmsLogger.e("ModelUtils", strValueOf.length() != 0 ? "Failed to create FileInputStream for model: ".concat(strValueOf) : new String("Failed to create FileInputStream for model: "));
            return null;
        }
    }

    private static String zza(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }

    private ModelUtils() {
    }
}
