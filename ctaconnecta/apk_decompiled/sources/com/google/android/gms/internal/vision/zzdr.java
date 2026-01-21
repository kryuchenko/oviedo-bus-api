package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdr<K> extends zzdo<K> {
    private final transient zzdk<K> zzlz;
    private final transient zzdl<K, ?> zzmj;

    zzdr(zzdl<K, ?> zzdlVar, zzdk<K> zzdkVar) {
        this.zzmj = zzdlVar;
        this.zzlz = zzdkVar;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    /* renamed from: zzbz */
    public final zzdw<K> iterator() {
        return (zzdw) zzcd().iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    final int zza(Object[] objArr, int i) {
        return zzcd().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzdo, com.google.android.gms.internal.vision.zzdh
    public final zzdk<K> zzcd() {
        return this.zzlz;
    }

    @Override // com.google.android.gms.internal.vision.zzdh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzmj.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzmj.size();
    }

    @Override // com.google.android.gms.internal.vision.zzdo, com.google.android.gms.internal.vision.zzdh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
