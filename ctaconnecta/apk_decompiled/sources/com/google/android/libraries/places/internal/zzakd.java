package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzakd {

    @CheckForNull
    private String zza = null;

    @CheckForNull
    private Boolean zzb = null;

    public final zzakd zza(boolean z) {
        this.zzb = true;
        return this;
    }

    public final zzakd zzb(String str) {
        String.format(Locale.ROOT, str, 0);
        this.zza = str;
        return this;
    }

    public final ThreadFactory zzc() {
        String str = this.zza;
        return new zzakc(Executors.defaultThreadFactory(), str, str != null ? new AtomicLong(0L) : null, this.zzb, null, null);
    }
}
