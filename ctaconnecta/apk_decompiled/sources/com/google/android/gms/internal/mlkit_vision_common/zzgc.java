package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgc {
    private static final zzga zza = zzc();
    private static final zzga zzb = new zzgd();

    static zzga zza() {
        return zza;
    }

    static zzga zzb() {
        return zzb;
    }

    private static zzga zzc() {
        try {
            return (zzga) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
