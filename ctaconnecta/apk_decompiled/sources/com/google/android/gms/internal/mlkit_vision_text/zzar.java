package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzar<K, V> extends zzba<Map.Entry<K, V>, K> {
    zzar(Iterator it) {
        super(it);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzba
    final /* synthetic */ Object zza(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}
