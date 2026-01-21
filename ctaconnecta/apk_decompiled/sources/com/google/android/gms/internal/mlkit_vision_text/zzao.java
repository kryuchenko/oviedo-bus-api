package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzao {
    static <V> V zza(Map<?, V> map, @NullableDecl Object obj) {
        zzd.zza(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean zzb(Map<?, ?> map, Object obj) {
        zzd.zza(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V zzc(Map<?, V> map, Object obj) {
        zzd.zza(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }
}
