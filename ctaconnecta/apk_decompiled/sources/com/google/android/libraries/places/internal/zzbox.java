package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbox {
    private final AtomicLong zza = new AtomicLong();

    zzbox() {
    }

    final long zza(long j) {
        return this.zza.addAndGet(j);
    }
}
