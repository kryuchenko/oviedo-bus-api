package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdd<T> implements zzcz<T>, Serializable {

    @NullableDecl
    private final T zzlx;

    zzdd(@NullableDecl T t) {
        this.zzlx = t;
    }

    @Override // com.google.android.gms.internal.vision.zzcz
    public final T get() {
        return this.zzlx;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdd) {
            return zzct.equal(this.zzlx, ((zzdd) obj).zzlx);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzlx});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzlx);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
