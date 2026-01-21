package com.google.android.gms.internal.mlkit_vision_text;

import android.content.Context;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_text.zzbh;
import com.google.android.gms.internal.mlkit_vision_text.zzeg;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class zzea implements zzeg.zzb {
    private final Provider<Transport<zzbh.zzad>> zzc;
    private static final GmsLogger zzb = new GmsLogger("FirelogLoggingTransport", "");
    public static final Component<?> zza = Component.builder(zzea.class).add(Dependency.required((Class<?>) Context.class)).factory(zzeb.zza).build();

    public zzea(final Context context) {
        this.zzc = new Lazy(new Provider(context) { // from class: com.google.android.gms.internal.mlkit_vision_text.zzdz
            private final Context zza;

            {
                this.zza = context;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return zzea.zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzeg.zzb
    public final void zza(zzbh.zzad zzadVar) {
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
        return TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("FIREBASE_ML_SDK", zzbh.zzad.class, zzec.zza);
    }
}
