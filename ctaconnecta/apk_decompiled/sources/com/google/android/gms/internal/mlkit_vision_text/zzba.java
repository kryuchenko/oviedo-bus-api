package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
abstract class zzba<F, T> implements Iterator<T> {
    private final Iterator<? extends F> zza;

    zzba(Iterator<? extends F> it) {
        this.zza = (Iterator) zzd.zza(it);
    }

    abstract T zza(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return zza(this.zza.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }
}
