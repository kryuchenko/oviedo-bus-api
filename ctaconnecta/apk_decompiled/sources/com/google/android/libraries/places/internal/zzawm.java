package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzawm extends RuntimeException {
    public zzawm(zzavf zzavfVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzauf zza() {
        return new zzauf(getMessage());
    }
}
