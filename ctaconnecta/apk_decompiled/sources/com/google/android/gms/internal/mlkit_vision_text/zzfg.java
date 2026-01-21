package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzfg {
    private int zza;
    private int zzb;
    private boolean zzc;

    static zzfg zza(byte[] bArr, int i, int i2, boolean z) {
        zzfi zzfiVar = new zzfi(bArr, 0, i2, false);
        try {
            zzfiVar.zza(i2);
            return zzfiVar;
        } catch (zzgg e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzgg;

    private zzfg() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }
}
