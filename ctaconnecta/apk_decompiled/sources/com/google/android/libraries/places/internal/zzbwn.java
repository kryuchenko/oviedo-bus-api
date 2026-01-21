package com.google.android.libraries.places.internal;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwn {
    public static final zzbwm zza = new zzbwm(null);
    public final byte[] zzb;
    public int zzc;
    public int zzd;
    public boolean zze;
    public final boolean zzf;
    public zzbwn zzg;
    public zzbwn zzh;

    public zzbwn() {
        this.zzb = new byte[8192];
        this.zzf = true;
        this.zze = false;
    }

    public zzbwn(byte[] data, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.zzb = data;
        this.zzc = i;
        this.zzd = i2;
        this.zze = z;
        this.zzf = false;
    }

    public final zzbwn zza() {
        zzbwn zzbwnVar = this.zzg;
        if (zzbwnVar == this) {
            zzbwnVar = null;
        }
        zzbwn zzbwnVar2 = this.zzh;
        Intrinsics.checkNotNull(zzbwnVar2);
        zzbwnVar2.zzg = this.zzg;
        zzbwn zzbwnVar3 = this.zzg;
        Intrinsics.checkNotNull(zzbwnVar3);
        zzbwnVar3.zzh = this.zzh;
        this.zzg = null;
        this.zzh = null;
        return zzbwnVar;
    }

    public final zzbwn zzb(zzbwn segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.zzh = this;
        segment.zzg = this.zzg;
        zzbwn zzbwnVar = this.zzg;
        Intrinsics.checkNotNull(zzbwnVar);
        zzbwnVar.zzh = segment;
        this.zzg = segment;
        return segment;
    }

    public final zzbwn zzc() {
        this.zze = true;
        return new zzbwn(this.zzb, this.zzc, this.zzd, true, false);
    }

    public final void zze(zzbwn sink, int i) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.zzf) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = sink.zzd;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (sink.zze) {
                throw new IllegalArgumentException();
            }
            int i4 = sink.zzc;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.zzb;
            ArraysKt.copyInto$default(bArr, bArr, 0, i4, i2, 2, (Object) null);
            i2 = sink.zzd - sink.zzc;
            sink.zzd = i2;
            sink.zzc = 0;
        }
        byte[] bArr2 = this.zzb;
        byte[] bArr3 = sink.zzb;
        int i5 = this.zzc;
        ArraysKt.copyInto(bArr2, bArr3, i2, i5, i5 + i);
        sink.zzd += i;
        this.zzc += i;
    }

    public final zzbwn zzd(int i) {
        zzbwn zzbwnVarZza;
        if (i > this.zzd - this.zzc) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i >= 1024) {
            zzbwnVarZza = zzc();
        } else {
            byte[] bArr = this.zzb;
            zzbwnVarZza = zzbwo.zza();
            byte[] bArr2 = zzbwnVarZza.zzb;
            int i2 = this.zzc;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i2, i2 + i, 2, (Object) null);
        }
        zzbwnVarZza.zzd = zzbwnVarZza.zzc + i;
        this.zzc += i;
        zzbwn zzbwnVar = this.zzh;
        Intrinsics.checkNotNull(zzbwnVar);
        zzbwnVar.zzb(zzbwnVarZza);
        return zzbwnVarZza;
    }
}
