package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgo {
    private static final zzgk<?> zztu = new zzgm();
    private static final zzgk<?> zztv = zzfq();

    private static zzgk<?> zzfq() {
        try {
            return (zzgk) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzgk<?> zzfr() {
        return zztu;
    }

    static zzgk<?> zzfs() {
        zzgk<?> zzgkVar = zztv;
        if (zzgkVar != null) {
            return zzgkVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
