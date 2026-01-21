package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Comparator;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzdl implements Comparator<zzdj> {
    zzdl() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdj zzdjVar, zzdj zzdjVar2) {
        zzdj zzdjVar3 = zzdjVar;
        zzdj zzdjVar4 = zzdjVar2;
        zzdo zzdoVar = (zzdo) zzdjVar3.iterator();
        zzdo zzdoVar2 = (zzdo) zzdjVar4.iterator();
        while (zzdoVar.hasNext() && zzdoVar2.hasNext()) {
            int iCompare = Integer.compare(zzdj.zzb(zzdoVar.zza()), zzdj.zzb(zzdoVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzdjVar3.zza(), zzdjVar4.zza());
    }
}
