package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgd implements zzge {
    zzgd() {
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final zzgc<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final Map<?, ?> zzb(Object obj) {
        return (zzgb) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final Object zzc(Object obj) {
        ((zzgb) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final Object zza(Object obj, Object obj2) {
        zzgb zzgbVarZza = (zzgb) obj;
        zzgb zzgbVar = (zzgb) obj2;
        if (!zzgbVar.isEmpty()) {
            if (!zzgbVarZza.zzc()) {
                zzgbVarZza = zzgbVarZza.zza();
            }
            zzgbVarZza.zza(zzgbVar);
        }
        return zzgbVarZza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final int zza(int i, Object obj, Object obj2) {
        zzgb zzgbVar = (zzgb) obj;
        if (zzgbVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgbVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
