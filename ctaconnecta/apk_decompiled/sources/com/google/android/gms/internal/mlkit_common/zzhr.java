package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzhr extends AbstractList<String> implements zzfs, RandomAccess {
    private final zzfs zza;

    public zzhr(zzfs zzfsVar) {
        this.zza = zzfsVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfs
    public final zzfs zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfs
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfs
    public final void zza(zzdv zzdvVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzhu(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzht(this);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfs
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
