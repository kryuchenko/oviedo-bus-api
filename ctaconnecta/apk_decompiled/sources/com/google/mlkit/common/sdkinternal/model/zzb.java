package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzb {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[ModelType.values().length];
        zza = iArr;
        try {
            iArr[ModelType.BASE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[ModelType.AUTOML.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[ModelType.TRANSLATE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
