package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzhn<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzyp;

    public zzhn(Iterator<Map.Entry<K, Object>> it) {
        this.zzyp = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzyp.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzyp.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzyp.next();
        return next.getValue() instanceof zzhi ? new zzhk(next) : next;
    }
}
