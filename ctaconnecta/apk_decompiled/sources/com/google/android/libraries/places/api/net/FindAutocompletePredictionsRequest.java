package com.google.android.libraries.places.api.net;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzjt;
import com.google.android.libraries.places.internal.zznx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class FindAutocompletePredictionsRequest implements zzjt {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public FindAutocompletePredictionsRequest build() {
            setCountries(zznx.zzj(getCountries()));
            setTypesFilter(zznx.zzj(getTypesFilter()));
            return zza();
        }

        public abstract CancellationToken getCancellationToken();

        public abstract List<String> getCountries();

        public abstract Integer getInputOffset();

        public abstract LocationBias getLocationBias();

        public abstract LocationRestriction getLocationRestriction();

        public abstract LatLng getOrigin();

        public abstract String getQuery();

        public abstract String getRegionCode();

        public abstract AutocompleteSessionToken getSessionToken();

        @Deprecated
        public abstract TypeFilter getTypeFilter();

        public abstract List<String> getTypesFilter();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setCountries(List<String> list);

        public Builder setCountries(String... strArr) {
            return setCountries(zznx.zzk(strArr));
        }

        @Deprecated
        public Builder setCountry(String str) {
            setCountries(str == null ? zznx.zzl() : zznx.zzm(str));
            return this;
        }

        public abstract Builder setInputOffset(Integer num);

        public abstract Builder setLocationBias(LocationBias locationBias);

        public abstract Builder setLocationRestriction(LocationRestriction locationRestriction);

        public abstract Builder setOrigin(LatLng latLng);

        public abstract Builder setQuery(String str);

        public abstract Builder setRegionCode(String str);

        public abstract Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken);

        @Deprecated
        public abstract Builder setTypeFilter(TypeFilter typeFilter);

        public abstract Builder setTypesFilter(List<String> list);

        abstract FindAutocompletePredictionsRequest zza();
    }

    public static Builder builder() {
        zzm zzmVar = new zzm();
        zzmVar.setCountries(new ArrayList());
        zzmVar.setTypesFilter(new ArrayList());
        return zzmVar;
    }

    public static FindAutocompletePredictionsRequest newInstance(String str) {
        Builder builder = builder();
        builder.setQuery(str);
        return builder.build();
    }

    @Override // com.google.android.libraries.places.internal.zzjt
    public abstract CancellationToken getCancellationToken();

    public abstract List<String> getCountries();

    @Deprecated
    public String getCountry() {
        if (getCountries().size() > 1) {
            throw new UnsupportedOperationException("Multiple countries found in this request - use getCountries() instead of getCountry().");
        }
        Iterator<T> it = getCountries().iterator();
        return (String) (it.hasNext() ? it.next() : null);
    }

    public abstract Integer getInputOffset();

    public abstract LocationBias getLocationBias();

    public abstract LocationRestriction getLocationRestriction();

    public abstract LatLng getOrigin();

    public abstract String getQuery();

    public abstract String getRegionCode();

    public abstract AutocompleteSessionToken getSessionToken();

    @Deprecated
    public abstract TypeFilter getTypeFilter();

    public abstract List<String> getTypesFilter();
}
