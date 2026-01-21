package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzbb<E> extends AbstractSet<E> {
    zzbb() {
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        zzd.zza(collection);
        if (collection instanceof zzaw) {
            collection = ((zzaw) collection).zza();
        }
        if ((collection instanceof Set) && collection.size() > size()) {
            Iterator<E> it = iterator();
            zzd.zza(collection);
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return zzay.zza(this, collection.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return super.retainAll((Collection) zzd.zza(collection));
    }
}
