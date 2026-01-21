package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzjt;
import com.google.android.libraries.places.internal.zznx;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class FindCurrentPlaceRequest implements zzjt {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public FindCurrentPlaceRequest build() {
            zza(zznx.zzj(zzb().getPlaceFields()));
            return zzb();
        }

        public abstract CancellationToken getCancellationToken();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        abstract Builder zza(List list);

        abstract FindCurrentPlaceRequest zzb();
    }

    public static Builder builder(List<Place.Field> list) {
        zzq zzqVar = new zzq();
        zzqVar.zza(list);
        return zzqVar;
    }

    public static FindCurrentPlaceRequest newInstance(List<Place.Field> list) {
        return builder(list).build();
    }

    @Override // com.google.android.libraries.places.internal.zzjt
    public abstract CancellationToken getCancellationToken();

    public abstract List<Place.Field> getPlaceFields();
}
