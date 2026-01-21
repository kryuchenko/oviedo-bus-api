package com.google.android.gms.internal.mlkit_vision_text;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhz {
    private static final Class<?> zza = zzd();
    private static final zzip<?, ?> zzb = zza(false);
    private static final zzip<?, ?> zzc = zza(true);
    private static final zzip<?, ?> zzd = new zzir();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfy.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzjj zzjjVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzjj zzjjVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zza(i, list);
    }

    public static void zzb(int i, List<zzeu> list, zzjj zzjjVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzjj zzjjVar, zzhx zzhxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zza(i, list, zzhxVar);
    }

    public static void zzb(int i, List<?> list, zzjj zzjjVar, zzhx zzhxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjjVar.zzb(i, list, zzhxVar);
    }

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgu)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzfl.zzd(list.get(i).longValue());
                i++;
            }
            return iZzd;
        }
        zzgu zzguVar = (zzgu) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzfl.zzd(zzguVar.zza(i));
            i++;
        }
        return iZzd2;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzfl.zze(i));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgu)) {
            int iZze = 0;
            while (i < size) {
                iZze += zzfl.zze(list.get(i).longValue());
                i++;
            }
            return iZze;
        }
        zzgu zzguVar = (zzgu) list;
        int iZze2 = 0;
        while (i < size) {
            iZze2 += zzfl.zze(zzguVar.zza(i));
            i++;
        }
        return iZze2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzfl.zze(i));
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgu)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzfl.zzf(list.get(i).longValue());
                i++;
            }
            return iZzf;
        }
        zzgu zzguVar = (zzgu) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzfl.zzf(zzguVar.zza(i));
            i++;
        }
        return iZzf2;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzfl.zze(i));
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfz)) {
            int iZzk = 0;
            while (i < size) {
                iZzk += zzfl.zzk(list.get(i).intValue());
                i++;
            }
            return iZzk;
        }
        zzfz zzfzVar = (zzfz) list;
        int iZzk2 = 0;
        while (i < size) {
            iZzk2 += zzfl.zzk(zzfzVar.zza(i));
            i++;
        }
        return iZzk2;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzfl.zze(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfz)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzfl.zzf(list.get(i).intValue());
                i++;
            }
            return iZzf;
        }
        zzfz zzfzVar = (zzfz) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzfl.zzf(zzfzVar.zza(i));
            i++;
        }
        return iZzf2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzfl.zze(i));
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfz)) {
            int iZzg = 0;
            while (i < size) {
                iZzg += zzfl.zzg(list.get(i).intValue());
                i++;
            }
            return iZzg;
        }
        zzfz zzfzVar = (zzfz) list;
        int iZzg2 = 0;
        while (i < size) {
            iZzg2 += zzfl.zzg(zzfzVar.zza(i));
            i++;
        }
        return iZzg2;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzfl.zze(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfz)) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzfl.zzh(list.get(i).intValue());
                i++;
            }
            return iZzh;
        }
        zzfz zzfzVar = (zzfz) list;
        int iZzh2 = 0;
        while (i < size) {
            iZzh2 += zzfl.zzh(zzfzVar.zza(i));
            i++;
        }
        return iZzh2;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzfl.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfl.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfl.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfl.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzfl.zze(i) * size;
        if (!(list instanceof zzgr)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzeu) {
                    iZzb = zzfl.zzb((zzeu) obj);
                } else {
                    iZzb = zzfl.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
            return iZze;
        }
        zzgr zzgrVar = (zzgr) list;
        while (i2 < size) {
            Object objZza = zzgrVar.zza(i2);
            if (objZza instanceof zzeu) {
                iZzb2 = zzfl.zzb((zzeu) objZza);
            } else {
                iZzb2 = zzfl.zzb((String) objZza);
            }
            iZze += iZzb2;
            i2++;
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzhx zzhxVar) {
        if (obj instanceof zzgp) {
            return zzfl.zza(i, (zzgp) obj);
        }
        return zzfl.zzb(i, (zzhg) obj, zzhxVar);
    }

    static int zza(int i, List<?> list, zzhx zzhxVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzfl.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzgp) {
                iZza = zzfl.zza((zzgp) obj);
            } else {
                iZza = zzfl.zza((zzhg) obj, zzhxVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzeu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzfl.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzfl.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzhg> list, zzhx zzhxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzfl.zzc(i, list.get(i2), zzhxVar);
        }
        return iZzc;
    }

    public static zzip<?, ?> zza() {
        return zzb;
    }

    public static zzip<?, ?> zzb() {
        return zzc;
    }

    public static zzip<?, ?> zzc() {
        return zzd;
    }

    private static zzip<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzip) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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

    static <T> void zza(zzhd zzhdVar, T t, T t2, long j) {
        zziv.zza(t, j, zzhdVar.zza(zziv.zzf(t, j), zziv.zzf(t2, j)));
    }

    static <T, FT extends zzfs<FT>> void zza(zzfp<FT> zzfpVar, T t, T t2) {
        zzfq<T> zzfqVarZza = zzfpVar.zza(t2);
        if (zzfqVarZza.zza.isEmpty()) {
            return;
        }
        zzfpVar.zzb(t).zza((zzfq) zzfqVarZza);
    }

    static <T, UT, UB> void zza(zzip<UT, UB> zzipVar, T t, T t2) {
        zzipVar.zza(t, zzipVar.zzb(zzipVar.zza(t), zzipVar.zza(t2)));
    }
}
