package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzez extends JsonObjectRequest {
    final /* synthetic */ Map zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzez(zzfa zzfaVar, int i, String str, JSONObject jSONObject, Response.Listener listener, Response.ErrorListener errorListener, Map map) {
        super(0, str, null, listener, errorListener);
        this.zza = map;
    }

    @Override // com.android.volley.Request
    public final Map getHeaders() {
        return this.zza;
    }
}
