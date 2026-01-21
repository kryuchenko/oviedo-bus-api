package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzew implements Comparator<zzeu> {
    zzew() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzeu zzeuVar, zzeu zzeuVar2) {
        zzeu zzeuVar3 = zzeuVar;
        zzeu zzeuVar4 = zzeuVar2;
        zzfd zzfdVar = (zzfd) zzeuVar3.iterator();
        zzfd zzfdVar2 = (zzfd) zzeuVar4.iterator();
        while (zzfdVar.hasNext() && zzfdVar2.hasNext()) {
            int iCompare = Integer.compare(zzeu.zzb(zzfdVar.zza()), zzeu.zzb(zzfdVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzeuVar3.zza(), zzeuVar4.zza());
    }
}
