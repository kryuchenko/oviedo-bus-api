package com.google.mlkit.common.model;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class RemoteModel {
    private static final Map<BaseModel, String> zzd = new EnumMap(BaseModel.class);
    private static final Map<BaseModel, String> zze = new EnumMap(BaseModel.class);
    private final String zza;
    private final BaseModel zzb;
    private final ModelType zzc;
    private String zzf;

    protected RemoteModel(String str, BaseModel baseModel, ModelType modelType) {
        Preconditions.checkArgument(TextUtils.isEmpty(str) == (baseModel != null), "One of cloud model name and base model cannot be empty");
        this.zza = str;
        this.zzb = baseModel;
        this.zzc = modelType;
    }

    public String getModelNameForBackend() {
        String str = this.zza;
        return str != null ? str : zze.get(this.zzb);
    }

    public String getUniqueModelNameForPersist() {
        String str = this.zza;
        if (str != null) {
            return str;
        }
        String strValueOf = String.valueOf(zze.get(this.zzb));
        return strValueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(strValueOf) : new String("COM.GOOGLE.BASE_");
    }

    public boolean isBaseModel() {
        return this.zzb != null;
    }

    public String getModelName() {
        return this.zza;
    }

    public ModelType getModelType() {
        return this.zzc;
    }

    public boolean baseModelHashMatches(String str) {
        BaseModel baseModel = this.zzb;
        if (baseModel == null) {
            return false;
        }
        return str.equals(zzd.get(baseModel));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        return Objects.equal(this.zza, remoteModel.zza) && Objects.equal(this.zzb, remoteModel.zzb);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public void setModelHash(String str) {
        this.zzf = str;
    }

    public String getModelHash() {
        return this.zzf;
    }
}
