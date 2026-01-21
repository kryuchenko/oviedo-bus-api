package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzcz implements zzdb.zza {
    public static final Component<?> zza = Component.builder(zzdb.zza.class).add(Dependency.required((Class<?>) zzcv.class)).add(Dependency.required((Class<?>) zzct.class)).factory(zzcy.zza).build();
    private final zzcv zzb;
    private final zzct zzc;

    public zzcz(zzcv zzcvVar, zzct zzctVar) {
        this.zzb = zzcvVar;
        this.zzc = zzctVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdb.zza
    public final void zza(zzaa.zzad zzadVar) {
        this.zzc.zza((zzaa.zzad) ((zzez) zzaa.zzad.zza(zzadVar).zza(zzaa.zzbg.zza(zzadVar.zza()).zza(true)).zzh()));
    }
}
