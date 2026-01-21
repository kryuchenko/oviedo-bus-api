package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzec extends WeakReference<Throwable> {
    private final int zzmv;

    public zzec(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzmv = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zzmv;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzec zzecVar = (zzec) obj;
            if (this.zzmv == zzecVar.zzmv && get() == zzecVar.get()) {
                return true;
            }
        }
        return false;
    }
}
