package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzec {
    private static final zzea<?> zza = new zzed();
    private static final zzea<?> zzb = zzc();

    private static zzea<?> zzc() {
        try {
            return (zzea) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzea<?> zza() {
        return zza;
    }

    static zzea<?> zzb() {
        zzea<?> zzeaVar = zzb;
        if (zzeaVar != null) {
            return zzeaVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
