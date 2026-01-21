package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzkz extends zzle {
    private final CancellationTokenSource zza;
    private final String zzb;

    zzkz(CancellationTokenSource cancellationTokenSource, String str) {
        this.zza = cancellationTokenSource;
        if (str == null) {
            throw new NullPointerException("Null placeId");
        }
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzle) {
            zzle zzleVar = (zzle) obj;
            if (this.zza.equals(zzleVar.zza()) && this.zzb.equals(zzleVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        return "PlaceRequest{source=" + this.zza.toString() + ", placeId=" + this.zzb + "}";
    }

    @Override // com.google.android.libraries.places.internal.zzlg
    public final CancellationTokenSource zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzle
    public final String zzb() {
        return this.zzb;
    }
}
