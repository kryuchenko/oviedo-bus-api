package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zziu implements zzif {
    private final int flags;
    private final String info;
    private final Object[] zzzk;
    private final zzih zzzn;

    zziu(zzih zzihVar, String str, Object[] objArr) {
        this.zzzn = zzihVar;
        this.info = str;
        this.zzzk = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.flags = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.flags = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String zzhq() {
        return this.info;
    }

    final Object[] zzhr() {
        return this.zzzk;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final zzih zzhl() {
        return this.zzzn;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzhj() {
        return (this.flags & 1) == 1 ? zzgx.zzf.zzxi : zzgx.zzf.zzxj;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final boolean zzhk() {
        return (this.flags & 2) == 2;
    }
}
