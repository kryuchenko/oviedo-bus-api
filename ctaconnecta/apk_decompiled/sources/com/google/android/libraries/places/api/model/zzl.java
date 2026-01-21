package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
abstract class zzl extends CircularBounds {
    private final LatLng zza;
    private final double zzb;

    zzl(LatLng latLng, double d) {
        if (latLng == null) {
            throw new NullPointerException("Null center");
        }
        this.zza = latLng;
        this.zzb = d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CircularBounds) {
            CircularBounds circularBounds = (CircularBounds) obj;
            if (this.zza.equals(circularBounds.getCenter()) && Double.doubleToLongBits(this.zzb) == Double.doubleToLongBits(circularBounds.getRadius())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.CircularBounds
    public final LatLng getCenter() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.api.model.CircularBounds
    public final double getRadius() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.zzb) >>> 32) ^ Double.doubleToLongBits(this.zzb)));
    }

    public final String toString() {
        return "CircularBounds{center=" + this.zza.toString() + ", radius=" + this.zzb + "}";
    }
}
