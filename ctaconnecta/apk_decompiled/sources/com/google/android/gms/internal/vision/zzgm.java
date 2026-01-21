package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgm extends zzgk<zzgx.zzd> {
    zzgm() {
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final boolean zze(zzih zzihVar) {
        return zzihVar instanceof zzgx.zze;
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final zzgn<zzgx.zzd> zzf(Object obj) {
        return ((zzgx.zze) obj).zzwz;
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final zzgn<zzgx.zzd> zzg(Object obj) {
        return ((zzgx.zze) obj).zzgl();
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final void zzh(Object obj) {
        zzf(obj).zzdq();
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final <UT, UB> UB zza(zzix zzixVar, Object obj, zzgi zzgiVar, zzgn<zzgx.zzd> zzgnVar, UB ub, zzjo<UT, UB> zzjoVar) throws IOException {
        Object objValueOf;
        Object objZza;
        ArrayList arrayList;
        zzgx.zzg zzgVar = (zzgx.zzg) obj;
        int i = zzgVar.zzxq.number;
        if (zzgVar.zzxq.zzwx && zzgVar.zzxq.zzwy) {
            switch (zzgl.zzsg[zzgVar.zzxq.zzww.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    zzixVar.zza(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    zzixVar.zzb(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    zzixVar.zzd(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    zzixVar.zzc(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    zzixVar.zze(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    zzixVar.zzf(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    zzixVar.zzg(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    zzixVar.zzh(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    zzixVar.zzk(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    zzixVar.zzm(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    zzixVar.zzn(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    zzixVar.zzo(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    zzixVar.zzp(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    zzixVar.zzl(arrayList);
                    ub = (UB) zziy.zza(i, arrayList, zzgVar.zzxq.zzwv, ub, zzjoVar);
                    break;
                default:
                    String strValueOf = String.valueOf(zzgVar.zzxq.zzww);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
                    sb.append("Type cannot be packed: ");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
            }
            zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, arrayList);
            return ub;
        }
        if (zzgVar.zzxq.zzww == zzkf.zzaco) {
            int iZzdz = zzixVar.zzdz();
            if (zzgVar.zzxq.zzwv.zzh(iZzdz) == null) {
                return (UB) zziy.zza(i, iZzdz, ub, zzjoVar);
            }
            objValueOf = Integer.valueOf(iZzdz);
        } else {
            switch (zzgl.zzsg[zzgVar.zzxq.zzww.ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(zzixVar.readDouble());
                    break;
                case 2:
                    objValueOf = Float.valueOf(zzixVar.readFloat());
                    break;
                case 3:
                    objValueOf = Long.valueOf(zzixVar.zzdy());
                    break;
                case 4:
                    objValueOf = Long.valueOf(zzixVar.zzdx());
                    break;
                case 5:
                    objValueOf = Integer.valueOf(zzixVar.zzdz());
                    break;
                case 6:
                    objValueOf = Long.valueOf(zzixVar.zzea());
                    break;
                case 7:
                    objValueOf = Integer.valueOf(zzixVar.zzeb());
                    break;
                case 8:
                    objValueOf = Boolean.valueOf(zzixVar.zzec());
                    break;
                case 9:
                    objValueOf = Integer.valueOf(zzixVar.zzef());
                    break;
                case 10:
                    objValueOf = Integer.valueOf(zzixVar.zzeh());
                    break;
                case 11:
                    objValueOf = Long.valueOf(zzixVar.zzei());
                    break;
                case 12:
                    objValueOf = Integer.valueOf(zzixVar.zzej());
                    break;
                case 13:
                    objValueOf = Long.valueOf(zzixVar.zzek());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    objValueOf = zzixVar.zzee();
                    break;
                case 16:
                    objValueOf = zzixVar.readString();
                    break;
                case 17:
                    objValueOf = zzixVar.zzb(zzgVar.zzxp.getClass(), zzgiVar);
                    break;
                case 18:
                    objValueOf = zzixVar.zza(zzgVar.zzxp.getClass(), zzgiVar);
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        }
        if (zzgVar.zzxq.zzwx) {
            zzgnVar.zzb((zzgn<zzgx.zzd>) zzgVar.zzxq, objValueOf);
            return ub;
        }
        int i2 = zzgl.zzsg[zzgVar.zzxq.zzww.ordinal()];
        if ((i2 == 17 || i2 == 18) && (objZza = zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq)) != null) {
            objValueOf = zzgy.zzb(objZza, objValueOf);
        }
        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, objValueOf);
        return ub;
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final int zza(Map.Entry<?, ?> entry) {
        return ((zzgx.zzd) entry.getKey()).number;
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final void zza(zzkl zzklVar, Map.Entry<?, ?> entry) throws IOException {
        zzgx.zzd zzdVar = (zzgx.zzd) entry.getKey();
        if (zzdVar.zzwx) {
            switch (zzgl.zzsg[zzdVar.zzww.ordinal()]) {
                case 1:
                    zziy.zza(zzdVar.number, (List<Double>) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 2:
                    zziy.zzb(zzdVar.number, (List<Float>) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 3:
                    zziy.zzc(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 4:
                    zziy.zzd(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 5:
                    zziy.zzh(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 6:
                    zziy.zzf(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 7:
                    zziy.zzk(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 8:
                    zziy.zzn(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 9:
                    zziy.zzi(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 10:
                    zziy.zzl(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 11:
                    zziy.zzg(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 12:
                    zziy.zzj(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 13:
                    zziy.zze(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 14:
                    zziy.zzh(zzdVar.number, (List) entry.getValue(), zzklVar, zzdVar.zzwy);
                    break;
                case 15:
                    zziy.zzb(zzdVar.number, (List) entry.getValue(), zzklVar);
                    break;
                case 16:
                    zziy.zza(zzdVar.number, (List<String>) entry.getValue(), zzklVar);
                    break;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zziy.zzb(zzdVar.number, (List<?>) entry.getValue(), zzklVar, zzis.zzhp().zzf(list.get(0).getClass()));
                        break;
                    }
                    break;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zziy.zza(zzdVar.number, (List<?>) entry.getValue(), zzklVar, zzis.zzhp().zzf(list2.get(0).getClass()));
                        break;
                    }
                    break;
            }
        }
        switch (zzgl.zzsg[zzdVar.zzww.ordinal()]) {
            case 1:
                zzklVar.zza(zzdVar.number, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                zzklVar.zza(zzdVar.number, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                zzklVar.zzi(zzdVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzklVar.zza(zzdVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                zzklVar.zzh(zzdVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                zzklVar.zzc(zzdVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                zzklVar.zzk(zzdVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                zzklVar.zza(zzdVar.number, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                zzklVar.zzi(zzdVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                zzklVar.zzr(zzdVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                zzklVar.zzj(zzdVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                zzklVar.zzj(zzdVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzklVar.zzb(zzdVar.number, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                zzklVar.zzh(zzdVar.number, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzklVar.zza(zzdVar.number, (zzfm) entry.getValue());
                break;
            case 16:
                zzklVar.zza(zzdVar.number, (String) entry.getValue());
                break;
            case 17:
                zzklVar.zzb(zzdVar.number, entry.getValue(), zzis.zzhp().zzf(entry.getValue().getClass()));
                break;
            case 18:
                zzklVar.zza(zzdVar.number, entry.getValue(), zzis.zzhp().zzf(entry.getValue().getClass()));
                break;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final Object zza(zzgi zzgiVar, zzih zzihVar, int i) {
        return zzgiVar.zza(zzihVar, i);
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final void zza(zzix zzixVar, Object obj, zzgi zzgiVar, zzgn<zzgx.zzd> zzgnVar) throws IOException {
        zzgx.zzg zzgVar = (zzgx.zzg) obj;
        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, zzixVar.zza(zzgVar.zzxp.getClass(), zzgiVar));
    }

    @Override // com.google.android.gms.internal.vision.zzgk
    final void zza(zzfm zzfmVar, Object obj, zzgi zzgiVar, zzgn<zzgx.zzd> zzgnVar) throws IOException {
        byte[] bArr;
        zzgx.zzg zzgVar = (zzgx.zzg) obj;
        zzih zzihVarZzgc = zzgVar.zzxp.zzgk().zzgc();
        int size = zzfmVar.size();
        if (size == 0) {
            bArr = zzgy.zzxr;
        } else {
            byte[] bArr2 = new byte[size];
            zzfmVar.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.hasArray()) {
            zzfl zzflVar = new zzfl(byteBufferWrap, true);
            zzis.zzhp().zzv(zzihVarZzgc).zza(zzihVarZzgc, zzflVar, zzgiVar);
            zzgnVar.zza((zzgn<zzgx.zzd>) zzgVar.zzxq, zzihVarZzgc);
            if (zzflVar.zzdv() != Integer.MAX_VALUE) {
                throw zzhh.zzgr();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
