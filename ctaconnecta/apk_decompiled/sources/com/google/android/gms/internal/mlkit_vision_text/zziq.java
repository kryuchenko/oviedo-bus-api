package com.google.android.gms.internal.mlkit_vision_text;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zziq extends AbstractList<String> implements zzgr, RandomAccess {
    private final zzgr zza;

    public zziq(zzgr zzgrVar) {
        this.zza = zzgrVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgr
    public final zzgr zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgr
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgr
    public final void zza(zzeu zzeuVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzit(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzis(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgr
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
