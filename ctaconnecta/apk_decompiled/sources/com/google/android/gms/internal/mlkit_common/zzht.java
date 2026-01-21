package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzht implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzhr zzb;

    zzht(zzhr zzhrVar) {
        this.zzb = zzhrVar;
        this.zza = zzhrVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }
}
