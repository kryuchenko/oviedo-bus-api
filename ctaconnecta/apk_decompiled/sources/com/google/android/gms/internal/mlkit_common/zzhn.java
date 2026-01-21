package com.google.android.gms.internal.mlkit_common;

import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzhn extends RuntimeException {
    private final List<String> zza;

    public zzhn(zzgh zzghVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }
}
