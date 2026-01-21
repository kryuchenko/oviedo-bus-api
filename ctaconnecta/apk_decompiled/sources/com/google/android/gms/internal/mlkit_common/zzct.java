package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzct implements zzdb.zza {
    private final ClearcutLogger zzc;
    private static final GmsLogger zzb = new GmsLogger("ClearcutTransport", "");
    public static final Component<?> zza = Component.builder(zzct.class).add(Dependency.required((Class<?>) Context.class)).factory(zzcs.zza).build();

    public zzct(Context context) {
        this.zzc = ClearcutLogger.anonymousLogger(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdb.zza
    public final void zza(zzaa.zzad zzadVar) {
        GmsLogger gmsLogger = zzb;
        String strValueOf = String.valueOf(zzadVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 30);
        sb.append("Logging FirebaseMlSdkLogEvent ");
        sb.append(strValueOf);
        gmsLogger.d("ClearcutTransport", sb.toString());
        try {
            this.zzc.newEvent(zzadVar.zzf()).log();
        } catch (SecurityException e) {
            zzb.e("ClearcutTransport", "Exception thrown from the logging side", e);
        }
    }
}
