package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfc {
    private final zzfl zza;
    private final byte[] zzb;

    private zzfc(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzfl.zza(bArr);
    }

    public final zzeu zza() {
        this.zza.zzb();
        return new zzfe(this.zzb);
    }

    public final zzfl zzb() {
        return this.zza;
    }

    /* synthetic */ zzfc(int i, zzex zzexVar) {
        this(i);
    }
}
