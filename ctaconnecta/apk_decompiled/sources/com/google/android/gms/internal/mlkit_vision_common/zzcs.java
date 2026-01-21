package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcs implements Callable {
    private final SharedPrefManager zza;

    private zzcs(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    static Callable zza(SharedPrefManager sharedPrefManager) {
        return new zzcs(sharedPrefManager);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
