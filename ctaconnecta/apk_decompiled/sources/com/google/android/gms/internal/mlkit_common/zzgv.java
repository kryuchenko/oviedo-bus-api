package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgv implements zzgf {
    private final zzgh zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzgv(zzgh zzghVar, String str, Object[] objArr) {
        this.zza = zzghVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgf
    public final zzgh zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgf
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzez.zzf.zzh : zzez.zzf.zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgf
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
