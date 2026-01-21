package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes3.dex */
final class zzkc implements zzkd {
    private static <E> zzjt<E> zzc(Object obj, long j) {
        return (zzjt) zzmg.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final <L> List<L> zza(Object obj, long j) {
        zzjt zzjtVarZzc = zzc(obj, j);
        if (zzjtVarZzc.zzc()) {
            return zzjtVarZzc;
        }
        int size = zzjtVarZzc.size();
        zzjt zzjtVarZza = zzjtVarZzc.zza(size == 0 ? 10 : size << 1);
        zzmg.zza(obj, j, zzjtVarZza);
        return zzjtVarZza;
    }

    zzkc() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzjt zzjtVarZzc = zzc(obj, j);
        zzjt zzjtVarZzc2 = zzc(obj2, j);
        int size = zzjtVarZzc.size();
        int size2 = zzjtVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzjtVarZzc.zzc()) {
                zzjtVarZzc = zzjtVarZzc.zza(size2 + size);
            }
            zzjtVarZzc.addAll(zzjtVarZzc2);
        }
        if (size > 0) {
            zzjtVarZzc2 = zzjtVarZzc;
        }
        zzmg.zza(obj, j, zzjtVarZzc2);
    }
}
