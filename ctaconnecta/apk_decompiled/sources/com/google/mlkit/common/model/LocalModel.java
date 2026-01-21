package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class LocalModel {
    private final String zza;
    private final String zzb;

    public String getAbsoluteFilePath() {
        return this.zza;
    }

    public String getAssetFilePath() {
        return this.zzb;
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static class Builder {
        private String zza = null;
        private String zzb = null;

        public Builder setAbsoluteFilePath(String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.zzb == null, "A local model source is either from local file or from asset, you can not set both.");
            this.zza = str;
            return this;
        }

        public Builder setAssetFilePath(String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            Preconditions.checkArgument(this.zza == null, "A local model source is either from local file or from asset, you can not set both.");
            this.zzb = str;
            return this;
        }

        public LocalModel build() {
            String str = this.zza;
            Preconditions.checkArgument((str != null && this.zzb == null) || (str == null && this.zzb != null), "Set either filePath or assetFilePath.");
            return new LocalModel(this.zza, this.zzb);
        }
    }

    private LocalModel(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalModel)) {
            return false;
        }
        LocalModel localModel = (LocalModel) obj;
        return Objects.equal(this.zza, localModel.zza) && Objects.equal(this.zzb, localModel.zzb);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }
}
