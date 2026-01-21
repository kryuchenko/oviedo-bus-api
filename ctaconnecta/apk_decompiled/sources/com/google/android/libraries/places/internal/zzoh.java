package com.google.android.libraries.places.internal;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzoh {
    public static List zza(List list, zzmd zzmdVar) {
        return list instanceof RandomAccess ? new zzoe(list, zzmdVar) : new zzog(list, zzmdVar);
    }
}
