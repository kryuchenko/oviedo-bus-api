package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhe extends zzhk {
    private final /* synthetic */ zzgz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzhe(zzgz zzgzVar) {
        super(zzgzVar, null);
        this.zza = zzgzVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhb(this.zza, null);
    }

    /* synthetic */ zzhe(zzgz zzgzVar, zzhc zzhcVar) {
        this(zzgzVar);
    }
}
