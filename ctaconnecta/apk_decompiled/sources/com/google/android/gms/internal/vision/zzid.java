package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzid implements zzia {
    zzid() {
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Map<?, ?> zzl(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final zzhy<?, ?> zzq(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Map<?, ?> zzm(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final boolean zzn(Object obj) {
        return !((zzib) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzo(Object obj) {
        ((zzib) obj).zzdq();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzp(Object obj) {
        return zzib.zzhd().zzhe();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzc(Object obj, Object obj2) {
        zzib zzibVarZzhe = (zzib) obj;
        zzib zzibVar = (zzib) obj2;
        if (!zzibVar.isEmpty()) {
            if (!zzibVarZzhe.isMutable()) {
                zzibVarZzhe = zzibVarZzhe.zzhe();
            }
            zzibVarZzhe.zza(zzibVar);
        }
        return zzibVarZzhe;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final int zzb(int i, Object obj, Object obj2) {
        zzib zzibVar = (zzib) obj;
        if (zzibVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzibVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
