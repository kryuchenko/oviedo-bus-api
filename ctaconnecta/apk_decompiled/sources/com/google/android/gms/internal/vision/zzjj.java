package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjj<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzjb zzaaq;
    private Iterator<Map.Entry<K, V>> zzaar;
    private boolean zzaav;

    private zzjj(zzjb zzjbVar) {
        this.zzaaq = zzjbVar;
        this.pos = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos + 1 < this.zzaaq.zzaal.size() || (!this.zzaaq.zzaam.isEmpty() && zzid().hasNext());
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzaav) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzaav = false;
        this.zzaaq.zzib();
        if (this.pos < this.zzaaq.zzaal.size()) {
            zzjb zzjbVar = this.zzaaq;
            int i = this.pos;
            this.pos = i - 1;
            zzjbVar.zzbw(i);
            return;
        }
        zzid().remove();
    }

    private final Iterator<Map.Entry<K, V>> zzid() {
        if (this.zzaar == null) {
            this.zzaar = this.zzaaq.zzaam.entrySet().iterator();
        }
        return this.zzaar;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzaav = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.zzaaq.zzaal.size()) {
            return zzid().next();
        }
        return (Map.Entry) this.zzaaq.zzaal.get(this.pos);
    }

    /* synthetic */ zzjj(zzjb zzjbVar, zzja zzjaVar) {
        this(zzjbVar);
    }
}
