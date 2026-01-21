package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjq extends zzjo<zzjr, zzjr> {
    zzjq() {
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final boolean zza(zzix zzixVar) {
        return false;
    }

    private static void zza(Object obj, zzjr zzjrVar) {
        ((zzgx) obj).zzws = zzjrVar;
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final void zzh(Object obj) {
        ((zzgx) obj).zzws.zzdq();
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ int zzs(zzjr zzjrVar) {
        return zzjrVar.zzgg();
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ int zzy(zzjr zzjrVar) {
        return zzjrVar.zzij();
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ zzjr zzh(zzjr zzjrVar, zzjr zzjrVar2) {
        zzjr zzjrVar3 = zzjrVar;
        zzjr zzjrVar4 = zzjrVar2;
        return zzjrVar4.equals(zzjr.zzih()) ? zzjrVar3 : zzjr.zza(zzjrVar3, zzjrVar4);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zzc(zzjr zzjrVar, zzkl zzklVar) throws IOException {
        zzjrVar.zza(zzklVar);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zza(zzjr zzjrVar, zzkl zzklVar) throws IOException {
        zzjrVar.zzb(zzklVar);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zzg(Object obj, zzjr zzjrVar) {
        zza(obj, zzjrVar);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ zzjr zzx(Object obj) {
        zzjr zzjrVar = ((zzgx) obj).zzws;
        if (zzjrVar != zzjr.zzih()) {
            return zzjrVar;
        }
        zzjr zzjrVarZzii = zzjr.zzii();
        zza(obj, zzjrVarZzii);
        return zzjrVarZzii;
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ zzjr zzw(Object obj) {
        return ((zzgx) obj).zzws;
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zzf(Object obj, zzjr zzjrVar) {
        zza(obj, zzjrVar);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ zzjr zzo(zzjr zzjrVar) {
        zzjr zzjrVar2 = zzjrVar;
        zzjrVar2.zzdq();
        return zzjrVar2;
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ zzjr zzig() {
        return zzjr.zzii();
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zza(zzjr zzjrVar, int i, zzjr zzjrVar2) {
        zzjrVar.zzb((i << 3) | 3, zzjrVar2);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zza(zzjr zzjrVar, int i, zzfm zzfmVar) {
        zzjrVar.zzb((i << 3) | 2, zzfmVar);
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zzb(zzjr zzjrVar, int i, long j) {
        zzjrVar.zzb((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zzc(zzjr zzjrVar, int i, int i2) {
        zzjrVar.zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.vision.zzjo
    final /* synthetic */ void zza(zzjr zzjrVar, int i, long j) {
        zzjrVar.zzb(i << 3, Long.valueOf(j));
    }
}
