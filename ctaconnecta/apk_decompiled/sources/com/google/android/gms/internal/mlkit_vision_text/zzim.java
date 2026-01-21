package com.google.android.gms.internal.mlkit_vision_text;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzim extends RuntimeException {
    private final List<String> zza;

    public zzim(zzhg zzhgVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }
}
