package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzhp {
    private static final zzhp zza = new zzhp(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzhp zza() {
        return zza;
    }

    static zzhp zza(zzhp zzhpVar, zzhp zzhpVar2) {
        int i = zzhpVar.zzb + zzhpVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhpVar.zzc, i);
        System.arraycopy(zzhpVar2.zzc, 0, iArrCopyOf, zzhpVar.zzb, zzhpVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhpVar.zzd, i);
        System.arraycopy(zzhpVar2.zzd, 0, objArrCopyOf, zzhpVar.zzb, zzhpVar2.zzb);
        return new zzhp(i, iArrCopyOf, objArrCopyOf, true);
    }

    private zzhp() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhp(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzb() {
        this.zzf = false;
    }

    final void zza(zzik zzikVar) throws IOException {
        if (zzikVar.zza() == zzez.zzf.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzikVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzikVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzik zzikVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzikVar.zza() == zzez.zzf.zzj) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzikVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzikVar);
        }
    }

    private static void zza(int i, Object obj, zzik zzikVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzikVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzikVar.zzd(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzikVar.zza(i2, (zzdv) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzikVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfh.zza());
        }
        if (zzikVar.zza() == zzez.zzf.zzj) {
            zzikVar.zza(i2);
            ((zzhp) obj).zzb(zzikVar);
            zzikVar.zzb(i2);
        } else {
            zzikVar.zzb(i2);
            ((zzhp) obj).zzb(zzikVar);
            zzikVar.zza(i2);
        }
    }

    public final int zzc() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZzd += zzem.zzd(this.zzc[i2] >>> 3, (zzdv) this.zzd[i2]);
        }
        this.zze = iZzd;
        return iZzd;
    }

    public final int zzd() {
        int iZze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzem.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                iZze = zzem.zzg(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                iZze = zzem.zzc(i5, (zzdv) this.zzd[i3]);
            } else if (i6 == 3) {
                iZze = (zzem.zze(i5) << 1) + ((zzhp) this.zzd[i3]).zzd();
            } else if (i6 == 5) {
                iZze = zzem.zzi(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzfh.zza());
            }
            i2 += iZze;
        }
        this.zze = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhp)) {
            return false;
        }
        zzhp zzhpVar = (zzhp) obj;
        int i = this.zzb;
        if (i == zzhpVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhpVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhpVar.zzd;
                    int i3 = this.zzb;
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
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgm.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}
