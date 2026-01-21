package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbep implements zzbkj {
    private final AtomicLong zza = new AtomicLong();

    zzbep() {
    }

    @Override // com.google.android.libraries.places.internal.zzbkj
    public final void zza(long j) {
        this.zza.getAndAdd(1L);
    }
}
