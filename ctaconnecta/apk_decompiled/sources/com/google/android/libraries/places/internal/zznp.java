package com.google.android.libraries.places.internal;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
abstract class zznp implements Comparable, Serializable {
    final Comparable zza;

    zznp(Comparable comparable) {
        this.zza = comparable;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zznp) {
            try {
                if (compareTo((zznp) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public int compareTo(zznp zznpVar) {
        if (zznpVar != zznn.zzb) {
            if (zznpVar == zznl.zzb) {
                return -1;
            }
            Comparable comparable = this.zza;
            Comparable comparable2 = zznpVar.zza;
            int i = zzok.zzc;
            int iCompareTo = comparable.compareTo(comparable2);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            boolean z = this instanceof zznm;
            if (z == (zznpVar instanceof zznm)) {
                return 0;
            }
            if (!z) {
                return -1;
            }
        }
        return 1;
    }

    abstract void zzc(StringBuilder sb);

    abstract void zzd(StringBuilder sb);

    abstract boolean zze(Comparable comparable);
}
