package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfo extends zzfp<zzfy.zzd> {
    zzfo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfp
    final boolean zza(zzhg zzhgVar) {
        return zzhgVar instanceof zzfy.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfp
    final zzfq<zzfy.zzd> zza(Object obj) {
        return ((zzfy.zze) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfp
    final zzfq<zzfy.zzd> zzb(Object obj) {
        zzfy.zze zzeVar = (zzfy.zze) obj;
        if (zzeVar.zzc.zzc()) {
            zzeVar.zzc = (zzfq) zzeVar.zzc.clone();
        }
        return zzeVar.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfp
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfp
    final int zza(Map.Entry<?, ?> entry) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzfp
    final void zza(zzjj zzjjVar, Map.Entry<?, ?> entry) throws IOException {
        throw new NoSuchMethodError();
    }
}
