package com.google.android.libraries.places.internal;

import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbbg {
    private List zza;
    private zzaye zzb = zzaye.zza;

    @Nullable
    private Object zzc;

    zzbbg() {
    }

    public final zzbbg zza(List list) {
        this.zza = list;
        return this;
    }

    public final zzbbg zzb(zzaye zzayeVar) {
        this.zzb = zzayeVar;
        return this;
    }

    public final zzbbg zzc(@Nullable Object obj) {
        this.zzc = obj;
        return this;
    }

    public final zzbbi zzd() {
        return new zzbbi(this.zza, this.zzb, this.zzc, null);
    }
}
