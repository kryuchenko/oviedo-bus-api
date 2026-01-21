package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgk {
    private static final Class<?> zza = zzd();
    private static final zzha<?, ?> zzb = zza(false);
    private static final zzha<?, ?> zzc = zza(true);
    private static final zzha<?, ?> zzd = new zzhc();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzek.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzhu zzhuVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zza(i, list);
    }

    public static void zzb(int i, List<zzdj> list, zzhu zzhuVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzhu zzhuVar, zzgi zzgiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zza(i, list, zzgiVar);
    }

    public static void zzb(int i, List<?> list, zzhu zzhuVar, zzgi zzgiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzb(i, list, zzgiVar);
    }

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzdw.zzd(list.get(i).longValue());
                i++;
            }
            return iZzd;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzdw.zzd(zzfjVar.zza(i));
            i++;
        }
        return iZzd2;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzdw.zze(i));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZze = 0;
            while (i < size) {
                iZze += zzdw.zze(list.get(i).longValue());
                i++;
            }
            return iZze;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZze2 = 0;
        while (i < size) {
            iZze2 += zzdw.zze(zzfjVar.zza(i));
            i++;
        }
        return iZze2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzdw.zze(i));
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzdw.zzf(list.get(i).longValue());
                i++;
            }
            return iZzf;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzdw.zzf(zzfjVar.zza(i));
            i++;
        }
        return iZzf2;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzdw.zze(i));
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzen)) {
            int iZzk = 0;
            while (i < size) {
                iZzk += zzdw.zzk(list.get(i).intValue());
                i++;
            }
            return iZzk;
        }
        zzen zzenVar = (zzen) list;
        int iZzk2 = 0;
        while (i < size) {
            iZzk2 += zzdw.zzk(zzenVar.zza(i));
            i++;
        }
        return iZzk2;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzdw.zze(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzen)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzdw.zzf(list.get(i).intValue());
                i++;
            }
            return iZzf;
        }
        zzen zzenVar = (zzen) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzdw.zzf(zzenVar.zza(i));
            i++;
        }
        return iZzf2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzdw.zze(i));
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzen)) {
            int iZzg = 0;
            while (i < size) {
                iZzg += zzdw.zzg(list.get(i).intValue());
                i++;
            }
            return iZzg;
        }
        zzen zzenVar = (zzen) list;
        int iZzg2 = 0;
        while (i < size) {
            iZzg2 += zzdw.zzg(zzenVar.zza(i));
            i++;
        }
        return iZzg2;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzdw.zze(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzen)) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzdw.zzh(list.get(i).intValue());
                i++;
            }
            return iZzh;
        }
        zzen zzenVar = (zzen) list;
        int iZzh2 = 0;
        while (i < size) {
            iZzh2 += zzdw.zzh(zzenVar.zza(i));
            i++;
        }
        return iZzh2;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzdw.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdw.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdw.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdw.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzdw.zze(i) * size;
        if (!(list instanceof zzfc)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdj) {
                    iZzb = zzdw.zzb((zzdj) obj);
                } else {
                    iZzb = zzdw.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
            return iZze;
        }
        zzfc zzfcVar = (zzfc) list;
        while (i2 < size) {
            Object objZza = zzfcVar.zza(i2);
            if (objZza instanceof zzdj) {
                iZzb2 = zzdw.zzb((zzdj) objZza);
            } else {
                iZzb2 = zzdw.zzb((String) objZza);
            }
            iZze += iZzb2;
            i2++;
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzgi zzgiVar) {
        if (obj instanceof zzfa) {
            return zzdw.zza(i, (zzfa) obj);
        }
        return zzdw.zzb(i, (zzfv) obj, zzgiVar);
    }

    static int zza(int i, List<?> list, zzgi zzgiVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzdw.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzfa) {
                iZza = zzdw.zza((zzfa) obj);
            } else {
                iZza = zzdw.zza((zzfv) obj, zzgiVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzdj> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzdw.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzdw.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzfv> list, zzgi zzgiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzdw.zzc(i, list.get(i2), zzgiVar);
        }
        return iZzc;
    }

    public static zzha<?, ?> zza() {
        return zzb;
    }

    public static zzha<?, ?> zzb() {
        return zzc;
    }

    public static zzha<?, ?> zzc() {
        return zzd;
    }

    private static zzha<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzha) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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

    static <T> void zza(zzfo zzfoVar, T t, T t2, long j) {
        zzhg.zza(t, j, zzfoVar.zza(zzhg.zzf(t, j), zzhg.zzf(t2, j)));
    }

    static <T, FT extends zzeh<FT>> void zza(zzea<FT> zzeaVar, T t, T t2) {
        zzef<T> zzefVarZza = zzeaVar.zza(t2);
        if (zzefVarZza.zza.isEmpty()) {
            return;
        }
        zzeaVar.zzb(t).zza((zzef) zzefVarZza);
    }

    static <T, UT, UB> void zza(zzha<UT, UB> zzhaVar, T t, T t2) {
        zzhaVar.zza(t, zzhaVar.zzb(zzhaVar.zza(t), zzhaVar.zza(t2)));
    }
}
