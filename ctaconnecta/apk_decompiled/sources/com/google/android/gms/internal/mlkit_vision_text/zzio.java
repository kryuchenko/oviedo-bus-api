package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzio {
    private static final zzio zza = new zzio(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzio zza() {
        return zza;
    }

    static zzio zza(zzio zzioVar, zzio zzioVar2) {
        int i = zzioVar.zzb + zzioVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzioVar.zzc, i);
        System.arraycopy(zzioVar2.zzc, 0, iArrCopyOf, zzioVar.zzb, zzioVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzioVar.zzd, i);
        System.arraycopy(zzioVar2.zzd, 0, objArrCopyOf, zzioVar.zzb, zzioVar2.zzb);
        return new zzio(i, iArrCopyOf, objArrCopyOf, true);
    }

    private zzio() {
        this(0, new int[8], new Object[8], true);
    }

    private zzio(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzb() {
        this.zzf = false;
    }

    final void zza(zzjj zzjjVar) throws IOException {
        if (zzjjVar.zza() == zzfy.zzf.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzjjVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjjVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzjj zzjjVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzjjVar.zza() == zzfy.zzf.zzj) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzjjVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzjjVar);
        }
    }

    private static void zza(int i, Object obj, zzjj zzjjVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjjVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzjjVar.zzd(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzjjVar.zza(i2, (zzeu) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzjjVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgg.zza());
        }
        if (zzjjVar.zza() == zzfy.zzf.zzj) {
            zzjjVar.zza(i2);
            ((zzio) obj).zzb(zzjjVar);
            zzjjVar.zzb(i2);
        } else {
            zzjjVar.zzb(i2);
            ((zzio) obj).zzb(zzjjVar);
            zzjjVar.zza(i2);
        }
    }

    public final int zzc() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZzd += zzfl.zzd(this.zzc[i2] >>> 3, (zzeu) this.zzd[i2]);
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
                iZze = zzfl.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                iZze = zzfl.zzg(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                iZze = zzfl.zzc(i5, (zzeu) this.zzd[i3]);
            } else if (i6 == 3) {
                iZze = (zzfl.zze(i5) << 1) + ((zzio) this.zzd[i3]).zzd();
            } else if (i6 == 5) {
                iZze = zzfl.zzi(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzgg.zza());
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
        if (obj == null || !(obj instanceof zzio)) {
            return false;
        }
        zzio zzioVar = (zzio) obj;
        int i = this.zzb;
        if (i == zzioVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzioVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzioVar.zzd;
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
            zzhl.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}
