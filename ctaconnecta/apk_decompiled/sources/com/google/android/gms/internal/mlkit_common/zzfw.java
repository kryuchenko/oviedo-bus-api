package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfw extends zzfr {
    private zzfw() {
        super();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfr
    final void zza(Object obj, long j) {
        zzb(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfr
    final <E> void zza(Object obj, Object obj2, long j) {
        zzfi zzfiVarZzb = zzb(obj, j);
        zzfi zzfiVarZzb2 = zzb(obj2, j);
        int size = zzfiVarZzb.size();
        int size2 = zzfiVarZzb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzfiVarZzb.zza()) {
                zzfiVarZzb = zzfiVarZzb.zzb(size2 + size);
            }
            zzfiVarZzb.addAll(zzfiVarZzb2);
        }
        if (size > 0) {
            zzfiVarZzb2 = zzfiVarZzb;
        }
        zzhw.zza(obj, j, zzfiVarZzb2);
    }

    private static <E> zzfi<E> zzb(Object obj, long j) {
        return (zzfi) zzhw.zzf(obj, j);
    }
}
