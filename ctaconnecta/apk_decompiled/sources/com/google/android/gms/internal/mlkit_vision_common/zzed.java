package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzed extends zzea<zzek.zzf> {
    zzed() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    final boolean zza(zzfv zzfvVar) {
        return zzfvVar instanceof zzek.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    final zzef<zzek.zzf> zza(Object obj) {
        return ((zzek.zzc) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    final zzef<zzek.zzf> zzb(Object obj) {
        zzek.zzc zzcVar = (zzek.zzc) obj;
        if (zzcVar.zzc.zzc()) {
            zzcVar.zzc = (zzef) zzcVar.zzc.clone();
        }
        return zzcVar.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    final int zza(Map.Entry<?, ?> entry) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    final void zza(zzhu zzhuVar, Map.Entry<?, ?> entry) throws IOException {
        throw new NoSuchMethodError();
    }
}
