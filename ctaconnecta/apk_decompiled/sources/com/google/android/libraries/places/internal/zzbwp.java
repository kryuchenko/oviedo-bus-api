package com.google.android.libraries.places.internal;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwp extends zzbwf {
    private final transient byte[][] zzc;
    private final transient int[] zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbwp(byte[][] segments, int[] directory) {
        super(zzbwf.zzb.zzn());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.zzc = segments;
        this.zzd = directory;
    }

    private final zzbwf zzs() {
        return new zzbwf(zzp());
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbwf) {
            zzbwf zzbwfVar = (zzbwf) obj;
            return zzbwfVar.zzc() == zzc() && zzk(0, zzbwfVar, 0, zzc());
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final int hashCode() {
        int iZzb = zzb();
        if (iZzb != 0) {
            return iZzb;
        }
        byte[][] bArr = this.zzc;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                zzh(i3);
                return i3;
            }
            int[] iArr = this.zzd;
            byte[][] bArr2 = this.zzc;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = (i5 - i2) + i4;
            byte[] bArr3 = bArr2[i];
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr3[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final String toString() {
        return zzs().toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final byte zza(int i) {
        zzbvv.zzb(this.zzd[this.zzc.length - 1], i, 1L);
        int iZza = zzbwz.zza(this, i);
        int i2 = iZza == 0 ? 0 : this.zzd[iZza - 1];
        int[] iArr = this.zzd;
        byte[][] bArr = this.zzc;
        return bArr[iZza][(i - i2) + iArr[bArr.length + iZza]];
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final int zzc() {
        return this.zzd[this.zzc.length - 1];
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final String zze() {
        return zzs().zze();
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final zzbwf zzg() {
        return zzs().zzg();
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final void zzj(zzbwb buffer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iZza = zzbwz.zza(this, 0);
        int i4 = 0;
        while (i4 < i2) {
            if (iZza == 0) {
                iZza = 0;
                i3 = 0;
            } else {
                i3 = this.zzd[iZza - 1];
            }
            int[] iArr = this.zzd;
            int i5 = iArr[iZza] - i3;
            int i6 = iArr[this.zzc.length + iZza];
            int iMin = Math.min(i2, i5 + i3) - i4;
            int i7 = i6 + (i4 - i3);
            zzbwn zzbwnVar = new zzbwn(this.zzc[iZza], i7, i7 + iMin, true, false);
            zzbwn zzbwnVar2 = buffer.zza;
            if (zzbwnVar2 == null) {
                zzbwnVar.zzh = zzbwnVar;
                zzbwnVar.zzg = zzbwnVar.zzh;
                buffer.zza = zzbwnVar.zzg;
            } else {
                Intrinsics.checkNotNull(zzbwnVar2);
                zzbwn zzbwnVar3 = zzbwnVar2.zzh;
                Intrinsics.checkNotNull(zzbwnVar3);
                zzbwnVar3.zzb(zzbwnVar);
            }
            i4 += iMin;
            iZza++;
        }
        buffer.zzE(buffer.zzg() + i2);
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final boolean zzk(int i, zzbwf other, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(other, "other");
        if (zzc() - i3 < 0) {
            return false;
        }
        int iZza = zzbwz.zza(this, 0);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            if (iZza == 0) {
                iZza = 0;
                i4 = 0;
            } else {
                i4 = this.zzd[iZza - 1];
            }
            int[] iArr = this.zzd;
            int i7 = iArr[iZza] - i4;
            int i8 = iArr[this.zzc.length + iZza];
            int iMin = Math.min(i3, i7 + i4) - i5;
            if (!other.zzl(i6, this.zzc[iZza], i8 + (i5 - i4), iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iZza++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final boolean zzl(int i, byte[] other, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > zzc() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int iZza = zzbwz.zza(this, i);
        while (i < i5) {
            if (iZza == 0) {
                iZza = 0;
                i4 = 0;
            } else {
                i4 = this.zzd[iZza - 1];
            }
            int[] iArr = this.zzd;
            int i6 = iArr[iZza] - i4;
            int i7 = iArr[this.zzc.length + iZza];
            int iMin = Math.min(i5, i6 + i4) - i;
            if (!zzbvv.zzc(this.zzc[iZza], i7 + (i - i4), other, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iZza++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final byte[] zzo() {
        return zzp();
    }

    @Override // com.google.android.libraries.places.internal.zzbwf
    public final byte[] zzp() {
        byte[] bArr = new byte[zzc()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[][] bArr2 = this.zzc;
            int length = bArr2.length;
            if (i >= length) {
                return bArr;
            }
            int[] iArr = this.zzd;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(bArr2[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
    }

    public final int[] zzq() {
        return this.zzd;
    }

    public final byte[][] zzr() {
        return this.zzc;
    }
}
