package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzc implements OnFailureListener {
    static final OnFailureListener zza = new zzc();

    private zzc() {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        MobileVisionBase.zza.e("MobileVisionBase", "Error preloading model resource", exc);
    }
}
