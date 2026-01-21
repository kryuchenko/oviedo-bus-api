package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfg extends zzff {
    private zzfg() {
        super();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzff
    final void zza(Object obj, long j) {
        zzb(obj, j).b_();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzff
    final <E> void zza(Object obj, Object obj2, long j) {
        zzes zzesVarZzb = zzb(obj, j);
        zzes zzesVarZzb2 = zzb(obj2, j);
        int size = zzesVarZzb.size();
        int size2 = zzesVarZzb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzesVarZzb.zza()) {
                zzesVarZzb = zzesVarZzb.zzb(size2 + size);
            }
            zzesVarZzb.addAll(zzesVarZzb2);
        }
        if (size > 0) {
            zzesVarZzb2 = zzesVarZzb;
        }
        zzhg.zza(obj, j, zzesVarZzb2);
    }

    private static <E> zzes<E> zzb(Object obj, long j) {
        return (zzes) zzhg.zzf(obj, j);
    }
}
