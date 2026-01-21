package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdj<E> extends zzdg<E> {
    private final zzdk<E> zzlz;

    zzdj(zzdk<E> zzdkVar, int i) {
        super(zzdkVar.size(), i);
        this.zzlz = zzdkVar;
    }

    @Override // com.google.android.gms.internal.vision.zzdg
    protected final E get(int i) {
        return this.zzlz.get(i);
    }
}
