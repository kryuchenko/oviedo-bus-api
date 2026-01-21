package com.google.android.gms.internal.vision;

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

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
class zzjb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zzaak;
    private List<zzjg> zzaal;
    private Map<K, V> zzaam;
    private volatile zzji zzaan;
    private Map<K, V> zzaao;
    private volatile zzjc zzaap;
    private boolean zztr;

    static <FieldDescriptorType extends zzgp<FieldDescriptorType>> zzjb<FieldDescriptorType, Object> zzbu(int i) {
        return new zzja(i);
    }

    private zzjb(int i) {
        this.zzaak = i;
        this.zzaal = Collections.EMPTY_LIST;
        this.zzaam = Collections.EMPTY_MAP;
        this.zzaao = Collections.EMPTY_MAP;
    }

    public void zzdq() {
        Map<K, V> mapUnmodifiableMap;
        Map<K, V> mapUnmodifiableMap2;
        if (this.zztr) {
            return;
        }
        if (this.zzaam.isEmpty()) {
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.zzaam);
        }
        this.zzaam = mapUnmodifiableMap;
        if (this.zzaao.isEmpty()) {
            mapUnmodifiableMap2 = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(this.zzaao);
        }
        this.zzaao = mapUnmodifiableMap2;
        this.zztr = true;
    }

    public final boolean isImmutable() {
        return this.zztr;
    }

    public final int zzhy() {
        return this.zzaal.size();
    }

    public final Map.Entry<K, V> zzbv(int i) {
        return this.zzaal.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzhz() {
        if (this.zzaam.isEmpty()) {
            return zzjf.zzie();
        }
        return this.zzaam.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzaal.size() + this.zzaam.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzjb<K, V>) comparable) >= 0 || this.zzaam.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza((zzjb<K, V>) comparable);
        if (iZza >= 0) {
            return (V) this.zzaal.get(iZza).getValue();
        }
        return this.zzaam.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V zza(K k, V v) {
        zzib();
        int iZza = zza((zzjb<K, V>) k);
        if (iZza >= 0) {
            return (V) this.zzaal.get(iZza).setValue(v);
        }
        zzib();
        if (this.zzaal.isEmpty() && !(this.zzaal instanceof ArrayList)) {
            this.zzaal = new ArrayList(this.zzaak);
        }
        int i = -(iZza + 1);
        if (i >= this.zzaak) {
            return zzic().put(k, v);
        }
        int size = this.zzaal.size();
        int i2 = this.zzaak;
        if (size == i2) {
            zzjg zzjgVarRemove = this.zzaal.remove(i2 - 1);
            zzic().put((Comparable) zzjgVarRemove.getKey(), zzjgVarRemove.getValue());
        }
        this.zzaal.add(i, new zzjg(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzib();
        if (!this.zzaal.isEmpty()) {
            this.zzaal.clear();
        }
        if (this.zzaam.isEmpty()) {
            return;
        }
        this.zzaam.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzib();
        Comparable comparable = (Comparable) obj;
        int iZza = zza((zzjb<K, V>) comparable);
        if (iZza >= 0) {
            return zzbw(iZza);
        }
        if (this.zzaam.isEmpty()) {
            return null;
        }
        return this.zzaam.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzbw(int i) {
        zzib();
        V v = (V) this.zzaal.remove(i).getValue();
        if (!this.zzaam.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzic().entrySet().iterator();
            this.zzaal.add(new zzjg(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(K k) {
        int i;
        int i2;
        int size = this.zzaal.size();
        int i3 = size - 1;
        if (i3 < 0) {
            i = 0;
            while (i <= i3) {
                int i4 = (i + i3) / 2;
                int iCompareTo = k.compareTo((Comparable) this.zzaal.get(i4).getKey());
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
            int iCompareTo2 = k.compareTo((Comparable) this.zzaal.get(i3).getKey());
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

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzaan == null) {
            this.zzaan = new zzji(this, null);
        }
        return this.zzaan;
    }

    final Set<Map.Entry<K, V>> zzia() {
        if (this.zzaap == null) {
            this.zzaap = new zzjc(this, null);
        }
        return this.zzaap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzib() {
        if (this.zztr) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzic() {
        zzib();
        if (this.zzaam.isEmpty() && !(this.zzaam instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzaam = treeMap;
            this.zzaao = treeMap.descendingMap();
        }
        return (SortedMap) this.zzaam;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return super.equals(obj);
        }
        zzjb zzjbVar = (zzjb) obj;
        int size = size();
        if (size != zzjbVar.size()) {
            return false;
        }
        int iZzhy = zzhy();
        if (iZzhy != zzjbVar.zzhy()) {
            return entrySet().equals(zzjbVar.entrySet());
        }
        for (int i = 0; i < iZzhy; i++) {
            if (!zzbv(i).equals(zzjbVar.zzbv(i))) {
                return false;
            }
        }
        if (iZzhy != size) {
            return this.zzaam.equals(zzjbVar.zzaam);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzhy = zzhy();
        int iHashCode = 0;
        for (int i = 0; i < iZzhy; i++) {
            iHashCode += this.zzaal.get(i).hashCode();
        }
        return this.zzaam.size() > 0 ? iHashCode + this.zzaam.hashCode() : iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzjb<K, V>) obj, (Comparable) obj2);
    }

    /* synthetic */ zzjb(int i, zzja zzjaVar) {
        this(i);
    }
}
