package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhr {
    private static final zzhp zza = zzc();
    private static final zzhp zzb = new zzho();

    static zzhp zza() {
        return zza;
    }

    static zzhp zzb() {
        return zzb;
    }

    private static zzhp zzc() {
        try {
            return (zzhp) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
