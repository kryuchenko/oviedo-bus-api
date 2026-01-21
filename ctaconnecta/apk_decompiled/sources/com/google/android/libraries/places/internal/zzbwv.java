package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InterruptedIOException;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class zzbwv {
    public static final zzbwu zzb = new zzbwu(null);
    public static final zzbwv zzc = new zzbwt();

    public static final void zzb() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
    }
}
