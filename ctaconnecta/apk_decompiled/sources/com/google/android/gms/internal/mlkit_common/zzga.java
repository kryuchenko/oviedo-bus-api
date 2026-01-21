package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzga implements zzgi {
    private zzgi[] zza;

    zzga(zzgi... zzgiVarArr) {
        this.zza = zzgiVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final boolean zza(Class<?> cls) {
        for (zzgi zzgiVar : this.zza) {
            if (zzgiVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final zzgf zzb(Class<?> cls) {
        for (zzgi zzgiVar : this.zza) {
            if (zzgiVar.zza(cls)) {
                return zzgiVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
