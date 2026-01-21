package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzjt;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.internal.zznx;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class SearchNearbyRequest implements zzjt {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public SearchNearbyRequest build() {
            List<Place.Field> placeFields = getPlaceFields();
            boolean z = getLocationRestriction() instanceof CircularBounds;
            List<String> includedTypes = getIncludedTypes();
            List<String> excludedTypes = getExcludedTypes();
            List<String> includedPrimaryTypes = getIncludedPrimaryTypes();
            List<String> excludedPrimaryTypes = getExcludedPrimaryTypes();
            zzmt.zzf(z, "LocationRestriction must be of type CircularBounds.");
            setPlaceFields(zznx.zzj(placeFields));
            if (includedTypes != null) {
                setIncludedTypes(zznx.zzj(includedTypes));
            }
            if (excludedTypes != null) {
                setExcludedTypes(zznx.zzj(excludedTypes));
            }
            if (includedPrimaryTypes != null) {
                setIncludedPrimaryTypes(zznx.zzj(includedPrimaryTypes));
            }
            if (excludedPrimaryTypes != null) {
                setExcludedPrimaryTypes(zznx.zzj(excludedPrimaryTypes));
            }
            return zza();
        }

        public abstract CancellationToken getCancellationToken();

        public abstract List<String> getExcludedPrimaryTypes();

        public abstract List<String> getExcludedTypes();

        public abstract List<String> getIncludedPrimaryTypes();

        public abstract List<String> getIncludedTypes();

        public abstract LocationRestriction getLocationRestriction();

        public abstract Integer getMaxResultCount();

        public abstract List<Place.Field> getPlaceFields();

        public abstract RankPreference getRankPreference();

        public abstract String getRegionCode();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setExcludedPrimaryTypes(List<String> list);

        public abstract Builder setExcludedTypes(List<String> list);

        public abstract Builder setIncludedPrimaryTypes(List<String> list);

        public abstract Builder setIncludedTypes(List<String> list);

        public abstract Builder setLocationRestriction(LocationRestriction locationRestriction);

        public abstract Builder setMaxResultCount(Integer num);

        public abstract Builder setPlaceFields(List<Place.Field> list);

        public abstract Builder setRankPreference(RankPreference rankPreference);

        public abstract Builder setRegionCode(String str);

        abstract SearchNearbyRequest zza();
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public enum RankPreference {
        DISTANCE,
        POPULARITY
    }

    public static Builder builder(LocationRestriction locationRestriction, List<Place.Field> list) {
        zzac zzacVar = new zzac();
        zzacVar.setLocationRestriction(locationRestriction);
        zzacVar.setPlaceFields(list);
        return zzacVar;
    }

    public static SearchNearbyRequest newInstance(LocationRestriction locationRestriction, List<Place.Field> list) {
        return builder(locationRestriction, list).build();
    }

    @Override // com.google.android.libraries.places.internal.zzjt
    public abstract CancellationToken getCancellationToken();

    public abstract List<String> getExcludedPrimaryTypes();

    public abstract List<String> getExcludedTypes();

    public abstract List<String> getIncludedPrimaryTypes();

    public abstract List<String> getIncludedTypes();

    public abstract LocationRestriction getLocationRestriction();

    public abstract Integer getMaxResultCount();

    public abstract List<Place.Field> getPlaceFields();

    public abstract RankPreference getRankPreference();

    public abstract String getRegionCode();
}
