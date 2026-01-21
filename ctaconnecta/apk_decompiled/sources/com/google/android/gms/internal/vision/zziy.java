package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zziy {
    private static final Class<?> zzaag = zzhw();
    private static final zzjo<?, ?> zzaah = zzn(false);
    private static final zzjo<?, ?> zzaai = zzn(true);
    private static final zzjo<?, ?> zzaaj = new zzjq();

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzgx.class.isAssignableFrom(cls) && (cls2 = zzaag) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzkl zzklVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzkl zzklVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zza(i, list);
    }

    public static void zzb(int i, List<zzfm> list, zzkl zzklVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzkl zzklVar, zziw zziwVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zza(i, list, zziwVar);
    }

    public static void zzb(int i, List<?> list, zzkl zzklVar, zziw zziwVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzklVar.zzb(i, list, zziwVar);
    }

    static int zzq(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhv)) {
            int iZzv = 0;
            while (i < size) {
                iZzv += zzgf.zzv(list.get(i).longValue());
                i++;
            }
            return iZzv;
        }
        zzhv zzhvVar = (zzhv) list;
        int iZzv2 = 0;
        while (i < size) {
            iZzv2 += zzgf.zzv(zzhvVar.getLong(i));
            i++;
        }
        return iZzv2;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzgf.zzbb(i));
    }

    static int zzr(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhv)) {
            int iZzw = 0;
            while (i < size) {
                iZzw += zzgf.zzw(list.get(i).longValue());
                i++;
            }
            return iZzw;
        }
        zzhv zzhvVar = (zzhv) list;
        int iZzw2 = 0;
        while (i < size) {
            iZzw2 += zzgf.zzw(zzhvVar.getLong(i));
            i++;
        }
        return iZzw2;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzgf.zzbb(i));
    }

    static int zzs(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhv)) {
            int iZzx = 0;
            while (i < size) {
                iZzx += zzgf.zzx(list.get(i).longValue());
                i++;
            }
            return iZzx;
        }
        zzhv zzhvVar = (zzhv) list;
        int iZzx2 = 0;
        while (i < size) {
            iZzx2 += zzgf.zzx(zzhvVar.getLong(i));
            i++;
        }
        return iZzx2;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzgf.zzbb(i));
    }

    static int zzt(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgz)) {
            int iZzbh = 0;
            while (i < size) {
                iZzbh += zzgf.zzbh(list.get(i).intValue());
                i++;
            }
            return iZzbh;
        }
        zzgz zzgzVar = (zzgz) list;
        int iZzbh2 = 0;
        while (i < size) {
            iZzbh2 += zzgf.zzbh(zzgzVar.getInt(i));
            i++;
        }
        return iZzbh2;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzgf.zzbb(i));
    }

    static int zzu(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgz)) {
            int iZzbc = 0;
            while (i < size) {
                iZzbc += zzgf.zzbc(list.get(i).intValue());
                i++;
            }
            return iZzbc;
        }
        zzgz zzgzVar = (zzgz) list;
        int iZzbc2 = 0;
        while (i < size) {
            iZzbc2 += zzgf.zzbc(zzgzVar.getInt(i));
            i++;
        }
        return iZzbc2;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzgf.zzbb(i));
    }

    static int zzv(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgz)) {
            int iZzbd = 0;
            while (i < size) {
                iZzbd += zzgf.zzbd(list.get(i).intValue());
                i++;
            }
            return iZzbd;
        }
        zzgz zzgzVar = (zzgz) list;
        int iZzbd2 = 0;
        while (i < size) {
            iZzbd2 += zzgf.zzbd(zzgzVar.getInt(i));
            i++;
        }
        return iZzbd2;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzgf.zzbb(i));
    }

    static int zzw(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgz)) {
            int iZzbe = 0;
            while (i < size) {
                iZzbe += zzgf.zzbe(list.get(i).intValue());
                i++;
            }
            return iZzbe;
        }
        zzgz zzgzVar = (zzgz) list;
        int iZzbe2 = 0;
        while (i < size) {
            iZzbe2 += zzgf.zzbe(zzgzVar.getInt(i));
            i++;
        }
        return iZzbe2;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzgf.zzbb(i));
    }

    static int zzx(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzo(i, 0);
    }

    static int zzy(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzg(i, 0L);
    }

    static int zzz(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int iZzy;
        int iZzy2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzbb = zzgf.zzbb(i) * size;
        if (!(list instanceof zzho)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzfm) {
                    iZzy = zzgf.zzb((zzfm) obj);
                } else {
                    iZzy = zzgf.zzy((String) obj);
                }
                iZzbb += iZzy;
                i2++;
            }
            return iZzbb;
        }
        zzho zzhoVar = (zzho) list;
        while (i2 < size) {
            Object raw = zzhoVar.getRaw(i2);
            if (raw instanceof zzfm) {
                iZzy2 = zzgf.zzb((zzfm) raw);
            } else {
                iZzy2 = zzgf.zzy((String) raw);
            }
            iZzbb += iZzy2;
            i2++;
        }
        return iZzbb;
    }

    static int zzc(int i, Object obj, zziw zziwVar) {
        if (obj instanceof zzhm) {
            return zzgf.zza(i, (zzhm) obj);
        }
        return zzgf.zzb(i, (zzih) obj, zziwVar);
    }

    static int zzc(int i, List<?> list, zziw zziwVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzbb = zzgf.zzbb(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzhm) {
                iZza = zzgf.zza((zzhm) obj);
            } else {
                iZza = zzgf.zza((zzih) obj, zziwVar);
            }
            iZzbb += iZza;
        }
        return iZzbb;
    }

    static int zzd(int i, List<zzfm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzbb = size * zzgf.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzbb += zzgf.zzb(list.get(i2));
        }
        return iZzbb;
    }

    static int zzd(int i, List<zzih> list, zziw zziwVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzgf.zzc(i, list.get(i2), zziwVar);
        }
        return iZzc;
    }

    public static zzjo<?, ?> zzht() {
        return zzaah;
    }

    public static zzjo<?, ?> zzhu() {
        return zzaai;
    }

    public static zzjo<?, ?> zzhv() {
        return zzaaj;
    }

    private static zzjo<?, ?> zzn(boolean z) {
        try {
            Class<?> clsZzhx = zzhx();
            if (clsZzhx == null) {
                return null;
            }
            return (zzjo) clsZzhx.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhw() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhx() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzia zziaVar, T t, T t2, long j) {
        zzju.zza(t, j, zziaVar.zzc(zzju.zzp(t, j), zzju.zzp(t2, j)));
    }

    static <T, FT extends zzgp<FT>> void zza(zzgk<FT> zzgkVar, T t, T t2) {
        zzgn<T> zzgnVarZzf = zzgkVar.zzf(t2);
        if (zzgnVarZzf.zztq.isEmpty()) {
            return;
        }
        zzgkVar.zzg(t).zza(zzgnVarZzf);
    }

    static <T, UT, UB> void zza(zzjo<UT, UB> zzjoVar, T t, T t2) {
        zzjoVar.zzf(t, zzjoVar.zzh(zzjoVar.zzw(t), zzjoVar.zzw(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzha<?> zzhaVar, UB ub, zzjo<UT, UB> zzjoVar) {
        if (zzhaVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (zzhaVar.zzh(iIntValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, iIntValue, ub, zzjoVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (zzhaVar.zzh(iIntValue2) == null) {
                ub = (UB) zza(i, iIntValue2, ub, zzjoVar);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzhd zzhdVar, UB ub, zzjo<UT, UB> zzjoVar) {
        if (zzhdVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (zzhdVar.zzg(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, iIntValue, ub, zzjoVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzhdVar.zzg(iIntValue2)) {
                ub = (UB) zza(i, iIntValue2, ub, zzjoVar);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzjo<UT, UB> zzjoVar) {
        if (ub == null) {
            ub = zzjoVar.zzig();
        }
        zzjoVar.zza((zzjo<UT, UB>) ub, i, i2);
        return ub;
    }
}
