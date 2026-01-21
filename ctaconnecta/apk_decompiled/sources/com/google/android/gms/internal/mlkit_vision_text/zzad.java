package com.google.android.gms.internal.mlkit_vision_text;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzad<T> implements Iterator<T> {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzw zzd;

    private zzad(zzw zzwVar) {
        this.zzd = zzwVar;
        this.zza = zzwVar.zzf;
        this.zzb = zzwVar.zzd();
        this.zzc = -1;
    }

    abstract T zza(int i);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.zzb >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        zza();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzc = i;
        T tZza = zza(i);
        this.zzb = this.zzd.zza(this.zzb);
        return tZza;
    }

    @Override // java.util.Iterator
    public void remove() {
        zza();
        zzd.zza(this.zzc >= 0, "no calls to next() since the last call to remove()");
        this.zza += 32;
        zzw zzwVar = this.zzd;
        zzwVar.remove(zzwVar.zzb[this.zzc]);
        this.zzb = zzw.zzb(this.zzb, this.zzc);
        this.zzc = -1;
    }

    private final void zza() {
        if (this.zzd.zzf != this.zza) {
            throw new ConcurrentModificationException();
        }
    }

    /* synthetic */ zzad(zzw zzwVar, zzz zzzVar) {
        this(zzwVar);
    }
}
