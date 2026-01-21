package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbmj {

    @Nullable
    private final zzbmg zza;
    private final Map zzb;
    private final Map zzc;

    @Nullable
    private final zzbpn zzd;

    @Nullable
    private final Object zze;

    @Nullable
    private final Map zzf;

    zzbmj(@Nullable zzbmg zzbmgVar, Map map, Map map2, @Nullable zzbpn zzbpnVar, @Nullable Object obj, @Nullable Map map3) {
        this.zza = zzbmgVar;
        this.zzb = Collections.unmodifiableMap(new HashMap(map));
        this.zzc = Collections.unmodifiableMap(new HashMap(map2));
        this.zzd = zzbpnVar;
        this.zze = obj;
        this.zzf = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbmj zzbmjVar = (zzbmj) obj;
            if (zzmo.zza(this.zza, zzbmjVar.zza) && zzmo.zza(this.zzb, zzbmjVar.zzb) && zzmo.zza(this.zzc, zzbmjVar.zzc) && zzmo.zza(this.zzd, zzbmjVar.zzd) && zzmo.zza(this.zze, zzbmjVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        zzmm zzmmVarZzb = zzmn.zzb(this);
        zzmmVarZzb.zzd("defaultMethodConfig", this.zza);
        zzmmVarZzb.zzd("serviceMethodMap", this.zzb);
        zzmmVarZzb.zzd("serviceMap", this.zzc);
        zzmmVarZzb.zzd("retryThrottling", this.zzd);
        zzmmVarZzb.zzd("loadBalancingConfig", this.zze);
        return zzmmVarZzb.toString();
    }

    @Nullable
    final zzbam zza() {
        if (this.zzc.isEmpty() && this.zzb.isEmpty() && this.zza == null) {
            return null;
        }
        return new zzbmi(this, null);
    }

    @Nullable
    final zzbmg zzb(zzbcl zzbclVar) {
        zzbmg zzbmgVar = (zzbmg) this.zzb.get(zzbclVar.zzf());
        if (zzbmgVar == null) {
            zzbmgVar = (zzbmg) this.zzc.get(zzbclVar.zzg());
        }
        return zzbmgVar == null ? this.zza : zzbmgVar;
    }

    @Nullable
    final zzbpn zzc() {
        return this.zzd;
    }

    @Nullable
    final Object zzd() {
        return this.zze;
    }

    @Nullable
    final Map zze() {
        return this.zzf;
    }
}
