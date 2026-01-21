package com.google.android.libraries.places.internal;

import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzavi<T> implements zzavt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzawx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzavf zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaut zzm;
    private final zzawn zzn;
    private final zzatg zzo;
    private final zzavl zzp;
    private final zzava zzq;

    private zzavi(int[] iArr, Object[] objArr, int i, int i2, zzavf zzavfVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzavl zzavlVar, zzaut zzautVar, zzawn zzawnVar, zzatg zzatgVar, zzava zzavaVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzavfVar instanceof zzatu;
        boolean z2 = false;
        if (zzatgVar != null && zzatgVar.zzi(zzavfVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzp = zzavlVar;
        this.zzm = zzautVar;
        this.zzn = zzawnVar;
        this.zzo = zzatgVar;
        this.zzg = zzavfVar;
        this.zzq = zzavaVar;
    }

    private final void zzA(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzavt zzavtVarZzs = zzs(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZzc = zzavtVarZzs.zzc();
                    zzavtVarZzs.zze(objZzc, object);
                    unsafe.putObject(obj, j, objZzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZzc2 = zzavtVarZzs.zzc();
                zzavtVarZzs.zze(objZzc2, object2);
                unsafe.putObject(obj, j, objZzc2);
                object2 = objZzc2;
            }
            zzavtVarZzs.zze(object2, object);
        }
    }

    private final void zzB(Object obj, int i, zzavs zzavsVar) throws IOException {
        long j = i & 1048575;
        if (zzH(i)) {
            zzawx.zzs(obj, j, zzavsVar.zzs());
        } else if (this.zzi) {
            zzawx.zzs(obj, j, zzavsVar.zzr());
        } else {
            zzawx.zzs(obj, j, zzavsVar.zzp());
        }
    }

    private final void zzC(Object obj, int i) {
        int iZzn = zzn(i);
        long j = 1048575 & iZzn;
        if (j == 1048575) {
            return;
        }
        zzawx.zzq(obj, j, (1 << (iZzn >>> 20)) | zzawx.zzc(obj, j));
    }

    private final void zzD(Object obj, int i, int i2) {
        zzawx.zzq(obj, zzn(i2) & 1048575, i);
    }

    private final void zzE(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzp(i) & 1048575, obj2);
        zzC(obj, i);
    }

    private final void zzF(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzp(i2) & 1048575, obj2);
        zzD(obj, i, i2);
    }

    private final boolean zzG(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private static boolean zzH(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzI(Object obj, int i) {
        int iZzn = zzn(i);
        long j = iZzn & 1048575;
        if (j != 1048575) {
            return (zzawx.zzc(obj, j) & (1 << (iZzn >>> 20))) != 0;
        }
        int iZzp = zzp(i);
        long j2 = iZzp & 1048575;
        switch (zzo(iZzp)) {
            case 0:
                return Double.doubleToRawLongBits(zzawx.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzawx.zzb(obj, j2)) != 0;
            case 2:
                return zzawx.zzd(obj, j2) != 0;
            case 3:
                return zzawx.zzd(obj, j2) != 0;
            case 4:
                return zzawx.zzc(obj, j2) != 0;
            case 5:
                return zzawx.zzd(obj, j2) != 0;
            case 6:
                return zzawx.zzc(obj, j2) != 0;
            case 7:
                return zzawx.zzw(obj, j2);
            case 8:
                Object objZzf = zzawx.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzask) {
                    return !zzask.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzawx.zzf(obj, j2) != null;
            case 10:
                return !zzask.zzb.equals(zzawx.zzf(obj, j2));
            case 11:
                return zzawx.zzc(obj, j2) != 0;
            case 12:
                return zzawx.zzc(obj, j2) != 0;
            case 13:
                return zzawx.zzc(obj, j2) != 0;
            case 14:
                return zzawx.zzd(obj, j2) != 0;
            case 15:
                return zzawx.zzc(obj, j2) != 0;
            case 16:
                return zzawx.zzd(obj, j2) != 0;
            case 17:
                return zzawx.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzavt zzavtVar) {
        return zzavtVar.zzh(zzawx.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzatu) {
            return ((zzatu) obj).zzaH();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzawx.zzc(obj, (long) (zzn(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzawx.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzasy zzasyVar) throws IOException {
        if (obj instanceof String) {
            zzasyVar.zzG(i, (String) obj);
        } else {
            zzasyVar.zzd(i, (zzask) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static zzavi zzi(Class cls, zzavc zzavcVar, zzavl zzavlVar, zzaut zzautVar, zzawn zzawnVar, zzatg zzatgVar, zzava zzavaVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
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
        int i22;
        int iObjectFieldOffset2;
        int i23;
        String str;
        int i24;
        int i25;
        int iObjectFieldOffset3;
        Field fieldZzx;
        char cCharAt9;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field fieldZzx2;
        Object obj2;
        Field fieldZzx3;
        int i30;
        char cCharAt10;
        int i31;
        char cCharAt11;
        int i32;
        char cCharAt12;
        int i33;
        char cCharAt13;
        if (!(zzavcVar instanceof zzavr)) {
            throw null;
        }
        zzavr zzavrVar = (zzavr) zzavcVar;
        String strZzd = zzavrVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i34 = 1;
            while (true) {
                i = i34 + 1;
                if (strZzd.charAt(i34) < 55296) {
                    break;
                }
                i34 = i;
            }
        } else {
            i = 1;
        }
        int i35 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i36 = iCharAt2 & 8191;
            int i37 = 13;
            while (true) {
                i33 = i35 + 1;
                cCharAt13 = strZzd.charAt(i35);
                if (cCharAt13 < 55296) {
                    break;
                }
                i36 |= (cCharAt13 & 8191) << i37;
                i37 += 13;
                i35 = i33;
            }
            iCharAt2 = i36 | (cCharAt13 << i37);
            i35 = i33;
        }
        if (iCharAt2 == 0) {
            iArr = zza;
            i7 = 0;
            i4 = 0;
            iCharAt = 0;
            i3 = 0;
            i5 = 0;
            i2 = 0;
            i6 = 0;
        } else {
            int i38 = i35 + 1;
            int iCharAt3 = strZzd.charAt(i35);
            if (iCharAt3 >= 55296) {
                int i39 = iCharAt3 & 8191;
                int i40 = 13;
                while (true) {
                    i15 = i38 + 1;
                    cCharAt8 = strZzd.charAt(i38);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt8 & 8191) << i40;
                    i40 += 13;
                    i38 = i15;
                }
                iCharAt3 = i39 | (cCharAt8 << i40);
                i38 = i15;
            }
            int i41 = i38 + 1;
            int iCharAt4 = strZzd.charAt(i38);
            if (iCharAt4 >= 55296) {
                int i42 = iCharAt4 & 8191;
                int i43 = 13;
                while (true) {
                    i14 = i41 + 1;
                    cCharAt7 = strZzd.charAt(i41);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt7 & 8191) << i43;
                    i43 += 13;
                    i41 = i14;
                }
                iCharAt4 = i42 | (cCharAt7 << i43);
                i41 = i14;
            }
            int i44 = i41 + 1;
            int iCharAt5 = strZzd.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i13 = i44 + 1;
                    cCharAt6 = strZzd.charAt(i44);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt6 & 8191) << i46;
                    i46 += 13;
                    i44 = i13;
                }
                iCharAt5 = i45 | (cCharAt6 << i46);
                i44 = i13;
            }
            int i47 = i44 + 1;
            int iCharAt6 = strZzd.charAt(i44);
            if (iCharAt6 >= 55296) {
                int i48 = iCharAt6 & 8191;
                int i49 = 13;
                while (true) {
                    i12 = i47 + 1;
                    cCharAt5 = strZzd.charAt(i47);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt5 & 8191) << i49;
                    i49 += 13;
                    i47 = i12;
                }
                iCharAt6 = i48 | (cCharAt5 << i49);
                i47 = i12;
            }
            int i50 = i47 + 1;
            iCharAt = strZzd.charAt(i47);
            if (iCharAt >= 55296) {
                int i51 = iCharAt & 8191;
                int i52 = 13;
                while (true) {
                    i11 = i50 + 1;
                    cCharAt4 = strZzd.charAt(i50);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt4 & 8191) << i52;
                    i52 += 13;
                    i50 = i11;
                }
                iCharAt = i51 | (cCharAt4 << i52);
                i50 = i11;
            }
            int i53 = i50 + 1;
            int iCharAt7 = strZzd.charAt(i50);
            if (iCharAt7 >= 55296) {
                int i54 = iCharAt7 & 8191;
                int i55 = 13;
                while (true) {
                    i10 = i53 + 1;
                    cCharAt3 = strZzd.charAt(i53);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt3 & 8191) << i55;
                    i55 += 13;
                    i53 = i10;
                }
                iCharAt7 = i54 | (cCharAt3 << i55);
                i53 = i10;
            }
            int i56 = i53 + 1;
            int iCharAt8 = strZzd.charAt(i53);
            if (iCharAt8 >= 55296) {
                int i57 = iCharAt8 & 8191;
                int i58 = 13;
                while (true) {
                    i9 = i56 + 1;
                    cCharAt2 = strZzd.charAt(i56);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt2 & 8191) << i58;
                    i58 += 13;
                    i56 = i9;
                }
                iCharAt8 = i57 | (cCharAt2 << i58);
                i56 = i9;
            }
            int i59 = i56 + 1;
            int iCharAt9 = strZzd.charAt(i56);
            if (iCharAt9 >= 55296) {
                int i60 = iCharAt9 & 8191;
                int i61 = 13;
                while (true) {
                    i8 = i59 + 1;
                    cCharAt = strZzd.charAt(i59);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i60 |= (cCharAt & 8191) << i61;
                    i61 += 13;
                    i59 = i8;
                }
                iCharAt9 = i60 | (cCharAt << i61);
                i59 = i8;
            }
            i2 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i62 = iCharAt7;
            i3 = iCharAt5;
            i4 = i62;
            iArr = iArr2;
            i5 = iCharAt6;
            i6 = iCharAt9;
            i7 = iCharAt3;
            i35 = i59;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzavrVar.zze();
        Class<?> cls2 = zzavrVar.zza().getClass();
        int i63 = i6 + i4;
        int i64 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i64];
        int i65 = i6;
        int i66 = i63;
        int i67 = 0;
        int i68 = 0;
        while (i35 < length) {
            int i69 = i35 + 1;
            int iCharAt10 = strZzd.charAt(i35);
            if (iCharAt10 >= c) {
                int i70 = iCharAt10 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i32 = i71 + 1;
                    cCharAt12 = strZzd.charAt(i71);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i70 |= (cCharAt12 & 8191) << i72;
                    i72 += 13;
                    i71 = i32;
                }
                iCharAt10 = i70 | (cCharAt12 << i72);
                i16 = i32;
            } else {
                i16 = i69;
            }
            int i73 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c) {
                int i74 = iCharAt11 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i31 = i75 + 1;
                    cCharAt11 = strZzd.charAt(i75);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i74 |= (cCharAt11 & 8191) << i76;
                    i76 += 13;
                    i75 = i31;
                }
                iCharAt11 = i74 | (cCharAt11 << i76);
                i17 = i31;
            } else {
                i17 = i73;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i68] = i67;
                i68++;
            }
            int i77 = iCharAt11 & 255;
            int i78 = iCharAt11 & 2048;
            zzavr zzavrVar2 = zzavrVar;
            if (i77 >= 51) {
                int i79 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i80 = iCharAt12 & 8191;
                    int i81 = i79;
                    int i82 = 13;
                    while (true) {
                        i30 = i81 + 1;
                        cCharAt10 = strZzd.charAt(i81);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i80 |= (cCharAt10 & 8191) << i82;
                        i82 += 13;
                        i81 = i30;
                        c2 = 55296;
                    }
                    iCharAt12 = i80 | (cCharAt10 << i82);
                    i28 = i30;
                } else {
                    i28 = i79;
                }
                int i83 = i28;
                int i84 = i77 - 51;
                i18 = length;
                if (i84 == 9 || i84 == 17) {
                    i29 = i2 + 1;
                    int i85 = i67 / 3;
                    objArr[i85 + i85 + 1] = objArrZze[i2];
                } else {
                    if (i84 == 12) {
                        if (zzavrVar2.zzc() == 1 || i78 != 0) {
                            i29 = i2 + 1;
                            int i86 = i67 / 3;
                            objArr[i86 + i86 + 1] = objArrZze[i2];
                        } else {
                            i78 = 0;
                        }
                    }
                    int i87 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i87];
                    if (obj instanceof Field) {
                        fieldZzx2 = zzx(cls2, (String) obj);
                        objArrZze[i87] = fieldZzx2;
                    } else {
                        fieldZzx2 = (Field) obj;
                    }
                    int i88 = iCharAt10;
                    int i89 = i78;
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzx2);
                    int i90 = i87 + 1;
                    obj2 = objArrZze[i90];
                    if (obj2 instanceof Field) {
                        fieldZzx3 = zzx(cls2, (String) obj2);
                        objArrZze[i90] = fieldZzx3;
                    } else {
                        fieldZzx3 = (Field) obj2;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzx3);
                    str = strZzd;
                    i35 = i83;
                    i25 = 0;
                    i23 = i2;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    i78 = i89;
                    i19 = i88;
                    i22 = iCharAt11;
                }
                i2 = i29;
                int i872 = iCharAt12 + iCharAt12;
                obj = objArrZze[i872];
                if (obj instanceof Field) {
                }
                int i882 = iCharAt10;
                int i892 = i78;
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzx2);
                int i902 = i872 + 1;
                obj2 = objArrZze[i902];
                if (obj2 instanceof Field) {
                }
                int iObjectFieldOffset42 = (int) unsafe.objectFieldOffset(fieldZzx3);
                str = strZzd;
                i35 = i83;
                i25 = 0;
                i23 = i2;
                iObjectFieldOffset2 = iObjectFieldOffset42;
                i78 = i892;
                i19 = i882;
                i22 = iCharAt11;
            } else {
                i18 = length;
                int i91 = iCharAt10;
                int i92 = i2 + 1;
                Field fieldZzx4 = zzx(cls2, (String) objArrZze[i2]);
                if (i77 == 9 || i77 == 17) {
                    i19 = i91;
                    int i93 = i67 / 3;
                    objArr[i93 + i93 + 1] = fieldZzx4.getType();
                } else {
                    if (i77 == 27) {
                        i19 = i91;
                        i26 = 1;
                        i27 = i2 + 2;
                    } else if (i77 == 49) {
                        i27 = i2 + 2;
                        i19 = i91;
                        i26 = 1;
                    } else {
                        if (i77 == 12 || i77 == 30 || i77 == 44) {
                            i19 = i91;
                            if (zzavrVar2.zzc() == 1 || i78 != 0) {
                                i27 = i2 + 2;
                                int i94 = i67 / 3;
                                objArr[i94 + i94 + 1] = objArrZze[i92];
                                i21 = i27;
                                i20 = iCharAt11;
                            } else {
                                i20 = iCharAt11;
                                i21 = i92;
                                i78 = 0;
                            }
                        } else if (i77 == 50) {
                            i21 = i2 + 2;
                            int i95 = i65 + 1;
                            iArr[i65] = i67;
                            int i96 = i67 / 3;
                            int i97 = i96 + i96;
                            objArr[i97] = objArrZze[i92];
                            if (i78 != 0) {
                                objArr[i97 + 1] = objArrZze[i21];
                                i21 = i2 + 3;
                                i65 = i95;
                                i19 = i91;
                                i20 = iCharAt11;
                            } else {
                                i20 = iCharAt11;
                                i65 = i95;
                                i78 = 0;
                                i19 = i91;
                            }
                        } else {
                            i19 = i91;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx4);
                        i22 = i20;
                        iObjectFieldOffset2 = 1048575;
                        if ((i22 & 4096) == 0 || i77 > 17) {
                            i23 = i21;
                            str = strZzd;
                            i24 = i17;
                            i25 = 0;
                        } else {
                            int i98 = i17 + 1;
                            int iCharAt13 = strZzd.charAt(i17);
                            i23 = i21;
                            if (iCharAt13 >= 55296) {
                                int i99 = iCharAt13 & 8191;
                                int i100 = 13;
                                while (true) {
                                    i24 = i98 + 1;
                                    cCharAt9 = strZzd.charAt(i98);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i99 |= (cCharAt9 & 8191) << i100;
                                    i100 += 13;
                                    i98 = i24;
                                }
                                iCharAt13 = i99 | (cCharAt9 << i100);
                            } else {
                                i24 = i98;
                            }
                            int i101 = i7 + i7 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i101];
                            str = strZzd;
                            if (obj3 instanceof Field) {
                                fieldZzx = (Field) obj3;
                            } else {
                                fieldZzx = zzx(cls2, (String) obj3);
                                objArrZze[i101] = fieldZzx;
                            }
                            i25 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzx);
                        }
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i66] = iObjectFieldOffset;
                            i66++;
                        }
                        iObjectFieldOffset3 = iObjectFieldOffset;
                        i35 = i24;
                    }
                    int i102 = i67 / 3;
                    objArr[i102 + i102 + i26] = objArrZze[i92];
                    i21 = i27;
                    i20 = iCharAt11;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx4);
                    i22 = i20;
                    iObjectFieldOffset2 = 1048575;
                    if ((i22 & 4096) == 0) {
                        i23 = i21;
                        str = strZzd;
                        i24 = i17;
                        i25 = 0;
                        if (i77 >= 18) {
                            iArr[i66] = iObjectFieldOffset;
                            i66++;
                        }
                        iObjectFieldOffset3 = iObjectFieldOffset;
                        i35 = i24;
                    }
                }
                i20 = iCharAt11;
                i21 = i92;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzx4);
                i22 = i20;
                iObjectFieldOffset2 = 1048575;
                if ((i22 & 4096) == 0) {
                }
            }
            int i103 = i67 + 1;
            iArr3[i67] = i19;
            int i104 = i67 + 2;
            iArr3[i103] = ((i22 & 512) != 0 ? 536870912 : 0) | ((i22 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | (i78 != 0 ? Integer.MIN_VALUE : 0) | (i77 << 20) | iObjectFieldOffset3;
            i67 += 3;
            iArr3[i104] = (i25 << 20) | iObjectFieldOffset2;
            zzavrVar = zzavrVar2;
            i2 = i23;
            strZzd = str;
            length = i18;
            c = 55296;
        }
        zzavr zzavrVar3 = zzavrVar;
        return new zzavi(iArr3, objArr, i3, i5, zzavrVar3.zza(), zzavrVar3.zzc(), false, iArr, i6, i63, zzavlVar, zzautVar, zzawnVar, zzatgVar, zzavaVar);
    }

    private static double zzk(Object obj, long j) {
        return ((Double) zzawx.zzf(obj, j)).doubleValue();
    }

    private static float zzl(Object obj, long j) {
        return ((Float) zzawx.zzf(obj, j)).floatValue();
    }

    private static int zzm(Object obj, long j) {
        return ((Integer) zzawx.zzf(obj, j)).intValue();
    }

    private final int zzn(int i) {
        return this.zzc[i + 2];
    }

    private static int zzo(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzp(int i) {
        return this.zzc[i + 1];
    }

    private static long zzq(Object obj, long j) {
        return ((Long) zzawx.zzf(obj, j)).longValue();
    }

    private final zzaty zzr(int i) {
        int i2 = i / 3;
        return (zzaty) this.zzd[i2 + i2 + 1];
    }

    private final zzavt zzs(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzavt zzavtVar = (zzavt) objArr[i3];
        if (zzavtVar != null) {
            return zzavtVar;
        }
        zzavt zzavtVarZzb = zzavp.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzavtVarZzb;
        return zzavtVarZzb;
    }

    private final Object zzt(Object obj, int i, Object obj2, zzawn zzawnVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzf = zzawx.zzf(obj, zzp(i) & 1048575);
        if (objZzf == null || zzr(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzu(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzv(Object obj, int i) {
        zzavt zzavtVarZzs = zzs(i);
        int iZzp = zzp(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzavtVarZzs.zzc();
        }
        Object object = zzb.getObject(obj, iZzp);
        if (zzL(object)) {
            return object;
        }
        Object objZzc = zzavtVarZzs.zzc();
        if (object != null) {
            zzavtVarZzs.zze(objZzc, object);
        }
        return objZzc;
    }

    private final Object zzw(Object obj, int i, int i2) {
        zzavt zzavtVarZzs = zzs(i2);
        if (!zzM(obj, i, i2)) {
            return zzavtVarZzs.zzc();
        }
        Object object = zzb.getObject(obj, zzp(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZzc = zzavtVarZzs.zzc();
        if (object != null) {
            zzavtVarZzs.zze(objZzc, object);
        }
        return objZzc;
    }

    private static Field zzx(Class cls, String str) {
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

    private static void zzy(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzz(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzavt zzavtVarZzs = zzs(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZzc = zzavtVarZzs.zzc();
                    zzavtVarZzs.zze(objZzc, object);
                    unsafe.putObject(obj, j, objZzc);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzC(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZzc2 = zzavtVarZzs.zzc();
                zzavtVarZzs.zze(objZzc2, object2);
                unsafe.putObject(obj, j, objZzc2);
                object2 = objZzc2;
            }
            zzavtVarZzs.zze(object2, object);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0552  */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(Object obj) {
        int i;
        int iZzB;
        int iZzB2;
        int iZzB3;
        int iZzC;
        int iZzB4;
        int iZzB5;
        int iZzB6;
        int iZzd;
        int iZzB7;
        int iZzh;
        int i2;
        int size;
        int iZzl;
        int iZzB8;
        int iZzg;
        int iZzB9;
        int iZzB10;
        int iZzC2;
        int iZze;
        int iZzB11;
        int iZzB12;
        int iZzy;
        int iZzB13;
        int iZzB14;
        int iZzd2;
        int iZzB15;
        zzavi<T> zzaviVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i4 < zzaviVar.zzc.length) {
            int iZzp = zzaviVar.zzp(i4);
            int iZzo = zzo(iZzp);
            int[] iArr = zzaviVar.zzc;
            int i8 = iArr[i4];
            int i9 = iArr[i4 + 2];
            int i10 = i9 & i3;
            if (iZzo <= 17) {
                if (i10 != i5) {
                    i6 = i10 == i3 ? 0 : unsafe.getInt(obj2, i10);
                    i5 = i10;
                }
                i = 1 << (i9 >>> 20);
            } else {
                i = 0;
            }
            int i11 = iZzp & i3;
            if (iZzo >= zzatl.DOUBLE_LIST_PACKED.zza()) {
                zzatl.SINT64_LIST_PACKED.zza();
            }
            int i12 = i7;
            long j = i11;
            switch (iZzo) {
                case 0:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB = zzasx.zzB(i8 << 3);
                        iZzh = iZzB + 8;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 1:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB2 = zzasx.zzB(i8 << 3);
                        iZzB5 = iZzB2 + 4;
                        i7 = i12 + iZzB5;
                        zzaviVar = this;
                        obj2 = obj;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    obj2 = obj;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 2:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        long j2 = unsafe.getLong(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzC(j2);
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 3:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        long j3 = unsafe.getLong(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzC(j3);
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 4:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        long j4 = unsafe.getInt(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzC(j4);
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 5:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB4 = zzasx.zzB(i8 << 3);
                        iZzB5 = iZzB4 + 8;
                        i7 = i12 + iZzB5;
                        zzaviVar = this;
                        obj2 = obj;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    obj2 = obj;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 6:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB2 = zzasx.zzB(i8 << 3);
                        iZzB5 = iZzB2 + 4;
                        i7 = i12 + iZzB5;
                        zzaviVar = this;
                        obj2 = obj;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    obj2 = obj;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 7:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB5 = zzasx.zzB(i8 << 3) + 1;
                        i7 = i12 + iZzB5;
                        zzaviVar = this;
                        obj2 = obj;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    obj2 = obj;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 8:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        int i13 = i8 << 3;
                        Object object = unsafe.getObject(obj2, j);
                        if (object instanceof zzask) {
                            iZzB6 = zzasx.zzB(i13);
                            iZzd = ((zzask) object).zzd();
                            iZzB7 = zzasx.zzB(iZzd);
                            i2 = iZzB6 + iZzB7 + iZzd;
                            i7 = i12 + i2;
                            zzaviVar = this;
                            i4 += 3;
                            i3 = 1048575;
                        } else {
                            iZzB3 = zzasx.zzB(i13);
                            iZzC = zzasx.zzA((String) object);
                            i2 = iZzB3 + iZzC;
                            i7 = i12 + i2;
                            zzaviVar = this;
                            i4 += 3;
                            i3 = 1048575;
                        }
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 9:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzh = zzavv.zzh(i8, unsafe.getObject(obj2, j), zzaviVar.zzs(i4));
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 10:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        zzask zzaskVar = (zzask) unsafe.getObject(obj2, j);
                        iZzB6 = zzasx.zzB(i8 << 3);
                        iZzd = zzaskVar.zzd();
                        iZzB7 = zzasx.zzB(iZzd);
                        i2 = iZzB6 + iZzB7 + iZzd;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 11:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        int i14 = unsafe.getInt(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzB(i14);
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 12:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        long j5 = unsafe.getInt(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzC(j5);
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 13:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB2 = zzasx.zzB(i8 << 3);
                        iZzB5 = iZzB2 + 4;
                        i7 = i12 + iZzB5;
                        zzaviVar = this;
                        obj2 = obj;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    obj2 = obj;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 14:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzB4 = zzasx.zzB(i8 << 3);
                        iZzB5 = iZzB4 + 8;
                        i7 = i12 + iZzB5;
                        zzaviVar = this;
                        obj2 = obj;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    obj2 = obj;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 15:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        int i15 = unsafe.getInt(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzB((i15 >> 31) ^ (i15 + i15));
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 16:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        long j6 = unsafe.getLong(obj2, j);
                        iZzB3 = zzasx.zzB(i8 << 3);
                        iZzC = zzasx.zzC((j6 >> 63) ^ (j6 + j6));
                        i2 = iZzB3 + iZzC;
                        i7 = i12 + i2;
                        zzaviVar = this;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    zzaviVar = this;
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 17:
                    if (zzaviVar.zzJ(obj2, i4, i5, i6, i)) {
                        iZzh = zzasx.zzy(i8, (zzavf) unsafe.getObject(obj2, j), zzaviVar.zzs(i4));
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 18:
                    iZzh = zzavv.zzd(i8, (List) unsafe.getObject(obj2, j), false);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 19:
                    iZzh = zzavv.zzb(i8, (List) unsafe.getObject(obj2, j), false);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j);
                    int i16 = zzavv.zza;
                    iZzg = list.size() == 0 ? 0 : zzavv.zzg(list) + (list.size() * zzasx.zzB(i8 << 3));
                    i7 = iZzg + i12;
                    i4 += 3;
                    i3 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj2, j);
                    int i17 = zzavv.zza;
                    size = list2.size();
                    if (size != 0) {
                        iZzl = zzavv.zzl(list2);
                        iZzB8 = zzasx.zzB(i8 << 3);
                        iZzC2 = size * iZzB8;
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj2, j);
                    int i18 = zzavv.zza;
                    size = list3.size();
                    if (size != 0) {
                        iZzl = zzavv.zzf(list3);
                        iZzB8 = zzasx.zzB(i8 << 3);
                        iZzC2 = size * iZzB8;
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 23:
                    iZzh = zzavv.zzd(i8, (List) unsafe.getObject(obj2, j), false);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 24:
                    iZzh = zzavv.zzb(i8, (List) unsafe.getObject(obj2, j), false);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj2, j);
                    int i19 = zzavv.zza;
                    int size2 = list4.size();
                    iZzh = size2 == 0 ? 0 : size2 * (zzasx.zzB(i8 << 3) + 1);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 26:
                    List list5 = (List) unsafe.getObject(obj2, j);
                    int i20 = zzavv.zza;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        iZzg = zzasx.zzB(i8 << 3) * size3;
                        if (list5 instanceof zzaun) {
                            zzaun zzaunVar = (zzaun) list5;
                            for (int i21 = 0; i21 < size3; i21++) {
                                Object objZzf = zzaunVar.zzf(i21);
                                if (objZzf instanceof zzask) {
                                    int iZzd3 = ((zzask) objZzf).zzd();
                                    iZzg += zzasx.zzB(iZzd3) + iZzd3;
                                } else {
                                    iZzg += zzasx.zzA((String) objZzf);
                                }
                            }
                        } else {
                            for (int i22 = 0; i22 < size3; i22++) {
                                Object obj3 = list5.get(i22);
                                if (obj3 instanceof zzask) {
                                    int iZzd4 = ((zzask) obj3).zzd();
                                    iZzg += zzasx.zzB(iZzd4) + iZzd4;
                                } else {
                                    iZzg += zzasx.zzA((String) obj3);
                                }
                            }
                        }
                    }
                    i7 = iZzg + i12;
                    i4 += 3;
                    i3 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj2, j);
                    zzavt zzavtVarZzs = zzaviVar.zzs(i4);
                    int i23 = zzavv.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzB9 = 0;
                    } else {
                        iZzB9 = zzasx.zzB(i8 << 3) * size4;
                        for (int i24 = 0; i24 < size4; i24++) {
                            Object obj4 = list6.get(i24);
                            if (obj4 instanceof zzaul) {
                                int iZza = ((zzaul) obj4).zza();
                                iZzB9 += zzasx.zzB(iZza) + iZza;
                            } else {
                                iZzB9 += zzasx.zzz((zzavf) obj4, zzavtVarZzs);
                            }
                        }
                    }
                    i7 = i12 + iZzB9;
                    i4 += 3;
                    i3 = 1048575;
                case 28:
                    List list7 = (List) unsafe.getObject(obj2, j);
                    int i25 = zzavv.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzB10 = 0;
                    } else {
                        iZzB10 = size5 * zzasx.zzB(i8 << 3);
                        for (int i26 = 0; i26 < list7.size(); i26++) {
                            int iZzd5 = ((zzask) list7.get(i26)).zzd();
                            iZzB10 += zzasx.zzB(iZzd5) + iZzd5;
                        }
                    }
                    i7 = i12 + iZzB10;
                    i4 += 3;
                    i3 = 1048575;
                case 29:
                    List list8 = (List) unsafe.getObject(obj2, j);
                    int i27 = zzavv.zza;
                    size = list8.size();
                    if (size != 0) {
                        iZzl = zzavv.zzk(list8);
                        iZzB8 = zzasx.zzB(i8 << 3);
                        iZzC2 = size * iZzB8;
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 30:
                    List list9 = (List) unsafe.getObject(obj2, j);
                    int i28 = zzavv.zza;
                    size = list9.size();
                    if (size != 0) {
                        iZzl = zzavv.zza(list9);
                        iZzB8 = zzasx.zzB(i8 << 3);
                        iZzC2 = size * iZzB8;
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 31:
                    iZzh = zzavv.zzb(i8, (List) unsafe.getObject(obj2, j), false);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 32:
                    iZzh = zzavv.zzd(i8, (List) unsafe.getObject(obj2, j), false);
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 33:
                    List list10 = (List) unsafe.getObject(obj2, j);
                    int i29 = zzavv.zza;
                    size = list10.size();
                    if (size != 0) {
                        iZzl = zzavv.zzi(list10);
                        iZzB8 = zzasx.zzB(i8 << 3);
                        iZzC2 = size * iZzB8;
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 34:
                    List list11 = (List) unsafe.getObject(obj2, j);
                    int i30 = zzavv.zza;
                    size = list11.size();
                    if (size != 0) {
                        iZzl = zzavv.zzj(list11);
                        iZzB8 = zzasx.zzB(i8 << 3);
                        iZzC2 = size * iZzB8;
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12 + iZzh;
                    i4 += 3;
                    i3 = 1048575;
                case 35:
                    iZze = zzavv.zze((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 36:
                    iZze = zzavv.zzc((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 37:
                    iZze = zzavv.zzg((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 38:
                    iZze = zzavv.zzl((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 39:
                    iZze = zzavv.zzf((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 40:
                    iZze = zzavv.zze((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 41:
                    iZze = zzavv.zzc((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j);
                    int i31 = zzavv.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 43:
                    iZze = zzavv.zzk((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 44:
                    iZze = zzavv.zza((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 45:
                    iZze = zzavv.zzc((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 46:
                    iZze = zzavv.zze((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 47:
                    iZze = zzavv.zzi((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 48:
                    iZze = zzavv.zzj((List) unsafe.getObject(obj2, j));
                    if (iZze > 0) {
                        iZzB11 = zzasx.zzB(i8 << 3);
                        iZzB12 = zzasx.zzB(iZze);
                        iZzB10 = iZzB11 + iZzB12 + iZze;
                        i7 = i12 + iZzB10;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j);
                    zzavt zzavtVarZzs2 = zzaviVar.zzs(i4);
                    int i32 = zzavv.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzy = 0;
                    } else {
                        iZzy = 0;
                        for (int i33 = 0; i33 < size6; i33++) {
                            iZzy += zzasx.zzy(i8, (zzavf) list13.get(i33), zzavtVarZzs2);
                        }
                    }
                    i7 = i12 + iZzy;
                    i4 += 3;
                    i3 = 1048575;
                case 50:
                    zzauz zzauzVar = (zzauz) unsafe.getObject(obj2, j);
                    if (!zzauzVar.isEmpty()) {
                        Iterator it = zzauzVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 51:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzB = zzasx.zzB(i8 << 3);
                        iZzh = iZzB + 8;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 52:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzB13 = zzasx.zzB(i8 << 3);
                        iZzh = iZzB13 + 4;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 53:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        long jZzq = zzq(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzC(jZzq);
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 54:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        long jZzq2 = zzq(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzC(jZzq2);
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 55:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        long jZzm = zzm(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzC(jZzm);
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 56:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzB = zzasx.zzB(i8 << 3);
                        iZzh = iZzB + 8;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 57:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzB13 = zzasx.zzB(i8 << 3);
                        iZzh = iZzB13 + 4;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 58:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzh = zzasx.zzB(i8 << 3) + 1;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 59:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        int i34 = i8 << 3;
                        Object object2 = unsafe.getObject(obj2, j);
                        if (object2 instanceof zzask) {
                            iZzB14 = zzasx.zzB(i34);
                            iZzd2 = ((zzask) object2).zzd();
                            iZzB15 = zzasx.zzB(iZzd2);
                            iZzh = iZzB14 + iZzB15 + iZzd2;
                            i7 = i12 + iZzh;
                            i4 += 3;
                            i3 = 1048575;
                        } else {
                            iZzl = zzasx.zzB(i34);
                            iZzC2 = zzasx.zzA((String) object2);
                            iZzh = iZzl + iZzC2;
                            i7 = i12 + iZzh;
                            i4 += 3;
                            i3 = 1048575;
                        }
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 60:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzh = zzavv.zzh(i8, unsafe.getObject(obj2, j), zzaviVar.zzs(i4));
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 61:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        zzask zzaskVar2 = (zzask) unsafe.getObject(obj2, j);
                        iZzB14 = zzasx.zzB(i8 << 3);
                        iZzd2 = zzaskVar2.zzd();
                        iZzB15 = zzasx.zzB(iZzd2);
                        iZzh = iZzB14 + iZzB15 + iZzd2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 62:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        int iZzm = zzm(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzB(iZzm);
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 63:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        long jZzm2 = zzm(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzC(jZzm2);
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 64:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzB13 = zzasx.zzB(i8 << 3);
                        iZzh = iZzB13 + 4;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 65:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzB = zzasx.zzB(i8 << 3);
                        iZzh = iZzB + 8;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 66:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        int iZzm2 = zzm(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzB((iZzm2 >> 31) ^ (iZzm2 + iZzm2));
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 67:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        long jZzq3 = zzq(obj2, j);
                        iZzl = zzasx.zzB(i8 << 3);
                        iZzC2 = zzasx.zzC((jZzq3 >> 63) ^ (jZzq3 + jZzq3));
                        iZzh = iZzl + iZzC2;
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                case 68:
                    if (zzaviVar.zzM(obj2, i8, i4)) {
                        iZzh = zzasx.zzy(i8, (zzavf) unsafe.getObject(obj2, j), zzaviVar.zzs(i4));
                        i7 = i12 + iZzh;
                        i4 += 3;
                        i3 = 1048575;
                    }
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
                default:
                    i7 = i12;
                    i4 += 3;
                    i3 = 1048575;
            }
        }
        zzawn zzawnVar = zzaviVar.zzn;
        int iZza2 = i7 + zzawnVar.zza(zzawnVar.zzd(obj2));
        if (!zzaviVar.zzh) {
            return iZza2;
        }
        zzatk zzatkVarZzb = zzaviVar.zzo.zzb(obj2);
        int iZzb = 0;
        for (int i35 = 0; i35 < zzatkVarZzb.zza.zzb(); i35++) {
            Map.Entry entryZzg = zzatkVarZzb.zza.zzg(i35);
            iZzb += zzatk.zzb((zzatj) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzatkVarZzb.zza.zzc()) {
            iZzb += zzatk.zzb((zzatj) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZzb;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int iZzp = zzp(i5);
            int[] iArr = this.zzc;
            int i6 = 1048575 & iZzp;
            int iZzo = zzo(iZzp);
            int i7 = iArr[i5];
            long j = i6;
            int iHashCode = 37;
            switch (iZzo) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzawx.zza(obj, j));
                    byte[] bArr = zzaud.zzd;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i2 = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzawx.zzb(obj, j));
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j);
                    byte[] bArr2 = zzaud.zzd;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j);
                    byte[] bArr3 = zzaud.zzd;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j);
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j);
                    byte[] bArr4 = zzaud.zzd;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j);
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 7:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzaud.zza(zzawx.zzw(obj, j));
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 8:
                    i2 = i4 * 53;
                    iFloatToIntBits = ((String) zzawx.zzf(obj, j)).hashCode();
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 9:
                    i3 = i4 * 53;
                    Object objZzf = zzawx.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i4 = i3 + iHashCode;
                    break;
                case 10:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzf(obj, j).hashCode();
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 11:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j);
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 12:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j);
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 13:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j);
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j);
                    byte[] bArr5 = zzaud.zzd;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzc(obj, j);
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzawx.zzd(obj, j);
                    byte[] bArr6 = zzaud.zzd;
                    i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i3 = i4 * 53;
                    Object objZzf2 = zzawx.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i4 = i3 + iHashCode;
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
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzf(obj, j).hashCode();
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 50:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzawx.zzf(obj, j).hashCode();
                    i4 = i2 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzk(obj, j));
                        byte[] bArr7 = zzaud.zzd;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzl(obj, j));
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr8 = zzaud.zzd;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr9 = zzaud.zzd;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr10 = zzaud.zzd;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzaud.zza(zzN(obj, j));
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = ((String) zzawx.zzf(obj, j)).hashCode();
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzawx.zzf(obj, j).hashCode();
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzawx.zzf(obj, j).hashCode();
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr11 = zzaud.zzd;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzm(obj, j);
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzq(obj, j);
                        byte[] bArr12 = zzaud.zzd;
                        i4 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzawx.zzf(obj, j).hashCode();
                        i4 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i4 * 53) + this.zzn.zzd(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzo.zzb(obj).zza.hashCode() : iHashCode2;
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final Object zzc() {
        return ((zzatu) this.zzg).zzat();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzatu) {
                zzatu zzatuVar = (zzatu) obj;
                zzatuVar.zzaF(Integer.MAX_VALUE);
                zzatuVar.zza = 0;
                zzatuVar.zzaD();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzp = zzp(i);
                int i2 = 1048575 & iZzp;
                int iZzo = zzo(iZzp);
                long j = i2;
                if (iZzo != 9) {
                    if (iZzo != 60 && iZzo != 68) {
                        switch (iZzo) {
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
                                this.zzm.zzb(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzauz) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzs(i).zzd(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzs(i).zzd(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zzf(obj);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final void zze(Object obj, Object obj2) {
        zzy(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzp = zzp(i);
            int i2 = 1048575 & iZzp;
            int[] iArr = this.zzc;
            int iZzo = zzo(iZzp);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzo) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzawx.zzo(obj, j, zzawx.zza(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzawx.zzp(obj, j, zzawx.zzb(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzawx.zzr(obj, j, zzawx.zzd(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzawx.zzr(obj, j, zzawx.zzd(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzawx.zzq(obj, j, zzawx.zzc(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzawx.zzr(obj, j, zzawx.zzd(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzawx.zzq(obj, j, zzawx.zzc(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzawx.zzm(obj, j, zzawx.zzw(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzawx.zzs(obj, j, zzawx.zzf(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzz(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzawx.zzs(obj, j, zzawx.zzf(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzawx.zzq(obj, j, zzawx.zzc(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzawx.zzq(obj, j, zzawx.zzc(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzawx.zzq(obj, j, zzawx.zzc(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzawx.zzr(obj, j, zzawx.zzd(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzawx.zzq(obj, j, zzawx.zzc(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzawx.zzr(obj, j, zzawx.zzd(obj2, j));
                        zzC(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzz(obj, obj2, i);
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
                    this.zzm.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzavv.zza;
                    zzawx.zzs(obj, j, zzava.zza(zzawx.zzf(obj, j), zzawx.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzawx.zzs(obj, j, zzawx.zzf(obj2, j));
                        zzD(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzA(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzawx.zzs(obj, j, zzawx.zzf(obj2, j));
                        zzD(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzA(obj, obj2, i);
                    break;
            }
        }
        zzavv.zzr(this.zzn, obj, obj2);
        if (this.zzh) {
            zzavv.zzq(this.zzo, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:198:0x0644 A[Catch: all -> 0x0669, TryCatch #4 {all -> 0x0669, blocks: (B:196:0x063f, B:198:0x0644, B:199:0x0649), top: B:226:0x063f }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0676 A[LOOP:4: B:213:0x0672->B:215:0x0676, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x064f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(Object obj, zzavs zzavsVar, zzatf zzatfVar) throws Throwable {
        Object obj2;
        int i;
        Object objZzt;
        Object objZzt2;
        Object obj3;
        zzavi<T> zzaviVar;
        zzatg zzatgVar;
        zzatf zzatfVar2;
        zzawn zzawnVar;
        Object objZzo;
        zzavi<T> zzaviVar2 = this;
        zzatf zzatfVar3 = zzatfVar;
        zzatfVar3.getClass();
        zzy(obj);
        zzawn zzawnVar2 = zzaviVar2.zzn;
        zzatg zzatgVar2 = zzaviVar2.zzo;
        Object objZzc = null;
        zzatk zzatkVarZzc = null;
        while (true) {
            try {
                int iZzc = zzavsVar.zzc();
                int i2 = -1;
                if (iZzc >= zzaviVar2.zze && iZzc <= zzaviVar2.zzf) {
                    int length = (zzaviVar2.zzc.length / 3) - 1;
                    int i3 = 0;
                    while (true) {
                        if (i3 <= length) {
                            int i4 = (length + i3) >>> 1;
                            int i5 = i4 * 3;
                            int i6 = zzaviVar2.zzc[i5];
                            if (iZzc == i6) {
                                i2 = i5;
                            } else if (iZzc < i6) {
                                length = i4 - 1;
                            } else {
                                i3 = i4 + 1;
                            }
                        }
                    }
                }
                if (i2 >= 0) {
                    zzatgVar = zzatgVar2;
                    zzaviVar = zzaviVar2;
                    zzatfVar2 = zzatfVar3;
                    obj3 = obj;
                    try {
                        int iZzp = zzaviVar.zzp(i2);
                        try {
                        } catch (zzaue unused) {
                            obj2 = obj3;
                            zzaviVar2 = zzaviVar;
                        }
                        switch (zzo(iZzp)) {
                            case 0:
                                zzawx.zzo(obj3, iZzp & 1048575, zzavsVar.zza());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 1:
                                zzawx.zzp(obj3, iZzp & 1048575, zzavsVar.zzb());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 2:
                                zzawx.zzr(obj3, iZzp & 1048575, zzavsVar.zzl());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 3:
                                zzawx.zzr(obj3, iZzp & 1048575, zzavsVar.zzo());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 4:
                                zzawx.zzq(obj3, iZzp & 1048575, zzavsVar.zzg());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 5:
                                zzawx.zzr(obj3, iZzp & 1048575, zzavsVar.zzk());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 6:
                                zzawx.zzq(obj3, iZzp & 1048575, zzavsVar.zzf());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 7:
                                zzawx.zzm(obj3, iZzp & 1048575, zzavsVar.zzN());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 8:
                                zzaviVar.zzB(obj3, iZzp, zzavsVar);
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 9:
                                zzavf zzavfVar = (zzavf) zzaviVar.zzv(obj3, i2);
                                zzavsVar.zzu(zzavfVar, zzaviVar.zzs(i2), zzatfVar2);
                                zzaviVar.zzE(obj3, i2, zzavfVar);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 10:
                                zzawx.zzs(obj3, iZzp & 1048575, zzavsVar.zzp());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 11:
                                zzawx.zzq(obj3, iZzp & 1048575, zzavsVar.zzj());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 12:
                                int iZze = zzavsVar.zze();
                                zzaty zzatyVarZzr = zzaviVar.zzr(i2);
                                if (zzatyVarZzr == null || zzatyVarZzr.zza(iZze)) {
                                    zzawx.zzq(obj3, iZzp & 1048575, iZze);
                                    zzaviVar.zzC(obj3, i2);
                                } else {
                                    objZzc = zzavv.zzp(obj3, iZzc, iZze, objZzc, zzawnVar2);
                                }
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                                break;
                            case 13:
                                zzawx.zzq(obj3, iZzp & 1048575, zzavsVar.zzh());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 14:
                                zzawx.zzr(obj3, iZzp & 1048575, zzavsVar.zzm());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 15:
                                zzawx.zzq(obj3, iZzp & 1048575, zzavsVar.zzi());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 16:
                                zzawx.zzr(obj3, iZzp & 1048575, zzavsVar.zzn());
                                zzaviVar.zzC(obj3, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 17:
                                zzavf zzavfVar2 = (zzavf) zzaviVar.zzv(obj3, i2);
                                zzavsVar.zzt(zzavfVar2, zzaviVar.zzs(i2), zzatfVar2);
                                zzaviVar.zzE(obj3, i2, zzavfVar2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 18:
                                zzavsVar.zzx(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 19:
                                zzavsVar.zzB(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 20:
                                zzavsVar.zzE(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 21:
                                zzavsVar.zzM(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 22:
                                zzavsVar.zzD(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 23:
                                zzavsVar.zzA(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 24:
                                zzavsVar.zzz(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 25:
                                zzavsVar.zzv(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 26:
                                if (zzH(iZzp)) {
                                    ((zzasr) zzavsVar).zzK(zzaviVar.zzm.zza(obj3, iZzp & 1048575), true);
                                } else {
                                    ((zzasr) zzavsVar).zzK(zzaviVar.zzm.zza(obj3, iZzp & 1048575), false);
                                }
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 27:
                                zzavsVar.zzF(zzaviVar.zzm.zza(obj3, iZzp & 1048575), zzaviVar.zzs(i2), zzatfVar2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 28:
                                zzavsVar.zzw(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 29:
                                zzavsVar.zzL(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 30:
                                List listZza = zzaviVar.zzm.zza(obj3, iZzp & 1048575);
                                zzavsVar.zzy(listZza);
                                Object obj4 = objZzc;
                                zzawn zzawnVar3 = zzawnVar2;
                                objZzo = zzavv.zzo(obj3, iZzc, listZza, zzaviVar.zzr(i2), obj4, zzawnVar3);
                                zzawnVar2 = zzawnVar3;
                                objZzc = objZzo;
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 31:
                                zzavsVar.zzG(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 32:
                                zzavsVar.zzH(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 33:
                                zzavsVar.zzI(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 34:
                                zzavsVar.zzJ(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 35:
                                zzavsVar.zzx(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 36:
                                zzavsVar.zzB(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 37:
                                zzavsVar.zzE(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 38:
                                zzavsVar.zzM(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 39:
                                zzavsVar.zzD(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 40:
                                zzavsVar.zzA(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 41:
                                zzavsVar.zzz(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 42:
                                zzavsVar.zzv(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 43:
                                zzavsVar.zzL(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 44:
                                List listZza2 = zzaviVar.zzm.zza(obj3, iZzp & 1048575);
                                zzavsVar.zzy(listZza2);
                                Object obj5 = objZzc;
                                zzawn zzawnVar4 = zzawnVar2;
                                try {
                                    objZzo = zzavv.zzo(obj3, iZzc, listZza2, zzaviVar.zzr(i2), obj5, zzawnVar4);
                                    zzawnVar2 = zzawnVar4;
                                    objZzc = objZzo;
                                    zzatfVar3 = zzatfVar2;
                                    zzatgVar2 = zzatgVar;
                                    zzaviVar2 = zzaviVar;
                                } catch (zzaue unused2) {
                                    objZzc = obj5;
                                    zzawnVar2 = zzawnVar4;
                                    obj2 = obj3;
                                    zzaviVar2 = zzaviVar;
                                    try {
                                        zzawnVar2.zzq(zzavsVar);
                                        if (objZzc == null) {
                                        }
                                        if (!zzawnVar2.zzp(objZzc, zzavsVar)) {
                                        }
                                        zzatfVar3 = zzatfVar2;
                                        zzatgVar2 = zzatgVar;
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    objZzc = obj5;
                                    zzawnVar2 = zzawnVar4;
                                    obj2 = obj3;
                                    zzaviVar2 = zzaviVar;
                                    i = zzaviVar2.zzk;
                                    objZzt = objZzc;
                                    while (i < zzaviVar2.zzl) {
                                    }
                                    if (objZzt != null) {
                                    }
                                    throw th;
                                }
                                break;
                            case 45:
                                zzavsVar.zzG(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 46:
                                zzavsVar.zzH(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 47:
                                zzavsVar.zzI(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 48:
                                zzavsVar.zzJ(zzaviVar.zzm.zza(obj3, iZzp & 1048575));
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 49:
                                zzavsVar.zzC(zzaviVar.zzm.zza(obj3, iZzp & 1048575), zzaviVar.zzs(i2), zzatfVar2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 50:
                                Object objZzu = zzaviVar.zzu(i2);
                                long jZzp = zzaviVar.zzp(i2) & 1048575;
                                Object objZzf = zzawx.zzf(obj3, jZzp);
                                if (objZzf == null) {
                                    objZzf = zzauz.zza().zzb();
                                    zzawx.zzs(obj3, jZzp, objZzf);
                                } else if (!((zzauz) objZzf).zze()) {
                                    Object objZzb = zzauz.zza().zzb();
                                    zzava.zza(objZzb, objZzf);
                                    zzawx.zzs(obj3, jZzp, objZzb);
                                    objZzf = objZzb;
                                }
                                throw null;
                                break;
                            case 51:
                                zzawx.zzs(obj3, iZzp & 1048575, Double.valueOf(zzavsVar.zza()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 52:
                                zzawx.zzs(obj3, iZzp & 1048575, Float.valueOf(zzavsVar.zzb()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 53:
                                zzawx.zzs(obj3, iZzp & 1048575, Long.valueOf(zzavsVar.zzl()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 54:
                                zzawx.zzs(obj3, iZzp & 1048575, Long.valueOf(zzavsVar.zzo()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 55:
                                zzawx.zzs(obj3, iZzp & 1048575, Integer.valueOf(zzavsVar.zzg()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 56:
                                zzawx.zzs(obj3, iZzp & 1048575, Long.valueOf(zzavsVar.zzk()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 57:
                                zzawx.zzs(obj3, iZzp & 1048575, Integer.valueOf(zzavsVar.zzf()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 58:
                                zzawx.zzs(obj3, iZzp & 1048575, Boolean.valueOf(zzavsVar.zzN()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 59:
                                zzaviVar.zzB(obj3, iZzp, zzavsVar);
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 60:
                                zzavf zzavfVar3 = (zzavf) zzaviVar.zzw(obj3, iZzc, i2);
                                zzavsVar.zzu(zzavfVar3, zzaviVar.zzs(i2), zzatfVar2);
                                zzaviVar.zzF(obj3, iZzc, i2, zzavfVar3);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 61:
                                zzawx.zzs(obj3, iZzp & 1048575, zzavsVar.zzp());
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 62:
                                zzawx.zzs(obj3, iZzp & 1048575, Integer.valueOf(zzavsVar.zzj()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 63:
                                int iZze2 = zzavsVar.zze();
                                zzaty zzatyVarZzr2 = zzaviVar.zzr(i2);
                                if (zzatyVarZzr2 == null || zzatyVarZzr2.zza(iZze2)) {
                                    zzawx.zzs(obj3, iZzp & 1048575, Integer.valueOf(iZze2));
                                    zzaviVar.zzD(obj3, iZzc, i2);
                                } else {
                                    objZzc = zzavv.zzp(obj3, iZzc, iZze2, objZzc, zzawnVar2);
                                }
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                                break;
                            case 64:
                                zzawx.zzs(obj3, iZzp & 1048575, Integer.valueOf(zzavsVar.zzh()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 65:
                                zzawx.zzs(obj3, iZzp & 1048575, Long.valueOf(zzavsVar.zzm()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 66:
                                zzawx.zzs(obj3, iZzp & 1048575, Integer.valueOf(zzavsVar.zzi()));
                                zzaviVar.zzD(obj3, iZzc, i2);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            case 67:
                                try {
                                    zzawx.zzs(obj3, iZzp & 1048575, Long.valueOf(zzavsVar.zzn()));
                                    zzaviVar.zzD(obj3, iZzc, i2);
                                    zzatfVar3 = zzatfVar2;
                                    zzatgVar2 = zzatgVar;
                                    zzaviVar2 = zzaviVar;
                                } catch (zzaue unused3) {
                                    obj2 = obj3;
                                    zzaviVar2 = zzaviVar;
                                    zzawnVar2.zzq(zzavsVar);
                                    if (objZzc == null) {
                                    }
                                    if (!zzawnVar2.zzp(objZzc, zzavsVar)) {
                                    }
                                    zzatfVar3 = zzatfVar2;
                                    zzatgVar2 = zzatgVar;
                                }
                                break;
                            case 68:
                                zzavf zzavfVar4 = (zzavf) zzaviVar.zzw(obj3, iZzc, i2);
                                zzavsVar.zzt(zzavfVar4, zzaviVar.zzs(i2), zzatfVar2);
                                zzaviVar.zzF(obj3, iZzc, i2, zzavfVar4);
                                zzatfVar3 = zzatfVar2;
                                zzatgVar2 = zzatgVar;
                                zzaviVar2 = zzaviVar;
                            default:
                                if (objZzc == null) {
                                    try {
                                        objZzc = zzawnVar2.zzc(obj3);
                                    } catch (zzaue unused4) {
                                        obj2 = obj3;
                                        zzaviVar2 = zzaviVar;
                                        zzawnVar2.zzq(zzavsVar);
                                        if (objZzc == null) {
                                            objZzc = zzawnVar2.zzc(obj2);
                                        }
                                        if (!zzawnVar2.zzp(objZzc, zzavsVar)) {
                                            objZzt2 = objZzc;
                                            for (int i7 = zzaviVar2.zzk; i7 < zzaviVar2.zzl; i7++) {
                                                objZzt2 = zzaviVar2.zzt(obj2, zzaviVar2.zzj[i7], objZzt2, zzawnVar2, obj);
                                            }
                                            if (objZzt2 == null) {
                                            }
                                        }
                                        zzatfVar3 = zzatfVar2;
                                        zzatgVar2 = zzatgVar;
                                    }
                                }
                                if (zzawnVar2.zzp(objZzc, zzavsVar)) {
                                    zzatfVar3 = zzatfVar2;
                                    zzatgVar2 = zzatgVar;
                                    zzaviVar2 = zzaviVar;
                                } else {
                                    int i8 = zzaviVar.zzk;
                                    objZzt2 = objZzc;
                                    while (i8 < zzaviVar.zzl) {
                                        Object obj6 = obj3;
                                        objZzt2 = zzaviVar.zzt(obj6, zzaviVar.zzj[i8], objZzt2, zzawnVar2, obj);
                                        i8++;
                                        obj3 = obj6;
                                    }
                                    obj2 = obj3;
                                }
                                break;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    int i9 = zzaviVar2.zzk;
                    objZzt2 = objZzc;
                    while (i9 < zzaviVar2.zzl) {
                        objZzt2 = zzaviVar2.zzt(obj, zzaviVar2.zzj[i9], objZzt2, zzawnVar2, obj);
                        i9++;
                        zzaviVar2 = zzaviVar2;
                    }
                    obj2 = obj;
                } else {
                    zzavi<T> zzaviVar3 = zzaviVar2;
                    obj3 = obj;
                    try {
                        Object objZzd = !zzaviVar3.zzh ? null : zzatgVar2.zzd(zzatfVar3, zzaviVar3.zzg, iZzc);
                        if (objZzd == null) {
                            zzatgVar = zzatgVar2;
                            obj2 = obj3;
                            zzatfVar2 = zzatfVar3;
                            try {
                                zzawnVar2.zzq(zzavsVar);
                                if (objZzc == null) {
                                    try {
                                        objZzc = zzawnVar2.zzc(obj2);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        zzaviVar2 = zzaviVar3;
                                        i = zzaviVar2.zzk;
                                        objZzt = objZzc;
                                        while (i < zzaviVar2.zzl) {
                                        }
                                        if (objZzt != null) {
                                        }
                                        throw th;
                                    }
                                }
                                try {
                                    if (zzawnVar2.zzp(objZzc, zzavsVar)) {
                                        zzaviVar2 = zzaviVar3;
                                        zzatfVar3 = zzatfVar2;
                                        zzatgVar2 = zzatgVar;
                                    } else {
                                        int i10 = zzaviVar3.zzk;
                                        objZzt2 = objZzc;
                                        while (i10 < zzaviVar3.zzl) {
                                            zzavi<T> zzaviVar4 = zzaviVar3;
                                            objZzt2 = zzaviVar4.zzt(obj2, zzaviVar3.zzj[i10], objZzt2, zzawnVar2, obj);
                                            i10++;
                                            zzaviVar3 = zzaviVar4;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    obj3 = obj2;
                                    zzaviVar = zzaviVar3;
                                    obj2 = obj3;
                                    zzaviVar2 = zzaviVar;
                                    i = zzaviVar2.zzk;
                                    objZzt = objZzc;
                                    while (i < zzaviVar2.zzl) {
                                    }
                                    if (objZzt != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                zzaviVar = zzaviVar3;
                                zzaviVar2 = zzaviVar;
                                i = zzaviVar2.zzk;
                                objZzt = objZzc;
                                while (i < zzaviVar2.zzl) {
                                }
                                if (objZzt != null) {
                                }
                                throw th;
                            }
                        } else if (zzatkVarZzc == null) {
                            try {
                                zzatkVarZzc = zzatgVar2.zzc(obj3);
                                zzatk zzatkVar = zzatkVarZzc;
                                zzawnVar = zzawnVar2;
                                try {
                                    objZzc = zzatgVar2.zze(obj3, zzavsVar, objZzd, zzatfVar3, zzatkVar, objZzc, zzawnVar);
                                    zzatkVarZzc = zzatkVar;
                                    zzawnVar2 = zzawnVar;
                                    zzatgVar = zzatgVar2;
                                    zzatfVar2 = zzatfVar3;
                                    zzaviVar2 = zzaviVar3;
                                    zzatfVar3 = zzatfVar2;
                                    zzatgVar2 = zzatgVar;
                                } catch (Throwable th7) {
                                    th = th7;
                                    obj2 = obj3;
                                    zzawnVar2 = zzawnVar;
                                    zzaviVar2 = zzaviVar3;
                                    i = zzaviVar2.zzk;
                                    objZzt = objZzc;
                                    while (i < zzaviVar2.zzl) {
                                    }
                                    if (objZzt != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                obj2 = obj3;
                                zzaviVar2 = zzaviVar3;
                                i = zzaviVar2.zzk;
                                objZzt = objZzc;
                                while (i < zzaviVar2.zzl) {
                                }
                                if (objZzt != null) {
                                }
                                throw th;
                            }
                        } else {
                            zzatk zzatkVar2 = zzatkVarZzc;
                            zzawnVar = zzawnVar2;
                            objZzc = zzatgVar2.zze(obj3, zzavsVar, objZzd, zzatfVar3, zzatkVar2, objZzc, zzawnVar);
                            zzatkVarZzc = zzatkVar2;
                            zzawnVar2 = zzawnVar;
                            zzatgVar = zzatgVar2;
                            zzatfVar2 = zzatfVar3;
                            zzaviVar2 = zzaviVar3;
                            zzatfVar3 = zzatfVar2;
                            zzatgVar2 = zzatgVar;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                obj2 = obj;
            }
            i = zzaviVar2.zzk;
            objZzt = objZzc;
            while (i < zzaviVar2.zzl) {
                objZzt = zzaviVar2.zzt(obj2, zzaviVar2.zzj[i], objZzt, zzawnVar2, obj);
                i++;
                zzaviVar2 = this;
            }
            if (objZzt != null) {
                zzawnVar2.zzn(obj2, objZzt);
            }
            throw th;
        }
        if (objZzt2 == null) {
            zzawnVar2.zzn(obj2, objZzt2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavt
    public final boolean zzg(Object obj, Object obj2) {
        boolean zZzt;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzp = zzp(i);
            long j = iZzp & 1048575;
            switch (zzo(iZzp)) {
                case 0:
                    if (!zzG(obj, obj2, i) || Double.doubleToLongBits(zzawx.zza(obj, j)) != Double.doubleToLongBits(zzawx.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzG(obj, obj2, i) || Float.floatToIntBits(zzawx.zzb(obj, j)) != Float.floatToIntBits(zzawx.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzG(obj, obj2, i) || zzawx.zzd(obj, j) != zzawx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzG(obj, obj2, i) || zzawx.zzd(obj, j) != zzawx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzG(obj, obj2, i) || zzawx.zzc(obj, j) != zzawx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzG(obj, obj2, i) || zzawx.zzd(obj, j) != zzawx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzG(obj, obj2, i) || zzawx.zzc(obj, j) != zzawx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzG(obj, obj2, i) || zzawx.zzw(obj, j) != zzawx.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzG(obj, obj2, i) || !zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzG(obj, obj2, i) || !zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzG(obj, obj2, i) || !zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzG(obj, obj2, i) || zzawx.zzc(obj, j) != zzawx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzG(obj, obj2, i) || zzawx.zzc(obj, j) != zzawx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzG(obj, obj2, i) || zzawx.zzc(obj, j) != zzawx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzG(obj, obj2, i) || zzawx.zzd(obj, j) != zzawx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzG(obj, obj2, i) || zzawx.zzc(obj, j) != zzawx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzG(obj, obj2, i) || zzawx.zzd(obj, j) != zzawx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzG(obj, obj2, i) || !zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
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
                    zZzt = zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j));
                    break;
                case 50:
                    zZzt = zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j));
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
                    long jZzn = zzn(i) & 1048575;
                    if (zzawx.zzc(obj, jZzn) != zzawx.zzc(obj2, jZzn) || !zzavv.zzt(zzawx.zzf(obj, j), zzawx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzt) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008f  */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzh(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr2[i6];
            int iZzp = zzp(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i4) {
                if (i9 != 1048575) {
                    i5 = zzb.getInt(obj, i9);
                }
                i2 = i5;
                i = i9;
            } else {
                i = i4;
                i2 = i5;
            }
            Object obj2 = obj;
            if ((268435456 & iZzp) != 0 && !zzJ(obj2, i6, i, i2, i10)) {
                return false;
            }
            int iZzo = zzo(iZzp);
            if (iZzo == 9 || iZzo == 17) {
                if (zzJ(obj2, i6, i, i2, i10) && !zzK(obj2, iZzp, zzs(i6))) {
                    return false;
                }
            } else if (iZzo == 27) {
                List list = (List) zzawx.zzf(obj2, iZzp & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzavt zzavtVarZzs = zzs(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzavtVarZzs.zzh(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (iZzo == 60 || iZzo == 68) {
                if (zzM(obj2, i7, i6) && !zzK(obj2, iZzp, zzs(i6))) {
                    return false;
                }
            } else if (iZzo != 49) {
                if (iZzo == 50 && !((zzauz) zzawx.zzf(obj2, iZzp & 1048575)).isEmpty()) {
                    throw null;
                }
            }
            i3++;
            obj = obj2;
            i4 = i;
            i5 = i2;
        }
        return !this.zzh || this.zzo.zzb(obj).zzj();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.android.libraries.places.internal.zzavt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(Object obj, zzasy zzasyVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        Map.Entry entry2;
        int i;
        int i2;
        int i3;
        int i4;
        zzavi<T> zzaviVar = this;
        if (zzaviVar.zzh) {
            zzatk zzatkVarZzb = zzaviVar.zzo.zzb(obj);
            if (zzatkVarZzb.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzatkVarZzb.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        }
        int[] iArr = zzaviVar.zzc;
        Unsafe unsafe = zzb;
        int i5 = 0;
        int i6 = 1048575;
        int i7 = 0;
        while (i5 < iArr.length) {
            int iZzp = zzaviVar.zzp(i5);
            int[] iArr2 = zzaviVar.zzc;
            int iZzo = zzo(iZzp);
            int i8 = iArr2[i5];
            if (iZzo <= 17) {
                int i9 = iArr2[i5 + 2];
                int i10 = i9 & 1048575;
                if (i10 != i6) {
                    i4 = 1;
                    i7 = i10 == 1048575 ? 0 : unsafe.getInt(obj, i10);
                    i6 = i10;
                } else {
                    i4 = 1;
                }
                entry2 = entry;
                i = i6;
                i2 = i7;
                i3 = i4 << (i9 >>> 20);
            } else {
                entry2 = entry;
                i = i6;
                i2 = i7;
                i3 = 0;
            }
            while (entry2 != null && zzaviVar.zzo.zza(entry2) <= i8) {
                zzaviVar.zzo.zzj(zzasyVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzp & 1048575;
            switch (iZzo) {
                case 0:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzf(i8, zzawx.zza(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 1:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzo(i8, zzawx.zzb(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 2:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 3:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzK(i8, unsafe.getLong(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 4:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 5:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 6:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 7:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzb(i8, zzawx.zzw(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 8:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzO(i8, unsafe.getObject(obj, j), zzasyVar);
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 9:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzv(i8, unsafe.getObject(obj, j), zzaviVar.zzs(i5));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 10:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzd(i8, (zzask) unsafe.getObject(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 11:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzI(i8, unsafe.getInt(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 12:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 13:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzx(i8, unsafe.getInt(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 14:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzz(i8, unsafe.getLong(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 15:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzB(i8, unsafe.getInt(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 16:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzD(i8, unsafe.getLong(obj, j));
                    }
                    zzaviVar = this;
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 17:
                    if (zzaviVar.zzJ(obj, i5, i, i2, i3)) {
                        zzasyVar.zzq(i8, unsafe.getObject(obj, j), zzaviVar.zzs(i5));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 18:
                    zzavv.zzv(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 19:
                    zzavv.zzz(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 20:
                    zzavv.zzB(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 21:
                    zzavv.zzH(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 22:
                    zzavv.zzA(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 23:
                    zzavv.zzy(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 24:
                    zzavv.zzx(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 25:
                    zzavv.zzu(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 26:
                    int i11 = zzaviVar.zzc[i5];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzavv.zza;
                    if (list != null && !list.isEmpty()) {
                        zzasyVar.zzH(i11, list);
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                    break;
                case 27:
                    int i13 = zzaviVar.zzc[i5];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzavt zzavtVarZzs = zzaviVar.zzs(i5);
                    int i14 = zzavv.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            zzasyVar.zzv(i13, list2.get(i15), zzavtVarZzs);
                        }
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                    break;
                case 28:
                    int i16 = zzaviVar.zzc[i5];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzavv.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzasyVar.zze(i16, list3);
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                    break;
                case 29:
                    zzavv.zzG(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 30:
                    zzavv.zzw(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 31:
                    zzavv.zzC(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 32:
                    zzavv.zzD(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 33:
                    zzavv.zzE(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 34:
                    zzavv.zzF(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, false);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 35:
                    zzavv.zzv(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 36:
                    zzavv.zzz(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 37:
                    zzavv.zzB(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 38:
                    zzavv.zzH(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 39:
                    zzavv.zzA(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 40:
                    zzavv.zzy(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 41:
                    zzavv.zzx(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 42:
                    zzavv.zzu(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 43:
                    zzavv.zzG(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 44:
                    zzavv.zzw(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 45:
                    zzavv.zzC(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 46:
                    zzavv.zzD(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 47:
                    zzavv.zzE(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 48:
                    zzavv.zzF(zzaviVar.zzc[i5], (List) unsafe.getObject(obj, j), zzasyVar, true);
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 49:
                    int i18 = zzaviVar.zzc[i5];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzavt zzavtVarZzs2 = zzaviVar.zzs(i5);
                    int i19 = zzavv.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zzasyVar.zzq(i18, list4.get(i20), zzavtVarZzs2);
                        }
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 51:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzf(i8, zzk(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 52:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzo(i8, zzl(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 53:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzt(i8, zzq(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 54:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzK(i8, zzq(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 55:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzr(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 56:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzm(i8, zzq(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 57:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzk(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 58:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzb(i8, zzN(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 59:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzO(i8, unsafe.getObject(obj, j), zzasyVar);
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 60:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzv(i8, unsafe.getObject(obj, j), zzaviVar.zzs(i5));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 61:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzd(i8, (zzask) unsafe.getObject(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 62:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzI(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 63:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzi(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 64:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzx(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 65:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzz(i8, zzq(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 66:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzB(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 67:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzD(i8, zzq(obj, j));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                case 68:
                    if (zzaviVar.zzM(obj, i8, i5)) {
                        zzasyVar.zzq(i8, unsafe.getObject(obj, j), zzaviVar.zzs(i5));
                    }
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
                default:
                    i5 += 3;
                    i7 = i2;
                    i6 = i;
                    entry = entry2;
            }
        }
        while (entry != null) {
            zzaviVar.zzo.zzj(zzasyVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zzawn zzawnVar = zzaviVar.zzn;
        zzawnVar.zzs(zzawnVar.zzd(obj), zzasyVar);
    }
}
