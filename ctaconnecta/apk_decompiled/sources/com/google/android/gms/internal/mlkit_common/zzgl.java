package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.mlkit_common.zzez;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgl<T> implements zzgy<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhw.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgh zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgq zzo;
    private final zzfr zzp;
    private final zzhq<?, ?> zzq;
    private final zzeq<?> zzr;
    private final zzge zzs;

    private zzgl(int[] iArr, Object[] objArr, int i, int i2, zzgh zzghVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgq zzgqVar, zzfr zzfrVar, zzhq<?, ?> zzhqVar, zzeq<?> zzeqVar, zzge zzgeVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzghVar instanceof zzez;
        this.zzj = z;
        this.zzh = zzeqVar != null && zzeqVar.zza(zzghVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgqVar;
        this.zzp = zzfrVar;
        this.zzq = zzhqVar;
        this.zzr = zzeqVar;
        this.zzg = zzghVar;
        this.zzs = zzgeVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0381  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> zzgl<T> zza(Class<T> cls, zzgf zzgfVar, zzgq zzgqVar, zzfr zzfrVar, zzhq<?, ?> zzhqVar, zzeq<?> zzeqVar, zzge zzgeVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        char cCharAt;
        int i5;
        char cCharAt2;
        int i6;
        char cCharAt3;
        int i7;
        char cCharAt4;
        int i8;
        char cCharAt5;
        int i9;
        char cCharAt6;
        int i10;
        char cCharAt7;
        int i11;
        char cCharAt8;
        int i12;
        int i13;
        int i14;
        int iObjectFieldOffset;
        String str;
        int iObjectFieldOffset2;
        int i15;
        int i16;
        int i17;
        Field fieldZza;
        char cCharAt9;
        int i18;
        Object obj;
        Field fieldZza2;
        Object obj2;
        Field fieldZza3;
        int i19;
        char cCharAt10;
        int i20;
        char cCharAt11;
        int i21;
        int i22;
        char cCharAt12;
        int i23;
        char cCharAt13;
        if (zzgfVar instanceof zzgv) {
            zzgv zzgvVar = (zzgv) zzgfVar;
            int i24 = 0;
            boolean z = zzgvVar.zza() == zzez.zzf.zzi;
            String strZzd = zzgvVar.zzd();
            int length = strZzd.length();
            if (strZzd.charAt(0) >= 55296) {
                int i25 = 1;
                while (true) {
                    i = i25 + 1;
                    if (strZzd.charAt(i25) < 55296) {
                        break;
                    }
                    i25 = i;
                }
            } else {
                i = 1;
            }
            int i26 = i + 1;
            int iCharAt5 = strZzd.charAt(i);
            if (iCharAt5 >= 55296) {
                int i27 = iCharAt5 & 8191;
                int i28 = 13;
                while (true) {
                    i23 = i26 + 1;
                    cCharAt13 = strZzd.charAt(i26);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i27 |= (cCharAt13 & 8191) << i28;
                    i28 += 13;
                    i26 = i23;
                }
                iCharAt5 = i27 | (cCharAt13 << i28);
                i26 = i23;
            }
            if (iCharAt5 == 0) {
                iArr = zza;
                i3 = 0;
                iCharAt = 0;
                iCharAt2 = 0;
                iCharAt3 = 0;
                i2 = 0;
                iCharAt4 = 0;
            } else {
                int i29 = i26 + 1;
                int iCharAt6 = strZzd.charAt(i26);
                if (iCharAt6 >= 55296) {
                    int i30 = iCharAt6 & 8191;
                    int i31 = 13;
                    while (true) {
                        i11 = i29 + 1;
                        cCharAt8 = strZzd.charAt(i29);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i30 |= (cCharAt8 & 8191) << i31;
                        i31 += 13;
                        i29 = i11;
                    }
                    iCharAt6 = i30 | (cCharAt8 << i31);
                    i29 = i11;
                }
                int i32 = i29 + 1;
                int iCharAt7 = strZzd.charAt(i29);
                if (iCharAt7 >= 55296) {
                    int i33 = iCharAt7 & 8191;
                    int i34 = 13;
                    while (true) {
                        i10 = i32 + 1;
                        cCharAt7 = strZzd.charAt(i32);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i33 |= (cCharAt7 & 8191) << i34;
                        i34 += 13;
                        i32 = i10;
                    }
                    iCharAt7 = i33 | (cCharAt7 << i34);
                    i32 = i10;
                }
                int i35 = i32 + 1;
                iCharAt = strZzd.charAt(i32);
                if (iCharAt >= 55296) {
                    int i36 = iCharAt & 8191;
                    int i37 = 13;
                    while (true) {
                        i9 = i35 + 1;
                        cCharAt6 = strZzd.charAt(i35);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i36 |= (cCharAt6 & 8191) << i37;
                        i37 += 13;
                        i35 = i9;
                    }
                    iCharAt = i36 | (cCharAt6 << i37);
                    i35 = i9;
                }
                int i38 = i35 + 1;
                iCharAt2 = strZzd.charAt(i35);
                if (iCharAt2 >= 55296) {
                    int i39 = iCharAt2 & 8191;
                    int i40 = 13;
                    while (true) {
                        i8 = i38 + 1;
                        cCharAt5 = strZzd.charAt(i38);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i39 |= (cCharAt5 & 8191) << i40;
                        i40 += 13;
                        i38 = i8;
                    }
                    iCharAt2 = i39 | (cCharAt5 << i40);
                    i38 = i8;
                }
                int i41 = i38 + 1;
                iCharAt3 = strZzd.charAt(i38);
                if (iCharAt3 >= 55296) {
                    int i42 = iCharAt3 & 8191;
                    int i43 = 13;
                    while (true) {
                        i7 = i41 + 1;
                        cCharAt4 = strZzd.charAt(i41);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i42 |= (cCharAt4 & 8191) << i43;
                        i43 += 13;
                        i41 = i7;
                    }
                    iCharAt3 = i42 | (cCharAt4 << i43);
                    i41 = i7;
                }
                int i44 = i41 + 1;
                int iCharAt8 = strZzd.charAt(i41);
                if (iCharAt8 >= 55296) {
                    int i45 = iCharAt8 & 8191;
                    int i46 = 13;
                    while (true) {
                        i6 = i44 + 1;
                        cCharAt3 = strZzd.charAt(i44);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i45 |= (cCharAt3 & 8191) << i46;
                        i46 += 13;
                        i44 = i6;
                    }
                    iCharAt8 = i45 | (cCharAt3 << i46);
                    i44 = i6;
                }
                int i47 = i44 + 1;
                int iCharAt9 = strZzd.charAt(i44);
                if (iCharAt9 >= 55296) {
                    int i48 = iCharAt9 & 8191;
                    int i49 = 13;
                    while (true) {
                        i5 = i47 + 1;
                        cCharAt2 = strZzd.charAt(i47);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i48 |= (cCharAt2 & 8191) << i49;
                        i49 += 13;
                        i47 = i5;
                    }
                    iCharAt9 = i48 | (cCharAt2 << i49);
                    i47 = i5;
                }
                int i50 = i47 + 1;
                iCharAt4 = strZzd.charAt(i47);
                if (iCharAt4 >= 55296) {
                    int i51 = iCharAt4 & 8191;
                    int i52 = i50;
                    int i53 = 13;
                    while (true) {
                        i4 = i52 + 1;
                        cCharAt = strZzd.charAt(i52);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i51 |= (cCharAt & 8191) << i53;
                        i53 += 13;
                        i52 = i4;
                    }
                    iCharAt4 = i51 | (cCharAt << i53);
                    i50 = i4;
                }
                int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
                i2 = (iCharAt6 << 1) + iCharAt7;
                i3 = iCharAt8;
                iArr = iArr2;
                i24 = iCharAt6;
                i26 = i50;
            }
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzgvVar.zze();
            Class<?> cls2 = zzgvVar.zzc().getClass();
            int[] iArr3 = new int[iCharAt3 * 3];
            Object[] objArr = new Object[iCharAt3 << 1];
            int i54 = i3 + iCharAt4;
            int i55 = i54;
            int i56 = iCharAt4;
            int i57 = 0;
            int i58 = 0;
            while (i26 < length) {
                int i59 = i26 + 1;
                int iCharAt10 = strZzd.charAt(i26);
                zzgv zzgvVar2 = zzgvVar;
                if (iCharAt10 >= 55296) {
                    int i60 = iCharAt10 & 8191;
                    int i61 = i59;
                    int i62 = 13;
                    while (true) {
                        i22 = i61 + 1;
                        cCharAt12 = strZzd.charAt(i61);
                        i12 = length;
                        if (cCharAt12 < 55296) {
                            break;
                        }
                        i60 |= (cCharAt12 & 8191) << i62;
                        i62 += 13;
                        i61 = i22;
                        length = i12;
                    }
                    iCharAt10 = i60 | (cCharAt12 << i62);
                    i13 = i22;
                } else {
                    i12 = length;
                    i13 = i59;
                }
                int i63 = i13 + 1;
                int iCharAt11 = strZzd.charAt(i13);
                if (iCharAt11 >= 55296) {
                    int i64 = iCharAt11 & 8191;
                    int i65 = i63;
                    int i66 = 13;
                    while (true) {
                        i20 = i65 + 1;
                        cCharAt11 = strZzd.charAt(i65);
                        i21 = i64;
                        if (cCharAt11 < 55296) {
                            break;
                        }
                        i64 = i21 | ((cCharAt11 & 8191) << i66);
                        i66 += 13;
                        i65 = i20;
                    }
                    iCharAt11 = i21 | (cCharAt11 << i66);
                    i14 = i20;
                } else {
                    i14 = i63;
                }
                int i67 = i24;
                int i68 = iCharAt11 & 255;
                int i69 = iCharAt10;
                if ((iCharAt11 & 1024) != 0) {
                    iArr[i57] = i58;
                    i57++;
                }
                int[] iArr4 = iArr3;
                if (i68 >= 51) {
                    int i70 = i14 + 1;
                    int iCharAt12 = strZzd.charAt(i14);
                    char c = 55296;
                    if (iCharAt12 >= 55296) {
                        int i71 = iCharAt12 & 8191;
                        int i72 = 13;
                        while (true) {
                            i19 = i70 + 1;
                            cCharAt10 = strZzd.charAt(i70);
                            if (cCharAt10 < c) {
                                break;
                            }
                            i71 |= (cCharAt10 & 8191) << i72;
                            i72 += 13;
                            i70 = i19;
                            c = 55296;
                        }
                        iCharAt12 = i71 | (cCharAt10 << i72);
                        i70 = i19;
                    }
                    int i73 = i68 - 51;
                    int i74 = iCharAt12;
                    if (i73 == 9 || i73 == 17) {
                        i18 = i2 + 1;
                        objArr[((i58 / 3) << 1) + 1] = objArrZze[i2];
                    } else {
                        if (i73 == 12 && !z) {
                            i18 = i2 + 1;
                            objArr[((i58 / 3) << 1) + 1] = objArrZze[i2];
                        }
                        int i75 = i74 << 1;
                        obj = objArrZze[i75];
                        if (!(obj instanceof Field)) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZze[i75] = fieldZza2;
                        }
                        int i76 = i70;
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza2);
                        int i77 = i75 + 1;
                        obj2 = objArrZze[i77];
                        if (!(obj2 instanceof Field)) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZze[i77] = fieldZza3;
                        }
                        str = strZzd;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                        i26 = i76;
                        i17 = iObjectFieldOffset3;
                        i16 = 0;
                    }
                    i2 = i18;
                    int i752 = i74 << 1;
                    obj = objArrZze[i752];
                    if (!(obj instanceof Field)) {
                    }
                    int i762 = i70;
                    int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldZza2);
                    int i772 = i752 + 1;
                    obj2 = objArrZze[i772];
                    if (!(obj2 instanceof Field)) {
                    }
                    str = strZzd;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    i26 = i762;
                    i17 = iObjectFieldOffset32;
                    i16 = 0;
                } else {
                    int i78 = i2 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i2]);
                    if (i68 == 9 || i68 == 17) {
                        objArr[((i58 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i68 == 27 || i68 == 49) {
                            i2 += 2;
                            objArr[((i58 / 3) << 1) + 1] = objArrZze[i78];
                        } else if (i68 == 12 || i68 == 30 || i68 == 44) {
                            if (!z) {
                                i2 += 2;
                                objArr[((i58 / 3) << 1) + 1] = objArrZze[i78];
                            }
                        } else if (i68 == 50) {
                            int i79 = i56 + 1;
                            iArr[i56] = i58;
                            int i80 = (i58 / 3) << 1;
                            int i81 = i2 + 2;
                            objArr[i80] = objArrZze[i78];
                            if ((iCharAt11 & 2048) != 0) {
                                objArr[i80 + 1] = objArrZze[i81];
                                i2 += 3;
                            } else {
                                i2 = i81;
                            }
                            i56 = i79;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((iCharAt11 & 4096) == 4096 || i68 > 17) {
                            str = strZzd;
                            iObjectFieldOffset2 = 1048575;
                            i15 = i14;
                            i16 = 0;
                        } else {
                            int i82 = i14 + 1;
                            int iCharAt13 = strZzd.charAt(i14);
                            if (iCharAt13 >= 55296) {
                                int i83 = iCharAt13 & 8191;
                                int i84 = 13;
                                while (true) {
                                    i15 = i82 + 1;
                                    cCharAt9 = strZzd.charAt(i82);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i83 |= (cCharAt9 & 8191) << i84;
                                    i84 += 13;
                                    i82 = i15;
                                }
                                iCharAt13 = i83 | (cCharAt9 << i84);
                            } else {
                                i15 = i82;
                            }
                            int i85 = (i67 << 1) + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i85];
                            str = strZzd;
                            if (obj3 instanceof Field) {
                                fieldZza = (Field) obj3;
                            } else {
                                fieldZza = zza(cls2, (String) obj3);
                                objArrZze[i85] = fieldZza;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                            i16 = iCharAt13 % 32;
                        }
                        if (i68 >= 18 && i68 <= 49) {
                            iArr[i55] = iObjectFieldOffset;
                            i55++;
                        }
                        i17 = iObjectFieldOffset;
                        i26 = i15;
                    }
                    i2 = i78;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((iCharAt11 & 4096) == 4096) {
                        str = strZzd;
                        iObjectFieldOffset2 = 1048575;
                        i15 = i14;
                        i16 = 0;
                        if (i68 >= 18) {
                            iArr[i55] = iObjectFieldOffset;
                            i55++;
                        }
                        i17 = iObjectFieldOffset;
                        i26 = i15;
                    }
                }
                int i86 = i58 + 1;
                iArr4[i58] = i69;
                int i87 = i58 + 2;
                int i88 = iObjectFieldOffset2;
                iArr4[i86] = ((iCharAt11 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i68 << 20) | i17;
                i58 += 3;
                iArr4[i87] = (i16 << 20) | i88;
                i24 = i67;
                zzgvVar = zzgvVar2;
                length = i12;
                iArr3 = iArr4;
                strZzd = str;
            }
            return new zzgl<>(iArr3, objArr, iCharAt, iCharAt2, zzgvVar.zzc(), z, false, iArr, iCharAt4, i54, zzgqVar, zzfrVar, zzhqVar, zzeqVar, zzgeVar);
        }
        ((zzhj) zzgfVar).zza();
        int i89 = zzez.zzf.zzi;
        throw new NoSuchMethodError();
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
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean zZza = true;
            if (i < length) {
                int iZzc = zzc(i);
                long j = iZzc & 1048575;
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzhw.zze(t, j)) != Double.doubleToLongBits(zzhw.zze(t2, j))) {
                            zZza = false;
                            break;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzhw.zzd(t, j)) != Float.floatToIntBits(zzhw.zzd(t2, j))) {
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zzhw.zzb(t, j) != zzhw.zzb(t2, j)) {
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zzhw.zzb(t, j) != zzhw.zzb(t2, j)) {
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zzhw.zza(t, j) != zzhw.zza(t2, j)) {
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zzhw.zzb(t, j) != zzhw.zzb(t2, j)) {
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zzhw.zza(t, j) != zzhw.zza(t2, j)) {
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zzhw.zzc(t, j) != zzhw.zzc(t2, j)) {
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j))) {
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j))) {
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j))) {
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zzhw.zza(t, j) != zzhw.zza(t2, j)) {
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zzhw.zza(t, j) != zzhw.zza(t2, j)) {
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zzhw.zza(t, j) != zzhw.zza(t2, j)) {
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zzhw.zzb(t, j) != zzhw.zzb(t2, j)) {
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zzhw.zza(t, j) != zzhw.zza(t2, j)) {
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zzhw.zzb(t, j) != zzhw.zzb(t2, j)) {
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j))) {
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
                        zZza = zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j));
                        break;
                    case 50:
                        zZza = zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j));
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
                        long jZzd = zzd(i) & 1048575;
                        if (zzhw.zza(t, jZzd) != zzhw.zza(t2, jZzd) || !zzha.zza(zzhw.zzf(t, j), zzhw.zzf(t2, j))) {
                        }
                        break;
                }
                if (!zZza) {
                    return false;
                }
                i += 3;
            } else {
                if (!this.zzq.zza(t).equals(this.zzq.zza(t2))) {
                    return false;
                }
                if (this.zzh) {
                    return this.zzr.zza(t).equals(this.zzr.zza(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final int zza(T t) {
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
                    iZza = zzfc.zza(Double.doubleToLongBits(zzhw.zze(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzhw.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzfc.zza(zzhw.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzfc.zza(zzhw.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzhw.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzfc.zza(zzhw.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzhw.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzfc.zza(zzhw.zzc(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzhw.zzf(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZzf = zzhw.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzhw.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzhw.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzhw.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzhw.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzfc.zza(zzhw.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzhw.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzfc.zza(zzhw.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZzf2 = zzhw.zzf(t, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
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
                    iZza = zzhw.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzhw.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(Double.doubleToLongBits(zzb(t, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzc(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(zzf(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzhw.zzf(t, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzhw.zzf(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzhw.zzf(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfc.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzgl<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzhw.zzf(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzq.zza(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzr.zza(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zzb(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza(t, j, zzhw.zze(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zzd(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zzb(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zzb(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zza(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zzb(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zza(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza(t, j, zzhw.zzc(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza(t, j, zzhw.zzf(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza(t, j, zzhw.zzf(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zza(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zza(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zza(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zzb(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zza(t2, j));
                        zzb((zzgl<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzgl<T>) t2, i)) {
                        zzhw.zza((Object) t, j, zzhw.zzb(t2, j));
                        zzb((zzgl<T>) t, i);
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
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzha.zza(this.zzs, t, t2, j);
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
                    if (zza((zzgl<T>) t2, i2, i)) {
                        zzhw.zza(t, j, zzhw.zzf(t2, j));
                        zzb((zzgl<T>) t, i2, i);
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
                    if (zza((zzgl<T>) t2, i2, i)) {
                        zzhw.zza(t, j, zzhw.zzf(t2, j));
                        zzb((zzgl<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzha.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzha.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzc = zzc(i) & 1048575;
        if (zza((zzgl<T>) t2, i)) {
            Object objZzf = zzhw.zzf(t, jZzc);
            Object objZzf2 = zzhw.zzf(t2, jZzc);
            if (objZzf != null && objZzf2 != null) {
                zzhw.zza(t, jZzc, zzfc.zza(objZzf, objZzf2));
                zzb((zzgl<T>) t, i);
            } else if (objZzf2 != null) {
                zzhw.zza(t, jZzc, objZzf2);
                zzb((zzgl<T>) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzc = zzc(i);
        int i2 = this.zzc[i];
        long j = iZzc & 1048575;
        if (zza((zzgl<T>) t2, i2, i)) {
            Object objZzf = zzhw.zzf(t, j);
            Object objZzf2 = zzhw.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zzhw.zza(t, j, zzfc.zza(objZzf, objZzf2));
                zzb((zzgl<T>) t, i2, i);
            } else if (objZzf2 != null) {
                zzhw.zza(t, j, objZzf2);
                zzb((zzgl<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final int zzb(T t) {
        int i;
        int i2;
        int iZzd;
        int iZzb;
        int iZzj;
        int iZzi;
        int iZze;
        int iZzg;
        int iZzb2;
        int iZzi2;
        int iZze2;
        int iZzg2;
        int i3 = 267386880;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.zzc.length) {
                int iZzc = zzc(i4);
                int i6 = (iZzc & i3) >>> 20;
                int i7 = this.zzc[i4];
                long j = iZzc & 1048575;
                int i8 = (i6 < zzew.DOUBLE_LIST_PACKED.zza() || i6 > zzew.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzb(i7, 0.0d);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzb(i7, 0.0f);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzd(i7, zzhw.zzb(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zze(i7, zzhw.zzb(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzf(i7, zzhw.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzg(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzi(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzb(i7, true);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzgl<T>) t, i4)) {
                            Object objZzf = zzhw.zzf(t, j);
                            if (objZzf instanceof zzdv) {
                                iZzb2 = zzem.zzc(i7, (zzdv) objZzf);
                            } else {
                                iZzb2 = zzem.zzb(i7, (String) objZzf);
                            }
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzha.zza(i7, zzhw.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzc(i7, (zzdv) zzhw.zzf(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzg(i7, zzhw.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzk(i7, zzhw.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzj(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzh(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzh(i7, zzhw.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzf(i7, zzhw.zzb(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzgl<T>) t, i4)) {
                            iZzb2 = zzem.zzc(i7, (zzgh) zzhw.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        iZzb2 = zzha.zzi(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 19:
                        iZzb2 = zzha.zzh(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 20:
                        iZzb2 = zzha.zza(i7, (List<Long>) zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 21:
                        iZzb2 = zzha.zzb(i7, (List<Long>) zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 22:
                        iZzb2 = zzha.zze(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 23:
                        iZzb2 = zzha.zzi(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 24:
                        iZzb2 = zzha.zzh(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 25:
                        iZzb2 = zzha.zzj(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 26:
                        iZzb2 = zzha.zza(i7, zza(t, j));
                        i5 += iZzb2;
                        break;
                    case 27:
                        iZzb2 = zzha.zza(i7, zza(t, j), zza(i4));
                        i5 += iZzb2;
                        break;
                    case 28:
                        iZzb2 = zzha.zzb(i7, zza(t, j));
                        i5 += iZzb2;
                        break;
                    case 29:
                        iZzb2 = zzha.zzf(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 30:
                        iZzb2 = zzha.zzd(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 31:
                        iZzb2 = zzha.zzh(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 32:
                        iZzb2 = zzha.zzi(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 33:
                        iZzb2 = zzha.zzg(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 34:
                        iZzb2 = zzha.zzc(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 35:
                        iZzi2 = zzha.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 36:
                        iZzi2 = zzha.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 37:
                        iZzi2 = zzha.zza((List<Long>) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 38:
                        iZzi2 = zzha.zzb((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 39:
                        iZzi2 = zzha.zze((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 40:
                        iZzi2 = zzha.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 41:
                        iZzi2 = zzha.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 42:
                        iZzi2 = zzha.zzj((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 43:
                        iZzi2 = zzha.zzf((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 44:
                        iZzi2 = zzha.zzd((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 45:
                        iZzi2 = zzha.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 46:
                        iZzi2 = zzha.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 47:
                        iZzi2 = zzha.zzg((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 48:
                        iZzi2 = zzha.zzc((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzem.zze(i7);
                            iZzg2 = zzem.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 49:
                        iZzb2 = zzha.zzb(i7, (List<zzgh>) zza(t, j), zza(i4));
                        i5 += iZzb2;
                        break;
                    case 50:
                        iZzb2 = this.zzs.zza(i7, zzhw.zzf(t, j), zzb(i4));
                        i5 += iZzb2;
                        break;
                    case 51:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzb(i7, 0.0d);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzb(i7, 0.0f);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzd(i7, zze(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zze(i7, zze(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzf(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzg(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzi(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzb(i7, true);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            Object objZzf2 = zzhw.zzf(t, j);
                            if (objZzf2 instanceof zzdv) {
                                iZzb2 = zzem.zzc(i7, (zzdv) objZzf2);
                            } else {
                                iZzb2 = zzem.zzb(i7, (String) objZzf2);
                            }
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzha.zza(i7, zzhw.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzc(i7, (zzdv) zzhw.zzf(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzg(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzk(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzj(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzh(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzh(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzf(i7, zze(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzgl<T>) t, i7, i4)) {
                            iZzb2 = zzem.zzc(i7, (zzgh) zzhw.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + zza((zzhq) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int iZzb3 = 0;
        int i9 = 1048575;
        int i10 = 0;
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int iZzc2 = zzc(i11);
            int[] iArr = this.zzc;
            int i12 = iArr[i11];
            int i13 = (iZzc2 & 267386880) >>> 20;
            if (i13 <= 17) {
                i = iArr[i11 + 2];
                int i14 = i & 1048575;
                i2 = 1 << (i >>> 20);
                if (i14 != i9) {
                    i10 = unsafe2.getInt(t, i14);
                    i9 = i14;
                }
            } else {
                i = (!this.zzk || i13 < zzew.DOUBLE_LIST_PACKED.zza() || i13 > zzew.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i11 + 2] & 1048575;
                i2 = 0;
            }
            long j2 = iZzc2 & 1048575;
            switch (i13) {
                case 0:
                    if ((i10 & i2) != 0) {
                        iZzb3 += zzem.zzb(i12, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i10 & i2) != 0) {
                        iZzb3 += zzem.zzb(i12, 0.0f);
                    }
                    break;
                case 2:
                    if ((i10 & i2) != 0) {
                        iZzd = zzem.zzd(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 3:
                    if ((i10 & i2) != 0) {
                        iZzd = zzem.zze(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 4:
                    if ((i10 & i2) != 0) {
                        iZzd = zzem.zzf(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 5:
                    if ((i10 & i2) != 0) {
                        iZzd = zzem.zzg(i12, 0L);
                        iZzb3 += iZzd;
                    }
                    break;
                case 6:
                    if ((i10 & i2) != 0) {
                        iZzd = zzem.zzi(i12, 0);
                        iZzb3 += iZzd;
                        break;
                    }
                case 7:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzb(i12, true);
                        iZzb3 += iZzb;
                    }
                    break;
                case 8:
                    if ((i10 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzdv) {
                            iZzb = zzem.zzc(i12, (zzdv) object);
                        } else {
                            iZzb = zzem.zzb(i12, (String) object);
                        }
                        iZzb3 += iZzb;
                    }
                    break;
                case 9:
                    if ((i10 & i2) != 0) {
                        iZzb = zzha.zza(i12, unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 10:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzc(i12, (zzdv) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 11:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzg(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 12:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzk(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 13:
                    if ((i10 & i2) != 0) {
                        iZzj = zzem.zzj(i12, 0);
                        iZzb3 += iZzj;
                    }
                    break;
                case 14:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzh(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 15:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzh(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 16:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzf(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 17:
                    if ((i10 & i2) != 0) {
                        iZzb = zzem.zzc(i12, (zzgh) unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 18:
                    iZzb = zzha.zzi(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 19:
                    iZzb = zzha.zzh(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 20:
                    iZzb = zzha.zza(i12, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 21:
                    iZzb = zzha.zzb(i12, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 22:
                    iZzb = zzha.zze(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 23:
                    iZzb = zzha.zzi(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 24:
                    iZzb = zzha.zzh(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 25:
                    iZzb = zzha.zzj(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 26:
                    iZzb = zzha.zza(i12, (List<?>) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    break;
                case 27:
                    iZzb = zzha.zza(i12, (List<?>) unsafe2.getObject(t, j2), zza(i11));
                    iZzb3 += iZzb;
                    break;
                case 28:
                    iZzb = zzha.zzb(i12, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    break;
                case 29:
                    iZzb = zzha.zzf(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 30:
                    iZzb = zzha.zzd(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 31:
                    iZzb = zzha.zzh(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 32:
                    iZzb = zzha.zzi(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 33:
                    iZzb = zzha.zzg(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 34:
                    iZzb = zzha.zzc(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 35:
                    iZzi = zzha.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 36:
                    iZzi = zzha.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 37:
                    iZzi = zzha.zza((List<Long>) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 38:
                    iZzi = zzha.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 39:
                    iZzi = zzha.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 40:
                    iZzi = zzha.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 41:
                    iZzi = zzha.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 42:
                    iZzi = zzha.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 43:
                    iZzi = zzha.zzf((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 44:
                    iZzi = zzha.zzd((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 45:
                    iZzi = zzha.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 46:
                    iZzi = zzha.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 47:
                    iZzi = zzha.zzg((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 48:
                    iZzi = zzha.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzem.zze(i12);
                        iZzg = zzem.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 49:
                    iZzb = zzha.zzb(i12, (List<zzgh>) unsafe2.getObject(t, j2), zza(i11));
                    iZzb3 += iZzb;
                    break;
                case 50:
                    iZzb = this.zzs.zza(i12, unsafe2.getObject(t, j2), zzb(i11));
                    iZzb3 += iZzb;
                    break;
                case 51:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzb(i12, 0.0d);
                        iZzb3 += iZzb;
                    }
                    break;
                case 52:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzj = zzem.zzb(i12, 0.0f);
                        iZzb3 += iZzj;
                    }
                    break;
                case 53:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzd(i12, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 54:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zze(i12, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 55:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzf(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 56:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzg(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 57:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzj = zzem.zzi(i12, 0);
                        iZzb3 += iZzj;
                    }
                    break;
                case 58:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzb(i12, true);
                        iZzb3 += iZzb;
                    }
                    break;
                case 59:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzdv) {
                            iZzb = zzem.zzc(i12, (zzdv) object2);
                        } else {
                            iZzb = zzem.zzb(i12, (String) object2);
                        }
                        iZzb3 += iZzb;
                    }
                    break;
                case 60:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzha.zza(i12, unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 61:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzc(i12, (zzdv) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 62:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzg(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 63:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzk(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 64:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzj = zzem.zzj(i12, 0);
                        iZzb3 += iZzj;
                    }
                    break;
                case 65:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzh(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 66:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzh(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 67:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzf(i12, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 68:
                    if (zza((zzgl<T>) t, i12, i11)) {
                        iZzb = zzem.zzc(i12, (zzgh) unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
            }
        }
        int iZza = 0;
        int iZza2 = iZzb3 + zza((zzhq) this.zzq, (Object) t);
        if (!this.zzh) {
            return iZza2;
        }
        zzer<T> zzerVarZza = this.zzr.zza(t);
        for (int i15 = 0; i15 < zzerVarZza.zza.zzc(); i15++) {
            Map.Entry entryZzb = zzerVarZza.zza.zzb(i15);
            iZza += zzer.zza((zzet<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        for (Map.Entry entry : zzerVarZza.zza.zzd()) {
            iZza += zzer.zza((zzet<?>) entry.getKey(), entry.getValue());
        }
        return iZza2 + iZza;
    }

    private static <UT, UB> int zza(zzhq<UT, UB> zzhqVar, T t) {
        return zzhqVar.zzd(zzhqVar.zza(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzhw.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzik zzikVar) throws IOException {
        Iterator itZzd;
        Map.Entry<?, ?> entry;
        Iterator itZze;
        Map.Entry<?, ?> entry2;
        if (zzikVar.zza() == zzez.zzf.zzk) {
            zza(this.zzq, t, zzikVar);
            if (this.zzh) {
                zzer<T> zzerVarZza = this.zzr.zza(t);
                if (zzerVarZza.zza.isEmpty()) {
                    itZze = null;
                    entry2 = null;
                } else {
                    itZze = zzerVarZza.zze();
                    entry2 = (Map.Entry) itZze.next();
                }
            }
            for (int length = this.zzc.length - 3; length >= 0; length -= 3) {
                int iZzc = zzc(length);
                int i = this.zzc[length];
                while (entry2 != null && this.zzr.zza(entry2) > i) {
                    this.zzr.zza(zzikVar, entry2);
                    entry2 = itZze.hasNext() ? (Map.Entry) itZze.next() : null;
                }
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, zzhw.zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, zzhw.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, zzhw.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzc(i, zzhw.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzc(i, zzhw.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzd(i, zzhw.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzd(i, zzhw.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, zzhw.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzgl<T>) t, length)) {
                            zza(i, zzhw.zzf(t, iZzc & 1048575), zzikVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, zzhw.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, (zzdv) zzhw.zzf(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zze(i, zzhw.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzb(i, zzhw.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zza(i, zzhw.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzb(i, zzhw.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzf(i, zzhw.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zze(i, zzhw.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzgl<T>) t, length)) {
                            zzikVar.zzb(i, zzhw.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzha.zza(this.zzc[length], (List<Double>) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 19:
                        zzha.zzb(this.zzc[length], (List<Float>) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 20:
                        zzha.zzc(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 21:
                        zzha.zzd(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 22:
                        zzha.zzh(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 23:
                        zzha.zzf(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 24:
                        zzha.zzk(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 25:
                        zzha.zzn(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 26:
                        zzha.zza(this.zzc[length], (List<String>) zzhw.zzf(t, iZzc & 1048575), zzikVar);
                        break;
                    case 27:
                        zzha.zza(this.zzc[length], (List<?>) zzhw.zzf(t, iZzc & 1048575), zzikVar, zza(length));
                        break;
                    case 28:
                        zzha.zzb(this.zzc[length], (List<zzdv>) zzhw.zzf(t, iZzc & 1048575), zzikVar);
                        break;
                    case 29:
                        zzha.zzi(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 30:
                        zzha.zzm(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 31:
                        zzha.zzl(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 32:
                        zzha.zzg(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 33:
                        zzha.zzj(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 34:
                        zzha.zze(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, false);
                        break;
                    case 35:
                        zzha.zza(this.zzc[length], (List<Double>) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 36:
                        zzha.zzb(this.zzc[length], (List<Float>) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 37:
                        zzha.zzc(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 38:
                        zzha.zzd(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 39:
                        zzha.zzh(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 40:
                        zzha.zzf(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 41:
                        zzha.zzk(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 42:
                        zzha.zzn(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 43:
                        zzha.zzi(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 44:
                        zzha.zzm(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 45:
                        zzha.zzl(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 46:
                        zzha.zzg(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 47:
                        zzha.zzj(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 48:
                        zzha.zze(this.zzc[length], (List) zzhw.zzf(t, iZzc & 1048575), zzikVar, true);
                        break;
                    case 49:
                        zzha.zzb(this.zzc[length], (List<?>) zzhw.zzf(t, iZzc & 1048575), zzikVar, zza(length));
                        break;
                    case 50:
                        zza(zzikVar, i, zzhw.zzf(t, iZzc & 1048575), length);
                        break;
                    case 51:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzc(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzc(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzd(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzd(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, zzf(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzgl<T>) t, i, length)) {
                            zza(i, zzhw.zzf(t, iZzc & 1048575), zzikVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, zzhw.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, (zzdv) zzhw.zzf(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zze(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzb(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zza(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzb(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzf(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zze(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzgl<T>) t, i, length)) {
                            zzikVar.zzb(i, zzhw.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry2 != null) {
                this.zzr.zza(zzikVar, entry2);
                entry2 = itZze.hasNext() ? (Map.Entry) itZze.next() : null;
            }
            return;
        }
        if (this.zzj) {
            if (this.zzh) {
                zzer<T> zzerVarZza2 = this.zzr.zza(t);
                if (zzerVarZza2.zza.isEmpty()) {
                    itZzd = null;
                    entry = null;
                } else {
                    itZzd = zzerVarZza2.zzd();
                    entry = (Map.Entry) itZzd.next();
                }
            }
            int length2 = this.zzc.length;
            for (int i2 = 0; i2 < length2; i2 += 3) {
                int iZzc2 = zzc(i2);
                int i3 = this.zzc[i2];
                while (entry != null && this.zzr.zza(entry) <= i3) {
                    this.zzr.zza(zzikVar, entry);
                    entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
                }
                switch ((iZzc2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, zzhw.zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, zzhw.zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, zzhw.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzc(i3, zzhw.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzc(i3, zzhw.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzd(i3, zzhw.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzd(i3, zzhw.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, zzhw.zzc(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzgl<T>) t, i2)) {
                            zza(i3, zzhw.zzf(t, iZzc2 & 1048575), zzikVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, zzhw.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, (zzdv) zzhw.zzf(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zze(i3, zzhw.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzb(i3, zzhw.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zza(i3, zzhw.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzb(i3, zzhw.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzf(i3, zzhw.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zze(i3, zzhw.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzgl<T>) t, i2)) {
                            zzikVar.zzb(i3, zzhw.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzha.zza(this.zzc[i2], (List<Double>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 19:
                        zzha.zzb(this.zzc[i2], (List<Float>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 20:
                        zzha.zzc(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 21:
                        zzha.zzd(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 22:
                        zzha.zzh(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 23:
                        zzha.zzf(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 24:
                        zzha.zzk(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 25:
                        zzha.zzn(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 26:
                        zzha.zza(this.zzc[i2], (List<String>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar);
                        break;
                    case 27:
                        zzha.zza(this.zzc[i2], (List<?>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, zza(i2));
                        break;
                    case 28:
                        zzha.zzb(this.zzc[i2], (List<zzdv>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar);
                        break;
                    case 29:
                        zzha.zzi(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 30:
                        zzha.zzm(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 31:
                        zzha.zzl(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 32:
                        zzha.zzg(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 33:
                        zzha.zzj(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 34:
                        zzha.zze(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, false);
                        break;
                    case 35:
                        zzha.zza(this.zzc[i2], (List<Double>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 36:
                        zzha.zzb(this.zzc[i2], (List<Float>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 37:
                        zzha.zzc(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 38:
                        zzha.zzd(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 39:
                        zzha.zzh(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 40:
                        zzha.zzf(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 41:
                        zzha.zzk(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 42:
                        zzha.zzn(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 43:
                        zzha.zzi(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 44:
                        zzha.zzm(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 45:
                        zzha.zzl(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 46:
                        zzha.zzg(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 47:
                        zzha.zzj(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 48:
                        zzha.zze(this.zzc[i2], (List) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, true);
                        break;
                    case 49:
                        zzha.zzb(this.zzc[i2], (List<?>) zzhw.zzf(t, iZzc2 & 1048575), zzikVar, zza(i2));
                        break;
                    case 50:
                        zza(zzikVar, i3, zzhw.zzf(t, iZzc2 & 1048575), i2);
                        break;
                    case 51:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, zzc(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzc(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzc(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzd(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzd(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, zzf(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zza(i3, zzhw.zzf(t, iZzc2 & 1048575), zzikVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, zzhw.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, (zzdv) zzhw.zzf(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zze(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzb(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zza(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzb(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzf(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zze(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzgl<T>) t, i3, i2)) {
                            zzikVar.zzb(i3, zzhw.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry != null) {
                this.zzr.zza(zzikVar, entry);
                entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
            }
            zza(this.zzq, t, zzikVar);
            return;
        }
        zzb((zzgl<T>) t, zzikVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzik zzikVar) throws IOException {
        Iterator itZzd;
        Map.Entry<?, ?> entry;
        int i;
        if (this.zzh) {
            zzer<T> zzerVarZza = this.zzr.zza(t);
            if (zzerVarZza.zza.isEmpty()) {
                itZzd = null;
                entry = null;
            } else {
                itZzd = zzerVarZza.zzd();
                entry = (Map.Entry) itZzd.next();
            }
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzc = zzc(i4);
            int[] iArr = this.zzc;
            int i5 = iArr[i4];
            int i6 = (iZzc & 267386880) >>> 20;
            if (this.zzj || i6 > 17) {
                i = 0;
            } else {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & 1048575;
                if (i8 != i2) {
                    i3 = unsafe.getInt(t, i8);
                    i2 = i8;
                }
                i = 1 << (i7 >>> 20);
            }
            while (entry != null && this.zzr.zza(entry) <= i5) {
                this.zzr.zza(zzikVar, entry);
                entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
            }
            long j = iZzc & 1048575;
            switch (i6) {
                case 0:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, zzhw.zze(t, j));
                        continue;
                    }
                case 1:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, zzhw.zzd(t, j));
                    } else {
                        continue;
                    }
                case 2:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 3:
                    if ((i3 & i) != 0) {
                        zzikVar.zzc(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 4:
                    if ((i3 & i) != 0) {
                        zzikVar.zzc(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 5:
                    if ((i3 & i) != 0) {
                        zzikVar.zzd(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 6:
                    if ((i3 & i) != 0) {
                        zzikVar.zzd(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 7:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, zzhw.zzc(t, j));
                    } else {
                        continue;
                    }
                case 8:
                    if ((i3 & i) != 0) {
                        zza(i5, unsafe.getObject(t, j), zzikVar);
                    } else {
                        continue;
                    }
                case 9:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, unsafe.getObject(t, j), zza(i4));
                    } else {
                        continue;
                    }
                case 10:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, (zzdv) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                case 11:
                    if ((i3 & i) != 0) {
                        zzikVar.zze(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 12:
                    if ((i3 & i) != 0) {
                        zzikVar.zzb(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 13:
                    if ((i3 & i) != 0) {
                        zzikVar.zza(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 14:
                    if ((i3 & i) != 0) {
                        zzikVar.zzb(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 15:
                    if ((i3 & i) != 0) {
                        zzikVar.zzf(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 16:
                    if ((i3 & i) != 0) {
                        zzikVar.zze(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 17:
                    if ((i3 & i) != 0) {
                        zzikVar.zzb(i5, unsafe.getObject(t, j), zza(i4));
                    } else {
                        continue;
                    }
                case 18:
                    zzha.zza(this.zzc[i4], (List<Double>) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 19:
                    zzha.zzb(this.zzc[i4], (List<Float>) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 20:
                    zzha.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 21:
                    zzha.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 22:
                    zzha.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 23:
                    zzha.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 24:
                    zzha.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 25:
                    zzha.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 26:
                    zzha.zza(this.zzc[i4], (List<String>) unsafe.getObject(t, j), zzikVar);
                    break;
                case 27:
                    zzha.zza(this.zzc[i4], (List<?>) unsafe.getObject(t, j), zzikVar, zza(i4));
                    break;
                case 28:
                    zzha.zzb(this.zzc[i4], (List<zzdv>) unsafe.getObject(t, j), zzikVar);
                    break;
                case 29:
                    zzha.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 30:
                    zzha.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 31:
                    zzha.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 32:
                    zzha.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 33:
                    zzha.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 34:
                    zzha.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, false);
                    continue;
                case 35:
                    zzha.zza(this.zzc[i4], (List<Double>) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 36:
                    zzha.zzb(this.zzc[i4], (List<Float>) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 37:
                    zzha.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 38:
                    zzha.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 39:
                    zzha.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 40:
                    zzha.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 41:
                    zzha.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 42:
                    zzha.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 43:
                    zzha.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 44:
                    zzha.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 45:
                    zzha.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 46:
                    zzha.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 47:
                    zzha.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 48:
                    zzha.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zzikVar, true);
                    break;
                case 49:
                    zzha.zzb(this.zzc[i4], (List<?>) unsafe.getObject(t, j), zzikVar, zza(i4));
                    break;
                case 50:
                    zza(zzikVar, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, zzb(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, zzc(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, zze(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzc(i5, zze(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzc(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzd(i5, zze(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzd(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, zzf(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zza(i5, unsafe.getObject(t, j), zzikVar);
                        break;
                    }
                    break;
                case 60:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, unsafe.getObject(t, j), zza(i4));
                        break;
                    }
                    break;
                case 61:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, (zzdv) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zze(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzb(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zza(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzb(i5, zze(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzf(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zze(i5, zze(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zza((zzgl<T>) t, i5, i4)) {
                        zzikVar.zzb(i5, unsafe.getObject(t, j), zza(i4));
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzr.zza(zzikVar, entry);
            entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
        }
        zza(this.zzq, t, zzikVar);
    }

    private final <K, V> void zza(zzik zzikVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzikVar.zza(i, this.zzs.zza(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzhq<UT, UB> zzhqVar, T t, zzik zzikVar) throws IOException {
        zzhqVar.zza((zzhq<UT, UB>) zzhqVar.zza(t), zzikVar);
    }

    private final zzgy zza(int i) {
        int i2 = (i / 3) << 1;
        zzgy zzgyVar = (zzgy) this.zzd[i2];
        if (zzgyVar != null) {
            return zzgyVar;
        }
        zzgy<T> zzgyVarZza = zzgt.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzgyVarZza;
        return zzgyVarZza;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long jZzc = zzc(this.zzl[i2]) & 1048575;
            Object objZzf = zzhw.zzf(t, jZzc);
            if (objZzf != null) {
                zzhw.zza(t, jZzc, this.zzs.zzc(objZzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zza(t, this.zzl[i]);
            i++;
        }
        this.zzq.zzb(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.gms.internal.mlkit_common.zzgy] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.google.android.gms.internal.mlkit_common.zzgy] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(T t) {
        int i;
        int i2;
        zzgl<T> zzglVar;
        T t2;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < this.zzm) {
            int i6 = this.zzl[i3];
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
                zzglVar = this;
                t2 = t;
                if (!zzglVar.zza(t2, i6, i, i2, i10)) {
                    return false;
                }
            } else {
                zzglVar = this;
                t2 = t;
            }
            int i11 = (267386880 & iZzc) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zzglVar.zza(t2, i6, i, i2, i10) && !zza(t2, iZzc, zza(i6))) {
                    return false;
                }
            } else if (i11 == 27) {
                List list = (List) zzhw.zzf(t2, iZzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? Zza = zza(i6);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!Zza.zzd(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (i11 == 60 || i11 == 68) {
                if (zza((zzgl<T>) t2, i7, i6) && !zza(t2, iZzc, zza(i6))) {
                    return false;
                }
            } else if (i11 != 49) {
                if (i11 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzb = zzglVar.zzs.zzb(zzhw.zzf(t2, iZzc & 1048575));
                    if (mapZzb.isEmpty()) {
                        continue;
                    } else if (zzglVar.zzs.zza(zzb(i6)).zzb.zza() == zzih.MESSAGE) {
                        ?? Zza2 = 0;
                        for (Object obj : mapZzb.values()) {
                            Zza2 = Zza2;
                            if (Zza2 == 0) {
                                Zza2 = zzgt.zza().zza((Class) obj.getClass());
                            }
                            if (!Zza2.zzd(obj)) {
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
        return !this.zzh || this.zzr.zza(t).zzf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzgy zzgyVar) {
        return zzgyVar.zzd(zzhw.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzik zzikVar) throws IOException {
        if (obj instanceof String) {
            zzikVar.zza(i, (String) obj);
        } else {
            zzikVar.zza(i, (zzdv) obj);
        }
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private final int zzd(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzhw.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzhw.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzhw.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzhw.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzhw.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzgl<T>) t, i) == zza((zzgl<T>) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzgl<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int iZzd = zzd(i);
        long j = iZzd & 1048575;
        if (j != 1048575) {
            return (zzhw.zza(t, j) & (1 << (iZzd >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return zzhw.zze(t, j2) != 0.0d;
            case 1:
                return zzhw.zzd(t, j2) != 0.0f;
            case 2:
                return zzhw.zzb(t, j2) != 0;
            case 3:
                return zzhw.zzb(t, j2) != 0;
            case 4:
                return zzhw.zza(t, j2) != 0;
            case 5:
                return zzhw.zzb(t, j2) != 0;
            case 6:
                return zzhw.zza(t, j2) != 0;
            case 7:
                return zzhw.zzc(t, j2);
            case 8:
                Object objZzf = zzhw.zzf(t, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdv) {
                    return !zzdv.zza.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhw.zzf(t, j2) != null;
            case 10:
                return !zzdv.zza.equals(zzhw.zzf(t, j2));
            case 11:
                return zzhw.zza(t, j2) != 0;
            case 12:
                return zzhw.zza(t, j2) != 0;
            case 13:
                return zzhw.zza(t, j2) != 0;
            case 14:
                return zzhw.zzb(t, j2) != 0;
            case 15:
                return zzhw.zza(t, j2) != 0;
            case 16:
                return zzhw.zzb(t, j2) != 0;
            case 17:
                return zzhw.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzb(T t, int i) {
        int iZzd = zzd(i);
        long j = 1048575 & iZzd;
        if (j == 1048575) {
            return;
        }
        zzhw.zza((Object) t, j, (1 << (iZzd >>> 20)) | zzhw.zza(t, j));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzhw.zza(t, (long) (zzd(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzhw.zza((Object) t, zzd(i2) & 1048575, i);
    }
}
