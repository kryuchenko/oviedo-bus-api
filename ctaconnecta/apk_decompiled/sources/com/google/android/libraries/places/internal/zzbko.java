package com.google.android.libraries.places.internal;

import java.lang.Thread;
import java.util.logging.Level;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbko implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzbma zza;

    zzbko(zzbma zzbmaVar) {
        this.zza = zzbmaVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzbma zzbmaVar = this.zza;
        zzbma.zza.logp(Level.SEVERE, "io.grpc.internal.ManagedChannelImpl$2", "uncaughtException", "[" + String.valueOf(zzbmaVar.zzc()) + "] Uncaught exception in the SynchronizationContext. Panic!", th);
        this.zza.zzW(th);
    }
}
