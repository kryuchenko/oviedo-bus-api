package com.google.android.gms.internal.vision;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzcs<T> implements Serializable {
    public static <T> zzcs<T> zzby() {
        return zzcp.zzls;
    }

    public abstract T get();

    public abstract boolean isPresent();

    public static <T> zzcs<T> zzc(T t) {
        return new zzcx(zzcy.checkNotNull(t));
    }

    zzcs() {
    }
}
