package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzak<E> extends zzf<E> {
    private final zzal<E> zza;

    zzak(zzal<E> zzalVar, int i) {
        super(zzalVar.size(), i);
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzf
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
