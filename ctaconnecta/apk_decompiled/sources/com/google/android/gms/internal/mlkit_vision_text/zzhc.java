package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhc implements zzhd {
    zzhc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhd
    public final zzhb<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhd
    public final Map<?, ?> zzb(Object obj) {
        return (zzha) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhd
    public final Object zzc(Object obj) {
        ((zzha) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhd
    public final Object zza(Object obj, Object obj2) {
        zzha zzhaVarZza = (zzha) obj;
        zzha zzhaVar = (zzha) obj2;
        if (!zzhaVar.isEmpty()) {
            if (!zzhaVarZza.zzc()) {
                zzhaVarZza = zzhaVarZza.zza();
            }
            zzhaVarZza.zza(zzhaVar);
        }
        return zzhaVarZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhd
    public final int zza(int i, Object obj, Object obj2) {
        zzha zzhaVar = (zzha) obj;
        if (zzhaVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzhaVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
