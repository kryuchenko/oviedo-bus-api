package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzex implements zzgi {
    private static final zzex zza = new zzex();

    private zzex() {
    }

    public static zzex zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final boolean zza(Class<?> cls) {
        return zzez.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final zzgf zzb(Class<?> cls) {
        if (!zzez.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzgf) zzez.zza(cls.asSubclass(zzez.class)).zza(zzez.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
