package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzis {
    private static final zzis zzaac = new zzis();
    private final ConcurrentMap<Class<?>, zziw<?>> zzaae = new ConcurrentHashMap();
    private final zziz zzaad = new zzhu();

    public static zzis zzhp() {
        return zzaac;
    }

    public final <T> zziw<T> zzf(Class<T> cls) {
        zzgy.zza(cls, "messageType");
        zziw<T> zziwVarZze = (zziw) this.zzaae.get(cls);
        if (zziwVarZze == null) {
            zziwVarZze = this.zzaad.zze(cls);
            zzgy.zza(cls, "messageType");
            zzgy.zza(zziwVarZze, "schema");
            zziw<T> zziwVar = (zziw) this.zzaae.putIfAbsent(cls, zziwVarZze);
            if (zziwVar != null) {
                return zziwVar;
            }
        }
        return zziwVarZze;
    }

    public final <T> zziw<T> zzv(T t) {
        return zzf(t.getClass());
    }

    private zzis() {
    }
}
