package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzjr {
    private static final zzjr zzaay = new zzjr(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzaaz;
    private boolean zzry;
    private int zzwt;
    private Object[] zzzk;

    public static zzjr zzih() {
        return zzaay;
    }

    static zzjr zzii() {
        return new zzjr();
    }

    static zzjr zza(zzjr zzjrVar, zzjr zzjrVar2) {
        int i = zzjrVar.count + zzjrVar2.count;
        int[] iArrCopyOf = Arrays.copyOf(zzjrVar.zzaaz, i);
        System.arraycopy(zzjrVar2.zzaaz, 0, iArrCopyOf, zzjrVar.count, zzjrVar2.count);
        Object[] objArrCopyOf = Arrays.copyOf(zzjrVar.zzzk, i);
        System.arraycopy(zzjrVar2.zzzk, 0, objArrCopyOf, zzjrVar.count, zzjrVar2.count);
        return new zzjr(i, iArrCopyOf, objArrCopyOf, true);
    }

    private zzjr() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjr(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwt = -1;
        this.count = i;
        this.zzaaz = iArr;
        this.zzzk = objArr;
        this.zzry = z;
    }

    public final void zzdq() {
        this.zzry = false;
    }

    final void zza(zzkl zzklVar) throws IOException {
        if (zzklVar.zzfk() == zzgx.zzf.zzxm) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzklVar.zza(this.zzaaz[i] >>> 3, this.zzzk[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzklVar.zza(this.zzaaz[i2] >>> 3, this.zzzk[i2]);
        }
    }

    public final void zzb(zzkl zzklVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzklVar.zzfk() == zzgx.zzf.zzxl) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzaaz[i], this.zzzk[i], zzklVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzaaz[i2], this.zzzk[i2], zzklVar);
        }
    }

    private static void zzb(int i, Object obj, zzkl zzklVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzklVar.zzi(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzklVar.zzc(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzklVar.zza(i2, (zzfm) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzklVar.zzk(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzhh.zzgs());
        }
        if (zzklVar.zzfk() == zzgx.zzf.zzxl) {
            zzklVar.zzbk(i2);
            ((zzjr) obj).zzb(zzklVar);
            zzklVar.zzbl(i2);
        } else {
            zzklVar.zzbl(i2);
            ((zzjr) obj).zzb(zzklVar);
            zzklVar.zzbk(i2);
        }
    }

    public final int zzij() {
        int i = this.zzwt;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            iZzd += zzgf.zzd(this.zzaaz[i2] >>> 3, (zzfm) this.zzzk[i2]);
        }
        this.zzwt = iZzd;
        return iZzd;
    }

    public final int zzgg() {
        int iZze;
        int i = this.zzwt;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzaaz[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzgf.zze(i5, ((Long) this.zzzk[i3]).longValue());
            } else if (i6 == 1) {
                iZze = zzgf.zzg(i5, ((Long) this.zzzk[i3]).longValue());
            } else if (i6 == 2) {
                iZze = zzgf.zzc(i5, (zzfm) this.zzzk[i3]);
            } else if (i6 == 3) {
                iZze = (zzgf.zzbb(i5) << 1) + ((zzjr) this.zzzk[i3]).zzgg();
            } else if (i6 == 5) {
                iZze = zzgf.zzo(i5, ((Integer) this.zzzk[i3]).intValue());
            } else {
                throw new IllegalStateException(zzhh.zzgs());
            }
            i2 += iZze;
        }
        this.zzwt = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzjr)) {
            return false;
        }
        zzjr zzjrVar = (zzjr) obj;
        int i = this.count;
        if (i == zzjrVar.count) {
            int[] iArr = this.zzaaz;
            int[] iArr2 = zzjrVar.zzaaz;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.zzzk;
                    Object[] objArr2 = zzjrVar.zzzk;
                    int i3 = this.count;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzaaz;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzzk;
        int i6 = this.count;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzii.zza(sb, i, String.valueOf(this.zzaaz[i2] >>> 3), this.zzzk[i2]);
        }
    }

    final void zzb(int i, Object obj) {
        if (!this.zzry) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.count;
        int[] iArr = this.zzaaz;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzaaz = Arrays.copyOf(iArr, i3);
            this.zzzk = Arrays.copyOf(this.zzzk, i3);
        }
        int[] iArr2 = this.zzaaz;
        int i4 = this.count;
        iArr2[i4] = i;
        this.zzzk[i4] = obj;
        this.count = i4 + 1;
    }
}
