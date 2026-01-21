package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzfl extends zzfj {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zzsj;
    private final int zzsk;
    private int zzsl;

    public zzfl(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.zzsj = true;
        this.buffer = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.pos = iArrayOffset;
        this.zzsk = iArrayOffset;
        this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzdu() {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdv() throws IOException {
        if (zzdu()) {
            return Integer.MAX_VALUE;
        }
        int iZzel = zzel();
        this.tag = iZzel;
        if (iZzel == this.zzsl) {
            return Integer.MAX_VALUE;
        }
        return iZzel >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int getTag() {
        return this.tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    @Override // com.google.android.gms.internal.vision.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzdw() throws IOException {
        int i;
        int i2;
        if (zzdu() || (i = this.tag) == (i2 = this.zzsl)) {
            return false;
        }
        int i3 = i & 7;
        if (i3 != 0) {
            if (i3 == 1) {
                zzai(8);
                return true;
            }
            if (i3 == 2) {
                zzai(zzel());
                return true;
            }
            if (i3 != 3) {
                if (i3 == 5) {
                    zzai(4);
                    return true;
                }
                throw zzhh.zzgs();
            }
            this.zzsl = ((i >>> 3) << 3) | 4;
            while (zzdv() != Integer.MAX_VALUE && zzdw()) {
            }
            if (this.tag != this.zzsl) {
                throw zzhh.zzgt();
            }
            this.zzsl = i2;
            return true;
        }
        int i4 = this.limit;
        int i5 = this.pos;
        if (i4 - i5 >= 10) {
            byte[] bArr = this.buffer;
            int i6 = 0;
            while (i6 < 10) {
                int i7 = i5 + 1;
                if (bArr[i5] >= 0) {
                    this.pos = i7;
                    break;
                }
                i6++;
                i5 = i7;
            }
            for (int i8 = 0; i8 < 10; i8++) {
                if (readByte() < 0) {
                }
            }
            throw zzhh.zzgp();
        }
        while (i8 < 10) {
        }
        throw zzhh.zzgp();
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final double readDouble() throws IOException {
        zzak(1);
        return Double.longBitsToDouble(zzep());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final float readFloat() throws IOException {
        zzak(5);
        return Float.intBitsToFloat(zzeo());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdx() throws IOException {
        zzak(0);
        return zzem();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdy() throws IOException {
        zzak(0);
        return zzem();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdz() throws IOException {
        zzak(0);
        return zzel();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzea() throws IOException {
        zzak(1);
        return zzep();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeb() throws IOException {
        zzak(5);
        return zzeo();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzec() throws IOException {
        zzak(0);
        return zzel() != 0;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String readString() throws IOException {
        return zzj(false);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String zzed() throws IOException {
        return zzj(true);
    }

    private final String zzj(boolean z) throws IOException {
        zzak(2);
        int iZzel = zzel();
        if (iZzel == 0) {
            return "";
        }
        zzaj(iZzel);
        if (z) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            if (!zzjx.zzf(bArr, i, i + iZzel)) {
                throw zzhh.zzgu();
            }
        }
        String str = new String(this.buffer, this.pos, iZzel, zzgy.UTF_8);
        this.pos += iZzel;
        return str;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(Class<T> cls, zzgi zzgiVar) throws IOException {
        zzak(2);
        return (T) zzb(zzis.zzhp().zzf(cls), zzgiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        zzak(2);
        return (T) zzb(zziwVar, zzgiVar);
    }

    private final <T> T zzb(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int iZzel = zzel();
        zzaj(iZzel);
        int i = this.limit;
        int i2 = this.pos + iZzel;
        this.limit = i2;
        try {
            T tNewInstance = zziwVar.newInstance();
            zziwVar.zza(tNewInstance, this, zzgiVar);
            zziwVar.zzh(tNewInstance);
            if (this.pos == i2) {
                return tNewInstance;
            }
            throw zzhh.zzgt();
        } finally {
            this.limit = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzb(Class<T> cls, zzgi zzgiVar) throws IOException {
        zzak(3);
        return (T) zzd(zzis.zzhp().zzf(cls), zzgiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzc(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        zzak(3);
        return (T) zzd(zziwVar, zzgiVar);
    }

    private final <T> T zzd(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int i = this.zzsl;
        this.zzsl = ((this.tag >>> 3) << 3) | 4;
        try {
            T tNewInstance = zziwVar.newInstance();
            zziwVar.zza(tNewInstance, this, zzgiVar);
            zziwVar.zzh(tNewInstance);
            if (this.tag == this.zzsl) {
                return tNewInstance;
            }
            throw zzhh.zzgt();
        } finally {
            this.zzsl = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final zzfm zzee() throws IOException {
        zzfm zzfmVarZza;
        zzak(2);
        int iZzel = zzel();
        if (iZzel == 0) {
            return zzfm.zzsm;
        }
        zzaj(iZzel);
        if (this.zzsj) {
            zzfmVarZza = zzfm.zzb(this.buffer, this.pos, iZzel);
        } else {
            zzfmVarZza = zzfm.zza(this.buffer, this.pos, iZzel);
        }
        this.pos += iZzel;
        return zzfmVarZza;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzef() throws IOException {
        zzak(0);
        return zzel();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeg() throws IOException {
        zzak(0);
        return zzel();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeh() throws IOException {
        zzak(5);
        return zzeo();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzei() throws IOException {
        zzak(1);
        return zzep();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzej() throws IOException {
        zzak(0);
        return zzfy.zzav(zzel());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzek() throws IOException {
        zzak(0);
        return zzfy.zzr(zzem());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgg) {
            zzgg zzggVar = (zzgg) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzggVar.zzc(readDouble());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            if (i3 == 2) {
                int iZzel = zzel();
                zzal(iZzel);
                int i4 = this.pos + iZzel;
                while (this.pos < i4) {
                    zzggVar.zzc(Double.longBitsToDouble(zzer()));
                }
                return;
            }
            throw zzhh.zzgs();
        }
        int i5 = this.tag & 7;
        if (i5 == 1) {
            do {
                list.add(Double.valueOf(readDouble()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        if (i5 == 2) {
            int iZzel2 = zzel();
            zzal(iZzel2);
            int i6 = this.pos + iZzel2;
            while (this.pos < i6) {
                list.add(Double.valueOf(Double.longBitsToDouble(zzer())));
            }
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgt) {
            zzgt zzgtVar = (zzgt) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int iZzel = zzel();
                zzam(iZzel);
                int i4 = this.pos + iZzel;
                while (this.pos < i4) {
                    zzgtVar.zzu(Float.intBitsToFloat(zzeq()));
                }
                return;
            }
            if (i3 == 5) {
                do {
                    zzgtVar.zzu(readFloat());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            throw zzhh.zzgs();
        }
        int i5 = this.tag & 7;
        if (i5 == 2) {
            int iZzel2 = zzel();
            zzam(iZzel2);
            int i6 = this.pos + iZzel2;
            while (this.pos < i6) {
                list.add(Float.valueOf(Float.intBitsToFloat(zzeq())));
            }
            return;
        }
        if (i5 == 5) {
            do {
                list.add(Float.valueOf(readFloat()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhvVar.zzac(zzdx());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            if (i3 == 2) {
                int iZzel = this.pos + zzel();
                while (this.pos < iZzel) {
                    zzhvVar.zzac(zzem());
                }
                zzan(iZzel);
                return;
            }
            throw zzhh.zzgs();
        }
        int i4 = this.tag & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(zzdx()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        if (i4 == 2) {
            int iZzel2 = this.pos + zzel();
            while (this.pos < iZzel2) {
                list.add(Long.valueOf(zzem()));
            }
            zzan(iZzel2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhvVar.zzac(zzdy());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            if (i3 == 2) {
                int iZzel = this.pos + zzel();
                while (this.pos < iZzel) {
                    zzhvVar.zzac(zzem());
                }
                zzan(iZzel);
                return;
            }
            throw zzhh.zzgs();
        }
        int i4 = this.tag & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(zzdy()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        if (i4 == 2) {
            int iZzel2 = this.pos + zzel();
            while (this.pos < iZzel2) {
                list.add(Long.valueOf(zzem()));
            }
            zzan(iZzel2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgzVar.zzbm(zzdz());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            if (i3 == 2) {
                int iZzel = this.pos + zzel();
                while (this.pos < iZzel) {
                    zzgzVar.zzbm(zzel());
                }
                zzan(iZzel);
                return;
            }
            throw zzhh.zzgs();
        }
        int i4 = this.tag & 7;
        if (i4 == 0) {
            do {
                list.add(Integer.valueOf(zzdz()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        if (i4 == 2) {
            int iZzel2 = this.pos + zzel();
            while (this.pos < iZzel2) {
                list.add(Integer.valueOf(zzel()));
            }
            zzan(iZzel2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhvVar.zzac(zzea());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            if (i3 == 2) {
                int iZzel = zzel();
                zzal(iZzel);
                int i4 = this.pos + iZzel;
                while (this.pos < i4) {
                    zzhvVar.zzac(zzer());
                }
                return;
            }
            throw zzhh.zzgs();
        }
        int i5 = this.tag & 7;
        if (i5 == 1) {
            do {
                list.add(Long.valueOf(zzea()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        if (i5 == 2) {
            int iZzel2 = zzel();
            zzal(iZzel2);
            int i6 = this.pos + iZzel2;
            while (this.pos < i6) {
                list.add(Long.valueOf(zzer()));
            }
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int iZzel = zzel();
                zzam(iZzel);
                int i4 = this.pos + iZzel;
                while (this.pos < i4) {
                    zzgzVar.zzbm(zzeq());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    zzgzVar.zzbm(zzeb());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            throw zzhh.zzgs();
        }
        int i5 = this.tag & 7;
        if (i5 == 2) {
            int iZzel2 = zzel();
            zzam(iZzel2);
            int i6 = this.pos + iZzel2;
            while (this.pos < i6) {
                list.add(Integer.valueOf(zzeq()));
            }
            return;
        }
        if (i5 == 5) {
            do {
                list.add(Integer.valueOf(zzeb()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzfk) {
            zzfk zzfkVar = (zzfk) list;
            int i3 = this.tag & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzel = this.pos + zzel();
                    while (this.pos < iZzel) {
                        zzfkVar.addBoolean(zzel() != 0);
                    }
                    zzan(iZzel);
                    return;
                }
                throw zzhh.zzgs();
            }
            do {
                zzfkVar.addBoolean(zzec());
                if (zzdu()) {
                    return;
                } else {
                    i2 = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
            return;
        }
        int i4 = this.tag & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzel2 = this.pos + zzel();
                while (this.pos < iZzel2) {
                    list.add(Boolean.valueOf(zzel() != 0));
                }
                zzan(iZzel2);
                return;
            }
            throw zzhh.zzgs();
        }
        do {
            list.add(Boolean.valueOf(zzec()));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        }
        if ((list instanceof zzho) && !z) {
            zzho zzhoVar = (zzho) list;
            do {
                zzhoVar.zzc(zzee());
                if (zzdu()) {
                    return;
                } else {
                    i2 = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
            return;
        }
        do {
            list.add(zzj(z));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zza(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) != 2) {
            throw zzhh.zzgs();
        }
        do {
            list.add(zzb(zziwVar, zzgiVar));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == i2);
        this.pos = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zzb(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) != 3) {
            throw zzhh.zzgs();
        }
        do {
            list.add(zzd(zziwVar, zzgiVar));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == i2);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzj(List<zzfm> list) throws IOException {
        int i;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        }
        do {
            list.add(zzee());
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzel = this.pos + zzel();
                    while (this.pos < iZzel) {
                        zzgzVar.zzbm(zzel());
                    }
                    return;
                }
                throw zzhh.zzgs();
            }
            do {
                zzgzVar.zzbm(zzef());
                if (zzdu()) {
                    return;
                } else {
                    i2 = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
            return;
        }
        int i4 = this.tag & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzel2 = this.pos + zzel();
                while (this.pos < iZzel2) {
                    list.add(Integer.valueOf(zzel()));
                }
                return;
            }
            throw zzhh.zzgs();
        }
        do {
            list.add(Integer.valueOf(zzef()));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzel = this.pos + zzel();
                    while (this.pos < iZzel) {
                        zzgzVar.zzbm(zzel());
                    }
                    return;
                }
                throw zzhh.zzgs();
            }
            do {
                zzgzVar.zzbm(zzeg());
                if (zzdu()) {
                    return;
                } else {
                    i2 = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
            return;
        }
        int i4 = this.tag & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzel2 = this.pos + zzel();
                while (this.pos < iZzel2) {
                    list.add(Integer.valueOf(zzel()));
                }
                return;
            }
            throw zzhh.zzgs();
        }
        do {
            list.add(Integer.valueOf(zzeg()));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int iZzel = zzel();
                zzam(iZzel);
                int i4 = this.pos + iZzel;
                while (this.pos < i4) {
                    zzgzVar.zzbm(zzeq());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    zzgzVar.zzbm(zzeh());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            throw zzhh.zzgs();
        }
        int i5 = this.tag & 7;
        if (i5 == 2) {
            int iZzel2 = zzel();
            zzam(iZzel2);
            int i6 = this.pos + iZzel2;
            while (this.pos < i6) {
                list.add(Integer.valueOf(zzeq()));
            }
            return;
        }
        if (i5 == 5) {
            do {
                list.add(Integer.valueOf(zzeh()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzn(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhvVar.zzac(zzei());
                    if (zzdu()) {
                        return;
                    } else {
                        i2 = this.pos;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
                return;
            }
            if (i3 == 2) {
                int iZzel = zzel();
                zzal(iZzel);
                int i4 = this.pos + iZzel;
                while (this.pos < i4) {
                    zzhvVar.zzac(zzer());
                }
                return;
            }
            throw zzhh.zzgs();
        }
        int i5 = this.tag & 7;
        if (i5 == 1) {
            do {
                list.add(Long.valueOf(zzei()));
                if (zzdu()) {
                    return;
                } else {
                    i = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        if (i5 == 2) {
            int iZzel2 = zzel();
            zzal(iZzel2);
            int i6 = this.pos + iZzel2;
            while (this.pos < i6) {
                list.add(Long.valueOf(zzer()));
            }
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzel = this.pos + zzel();
                    while (this.pos < iZzel) {
                        zzgzVar.zzbm(zzfy.zzav(zzel()));
                    }
                    return;
                }
                throw zzhh.zzgs();
            }
            do {
                zzgzVar.zzbm(zzej());
                if (zzdu()) {
                    return;
                } else {
                    i2 = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
            return;
        }
        int i4 = this.tag & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzel2 = this.pos + zzel();
                while (this.pos < iZzel2) {
                    list.add(Integer.valueOf(zzfy.zzav(zzel())));
                }
                return;
            }
            throw zzhh.zzgs();
        }
        do {
            list.add(Integer.valueOf(zzej()));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzp(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzel = this.pos + zzel();
                    while (this.pos < iZzel) {
                        zzhvVar.zzac(zzfy.zzr(zzem()));
                    }
                    return;
                }
                throw zzhh.zzgs();
            }
            do {
                zzhvVar.zzac(zzek());
                if (zzdu()) {
                    return;
                } else {
                    i2 = this.pos;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
            return;
        }
        int i4 = this.tag & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzel2 = this.pos + zzel();
                while (this.pos < iZzel2) {
                    list.add(Long.valueOf(zzfy.zzr(zzem())));
                }
                return;
            }
            throw zzhh.zzgs();
        }
        do {
            list.add(Long.valueOf(zzek()));
            if (zzdu()) {
                return;
            } else {
                i = this.pos;
            }
        } while (zzel() == this.tag);
        this.pos = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <K, V> void zza(Map<K, V> map, zzhy<K, V> zzhyVar, zzgi zzgiVar) throws IOException {
        zzak(2);
        int iZzel = zzel();
        zzaj(iZzel);
        int i = this.limit;
        this.limit = this.pos + iZzel;
        try {
            Object objZza = zzhyVar.zzzc;
            Object objZza2 = zzhyVar.zzgl;
            while (true) {
                int iZzdv = zzdv();
                if (iZzdv == Integer.MAX_VALUE) {
                    map.put(objZza, objZza2);
                    return;
                }
                if (iZzdv == 1) {
                    objZza = zza(zzhyVar.zzzb, (Class<?>) null, (zzgi) null);
                } else if (iZzdv == 2) {
                    objZza2 = zza(zzhyVar.zzzd, zzhyVar.zzgl.getClass(), zzgiVar);
                } else {
                    try {
                        if (!zzdw()) {
                            throw new zzhh("Unable to parse map entry.");
                        }
                    } catch (zzhg unused) {
                        if (!zzdw()) {
                            throw new zzhh("Unable to parse map entry.");
                        }
                    }
                }
            }
        } finally {
            this.limit = i;
        }
    }

    private final Object zza(zzkf zzkfVar, Class<?> cls, zzgi zzgiVar) throws IOException {
        switch (zzfi.zzsg[zzkfVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzec());
            case 2:
                return zzee();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzeg());
            case 5:
                return Integer.valueOf(zzeb());
            case 6:
                return Long.valueOf(zzea());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdz());
            case 9:
                return Long.valueOf(zzdy());
            case 10:
                return zza(cls, zzgiVar);
            case 11:
                return Integer.valueOf(zzeh());
            case 12:
                return Long.valueOf(zzei());
            case 13:
                return Integer.valueOf(zzej());
            case 14:
                return Long.valueOf(zzek());
            case 15:
                return zzj(true);
            case 16:
                return Integer.valueOf(zzef());
            case 17:
                return Long.valueOf(zzdx());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzel() throws IOException {
        int i;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 == i2) {
            throw zzhh.zzgn();
        }
        byte[] bArr = this.buffer;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.pos = i4;
            return b;
        }
        if (i3 - i4 < 9) {
            return (int) zzen();
        }
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
                                        if (bArr[i7] < 0) {
                                            throw zzhh.zzgp();
                                        }
                                        i5 = i12;
                                        i = i11;
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

    private final long zzem() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.pos;
        int i2 = this.limit;
        if (i2 == i) {
            throw zzhh.zzgn();
        }
        byte[] bArr = this.buffer;
        int i3 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.pos = i3;
            return b;
        }
        if (i2 - i3 < 9) {
            return zzen();
        }
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
                                        if (bArr[i4] < 0) {
                                            throw zzhh.zzgp();
                                        }
                                        i4 = i10;
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

    private final long zzen() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((readByte() & 128) == 0) {
                return j;
            }
        }
        throw zzhh.zzgp();
    }

    private final byte readByte() throws IOException {
        int i = this.pos;
        if (i == this.limit) {
            throw zzhh.zzgn();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 1;
        return bArr[i];
    }

    private final int zzeo() throws IOException {
        zzaj(4);
        return zzeq();
    }

    private final long zzep() throws IOException {
        zzaj(8);
        return zzer();
    }

    private final int zzeq() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzer() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private final void zzai(int i) throws IOException {
        zzaj(i);
        this.pos += i;
    }

    private final void zzaj(int i) throws IOException {
        if (i < 0 || i > this.limit - this.pos) {
            throw zzhh.zzgn();
        }
    }

    private final void zzak(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzgs();
        }
    }

    private final void zzal(int i) throws IOException {
        zzaj(i);
        if ((i & 7) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzam(int i) throws IOException {
        zzaj(i);
        if ((i & 3) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzan(int i) throws IOException {
        if (this.pos != i) {
            throw zzhh.zzgn();
        }
    }
}
