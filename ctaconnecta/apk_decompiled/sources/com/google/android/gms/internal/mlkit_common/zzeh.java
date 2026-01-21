package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzeh {
    private int zza;
    private int zzb;
    private boolean zzc;

    static zzeh zza(byte[] bArr, int i, int i2, boolean z) {
        zzej zzejVar = new zzej(bArr, 0, i2, false);
        try {
            zzejVar.zza(i2);
            return zzejVar;
        } catch (zzfh e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzfh;

    private zzeh() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }
}
