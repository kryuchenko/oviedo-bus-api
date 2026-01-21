package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
class zzfw extends zzfx {
    protected final byte[] zzst;

    zzfw(byte[] bArr) {
        bArr.getClass();
        this.zzst = bArr;
    }

    protected int zzev() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public byte zzao(int i) {
        return this.zzst[i];
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    byte zzap(int i) {
        return this.zzst[i];
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public int size() {
        return this.zzst.length;
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public final zzfm zzg(int i, int i2) {
        int iZzc = zzc(0, i2, size());
        if (iZzc == 0) {
            return zzfm.zzsm;
        }
        return new zzft(this.zzst, zzev(), iZzc);
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzst, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    final void zza(zzfn zzfnVar) throws IOException {
        zzfnVar.zzc(this.zzst, zzev(), size());
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    protected final String zza(Charset charset) {
        return new String(this.zzst, zzev(), size(), charset);
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public final boolean zzet() {
        int iZzev = zzev();
        return zzjx.zzf(this.zzst, iZzev, size() + iZzev);
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm) || size() != ((zzfm) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzfw) {
            zzfw zzfwVar = (zzfw) obj;
            int iZzeu = zzeu();
            int iZzeu2 = zzfwVar.zzeu();
            if (iZzeu == 0 || iZzeu2 == 0 || iZzeu == iZzeu2) {
                return zza(zzfwVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.vision.zzfx
    final boolean zza(zzfm zzfmVar, int i, int i2) {
        if (i2 > zzfmVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzfmVar.size()) {
            int size2 = zzfmVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (zzfmVar instanceof zzfw) {
            zzfw zzfwVar = (zzfw) zzfmVar;
            byte[] bArr = this.zzst;
            byte[] bArr2 = zzfwVar.zzst;
            int iZzev = zzev() + i2;
            int iZzev2 = zzev();
            int iZzev3 = zzfwVar.zzev();
            while (iZzev2 < iZzev) {
                if (bArr[iZzev2] != bArr2[iZzev3]) {
                    return false;
                }
                iZzev2++;
                iZzev3++;
            }
            return true;
        }
        return zzfmVar.zzg(0, i2).equals(zzg(0, i2));
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    protected final int zzb(int i, int i2, int i3) {
        return zzgy.zza(i, this.zzst, zzev(), i3);
    }
}
