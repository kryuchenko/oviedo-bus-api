package com.google.mlkit.common.sdkinternal;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class LazyInstanceMap<K, V> {
    private final Map<K, V> zza = new HashMap();

    protected abstract V create(K k);

    public V get(K k) {
        synchronized (this.zza) {
            if (this.zza.containsKey(k)) {
                return this.zza.get(k);
            }
            V vCreate = create(k);
            this.zza.put(k, vCreate);
            return vCreate;
        }
    }
}
