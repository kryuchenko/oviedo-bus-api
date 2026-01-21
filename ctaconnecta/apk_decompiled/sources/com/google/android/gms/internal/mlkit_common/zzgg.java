package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgg {
    private static final zzge zza = zzc();
    private static final zzge zzb = new zzgd();

    static zzge zza() {
        return zza;
    }

    static zzge zzb() {
        return zzb;
    }

    private static zzge zzc() {
        try {
            return (zzge) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
