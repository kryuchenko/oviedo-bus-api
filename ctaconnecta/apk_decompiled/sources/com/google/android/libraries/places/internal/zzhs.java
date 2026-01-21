package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzhs {
    private Bitmap zza;

    public final zzhu zza() {
        zzmt.zzp(this.zza != null, "Photo must be set to non-null value.");
        return new zzhu(this.zza, null);
    }

    public final zzhs zzb(Bitmap bitmap) {
        this.zza = bitmap;
        return this;
    }
}
