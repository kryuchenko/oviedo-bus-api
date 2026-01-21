package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzct implements Callable {
    static final Callable zza = new zzct();

    private zzct() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LibraryVersion.getInstance().getVersion("vision-common");
    }
}
