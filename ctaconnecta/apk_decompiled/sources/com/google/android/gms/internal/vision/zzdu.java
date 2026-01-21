package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdu extends zzdk<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzmk;

    zzdu(Object[] objArr, int i, int i2) {
        this.zzmk = objArr;
        this.offset = i;
        this.size = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzcy.zzd(i, this.size);
        return this.zzmk[(i * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }
}
