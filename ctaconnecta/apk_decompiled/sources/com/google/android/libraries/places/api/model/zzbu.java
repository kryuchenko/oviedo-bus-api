package com.google.android.libraries.places.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbu extends zzag {
    public static final Parcelable.Creator<zzbu> CREATOR = new zzbt();

    zzbu(LocalDate localDate, boolean z) {
        super(localDate, z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getDate(), i);
        parcel.writeInt(isExceptional() ? 1 : 0);
    }
}
