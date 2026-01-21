package com.google.android.libraries.places.api.model;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
abstract class zzj extends zzby {
    private final int zza;
    private final int zzb;

    zzj(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzby) {
            zzby zzbyVar = (zzby) obj;
            if (this.zza == zzbyVar.zzb() && this.zzb == zzbyVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        return "SubstringMatch{offset=" + this.zza + ", length=" + this.zzb + "}";
    }

    @Override // com.google.android.libraries.places.api.model.zzby
    final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.api.model.zzby
    final int zzb() {
        return this.zza;
    }
}
