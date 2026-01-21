package com.google.android.gms.internal.drive;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class zzmd {
    private static final zzmd zzuw = new zzmd();
    private final ConcurrentMap<Class<?>, zzmf<?>> zzuy = new ConcurrentHashMap();
    private final zzmg zzux = new zzlf();

    public static zzmd zzej() {
        return zzuw;
    }

    public final <T> zzmf<T> zzf(Class<T> cls) {
        zzkm.zza(cls, "messageType");
        zzmf<T> zzmfVarZze = (zzmf) this.zzuy.get(cls);
        if (zzmfVarZze == null) {
            zzmfVarZze = this.zzux.zze(cls);
            zzkm.zza(cls, "messageType");
            zzkm.zza(zzmfVarZze, "schema");
            zzmf<T> zzmfVar = (zzmf) this.zzuy.putIfAbsent(cls, zzmfVarZze);
            if (zzmfVar != null) {
                return zzmfVar;
            }
        }
        return zzmfVarZze;
    }

    public final <T> zzmf<T> zzq(T t) {
        return zzf(t.getClass());
    }

    private zzmd() {
    }
}
