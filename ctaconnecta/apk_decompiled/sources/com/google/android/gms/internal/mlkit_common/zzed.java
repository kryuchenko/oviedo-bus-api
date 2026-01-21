package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzed {
    private final zzem zza;
    private final byte[] zzb;

    private zzed(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzem.zza(bArr);
    }

    public final zzdv zza() {
        this.zza.zzb();
        return new zzef(this.zzb);
    }

    public final zzem zzb() {
        return this.zza;
    }

    /* synthetic */ zzed(int i, zzdy zzdyVar) {
        this(i);
    }
}
