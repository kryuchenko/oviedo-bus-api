package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzg<K, V> extends zzau<K, Collection<V>> {
    final transient Map<K, Collection<V>> zza;
    final /* synthetic */ zzh zzb;

    zzg(zzh zzhVar, Map<K, Collection<V>> map) {
        this.zzb = zzhVar;
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzau
    protected final Set<Map.Entry<K, Collection<V>>> zza() {
        return new zzj(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzao.zzb(this.zza, obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzau, java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        return this.zzb.zzh();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (this.zza == this.zzb.zza) {
            this.zzb.zzc();
        } else {
            zzam.zza(new zzi(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        Collection<V> collectionRemove = this.zza.remove(obj);
        if (collectionRemove == null) {
            return null;
        }
        Collection<V> collectionZzb = this.zzb.zzb();
        collectionZzb.addAll(collectionRemove);
        zzh.zzb(this.zzb, collectionRemove.size());
        collectionRemove.clear();
        return collectionZzb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object get(Object obj) {
        Collection<V> collection = (Collection) zzao.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zza((zzh) obj, (Collection) collection);
    }
}
