package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzazd {
    private static final zzazd zza = new zzazd(new zzayz(), zzaza.zza);
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    zzazd(zzazc... zzazcVarArr) {
        for (int i = 0; i < 2; i++) {
            zzazc zzazcVar = zzazcVarArr[i];
            this.zzb.put(zzazcVar.zzb(), zzazcVar);
        }
    }

    public static zzazd zza() {
        return zza;
    }
}
