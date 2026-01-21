package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhf {
    private static final zzhd zza = zzc();
    private static final zzhd zzb = new zzhc();

    static zzhd zza() {
        return zza;
    }

    static zzhd zzb() {
        return zzb;
    }

    private static zzhd zzc() {
        try {
            return (zzhd) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
