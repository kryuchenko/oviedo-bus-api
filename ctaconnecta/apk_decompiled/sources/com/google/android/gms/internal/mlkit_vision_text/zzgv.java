package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgv extends zzgq {
    private zzgv() {
        super();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgq
    final void zza(Object obj, long j) {
        zzb(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzgq
    final <E> void zza(Object obj, Object obj2, long j) {
        zzgh zzghVarZzb = zzb(obj, j);
        zzgh zzghVarZzb2 = zzb(obj2, j);
        int size = zzghVarZzb.size();
        int size2 = zzghVarZzb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzghVarZzb.zza()) {
                zzghVarZzb = zzghVarZzb.zzb(size2 + size);
            }
            zzghVarZzb.addAll(zzghVarZzb2);
        }
        if (size > 0) {
            zzghVarZzb2 = zzghVarZzb;
        }
        zziv.zza(obj, j, zzghVarZzb2);
    }

    private static <E> zzgh<E> zzb(Object obj, long j) {
        return (zzgh) zziv.zzf(obj, j);
    }
}
