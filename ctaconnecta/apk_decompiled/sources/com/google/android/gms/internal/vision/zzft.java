package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzft extends zzfw {
    private final int zzsq;
    private final int zzsr;

    zzft(byte[] bArr, int i, int i2) {
        super(bArr);
        zzc(i, i + i2, bArr.length);
        this.zzsq = i;
        this.zzsr = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzfw, com.google.android.gms.internal.vision.zzfm
    public final byte zzao(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzst[this.zzsq + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.vision.zzfw, com.google.android.gms.internal.vision.zzfm
    final byte zzap(int i) {
        return this.zzst[this.zzsq + i];
    }

    @Override // com.google.android.gms.internal.vision.zzfw, com.google.android.gms.internal.vision.zzfm
    public final int size() {
        return this.zzsr;
    }

    @Override // com.google.android.gms.internal.vision.zzfw
    protected final int zzev() {
        return this.zzsq;
    }

    @Override // com.google.android.gms.internal.vision.zzfw, com.google.android.gms.internal.vision.zzfm
    protected final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzst, zzev(), bArr, 0, i3);
    }
}
