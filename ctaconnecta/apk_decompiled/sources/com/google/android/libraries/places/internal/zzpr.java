package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class zzpr {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzpr(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzpr zza(String str, Class cls) {
        return new zzpr(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + RemoteSettings.FORWARD_SLASH_STRING + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzpr(String str, Class cls, boolean z, boolean z2) {
        zzrr.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
