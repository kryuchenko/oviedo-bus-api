package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbqs implements zzbqt {
    zzbqs() {
    }

    @Override // com.google.android.libraries.places.internal.zzbqt
    public final long zza() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }
}
