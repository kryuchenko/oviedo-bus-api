package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbuc {
    private final zzbuc[] zza;
    private final int zzb;
    private final int zzc;

    zzbuc() {
        this.zza = new zzbuc[256];
        this.zzb = 0;
        this.zzc = 0;
    }

    zzbuc(int i, int i2) {
        this.zza = null;
        this.zzb = i;
        int i3 = i2 & 7;
        this.zzc = i3 == 0 ? 8 : i3;
    }
}
