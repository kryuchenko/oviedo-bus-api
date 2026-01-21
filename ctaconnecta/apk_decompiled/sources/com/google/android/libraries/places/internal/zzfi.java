package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class zzfi {
    private final zzjt zza;

    protected zzfi(zzjt zzjtVar) {
        this.zza = zzjtVar;
    }

    protected final CancellationToken zza() {
        return this.zza.getCancellationToken();
    }

    protected final zzjt zzb() {
        return this.zza;
    }

    protected abstract String zzc();

    protected abstract Map zzd();
}
