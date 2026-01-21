package com.google.android.gms.internal.mlkit_vision_text;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
class zzfe extends zzff {
    protected final byte[] zzb;

    zzfe(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    public final zzeu zza(int i, int i2) {
        int iZzb = zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzeu.zza;
        }
        return new zzfb(this.zzb, zze(), iZzb);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    final void zza(zzev zzevVar) throws IOException {
        zzevVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    public final boolean zzc() {
        int iZze = zze();
        return zzix.zza(this.zzb, iZze, zza() + iZze);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeu) || zza() != ((zzeu) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (obj instanceof zzfe) {
            zzfe zzfeVar = (zzfe) obj;
            int iZzd = zzd();
            int iZzd2 = zzfeVar.zzd();
            if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
                return zza(zzfeVar, 0, zza());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzff
    final boolean zza(zzeu zzeuVar, int i, int i2) {
        if (i2 > zzeuVar.zza()) {
            int iZza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iZza);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzeuVar.zza()) {
            int iZza2 = zzeuVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iZza2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzeuVar instanceof zzfe) {
            zzfe zzfeVar = (zzfe) zzeuVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzfeVar.zzb;
            int iZze = zze() + i2;
            int iZze2 = zze();
            int iZze3 = zzfeVar.zze();
            while (iZze2 < iZze) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzeuVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeu
    protected final int zza(int i, int i2, int i3) {
        return zzgb.zza(i, this.zzb, zze(), i3);
    }
}
