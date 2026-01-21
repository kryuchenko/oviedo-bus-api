package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    public LocalModelLoader(Context context, LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    public MappedByteBuffer load() throws MlKitException, IOException {
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        if (this.zzc.getAbsoluteFilePath() != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.zzc.getAbsoluteFilePath(), "r");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    this.zza = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    randomAccessFile.close();
                    return this.zza;
                } finally {
                }
            } catch (IOException e) {
                String strValueOf = String.valueOf(this.zzc.getAbsoluteFilePath());
                throw new MlKitException(strValueOf.length() != 0 ? "Can not open the local file: ".concat(strValueOf) : new String("Can not open the local file: "), 14, e);
            }
        } else if (this.zzc.getAssetFilePath() != null) {
            String assetFilePath = this.zzc.getAssetFilePath();
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.zzb.getAssets().openFd(assetFilePath);
                try {
                    this.zza = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel().map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
                    if (assetFileDescriptorOpenFd != null) {
                        assetFileDescriptorOpenFd.close();
                    }
                    return this.zza;
                } finally {
                }
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder(String.valueOf(assetFilePath).length() + CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256);
                sb.append("Can not load the file from asset: ");
                sb.append(assetFilePath);
                sb.append(". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression");
                throw new MlKitException(sb.toString(), 14, e2);
            }
        } else {
            throw new MlKitException("Can not load the model. Either filePath or assetFilePath must be set for the model.", 14);
        }
    }

    public LocalModel getLocalModel() {
        return this.zzc;
    }
}
