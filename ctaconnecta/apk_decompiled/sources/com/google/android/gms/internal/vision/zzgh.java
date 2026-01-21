package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgh implements zzkl {
    private final zzgf zzss;

    public static zzgh zza(zzgf zzgfVar) {
        return zzgfVar.zzth != null ? zzgfVar.zzth : new zzgh(zzgfVar);
    }

    private zzgh(zzgf zzgfVar) {
        zzgf zzgfVar2 = (zzgf) zzgy.zza(zzgfVar, "output");
        this.zzss = zzgfVar2;
        zzgfVar2.zzth = this;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final int zzfk() {
        return zzgx.zzf.zzxl;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzr(int i, int i2) throws IOException {
        this.zzss.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzi(int i, long j) throws IOException {
        this.zzss.zza(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzj(int i, long j) throws IOException {
        this.zzss.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, float f) throws IOException {
        this.zzss.zza(i, f);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, double d) throws IOException {
        this.zzss.zza(i, d);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzs(int i, int i2) throws IOException {
        this.zzss.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, long j) throws IOException {
        this.zzss.zza(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzh(int i, int i2) throws IOException {
        this.zzss.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzc(int i, long j) throws IOException {
        this.zzss.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzk(int i, int i2) throws IOException {
        this.zzss.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, boolean z) throws IOException {
        this.zzss.zza(i, z);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, String str) throws IOException {
        this.zzss.zza(i, str);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, zzfm zzfmVar) throws IOException {
        this.zzss.zza(i, zzfmVar);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzi(int i, int i2) throws IOException {
        this.zzss.zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzj(int i, int i2) throws IOException {
        this.zzss.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzb(int i, long j) throws IOException {
        this.zzss.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, Object obj, zziw zziwVar) throws IOException {
        this.zzss.zza(i, (zzih) obj, zziwVar);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzb(int i, Object obj, zziw zziwVar) throws IOException {
        zzgf zzgfVar = this.zzss;
        zzgfVar.writeTag(i, 3);
        zziwVar.zza((zzih) obj, zzgfVar.zzth);
        zzgfVar.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzbk(int i) throws IOException {
        this.zzss.writeTag(i, 3);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzbl(int i) throws IOException {
        this.zzss.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzfm) {
            this.zzss.zzb(i, (zzfm) obj);
        } else {
            this.zzss.zza(i, (zzih) obj);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzbc = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbc += zzgf.zzbc(list.get(i3).intValue());
            }
            this.zzss.zzay(iZzbc);
            while (i2 < list.size()) {
                this.zzss.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzbf = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbf += zzgf.zzbf(list.get(i3).intValue());
            }
            this.zzss.zzay(iZzbf);
            while (i2 < list.size()) {
                this.zzss.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzv = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzv += zzgf.zzv(list.get(i3).longValue());
            }
            this.zzss.zzay(iZzv);
            while (i2 < list.size()) {
                this.zzss.zzs(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzw = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzw += zzgf.zzw(list.get(i3).longValue());
            }
            this.zzss.zzay(iZzw);
            while (i2 < list.size()) {
                this.zzss.zzs(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzy = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzy += zzgf.zzy(list.get(i3).longValue());
            }
            this.zzss.zzay(iZzy);
            while (i2 < list.size()) {
                this.zzss.zzu(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzt = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzt += zzgf.zzt(list.get(i3).floatValue());
            }
            this.zzss.zzay(iZzt);
            while (i2 < list.size()) {
                this.zzss.zzs(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzb += zzgf.zzb(list.get(i3).doubleValue());
            }
            this.zzss.zzay(iZzb);
            while (i2 < list.size()) {
                this.zzss.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzbh = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbh += zzgf.zzbh(list.get(i3).intValue());
            }
            this.zzss.zzay(iZzbh);
            while (i2 < list.size()) {
                this.zzss.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzl = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzl += zzgf.zzl(list.get(i3).booleanValue());
            }
            this.zzss.zzay(iZzl);
            while (i2 < list.size()) {
                this.zzss.zzk(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzho) {
            zzho zzhoVar = (zzho) list;
            while (i2 < list.size()) {
                Object raw = zzhoVar.getRaw(i2);
                if (raw instanceof String) {
                    this.zzss.zza(i, (String) raw);
                } else {
                    this.zzss.zza(i, (zzfm) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzb(int i, List<zzfm> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzss.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzbd = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbd += zzgf.zzbd(list.get(i3).intValue());
            }
            this.zzss.zzay(iZzbd);
            while (i2 < list.size()) {
                this.zzss.zzay(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzbg = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbg += zzgf.zzbg(list.get(i3).intValue());
            }
            this.zzss.zzay(iZzbg);
            while (i2 < list.size()) {
                this.zzss.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzgf.zzz(list.get(i3).longValue());
            }
            this.zzss.zzay(iZzz);
            while (i2 < list.size()) {
                this.zzss.zzu(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzbe = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbe += zzgf.zzbe(list.get(i3).intValue());
            }
            this.zzss.zzay(iZzbe);
            while (i2 < list.size()) {
                this.zzss.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzss.writeTag(i, 2);
            int iZzx = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzx += zzgf.zzx(list.get(i3).longValue());
            }
            this.zzss.zzay(iZzx);
            while (i2 < list.size()) {
                this.zzss.zzt(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzss.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zza(int i, List<?> list, zziw zziwVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zziwVar);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final void zzb(int i, List<?> list, zziw zziwVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zziwVar);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final <K, V> void zza(int i, zzhy<K, V> zzhyVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzss.writeTag(i, 2);
            this.zzss.zzay(zzhz.zza(zzhyVar, entry.getKey(), entry.getValue()));
            zzhz.zza(this.zzss, zzhyVar, entry.getKey(), entry.getValue());
        }
    }
}
