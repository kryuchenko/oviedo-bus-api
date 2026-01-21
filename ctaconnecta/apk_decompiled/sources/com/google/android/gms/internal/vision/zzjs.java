package com.google.android.gms.internal.vision;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjs implements ListIterator<String> {
    private ListIterator<String> zzaba;
    private final /* synthetic */ int zzabb;
    private final /* synthetic */ zzjt zzabc;

    zzjs(zzjt zzjtVar, int i) {
        this.zzabc = zzjtVar;
        this.zzabb = i;
        this.zzaba = zzjtVar.zzabd.listIterator(i);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzaba.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzaba.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzaba.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzaba.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzaba.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzaba.next();
    }
}
