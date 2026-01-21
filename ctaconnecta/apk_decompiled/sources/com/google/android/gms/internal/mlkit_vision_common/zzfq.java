package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfq {
    private static final zzfo zza = zzc();
    private static final zzfo zzb = new zzfr();

    static zzfo zza() {
        return zza;
    }

    static zzfo zzb() {
        return zzb;
    }

    private static zzfo zzc() {
        try {
            return (zzfo) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
