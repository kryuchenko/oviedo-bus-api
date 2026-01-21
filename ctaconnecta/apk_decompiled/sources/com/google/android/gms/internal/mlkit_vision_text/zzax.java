package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public interface zzax<K, V> {
    boolean zza(@NullableDecl K k, @NullableDecl V v);

    Collection<V> zzb(@NullableDecl K k);

    Map<K, Collection<V>> zzg();

    Set<K> zzh();
}
