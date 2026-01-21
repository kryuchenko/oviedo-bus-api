package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzk<K> implements Iterator<K> {

    @NullableDecl
    private Map.Entry<K, Collection<V>> zza;
    private final /* synthetic */ Iterator zzb;
    private final /* synthetic */ zzl zzc;

    zzk(zzl zzlVar, Iterator it) {
        this.zzc = zzlVar;
        this.zzb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final K next() {
        Map.Entry<K, Collection<V>> entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzd.zza(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzh.zzb(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
