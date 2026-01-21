package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbpp {
    final int zza;
    final long zzb;
    final long zzc;
    final double zzd;

    @Nullable
    final Long zze;
    final Set zzf;

    zzbpp(int i, long j, long j2, double d, @Nullable Long l, @Nonnull Set set) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = d;
        this.zze = l;
        this.zzf = zzob.zzj(set);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbpp)) {
            return false;
        }
        zzbpp zzbppVar = (zzbpp) obj;
        return this.zza == zzbppVar.zza && this.zzb == zzbppVar.zzb && this.zzc == zzbppVar.zzc && Double.compare(this.zzd, zzbppVar.zzd) == 0 && zzmo.zza(this.zze, zzbppVar.zze) && zzmo.zza(this.zzf, zzbppVar.zzf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), Double.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        zzmm zzmmVarZzb = zzmn.zzb(this);
        zzmmVarZzb.zzb("maxAttempts", this.zza);
        zzmmVarZzb.zzc("initialBackoffNanos", this.zzb);
        zzmmVarZzb.zzc("maxBackoffNanos", this.zzc);
        zzmmVarZzb.zza("backoffMultiplier", this.zzd);
        zzmmVarZzb.zzd("perAttemptRecvTimeoutNanos", this.zze);
        zzmmVarZzb.zzd("retryableStatusCodes", this.zzf);
        return zzmmVarZzb.toString();
    }
}
