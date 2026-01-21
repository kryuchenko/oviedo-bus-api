package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzj<K, V> extends zzat<K, Collection<V>> {
    private final /* synthetic */ zzg zza;

    zzj(zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzat
    final Map<K, Collection<V>> zza() {
        return this.zza;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return new zzi(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzat, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return zzx.zza(this.zza.zza.entrySet(), obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzat, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.zza.zzb.zzc(((Map.Entry) obj).getKey());
        return true;
    }
}
