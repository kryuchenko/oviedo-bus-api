package com.google.android.gms.internal.mlkit_common;

import java.util.Comparator;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzdx implements Comparator<zzdv> {
    zzdx() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdv zzdvVar, zzdv zzdvVar2) {
        zzdv zzdvVar3 = zzdvVar;
        zzdv zzdvVar4 = zzdvVar2;
        zzee zzeeVar = (zzee) zzdvVar3.iterator();
        zzee zzeeVar2 = (zzee) zzdvVar4.iterator();
        while (zzeeVar.hasNext() && zzeeVar2.hasNext()) {
            int iCompare = Integer.compare(zzdv.zzb(zzeeVar.zza()), zzdv.zzb(zzeeVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzdvVar3.zza(), zzdvVar4.zza());
    }
}
