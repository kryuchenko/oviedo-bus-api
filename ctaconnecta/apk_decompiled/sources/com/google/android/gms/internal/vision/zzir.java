package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzir {
    private static final zzip zzaaa = zzho();
    private static final zzip zzaab = new zzio();

    static zzip zzhm() {
        return zzaaa;
    }

    static zzip zzhn() {
        return zzaab;
    }

    private static zzip zzho() {
        try {
            return (zzip) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
