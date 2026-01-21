package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzfe {
    static int zza(byte[] bArr, int i, zzfg zzfgVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzfgVar);
        }
        zzfgVar.zzsd = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzfg zzfgVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzfgVar.zzsd = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzfgVar.zzsd = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzfgVar.zzsd = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzfgVar.zzsd = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfgVar.zzsd = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzfg zzfgVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzfgVar.zzse = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzfgVar.zzse = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzfg zzfgVar) throws zzhh {
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        }
        if (i2 == 0) {
            zzfgVar.zzsf = "";
            return iZza;
        }
        zzfgVar.zzsf = new String(bArr, iZza, i2, zzgy.UTF_8);
        return iZza + i2;
    }

    static int zzd(byte[] bArr, int i, zzfg zzfgVar) throws zzhh {
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        }
        if (i2 == 0) {
            zzfgVar.zzsf = "";
            return iZza;
        }
        zzfgVar.zzsf = zzjx.zzh(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zze(byte[] bArr, int i, zzfg zzfgVar) throws zzhh {
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        }
        if (i2 > bArr.length - iZza) {
            throw zzhh.zzgn();
        }
        if (i2 == 0) {
            zzfgVar.zzsf = zzfm.zzsm;
            return iZza;
        }
        zzfgVar.zzsf = zzfm.zza(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zza(zziw zziwVar, byte[] bArr, int i, int i2, zzfg zzfgVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzfgVar);
            i3 = zzfgVar.zzsd;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzhh.zzgn();
        }
        Object objNewInstance = zziwVar.newInstance();
        int i5 = i4 + i3;
        zziwVar.zza(objNewInstance, bArr, i4, i5, zzfgVar);
        zziwVar.zzh(objNewInstance);
        zzfgVar.zzsf = objNewInstance;
        return i5;
    }

    static int zza(zziw zziwVar, byte[] bArr, int i, int i2, int i3, zzfg zzfgVar) throws IOException {
        zzil zzilVar = (zzil) zziwVar;
        Object objNewInstance = zzilVar.newInstance();
        int iZza = zzilVar.zza((zzil) objNewInstance, bArr, i, i2, i3, zzfgVar);
        zzilVar.zzh(objNewInstance);
        zzfgVar.zzsf = objNewInstance;
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhe<?> zzheVar, zzfg zzfgVar) {
        zzgz zzgzVar = (zzgz) zzheVar;
        int iZza = zza(bArr, i2, zzfgVar);
        zzgzVar.zzbm(zzfgVar.zzsd);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzfgVar);
            if (i != zzfgVar.zzsd) {
                break;
            }
            iZza = zza(bArr, iZza2, zzfgVar);
            zzgzVar.zzbm(zzfgVar.zzsd);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgz zzgzVar = (zzgz) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzfgVar);
            zzgzVar.zzbm(zzfgVar.zzsd);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzb(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzhv zzhvVar = (zzhv) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            iZza = zzb(bArr, iZza, zzfgVar);
            zzhvVar.zzac(zzfgVar.zzse);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzc(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgz zzgzVar = (zzgz) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            zzgzVar.zzbm(zza(bArr, iZza));
            iZza += 4;
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzd(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzhv zzhvVar = (zzhv) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            zzhvVar.zzac(zzb(bArr, iZza));
            iZza += 8;
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zze(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgt zzgtVar = (zzgt) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            zzgtVar.zzu(zzd(bArr, iZza));
            iZza += 4;
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzf(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgg zzggVar = (zzgg) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            zzggVar.zzc(zzc(bArr, iZza));
            iZza += 8;
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzg(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzfk zzfkVar = (zzfk) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            iZza = zzb(bArr, iZza, zzfgVar);
            zzfkVar.addBoolean(zzfgVar.zzse != 0);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzh(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgz zzgzVar = (zzgz) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzfgVar);
            zzgzVar.zzbm(zzfy.zzav(zzfgVar.zzsd));
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zzi(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzhv zzhvVar = (zzhv) zzheVar;
        int iZza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + iZza;
        while (iZza < i2) {
            iZza = zzb(bArr, iZza, zzfgVar);
            zzhvVar.zzac(zzfy.zzr(zzfgVar.zzse));
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzhh.zzgn();
    }

    static int zza(zziw<?> zziwVar, int i, byte[] bArr, int i2, int i3, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        int iZza = zza(zziwVar, bArr, i2, i3, zzfgVar);
        zzheVar.add(zzfgVar.zzsf);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzfgVar);
            if (i != zzfgVar.zzsd) {
                break;
            }
            iZza = zza(zziwVar, bArr, iZza2, i3, zzfgVar);
            zzheVar.add(zzfgVar.zzsf);
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzjr zzjrVar, zzfg zzfgVar) throws zzhh {
        if ((i >>> 3) == 0) {
            throw zzhh.zzgq();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzb = zzb(bArr, i2, zzfgVar);
            zzjrVar.zzb(i, Long.valueOf(zzfgVar.zzse));
            return iZzb;
        }
        if (i4 == 1) {
            zzjrVar.zzb(i, Long.valueOf(zzb(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzfgVar);
            int i5 = zzfgVar.zzsd;
            if (i5 < 0) {
                throw zzhh.zzgo();
            }
            if (i5 > bArr.length - iZza) {
                throw zzhh.zzgn();
            }
            if (i5 == 0) {
                zzjrVar.zzb(i, zzfm.zzsm);
            } else {
                zzjrVar.zzb(i, zzfm.zza(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzjrVar.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            }
            throw zzhh.zzgq();
        }
        zzjr zzjrVarZzii = zzjr.zzii();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzfgVar);
            i7 = zzfgVar.zzsd;
            if (i7 == i6) {
                i2 = iZza2;
                break;
            }
            i2 = zza(i7, bArr, iZza2, i3, zzjrVarZzii, zzfgVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzhh.zzgt();
        }
        zzjrVar.zzb(i, zzjrVarZzii);
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfg zzfgVar) throws zzhh {
        if ((i >>> 3) == 0) {
            throw zzhh.zzgq();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzb(bArr, i2, zzfgVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzfgVar) + zzfgVar.zzsd;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzhh.zzgq();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzfgVar);
            i6 = zzfgVar.zzsd;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzfgVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzhh.zzgt();
        }
        return i2;
    }
}
