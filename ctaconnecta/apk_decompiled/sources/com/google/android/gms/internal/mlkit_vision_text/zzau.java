package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzau<K, V> extends AbstractMap<K, V> {

    @NullableDecl
    private transient Set<Map.Entry<K, V>> zza;

    @NullableDecl
    private transient Set<K> zzb;

    @NullableDecl
    private transient Collection<V> zzc;

    zzau() {
    }

    abstract Set<Map.Entry<K, V>> zza();

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setZza = zza();
        this.zza = setZza;
        return setZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.zzb;
        if (set != null) {
            return set;
        }
        zzas zzasVar = new zzas(this);
        this.zzb = zzasVar;
        return zzasVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzav zzavVar = new zzav(this);
        this.zzc = zzavVar;
        return zzavVar;
    }
}
