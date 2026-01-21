package com.google.android.gms.internal.mlkit_vision_common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgh {
    private static final zzgh zza = new zzgh();
    private final ConcurrentMap<Class<?>, zzgi<?>> zzc = new ConcurrentHashMap();
    private final zzgl zzb = new zzfi();

    public static zzgh zza() {
        return zza;
    }

    public final <T> zzgi<T> zza(Class<T> cls) {
        zzem.zza(cls, "messageType");
        zzgi<T> zzgiVarZza = (zzgi) this.zzc.get(cls);
        if (zzgiVarZza == null) {
            zzgiVarZza = this.zzb.zza(cls);
            zzem.zza(cls, "messageType");
            zzem.zza(zzgiVarZza, "schema");
            zzgi<T> zzgiVar = (zzgi) this.zzc.putIfAbsent(cls, zzgiVarZza);
            if (zzgiVar != null) {
                return zzgiVar;
            }
        }
        return zzgiVarZza;
    }

    public final <T> zzgi<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzgh() {
    }
}
