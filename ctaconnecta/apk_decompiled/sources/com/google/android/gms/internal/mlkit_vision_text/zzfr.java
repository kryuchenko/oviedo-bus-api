package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfr {
    private static final zzfp<?> zza = new zzfo();
    private static final zzfp<?> zzb = zzc();

    private static zzfp<?> zzc() {
        try {
            return (zzfp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzfp<?> zza() {
        return zza;
    }

    static zzfp<?> zzb() {
        zzfp<?> zzfpVar = zzb;
        if (zzfpVar != null) {
            return zzfpVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
