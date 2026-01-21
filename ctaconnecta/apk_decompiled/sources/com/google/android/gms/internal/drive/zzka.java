package com.google.android.gms.internal.drive;

/* loaded from: classes3.dex */
final class zzka {
    private static final zzjy<?> zzoq = new zzjz();
    private static final zzjy<?> zzor = zzck();

    private static zzjy<?> zzck() {
        try {
            return (zzjy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzjy<?> zzcl() {
        return zzoq;
    }

    static zzjy<?> zzcm() {
        zzjy<?> zzjyVar = zzor;
        if (zzjyVar != null) {
            return zzjyVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
