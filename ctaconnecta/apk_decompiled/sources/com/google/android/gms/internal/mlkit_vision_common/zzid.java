package com.google.android.gms.internal.mlkit_vision_common;

import kotlin.text.Typography;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzid implements zzep {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);

    private static final zzeo<zzid> zzd = new zzeo<zzid>() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzig
    };
    private final int zze;

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
    public final int zza() {
        return this.zze;
    }

    public static zzer zzb() {
        return zzif.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    zzid(int i) {
        this.zze = i;
    }
}
