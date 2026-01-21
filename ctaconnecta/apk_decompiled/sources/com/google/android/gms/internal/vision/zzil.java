package com.google.android.gms.internal.vision;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzil<T> implements zziw<T> {
    private static final int[] zzzh = new int[0];
    private static final Unsafe zzzi = zzju.zzim();
    private final int[] zzzj;
    private final Object[] zzzk;
    private final int zzzl;
    private final int zzzm;
    private final zzih zzzn;
    private final boolean zzzo;
    private final boolean zzzp;
    private final boolean zzzq;
    private final boolean zzzr;
    private final int[] zzzs;
    private final int zzzt;
    private final int zzzu;
    private final zzip zzzv;
    private final zzhr zzzw;
    private final zzjo<?, ?> zzzx;
    private final zzgk<?> zzzy;
    private final zzia zzzz;

    private zzil(int[] iArr, Object[] objArr, int i, int i2, zzih zzihVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzip zzipVar, zzhr zzhrVar, zzjo<?, ?> zzjoVar, zzgk<?> zzgkVar, zzia zziaVar) {
        this.zzzj = iArr;
        this.zzzk = objArr;
        this.zzzl = i;
        this.zzzm = i2;
        this.zzzp = zzihVar instanceof zzgx;
        this.zzzq = z;
        this.zzzo = zzgkVar != null && zzgkVar.zze(zzihVar);
        this.zzzr = false;
        this.zzzs = iArr2;
        this.zzzt = i3;
        this.zzzu = i4;
        this.zzzv = zzipVar;
        this.zzzw = zzhrVar;
        this.zzzx = zzjoVar;
        this.zzzy = zzgkVar;
        this.zzzn = zzihVar;
        this.zzzz = zziaVar;
    }

    private static boolean zzbs(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0381  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> zzil<T> zza(Class<T> cls, zzif zzifVar, zzip zzipVar, zzhr zzhrVar, zzjo<?, ?> zzjoVar, zzgk<?> zzgkVar, zzia zziaVar) {
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
        if (zzifVar instanceof zziu) {
            zziu zziuVar = (zziu) zzifVar;
            int i24 = 0;
            boolean z = zziuVar.zzhj() == zzgx.zzf.zzxj;
            String strZzhq = zziuVar.zzhq();
            int length = strZzhq.length();
            if (strZzhq.charAt(0) >= 55296) {
                int i25 = 1;
                while (true) {
                    i = i25 + 1;
                    if (strZzhq.charAt(i25) < 55296) {
                        break;
                    }
                    i25 = i;
                }
            } else {
                i = 1;
            }
            int i26 = i + 1;
            int iCharAt5 = strZzhq.charAt(i);
            if (iCharAt5 >= 55296) {
                int i27 = iCharAt5 & 8191;
                int i28 = 13;
                while (true) {
                    i23 = i26 + 1;
                    cCharAt13 = strZzhq.charAt(i26);
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
                iArr = zzzh;
                i3 = 0;
                iCharAt = 0;
                iCharAt2 = 0;
                iCharAt3 = 0;
                i2 = 0;
                iCharAt4 = 0;
            } else {
                int i29 = i26 + 1;
                int iCharAt6 = strZzhq.charAt(i26);
                if (iCharAt6 >= 55296) {
                    int i30 = iCharAt6 & 8191;
                    int i31 = 13;
                    while (true) {
                        i11 = i29 + 1;
                        cCharAt8 = strZzhq.charAt(i29);
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
                int iCharAt7 = strZzhq.charAt(i29);
                if (iCharAt7 >= 55296) {
                    int i33 = iCharAt7 & 8191;
                    int i34 = 13;
                    while (true) {
                        i10 = i32 + 1;
                        cCharAt7 = strZzhq.charAt(i32);
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
                iCharAt = strZzhq.charAt(i32);
                if (iCharAt >= 55296) {
                    int i36 = iCharAt & 8191;
                    int i37 = 13;
                    while (true) {
                        i9 = i35 + 1;
                        cCharAt6 = strZzhq.charAt(i35);
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
                iCharAt2 = strZzhq.charAt(i35);
                if (iCharAt2 >= 55296) {
                    int i39 = iCharAt2 & 8191;
                    int i40 = 13;
                    while (true) {
                        i8 = i38 + 1;
                        cCharAt5 = strZzhq.charAt(i38);
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
                iCharAt3 = strZzhq.charAt(i38);
                if (iCharAt3 >= 55296) {
                    int i42 = iCharAt3 & 8191;
                    int i43 = 13;
                    while (true) {
                        i7 = i41 + 1;
                        cCharAt4 = strZzhq.charAt(i41);
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
                int iCharAt8 = strZzhq.charAt(i41);
                if (iCharAt8 >= 55296) {
                    int i45 = iCharAt8 & 8191;
                    int i46 = 13;
                    while (true) {
                        i6 = i44 + 1;
                        cCharAt3 = strZzhq.charAt(i44);
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
                int iCharAt9 = strZzhq.charAt(i44);
                if (iCharAt9 >= 55296) {
                    int i48 = iCharAt9 & 8191;
                    int i49 = 13;
                    while (true) {
                        i5 = i47 + 1;
                        cCharAt2 = strZzhq.charAt(i47);
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
                iCharAt4 = strZzhq.charAt(i47);
                if (iCharAt4 >= 55296) {
                    int i51 = iCharAt4 & 8191;
                    int i52 = i50;
                    int i53 = 13;
                    while (true) {
                        i4 = i52 + 1;
                        cCharAt = strZzhq.charAt(i52);
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
            Unsafe unsafe = zzzi;
            Object[] objArrZzhr = zziuVar.zzhr();
            Class<?> cls2 = zziuVar.zzhl().getClass();
            int[] iArr3 = new int[iCharAt3 * 3];
            Object[] objArr = new Object[iCharAt3 << 1];
            int i54 = i3 + iCharAt4;
            int i55 = i54;
            int i56 = iCharAt4;
            int i57 = 0;
            int i58 = 0;
            while (i26 < length) {
                int i59 = i26 + 1;
                int iCharAt10 = strZzhq.charAt(i26);
                zziu zziuVar2 = zziuVar;
                if (iCharAt10 >= 55296) {
                    int i60 = iCharAt10 & 8191;
                    int i61 = i59;
                    int i62 = 13;
                    while (true) {
                        i22 = i61 + 1;
                        cCharAt12 = strZzhq.charAt(i61);
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
                int iCharAt11 = strZzhq.charAt(i13);
                if (iCharAt11 >= 55296) {
                    int i64 = iCharAt11 & 8191;
                    int i65 = i63;
                    int i66 = 13;
                    while (true) {
                        i20 = i65 + 1;
                        cCharAt11 = strZzhq.charAt(i65);
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
                    int iCharAt12 = strZzhq.charAt(i14);
                    char c = 55296;
                    if (iCharAt12 >= 55296) {
                        int i71 = iCharAt12 & 8191;
                        int i72 = 13;
                        while (true) {
                            i19 = i70 + 1;
                            cCharAt10 = strZzhq.charAt(i70);
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
                        objArr[((i58 / 3) << 1) + 1] = objArrZzhr[i2];
                    } else {
                        if (i73 == 12 && !z) {
                            i18 = i2 + 1;
                            objArr[((i58 / 3) << 1) + 1] = objArrZzhr[i2];
                        }
                        int i75 = i74 << 1;
                        obj = objArrZzhr[i75];
                        if (!(obj instanceof Field)) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZzhr[i75] = fieldZza2;
                        }
                        int i76 = i70;
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza2);
                        int i77 = i75 + 1;
                        obj2 = objArrZzhr[i77];
                        if (!(obj2 instanceof Field)) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZzhr[i77] = fieldZza3;
                        }
                        str = strZzhq;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                        i26 = i76;
                        i17 = iObjectFieldOffset3;
                        i16 = 0;
                    }
                    i2 = i18;
                    int i752 = i74 << 1;
                    obj = objArrZzhr[i752];
                    if (!(obj instanceof Field)) {
                    }
                    int i762 = i70;
                    int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldZza2);
                    int i772 = i752 + 1;
                    obj2 = objArrZzhr[i772];
                    if (!(obj2 instanceof Field)) {
                    }
                    str = strZzhq;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    i26 = i762;
                    i17 = iObjectFieldOffset32;
                    i16 = 0;
                } else {
                    int i78 = i2 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZzhr[i2]);
                    if (i68 == 9 || i68 == 17) {
                        objArr[((i58 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i68 == 27 || i68 == 49) {
                            i2 += 2;
                            objArr[((i58 / 3) << 1) + 1] = objArrZzhr[i78];
                        } else if (i68 == 12 || i68 == 30 || i68 == 44) {
                            if (!z) {
                                i2 += 2;
                                objArr[((i58 / 3) << 1) + 1] = objArrZzhr[i78];
                            }
                        } else if (i68 == 50) {
                            int i79 = i56 + 1;
                            iArr[i56] = i58;
                            int i80 = (i58 / 3) << 1;
                            int i81 = i2 + 2;
                            objArr[i80] = objArrZzhr[i78];
                            if ((iCharAt11 & 2048) != 0) {
                                objArr[i80 + 1] = objArrZzhr[i81];
                                i2 += 3;
                            } else {
                                i2 = i81;
                            }
                            i56 = i79;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((iCharAt11 & 4096) == 4096 || i68 > 17) {
                            str = strZzhq;
                            iObjectFieldOffset2 = 1048575;
                            i15 = i14;
                            i16 = 0;
                        } else {
                            int i82 = i14 + 1;
                            int iCharAt13 = strZzhq.charAt(i14);
                            if (iCharAt13 >= 55296) {
                                int i83 = iCharAt13 & 8191;
                                int i84 = 13;
                                while (true) {
                                    i15 = i82 + 1;
                                    cCharAt9 = strZzhq.charAt(i82);
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
                            Object obj3 = objArrZzhr[i85];
                            str = strZzhq;
                            if (obj3 instanceof Field) {
                                fieldZza = (Field) obj3;
                            } else {
                                fieldZza = zza(cls2, (String) obj3);
                                objArrZzhr[i85] = fieldZza;
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
                        str = strZzhq;
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
                zziuVar = zziuVar2;
                length = i12;
                iArr3 = iArr4;
                strZzhq = str;
            }
            return new zzil<>(iArr3, objArr, iCharAt, iCharAt2, zziuVar.zzhl(), z, false, iArr, iCharAt4, i54, zzipVar, zzhrVar, zzjoVar, zzgkVar, zziaVar);
        }
        ((zzjl) zzifVar).zzhj();
        int i89 = zzgx.zzf.zzxj;
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

    @Override // com.google.android.gms.internal.vision.zziw
    public final T newInstance() {
        return (T) this.zzzv.newInstance(this.zzzn);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.vision.zziw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(T t, T t2) {
        int length = this.zzzj.length;
        int i = 0;
        while (true) {
            boolean zZze = true;
            if (i < length) {
                int iZzbq = zzbq(i);
                long j = iZzbq & 1048575;
                switch ((iZzbq & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzju.zzo(t, j)) != Double.doubleToLongBits(zzju.zzo(t2, j))) {
                            zZze = false;
                            break;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzju.zzn(t, j)) != Float.floatToIntBits(zzju.zzn(t2, j))) {
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zzju.zzl(t, j) != zzju.zzl(t2, j)) {
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zzju.zzl(t, j) != zzju.zzl(t2, j)) {
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zzju.zzk(t, j) != zzju.zzk(t2, j)) {
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zzju.zzl(t, j) != zzju.zzl(t2, j)) {
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zzju.zzk(t, j) != zzju.zzk(t2, j)) {
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zzju.zzm(t, j) != zzju.zzm(t2, j)) {
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j))) {
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j))) {
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j))) {
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zzju.zzk(t, j) != zzju.zzk(t2, j)) {
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zzju.zzk(t, j) != zzju.zzk(t2, j)) {
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zzju.zzk(t, j) != zzju.zzk(t2, j)) {
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zzju.zzl(t, j) != zzju.zzl(t2, j)) {
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zzju.zzk(t, j) != zzju.zzk(t2, j)) {
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zzju.zzl(t, j) != zzju.zzl(t2, j)) {
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j))) {
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
                        zZze = zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j));
                        break;
                    case 50:
                        zZze = zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j));
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
                        long jZzbr = zzbr(i) & 1048575;
                        if (zzju.zzk(t, jZzbr) != zzju.zzk(t2, jZzbr) || !zziy.zze(zzju.zzp(t, j), zzju.zzp(t2, j))) {
                        }
                        break;
                }
                if (!zZze) {
                    return false;
                }
                i += 3;
            } else {
                if (!this.zzzx.zzw(t).equals(this.zzzx.zzw(t2))) {
                    return false;
                }
                if (this.zzzo) {
                    return this.zzzy.zzf(t).equals(this.zzzy.zzf(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final int hashCode(T t) {
        int i;
        int iZzab;
        int length = this.zzzj.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzbq = zzbq(i3);
            int i4 = this.zzzj[i3];
            long j = 1048575 & iZzbq;
            int iHashCode = 37;
            switch ((iZzbq & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZzab = zzgy.zzab(Double.doubleToLongBits(zzju.zzo(t, j)));
                    i2 = i + iZzab;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzab = Float.floatToIntBits(zzju.zzn(t, j));
                    i2 = i + iZzab;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzab = zzgy.zzab(zzju.zzl(t, j));
                    i2 = i + iZzab;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzab = zzgy.zzab(zzju.zzl(t, j));
                    i2 = i + iZzab;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzab = zzju.zzk(t, j);
                    i2 = i + iZzab;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzab = zzgy.zzab(zzju.zzl(t, j));
                    i2 = i + iZzab;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzab = zzju.zzk(t, j);
                    i2 = i + iZzab;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzab = zzgy.zzm(zzju.zzm(t, j));
                    i2 = i + iZzab;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzab = ((String) zzju.zzp(t, j)).hashCode();
                    i2 = i + iZzab;
                    break;
                case 9:
                    Object objZzp = zzju.zzp(t, j);
                    if (objZzp != null) {
                        iHashCode = objZzp.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzab = zzju.zzp(t, j).hashCode();
                    i2 = i + iZzab;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzab = zzju.zzk(t, j);
                    i2 = i + iZzab;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzab = zzju.zzk(t, j);
                    i2 = i + iZzab;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzab = zzju.zzk(t, j);
                    i2 = i + iZzab;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzab = zzgy.zzab(zzju.zzl(t, j));
                    i2 = i + iZzab;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzab = zzju.zzk(t, j);
                    i2 = i + iZzab;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzab = zzgy.zzab(zzju.zzl(t, j));
                    i2 = i + iZzab;
                    break;
                case 17:
                    Object objZzp2 = zzju.zzp(t, j);
                    if (objZzp2 != null) {
                        iHashCode = objZzp2.hashCode();
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
                    iZzab = zzju.zzp(t, j).hashCode();
                    i2 = i + iZzab;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzab = zzju.zzp(t, j).hashCode();
                    i2 = i + iZzab;
                    break;
                case 51:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzab(Double.doubleToLongBits(zzf(t, j)));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = Float.floatToIntBits(zzg(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzab(zzi(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzab(zzi(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzh(t, j);
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzab(zzi(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzh(t, j);
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzm(zzj(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = ((String) zzju.zzp(t, j)).hashCode();
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzju.zzp(t, j).hashCode();
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzju.zzp(t, j).hashCode();
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzh(t, j);
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzh(t, j);
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzh(t, j);
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzab(zzi(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzh(t, j);
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzgy.zzab(zzi(t, j));
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzil<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzab = zzju.zzp(t, j).hashCode();
                        i2 = i + iZzab;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzzx.zzw(t).hashCode();
        return this.zzzo ? (iHashCode2 * 53) + this.zzzy.zzf(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzd(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzzj.length; i += 3) {
            int iZzbq = zzbq(i);
            long j = 1048575 & iZzbq;
            int i2 = this.zzzj[i];
            switch ((iZzbq & 267386880) >>> 20) {
                case 0:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza(t, j, zzju.zzo(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza((Object) t, j, zzju.zzn(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza((Object) t, j, zzju.zzl(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza((Object) t, j, zzju.zzl(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zzb(t, j, zzju.zzk(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza((Object) t, j, zzju.zzl(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zzb(t, j, zzju.zzk(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza(t, j, zzju.zzm(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza(t, j, zzju.zzp(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza(t, j, zzju.zzp(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zzb(t, j, zzju.zzk(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zzb(t, j, zzju.zzk(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zzb(t, j, zzju.zzk(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza((Object) t, j, zzju.zzl(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zzb(t, j, zzju.zzk(t2, j));
                        zzb((zzil<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzil<T>) t2, i)) {
                        zzju.zza((Object) t, j, zzju.zzl(t2, j));
                        zzb((zzil<T>) t, i);
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
                    this.zzzw.zza(t, t2, j);
                    break;
                case 50:
                    zziy.zza(this.zzzz, t, t2, j);
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
                    if (zza((zzil<T>) t2, i2, i)) {
                        zzju.zza(t, j, zzju.zzp(t2, j));
                        zzb((zzil<T>) t, i2, i);
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
                    if (zza((zzil<T>) t2, i2, i)) {
                        zzju.zza(t, j, zzju.zzp(t2, j));
                        zzb((zzil<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zziy.zza(this.zzzx, t, t2);
        if (this.zzzo) {
            zziy.zza(this.zzzy, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzbq = zzbq(i) & 1048575;
        if (zza((zzil<T>) t2, i)) {
            Object objZzp = zzju.zzp(t, jZzbq);
            Object objZzp2 = zzju.zzp(t2, jZzbq);
            if (objZzp != null && objZzp2 != null) {
                zzju.zza(t, jZzbq, zzgy.zzb(objZzp, objZzp2));
                zzb((zzil<T>) t, i);
            } else if (objZzp2 != null) {
                zzju.zza(t, jZzbq, objZzp2);
                zzb((zzil<T>) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzbq = zzbq(i);
        int i2 = this.zzzj[i];
        long j = iZzbq & 1048575;
        if (zza((zzil<T>) t2, i2, i)) {
            Object objZzp = zzju.zzp(t, j);
            Object objZzp2 = zzju.zzp(t2, j);
            if (objZzp != null && objZzp2 != null) {
                zzju.zza(t, j, zzgy.zzb(objZzp, objZzp2));
                zzb((zzil<T>) t, i2, i);
            } else if (objZzp2 != null) {
                zzju.zza(t, j, objZzp2);
                zzb((zzil<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.vision.zziw
    public final int zzs(T t) {
        int i;
        int i2;
        int iZzd;
        int iZzb;
        int iZzp;
        int iZzy;
        int iZzbb;
        int iZzbd;
        int iZzb2;
        int iZzy2;
        int iZzbb2;
        int iZzbd2;
        int i3 = 267386880;
        if (this.zzzq) {
            Unsafe unsafe = zzzi;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.zzzj.length) {
                int iZzbq = zzbq(i4);
                int i6 = (iZzbq & i3) >>> 20;
                int i7 = this.zzzj[i4];
                long j = iZzbq & 1048575;
                int i8 = (i6 < zzgs.DOUBLE_LIST_PACKED.id() || i6 > zzgs.SINT64_LIST_PACKED.id()) ? 0 : this.zzzj[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzb(i7, 0.0d);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzb(i7, 0.0f);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzd(i7, zzju.zzl(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zze(i7, zzju.zzl(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzl(i7, zzju.zzk(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzg(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzo(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzb(i7, true);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzil<T>) t, i4)) {
                            Object objZzp = zzju.zzp(t, j);
                            if (objZzp instanceof zzfm) {
                                iZzb2 = zzgf.zzc(i7, (zzfm) objZzp);
                            } else {
                                iZzb2 = zzgf.zzb(i7, (String) objZzp);
                            }
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zziy.zzc(i7, zzju.zzp(t, j), zzbn(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzc(i7, (zzfm) zzju.zzp(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzm(i7, zzju.zzk(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzq(i7, zzju.zzk(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzp(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzh(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzn(i7, zzju.zzk(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzf(i7, zzju.zzl(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzil<T>) t, i4)) {
                            iZzb2 = zzgf.zzc(i7, (zzih) zzju.zzp(t, j), zzbn(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        iZzb2 = zziy.zzw(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 19:
                        iZzb2 = zziy.zzv(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 20:
                        iZzb2 = zziy.zzo(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 21:
                        iZzb2 = zziy.zzp(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 22:
                        iZzb2 = zziy.zzs(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 23:
                        iZzb2 = zziy.zzw(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 24:
                        iZzb2 = zziy.zzv(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 25:
                        iZzb2 = zziy.zzx(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 26:
                        iZzb2 = zziy.zzc(i7, zze(t, j));
                        i5 += iZzb2;
                        break;
                    case 27:
                        iZzb2 = zziy.zzc(i7, zze(t, j), zzbn(i4));
                        i5 += iZzb2;
                        break;
                    case 28:
                        iZzb2 = zziy.zzd(i7, zze(t, j));
                        i5 += iZzb2;
                        break;
                    case 29:
                        iZzb2 = zziy.zzt(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 30:
                        iZzb2 = zziy.zzr(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 31:
                        iZzb2 = zziy.zzv(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 32:
                        iZzb2 = zziy.zzw(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 33:
                        iZzb2 = zziy.zzu(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 34:
                        iZzb2 = zziy.zzq(i7, zze(t, j), false);
                        i5 += iZzb2;
                        break;
                    case 35:
                        iZzy2 = zziy.zzy((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 36:
                        iZzy2 = zziy.zzx((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 37:
                        iZzy2 = zziy.zzq((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 38:
                        iZzy2 = zziy.zzr((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 39:
                        iZzy2 = zziy.zzu((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 40:
                        iZzy2 = zziy.zzy((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 41:
                        iZzy2 = zziy.zzx((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 42:
                        iZzy2 = zziy.zzz((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 43:
                        iZzy2 = zziy.zzv((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 44:
                        iZzy2 = zziy.zzt((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 45:
                        iZzy2 = zziy.zzx((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 46:
                        iZzy2 = zziy.zzy((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 47:
                        iZzy2 = zziy.zzw((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 48:
                        iZzy2 = zziy.zzs((List) unsafe.getObject(t, j));
                        if (iZzy2 <= 0) {
                            break;
                        } else {
                            if (this.zzzr) {
                                unsafe.putInt(t, i8, iZzy2);
                            }
                            iZzbb2 = zzgf.zzbb(i7);
                            iZzbd2 = zzgf.zzbd(iZzy2);
                            iZzb2 = iZzbb2 + iZzbd2 + iZzy2;
                            i5 += iZzb2;
                            break;
                        }
                    case 49:
                        iZzb2 = zziy.zzd(i7, zze(t, j), zzbn(i4));
                        i5 += iZzb2;
                        break;
                    case 50:
                        iZzb2 = this.zzzz.zzb(i7, zzju.zzp(t, j), zzbo(i4));
                        i5 += iZzb2;
                        break;
                    case 51:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzb(i7, 0.0d);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzb(i7, 0.0f);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzd(i7, zzi(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zze(i7, zzi(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzl(i7, zzh(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzg(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzo(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzb(i7, true);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzil<T>) t, i7, i4)) {
                            Object objZzp2 = zzju.zzp(t, j);
                            if (objZzp2 instanceof zzfm) {
                                iZzb2 = zzgf.zzc(i7, (zzfm) objZzp2);
                            } else {
                                iZzb2 = zzgf.zzb(i7, (String) objZzp2);
                            }
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zziy.zzc(i7, zzju.zzp(t, j), zzbn(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzc(i7, (zzfm) zzju.zzp(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzm(i7, zzh(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzq(i7, zzh(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzp(i7, 0);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzh(i7, 0L);
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzn(i7, zzh(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzf(i7, zzi(t, j));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzil<T>) t, i7, i4)) {
                            iZzb2 = zzgf.zzc(i7, (zzih) zzju.zzp(t, j), zzbn(i4));
                            i5 += iZzb2;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + zza(this.zzzx, t);
        }
        Unsafe unsafe2 = zzzi;
        int iZzb3 = 0;
        int i9 = 1048575;
        int i10 = 0;
        for (int i11 = 0; i11 < this.zzzj.length; i11 += 3) {
            int iZzbq2 = zzbq(i11);
            int[] iArr = this.zzzj;
            int i12 = iArr[i11];
            int i13 = (iZzbq2 & 267386880) >>> 20;
            if (i13 <= 17) {
                i = iArr[i11 + 2];
                int i14 = i & 1048575;
                i2 = 1 << (i >>> 20);
                if (i14 != i9) {
                    i10 = unsafe2.getInt(t, i14);
                    i9 = i14;
                }
            } else {
                i = (!this.zzzr || i13 < zzgs.DOUBLE_LIST_PACKED.id() || i13 > zzgs.SINT64_LIST_PACKED.id()) ? 0 : this.zzzj[i11 + 2] & 1048575;
                i2 = 0;
            }
            long j2 = iZzbq2 & 1048575;
            switch (i13) {
                case 0:
                    if ((i10 & i2) != 0) {
                        iZzb3 += zzgf.zzb(i12, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i10 & i2) != 0) {
                        iZzb3 += zzgf.zzb(i12, 0.0f);
                    }
                    break;
                case 2:
                    if ((i10 & i2) != 0) {
                        iZzd = zzgf.zzd(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 3:
                    if ((i10 & i2) != 0) {
                        iZzd = zzgf.zze(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 4:
                    if ((i10 & i2) != 0) {
                        iZzd = zzgf.zzl(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzd;
                    }
                    break;
                case 5:
                    if ((i10 & i2) != 0) {
                        iZzd = zzgf.zzg(i12, 0L);
                        iZzb3 += iZzd;
                    }
                    break;
                case 6:
                    if ((i10 & i2) != 0) {
                        iZzd = zzgf.zzo(i12, 0);
                        iZzb3 += iZzd;
                        break;
                    }
                case 7:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzb(i12, true);
                        iZzb3 += iZzb;
                    }
                    break;
                case 8:
                    if ((i10 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzfm) {
                            iZzb = zzgf.zzc(i12, (zzfm) object);
                        } else {
                            iZzb = zzgf.zzb(i12, (String) object);
                        }
                        iZzb3 += iZzb;
                    }
                    break;
                case 9:
                    if ((i10 & i2) != 0) {
                        iZzb = zziy.zzc(i12, unsafe2.getObject(t, j2), zzbn(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 10:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzc(i12, (zzfm) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 11:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzm(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 12:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzq(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 13:
                    if ((i10 & i2) != 0) {
                        iZzp = zzgf.zzp(i12, 0);
                        iZzb3 += iZzp;
                    }
                    break;
                case 14:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzh(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 15:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzn(i12, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 16:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzf(i12, unsafe2.getLong(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 17:
                    if ((i10 & i2) != 0) {
                        iZzb = zzgf.zzc(i12, (zzih) unsafe2.getObject(t, j2), zzbn(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 18:
                    iZzb = zziy.zzw(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 19:
                    iZzb = zziy.zzv(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 20:
                    iZzb = zziy.zzo(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 21:
                    iZzb = zziy.zzp(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 22:
                    iZzb = zziy.zzs(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 23:
                    iZzb = zziy.zzw(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 24:
                    iZzb = zziy.zzv(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 25:
                    iZzb = zziy.zzx(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 26:
                    iZzb = zziy.zzc(i12, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    break;
                case 27:
                    iZzb = zziy.zzc(i12, (List<?>) unsafe2.getObject(t, j2), zzbn(i11));
                    iZzb3 += iZzb;
                    break;
                case 28:
                    iZzb = zziy.zzd(i12, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    break;
                case 29:
                    iZzb = zziy.zzt(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 30:
                    iZzb = zziy.zzr(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 31:
                    iZzb = zziy.zzv(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 32:
                    iZzb = zziy.zzw(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 33:
                    iZzb = zziy.zzu(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 34:
                    iZzb = zziy.zzq(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    break;
                case 35:
                    iZzy = zziy.zzy((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 36:
                    iZzy = zziy.zzx((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 37:
                    iZzy = zziy.zzq((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 38:
                    iZzy = zziy.zzr((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 39:
                    iZzy = zziy.zzu((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 40:
                    iZzy = zziy.zzy((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 41:
                    iZzy = zziy.zzx((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 42:
                    iZzy = zziy.zzz((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 43:
                    iZzy = zziy.zzv((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 44:
                    iZzy = zziy.zzt((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 45:
                    iZzy = zziy.zzx((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 46:
                    iZzy = zziy.zzy((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 47:
                    iZzy = zziy.zzw((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 48:
                    iZzy = zziy.zzs((List) unsafe2.getObject(t, j2));
                    if (iZzy > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, i, iZzy);
                        }
                        iZzbb = zzgf.zzbb(i12);
                        iZzbd = zzgf.zzbd(iZzy);
                        iZzb = iZzbb + iZzbd + iZzy;
                        iZzb3 += iZzb;
                    }
                    break;
                case 49:
                    iZzb = zziy.zzd(i12, (List) unsafe2.getObject(t, j2), zzbn(i11));
                    iZzb3 += iZzb;
                    break;
                case 50:
                    iZzb = this.zzzz.zzb(i12, unsafe2.getObject(t, j2), zzbo(i11));
                    iZzb3 += iZzb;
                    break;
                case 51:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzb(i12, 0.0d);
                        iZzb3 += iZzb;
                    }
                    break;
                case 52:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzp = zzgf.zzb(i12, 0.0f);
                        iZzb3 += iZzp;
                    }
                    break;
                case 53:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzd(i12, zzi(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 54:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zze(i12, zzi(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 55:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzl(i12, zzh(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 56:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzg(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 57:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzp = zzgf.zzo(i12, 0);
                        iZzb3 += iZzp;
                    }
                    break;
                case 58:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzb(i12, true);
                        iZzb3 += iZzb;
                    }
                    break;
                case 59:
                    if (zza((zzil<T>) t, i12, i11)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzfm) {
                            iZzb = zzgf.zzc(i12, (zzfm) object2);
                        } else {
                            iZzb = zzgf.zzb(i12, (String) object2);
                        }
                        iZzb3 += iZzb;
                    }
                    break;
                case 60:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zziy.zzc(i12, unsafe2.getObject(t, j2), zzbn(i11));
                        iZzb3 += iZzb;
                    }
                    break;
                case 61:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzc(i12, (zzfm) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 62:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzm(i12, zzh(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 63:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzq(i12, zzh(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 64:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzp = zzgf.zzp(i12, 0);
                        iZzb3 += iZzp;
                    }
                    break;
                case 65:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzh(i12, 0L);
                        iZzb3 += iZzb;
                    }
                    break;
                case 66:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzn(i12, zzh(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 67:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzf(i12, zzi(t, j2));
                        iZzb3 += iZzb;
                    }
                    break;
                case 68:
                    if (zza((zzil<T>) t, i12, i11)) {
                        iZzb = zzgf.zzc(i12, (zzih) unsafe2.getObject(t, j2), zzbn(i11));
                        iZzb3 += iZzb;
                    }
                    break;
            }
        }
        int iZzc = 0;
        int iZza = iZzb3 + zza(this.zzzx, t);
        if (!this.zzzo) {
            return iZza;
        }
        zzgn<T> zzgnVarZzf = this.zzzy.zzf(t);
        for (int i15 = 0; i15 < zzgnVarZzf.zztq.zzhy(); i15++) {
            Map.Entry entryZzbv = zzgnVarZzf.zztq.zzbv(i15);
            iZzc += zzgn.zzc((zzgp) entryZzbv.getKey(), entryZzbv.getValue());
        }
        for (Map.Entry entry : zzgnVarZzf.zztq.zzhz()) {
            iZzc += zzgn.zzc((zzgp) entry.getKey(), entry.getValue());
        }
        return iZza + iZzc;
    }

    private static <UT, UB> int zza(zzjo<UT, UB> zzjoVar, T t) {
        return zzjoVar.zzs(zzjoVar.zzw(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzju.zzp(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.vision.zziw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzkl zzklVar) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry2;
        if (zzklVar.zzfk() == zzgx.zzf.zzxm) {
            zza(this.zzzx, t, zzklVar);
            if (this.zzzo) {
                zzgn<T> zzgnVarZzf = this.zzzy.zzf(t);
                if (zzgnVarZzf.zztq.isEmpty()) {
                    itDescendingIterator = null;
                    entry2 = null;
                } else {
                    itDescendingIterator = zzgnVarZzf.descendingIterator();
                    entry2 = (Map.Entry) itDescendingIterator.next();
                }
            }
            for (int length = this.zzzj.length - 3; length >= 0; length -= 3) {
                int iZzbq = zzbq(length);
                int i = this.zzzj[length];
                while (entry2 != null && this.zzzy.zza(entry2) > i) {
                    this.zzzy.zza(zzklVar, entry2);
                    entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((iZzbq & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zza(i, zzju.zzo(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zza(i, zzju.zzn(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzi(i, zzju.zzl(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zza(i, zzju.zzl(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzh(i, zzju.zzk(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzc(i, zzju.zzl(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzk(i, zzju.zzk(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zza(i, zzju.zzm(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzil<T>) t, length)) {
                            zza(i, zzju.zzp(t, iZzbq & 1048575), zzklVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zza(i, zzju.zzp(t, iZzbq & 1048575), zzbn(length));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zza(i, (zzfm) zzju.zzp(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzi(i, zzju.zzk(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzs(i, zzju.zzk(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzr(i, zzju.zzk(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzj(i, zzju.zzl(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzj(i, zzju.zzk(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzb(i, zzju.zzl(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzil<T>) t, length)) {
                            zzklVar.zzb(i, zzju.zzp(t, iZzbq & 1048575), zzbn(length));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zziy.zza(this.zzzj[length], (List<Double>) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 19:
                        zziy.zzb(this.zzzj[length], (List<Float>) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 20:
                        zziy.zzc(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 21:
                        zziy.zzd(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 22:
                        zziy.zzh(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 23:
                        zziy.zzf(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 24:
                        zziy.zzk(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 25:
                        zziy.zzn(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 26:
                        zziy.zza(this.zzzj[length], (List<String>) zzju.zzp(t, iZzbq & 1048575), zzklVar);
                        break;
                    case 27:
                        zziy.zza(this.zzzj[length], (List<?>) zzju.zzp(t, iZzbq & 1048575), zzklVar, zzbn(length));
                        break;
                    case 28:
                        zziy.zzb(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar);
                        break;
                    case 29:
                        zziy.zzi(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 30:
                        zziy.zzm(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 31:
                        zziy.zzl(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 32:
                        zziy.zzg(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 33:
                        zziy.zzj(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 34:
                        zziy.zze(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, false);
                        break;
                    case 35:
                        zziy.zza(this.zzzj[length], (List<Double>) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 36:
                        zziy.zzb(this.zzzj[length], (List<Float>) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 37:
                        zziy.zzc(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 38:
                        zziy.zzd(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 39:
                        zziy.zzh(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 40:
                        zziy.zzf(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 41:
                        zziy.zzk(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 42:
                        zziy.zzn(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 43:
                        zziy.zzi(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 44:
                        zziy.zzm(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 45:
                        zziy.zzl(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 46:
                        zziy.zzg(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 47:
                        zziy.zzj(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 48:
                        zziy.zze(this.zzzj[length], (List) zzju.zzp(t, iZzbq & 1048575), zzklVar, true);
                        break;
                    case 49:
                        zziy.zzb(this.zzzj[length], (List<?>) zzju.zzp(t, iZzbq & 1048575), zzklVar, zzbn(length));
                        break;
                    case 50:
                        zza(zzklVar, i, zzju.zzp(t, iZzbq & 1048575), length);
                        break;
                    case 51:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zza(i, zzf(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zza(i, zzg(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzi(i, zzi(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zza(i, zzi(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzh(i, zzh(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzc(i, zzi(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzk(i, zzh(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zza(i, zzj(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzil<T>) t, i, length)) {
                            zza(i, zzju.zzp(t, iZzbq & 1048575), zzklVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zza(i, zzju.zzp(t, iZzbq & 1048575), zzbn(length));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zza(i, (zzfm) zzju.zzp(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzi(i, zzh(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzs(i, zzh(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzr(i, zzh(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzj(i, zzi(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzj(i, zzh(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzb(i, zzi(t, iZzbq & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzil<T>) t, i, length)) {
                            zzklVar.zzb(i, zzju.zzp(t, iZzbq & 1048575), zzbn(length));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry2 != null) {
                this.zzzy.zza(zzklVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (this.zzzq) {
            if (this.zzzo) {
                zzgn<T> zzgnVarZzf2 = this.zzzy.zzf(t);
                if (zzgnVarZzf2.zztq.isEmpty()) {
                    it = null;
                    entry = null;
                } else {
                    it = zzgnVarZzf2.iterator();
                    entry = (Map.Entry) it.next();
                }
            }
            int length2 = this.zzzj.length;
            for (int i2 = 0; i2 < length2; i2 += 3) {
                int iZzbq2 = zzbq(i2);
                int i3 = this.zzzj[i2];
                while (entry != null && this.zzzy.zza(entry) <= i3) {
                    this.zzzy.zza(zzklVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                switch ((iZzbq2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zza(i3, zzju.zzo(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zza(i3, zzju.zzn(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzi(i3, zzju.zzl(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zza(i3, zzju.zzl(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzh(i3, zzju.zzk(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzc(i3, zzju.zzl(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzk(i3, zzju.zzk(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zza(i3, zzju.zzm(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzil<T>) t, i2)) {
                            zza(i3, zzju.zzp(t, iZzbq2 & 1048575), zzklVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zza(i3, zzju.zzp(t, iZzbq2 & 1048575), zzbn(i2));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zza(i3, (zzfm) zzju.zzp(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzi(i3, zzju.zzk(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzs(i3, zzju.zzk(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzr(i3, zzju.zzk(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzj(i3, zzju.zzl(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzj(i3, zzju.zzk(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzb(i3, zzju.zzl(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzil<T>) t, i2)) {
                            zzklVar.zzb(i3, zzju.zzp(t, iZzbq2 & 1048575), zzbn(i2));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zziy.zza(this.zzzj[i2], (List<Double>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 19:
                        zziy.zzb(this.zzzj[i2], (List<Float>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 20:
                        zziy.zzc(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 21:
                        zziy.zzd(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 22:
                        zziy.zzh(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 23:
                        zziy.zzf(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 24:
                        zziy.zzk(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 25:
                        zziy.zzn(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 26:
                        zziy.zza(this.zzzj[i2], (List<String>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar);
                        break;
                    case 27:
                        zziy.zza(this.zzzj[i2], (List<?>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, zzbn(i2));
                        break;
                    case 28:
                        zziy.zzb(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar);
                        break;
                    case 29:
                        zziy.zzi(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 30:
                        zziy.zzm(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 31:
                        zziy.zzl(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 32:
                        zziy.zzg(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 33:
                        zziy.zzj(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 34:
                        zziy.zze(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, false);
                        break;
                    case 35:
                        zziy.zza(this.zzzj[i2], (List<Double>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 36:
                        zziy.zzb(this.zzzj[i2], (List<Float>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 37:
                        zziy.zzc(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 38:
                        zziy.zzd(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 39:
                        zziy.zzh(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 40:
                        zziy.zzf(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 41:
                        zziy.zzk(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 42:
                        zziy.zzn(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 43:
                        zziy.zzi(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 44:
                        zziy.zzm(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 45:
                        zziy.zzl(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 46:
                        zziy.zzg(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 47:
                        zziy.zzj(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 48:
                        zziy.zze(this.zzzj[i2], (List) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, true);
                        break;
                    case 49:
                        zziy.zzb(this.zzzj[i2], (List<?>) zzju.zzp(t, iZzbq2 & 1048575), zzklVar, zzbn(i2));
                        break;
                    case 50:
                        zza(zzklVar, i3, zzju.zzp(t, iZzbq2 & 1048575), i2);
                        break;
                    case 51:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zza(i3, zzf(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zza(i3, zzg(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzi(i3, zzi(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zza(i3, zzi(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzh(i3, zzh(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzc(i3, zzi(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzk(i3, zzh(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zza(i3, zzj(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zza(i3, zzju.zzp(t, iZzbq2 & 1048575), zzklVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zza(i3, zzju.zzp(t, iZzbq2 & 1048575), zzbn(i2));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zza(i3, (zzfm) zzju.zzp(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzi(i3, zzh(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzs(i3, zzh(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzr(i3, zzh(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzj(i3, zzi(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzj(i3, zzh(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzb(i3, zzi(t, iZzbq2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzil<T>) t, i3, i2)) {
                            zzklVar.zzb(i3, zzju.zzp(t, iZzbq2 & 1048575), zzbn(i2));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry != null) {
                this.zzzy.zza(zzklVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            zza(this.zzzx, t, zzklVar);
            return;
        }
        zzb((zzil<T>) t, zzklVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzkl zzklVar) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.zzzo) {
            zzgn<T> zzgnVarZzf = this.zzzy.zzf(t);
            if (zzgnVarZzf.zztq.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzgnVarZzf.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.zzzj.length;
        Unsafe unsafe = zzzi;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzbq = zzbq(i4);
            int[] iArr = this.zzzj;
            int i5 = iArr[i4];
            int i6 = (iZzbq & 267386880) >>> 20;
            if (this.zzzq || i6 > 17) {
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
            while (entry != null && this.zzzy.zza(entry) <= i5) {
                this.zzzy.zza(zzklVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzbq & 1048575;
            switch (i6) {
                case 0:
                    if ((i3 & i) != 0) {
                        zzklVar.zza(i5, zzju.zzo(t, j));
                        continue;
                    }
                case 1:
                    if ((i3 & i) != 0) {
                        zzklVar.zza(i5, zzju.zzn(t, j));
                    } else {
                        continue;
                    }
                case 2:
                    if ((i3 & i) != 0) {
                        zzklVar.zzi(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 3:
                    if ((i3 & i) != 0) {
                        zzklVar.zza(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 4:
                    if ((i3 & i) != 0) {
                        zzklVar.zzh(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 5:
                    if ((i3 & i) != 0) {
                        zzklVar.zzc(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 6:
                    if ((i3 & i) != 0) {
                        zzklVar.zzk(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 7:
                    if ((i3 & i) != 0) {
                        zzklVar.zza(i5, zzju.zzm(t, j));
                    } else {
                        continue;
                    }
                case 8:
                    if ((i3 & i) != 0) {
                        zza(i5, unsafe.getObject(t, j), zzklVar);
                    } else {
                        continue;
                    }
                case 9:
                    if ((i3 & i) != 0) {
                        zzklVar.zza(i5, unsafe.getObject(t, j), zzbn(i4));
                    } else {
                        continue;
                    }
                case 10:
                    if ((i3 & i) != 0) {
                        zzklVar.zza(i5, (zzfm) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                case 11:
                    if ((i3 & i) != 0) {
                        zzklVar.zzi(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 12:
                    if ((i3 & i) != 0) {
                        zzklVar.zzs(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 13:
                    if ((i3 & i) != 0) {
                        zzklVar.zzr(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 14:
                    if ((i3 & i) != 0) {
                        zzklVar.zzj(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 15:
                    if ((i3 & i) != 0) {
                        zzklVar.zzj(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 16:
                    if ((i3 & i) != 0) {
                        zzklVar.zzb(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 17:
                    if ((i3 & i) != 0) {
                        zzklVar.zzb(i5, unsafe.getObject(t, j), zzbn(i4));
                    } else {
                        continue;
                    }
                case 18:
                    zziy.zza(this.zzzj[i4], (List<Double>) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 19:
                    zziy.zzb(this.zzzj[i4], (List<Float>) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 20:
                    zziy.zzc(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 21:
                    zziy.zzd(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 22:
                    zziy.zzh(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 23:
                    zziy.zzf(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 24:
                    zziy.zzk(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 25:
                    zziy.zzn(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 26:
                    zziy.zza(this.zzzj[i4], (List<String>) unsafe.getObject(t, j), zzklVar);
                    break;
                case 27:
                    zziy.zza(this.zzzj[i4], (List<?>) unsafe.getObject(t, j), zzklVar, zzbn(i4));
                    break;
                case 28:
                    zziy.zzb(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar);
                    break;
                case 29:
                    zziy.zzi(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 30:
                    zziy.zzm(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 31:
                    zziy.zzl(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 32:
                    zziy.zzg(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 33:
                    zziy.zzj(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 34:
                    zziy.zze(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, false);
                    continue;
                case 35:
                    zziy.zza(this.zzzj[i4], (List<Double>) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 36:
                    zziy.zzb(this.zzzj[i4], (List<Float>) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 37:
                    zziy.zzc(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 38:
                    zziy.zzd(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 39:
                    zziy.zzh(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 40:
                    zziy.zzf(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 41:
                    zziy.zzk(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 42:
                    zziy.zzn(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 43:
                    zziy.zzi(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 44:
                    zziy.zzm(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 45:
                    zziy.zzl(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 46:
                    zziy.zzg(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 47:
                    zziy.zzj(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 48:
                    zziy.zze(this.zzzj[i4], (List) unsafe.getObject(t, j), zzklVar, true);
                    break;
                case 49:
                    zziy.zzb(this.zzzj[i4], (List<?>) unsafe.getObject(t, j), zzklVar, zzbn(i4));
                    break;
                case 50:
                    zza(zzklVar, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zza(i5, zzf(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zza(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzi(i5, zzi(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zza(i5, zzi(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzh(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzc(i5, zzi(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzk(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zza(i5, zzj(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zza(i5, unsafe.getObject(t, j), zzklVar);
                        break;
                    }
                    break;
                case 60:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zza(i5, unsafe.getObject(t, j), zzbn(i4));
                        break;
                    }
                    break;
                case 61:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zza(i5, (zzfm) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzi(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzs(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzr(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzj(i5, zzi(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzj(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzb(i5, zzi(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zza((zzil<T>) t, i5, i4)) {
                        zzklVar.zzb(i5, unsafe.getObject(t, j), zzbn(i4));
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzzy.zza(zzklVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzzx, t, zzklVar);
    }

    private final <K, V> void zza(zzkl zzklVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzklVar.zza(i, this.zzzz.zzq(zzbo(i2)), this.zzzz.zzm(obj));
        }
    }

    private static <UT, UB> void zza(zzjo<UT, UB> zzjoVar, T t, zzkl zzklVar) throws IOException {
        zzjoVar.zza((zzjo<UT, UB>) zzjoVar.zzw(t), zzklVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05cc A[DONT_GENERATE, FINALLY_INSNS, LOOP:5: B:159:0x05c8->B:161:0x05cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x05d9 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:351:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.zziw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzix zzixVar, zzgi zzgiVar) throws IOException {
        int iZzdv;
        int iZzbt;
        zzgiVar.getClass();
        zzjo zzjoVar = this.zzzx;
        zzgk<?> zzgkVar = this.zzzy;
        Object objZzg = null;
        Object objZza = null;
        while (true) {
            try {
                iZzdv = zzixVar.zzdv();
                iZzbt = zzbt(iZzdv);
            } finally {
            }
            if (iZzbt < 0) {
                if (iZzdv == Integer.MAX_VALUE) {
                    for (int i = this.zzzt; i < this.zzzu; i++) {
                        objZza = zza((Object) t, this.zzzs[i], (int) objZza, (zzjo<UT, int>) zzjoVar);
                    }
                    if (objZza != null) {
                        zzjoVar.zzg(t, objZza);
                        return;
                    }
                    return;
                }
                Object objZza2 = !this.zzzo ? null : zzgkVar.zza(zzgiVar, this.zzzn, iZzdv);
                if (objZza2 != null) {
                    if (objZzg == null) {
                        objZzg = zzgkVar.zzg(t);
                    }
                    zzgi zzgiVar2 = zzgiVar;
                    zzgn<T> zzgnVar = objZzg;
                    zzix zzixVar2 = zzixVar;
                    objZza = zzgkVar.zza(zzixVar2, objZza2, zzgiVar2, zzgnVar, objZza, zzjoVar);
                    zzixVar = zzixVar2;
                    zzgiVar = zzgiVar2;
                    objZzg = zzgnVar;
                } else {
                    zzjoVar.zza(zzixVar);
                    if (objZza == null) {
                        objZza = zzjoVar.zzx(t);
                    }
                    if (!zzjoVar.zza((zzjo) objZza, zzixVar)) {
                        for (int i2 = this.zzzt; i2 < this.zzzu; i2++) {
                            objZza = zza((Object) t, this.zzzs[i2], (int) objZza, (zzjo<UT, int>) zzjoVar);
                        }
                        if (objZza != null) {
                            zzjoVar.zzg(t, objZza);
                            return;
                        }
                        return;
                    }
                }
            } else {
                int iZzbq = zzbq(iZzbt);
                switch ((267386880 & iZzbq) >>> 20) {
                    case 0:
                        zzju.zza(t, iZzbq & 1048575, zzixVar.readDouble());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 1:
                        zzju.zza((Object) t, iZzbq & 1048575, zzixVar.readFloat());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 2:
                        zzju.zza((Object) t, iZzbq & 1048575, zzixVar.zzdy());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 3:
                        zzju.zza((Object) t, iZzbq & 1048575, zzixVar.zzdx());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 4:
                        zzju.zzb(t, iZzbq & 1048575, zzixVar.zzdz());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 5:
                        zzju.zza((Object) t, iZzbq & 1048575, zzixVar.zzea());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 6:
                        zzju.zzb(t, iZzbq & 1048575, zzixVar.zzeb());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 7:
                        zzju.zza(t, iZzbq & 1048575, zzixVar.zzec());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 8:
                        zza(t, iZzbq, zzixVar);
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 9:
                        if (zza((zzil<T>) t, iZzbt)) {
                            long j = iZzbq & 1048575;
                            zzju.zza(t, j, zzgy.zzb(zzju.zzp(t, j), zzixVar.zza(zzbn(iZzbt), zzgiVar)));
                            break;
                        } else {
                            zzju.zza(t, iZzbq & 1048575, zzixVar.zza(zzbn(iZzbt), zzgiVar));
                            zzb((zzil<T>) t, iZzbt);
                            continue;
                        }
                    case 10:
                        zzju.zza(t, iZzbq & 1048575, zzixVar.zzee());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 11:
                        zzju.zzb(t, iZzbq & 1048575, zzixVar.zzef());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 12:
                        int iZzeg = zzixVar.zzeg();
                        zzhd zzhdVarZzbp = zzbp(iZzbt);
                        if (zzhdVarZzbp == null || zzhdVarZzbp.zzg(iZzeg)) {
                            zzju.zzb(t, iZzbq & 1048575, iZzeg);
                            zzb((zzil<T>) t, iZzbt);
                            continue;
                        } else {
                            objZza = zziy.zza(iZzdv, iZzeg, objZza, (zzjo<UT, Object>) zzjoVar);
                            break;
                        }
                    case 13:
                        zzju.zzb(t, iZzbq & 1048575, zzixVar.zzeh());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 14:
                        zzju.zza((Object) t, iZzbq & 1048575, zzixVar.zzei());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 15:
                        zzju.zzb(t, iZzbq & 1048575, zzixVar.zzej());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 16:
                        zzju.zza((Object) t, iZzbq & 1048575, zzixVar.zzek());
                        zzb((zzil<T>) t, iZzbt);
                        continue;
                    case 17:
                        if (zza((zzil<T>) t, iZzbt)) {
                            long j2 = iZzbq & 1048575;
                            zzju.zza(t, j2, zzgy.zzb(zzju.zzp(t, j2), zzixVar.zzc(zzbn(iZzbt), zzgiVar)));
                            break;
                        } else {
                            zzju.zza(t, iZzbq & 1048575, zzixVar.zzc(zzbn(iZzbt), zzgiVar));
                            zzb((zzil<T>) t, iZzbt);
                            continue;
                        }
                    case 18:
                        zzixVar.zza(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 19:
                        zzixVar.zzb(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 20:
                        zzixVar.zzd(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 21:
                        zzixVar.zzc(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 22:
                        zzixVar.zze(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 23:
                        zzixVar.zzf(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 24:
                        zzixVar.zzg(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 25:
                        zzixVar.zzh(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 26:
                        if (zzbs(iZzbq)) {
                            zzixVar.zzi(this.zzzw.zza(t, iZzbq & 1048575));
                            break;
                        } else {
                            zzixVar.readStringList(this.zzzw.zza(t, iZzbq & 1048575));
                            continue;
                        }
                    case 27:
                        zzixVar.zza(this.zzzw.zza(t, iZzbq & 1048575), zzbn(iZzbt), zzgiVar);
                        continue;
                    case 28:
                        zzixVar.zzj(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 29:
                        zzixVar.zzk(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 30:
                        List<Integer> listZza = this.zzzw.zza(t, iZzbq & 1048575);
                        zzixVar.zzl(listZza);
                        objZza = zziy.zza(iZzdv, listZza, zzbp(iZzbt), objZza, (zzjo<UT, Object>) zzjoVar);
                        continue;
                    case 31:
                        zzixVar.zzm(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 32:
                        zzixVar.zzn(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 33:
                        zzixVar.zzo(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 34:
                        zzixVar.zzp(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 35:
                        zzixVar.zza(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 36:
                        zzixVar.zzb(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 37:
                        zzixVar.zzd(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 38:
                        zzixVar.zzc(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 39:
                        zzixVar.zze(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 40:
                        zzixVar.zzf(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 41:
                        zzixVar.zzg(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 42:
                        zzixVar.zzh(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 43:
                        zzixVar.zzk(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 44:
                        List<Integer> listZza2 = this.zzzw.zza(t, iZzbq & 1048575);
                        zzixVar.zzl(listZza2);
                        objZza = zziy.zza(iZzdv, listZza2, zzbp(iZzbt), objZza, (zzjo<UT, Object>) zzjoVar);
                        continue;
                    case 45:
                        zzixVar.zzm(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 46:
                        zzixVar.zzn(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 47:
                        zzixVar.zzo(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 48:
                        zzixVar.zzp(this.zzzw.zza(t, iZzbq & 1048575));
                        continue;
                    case 49:
                        zzixVar.zzb(this.zzzw.zza(t, iZzbq & 1048575), zzbn(iZzbt), zzgiVar);
                        continue;
                    case 50:
                        Object objZzbo = zzbo(iZzbt);
                        long jZzbq = zzbq(iZzbt) & 1048575;
                        Object objZzp = zzju.zzp(t, jZzbq);
                        if (objZzp == null) {
                            objZzp = this.zzzz.zzp(objZzbo);
                            zzju.zza(t, jZzbq, objZzp);
                        } else if (this.zzzz.zzn(objZzp)) {
                            Object objZzp2 = this.zzzz.zzp(objZzbo);
                            this.zzzz.zzc(objZzp2, objZzp);
                            zzju.zza(t, jZzbq, objZzp2);
                            objZzp = objZzp2;
                        }
                        zzixVar.zza(this.zzzz.zzl(objZzp), this.zzzz.zzq(objZzbo), zzgiVar);
                        continue;
                    case 51:
                        zzju.zza(t, iZzbq & 1048575, Double.valueOf(zzixVar.readDouble()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 52:
                        zzju.zza(t, iZzbq & 1048575, Float.valueOf(zzixVar.readFloat()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 53:
                        zzju.zza(t, iZzbq & 1048575, Long.valueOf(zzixVar.zzdy()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 54:
                        zzju.zza(t, iZzbq & 1048575, Long.valueOf(zzixVar.zzdx()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 55:
                        zzju.zza(t, iZzbq & 1048575, Integer.valueOf(zzixVar.zzdz()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 56:
                        zzju.zza(t, iZzbq & 1048575, Long.valueOf(zzixVar.zzea()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 57:
                        zzju.zza(t, iZzbq & 1048575, Integer.valueOf(zzixVar.zzeb()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 58:
                        zzju.zza(t, iZzbq & 1048575, Boolean.valueOf(zzixVar.zzec()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 59:
                        zza(t, iZzbq, zzixVar);
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 60:
                        if (zza((zzil<T>) t, iZzdv, iZzbt)) {
                            long j3 = iZzbq & 1048575;
                            zzju.zza(t, j3, zzgy.zzb(zzju.zzp(t, j3), zzixVar.zza(zzbn(iZzbt), zzgiVar)));
                        } else {
                            zzju.zza(t, iZzbq & 1048575, zzixVar.zza(zzbn(iZzbt), zzgiVar));
                            zzb((zzil<T>) t, iZzbt);
                        }
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 61:
                        zzju.zza(t, iZzbq & 1048575, zzixVar.zzee());
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 62:
                        zzju.zza(t, iZzbq & 1048575, Integer.valueOf(zzixVar.zzef()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 63:
                        int iZzeg2 = zzixVar.zzeg();
                        zzhd zzhdVarZzbp2 = zzbp(iZzbt);
                        if (zzhdVarZzbp2 == null || zzhdVarZzbp2.zzg(iZzeg2)) {
                            zzju.zza(t, iZzbq & 1048575, Integer.valueOf(iZzeg2));
                            zzb((zzil<T>) t, iZzdv, iZzbt);
                            continue;
                        } else {
                            objZza = zziy.zza(iZzdv, iZzeg2, objZza, (zzjo<UT, Object>) zzjoVar);
                            break;
                        }
                        break;
                    case 64:
                        zzju.zza(t, iZzbq & 1048575, Integer.valueOf(zzixVar.zzeh()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 65:
                        zzju.zza(t, iZzbq & 1048575, Long.valueOf(zzixVar.zzei()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 66:
                        zzju.zza(t, iZzbq & 1048575, Integer.valueOf(zzixVar.zzej()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 67:
                        zzju.zza(t, iZzbq & 1048575, Long.valueOf(zzixVar.zzek()));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    case 68:
                        zzju.zza(t, iZzbq & 1048575, zzixVar.zzc(zzbn(iZzbt), zzgiVar));
                        zzb((zzil<T>) t, iZzdv, iZzbt);
                        continue;
                    default:
                        if (objZza == null) {
                            try {
                                objZza = zzjoVar.zzig();
                            } catch (zzhg unused) {
                                zzjoVar.zza(zzixVar);
                                if (objZza == null) {
                                    objZza = zzjoVar.zzx(t);
                                }
                                if (!zzjoVar.zza((zzjo) objZza, zzixVar)) {
                                    for (int i3 = this.zzzt; i3 < this.zzzu; i3++) {
                                        objZza = zza((Object) t, this.zzzs[i3], (int) objZza, (zzjo<UT, int>) zzjoVar);
                                    }
                                    if (objZza != null) {
                                        zzjoVar.zzg(t, objZza);
                                        return;
                                    }
                                    return;
                                }
                                break;
                            }
                        }
                        if (!zzjoVar.zza((zzjo) objZza, zzixVar)) {
                            for (int i4 = this.zzzt; i4 < this.zzzu; i4++) {
                                objZza = zza((Object) t, this.zzzs[i4], (int) objZza, (zzjo<UT, int>) zzjoVar);
                            }
                            if (objZza != null) {
                                zzjoVar.zzg(t, objZza);
                                return;
                            }
                            return;
                        }
                        break;
                }
            }
        }
    }

    private static zzjr zzt(Object obj) {
        zzgx zzgxVar = (zzgx) obj;
        zzjr zzjrVar = zzgxVar.zzws;
        if (zzjrVar != zzjr.zzih()) {
            return zzjrVar;
        }
        zzjr zzjrVarZzii = zzjr.zzii();
        zzgxVar.zzws = zzjrVarZzii;
        return zzjrVarZzii;
    }

    private static int zza(byte[] bArr, int i, int i2, zzkf zzkfVar, Class<?> cls, zzfg zzfgVar) throws IOException {
        switch (zzik.zzsg[zzkfVar.ordinal()]) {
            case 1:
                int iZzb = zzfe.zzb(bArr, i, zzfgVar);
                zzfgVar.zzsf = Boolean.valueOf(zzfgVar.zzse != 0);
                return iZzb;
            case 2:
                return zzfe.zze(bArr, i, zzfgVar);
            case 3:
                zzfgVar.zzsf = Double.valueOf(zzfe.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzfgVar.zzsf = Integer.valueOf(zzfe.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzfgVar.zzsf = Long.valueOf(zzfe.zzb(bArr, i));
                return i + 8;
            case 8:
                zzfgVar.zzsf = Float.valueOf(zzfe.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zzfe.zza(bArr, i, zzfgVar);
                zzfgVar.zzsf = Integer.valueOf(zzfgVar.zzsd);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zzfe.zzb(bArr, i, zzfgVar);
                zzfgVar.zzsf = Long.valueOf(zzfgVar.zzse);
                return iZzb2;
            case 14:
                return zzfe.zza(zzis.zzhp().zzf(cls), bArr, i, i2, zzfgVar);
            case 15:
                int iZza2 = zzfe.zza(bArr, i, zzfgVar);
                zzfgVar.zzsf = Integer.valueOf(zzfy.zzav(zzfgVar.zzsd));
                return iZza2;
            case 16:
                int iZzb3 = zzfe.zzb(bArr, i, zzfgVar);
                zzfgVar.zzsf = Long.valueOf(zzfy.zzr(zzfgVar.zzse));
                return iZzb3;
            case 17:
                return zzfe.zzd(bArr, i, zzfgVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzfg zzfgVar) throws IOException {
        int iZza;
        Unsafe unsafe = zzzi;
        zzhe zzheVarZzah = (zzhe) unsafe.getObject(t, j2);
        if (!zzheVarZzah.zzdp()) {
            int size = zzheVarZzah.size();
            zzheVarZzah = zzheVarZzah.zzah(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzheVarZzah);
        }
        zzhe zzheVar = zzheVarZzah;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return zzfe.zzf(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 1) {
                    zzgg zzggVar = (zzgg) zzheVar;
                    zzggVar.zzc(zzfe.zzc(bArr, i));
                    int i8 = i + 8;
                    while (i8 < i2) {
                        int iZza2 = zzfe.zza(bArr, i8, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return i8;
                        }
                        zzggVar.zzc(zzfe.zzc(bArr, iZza2));
                        i8 = iZza2 + 8;
                    }
                    return i8;
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return zzfe.zze(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 5) {
                    zzgt zzgtVar = (zzgt) zzheVar;
                    zzgtVar.zzu(zzfe.zzd(bArr, i));
                    int i9 = i + 4;
                    while (i9 < i2) {
                        int iZza3 = zzfe.zza(bArr, i9, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return i9;
                        }
                        zzgtVar.zzu(zzfe.zzd(bArr, iZza3));
                        i9 = iZza3 + 4;
                    }
                    return i9;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return zzfe.zzb(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 0) {
                    zzhv zzhvVar = (zzhv) zzheVar;
                    int iZzb = zzfe.zzb(bArr, i, zzfgVar);
                    zzhvVar.zzac(zzfgVar.zzse);
                    while (iZzb < i2) {
                        int iZza4 = zzfe.zza(bArr, iZzb, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return iZzb;
                        }
                        iZzb = zzfe.zzb(bArr, iZza4, zzfgVar);
                        zzhvVar.zzac(zzfgVar.zzse);
                    }
                    return iZzb;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzfe.zza(bArr, i, (zzhe<?>) zzheVar, zzfgVar);
                }
                if (i5 == 0) {
                    return zzfe.zza(i3, bArr, i, i2, (zzhe<?>) zzheVar, zzfgVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return zzfe.zzd(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 1) {
                    zzhv zzhvVar2 = (zzhv) zzheVar;
                    zzhvVar2.zzac(zzfe.zzb(bArr, i));
                    int i10 = i + 8;
                    while (i10 < i2) {
                        int iZza5 = zzfe.zza(bArr, i10, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return i10;
                        }
                        zzhvVar2.zzac(zzfe.zzb(bArr, iZza5));
                        i10 = iZza5 + 8;
                    }
                    return i10;
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return zzfe.zzc(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 5) {
                    zzgz zzgzVar = (zzgz) zzheVar;
                    zzgzVar.zzbm(zzfe.zza(bArr, i));
                    int i11 = i + 4;
                    while (i11 < i2) {
                        int iZza6 = zzfe.zza(bArr, i11, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return i11;
                        }
                        zzgzVar.zzbm(zzfe.zza(bArr, iZza6));
                        i11 = iZza6 + 4;
                    }
                    return i11;
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return zzfe.zzg(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 0) {
                    zzfk zzfkVar = (zzfk) zzheVar;
                    int iZzb2 = zzfe.zzb(bArr, i, zzfgVar);
                    zzfkVar.addBoolean(zzfgVar.zzse != 0);
                    while (iZzb2 < i2) {
                        int iZza7 = zzfe.zza(bArr, iZzb2, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return iZzb2;
                        }
                        iZzb2 = zzfe.zzb(bArr, iZza7, zzfgVar);
                        zzfkVar.addBoolean(zzfgVar.zzse != 0);
                    }
                    return iZzb2;
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZza8 = zzfe.zza(bArr, i, zzfgVar);
                        int i12 = zzfgVar.zzsd;
                        if (i12 < 0) {
                            throw zzhh.zzgo();
                        }
                        if (i12 == 0) {
                            zzheVar.add("");
                        } else {
                            zzheVar.add(new String(bArr, iZza8, i12, zzgy.UTF_8));
                            iZza8 += i12;
                        }
                        while (iZza8 < i2) {
                            int iZza9 = zzfe.zza(bArr, iZza8, zzfgVar);
                            if (i3 != zzfgVar.zzsd) {
                                return iZza8;
                            }
                            iZza8 = zzfe.zza(bArr, iZza9, zzfgVar);
                            int i13 = zzfgVar.zzsd;
                            if (i13 < 0) {
                                throw zzhh.zzgo();
                            }
                            if (i13 == 0) {
                                zzheVar.add("");
                            } else {
                                zzheVar.add(new String(bArr, iZza8, i13, zzgy.UTF_8));
                                iZza8 += i13;
                            }
                        }
                        return iZza8;
                    }
                    int iZza10 = zzfe.zza(bArr, i, zzfgVar);
                    int i14 = zzfgVar.zzsd;
                    if (i14 < 0) {
                        throw zzhh.zzgo();
                    }
                    if (i14 == 0) {
                        zzheVar.add("");
                    } else {
                        int i15 = iZza10 + i14;
                        if (!zzjx.zzf(bArr, iZza10, i15)) {
                            throw zzhh.zzgu();
                        }
                        zzheVar.add(new String(bArr, iZza10, i14, zzgy.UTF_8));
                        iZza10 = i15;
                    }
                    while (iZza10 < i2) {
                        int iZza11 = zzfe.zza(bArr, iZza10, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return iZza10;
                        }
                        iZza10 = zzfe.zza(bArr, iZza11, zzfgVar);
                        int i16 = zzfgVar.zzsd;
                        if (i16 < 0) {
                            throw zzhh.zzgo();
                        }
                        if (i16 == 0) {
                            zzheVar.add("");
                        } else {
                            int i17 = iZza10 + i16;
                            if (!zzjx.zzf(bArr, iZza10, i17)) {
                                throw zzhh.zzgu();
                            }
                            zzheVar.add(new String(bArr, iZza10, i16, zzgy.UTF_8));
                            iZza10 = i17;
                        }
                    }
                    return iZza10;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return zzfe.zza(zzbn(i6), i3, bArr, i, i2, zzheVar, zzfgVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    int iZza12 = zzfe.zza(bArr, i, zzfgVar);
                    int i18 = zzfgVar.zzsd;
                    if (i18 < 0) {
                        throw zzhh.zzgo();
                    }
                    if (i18 > bArr.length - iZza12) {
                        throw zzhh.zzgn();
                    }
                    if (i18 == 0) {
                        zzheVar.add(zzfm.zzsm);
                    } else {
                        zzheVar.add(zzfm.zza(bArr, iZza12, i18));
                        iZza12 += i18;
                    }
                    while (iZza12 < i2) {
                        int iZza13 = zzfe.zza(bArr, iZza12, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return iZza12;
                        }
                        iZza12 = zzfe.zza(bArr, iZza13, zzfgVar);
                        int i19 = zzfgVar.zzsd;
                        if (i19 < 0) {
                            throw zzhh.zzgo();
                        }
                        if (i19 > bArr.length - iZza12) {
                            throw zzhh.zzgn();
                        }
                        if (i19 == 0) {
                            zzheVar.add(zzfm.zzsm);
                        } else {
                            zzheVar.add(zzfm.zza(bArr, iZza12, i19));
                            iZza12 += i19;
                        }
                    }
                    return iZza12;
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzfe.zza(i3, bArr, i, i2, (zzhe<?>) zzheVar, zzfgVar);
                    }
                    return i;
                }
                iZza = zzfe.zza(bArr, i, (zzhe<?>) zzheVar, zzfgVar);
                zzgx zzgxVar = (zzgx) t;
                zzjr zzjrVar = zzgxVar.zzws;
                if (zzjrVar == zzjr.zzih()) {
                    zzjrVar = null;
                }
                zzjr zzjrVar2 = (zzjr) zziy.zza(i4, (List<Integer>) zzheVar, zzbp(i6), zzjrVar, (zzjo<UT, zzjr>) this.zzzx);
                if (zzjrVar2 != null) {
                    zzgxVar.zzws = zzjrVar2;
                }
                return iZza;
            case 33:
            case 47:
                if (i5 == 2) {
                    return zzfe.zzh(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 0) {
                    zzgz zzgzVar2 = (zzgz) zzheVar;
                    int iZza14 = zzfe.zza(bArr, i, zzfgVar);
                    zzgzVar2.zzbm(zzfy.zzav(zzfgVar.zzsd));
                    while (iZza14 < i2) {
                        int iZza15 = zzfe.zza(bArr, iZza14, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return iZza14;
                        }
                        iZza14 = zzfe.zza(bArr, iZza15, zzfgVar);
                        zzgzVar2.zzbm(zzfy.zzav(zzfgVar.zzsd));
                    }
                    return iZza14;
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return zzfe.zzi(bArr, i, zzheVar, zzfgVar);
                }
                if (i5 == 0) {
                    zzhv zzhvVar3 = (zzhv) zzheVar;
                    int iZzb3 = zzfe.zzb(bArr, i, zzfgVar);
                    zzhvVar3.zzac(zzfy.zzr(zzfgVar.zzse));
                    while (iZzb3 < i2) {
                        int iZza16 = zzfe.zza(bArr, iZzb3, zzfgVar);
                        if (i3 != zzfgVar.zzsd) {
                            return iZzb3;
                        }
                        iZzb3 = zzfe.zzb(bArr, iZza16, zzfgVar);
                        zzhvVar3.zzac(zzfy.zzr(zzfgVar.zzse));
                    }
                    return iZzb3;
                }
                return i;
            case 49:
                if (i5 == 3) {
                    zziw zziwVarZzbn = zzbn(i6);
                    int i20 = (i3 & (-8)) | 4;
                    int iZza17 = zzfe.zza(zziwVarZzbn, bArr, i, i2, i20, zzfgVar);
                    zziw zziwVar = zziwVarZzbn;
                    int i21 = i2;
                    zzfg zzfgVar2 = zzfgVar;
                    zzheVar.add(zzfgVar2.zzsf);
                    while (iZza17 < i21) {
                        int iZza18 = zzfe.zza(bArr, iZza17, zzfgVar2);
                        if (i3 != zzfgVar2.zzsd) {
                            return iZza17;
                        }
                        zziw zziwVar2 = zziwVar;
                        int i22 = i21;
                        zzfg zzfgVar3 = zzfgVar2;
                        iZza17 = zzfe.zza(zziwVar2, bArr, iZza18, i22, i20, zzfgVar3);
                        zzheVar.add(zzfgVar3.zzsf);
                        zziwVar = zziwVar2;
                        i21 = i22;
                        zzfgVar2 = zzfgVar3;
                    }
                    return iZza17;
                }
                return i;
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzfg zzfgVar) throws IOException {
        byte[] bArr2;
        zzfg zzfgVar2;
        int i4;
        Unsafe unsafe = zzzi;
        Object objZzbo = zzbo(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzzz.zzn(object)) {
            Object objZzp = this.zzzz.zzp(objZzbo);
            this.zzzz.zzc(objZzp, object);
            unsafe.putObject(t, j, objZzp);
            object = objZzp;
        }
        zzhy<?, ?> zzhyVarZzq = this.zzzz.zzq(objZzbo);
        Map<?, ?> mapZzl = this.zzzz.zzl(object);
        int iZza = zzfe.zza(bArr, i, zzfgVar);
        int i5 = zzfgVar.zzsd;
        if (i5 < 0 || i5 > i2 - iZza) {
            throw zzhh.zzgn();
        }
        int i6 = i5 + iZza;
        K k = zzhyVarZzq.zzzc;
        V v = zzhyVarZzq.zzgl;
        while (iZza < i6) {
            int iZza2 = iZza + 1;
            int i7 = bArr[iZza];
            if (i7 < 0) {
                iZza2 = zzfe.zza(i7, bArr, iZza2, zzfgVar);
                i7 = zzfgVar.zzsd;
            }
            int i8 = iZza2;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 == 1) {
                bArr2 = bArr;
                int i11 = i2;
                zzfgVar2 = zzfgVar;
                if (i10 == zzhyVarZzq.zzzb.zzir()) {
                    i4 = i11;
                    iZza = zza(bArr2, i8, i4, zzhyVarZzq.zzzb, (Class<?>) null, zzfgVar2);
                    k = zzfgVar2.zzsf;
                    bArr = bArr2;
                    i2 = i4;
                    zzfgVar = zzfgVar2;
                } else {
                    i4 = i11;
                }
            } else if (i9 == 2 && i10 == zzhyVarZzq.zzzd.zzir()) {
                byte[] bArr3 = bArr;
                int i12 = i2;
                zzfg zzfgVar3 = zzfgVar;
                iZza = zza(bArr3, i8, i12, zzhyVarZzq.zzzd, zzhyVarZzq.zzgl.getClass(), zzfgVar3);
                v = (V) zzfgVar3.zzsf;
                i2 = i12;
                bArr = bArr3;
            } else {
                bArr2 = bArr;
                i4 = i2;
                zzfgVar2 = zzfgVar;
            }
            iZza = zzfe.zza(i7, bArr2, i8, i4, zzfgVar2);
            k = k;
            bArr = bArr2;
            i2 = i4;
            zzfgVar = zzfgVar2;
        }
        if (iZza != i6) {
            throw zzhh.zzgt();
        }
        mapZzl.put(k, v);
        return i6;
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzfg zzfgVar) throws IOException {
        int i9;
        int i10;
        int iZzb;
        Object object;
        Unsafe unsafe = zzzi;
        long j2 = this.zzzj[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                unsafe.putObject(t, j, Double.valueOf(zzfe.zzc(bArr, i)));
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                unsafe.putObject(t, j, Float.valueOf(zzfe.zzd(bArr, i)));
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzfe.zzb(bArr, i, zzfgVar);
                unsafe.putObject(t, j, Long.valueOf(zzfgVar.zzse));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzfe.zza(bArr, i, zzfgVar);
                unsafe.putObject(t, j, Integer.valueOf(zzfgVar.zzsd));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                unsafe.putObject(t, j, Long.valueOf(zzfe.zzb(bArr, i)));
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                unsafe.putObject(t, j, Integer.valueOf(zzfe.zza(bArr, i)));
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzfe.zzb(bArr, i, zzfgVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzfgVar.zzse != 0));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzfe.zza(bArr, i, zzfgVar);
                int i11 = zzfgVar.zzsd;
                if (i11 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzjx.zzf(bArr, iZza, iZza + i11)) {
                        throw zzhh.zzgu();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i11, zzgy.UTF_8));
                    iZza += i11;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zzfe.zza(zzbn(i8), bArr, i, i2, zzfgVar);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzfgVar.zzsf);
                } else {
                    unsafe.putObject(t, j, zzgy.zzb(object, zzfgVar.zzsf));
                }
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iZzb = zzfe.zze(bArr, i, zzfgVar);
                unsafe.putObject(t, j, zzfgVar.zzsf);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZza3 = zzfe.zza(bArr, i, zzfgVar);
                int i12 = zzfgVar.zzsd;
                zzhd zzhdVarZzbp = zzbp(i8);
                if (zzhdVarZzbp == null || zzhdVarZzbp.zzg(i12)) {
                    unsafe.putObject(t, j, Integer.valueOf(i12));
                    iZzb = iZza3;
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
                zzt(t).zzb(i3, Long.valueOf(i12));
                return iZza3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzfe.zza(bArr, i, zzfgVar);
                unsafe.putObject(t, j, Integer.valueOf(zzfy.zzav(zzfgVar.zzsd)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzfe.zzb(bArr, i, zzfgVar);
                unsafe.putObject(t, j, Long.valueOf(zzfy.zzr(zzfgVar.zzse)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 == 3) {
                    iZzb = zzfe.zza(zzbn(i8), bArr, i, i2, (i3 & (-8)) | 4, zzfgVar);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzfgVar.zzsf);
                    } else {
                        unsafe.putObject(t, j, zzgy.zzb(object, zzfgVar.zzsf));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
            default:
                return i;
        }
    }

    private final zziw zzbn(int i) {
        int i2 = (i / 3) << 1;
        zziw zziwVar = (zziw) this.zzzk[i2];
        if (zziwVar != null) {
            return zziwVar;
        }
        zziw<T> zziwVarZzf = zzis.zzhp().zzf((Class) this.zzzk[i2 + 1]);
        this.zzzk[i2] = zziwVarZzf;
        return zziwVarZzf;
    }

    private final Object zzbo(int i) {
        return this.zzzk[(i / 3) << 1];
    }

    private final zzhd zzbp(int i) {
        return (zzhd) this.zzzk[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:232:0x06eb, code lost:
    
        if (r11 == 1048575) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x06ed, code lost:
    
        r22.putInt(r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x06f3, code lost:
    
        r0 = r9.zzzt;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x06f9, code lost:
    
        if (r0 >= r9.zzzu) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x06fb, code lost:
    
        r1 = (com.google.android.gms.internal.vision.zzjr) r9.zza((java.lang.Object) r10, r9.zzzs[r0], (int) r1, (com.google.android.gms.internal.vision.zzjo<UT, int>) r9.zzzx);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x070a, code lost:
    
        if (r1 == null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x070c, code lost:
    
        r9.zzzx.zzg(r10, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0711, code lost:
    
        if (r14 != 0) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0713, code lost:
    
        if (r4 != r3) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x071a, code lost:
    
        throw com.google.android.gms.internal.vision.zzhh.zzgt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x071b, code lost:
    
        if (r4 > r3) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x071d, code lost:
    
        if (r13 != r14) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x071f, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0724, code lost:
    
        throw com.google.android.gms.internal.vision.zzhh.zzgt();
     */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x069c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza(T t, byte[] bArr, int i, int i2, int i3, zzfg zzfgVar) throws IOException {
        int i4;
        zzil<T> zzilVar;
        T t2;
        Unsafe unsafe;
        int iZzbt;
        int iZzb;
        int i5;
        boolean z;
        int i6;
        int i7;
        byte[] bArr2;
        Object obj;
        Object objZzb;
        int iZzf;
        zzfc zzfcVar;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Unsafe unsafe2;
        int i16;
        byte[] bArr3;
        int i17;
        zzfg zzfgVar2;
        Unsafe unsafe3;
        int i18;
        Unsafe unsafe4;
        byte[] bArr4;
        Unsafe unsafe5;
        int i19;
        int i20;
        int i21;
        byte[] bArr5;
        int iZzd;
        zzil<T> zzilVar2 = this;
        T t3 = t;
        byte[] bArr6 = bArr;
        int i22 = i2;
        zzfg zzfgVar3 = zzfgVar;
        Unsafe unsafe6 = zzzi;
        int i23 = -1;
        int iZza = i;
        int i24 = -1;
        int i25 = 0;
        int i26 = 1048575;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            Object objValueOf = null;
            if (iZza < i22) {
                int iZza2 = iZza + 1;
                int i29 = bArr6[iZza];
                if (i29 < 0) {
                    iZza2 = zzfe.zza(i29, bArr6, iZza2, zzfgVar3);
                    i29 = zzfgVar3.zzsd;
                }
                int i30 = iZza2;
                i28 = i29;
                int i31 = i28 >>> 3;
                int i32 = i25;
                int i33 = i28 & 7;
                if (i31 > i24) {
                    iZzbt = zzilVar2.zzt(i31, i32 / 3);
                } else {
                    iZzbt = zzilVar2.zzbt(i31);
                }
                if (iZzbt == i23) {
                    zzilVar = zzilVar2;
                    t2 = t3;
                    iZzb = i30;
                    unsafe = unsafe6;
                    i24 = i31;
                    i5 = 0;
                    z = true;
                    i4 = i3;
                } else {
                    int[] iArr = zzilVar2.zzzj;
                    int i34 = iArr[iZzbt + 1];
                    int i35 = (i34 & 267386880) >>> 20;
                    long j = i34 & 1048575;
                    if (i35 <= 17) {
                        int i36 = iArr[iZzbt + 2];
                        int i37 = 1 << (i36 >>> 20);
                        int i38 = i36 & 1048575;
                        if (i38 != i26) {
                            i14 = i34;
                            i13 = i30;
                            if (i26 != 1048575) {
                                unsafe6.putInt(t3, i26, i27);
                            }
                            i27 = unsafe6.getInt(t3, i38);
                            i26 = i38;
                        } else {
                            i13 = i30;
                            i14 = i34;
                        }
                        switch (i35) {
                            case 0:
                                t2 = t3;
                                i15 = iZzbt;
                                unsafe2 = unsafe6;
                                i16 = i13;
                                bArr3 = bArr;
                                i17 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 1) {
                                    zzju.zza(t2, j, zzfe.zzc(bArr3, i16));
                                    iZza = i16 + 8;
                                    i27 |= i37;
                                    i25 = i15;
                                    bArr6 = bArr3;
                                    i22 = i17;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    unsafe6 = unsafe2;
                                    t3 = t2;
                                    i23 = -1;
                                    break;
                                }
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 1:
                                t2 = t3;
                                i15 = iZzbt;
                                unsafe2 = unsafe6;
                                i16 = i13;
                                bArr3 = bArr;
                                i17 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 5) {
                                    zzju.zza((Object) t2, j, zzfe.zzd(bArr3, i16));
                                    iZza = i16 + 4;
                                    i27 |= i37;
                                    i25 = i15;
                                    bArr6 = bArr3;
                                    i22 = i17;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    unsafe6 = unsafe2;
                                    t3 = t2;
                                    i23 = -1;
                                    break;
                                }
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 2:
                            case 3:
                                i15 = iZzbt;
                                unsafe3 = unsafe6;
                                i16 = i13;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 0) {
                                    int iZzb2 = zzfe.zzb(bArr, i16, zzfgVar2);
                                    T t4 = t3;
                                    unsafe2 = unsafe3;
                                    unsafe2.putLong(t4, j, zzfgVar2.zzse);
                                    t2 = t4;
                                    i27 |= i37;
                                    iZza = iZzb2;
                                    bArr6 = bArr;
                                    i22 = i2;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i25 = i15;
                                    unsafe6 = unsafe2;
                                    t3 = t2;
                                    i23 = -1;
                                    break;
                                }
                                t2 = t3;
                                unsafe2 = unsafe3;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 4:
                            case 11:
                                i15 = iZzbt;
                                unsafe3 = unsafe6;
                                i16 = i13;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 0) {
                                    int iZza3 = zzfe.zza(bArr, i16, zzfgVar2);
                                    unsafe3.putInt(t3, j, zzfgVar2.zzsd);
                                    i27 |= i37;
                                    unsafe6 = unsafe3;
                                    bArr6 = bArr;
                                    i25 = i15;
                                    iZza = iZza3;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                                t2 = t3;
                                unsafe2 = unsafe3;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 5:
                            case 14:
                                i15 = iZzbt;
                                unsafe4 = unsafe6;
                                int i39 = i13;
                                bArr4 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 != 1) {
                                    i16 = i39;
                                    t2 = t3;
                                    unsafe2 = unsafe4;
                                    i5 = i15;
                                    i4 = i3;
                                    unsafe = unsafe2;
                                    iZzb = i16;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    z = true;
                                    zzilVar = zzilVar2;
                                    break;
                                } else {
                                    T t5 = t3;
                                    unsafe4.putLong(t5, j, zzfe.zzb(bArr4, i39));
                                    unsafe5 = unsafe4;
                                    t3 = t5;
                                    iZza = i39 + 8;
                                    i27 |= i37;
                                    byte[] bArr7 = bArr4;
                                    unsafe6 = unsafe5;
                                    bArr6 = bArr7;
                                    i25 = i15;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                            case 6:
                            case 13:
                                i15 = iZzbt;
                                unsafe5 = unsafe6;
                                i19 = i13;
                                bArr4 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 5) {
                                    unsafe5.putInt(t3, j, zzfe.zza(bArr4, i19));
                                    iZza = i19 + 4;
                                    i27 |= i37;
                                    byte[] bArr72 = bArr4;
                                    unsafe6 = unsafe5;
                                    bArr6 = bArr72;
                                    i25 = i15;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                                t2 = t3;
                                unsafe2 = unsafe5;
                                i16 = i19;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 7:
                                int i40 = iZzbt;
                                unsafe5 = unsafe6;
                                i19 = i13;
                                bArr4 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 != 0) {
                                    i15 = i40;
                                    t2 = t3;
                                    unsafe2 = unsafe5;
                                    i16 = i19;
                                    i5 = i15;
                                    i4 = i3;
                                    unsafe = unsafe2;
                                    iZzb = i16;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    z = true;
                                    zzilVar = zzilVar2;
                                    break;
                                } else {
                                    iZza = zzfe.zzb(bArr4, i19, zzfgVar2);
                                    i15 = i40;
                                    zzju.zza(t3, j, zzfgVar2.zzse != 0);
                                    i27 |= i37;
                                    byte[] bArr722 = bArr4;
                                    unsafe6 = unsafe5;
                                    bArr6 = bArr722;
                                    i25 = i15;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                            case 8:
                                i20 = iZzbt;
                                unsafe4 = unsafe6;
                                i21 = i13;
                                bArr5 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 2) {
                                    if ((i14 & 536870912) == 0) {
                                        iZzd = zzfe.zzc(bArr5, i21, zzfgVar2);
                                    } else {
                                        iZzd = zzfe.zzd(bArr5, i21, zzfgVar2);
                                    }
                                    iZza = iZzd;
                                    unsafe4.putObject(t3, j, zzfgVar2.zzsf);
                                    i27 |= i37;
                                    byte[] bArr8 = bArr5;
                                    unsafe6 = unsafe4;
                                    bArr6 = bArr8;
                                    i25 = i20;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                                i16 = i21;
                                i15 = i20;
                                t2 = t3;
                                unsafe2 = unsafe4;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 9:
                                i20 = iZzbt;
                                unsafe4 = unsafe6;
                                i21 = i13;
                                bArr5 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 2) {
                                    iZza = zzfe.zza(zzilVar2.zzbn(i20), bArr5, i21, i18, zzfgVar2);
                                    if ((i27 & i37) == 0) {
                                        unsafe4.putObject(t3, j, zzfgVar2.zzsf);
                                    } else {
                                        unsafe4.putObject(t3, j, zzgy.zzb(unsafe4.getObject(t3, j), zzfgVar2.zzsf));
                                    }
                                    i27 |= i37;
                                    byte[] bArr82 = bArr5;
                                    unsafe6 = unsafe4;
                                    bArr6 = bArr82;
                                    i25 = i20;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                                i16 = i21;
                                i15 = i20;
                                t2 = t3;
                                unsafe2 = unsafe4;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 10:
                                i20 = iZzbt;
                                unsafe4 = unsafe6;
                                i21 = i13;
                                bArr5 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 2) {
                                    iZza = zzfe.zze(bArr5, i21, zzfgVar2);
                                    unsafe4.putObject(t3, j, zzfgVar2.zzsf);
                                    i27 |= i37;
                                    byte[] bArr822 = bArr5;
                                    unsafe6 = unsafe4;
                                    bArr6 = bArr822;
                                    i25 = i20;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                                i16 = i21;
                                i15 = i20;
                                t2 = t3;
                                unsafe2 = unsafe4;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 12:
                                i20 = iZzbt;
                                unsafe4 = unsafe6;
                                i21 = i13;
                                bArr5 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 0) {
                                    iZza = zzfe.zza(bArr5, i21, zzfgVar2);
                                    int i41 = zzfgVar2.zzsd;
                                    zzhd zzhdVarZzbp = zzilVar2.zzbp(i20);
                                    if (zzhdVarZzbp == null || zzhdVarZzbp.zzg(i41)) {
                                        unsafe4.putInt(t3, j, i41);
                                        i27 |= i37;
                                        byte[] bArr8222 = bArr5;
                                        unsafe6 = unsafe4;
                                        bArr6 = bArr8222;
                                        i25 = i20;
                                        i22 = i18;
                                        zzfgVar3 = zzfgVar2;
                                        i24 = i31;
                                        i23 = -1;
                                        break;
                                    } else {
                                        zzt(t3).zzb(i28, Long.valueOf(i41));
                                        byte[] bArr82222 = bArr5;
                                        unsafe6 = unsafe4;
                                        bArr6 = bArr82222;
                                        i25 = i20;
                                        i22 = i18;
                                        zzfgVar3 = zzfgVar2;
                                        i24 = i31;
                                        i23 = -1;
                                    }
                                }
                                i16 = i21;
                                i15 = i20;
                                t2 = t3;
                                unsafe2 = unsafe4;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 15:
                                i20 = iZzbt;
                                unsafe4 = unsafe6;
                                i21 = i13;
                                bArr5 = bArr;
                                i18 = i2;
                                zzfgVar2 = zzfgVar3;
                                if (i33 == 0) {
                                    iZza = zzfe.zza(bArr5, i21, zzfgVar2);
                                    unsafe4.putInt(t3, j, zzfy.zzav(zzfgVar2.zzsd));
                                    i27 |= i37;
                                    byte[] bArr822222 = bArr5;
                                    unsafe6 = unsafe4;
                                    bArr6 = bArr822222;
                                    i25 = i20;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                                i16 = i21;
                                i15 = i20;
                                t2 = t3;
                                unsafe2 = unsafe4;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                            case 16:
                                zzfg zzfgVar4 = zzfgVar3;
                                i20 = iZzbt;
                                i21 = i13;
                                if (i33 != 0) {
                                    unsafe4 = unsafe6;
                                    zzfgVar2 = zzfgVar4;
                                    i16 = i21;
                                    i15 = i20;
                                    t2 = t3;
                                    unsafe2 = unsafe4;
                                    i5 = i15;
                                    i4 = i3;
                                    unsafe = unsafe2;
                                    iZzb = i16;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    z = true;
                                    zzilVar = zzilVar2;
                                    break;
                                } else {
                                    int iZzb3 = zzfe.zzb(bArr, i21, zzfgVar4);
                                    zzfgVar2 = zzfgVar4;
                                    T t6 = t3;
                                    Unsafe unsafe7 = unsafe6;
                                    i18 = i2;
                                    unsafe7.putLong(t6, j, zzfy.zzr(zzfgVar4.zzse));
                                    t3 = t6;
                                    i27 |= i37;
                                    unsafe6 = unsafe7;
                                    bArr6 = bArr;
                                    iZza = iZzb3;
                                    i25 = i20;
                                    i22 = i18;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    i23 = -1;
                                    break;
                                }
                            case 17:
                                if (i33 != 3) {
                                    t2 = t3;
                                    zzfgVar2 = zzfgVar3;
                                    i15 = iZzbt;
                                    unsafe2 = unsafe6;
                                    i16 = i13;
                                    i5 = i15;
                                    i4 = i3;
                                    unsafe = unsafe2;
                                    iZzb = i16;
                                    zzfgVar3 = zzfgVar2;
                                    i24 = i31;
                                    z = true;
                                    zzilVar = zzilVar2;
                                    break;
                                } else {
                                    zzfg zzfgVar5 = zzfgVar3;
                                    int i42 = iZzbt;
                                    iZza = zzfe.zza(zzilVar2.zzbn(iZzbt), bArr, i13, i2, (i31 << 3) | 4, zzfgVar5);
                                    bArr6 = bArr;
                                    if ((i27 & i37) == 0) {
                                        unsafe6.putObject(t3, j, zzfgVar5.zzsf);
                                    } else {
                                        unsafe6.putObject(t3, j, zzgy.zzb(unsafe6.getObject(t3, j), zzfgVar5.zzsf));
                                    }
                                    i27 |= i37;
                                    zzfgVar3 = zzfgVar5;
                                    i25 = i42;
                                    i24 = i31;
                                    i23 = -1;
                                    i22 = i2;
                                    break;
                                }
                            default:
                                t2 = t3;
                                zzfgVar2 = zzfgVar3;
                                i15 = iZzbt;
                                unsafe2 = unsafe6;
                                i16 = i13;
                                i5 = i15;
                                i4 = i3;
                                unsafe = unsafe2;
                                iZzb = i16;
                                zzfgVar3 = zzfgVar2;
                                i24 = i31;
                                z = true;
                                zzilVar = zzilVar2;
                                break;
                        }
                    } else {
                        T t7 = t3;
                        int i43 = iZzbt;
                        Unsafe unsafe8 = unsafe6;
                        zzfg zzfgVar6 = zzfgVar3;
                        if (i35 != 27) {
                            i8 = i43;
                            i9 = i30;
                            if (i35 <= 49) {
                                i10 = i26;
                                i11 = i27;
                                unsafe = unsafe8;
                                z = true;
                                int iZza4 = zzilVar2.zza((zzil<T>) t, bArr, i9, i2, i28, i31, i33, i8, i34, i35, j, zzfgVar);
                                i28 = i28;
                                i12 = i31;
                                if (iZza4 == i9) {
                                    t2 = t;
                                    i4 = i3;
                                    zzfgVar3 = zzfgVar;
                                    iZzb = iZza4;
                                    i5 = i8;
                                    i24 = i12;
                                    i26 = i10;
                                    i27 = i11;
                                    zzilVar = this;
                                } else {
                                    zzilVar2 = this;
                                    t3 = t;
                                    bArr6 = bArr;
                                    i22 = i2;
                                    zzfgVar3 = zzfgVar;
                                    iZza = iZza4;
                                    i25 = i8;
                                    i24 = i12;
                                    i26 = i10;
                                    i27 = i11;
                                    unsafe6 = unsafe;
                                }
                            } else {
                                i10 = i26;
                                i11 = i27;
                                unsafe = unsafe8;
                                i12 = i31;
                                z = true;
                                if (i35 == 50) {
                                    if (i33 == 2) {
                                        int iZza5 = zza((zzil<T>) t, bArr, i9, i2, i8, j, zzfgVar);
                                        i8 = i8;
                                        if (iZza5 == i9) {
                                            t2 = t;
                                            i4 = i3;
                                            zzfgVar3 = zzfgVar;
                                            iZzb = iZza5;
                                        } else {
                                            zzilVar2 = this;
                                            t3 = t;
                                            bArr6 = bArr;
                                            i22 = i2;
                                            zzfgVar3 = zzfgVar;
                                            iZza = iZza5;
                                            i25 = i8;
                                            i24 = i12;
                                            i26 = i10;
                                            i27 = i11;
                                            unsafe6 = unsafe;
                                        }
                                    }
                                    i5 = i8;
                                    i24 = i12;
                                    i26 = i10;
                                    i27 = i11;
                                    zzilVar = this;
                                } else {
                                    i24 = i12;
                                    int iZza6 = zza((zzil<T>) t, bArr, i9, i2, i28, i24, i33, i34, i35, j, i8, zzfgVar);
                                    i28 = i28;
                                    zzfgVar3 = zzfgVar;
                                    zzilVar = this;
                                    t2 = t;
                                    i4 = i3;
                                    if (iZza6 == i9) {
                                        iZzb = iZza6;
                                        i5 = i8;
                                        i26 = i10;
                                        i27 = i11;
                                    } else {
                                        bArr6 = bArr;
                                        i22 = i2;
                                        zzfgVar3 = zzfgVar;
                                        iZza = iZza6;
                                        i25 = i8;
                                        zzilVar2 = zzilVar;
                                        t3 = t2;
                                        i26 = i10;
                                        i27 = i11;
                                        unsafe6 = unsafe;
                                    }
                                }
                            }
                            i23 = -1;
                        } else if (i33 == 2) {
                            zzhe zzheVarZzah = (zzhe) unsafe8.getObject(t7, j);
                            if (!zzheVarZzah.zzdp()) {
                                int size = zzheVarZzah.size();
                                zzheVarZzah = zzheVarZzah.zzah(size == 0 ? 10 : size << 1);
                                unsafe8.putObject(t7, j, zzheVarZzah);
                            }
                            iZza = zzfe.zza(zzilVar2.zzbn(i43), i28, bArr, i30, i2, zzheVarZzah, zzfgVar6);
                            bArr6 = bArr;
                            i22 = i2;
                            zzfgVar3 = zzfgVar;
                            i25 = i43;
                            t3 = t7;
                            unsafe6 = unsafe8;
                            i24 = i31;
                            i23 = -1;
                        } else {
                            i8 = i43;
                            unsafe = unsafe8;
                            i9 = i30;
                            i10 = i26;
                            i11 = i27;
                            i12 = i31;
                            z = true;
                        }
                        t2 = t;
                        i4 = i3;
                        zzfgVar3 = zzfgVar;
                        iZzb = i9;
                        i5 = i8;
                        i24 = i12;
                        i26 = i10;
                        i27 = i11;
                        zzilVar = this;
                    }
                }
                if (i28 != i4 || i4 == 0) {
                    if (zzilVar.zzzo && zzfgVar3.zzcu != zzgi.zzfm()) {
                        zzih zzihVar = zzilVar.zzzn;
                        zzjo<?, ?> zzjoVar = zzilVar.zzzx;
                        zzgx.zzg zzgVarZza = zzfgVar3.zzcu.zza(zzihVar, i24);
                        if (zzgVarZza == null) {
                            bArr2 = bArr;
                            iZzb = zzfe.zza(i28, bArr2, iZzb, i2, zzt(t2), zzfgVar3);
                            i7 = i5;
                            i6 = i26;
                        } else {
                            zzgx.zze zzeVar = (zzgx.zze) t2;
                            zzeVar.zzgl();
                            zzgn<zzgx.zzd> zzgnVar = zzeVar.zzwz;
                            i7 = i5;
                            if (zzgVarZza.zzxq.zzwx && zzgVarZza.zzxq.zzwy) {
                                switch (zzfh.zzsg[zzgVarZza.zzxq.zzww.ordinal()]) {
                                    case 1:
                                        i6 = i26;
                                        zzfc zzggVar = new zzgg();
                                        iZzf = zzfe.zzf(bArr, iZzb, zzggVar, zzfgVar3);
                                        zzfcVar = zzggVar;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 2:
                                        i6 = i26;
                                        zzfc zzgtVar = new zzgt();
                                        iZzf = zzfe.zze(bArr, iZzb, zzgtVar, zzfgVar3);
                                        zzfcVar = zzgtVar;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 3:
                                    case 4:
                                        i6 = i26;
                                        zzfc zzhvVar = new zzhv();
                                        iZzf = zzfe.zzb(bArr, iZzb, zzhvVar, zzfgVar3);
                                        zzfcVar = zzhvVar;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 5:
                                    case 6:
                                        i6 = i26;
                                        zzfc zzgzVar = new zzgz();
                                        iZzf = zzfe.zza(bArr, iZzb, zzgzVar, zzfgVar3);
                                        zzfcVar = zzgzVar;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 7:
                                    case 8:
                                        i6 = i26;
                                        zzfc zzhvVar2 = new zzhv();
                                        iZzf = zzfe.zzd(bArr, iZzb, zzhvVar2, zzfgVar3);
                                        zzfcVar = zzhvVar2;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 9:
                                    case 10:
                                        i6 = i26;
                                        zzfc zzgzVar2 = new zzgz();
                                        iZzf = zzfe.zzc(bArr, iZzb, zzgzVar2, zzfgVar3);
                                        zzfcVar = zzgzVar2;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 11:
                                        i6 = i26;
                                        zzfc zzfkVar = new zzfk();
                                        iZzf = zzfe.zzg(bArr, iZzb, zzfkVar, zzfgVar3);
                                        zzfcVar = zzfkVar;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 12:
                                        i6 = i26;
                                        zzfc zzgzVar3 = new zzgz();
                                        iZzf = zzfe.zzh(bArr, iZzb, zzgzVar3, zzfgVar3);
                                        zzfcVar = zzgzVar3;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 13:
                                        i6 = i26;
                                        zzfc zzhvVar3 = new zzhv();
                                        iZzf = zzfe.zzi(bArr, iZzb, zzhvVar3, zzfgVar3);
                                        zzfcVar = zzhvVar3;
                                        iZzb = iZzf;
                                        bArr2 = bArr;
                                        objZzb = zzfcVar;
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                        break;
                                    case 14:
                                        zzgz zzgzVar4 = new zzgz();
                                        int iZza7 = zzfe.zza(bArr, iZzb, zzgzVar4, zzfgVar3);
                                        zzjr zzjrVar = zzeVar.zzws;
                                        i6 = i26;
                                        if (zzjrVar == zzjr.zzih()) {
                                            zzjrVar = null;
                                        }
                                        zzjr zzjrVar2 = (zzjr) zziy.zza(i24, (List<Integer>) zzgzVar4, zzgVarZza.zzxq.zzwv, zzjrVar, (zzjo<UT, zzjr>) zzjoVar);
                                        if (zzjrVar2 != null) {
                                            zzeVar.zzws = zzjrVar2;
                                        }
                                        zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, zzgzVar4);
                                        bArr2 = bArr;
                                        iZzb = iZza7;
                                        break;
                                    default:
                                        String strValueOf = String.valueOf(zzgVarZza.zzxq.zzww);
                                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
                                        sb.append("Type cannot be packed: ");
                                        sb.append(strValueOf);
                                        throw new IllegalStateException(sb.toString());
                                }
                            } else {
                                i6 = i26;
                                if (zzgVarZza.zzxq.zzww == zzkf.zzaco) {
                                    iZzb = zzfe.zza(bArr, iZzb, zzfgVar3);
                                    if (zzgVarZza.zzxq.zzwv.zzh(zzfgVar3.zzsd) == null) {
                                        zzjr zzjrVarZzii = zzeVar.zzws;
                                        if (zzjrVarZzii == zzjr.zzih()) {
                                            zzjrVarZzii = zzjr.zzii();
                                            zzeVar.zzws = zzjrVarZzii;
                                        }
                                        zziy.zza(i24, zzfgVar3.zzsd, zzjrVarZzii, (zzjo<UT, zzjr>) zzjoVar);
                                        bArr2 = bArr;
                                    } else {
                                        objValueOf = Integer.valueOf(zzfgVar3.zzsd);
                                    }
                                } else {
                                    switch (zzfh.zzsg[zzgVarZza.zzxq.zzww.ordinal()]) {
                                        case 1:
                                            bArr2 = bArr;
                                            objValueOf = Double.valueOf(zzfe.zzc(bArr2, iZzb));
                                            iZzb += 8;
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                                zzgnVar.zzb((zzgn<zzgx.zzd>) zzgVarZza.zzxq, obj);
                                                break;
                                            } else {
                                                int i44 = zzfh.zzsg[zzgVarZza.zzxq.zzww.ordinal()];
                                                if (i44 != 17) {
                                                    objZzb = obj;
                                                    if (i44 == 18) {
                                                        Object objZza = zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq);
                                                        objZzb = obj;
                                                        if (objZza != null) {
                                                            objZzb = zzgy.zzb(objZza, obj);
                                                        }
                                                    }
                                                    zzgnVar.zza((zzgn<zzgx.zzd>) zzgVarZza.zzxq, objZzb);
                                                    break;
                                                }
                                            }
                                        case 2:
                                            bArr2 = bArr;
                                            objValueOf = Float.valueOf(zzfe.zzd(bArr2, iZzb));
                                            iZzb += 4;
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 3:
                                        case 4:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zzb(bArr2, iZzb, zzfgVar3);
                                            objValueOf = Long.valueOf(zzfgVar3.zzse);
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 5:
                                        case 6:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zza(bArr2, iZzb, zzfgVar3);
                                            objValueOf = Integer.valueOf(zzfgVar3.zzsd);
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 7:
                                        case 8:
                                            bArr2 = bArr;
                                            objValueOf = Long.valueOf(zzfe.zzb(bArr2, iZzb));
                                            iZzb += 8;
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 9:
                                        case 10:
                                            bArr2 = bArr;
                                            objValueOf = Integer.valueOf(zzfe.zza(bArr2, iZzb));
                                            iZzb += 4;
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 11:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zzb(bArr2, iZzb, zzfgVar3);
                                            if (zzfgVar3.zzse == 0) {
                                                z = false;
                                            }
                                            objValueOf = Boolean.valueOf(z);
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 12:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zza(bArr2, iZzb, zzfgVar3);
                                            objValueOf = Integer.valueOf(zzfy.zzav(zzfgVar3.zzsd));
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 13:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zzb(bArr2, iZzb, zzfgVar3);
                                            objValueOf = Long.valueOf(zzfy.zzr(zzfgVar3.zzse));
                                            obj = objValueOf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 14:
                                            throw new IllegalStateException("Shouldn't reach here.");
                                        case 15:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zze(bArr2, iZzb, zzfgVar3);
                                            obj = zzfgVar3.zzsf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 16:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zzc(bArr2, iZzb, zzfgVar3);
                                            obj = zzfgVar3.zzsf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 17:
                                            bArr2 = bArr;
                                            iZzb = zzfe.zza(zzis.zzhp().zzf(zzgVarZza.zzxp.getClass()), bArr2, iZzb, i2, (i24 << 3) | 4, zzfgVar3);
                                            obj = zzfgVar3.zzsf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                        case 18:
                                            iZzb = zzfe.zza(zzis.zzhp().zzf(zzgVarZza.zzxp.getClass()), bArr, iZzb, i2, zzfgVar3);
                                            bArr2 = bArr;
                                            obj = zzfgVar3.zzsf;
                                            if (!zzgVarZza.zzxq.zzwx) {
                                            }
                                            break;
                                    }
                                }
                                bArr2 = bArr;
                                obj = objValueOf;
                                if (!zzgVarZza.zzxq.zzwx) {
                                }
                            }
                        }
                        iZza = iZzb;
                        i25 = i7;
                        i22 = i2;
                        bArr6 = bArr2;
                    } else {
                        i6 = i26;
                        i22 = i2;
                        iZza = zzfe.zza(i28, bArr, iZzb, i22, zzt(t2), zzfgVar3);
                        bArr6 = bArr;
                        i25 = i5;
                        zzfgVar3 = zzfgVar;
                    }
                    zzilVar2 = zzilVar;
                    t3 = t2;
                    i26 = i6;
                    unsafe6 = unsafe;
                    i23 = -1;
                } else {
                    i22 = i2;
                    iZza = iZzb;
                }
            } else {
                i4 = i3;
                zzilVar = zzilVar2;
                t2 = t3;
                unsafe = unsafe6;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0087. Please report as an issue. */
    @Override // com.google.android.gms.internal.vision.zziw
    public final void zza(T t, byte[] bArr, int i, int i2, zzfg zzfgVar) throws IOException {
        int iZzbt;
        T t2;
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzil<T> zzilVar = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i12 = i2;
        zzfg zzfgVar2 = zzfgVar;
        if (zzilVar.zzzq) {
            Unsafe unsafe2 = zzzi;
            int i13 = -1;
            int iZzb = i;
            int i14 = -1;
            int i15 = 0;
            int i16 = 1048575;
            int i17 = 0;
            while (iZzb < i12) {
                int iZza = iZzb + 1;
                int i18 = bArr2[iZzb];
                if (i18 < 0) {
                    iZza = zzfe.zza(i18, bArr2, iZza, zzfgVar2);
                    i18 = zzfgVar2.zzsd;
                }
                int i19 = iZza;
                int i20 = i18 >>> 3;
                int i21 = i18 & 7;
                if (i20 > i14) {
                    iZzbt = zzilVar.zzt(i20, i15 / 3);
                } else {
                    iZzbt = zzilVar.zzbt(i20);
                }
                if (iZzbt == i13) {
                    t2 = t3;
                    unsafe = unsafe2;
                    i3 = i18;
                    i4 = i20;
                    i5 = 0;
                } else {
                    int[] iArr = zzilVar.zzzj;
                    int i22 = iArr[iZzbt + 1];
                    int i23 = (i22 & 267386880) >>> 20;
                    int i24 = i18;
                    int i25 = iZzbt;
                    long j = i22 & 1048575;
                    if (i23 <= 17) {
                        int i26 = iArr[i25 + 2];
                        int i27 = 1 << (i26 >>> 20);
                        int i28 = i26 & 1048575;
                        int i29 = 1048575;
                        if (i28 != i16) {
                            if (i16 != 1048575) {
                                unsafe2.putInt(t3, i16, i17);
                                i29 = 1048575;
                            }
                            if (i28 != i29) {
                                i17 = unsafe2.getInt(t3, i28);
                            }
                            i16 = i28;
                        }
                        switch (i23) {
                            case 0:
                                if (i21 != 1) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    zzju.zza(t3, j, zzfe.zzc(bArr2, i19));
                                    iZzb = i19 + 8;
                                    i17 |= i27;
                                    i12 = i2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 1:
                                if (i21 != 5) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    zzju.zza((Object) t3, j, zzfe.zzd(bArr2, i19));
                                    iZzb = i19 + 4;
                                    i17 |= i27;
                                    i12 = i2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 2:
                            case 3:
                                if (i21 != 0) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    int iZzb2 = zzfe.zzb(bArr2, i19, zzfgVar2);
                                    Unsafe unsafe3 = unsafe2;
                                    T t4 = t3;
                                    unsafe3.putLong(t4, j, zzfgVar2.zzse);
                                    unsafe2 = unsafe3;
                                    t3 = t4;
                                    i17 |= i27;
                                    iZzb = iZzb2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    i12 = i2;
                                    break;
                                }
                            case 4:
                            case 11:
                                if (i21 != 0) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    int iZza2 = zzfe.zza(bArr2, i19, zzfgVar2);
                                    unsafe2.putInt(t3, j, zzfgVar2.zzsd);
                                    i17 |= i27;
                                    i12 = i2;
                                    iZzb = iZza2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 5:
                            case 14:
                                if (i21 != 1) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    Unsafe unsafe4 = unsafe2;
                                    T t5 = t3;
                                    unsafe4.putLong(t5, j, zzfe.zzb(bArr2, i19));
                                    unsafe2 = unsafe4;
                                    t3 = t5;
                                    iZzb = i19 + 8;
                                    i17 |= i27;
                                    i12 = i2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 6:
                            case 13:
                                if (i21 != 5) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    unsafe2.putInt(t3, j, zzfe.zza(bArr2, i19));
                                    iZzb = i19 + 4;
                                    i17 |= i27;
                                    i12 = i2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 7:
                                if (i21 != 0) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    iZzb = zzfe.zzb(bArr2, i19, zzfgVar2);
                                    zzju.zza(t3, j, zzfgVar2.zzse != 0);
                                    i17 |= i27;
                                    i12 = i2;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 8:
                                if (i21 != 2) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    if ((536870912 & i22) == 0) {
                                        iZzb = zzfe.zzc(bArr2, i19, zzfgVar2);
                                    } else {
                                        iZzb = zzfe.zzd(bArr2, i19, zzfgVar2);
                                    }
                                    unsafe2.putObject(t3, j, zzfgVar2.zzsf);
                                    i17 |= i27;
                                    i14 = i20;
                                    i15 = i25;
                                    i13 = -1;
                                    break;
                                }
                            case 9:
                                i11 = i25;
                                if (i21 != 2) {
                                    i25 = i11;
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    iZzb = zzfe.zza(zzilVar.zzbn(i11), bArr2, i19, i12, zzfgVar2);
                                    Object object = unsafe2.getObject(t3, j);
                                    if (object == null) {
                                        unsafe2.putObject(t3, j, zzfgVar2.zzsf);
                                    } else {
                                        unsafe2.putObject(t3, j, zzgy.zzb(object, zzfgVar2.zzsf));
                                    }
                                    i17 |= i27;
                                    i14 = i20;
                                    i15 = i11;
                                    i13 = -1;
                                    break;
                                }
                            case 10:
                                i11 = i25;
                                if (i21 != 2) {
                                    i25 = i11;
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    iZzb = zzfe.zze(bArr2, i19, zzfgVar2);
                                    unsafe2.putObject(t3, j, zzfgVar2.zzsf);
                                    i17 |= i27;
                                    i14 = i20;
                                    i15 = i11;
                                    i13 = -1;
                                    break;
                                }
                            case 12:
                                i11 = i25;
                                if (i21 != 0) {
                                    i25 = i11;
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    iZzb = zzfe.zza(bArr2, i19, zzfgVar2);
                                    unsafe2.putInt(t3, j, zzfgVar2.zzsd);
                                    i17 |= i27;
                                    i14 = i20;
                                    i15 = i11;
                                    i13 = -1;
                                    break;
                                }
                            case 15:
                                i11 = i25;
                                if (i21 != 0) {
                                    i25 = i11;
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    iZzb = zzfe.zza(bArr2, i19, zzfgVar2);
                                    unsafe2.putInt(t3, j, zzfy.zzav(zzfgVar2.zzsd));
                                    i17 |= i27;
                                    i14 = i20;
                                    i15 = i11;
                                    i13 = -1;
                                    break;
                                }
                            case 16:
                                if (i21 != 0) {
                                    t2 = t3;
                                    unsafe = unsafe2;
                                    i4 = i20;
                                    i5 = i25;
                                    i3 = i24;
                                    break;
                                } else {
                                    int iZzb3 = zzfe.zzb(bArr2, i19, zzfgVar2);
                                    Unsafe unsafe5 = unsafe2;
                                    T t6 = t3;
                                    i11 = i25;
                                    unsafe5.putLong(t6, j, zzfy.zzr(zzfgVar2.zzse));
                                    unsafe2 = unsafe5;
                                    t3 = t6;
                                    i17 |= i27;
                                    iZzb = iZzb3;
                                    i14 = i20;
                                    i15 = i11;
                                    i13 = -1;
                                    break;
                                }
                            default:
                                t2 = t3;
                                unsafe = unsafe2;
                                i4 = i20;
                                i5 = i25;
                                i3 = i24;
                                break;
                        }
                    } else {
                        i5 = i25;
                        if (i23 != 27) {
                            i6 = i19;
                            Unsafe unsafe6 = unsafe2;
                            if (i23 <= 49) {
                                int i30 = i16;
                                i7 = i17;
                                unsafe = unsafe6;
                                int iZza3 = zzilVar.zza((zzil<T>) t, bArr, i6, i2, i24, i20, i21, i5, i22, i23, j, zzfgVar);
                                if (iZza3 == i6) {
                                    i19 = iZza3;
                                    i4 = i20;
                                    i3 = i24;
                                    i17 = i7;
                                    t2 = t;
                                    i16 = i30;
                                } else {
                                    zzilVar = this;
                                    t3 = t;
                                    i16 = i30;
                                    zzfgVar2 = zzfgVar;
                                    iZzb = iZza3;
                                    i15 = i5;
                                    i14 = i20;
                                    i17 = i7;
                                    unsafe2 = unsafe;
                                    i13 = -1;
                                    bArr2 = bArr;
                                    i12 = i2;
                                }
                            } else {
                                i7 = i17;
                                unsafe = unsafe6;
                                i8 = i20;
                                i9 = i16;
                                i10 = i24;
                                if (i23 != 50) {
                                    i4 = i8;
                                    int iZza4 = zza((zzil<T>) t, bArr, i6, i2, i10, i4, i21, i22, i23, j, i5, zzfgVar);
                                    t2 = t;
                                    i3 = i10;
                                    i5 = i5;
                                    if (iZza4 == i6) {
                                        i19 = iZza4;
                                        i16 = i9;
                                        i17 = i7;
                                    } else {
                                        zzilVar = this;
                                        zzfgVar2 = zzfgVar;
                                        i14 = i4;
                                        iZzb = iZza4;
                                        i15 = i5;
                                        t3 = t2;
                                        i16 = i9;
                                        i17 = i7;
                                        unsafe2 = unsafe;
                                        i13 = -1;
                                        bArr2 = bArr;
                                        i12 = i2;
                                    }
                                } else if (i21 == 2) {
                                    int iZza5 = zza((zzil<T>) t, bArr, i6, i2, i5, j, zzfgVar);
                                    i5 = i5;
                                    if (iZza5 == i6) {
                                        i19 = iZza5;
                                        i4 = i8;
                                        i3 = i10;
                                        i16 = i9;
                                        i17 = i7;
                                        t2 = t;
                                    } else {
                                        zzilVar = this;
                                        t3 = t;
                                        bArr2 = bArr;
                                        zzfgVar2 = zzfgVar;
                                        iZzb = iZza5;
                                        i15 = i5;
                                        i14 = i8;
                                        i16 = i9;
                                        i17 = i7;
                                        unsafe2 = unsafe;
                                        i13 = -1;
                                        i12 = i2;
                                    }
                                } else {
                                    i5 = i5;
                                    i19 = i6;
                                    i4 = i8;
                                    i3 = i10;
                                    i16 = i9;
                                    i17 = i7;
                                    t2 = t;
                                }
                            }
                        } else if (i21 == 2) {
                            zzhe zzheVarZzah = (zzhe) unsafe2.getObject(t3, j);
                            if (!zzheVarZzah.zzdp()) {
                                int size = zzheVarZzah.size();
                                zzheVarZzah = zzheVarZzah.zzah(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t3, j, zzheVarZzah);
                            }
                            int iZza6 = zzfe.zza(zzilVar.zzbn(i5), i24, bArr2, i19, i2, zzheVarZzah, zzfgVar2);
                            bArr2 = bArr;
                            zzfgVar2 = zzfgVar;
                            iZzb = iZza6;
                            i15 = i5;
                            unsafe2 = unsafe2;
                            i14 = i20;
                            i13 = -1;
                            t3 = t;
                            i12 = i2;
                        } else {
                            i6 = i19;
                            i7 = i17;
                            unsafe = unsafe2;
                            i8 = i20;
                            i9 = i16;
                            i10 = i24;
                            i19 = i6;
                            i4 = i8;
                            i3 = i10;
                            i16 = i9;
                            i17 = i7;
                            t2 = t;
                        }
                    }
                }
                int iZza7 = zzfe.zza(i3, bArr, i19, i2, zzt(t2), zzfgVar);
                bArr2 = bArr;
                zzfgVar2 = zzfgVar;
                i14 = i4;
                i15 = i5;
                t3 = t2;
                unsafe2 = unsafe;
                i13 = -1;
                i12 = i2;
                iZzb = iZza7;
                zzilVar = this;
            }
            T t7 = t3;
            Unsafe unsafe7 = unsafe2;
            int i31 = i12;
            int i32 = i16;
            int i33 = i17;
            if (i32 != 1048575) {
                unsafe7.putInt(t7, i32, i33);
            }
            if (iZzb != i31) {
                throw zzhh.zzgt();
            }
            return;
        }
        zza((zzil<T>) t3, bArr, i, i12, 0, zzfgVar);
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzh(T t) {
        int i;
        int i2 = this.zzzt;
        while (true) {
            i = this.zzzu;
            if (i2 >= i) {
                break;
            }
            long jZzbq = zzbq(this.zzzs[i2]) & 1048575;
            Object objZzp = zzju.zzp(t, jZzbq);
            if (objZzp != null) {
                zzju.zza(t, jZzbq, this.zzzz.zzo(objZzp));
            }
            i2++;
        }
        int length = this.zzzs.length;
        while (i < length) {
            this.zzzw.zzb(t, this.zzzs[i]);
            i++;
        }
        this.zzzx.zzh(t);
        if (this.zzzo) {
            this.zzzy.zzh(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzjo<UT, UB> zzjoVar) {
        zzhd zzhdVarZzbp;
        int i2 = this.zzzj[i];
        Object objZzp = zzju.zzp(obj, zzbq(i) & 1048575);
        return (objZzp == null || (zzhdVarZzbp = zzbp(i)) == null) ? ub : (UB) zza(i, i2, this.zzzz.zzl(objZzp), zzhdVarZzbp, (zzhd) ub, (zzjo<UT, zzhd>) zzjoVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzhd zzhdVar, UB ub, zzjo<UT, UB> zzjoVar) {
        zzhy<?, ?> zzhyVarZzq = this.zzzz.zzq(zzbo(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzhdVar.zzg(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzjoVar.zzig();
                }
                zzfu zzfuVarZzaq = zzfm.zzaq(zzhz.zza(zzhyVarZzq, next.getKey(), next.getValue()));
                try {
                    zzhz.zza(zzfuVarZzaq.zzex(), zzhyVarZzq, next.getKey(), next.getValue());
                    zzjoVar.zza((zzjo<UT, UB>) ub, i2, zzfuVarZzaq.zzew());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.gms.internal.vision.zziw] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.google.android.gms.internal.vision.zziw] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    @Override // com.google.android.gms.internal.vision.zziw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzu(T t) {
        int i;
        int i2;
        zzil<T> zzilVar;
        T t2;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < this.zzzt) {
            int i6 = this.zzzs[i3];
            int i7 = this.zzzj[i6];
            int iZzbq = zzbq(i6);
            int i8 = this.zzzj[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i4) {
                if (i9 != 1048575) {
                    i5 = zzzi.getInt(t, i9);
                }
                i2 = i5;
                i = i9;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzbq) != 0) {
                zzilVar = this;
                t2 = t;
                if (!zzilVar.zza((zzil<T>) t2, i6, i, i2, i10)) {
                    return false;
                }
            } else {
                zzilVar = this;
                t2 = t;
            }
            int i11 = (267386880 & iZzbq) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zzilVar.zza((zzil<T>) t2, i6, i, i2, i10) && !zza(t2, iZzbq, zzbn(i6))) {
                    return false;
                }
            } else if (i11 == 27) {
                List list = (List) zzju.zzp(t2, iZzbq & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? Zzbn = zzbn(i6);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!Zzbn.zzu(list.get(i12))) {
                            return false;
                        }
                    }
                }
            } else if (i11 == 60 || i11 == 68) {
                if (zza((zzil<T>) t2, i7, i6) && !zza(t2, iZzbq, zzbn(i6))) {
                    return false;
                }
            } else if (i11 != 49) {
                if (i11 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzm = zzilVar.zzzz.zzm(zzju.zzp(t2, iZzbq & 1048575));
                    if (mapZzm.isEmpty()) {
                        continue;
                    } else if (zzilVar.zzzz.zzq(zzbo(i6)).zzzd.zziq() == zzki.MESSAGE) {
                        ?? Zzf = 0;
                        for (Object obj : mapZzm.values()) {
                            Zzf = Zzf;
                            if (Zzf == 0) {
                                Zzf = zzis.zzhp().zzf(obj.getClass());
                            }
                            if (!Zzf.zzu(obj)) {
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
        return !this.zzzo || this.zzzy.zzf(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zziw zziwVar) {
        return zziwVar.zzu(zzju.zzp(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzkl zzklVar) throws IOException {
        if (obj instanceof String) {
            zzklVar.zza(i, (String) obj);
        } else {
            zzklVar.zza(i, (zzfm) obj);
        }
    }

    private final void zza(Object obj, int i, zzix zzixVar) throws IOException {
        if (zzbs(i)) {
            zzju.zza(obj, i & 1048575, zzixVar.zzed());
        } else if (this.zzzp) {
            zzju.zza(obj, i & 1048575, zzixVar.readString());
        } else {
            zzju.zza(obj, i & 1048575, zzixVar.zzee());
        }
    }

    private final int zzbq(int i) {
        return this.zzzj[i + 1];
    }

    private final int zzbr(int i) {
        return this.zzzj[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzju.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzju.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzju.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzju.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzju.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzil<T>) t, i) == zza((zzil<T>) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzil<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int iZzbr = zzbr(i);
        long j = iZzbr & 1048575;
        if (j != 1048575) {
            return (zzju.zzk(t, j) & (1 << (iZzbr >>> 20))) != 0;
        }
        int iZzbq = zzbq(i);
        long j2 = iZzbq & 1048575;
        switch ((iZzbq & 267386880) >>> 20) {
            case 0:
                return zzju.zzo(t, j2) != 0.0d;
            case 1:
                return zzju.zzn(t, j2) != 0.0f;
            case 2:
                return zzju.zzl(t, j2) != 0;
            case 3:
                return zzju.zzl(t, j2) != 0;
            case 4:
                return zzju.zzk(t, j2) != 0;
            case 5:
                return zzju.zzl(t, j2) != 0;
            case 6:
                return zzju.zzk(t, j2) != 0;
            case 7:
                return zzju.zzm(t, j2);
            case 8:
                Object objZzp = zzju.zzp(t, j2);
                if (objZzp instanceof String) {
                    return !((String) objZzp).isEmpty();
                }
                if (objZzp instanceof zzfm) {
                    return !zzfm.zzsm.equals(objZzp);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzju.zzp(t, j2) != null;
            case 10:
                return !zzfm.zzsm.equals(zzju.zzp(t, j2));
            case 11:
                return zzju.zzk(t, j2) != 0;
            case 12:
                return zzju.zzk(t, j2) != 0;
            case 13:
                return zzju.zzk(t, j2) != 0;
            case 14:
                return zzju.zzl(t, j2) != 0;
            case 15:
                return zzju.zzk(t, j2) != 0;
            case 16:
                return zzju.zzl(t, j2) != 0;
            case 17:
                return zzju.zzp(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzb(T t, int i) {
        int iZzbr = zzbr(i);
        long j = 1048575 & iZzbr;
        if (j == 1048575) {
            return;
        }
        zzju.zzb(t, j, (1 << (iZzbr >>> 20)) | zzju.zzk(t, j));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzju.zzk(t, (long) (zzbr(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzju.zzb(t, zzbr(i2) & 1048575, i);
    }

    private final int zzbt(int i) {
        if (i < this.zzzl || i > this.zzzm) {
            return -1;
        }
        return zzu(i, 0);
    }

    private final int zzt(int i, int i2) {
        if (i < this.zzzl || i > this.zzzm) {
            return -1;
        }
        return zzu(i, i2);
    }

    private final int zzu(int i, int i2) {
        int length = (this.zzzj.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzzj[i4];
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
}
