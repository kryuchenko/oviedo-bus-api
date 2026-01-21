package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzaz<E> extends zzal<E> {
    static final zzal<Object> zza = new zzaz(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzaz(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzaj
    final int zzc() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzaj
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzaj
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzal, com.google.android.gms.internal.mlkit_vision_text.zzaj
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzd.zza(i, this.zzc);
        return (E) this.zzb[i];
    }
}
