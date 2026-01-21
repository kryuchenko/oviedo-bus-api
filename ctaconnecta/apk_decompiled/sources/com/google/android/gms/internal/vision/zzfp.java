package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzfp extends zzfr {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzfm zzsp;

    zzfp(zzfm zzfmVar) {
        this.zzsp = zzfmVar;
        this.limit = zzfmVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzfv
    public final byte nextByte() {
        int i = this.position;
        if (i >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = i + 1;
        return this.zzsp.zzap(i);
    }
}
