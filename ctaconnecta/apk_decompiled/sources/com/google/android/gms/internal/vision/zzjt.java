package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzjt extends AbstractList<String> implements zzho, RandomAccess {
    private final zzho zzabd;

    public zzjt(zzho zzhoVar) {
        this.zzabd = zzhoVar;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final zzho zzgz() {
        return this;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final Object getRaw(int i) {
        return this.zzabd.getRaw(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzabd.size();
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final void zzc(zzfm zzfmVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzjs(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzjv(this);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final List<?> zzgy() {
        return this.zzabd.zzgy();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzabd.get(i);
    }
}
