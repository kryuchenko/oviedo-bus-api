package com.google.android.gms.internal.drive;

/* loaded from: classes3.dex */
final class zzma {
    private static final zzly zzuu = zzei();
    private static final zzly zzuv = new zzlz();

    static zzly zzeg() {
        return zzuu;
    }

    static zzly zzeh() {
        return zzuv;
    }

    private static zzly zzei() {
        try {
            return (zzly) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
