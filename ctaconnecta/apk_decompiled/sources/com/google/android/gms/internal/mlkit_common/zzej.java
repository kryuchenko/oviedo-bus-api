package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzej extends zzeh {
    private final byte[] zza;
    private final boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    private zzej(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzg = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzc = i2 + i;
        this.zze = i;
        this.zzf = i;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeh
    public final int zza(int i) throws zzfh {
        if (i < 0) {
            throw new zzfh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iZza = i + zza();
        int i2 = this.zzg;
        if (iZza > i2) {
            throw new zzfh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzg = iZza;
        int i3 = this.zzc + this.zzd;
        this.zzc = i3;
        int i4 = i3 - this.zzf;
        if (i4 > iZza) {
            int i5 = i4 - iZza;
            this.zzd = i5;
            this.zzc = i3 - i5;
            return i2;
        }
        this.zzd = 0;
        return i2;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeh
    public final int zza() {
        return this.zze - this.zzf;
    }
}
