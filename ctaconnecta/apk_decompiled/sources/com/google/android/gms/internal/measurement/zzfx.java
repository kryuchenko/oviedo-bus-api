package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzfx {
    private static zzga zza;

    public static synchronized zzga zza() {
        if (zza == null) {
            zza(new zzfz());
        }
        return zza;
    }

    private static synchronized void zza(zzga zzgaVar) {
        if (zza != null) {
            throw new IllegalStateException("init() already called");
        }
        zza = zzgaVar;
    }
}
