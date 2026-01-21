package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzrw {
    private static final zzpd zza;

    static {
        zzph zzphVarZza = zzpi.zza();
        zzphVarZza.zzb(Typography.quote, "&quot;");
        zzphVarZza.zzb('\'', "&#39;");
        zzphVarZza.zzb(Typography.amp, "&amp;");
        zzphVarZza.zzb(Typography.less, "&lt;");
        zzphVarZza.zzb(Typography.greater, "&gt;");
        zza = zzphVarZza.zza();
    }

    static String zza(String str) {
        return zza.zza(str);
    }
}
