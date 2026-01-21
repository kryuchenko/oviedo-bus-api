package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzg<E> extends zzf<E> {
    private final zzh<E> zza;

    zzg(zzh<E> zzhVar, int i) {
        super(zzhVar.size(), i);
        this.zza = zzhVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzf
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
