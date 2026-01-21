package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjd<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzjb zzaaq;
    private Iterator<Map.Entry<K, V>> zzaar;

    private zzjd(zzjb zzjbVar) {
        this.zzaaq = zzjbVar;
        this.pos = zzjbVar.zzaal.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzaaq.zzaal.size()) || zzid().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzid() {
        if (this.zzaar == null) {
            this.zzaar = this.zzaaq.zzaao.entrySet().iterator();
        }
        return this.zzaar;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzid().hasNext()) {
            return zzid().next();
        }
        List list = this.zzaaq.zzaal;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    /* synthetic */ zzjd(zzjb zzjbVar, zzja zzjaVar) {
        this(zzjbVar);
    }
}
