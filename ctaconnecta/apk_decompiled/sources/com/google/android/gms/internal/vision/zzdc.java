package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzdc {
    public static <T> zzcz<T> zza(zzcz<T> zzczVar) {
        return ((zzczVar instanceof zzde) || (zzczVar instanceof zzdb)) ? zzczVar : zzczVar instanceof Serializable ? new zzdb(zzczVar) : new zzde(zzczVar);
    }

    public static <T> zzcz<T> zze(@NullableDecl T t) {
        return new zzdd(t);
    }
}
