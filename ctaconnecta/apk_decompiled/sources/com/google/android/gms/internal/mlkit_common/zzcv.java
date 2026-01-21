package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzcv implements zzdb.zza {
    private final Provider<Transport<zzaa.zzad>> zzc;
    private static final GmsLogger zzb = new GmsLogger("FirelogLoggingTransport", "");
    public static final Component<?> zza = Component.builder(zzcv.class).add(Dependency.required((Class<?>) Context.class)).factory(zzcw.zza).build();

    public zzcv(final Context context) {
        this.zzc = new Lazy(new Provider(context) { // from class: com.google.android.gms.internal.mlkit_common.zzcu
            private final Context zza;

            {
                this.zza = context;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return zzcv.zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdb.zza
    public final void zza(zzaa.zzad zzadVar) {
        GmsLogger gmsLogger = zzb;
        String strValueOf = String.valueOf(zzadVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 30);
        sb.append("Logging FirebaseMlSdkLogEvent ");
        sb.append(strValueOf);
        gmsLogger.d("FirelogLoggingTransport", sb.toString());
        this.zzc.get().send(Event.ofData(zzadVar));
    }

    static final /* synthetic */ Transport zza(Context context) {
        TransportRuntime.initialize(context);
        return TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("FIREBASE_ML_SDK", zzaa.zzad.class, zzcx.zza);
    }
}
