package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzq<E> extends zzl<E> {
    static final zzl<Object> zza = new zzq(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzq(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    final int zzc() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzl, com.google.android.gms.internal.mlkit_common.zzm
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzi.zza(i, this.zzc);
        return (E) this.zzb[i];
    }
}
