package com.google.android.libraries.places.internal;

import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbqg {
    final zzbbo zza;

    @Nullable
    final Object zzb;

    public zzbqg(zzbbo zzbboVar, @Nullable Object obj) {
        this.zza = zzbboVar;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbqg zzbqgVar = (zzbqg) obj;
            if (zzmo.zza(this.zza, zzbqgVar.zza) && zzmo.zza(this.zzb, zzbqgVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzmm zzmmVarZzb = zzmn.zzb(this);
        zzmmVarZzb.zzd("provider", this.zza);
        zzmmVarZzb.zzd("config", this.zzb);
        return zzmmVarZzb.toString();
    }
}
