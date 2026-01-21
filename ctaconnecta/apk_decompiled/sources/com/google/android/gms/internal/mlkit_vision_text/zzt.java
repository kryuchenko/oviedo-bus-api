package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzt<K, V> implements zzax<K, V> {

    @NullableDecl
    private transient Set<K> zza;

    @NullableDecl
    private transient Map<K, Collection<V>> zzb;

    zzt() {
    }

    abstract Set<K> zzd();

    abstract Map<K, Collection<V>> zze();

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzax
    public boolean zza(@NullableDecl K k, @NullableDecl V v) {
        return zzb(k).add(v);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzax
    public Set<K> zzh() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> setZzd = zzd();
        this.zza = setZzd;
        return setZzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzax
    public Map<K, Collection<V>> zzg() {
        Map<K, Collection<V>> map = this.zzb;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapZze = zze();
        this.zzb = mapZze;
        return mapZze;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzax) {
            return zzg().equals(((zzax) obj).zzg());
        }
        return false;
    }

    public int hashCode() {
        return zzg().hashCode();
    }

    public String toString() {
        return zzg().toString();
    }
}
