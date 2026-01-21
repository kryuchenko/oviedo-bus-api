package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class zzlu<T> implements zzmf<T> {
    private static final int[] zzub = new int[0];
    private static final Unsafe zzuc = zznd.zzff();
    private final int[] zzud;
    private final Object[] zzue;
    private final int zzuf;
    private final int zzug;
    private final zzlq zzuh;
    private final boolean zzui;
    private final boolean zzuj;
    private final boolean zzuk;
    private final boolean zzul;
    private final int[] zzum;
    private final int zzun;
    private final int zzuo;
    private final zzly zzup;
    private final zzla zzuq;
    private final zzmx<?, ?> zzur;
    private final zzjy<?> zzus;
    private final zzll zzut;

    private zzlu(int[] iArr, Object[] objArr, int i, int i2, zzlq zzlqVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzly zzlyVar, zzla zzlaVar, zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzll zzllVar) {
        this.zzud = iArr;
        this.zzue = objArr;
        this.zzuf = i;
        this.zzug = i2;
        this.zzuj = zzlqVar instanceof zzkk;
        this.zzuk = z;
        this.zzui = zzjyVar != null && zzjyVar.zze(zzlqVar);
        this.zzul = false;
        this.zzum = iArr2;
        this.zzun = i3;
        this.zzuo = i4;
        this.zzup = zzlyVar;
        this.zzuq = zzlaVar;
        this.zzur = zzmxVar;
        this.zzus = zzjyVar;
        this.zzuh = zzlqVar;
        this.zzut = zzllVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> zzlu<T> zza(Class<T> cls, zzlo zzloVar, zzly zzlyVar, zzla zzlaVar, zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzll zzllVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
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
        int i18;
        int i19;
        int i20;
        int i21;
        int iObjectFieldOffset;
        String str;
        int i22;
        int iObjectFieldOffset2;
        int i23;
        Field fieldZza;
        char cCharAt9;
        int i24;
        Field fieldZza2;
        Field fieldZza3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        char cCharAt14;
        if (zzloVar instanceof zzme) {
            zzme zzmeVar = (zzme) zzloVar;
            int i30 = 0;
            boolean z = zzmeVar.zzec() == zzkk.zze.zzsg;
            String strZzek = zzmeVar.zzek();
            int length = strZzek.length();
            int iCharAt2 = strZzek.charAt(0);
            if (iCharAt2 >= 55296) {
                int i31 = iCharAt2 & 8191;
                int i32 = 1;
                int i33 = 13;
                while (true) {
                    i = i32 + 1;
                    cCharAt14 = strZzek.charAt(i32);
                    if (cCharAt14 < 55296) {
                        break;
                    }
                    i31 |= (cCharAt14 & 8191) << i33;
                    i33 += 13;
                    i32 = i;
                }
                iCharAt2 = i31 | (cCharAt14 << i33);
            } else {
                i = 1;
            }
            int i34 = i + 1;
            int iCharAt3 = strZzek.charAt(i);
            if (iCharAt3 >= 55296) {
                int i35 = iCharAt3 & 8191;
                int i36 = 13;
                while (true) {
                    i29 = i34 + 1;
                    cCharAt13 = strZzek.charAt(i34);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt13 & 8191) << i36;
                    i36 += 13;
                    i34 = i29;
                }
                iCharAt3 = i35 | (cCharAt13 << i36);
                i34 = i29;
            }
            if (iCharAt3 == 0) {
                iArr = zzub;
                i4 = 0;
                i5 = 0;
                iCharAt = 0;
                i6 = 0;
                i7 = 0;
                i3 = 0;
            } else {
                int i37 = i34 + 1;
                int iCharAt4 = strZzek.charAt(i34);
                if (iCharAt4 >= 55296) {
                    int i38 = iCharAt4 & 8191;
                    int i39 = 13;
                    while (true) {
                        i15 = i37 + 1;
                        cCharAt8 = strZzek.charAt(i37);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i38 |= (cCharAt8 & 8191) << i39;
                        i39 += 13;
                        i37 = i15;
                    }
                    iCharAt4 = i38 | (cCharAt8 << i39);
                    i37 = i15;
                }
                int i40 = i37 + 1;
                int iCharAt5 = strZzek.charAt(i37);
                if (iCharAt5 >= 55296) {
                    int i41 = iCharAt5 & 8191;
                    int i42 = 13;
                    while (true) {
                        i14 = i40 + 1;
                        cCharAt7 = strZzek.charAt(i40);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i41 |= (cCharAt7 & 8191) << i42;
                        i42 += 13;
                        i40 = i14;
                    }
                    iCharAt5 = i41 | (cCharAt7 << i42);
                    i40 = i14;
                }
                int i43 = i40 + 1;
                iCharAt = strZzek.charAt(i40);
                if (iCharAt >= 55296) {
                    int i44 = iCharAt & 8191;
                    int i45 = 13;
                    while (true) {
                        i13 = i43 + 1;
                        cCharAt6 = strZzek.charAt(i43);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i44 |= (cCharAt6 & 8191) << i45;
                        i45 += 13;
                        i43 = i13;
                    }
                    iCharAt = i44 | (cCharAt6 << i45);
                    i43 = i13;
                }
                int i46 = i43 + 1;
                int iCharAt6 = strZzek.charAt(i43);
                if (iCharAt6 >= 55296) {
                    int i47 = iCharAt6 & 8191;
                    int i48 = 13;
                    while (true) {
                        i12 = i46 + 1;
                        cCharAt5 = strZzek.charAt(i46);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i47 |= (cCharAt5 & 8191) << i48;
                        i48 += 13;
                        i46 = i12;
                    }
                    iCharAt6 = i47 | (cCharAt5 << i48);
                    i46 = i12;
                }
                int i49 = i46 + 1;
                int iCharAt7 = strZzek.charAt(i46);
                if (iCharAt7 >= 55296) {
                    int i50 = iCharAt7 & 8191;
                    int i51 = 13;
                    while (true) {
                        i11 = i49 + 1;
                        cCharAt4 = strZzek.charAt(i49);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i50 |= (cCharAt4 & 8191) << i51;
                        i51 += 13;
                        i49 = i11;
                    }
                    iCharAt7 = i50 | (cCharAt4 << i51);
                    i49 = i11;
                }
                int i52 = i49 + 1;
                int iCharAt8 = strZzek.charAt(i49);
                if (iCharAt8 >= 55296) {
                    int i53 = iCharAt8 & 8191;
                    int i54 = 13;
                    while (true) {
                        i10 = i52 + 1;
                        cCharAt3 = strZzek.charAt(i52);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i53 |= (cCharAt3 & 8191) << i54;
                        i54 += 13;
                        i52 = i10;
                    }
                    iCharAt8 = i53 | (cCharAt3 << i54);
                    i52 = i10;
                }
                int i55 = i52 + 1;
                int iCharAt9 = strZzek.charAt(i52);
                if (iCharAt9 >= 55296) {
                    int i56 = iCharAt9 & 8191;
                    int i57 = i55;
                    int i58 = 13;
                    while (true) {
                        i9 = i57 + 1;
                        cCharAt2 = strZzek.charAt(i57);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i56 |= (cCharAt2 & 8191) << i58;
                        i58 += 13;
                        i57 = i9;
                    }
                    iCharAt9 = i56 | (cCharAt2 << i58);
                    i2 = i9;
                } else {
                    i2 = i55;
                }
                int i59 = i2 + 1;
                int iCharAt10 = strZzek.charAt(i2);
                if (iCharAt10 >= 55296) {
                    int i60 = iCharAt10 & 8191;
                    int i61 = i59;
                    int i62 = 13;
                    while (true) {
                        i8 = i61 + 1;
                        cCharAt = strZzek.charAt(i61);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i60 |= (cCharAt & 8191) << i62;
                        i62 += 13;
                        i61 = i8;
                    }
                    iCharAt10 = i60 | (cCharAt << i62);
                    i59 = i8;
                }
                int[] iArr2 = new int[iCharAt10 + iCharAt8 + iCharAt9];
                i3 = (iCharAt4 << 1) + iCharAt5;
                int i63 = iCharAt7;
                iArr = iArr2;
                i4 = i63;
                i5 = iCharAt6;
                i6 = iCharAt8;
                i7 = iCharAt10;
                i30 = iCharAt4;
                i34 = i59;
            }
            Unsafe unsafe = zzuc;
            Object[] objArrZzel = zzmeVar.zzel();
            Class<?> cls2 = zzmeVar.zzee().getClass();
            int[] iArr3 = new int[i4 * 3];
            Object[] objArr = new Object[i4 << 1];
            int i64 = i6 + i7;
            int i65 = i64;
            int i66 = i7;
            int i67 = 0;
            int i68 = 0;
            while (i34 < length) {
                int i69 = i34 + 1;
                int iCharAt11 = strZzek.charAt(i34);
                int[] iArr4 = iArr3;
                if (iCharAt11 >= 55296) {
                    int i70 = iCharAt11 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i28 = i71 + 1;
                        cCharAt12 = strZzek.charAt(i71);
                        i16 = length;
                        if (cCharAt12 < 55296) {
                            break;
                        }
                        i70 |= (cCharAt12 & 8191) << i72;
                        i72 += 13;
                        i71 = i28;
                        length = i16;
                    }
                    iCharAt11 = i70 | (cCharAt12 << i72);
                    i17 = i28;
                } else {
                    i16 = length;
                    i17 = i69;
                }
                int i73 = i17 + 1;
                int iCharAt12 = strZzek.charAt(i17);
                if (iCharAt12 >= 55296) {
                    int i74 = iCharAt12 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i26 = i75 + 1;
                        cCharAt11 = strZzek.charAt(i75);
                        i27 = i74;
                        if (cCharAt11 < 55296) {
                            break;
                        }
                        i74 = i27 | ((cCharAt11 & 8191) << i76);
                        i76 += 13;
                        i75 = i26;
                    }
                    iCharAt12 = i27 | (cCharAt11 << i76);
                    i18 = i26;
                } else {
                    i18 = i73;
                }
                int i77 = i30;
                int i78 = iCharAt12 & 255;
                int i79 = iCharAt2;
                if ((iCharAt12 & 1024) != 0) {
                    iArr[i67] = i68;
                    i67++;
                }
                Object[] objArr2 = objArr;
                if (i78 >= 51) {
                    int i80 = i18 + 1;
                    int iCharAt13 = strZzek.charAt(i18);
                    char c = 55296;
                    if (iCharAt13 >= 55296) {
                        int i81 = iCharAt13 & 8191;
                        int i82 = 13;
                        while (true) {
                            i25 = i80 + 1;
                            cCharAt10 = strZzek.charAt(i80);
                            if (cCharAt10 < c) {
                                break;
                            }
                            i81 |= (cCharAt10 & 8191) << i82;
                            i82 += 13;
                            i80 = i25;
                            c = 55296;
                        }
                        iCharAt13 = i81 | (cCharAt10 << i82);
                        i80 = i25;
                    }
                    int i83 = i78 - 51;
                    int i84 = iCharAt13;
                    if (i83 == 9 || i83 == 17) {
                        objArr2[((i68 / 3) << 1) + 1] = objArrZzel[i3];
                        i3++;
                    } else if (i83 == 12 && (i79 & 1) == 1) {
                        objArr2[((i68 / 3) << 1) + 1] = objArrZzel[i3];
                        i3++;
                    }
                    int i85 = i84 << 1;
                    Object obj = objArrZzel[i85];
                    if (obj instanceof Field) {
                        fieldZza2 = (Field) obj;
                    } else {
                        fieldZza2 = zza(cls2, (String) obj);
                        objArrZzel[i85] = fieldZza2;
                    }
                    int i86 = i80;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza2);
                    int i87 = i85 + 1;
                    Object obj2 = objArrZzel[i87];
                    if (obj2 instanceof Field) {
                        fieldZza3 = (Field) obj2;
                    } else {
                        fieldZza3 = zza(cls2, (String) obj2);
                        objArrZzel[i87] = fieldZza3;
                    }
                    i19 = iCharAt11;
                    i34 = i86;
                    str = strZzek;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    i21 = i3;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i23 = 0;
                    i20 = i5;
                } else {
                    int i88 = i3 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZzel[i3]);
                    if (i78 == 9 || i78 == 17) {
                        i19 = iCharAt11;
                        objArr2[((i68 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i78 == 27 || i78 == 49) {
                            i19 = iCharAt11;
                            i24 = i3 + 2;
                            objArr2[((i68 / 3) << 1) + 1] = objArrZzel[i88];
                        } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                            i19 = iCharAt11;
                            if ((i79 & 1) == 1) {
                                i24 = i3 + 2;
                                objArr2[((i68 / 3) << 1) + 1] = objArrZzel[i88];
                            }
                        } else if (i78 == 50) {
                            int i89 = i66 + 1;
                            iArr[i66] = i68;
                            int i90 = (i68 / 3) << 1;
                            int i91 = i3 + 2;
                            objArr2[i90] = objArrZzel[i88];
                            if ((iCharAt12 & 2048) != 0) {
                                i21 = i3 + 3;
                                objArr2[i90 + 1] = objArrZzel[i91];
                                i19 = iCharAt11;
                                i20 = i5;
                                i66 = i89;
                            } else {
                                i20 = i5;
                                i21 = i91;
                                i66 = i89;
                                i19 = iCharAt11;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                            if ((i79 & 1) != 1 || i78 > 17) {
                                str = strZzek;
                                i22 = i18;
                                iObjectFieldOffset2 = 0;
                                i23 = 0;
                            } else {
                                int i92 = i18 + 1;
                                int iCharAt14 = strZzek.charAt(i18);
                                if (iCharAt14 >= 55296) {
                                    int i93 = iCharAt14 & 8191;
                                    int i94 = 13;
                                    while (true) {
                                        i22 = i92 + 1;
                                        cCharAt9 = strZzek.charAt(i92);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i93 |= (cCharAt9 & 8191) << i94;
                                        i94 += 13;
                                        i92 = i22;
                                    }
                                    iCharAt14 = i93 | (cCharAt9 << i94);
                                } else {
                                    i22 = i92;
                                }
                                int i95 = (i77 << 1) + (iCharAt14 / 32);
                                Object obj3 = objArrZzel[i95];
                                str = strZzek;
                                if (obj3 instanceof Field) {
                                    fieldZza = (Field) obj3;
                                } else {
                                    fieldZza = zza(cls2, (String) obj3);
                                    objArrZzel[i95] = fieldZza;
                                }
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                                i23 = iCharAt14 % 32;
                            }
                            if (i78 >= 18 && i78 <= 49) {
                                iArr[i65] = iObjectFieldOffset;
                                i65++;
                            }
                            i34 = i22;
                        } else {
                            i19 = iCharAt11;
                        }
                        i21 = i24;
                        i20 = i5;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((i79 & 1) != 1) {
                            str = strZzek;
                            i22 = i18;
                            iObjectFieldOffset2 = 0;
                            i23 = 0;
                            if (i78 >= 18) {
                                iArr[i65] = iObjectFieldOffset;
                                i65++;
                            }
                            i34 = i22;
                        }
                    }
                    i20 = i5;
                    i21 = i88;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((i79 & 1) != 1) {
                    }
                }
                int i96 = i68 + 1;
                iArr4[i68] = i19;
                int i97 = i68 + 2;
                int i98 = iObjectFieldOffset2;
                iArr4[i96] = ((iCharAt12 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((iCharAt12 & 512) != 0 ? 536870912 : 0) | (i78 << 20) | iObjectFieldOffset;
                i68 += 3;
                iArr4[i97] = (i23 << 20) | i98;
                i5 = i20;
                i30 = i77;
                iArr3 = iArr4;
                length = i16;
                objArr = objArr2;
                strZzek = str;
                i3 = i21;
                iCharAt2 = i79;
            }
            return new zzlu<>(iArr3, objArr, iCharAt, i5, zzmeVar.zzee(), z, false, iArr, i7, i64, zzlyVar, zzlaVar, zzmxVar, zzjyVar, zzllVar);
        }
        ((zzms) zzloVar).zzec();
        int i99 = zzkk.zze.zzsg;
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

    @Override // com.google.android.gms.internal.drive.zzmf
    public final T newInstance() {
        return (T) this.zzup.newInstance(this.zzuh);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(T t, T t2) {
        int length = this.zzud.length;
        int i = 0;
        while (true) {
            boolean zZzd = true;
            if (i < length) {
                int iZzas = zzas(i);
                long j = iZzas & 1048575;
                switch ((iZzas & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zznd.zzn(t, j)) != Double.doubleToLongBits(zznd.zzn(t2, j))) {
                            zZzd = false;
                            break;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zznd.zzm(t, j)) != Float.floatToIntBits(zznd.zzm(t2, j))) {
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zznd.zzl(t, j) != zznd.zzl(t2, j)) {
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zznd.zzj(t, j) != zznd.zzj(t2, j)) {
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zznd.zzk(t, j) != zznd.zzk(t2, j)) {
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
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
                        zZzd = zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j));
                        break;
                    case 50:
                        zZzd = zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j));
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
                        long jZzat = zzat(i) & 1048575;
                        if (zznd.zzj(t, jZzat) != zznd.zzj(t2, jZzat) || !zzmh.zzd(zznd.zzo(t, j), zznd.zzo(t2, j))) {
                        }
                        break;
                }
                if (!zZzd) {
                    return false;
                }
                i += 3;
            } else {
                if (!this.zzur.zzr(t).equals(this.zzur.zzr(t2))) {
                    return false;
                }
                if (this.zzui) {
                    return this.zzus.zzb(t).equals(this.zzus.zzb(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final int hashCode(T t) {
        int i;
        int iZzu;
        int length = this.zzud.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzas = zzas(i3);
            int i4 = this.zzud[i3];
            long j = 1048575 & iZzas;
            int iHashCode = 37;
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZzu = zzkm.zzu(Double.doubleToLongBits(zznd.zzn(t, j)));
                    i2 = i + iZzu;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzu = Float.floatToIntBits(zznd.zzm(t, j));
                    i2 = i + iZzu;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i2 = i + iZzu;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i2 = i + iZzu;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzu = zznd.zzj(t, j);
                    i2 = i + iZzu;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i2 = i + iZzu;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzu = zznd.zzj(t, j);
                    i2 = i + iZzu;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzu = zzkm.zze(zznd.zzl(t, j));
                    i2 = i + iZzu;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzu = ((String) zznd.zzo(t, j)).hashCode();
                    i2 = i + iZzu;
                    break;
                case 9:
                    Object objZzo = zznd.zzo(t, j);
                    if (objZzo != null) {
                        iHashCode = objZzo.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzu = zznd.zzo(t, j).hashCode();
                    i2 = i + iZzu;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzu = zznd.zzj(t, j);
                    i2 = i + iZzu;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzu = zznd.zzj(t, j);
                    i2 = i + iZzu;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzu = zznd.zzj(t, j);
                    i2 = i + iZzu;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i2 = i + iZzu;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzu = zznd.zzj(t, j);
                    i2 = i + iZzu;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzu = zzkm.zzu(zznd.zzk(t, j));
                    i2 = i + iZzu;
                    break;
                case 17:
                    Object objZzo2 = zznd.zzo(t, j);
                    if (objZzo2 != null) {
                        iHashCode = objZzo2.hashCode();
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
                    iZzu = zznd.zzo(t, j).hashCode();
                    i2 = i + iZzu;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzu = zznd.zzo(t, j).hashCode();
                    i2 = i + iZzu;
                    break;
                case 51:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zzu(Double.doubleToLongBits(zze(t, j)));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = Float.floatToIntBits(zzf(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzg(t, j);
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzg(t, j);
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zze(zzi(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = ((String) zznd.zzo(t, j)).hashCode();
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zznd.zzo(t, j).hashCode();
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zznd.zzo(t, j).hashCode();
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzg(t, j);
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzg(t, j);
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzg(t, j);
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzg(t, j);
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zzkm.zzu(zzh(t, j));
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzlu<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZzu = zznd.zzo(t, j).hashCode();
                        i2 = i + iZzu;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzur.zzr(t).hashCode();
        return this.zzui ? (iHashCode2 * 53) + this.zzus.zzb(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzc(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzud.length; i += 3) {
            int iZzas = zzas(i);
            long j = 1048575 & iZzas;
            int i2 = this.zzud[i];
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza(t, j, zznd.zzn(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzm(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza(t, j, zznd.zzl(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzj(t2, j));
                        zzb((zzlu<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzlu<T>) t2, i)) {
                        zznd.zza((Object) t, j, zznd.zzk(t2, j));
                        zzb((zzlu<T>) t, i);
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
                    this.zzuq.zza(t, t2, j);
                    break;
                case 50:
                    zzmh.zza(this.zzut, t, t2, j);
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
                    if (zza((zzlu<T>) t2, i2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb((zzlu<T>) t, i2, i);
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
                    if (zza((zzlu<T>) t2, i2, i)) {
                        zznd.zza(t, j, zznd.zzo(t2, j));
                        zzb((zzlu<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        if (this.zzuk) {
            return;
        }
        zzmh.zza(this.zzur, t, t2);
        if (this.zzui) {
            zzmh.zza(this.zzus, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzas = zzas(i) & 1048575;
        if (zza((zzlu<T>) t2, i)) {
            Object objZzo = zznd.zzo(t, jZzas);
            Object objZzo2 = zznd.zzo(t2, jZzas);
            if (objZzo != null && objZzo2 != null) {
                zznd.zza(t, jZzas, zzkm.zza(objZzo, objZzo2));
                zzb((zzlu<T>) t, i);
            } else if (objZzo2 != null) {
                zznd.zza(t, jZzas, objZzo2);
                zzb((zzlu<T>) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzas = zzas(i);
        int i2 = this.zzud[i];
        long j = iZzas & 1048575;
        if (zza((zzlu<T>) t2, i2, i)) {
            Object objZzo = zznd.zzo(t, j);
            Object objZzo2 = zznd.zzo(t2, j);
            if (objZzo != null && objZzo2 != null) {
                zznd.zza(t, j, zzkm.zza(objZzo, objZzo2));
                zzb((zzlu<T>) t, i2, i);
            } else if (objZzo2 != null) {
                zznd.zza(t, j, objZzo2);
                zzb((zzlu<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.drive.zzmf
    public final int zzn(T t) {
        int i;
        int i2;
        int iZzd;
        int iZzc;
        int iZzk;
        int iZzi;
        int iZzab;
        int iZzad;
        int iZzb;
        int iZzi2;
        int iZzab2;
        int iZzad2;
        int i3 = 267386880;
        if (this.zzuk) {
            Unsafe unsafe = zzuc;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.zzud.length) {
                int iZzas = zzas(i4);
                int i6 = (iZzas & i3) >>> 20;
                int i7 = this.zzud[i4];
                long j = iZzas & 1048575;
                int i8 = (i6 < zzke.DOUBLE_LIST_PACKED.id() || i6 > zzke.SINT64_LIST_PACKED.id()) ? 0 : this.zzud[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzb(i7, 0.0d);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzb(i7, 0.0f);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzd(i7, zznd.zzk(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zze(i7, zznd.zzk(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzg(i7, zznd.zzj(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzg(i7, 0L);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzj(i7, 0);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzc(i7, true);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzlu<T>) t, i4)) {
                            Object objZzo = zznd.zzo(t, j);
                            if (objZzo instanceof zzjc) {
                                iZzb = zzjr.zzc(i7, (zzjc) objZzo);
                            } else {
                                iZzb = zzjr.zzb(i7, (String) objZzo);
                            }
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzmh.zzc(i7, zznd.zzo(t, j), zzap(i4));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzc(i7, (zzjc) zznd.zzo(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzh(i7, zznd.zzj(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzl(i7, zznd.zzj(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzk(i7, 0);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzh(i7, 0L);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzi(i7, zznd.zzj(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzf(i7, zznd.zzk(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzlu<T>) t, i4)) {
                            iZzb = zzjr.zzc(i7, (zzlq) zznd.zzo(t, j), zzap(i4));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        iZzb = zzmh.zzw(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 19:
                        iZzb = zzmh.zzv(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 20:
                        iZzb = zzmh.zzo(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 21:
                        iZzb = zzmh.zzp(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 22:
                        iZzb = zzmh.zzs(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 23:
                        iZzb = zzmh.zzw(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 24:
                        iZzb = zzmh.zzv(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 25:
                        iZzb = zzmh.zzx(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 26:
                        iZzb = zzmh.zzc(i7, zzd(t, j));
                        i5 += iZzb;
                        break;
                    case 27:
                        iZzb = zzmh.zzc(i7, (List<?>) zzd(t, j), zzap(i4));
                        i5 += iZzb;
                        break;
                    case 28:
                        iZzb = zzmh.zzd(i7, (List<zzjc>) zzd(t, j));
                        i5 += iZzb;
                        break;
                    case 29:
                        iZzb = zzmh.zzt(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 30:
                        iZzb = zzmh.zzr(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 31:
                        iZzb = zzmh.zzv(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 32:
                        iZzb = zzmh.zzw(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 33:
                        iZzb = zzmh.zzu(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 34:
                        iZzb = zzmh.zzq(i7, zzd(t, j), false);
                        i5 += iZzb;
                        break;
                    case 35:
                        iZzi2 = zzmh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 36:
                        iZzi2 = zzmh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 37:
                        iZzi2 = zzmh.zza((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 38:
                        iZzi2 = zzmh.zzb((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 39:
                        iZzi2 = zzmh.zze((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 40:
                        iZzi2 = zzmh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 41:
                        iZzi2 = zzmh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 42:
                        iZzi2 = zzmh.zzj((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 43:
                        iZzi2 = zzmh.zzf((List<Integer>) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 44:
                        iZzi2 = zzmh.zzd((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 45:
                        iZzi2 = zzmh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 46:
                        iZzi2 = zzmh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 47:
                        iZzi2 = zzmh.zzg((List<Integer>) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 48:
                        iZzi2 = zzmh.zzc((List) unsafe.getObject(t, j));
                        if (iZzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzul) {
                                unsafe.putInt(t, i8, iZzi2);
                            }
                            iZzab2 = zzjr.zzab(i7);
                            iZzad2 = zzjr.zzad(iZzi2);
                            iZzb = iZzab2 + iZzad2 + iZzi2;
                            i5 += iZzb;
                            break;
                        }
                    case 49:
                        iZzb = zzmh.zzd(i7, zzd(t, j), zzap(i4));
                        i5 += iZzb;
                        break;
                    case 50:
                        iZzb = this.zzut.zzb(i7, zznd.zzo(t, j), zzaq(i4));
                        i5 += iZzb;
                        break;
                    case 51:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzb(i7, 0.0d);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzb(i7, 0.0f);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzd(i7, zzh(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zze(i7, zzh(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzg(i7, zzg(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzg(i7, 0L);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzj(i7, 0);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzc(i7, true);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            Object objZzo2 = zznd.zzo(t, j);
                            if (objZzo2 instanceof zzjc) {
                                iZzb = zzjr.zzc(i7, (zzjc) objZzo2);
                            } else {
                                iZzb = zzjr.zzb(i7, (String) objZzo2);
                            }
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzmh.zzc(i7, zznd.zzo(t, j), zzap(i4));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzc(i7, (zzjc) zznd.zzo(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzh(i7, zzg(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzl(i7, zzg(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzk(i7, 0);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzh(i7, 0L);
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzi(i7, zzg(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzf(i7, zzh(t, j));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzlu<T>) t, i7, i4)) {
                            iZzb = zzjr.zzc(i7, (zzlq) zznd.zzo(t, j), zzap(i4));
                            i5 += iZzb;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + zza(this.zzur, t);
        }
        Unsafe unsafe2 = zzuc;
        int i9 = -1;
        int iZzb2 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < this.zzud.length; i11 += 3) {
            int iZzas2 = zzas(i11);
            int[] iArr = this.zzud;
            int i12 = iArr[i11];
            int i13 = (iZzas2 & 267386880) >>> 20;
            if (i13 <= 17) {
                i = iArr[i11 + 2];
                int i14 = i & 1048575;
                i2 = 1 << (i >>> 20);
                if (i14 != i9) {
                    i10 = unsafe2.getInt(t, i14);
                    i9 = i14;
                }
            } else {
                i = (!this.zzul || i13 < zzke.DOUBLE_LIST_PACKED.id() || i13 > zzke.SINT64_LIST_PACKED.id()) ? 0 : this.zzud[i11 + 2] & 1048575;
                i2 = 0;
            }
            long j2 = iZzas2 & 1048575;
            switch (i13) {
                case 0:
                    if ((i10 & i2) != 0) {
                        iZzb2 += zzjr.zzb(i12, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i10 & i2) != 0) {
                        iZzb2 += zzjr.zzb(i12, 0.0f);
                    }
                    break;
                case 2:
                    if ((i10 & i2) != 0) {
                        iZzd = zzjr.zzd(i12, unsafe2.getLong(t, j2));
                        iZzb2 += iZzd;
                    }
                    break;
                case 3:
                    if ((i10 & i2) != 0) {
                        iZzd = zzjr.zze(i12, unsafe2.getLong(t, j2));
                        iZzb2 += iZzd;
                    }
                    break;
                case 4:
                    if ((i10 & i2) != 0) {
                        iZzd = zzjr.zzg(i12, unsafe2.getInt(t, j2));
                        iZzb2 += iZzd;
                    }
                    break;
                case 5:
                    if ((i10 & i2) != 0) {
                        iZzd = zzjr.zzg(i12, 0L);
                        iZzb2 += iZzd;
                    }
                    break;
                case 6:
                    if ((i10 & i2) != 0) {
                        iZzd = zzjr.zzj(i12, 0);
                        iZzb2 += iZzd;
                        break;
                    }
                case 7:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzc(i12, true);
                        iZzb2 += iZzc;
                    }
                    break;
                case 8:
                    if ((i10 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzjc) {
                            iZzc = zzjr.zzc(i12, (zzjc) object);
                        } else {
                            iZzc = zzjr.zzb(i12, (String) object);
                        }
                        iZzb2 += iZzc;
                    }
                    break;
                case 9:
                    if ((i10 & i2) != 0) {
                        iZzc = zzmh.zzc(i12, unsafe2.getObject(t, j2), zzap(i11));
                        iZzb2 += iZzc;
                    }
                    break;
                case 10:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzc(i12, (zzjc) unsafe2.getObject(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 11:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzh(i12, unsafe2.getInt(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 12:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzl(i12, unsafe2.getInt(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 13:
                    if ((i10 & i2) != 0) {
                        iZzk = zzjr.zzk(i12, 0);
                        iZzb2 += iZzk;
                    }
                    break;
                case 14:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzh(i12, 0L);
                        iZzb2 += iZzc;
                    }
                    break;
                case 15:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzi(i12, unsafe2.getInt(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 16:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzf(i12, unsafe2.getLong(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 17:
                    if ((i10 & i2) != 0) {
                        iZzc = zzjr.zzc(i12, (zzlq) unsafe2.getObject(t, j2), zzap(i11));
                        iZzb2 += iZzc;
                    }
                    break;
                case 18:
                    iZzc = zzmh.zzw(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 19:
                    iZzc = zzmh.zzv(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 20:
                    iZzc = zzmh.zzo(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 21:
                    iZzc = zzmh.zzp(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 22:
                    iZzc = zzmh.zzs(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 23:
                    iZzc = zzmh.zzw(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 24:
                    iZzc = zzmh.zzv(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 25:
                    iZzc = zzmh.zzx(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 26:
                    iZzc = zzmh.zzc(i12, (List) unsafe2.getObject(t, j2));
                    iZzb2 += iZzc;
                    break;
                case 27:
                    iZzc = zzmh.zzc(i12, (List<?>) unsafe2.getObject(t, j2), zzap(i11));
                    iZzb2 += iZzc;
                    break;
                case 28:
                    iZzc = zzmh.zzd(i12, (List<zzjc>) unsafe2.getObject(t, j2));
                    iZzb2 += iZzc;
                    break;
                case 29:
                    iZzc = zzmh.zzt(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 30:
                    iZzc = zzmh.zzr(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 31:
                    iZzc = zzmh.zzv(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 32:
                    iZzc = zzmh.zzw(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 33:
                    iZzc = zzmh.zzu(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 34:
                    iZzc = zzmh.zzq(i12, (List) unsafe2.getObject(t, j2), false);
                    iZzb2 += iZzc;
                    break;
                case 35:
                    iZzi = zzmh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 36:
                    iZzi = zzmh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 37:
                    iZzi = zzmh.zza((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 38:
                    iZzi = zzmh.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 39:
                    iZzi = zzmh.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 40:
                    iZzi = zzmh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 41:
                    iZzi = zzmh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 42:
                    iZzi = zzmh.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 43:
                    iZzi = zzmh.zzf((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 44:
                    iZzi = zzmh.zzd((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 45:
                    iZzi = zzmh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 46:
                    iZzi = zzmh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 47:
                    iZzi = zzmh.zzg((List<Integer>) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 48:
                    iZzi = zzmh.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzul) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZzab = zzjr.zzab(i12);
                        iZzad = zzjr.zzad(iZzi);
                        iZzc = iZzab + iZzad + iZzi;
                        iZzb2 += iZzc;
                    }
                    break;
                case 49:
                    iZzc = zzmh.zzd(i12, (List) unsafe2.getObject(t, j2), zzap(i11));
                    iZzb2 += iZzc;
                    break;
                case 50:
                    iZzc = this.zzut.zzb(i12, unsafe2.getObject(t, j2), zzaq(i11));
                    iZzb2 += iZzc;
                    break;
                case 51:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzb(i12, 0.0d);
                        iZzb2 += iZzc;
                    }
                    break;
                case 52:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzk = zzjr.zzb(i12, 0.0f);
                        iZzb2 += iZzk;
                    }
                    break;
                case 53:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzd(i12, zzh(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 54:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zze(i12, zzh(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 55:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzg(i12, zzg(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 56:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzg(i12, 0L);
                        iZzb2 += iZzc;
                    }
                    break;
                case 57:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzk = zzjr.zzj(i12, 0);
                        iZzb2 += iZzk;
                    }
                    break;
                case 58:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzc(i12, true);
                        iZzb2 += iZzc;
                    }
                    break;
                case 59:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzjc) {
                            iZzc = zzjr.zzc(i12, (zzjc) object2);
                        } else {
                            iZzc = zzjr.zzb(i12, (String) object2);
                        }
                        iZzb2 += iZzc;
                    }
                    break;
                case 60:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzmh.zzc(i12, unsafe2.getObject(t, j2), zzap(i11));
                        iZzb2 += iZzc;
                    }
                    break;
                case 61:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzc(i12, (zzjc) unsafe2.getObject(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 62:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzh(i12, zzg(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 63:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzl(i12, zzg(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 64:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzk = zzjr.zzk(i12, 0);
                        iZzb2 += iZzk;
                    }
                    break;
                case 65:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzh(i12, 0L);
                        iZzb2 += iZzc;
                    }
                    break;
                case 66:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzi(i12, zzg(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 67:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzf(i12, zzh(t, j2));
                        iZzb2 += iZzc;
                    }
                    break;
                case 68:
                    if (zza((zzlu<T>) t, i12, i11)) {
                        iZzc = zzjr.zzc(i12, (zzlq) unsafe2.getObject(t, j2), zzap(i11));
                        iZzb2 += iZzc;
                    }
                    break;
            }
        }
        int iZzb3 = 0;
        int iZza = iZzb2 + zza(this.zzur, t);
        if (!this.zzui) {
            return iZza;
        }
        zzkb<T> zzkbVarZzb = this.zzus.zzb(t);
        for (int i15 = 0; i15 < zzkbVarZzb.zzos.zzer(); i15++) {
            Map.Entry entryZzaw = zzkbVarZzb.zzos.zzaw(i15);
            iZzb3 += zzkb.zzb((zzkd<?>) entryZzaw.getKey(), entryZzaw.getValue());
        }
        for (Map.Entry entry : zzkbVarZzb.zzos.zzes()) {
            iZzb3 += zzkb.zzb((zzkd<?>) entry.getKey(), entry.getValue());
        }
        return iZza + iZzb3;
    }

    private static <UT, UB> int zza(zzmx<UT, UB> zzmxVar, T t) {
        return zzmxVar.zzn(zzmxVar.zzr(t));
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zznd.zzo(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzns zznsVar) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry2;
        if (zznsVar.zzcd() == zzkk.zze.zzsj) {
            zza(this.zzur, t, zznsVar);
            if (this.zzui) {
                zzkb<T> zzkbVarZzb = this.zzus.zzb(t);
                if (zzkbVarZzb.zzos.isEmpty()) {
                    itDescendingIterator = null;
                    entry2 = null;
                } else {
                    itDescendingIterator = zzkbVarZzb.descendingIterator();
                    entry2 = (Map.Entry) itDescendingIterator.next();
                }
            }
            for (int length = this.zzud.length - 3; length >= 0; length -= 3) {
                int iZzas = zzas(length);
                int i = this.zzud[length];
                while (entry2 != null && this.zzus.zza(entry2) > i) {
                    this.zzus.zza(zznsVar, entry2);
                    entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
                }
                switch ((iZzas & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zza(i, zznd.zzn(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zza(i, zznd.zzm(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzi(i, zznd.zzk(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zza(i, zznd.zzk(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzc(i, zznd.zzj(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzc(i, zznd.zzk(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzf(i, zznd.zzj(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzb(i, zznd.zzl(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzlu<T>) t, length)) {
                            zza(i, zznd.zzo(t, iZzas & 1048575), zznsVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zza(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zza(i, (zzjc) zznd.zzo(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzd(i, zznd.zzj(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzn(i, zznd.zzj(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzm(i, zznd.zzj(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzj(i, zznd.zzk(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zze(i, zznd.zzj(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzb(i, zznd.zzk(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzlu<T>) t, length)) {
                            zznsVar.zzb(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzmh.zza(this.zzud[length], (List<Double>) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 19:
                        zzmh.zzb(this.zzud[length], (List<Float>) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 20:
                        zzmh.zzc(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 21:
                        zzmh.zzd(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 22:
                        zzmh.zzh(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 23:
                        zzmh.zzf(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 24:
                        zzmh.zzk(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 25:
                        zzmh.zzn(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 26:
                        zzmh.zza(this.zzud[length], (List<String>) zznd.zzo(t, iZzas & 1048575), zznsVar);
                        break;
                    case 27:
                        zzmh.zza(this.zzud[length], (List<?>) zznd.zzo(t, iZzas & 1048575), zznsVar, zzap(length));
                        break;
                    case 28:
                        zzmh.zzb(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar);
                        break;
                    case 29:
                        zzmh.zzi(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 30:
                        zzmh.zzm(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 31:
                        zzmh.zzl(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 32:
                        zzmh.zzg(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 33:
                        zzmh.zzj(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 34:
                        zzmh.zze(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, false);
                        break;
                    case 35:
                        zzmh.zza(this.zzud[length], (List<Double>) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 36:
                        zzmh.zzb(this.zzud[length], (List<Float>) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 37:
                        zzmh.zzc(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 38:
                        zzmh.zzd(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 39:
                        zzmh.zzh(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 40:
                        zzmh.zzf(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 41:
                        zzmh.zzk(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 42:
                        zzmh.zzn(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 43:
                        zzmh.zzi(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 44:
                        zzmh.zzm(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 45:
                        zzmh.zzl(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 46:
                        zzmh.zzg(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 47:
                        zzmh.zzj(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 48:
                        zzmh.zze(this.zzud[length], (List) zznd.zzo(t, iZzas & 1048575), zznsVar, true);
                        break;
                    case 49:
                        zzmh.zzb(this.zzud[length], (List<?>) zznd.zzo(t, iZzas & 1048575), zznsVar, zzap(length));
                        break;
                    case 50:
                        zza(zznsVar, i, zznd.zzo(t, iZzas & 1048575), length);
                        break;
                    case 51:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zza(i, zze(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zza(i, zzf(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzi(i, zzh(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zza(i, zzh(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzc(i, zzg(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzc(i, zzh(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzf(i, zzg(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzb(i, zzi(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzlu<T>) t, i, length)) {
                            zza(i, zznd.zzo(t, iZzas & 1048575), zznsVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zza(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zza(i, (zzjc) zznd.zzo(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzd(i, zzg(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzn(i, zzg(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzm(i, zzg(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzj(i, zzh(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zze(i, zzg(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzb(i, zzh(t, iZzas & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzlu<T>) t, i, length)) {
                            zznsVar.zzb(i, zznd.zzo(t, iZzas & 1048575), zzap(length));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry2 != null) {
                this.zzus.zza(zznsVar, entry2);
                entry2 = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            return;
        }
        if (this.zzuk) {
            if (this.zzui) {
                zzkb<T> zzkbVarZzb2 = this.zzus.zzb(t);
                if (zzkbVarZzb2.zzos.isEmpty()) {
                    it = null;
                    entry = null;
                } else {
                    it = zzkbVarZzb2.iterator();
                    entry = (Map.Entry) it.next();
                }
            }
            int length2 = this.zzud.length;
            for (int i2 = 0; i2 < length2; i2 += 3) {
                int iZzas2 = zzas(i2);
                int i3 = this.zzud[i2];
                while (entry != null && this.zzus.zza(entry) <= i3) {
                    this.zzus.zza(zznsVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                switch ((iZzas2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zza(i3, zznd.zzn(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zza(i3, zznd.zzm(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzi(i3, zznd.zzk(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zza(i3, zznd.zzk(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzc(i3, zznd.zzj(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzc(i3, zznd.zzk(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzf(i3, zznd.zzj(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzb(i3, zznd.zzl(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzlu<T>) t, i2)) {
                            zza(i3, zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zza(i3, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zza(i3, (zzjc) zznd.zzo(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzd(i3, zznd.zzj(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzn(i3, zznd.zzj(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzm(i3, zznd.zzj(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzj(i3, zznd.zzk(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zze(i3, zznd.zzj(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzb(i3, zznd.zzk(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzlu<T>) t, i2)) {
                            zznsVar.zzb(i3, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzmh.zza(this.zzud[i2], (List<Double>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 19:
                        zzmh.zzb(this.zzud[i2], (List<Float>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 20:
                        zzmh.zzc(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 21:
                        zzmh.zzd(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 22:
                        zzmh.zzh(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 23:
                        zzmh.zzf(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 24:
                        zzmh.zzk(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 25:
                        zzmh.zzn(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 26:
                        zzmh.zza(this.zzud[i2], (List<String>) zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                        break;
                    case 27:
                        zzmh.zza(this.zzud[i2], (List<?>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, zzap(i2));
                        break;
                    case 28:
                        zzmh.zzb(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                        break;
                    case 29:
                        zzmh.zzi(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 30:
                        zzmh.zzm(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 31:
                        zzmh.zzl(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 32:
                        zzmh.zzg(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 33:
                        zzmh.zzj(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 34:
                        zzmh.zze(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, false);
                        break;
                    case 35:
                        zzmh.zza(this.zzud[i2], (List<Double>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 36:
                        zzmh.zzb(this.zzud[i2], (List<Float>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 37:
                        zzmh.zzc(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 38:
                        zzmh.zzd(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 39:
                        zzmh.zzh(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 40:
                        zzmh.zzf(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 41:
                        zzmh.zzk(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 42:
                        zzmh.zzn(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 43:
                        zzmh.zzi(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 44:
                        zzmh.zzm(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 45:
                        zzmh.zzl(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 46:
                        zzmh.zzg(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 47:
                        zzmh.zzj(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 48:
                        zzmh.zze(this.zzud[i2], (List) zznd.zzo(t, iZzas2 & 1048575), zznsVar, true);
                        break;
                    case 49:
                        zzmh.zzb(this.zzud[i2], (List<?>) zznd.zzo(t, iZzas2 & 1048575), zznsVar, zzap(i2));
                        break;
                    case 50:
                        zza(zznsVar, i3, zznd.zzo(t, iZzas2 & 1048575), i2);
                        break;
                    case 51:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zza(i3, zze(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zza(i3, zzf(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzi(i3, zzh(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zza(i3, zzh(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzc(i3, zzg(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzc(i3, zzh(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzf(i3, zzg(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzb(i3, zzi(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zza(i3, zznd.zzo(t, iZzas2 & 1048575), zznsVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zza(i3, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zza(i3, (zzjc) zznd.zzo(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzd(i3, zzg(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzn(i3, zzg(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzm(i3, zzg(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzj(i3, zzh(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zze(i3, zzg(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzb(i3, zzh(t, iZzas2 & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza((zzlu<T>) t, i3, i2)) {
                            zznsVar.zzb(i3, zznd.zzo(t, iZzas2 & 1048575), zzap(i2));
                            break;
                        } else {
                            break;
                        }
                }
            }
            while (entry != null) {
                this.zzus.zza(zznsVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            zza(this.zzur, t, zznsVar);
            return;
        }
        zzb((zzlu<T>) t, zznsVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzns zznsVar) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.zzui) {
            zzkb<T> zzkbVarZzb = this.zzus.zzb(t);
            if (zzkbVarZzb.zzos.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = zzkbVarZzb.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.zzud.length;
        Unsafe unsafe = zzuc;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzas = zzas(i4);
            int[] iArr = this.zzud;
            int i5 = iArr[i4];
            int i6 = (267386880 & iZzas) >>> 20;
            if (this.zzuk || i6 > 17) {
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
            while (entry != null && this.zzus.zza(entry) <= i5) {
                this.zzus.zza(zznsVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzas & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        zznsVar.zza(i5, zznd.zzn(t, j));
                        continue;
                    }
                case 1:
                    if ((i & i3) != 0) {
                        zznsVar.zza(i5, zznd.zzm(t, j));
                    } else {
                        continue;
                    }
                case 2:
                    if ((i & i3) != 0) {
                        zznsVar.zzi(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 3:
                    if ((i & i3) != 0) {
                        zznsVar.zza(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 4:
                    if ((i & i3) != 0) {
                        zznsVar.zzc(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 5:
                    if ((i & i3) != 0) {
                        zznsVar.zzc(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 6:
                    if ((i & i3) != 0) {
                        zznsVar.zzf(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 7:
                    if ((i & i3) != 0) {
                        zznsVar.zzb(i5, zznd.zzl(t, j));
                    } else {
                        continue;
                    }
                case 8:
                    if ((i & i3) != 0) {
                        zza(i5, unsafe.getObject(t, j), zznsVar);
                    } else {
                        continue;
                    }
                case 9:
                    if ((i & i3) != 0) {
                        zznsVar.zza(i5, unsafe.getObject(t, j), zzap(i4));
                    } else {
                        continue;
                    }
                case 10:
                    if ((i & i3) != 0) {
                        zznsVar.zza(i5, (zzjc) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                case 11:
                    if ((i & i3) != 0) {
                        zznsVar.zzd(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 12:
                    if ((i & i3) != 0) {
                        zznsVar.zzn(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 13:
                    if ((i & i3) != 0) {
                        zznsVar.zzm(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 14:
                    if ((i & i3) != 0) {
                        zznsVar.zzj(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 15:
                    if ((i & i3) != 0) {
                        zznsVar.zze(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 16:
                    if ((i & i3) != 0) {
                        zznsVar.zzb(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 17:
                    if ((i & i3) != 0) {
                        zznsVar.zzb(i5, unsafe.getObject(t, j), zzap(i4));
                    } else {
                        continue;
                    }
                case 18:
                    zzmh.zza(this.zzud[i4], (List<Double>) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 19:
                    zzmh.zzb(this.zzud[i4], (List<Float>) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 20:
                    zzmh.zzc(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 21:
                    zzmh.zzd(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 22:
                    zzmh.zzh(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 23:
                    zzmh.zzf(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 24:
                    zzmh.zzk(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 25:
                    zzmh.zzn(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    continue;
                case 26:
                    zzmh.zza(this.zzud[i4], (List<String>) unsafe.getObject(t, j), zznsVar);
                    break;
                case 27:
                    zzmh.zza(this.zzud[i4], (List<?>) unsafe.getObject(t, j), zznsVar, zzap(i4));
                    break;
                case 28:
                    zzmh.zzb(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar);
                    break;
                case 29:
                    zzmh.zzi(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 30:
                    zzmh.zzm(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 31:
                    zzmh.zzl(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 32:
                    zzmh.zzg(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 33:
                    zzmh.zzj(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 34:
                    zzmh.zze(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, false);
                    break;
                case 35:
                    zzmh.zza(this.zzud[i4], (List<Double>) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 36:
                    zzmh.zzb(this.zzud[i4], (List<Float>) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 37:
                    zzmh.zzc(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 38:
                    zzmh.zzd(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 39:
                    zzmh.zzh(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 40:
                    zzmh.zzf(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 41:
                    zzmh.zzk(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 42:
                    zzmh.zzn(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 43:
                    zzmh.zzi(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 44:
                    zzmh.zzm(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 45:
                    zzmh.zzl(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 46:
                    zzmh.zzg(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 47:
                    zzmh.zzj(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 48:
                    zzmh.zze(this.zzud[i4], (List) unsafe.getObject(t, j), zznsVar, true);
                    break;
                case 49:
                    zzmh.zzb(this.zzud[i4], (List<?>) unsafe.getObject(t, j), zznsVar, zzap(i4));
                    break;
                case 50:
                    zza(zznsVar, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zza(i5, zze(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zza(i5, zzf(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzi(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zza(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzc(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzc(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzf(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzb(i5, zzi(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zza(i5, unsafe.getObject(t, j), zznsVar);
                        break;
                    }
                    break;
                case 60:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zza(i5, unsafe.getObject(t, j), zzap(i4));
                        break;
                    }
                    break;
                case 61:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zza(i5, (zzjc) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzd(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzn(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzm(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzj(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zze(i5, zzg(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzb(i5, zzh(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zza((zzlu<T>) t, i5, i4)) {
                        zznsVar.zzb(i5, unsafe.getObject(t, j), zzap(i4));
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.zzus.zza(zznsVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zza(this.zzur, t, zznsVar);
    }

    private final <K, V> void zza(zzns zznsVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznsVar.zza(i, this.zzut.zzm(zzaq(i2)), this.zzut.zzi(obj));
        }
    }

    private static <UT, UB> void zza(zzmx<UT, UB> zzmxVar, T t, zzns zznsVar) throws IOException {
        zzmxVar.zza(zzmxVar.zzr(t), zznsVar);
    }

    private static zzmy zzo(Object obj) {
        zzkk zzkkVar = (zzkk) obj;
        zzmy zzmyVar = zzkkVar.zzrq;
        if (zzmyVar != zzmy.zzfa()) {
            return zzmyVar;
        }
        zzmy zzmyVarZzfb = zzmy.zzfb();
        zzkkVar.zzrq = zzmyVarZzfb;
        return zzmyVarZzfb;
    }

    private static int zza(byte[] bArr, int i, int i2, zznm zznmVar, Class<?> cls, zziz zzizVar) throws IOException {
        switch (zzlv.zzox[zznmVar.ordinal()]) {
            case 1:
                int iZzb = zziy.zzb(bArr, i, zzizVar);
                zzizVar.zznm = Boolean.valueOf(zzizVar.zznl != 0);
                return iZzb;
            case 2:
                return zziy.zze(bArr, i, zzizVar);
            case 3:
                zzizVar.zznm = Double.valueOf(zziy.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzizVar.zznm = Integer.valueOf(zziy.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzizVar.zznm = Long.valueOf(zziy.zzb(bArr, i));
                return i + 8;
            case 8:
                zzizVar.zznm = Float.valueOf(zziy.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zziy.zza(bArr, i, zzizVar);
                zzizVar.zznm = Integer.valueOf(zzizVar.zznk);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zziy.zzb(bArr, i, zzizVar);
                zzizVar.zznm = Long.valueOf(zzizVar.zznl);
                return iZzb2;
            case 14:
                return zziy.zza(zzmd.zzej().zzf(cls), bArr, i, i2, zzizVar);
            case 15:
                int iZza2 = zziy.zza(bArr, i, zzizVar);
                zzizVar.zznm = Integer.valueOf(zzjo.zzw(zzizVar.zznk));
                return iZza2;
            case 16:
                int iZzb3 = zziy.zzb(bArr, i, zzizVar);
                zzizVar.zznm = Long.valueOf(zzjo.zzk(zzizVar.zznl));
                return iZzb3;
            case 17:
                return zziy.zzd(bArr, i, zzizVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zziz zzizVar) throws IOException {
        int i8;
        int i9;
        int iZza;
        Unsafe unsafe = zzuc;
        zzkp zzkpVarZzr = (zzkp) unsafe.getObject(t, j2);
        if (!zzkpVarZzr.zzbo()) {
            int size = zzkpVarZzr.size();
            zzkpVarZzr = zzkpVarZzr.zzr(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzkpVarZzr);
        }
        zzkp zzkpVar = zzkpVarZzr;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzju zzjuVar = (zzju) zzkpVar;
                    int iZza2 = zziy.zza(bArr, i, zzizVar);
                    int i10 = zzizVar.zznk + iZza2;
                    while (iZza2 < i10) {
                        zzjuVar.zzc(zziy.zzc(bArr, iZza2));
                        iZza2 += 8;
                    }
                    if (iZza2 == i10) {
                        return iZza2;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 != 1) {
                    return i;
                }
                zzju zzjuVar2 = (zzju) zzkpVar;
                zzjuVar2.zzc(zziy.zzc(bArr, i));
                int i11 = i + 8;
                while (i11 < i2) {
                    int iZza3 = zziy.zza(bArr, i11, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return i11;
                    }
                    zzjuVar2.zzc(zziy.zzc(bArr, iZza3));
                    i11 = iZza3 + 8;
                }
                return i11;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzkh zzkhVar = (zzkh) zzkpVar;
                    int iZza4 = zziy.zza(bArr, i, zzizVar);
                    int i12 = zzizVar.zznk + iZza4;
                    while (iZza4 < i12) {
                        zzkhVar.zzc(zziy.zzd(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 == i12) {
                        return iZza4;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 != 5) {
                    return i;
                }
                zzkh zzkhVar2 = (zzkh) zzkpVar;
                zzkhVar2.zzc(zziy.zzd(bArr, i));
                int i13 = i + 4;
                while (i13 < i2) {
                    int iZza5 = zziy.zza(bArr, i13, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return i13;
                    }
                    zzkhVar2.zzc(zziy.zzd(bArr, iZza5));
                    i13 = iZza5 + 4;
                }
                return i13;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzle zzleVar = (zzle) zzkpVar;
                    int iZza6 = zziy.zza(bArr, i, zzizVar);
                    int i14 = zzizVar.zznk + iZza6;
                    while (iZza6 < i14) {
                        iZza6 = zziy.zzb(bArr, iZza6, zzizVar);
                        zzleVar.zzv(zzizVar.zznl);
                    }
                    if (iZza6 == i14) {
                        return iZza6;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 != 0) {
                    return i;
                }
                zzle zzleVar2 = (zzle) zzkpVar;
                int iZzb = zziy.zzb(bArr, i, zzizVar);
                zzleVar2.zzv(zzizVar.zznl);
                while (iZzb < i2) {
                    int iZza7 = zziy.zza(bArr, iZzb, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return iZzb;
                    }
                    iZzb = zziy.zzb(bArr, iZza7, zzizVar);
                    zzleVar2.zzv(zzizVar.zznl);
                }
                return iZzb;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zziy.zza(bArr, i, (zzkp<?>) zzkpVar, zzizVar);
                }
                return i5 == 0 ? zziy.zza(i3, bArr, i, i2, (zzkp<?>) zzkpVar, zzizVar) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzle zzleVar3 = (zzle) zzkpVar;
                    int iZza8 = zziy.zza(bArr, i, zzizVar);
                    int i15 = zzizVar.zznk + iZza8;
                    while (iZza8 < i15) {
                        zzleVar3.zzv(zziy.zzb(bArr, iZza8));
                        iZza8 += 8;
                    }
                    if (iZza8 == i15) {
                        return iZza8;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 != 1) {
                    return i;
                }
                zzle zzleVar4 = (zzle) zzkpVar;
                zzleVar4.zzv(zziy.zzb(bArr, i));
                int i16 = i + 8;
                while (i16 < i2) {
                    int iZza9 = zziy.zza(bArr, i16, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return i16;
                    }
                    zzleVar4.zzv(zziy.zzb(bArr, iZza9));
                    i16 = iZza9 + 8;
                }
                return i16;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzkl zzklVar = (zzkl) zzkpVar;
                    int iZza10 = zziy.zza(bArr, i, zzizVar);
                    int i17 = zzizVar.zznk + iZza10;
                    while (iZza10 < i17) {
                        zzklVar.zzam(zziy.zza(bArr, iZza10));
                        iZza10 += 4;
                    }
                    if (iZza10 == i17) {
                        return iZza10;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 != 5) {
                    return i;
                }
                zzkl zzklVar2 = (zzkl) zzkpVar;
                zzklVar2.zzam(zziy.zza(bArr, i));
                int i18 = i + 4;
                while (i18 < i2) {
                    int iZza11 = zziy.zza(bArr, i18, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return i18;
                    }
                    zzklVar2.zzam(zziy.zza(bArr, iZza11));
                    i18 = iZza11 + 4;
                }
                return i18;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzja zzjaVar = (zzja) zzkpVar;
                    int iZza12 = zziy.zza(bArr, i, zzizVar);
                    int i19 = zzizVar.zznk + iZza12;
                    while (iZza12 < i19) {
                        iZza12 = zziy.zzb(bArr, iZza12, zzizVar);
                        zzjaVar.addBoolean(zzizVar.zznl != 0);
                    }
                    if (iZza12 == i19) {
                        return iZza12;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 != 0) {
                    return i;
                }
                zzja zzjaVar2 = (zzja) zzkpVar;
                int iZzb2 = zziy.zzb(bArr, i, zzizVar);
                zzjaVar2.addBoolean(zzizVar.zznl != 0);
                while (iZzb2 < i2) {
                    int iZza13 = zziy.zza(bArr, iZzb2, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return iZzb2;
                    }
                    iZzb2 = zziy.zzb(bArr, iZza13, zzizVar);
                    zzjaVar2.addBoolean(zzizVar.zznl != 0);
                }
                return iZzb2;
            case 26:
                if (i5 != 2) {
                    return i;
                }
                if ((j & 536870912) == 0) {
                    int iZza14 = zziy.zza(bArr, i, zzizVar);
                    int i20 = zzizVar.zznk;
                    if (i20 < 0) {
                        throw zzkq.zzdj();
                    }
                    if (i20 == 0) {
                        zzkpVar.add("");
                    } else {
                        zzkpVar.add(new String(bArr, iZza14, i20, zzkm.UTF_8));
                        iZza14 += i20;
                    }
                    while (iZza14 < i2) {
                        int iZza15 = zziy.zza(bArr, iZza14, zzizVar);
                        if (i3 != zzizVar.zznk) {
                            return iZza14;
                        }
                        iZza14 = zziy.zza(bArr, iZza15, zzizVar);
                        int i21 = zzizVar.zznk;
                        if (i21 < 0) {
                            throw zzkq.zzdj();
                        }
                        if (i21 == 0) {
                            zzkpVar.add("");
                        } else {
                            zzkpVar.add(new String(bArr, iZza14, i21, zzkm.UTF_8));
                            iZza14 += i21;
                        }
                    }
                    return iZza14;
                }
                int iZza16 = zziy.zza(bArr, i, zzizVar);
                int i22 = zzizVar.zznk;
                if (i22 < 0) {
                    throw zzkq.zzdj();
                }
                if (i22 == 0) {
                    zzkpVar.add("");
                } else {
                    int i23 = iZza16 + i22;
                    if (!zznf.zze(bArr, iZza16, i23)) {
                        throw zzkq.zzdn();
                    }
                    zzkpVar.add(new String(bArr, iZza16, i22, zzkm.UTF_8));
                    iZza16 = i23;
                }
                while (iZza16 < i2) {
                    int iZza17 = zziy.zza(bArr, iZza16, zzizVar);
                    if (i3 != zzizVar.zznk) {
                        return iZza16;
                    }
                    iZza16 = zziy.zza(bArr, iZza17, zzizVar);
                    int i24 = zzizVar.zznk;
                    if (i24 < 0) {
                        throw zzkq.zzdj();
                    }
                    if (i24 == 0) {
                        zzkpVar.add("");
                    } else {
                        int i25 = iZza16 + i24;
                        if (!zznf.zze(bArr, iZza16, i25)) {
                            throw zzkq.zzdn();
                        }
                        zzkpVar.add(new String(bArr, iZza16, i24, zzkm.UTF_8));
                        iZza16 = i25;
                    }
                }
                return iZza16;
            case 27:
                i8 = i;
                if (i5 == 2) {
                    return zziy.zza(zzap(i6), i3, bArr, i8, i2, zzkpVar, zzizVar);
                }
                return i8;
            case 28:
                i8 = i;
                if (i5 == 2) {
                    int iZza18 = zziy.zza(bArr, i8, zzizVar);
                    int i26 = zzizVar.zznk;
                    if (i26 < 0) {
                        throw zzkq.zzdj();
                    }
                    if (i26 > bArr.length - iZza18) {
                        throw zzkq.zzdi();
                    }
                    if (i26 == 0) {
                        zzkpVar.add(zzjc.zznq);
                    } else {
                        zzkpVar.add(zzjc.zzb(bArr, iZza18, i26));
                        iZza18 += i26;
                    }
                    while (iZza18 < i2) {
                        int iZza19 = zziy.zza(bArr, iZza18, zzizVar);
                        if (i3 != zzizVar.zznk) {
                            return iZza18;
                        }
                        iZza18 = zziy.zza(bArr, iZza19, zzizVar);
                        int i27 = zzizVar.zznk;
                        if (i27 < 0) {
                            throw zzkq.zzdj();
                        }
                        if (i27 > bArr.length - iZza18) {
                            throw zzkq.zzdi();
                        }
                        if (i27 == 0) {
                            zzkpVar.add(zzjc.zznq);
                        } else {
                            zzkpVar.add(zzjc.zzb(bArr, iZza18, i27));
                            iZza18 += i27;
                        }
                    }
                    return iZza18;
                }
                return i8;
            case 30:
            case 44:
                i9 = i;
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zziy.zza(i3, bArr, i9, i2, (zzkp<?>) zzkpVar, zzizVar);
                    }
                    return i9;
                }
                iZza = zziy.zza(bArr, i9, (zzkp<?>) zzkpVar, zzizVar);
                zzkk zzkkVar = (zzkk) t;
                zzmy zzmyVar = zzkkVar.zzrq;
                if (zzmyVar == zzmy.zzfa()) {
                    zzmyVar = null;
                }
                zzmy zzmyVar2 = (zzmy) zzmh.zza(i4, zzkpVar, zzar(i6), zzmyVar, this.zzur);
                if (zzmyVar2 != null) {
                    zzkkVar.zzrq = zzmyVar2;
                }
                return iZza;
            case 33:
            case 47:
                i9 = i;
                if (i5 == 2) {
                    zzkl zzklVar3 = (zzkl) zzkpVar;
                    int iZza20 = zziy.zza(bArr, i9, zzizVar);
                    int i28 = zzizVar.zznk + iZza20;
                    while (iZza20 < i28) {
                        iZza20 = zziy.zza(bArr, iZza20, zzizVar);
                        zzklVar3.zzam(zzjo.zzw(zzizVar.zznk));
                    }
                    if (iZza20 == i28) {
                        return iZza20;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 == 0) {
                    zzkl zzklVar4 = (zzkl) zzkpVar;
                    int iZza21 = zziy.zza(bArr, i9, zzizVar);
                    zzklVar4.zzam(zzjo.zzw(zzizVar.zznk));
                    while (iZza21 < i2) {
                        int iZza22 = zziy.zza(bArr, iZza21, zzizVar);
                        if (i3 != zzizVar.zznk) {
                            return iZza21;
                        }
                        iZza21 = zziy.zza(bArr, iZza22, zzizVar);
                        zzklVar4.zzam(zzjo.zzw(zzizVar.zznk));
                    }
                    return iZza21;
                }
                return i9;
            case 34:
            case 48:
                i9 = i;
                if (i5 == 2) {
                    zzle zzleVar5 = (zzle) zzkpVar;
                    int iZza23 = zziy.zza(bArr, i9, zzizVar);
                    int i29 = zzizVar.zznk + iZza23;
                    while (iZza23 < i29) {
                        iZza23 = zziy.zzb(bArr, iZza23, zzizVar);
                        zzleVar5.zzv(zzjo.zzk(zzizVar.zznl));
                    }
                    if (iZza23 == i29) {
                        return iZza23;
                    }
                    throw zzkq.zzdi();
                }
                if (i5 == 0) {
                    zzle zzleVar6 = (zzle) zzkpVar;
                    int iZzb3 = zziy.zzb(bArr, i9, zzizVar);
                    zzleVar6.zzv(zzjo.zzk(zzizVar.zznl));
                    while (iZzb3 < i2) {
                        int iZza24 = zziy.zza(bArr, iZzb3, zzizVar);
                        if (i3 != zzizVar.zznk) {
                            return iZzb3;
                        }
                        iZzb3 = zziy.zzb(bArr, iZza24, zzizVar);
                        zzleVar6.zzv(zzjo.zzk(zzizVar.zznl));
                    }
                    return iZzb3;
                }
                return i9;
            case 49:
                if (i5 == 3) {
                    zzmf zzmfVarZzap = zzap(i6);
                    int i30 = (i3 & (-8)) | 4;
                    int iZza25 = zziy.zza(zzmfVarZzap, bArr, i, i2, i30, zzizVar);
                    zzmf zzmfVar = zzmfVarZzap;
                    int i31 = i2;
                    zziz zzizVar2 = zzizVar;
                    zzkpVar.add(zzizVar2.zznm);
                    while (iZza25 < i31) {
                        int iZza26 = zziy.zza(bArr, iZza25, zzizVar2);
                        if (i3 != zzizVar2.zznk) {
                            return iZza25;
                        }
                        zzmf zzmfVar2 = zzmfVar;
                        int i32 = i31;
                        zziz zzizVar3 = zzizVar2;
                        iZza25 = zziy.zza(zzmfVar2, bArr, iZza26, i32, i30, zzizVar3);
                        zzkpVar.add(zzizVar3.zznm);
                        zzmfVar = zzmfVar2;
                        i31 = i32;
                        zzizVar2 = zzizVar3;
                    }
                    return iZza25;
                }
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zziz zzizVar) throws IOException {
        byte[] bArr2;
        zziz zzizVar2;
        int i4;
        Unsafe unsafe = zzuc;
        Object objZzaq = zzaq(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzut.zzj(object)) {
            Object objZzl = this.zzut.zzl(objZzaq);
            this.zzut.zzb(objZzl, object);
            unsafe.putObject(t, j, objZzl);
            object = objZzl;
        }
        zzlj<?, ?> zzljVarZzm = this.zzut.zzm(objZzaq);
        Map<?, ?> mapZzh = this.zzut.zzh(object);
        int iZza = zziy.zza(bArr, i, zzizVar);
        int i5 = zzizVar.zznk;
        if (i5 < 0 || i5 > i2 - iZza) {
            throw zzkq.zzdi();
        }
        int i6 = i5 + iZza;
        K k = zzljVarZzm.zztv;
        V v = zzljVarZzm.zztx;
        while (iZza < i6) {
            int iZza2 = iZza + 1;
            int i7 = bArr[iZza];
            if (i7 < 0) {
                iZza2 = zziy.zza(i7, bArr, iZza2, zzizVar);
                i7 = zzizVar.zznk;
            }
            int i8 = iZza2;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 == 1) {
                bArr2 = bArr;
                int i11 = i2;
                zzizVar2 = zzizVar;
                if (i10 == zzljVarZzm.zztu.zzfk()) {
                    i4 = i11;
                    iZza = zza(bArr2, i8, i4, zzljVarZzm.zztu, (Class<?>) null, zzizVar2);
                    k = zzizVar2.zznm;
                    bArr = bArr2;
                    i2 = i4;
                    zzizVar = zzizVar2;
                } else {
                    i4 = i11;
                }
            } else if (i9 == 2 && i10 == zzljVarZzm.zztw.zzfk()) {
                byte[] bArr3 = bArr;
                int i12 = i2;
                zziz zzizVar3 = zzizVar;
                iZza = zza(bArr3, i8, i12, zzljVarZzm.zztw, zzljVarZzm.zztx.getClass(), zzizVar3);
                v = (V) zzizVar3.zznm;
                i2 = i12;
                bArr = bArr3;
            } else {
                bArr2 = bArr;
                i4 = i2;
                zzizVar2 = zzizVar;
            }
            iZza = zziy.zza(i7, bArr2, i8, i4, zzizVar2);
            k = k;
            bArr = bArr2;
            i2 = i4;
            zzizVar = zzizVar2;
        }
        if (iZza != i6) {
            throw zzkq.zzdm();
        }
        mapZzh.put(k, v);
        return i6;
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zziz zzizVar) throws IOException {
        int i9;
        int i10;
        int iZzb;
        Object object;
        Unsafe unsafe = zzuc;
        long j2 = this.zzud[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                unsafe.putObject(t, j, Double.valueOf(zziy.zzc(bArr, i)));
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                unsafe.putObject(t, j, Float.valueOf(zziy.zzd(bArr, i)));
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zziy.zzb(bArr, i, zzizVar);
                unsafe.putObject(t, j, Long.valueOf(zzizVar.zznl));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zziy.zza(bArr, i, zzizVar);
                unsafe.putObject(t, j, Integer.valueOf(zzizVar.zznk));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                unsafe.putObject(t, j, Long.valueOf(zziy.zzb(bArr, i)));
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                unsafe.putObject(t, j, Integer.valueOf(zziy.zza(bArr, i)));
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zziy.zzb(bArr, i, zzizVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzizVar.zznl != 0));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zziy.zza(bArr, i, zzizVar);
                int i11 = zzizVar.zznk;
                if (i11 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zznf.zze(bArr, iZza, iZza + i11)) {
                        throw zzkq.zzdn();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i11, zzkm.UTF_8));
                    iZza += i11;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zziy.zza(zzap(i8), bArr, i, i2, zzizVar);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzizVar.zznm);
                } else {
                    unsafe.putObject(t, j, zzkm.zza(object, zzizVar.zznm));
                }
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iZzb = zziy.zze(bArr, i, zzizVar);
                unsafe.putObject(t, j, zzizVar.zznm);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZza3 = zziy.zza(bArr, i, zzizVar);
                int i12 = zzizVar.zznk;
                zzko zzkoVarZzar = zzar(i8);
                if (zzkoVarZzar == null || zzkoVarZzar.zzan(i12)) {
                    unsafe.putObject(t, j, Integer.valueOf(i12));
                    iZzb = iZza3;
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
                zzo(t).zzb(i3, Long.valueOf(i12));
                return iZza3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zziy.zza(bArr, i, zzizVar);
                unsafe.putObject(t, j, Integer.valueOf(zzjo.zzw(zzizVar.zznk)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zziy.zzb(bArr, i, zzizVar);
                unsafe.putObject(t, j, Long.valueOf(zzjo.zzk(zzizVar.zznl)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 == 3) {
                    iZzb = zziy.zza(zzap(i8), bArr, i, i2, (i3 & (-8)) | 4, zzizVar);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzizVar.zznm);
                    } else {
                        unsafe.putObject(t, j, zzkm.zza(object, zzizVar.zznm));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
            default:
                return i;
        }
    }

    private final zzmf zzap(int i) {
        int i2 = (i / 3) << 1;
        zzmf zzmfVar = (zzmf) this.zzue[i2];
        if (zzmfVar != null) {
            return zzmfVar;
        }
        zzmf<T> zzmfVarZzf = zzmd.zzej().zzf((Class) this.zzue[i2 + 1]);
        this.zzue[i2] = zzmfVarZzf;
        return zzmfVarZzf;
    }

    private final Object zzaq(int i) {
        return this.zzue[(i / 3) << 1];
    }

    private final zzko zzar(int i) {
        return (zzko) this.zzue[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x046a, code lost:
    
        if (r10 == (-1)) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x046c, code lost:
    
        r25.putInt(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0472, code lost:
    
        r10 = r8.zzun;
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0479, code lost:
    
        if (r10 >= r8.zzuo) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x047b, code lost:
    
        r1 = r8.zzum[r10];
        r6 = r8.zzur;
        r2 = r8.zzud[r1];
        r0 = com.google.android.gms.internal.drive.zznd.zzo(r9, r8.zzas(r1) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0490, code lost:
    
        if (r0 != null) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0493, code lost:
    
        r4 = r8.zzar(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0497, code lost:
    
        if (r4 != null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0499, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x049b, code lost:
    
        r3 = r8.zzut.zzh(r0);
        r0 = r8;
        r5 = r0.zza(r1, r2, r3, r4, (com.google.android.gms.internal.drive.zzko) r5, (com.google.android.gms.internal.drive.zzmx<UT, com.google.android.gms.internal.drive.zzko>) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x04a6, code lost:
    
        r5 = (com.google.android.gms.internal.drive.zzmy) r5;
        r10 = r10 + 1;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x04ac, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x04ad, code lost:
    
        if (r5 == null) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04af, code lost:
    
        r0.zzur.zzf(r9, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04b4, code lost:
    
        if (r33 != 0) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04b6, code lost:
    
        if (r7 != r13) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x04bd, code lost:
    
        throw com.google.android.gms.internal.drive.zzkq.zzdm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x04be, code lost:
    
        if (r7 > r13) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x04c0, code lost:
    
        if (r12 != r33) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x04c2, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x04c7, code lost:
    
        throw com.google.android.gms.internal.drive.zzkq.zzdm();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza(T t, byte[] bArr, int i, int i2, int i3, zziz zzizVar) throws IOException {
        T t2;
        int i4;
        Unsafe unsafe;
        zzlu<T> zzluVar;
        int i5;
        int iZzau;
        int i6;
        int i7;
        zziz zzizVar2;
        int i8;
        Unsafe unsafe2;
        byte[] bArr2;
        int i9;
        byte[] bArr3;
        int i10;
        int iZzb;
        byte[] bArr4;
        int i11;
        byte[] bArr5;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        zzlu<T> zzluVar2 = this;
        T t3 = t;
        byte[] bArr6 = bArr;
        int i17 = i2;
        zziz zzizVar3 = zzizVar;
        Unsafe unsafe3 = zzuc;
        int iZza = i;
        int i18 = -1;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (iZza < i17) {
                int iZza2 = iZza + 1;
                int i23 = bArr6[iZza];
                if (i23 < 0) {
                    iZza2 = zziy.zza(i23, bArr6, iZza2, zzizVar3);
                    i23 = zzizVar3.zznk;
                }
                int i24 = iZza2;
                int i25 = i23;
                int i26 = i25 >>> 3;
                int i27 = i19;
                int i28 = i25 & 7;
                if (i26 > i18) {
                    iZzau = zzluVar2.zzp(i26, i27 / 3);
                } else {
                    iZzau = zzluVar2.zzau(i26);
                }
                int i29 = iZzau;
                if (i29 == -1) {
                    t2 = t3;
                    i6 = i24;
                    unsafe = unsafe3;
                    i18 = i26;
                    i19 = 0;
                    zzluVar = zzluVar2;
                    i7 = i25;
                } else {
                    int[] iArr = zzluVar2.zzud;
                    int i30 = iArr[i29 + 1];
                    int i31 = (i30 & 267386880) >>> 20;
                    long j = i30 & 1048575;
                    if (i31 <= 17) {
                        int i32 = iArr[i29 + 2];
                        int i33 = 1 << (i32 >>> 20);
                        int i34 = i32 & 1048575;
                        if (i34 != i20) {
                            if (i20 != -1) {
                                unsafe3.putInt(t3, i20, i21);
                            }
                            i21 = unsafe3.getInt(t3, i34);
                            i20 = i34;
                        }
                        switch (i31) {
                            case 0:
                                unsafe2 = unsafe3;
                                i8 = i24;
                                i22 = i25;
                                bArr2 = bArr;
                                zzizVar2 = zzizVar;
                                if (i28 != 1) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    zznd.zza(t3, j, zziy.zzc(bArr2, i8));
                                    iZza = i8 + 8;
                                    i21 |= i33;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                }
                            case 1:
                                unsafe2 = unsafe3;
                                i8 = i24;
                                i22 = i25;
                                bArr2 = bArr;
                                zzizVar2 = zzizVar;
                                if (i28 != 5) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    zznd.zza((Object) t3, j, zziy.zzd(bArr2, i8));
                                    iZza = i8 + 4;
                                    i21 |= i33;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                }
                            case 2:
                            case 3:
                                unsafe2 = unsafe3;
                                i8 = i24;
                                i22 = i25;
                                bArr2 = bArr;
                                zzizVar2 = zzizVar;
                                if (i28 != 0) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    int iZzb2 = zziy.zzb(bArr2, i8, zzizVar2);
                                    unsafe2.putLong(t, j, zzizVar2.zznl);
                                    unsafe2 = unsafe2;
                                    t3 = t;
                                    i21 |= i33;
                                    iZza = iZzb2;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                }
                            case 4:
                            case 11:
                                unsafe2 = unsafe3;
                                i8 = i24;
                                i22 = i25;
                                bArr2 = bArr;
                                zzizVar2 = zzizVar;
                                if (i28 != 0) {
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    iZza = zziy.zza(bArr2, i8, zzizVar2);
                                    unsafe2.putInt(t3, j, zzizVar2.zznk);
                                    i21 |= i33;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                }
                            case 5:
                            case 14:
                                unsafe2 = unsafe3;
                                i9 = i24;
                                i22 = i25;
                                bArr2 = bArr;
                                zzizVar2 = zzizVar;
                                if (i28 != 1) {
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    i8 = i9;
                                    unsafe2.putLong(t, j, zziy.zzb(bArr2, i9));
                                    unsafe2 = unsafe2;
                                    t3 = t;
                                    iZza = i8 + 8;
                                    i21 |= i33;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                }
                            case 6:
                            case 13:
                                unsafe2 = unsafe3;
                                i9 = i24;
                                i22 = i25;
                                bArr2 = bArr;
                                zzizVar2 = zzizVar;
                                if (i28 != 5) {
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    unsafe2.putInt(t3, j, zziy.zza(bArr2, i9));
                                    iZza = i9 + 4;
                                    i21 |= i33;
                                    bArr6 = bArr2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                }
                            case 7:
                                bArr3 = bArr;
                                unsafe2 = unsafe3;
                                i10 = i24;
                                i22 = i25;
                                zzizVar2 = zzizVar;
                                if (i28 != 0) {
                                    i8 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    iZzb = zziy.zzb(bArr3, i10, zzizVar2);
                                    zznd.zza(t3, j, zzizVar2.zznl != 0);
                                    i21 |= i33;
                                    byte[] bArr7 = bArr3;
                                    iZza = iZzb;
                                    bArr6 = bArr7;
                                    unsafe3 = unsafe2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    i17 = i2;
                                }
                            case 8:
                                bArr3 = bArr;
                                unsafe2 = unsafe3;
                                i10 = i24;
                                i22 = i25;
                                zzizVar2 = zzizVar;
                                if (i28 != 2) {
                                    i8 = i10;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    if ((536870912 & i30) == 0) {
                                        iZzb = zziy.zzc(bArr3, i10, zzizVar2);
                                    } else {
                                        iZzb = zziy.zzd(bArr3, i10, zzizVar2);
                                    }
                                    unsafe2.putObject(t3, j, zzizVar2.zznm);
                                    i21 |= i33;
                                    byte[] bArr72 = bArr3;
                                    iZza = iZzb;
                                    bArr6 = bArr72;
                                    unsafe3 = unsafe2;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    i17 = i2;
                                }
                            case 9:
                                bArr4 = bArr;
                                unsafe2 = unsafe3;
                                i9 = i24;
                                i22 = i25;
                                i11 = i2;
                                zzizVar2 = zzizVar;
                                if (i28 != 2) {
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    iZza = zziy.zza(zzluVar2.zzap(i29), bArr4, i9, i11, zzizVar2);
                                    if ((i21 & i33) == 0) {
                                        unsafe2.putObject(t3, j, zzizVar2.zznm);
                                    } else {
                                        unsafe2.putObject(t3, j, zzkm.zza(unsafe2.getObject(t3, j), zzizVar2.zznm));
                                    }
                                    i21 |= i33;
                                    int i35 = i11;
                                    unsafe3 = unsafe2;
                                    i17 = i35;
                                    bArr6 = bArr4;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                }
                            case 10:
                                bArr4 = bArr;
                                unsafe2 = unsafe3;
                                i9 = i24;
                                i22 = i25;
                                i11 = i2;
                                zzizVar2 = zzizVar;
                                if (i28 != 2) {
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    iZza = zziy.zze(bArr4, i9, zzizVar2);
                                    unsafe2.putObject(t3, j, zzizVar2.zznm);
                                    i21 |= i33;
                                    int i352 = i11;
                                    unsafe3 = unsafe2;
                                    i17 = i352;
                                    bArr6 = bArr4;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                }
                            case 12:
                                bArr4 = bArr;
                                unsafe2 = unsafe3;
                                i9 = i24;
                                i11 = i2;
                                zzizVar2 = zzizVar;
                                if (i28 != 0) {
                                    i22 = i25;
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    iZza = zziy.zza(bArr4, i9, zzizVar2);
                                    int i36 = zzizVar2.zznk;
                                    zzko zzkoVarZzar = zzluVar2.zzar(i29);
                                    if (zzkoVarZzar == null || zzkoVarZzar.zzan(i36)) {
                                        i22 = i25;
                                        unsafe2.putInt(t3, j, i36);
                                        i21 |= i33;
                                        int i3522 = i11;
                                        unsafe3 = unsafe2;
                                        i17 = i3522;
                                        bArr6 = bArr4;
                                        zzizVar3 = zzizVar2;
                                        i19 = i29;
                                        i18 = i26;
                                    } else {
                                        i22 = i25;
                                        zzo(t3).zzb(i22, Long.valueOf(i36));
                                        int i35222 = i11;
                                        unsafe3 = unsafe2;
                                        i17 = i35222;
                                        bArr6 = bArr4;
                                        zzizVar3 = zzizVar2;
                                        i19 = i29;
                                        i18 = i26;
                                    }
                                }
                                break;
                            case 15:
                                bArr5 = bArr;
                                unsafe2 = unsafe3;
                                i9 = i24;
                                zzizVar2 = zzizVar;
                                if (i28 != 0) {
                                    i22 = i25;
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    iZza = zziy.zza(bArr5, i9, zzizVar2);
                                    unsafe2.putInt(t3, j, zzjo.zzw(zzizVar2.zznk));
                                    i21 |= i33;
                                    unsafe3 = unsafe2;
                                    i17 = i2;
                                    bArr6 = bArr5;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i22 = i25;
                                    i18 = i26;
                                }
                            case 16:
                                bArr5 = bArr;
                                i9 = i24;
                                if (i28 != 0) {
                                    zzizVar2 = zzizVar;
                                    unsafe2 = unsafe3;
                                    i22 = i25;
                                    i8 = i9;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    int iZzb3 = zziy.zzb(bArr5, i9, zzizVar);
                                    zzizVar2 = zzizVar;
                                    T t4 = t3;
                                    Unsafe unsafe4 = unsafe3;
                                    unsafe4.putLong(t4, j, zzjo.zzk(zzizVar.zznl));
                                    t3 = t4;
                                    i21 |= i33;
                                    unsafe3 = unsafe4;
                                    i17 = i2;
                                    iZza = iZzb3;
                                    bArr6 = bArr5;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i22 = i25;
                                    i18 = i26;
                                }
                            case 17:
                                if (i28 != 3) {
                                    zzizVar2 = zzizVar;
                                    i8 = i24;
                                    unsafe2 = unsafe3;
                                    i22 = i25;
                                    zzluVar = zzluVar2;
                                    unsafe = unsafe2;
                                    i6 = i8;
                                    i7 = i22;
                                    zzizVar3 = zzizVar2;
                                    i19 = i29;
                                    i18 = i26;
                                    t2 = t3;
                                    break;
                                } else {
                                    int iZza3 = zziy.zza(zzluVar2.zzap(i29), bArr, i24, i2, (i26 << 3) | 4, zzizVar);
                                    if ((i21 & i33) == 0) {
                                        unsafe3.putObject(t3, j, zzizVar.zznm);
                                    } else {
                                        unsafe3.putObject(t3, j, zzkm.zza(unsafe3.getObject(t3, j), zzizVar.zznm));
                                    }
                                    i21 |= i33;
                                    i17 = i2;
                                    zzizVar3 = zzizVar;
                                    i19 = i29;
                                    i22 = i25;
                                    i18 = i26;
                                    iZza = iZza3;
                                    bArr6 = bArr;
                                }
                            default:
                                zzizVar2 = zzizVar;
                                unsafe2 = unsafe3;
                                i8 = i24;
                                i22 = i25;
                                zzluVar = zzluVar2;
                                unsafe = unsafe2;
                                i6 = i8;
                                i7 = i22;
                                zzizVar3 = zzizVar2;
                                i19 = i29;
                                i18 = i26;
                                t2 = t3;
                                break;
                        }
                    } else {
                        zziz zzizVar4 = zzizVar3;
                        Unsafe unsafe5 = unsafe3;
                        i22 = i25;
                        if (i31 != 27) {
                            i12 = i24;
                            if (i31 <= 49) {
                                i13 = i20;
                                unsafe = unsafe5;
                                i14 = i21;
                                int iZza4 = zzluVar2.zza((zzlu<T>) t, bArr, i12, i2, i22, i26, i28, i29, i30, i31, j, zzizVar);
                                i15 = i22;
                                i16 = i29;
                                if (iZza4 == i12) {
                                    zzluVar = this;
                                    t2 = t;
                                    zzizVar3 = zzizVar;
                                    i6 = iZza4;
                                } else {
                                    zzluVar2 = this;
                                    t3 = t;
                                    bArr6 = bArr;
                                    i17 = i2;
                                    zzizVar3 = zzizVar;
                                    iZza = iZza4;
                                    i19 = i16;
                                    i20 = i13;
                                    i21 = i14;
                                    i22 = i15;
                                    i18 = i26;
                                    unsafe3 = unsafe;
                                }
                            } else {
                                unsafe = unsafe5;
                                i13 = i20;
                                i14 = i21;
                                i15 = i22;
                                i16 = i29;
                                if (i31 != 50) {
                                    i18 = i26;
                                    int iZza5 = zza((zzlu<T>) t, bArr, i12, i2, i15, i18, i28, i30, i31, j, i16, zzizVar);
                                    zzluVar = this;
                                    t2 = t;
                                    i7 = i15;
                                    zzizVar3 = zzizVar;
                                    if (iZza5 == i12) {
                                        i6 = iZza5;
                                        i19 = i16;
                                        i20 = i13;
                                        i21 = i14;
                                    } else {
                                        bArr6 = bArr;
                                        i17 = i2;
                                        zzizVar3 = zzizVar;
                                        iZza = iZza5;
                                        t3 = t2;
                                        i19 = i16;
                                        i20 = i13;
                                        i21 = i14;
                                        i22 = i7;
                                        zzluVar2 = zzluVar;
                                        unsafe3 = unsafe;
                                    }
                                } else if (i28 == 2) {
                                    int iZza6 = zza((zzlu<T>) t, bArr, i12, i2, i16, j, zzizVar);
                                    if (iZza6 == i12) {
                                        zzluVar = this;
                                        t2 = t;
                                        zzizVar3 = zzizVar;
                                        i6 = iZza6;
                                    } else {
                                        zzluVar2 = this;
                                        t3 = t;
                                        bArr6 = bArr;
                                        i17 = i2;
                                        zzizVar3 = zzizVar;
                                        iZza = iZza6;
                                        i19 = i16;
                                        i20 = i13;
                                        i21 = i14;
                                        i22 = i15;
                                        i18 = i26;
                                        unsafe3 = unsafe;
                                    }
                                } else {
                                    zzluVar = this;
                                    t2 = t;
                                    zzizVar3 = zzizVar;
                                    i6 = i12;
                                }
                            }
                        } else if (i28 == 2) {
                            zzkp zzkpVarZzr = (zzkp) unsafe5.getObject(t3, j);
                            if (!zzkpVarZzr.zzbo()) {
                                int size = zzkpVarZzr.size();
                                zzkpVarZzr = zzkpVarZzr.zzr(size == 0 ? 10 : size << 1);
                                unsafe5.putObject(t3, j, zzkpVarZzr);
                            }
                            unsafe3 = unsafe5;
                            int iZza7 = zziy.zza(zzluVar2.zzap(i29), i22, bArr, i24, i2, zzkpVarZzr, zzizVar4);
                            bArr6 = bArr;
                            i17 = i2;
                            zzizVar3 = zzizVar;
                            iZza = iZza7;
                            i19 = i29;
                            i18 = i26;
                            t3 = t;
                        } else {
                            i12 = i24;
                            unsafe = unsafe5;
                            i13 = i20;
                            i14 = i21;
                            i15 = i22;
                            i16 = i29;
                            zzluVar = this;
                            t2 = t;
                            zzizVar3 = zzizVar;
                            i6 = i12;
                        }
                        i19 = i16;
                        i20 = i13;
                        i21 = i14;
                        i7 = i15;
                        i18 = i26;
                    }
                }
                if (i7 != i3 || i3 == 0) {
                    if (zzluVar.zzui && zzizVar3.zznn != zzjx.zzci()) {
                        if (zzizVar3.zznn.zza(zzluVar.zzuh, i18) == null) {
                            int iZza8 = zziy.zza(i7, bArr, i6, i2, zzo(t2), zzizVar3);
                            i17 = i2;
                            zzizVar3 = zzizVar;
                            i22 = i7;
                            iZza = iZza8;
                            zzluVar2 = zzluVar;
                            t3 = t2;
                            unsafe3 = unsafe;
                        } else {
                            zzkk.zzc zzcVar = (zzkk.zzc) t2;
                            zzcVar.zzdg();
                            zzkb<Object> zzkbVar = zzcVar.zzrw;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        zzizVar3 = zzizVar;
                        int iZza9 = zziy.zza(i7, bArr, i6, i2, zzo(t2), zzizVar3);
                        i22 = i7;
                        i17 = i2;
                        zzluVar2 = zzluVar;
                        t3 = t2;
                        unsafe3 = unsafe;
                        iZza = iZza9;
                    }
                    bArr6 = bArr;
                } else {
                    i4 = i2;
                    i22 = i7;
                    i5 = i6;
                }
            } else {
                t2 = t3;
                i4 = i17;
                unsafe = unsafe3;
                zzluVar = zzluVar2;
                i5 = iZza;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0059. Please report as an issue. */
    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zza(T t, byte[] bArr, int i, int i2, zziz zzizVar) throws IOException {
        int iZzau;
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe2;
        int i7;
        int i8;
        int i9;
        int i10;
        int iZzb;
        T t2;
        zzlu<T> zzluVar = this;
        byte[] bArr2 = bArr;
        int i11 = i2;
        zziz zzizVar2 = zzizVar;
        if (zzluVar.zzuk) {
            Unsafe unsafe3 = zzuc;
            int i12 = -1;
            int iZza = i;
            int i13 = -1;
            int i14 = 0;
            while (iZza < i11) {
                int iZza2 = iZza + 1;
                int i15 = bArr2[iZza];
                if (i15 < 0) {
                    iZza2 = zziy.zza(i15, bArr2, iZza2, zzizVar2);
                    i15 = zzizVar2.zznk;
                }
                int i16 = iZza2;
                int i17 = i15;
                int i18 = i17 >>> 3;
                int i19 = i17 & 7;
                if (i18 > i13) {
                    iZzau = zzluVar.zzp(i18, i14 / 3);
                } else {
                    iZzau = zzluVar.zzau(i18);
                }
                int i20 = iZzau;
                if (i20 == i12) {
                    unsafe = unsafe3;
                    i3 = i16;
                    i4 = i18;
                    i5 = 0;
                    i6 = i17;
                } else {
                    int i21 = zzluVar.zzud[i20 + 1];
                    int i22 = (267386880 & i21) >>> 20;
                    long j = 1048575 & i21;
                    if (i22 <= 17) {
                        switch (i22) {
                            case 0:
                                unsafe2 = unsafe3;
                                if (i19 != 1) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    zznd.zza(t, j, zziy.zzc(bArr2, i16));
                                    iZza = i16 + 8;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 1:
                                unsafe2 = unsafe3;
                                if (i19 != 5) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    zznd.zza((Object) t, j, zziy.zzd(bArr2, i16));
                                    iZza = i16 + 4;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 2:
                            case 3:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZzb = zziy.zzb(bArr2, i16, zzizVar2);
                                    t2 = t;
                                    unsafe3 = unsafe2;
                                    unsafe3.putLong(t2, j, zzizVar2.zznl);
                                    unsafe3 = unsafe3;
                                    iZza = iZzb;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 4:
                            case 11:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZza = zziy.zza(bArr2, i16, zzizVar2);
                                    unsafe2.putInt(t, j, zzizVar2.zznk);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 5:
                            case 14:
                                unsafe2 = unsafe3;
                                if (i19 != 1) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j, zziy.zzb(bArr2, i16));
                                    unsafe2 = unsafe2;
                                    iZza = i16 + 8;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 6:
                            case 13:
                                unsafe2 = unsafe3;
                                if (i19 != 5) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    unsafe2.putInt(t, j, zziy.zza(bArr2, i16));
                                    iZza = i16 + 4;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 7:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    int iZzb2 = zziy.zzb(bArr2, i16, zzizVar2);
                                    zznd.zza(t, j, zzizVar2.zznl != 0);
                                    iZza = iZzb2;
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 8:
                                unsafe2 = unsafe3;
                                if (i19 != 2) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    if ((536870912 & i21) == 0) {
                                        iZza = zziy.zzc(bArr2, i16, zzizVar2);
                                    } else {
                                        iZza = zziy.zzd(bArr2, i16, zzizVar2);
                                    }
                                    unsafe2.putObject(t, j, zzizVar2.zznm);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 9:
                                unsafe2 = unsafe3;
                                if (i19 != 2) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZza = zziy.zza(zzluVar.zzap(i20), bArr2, i16, i11, zzizVar2);
                                    Object object = unsafe2.getObject(t, j);
                                    if (object == null) {
                                        unsafe2.putObject(t, j, zzizVar2.zznm);
                                    } else {
                                        unsafe2.putObject(t, j, zzkm.zza(object, zzizVar2.zznm));
                                    }
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 10:
                                unsafe2 = unsafe3;
                                if (i19 != 2) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZza = zziy.zze(bArr2, i16, zzizVar2);
                                    unsafe2.putObject(t, j, zzizVar2.zznm);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 12:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZza = zziy.zza(bArr2, i16, zzizVar2);
                                    unsafe2.putInt(t, j, zzizVar2.zznk);
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 15:
                                unsafe2 = unsafe3;
                                if (i19 != 0) {
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZza = zziy.zza(bArr2, i16, zzizVar2);
                                    unsafe2.putInt(t, j, zzjo.zzw(zzizVar2.zznk));
                                    unsafe3 = unsafe2;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            case 16:
                                if (i19 != 0) {
                                    unsafe2 = unsafe3;
                                    unsafe = unsafe2;
                                    i10 = i16;
                                    i9 = i18;
                                    i8 = i20;
                                    i6 = i17;
                                    i3 = i10;
                                    i5 = i8;
                                    break;
                                } else {
                                    iZzb = zziy.zzb(bArr2, i16, zzizVar2);
                                    t2 = t;
                                    unsafe3.putLong(t2, j, zzjo.zzk(zzizVar2.zznl));
                                    unsafe3 = unsafe3;
                                    iZza = iZzb;
                                    i13 = i18;
                                    i14 = i20;
                                    i12 = -1;
                                    break;
                                }
                            default:
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i10 = i16;
                                i9 = i18;
                                i8 = i20;
                                i6 = i17;
                                i3 = i10;
                                i5 = i8;
                                break;
                        }
                    } else {
                        unsafe2 = unsafe3;
                        if (i22 != 27) {
                            unsafe = unsafe2;
                            if (i22 <= 49) {
                                int iZza3 = zzluVar.zza((zzlu<T>) t, bArr, i16, i2, i17, i18, i19, i20, i21, i22, j, zzizVar);
                                i6 = i17;
                                i7 = i20;
                                if (iZza3 == i16) {
                                    i3 = iZza3;
                                    i4 = i18;
                                    i5 = i7;
                                } else {
                                    zzluVar = this;
                                    i11 = i2;
                                    zzizVar2 = zzizVar;
                                    i14 = i7;
                                    iZza = iZza3;
                                    i13 = i18;
                                }
                            } else {
                                i8 = i20;
                                i9 = i18;
                                i6 = i17;
                                if (i22 != 50) {
                                    i4 = i9;
                                    int iZza4 = zza((zzlu<T>) t, bArr, i16, i2, i6, i4, i19, i21, i22, j, i8, zzizVar);
                                    i6 = i6;
                                    i7 = i8;
                                    if (iZza4 == i16) {
                                        i3 = iZza4;
                                        i5 = i7;
                                    } else {
                                        zzluVar = this;
                                        i11 = i2;
                                        zzizVar2 = zzizVar;
                                        i14 = i7;
                                        i13 = i4;
                                        iZza = iZza4;
                                    }
                                } else if (i19 == 2) {
                                    int iZza5 = zza((zzlu<T>) t, bArr, i16, i2, i8, j, zzizVar);
                                    if (iZza5 == i16) {
                                        i5 = i8;
                                        i3 = iZza5;
                                    } else {
                                        zzluVar = this;
                                        bArr2 = bArr;
                                        i11 = i2;
                                        zzizVar2 = zzizVar;
                                        i14 = i8;
                                        iZza = iZza5;
                                        i13 = i9;
                                    }
                                } else {
                                    i10 = i16;
                                    i3 = i10;
                                    i5 = i8;
                                }
                            }
                            unsafe3 = unsafe;
                            i12 = -1;
                            bArr2 = bArr;
                        } else if (i19 == 2) {
                            zzkp zzkpVarZzr = (zzkp) unsafe2.getObject(t, j);
                            if (!zzkpVarZzr.zzbo()) {
                                int size = zzkpVarZzr.size();
                                zzkpVarZzr = zzkpVarZzr.zzr(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t, j, zzkpVarZzr);
                            }
                            unsafe = unsafe2;
                            iZza = zziy.zza(zzluVar.zzap(i20), i17, bArr2, i16, i11, zzkpVarZzr, zzizVar2);
                            bArr2 = bArr;
                            i11 = i2;
                            zzizVar2 = zzizVar;
                            i13 = i18;
                            i14 = i20;
                        } else {
                            unsafe = unsafe2;
                            i10 = i16;
                            i9 = i18;
                            i8 = i20;
                            i6 = i17;
                            i3 = i10;
                            i5 = i8;
                        }
                        unsafe3 = unsafe;
                        i12 = -1;
                    }
                    i4 = i9;
                }
                iZza = zziy.zza(i6, bArr, i3, i2, zzo(t), zzizVar);
                zzluVar = this;
                zzizVar2 = zzizVar;
                i11 = i2;
                i13 = i4;
                i14 = i5;
                unsafe3 = unsafe;
                i12 = -1;
                bArr2 = bArr;
            }
            if (iZza != i11) {
                throw zzkq.zzdm();
            }
            return;
        }
        zza((zzlu<T>) t, bArr, i, i11, 0, zzizVar);
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzd(T t) {
        int i;
        int i2 = this.zzun;
        while (true) {
            i = this.zzuo;
            if (i2 >= i) {
                break;
            }
            long jZzas = zzas(this.zzum[i2]) & 1048575;
            Object objZzo = zznd.zzo(t, jZzas);
            if (objZzo != null) {
                zznd.zza(t, jZzas, this.zzut.zzk(objZzo));
            }
            i2++;
        }
        int length = this.zzum.length;
        while (i < length) {
            this.zzuq.zza(t, this.zzum[i]);
            i++;
        }
        this.zzur.zzd(t);
        if (this.zzui) {
            this.zzus.zzd(t);
        }
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzko zzkoVar, UB ub, zzmx<UT, UB> zzmxVar) {
        zzlj<?, ?> zzljVarZzm = this.zzut.zzm(zzaq(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzkoVar.zzan(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmxVar.zzez();
                }
                zzjk zzjkVarZzu = zzjc.zzu(zzli.zza(zzljVarZzm, next.getKey(), next.getValue()));
                try {
                    zzli.zza(zzjkVarZzu.zzby(), zzljVarZzm, next.getKey(), next.getValue());
                    zzmxVar.zza((zzmx<UT, UB>) ub, i2, zzjkVarZzu.zzbx());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2  */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.drive.zzmf] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.drive.zzmf] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzp(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzun; i4++) {
            int i5 = this.zzum[i4];
            int i6 = this.zzud[i5];
            int iZzas = zzas(i5);
            if (this.zzuk) {
                i = 0;
            } else {
                int i7 = this.zzud[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i3 = zzuc.getInt(t, i8);
                    i2 = i8;
                }
            }
            if ((268435456 & iZzas) != 0 && !zza((zzlu<T>) t, i5, i3, i)) {
                return false;
            }
            int i9 = (267386880 & iZzas) >>> 20;
            if (i9 == 9 || i9 == 17) {
                if (zza((zzlu<T>) t, i5, i3, i) && !zza(t, iZzas, zzap(i5))) {
                    return false;
                }
            } else if (i9 == 27) {
                List list = (List) zznd.zzo(t, iZzas & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ?? Zzap = zzap(i5);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!Zzap.zzp(list.get(i10))) {
                            return false;
                        }
                    }
                }
            } else if (i9 == 60 || i9 == 68) {
                if (zza((zzlu<T>) t, i6, i5) && !zza(t, iZzas, zzap(i5))) {
                    return false;
                }
            } else if (i9 != 49) {
                if (i9 != 50) {
                    continue;
                } else {
                    Map<?, ?> mapZzi = this.zzut.zzi(zznd.zzo(t, iZzas & 1048575));
                    if (mapZzi.isEmpty()) {
                        continue;
                    } else if (this.zzut.zzm(zzaq(i5)).zztw.zzfj() == zznr.MESSAGE) {
                        ?? Zzf = 0;
                        for (Object obj : mapZzi.values()) {
                            Zzf = Zzf;
                            if (Zzf == 0) {
                                Zzf = zzmd.zzej().zzf(obj.getClass());
                            }
                            if (!Zzf.zzp(obj)) {
                                return false;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return !this.zzui || this.zzus.zzb(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzmf zzmfVar) {
        return zzmfVar.zzp(zznd.zzo(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzns zznsVar) throws IOException {
        if (obj instanceof String) {
            zznsVar.zza(i, (String) obj);
        } else {
            zznsVar.zza(i, (zzjc) obj);
        }
    }

    private final int zzas(int i) {
        return this.zzud[i + 1];
    }

    private final int zzat(int i) {
        return this.zzud[i + 2];
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zznd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zznd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zznd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zznd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zznd.zzo(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzlu<T>) t, i) == zza((zzlu<T>) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzuk) {
            return zza((zzlu<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzuk) {
            int iZzas = zzas(i);
            long j = iZzas & 1048575;
            switch ((iZzas & 267386880) >>> 20) {
                case 0:
                    return zznd.zzn(t, j) != 0.0d;
                case 1:
                    return zznd.zzm(t, j) != 0.0f;
                case 2:
                    return zznd.zzk(t, j) != 0;
                case 3:
                    return zznd.zzk(t, j) != 0;
                case 4:
                    return zznd.zzj(t, j) != 0;
                case 5:
                    return zznd.zzk(t, j) != 0;
                case 6:
                    return zznd.zzj(t, j) != 0;
                case 7:
                    return zznd.zzl(t, j);
                case 8:
                    Object objZzo = zznd.zzo(t, j);
                    if (objZzo instanceof String) {
                        return !((String) objZzo).isEmpty();
                    }
                    if (objZzo instanceof zzjc) {
                        return !zzjc.zznq.equals(objZzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zznd.zzo(t, j) != null;
                case 10:
                    return !zzjc.zznq.equals(zznd.zzo(t, j));
                case 11:
                    return zznd.zzj(t, j) != 0;
                case 12:
                    return zznd.zzj(t, j) != 0;
                case 13:
                    return zznd.zzj(t, j) != 0;
                case 14:
                    return zznd.zzk(t, j) != 0;
                case 15:
                    return zznd.zzj(t, j) != 0;
                case 16:
                    return zznd.zzk(t, j) != 0;
                case 17:
                    return zznd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iZzat = zzat(i);
        return (zznd.zzj(t, (long) (iZzat & 1048575)) & (1 << (iZzat >>> 20))) != 0;
    }

    private final void zzb(T t, int i) {
        if (this.zzuk) {
            return;
        }
        int iZzat = zzat(i);
        long j = iZzat & 1048575;
        zznd.zza((Object) t, j, zznd.zzj(t, j) | (1 << (iZzat >>> 20)));
    }

    private final boolean zza(T t, int i, int i2) {
        return zznd.zzj(t, (long) (zzat(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zznd.zza((Object) t, zzat(i2) & 1048575, i);
    }

    private final int zzau(int i) {
        if (i < this.zzuf || i > this.zzug) {
            return -1;
        }
        return zzq(i, 0);
    }

    private final int zzp(int i, int i2) {
        if (i < this.zzuf || i > this.zzug) {
            return -1;
        }
        return zzq(i, i2);
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzud.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzud[i4];
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
