package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
abstract class zzhr {
    private static final zzhr zzyt;
    private static final zzhr zzyu;

    private zzhr() {
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zzhr zzha() {
        return zzyt;
    }

    static zzhr zzhb() {
        return zzyu;
    }

    static {
        zzhq zzhqVar = null;
        zzyt = new zzht();
        zzyu = new zzhs();
    }
}
