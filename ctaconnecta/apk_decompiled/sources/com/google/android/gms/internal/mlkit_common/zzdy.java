package com.google.android.gms.internal.mlkit_common;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzdy extends zzea {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzdv zzc;

    zzdy(zzdv zzdvVar) {
        this.zzc = zzdvVar;
        this.zzb = zzdvVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzee
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }
}
