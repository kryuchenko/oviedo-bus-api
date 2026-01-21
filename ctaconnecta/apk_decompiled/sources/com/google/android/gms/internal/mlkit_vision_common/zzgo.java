package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgo extends zzgu {
    private final /* synthetic */ zzgn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzgo(zzgn zzgnVar) {
        super(zzgnVar, null);
        this.zza = zzgnVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgu, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzgp(this.zza, null);
    }

    /* synthetic */ zzgo(zzgn zzgnVar, zzgm zzgmVar) {
        this(zzgnVar);
    }
}
