package com.google.android.gms.internal.mlkit_vision_text;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhs {
    private static final zzhs zza = new zzhs();
    private final ConcurrentMap<Class<?>, zzhx<?>> zzc = new ConcurrentHashMap();
    private final zzhw zzb = new zzgx();

    public static zzhs zza() {
        return zza;
    }

    public final <T> zzhx<T> zza(Class<T> cls) {
        zzgb.zza(cls, "messageType");
        zzhx<T> zzhxVarZza = (zzhx) this.zzc.get(cls);
        if (zzhxVarZza == null) {
            zzhxVarZza = this.zzb.zza(cls);
            zzgb.zza(cls, "messageType");
            zzgb.zza(zzhxVarZza, "schema");
            zzhx<T> zzhxVar = (zzhx) this.zzc.putIfAbsent(cls, zzhxVarZza);
            if (zzhxVar != null) {
                return zzhxVar;
            }
        }
        return zzhxVarZza;
    }

    public final <T> zzhx<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzhs() {
    }
}
