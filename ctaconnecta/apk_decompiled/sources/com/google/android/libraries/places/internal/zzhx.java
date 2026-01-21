package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzhx extends zzik {
    zzhx(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, boolean z, zzki zzkiVar) {
        super(fetchPlaceRequest, locale, str, false, zzkiVar);
    }

    @Override // com.google.android.libraries.places.internal.zzik
    protected final String zze() {
        return "details/json";
    }

    @Override // com.google.android.libraries.places.internal.zzik
    public final Map zzf() {
        FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) zzb();
        HashMap map = new HashMap();
        zzg(map, "placeid", fetchPlaceRequest.getPlaceId(), null);
        zzg(map, "sessiontoken", fetchPlaceRequest.getSessionToken(), null);
        zzg(map, "fields", zzjd.zza(fetchPlaceRequest.getPlaceFields()), null);
        return map;
    }
}
