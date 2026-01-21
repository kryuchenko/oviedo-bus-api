package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzib<K, V> extends LinkedHashMap<K, V> {
    private static final zzib zzze;
    private boolean zzry;

    private zzib() {
        this.zzry = true;
    }

    private zzib(Map<K, V> map) {
        super(map);
        this.zzry = true;
    }

    public static <K, V> zzib<K, V> zzhd() {
        return zzze;
    }

    public final void zza(zzib<K, V> zzibVar) {
        zzhf();
        if (zzibVar.isEmpty()) {
            return;
        }
        putAll(zzibVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzhf();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzhf();
        zzgy.checkNotNull(k);
        zzgy.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzhf();
        for (K k : map.keySet()) {
            zzgy.checkNotNull(k);
            zzgy.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzhf();
        return (V) super.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                zEquals = Arrays.equals((byte[]) value, (byte[]) obj2);
            } else {
                zEquals = value.equals(obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    private static int zzr(Object obj) {
        if (obj instanceof byte[]) {
            return zzgy.hashCode((byte[]) obj);
        }
        if (obj instanceof zzhb) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzr = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iZzr += zzr(entry.getValue()) ^ zzr(entry.getKey());
        }
        return iZzr;
    }

    public final zzib<K, V> zzhe() {
        return isEmpty() ? new zzib<>() : new zzib<>(this);
    }

    public final void zzdq() {
        this.zzry = false;
    }

    public final boolean isMutable() {
        return this.zzry;
    }

    private final void zzhf() {
        if (!this.zzry) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzib zzibVar = new zzib();
        zzze = zzibVar;
        zzibVar.zzry = false;
    }
}
