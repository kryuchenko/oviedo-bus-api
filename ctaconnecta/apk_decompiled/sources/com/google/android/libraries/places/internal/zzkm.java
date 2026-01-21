package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzkm extends zzkk {
    public static final Parcelable.Creator<zzkm> CREATOR = new zzkl();

    zzkm(AutocompleteActivityMode autocompleteActivityMode, zznx zznxVar, zzkr zzkrVar, String str, String str2, LocationBias locationBias, LocationRestriction locationRestriction, zznx zznxVar2, TypeFilter typeFilter, zznx zznxVar3, int i, int i2, String str3) {
        super(autocompleteActivityMode, zznxVar, zzkrVar, str, str2, locationBias, locationRestriction, zznxVar2, typeFilter, zznxVar3, i, i2, str3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(zzh(), i);
        parcel.writeList(zzj());
        parcel.writeParcelable(zzf(), i);
        if (zzm() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(zzm());
        }
        if (zzl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(zzl());
        }
        parcel.writeParcelable(zzc(), i);
        parcel.writeParcelable(zzd(), i);
        parcel.writeList(zzi());
        parcel.writeParcelable(zze(), i);
        parcel.writeList(zzk());
        parcel.writeInt(zza());
        parcel.writeInt(zzb());
        if (zzn() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(zzn());
        }
    }
}
