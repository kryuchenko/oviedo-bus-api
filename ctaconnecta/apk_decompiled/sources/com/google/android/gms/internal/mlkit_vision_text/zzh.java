package com.google.android.gms.internal.mlkit_vision_text;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzh<K, V> extends zzt<K, V> implements Serializable {
    private transient Map<K, Collection<V>> zza;
    private transient int zzb;

    protected zzh(Map<K, Collection<V>> map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.zza = map;
    }

    abstract Collection<V> zzb();

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt, com.google.android.gms.internal.mlkit_vision_text.zzax
    public boolean zza(@NullableDecl K k, @NullableDecl V v) {
        Collection<V> collection = this.zza.get(k);
        if (collection == null) {
            Collection<V> collectionZzb = zzb();
            if (collectionZzb.add(v)) {
                this.zzb++;
                this.zza.put(k, collectionZzb);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (!collection.add(v)) {
            return false;
        }
        this.zzb++;
        return true;
    }

    public void zzc() {
        Iterator<Collection<V>> it = this.zza.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzax
    public Collection<V> zzb(@NullableDecl K k) {
        Collection<V> collectionZzb = this.zza.get(k);
        if (collectionZzb == null) {
            collectionZzb = zzb();
        }
        return zza((zzh<K, V>) k, (Collection) collectionZzb);
    }

    Collection<V> zza(@NullableDecl K k, Collection<V> collection) {
        return new zzm(this, k, collection, null);
    }

    final List<V> zza(@NullableDecl K k, List<V> list, @NullableDecl zzm zzmVar) {
        if (list instanceof RandomAccess) {
            return new zzn(this, k, list, zzmVar);
        }
        return new zzo(this, k, list, zzmVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> zzb(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt
    final Set<K> zzd() {
        return new zzl(this, this.zza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(Object obj) {
        Collection collection = (Collection) zzao.zzc(this.zza, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.zzb -= size;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt
    final Map<K, Collection<V>> zze() {
        return new zzg(this, this.zza);
    }

    static /* synthetic */ int zzb(zzh zzhVar) {
        int i = zzhVar.zzb;
        zzhVar.zzb = i - 1;
        return i;
    }

    static /* synthetic */ int zzc(zzh zzhVar) {
        int i = zzhVar.zzb;
        zzhVar.zzb = i + 1;
        return i;
    }

    static /* synthetic */ int zza(zzh zzhVar, int i) {
        int i2 = zzhVar.zzb + i;
        zzhVar.zzb = i2;
        return i2;
    }

    static /* synthetic */ int zzb(zzh zzhVar, int i) {
        int i2 = zzhVar.zzb - i;
        zzhVar.zzb = i2;
        return i2;
    }
}
