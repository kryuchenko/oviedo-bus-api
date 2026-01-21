package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzde<T> implements zzcz<T> {

    @NullableDecl
    private T value;
    private volatile zzcz<T> zzlv;
    private volatile boolean zzlw;

    zzde(zzcz<T> zzczVar) {
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
                    this.zzlv = null;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object string = this.zzlv;
        if (string == null) {
            String strValueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
