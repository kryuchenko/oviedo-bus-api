package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzel implements zzfs {
    private static final zzel zza = new zzel();

    private zzel() {
    }

    public static zzel zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final boolean zza(Class<?> cls) {
        return zzek.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final zzft zzb(Class<?> cls) {
        if (!zzek.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzft) zzek.zza(cls.asSubclass(zzek.class)).zza(zzek.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
