package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzjt;
import com.google.android.libraries.places.internal.zzmt;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class IsOpenRequest implements zzjt {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public IsOpenRequest build() {
            IsOpenRequest isOpenRequestZza = zza();
            Place place = isOpenRequestZza.getPlace();
            if (place != null) {
                zzmt.zzf(place.getId() != null, "Place must have a valid place id.");
            }
            return isOpenRequestZza;
        }

        public abstract CancellationToken getCancellationToken();

        public abstract Place getPlace();

        public abstract String getPlaceId();

        public abstract long getUtcTimeMillis();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setPlace(Place place);

        public abstract Builder setPlaceId(String str);

        public abstract Builder setUtcTimeMillis(long j);

        abstract IsOpenRequest zza();
    }

    public static Builder builder(Place place) {
        zzu zzuVar = new zzu();
        zzuVar.setPlace(place);
        zzuVar.setUtcTimeMillis(System.currentTimeMillis());
        return zzuVar;
    }

    public static IsOpenRequest newInstance(Place place) {
        return builder(place).build();
    }

    @Override // com.google.android.libraries.places.internal.zzjt
    public abstract CancellationToken getCancellationToken();

    public abstract Place getPlace();

    public abstract String getPlaceId();

    public abstract long getUtcTimeMillis();

    public static IsOpenRequest newInstance(Place place, long j) {
        return builder(place, j).build();
    }

    public static Builder builder(Place place, long j) {
        zzu zzuVar = new zzu();
        zzuVar.setPlace(place);
        zzuVar.setUtcTimeMillis(j);
        return zzuVar;
    }

    public static IsOpenRequest newInstance(String str) {
        return builder(str).build();
    }

    public static Builder builder(String str) {
        zzu zzuVar = new zzu();
        zzuVar.setPlaceId(str);
        zzuVar.setUtcTimeMillis(System.currentTimeMillis());
        return zzuVar;
    }

    public static IsOpenRequest newInstance(String str, long j) {
        return builder(str, j).build();
    }

    public static Builder builder(String str, long j) {
        zzu zzuVar = new zzu();
        zzuVar.setPlaceId(str);
        zzuVar.setUtcTimeMillis(j);
        return zzuVar;
    }
}
