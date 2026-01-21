package com.google.android.libraries.places.internal;

import java.lang.Thread;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbof implements Thread.UncaughtExceptionHandler {
    zzbof(zzbpo zzbpoVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        throw new zzbdq(zzbdo.zze(th).zzg("Uncaught exception in the SynchronizationContext. Re-thrown."), null);
    }
}
