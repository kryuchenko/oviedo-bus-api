package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jmrtd.PassportService;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwb implements Cloneable, ByteChannel, zzbwd, zzbwc, AutoCloseable {
    public zzbwn zza;
    private long zzb;

    public final /* synthetic */ Object clone() {
        zzbwb zzbwbVar = new zzbwb();
        if (this.zzb == 0) {
            return zzbwbVar;
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        zzbwn zzbwnVarZzc = zzbwnVar.zzc();
        zzbwbVar.zza = zzbwnVarZzc;
        zzbwnVarZzc.zzh = zzbwnVarZzc;
        zzbwnVarZzc.zzg = zzbwnVarZzc.zzh;
        for (zzbwn zzbwnVar2 = zzbwnVar.zzg; zzbwnVar2 != zzbwnVar; zzbwnVar2 = zzbwnVar2.zzg) {
            zzbwn zzbwnVar3 = zzbwnVarZzc.zzh;
            Intrinsics.checkNotNull(zzbwnVar3);
            Intrinsics.checkNotNull(zzbwnVar2);
            zzbwnVar3.zzb(zzbwnVar2.zzc());
        }
        zzbwbVar.zzb = this.zzb;
        return zzbwbVar;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbws
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbwb)) {
            return false;
        }
        long j = this.zzb;
        zzbwb zzbwbVar = (zzbwb) obj;
        if (j != zzbwbVar.zzb) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwbVar.zza;
        Intrinsics.checkNotNull(zzbwnVar2);
        int i = zzbwnVar.zzc;
        int i2 = zzbwnVar2.zzc;
        long j2 = 0;
        while (j2 < this.zzb) {
            long jMin = Math.min(zzbwnVar.zzd - i, zzbwnVar2.zzd - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (zzbwnVar.zzb[i] != zzbwnVar2.zzb[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == zzbwnVar.zzd) {
                zzbwnVar = zzbwnVar.zzg;
                Intrinsics.checkNotNull(zzbwnVar);
                i = zzbwnVar.zzc;
            }
            if (i2 == zzbwnVar2.zzd) {
                zzbwnVar2 = zzbwnVar2.zzg;
                Intrinsics.checkNotNull(zzbwnVar2);
                i2 = zzbwnVar2.zzc;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc, com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    public final void flush() {
    }

    public final int hashCode() {
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = zzbwnVar.zzd;
            for (int i3 = zzbwnVar.zzc; i3 < i2; i3++) {
                i = (i * 31) + zzbwnVar.zzb[i3];
            }
            zzbwnVar = zzbwnVar.zzg;
            Intrinsics.checkNotNull(zzbwnVar);
        } while (zzbwnVar != this.zza);
        return i;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), zzbwnVar.zzd - zzbwnVar.zzc);
        sink.put(zzbwnVar.zzb, zzbwnVar.zzc, iMin);
        int i = zzbwnVar.zzc + iMin;
        zzbwnVar.zzc = i;
        this.zzb -= iMin;
        if (i == zzbwnVar.zzd) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        }
        return iMin;
    }

    public final String toString() {
        return zzz().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            zzbwn zzbwnVarZzB = zzB(1);
            int iMin = Math.min(i, 8192 - zzbwnVarZzB.zzd);
            source.get(zzbwnVarZzB.zzb, zzbwnVarZzB.zzd, iMin);
            i -= iMin;
            zzbwnVarZzB.zzd += iMin;
        }
        this.zzb += iRemaining;
        return iRemaining;
    }

    public final short zzC() throws EOFException {
        int iZzc;
        if (this.zzb < 2) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        int i = zzbwnVar.zzc;
        int i2 = zzbwnVar.zzd;
        if (i2 - i < 2) {
            iZzc = ((zzc() & 255) << 8) | (zzc() & 255);
        } else {
            byte[] bArr = zzbwnVar.zzb;
            int i3 = (bArr[i] & 255) << 8;
            int i4 = bArr[i + 1] & 255;
            this.zzb -= 2;
            int i5 = i + 2;
            if (i5 == i2) {
                this.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            } else {
                zzbwnVar.zzc = i5;
            }
            iZzc = i3 | i4;
        }
        return (short) iZzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzD(long j) throws EOFException {
        throw null;
    }

    public final void zzE(long j) {
        this.zzb = j;
    }

    public final boolean zzG() {
        return this.zzb == 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.zzb;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        sink.zzn(this, j);
        return j;
    }

    public final byte zzb(long j) {
        zzbvv.zzb(this.zzb, j, 1L);
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        long j2 = this.zzb;
        if (j2 - j < j) {
            while (j2 > j) {
                zzbwnVar = zzbwnVar.zzh;
                Intrinsics.checkNotNull(zzbwnVar);
                j2 -= zzbwnVar.zzd - zzbwnVar.zzc;
            }
            Intrinsics.checkNotNull(zzbwnVar);
            return zzbwnVar.zzb[(int) ((zzbwnVar.zzc + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            long j4 = (zzbwnVar.zzd - zzbwnVar.zzc) + j3;
            if (j4 > j) {
                Intrinsics.checkNotNull(zzbwnVar);
                return zzbwnVar.zzb[(int) ((zzbwnVar.zzc + j) - j3)];
            }
            zzbwnVar = zzbwnVar.zzg;
            Intrinsics.checkNotNull(zzbwnVar);
            j3 = j4;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final byte zzc() throws EOFException {
        if (this.zzb == 0) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        int i = zzbwnVar.zzc;
        int i2 = zzbwnVar.zzd;
        int i3 = i + 1;
        byte b = zzbwnVar.zzb[i];
        this.zzb--;
        if (i3 != i2) {
            zzbwnVar.zzc = i3;
            return b;
        }
        this.zza = zzbwnVar.zza();
        zzbwo.zzb(zzbwnVar);
        return b;
    }

    public final int zzd(byte[] sink, int i, int i2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbvv.zzb(sink.length, i, i2);
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, zzbwnVar.zzd - zzbwnVar.zzc);
        int i3 = zzbwnVar.zzc;
        ArraysKt.copyInto(zzbwnVar.zzb, sink, i, i3, i3 + iMin);
        int i4 = zzbwnVar.zzc + iMin;
        zzbwnVar.zzc = i4;
        this.zzb -= iMin;
        if (i4 != zzbwnVar.zzd) {
            return iMin;
        }
        this.zza = zzbwnVar.zza();
        zzbwo.zzb(zzbwnVar);
        return iMin;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final int zze() throws EOFException {
        if (this.zzb < 4) {
            throw new EOFException(null);
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        int i = zzbwnVar.zzc;
        int i2 = zzbwnVar.zzd;
        if (i2 - i < 4) {
            return ((zzc() & 255) << 24) | ((zzc() & 255) << 16) | ((zzc() & 255) << 8) | (zzc() & 255);
        }
        byte[] bArr = zzbwnVar.zzb;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = (bArr[i + 1] & 255) << 16;
        int i5 = (bArr[i + 2] & 255) << 8;
        this.zzb -= 4;
        int i6 = (bArr[i + 3] & 255) | i4 | i3 | i5;
        int i7 = i + 4;
        if (i7 != i2) {
            zzbwnVar.zzc = i7;
            return i6;
        }
        this.zza = zzbwnVar.zza();
        zzbwo.zzb(zzbwnVar);
        return i6;
    }

    public final long zzf() {
        long j = this.zzb;
        if (j == 0) {
            return 0L;
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwnVar.zzh;
        Intrinsics.checkNotNull(zzbwnVar2);
        return (zzbwnVar2.zzd >= 8192 || !zzbwnVar2.zzf) ? j : j - (r3 - zzbwnVar2.zzc);
    }

    public final long zzg() {
        return this.zzb;
    }

    public final String zzi() {
        return zzh(this.zzb, Charsets.UTF_8);
    }

    public final zzbwb zzk(zzbwf byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.zzj(this, 0, byteString.zzc());
        return this;
    }

    public final zzbwb zzl(byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        zzbvv.zzb(source.length, i, j);
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                this.zzb += j;
                return this;
            }
            zzbwn zzbwnVarZzB = zzB(1);
            int iMin = Math.min(i4 - i3, 8192 - zzbwnVarZzB.zzd);
            int i5 = i3 + iMin;
            ArraysKt.copyInto(source, zzbwnVarZzB.zzb, zzbwnVarZzB.zzd, i3, i5);
            zzbwnVarZzB.zzd += iMin;
            i3 = i5;
        }
    }

    public final zzbwb zzm(int i) {
        zzbwn zzbwnVarZzB = zzB(1);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i2 = zzbwnVarZzB.zzd;
        zzbwnVarZzB.zzd = i2 + 1;
        bArr[i2] = (byte) i;
        this.zzb++;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwq
    public final void zzn(zzbwb source, long j) {
        zzbwn zzbwnVar;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        zzbvv.zzb(source.zzb, 0L, j);
        while (j > 0) {
            zzbwn zzbwnVar2 = source.zza;
            Intrinsics.checkNotNull(zzbwnVar2);
            int i = zzbwnVar2.zzd;
            Intrinsics.checkNotNull(source.zza);
            int i2 = 0;
            if (j < i - r1.zzc) {
                zzbwn zzbwnVar3 = this.zza;
                if (zzbwnVar3 != null) {
                    Intrinsics.checkNotNull(zzbwnVar3);
                    zzbwnVar = zzbwnVar3.zzh;
                } else {
                    zzbwnVar = null;
                }
                int i3 = (int) j;
                if (zzbwnVar != null && zzbwnVar.zzf) {
                    if ((zzbwnVar.zzd + j) - (zzbwnVar.zze ? 0 : zzbwnVar.zzc) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        zzbwn zzbwnVar4 = source.zza;
                        Intrinsics.checkNotNull(zzbwnVar4);
                        zzbwnVar4.zze(zzbwnVar, i3);
                        source.zzb -= j;
                        this.zzb += j;
                        return;
                    }
                }
                zzbwn zzbwnVar5 = source.zza;
                Intrinsics.checkNotNull(zzbwnVar5);
                source.zza = zzbwnVar5.zzd(i3);
            }
            zzbwn zzbwnVar6 = source.zza;
            Intrinsics.checkNotNull(zzbwnVar6);
            int i4 = zzbwnVar6.zzd - zzbwnVar6.zzc;
            source.zza = zzbwnVar6.zza();
            zzbwn zzbwnVar7 = this.zza;
            if (zzbwnVar7 == null) {
                this.zza = zzbwnVar6;
                zzbwnVar6.zzh = zzbwnVar6;
                zzbwnVar6.zzg = zzbwnVar6.zzh;
            } else {
                Intrinsics.checkNotNull(zzbwnVar7);
                zzbwn zzbwnVar8 = zzbwnVar7.zzh;
                Intrinsics.checkNotNull(zzbwnVar8);
                zzbwnVar8.zzb(zzbwnVar6);
                zzbwn zzbwnVar9 = zzbwnVar6.zzh;
                if (zzbwnVar9 == zzbwnVar6) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.checkNotNull(zzbwnVar9);
                if (zzbwnVar9.zzf) {
                    int i5 = zzbwnVar6.zzd - zzbwnVar6.zzc;
                    zzbwn zzbwnVar10 = zzbwnVar6.zzh;
                    Intrinsics.checkNotNull(zzbwnVar10);
                    int i6 = 8192 - zzbwnVar10.zzd;
                    zzbwn zzbwnVar11 = zzbwnVar6.zzh;
                    Intrinsics.checkNotNull(zzbwnVar11);
                    if (!zzbwnVar11.zze) {
                        zzbwn zzbwnVar12 = zzbwnVar6.zzh;
                        Intrinsics.checkNotNull(zzbwnVar12);
                        i2 = zzbwnVar12.zzc;
                    }
                    if (i5 <= i6 + i2) {
                        zzbwn zzbwnVar13 = zzbwnVar6.zzh;
                        Intrinsics.checkNotNull(zzbwnVar13);
                        zzbwnVar6.zze(zzbwnVar13, i5);
                        zzbwnVar6.zza();
                        zzbwo.zzb(zzbwnVar6);
                    }
                }
            }
            long j2 = i4;
            source.zzb -= j2;
            this.zzb += j2;
            j -= j2;
        }
    }

    public final zzbwb zzo(long j) {
        if (j == 0) {
            zzm(48);
            return this;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 - ((j5 >>> 1) & 6148914691236517205L);
        long j7 = ((j6 >>> 2) & 3689348814741910323L) + (j6 & 3689348814741910323L);
        long j8 = ((j7 >>> 4) + j7) & 1085102592571150095L;
        long j9 = j8 + (j8 >>> 8);
        long j10 = j9 + (j9 >>> 16);
        int i = (int) ((((j10 & 63) + ((j10 >>> 32) & 63)) + 3) >> 2);
        zzbwn zzbwnVarZzB = zzB(i);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i2 = zzbwnVarZzB.zzd;
        int i3 = i2 + i;
        while (true) {
            i3--;
            if (i3 < i2) {
                zzbwnVarZzB.zzd += i;
                this.zzb += i;
                return this;
            }
            bArr[i3] = zzbwx.zza()[(int) (15 & j)];
            j >>>= 4;
        }
    }

    public final zzbwb zzp(int i) {
        zzbwn zzbwnVarZzB = zzB(4);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i2 = zzbwnVarZzB.zzd;
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        zzbwnVarZzB.zzd = i2 + 4;
        this.zzb += 4;
        return this;
    }

    public final zzbwb zzq(int i) {
        zzbwn zzbwnVarZzB = zzB(2);
        byte[] bArr = zzbwnVarZzB.zzb;
        int i2 = zzbwnVarZzB.zzd;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        zzbwnVarZzB.zzd = i2 + 2;
        this.zzb += 2;
        return this;
    }

    public final zzbwb zzr(OutputStream out, long j) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        zzbvv.zzb(this.zzb, 0L, j);
        zzbwn zzbwnVar = this.zza;
        long j2 = j;
        while (j2 > 0) {
            Intrinsics.checkNotNull(zzbwnVar);
            int iMin = (int) Math.min(j2, zzbwnVar.zzd - zzbwnVar.zzc);
            out.write(zzbwnVar.zzb, zzbwnVar.zzc, iMin);
            int i = zzbwnVar.zzc + iMin;
            zzbwnVar.zzc = i;
            long j3 = iMin;
            this.zzb -= j3;
            j2 -= j3;
            if (i == zzbwnVar.zzd) {
                zzbwn zzbwnVarZza = zzbwnVar.zza();
                this.zza = zzbwnVarZza;
                zzbwo.zzb(zzbwnVar);
                zzbwnVar = zzbwnVarZza;
            }
        }
        return this;
    }

    public final zzbwb zzs(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        zzt(string, 0, string.length());
        return this;
    }

    public final zzbwb zzt(String string, int i, int i2) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < 0");
        }
        if (i2 > string.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + string.length());
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char cCharAt = string.charAt(i3);
            if (cCharAt < 128) {
                zzbwn zzbwnVarZzB = zzB(1);
                byte[] bArr = zzbwnVarZzB.zzb;
                int i5 = zzbwnVarZzB.zzd - i3;
                int iMin = Math.min(i2, 8192 - i5);
                bArr[i3 + i5] = (byte) cCharAt;
                i3 = i4;
                while (i3 < iMin) {
                    char cCharAt2 = string.charAt(i3);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i5] = (byte) cCharAt2;
                    i3++;
                }
                int i6 = zzbwnVarZzB.zzd;
                int i7 = (i5 + i3) - i6;
                zzbwnVarZzB.zzd = i6 + i7;
                this.zzb += i7;
            } else {
                if (cCharAt < 2048) {
                    zzbwn zzbwnVarZzB2 = zzB(2);
                    byte[] bArr2 = zzbwnVarZzB2.zzb;
                    int i8 = zzbwnVarZzB2.zzd;
                    bArr2[i8] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((cCharAt & '?') | 128);
                    zzbwnVarZzB2.zzd = i8 + 2;
                    this.zzb += 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    zzbwn zzbwnVarZzB3 = zzB(3);
                    byte[] bArr3 = zzbwnVarZzB3.zzb;
                    int i9 = zzbwnVarZzB3.zzd;
                    bArr3[i9] = (byte) ((cCharAt >> '\f') | PassportService.DEFAULT_MAX_BLOCKSIZE);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt & '?') | 128);
                    zzbwnVarZzB3.zzd = i9 + 3;
                    this.zzb += 3;
                } else {
                    char cCharAt3 = i4 < i2 ? string.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 >= 57344) {
                        zzm(63);
                    } else {
                        zzbwn zzbwnVarZzB4 = zzB(4);
                        byte[] bArr4 = zzbwnVarZzB4.zzb;
                        int i10 = zzbwnVarZzB4.zzd;
                        int i11 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        bArr4[i10] = (byte) ((i11 >> 18) | 240);
                        bArr4[i10 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i10 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i10 + 3] = (byte) ((i11 & 63) | 128);
                        zzbwnVarZzB4.zzd = i10 + 4;
                        this.zzb += 4;
                        i3 += 2;
                    }
                }
                i3 = i4;
            }
        }
        return this;
    }

    public final zzbwb zzu(int i) {
        if (i < 128) {
            zzm(i);
            return this;
        }
        if (i < 2048) {
            zzbwn zzbwnVarZzB = zzB(2);
            byte[] bArr = zzbwnVarZzB.zzb;
            int i2 = zzbwnVarZzB.zzd;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            zzbwnVarZzB.zzd = i2 + 2;
            this.zzb += 2;
            return this;
        }
        if (i >= 55296 && i < 57344) {
            zzm(63);
            return this;
        }
        if (i < 65536) {
            zzbwn zzbwnVarZzB2 = zzB(3);
            byte[] bArr2 = zzbwnVarZzB2.zzb;
            int i3 = zzbwnVarZzB2.zzd;
            bArr2[i3] = (byte) ((i >> 12) | PassportService.DEFAULT_MAX_BLOCKSIZE);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            zzbwnVarZzB2.zzd = i3 + 3;
            this.zzb += 3;
            return this;
        }
        if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(String.valueOf(zzbvv.zza(i))));
        }
        zzbwn zzbwnVarZzB3 = zzB(4);
        byte[] bArr3 = zzbwnVarZzB3.zzb;
        int i4 = zzbwnVarZzB3.zzd;
        bArr3[i4] = (byte) ((i >> 18) | 240);
        bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i4 + 3] = (byte) ((i & 63) | 128);
        zzbwnVarZzB3.zzd = i4 + 4;
        this.zzb += 4;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzv(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzw(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final /* bridge */ /* synthetic */ zzbwc zzx(String str) {
        throw null;
    }

    public final zzbwf zzz() {
        long j = this.zzb;
        if (j <= 2147483647L) {
            return zzA((int) j);
        }
        throw new IllegalStateException("size > Int.MAX_VALUE: " + j);
    }

    public final zzbwn zzB(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        zzbwn zzbwnVar = this.zza;
        if (zzbwnVar == null) {
            zzbwn zzbwnVarZza = zzbwo.zza();
            this.zza = zzbwnVarZza;
            zzbwnVarZza.zzh = zzbwnVarZza;
            zzbwnVarZza.zzg = zzbwnVarZza;
            return zzbwnVarZza;
        }
        Intrinsics.checkNotNull(zzbwnVar);
        zzbwn zzbwnVar2 = zzbwnVar.zzh;
        Intrinsics.checkNotNull(zzbwnVar2);
        if (zzbwnVar2.zzd + i <= 8192 && zzbwnVar2.zzf) {
            return zzbwnVar2;
        }
        zzbwn zzbwnVarZza2 = zzbwo.zza();
        zzbwnVar2.zzb(zzbwnVarZza2);
        return zzbwnVarZza2;
    }

    public final byte[] zzH(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j);
        }
        if (this.zzb < j) {
            throw new EOFException(null);
        }
        int i = (int) j;
        byte[] sink = new byte[i];
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i2 = 0;
        while (i2 < i) {
            int iZzd = zzd(sink, i2, i - i2);
            if (iZzd == -1) {
                throw new EOFException(null);
            }
            i2 += iZzd;
        }
        return sink;
    }

    public final String zzh(long j, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j);
        }
        if (this.zzb < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        zzbwn zzbwnVar = this.zza;
        Intrinsics.checkNotNull(zzbwnVar);
        int i = zzbwnVar.zzc;
        int i2 = zzbwnVar.zzd;
        if (i + j > i2) {
            return new String(zzH(j), charset);
        }
        int i3 = (int) j;
        String str = new String(zzbwnVar.zzb, i, i3, charset);
        int i4 = i + i3;
        zzbwnVar.zzc = i4;
        this.zzb -= j;
        if (i4 == i2) {
            this.zza = zzbwnVar.zza();
            zzbwo.zzb(zzbwnVar);
        }
        return str;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final zzbwf zzy(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException("byteCount: " + j);
        }
        if (this.zzb < j) {
            throw new EOFException(null);
        }
        if (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new zzbwf(zzH(j));
        }
        zzbwf zzbwfVarZzA = zzA((int) j);
        zzF(j);
        return zzbwfVarZzA;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzF(long j) throws EOFException {
        while (j > 0) {
            zzbwn zzbwnVar = this.zza;
            if (zzbwnVar == null) {
                throw new EOFException(null);
            }
            int iMin = (int) Math.min(j, zzbwnVar.zzd - zzbwnVar.zzc);
            long j2 = iMin;
            this.zzb -= j2;
            j -= j2;
            int i = zzbwnVar.zzc + iMin;
            zzbwnVar.zzc = i;
            if (i == zzbwnVar.zzd) {
                this.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzj(long j) throws EOFException {
        zzbwn zzbwnVar;
        long j2;
        long j3;
        long j4;
        long j5 = this.zzb;
        long j6 = j5 < Long.MAX_VALUE ? j5 : Long.MAX_VALUE;
        long j7 = 0;
        if (j6 != 0 && (zzbwnVar = this.zza) != null) {
            if (j5 < 0) {
                while (j5 > 0) {
                    zzbwnVar = zzbwnVar.zzh;
                    Intrinsics.checkNotNull(zzbwnVar);
                    j5 -= zzbwnVar.zzd - zzbwnVar.zzc;
                }
                if (zzbwnVar == null) {
                    j2 = 0;
                    j3 = -1;
                    j4 = -1;
                } else {
                    long j8 = 0;
                    loop3: while (j5 < j6) {
                        byte[] bArr = zzbwnVar.zzb;
                        j3 = -1;
                        j2 = j7;
                        int iMin = (int) Math.min(zzbwnVar.zzd, (zzbwnVar.zzc + j6) - j5);
                        for (int i = (int) ((zzbwnVar.zzc + j8) - j5); i < iMin; i++) {
                            if (bArr[i] == 10) {
                                j4 = (i - zzbwnVar.zzc) + j5;
                                break loop3;
                            }
                        }
                        j8 = j5 + (zzbwnVar.zzd - zzbwnVar.zzc);
                        zzbwnVar = zzbwnVar.zzg;
                        Intrinsics.checkNotNull(zzbwnVar);
                        j5 = j8;
                        j7 = j2;
                    }
                    j2 = j7;
                    j3 = -1;
                    j4 = j3;
                }
            } else {
                j2 = 0;
                j3 = -1;
                long j9 = 0;
                while (true) {
                    long j10 = (zzbwnVar.zzd - zzbwnVar.zzc) + j9;
                    if (j10 > 0) {
                        break;
                    }
                    zzbwnVar = zzbwnVar.zzg;
                    Intrinsics.checkNotNull(zzbwnVar);
                    j9 = j10;
                }
                if (zzbwnVar == null) {
                    j4 = j3;
                } else {
                    long j11 = 0;
                    loop6: while (j9 < j6) {
                        byte[] bArr2 = zzbwnVar.zzb;
                        int iMin2 = (int) Math.min(zzbwnVar.zzd, (zzbwnVar.zzc + j6) - j9);
                        for (int i2 = (int) ((zzbwnVar.zzc + j11) - j9); i2 < iMin2; i2++) {
                            if (bArr2[i2] == 10) {
                                j4 = (i2 - zzbwnVar.zzc) + j9;
                                break loop6;
                            }
                        }
                        j11 = j9 + (zzbwnVar.zzd - zzbwnVar.zzc);
                        zzbwnVar = zzbwnVar.zzg;
                        Intrinsics.checkNotNull(zzbwnVar);
                        j9 = j11;
                    }
                    j4 = j3;
                }
            }
        }
        if (j4 != j3) {
            int i3 = zzbwx.zza;
            Intrinsics.checkNotNullParameter(this, "<this>");
            if (j4 > j2) {
                long j12 = j4 + j3;
                if (zzb(j12) == 13) {
                    String strZzh = zzh(j12, Charsets.UTF_8);
                    zzF(2L);
                    return strZzh;
                }
            }
            String strZzh2 = zzh(j4, Charsets.UTF_8);
            zzF(1L);
            return strZzh2;
        }
        zzbwb out = new zzbwb();
        long jMin = Math.min(32L, this.zzb);
        Intrinsics.checkNotNullParameter(out, "out");
        zzbvv.zzb(this.zzb, 0L, jMin);
        if (jMin != j2) {
            out.zzb += jMin;
            zzbwn zzbwnVar2 = this.zza;
            long j13 = j2;
            while (true) {
                Intrinsics.checkNotNull(zzbwnVar2);
                long j14 = zzbwnVar2.zzd - zzbwnVar2.zzc;
                if (j13 < j14) {
                    break;
                }
                zzbwnVar2 = zzbwnVar2.zzg;
                j13 -= j14;
            }
            while (jMin > j2) {
                Intrinsics.checkNotNull(zzbwnVar2);
                zzbwn zzbwnVarZzc = zzbwnVar2.zzc();
                int i4 = zzbwnVarZzc.zzc + ((int) j13);
                zzbwnVarZzc.zzc = i4;
                zzbwnVarZzc.zzd = Math.min(i4 + ((int) jMin), zzbwnVarZzc.zzd);
                zzbwn zzbwnVar3 = out.zza;
                if (zzbwnVar3 == null) {
                    zzbwnVarZzc.zzh = zzbwnVarZzc;
                    zzbwnVarZzc.zzg = zzbwnVarZzc.zzh;
                    out.zza = zzbwnVarZzc.zzg;
                } else {
                    Intrinsics.checkNotNull(zzbwnVar3);
                    zzbwn zzbwnVar4 = zzbwnVar3.zzh;
                    Intrinsics.checkNotNull(zzbwnVar4);
                    zzbwnVar4.zzb(zzbwnVarZzc);
                }
                jMin -= zzbwnVarZzc.zzd - zzbwnVarZzc.zzc;
                zzbwnVar2 = zzbwnVar2.zzg;
                j13 = j2;
            }
        }
        throw new EOFException("\\n not found: limit=" + Math.min(this.zzb, Long.MAX_VALUE) + " content=" + out.zzy(out.zzb).zze() + "…");
    }

    public final zzbwf zzA(int i) {
        if (i == 0) {
            return zzbwf.zzb;
        }
        zzbvv.zzb(this.zzb, 0L, i);
        zzbwn zzbwnVar = this.zza;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(zzbwnVar);
            int i5 = zzbwnVar.zzd;
            int i6 = zzbwnVar.zzc;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            zzbwnVar = zzbwnVar.zzg;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 + i4];
        zzbwn zzbwnVar2 = this.zza;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(zzbwnVar2);
            bArr[i7] = zzbwnVar2.zzb;
            i2 += zzbwnVar2.zzd - zzbwnVar2.zzc;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = zzbwnVar2.zzc;
            zzbwnVar2.zze = true;
            i7++;
            zzbwnVar2 = zzbwnVar2.zzg;
        }
        return new zzbwp(bArr, iArr);
    }
}
