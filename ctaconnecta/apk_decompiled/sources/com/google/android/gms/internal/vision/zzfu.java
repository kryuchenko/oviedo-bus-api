package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzfu {
    private final byte[] buffer;
    private final zzgf zzss;

    private zzfu(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzss = zzgf.zze(bArr);
    }

    public final zzfm zzew() {
        this.zzss.zzfi();
        return new zzfw(this.buffer);
    }

    public final zzgf zzex() {
        return this.zzss;
    }

    /* synthetic */ zzfu(int i, zzfp zzfpVar) {
        this(i);
    }
}
