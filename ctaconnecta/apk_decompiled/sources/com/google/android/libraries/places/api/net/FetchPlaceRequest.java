package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzjt;
import com.google.android.libraries.places.internal.zznx;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class FetchPlaceRequest implements zzjt {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public FetchPlaceRequest build() {
            zza(zznx.zzj(zzc().getPlaceFields()));
            return zzc();
        }

        public abstract CancellationToken getCancellationToken();

        public abstract String getRegionCode();

        public abstract AutocompleteSessionToken getSessionToken();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setRegionCode(String str);

        public abstract Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken);

        abstract Builder zza(List list);

        abstract FetchPlaceRequest zzc();
    }

    public static Builder builder(String str, List<Place.Field> list) {
        zze zzeVar = new zze();
        zzeVar.zzb(str);
        zzeVar.zza(list);
        return zzeVar;
    }

    public static FetchPlaceRequest newInstance(String str, List<Place.Field> list) {
        return builder(str, list).build();
    }

    @Override // com.google.android.libraries.places.internal.zzjt
    public abstract CancellationToken getCancellationToken();

    public abstract List<Place.Field> getPlaceFields();

    public abstract String getPlaceId();

    public abstract String getRegionCode();

    public abstract AutocompleteSessionToken getSessionToken();
}
