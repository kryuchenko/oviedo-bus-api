package com.google.android.gms.internal.drive;

import net.sf.scuba.smartcards.ISO7816;

/* loaded from: classes3.dex */
final class zznk extends zznh {
    zznk() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0096, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.drive.zznh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        int i5 = 2;
        int i6 = 3;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        int i7 = (int) (i3 - j2);
        long j3 = 1;
        if (i7 >= 16) {
            long j4 = j2;
            i4 = 0;
            while (true) {
                if (i4 >= i7) {
                    i4 = i7;
                    break;
                }
                long j5 = j4 + 1;
                if (zznd.zza(bArr, j4) < 0) {
                    break;
                }
                i4++;
                j4 = j5;
            }
        } else {
            i4 = 0;
        }
        int i8 = i7 - i4;
        long j6 = j2 + i4;
        while (true) {
            byte bZza = 0;
            while (true) {
                if (i8 <= 0) {
                    break;
                }
                long j7 = j6 + j3;
                bZza = zznd.zza(bArr, j6);
                if (bZza < 0) {
                    j6 = j7;
                    break;
                }
                i8--;
                j6 = j7;
            }
            if (i8 == 0) {
                return 0;
            }
            int i9 = i8 - 1;
            if (bZza >= -32) {
                if (bZza >= -16) {
                    j = j3;
                    if (i9 >= i6) {
                        i8 -= 4;
                        long j8 = j6 + j;
                        byte bZza2 = zznd.zza(bArr, j6);
                        if (bZza2 <= -65 && (((bZza << 28) + (bZza2 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                            long j9 = j6 + 2;
                            if (zznd.zza(bArr, j8) > -65) {
                                break;
                            }
                            j6 += 3;
                            if (zznd.zza(bArr, j9) > -65) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        return zza(bArr, bZza, j6, i9);
                    }
                } else {
                    if (i9 < i5) {
                        return zza(bArr, bZza, j6, i9);
                    }
                    i8 -= 3;
                    long j10 = j3;
                    long j11 = j6 + j10;
                    byte bZza3 = zznd.zza(bArr, j6);
                    if (bZza3 > -65 || ((bZza == -32 && bZza3 < -96) || (bZza == -19 && bZza3 >= -96))) {
                        break;
                    }
                    j6 += 2;
                    if (zznd.zza(bArr, j11) > -65) {
                        break;
                    }
                    j3 = j10;
                }
            } else if (i9 != 0) {
                i8 -= 2;
                if (bZza < -62) {
                    break;
                }
                long j12 = j6 + j3;
                if (zznd.zza(bArr, j6) > -65) {
                    break;
                }
                j = j3;
                j6 = j12;
            } else {
                return bZza;
            }
            j3 = j;
            i5 = 2;
            i6 = 3;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.drive.zznh
    final String zzg(byte[] bArr, int i, int i2) throws zzkq {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zznd.zza(bArr, i);
            if (!zzng.zzd(bZza)) {
                break;
            }
            i++;
            zzng.zza(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zznd.zza(bArr, i);
            if (zzng.zzd(bZza2)) {
                int i7 = i5 + 1;
                zzng.zza(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zznd.zza(bArr, i6);
                    if (!zzng.zzd(bZza3)) {
                        break;
                    }
                    i6++;
                    zzng.zza(bZza3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (zzng.zze(bZza2)) {
                if (i6 < i3) {
                    i += 2;
                    zzng.zza(bZza2, zznd.zza(bArr, i6), cArr, i5);
                    i5++;
                } else {
                    throw zzkq.zzdn();
                }
            } else if (zzng.zzf(bZza2)) {
                if (i6 < i3 - 1) {
                    int i8 = i + 2;
                    i += 3;
                    zzng.zza(bZza2, zznd.zza(bArr, i6), zznd.zza(bArr, i8), cArr, i5);
                    i5++;
                } else {
                    throw zzkq.zzdn();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzkq.zzdn();
                }
                byte bZza4 = zznd.zza(bArr, i6);
                int i9 = i + 3;
                byte bZza5 = zznd.zza(bArr, i + 2);
                i += 4;
                zzng.zza(bZza2, bZza4, bZza5, zznd.zza(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.drive.zznh
    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zznd.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 < 128 && j4 < j5) {
                zznd.zza(bArr, j4, (byte) cCharAt3);
                j3 = j5;
                j2 = j;
                j4 += j;
            } else if (cCharAt3 >= 2048 || j4 > j5 - 2) {
                j2 = j;
                if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                    j3 = j5;
                    if (j4 <= j3 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                zznd.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                zznd.zza(bArr, j4 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                zznd.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                zznd.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zznj(i4 - 1, length);
                    }
                    if (55296 > cCharAt3 || cCharAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    throw new zznj(i4, length);
                }
                zznd.zza(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                j3 = j5;
                long j7 = j4 + 2;
                zznd.zza(bArr, j4 + j2, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                j4 += 3;
                zznd.zza(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
            } else {
                j2 = j;
                long j8 = j4 + j2;
                zznd.zza(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                j4 += 2;
                zznd.zza(bArr, j8, (byte) ((cCharAt3 & '?') | 128));
                j3 = j5;
            }
            i4++;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zznf.zzay(i);
        }
        if (i2 == 1) {
            return zznf.zzr(i, zznd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zznf.zzc(i, zznd.zza(bArr, j), zznd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
