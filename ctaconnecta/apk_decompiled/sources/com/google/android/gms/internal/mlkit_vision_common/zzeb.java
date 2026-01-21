package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzeb {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzeb zzc;
    private static final zzeb zzd = new zzeb(true);
    private final Map<Object, Object> zze;

    public static zzeb zza() {
        zzeb zzebVar;
        zzeb zzebVar2 = zzc;
        if (zzebVar2 != null) {
            return zzebVar2;
        }
        synchronized (zzeb.class) {
            zzebVar = zzc;
            if (zzebVar == null) {
                zzebVar = zzd;
                zzc = zzebVar;
            }
        }
        return zzebVar;
    }

    zzeb() {
        this.zze = new HashMap();
    }

    private zzeb(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }
}
