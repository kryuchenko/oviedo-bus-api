package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdw extends zzdg {
    private static final Logger zzb = Logger.getLogger(zzdw.class.getName());
    private static final boolean zzc = zzhg.zza();
    zzdz zza;

    public static zzdw zza(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zze(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzg(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzj(int i) {
        return 4;
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zza(int i) throws IOException;

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzdj zzdjVar) throws IOException;

    public abstract void zza(int i, zzfv zzfvVar) throws IOException;

    abstract void zza(int i, zzfv zzfvVar, zzgi zzgiVar) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzdj zzdjVar) throws IOException;

    public abstract void zza(zzfv zzfvVar) throws IOException;

    public abstract void zza(String str) throws IOException;

    public abstract void zzb(int i) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, zzdj zzdjVar) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(long j) throws IOException;

    public abstract void zzd(int i) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzb(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzdw() {
    }

    public final void zzd(int i, int i2) throws IOException {
        zzc(i, zzm(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzi(j));
    }

    public final void zza(int i, float f) throws IOException {
        zze(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzc(int i) throws IOException {
        zzb(zzm(i));
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    static class zza extends zzdw {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.zzb = bArr;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = i2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i, int i2) throws IOException {
            zzb((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzb(int i, int i2) throws IOException {
            zza(i, 0);
            zza(i2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzc(int i, int i2) throws IOException {
            zza(i, 0);
            zzb(i2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zze(int i, int i2) throws IOException {
            zza(i, 5);
            zzd(i2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i, long j) throws IOException {
            zza(i, 0);
            zza(j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzc(int i, long j) throws IOException {
            zza(i, 1);
            zzc(j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i, boolean z) throws IOException {
            zza(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i, String str) throws IOException {
            zza(i, 2);
            zza(str);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i, zzdj zzdjVar) throws IOException {
            zza(i, 2);
            zza(zzdjVar);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(zzdj zzdjVar) throws IOException {
            zzb(zzdjVar.zza());
            zzdjVar.zza(this);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzb(i2);
            zzc(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        final void zza(int i, zzfv zzfvVar, zzgi zzgiVar) throws IOException {
            zza(i, 2);
            zzda zzdaVar = (zzda) zzfvVar;
            int iZzg = zzdaVar.zzg();
            if (iZzg == -1) {
                iZzg = zzgiVar.zzd(zzdaVar);
                zzdaVar.zza(iZzg);
            }
            zzb(iZzg);
            zzgiVar.zza((zzgi) zzfvVar, (zzhu) this.zza);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i, zzfv zzfvVar) throws IOException {
            zza(1, 3);
            zzc(2, i);
            zza(3, 2);
            zza(zzfvVar);
            zza(1, 4);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzb(int i, zzdj zzdjVar) throws IOException {
            zza(1, 3);
            zzc(2, i);
            zza(3, zzdjVar);
            zza(1, 4);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(zzfv zzfvVar) throws IOException {
            zzb(zzfvVar.zzj());
            zzfvVar.zza(this);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(int i) throws IOException {
            if (i >= 0) {
                zzb(i);
            } else {
                zza(i);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzb(int i) throws IOException {
            if (!zzdw.zzc || zzdh.zza() || zza() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.zzb;
                        int i2 = this.zze;
                        this.zze = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                    }
                }
                byte[] bArr2 = this.zzb;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzhg.zza(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zze;
            this.zze = i5 + 1;
            zzhg.zza(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.zzb;
                int i7 = this.zze;
                this.zze = i7 + 1;
                zzhg.zza(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.zzb;
            int i8 = this.zze;
            this.zze = i8 + 1;
            zzhg.zza(bArr6, i8, (byte) (i6 | 128));
            int i9 = i >>> 14;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.zzb;
                int i10 = this.zze;
                this.zze = i10 + 1;
                zzhg.zza(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.zzb;
            int i11 = this.zze;
            this.zze = i11 + 1;
            zzhg.zza(bArr8, i11, (byte) (i9 | 128));
            int i12 = i >>> 21;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.zzb;
                int i13 = this.zze;
                this.zze = i13 + 1;
                zzhg.zza(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.zzb;
            int i14 = this.zze;
            this.zze = i14 + 1;
            zzhg.zza(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.zzb;
            int i15 = this.zze;
            this.zze = i15 + 1;
            zzhg.zza(bArr11, i15, (byte) (i >>> 28));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzd(int i) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                int i3 = i2 + 1;
                this.zze = i3;
                bArr[i2] = (byte) i;
                int i4 = i2 + 2;
                this.zze = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i2 + 3;
                this.zze = i5;
                bArr[i4] = (byte) (i >> 16);
                this.zze = i2 + 4;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(long j) throws IOException {
            if (zzdw.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    zzhg.zza(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                zzhg.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zze;
            this.zze = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zzc(long j) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                int i2 = i + 1;
                this.zze = i2;
                bArr[i] = (byte) j;
                int i3 = i + 2;
                this.zze = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i + 3;
                this.zze = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i + 4;
                this.zze = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i + 5;
                this.zze = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i + 6;
                this.zze = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i + 7;
                this.zze = i8;
                bArr[i7] = (byte) (j >> 48);
                this.zze = i + 8;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdg
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final void zza(String str) throws IOException {
            int i = this.zze;
            try {
                int iZzg = zzg(str.length() * 3);
                int iZzg2 = zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i2 = i + iZzg2;
                    this.zze = i2;
                    int iZza = zzhj.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzb((iZza - i) - iZzg2);
                    this.zze = iZza;
                    return;
                }
                zzb(zzhj.zza(str));
                this.zze = zzhj.zza(str, this.zzb, this.zze, zza());
            } catch (zzhn e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzdw
        public final int zza() {
            return this.zzd - this.zze;
        }
    }

    public final void zzb(long j) throws IOException {
        zza(zzi(j));
    }

    public final void zza(float f) throws IOException {
        zzd(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzc(Double.doubleToRawLongBits(d));
    }

    public final void zza(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public static int zzf(int i, int i2) {
        return zze(i) + zzf(i2);
    }

    public static int zzg(int i, int i2) {
        return zze(i) + zzg(i2);
    }

    public static int zzh(int i, int i2) {
        return zze(i) + zzg(zzm(i2));
    }

    public static int zzi(int i, int i2) {
        return zze(i) + 4;
    }

    public static int zzj(int i, int i2) {
        return zze(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zze(i) + zze(j);
    }

    public static int zze(int i, long j) {
        return zze(i) + zze(j);
    }

    public static int zzf(int i, long j) {
        return zze(i) + zze(zzi(j));
    }

    public static int zzg(int i, long j) {
        return zze(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zze(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zze(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zze(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zze(i) + 1;
    }

    public static int zzk(int i, int i2) {
        return zze(i) + zzf(i2);
    }

    public static int zzb(int i, String str) {
        return zze(i) + zzb(str);
    }

    public static int zzc(int i, zzdj zzdjVar) {
        int iZze = zze(i);
        int iZza = zzdjVar.zza();
        return iZze + zzg(iZza) + iZza;
    }

    public static int zza(int i, zzfa zzfaVar) {
        int iZze = zze(i);
        int iZzb = zzfaVar.zzb();
        return iZze + zzg(iZzb) + iZzb;
    }

    static int zzb(int i, zzfv zzfvVar, zzgi zzgiVar) {
        return zze(i) + zza(zzfvVar, zzgiVar);
    }

    public static int zzb(int i, zzfv zzfvVar) {
        return (zze(1) << 1) + zzg(2, i) + zze(3) + zzb(zzfvVar);
    }

    public static int zzd(int i, zzdj zzdjVar) {
        return (zze(1) << 1) + zzg(2, i) + zzc(3, zzdjVar);
    }

    public static int zzb(int i, zzfa zzfaVar) {
        return (zze(1) << 1) + zzg(2, i) + zza(3, zzfaVar);
    }

    public static int zze(int i) {
        return zzg(i << 3);
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzg(i);
        }
        return 10;
    }

    public static int zzh(int i) {
        return zzg(zzm(i));
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public static int zzk(int i) {
        return zzf(i);
    }

    public static int zzb(String str) {
        int length;
        try {
            length = zzhj.zza(str);
        } catch (zzhn unused) {
            length = str.getBytes(zzem.zza).length;
        }
        return zzg(length) + length;
    }

    public static int zza(zzfa zzfaVar) {
        int iZzb = zzfaVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zzb(zzdj zzdjVar) {
        int iZza = zzdjVar.zza();
        return zzg(iZza) + iZza;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzb(zzfv zzfvVar) {
        int iZzj = zzfvVar.zzj();
        return zzg(iZzj) + iZzj;
    }

    static int zza(zzfv zzfvVar, zzgi zzgiVar) {
        zzda zzdaVar = (zzda) zzfvVar;
        int iZzg = zzdaVar.zzg();
        if (iZzg == -1) {
            iZzg = zzgiVar.zzd(zzdaVar);
            zzdaVar.zza(iZzg);
        }
        return zzg(iZzg) + iZzg;
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zzhn zzhnVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhnVar);
        byte[] bytes = str.getBytes(zzem.zza);
        try {
            zzb(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    @Deprecated
    static int zzc(int i, zzfv zzfvVar, zzgi zzgiVar) {
        int iZze = zze(i) << 1;
        zzda zzdaVar = (zzda) zzfvVar;
        int iZzg = zzdaVar.zzg();
        if (iZzg == -1) {
            iZzg = zzgiVar.zzd(zzdaVar);
            zzdaVar.zza(iZzg);
        }
        return iZze + iZzg;
    }

    @Deprecated
    public static int zzc(zzfv zzfvVar) {
        return zzfvVar.zzj();
    }

    @Deprecated
    public static int zzl(int i) {
        return zzg(i);
    }
}
