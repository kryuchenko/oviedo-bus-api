package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzdj {
    public static zzaa.zzal.zza zza(ModelType modelType) {
        int i = zzdl.zza[modelType.ordinal()];
        return i != 1 ? i != 2 ? zzaa.zzal.zza.TYPE_UNKNOWN : zzaa.zzal.zza.AUTOML_IMAGE_LABELING : zzaa.zzal.zza.BASE_TRANSLATE;
    }
}
