package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zze<K, V> extends zzh<K, V> implements zzap<K, V> {
    protected zze(Map<K, Collection<V>> map) {
        super(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzh
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract List<V> zzb();

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzh
    final Collection<V> zza(K k, Collection<V> collection) {
        return zza(k, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzap
    public List<V> zza(@NullableDecl K k) {
        return (List) super.zzb((zze<K, V>) k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzh, com.google.android.gms.internal.mlkit_vision_text.zzax
    public /* synthetic */ Collection zzb(@NullableDecl Object obj) {
        return zza((zze<K, V>) obj);
    }
}
