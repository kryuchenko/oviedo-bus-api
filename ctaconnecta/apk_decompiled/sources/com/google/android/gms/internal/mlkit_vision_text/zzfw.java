package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfw implements zzhh {
    private static final zzfw zza = new zzfw();

    private zzfw() {
    }

    public static zzfw zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhh
    public final boolean zza(Class<?> cls) {
        return zzfy.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhh
    public final zzhe zzb(Class<?> cls) {
        if (!zzfy.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzhe) zzfy.zza(cls.asSubclass(zzfy.class)).zza(zzfy.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
