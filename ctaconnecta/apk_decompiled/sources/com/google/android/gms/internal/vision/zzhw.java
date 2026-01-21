package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzhw implements zzie {
    private zzie[] zzza;

    zzhw(zzie... zzieVarArr) {
        this.zzza = zzieVarArr;
    }

    @Override // com.google.android.gms.internal.vision.zzie
    public final boolean zza(Class<?> cls) {
        for (zzie zzieVar : this.zzza) {
            if (zzieVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzie
    public final zzif zzb(Class<?> cls) {
        for (zzie zzieVar : this.zzza) {
            if (zzieVar.zza(cls)) {
                return zzieVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
