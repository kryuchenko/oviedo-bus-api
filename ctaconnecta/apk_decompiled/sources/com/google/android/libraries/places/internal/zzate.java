package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzate {
    private final Object zza;
    private final int zzb;

    zzate(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzate)) {
            return false;
        }
        zzate zzateVar = (zzate) obj;
        return this.zza == zzateVar.zza && this.zzb == zzateVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
