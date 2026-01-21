package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzi<K, V> implements Iterator<Map.Entry<K, Collection<V>>> {
    private final Iterator<Map.Entry<K, Collection<V>>> zza;

    @NullableDecl
    private Collection<V> zzb;
    private final /* synthetic */ zzg zzc;

    zzi(zzg zzgVar) {
        this.zzc = zzgVar;
        this.zza = zzgVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzd.zza(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzh.zzb(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Collection<V>> next = this.zza.next();
        this.zzb = next.getValue();
        zzg zzgVar = this.zzc;
        K key = next.getKey();
        return new zzai(key, zzgVar.zzb.zza((zzh) key, (Collection) next.getValue()));
    }
}
