package com.google.android.gms.internal.vision;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzhk<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzhi> zzyl;

    private zzhk(Map.Entry<K, zzhi> entry) {
        this.zzyl = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzyl.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzyl.getValue() == null) {
            return null;
        }
        return zzhi.zzgv();
    }

    public final zzhi zzgx() {
        return this.zzyl.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzih)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zzyl.getValue().zzi((zzih) obj);
    }
}
