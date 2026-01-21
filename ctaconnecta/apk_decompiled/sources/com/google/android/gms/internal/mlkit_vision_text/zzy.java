package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzy<K, V> extends zzad<Map.Entry<K, V>> {
    private final /* synthetic */ zzw zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzw zzwVar) {
        super(zzwVar, null);
        this.zza = zzwVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzad
    final /* synthetic */ Object zza(int i) {
        return new zzaf(this.zza, i);
    }
}
