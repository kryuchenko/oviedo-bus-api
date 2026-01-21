package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzha {
    private static final Class<?> zza = zzd();
    private static final zzhq<?, ?> zzb = zza(false);
    private static final zzhq<?, ?> zzc = zza(true);
    private static final zzhq<?, ?> zzd = new zzhs();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzez.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzik zzikVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzik zzikVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zza(i, list);
    }

    public static void zzb(int i, List<zzdv> list, zzik zzikVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzik zzikVar, zzgy zzgyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zza(i, list, zzgyVar);
    }

    public static void zzb(int i, List<?> list, zzik zzikVar, zzgy zzgyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzikVar.zzb(i, list, zzgyVar);
    }

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzem.zzd(list.get(i).longValue());
                i++;
            }
            return iZzd;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzem.zzd(zzfvVar.zza(i));
            i++;
        }
        return iZzd2;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzem.zze(i));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZze = 0;
            while (i < size) {
                iZze += zzem.zze(list.get(i).longValue());
                i++;
            }
            return iZze;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZze2 = 0;
        while (i < size) {
            iZze2 += zzem.zze(zzfvVar.zza(i));
            i++;
        }
        return iZze2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzem.zze(i));
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzem.zzf(list.get(i).longValue());
                i++;
            }
            return iZzf;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzem.zzf(zzfvVar.zza(i));
            i++;
        }
        return iZzf2;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzem.zze(i));
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfa)) {
            int iZzk = 0;
            while (i < size) {
                iZzk += zzem.zzk(list.get(i).intValue());
                i++;
            }
            return iZzk;
        }
        zzfa zzfaVar = (zzfa) list;
        int iZzk2 = 0;
        while (i < size) {
            iZzk2 += zzem.zzk(zzfaVar.zza(i));
            i++;
        }
        return iZzk2;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzem.zze(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfa)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzem.zzf(list.get(i).intValue());
                i++;
            }
            return iZzf;
        }
        zzfa zzfaVar = (zzfa) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzem.zzf(zzfaVar.zza(i));
            i++;
        }
        return iZzf2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzem.zze(i));
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfa)) {
            int iZzg = 0;
            while (i < size) {
                iZzg += zzem.zzg(list.get(i).intValue());
                i++;
            }
            return iZzg;
        }
        zzfa zzfaVar = (zzfa) list;
        int iZzg2 = 0;
        while (i < size) {
            iZzg2 += zzem.zzg(zzfaVar.zza(i));
            i++;
        }
        return iZzg2;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzem.zze(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfa)) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzem.zzh(list.get(i).intValue());
                i++;
            }
            return iZzh;
        }
        zzfa zzfaVar = (zzfa) list;
        int iZzh2 = 0;
        while (i < size) {
            iZzh2 += zzem.zzh(zzfaVar.zza(i));
            i++;
        }
        return iZzh2;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzem.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzem.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzem.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzem.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzem.zze(i) * size;
        if (!(list instanceof zzfs)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdv) {
                    iZzb = zzem.zzb((zzdv) obj);
                } else {
                    iZzb = zzem.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
            return iZze;
        }
        zzfs zzfsVar = (zzfs) list;
        while (i2 < size) {
            Object objZza = zzfsVar.zza(i2);
            if (objZza instanceof zzdv) {
                iZzb2 = zzem.zzb((zzdv) objZza);
            } else {
                iZzb2 = zzem.zzb((String) objZza);
            }
            iZze += iZzb2;
            i2++;
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzgy zzgyVar) {
        if (obj instanceof zzfq) {
            return zzem.zza(i, (zzfq) obj);
        }
        return zzem.zzb(i, (zzgh) obj, zzgyVar);
    }

    static int zza(int i, List<?> list, zzgy zzgyVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzem.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzfq) {
                iZza = zzem.zza((zzfq) obj);
            } else {
                iZza = zzem.zza((zzgh) obj, zzgyVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzdv> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzem.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzem.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzgh> list, zzgy zzgyVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzem.zzc(i, list.get(i2), zzgyVar);
        }
        return iZzc;
    }

    public static zzhq<?, ?> zza() {
        return zzb;
    }

    public static zzhq<?, ?> zzb() {
        return zzc;
    }

    public static zzhq<?, ?> zzc() {
        return zzd;
    }

    private static zzhq<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzhq) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzge zzgeVar, T t, T t2, long j) {
        zzhw.zza(t, j, zzgeVar.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j)));
    }

    static <T, FT extends zzet<FT>> void zza(zzeq<FT> zzeqVar, T t, T t2) {
        zzer<T> zzerVarZza = zzeqVar.zza(t2);
        if (zzerVarZza.zza.isEmpty()) {
            return;
        }
        zzeqVar.zzb(t).zza((zzer) zzerVarZza);
    }

    static <T, UT, UB> void zza(zzhq<UT, UB> zzhqVar, T t, T t2) {
        zzhqVar.zza(t, zzhqVar.zzb(zzhqVar.zza(t), zzhqVar.zza(t2)));
    }
}
