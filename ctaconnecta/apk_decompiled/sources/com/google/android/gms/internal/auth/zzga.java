package com.google.android.gms.internal.auth;

import com.google.android.gms.drive.DriveFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* loaded from: classes3.dex */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfxVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, zzl(i2) & 1048575, i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzo(i) & 1048575, obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzo(i2) & 1048575, obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        return zzE(obj, i) == zzE(obj2, i);
    }

    private final boolean zzE(Object obj, int i) {
        int iZzl = zzl(i);
        long j = iZzl & 1048575;
        if (j != 1048575) {
            return (zzhj.zzc(obj, j) & (1 << (iZzl >>> 20))) != 0;
        }
        int iZzo = zzo(i);
        long j2 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0;
            case 2:
                return zzhj.zzd(obj, j2) != 0;
            case 3:
                return zzhj.zzd(obj, j2) != 0;
            case 4:
                return zzhj.zzc(obj, j2) != 0;
            case 5:
                return zzhj.zzd(obj, j2) != 0;
            case 6:
                return zzhj.zzc(obj, j2) != 0;
            case 7:
                return zzhj.zzt(obj, j2);
            case 8:
                Object objZzf = zzhj.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzef) {
                    return !zzef.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhj.zzf(obj, j2) != null;
            case 10:
                return !zzef.zzb.equals(zzhj.zzf(obj, j2));
            case 11:
                return zzhj.zzc(obj, j2) != 0;
            case 12:
                return zzhj.zzc(obj, j2) != 0;
            case 13:
                return zzhj.zzc(obj, j2) != 0;
            case 14:
                return zzhj.zzd(obj, j2) != 0;
            case 15:
                return zzhj.zzc(obj, j2) != 0;
            case 16:
                return zzhj.zzd(obj, j2) != 0;
            case 17:
                return zzhj.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzE(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        return zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzhaVarZzd = zzha.zzd();
        zzevVar.zzc = zzhaVarZzd;
        return zzhaVarZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static zzga zzj(Class cls, zzfu zzfuVar, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
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
        zzgh zzghVar;
        int i18;
        int i19;
        int i20;
        String str;
        int i21;
        int i22;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Field fieldZzv;
        char cCharAt9;
        int i23;
        int i24;
        Object obj;
        Field fieldZzv2;
        Object obj2;
        Field fieldZzv3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        if (!(zzfuVar instanceof zzgh)) {
            throw null;
        }
        zzgh zzghVar2 = (zzgh) zzfuVar;
        String strZzd = zzghVar2.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i29 = 1;
            while (true) {
                i = i29 + 1;
                if (strZzd.charAt(i29) < 55296) {
                    break;
                }
                i29 = i;
            }
        } else {
            i = 1;
        }
        int i30 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i31 = iCharAt2 & 8191;
            int i32 = 13;
            while (true) {
                i28 = i30 + 1;
                cCharAt13 = strZzd.charAt(i30);
                if (cCharAt13 < 55296) {
                    break;
                }
                i31 |= (cCharAt13 & 8191) << i32;
                i32 += 13;
                i30 = i28;
            }
            iCharAt2 = i31 | (cCharAt13 << i32);
            i30 = i28;
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
            int i33 = i30 + 1;
            int iCharAt3 = strZzd.charAt(i30);
            if (iCharAt3 >= 55296) {
                int i34 = iCharAt3 & 8191;
                int i35 = 13;
                while (true) {
                    i15 = i33 + 1;
                    cCharAt8 = strZzd.charAt(i33);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt8 & 8191) << i35;
                    i35 += 13;
                    i33 = i15;
                }
                iCharAt3 = i34 | (cCharAt8 << i35);
                i33 = i15;
            }
            int i36 = i33 + 1;
            int iCharAt4 = strZzd.charAt(i33);
            if (iCharAt4 >= 55296) {
                int i37 = iCharAt4 & 8191;
                int i38 = 13;
                while (true) {
                    i14 = i36 + 1;
                    cCharAt7 = strZzd.charAt(i36);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt7 & 8191) << i38;
                    i38 += 13;
                    i36 = i14;
                }
                iCharAt4 = i37 | (cCharAt7 << i38);
                i36 = i14;
            }
            int i39 = i36 + 1;
            int iCharAt5 = strZzd.charAt(i36);
            if (iCharAt5 >= 55296) {
                int i40 = iCharAt5 & 8191;
                int i41 = 13;
                while (true) {
                    i13 = i39 + 1;
                    cCharAt6 = strZzd.charAt(i39);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt6 & 8191) << i41;
                    i41 += 13;
                    i39 = i13;
                }
                iCharAt5 = i40 | (cCharAt6 << i41);
                i39 = i13;
            }
            int i42 = i39 + 1;
            int iCharAt6 = strZzd.charAt(i39);
            if (iCharAt6 >= 55296) {
                int i43 = iCharAt6 & 8191;
                int i44 = 13;
                while (true) {
                    i12 = i42 + 1;
                    cCharAt5 = strZzd.charAt(i42);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt5 & 8191) << i44;
                    i44 += 13;
                    i42 = i12;
                }
                iCharAt6 = i43 | (cCharAt5 << i44);
                i42 = i12;
            }
            int i45 = i42 + 1;
            iCharAt = strZzd.charAt(i42);
            if (iCharAt >= 55296) {
                int i46 = iCharAt & 8191;
                int i47 = 13;
                while (true) {
                    i11 = i45 + 1;
                    cCharAt4 = strZzd.charAt(i45);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt4 & 8191) << i47;
                    i47 += 13;
                    i45 = i11;
                }
                iCharAt = i46 | (cCharAt4 << i47);
                i45 = i11;
            }
            int i48 = i45 + 1;
            int iCharAt7 = strZzd.charAt(i45);
            if (iCharAt7 >= 55296) {
                int i49 = iCharAt7 & 8191;
                int i50 = 13;
                while (true) {
                    i10 = i48 + 1;
                    cCharAt3 = strZzd.charAt(i48);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt3 & 8191) << i50;
                    i50 += 13;
                    i48 = i10;
                }
                iCharAt7 = i49 | (cCharAt3 << i50);
                i48 = i10;
            }
            int i51 = i48 + 1;
            int iCharAt8 = strZzd.charAt(i48);
            if (iCharAt8 >= 55296) {
                int i52 = iCharAt8 & 8191;
                int i53 = 13;
                while (true) {
                    i9 = i51 + 1;
                    cCharAt2 = strZzd.charAt(i51);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt2 & 8191) << i53;
                    i53 += 13;
                    i51 = i9;
                }
                iCharAt8 = i52 | (cCharAt2 << i53);
                i51 = i9;
            }
            int i54 = i51 + 1;
            int iCharAt9 = strZzd.charAt(i51);
            if (iCharAt9 >= 55296) {
                int i55 = iCharAt9 & 8191;
                int i56 = 13;
                while (true) {
                    i8 = i54 + 1;
                    cCharAt = strZzd.charAt(i54);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i54 = i8;
                }
                iCharAt9 = i55 | (cCharAt << i56);
                i54 = i8;
            }
            i2 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i57 = iCharAt7;
            i3 = iCharAt5;
            i4 = i57;
            iArr = iArr2;
            i5 = iCharAt6;
            i6 = iCharAt9;
            i7 = iCharAt3;
            i30 = i54;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzghVar2.zze();
        Class<?> cls2 = zzghVar2.zza().getClass();
        int i58 = i6 + i4;
        int i59 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i59];
        int i60 = i6;
        int i61 = i58;
        int i62 = 0;
        int i63 = 0;
        while (i30 < length) {
            int i64 = i30 + 1;
            int iCharAt10 = strZzd.charAt(i30);
            if (iCharAt10 >= c) {
                int i65 = iCharAt10 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i27 = i66 + 1;
                    cCharAt12 = strZzd.charAt(i66);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i65 |= (cCharAt12 & 8191) << i67;
                    i67 += 13;
                    i66 = i27;
                }
                iCharAt10 = i65 | (cCharAt12 << i67);
                i16 = i27;
            } else {
                i16 = i64;
            }
            int i68 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c) {
                int i69 = iCharAt11 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i26 = i70 + 1;
                    cCharAt11 = strZzd.charAt(i70);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i71;
                    i71 += 13;
                    i70 = i26;
                }
                iCharAt11 = i69 | (cCharAt11 << i71);
                i17 = i26;
            } else {
                i17 = i68;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i62] = i63;
                i62++;
            }
            int i72 = iCharAt11 & 255;
            if (i72 >= 51) {
                int i73 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                zzghVar = zzghVar2;
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i74 = iCharAt12 & 8191;
                    int i75 = 13;
                    while (true) {
                        i25 = i73 + 1;
                        cCharAt10 = strZzd.charAt(i73);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i74 |= (cCharAt10 & 8191) << i75;
                        i75 += 13;
                        i73 = i25;
                        c2 = 55296;
                    }
                    iCharAt12 = i74 | (cCharAt10 << i75);
                    i73 = i25;
                }
                int i76 = i72 - 51;
                i18 = length;
                if (i76 == 9 || i76 == 17) {
                    int i77 = i63 / 3;
                    i24 = i2 + 1;
                    objArr[i77 + i77 + 1] = objArrZze[i2];
                } else {
                    if (i76 == 12 && (zzghVar.zzc() == 1 || (iCharAt11 & 2048) != 0)) {
                        int i78 = i63 / 3;
                        i24 = i2 + 1;
                        objArr[i78 + i78 + 1] = objArrZze[i2];
                    }
                    int i79 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i79];
                    if (obj instanceof Field) {
                        fieldZzv2 = zzv(cls2, (String) obj);
                        objArrZze[i79] = fieldZzv2;
                    } else {
                        fieldZzv2 = (Field) obj;
                    }
                    i19 = iCharAt10;
                    int i80 = i73;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv2);
                    int i81 = i79 + 1;
                    obj2 = objArrZze[i81];
                    if (obj2 instanceof Field) {
                        fieldZzv3 = zzv(cls2, (String) obj2);
                        objArrZze[i81] = fieldZzv3;
                    } else {
                        fieldZzv3 = (Field) obj2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzv3);
                    str = strZzd;
                    i30 = i80;
                    i22 = 0;
                }
                i2 = i24;
                int i792 = iCharAt12 + iCharAt12;
                obj = objArrZze[i792];
                if (obj instanceof Field) {
                }
                i19 = iCharAt10;
                int i802 = i73;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzv2);
                int i812 = i792 + 1;
                obj2 = objArrZze[i812];
                if (obj2 instanceof Field) {
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzv3);
                str = strZzd;
                i30 = i802;
                i22 = 0;
            } else {
                zzghVar = zzghVar2;
                i18 = length;
                i19 = iCharAt10;
                int i82 = i2 + 1;
                Field fieldZzv4 = zzv(cls2, (String) objArrZze[i2]);
                if (i72 == 9 || i72 == 17) {
                    i20 = i82;
                    int i83 = i63 / 3;
                    objArr[i83 + i83 + 1] = fieldZzv4.getType();
                } else {
                    if (i72 == 27 || i72 == 49) {
                        int i84 = i63 / 3;
                        i23 = i2 + 2;
                        objArr[i84 + i84 + 1] = objArrZze[i82];
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        i20 = i82;
                        if (zzghVar.zzc() == 1 || (iCharAt11 & 2048) != 0) {
                            int i85 = i63 / 3;
                            i23 = i2 + 2;
                            objArr[i85 + i85 + 1] = objArrZze[i20];
                        }
                    } else if (i72 == 50) {
                        int i86 = i60 + 1;
                        iArr[i60] = i63;
                        int i87 = i63 / 3;
                        i20 = i2 + 2;
                        int i88 = i87 + i87;
                        objArr[i88] = objArrZze[i82];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr[i88 + 1] = objArrZze[i20];
                            i20 = i2 + 3;
                        }
                        i60 = i86;
                    } else {
                        i20 = i82;
                    }
                    i20 = i23;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzv4);
                int iObjectFieldOffset4 = 1048575;
                if ((iCharAt11 & 4096) == 0 || i72 > 17) {
                    str = strZzd;
                    i21 = i17;
                    i22 = 0;
                } else {
                    int i89 = i17 + 1;
                    int iCharAt13 = strZzd.charAt(i17);
                    if (iCharAt13 >= 55296) {
                        int i90 = iCharAt13 & 8191;
                        int i91 = 13;
                        while (true) {
                            i21 = i89 + 1;
                            cCharAt9 = strZzd.charAt(i89);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i90 |= (cCharAt9 & 8191) << i91;
                            i91 += 13;
                            i89 = i21;
                        }
                        iCharAt13 = i90 | (cCharAt9 << i91);
                    } else {
                        i21 = i89;
                    }
                    int i92 = i7 + i7 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i92];
                    str = strZzd;
                    if (obj3 instanceof Field) {
                        fieldZzv = (Field) obj3;
                    } else {
                        fieldZzv = zzv(cls2, (String) obj3);
                        objArrZze[i92] = fieldZzv;
                    }
                    i22 = iCharAt13 % 32;
                    iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzv);
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i61] = iObjectFieldOffset3;
                    i61++;
                }
                iObjectFieldOffset = iObjectFieldOffset3;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                i30 = i21;
                i2 = i20;
            }
            int i93 = i63 + 1;
            iArr3[i63] = i19;
            int i94 = i63 + 2;
            iArr3[i93] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i72 << 20) | iObjectFieldOffset;
            i63 += 3;
            iArr3[i94] = (i22 << 20) | iObjectFieldOffset2;
            zzghVar2 = zzghVar;
            strZzd = str;
            length = i18;
            c = 55296;
        }
        zzgh zzghVar3 = zzghVar2;
        return new zzga(iArr3, objArr, i3, i5, zzghVar3.zza(), zzghVar3.zzc(), false, iArr, i6, i58, zzgcVar, zzflVar, zzgzVar, zzemVar, zzfsVar);
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
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

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgiVar = (zzgi) this.zzd[i3];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarZzb = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzgiVarZzb;
        return zzgiVarZzb;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzgiVarZzr = zzr(i);
        int iZzo = zzo(i) & 1048575;
        if (!zzE(obj, i)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, iZzo);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzgiVarZzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i2) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private static Field zzv(Class cls, String str) {
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

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzE(obj, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzz(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzI(obj, i2, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzA(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i) {
        int iZzl = zzl(i);
        long j = 1048575 & iZzl;
        if (j == 1048575) {
            return;
        }
        zzhj.zzn(obj, j, (1 << (iZzl >>> 20)) | zzhj.zzc(obj, j));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzo = zzo(i4);
            int i5 = this.zzc[i4];
            long j = 1048575 & iZzo;
            int iHashCode = 37;
            switch (zzn(iZzo)) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j));
                    byte[] bArr = zzfa.zzd;
                    i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i2 = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j));
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr2 = zzfa.zzd;
                    i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr3 = zzfa.zzd;
                    i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr4 = zzfa.zzd;
                    i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 7:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzfa.zza(zzhj.zzt(obj, j));
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 8:
                    i2 = i3 * 53;
                    iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zzhj.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr5 = zzfa.zzd;
                    i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr6 = zzfa.zzd;
                    i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object objZzf2 = zzhj.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
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
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 50:
                    i2 = i3 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i3 = i2 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzI(obj, i5, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j)).floatValue());
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzI(obj, i5, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr8 = zzfa.zzd;
                        i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzI(obj, i5, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr9 = zzfa.zzd;
                        i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzI(obj, i5, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr10 = zzfa.zzd;
                        i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j)).booleanValue());
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzI(obj, i5, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr11 = zzfa.zzd;
                        i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzI(obj, i5, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr12 = zzfa.zzd;
                        i3 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzI(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i3 = i2 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return (i3 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0a00 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:621:0x0c64 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:660:0x0a11 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:662:0x0c75 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zzb(Object obj, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        int i4;
        Unsafe unsafe;
        Object obj2;
        int i5;
        int iZzm;
        int i6;
        byte[] bArr2;
        int i7;
        int i8;
        zzdt zzdtVar2;
        int i9;
        int i10;
        zzdt zzdtVar3;
        int i11;
        int i12;
        int iZzk;
        zzdt zzdtVar4;
        int iZza;
        int i13;
        int iZzh;
        int i14;
        zzga<T> zzgaVar;
        int iZzh2;
        int i15;
        int iZzf;
        int i16;
        int iZzj;
        int i17;
        int i18;
        int iZzh3;
        int i19;
        int i20;
        Unsafe unsafe2;
        Object obj3;
        int i21;
        Unsafe unsafe3;
        byte[] bArr3;
        Object obj4;
        int i22;
        zzdt zzdtVar5;
        int iZzk2;
        int i23;
        Unsafe unsafe4;
        Object obj5;
        int i24;
        zzga<T> zzgaVar2 = this;
        Object obj6 = obj;
        byte[] bArr4 = bArr;
        int i25 = i2;
        zzdt zzdtVar6 = zzdtVar;
        zzw(obj6);
        Unsafe unsafe5 = zzb;
        int i26 = 0;
        int iZzg = i;
        int i27 = -1;
        int i28 = 0;
        int i29 = 0;
        int i30 = 1048575;
        int i31 = 0;
        while (true) {
            if (iZzg < i25) {
                int iZzi = iZzg + 1;
                int i32 = bArr4[iZzg];
                if (i32 < 0) {
                    iZzi = zzdu.zzi(i32, bArr4, iZzi, zzdtVar6);
                    i32 = zzdtVar6.zza;
                }
                int i33 = iZzi;
                int i34 = i32;
                iZzg = i33;
                int i35 = i34 >>> 3;
                if (i35 > i27) {
                    iZzm = (i35 < zzgaVar2.zze || i35 > zzgaVar2.zzf) ? -1 : zzgaVar2.zzm(i35, i28 / 3);
                    if (iZzm != -1) {
                        i4 = i3;
                        unsafe = unsafe5;
                        i6 = i34;
                        bArr2 = bArr4;
                        i7 = i30;
                        i8 = 0;
                        zzdtVar2 = zzdtVar6;
                        obj2 = obj6;
                    } else {
                        int i36 = i34 & 7;
                        int[] iArr = zzgaVar2.zzc;
                        int i37 = iArr[iZzm + 1];
                        int i38 = iZzm;
                        int iZzn = zzn(i37);
                        int i39 = i34;
                        long j = i37 & 1048575;
                        if (iZzn <= 17) {
                            int i40 = iArr[i38 + 2];
                            int i41 = 1 << (i40 >>> 20);
                            int i42 = i40 & 1048575;
                            if (i42 != i30) {
                                int i43 = 1048575;
                                if (i30 != 1048575) {
                                    unsafe5.putInt(obj6, i30, i31);
                                    i43 = 1048575;
                                }
                                i31 = i42 == i43 ? 0 : unsafe5.getInt(obj6, i42);
                                i30 = i42;
                            }
                            switch (iZzn) {
                                case 0:
                                    zzdtVar6 = zzdtVar;
                                    i19 = iZzg;
                                    i8 = i38;
                                    i20 = i31;
                                    unsafe2 = unsafe5;
                                    int i44 = i30;
                                    obj3 = obj6;
                                    i21 = i44;
                                    if (i36 == 1) {
                                        zzhj.zzl(obj3, j, Double.longBitsToDouble(zzdu.zzn(bArr4, i19)));
                                        iZzg = i19 + 8;
                                        Unsafe unsafe6 = unsafe2;
                                        i31 = i20 | i41;
                                        unsafe5 = unsafe6;
                                        i25 = i2;
                                        i28 = i8;
                                        i27 = i35;
                                        obj6 = obj3;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        iZzg = i19;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 1:
                                    zzdtVar6 = zzdtVar;
                                    i19 = iZzg;
                                    i8 = i38;
                                    i20 = i31;
                                    unsafe2 = unsafe5;
                                    int i45 = i30;
                                    obj3 = obj6;
                                    i21 = i45;
                                    if (i36 == 5) {
                                        zzhj.zzm(obj3, j, Float.intBitsToFloat(zzdu.zzb(bArr4, i19)));
                                        iZzg = i19 + 4;
                                        Unsafe unsafe62 = unsafe2;
                                        i31 = i20 | i41;
                                        unsafe5 = unsafe62;
                                        i25 = i2;
                                        i28 = i8;
                                        i27 = i35;
                                        obj6 = obj3;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        iZzg = i19;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 2:
                                case 3:
                                    zzdtVar6 = zzdtVar;
                                    i19 = iZzg;
                                    i8 = i38;
                                    i21 = i30;
                                    i20 = i31;
                                    if (i36 == 0) {
                                        int iZzk3 = zzdu.zzk(bArr4, i19, zzdtVar6);
                                        unsafe5.putLong(obj6, j, zzdtVar6.zzb);
                                        obj3 = obj6;
                                        i31 = i20 | i41;
                                        unsafe5 = unsafe5;
                                        i25 = i2;
                                        i28 = i8;
                                        iZzg = iZzk3;
                                        i27 = i35;
                                        obj6 = obj3;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        unsafe2 = unsafe5;
                                        obj3 = obj6;
                                        iZzg = i19;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 4:
                                case 11:
                                    zzdtVar6 = zzdtVar;
                                    i19 = iZzg;
                                    i8 = i38;
                                    i21 = i30;
                                    i20 = i31;
                                    if (i36 == 0) {
                                        int iZzh4 = zzdu.zzh(bArr4, i19, zzdtVar6);
                                        unsafe5.putInt(obj6, j, zzdtVar6.zza);
                                        i31 = i20 | i41;
                                        i25 = i2;
                                        iZzg = iZzh4;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        unsafe2 = unsafe5;
                                        obj3 = obj6;
                                        iZzg = i19;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 5:
                                case 14:
                                    Unsafe unsafe7 = unsafe5;
                                    byte[] bArr5 = bArr4;
                                    i8 = i38;
                                    Object obj7 = obj6;
                                    i20 = i31;
                                    i21 = i30;
                                    if (i36 == 1) {
                                        long jZzn = zzdu.zzn(bArr5, iZzg);
                                        obj6 = obj7;
                                        bArr4 = bArr5;
                                        unsafe5 = unsafe7;
                                        zzdtVar6 = zzdtVar;
                                        unsafe5.putLong(obj6, j, jZzn);
                                        iZzg += 8;
                                        i31 = i20 | i41;
                                        i25 = i2;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        i19 = iZzg;
                                        obj6 = obj7;
                                        unsafe5 = unsafe7;
                                        unsafe2 = unsafe5;
                                        obj3 = obj6;
                                        iZzg = i19;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 6:
                                case 13:
                                    unsafe3 = unsafe5;
                                    bArr3 = bArr4;
                                    i8 = i38;
                                    obj4 = obj6;
                                    i22 = iZzg;
                                    i20 = i31;
                                    zzdtVar5 = zzdtVar;
                                    i21 = i30;
                                    if (i36 == 5) {
                                        unsafe3.putInt(obj4, j, zzdu.zzb(bArr3, i22));
                                        iZzk2 = i22 + 4;
                                        i31 = i20 | i41;
                                        Object obj8 = obj4;
                                        bArr4 = bArr3;
                                        unsafe5 = unsafe3;
                                        zzdtVar6 = zzdtVar5;
                                        iZzg = iZzk2;
                                        obj6 = obj8;
                                        i25 = i2;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        iZzg = i22;
                                        obj3 = obj4;
                                        unsafe2 = unsafe3;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 7:
                                    unsafe3 = unsafe5;
                                    bArr3 = bArr4;
                                    i8 = i38;
                                    obj4 = obj6;
                                    i22 = iZzg;
                                    i20 = i31;
                                    zzdtVar5 = zzdtVar;
                                    i21 = i30;
                                    if (i36 == 0) {
                                        iZzk2 = zzdu.zzk(bArr3, i22, zzdtVar5);
                                        zzhj.zzk(obj4, j, zzdtVar5.zzb != 0);
                                        i31 = i20 | i41;
                                        Object obj82 = obj4;
                                        bArr4 = bArr3;
                                        unsafe5 = unsafe3;
                                        zzdtVar6 = zzdtVar5;
                                        iZzg = iZzk2;
                                        obj6 = obj82;
                                        i25 = i2;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        iZzg = i22;
                                        obj3 = obj4;
                                        unsafe2 = unsafe3;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 8:
                                    unsafe3 = unsafe5;
                                    bArr3 = bArr4;
                                    int i46 = i30;
                                    i8 = i38;
                                    obj4 = obj6;
                                    i22 = iZzg;
                                    i20 = i31;
                                    zzdtVar5 = zzdtVar;
                                    if (i36 == 2) {
                                        if ((i37 & 536870912) != 0) {
                                            iZzk2 = zzdu.zzh(bArr3, i22, zzdtVar5);
                                            int i47 = zzdtVar5.zza;
                                            if (i47 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i47 == 0) {
                                                zzdtVar5.zzc = "";
                                                i21 = i46;
                                            } else {
                                                int i48 = zzhn.zza;
                                                int length = bArr3.length;
                                                if ((((length - iZzk2) - i47) | iZzk2 | i47) < 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzk2), Integer.valueOf(i47)));
                                                }
                                                int i49 = iZzk2 + i47;
                                                char[] cArr = new char[i47];
                                                int i50 = 0;
                                                while (iZzk2 < i49) {
                                                    byte b = bArr3[iZzk2];
                                                    if (zzhk.zzd(b)) {
                                                        iZzk2++;
                                                        cArr[i50] = (char) b;
                                                        i50++;
                                                    } else {
                                                        while (iZzk2 < i49) {
                                                            int i51 = iZzk2 + 1;
                                                            int i52 = iZzk2;
                                                            byte b2 = bArr3[i52];
                                                            if (zzhk.zzd(b2)) {
                                                                int i53 = i50 + 1;
                                                                cArr[i50] = (char) b2;
                                                                iZzk2 = i51;
                                                                while (true) {
                                                                    i50 = i53;
                                                                    if (iZzk2 < i49) {
                                                                        byte b3 = bArr3[iZzk2];
                                                                        if (zzhk.zzd(b3)) {
                                                                            iZzk2++;
                                                                            i53 = i50 + 1;
                                                                            cArr[i50] = (char) b3;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                int i54 = i46;
                                                                if (b2 < -32) {
                                                                    if (i51 >= i49) {
                                                                        throw zzfb.zzb();
                                                                    }
                                                                    zzhk.zzc(b2, bArr3[i51], cArr, i50);
                                                                    iZzk2 = i52 + 2;
                                                                    i50++;
                                                                } else if (b2 < -16) {
                                                                    if (i51 >= i49 - 1) {
                                                                        throw zzfb.zzb();
                                                                    }
                                                                    zzhk.zzb(b2, bArr3[i51], bArr3[i52 + 2], cArr, i50);
                                                                    iZzk2 = i52 + 3;
                                                                    i50++;
                                                                } else {
                                                                    if (i51 >= i49 - 2) {
                                                                        throw zzfb.zzb();
                                                                    }
                                                                    char[] cArr2 = cArr;
                                                                    zzhk.zza(b2, bArr3[i51], bArr3[i52 + 2], bArr3[i52 + 3], cArr2, i50);
                                                                    i50 += 2;
                                                                    cArr = cArr2;
                                                                    iZzk2 = i52 + 4;
                                                                }
                                                                i46 = i54;
                                                            }
                                                        }
                                                        i21 = i46;
                                                        zzdtVar5.zzc = new String(cArr, 0, i50);
                                                        iZzk2 = i49;
                                                    }
                                                }
                                                while (iZzk2 < i49) {
                                                }
                                                i21 = i46;
                                                zzdtVar5.zzc = new String(cArr, 0, i50);
                                                iZzk2 = i49;
                                            }
                                        } else {
                                            i21 = i46;
                                            iZzk2 = zzdu.zzh(bArr3, i22, zzdtVar5);
                                            int i55 = zzdtVar5.zza;
                                            if (i55 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if (i55 == 0) {
                                                zzdtVar5.zzc = "";
                                            } else {
                                                zzdtVar5.zzc = new String(bArr3, iZzk2, i55, zzfa.zzb);
                                                iZzk2 += i55;
                                            }
                                        }
                                        unsafe3.putObject(obj4, j, zzdtVar5.zzc);
                                        i31 = i20 | i41;
                                        Object obj822 = obj4;
                                        bArr4 = bArr3;
                                        unsafe5 = unsafe3;
                                        zzdtVar6 = zzdtVar5;
                                        iZzg = iZzk2;
                                        obj6 = obj822;
                                        i25 = i2;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        i21 = i46;
                                        iZzg = i22;
                                        obj3 = obj4;
                                        unsafe2 = unsafe3;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 9:
                                    Object obj9 = obj6;
                                    Unsafe unsafe8 = unsafe5;
                                    i23 = i30;
                                    i8 = i38;
                                    i20 = i31;
                                    if (i36 == 2) {
                                        Object objZzt = zzgaVar2.zzt(obj9, i8);
                                        i39 = i39;
                                        byte[] bArr6 = bArr4;
                                        int iZzm2 = zzdu.zzm(objZzt, zzgaVar2.zzr(i8), bArr6, iZzg, i2, zzdtVar);
                                        zzgaVar2.zzB(obj9, i8, objZzt);
                                        i31 = i20 | i41;
                                        bArr4 = bArr6;
                                        unsafe5 = unsafe8;
                                        zzdtVar6 = zzdtVar;
                                        iZzg = iZzm2;
                                        obj6 = obj9;
                                        i30 = i23;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i26 = 0;
                                        i25 = i2;
                                        break;
                                    } else {
                                        i39 = i39;
                                        iZzg = iZzg;
                                        obj3 = obj9;
                                        i21 = i23;
                                        unsafe2 = unsafe8;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 10:
                                    Object obj10 = obj6;
                                    unsafe4 = unsafe5;
                                    obj5 = obj10;
                                    zzdtVar6 = zzdtVar;
                                    i23 = i30;
                                    i8 = i38;
                                    i24 = i39;
                                    i20 = i31;
                                    if (i36 == 2) {
                                        iZzg = zzdu.zza(bArr4, iZzg, zzdtVar6);
                                        unsafe4.putObject(obj5, j, zzdtVar6.zzc);
                                        i31 = i20 | i41;
                                        Unsafe unsafe9 = unsafe4;
                                        obj6 = obj5;
                                        unsafe5 = unsafe9;
                                        i29 = i24;
                                        i30 = i23;
                                        i28 = i8;
                                        i27 = i35;
                                        i26 = 0;
                                        i25 = i2;
                                        break;
                                    } else {
                                        obj3 = obj5;
                                        unsafe2 = unsafe4;
                                        i39 = i24;
                                        i21 = i23;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 12:
                                    Object obj11 = obj6;
                                    unsafe4 = unsafe5;
                                    obj5 = obj11;
                                    zzdtVar6 = zzdtVar;
                                    i23 = i30;
                                    i8 = i38;
                                    i24 = i39;
                                    i20 = i31;
                                    if (i36 != 0) {
                                        obj3 = obj5;
                                        unsafe2 = unsafe4;
                                        i39 = i24;
                                        i21 = i23;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    } else {
                                        iZzg = zzdu.zzh(bArr4, iZzg, zzdtVar6);
                                        int i56 = zzdtVar6.zza;
                                        zzey zzeyVarZzq = zzgaVar2.zzq(i8);
                                        if ((i37 & Integer.MIN_VALUE) == 0 || zzeyVarZzq == null || zzeyVarZzq.zza()) {
                                            unsafe4.putInt(obj5, j, i56);
                                            i31 = i20 | i41;
                                            Unsafe unsafe92 = unsafe4;
                                            obj6 = obj5;
                                            unsafe5 = unsafe92;
                                            i29 = i24;
                                            i30 = i23;
                                            i28 = i8;
                                            i27 = i35;
                                            i26 = 0;
                                            i25 = i2;
                                            break;
                                        } else {
                                            zzc(obj5).zzh(i24, Long.valueOf(i56));
                                            obj6 = obj5;
                                            unsafe5 = unsafe4;
                                            i29 = i24;
                                            i30 = i23;
                                            i28 = i8;
                                            i27 = i35;
                                            i31 = i20;
                                            i26 = 0;
                                            i25 = i2;
                                        }
                                    }
                                case 15:
                                    Object obj12 = obj6;
                                    Unsafe unsafe10 = unsafe5;
                                    zzdtVar6 = zzdtVar;
                                    i23 = i30;
                                    i8 = i38;
                                    i20 = i31;
                                    if (i36 == 0) {
                                        iZzg = zzdu.zzh(bArr4, iZzg, zzdtVar6);
                                        unsafe10.putInt(obj12, j, zzej.zzb(zzdtVar6.zza));
                                        i31 = i20 | i41;
                                        obj6 = obj12;
                                        unsafe5 = unsafe10;
                                        i30 = i23;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i26 = 0;
                                        i25 = i2;
                                        break;
                                    } else {
                                        obj3 = obj12;
                                        unsafe2 = unsafe10;
                                        i21 = i23;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                case 16:
                                    if (i36 == 0) {
                                        zzdtVar6 = zzdtVar;
                                        int iZzk4 = zzdu.zzk(bArr4, iZzg, zzdtVar6);
                                        i8 = i38;
                                        unsafe5.putLong(obj6, j, zzej.zzc(zzdtVar6.zzb));
                                        i31 |= i41;
                                        obj6 = obj6;
                                        unsafe5 = unsafe5;
                                        iZzg = iZzk4;
                                        i28 = i8;
                                        i27 = i35;
                                        i29 = i39;
                                        i26 = 0;
                                        i25 = i2;
                                        break;
                                    } else {
                                        i8 = i38;
                                        i21 = i30;
                                        i20 = i31;
                                        obj3 = obj6;
                                        unsafe2 = unsafe5;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                                default:
                                    i19 = iZzg;
                                    i21 = i30;
                                    i8 = i38;
                                    obj3 = obj6;
                                    i20 = i31;
                                    unsafe2 = unsafe5;
                                    if (i36 == 3) {
                                        Object objZzt2 = zzgaVar2.zzt(obj3, i8);
                                        int iZzl = zzdu.zzl(objZzt2, zzgaVar2.zzr(i8), bArr4, i19, i2, (i35 << 3) | 4, zzdtVar);
                                        zzgaVar2.zzB(obj3, i8, objZzt2);
                                        i31 = i20 | i41;
                                        unsafe5 = unsafe2;
                                        bArr4 = bArr;
                                        i25 = i2;
                                        zzdtVar6 = zzdtVar;
                                        iZzg = iZzl;
                                        i28 = i8;
                                        i27 = i35;
                                        obj6 = obj3;
                                        i29 = i39;
                                        i30 = i21;
                                        i26 = 0;
                                        break;
                                    } else {
                                        iZzg = i19;
                                        bArr2 = bArr;
                                        i4 = i3;
                                        obj2 = obj3;
                                        unsafe = unsafe2;
                                        i31 = i20;
                                        i6 = i39;
                                        i7 = i21;
                                        zzdtVar2 = zzdtVar;
                                        break;
                                    }
                            }
                        } else {
                            Unsafe unsafe11 = unsafe5;
                            obj2 = obj6;
                            i8 = i38;
                            if (iZzn != 27) {
                                unsafe = unsafe11;
                                i7 = i30;
                                i9 = i31;
                                i10 = iZzg;
                                zzdtVar3 = zzdtVar;
                                if (iZzn <= 49) {
                                    long j2 = i37;
                                    Unsafe unsafe12 = zzb;
                                    zzez zzezVarZzd = (zzez) unsafe12.getObject(obj2, j);
                                    if (!zzezVarZzd.zzc()) {
                                        int size = zzezVarZzd.size();
                                        zzezVarZzd = zzezVarZzd.zzd(size == 0 ? 10 : size + size);
                                        unsafe12.putObject(obj2, j, zzezVarZzd);
                                    }
                                    switch (iZzn) {
                                        case 18:
                                        case 35:
                                            zzez zzezVar = zzezVarZzd;
                                            i6 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 != 2) {
                                                if (i36 == 1) {
                                                    zzek zzekVar = (zzek) zzezVar;
                                                    zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, i14)));
                                                    iZzh2 = i14 + 8;
                                                    while (iZzh2 < i2) {
                                                        int iZzh5 = zzdu.zzh(bArr, iZzh2, zzdtVar3);
                                                        if (i6 == zzdtVar3.zza) {
                                                            zzekVar.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzh5)));
                                                            iZzh2 = iZzh5 + 8;
                                                        }
                                                    }
                                                }
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                    bArr4 = bArr;
                                                    i28 = i8;
                                                    obj6 = obj2;
                                                    zzgaVar2 = zzgaVar;
                                                    i27 = i35;
                                                    i30 = i7;
                                                    i31 = i9;
                                                    unsafe5 = unsafe;
                                                    i26 = 0;
                                                    zzdtVar6 = zzdtVar3;
                                                    i29 = i6;
                                                    i25 = i2;
                                                    break;
                                                } else {
                                                    bArr2 = bArr;
                                                    i4 = i3;
                                                    zzdtVar2 = zzdtVar3;
                                                    break;
                                                }
                                            } else {
                                                zzek zzekVar2 = (zzek) zzezVar;
                                                iZzh2 = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i57 = zzdtVar3.zza + iZzh2;
                                                while (iZzh2 < i57) {
                                                    zzekVar2.zze(Double.longBitsToDouble(zzdu.zzn(bArr, iZzh2)));
                                                    iZzh2 += 8;
                                                }
                                                if (iZzh2 != i57) {
                                                    throw zzfb.zzf();
                                                }
                                            }
                                            iZzg = iZzh2;
                                            i10 = i14;
                                            if (iZzg != i10) {
                                            }
                                        case 19:
                                        case 36:
                                            zzez zzezVar2 = zzezVarZzd;
                                            i6 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                zzer zzerVar = (zzer) zzezVar2;
                                                iZzh2 = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i58 = zzdtVar3.zza + iZzh2;
                                                while (iZzh2 < i58) {
                                                    zzerVar.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzh2)));
                                                    iZzh2 += 4;
                                                }
                                                if (iZzh2 != i58) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 5) {
                                                    zzer zzerVar2 = (zzer) zzezVar2;
                                                    zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, i14)));
                                                    iZzh2 = i14 + 4;
                                                    while (iZzh2 < i2) {
                                                        int iZzh6 = zzdu.zzh(bArr, iZzh2, zzdtVar3);
                                                        if (i6 == zzdtVar3.zza) {
                                                            zzerVar2.zze(Float.intBitsToFloat(zzdu.zzb(bArr, iZzh6)));
                                                            iZzh2 = iZzh6 + 4;
                                                        }
                                                    }
                                                }
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            iZzg = iZzh2;
                                            i10 = i14;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            zzez zzezVar3 = zzezVarZzd;
                                            i6 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                zzfm zzfmVar = (zzfm) zzezVar3;
                                                iZzh2 = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i59 = zzdtVar3.zza + iZzh2;
                                                while (iZzh2 < i59) {
                                                    iZzh2 = zzdu.zzk(bArr, iZzh2, zzdtVar3);
                                                    zzfmVar.zze(zzdtVar3.zzb);
                                                }
                                                if (iZzh2 != i59) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 0) {
                                                    zzfm zzfmVar2 = (zzfm) zzezVar3;
                                                    iZzh2 = zzdu.zzk(bArr, i14, zzdtVar3);
                                                    zzfmVar2.zze(zzdtVar3.zzb);
                                                    while (iZzh2 < i2) {
                                                        int iZzh7 = zzdu.zzh(bArr, iZzh2, zzdtVar3);
                                                        if (i6 == zzdtVar3.zza) {
                                                            iZzh2 = zzdu.zzk(bArr, iZzh7, zzdtVar3);
                                                            zzfmVar2.zze(zzdtVar3.zzb);
                                                        }
                                                    }
                                                }
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            iZzg = iZzh2;
                                            i10 = i14;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                iZzf = zzdu.zzf(bArr, i14, zzezVarZzd, zzdtVar3);
                                                iZzg = iZzf;
                                                i6 = i15;
                                                i10 = i14;
                                                if (iZzg != i10) {
                                                }
                                            } else {
                                                if (i36 == 0) {
                                                    int iZzj2 = zzdu.zzj(i15, bArr, i14, i2, zzezVarZzd, zzdtVar3);
                                                    i6 = i15;
                                                    iZzg = iZzj2;
                                                    i10 = i14;
                                                    if (iZzg != i10) {
                                                    }
                                                }
                                                i6 = i15;
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                zzfm zzfmVar3 = (zzfm) zzezVarZzd;
                                                iZzf = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i60 = zzdtVar3.zza + iZzf;
                                                while (iZzf < i60) {
                                                    zzfmVar3.zze(zzdu.zzn(bArr, iZzf));
                                                    iZzf += 8;
                                                }
                                                if (iZzf != i60) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 1) {
                                                    zzfm zzfmVar4 = (zzfm) zzezVarZzd;
                                                    zzfmVar4.zze(zzdu.zzn(bArr, i14));
                                                    iZzf = i14 + 8;
                                                    while (iZzf < i2) {
                                                        int iZzh8 = zzdu.zzh(bArr, iZzf, zzdtVar3);
                                                        if (i15 == zzdtVar3.zza) {
                                                            zzfmVar4.zze(zzdu.zzn(bArr, iZzh8));
                                                            iZzf = iZzh8 + 8;
                                                        }
                                                    }
                                                }
                                                i6 = i15;
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            iZzg = iZzf;
                                            i6 = i15;
                                            i10 = i14;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                zzew zzewVar = (zzew) zzezVarZzd;
                                                iZzf = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i61 = zzdtVar3.zza + iZzf;
                                                while (iZzf < i61) {
                                                    zzewVar.zze(zzdu.zzb(bArr, iZzf));
                                                    iZzf += 4;
                                                }
                                                if (iZzf != i61) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 5) {
                                                    zzew zzewVar2 = (zzew) zzezVarZzd;
                                                    zzewVar2.zze(zzdu.zzb(bArr, i14));
                                                    iZzf = i14 + 4;
                                                    while (iZzf < i2) {
                                                        int iZzh9 = zzdu.zzh(bArr, iZzf, zzdtVar3);
                                                        if (i15 == zzdtVar3.zza) {
                                                            zzewVar2.zze(zzdu.zzb(bArr, iZzh9));
                                                            iZzf = iZzh9 + 4;
                                                        }
                                                    }
                                                }
                                                i6 = i15;
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            iZzg = iZzf;
                                            i6 = i15;
                                            i10 = i14;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                zzdv zzdvVar = (zzdv) zzezVarZzd;
                                                iZzf = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i62 = zzdtVar3.zza + iZzf;
                                                while (iZzf < i62) {
                                                    iZzf = zzdu.zzk(bArr, iZzf, zzdtVar3);
                                                    zzdvVar.zze(zzdtVar3.zzb != 0);
                                                }
                                                if (iZzf != i62) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 0) {
                                                    zzdv zzdvVar2 = (zzdv) zzezVarZzd;
                                                    iZzf = zzdu.zzk(bArr, i14, zzdtVar3);
                                                    zzdvVar2.zze(zzdtVar3.zzb != 0);
                                                    while (iZzf < i2) {
                                                        int iZzh10 = zzdu.zzh(bArr, iZzf, zzdtVar3);
                                                        if (i15 == zzdtVar3.zza) {
                                                            iZzf = zzdu.zzk(bArr, iZzh10, zzdtVar3);
                                                            zzdvVar2.zze(zzdtVar3.zzb != 0);
                                                        }
                                                    }
                                                }
                                                i6 = i15;
                                                i10 = i14;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            iZzg = iZzf;
                                            i6 = i15;
                                            i10 = i14;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 26:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 2) {
                                                if ((j2 & 536870912) == 0) {
                                                    iZzf = zzdu.zzh(bArr, i14, zzdtVar3);
                                                    int i63 = zzdtVar3.zza;
                                                    if (i63 < 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i63 == 0) {
                                                        zzezVarZzd.add("");
                                                    } else {
                                                        zzezVarZzd.add(new String(bArr, iZzf, i63, zzfa.zzb));
                                                        iZzf += i63;
                                                    }
                                                    while (iZzf < i2) {
                                                        int iZzh11 = zzdu.zzh(bArr, iZzf, zzdtVar3);
                                                        if (i15 == zzdtVar3.zza) {
                                                            iZzf = zzdu.zzh(bArr, iZzh11, zzdtVar3);
                                                            int i64 = zzdtVar3.zza;
                                                            if (i64 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i64 == 0) {
                                                                zzezVarZzd.add("");
                                                            } else {
                                                                zzezVarZzd.add(new String(bArr, iZzf, i64, zzfa.zzb));
                                                                iZzf += i64;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iZzf = zzdu.zzh(bArr, i14, zzdtVar3);
                                                    int i65 = zzdtVar3.zza;
                                                    if (i65 < 0) {
                                                        throw zzfb.zzc();
                                                    }
                                                    if (i65 == 0) {
                                                        zzezVarZzd.add("");
                                                    } else {
                                                        int i66 = iZzf + i65;
                                                        if (!zzhn.zzc(bArr, iZzf, i66)) {
                                                            throw zzfb.zzb();
                                                        }
                                                        zzezVarZzd.add(new String(bArr, iZzf, i65, zzfa.zzb));
                                                        iZzf = i66;
                                                    }
                                                    while (iZzf < i2) {
                                                        int iZzh12 = zzdu.zzh(bArr, iZzf, zzdtVar3);
                                                        if (i15 == zzdtVar3.zza) {
                                                            iZzf = zzdu.zzh(bArr, iZzh12, zzdtVar3);
                                                            int i67 = zzdtVar3.zza;
                                                            if (i67 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if (i67 == 0) {
                                                                zzezVarZzd.add("");
                                                            } else {
                                                                int i68 = iZzf + i67;
                                                                if (!zzhn.zzc(bArr, iZzf, i68)) {
                                                                    throw zzfb.zzb();
                                                                }
                                                                zzezVarZzd.add(new String(bArr, iZzf, i67, zzfa.zzb));
                                                                iZzf = i68;
                                                            }
                                                        }
                                                    }
                                                }
                                                iZzg = iZzf;
                                                i6 = i15;
                                                i10 = i14;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            i6 = i15;
                                            i10 = i14;
                                            iZzg = i10;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 27:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            if (i36 == 2) {
                                                zzgaVar = this;
                                                iZzg = zzdu.zze(zzgaVar.zzr(i8), i15, bArr, i14, i2, zzezVarZzd, zzdtVar3);
                                                i6 = i15;
                                                zzdtVar3 = zzdtVar3;
                                                i10 = i14;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            zzgaVar = this;
                                            i6 = i15;
                                            i10 = i14;
                                            iZzg = i10;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 28:
                                            i15 = i39;
                                            i14 = i10;
                                            i8 = i8;
                                            if (i36 == 2) {
                                                iZzf = zzdu.zzh(bArr, i14, zzdtVar3);
                                                int i69 = zzdtVar3.zza;
                                                if (i69 < 0) {
                                                    throw zzfb.zzc();
                                                }
                                                if (i69 > bArr.length - iZzf) {
                                                    throw zzfb.zzf();
                                                }
                                                if (i69 == 0) {
                                                    zzezVarZzd.add(zzef.zzb);
                                                } else {
                                                    zzezVarZzd.add(zzef.zzk(bArr, iZzf, i69));
                                                    iZzf += i69;
                                                }
                                                while (iZzf < i2) {
                                                    int iZzh13 = zzdu.zzh(bArr, iZzf, zzdtVar3);
                                                    if (i15 == zzdtVar3.zza) {
                                                        iZzf = zzdu.zzh(bArr, iZzh13, zzdtVar3);
                                                        int i70 = zzdtVar3.zza;
                                                        if (i70 < 0) {
                                                            throw zzfb.zzc();
                                                        }
                                                        if (i70 > bArr.length - iZzf) {
                                                            throw zzfb.zzf();
                                                        }
                                                        if (i70 == 0) {
                                                            zzezVarZzd.add(zzef.zzb);
                                                        } else {
                                                            zzezVarZzd.add(zzef.zzk(bArr, iZzf, i70));
                                                            iZzf += i70;
                                                        }
                                                    } else {
                                                        zzgaVar = this;
                                                        iZzg = iZzf;
                                                        i6 = i15;
                                                        i10 = i14;
                                                        if (iZzg != i10) {
                                                        }
                                                    }
                                                }
                                                zzgaVar = this;
                                                iZzg = iZzf;
                                                i6 = i15;
                                                i10 = i14;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            zzgaVar = this;
                                            i6 = i15;
                                            i10 = i14;
                                            iZzg = i10;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            if (i36 == 2) {
                                                iZzj = zzdu.zzf(bArr, i10, zzezVarZzd, zzdtVar3);
                                                i16 = i39;
                                                i17 = i10;
                                            } else if (i36 == 0) {
                                                i16 = i39;
                                                iZzj = zzdu.zzj(i16, bArr, i10, i2, zzezVarZzd, zzdtVar3);
                                                i17 = i10;
                                            } else {
                                                i8 = i8;
                                                zzgaVar = this;
                                                i6 = i39;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            i8 = i8;
                                            zzey zzeyVarZzq2 = zzgaVar2.zzq(i8);
                                            zzgz zzgzVar = zzgaVar2.zzl;
                                            int i71 = zzgk.zza;
                                            if (zzeyVarZzq2 == null) {
                                                i18 = iZzj;
                                            } else if (zzezVarZzd instanceof RandomAccess) {
                                                int size2 = zzezVarZzd.size();
                                                Object objZzc = null;
                                                int i72 = 0;
                                                int i73 = 0;
                                                while (i72 < size2) {
                                                    int i74 = iZzj;
                                                    Integer num = (Integer) zzezVarZzd.get(i72);
                                                    int iIntValue = num.intValue();
                                                    if (zzeyVarZzq2.zza()) {
                                                        if (i72 != i73) {
                                                            zzezVarZzd.set(i73, num);
                                                        }
                                                        i73++;
                                                    } else {
                                                        objZzc = zzgk.zzc(obj2, i35, iIntValue, objZzc, zzgzVar);
                                                    }
                                                    i72++;
                                                    iZzj = i74;
                                                }
                                                i18 = iZzj;
                                                if (i73 != size2) {
                                                    zzezVarZzd.subList(i73, size2).clear();
                                                }
                                            } else {
                                                i18 = iZzj;
                                                Iterator it = zzezVarZzd.iterator();
                                                Object objZzc2 = null;
                                                while (it.hasNext()) {
                                                    int iIntValue2 = ((Integer) it.next()).intValue();
                                                    if (!zzeyVarZzq2.zza()) {
                                                        objZzc2 = zzgk.zzc(obj2, i35, iIntValue2, objZzc2, zzgzVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            zzgaVar = this;
                                            i6 = i16;
                                            i10 = i17;
                                            iZzg = i18;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            if (i36 == 2) {
                                                zzew zzewVar3 = (zzew) zzezVarZzd;
                                                iZzh3 = zzdu.zzh(bArr, i10, zzdtVar3);
                                                int i75 = zzdtVar3.zza + iZzh3;
                                                while (iZzh3 < i75) {
                                                    iZzh3 = zzdu.zzh(bArr, iZzh3, zzdtVar3);
                                                    zzewVar3.zze(zzej.zzb(zzdtVar3.zza));
                                                }
                                                if (iZzh3 != i75) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 0) {
                                                    zzew zzewVar4 = (zzew) zzezVarZzd;
                                                    iZzh3 = zzdu.zzh(bArr, i10, zzdtVar3);
                                                    zzewVar4.zze(zzej.zzb(zzdtVar3.zza));
                                                    while (iZzh3 < i2) {
                                                        int iZzh14 = zzdu.zzh(bArr, iZzh3, zzdtVar3);
                                                        if (i39 == zzdtVar3.zza) {
                                                            iZzh3 = zzdu.zzh(bArr, iZzh14, zzdtVar3);
                                                            zzewVar4.zze(zzej.zzb(zzdtVar3.zza));
                                                        }
                                                    }
                                                }
                                                zzgaVar = zzgaVar2;
                                                i6 = i39;
                                                i8 = i8;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            zzgaVar = zzgaVar2;
                                            i6 = i39;
                                            i8 = i8;
                                            iZzg = iZzh3;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            if (i36 == 2) {
                                                zzfm zzfmVar5 = (zzfm) zzezVarZzd;
                                                iZzh3 = zzdu.zzh(bArr, i10, zzdtVar3);
                                                int i76 = zzdtVar3.zza + iZzh3;
                                                while (iZzh3 < i76) {
                                                    iZzh3 = zzdu.zzk(bArr, iZzh3, zzdtVar3);
                                                    zzfmVar5.zze(zzej.zzc(zzdtVar3.zzb));
                                                }
                                                if (iZzh3 != i76) {
                                                    throw zzfb.zzf();
                                                }
                                            } else {
                                                if (i36 == 0) {
                                                    zzfm zzfmVar6 = (zzfm) zzezVarZzd;
                                                    iZzh3 = zzdu.zzk(bArr, i10, zzdtVar3);
                                                    zzfmVar6.zze(zzej.zzc(zzdtVar3.zzb));
                                                    while (iZzh3 < i2) {
                                                        int iZzh15 = zzdu.zzh(bArr, iZzh3, zzdtVar3);
                                                        if (i39 == zzdtVar3.zza) {
                                                            iZzh3 = zzdu.zzk(bArr, iZzh15, zzdtVar3);
                                                            zzfmVar6.zze(zzej.zzc(zzdtVar3.zzb));
                                                        }
                                                    }
                                                }
                                                zzgaVar = zzgaVar2;
                                                i6 = i39;
                                                i8 = i8;
                                                iZzg = i10;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            zzgaVar = zzgaVar2;
                                            i6 = i39;
                                            i8 = i8;
                                            iZzg = iZzh3;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                        default:
                                            zzez zzezVar4 = zzezVarZzd;
                                            i6 = i39;
                                            int i77 = i2;
                                            i14 = i10;
                                            i8 = i8;
                                            zzgaVar = zzgaVar2;
                                            if (i36 == 3) {
                                                zzgi zzgiVarZzr = zzgaVar.zzr(i8);
                                                int i78 = (i6 & (-8)) | 4;
                                                int iZzc = zzdu.zzc(zzgiVarZzr, bArr, i14, i77, i78, zzdtVar3);
                                                i10 = i14;
                                                zzezVar4.add(zzdtVar3.zzc);
                                                while (iZzc < i77) {
                                                    int iZzh16 = zzdu.zzh(bArr, iZzc, zzdtVar3);
                                                    if (i6 == zzdtVar3.zza) {
                                                        iZzc = zzdu.zzc(zzgiVarZzr, bArr, iZzh16, i77, i78, zzdtVar3);
                                                        zzezVar4.add(zzdtVar3.zzc);
                                                        i77 = i2;
                                                    } else {
                                                        iZzg = iZzc;
                                                        if (iZzg != i10) {
                                                        }
                                                    }
                                                }
                                                iZzg = iZzc;
                                                if (iZzg != i10) {
                                                }
                                            }
                                            i10 = i14;
                                            iZzg = i10;
                                            if (iZzg != i10) {
                                            }
                                            break;
                                    }
                                } else {
                                    zzga<T> zzgaVar3 = zzgaVar2;
                                    i6 = i39;
                                    if (iZzn != 50) {
                                        Unsafe unsafe13 = zzb;
                                        long j3 = iArr[i8 + 2] & 1048575;
                                        switch (iZzn) {
                                            case 51:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 1) {
                                                    unsafe13.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzdu.zzn(bArr2, i12))));
                                                    iZzk = i12 + 8;
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                        zzgaVar2 = this;
                                                        bArr4 = bArr2;
                                                        i29 = i6;
                                                        obj6 = obj2;
                                                        i27 = i35;
                                                        zzdtVar6 = zzdtVar2;
                                                        i28 = i11;
                                                        i30 = i7;
                                                        i31 = i9;
                                                        unsafe5 = unsafe;
                                                        i26 = 0;
                                                        i25 = i2;
                                                        break;
                                                    } else {
                                                        i4 = i3;
                                                        i8 = i11;
                                                        break;
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                            case 52:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 5) {
                                                    unsafe13.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzdu.zzb(bArr2, i12))));
                                                    iZzk = i12 + 4;
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 0) {
                                                    iZzk = zzdu.zzk(bArr2, i12, zzdtVar2);
                                                    unsafe13.putObject(obj2, j, Long.valueOf(zzdtVar2.zzb));
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 0) {
                                                    iZzk = zzdu.zzh(bArr2, i12, zzdtVar2);
                                                    unsafe13.putObject(obj2, j, Integer.valueOf(zzdtVar2.zza));
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 1) {
                                                    unsafe13.putObject(obj2, j, Long.valueOf(zzdu.zzn(bArr2, i12)));
                                                    iZzk = i12 + 8;
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 5) {
                                                    unsafe13.putObject(obj2, j, Integer.valueOf(zzdu.zzb(bArr2, i12)));
                                                    iZzk = i12 + 4;
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 58:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 0) {
                                                    iZzk = zzdu.zzk(bArr2, i12, zzdtVar2);
                                                    unsafe13.putObject(obj2, j, Boolean.valueOf(zzdtVar2.zzb != 0));
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 59:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                if (i36 == 2) {
                                                    iZzk = zzdu.zzh(bArr2, i12, zzdtVar2);
                                                    int i79 = zzdtVar2.zza;
                                                    if (i79 == 0) {
                                                        unsafe13.putObject(obj2, j, "");
                                                    } else {
                                                        if ((i37 & 536870912) != 0 && !zzhn.zzc(bArr2, iZzk, iZzk + i79)) {
                                                            throw zzfb.zzb();
                                                        }
                                                        unsafe13.putObject(obj2, j, new String(bArr2, iZzk, i79, zzfa.zzb));
                                                        iZzk += i79;
                                                    }
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzk;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 60:
                                                bArr2 = bArr;
                                                if (i36 == 2) {
                                                    Object objZzu = zzgaVar3.zzu(obj2, i35, i8);
                                                    int iZzm3 = zzdu.zzm(objZzu, zzgaVar3.zzr(i8), bArr2, i10, i2, zzdtVar);
                                                    zzdtVar2 = zzdtVar;
                                                    bArr2 = bArr2;
                                                    zzgaVar3.zzC(obj2, i35, i8, objZzu);
                                                    iZzg = iZzm3;
                                                    i11 = i8;
                                                    i12 = i10;
                                                    if (iZzg == i12) {
                                                    }
                                                } else {
                                                    zzdtVar2 = zzdtVar;
                                                    i11 = i8;
                                                    i12 = i10;
                                                    iZzg = i12;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                break;
                                            case 61:
                                                bArr2 = bArr;
                                                zzdtVar4 = zzdtVar;
                                                if (i36 == 2) {
                                                    iZza = zzdu.zza(bArr2, i10, zzdtVar4);
                                                    unsafe13.putObject(obj2, j, zzdtVar4.zzc);
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZza;
                                                    i11 = i8;
                                                    i12 = i10;
                                                    zzdtVar2 = zzdtVar4;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar4;
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 63:
                                                bArr2 = bArr;
                                                zzdtVar4 = zzdtVar;
                                                i11 = i8;
                                                if (i36 == 0) {
                                                    iZza = zzdu.zzh(bArr2, i10, zzdtVar4);
                                                    int i80 = zzdtVar4.zza;
                                                    i8 = i11;
                                                    zzey zzeyVarZzq3 = zzgaVar3.zzq(i8);
                                                    if (zzeyVarZzq3 == null || zzeyVarZzq3.zza()) {
                                                        i6 = i6;
                                                        unsafe13.putObject(obj2, j, Integer.valueOf(i80));
                                                        unsafe13.putInt(obj2, j3, i35);
                                                    } else {
                                                        i6 = i6;
                                                        zzc(obj2).zzh(i6, Long.valueOf(i80));
                                                    }
                                                    iZzg = iZza;
                                                    i11 = i8;
                                                    i12 = i10;
                                                    zzdtVar2 = zzdtVar4;
                                                    if (iZzg == i12) {
                                                    }
                                                } else {
                                                    i6 = i6;
                                                    i12 = i10;
                                                    zzdtVar2 = zzdtVar4;
                                                    iZzg = i12;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                break;
                                            case 66:
                                                bArr2 = bArr;
                                                zzdtVar4 = zzdtVar;
                                                i13 = i6;
                                                i11 = i8;
                                                if (i36 == 0) {
                                                    iZzh = zzdu.zzh(bArr2, i10, zzdtVar4);
                                                    unsafe13.putObject(obj2, j, Integer.valueOf(zzej.zzb(zzdtVar4.zza)));
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzh;
                                                    i12 = i10;
                                                    i6 = i13;
                                                    zzdtVar2 = zzdtVar4;
                                                    if (iZzg == i12) {
                                                    }
                                                } else {
                                                    i12 = i10;
                                                    i6 = i13;
                                                    zzdtVar2 = zzdtVar4;
                                                    iZzg = i12;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                break;
                                            case 67:
                                                bArr2 = bArr;
                                                zzdtVar4 = zzdtVar;
                                                if (i36 == 0) {
                                                    iZzh = zzdu.zzk(bArr2, i10, zzdtVar4);
                                                    i13 = i6;
                                                    i11 = i8;
                                                    unsafe13.putObject(obj2, j, Long.valueOf(zzej.zzc(zzdtVar4.zzb)));
                                                    unsafe13.putInt(obj2, j3, i35);
                                                    iZzg = iZzh;
                                                    i12 = i10;
                                                    i6 = i13;
                                                    zzdtVar2 = zzdtVar4;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar4;
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                            case 68:
                                                if (i36 == 3) {
                                                    Object objZzu2 = zzgaVar3.zzu(obj2, i35, i8);
                                                    iZza = zzdu.zzl(objZzu2, zzgaVar3.zzr(i8), bArr, i10, i2, (i6 & (-8)) | 4, zzdtVar);
                                                    zzdtVar4 = zzdtVar;
                                                    bArr2 = bArr;
                                                    zzgaVar3.zzC(obj2, i35, i8, objZzu2);
                                                    iZzg = iZza;
                                                    i11 = i8;
                                                    i12 = i10;
                                                    zzdtVar2 = zzdtVar4;
                                                    if (iZzg == i12) {
                                                    }
                                                }
                                                break;
                                            default:
                                                bArr2 = bArr;
                                                i11 = i8;
                                                i12 = i10;
                                                zzdtVar2 = zzdtVar;
                                                iZzg = i12;
                                                if (iZzg == i12) {
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i36 == 2) {
                                            Unsafe unsafe14 = zzb;
                                            Object objZzs = zzgaVar3.zzs(i8);
                                            Object object = unsafe14.getObject(obj2, j);
                                            if (!((zzfr) object).zze()) {
                                                zzfr zzfrVarZzb = zzfr.zza().zzb();
                                                zzfs.zza(zzfrVarZzb, object);
                                                unsafe14.putObject(obj2, j, zzfrVarZzb);
                                            }
                                            throw null;
                                        }
                                        bArr2 = bArr;
                                        i4 = i3;
                                        iZzg = i10;
                                        i31 = i9;
                                        zzdtVar2 = zzdtVar3;
                                    }
                                }
                                i31 = i9;
                            } else if (i36 == 2) {
                                zzez zzezVarZzd2 = (zzez) unsafe11.getObject(obj2, j);
                                if (!zzezVarZzd2.zzc()) {
                                    int size3 = zzezVarZzd2.size();
                                    zzezVarZzd2 = zzezVarZzd2.zzd(size3 == 0 ? 10 : size3 + size3);
                                    unsafe11.putObject(obj2, j, zzezVarZzd2);
                                }
                                int iZze = zzdu.zze(zzgaVar2.zzr(i8), i39, bArr, iZzg, i2, zzezVarZzd2, zzdtVar);
                                bArr4 = bArr;
                                i29 = i39;
                                i28 = i8;
                                obj6 = obj2;
                                i27 = i35;
                                i26 = 0;
                                zzdtVar6 = zzdtVar;
                                iZzg = iZze;
                                unsafe5 = unsafe11;
                                i25 = i2;
                            } else {
                                zzdtVar3 = zzdtVar;
                                unsafe = unsafe11;
                                i7 = i30;
                                i9 = i31;
                                i6 = i39;
                                i10 = iZzg;
                                bArr2 = bArr;
                                i4 = i3;
                                iZzg = i10;
                                i31 = i9;
                                zzdtVar2 = zzdtVar3;
                            }
                        }
                    }
                    if (i6 == i4 || i4 == 0) {
                        int i81 = i6;
                        iZzg = zzdu.zzg(i81, bArr2, iZzg, i2, zzc(obj2), zzdtVar2);
                        zzgaVar2 = this;
                        bArr4 = bArr;
                        i29 = i81;
                        i25 = i2;
                        i28 = i8;
                        obj6 = obj2;
                        i27 = i35;
                        i30 = i7;
                        unsafe5 = unsafe;
                        i26 = 0;
                        zzdtVar6 = zzdtVar;
                    } else {
                        i5 = i2;
                        i29 = i6;
                        i30 = i7;
                    }
                } else {
                    if (i35 >= zzgaVar2.zze && i35 <= zzgaVar2.zzf) {
                        iZzm = zzgaVar2.zzm(i35, i26);
                    }
                    if (iZzm != -1) {
                    }
                    if (i6 == i4) {
                    }
                    int i812 = i6;
                    iZzg = zzdu.zzg(i812, bArr2, iZzg, i2, zzc(obj2), zzdtVar2);
                    zzgaVar2 = this;
                    bArr4 = bArr;
                    i29 = i812;
                    i25 = i2;
                    i28 = i8;
                    obj6 = obj2;
                    i27 = i35;
                    i30 = i7;
                    unsafe5 = unsafe;
                    i26 = 0;
                    zzdtVar6 = zzdtVar;
                }
            } else {
                i4 = i3;
                unsafe = unsafe5;
                obj2 = obj6;
                i5 = i25;
            }
        }
        if (i30 != 1048575) {
            unsafe.putInt(obj2, i30, i31);
        }
        for (int i82 = this.zzi; i82 < this.zzj; i82++) {
            int i83 = this.zzh[i82];
            int i84 = this.zzc[i83];
            Object objZzf = zzhj.zzf(obj2, zzo(i83) & 1048575);
            if (objZzf != null && zzq(i83) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzg != i5) {
                throw zzfb.zzd();
            }
        } else if (iZzg > i5 || i29 != i4) {
            throw zzfb.zzd();
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(Object obj) {
        if (zzH(obj)) {
            if (obj instanceof zzev) {
                zzev zzevVar = (zzev) obj;
                zzevVar.zzl(Integer.MAX_VALUE);
                zzevVar.zza = 0;
                zzevVar.zzj();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzo = zzo(i);
                int i2 = 1048575 & iZzo;
                int iZzn = zzn(iZzo);
                long j = i2;
                if (iZzn != 9) {
                    if (iZzn != 60 && iZzn != 68) {
                        switch (iZzn) {
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
                                this.zzk.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfr) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzI(obj, this.zzc[i], i)) {
                        zzr(i).zze(zzb.getObject(obj, j));
                    }
                } else if (zzE(obj, i)) {
                    zzr(i).zze(zzb.getObject(obj, j));
                }
            }
            this.zzl.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzo = zzo(i);
            int i2 = this.zzc[i];
            long j = 1048575 & iZzo;
            switch (zzn(iZzo)) {
                case 0:
                    if (zzE(obj2, i)) {
                        zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzE(obj2, i)) {
                        zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzE(obj2, i)) {
                        zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzx(obj, obj2, i);
                    break;
                case 10:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzx(obj, obj2, i);
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
                    this.zzk.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgk.zza;
                    zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
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
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzy(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzy(obj, obj2, i);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        zzb(obj, bArr, i, i2, 0, zzdtVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzf;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzo = zzo(i);
            long j = iZzo & 1048575;
            switch (zzn(iZzo)) {
                case 0:
                    if (!zzD(obj, obj2, i) || Double.doubleToLongBits(zzhj.zza(obj, j)) != Double.doubleToLongBits(zzhj.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzD(obj, obj2, i) || Float.floatToIntBits(zzhj.zzb(obj, j)) != Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzD(obj, obj2, i) || zzhj.zzt(obj, j) != zzhj.zzt(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
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
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 50:
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
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
                    long jZzl = zzl(i) & 1048575;
                    if (zzhj.zzc(obj, jZzl) != zzhj.zzc(obj2, jZzl) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzf) {
                return false;
            }
        }
        return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008f  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzi(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < this.zzi) {
            int i6 = this.zzh[i3];
            int i7 = this.zzc[i6];
            int iZzo = zzo(i6);
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
            if ((268435456 & iZzo) != 0 && !zzF(obj2, i6, i, i2, i10)) {
                return false;
            }
            int iZzn = zzn(iZzo);
            if (iZzn == 9 || iZzn == 17) {
                if (zzF(obj2, i6, i, i2, i10) && !zzG(obj2, iZzo, zzr(i6))) {
                    return false;
                }
            } else if (iZzn == 27) {
                List list = (List) zzhj.zzf(obj2, iZzo & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgi zzgiVarZzr = zzr(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzgiVarZzr.zzi(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (iZzn == 60 || iZzn == 68) {
                if (zzI(obj2, i7, i6) && !zzG(obj2, iZzo, zzr(i6))) {
                    return false;
                }
            } else if (iZzn != 49) {
                if (iZzn == 50 && !((zzfr) zzhj.zzf(obj2, iZzo & 1048575)).isEmpty()) {
                    throw null;
                }
            }
            i3++;
            obj = obj2;
            i4 = i;
            i5 = i2;
        }
        return true;
    }
}
