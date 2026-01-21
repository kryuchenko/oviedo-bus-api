package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzfh extends IOException {
    private zzgh zza;

    public zzfh(String str) {
        super(str);
        this.zza = null;
    }

    static zzfk zza() {
        return new zzfk("Protocol message tag had invalid wire type.");
    }
}
