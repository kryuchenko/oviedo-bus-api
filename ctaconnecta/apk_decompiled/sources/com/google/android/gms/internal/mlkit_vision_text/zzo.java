package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
class zzo<V> extends zzm implements List<V> {
    final /* synthetic */ zzh zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzo(@NullableDecl zzh zzhVar, K k, @NullableDecl List<V> list, zzm zzmVar) {
        super(zzhVar, k, list, zzmVar);
        this.zzd = zzhVar;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i, collection);
        if (zAddAll) {
            zzh.zza(this.zzd, this.zzb.size() - size);
            if (size == 0) {
                zzc();
            }
        }
        return zAddAll;
    }

    @Override // java.util.List
    public V get(int i) {
        zza();
        return (V) ((List) this.zzb).get(i);
    }

    @Override // java.util.List
    public V set(int i, V v) {
        zza();
        return (V) ((List) this.zzb).set(i, v);
    }

    @Override // java.util.List
    public void add(int i, V v) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, v);
        zzh.zzc(this.zzd);
        if (zIsEmpty) {
            zzc();
        }
    }

    @Override // java.util.List
    public V remove(int i) {
        zza();
        V v = (V) ((List) this.zzb).remove(i);
        zzh.zzb(this.zzd);
        zzb();
        return v;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<V> listIterator() {
        zza();
        return new zzr(this);
    }

    @Override // java.util.List
    public ListIterator<V> listIterator(int i) {
        zza();
        return new zzr(this, i);
    }

    @Override // java.util.List
    public List<V> subList(int i, int i2) {
        zza();
        return this.zzd.zza(this.zza, ((List) this.zzb).subList(i, i2), this.zzc == null ? this : this.zzc);
    }
}
