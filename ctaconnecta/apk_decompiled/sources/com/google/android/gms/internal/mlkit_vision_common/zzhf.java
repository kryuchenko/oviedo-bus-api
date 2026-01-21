package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzhf extends AbstractList<String> implements zzfc, RandomAccess {
    private final zzfc zza;

    public zzhf(zzfc zzfcVar) {
        this.zza = zzfcVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final zzfc a_() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final void zza(zzdj zzdjVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzhe(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzhh(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final List<?> zzb() {
        return this.zza.zzb();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
