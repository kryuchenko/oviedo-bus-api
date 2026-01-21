package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
class zzdt extends zzdq {
    protected final byte[] zzb;

    zzdt(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final zzdj zza(int i, int i2) {
        int iZzb = zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzdj.zza;
        }
        return new zzdm(this.zzb, zze(), iZzb);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    final void zza(zzdg zzdgVar) throws IOException {
        zzdgVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final boolean zzc() {
        int iZze = zze();
        return zzhj.zza(this.zzb, iZze, zza() + iZze);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdj) || zza() != ((zzdj) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (obj instanceof zzdt) {
            zzdt zzdtVar = (zzdt) obj;
            int iZzd = zzd();
            int iZzd2 = zzdtVar.zzd();
            if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
                return zza(zzdtVar, 0, zza());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdq
    final boolean zza(zzdj zzdjVar, int i, int i2) {
        if (i2 > zzdjVar.zza()) {
            int iZza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iZza);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzdjVar.zza()) {
            int iZza2 = zzdjVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iZza2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzdjVar instanceof zzdt) {
            zzdt zzdtVar = (zzdt) zzdjVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzdtVar.zzb;
            int iZze = zze() + i2;
            int iZze2 = zze();
            int iZze3 = zzdtVar.zze();
            while (iZze2 < iZze) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzdjVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    protected final int zza(int i, int i2, int i3) {
        return zzem.zza(i, this.zzb, zze(), i3);
    }
}
