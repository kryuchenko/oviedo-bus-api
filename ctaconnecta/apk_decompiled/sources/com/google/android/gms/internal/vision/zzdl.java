package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzdl<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzmb = new Map.Entry[0];
    private transient zzdo<Map.Entry<K, V>> zzmc;
    private transient zzdo<K> zzmd;
    private transient zzdh<V> zzme;

    public static <K, V> zzdl<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        zzdf.zza(k, v);
        zzdf.zza(k2, v2);
        zzdf.zza(k3, v3);
        zzdf.zza(k4, v4);
        return zzdq.zza(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    abstract zzdo<Map.Entry<K, V>> zzcf();

    abstract zzdo<K> zzcg();

    abstract zzdh<V> zzch();

    zzdl() {
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdh) values()).contains(obj);
    }

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzdt.zza((zzdo) entrySet());
    }

    public String toString() {
        int size = size();
        if (size < 0) {
            StringBuilder sb = new StringBuilder(44);
            sb.append("size cannot be negative but was: ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(size << 3, 1073741824L));
        sb2.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdo<Map.Entry<K, V>> zzdoVar = this.zzmc;
        if (zzdoVar != null) {
            return zzdoVar;
        }
        zzdo<Map.Entry<K, V>> zzdoVarZzcf = zzcf();
        this.zzmc = zzdoVarZzcf;
        return zzdoVarZzcf;
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdh<V> zzdhVar = this.zzme;
        if (zzdhVar != null) {
            return zzdhVar;
        }
        zzdh<V> zzdhVarZzch = zzch();
        this.zzme = zzdhVarZzch;
        return zzdhVarZzch;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdo<K> zzdoVar = this.zzmd;
        if (zzdoVar != null) {
            return zzdoVar;
        }
        zzdo<K> zzdoVarZzcg = zzcg();
        this.zzmd = zzdoVarZzcg;
        return zzdoVarZzcg;
    }
}
