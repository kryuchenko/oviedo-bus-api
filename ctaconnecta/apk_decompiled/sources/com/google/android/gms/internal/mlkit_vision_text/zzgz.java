package com.google.android.gms.internal.mlkit_vision_text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgz implements zzhh {
    private zzhh[] zza;

    zzgz(zzhh... zzhhVarArr) {
        this.zza = zzhhVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhh
    public final boolean zza(Class<?> cls) {
        for (zzhh zzhhVar : this.zza) {
            if (zzhhVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhh
    public final zzhe zzb(Class<?> cls) {
        for (zzhh zzhhVar : this.zza) {
            if (zzhhVar.zza(cls)) {
                return zzhhVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
