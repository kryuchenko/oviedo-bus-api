package com.google.android.gms.internal.mlkit_common;

import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzn<E> extends zzl<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzl zzc;

    zzn(zzl zzlVar, int i, int i2) {
        this.zzc = zzlVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzm
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzi.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzl
    /* renamed from: zza */
    public final zzl<E> subList(int i, int i2) {
        zzi.zza(i, i2, this.zzb);
        zzl zzlVar = this.zzc;
        int i3 = this.zza;
        return (zzl) zzlVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzl, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
