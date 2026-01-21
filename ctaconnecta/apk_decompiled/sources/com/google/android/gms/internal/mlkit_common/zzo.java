package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzo<E> extends zzk<E> {
    private final zzl<E> zza;

    zzo(zzl<E> zzlVar, int i) {
        super(zzlVar.size(), i);
        this.zza = zzlVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzk
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
