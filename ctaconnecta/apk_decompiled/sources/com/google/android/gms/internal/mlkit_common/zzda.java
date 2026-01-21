package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzda implements Callable {
    static final Callable zza = new zzda();

    private zzda() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LibraryVersion.getInstance().getVersion("common");
    }
}
