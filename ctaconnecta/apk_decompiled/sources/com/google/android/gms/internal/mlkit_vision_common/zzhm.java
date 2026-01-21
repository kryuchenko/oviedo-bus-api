package com.google.android.gms.internal.mlkit_vision_common;

import net.sf.scuba.smartcards.ISO7816;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhm extends zzhl {
    zzhm() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0096, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zza(int i, byte[] bArr, int i2, int i3) {
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
                if (zzhg.zza(bArr, j4) < 0) {
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
                bZza = zzhg.zza(bArr, j6);
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
                        byte bZza2 = zzhg.zza(bArr, j6);
                        if (bZza2 <= -65 && (((bZza << 28) + (bZza2 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                            long j9 = j6 + 2;
                            if (zzhg.zza(bArr, j8) > -65) {
                                break;
                            }
                            j6 += 3;
                            if (zzhg.zza(bArr, j9) > -65) {
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
                    byte bZza3 = zzhg.zza(bArr, j6);
                    if (bZza3 > -65 || ((bZza == -32 && bZza3 < -96) || (bZza == -19 && bZza3 >= -96))) {
                        break;
                    }
                    j6 += 2;
                    if (zzhg.zza(bArr, j11) > -65) {
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
                if (zzhg.zza(bArr, j6) > -65) {
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhl
    final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            zzhg.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 < 128 && j4 < j5) {
                zzhg.zza(bArr, j4, (byte) cCharAt3);
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
                                zzhg.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                zzhg.zza(bArr, j4 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                zzhg.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                zzhg.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzhn(i4 - 1, length);
                    }
                    if (55296 > cCharAt3 || cCharAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    throw new zzhn(i4, length);
                }
                zzhg.zza(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                j3 = j5;
                long j7 = j4 + 2;
                zzhg.zza(bArr, j4 + j2, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                j4 += 3;
                zzhg.zza(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
            } else {
                j2 = j;
                long j8 = j4 + j2;
                zzhg.zza(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                j4 += 2;
                zzhg.zza(bArr, j8, (byte) ((cCharAt3 & '?') | 128));
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
            return zzhj.zzb(i);
        }
        if (i2 == 1) {
            return zzhj.zzb(i, zzhg.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzhj.zzb(i, zzhg.zza(bArr, j), zzhg.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
