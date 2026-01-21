package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzds<K, V> extends zzdk<Map.Entry<K, V>> {
    private final /* synthetic */ zzdp zzmo;

    zzds(zzdp zzdpVar) {
        this.zzmo = zzdpVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzmo.size;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzcy.zzd(i, this.zzmo.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzmo.zzmk[i2], this.zzmo.zzmk[i2 + 1]);
    }
}
