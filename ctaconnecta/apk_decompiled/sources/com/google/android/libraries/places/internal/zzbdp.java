package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbdp extends Exception {
    private final zzbdo zza;

    public zzbdp(zzbdo zzbdoVar, @Nullable zzbcf zzbcfVar) {
        super(zzbdo.zzh(zzbdoVar), zzbdoVar.zzj(), true, true);
        this.zza = zzbdoVar;
    }

    public final zzbdo zza() {
        return this.zza;
    }
}
