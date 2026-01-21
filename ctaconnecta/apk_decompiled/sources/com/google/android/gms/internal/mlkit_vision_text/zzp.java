package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
class zzp<V> implements Iterator<V> {
    final Iterator<V> zza;
    private final Collection<V> zzb;
    private final /* synthetic */ zzm zzc;

    zzp(zzm zzmVar) {
        this.zzc = zzmVar;
        this.zzb = zzmVar.zzb;
        this.zza = zzh.zzb((Collection) zzmVar.zzb);
    }

    zzp(zzm zzmVar, Iterator<V> it) {
        this.zzc = zzmVar;
        this.zzb = zzmVar.zzb;
        this.zza = it;
    }

    final void zza() {
        this.zzc.zza();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.zza.remove();
        zzh.zzb(this.zzc.zzd);
        this.zzc.zzb();
    }
}
