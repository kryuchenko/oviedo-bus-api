package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzl<K, V> extends zzas<K, Collection<V>> {
    final /* synthetic */ zzh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzl(zzh zzhVar, Map<K, Collection<V>> map) {
        super(map);
        this.zza = zzhVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzas, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return new zzk(this, this.zzb.entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzas, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int size;
        Collection collection = (Collection) this.zzb.remove(obj);
        if (collection != null) {
            size = collection.size();
            collection.clear();
            zzh.zzb(this.zza, size);
        } else {
            size = 0;
        }
        return size > 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzas, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        zzam.zza(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        return this.zzb.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zzb.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zzb.keySet().hashCode();
    }
}
