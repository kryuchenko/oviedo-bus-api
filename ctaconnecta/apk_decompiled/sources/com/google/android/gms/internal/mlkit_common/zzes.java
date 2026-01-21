package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzes {
    private static final zzeq<?> zza = new zzep();
    private static final zzeq<?> zzb = zzc();

    private static zzeq<?> zzc() {
        try {
            return (zzeq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzeq<?> zza() {
        return zza;
    }

    static zzeq<?> zzb() {
        zzeq<?> zzeqVar = zzb;
        if (zzeqVar != null) {
            return zzeqVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
