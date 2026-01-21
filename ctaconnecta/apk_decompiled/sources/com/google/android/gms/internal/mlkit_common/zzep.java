package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzep extends zzeq<zzez.zzd> {
    zzep() {
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    final boolean zza(zzgh zzghVar) {
        return zzghVar instanceof zzez.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    final zzer<zzez.zzd> zza(Object obj) {
        return ((zzez.zze) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    final zzer<zzez.zzd> zzb(Object obj) {
        zzez.zze zzeVar = (zzez.zze) obj;
        if (zzeVar.zzc.zzc()) {
            zzeVar.zzc = (zzer) zzeVar.zzc.clone();
        }
        return zzeVar.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    final int zza(Map.Entry<?, ?> entry) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    final void zza(zzik zzikVar, Map.Entry<?, ?> entry) throws IOException {
        throw new NoSuchMethodError();
    }
}
