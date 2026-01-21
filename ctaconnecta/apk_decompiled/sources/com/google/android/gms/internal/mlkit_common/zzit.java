package com.google.android.gms.internal.mlkit_common;

import kotlin.text.Typography;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzit implements zzfb {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);

    private static final zzfe<zzit> zzd = new zzfe<zzit>() { // from class: com.google.android.gms.internal.mlkit_common.zzis
    };
    private final int zze;

    @Override // com.google.android.gms.internal.mlkit_common.zzfb
    public final int zza() {
        return this.zze;
    }

    public static zzfd zzb() {
        return zziu.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    zzit(int i) {
        this.zze = i;
    }
}
