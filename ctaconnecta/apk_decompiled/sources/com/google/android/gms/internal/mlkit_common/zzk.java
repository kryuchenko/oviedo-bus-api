package com.google.android.gms.internal.mlkit_common;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzk<E> extends zzs<E> {
    private final int zza;
    private int zzb;

    protected zzk(int i, int i2) {
        zzi.zzb(i2, i);
        this.zza = i;
        this.zzb = i2;
    }

    protected abstract E zza(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzb = i + 1;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb - 1;
        this.zzb = i;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }
}
