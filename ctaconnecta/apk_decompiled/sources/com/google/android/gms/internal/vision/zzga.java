package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzga extends zzfy {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzsz;
    private int zzta;
    private int zztb;
    private int zztc;
    private int zztd;

    private zzga(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zztd = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zztb = i;
        this.zzsz = z;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzey() throws IOException {
        if (zzdu()) {
            this.zztc = 0;
            return 0;
        }
        int iZzfb = zzfb();
        this.zztc = iZzfb;
        if ((iZzfb >>> 3) != 0) {
            return iZzfb;
        }
        throw zzhh.zzgq();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final void zzar(int i) throws zzhh {
        if (this.zztc != i) {
            throw zzhh.zzgr();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final boolean zzas(int i) throws IOException {
        int iZzey;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzhh.zzgp();
            }
            while (i3 < 10) {
                if (zzfg() < 0) {
                    i3++;
                }
            }
            throw zzhh.zzgp();
            return true;
        }
        if (i2 == 1) {
            zzaw(8);
            return true;
        }
        if (i2 == 2) {
            zzaw(zzfb());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzaw(4);
                return true;
            }
            throw zzhh.zzgs();
        }
        do {
            iZzey = zzey();
            if (iZzey == 0) {
                break;
            }
        } while (zzas(iZzey));
        zzar(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzfe());
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzfd());
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzdx() throws IOException {
        return zzfc();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzdy() throws IOException {
        return zzfc();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzdz() throws IOException {
        return zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzea() throws IOException {
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzeb() throws IOException {
        return zzfd();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final boolean zzec() throws IOException {
        return zzfc() != 0;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final String readString() throws IOException {
        int iZzfb = zzfb();
        if (iZzfb > 0 && iZzfb <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, iZzfb, zzgy.UTF_8);
            this.pos += iZzfb;
            return str;
        }
        if (iZzfb == 0) {
            return "";
        }
        if (iZzfb < 0) {
            throw zzhh.zzgo();
        }
        throw zzhh.zzgn();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final String zzed() throws IOException {
        int iZzfb = zzfb();
        if (iZzfb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (iZzfb <= i - i2) {
                String strZzh = zzjx.zzh(this.buffer, i2, iZzfb);
                this.pos += iZzfb;
                return strZzh;
            }
        }
        if (iZzfb == 0) {
            return "";
        }
        if (iZzfb <= 0) {
            throw zzhh.zzgo();
        }
        throw zzhh.zzgn();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.vision.zzfy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzfm zzee() throws IOException {
        byte[] bArrCopyOfRange;
        int iZzfb = zzfb();
        if (iZzfb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (iZzfb <= i - i2) {
                zzfm zzfmVarZza = zzfm.zza(this.buffer, i2, iZzfb);
                this.pos += iZzfb;
                return zzfmVarZza;
            }
        }
        if (iZzfb == 0) {
            return zzfm.zzsm;
        }
        if (iZzfb > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (iZzfb <= i3 - i4) {
                int i5 = iZzfb + i4;
                this.pos = i5;
                bArrCopyOfRange = Arrays.copyOfRange(this.buffer, i4, i5);
            } else {
                if (iZzfb > 0) {
                    throw zzhh.zzgn();
                }
                if (iZzfb == 0) {
                    bArrCopyOfRange = zzgy.zzxr;
                } else {
                    throw zzhh.zzgo();
                }
            }
        }
        return zzfm.zzd(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzef() throws IOException {
        return zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzeg() throws IOException {
        return zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzeh() throws IOException {
        return zzfd();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzei() throws IOException {
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzej() throws IOException {
        return zzav(zzfb());
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzek() throws IOException {
        return zzr(zzfc());
    }

    private final int zzfb() throws IOException {
        int i;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
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
                this.pos = i5;
                return i;
            }
        }
        return (int) zzez();
    }

    private final long zzfc() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.pos;
        int i2 = this.limit;
        if (i2 != i) {
            byte[] bArr = this.buffer;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.pos = i3;
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
                this.pos = i4;
                return j;
            }
        }
        return zzez();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    final long zzez() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzfg() & 128) == 0) {
                return j;
            }
        }
        throw zzhh.zzgp();
    }

    private final int zzfd() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzhh.zzgn();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzfe() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzhh.zzgn();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzat(int i) throws zzhh {
        if (i < 0) {
            throw zzhh.zzgo();
        }
        int iZzfa = i + zzfa();
        int i2 = this.zztd;
        if (iZzfa > i2) {
            throw zzhh.zzgn();
        }
        this.zztd = iZzfa;
        zzff();
        return i2;
    }

    private final void zzff() {
        int i = this.limit + this.zzta;
        this.limit = i;
        int i2 = i - this.zztb;
        int i3 = this.zztd;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzta = i4;
            this.limit = i - i4;
            return;
        }
        this.zzta = 0;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final void zzau(int i) {
        this.zztd = i;
        zzff();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final boolean zzdu() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzfa() {
        return this.pos - this.zztb;
    }

    private final byte zzfg() throws IOException {
        int i = this.pos;
        if (i == this.limit) {
            throw zzhh.zzgn();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzaw(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzhh.zzgo();
        }
        throw zzhh.zzgn();
    }
}
