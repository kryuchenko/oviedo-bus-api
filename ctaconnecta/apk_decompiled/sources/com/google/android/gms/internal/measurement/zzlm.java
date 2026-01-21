package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes3.dex */
class zzlm<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<zzls> zza;
    private Map<K, V> zzb;
    private boolean zzc;
    private volatile zzlx zzd;
    private Map<K, V> zze;
    private volatile zzlq zzf;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(K k) {
        int i;
        int i2;
        int size = this.zza.size();
        int i3 = size - 1;
        if (i3 < 0) {
            i = 0;
            while (i <= i3) {
                int i4 = (i + i3) / 2;
                int iCompareTo = k.compareTo((Comparable) this.zza.get(i4).getKey());
                if (iCompareTo < 0) {
                    i3 = i4 - 1;
                } else {
                    if (iCompareTo <= 0) {
                        return i4;
                    }
                    i = i4 + 1;
                }
            }
            i2 = i + 1;
        } else {
            int iCompareTo2 = k.compareTo((Comparable) this.zza.get(i3).getKey());
            if (iCompareTo2 > 0) {
                i2 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i3;
                }
                i = 0;
                while (i <= i3) {
                }
                i2 = i + 1;
            }
        }
        return -i2;
    }

    public final int zza() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZza = zza();
        int iHashCode = 0;
        for (int i = 0; i < iZza; i++) {
            iHashCode += this.zza.get(i).hashCode();
        }
        return this.zzb.size() > 0 ? iHashCode + this.zzb.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zza.size() + this.zzb.size();
    }

    public final Iterable<Map.Entry<K, V>> zzb() {
        if (this.zzb.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.zzb.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza((zzlm<K, V>) comparable);
        if (iZza >= 0) {
            return (V) this.zza.get(iZza).getValue();
        }
        return this.zzb.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V zza(K k, V v) {
        zzg();
        int iZza = zza((zzlm<K, V>) k);
        if (iZza >= 0) {
            return (V) this.zza.get(iZza).setValue(v);
        }
        zzg();
        if (this.zza.isEmpty() && !(this.zza instanceof ArrayList)) {
            this.zza = new ArrayList(16);
        }
        int i = -(iZza + 1);
        if (i >= 16) {
            return zzf().put(k, v);
        }
        if (this.zza.size() == 16) {
            zzls zzlsVarRemove = this.zza.remove(15);
            zzf().put((Comparable) zzlsVarRemove.getKey(), zzlsVarRemove.getValue());
        }
        this.zza.add(i, new zzls(this, k, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzlm<K, V>) obj, (Comparable) obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int iZza = zza((zzlm<K, V>) comparable);
        if (iZza >= 0) {
            return zzb(iZza);
        }
        if (this.zzb.isEmpty()) {
            return null;
        }
        return this.zzb.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzb(int i) {
        zzg();
        V v = (V) this.zza.remove(i).getValue();
        if (!this.zzb.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zza.add(new zzls(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final Map.Entry<K, V> zza(int i) {
        return this.zza.get(i);
    }

    final Set<Map.Entry<K, V>> zzc() {
        if (this.zzf == null) {
            this.zzf = new zzlq(this);
        }
        return this.zzf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzd == null) {
            this.zzd = new zzlx(this);
        }
        return this.zzd;
    }

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzb = treeMap;
            this.zze = treeMap.descendingMap();
        }
        return (SortedMap) this.zzb;
    }

    private zzlm() {
        this.zza = Collections.EMPTY_LIST;
        this.zzb = Collections.EMPTY_MAP;
        this.zze = Collections.EMPTY_MAP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (this.zzc) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (!this.zza.isEmpty()) {
            this.zza.clear();
        }
        if (this.zzb.isEmpty()) {
            return;
        }
        this.zzb.clear();
    }

    public void zzd() {
        Map<K, V> mapUnmodifiableMap;
        Map<K, V> mapUnmodifiableMap2;
        if (this.zzc) {
            return;
        }
        if (this.zzb.isEmpty()) {
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.zzb);
        }
        this.zzb = mapUnmodifiableMap;
        if (this.zze.isEmpty()) {
            mapUnmodifiableMap2 = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(this.zze);
        }
        this.zze = mapUnmodifiableMap2;
        this.zzc = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzlm<K, V>) comparable) >= 0 || this.zzb.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlm)) {
            return super.equals(obj);
        }
        zzlm zzlmVar = (zzlm) obj;
        int size = size();
        if (size != zzlmVar.size()) {
            return false;
        }
        int iZza = zza();
        if (iZza != zzlmVar.zza()) {
            return entrySet().equals(zzlmVar.entrySet());
        }
        for (int i = 0; i < iZza; i++) {
            if (!zza(i).equals(zzlmVar.zza(i))) {
                return false;
            }
        }
        if (iZza != size) {
            return this.zzb.equals(zzlmVar.zzb);
        }
        return true;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
