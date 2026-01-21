package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzco implements zzcq.zza {
    public static final Component<?> zza = Component.builder(zzcq.zza.class).add(Dependency.required((Class<?>) zzck.class)).add(Dependency.required((Class<?>) zzcj.class)).factory(zzcr.zza).build();
    private final zzck zzb;
    private final zzcj zzc;

    public zzco(zzck zzckVar, zzcj zzcjVar) {
        this.zzb = zzckVar;
        this.zzc = zzcjVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzcq.zza
    public final void zza(zzr.zzad zzadVar) {
        this.zzc.zza((zzr.zzad) ((zzek) zzr.zzad.zza(zzadVar).zza(zzr.zzbg.zza(zzadVar.zza()).zza(true)).zzg()));
    }
}
