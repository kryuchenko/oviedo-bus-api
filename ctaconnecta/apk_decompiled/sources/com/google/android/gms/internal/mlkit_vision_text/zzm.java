package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
class zzm<V> extends AbstractCollection<V> {

    @NullableDecl
    final K zza;
    Collection<V> zzb;

    @NullableDecl
    final zzm zzc;
    final /* synthetic */ zzh zzd;

    @NullableDecl
    private final Collection<V> zze;

    zzm(@NullableDecl zzh zzhVar, K k, @NullableDecl Collection<V> collection, zzm zzmVar) {
        this.zzd = zzhVar;
        this.zza = k;
        this.zzb = collection;
        this.zzc = zzmVar;
        this.zze = zzmVar == null ? null : zzmVar.zzb;
    }

    final void zza() {
        Collection<V> collection;
        zzm zzmVar = this.zzc;
        if (zzmVar != null) {
            zzmVar.zza();
            if (this.zzc.zzb != this.zze) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.zzb.isEmpty() || (collection = (Collection) this.zzd.zza.get(this.zza)) == null) {
                return;
            }
            this.zzb = collection;
        }
    }

    final void zzb() {
        zzm<V> zzmVar = this;
        while (true) {
            zzm<V> zzmVar2 = zzmVar.zzc;
            if (zzmVar2 == null) {
                break;
            } else {
                zzmVar = zzmVar2;
            }
        }
        if (zzmVar.zzb.isEmpty()) {
            zzmVar.zzd.zza.remove(zzmVar.zza);
        }
    }

    final void zzc() {
        zzm<V> zzmVar = this;
        while (true) {
            zzm<V> zzmVar2 = zzmVar.zzc;
            if (zzmVar2 == null) {
                zzmVar.zzd.zza.put(zzmVar.zza, zzmVar.zzb);
                return;
            }
            zzmVar = zzmVar2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        zza();
        return this.zzb.size();
    }

    @Override // java.util.Collection
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        zza();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        zza();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        zza();
        return this.zzb.toString();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        zza();
        return new zzp(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        boolean zAdd = this.zzb.add(v);
        if (zAdd) {
            zzh.zzc(this.zzd);
            if (zIsEmpty) {
                zzc();
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.zzb.addAll(collection);
        if (zAddAll) {
            zzh.zza(this.zzd, this.zzb.size() - size);
            if (size == 0) {
                zzc();
            }
        }
        return zAddAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        zza();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        zza();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzh.zzb(this.zzd, size);
        zzb();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        zza();
        boolean zRemove = this.zzb.remove(obj);
        if (zRemove) {
            zzh.zzb(this.zzd);
            zzb();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.zzb.removeAll(collection);
        if (zRemoveAll) {
            zzh.zza(this.zzd, this.zzb.size() - size);
            zzb();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzd.zza(collection);
        int size = size();
        boolean zRetainAll = this.zzb.retainAll(collection);
        if (zRetainAll) {
            zzh.zza(this.zzd, this.zzb.size() - size);
            zzb();
        }
        return zRetainAll;
    }
}
