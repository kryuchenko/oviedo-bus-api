package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgv implements zzie {
    private static final zzgv zzwn = new zzgv();

    private zzgv() {
    }

    public static zzgv zzfx() {
        return zzwn;
    }

    @Override // com.google.android.gms.internal.vision.zzie
    public final boolean zza(Class<?> cls) {
        return zzgx.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.vision.zzie
    public final zzif zzb(Class<?> cls) {
        if (!zzgx.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzif) zzgx.zzd(cls.asSubclass(zzgx.class)).zza(zzgx.zzf.zzxc, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
