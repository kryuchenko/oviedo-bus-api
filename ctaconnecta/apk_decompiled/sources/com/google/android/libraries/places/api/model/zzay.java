package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzay extends zzl {
    public static final Parcelable.Creator<zzay> CREATOR = new zzax();

    zzay(LatLng latLng, double d) {
        super(latLng, d);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getCenter(), i);
        parcel.writeDouble(getRadius());
    }
}
