package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class zzfm {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzfm zzc;
    private static final zzfm zzd = new zzfm(true);
    private final Map<Object, Object> zze;

    public static zzfm zza() {
        zzfm zzfmVar;
        zzfm zzfmVar2 = zzc;
        if (zzfmVar2 != null) {
            return zzfmVar2;
        }
        synchronized (zzfm.class) {
            zzfmVar = zzc;
            if (zzfmVar == null) {
                zzfmVar = zzd;
                zzc = zzfmVar;
            }
        }
        return zzfmVar;
    }

    zzfm() {
        this.zze = new HashMap();
    }

    private zzfm(boolean z) {
        this.zze = Collections.EMPTY_MAP;
    }
}
