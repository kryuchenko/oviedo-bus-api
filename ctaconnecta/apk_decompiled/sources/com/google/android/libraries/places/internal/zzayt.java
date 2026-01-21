package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzayt {
    private static final zzayo zza = new zzayq();

    public static zzayk zza(zzayk zzaykVar, List list) {
        zzmt.zzc(zzaykVar, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzaykVar = new zzays(zzaykVar, (zzayp) it.next(), null);
        }
        return zzaykVar;
    }
}
