package com.google.android.gms.internal.mlkit_vision_text;

import com.google.mlkit.common.sdkinternal.LibraryVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzef implements Callable {
    static final Callable zza = new zzef();

    private zzef() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LibraryVersion.getInstance().getVersion("text-recognition");
    }
}
