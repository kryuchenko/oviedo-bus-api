package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzcp extends zzcq {
    @Override // com.google.android.gms.internal.measurement.zzcq
    public final URLConnection zza(URL url, String str) throws IOException {
        return url.openConnection();
    }

    private zzcp() {
    }
}
