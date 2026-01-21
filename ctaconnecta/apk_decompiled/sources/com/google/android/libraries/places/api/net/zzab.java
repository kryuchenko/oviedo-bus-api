package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzab extends SearchByTextResponse {
    private final List zza;

    zzab(List list) {
        if (list == null) {
            throw new NullPointerException("Null places");
        }
        this.zza = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchByTextResponse) {
            return this.zza.equals(((SearchByTextResponse) obj).getPlaces());
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public final List<Place> getPlaces() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "SearchByTextResponse{places=" + this.zza.toString() + "}";
    }
}
