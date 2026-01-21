package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzbh;
import com.google.android.gms.internal.mlkit_vision_text.zzeg;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzee implements zzeg.zzb {
    public static final Component<?> zza = Component.builder(zzeg.zzb.class).add(Dependency.required((Class<?>) zzea.class)).add(Dependency.required((Class<?>) zzdy.class)).factory(zzed.zza).build();
    private final zzea zzb;
    private final zzdy zzc;

    public zzee(zzea zzeaVar, zzdy zzdyVar) {
        this.zzb = zzeaVar;
        this.zzc = zzdyVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeg.zzb
    public final void zza(zzbh.zzad zzadVar) {
        this.zzc.zza((zzbh.zzad) ((zzfy) zzbh.zzad.zza(zzadVar).zza(zzbh.zzbg.zza(zzadVar.zza()).zza(true)).zzh()));
    }
}
