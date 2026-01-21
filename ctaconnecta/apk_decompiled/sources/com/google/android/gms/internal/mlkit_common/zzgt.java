package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgt {
    private static final zzgt zza = new zzgt();
    private final ConcurrentMap<Class<?>, zzgy<?>> zzc = new ConcurrentHashMap();
    private final zzgx zzb = new zzfy();

    public static zzgt zza() {
        return zza;
    }

    public final <T> zzgy<T> zza(Class<T> cls) {
        zzfc.zza(cls, "messageType");
        zzgy<T> zzgyVarZza = (zzgy) this.zzc.get(cls);
        if (zzgyVarZza == null) {
            zzgyVarZza = this.zzb.zza(cls);
            zzfc.zza(cls, "messageType");
            zzfc.zza(zzgyVarZza, "schema");
            zzgy<T> zzgyVar = (zzgy) this.zzc.putIfAbsent(cls, zzgyVarZza);
            if (zzgyVar != null) {
                return zzgyVar;
            }
        }
        return zzgyVarZza;
    }

    public final <T> zzgy<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzgt() {
    }
}
