package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zznx;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class SearchByTextResponse {
    public static SearchByTextResponse newInstance(List<Place> list) {
        return new zzab(zznx.zzj(list));
    }

    public abstract List<Place> getPlaces();
}
