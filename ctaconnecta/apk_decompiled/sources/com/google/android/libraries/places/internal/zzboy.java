package com.google.android.libraries.places.internal;

import java.util.concurrent.Future;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzboy {
    final Object zza;
    Future zzb;
    boolean zzc;

    zzboy(Object obj) {
        this.zza = obj;
    }

    @CheckForNull
    final Future zza() {
        this.zzc = true;
        return this.zzb;
    }

    final void zzb(Future future) {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
            if (!z) {
                this.zzb = future;
            }
        }
        if (z) {
            future.cancel(false);
        }
    }
}
