package com.google.android.gms.internal.measurement;

import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes3.dex */
final class zzkx<T> implements zzll<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmg.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkt zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlb zzn;
    private final zzkd zzo;
    private final zzmf<?, ?> zzp;
    private final zziz<?> zzq;
    private final zzkm zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzmg.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzmg.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzmn zzmnVar, Class<?> cls, zzhv zzhvVar) throws IOException {
        switch (zzkw.zza[zzmnVar.ordinal()]) {
            case 1:
                int iZzd = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Boolean.valueOf(zzhvVar.zzb != 0);
                return iZzd;
            case 2:
                return zzhw.zza(bArr, i, zzhvVar);
            case 3:
                zzhvVar.zzc = Double.valueOf(zzhw.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzhvVar.zzc = Integer.valueOf(zzhw.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzhvVar.zzc = Long.valueOf(zzhw.zzd(bArr, i));
                return i + 8;
            case 8:
                zzhvVar.zzc = Float.valueOf(zzhw.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzhw.zzc(bArr, i, zzhvVar);
                zzhvVar.zzc = Integer.valueOf(zzhvVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Long.valueOf(zzhvVar.zzb);
                return iZzd2;
            case 14:
                return zzhw.zza(zzlh.zza().zza((Class) cls), bArr, i, i2, zzhvVar);
            case 15:
                int iZzc2 = zzhw.zzc(bArr, i, zzhvVar);
                zzhvVar.zzc = Integer.valueOf(zzio.zze(zzhvVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Long.valueOf(zzio.zza(zzhvVar.zzb));
                return iZzd3;
            case 17:
                return zzhw.zzb(bArr, i, zzhvVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zza(T t) {
        int i;
        int iZza;
        int iZza2;
        int iZzd;
        int iZzd2;
        int iZzi;
        int iZzj;
        zzkx<T> zzkxVar = this;
        T t2 = t;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i3 < zzkxVar.zzc.length) {
            int iZzc = zzkxVar.zzc(i3);
            int i7 = (267386880 & iZzc) >>> 20;
            int[] iArr = zzkxVar.zzc;
            int i8 = iArr[i3];
            int i9 = iArr[i3 + 2];
            int i10 = i9 & i2;
            if (i7 <= 17) {
                if (i10 != i4) {
                    i5 = i10 == i2 ? 0 : unsafe.getInt(t2, i10);
                    i4 = i10;
                }
                i = 1 << (i9 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzc & i2;
            if (i7 >= zzje.DOUBLE_LIST_PACKED.zza()) {
                zzje.SINT64_LIST_PACKED.zza();
            }
            int i11 = i6;
            switch (i7) {
                case 0:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza = zzit.zza(i8, 0.0d);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 1:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza2 = zzit.zza(i8, 0.0f);
                        i6 = i11 + iZza2;
                        zzkxVar = this;
                        t2 = t;
                        break;
                    }
                    zzkxVar = this;
                    t2 = t;
                    i6 = i11;
                    break;
                case 2:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzd(i8, unsafe.getLong(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 3:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzg(i8, unsafe.getLong(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 4:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzg(i8, unsafe.getInt(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 5:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza2 = zzit.zzc(i8, 0L);
                        i6 = i11 + iZza2;
                        zzkxVar = this;
                        t2 = t;
                        break;
                    }
                    zzkxVar = this;
                    t2 = t;
                    i6 = i11;
                    break;
                case 6:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza2 = zzit.zzf(i8, 0);
                        i6 = i11 + iZza2;
                        zzkxVar = this;
                        t2 = t;
                        break;
                    }
                    zzkxVar = this;
                    t2 = t;
                    i6 = i11;
                    break;
                case 7:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza2 = zzit.zzb(i8, true);
                        i6 = i11 + iZza2;
                        zzkxVar = this;
                        t2 = t;
                        break;
                    }
                    zzkxVar = this;
                    t2 = t;
                    i6 = i11;
                    break;
                case 8:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        Object object = unsafe.getObject(t2, j);
                        if (object instanceof zzia) {
                            iZzd = zzit.zzc(i8, (zzia) object);
                        } else {
                            iZzd = zzit.zzb(i8, (String) object);
                        }
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 9:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza = zzln.zza(i8, unsafe.getObject(t2, j), zzkxVar.zze(i3));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 10:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzc(i8, (zzia) unsafe.getObject(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 11:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzj(i8, unsafe.getInt(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 12:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zze(i8, unsafe.getInt(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 13:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza2 = zzit.zzh(i8, 0);
                        i6 = i11 + iZza2;
                        zzkxVar = this;
                        t2 = t;
                        break;
                    }
                    zzkxVar = this;
                    t2 = t;
                    i6 = i11;
                    break;
                case 14:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza2 = zzit.zze(i8, 0L);
                        i6 = i11 + iZza2;
                        zzkxVar = this;
                        t2 = t;
                        break;
                    }
                    zzkxVar = this;
                    t2 = t;
                    i6 = i11;
                    break;
                case 15:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzi(i8, unsafe.getInt(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 16:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZzd = zzit.zzf(i8, unsafe.getLong(t2, j));
                        i6 = i11 + iZzd;
                        zzkxVar = this;
                        break;
                    }
                    zzkxVar = this;
                    i6 = i11;
                    break;
                case 17:
                    if (zzkxVar.zza((zzkx<T>) t2, i3, i4, i5, i)) {
                        iZza = zzit.zzb(i8, (zzkt) unsafe.getObject(t2, j), zzkxVar.zze(i3));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 18:
                    iZza = zzln.zzd(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 19:
                    iZza = zzln.zzc(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 20:
                    iZza = zzln.zzf(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 21:
                    iZza = zzln.zzj(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 22:
                    iZza = zzln.zze(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 23:
                    iZza = zzln.zzd(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 24:
                    iZza = zzln.zzc(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 25:
                    iZza = zzln.zza(i8, (List<?>) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 26:
                    iZza = zzln.zzb(i8, (List) unsafe.getObject(t2, j));
                    i6 = i11 + iZza;
                    break;
                case 27:
                    iZza = zzln.zzb(i8, (List<?>) unsafe.getObject(t2, j), zzkxVar.zze(i3));
                    i6 = i11 + iZza;
                    break;
                case 28:
                    iZza = zzln.zza(i8, (List<zzia>) unsafe.getObject(t2, j));
                    i6 = i11 + iZza;
                    break;
                case 29:
                    iZza = zzln.zzi(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 30:
                    iZza = zzln.zzb(i8, (List<Integer>) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 31:
                    iZza = zzln.zzc(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 32:
                    iZza = zzln.zzd(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 33:
                    iZza = zzln.zzg(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 34:
                    iZza = zzln.zzh(i8, (List) unsafe.getObject(t2, j), false);
                    i6 = i11 + iZza;
                    break;
                case 35:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 36:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 37:
                    iZzd2 = zzln.zzf((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 38:
                    iZzd2 = zzln.zzj((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 39:
                    iZzd2 = zzln.zze((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 40:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 41:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 42:
                    iZzd2 = zzln.zza((List<?>) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 43:
                    iZzd2 = zzln.zzi((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 44:
                    iZzd2 = zzln.zzb((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 45:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 46:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 47:
                    iZzd2 = zzln.zzg((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 48:
                    iZzd2 = zzln.zzh((List) unsafe.getObject(t2, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i8);
                        iZzj = zzit.zzj(iZzd2);
                        i6 = i11 + iZzi + iZzj + iZzd2;
                        break;
                    }
                    i6 = i11;
                    break;
                case 49:
                    iZza = zzln.zza(i8, (List<zzkt>) unsafe.getObject(t2, j), zzkxVar.zze(i3));
                    i6 = i11 + iZza;
                    break;
                case 50:
                    iZza = zzkxVar.zzr.zza(i8, unsafe.getObject(t2, j), zzkxVar.zzf(i3));
                    i6 = i11 + iZza;
                    break;
                case 51:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zza(i8, 0.0d);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 52:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zza(i8, 0.0f);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 53:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzd(i8, zzd(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 54:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzg(i8, zzd(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 55:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzg(i8, zzc(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 56:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzc(i8, 0L);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 57:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzf(i8, 0);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 58:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzb(i8, true);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 59:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        Object object2 = unsafe.getObject(t2, j);
                        if (object2 instanceof zzia) {
                            iZza = zzit.zzc(i8, (zzia) object2);
                        } else {
                            iZza = zzit.zzb(i8, (String) object2);
                        }
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 60:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzln.zza(i8, unsafe.getObject(t2, j), zzkxVar.zze(i3));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 61:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzc(i8, (zzia) unsafe.getObject(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 62:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzj(i8, zzc(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 63:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zze(i8, zzc(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 64:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzh(i8, 0);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 65:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zze(i8, 0L);
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 66:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzi(i8, zzc(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 67:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzf(i8, zzd(t2, j));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                case 68:
                    if (zzkxVar.zzc((zzkx<T>) t2, i8, i3)) {
                        iZza = zzit.zzb(i8, (zzkt) unsafe.getObject(t2, j), zzkxVar.zze(i3));
                        i6 = i11 + iZza;
                        break;
                    }
                    i6 = i11;
                    break;
                default:
                    i6 = i11;
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        zzmf<?, ?> zzmfVar = zzkxVar.zzp;
        int iZza3 = i6 + zzmfVar.zza((zzmf<?, ?>) zzmfVar.zzd(t2));
        if (!zzkxVar.zzh) {
            return iZza3;
        }
        zzjd<T> zzjdVarZza = zzkxVar.zzq.zza(t2);
        int iZza4 = 0;
        for (int i12 = 0; i12 < zzjdVarZza.zza.zza(); i12++) {
            Map.Entry entryZza = zzjdVarZza.zza.zza(i12);
            iZza4 += zzjd.zza((zzjf<?>) entryZza.getKey(), entryZza.getValue());
        }
        for (Map.Entry entry : zzjdVarZza.zza.zzb()) {
            iZza4 += zzjd.zza((zzjf<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + iZza4;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjm.zza(Double.doubleToLongBits(zzmg.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzmg.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzmg.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzmg.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzmg.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzmg.zze(t, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzmg.zze(t, j)).intValue();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zza(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzhv r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzhv):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzmg.zze(t, j)).longValue();
    }

    private final zzjo zzd(int i) {
        return (zzjo) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x037a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> zzkx<T> zza(Class<T> cls, zzkr zzkrVar, zzlb zzlbVar, zzkd zzkdVar, zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkm zzkmVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int[] iArr2;
        int i18;
        int i19;
        int iObjectFieldOffset;
        String str;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        Field fieldZza;
        char cCharAt9;
        int i22;
        int i23;
        Object obj;
        Field fieldZza2;
        Object obj2;
        Field fieldZza3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        if (zzkrVar instanceof zzlj) {
            zzlj zzljVar = (zzlj) zzkrVar;
            String strZzd = zzljVar.zzd();
            int length = strZzd.length();
            char c = 55296;
            if (strZzd.charAt(0) >= 55296) {
                int i28 = 1;
                while (true) {
                    i = i28 + 1;
                    if (strZzd.charAt(i28) < 55296) {
                        break;
                    }
                    i28 = i;
                }
            } else {
                i = 1;
            }
            int i29 = i + 1;
            int iCharAt2 = strZzd.charAt(i);
            if (iCharAt2 >= 55296) {
                int i30 = iCharAt2 & 8191;
                int i31 = 13;
                while (true) {
                    i27 = i29 + 1;
                    cCharAt13 = strZzd.charAt(i29);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i30 |= (cCharAt13 & 8191) << i31;
                    i31 += 13;
                    i29 = i27;
                }
                iCharAt2 = i30 | (cCharAt13 << i31);
                i29 = i27;
            }
            if (iCharAt2 == 0) {
                iArr = zza;
                i5 = 0;
                i4 = 0;
                iCharAt = 0;
                i3 = 0;
                i7 = 0;
                i2 = 0;
                i6 = 0;
            } else {
                int i32 = i29 + 1;
                int iCharAt3 = strZzd.charAt(i29);
                if (iCharAt3 >= 55296) {
                    int i33 = iCharAt3 & 8191;
                    int i34 = 13;
                    while (true) {
                        i15 = i32 + 1;
                        cCharAt8 = strZzd.charAt(i32);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i33 |= (cCharAt8 & 8191) << i34;
                        i34 += 13;
                        i32 = i15;
                    }
                    iCharAt3 = i33 | (cCharAt8 << i34);
                    i32 = i15;
                }
                int i35 = i32 + 1;
                int iCharAt4 = strZzd.charAt(i32);
                if (iCharAt4 >= 55296) {
                    int i36 = iCharAt4 & 8191;
                    int i37 = 13;
                    while (true) {
                        i14 = i35 + 1;
                        cCharAt7 = strZzd.charAt(i35);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i36 |= (cCharAt7 & 8191) << i37;
                        i37 += 13;
                        i35 = i14;
                    }
                    iCharAt4 = i36 | (cCharAt7 << i37);
                    i35 = i14;
                }
                int i38 = i35 + 1;
                int iCharAt5 = strZzd.charAt(i35);
                if (iCharAt5 >= 55296) {
                    int i39 = iCharAt5 & 8191;
                    int i40 = 13;
                    while (true) {
                        i13 = i38 + 1;
                        cCharAt6 = strZzd.charAt(i38);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i39 |= (cCharAt6 & 8191) << i40;
                        i40 += 13;
                        i38 = i13;
                    }
                    iCharAt5 = i39 | (cCharAt6 << i40);
                    i38 = i13;
                }
                int i41 = i38 + 1;
                int iCharAt6 = strZzd.charAt(i38);
                if (iCharAt6 >= 55296) {
                    int i42 = iCharAt6 & 8191;
                    int i43 = 13;
                    while (true) {
                        i12 = i41 + 1;
                        cCharAt5 = strZzd.charAt(i41);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i42 |= (cCharAt5 & 8191) << i43;
                        i43 += 13;
                        i41 = i12;
                    }
                    iCharAt6 = i42 | (cCharAt5 << i43);
                    i41 = i12;
                }
                int i44 = i41 + 1;
                iCharAt = strZzd.charAt(i41);
                if (iCharAt >= 55296) {
                    int i45 = iCharAt & 8191;
                    int i46 = 13;
                    while (true) {
                        i11 = i44 + 1;
                        cCharAt4 = strZzd.charAt(i44);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i45 |= (cCharAt4 & 8191) << i46;
                        i46 += 13;
                        i44 = i11;
                    }
                    iCharAt = i45 | (cCharAt4 << i46);
                    i44 = i11;
                }
                int i47 = i44 + 1;
                int iCharAt7 = strZzd.charAt(i44);
                if (iCharAt7 >= 55296) {
                    int i48 = iCharAt7 & 8191;
                    int i49 = 13;
                    while (true) {
                        i10 = i47 + 1;
                        cCharAt3 = strZzd.charAt(i47);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i48 |= (cCharAt3 & 8191) << i49;
                        i49 += 13;
                        i47 = i10;
                    }
                    iCharAt7 = i48 | (cCharAt3 << i49);
                    i47 = i10;
                }
                int i50 = i47 + 1;
                int iCharAt8 = strZzd.charAt(i47);
                if (iCharAt8 >= 55296) {
                    int i51 = iCharAt8 & 8191;
                    int i52 = 13;
                    while (true) {
                        i9 = i50 + 1;
                        cCharAt2 = strZzd.charAt(i50);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i51 |= (cCharAt2 & 8191) << i52;
                        i52 += 13;
                        i50 = i9;
                    }
                    iCharAt8 = i51 | (cCharAt2 << i52);
                    i50 = i9;
                }
                int i53 = i50 + 1;
                int iCharAt9 = strZzd.charAt(i50);
                if (iCharAt9 >= 55296) {
                    int i54 = iCharAt9 & 8191;
                    int i55 = 13;
                    while (true) {
                        i8 = i53 + 1;
                        cCharAt = strZzd.charAt(i53);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i54 |= (cCharAt & 8191) << i55;
                        i55 += 13;
                        i53 = i8;
                    }
                    iCharAt9 = i54 | (cCharAt << i55);
                    i53 = i8;
                }
                int[] iArr3 = new int[iCharAt9 + iCharAt7 + iCharAt8];
                i2 = (iCharAt3 << 1) + iCharAt4;
                int i56 = iCharAt7;
                i3 = iCharAt5;
                i4 = i56;
                i5 = iCharAt3;
                iArr = iArr3;
                i6 = iCharAt9;
                i29 = i53;
                i7 = iCharAt6;
            }
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzljVar.zze();
            Class<?> cls2 = zzljVar.zza().getClass();
            int[] iArr4 = new int[iCharAt * 3];
            Object[] objArr = new Object[iCharAt << 1];
            int i57 = i6 + i4;
            int i58 = i6;
            int i59 = i57;
            int i60 = 0;
            int i61 = 0;
            while (i29 < length) {
                int i62 = i29 + 1;
                int iCharAt10 = strZzd.charAt(i29);
                if (iCharAt10 >= c) {
                    int i63 = iCharAt10 & 8191;
                    int i64 = i62;
                    int i65 = 13;
                    while (true) {
                        i26 = i64 + 1;
                        cCharAt12 = strZzd.charAt(i64);
                        if (cCharAt12 < c) {
                            break;
                        }
                        i63 |= (cCharAt12 & 8191) << i65;
                        i65 += 13;
                        i64 = i26;
                    }
                    iCharAt10 = i63 | (cCharAt12 << i65);
                    i16 = i26;
                } else {
                    i16 = i62;
                }
                int i66 = i16 + 1;
                int iCharAt11 = strZzd.charAt(i16);
                if (iCharAt11 >= c) {
                    int i67 = iCharAt11 & 8191;
                    int i68 = i66;
                    int i69 = 13;
                    while (true) {
                        i25 = i68 + 1;
                        cCharAt11 = strZzd.charAt(i68);
                        if (cCharAt11 < c) {
                            break;
                        }
                        i67 |= (cCharAt11 & 8191) << i69;
                        i69 += 13;
                        i68 = i25;
                    }
                    iCharAt11 = i67 | (cCharAt11 << i69);
                    i17 = i25;
                } else {
                    i17 = i66;
                }
                int i70 = iCharAt11 & 255;
                zzlj zzljVar2 = zzljVar;
                if ((iCharAt11 & 1024) != 0) {
                    iArr[i61] = i60;
                    i61++;
                }
                int i71 = length;
                if (i70 >= 51) {
                    int i72 = i17 + 1;
                    int iCharAt12 = strZzd.charAt(i17);
                    char c2 = 55296;
                    if (iCharAt12 >= 55296) {
                        int i73 = iCharAt12 & 8191;
                        int i74 = 13;
                        while (true) {
                            i24 = i72 + 1;
                            cCharAt10 = strZzd.charAt(i72);
                            if (cCharAt10 < c2) {
                                break;
                            }
                            i73 |= (cCharAt10 & 8191) << i74;
                            i74 += 13;
                            i72 = i24;
                            c2 = 55296;
                        }
                        iCharAt12 = i73 | (cCharAt10 << i74);
                        i72 = i24;
                    }
                    int i75 = i70 - 51;
                    int i76 = i72;
                    if (i75 == 9 || i75 == 17) {
                        i23 = i2 + 1;
                        objArr[((i60 / 3) << 1) + 1] = objArrZze[i2];
                    } else {
                        if (i75 == 12 && (zzljVar2.zzb().equals(zzle.PROTO2) || (iCharAt11 & 2048) != 0)) {
                            i23 = i2 + 1;
                            objArr[((i60 / 3) << 1) + 1] = objArrZze[i2];
                        }
                        int i77 = iCharAt12 << 1;
                        obj = objArrZze[i77];
                        if (!(obj instanceof Field)) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZze[i77] = fieldZza2;
                        }
                        iArr2 = iArr4;
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza2);
                        int i78 = i77 + 1;
                        obj2 = objArrZze[i78];
                        if (!(obj2 instanceof Field)) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZze[i78] = fieldZza3;
                        }
                        iObjectFieldOffset = iObjectFieldOffset3;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                        str = strZzd;
                        i20 = i76;
                        i21 = 0;
                    }
                    i2 = i23;
                    int i772 = iCharAt12 << 1;
                    obj = objArrZze[i772];
                    if (!(obj instanceof Field)) {
                    }
                    iArr2 = iArr4;
                    int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldZza2);
                    int i782 = i772 + 1;
                    obj2 = objArrZze[i782];
                    if (!(obj2 instanceof Field)) {
                    }
                    iObjectFieldOffset = iObjectFieldOffset32;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    str = strZzd;
                    i20 = i76;
                    i21 = 0;
                } else {
                    iArr2 = iArr4;
                    int i79 = i2 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i2]);
                    if (i70 == 9 || i70 == 17) {
                        i18 = i79;
                        objArr[((i60 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i70 == 27 || i70 == 49) {
                            i22 = i2 + 2;
                            objArr[((i60 / 3) << 1) + 1] = objArrZze[i79];
                        } else if (i70 == 12 || i70 == 30 || i70 == 44) {
                            i18 = i79;
                            if (zzljVar2.zzb() == zzle.PROTO2 || (iCharAt11 & 2048) != 0) {
                                i22 = i2 + 2;
                                objArr[((i60 / 3) << 1) + 1] = objArrZze[i18];
                            }
                        } else if (i70 == 50) {
                            int i80 = i58 + 1;
                            iArr[i58] = i60;
                            int i81 = (i60 / 3) << 1;
                            i18 = i2 + 2;
                            objArr[i81] = objArrZze[i79];
                            if ((iCharAt11 & 2048) != 0) {
                                i19 = i2 + 3;
                                objArr[i81 + 1] = objArrZze[i18];
                                i58 = i80;
                                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                                if ((iCharAt11 & 4096) == 0 || i70 > 17) {
                                    i2 = i19;
                                    str = strZzd;
                                    iObjectFieldOffset2 = 1048575;
                                    i20 = i17;
                                    i21 = 0;
                                } else {
                                    int i82 = i17 + 1;
                                    int iCharAt13 = strZzd.charAt(i17);
                                    i2 = i19;
                                    if (iCharAt13 >= 55296) {
                                        int i83 = iCharAt13 & 8191;
                                        int i84 = 13;
                                        while (true) {
                                            i20 = i82 + 1;
                                            cCharAt9 = strZzd.charAt(i82);
                                            if (cCharAt9 < 55296) {
                                                break;
                                            }
                                            i83 |= (cCharAt9 & 8191) << i84;
                                            i84 += 13;
                                            i82 = i20;
                                        }
                                        iCharAt13 = i83 | (cCharAt9 << i84);
                                    } else {
                                        i20 = i82;
                                    }
                                    int i85 = (i5 << 1) + (iCharAt13 / 32);
                                    Object obj3 = objArrZze[i85];
                                    str = strZzd;
                                    if (obj3 instanceof Field) {
                                        fieldZza = (Field) obj3;
                                    } else {
                                        fieldZza = zza(cls2, (String) obj3);
                                        objArrZze[i85] = fieldZza;
                                    }
                                    i21 = iCharAt13 % 32;
                                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                                }
                                if (i70 >= 18 && i70 <= 49) {
                                    iArr[i59] = iObjectFieldOffset;
                                    i59++;
                                }
                            } else {
                                i58 = i80;
                            }
                        } else {
                            i18 = i79;
                        }
                        i19 = i22;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((iCharAt11 & 4096) == 0) {
                            i2 = i19;
                            str = strZzd;
                            iObjectFieldOffset2 = 1048575;
                            i20 = i17;
                            i21 = 0;
                            if (i70 >= 18) {
                                iArr[i59] = iObjectFieldOffset;
                                i59++;
                            }
                        }
                    }
                    i19 = i18;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((iCharAt11 & 4096) == 0) {
                    }
                }
                int i86 = i60 + 1;
                iArr2[i60] = iCharAt10;
                int i87 = i60 + 2;
                int i88 = iObjectFieldOffset2;
                iArr2[i86] = ((iCharAt11 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i70 << 20) | iObjectFieldOffset;
                i60 += 3;
                iArr2[i87] = (i21 << 20) | i88;
                zzljVar = zzljVar2;
                i29 = i20;
                strZzd = str;
                length = i71;
                iArr4 = iArr2;
                c = 55296;
            }
            zzlj zzljVar3 = zzljVar;
            return new zzkx<>(iArr4, objArr, i3, i7, zzljVar3.zza(), zzljVar3.zzb(), false, iArr, i6, i57, zzlbVar, zzkdVar, zzmfVar, zzizVar, zzkmVar);
        }
        throw new NoSuchMethodError();
    }

    private final zzll zze(int i) {
        int i2 = (i / 3) << 1;
        zzll zzllVar = (zzll) this.zzd[i2];
        if (zzllVar != null) {
            return zzllVar;
        }
        zzll<T> zzllVarZza = zzlh.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzllVarZza;
        return zzllVarZza;
    }

    private static zzme zze(Object obj) {
        zzjk zzjkVar = (zzjk) obj;
        zzme zzmeVar = zzjkVar.zzb;
        if (zzmeVar != zzme.zzc()) {
            return zzmeVar;
        }
        zzme zzmeVarZzd = zzme.zzd();
        zzjkVar.zzb = zzmeVarZzd;
        return zzmeVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmf<UT, UB> zzmfVar, Object obj2) {
        zzjo zzjoVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzmg.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzjoVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzjoVarZzd, (zzjo) ub, (zzmf<UT, zzjo>) zzmfVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjo zzjoVar, UB ub, zzmf<UT, UB> zzmfVar, Object obj) {
        zzkk<?, ?> zzkkVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjoVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmfVar.zzc(obj);
                }
                zzif zzifVarZzc = zzia.zzc(zzkl.zza(zzkkVarZza, next.getKey(), next.getValue()));
                try {
                    zzkl.zza(zzifVarZzc.zzb(), zzkkVarZza, next.getKey(), next.getValue());
                    zzmfVar.zza((zzmf<UT, UB>) ub, i2, zzifVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzll zzllVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((zzkx<T>) t, i)) {
            return zzllVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzllVarZze.zza();
        if (object != null) {
            zzllVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzll zzllVarZze = zze(i2);
        if (!zzc((zzkx<T>) t, i, i2)) {
            return zzllVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzllVarZze.zza();
        if (object != null) {
            zzllVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzkx(int[] iArr, Object[] objArr, int i, int i2, zzkt zzktVar, zzle zzleVar, boolean z, int[] iArr2, int i3, int i4, zzlb zzlbVar, zzkd zzkdVar, zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkm zzkmVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzktVar instanceof zzjk;
        this.zzh = zzizVar != null && zzizVar.zza(zzktVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzlbVar;
        this.zzo = zzkdVar;
        this.zzp = zzmfVar;
        this.zzq = zzizVar;
        this.zzg = zzktVar;
        this.zzr = zzkmVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(T t) {
        if (zzg(t)) {
            if (t instanceof zzjk) {
                zzjk zzjkVar = (zzjk) t;
                zzjkVar.zzc(Integer.MAX_VALUE);
                zzjkVar.zza = 0;
                zzjkVar.zzcl();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzc = zzc(i);
                long j = 1048575 & iZzc;
                int i2 = (iZzc & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 == 60 || i2 == 68) {
                        if (zzc((zzkx<T>) t, this.zzc[i], i)) {
                            zze(i).zzc(zzb.getObject(t, j));
                        }
                    } else {
                        switch (i2) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzo.zzb(t, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzr.zzc(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                } else if (zzc((zzkx<T>) t, i)) {
                    zze(i).zzc(zzb.getObject(t, j));
                }
            }
            this.zzp.zzf(t);
            if (this.zzh) {
                this.zzq.zzc(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza(t, j, zzmg.zza(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzb(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zzc(t, j, zzmg.zzh(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzln.zza(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzc((zzkx<T>) t2, i2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc((zzkx<T>) t2, i2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzln.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzln.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:220:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05a9 A[Catch: all -> 0x05ce, TryCatch #6 {all -> 0x05ce, blocks: (B:166:0x05a4, B:168:0x05a9, B:169:0x05ae), top: B:203:0x05a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05df A[LOOP:1: B:186:0x05db->B:188:0x05df, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0576 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzli zzliVar, zzix zzixVar) throws Throwable {
        T t2;
        int i;
        Object objZza;
        zziz<?> zzizVar;
        zzkx<T> zzkxVar;
        zzix zzixVar2;
        T t3;
        Object objZza2;
        zzkx<T> zzkxVar2 = this;
        zzix zzixVar3 = zzixVar;
        zzixVar3.getClass();
        zzf(t);
        zzmf zzmfVar = zzkxVar2.zzp;
        zziz<?> zzizVar2 = zzkxVar2.zzq;
        Object objZza3 = null;
        Object objZzb = null;
        while (true) {
            try {
                int iZzc = zzliVar.zzc();
                int iZza = zzkxVar2.zza(iZzc);
                if (iZza >= 0) {
                    zzizVar = zzizVar2;
                    zzkxVar = zzkxVar2;
                    zzixVar2 = zzixVar3;
                    t3 = t;
                    int iZzc2 = zzkxVar.zzc(iZza);
                    switch ((267386880 & iZzc2) >>> 20) {
                        case 0:
                            zzmg.zza(t3, iZzc2 & 1048575, zzliVar.zza());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 1:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzb());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 2:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzl());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 3:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzo());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 4:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzg());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 5:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzk());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 6:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzf());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 7:
                            zzmg.zzc(t3, iZzc2 & 1048575, zzliVar.zzs());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 8:
                            zzkxVar.zza((Object) t3, iZzc2, zzliVar);
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 9:
                            zzkt zzktVar = (zzkt) zzkxVar.zza((zzkx<T>) t3, iZza);
                            zzliVar.zzb((zzli) zzktVar, (zzll<zzli>) zzkxVar.zze(iZza), zzixVar2);
                            zzkxVar.zza((zzkx<T>) t3, iZza, zzktVar);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 10:
                            zzmg.zza(t3, iZzc2 & 1048575, zzliVar.zzp());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 11:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzj());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 12:
                            int iZze = zzliVar.zze();
                            zzjo zzjoVarZzd = zzkxVar.zzd(iZza);
                            if (zzjoVarZzd == null || zzjoVarZzd.zza(iZze)) {
                                zzmg.zza((Object) t3, iZzc2 & 1048575, iZze);
                                zzkxVar.zzb((zzkx<T>) t3, iZza);
                            } else {
                                objZza3 = zzln.zza(t3, iZzc, iZze, objZza3, zzmfVar);
                            }
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                            break;
                        case 13:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzh());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 14:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzm());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 15:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzi());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 16:
                            zzmg.zza((Object) t3, iZzc2 & 1048575, zzliVar.zzn());
                            zzkxVar.zzb((zzkx<T>) t3, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 17:
                            zzkt zzktVar2 = (zzkt) zzkxVar.zza((zzkx<T>) t3, iZza);
                            zzliVar.zza((zzli) zzktVar2, (zzll<zzli>) zzkxVar.zze(iZza), zzixVar2);
                            zzkxVar.zza((zzkx<T>) t3, iZza, zzktVar2);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 18:
                            zzliVar.zzc(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 19:
                            zzliVar.zzg(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 20:
                            zzliVar.zzi(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 21:
                            zzliVar.zzq(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 22:
                            zzliVar.zzh(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 23:
                            zzliVar.zzf(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 24:
                            zzliVar.zze(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 25:
                            zzliVar.zza(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 26:
                            if (zzg(iZzc2)) {
                                zzliVar.zzo(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            } else {
                                zzliVar.zzn(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            }
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 27:
                            zzliVar.zzb((List) zzkxVar.zzo.zza(t3, iZzc2 & 1048575), (zzll) zzkxVar.zze(iZza), zzixVar2);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 28:
                            zzliVar.zzb(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 29:
                            zzliVar.zzp(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 30:
                            List<Integer> listZza = zzkxVar.zzo.zza(t3, iZzc2 & 1048575);
                            zzliVar.zzd(listZza);
                            zzjo zzjoVarZzd2 = zzkxVar.zzd(iZza);
                            Object obj = objZza3;
                            zzmf zzmfVar2 = zzmfVar;
                            objZza2 = zzln.zza(t3, iZzc, listZza, zzjoVarZzd2, obj, zzmfVar2);
                            zzmfVar = zzmfVar2;
                            objZza3 = objZza2;
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 31:
                            zzliVar.zzj(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 32:
                            zzliVar.zzk(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 33:
                            zzliVar.zzl(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 34:
                            zzliVar.zzm(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 35:
                            zzliVar.zzc(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 36:
                            zzliVar.zzg(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 37:
                            zzliVar.zzi(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 38:
                            zzliVar.zzq(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 39:
                            zzliVar.zzh(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 40:
                            zzliVar.zzf(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 41:
                            zzliVar.zze(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 42:
                            zzliVar.zza(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 43:
                            zzliVar.zzp(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 44:
                            List<Integer> listZza2 = zzkxVar.zzo.zza(t3, iZzc2 & 1048575);
                            zzliVar.zzd(listZza2);
                            zzjo zzjoVarZzd3 = zzkxVar.zzd(iZza);
                            Object obj2 = objZza3;
                            zzmf zzmfVar3 = zzmfVar;
                            try {
                                objZza2 = zzln.zza(t3, iZzc, listZza2, zzjoVarZzd3, obj2, zzmfVar3);
                                zzmfVar = zzmfVar3;
                                objZza3 = objZza2;
                                zzkxVar2 = zzkxVar;
                            } catch (zzjv unused) {
                                objZza3 = obj2;
                                zzmfVar = zzmfVar3;
                                t2 = t3;
                                zzkxVar2 = zzkxVar;
                                try {
                                    zzmfVar.zza(zzliVar);
                                    if (objZza3 == null) {
                                    }
                                    if (zzmfVar.zza((zzmf) objZza3, zzliVar)) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objZza3 = obj2;
                                zzmfVar = zzmfVar3;
                                t2 = t3;
                                zzkxVar2 = zzkxVar;
                                i = zzkxVar2.zzl;
                                objZza = objZza3;
                                while (i < zzkxVar2.zzm) {
                                }
                                if (objZza != null) {
                                }
                                throw th;
                            }
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                            break;
                        case 45:
                            zzliVar.zzj(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 46:
                            zzliVar.zzk(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 47:
                            zzliVar.zzl(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 48:
                            zzliVar.zzm(zzkxVar.zzo.zza(t3, iZzc2 & 1048575));
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 49:
                            zzliVar.zza((List) zzkxVar.zzo.zza(t3, iZzc2 & 1048575), (zzll) zzkxVar.zze(iZza), zzixVar2);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 50:
                            Object objZzf = zzkxVar.zzf(iZza);
                            long jZzc = zzkxVar.zzc(iZza) & 1048575;
                            Object objZze = zzmg.zze(t3, jZzc);
                            if (objZze == null) {
                                objZze = zzkxVar.zzr.zzb(objZzf);
                                zzmg.zza(t3, jZzc, objZze);
                            } else if (zzkxVar.zzr.zzf(objZze)) {
                                Object objZzb2 = zzkxVar.zzr.zzb(objZzf);
                                zzkxVar.zzr.zza(objZzb2, objZze);
                                zzmg.zza(t3, jZzc, objZzb2);
                                objZze = objZzb2;
                            }
                            zzliVar.zza(zzkxVar.zzr.zze(objZze), zzkxVar.zzr.zza(objZzf), zzixVar2);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 51:
                            zzmg.zza(t3, iZzc2 & 1048575, Double.valueOf(zzliVar.zza()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 52:
                            zzmg.zza(t3, iZzc2 & 1048575, Float.valueOf(zzliVar.zzb()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 53:
                            zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzl()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 54:
                            zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzo()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 55:
                            zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzg()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 56:
                            zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzk()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 57:
                            zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzf()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 58:
                            zzmg.zza(t3, iZzc2 & 1048575, Boolean.valueOf(zzliVar.zzs()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 59:
                            zzkxVar.zza((Object) t3, iZzc2, zzliVar);
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 60:
                            zzkt zzktVar3 = (zzkt) zzkxVar.zza((zzkx<T>) t3, iZzc, iZza);
                            zzliVar.zzb((zzli) zzktVar3, (zzll<zzli>) zzkxVar.zze(iZza), zzixVar2);
                            zzkxVar.zza((zzkx<T>) t3, iZzc, iZza, zzktVar3);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 61:
                            zzmg.zza(t3, iZzc2 & 1048575, zzliVar.zzp());
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 62:
                            zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzj()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 63:
                            int iZze2 = zzliVar.zze();
                            zzjo zzjoVarZzd4 = zzkxVar.zzd(iZza);
                            if (zzjoVarZzd4 == null || zzjoVarZzd4.zza(iZze2)) {
                                zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(iZze2));
                                zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            } else {
                                objZza3 = zzln.zza(t3, iZzc, iZze2, objZza3, zzmfVar);
                            }
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                            break;
                        case 64:
                            zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzh()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 65:
                            zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzm()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 66:
                            zzmg.zza(t3, iZzc2 & 1048575, Integer.valueOf(zzliVar.zzi()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 67:
                            zzmg.zza(t3, iZzc2 & 1048575, Long.valueOf(zzliVar.zzn()));
                            zzkxVar.zzb((zzkx<T>) t3, iZzc, iZza);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        case 68:
                            zzkt zzktVar4 = (zzkt) zzkxVar.zza((zzkx<T>) t3, iZzc, iZza);
                            zzliVar.zza((zzli) zzktVar4, (zzll<zzli>) zzkxVar.zze(iZza), zzixVar2);
                            zzkxVar.zza((zzkx<T>) t3, iZzc, iZza, zzktVar4);
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                        default:
                            if (objZza3 == null) {
                                try {
                                    objZza3 = zzmfVar.zzc(t3);
                                } catch (zzjv unused2) {
                                    t2 = t3;
                                    zzkxVar2 = zzkxVar;
                                    zzmfVar.zza(zzliVar);
                                    if (objZza3 == null) {
                                        objZza3 = zzmfVar.zzc(t2);
                                    }
                                    if (zzmfVar.zza((zzmf) objZza3, zzliVar)) {
                                        Object objZza4 = objZza3;
                                        for (int i2 = zzkxVar2.zzl; i2 < zzkxVar2.zzm; i2++) {
                                            objZza4 = zzkxVar2.zza((Object) t2, zzkxVar2.zzk[i2], (int) objZza4, (zzmf<UT, int>) zzmfVar, (Object) t);
                                        }
                                        if (objZza4 != null) {
                                            zzmfVar.zzb((Object) t2, (T) objZza4);
                                            return;
                                        }
                                        return;
                                    }
                                    zzixVar3 = zzixVar2;
                                    zzizVar2 = zzizVar;
                                }
                            }
                            if (!zzmfVar.zza((zzmf) objZza3, zzliVar)) {
                                int i3 = zzkxVar.zzl;
                                Object objZza5 = objZza3;
                                while (i3 < zzkxVar.zzm) {
                                    T t4 = t3;
                                    objZza5 = zzkxVar.zza((Object) t4, zzkxVar.zzk[i3], (int) objZza5, (zzmf<UT, int>) zzmfVar, (Object) t);
                                    i3++;
                                    t3 = t4;
                                }
                                T t5 = t3;
                                if (objZza5 != null) {
                                    zzmfVar.zzb((Object) t5, (T) objZza5);
                                    return;
                                }
                                return;
                            }
                            zzkxVar2 = zzkxVar;
                            zzixVar3 = zzixVar2;
                            zzizVar2 = zzizVar;
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    int i4 = zzkxVar2.zzl;
                    Object objZza6 = objZza3;
                    while (i4 < zzkxVar2.zzm) {
                        objZza6 = zzkxVar2.zza((Object) t, zzkxVar2.zzk[i4], (int) objZza6, (zzmf<UT, int>) zzmfVar, (Object) t);
                        i4++;
                        zzkxVar2 = zzkxVar2;
                    }
                    zzkxVar = zzkxVar2;
                    if (objZza6 != null) {
                        zzmfVar.zzb((Object) t, (T) objZza6);
                    }
                } else {
                    zzkxVar = zzkxVar2;
                    t3 = t;
                    try {
                        Object objZza7 = !zzkxVar.zzh ? null : zzizVar2.zza(zzixVar3, zzkxVar.zzg, iZzc);
                        if (objZza7 != null) {
                            if (objZzb == null) {
                                objZzb = zzizVar2.zzb(t3);
                            }
                            zzjd<T> zzjdVar = objZzb;
                            zzmf zzmfVar4 = zzmfVar;
                            try {
                                objZza3 = zzizVar2.zza(t3, zzliVar, objZza7, zzixVar3, zzjdVar, objZza3, zzmfVar4);
                                objZzb = zzjdVar;
                                zzmfVar = zzmfVar4;
                                zzizVar = zzizVar2;
                                zzixVar2 = zzixVar3;
                                zzkxVar2 = zzkxVar;
                                zzixVar3 = zzixVar2;
                                zzizVar2 = zzizVar;
                            } catch (Throwable th3) {
                                th = th3;
                                t2 = t3;
                                zzmfVar = zzmfVar4;
                                zzkxVar2 = zzkxVar;
                                i = zzkxVar2.zzl;
                                objZza = objZza3;
                                while (i < zzkxVar2.zzm) {
                                }
                                if (objZza != null) {
                                }
                                throw th;
                            }
                        } else {
                            zzizVar = zzizVar2;
                            t2 = t3;
                            zzixVar2 = zzixVar3;
                            try {
                                zzmfVar.zza(zzliVar);
                                if (objZza3 == null) {
                                    try {
                                        objZza3 = zzmfVar.zzc(t2);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        zzkxVar2 = zzkxVar;
                                        i = zzkxVar2.zzl;
                                        objZza = objZza3;
                                        while (i < zzkxVar2.zzm) {
                                        }
                                        if (objZza != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (zzmfVar.zza((zzmf) objZza3, zzliVar)) {
                                    zzkxVar2 = zzkxVar;
                                    zzixVar3 = zzixVar2;
                                    zzizVar2 = zzizVar;
                                } else {
                                    Object objZza8 = objZza3;
                                    for (int i5 = zzkxVar.zzl; i5 < zzkxVar.zzm; i5++) {
                                        objZza8 = zzkxVar.zza((Object) t2, zzkxVar.zzk[i5], (int) objZza8, (zzmf<UT, int>) zzmfVar, (Object) t);
                                    }
                                    if (objZza8 != null) {
                                        zzmfVar.zzb((Object) t2, (T) objZza8);
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        t2 = t3;
                        zzkxVar2 = zzkxVar;
                        i = zzkxVar2.zzl;
                        objZza = objZza3;
                        while (i < zzkxVar2.zzm) {
                        }
                        if (objZza != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                t2 = t;
            }
            i = zzkxVar2.zzl;
            objZza = objZza3;
            while (i < zzkxVar2.zzm) {
                objZza = zzkxVar2.zza((Object) t2, zzkxVar2.zzk[i], (int) objZza, (zzmf<UT, int>) zzmfVar, (Object) t);
                i++;
                zzkxVar2 = this;
            }
            if (objZza != null) {
                zzmfVar.zzb((Object) t2, (T) objZza);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, byte[] bArr, int i, int i2, zzhv zzhvVar) throws IOException {
        zza((zzkx<T>) t, bArr, i, i2, 0, zzhvVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((zzkx<T>) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzll zzllVarZze = zze(i);
            if (!zzc((zzkx<T>) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzllVarZze.zza();
                    zzllVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzkx<T>) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzllVarZze.zza();
                zzllVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzllVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc((zzkx<T>) t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzll zzllVarZze = zze(i);
            if (!zzc((zzkx<T>) t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzllVarZze.zza();
                    zzllVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzkx<T>) t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzllVarZze.zza();
                zzllVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzllVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzli zzliVar) throws IOException {
        if (zzg(i)) {
            zzmg.zza(obj, i & 1048575, zzliVar.zzr());
        } else if (this.zzi) {
            zzmg.zza(obj, i & 1048575, zzliVar.zzq());
        } else {
            zzmg.zza(obj, i & 1048575, zzliVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzmg.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzmg.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzmg.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((zzkx<T>) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb((zzkx<T>) t, i, i2);
    }

    private final <K, V> void zza(zzna zznaVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznaVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzna zznaVar) throws IOException {
        if (obj instanceof String) {
            zznaVar.zza(i, (String) obj);
        } else {
            zznaVar.zza(i, (zzia) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:176:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzna zznaVar) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it;
        Map.Entry<?, ?> entry2;
        int i;
        int i2;
        int i3;
        Iterator itZzc;
        Map.Entry<?, ?> entry3;
        zzkx<T> zzkxVar = this;
        int i4 = 1048575;
        if (zznaVar.zza() == 2) {
            zza(zzkxVar.zzp, t, zznaVar);
            if (zzkxVar.zzh) {
                zzjd<T> zzjdVarZza = zzkxVar.zzq.zza(t);
                if (zzjdVarZza.zza.isEmpty()) {
                    itZzc = null;
                    entry3 = null;
                } else {
                    itZzc = zzjdVarZza.zzc();
                    entry3 = (Map.Entry) itZzc.next();
                }
            }
            for (int length = zzkxVar.zzc.length - 3; length >= 0; length -= 3) {
                int iZzc = zzkxVar.zzc(length);
                int i5 = zzkxVar.zzc[length];
                while (entry3 != null && zzkxVar.zzq.zza(entry3) > i5) {
                    zzkxVar.zzq.zza(zznaVar, entry3);
                    entry3 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
                }
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, zzmg.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, zzmg.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzb(i5, zzmg.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zze(i5, zzmg.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzc(i5, zzmg.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, zzmg.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzb(i5, zzmg.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, zzmg.zzh(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zza(i5, zzmg.zze(t, iZzc & 1048575), zznaVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzb(i5, zzmg.zze(t, iZzc & 1048575), zzkxVar.zze(length));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, (zzia) zzmg.zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzf(i5, zzmg.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, zzmg.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzd(i5, zzmg.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzc(i5, zzmg.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zze(i5, zzmg.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zzd(i5, zzmg.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzkxVar.zzc((zzkx<T>) t, length)) {
                            zznaVar.zza(i5, zzmg.zze(t, iZzc & 1048575), zzkxVar.zze(length));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzln.zzb(zzkxVar.zzc[length], (List<Double>) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 19:
                        zzln.zzf(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 20:
                        zzln.zzh(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 21:
                        zzln.zzn(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 22:
                        zzln.zzg(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 23:
                        zzln.zze(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 24:
                        zzln.zzd(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 25:
                        zzln.zza(zzkxVar.zzc[length], (List<Boolean>) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 26:
                        zzln.zzb(zzkxVar.zzc[length], (List<String>) zzmg.zze(t, iZzc & 1048575), zznaVar);
                        break;
                    case 27:
                        zzln.zzb(zzkxVar.zzc[length], (List<?>) zzmg.zze(t, iZzc & 1048575), zznaVar, zzkxVar.zze(length));
                        break;
                    case 28:
                        zzln.zza(zzkxVar.zzc[length], (List<zzia>) zzmg.zze(t, iZzc & 1048575), zznaVar);
                        break;
                    case 29:
                        zzln.zzm(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 30:
                        zzln.zzc(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 31:
                        zzln.zzi(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 32:
                        zzln.zzj(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 33:
                        zzln.zzk(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 34:
                        zzln.zzl(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, false);
                        break;
                    case 35:
                        zzln.zzb(zzkxVar.zzc[length], (List<Double>) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 36:
                        zzln.zzf(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 37:
                        zzln.zzh(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 38:
                        zzln.zzn(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 39:
                        zzln.zzg(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 40:
                        zzln.zze(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 41:
                        zzln.zzd(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 42:
                        zzln.zza(zzkxVar.zzc[length], (List<Boolean>) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 43:
                        zzln.zzm(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 44:
                        zzln.zzc(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 45:
                        zzln.zzi(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 46:
                        zzln.zzj(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 47:
                        zzln.zzk(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 48:
                        zzln.zzl(zzkxVar.zzc[length], (List) zzmg.zze(t, iZzc & 1048575), zznaVar, true);
                        break;
                    case 49:
                        zzln.zza(zzkxVar.zzc[length], (List<?>) zzmg.zze(t, iZzc & 1048575), zznaVar, zzkxVar.zze(length));
                        break;
                    case 50:
                        zzkxVar.zza(zznaVar, i5, zzmg.zze(t, iZzc & 1048575), length);
                        break;
                    case 51:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzb(i5, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zze(i5, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzc(i5, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzb(i5, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zza(i5, zzmg.zze(t, iZzc & 1048575), zznaVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzb(i5, zzmg.zze(t, iZzc & 1048575), zzkxVar.zze(length));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, (zzia) zzmg.zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzf(i5, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzd(i5, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzc(i5, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zze(i5, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zzd(i5, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzkxVar.zzc((zzkx<T>) t, i5, length)) {
                            zznaVar.zza(i5, zzmg.zze(t, iZzc & 1048575), zzkxVar.zze(length));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry3 != null) {
                zzkxVar.zzq.zza(zznaVar, entry3);
                entry3 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
            }
            return;
        }
        if (zzkxVar.zzh) {
            zzjd<T> zzjdVarZza2 = zzkxVar.zzq.zza(t);
            if (zzjdVarZza2.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzd = zzjdVarZza2.zzd();
                entry = (Map.Entry) itZzd.next();
                it = itZzd;
            }
        }
        int length2 = zzkxVar.zzc.length;
        Unsafe unsafe = zzb;
        int i6 = 0;
        int i7 = 1048575;
        int i8 = 0;
        while (i6 < length2) {
            int iZzc2 = zzkxVar.zzc(i6);
            int[] iArr = zzkxVar.zzc;
            int i9 = iArr[i6];
            int i10 = (iZzc2 & 267386880) >>> 20;
            if (i10 <= 17) {
                int i11 = iArr[i6 + 2];
                int i12 = i11 & i4;
                if (i12 != i7) {
                    i8 = i12 == i4 ? 0 : unsafe.getInt(t, i12);
                    i7 = i12;
                }
                int i13 = 1 << (i11 >>> 20);
                entry2 = entry;
                i = i7;
                i2 = i8;
                i3 = i13;
            } else {
                entry2 = entry;
                i = i7;
                i2 = i8;
                i3 = 0;
            }
            while (entry2 != null && zzkxVar.zzq.zza(entry2) <= i9) {
                zzkxVar.zzq.zza(zznaVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            Iterator it2 = it;
            long j = iZzc2 & i4;
            switch (i10) {
                case 0:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, zzmg.zza(t, j));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, zzmg.zzb(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 2:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzb(i9, unsafe.getLong(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 3:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zze(i9, unsafe.getLong(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 4:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzc(i9, unsafe.getInt(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 5:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, unsafe.getLong(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 6:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzb(i9, unsafe.getInt(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 7:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, zzmg.zzh(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 8:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zza(i9, unsafe.getObject(t, j), zznaVar);
                    }
                    zzkxVar = this;
                    break;
                case 9:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzb(i9, unsafe.getObject(t, j), zzkxVar.zze(i6));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, (zzia) unsafe.getObject(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 11:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzf(i9, unsafe.getInt(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 12:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, unsafe.getInt(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 13:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzd(i9, unsafe.getInt(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 14:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzc(i9, unsafe.getLong(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 15:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zze(i9, unsafe.getInt(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 16:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zzd(i9, unsafe.getLong(t, j));
                    }
                    zzkxVar = this;
                    break;
                case 17:
                    if (zzkxVar.zza((zzkx<T>) t, i6, i, i2, i3)) {
                        zznaVar.zza(i9, unsafe.getObject(t, j), zzkxVar.zze(i6));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzln.zzb(zzkxVar.zzc[i6], (List<Double>) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 19:
                    zzln.zzf(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 20:
                    zzln.zzh(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 21:
                    zzln.zzn(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 22:
                    zzln.zzg(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 23:
                    zzln.zze(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 24:
                    zzln.zzd(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 25:
                    zzln.zza(zzkxVar.zzc[i6], (List<Boolean>) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 26:
                    zzln.zzb(zzkxVar.zzc[i6], (List<String>) unsafe.getObject(t, j), zznaVar);
                    break;
                case 27:
                    zzln.zzb(zzkxVar.zzc[i6], (List<?>) unsafe.getObject(t, j), zznaVar, zzkxVar.zze(i6));
                    break;
                case 28:
                    zzln.zza(zzkxVar.zzc[i6], (List<zzia>) unsafe.getObject(t, j), zznaVar);
                    break;
                case 29:
                    zzln.zzm(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 30:
                    zzln.zzc(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 31:
                    zzln.zzi(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 32:
                    zzln.zzj(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 33:
                    zzln.zzk(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 34:
                    zzln.zzl(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, false);
                    break;
                case 35:
                    zzln.zzb(zzkxVar.zzc[i6], (List<Double>) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 36:
                    zzln.zzf(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 37:
                    zzln.zzh(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 38:
                    zzln.zzn(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 39:
                    zzln.zzg(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 40:
                    zzln.zze(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 41:
                    zzln.zzd(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 42:
                    zzln.zza(zzkxVar.zzc[i6], (List<Boolean>) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 43:
                    zzln.zzm(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 44:
                    zzln.zzc(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 45:
                    zzln.zzi(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 46:
                    zzln.zzj(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 47:
                    zzln.zzk(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 48:
                    zzln.zzl(zzkxVar.zzc[i6], (List) unsafe.getObject(t, j), zznaVar, true);
                    break;
                case 49:
                    zzln.zza(zzkxVar.zzc[i6], (List<?>) unsafe.getObject(t, j), zznaVar, zzkxVar.zze(i6));
                    break;
                case 50:
                    zzkxVar.zza(zznaVar, i9, unsafe.getObject(t, j), i6);
                    break;
                case 51:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, zza(t, j));
                    }
                    break;
                case 52:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, zzb(t, j));
                    }
                    break;
                case 53:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzb(i9, zzd(t, j));
                    }
                    break;
                case 54:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zze(i9, zzd(t, j));
                    }
                    break;
                case 55:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzc(i9, zzc(t, j));
                    }
                    break;
                case 56:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, zzd(t, j));
                    }
                    break;
                case 57:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzb(i9, zzc(t, j));
                    }
                    break;
                case 58:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, zze(t, j));
                    }
                    break;
                case 59:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zza(i9, unsafe.getObject(t, j), zznaVar);
                    }
                    break;
                case 60:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzb(i9, unsafe.getObject(t, j), zzkxVar.zze(i6));
                    }
                    break;
                case 61:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, (zzia) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzf(i9, zzc(t, j));
                    }
                    break;
                case 63:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, zzc(t, j));
                    }
                    break;
                case 64:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzd(i9, zzc(t, j));
                    }
                    break;
                case 65:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzc(i9, zzd(t, j));
                    }
                    break;
                case 66:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zze(i9, zzc(t, j));
                    }
                    break;
                case 67:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zzd(i9, zzd(t, j));
                    }
                    break;
                case 68:
                    if (zzkxVar.zzc((zzkx<T>) t, i9, i6)) {
                        zznaVar.zza(i9, unsafe.getObject(t, j), zzkxVar.zze(i6));
                    }
                    break;
            }
            i6 += 3;
            i8 = i2;
            it = it2;
            i4 = 1048575;
            i7 = i;
            entry = entry2;
        }
        Iterator it3 = it;
        while (entry != null) {
            zzkxVar.zzq.zza(zznaVar, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
        }
        zza(zzkxVar.zzp, t, zznaVar);
    }

    private static <UT, UB> void zza(zzmf<UT, UB> zzmfVar, T t, zzna zznaVar) throws IOException {
        zzmfVar.zzb((zzmf<UT, UB>) zzmfVar.zzd(t), zznaVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((zzkx<T>) t, i) == zzc((zzkx<T>) t2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzb(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean zZza = true;
            if (i < length) {
                int iZzc = zzc(i);
                long j = iZzc & 1048575;
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzmg.zza(t, j)) != Double.doubleToLongBits(zzmg.zza(t2, j))) {
                            zZza = false;
                            break;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzmg.zzb(t, j)) != Float.floatToIntBits(zzmg.zzb(t2, j))) {
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zzmg.zzh(t, j) != zzmg.zzh(t2, j)) {
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zzmg.zzc(t, j) != zzmg.zzc(t2, j)) {
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zzmg.zzd(t, j) != zzmg.zzd(t2, j)) {
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zZza = zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j));
                        break;
                    case 50:
                        zZza = zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long jZzb = zzb(i) & 1048575;
                        if (zzmg.zzc(t, jZzb) != zzmg.zzc(t2, jZzb) || !zzln.zza(zzmg.zze(t, j), zzmg.zze(t2, j))) {
                        }
                        break;
                }
                if (!zZza) {
                    return false;
                }
                i += 3;
            } else {
                if (!this.zzp.zzd(t).equals(this.zzp.zzd(t2))) {
                    return false;
                }
                if (this.zzh) {
                    return this.zzq.zza(t).equals(this.zzq.zza(t2));
                }
                return true;
            }
        }
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzmg.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmg.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmg.zzb(t, j2)) != 0;
            case 2:
                return zzmg.zzd(t, j2) != 0;
            case 3:
                return zzmg.zzd(t, j2) != 0;
            case 4:
                return zzmg.zzc(t, j2) != 0;
            case 5:
                return zzmg.zzd(t, j2) != 0;
            case 6:
                return zzmg.zzc(t, j2) != 0;
            case 7:
                return zzmg.zzh(t, j2);
            case 8:
                Object objZze = zzmg.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzia) {
                    return !zzia.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmg.zze(t, j2) != null;
            case 10:
                return !zzia.zza.equals(zzmg.zze(t, j2));
            case 11:
                return zzmg.zzc(t, j2) != 0;
            case 12:
                return zzmg.zzc(t, j2) != 0;
            case 13:
                return zzmg.zzc(t, j2) != 0;
            case 14:
                return zzmg.zzd(t, j2) != 0;
            case 15:
                return zzmg.zzc(t, j2) != 0;
            case 16:
                return zzmg.zzd(t, j2) != 0;
            case 17:
                return zzmg.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((zzkx<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.gms.internal.measurement.zzll] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.google.android.gms.internal.measurement.zzll] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(T t) {
        int i;
        int i2;
        zzkx<T> zzkxVar;
        T t2;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < this.zzl) {
            int i6 = this.zzk[i3];
            int i7 = this.zzc[i6];
            int iZzc = zzc(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i4) {
                if (i9 != 1048575) {
                    i5 = zzb.getInt(t, i9);
                }
                i2 = i5;
                i = i9;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzc) != 0) {
                zzkxVar = this;
                t2 = t;
                if (!zzkxVar.zza((zzkx<T>) t2, i6, i, i2, i10)) {
                    return false;
                }
            } else {
                zzkxVar = this;
                t2 = t;
            }
            int i11 = (267386880 & iZzc) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zzkxVar.zza((zzkx<T>) t2, i6, i, i2, i10) && !zza((Object) t2, iZzc, zze(i6))) {
                    return false;
                }
            } else if (i11 == 27) {
                List list = (List) zzmg.zze(t2, iZzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? Zze = zze(i6);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!Zze.zzd(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (i11 == 60 || i11 == 68) {
                if (zzc((zzkx<T>) t2, i7, i6) && !zza((Object) t2, iZzc, zze(i6))) {
                    return false;
                }
            } else if (i11 != 49) {
                if (i11 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzd = zzkxVar.zzr.zzd(zzmg.zze(t2, iZzc & 1048575));
                    if (mapZzd.isEmpty()) {
                        continue;
                    } else if (zzkxVar.zzr.zza(zzf(i6)).zzc.zzb() == zzmx.MESSAGE) {
                        ?? Zza = 0;
                        for (Object obj : mapZzd.values()) {
                            Zza = Zza;
                            if (Zza == 0) {
                                Zza = zzlh.zza().zza((Class) obj.getClass());
                            }
                            if (!Zza.zzd(obj)) {
                                return false;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            i3++;
            t = t2;
            i4 = i;
            i5 = i2;
        }
        return !this.zzh || this.zzq.zza(t).zzg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzll zzllVar) {
        return zzllVar.zzd(zzmg.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjk) {
            return ((zzjk) obj).zzcn();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzmg.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzmg.zze(t, j)).booleanValue();
    }
}
