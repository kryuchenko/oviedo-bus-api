package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzid extends zzij {
    private final /* synthetic */ zzhy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzid(zzhy zzhyVar) {
        super(zzhyVar, null);
        this.zza = zzhyVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzij, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzia(this.zza, null);
    }

    /* synthetic */ zzid(zzhy zzhyVar, zzib zzibVar) {
        this(zzhyVar);
    }
}
