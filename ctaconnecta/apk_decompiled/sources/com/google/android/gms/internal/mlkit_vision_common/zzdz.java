package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzdz implements zzhu {
    private final zzdw zza;

    public static zzdz zza(zzdw zzdwVar) {
        return zzdwVar.zza != null ? zzdwVar.zza : new zzdz(zzdwVar);
    }

    private zzdz(zzdw zzdwVar) {
        zzdw zzdwVar2 = (zzdw) zzem.zza(zzdwVar, "output");
        this.zza = zzdwVar2;
        zzdwVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final int zza() {
        return zzek.zze.zzj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, int i2) throws IOException {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i, long j) throws IOException {
        this.zza.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, float f) throws IOException {
        this.zza.zza(i, f);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, double d) throws IOException {
        this.zza.zza(i, d);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzc(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzd(int i, int i2) throws IOException {
        this.zza.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, boolean z) throws IOException {
        this.zza.zza(i, z);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, String str) throws IOException {
        this.zza.zza(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, zzdj zzdjVar) throws IOException {
        this.zza.zza(i, zzdjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zze(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zze(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, Object obj, zzgi zzgiVar) throws IOException {
        this.zza.zza(i, (zzfv) obj, zzgiVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i, Object obj, zzgi zzgiVar) throws IOException {
        zzdw zzdwVar = this.zza;
        zzdwVar.zza(i, 3);
        zzgiVar.zza((zzgi) obj, (zzhu) zzdwVar.zza);
        zzdwVar.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzdj) {
            this.zza.zzb(i, (zzdj) obj);
        } else {
            this.zza.zza(i, (zzfv) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzf = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzf += zzdw.zzf(list.get(i3).intValue());
            }
            this.zza.zzb(iZzf);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzi = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzi += zzdw.zzi(list.get(i3).intValue());
            }
            this.zza.zzb(iZzi);
            while (i2 < list.size()) {
                this.zza.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzd = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzd += zzdw.zzd(list.get(i3).longValue());
            }
            this.zza.zzb(iZzd);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZze = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZze += zzdw.zze(list.get(i3).longValue());
            }
            this.zza.zzb(iZze);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzg = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzg += zzdw.zzg(list.get(i3).longValue());
            }
            this.zza.zzb(iZzg);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzb += zzdw.zzb(list.get(i3).floatValue());
            }
            this.zza.zzb(iZzb);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzb += zzdw.zzb(list.get(i3).doubleValue());
            }
            this.zza.zzb(iZzb);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzk = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzk += zzdw.zzk(list.get(i3).intValue());
            }
            this.zza.zzb(iZzk);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzb += zzdw.zzb(list.get(i3).booleanValue());
            }
            this.zza.zzb(iZzb);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzfc) {
            zzfc zzfcVar = (zzfc) list;
            while (i2 < list.size()) {
                Object objZza = zzfcVar.zza(i2);
                if (objZza instanceof String) {
                    this.zza.zza(i, (String) objZza);
                } else {
                    this.zza.zza(i, (zzdj) objZza);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i, List<zzdj> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzg = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzg += zzdw.zzg(list.get(i3).intValue());
            }
            this.zza.zzb(iZzg);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzj = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzj += zzdw.zzj(list.get(i3).intValue());
            }
            this.zza.zzb(iZzj);
            while (i2 < list.size()) {
                this.zza.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzh = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzh += zzdw.zzh(list.get(i3).longValue());
            }
            this.zza.zzb(iZzh);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzh = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzh += zzdw.zzh(list.get(i3).intValue());
            }
            this.zza.zzb(iZzh);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int iZzf = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzf += zzdw.zzf(list.get(i3).longValue());
            }
            this.zza.zzb(iZzf);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zza(int i, List<?> list, zzgi zzgiVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzgiVar);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final void zzb(int i, List<?> list, zzgi zzgiVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzgiVar);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhu
    public final <K, V> void zza(int i, zzfm<K, V> zzfmVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zza(i, 2);
            this.zza.zzb(zzef.zza(zzfmVar.zza, 1, entry.getKey()) + zzef.zza(zzfmVar.zzb, 2, entry.getValue()));
            zzdw zzdwVar = this.zza;
            K key = entry.getKey();
            V value = entry.getValue();
            zzef.zza(zzdwVar, zzfmVar.zza, 1, key);
            zzef.zza(zzdwVar, zzfmVar.zzb, 2, value);
        }
    }
}
