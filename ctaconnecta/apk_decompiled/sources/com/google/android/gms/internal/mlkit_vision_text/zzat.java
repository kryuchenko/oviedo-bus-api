package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzat<K, V> extends zzbb<Map.Entry<K, V>> {
    zzat() {
    }

    abstract Map<K, V> zza();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return zza().size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        zza().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objZza = zzao.zza(zza(), key);
            if (zza.zza(objZza, entry.getValue()) && (objZza != null || zza().containsKey(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return zza().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj)) {
            return zza().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzbb, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) zzd.zza(collection));
        } catch (UnsupportedOperationException unused) {
            return zzay.zza(this, collection.iterator());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzbb, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        int i;
        try {
            return super.retainAll((Collection) zzd.zza(collection));
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzu.zza(size, "expectedSize");
                i = size + 1;
            } else {
                i = size < 1073741824 ? (int) ((size / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i);
            for (Object obj : collection) {
                if (contains(obj)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return zza().keySet().retainAll(hashSet);
        }
    }
}
