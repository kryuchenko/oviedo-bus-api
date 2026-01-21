package com.google.android.gms.internal.mlkit_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzen {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzen zzc;
    private static final zzen zzd = new zzen(true);
    private final Map<Object, Object> zze;

    public static zzen zza() {
        zzen zzenVar;
        zzen zzenVar2 = zzc;
        if (zzenVar2 != null) {
            return zzenVar2;
        }
        synchronized (zzen.class) {
            zzenVar = zzc;
            if (zzenVar == null) {
                zzenVar = zzd;
                zzc = zzenVar;
            }
        }
        return zzenVar;
    }

    zzen() {
        this.zze = new HashMap();
    }

    private zzen(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }
}
