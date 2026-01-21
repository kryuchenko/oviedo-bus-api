package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes3.dex */
final class zzin extends zzio {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final byte zzv() throws IOException {
        int i = this.zzg;
        if (i == this.zze) {
            throw zzjs.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzc() {
        return this.zzg - this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zza(int i) throws zzjs {
        if (i < 0) {
            throw zzjs.zzf();
        }
        int iZzc = i + zzc();
        if (iZzc < 0) {
            throw zzjs.zzg();
        }
        int i2 = this.zzj;
        if (iZzc > i2) {
            throw zzjs.zzh();
        }
        this.zzj = iZzc;
        zzaa();
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzd() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zze() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzf() throws IOException {
        return zzx();
    }

    private final int zzw() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 4) {
            throw zzjs.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final int zzx() throws IOException {
        int i;
        int i2 = this.zzg;
        int i3 = this.zze;
        if (i3 != i2) {
            byte[] bArr = this.zzd;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzg = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzg = i5;
                return i;
            }
        }
        return (int) zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzg() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzh() throws IOException {
        return zze(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzi = 0;
            return 0;
        }
        int iZzx = zzx();
        this.zzi = iZzx;
        if ((iZzx >>> 3) != 0) {
            return iZzx;
        }
        throw zzjs.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzj() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final long zzk() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final long zzl() throws IOException {
        return zzz();
    }

    private final long zzy() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 8) {
            throw zzjs.zzh();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final long zzz() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.zzg;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzg = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            j4 = (-2080896) ^ i9;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (bArr[i8] << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                i8 = i + 6;
                                long j7 = j6 ^ (bArr[i4] << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (bArr[i8] << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (bArr[i4] << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (bArr[i8] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i10 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i10;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j4 = j2 ^ j7;
                            }
                            j = j3 ^ j6;
                        }
                        i4 = i8;
                        j = j4;
                    }
                }
                this.zzg = i4;
                return j;
            }
        }
        return zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzv() & 128) == 0) {
                return j;
            }
        }
        throw zzjs.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final long zzn() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final long zzo() throws IOException {
        return zza(zzz());
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final long zzp() throws IOException {
        return zzz();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.measurement.zzio
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzia zzq() throws IOException {
        byte[] bArrCopyOfRange;
        int iZzx = zzx();
        if (iZzx > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (iZzx <= i - i2) {
                zzia zziaVarZza = zzia.zza(this.zzd, i2, iZzx);
                this.zzg += iZzx;
                return zziaVarZza;
            }
        }
        if (iZzx == 0) {
            return zzia.zza;
        }
        if (iZzx > 0) {
            int i3 = this.zze;
            int i4 = this.zzg;
            if (iZzx <= i3 - i4) {
                int i5 = iZzx + i4;
                this.zzg = i5;
                bArrCopyOfRange = Arrays.copyOfRange(this.zzd, i4, i5);
            } else {
                if (iZzx > 0) {
                    throw zzjs.zzh();
                }
                if (iZzx == 0) {
                    bArrCopyOfRange = zzjm.zzb;
                } else {
                    throw zzjs.zzf();
                }
            }
        }
        return zzia.zzb(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final String zzr() throws IOException {
        int iZzx = zzx();
        if (iZzx > 0 && iZzx <= this.zze - this.zzg) {
            String str = new String(this.zzd, this.zzg, iZzx, zzjm.zza);
            this.zzg += iZzx;
            return str;
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx < 0) {
            throw zzjs.zzf();
        }
        throw zzjs.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final String zzs() throws IOException {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (iZzx <= i - i2) {
                String strZzb = zzmk.zzb(this.zzd, i2, iZzx);
                this.zzg += iZzx;
                return strZzb;
            }
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx <= 0) {
            throw zzjs.zzf();
        }
        throw zzjs.zzh();
    }

    private zzin(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzj = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zze = i2 + i;
        this.zzg = i;
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final void zzb(int i) throws zzjs {
        if (this.zzi != i) {
            throw zzjs.zzb();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final void zzc(int i) {
        this.zzj = i;
        zzaa();
    }

    private final void zzaa() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i2 = i - this.zzh;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzf = i4;
            this.zze = i - i4;
            return;
        }
        this.zzf = 0;
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zze;
            int i3 = this.zzg;
            if (i <= i2 - i3) {
                this.zzg = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzjs.zzf();
        }
        throw zzjs.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final boolean zzt() throws IOException {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final boolean zzu() throws IOException {
        return zzz() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final boolean zzd(int i) throws IOException {
        int iZzi;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzg;
                    this.zzg = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzjs.zze();
            }
            while (i3 < 10) {
                if (zzv() < 0) {
                    i3++;
                }
            }
            throw zzjs.zze();
            return true;
        }
        if (i2 == 1) {
            zzf(8);
            return true;
        }
        if (i2 == 2) {
            zzf(zzx());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzf(4);
                return true;
            }
            throw zzjs.zza();
        }
        do {
            iZzi = zzi();
            if (iZzi == 0) {
                break;
            }
        } while (zzd(iZzi));
        zzb(((i >>> 3) << 3) | 4);
        return true;
    }
}
