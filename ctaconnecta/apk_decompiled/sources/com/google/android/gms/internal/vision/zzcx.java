package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzcx<T> extends zzcs<T> {
    private final T zzlu;

    zzcx(T t) {
        this.zzlu = t;
    }

    @Override // com.google.android.gms.internal.vision.zzcs
    public final boolean isPresent() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzcs
    public final T get() {
        return this.zzlu;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzcx) {
            return this.zzlu.equals(((zzcx) obj).zzlu);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzlu.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzlu);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
