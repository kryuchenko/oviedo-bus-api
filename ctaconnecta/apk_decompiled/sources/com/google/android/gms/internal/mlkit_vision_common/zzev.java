package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzev extends IOException {
    private zzfv zza;

    public zzev(String str) {
        super(str);
        this.zza = null;
    }

    static zzeu zza() {
        return new zzeu("Protocol message tag had invalid wire type.");
    }
}
