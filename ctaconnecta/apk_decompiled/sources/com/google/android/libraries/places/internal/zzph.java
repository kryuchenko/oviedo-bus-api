package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzph {
    private final Map zza = new HashMap();

    private zzph() {
    }

    public final zzpd zza() {
        return new zzpf(this, this.zza, (char) 0, CharCompanionObject.MAX_VALUE);
    }

    public final zzph zzb(char c, String str) {
        this.zza.put(Character.valueOf(c), str);
        return this;
    }

    /* synthetic */ zzph(zzpg zzpgVar) {
    }
}
