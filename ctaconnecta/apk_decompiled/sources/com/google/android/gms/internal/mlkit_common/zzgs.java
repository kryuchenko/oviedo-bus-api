package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgs {
    private static final zzgq zza = zzc();
    private static final zzgq zzb = new zzgp();

    static zzgq zza() {
        return zza;
    }

    static zzgq zzb() {
        return zzb;
    }

    private static zzgq zzc() {
        try {
            return (zzgq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
