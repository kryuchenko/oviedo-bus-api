package com.google.android.gms.internal.mlkit_vision_common;

import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzj<E> extends zzh<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzh zzc;

    zzj(zzh zzhVar, int i, int i2) {
        this.zzc = zzhVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzd.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzh
    /* renamed from: zza */
    public final zzh<E> subList(int i, int i2) {
        zzd.zza(i, i2, this.zzb);
        zzh zzhVar = this.zzc;
        int i3 = this.zza;
        return (zzh) zzhVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzh, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
