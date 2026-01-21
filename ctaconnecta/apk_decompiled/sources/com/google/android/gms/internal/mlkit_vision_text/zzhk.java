package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhk<T> implements zzhx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zziv.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhg zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzhp zzo;
    private final zzgq zzp;
    private final zzip<?, ?> zzq;
    private final zzfp<?> zzr;
    private final zzhd zzs;

    private zzhk(int[] iArr, Object[] objArr, int i, int i2, zzhg zzhgVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhp zzhpVar, zzgq zzgqVar, zzip<?, ?> zzipVar, zzfp<?> zzfpVar, zzhd zzhdVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhgVar instanceof zzfy;
        this.zzj = z;
        this.zzh = zzfpVar != null && zzfpVar.zza(zzhgVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzhpVar;
        this.zzp = zzgqVar;
        this.zzq = zzipVar;
        this.zzr = zzfpVar;
        this.zzg = zzhgVar;
        this.zzs = zzhdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0381  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> zzhk<T> zza(Class<T> cls, zzhe zzheVar, zzhp zzhpVar, zzgq zzgqVar, zzip<?, ?> zzipVar, zzfp<?> zzfpVar, zzhd zzhdVar) {
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
        if (zzheVar instanceof zzhu) {
            zzhu zzhuVar = (zzhu) zzheVar;
            int i24 = 0;
            boolean z = zzhuVar.zza() == zzfy.zzf.zzi;
            String strZzd = zzhuVar.zzd();
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
            Object[] objArrZze = zzhuVar.zze();
            Class<?> cls2 = zzhuVar.zzc().getClass();
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
                zzhu zzhuVar2 = zzhuVar;
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
                zzhuVar = zzhuVar2;
                length = i12;
                iArr3 = iArr4;
                strZzd = str;
            }
            return new zzhk<>(iArr3, objArr, iCharAt, iCharAt2, zzhuVar.zzc(), z, false, iArr, iCharAt4, i54, zzhpVar, zzgqVar, zzipVar, zzfpVar, zzhdVar);
        }
        ((zzii) zzheVar).zza();
        int i89 = zzfy.zzf.zzi;
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
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
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
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zziv.zze(t, j)) != Double.doubleToLongBits(zziv.zze(t2, j))) {
                            zZza = false;
                            break;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zziv.zzd(t, j)) != Float.floatToIntBits(zziv.zzd(t2, j))) {
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zziv.zzb(t, j) != zziv.zzb(t2, j)) {
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zziv.zzb(t, j) != zziv.zzb(t2, j)) {
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zziv.zza(t, j) != zziv.zza(t2, j)) {
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zziv.zzb(t, j) != zziv.zzb(t2, j)) {
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zziv.zza(t, j) != zziv.zza(t2, j)) {
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zziv.zzc(t, j) != zziv.zzc(t2, j)) {
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j))) {
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j))) {
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j))) {
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zziv.zza(t, j) != zziv.zza(t2, j)) {
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zziv.zza(t, j) != zziv.zza(t2, j)) {
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zziv.zza(t, j) != zziv.zza(t2, j)) {
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zziv.zzb(t, j) != zziv.zzb(t2, j)) {
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zziv.zza(t, j) != zziv.zza(t2, j)) {
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zziv.zzb(t, j) != zziv.zzb(t2, j)) {
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j))) {
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
                        zZza = zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j));
                        break;
                    case 50:
                        zZza = zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j));
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
                        if (zziv.zza(t, jZzd) != zziv.zza(t2, jZzd) || !zzhz.zza(zziv.zzf(t, j), zziv.zzf(t2, j))) {
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

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
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
                    iZza = zzgb.zza(Double.doubleToLongBits(zziv.zze(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zziv.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzgb.zza(zziv.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzgb.zza(zziv.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zziv.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzgb.zza(zziv.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zziv.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzgb.zza(zziv.zzc(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zziv.zzf(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZzf = zziv.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zziv.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zziv.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zziv.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zziv.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzgb.zza(zziv.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zziv.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzgb.zza(zziv.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZzf2 = zziv.zzf(t, j);
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
                    iZza = zziv.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zziv.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(Double.doubleToLongBits(zzb(t, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzc(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(zzf(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zziv.zzf(t, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zziv.zzf(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zziv.zzf(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzgb.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzhk<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zziv.zzf(t, j).hashCode();
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

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final void zzb(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza(t, j, zziv.zze(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zzd(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zzb(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zzb(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zza(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zzb(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zza(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza(t, j, zziv.zzc(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza(t, j, zziv.zzf(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza(t, j, zziv.zzf(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zza(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zza(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zza(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zzb(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zza(t2, j));
                        zzb((zzhk<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzhk<T>) t2, i)) {
                        zziv.zza((Object) t, j, zziv.zzb(t2, j));
                        zzb((zzhk<T>) t, i);
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
                    zzhz.zza(this.zzs, t, t2, j);
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
                    if (zza((zzhk<T>) t2, i2, i)) {
                        zziv.zza(t, j, zziv.zzf(t2, j));
                        zzb((zzhk<T>) t, i2, i);
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
                    if (zza((zzhk<T>) t2, i2, i)) {
                        zziv.zza(t, j, zziv.zzf(t2, j));
                        zzb((zzhk<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzhz.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzhz.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzc = zzc(i) & 1048575;
        if (zza((zzhk<T>) t2, i)) {
            Object objZzf = zziv.zzf(t, jZzc);
            Object objZzf2 = zziv.zzf(t2, jZzc);
            if (objZzf != null && objZzf2 != null) {
                zziv.zza(t, jZzc, zzgb.zza(objZzf, objZzf2));
                zzb((zzhk<T>) t, i);
            } else if (objZzf2 != null) {
                zziv.zza(t, jZzc, objZzf2);
                zzb((zzhk<T>) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzc = zzc(i);
        int i2 = this.zzc[i];
        long j = iZzc & 1048575;
        if (zza((zzhk<T>) t2, i2, i)) {
            Object objZzf = zziv.zzf(t, j);
            Object objZzf2 = zziv.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zziv.zza(t, j, zzgb.zza(objZzf, objZzf2));
                zzb((zzhk<T>) t, i2, i);
            } else if (objZzf2 != null) {
                zziv.zza(t, j, objZzf2);
                zzb((zzhk<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
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
                int i8 = (i6 < zzfv.DOUBLE_LIST_PACKED.zza() || i6 > zzfv.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzb(i7, 0.0d);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzb(i7, 0.0f);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzd(i7, zziv.zzb(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zze(i7, zziv.zzb(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzf(i7, zziv.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzg(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzi(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzb(i7, true);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzhk<T>) t, i4)) {
                            Object objZzf = zziv.zzf(t, j);
                            if (objZzf instanceof zzeu) {
                                iZzb2 = zzfl.zzc(i7, (zzeu) objZzf);
                            } else {
                                iZzb2 = zzfl.zzb(i7, (String) objZzf);
                            }
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzhz.zza(i7, zziv.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzc(i7, (zzeu) zziv.zzf(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzg(i7, zziv.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzk(i7, zziv.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzj(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzh(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzh(i7, zziv.zza(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzf(i7, zziv.zzb(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzhk<T>) t, i4)) {
                            iZzb2 = zzfl.zzc(i7, (zzhg) zziv.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        iZzb2 = zzhz.zzi(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 19:
                        iZzb2 = zzhz.zzh(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 20:
                        iZzb2 = zzhz.zza(i7, (List<Long>) zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 21:
                        iZzb2 = zzhz.zzb(i7, (List<Long>) zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 22:
                        iZzb2 = zzhz.zze(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 23:
                        iZzb2 = zzhz.zzi(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 24:
                        iZzb2 = zzhz.zzh(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 25:
                        iZzb2 = zzhz.zzj(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 26:
                        iZzb2 = zzhz.zza(i7, zza(t, j));
                        i5 += iZzb2;
                        break;
                    case 27:
                        iZzb2 = zzhz.zza(i7, zza(t, j), zza(i4));
                        i5 += iZzb2;
                        break;
                    case 28:
                        iZzb2 = zzhz.zzb(i7, zza(t, j));
                        i5 += iZzb2;
                        break;
                    case 29:
                        iZzb2 = zzhz.zzf(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 30:
                        iZzb2 = zzhz.zzd(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 31:
                        iZzb2 = zzhz.zzh(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 32:
                        iZzb2 = zzhz.zzi(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 33:
                        iZzb2 = zzhz.zzg(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 34:
                        iZzb2 = zzhz.zzc(i7, zza(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 35:
                        iZzi2 = zzhz.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 36:
                        iZzi2 = zzhz.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 37:
                        iZzi2 = zzhz.zza((List<Long>) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 38:
                        iZzi2 = zzhz.zzb((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 39:
                        iZzi2 = zzhz.zze((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 40:
                        iZzi2 = zzhz.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 41:
                        iZzi2 = zzhz.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 42:
                        iZzi2 = zzhz.zzj((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 43:
                        iZzi2 = zzhz.zzf((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 44:
                        iZzi2 = zzhz.zzd((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 45:
                        iZzi2 = zzhz.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 46:
                        iZzi2 = zzhz.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 47:
                        iZzi2 = zzhz.zzg((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 48:
                        iZzi2 = zzhz.zzc((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZze2 = zzfl.zze(i7);
                            iZzg2 = zzfl.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i5 += iZzb2;
                            break;
                        }
                    case 49:
                        iZzb2 = zzhz.zzb(i7, (List<zzhg>) zza(t, j), zza(i4));
                        i5 += iZzb2;
                        break;
                    case 50:
                        iZzb2 = this.zzs.zza(i7, zziv.zzf(t, j), zzb(i4));
                        i5 += iZzb2;
                        break;
                    case 51:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzb(i7, 0.0d);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzb(i7, 0.0f);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzd(i7, zze(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zze(i7, zze(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzf(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzg(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzi(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzb(i7, true);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            Object objZzf2 = zziv.zzf(t, j);
                            if (objZzf2 instanceof zzeu) {
                                iZzb2 = zzfl.zzc(i7, (zzeu) objZzf2);
                            } else {
                                iZzb2 = zzfl.zzb(i7, (String) objZzf2);
                            }
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzhz.zza(i7, zziv.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzc(i7, (zzeu) zziv.zzf(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzg(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzk(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzj(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzh(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzh(i7, zzd(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzf(i7, zze(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzhk<T>) t, i7, i4)) {
                            iZzb2 = zzfl.zzc(i7, (zzhg) zziv.zzf(t, j), zza(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + zza((zzip) this.zzq, (Object) t);
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
                i = (!this.zzk || i13 < zzfv.DOUBLE_LIST_PACKED.zza() || i13 > zzfv.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i11 + 2] & 1048575;
                i2 = 0;
            }
            long j2 = iZzc2 & 1048575;
            switch (i13) {
                case 0:
                    if ((i10 & i2) != 0) {
                        iZzb3 += zzfl.zzb(i12, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i10 & i2) != 0) {
                        iZzb3 += zzfl.zzb(i12, 0.0f);
                    }
                    break;
                case 2:
                    if ((i10 & i2) != 0) {
                        iZzd = zzfl.zzd(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 3:
                    if ((i10 & i2) != 0) {
                        iZzd = zzfl.zze(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 4:
                    if ((i10 & i2) != 0) {
                        iZzd = zzfl.zzf(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 5:
                    if ((i10 & i2) != 0) {
                        iZzd = zzfl.zzg(i12, 0L);
                        iZzb3 += iZzd;
                    }
                    break;
                case 6:
                    if ((i10 & i2) != 0) {
                        iZzd = zzfl.zzi(i12, 0);
                        iZzb3 += iZzd;
                        break;
                    }
                case 7:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzb(i12, true);
                        iZzb3 += iZzb;
                    }
                    break;
                case 8:
                    if ((i10 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzeu) {
                            iZzb = zzfl.zzc(i12, (zzeu) object);
                        } else {
                            iZzb = zzfl.zzb(i12, (String) object);
                        }
                        iZzb3 += iZzb;
                    }
                    break;
                case 9:
                    if ((i10 & i2) != 0) {
                        iZzb = zzhz.zza(i12, unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 10:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzc(i12, (zzeu) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 11:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzg(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 12:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzk(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 13:
                    if ((i10 & i2) != 0) {
                        iZzj = zzfl.zzj(i12, 0);
                        iZzb3 += iZzj;
                    }
                    break;
                case 14:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzh(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 15:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzh(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 16:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzf(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 17:
                    if ((i10 & i2) != 0) {
                        iZzb = zzfl.zzc(i12, (zzhg) unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 18:
                    iZzb = zzhz.zzi(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 19:
                    iZzb = zzhz.zzh(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 20:
                    iZzb = zzhz.zza(i12, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 21:
                    iZzb = zzhz.zzb(i12, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 22:
                    iZzb = zzhz.zze(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 23:
                    iZzb = zzhz.zzi(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 24:
                    iZzb = zzhz.zzh(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 25:
                    iZzb = zzhz.zzj(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 26:
                    iZzb = zzhz.zza(i12, (List<?>) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    break;
                case 27:
                    iZzb = zzhz.zza(i12, (List<?>) unsafe2.getObject(t, j2), zza(i11));
                    iZzb3 += iZzb;
                    break;
                case 28:
                    iZzb = zzhz.zzb(i12, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    break;
                case 29:
                    iZzb = zzhz.zzf(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 30:
                    iZzb = zzhz.zzd(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 31:
                    iZzb = zzhz.zzh(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 32:
                    iZzb = zzhz.zzi(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 33:
                    iZzb = zzhz.zzg(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 34:
                    iZzb = zzhz.zzc(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 35:
                    iZzi = zzhz.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 36:
                    iZzi = zzhz.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 37:
                    iZzi = zzhz.zza((List<Long>) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 38:
                    iZzi = zzhz.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 39:
                    iZzi = zzhz.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 40:
                    iZzi = zzhz.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 41:
                    iZzi = zzhz.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 42:
                    iZzi = zzhz.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 43:
                    iZzi = zzhz.zzf((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 44:
                    iZzi = zzhz.zzd((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 45:
                    iZzi = zzhz.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 46:
                    iZzi = zzhz.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 47:
                    iZzi = zzhz.zzg((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 48:
                    iZzi = zzhz.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzfl.zze(i12);
                        iZzg = zzfl.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    break;
                case 49:
                    iZzb = zzhz.zzb(i12, (List<zzhg>) unsafe2.getObject(t, j2), zza(i11));
                    iZzb3 += iZzb;
                    break;
                case 50:
                    iZzb = this.zzs.zza(i12, unsafe2.getObject(t, j2), zzb(i11));
                    iZzb3 += iZzb;
                    break;
                case 51:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzb(i12, 0.0d);
                        iZzb3 += iZzb;
                    }
                    break;
                case 52:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzj = zzfl.zzb(i12, 0.0f);
                        iZzb3 += iZzj;
                    }
                    break;
                case 53:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzd(i12, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 54:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zze(i12, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 55:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzf(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 56:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzg(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 57:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzj = zzfl.zzi(i12, 0);
                        iZzb3 += iZzj;
                    }
                    break;
                case 58:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzb(i12, true);
                        iZzb3 += iZzb;
                    }
                    break;
                case 59:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzeu) {
                            iZzb = zzfl.zzc(i12, (zzeu) object2);
                        } else {
                            iZzb = zzfl.zzb(i12, (String) object2);
                        }
                        iZzb3 += iZzb;
                    }
                    break;
                case 60:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzhz.zza(i12, unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 61:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzc(i12, (zzeu) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 62:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzg(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 63:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzk(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 64:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzj = zzfl.zzj(i12, 0);
                        iZzb3 += iZzj;
                    }
                    break;
                case 65:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzh(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 66:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzh(i12, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 67:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzf(i12, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 68:
                    if (zza((zzhk<T>) t, i12, i11)) {
                        iZzb = zzfl.zzc(i12, (zzhg) unsafe2.getObject(t, j2), zza(i11));
                        iZzb3 += iZzb;
                    }
                    break;
            }
        }
        int iZza = 0;
        int iZza2 = iZzb3 + zza((zzip) this.zzq, (Object) t);
        if (!this.zzh) {
            return iZza2;
        }
        zzfq<T> zzfqVarZza = this.zzr.zza(t);
        for (int i15 = 0; i15 < zzfqVarZza.zza.zzc(); i15++) {
            Map.Entry entryZzb = zzfqVarZza.zza.zzb(i15);
            iZza += zzfq.zza((zzfs<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        for (Map.Entry entry : zzfqVarZza.zza.zzd()) {
            iZza += zzfq.zza((zzfs<?>) entry.getKey(), entry.getValue());
        }
        return iZza2 + iZza;
    }

    private static <UT, UB> int zza(zzip<UT, UB> zzipVar, T t) {
        return zzipVar.zzd(zzipVar.zza(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zziv.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzjj zzjjVar) throws IOException {
        Iterator itZzd;
        Map.Entry<?, ?> entry;
        Iterator itZze;
        Map.Entry<?, ?> entry2;
        if (zzjjVar.zza() == zzfy.zzf.zzk) {
            zza(this.zzq, t, zzjjVar);
            if (this.zzh) {
                zzfq<T> zzfqVarZza = this.zzr.zza(t);
                if (zzfqVarZza.zza.isEmpty()) {
                    itZze = null;
                    entry2 = null;
                } else {
                    itZze = zzfqVarZza.zze();
                    entry2 = (Map.Entry) itZze.next();
                }
            }
            for (int length = this.zzc.length - 3; length >= 0; length -= 3) {
                int iZzc = zzc(length);
                int i = this.zzc[length];
                while (entry2 != null && this.zzr.zza(entry2) > i) {
                    this.zzr.zza(zzjjVar, entry2);
                    entry2 = itZze.hasNext() ? (Map.Entry) itZze.next() : null;
                }
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, zziv.zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, zziv.zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, zziv.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzc(i, zziv.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzc(i, zziv.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzd(i, zziv.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzd(i, zziv.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, zziv.zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzhk<T>) t, length)) {
                            zza(i, zziv.zzf(t, iZzc & 1048575), zzjjVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, zziv.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, (zzeu) zziv.zzf(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zze(i, zziv.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzb(i, zziv.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zza(i, zziv.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzb(i, zziv.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzf(i, zziv.zza(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zze(i, zziv.zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzhk<T>) t, length)) {
                            zzjjVar.zzb(i, zziv.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzhz.zza(this.zzc[length], (List<Double>) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 19:
                        zzhz.zzb(this.zzc[length], (List<Float>) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 20:
                        zzhz.zzc(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 21:
                        zzhz.zzd(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 22:
                        zzhz.zzh(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 23:
                        zzhz.zzf(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 24:
                        zzhz.zzk(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 25:
                        zzhz.zzn(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 26:
                        zzhz.zza(this.zzc[length], (List<String>) zziv.zzf(t, iZzc & 1048575), zzjjVar);
                        break;
                    case 27:
                        zzhz.zza(this.zzc[length], (List<?>) zziv.zzf(t, iZzc & 1048575), zzjjVar, zza(length));
                        break;
                    case 28:
                        zzhz.zzb(this.zzc[length], (List<zzeu>) zziv.zzf(t, iZzc & 1048575), zzjjVar);
                        break;
                    case 29:
                        zzhz.zzi(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 30:
                        zzhz.zzm(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 31:
                        zzhz.zzl(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 32:
                        zzhz.zzg(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 33:
                        zzhz.zzj(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 34:
                        zzhz.zze(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, false);
                        break;
                    case 35:
                        zzhz.zza(this.zzc[length], (List<Double>) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 36:
                        zzhz.zzb(this.zzc[length], (List<Float>) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 37:
                        zzhz.zzc(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 38:
                        zzhz.zzd(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 39:
                        zzhz.zzh(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 40:
                        zzhz.zzf(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 41:
                        zzhz.zzk(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 42:
                        zzhz.zzn(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 43:
                        zzhz.zzi(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 44:
                        zzhz.zzm(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 45:
                        zzhz.zzl(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 46:
                        zzhz.zzg(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 47:
                        zzhz.zzj(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 48:
                        zzhz.zze(this.zzc[length], (List) zziv.zzf(t, iZzc & 1048575), zzjjVar, true);
                        break;
                    case 49:
                        zzhz.zzb(this.zzc[length], (List<?>) zziv.zzf(t, iZzc & 1048575), zzjjVar, zza(length));
                        break;
                    case 50:
                        zza(zzjjVar, i, zziv.zzf(t, iZzc & 1048575), length);
                        break;
                    case 51:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, zzb(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, zzc(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzc(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzc(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzd(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzd(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, zzf(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzhk<T>) t, i, length)) {
                            zza(i, zziv.zzf(t, iZzc & 1048575), zzjjVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, zziv.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, (zzeu) zziv.zzf(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zze(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzb(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zza(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzb(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzf(i, zzd(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zze(i, zze(t, iZzc & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzhk<T>) t, i, length)) {
                            zzjjVar.zzb(i, zziv.zzf(t, iZzc & 1048575), zza(length));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry2 != null) {
                this.zzr.zza(zzjjVar, entry2);
                entry2 = itZze.hasNext() ? (Map.Entry) itZze.next() : null;
            }
            return;
        }
        if (this.zzj) {
            if (this.zzh) {
                zzfq<T> zzfqVarZza2 = this.zzr.zza(t);
                if (zzfqVarZza2.zza.isEmpty()) {
                    itZzd = null;
                    entry = null;
                } else {
                    itZzd = zzfqVarZza2.zzd();
                    entry = (Map.Entry) itZzd.next();
                }
            }
            int length2 = this.zzc.length;
            for (int i2 = 0; i2 < length2; i2 += 3) {
                int iZzc2 = zzc(i2);
                int i3 = this.zzc[i2];
                while (entry != null && this.zzr.zza(entry) <= i3) {
                    this.zzr.zza(zzjjVar, entry);
                    entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
                }
                switch ((iZzc2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, zziv.zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, zziv.zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, zziv.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzc(i3, zziv.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzc(i3, zziv.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzd(i3, zziv.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzd(i3, zziv.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, zziv.zzc(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzhk<T>) t, i2)) {
                            zza(i3, zziv.zzf(t, iZzc2 & 1048575), zzjjVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, zziv.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, (zzeu) zziv.zzf(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zze(i3, zziv.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzb(i3, zziv.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zza(i3, zziv.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzb(i3, zziv.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzf(i3, zziv.zza(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zze(i3, zziv.zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzhk<T>) t, i2)) {
                            zzjjVar.zzb(i3, zziv.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzhz.zza(this.zzc[i2], (List<Double>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 19:
                        zzhz.zzb(this.zzc[i2], (List<Float>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 20:
                        zzhz.zzc(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 21:
                        zzhz.zzd(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 22:
                        zzhz.zzh(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 23:
                        zzhz.zzf(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 24:
                        zzhz.zzk(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 25:
                        zzhz.zzn(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 26:
                        zzhz.zza(this.zzc[i2], (List<String>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar);
                        break;
                    case 27:
                        zzhz.zza(this.zzc[i2], (List<?>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, zza(i2));
                        break;
                    case 28:
                        zzhz.zzb(this.zzc[i2], (List<zzeu>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar);
                        break;
                    case 29:
                        zzhz.zzi(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 30:
                        zzhz.zzm(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 31:
                        zzhz.zzl(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 32:
                        zzhz.zzg(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 33:
                        zzhz.zzj(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 34:
                        zzhz.zze(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, false);
                        break;
                    case 35:
                        zzhz.zza(this.zzc[i2], (List<Double>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 36:
                        zzhz.zzb(this.zzc[i2], (List<Float>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 37:
                        zzhz.zzc(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 38:
                        zzhz.zzd(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 39:
                        zzhz.zzh(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 40:
                        zzhz.zzf(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 41:
                        zzhz.zzk(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 42:
                        zzhz.zzn(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 43:
                        zzhz.zzi(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 44:
                        zzhz.zzm(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 45:
                        zzhz.zzl(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 46:
                        zzhz.zzg(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 47:
                        zzhz.zzj(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 48:
                        zzhz.zze(this.zzc[i2], (List) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, true);
                        break;
                    case 49:
                        zzhz.zzb(this.zzc[i2], (List<?>) zziv.zzf(t, iZzc2 & 1048575), zzjjVar, zza(i2));
                        break;
                    case 50:
                        zza(zzjjVar, i3, zziv.zzf(t, iZzc2 & 1048575), i2);
                        break;
                    case 51:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, zzb(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, zzc(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzc(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzc(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzd(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzd(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, zzf(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zza(i3, zziv.zzf(t, iZzc2 & 1048575), zzjjVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, zziv.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, (zzeu) zziv.zzf(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zze(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzb(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zza(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzb(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzf(i3, zzd(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zze(i3, zze(t, iZzc2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzhk<T>) t, i3, i2)) {
                            zzjjVar.zzb(i3, zziv.zzf(t, iZzc2 & 1048575), zza(i2));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry != null) {
                this.zzr.zza(zzjjVar, entry);
                entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
            }
            zza(this.zzq, t, zzjjVar);
            return;
        }
        zzb((zzhk<T>) t, zzjjVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzjj zzjjVar) throws IOException {
        Iterator itZzd;
        Map.Entry<?, ?> entry;
        int i;
        if (this.zzh) {
            zzfq<T> zzfqVarZza = this.zzr.zza(t);
            if (zzfqVarZza.zza.isEmpty()) {
                itZzd = null;
                entry = null;
            } else {
                itZzd = zzfqVarZza.zzd();
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
                this.zzr.zza(zzjjVar, entry);
                entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
            }
            long j = iZzc & 1048575;
            switch (i6) {
                case 0:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, zziv.zze(t, j));
                        continue;
                    }
                case 1:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, zziv.zzd(t, j));
                    } else {
                        continue;
                    }
                case 2:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 3:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzc(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 4:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzc(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 5:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzd(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 6:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzd(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 7:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, zziv.zzc(t, j));
                    } else {
                        continue;
                    }
                case 8:
                    if ((i3 & i) != 0) {
                        zza(i5, unsafe.getObject(t, j), zzjjVar);
                    } else {
                        continue;
                    }
                case 9:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, unsafe.getObject(t, j), zza(i4));
                    } else {
                        continue;
                    }
                case 10:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, (zzeu) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                case 11:
                    if ((i3 & i) != 0) {
                        zzjjVar.zze(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 12:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzb(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 13:
                    if ((i3 & i) != 0) {
                        zzjjVar.zza(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 14:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzb(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 15:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzf(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 16:
                    if ((i3 & i) != 0) {
                        zzjjVar.zze(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 17:
                    if ((i3 & i) != 0) {
                        zzjjVar.zzb(i5, unsafe.getObject(t, j), zza(i4));
                    } else {
                        continue;
                    }
                case 18:
                    zzhz.zza(this.zzc[i4], (List<Double>) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 19:
                    zzhz.zzb(this.zzc[i4], (List<Float>) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 20:
                    zzhz.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 21:
                    zzhz.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 22:
                    zzhz.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 23:
                    zzhz.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 24:
                    zzhz.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 25:
                    zzhz.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 26:
                    zzhz.zza(this.zzc[i4], (List<String>) unsafe.getObject(t, j), zzjjVar);
                    break;
                case 27:
                    zzhz.zza(this.zzc[i4], (List<?>) unsafe.getObject(t, j), zzjjVar, zza(i4));
                    break;
                case 28:
                    zzhz.zzb(this.zzc[i4], (List<zzeu>) unsafe.getObject(t, j), zzjjVar);
                    break;
                case 29:
                    zzhz.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 30:
                    zzhz.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 31:
                    zzhz.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 32:
                    zzhz.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 33:
                    zzhz.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 34:
                    zzhz.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, false);
                    continue;
                case 35:
                    zzhz.zza(this.zzc[i4], (List<Double>) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 36:
                    zzhz.zzb(this.zzc[i4], (List<Float>) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 37:
                    zzhz.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 38:
                    zzhz.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 39:
                    zzhz.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 40:
                    zzhz.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 41:
                    zzhz.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 42:
                    zzhz.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 43:
                    zzhz.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 44:
                    zzhz.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 45:
                    zzhz.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 46:
                    zzhz.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 47:
                    zzhz.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 48:
                    zzhz.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zzjjVar, true);
                    break;
                case 49:
                    zzhz.zzb(this.zzc[i4], (List<?>) unsafe.getObject(t, j), zzjjVar, zza(i4));
                    break;
                case 50:
                    zza(zzjjVar, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, zzb(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, zzc(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, zze(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzc(i5, zze(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzc(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzd(i5, zze(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzd(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, zzf(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zza(i5, unsafe.getObject(t, j), zzjjVar);
                        break;
                    }
                    break;
                case 60:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, unsafe.getObject(t, j), zza(i4));
                        break;
                    }
                    break;
                case 61:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, (zzeu) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zze(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzb(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zza(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzb(i5, zze(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzf(i5, zzd(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zze(i5, zze(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zza((zzhk<T>) t, i5, i4)) {
                        zzjjVar.zzb(i5, unsafe.getObject(t, j), zza(i4));
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzr.zza(zzjjVar, entry);
            entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
        }
        zza(this.zzq, t, zzjjVar);
    }

    private final <K, V> void zza(zzjj zzjjVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjjVar.zza(i, this.zzs.zza(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzip<UT, UB> zzipVar, T t, zzjj zzjjVar) throws IOException {
        zzipVar.zza((zzip<UT, UB>) zzipVar.zza(t), zzjjVar);
    }

    private final zzhx zza(int i) {
        int i2 = (i / 3) << 1;
        zzhx zzhxVar = (zzhx) this.zzd[i2];
        if (zzhxVar != null) {
            return zzhxVar;
        }
        zzhx<T> zzhxVarZza = zzhs.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzhxVarZza;
        return zzhxVarZza;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long jZzc = zzc(this.zzl[i2]) & 1048575;
            Object objZzf = zziv.zzf(t, jZzc);
            if (objZzf != null) {
                zziv.zza(t, jZzc, this.zzs.zzc(objZzf));
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
    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.gms.internal.mlkit_vision_text.zzhx] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.google.android.gms.internal.mlkit_vision_text.zzhx] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(T t) {
        int i;
        int i2;
        zzhk<T> zzhkVar;
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
                zzhkVar = this;
                t2 = t;
                if (!zzhkVar.zza(t2, i6, i, i2, i10)) {
                    return false;
                }
            } else {
                zzhkVar = this;
                t2 = t;
            }
            int i11 = (267386880 & iZzc) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zzhkVar.zza(t2, i6, i, i2, i10) && !zza(t2, iZzc, zza(i6))) {
                    return false;
                }
            } else if (i11 == 27) {
                List list = (List) zziv.zzf(t2, iZzc & 1048575);
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
                if (zza((zzhk<T>) t2, i7, i6) && !zza(t2, iZzc, zza(i6))) {
                    return false;
                }
            } else if (i11 != 49) {
                if (i11 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzb = zzhkVar.zzs.zzb(zziv.zzf(t2, iZzc & 1048575));
                    if (mapZzb.isEmpty()) {
                        continue;
                    } else if (zzhkVar.zzs.zza(zzb(i6)).zzb.zza() == zzjg.MESSAGE) {
                        ?? Zza2 = 0;
                        for (Object obj : mapZzb.values()) {
                            Zza2 = Zza2;
                            if (Zza2 == 0) {
                                Zza2 = zzhs.zza().zza((Class) obj.getClass());
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
    private static boolean zza(Object obj, int i, zzhx zzhxVar) {
        return zzhxVar.zzd(zziv.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzjj zzjjVar) throws IOException {
        if (obj instanceof String) {
            zzjjVar.zza(i, (String) obj);
        } else {
            zzjjVar.zza(i, (zzeu) obj);
        }
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private final int zzd(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zziv.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zziv.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zziv.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zziv.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zziv.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzhk<T>) t, i) == zza((zzhk<T>) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzhk<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int iZzd = zzd(i);
        long j = iZzd & 1048575;
        if (j != 1048575) {
            return (zziv.zza(t, j) & (1 << (iZzd >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return zziv.zze(t, j2) != 0.0d;
            case 1:
                return zziv.zzd(t, j2) != 0.0f;
            case 2:
                return zziv.zzb(t, j2) != 0;
            case 3:
                return zziv.zzb(t, j2) != 0;
            case 4:
                return zziv.zza(t, j2) != 0;
            case 5:
                return zziv.zzb(t, j2) != 0;
            case 6:
                return zziv.zza(t, j2) != 0;
            case 7:
                return zziv.zzc(t, j2);
            case 8:
                Object objZzf = zziv.zzf(t, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzeu) {
                    return !zzeu.zza.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zziv.zzf(t, j2) != null;
            case 10:
                return !zzeu.zza.equals(zziv.zzf(t, j2));
            case 11:
                return zziv.zza(t, j2) != 0;
            case 12:
                return zziv.zza(t, j2) != 0;
            case 13:
                return zziv.zza(t, j2) != 0;
            case 14:
                return zziv.zzb(t, j2) != 0;
            case 15:
                return zziv.zza(t, j2) != 0;
            case 16:
                return zziv.zzb(t, j2) != 0;
            case 17:
                return zziv.zzf(t, j2) != null;
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
        zziv.zza((Object) t, j, (1 << (iZzd >>> 20)) | zziv.zza(t, j));
    }

    private final boolean zza(T t, int i, int i2) {
        return zziv.zza(t, (long) (zzd(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zziv.zza((Object) t, zzd(i2) & 1048575, i);
    }
}
