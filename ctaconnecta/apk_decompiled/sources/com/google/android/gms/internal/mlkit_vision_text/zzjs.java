package com.google.android.gms.internal.mlkit_vision_text;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzjs implements zzga {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);

    private static final zzgd<zzjs> zzd = new zzgd<zzjs>() { // from class: com.google.android.gms.internal.mlkit_vision_text.zzjr
    };
    private final int zze;

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
    public final int zza() {
        return this.zze;
    }

    public static zzgc zzb() {
        return zzjt.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    zzjs(int i) {
        this.zze = i;
    }
}
