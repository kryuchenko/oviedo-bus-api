package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzka implements zznr {
    private final /* synthetic */ zziv zza;

    zzka(zziv zzivVar) {
        this.zza = zzivVar;
    }

    @Override // com.google.android.gms.measurement.internal.zznr
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, bundle);
        } else {
            this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, bundle, str);
        }
    }
}
