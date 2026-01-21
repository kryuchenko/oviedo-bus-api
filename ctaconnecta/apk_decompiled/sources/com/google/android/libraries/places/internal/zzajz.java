package com.google.android.libraries.places.internal;

import java.util.logging.Logger;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzajz {
    private final String zza;
    private volatile Logger zzb;

    zzajz(Class cls) {
        this.zza = cls.getName();
    }

    final Logger zza() {
        Logger logger = this.zzb;
        if (logger != null) {
            return logger;
        }
        synchronized (this) {
            Logger logger2 = this.zzb;
            if (logger2 != null) {
                return logger2;
            }
            Logger logger3 = Logger.getLogger(this.zza);
            this.zzb = logger3;
            return logger3;
        }
    }
}
