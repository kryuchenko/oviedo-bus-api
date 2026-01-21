package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzfo implements Comparator<zzfm> {
    zzfo() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzfm zzfmVar, zzfm zzfmVar2) {
        zzfm zzfmVar3 = zzfmVar;
        zzfm zzfmVar4 = zzfmVar2;
        zzfv zzfvVar = (zzfv) zzfmVar3.iterator();
        zzfv zzfvVar2 = (zzfv) zzfmVar4.iterator();
        while (zzfvVar.hasNext() && zzfvVar2.hasNext()) {
            int iCompare = Integer.compare(zzfm.zza(zzfvVar.nextByte()), zzfm.zza(zzfvVar2.nextByte()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzfmVar3.size(), zzfmVar4.size());
    }
}
