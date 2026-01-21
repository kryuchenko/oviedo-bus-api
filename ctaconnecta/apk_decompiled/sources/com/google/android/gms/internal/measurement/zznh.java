package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zznh implements zzni {
    private static final zzgz<Long> zza;

    @Override // com.google.android.gms.internal.measurement.zzni
    public final long zza() {
        return zza.zza().longValue();
    }

    static {
        zzhh zzhhVarZza = new zzhh(zzgw.zza("com.google.android.gms.measurement")).zzb().zza();
        zzhhVarZza.zza("measurement.client.consent_state_v1", true);
        zzhhVarZza.zza("measurement.client.3p_consent_state_v1", true);
        zzhhVarZza.zza("measurement.service.consent_state_v1_W36", true);
        zza = zzhhVarZza.zza("measurement.service.storage_consent_support_version", 203600L);
    }
}
