package com.google.mlkit.common.sdkinternal.model;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class URLWrapper {
    private final URL zza;

    public URLWrapper(String str) throws MalformedURLException {
        this.zza = new URL(str);
    }

    public URLConnection openConnection() throws IOException {
        return (URLConnection) FirebasePerfUrlConnection.instrument(this.zza.openConnection());
    }
}
