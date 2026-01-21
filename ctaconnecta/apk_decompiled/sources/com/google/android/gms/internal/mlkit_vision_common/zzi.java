package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzi<E> extends zzh<E> {
    static final zzh<Object> zza = new zzi(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzi(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    final int zzc() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzh, com.google.android.gms.internal.mlkit_vision_common.zze
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
