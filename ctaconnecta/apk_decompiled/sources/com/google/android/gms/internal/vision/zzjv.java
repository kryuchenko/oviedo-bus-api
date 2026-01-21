package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjv implements Iterator<String> {
    private final /* synthetic */ zzjt zzabc;
    private Iterator<String> zzaby;

    zzjv(zzjt zzjtVar) {
        this.zzabc = zzjtVar;
        this.zzaby = zzjtVar.zzabd.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzaby.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzaby.next();
    }
}
