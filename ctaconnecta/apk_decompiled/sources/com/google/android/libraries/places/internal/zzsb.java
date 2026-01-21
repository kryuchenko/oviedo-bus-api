package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzsb {
    public static final zzsb zza = new zzsb("about:invalid#zGuavaz");
    private final String zzb;

    zzsb(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzsb) {
            return this.zzb.equals(((zzsb) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ 18288376;
    }

    public final String toString() {
        return "SafeUrl{" + this.zzb + "}";
    }

    public final String zza() {
        return this.zzb;
    }
}
