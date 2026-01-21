package com.google.android.libraries.places.api.net;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class IsOpenResponse {
    public static IsOpenResponse newInstance(Boolean bool) {
        return new zzx(bool);
    }

    public abstract Boolean isOpen();
}
