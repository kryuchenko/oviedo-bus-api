package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzhs extends zzhr {
    private zzhs() {
        super();
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final <L> List<L> zza(Object obj, long j) {
        zzhe zzheVarZzc = zzc(obj, j);
        if (zzheVarZzc.zzdp()) {
            return zzheVarZzc;
        }
        int size = zzheVarZzc.size();
        zzhe zzheVarZzah = zzheVarZzc.zzah(size == 0 ? 10 : size << 1);
        zzju.zza(obj, j, zzheVarZzah);
        return zzheVarZzah;
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final void zzb(Object obj, long j) {
        zzc(obj, j).zzdq();
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final <E> void zza(Object obj, Object obj2, long j) {
        zzhe zzheVarZzc = zzc(obj, j);
        zzhe zzheVarZzc2 = zzc(obj2, j);
        int size = zzheVarZzc.size();
        int size2 = zzheVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzheVarZzc.zzdp()) {
                zzheVarZzc = zzheVarZzc.zzah(size2 + size);
            }
            zzheVarZzc.addAll(zzheVarZzc2);
        }
        if (size > 0) {
            zzheVarZzc2 = zzheVarZzc;
        }
        zzju.zza(obj, j, zzheVarZzc2);
    }

    private static <E> zzhe<E> zzc(Object obj, long j) {
        return (zzhe) zzju.zzp(obj, j);
    }
}
