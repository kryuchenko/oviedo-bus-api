package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzdb<T> implements zzcz<T>, Serializable {

    @NullableDecl
    private transient T value;
    private final zzcz<T> zzlv;
    private volatile transient boolean zzlw;

    zzdb(zzcz<T> zzczVar) {
        this.zzlv = (zzcz) zzcy.checkNotNull(zzczVar);
    }

    @Override // com.google.android.gms.internal.vision.zzcz
    public final T get() {
        if (!this.zzlw) {
            synchronized (this) {
                if (!this.zzlw) {
                    T t = this.zzlv.get();
                    this.value = t;
                    this.zzlw = true;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object string;
        if (this.zzlw) {
            String strValueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.zzlv;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
