package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzic {
    private static final zzia zzzf = zzhi();
    private static final zzia zzzg = new zzid();

    static zzia zzhg() {
        return zzzf;
    }

    static zzia zzhh() {
        return zzzg;
    }

    private static zzia zzhi() {
        try {
            return (zzia) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
