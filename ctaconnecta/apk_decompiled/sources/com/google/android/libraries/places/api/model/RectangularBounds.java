package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class RectangularBounds implements LocationBias, LocationRestriction {
    public static RectangularBounds newInstance(LatLng latLng, LatLng latLng2) {
        return newInstance(new LatLngBounds(latLng, latLng2));
    }

    public abstract LatLng getNortheast();

    public abstract LatLng getSouthwest();

    public static RectangularBounds newInstance(LatLngBounds latLngBounds) {
        zzab zzabVar = new zzab();
        zzabVar.zzb(latLngBounds.southwest);
        zzabVar.zza(latLngBounds.northeast);
        return zzabVar.zzc();
    }
}
