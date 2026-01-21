package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdn<E> extends zzdk<E> {
    static final zzdk<Object> zzmg = new zzdn(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzmh;

    zzdn(Object[] objArr, int i) {
        this.zzmh = objArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    final int zzcb() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    final Object[] zzca() {
        return this.zzmh;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    final int zzcc() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.vision.zzdk, com.google.android.gms.internal.vision.zzdh
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzmh, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzcy.zzd(i, this.size);
        return (E) this.zzmh[i];
    }
}
