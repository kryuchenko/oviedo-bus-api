package com.google.android.gms.internal.mlkit_vision_common;

import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzhb extends RuntimeException {
    private final List<String> zza;

    public zzhb(zzfv zzfvVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }
}
