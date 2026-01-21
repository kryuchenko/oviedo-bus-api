package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfr implements zzfo {
    zzfr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final zzfm<?, ?> zzc(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final Map<?, ?> zza(Object obj) {
        return (zzfp) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final Object zzb(Object obj) {
        ((zzfp) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final Object zza(Object obj, Object obj2) {
        zzfp zzfpVarZza = (zzfp) obj;
        zzfp zzfpVar = (zzfp) obj2;
        if (!zzfpVar.isEmpty()) {
            if (!zzfpVarZza.zzc()) {
                zzfpVarZza = zzfpVarZza.zza();
            }
            zzfpVarZza.zza(zzfpVar);
        }
        return zzfpVarZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfo
    public final int zza(int i, Object obj, Object obj2) {
        zzfp zzfpVar = (zzfp) obj;
        if (zzfpVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzfpVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
