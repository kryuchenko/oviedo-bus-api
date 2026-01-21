package com.google.android.gms.internal.mlkit_vision_text;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzex extends zzez {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzeu zzc;

    zzex(zzeu zzeuVar) {
        this.zzc = zzeuVar;
        this.zzb = zzeuVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfd
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }
}
