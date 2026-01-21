package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgd implements zzix {
    private int tag;
    private int zzsl;
    private final zzfy zzte;
    private int zztf = 0;

    public static zzgd zza(zzfy zzfyVar) {
        return zzfyVar.zzsx != null ? zzfyVar.zzsx : new zzgd(zzfyVar);
    }

    private zzgd(zzfy zzfyVar) {
        zzfy zzfyVar2 = (zzfy) zzgy.zza(zzfyVar, "input");
        this.zzte = zzfyVar2;
        zzfyVar2.zzsx = this;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdv() throws IOException {
        int i = this.zztf;
        if (i != 0) {
            this.tag = i;
            this.zztf = 0;
        } else {
            this.tag = this.zzte.zzey();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzsl) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzdw() throws IOException {
        int i;
        if (this.zzte.zzdu() || (i = this.tag) == this.zzsl) {
            return false;
        }
        return this.zzte.zzas(i);
    }

    private final void zzak(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzgs();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final double readDouble() throws IOException {
        zzak(1);
        return this.zzte.readDouble();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final float readFloat() throws IOException {
        zzak(5);
        return this.zzte.readFloat();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdx() throws IOException {
        zzak(0);
        return this.zzte.zzdx();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdy() throws IOException {
        zzak(0);
        return this.zzte.zzdy();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdz() throws IOException {
        zzak(0);
        return this.zzte.zzdz();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzea() throws IOException {
        zzak(1);
        return this.zzte.zzea();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeb() throws IOException {
        zzak(5);
        return this.zzte.zzeb();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzec() throws IOException {
        zzak(0);
        return this.zzte.zzec();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String readString() throws IOException {
        zzak(2);
        return this.zzte.readString();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String zzed() throws IOException {
        zzak(2);
        return this.zzte.zzed();
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

    private final <T> T zzb(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int iZzef = this.zzte.zzef();
        if (this.zzte.zzsu >= this.zzte.zzsv) {
            throw new zzhh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzat = this.zzte.zzat(iZzef);
        T tNewInstance = zziwVar.newInstance();
        this.zzte.zzsu++;
        zziwVar.zza(tNewInstance, this, zzgiVar);
        zziwVar.zzh(tNewInstance);
        this.zzte.zzar(0);
        zzfy zzfyVar = this.zzte;
        zzfyVar.zzsu--;
        this.zzte.zzau(iZzat);
        return tNewInstance;
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
        zzak(2);
        return this.zzte.zzee();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzef() throws IOException {
        zzak(0);
        return this.zzte.zzef();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeg() throws IOException {
        zzak(0);
        return this.zzte.zzeg();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeh() throws IOException {
        zzak(5);
        return this.zzte.zzeh();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzei() throws IOException {
        zzak(1);
        return this.zzte.zzei();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzej() throws IOException {
        zzak(0);
        return this.zzte.zzej();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzek() throws IOException {
        zzak(0);
        return this.zzte.zzek();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zza(List<Double> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgg) {
            zzgg zzggVar = (zzgg) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzggVar.zzc(this.zzte.readDouble());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzef = this.zzte.zzef();
                zzal(iZzef);
                int iZzfa = this.zzte.zzfa() + iZzef;
                do {
                    zzggVar.zzc(this.zzte.readDouble());
                } while (this.zzte.zzfa() < iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.zzte.readDouble()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzef2 = this.zzte.zzef();
            zzal(iZzef2);
            int iZzfa2 = this.zzte.zzfa() + iZzef2;
            do {
                list.add(Double.valueOf(this.zzte.readDouble()));
            } while (this.zzte.zzfa() < iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(List<Float> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgt) {
            zzgt zzgtVar = (zzgt) list;
            int i = this.tag & 7;
            if (i == 2) {
                int iZzef = this.zzte.zzef();
                zzam(iZzef);
                int iZzfa = this.zzte.zzfa() + iZzef;
                do {
                    zzgtVar.zzu(this.zzte.readFloat());
                } while (this.zzte.zzfa() < iZzfa);
                return;
            }
            if (i == 5) {
                do {
                    zzgtVar.zzu(this.zzte.readFloat());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int iZzef2 = this.zzte.zzef();
            zzam(iZzef2);
            int iZzfa2 = this.zzte.zzfa() + iZzef2;
            do {
                list.add(Float.valueOf(this.zzte.readFloat()));
            } while (this.zzte.zzfa() < iZzfa2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.zzte.readFloat()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzc(List<Long> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhvVar.zzac(this.zzte.zzdx());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhvVar.zzac(this.zzte.zzdx());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zzte.zzdx()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Long.valueOf(this.zzte.zzdx()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzd(List<Long> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhvVar.zzac(this.zzte.zzdy());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhvVar.zzac(this.zzte.zzdy());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zzte.zzdy()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Long.valueOf(this.zzte.zzdy()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zze(List<Integer> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzdz());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzdz());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zzte.zzdz()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Integer.valueOf(this.zzte.zzdz()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzf(List<Long> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhvVar.zzac(this.zzte.zzea());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzef = this.zzte.zzef();
                zzal(iZzef);
                int iZzfa = this.zzte.zzfa() + iZzef;
                do {
                    zzhvVar.zzac(this.zzte.zzea());
                } while (this.zzte.zzfa() < iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zzte.zzea()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzef2 = this.zzte.zzef();
            zzal(iZzef2);
            int iZzfa2 = this.zzte.zzfa() + iZzef2;
            do {
                list.add(Long.valueOf(this.zzte.zzea()));
            } while (this.zzte.zzfa() < iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzg(List<Integer> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int iZzef = this.zzte.zzef();
                zzam(iZzef);
                int iZzfa = this.zzte.zzfa() + iZzef;
                do {
                    zzgzVar.zzbm(this.zzte.zzeb());
                } while (this.zzte.zzfa() < iZzfa);
                return;
            }
            if (i == 5) {
                do {
                    zzgzVar.zzbm(this.zzte.zzeb());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int iZzef2 = this.zzte.zzef();
            zzam(iZzef2);
            int iZzfa2 = this.zzte.zzfa() + iZzef2;
            do {
                list.add(Integer.valueOf(this.zzte.zzeb()));
            } while (this.zzte.zzfa() < iZzfa2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zzte.zzeb()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzh(List<Boolean> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzfk) {
            zzfk zzfkVar = (zzfk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfkVar.addBoolean(this.zzte.zzec());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzfkVar.addBoolean(this.zzte.zzec());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zzte.zzec()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Boolean.valueOf(this.zzte.zzec()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
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
        int iZzey;
        int iZzey2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        }
        if ((list instanceof zzho) && !z) {
            zzho zzhoVar = (zzho) list;
            do {
                zzhoVar.zzc(zzee());
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey2 = this.zzte.zzey();
                }
            } while (iZzey2 == this.tag);
            this.zztf = iZzey2;
            return;
        }
        do {
            list.add(z ? zzed() : readString());
            if (this.zzte.zzdu()) {
                return;
            } else {
                iZzey = this.zzte.zzey();
            }
        } while (iZzey == this.tag);
        this.zztf = iZzey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zza(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int iZzey;
        int i = this.tag;
        if ((i & 7) != 2) {
            throw zzhh.zzgs();
        }
        do {
            list.add(zzb(zziwVar, zzgiVar));
            if (this.zzte.zzdu() || this.zztf != 0) {
                return;
            } else {
                iZzey = this.zzte.zzey();
            }
        } while (iZzey == i);
        this.zztf = iZzey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zzb(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int iZzey;
        int i = this.tag;
        if ((i & 7) != 3) {
            throw zzhh.zzgs();
        }
        do {
            list.add(zzd(zziwVar, zzgiVar));
            if (this.zzte.zzdu() || this.zztf != 0) {
                return;
            } else {
                iZzey = this.zzte.zzey();
            }
        } while (iZzey == i);
        this.zztf = iZzey;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzj(List<zzfm> list) throws IOException {
        int iZzey;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        }
        do {
            list.add(zzee());
            if (this.zzte.zzdu()) {
                return;
            } else {
                iZzey = this.zzte.zzey();
            }
        } while (iZzey == this.tag);
        this.zztf = iZzey;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzef());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzef());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zzte.zzef()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Integer.valueOf(this.zzte.zzef()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzl(List<Integer> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzeg());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzeg());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zzte.zzeg()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Integer.valueOf(this.zzte.zzeg()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzm(List<Integer> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int iZzef = this.zzte.zzef();
                zzam(iZzef);
                int iZzfa = this.zzte.zzfa() + iZzef;
                do {
                    zzgzVar.zzbm(this.zzte.zzeh());
                } while (this.zzte.zzfa() < iZzfa);
                return;
            }
            if (i == 5) {
                do {
                    zzgzVar.zzbm(this.zzte.zzeh());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int iZzef2 = this.zzte.zzef();
            zzam(iZzef2);
            int iZzfa2 = this.zzte.zzfa() + iZzef2;
            do {
                list.add(Integer.valueOf(this.zzte.zzeh()));
            } while (this.zzte.zzfa() < iZzfa2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zzte.zzeh()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzn(List<Long> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhvVar.zzac(this.zzte.zzei());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzef = this.zzte.zzef();
                zzal(iZzef);
                int iZzfa = this.zzte.zzfa() + iZzef;
                do {
                    zzhvVar.zzac(this.zzte.zzei());
                } while (this.zzte.zzfa() < iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zzte.zzei()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzef2 = this.zzte.zzef();
            zzal(iZzef2);
            int iZzfa2 = this.zzte.zzfa() + iZzef2;
            do {
                list.add(Long.valueOf(this.zzte.zzei()));
            } while (this.zzte.zzfa() < iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzej());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzej());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zzte.zzej()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Integer.valueOf(this.zzte.zzej()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzp(List<Long> list) throws IOException {
        int iZzey;
        int iZzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhvVar.zzac(this.zzte.zzek());
                    if (this.zzte.zzdu()) {
                        return;
                    } else {
                        iZzey2 = this.zzte.zzey();
                    }
                } while (iZzey2 == this.tag);
                this.zztf = iZzey2;
                return;
            }
            if (i == 2) {
                int iZzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhvVar.zzac(this.zzte.zzek());
                } while (this.zzte.zzfa() < iZzfa);
                zzan(iZzfa);
                return;
            }
            throw zzhh.zzgs();
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zzte.zzek()));
                if (this.zzte.zzdu()) {
                    return;
                } else {
                    iZzey = this.zzte.zzey();
                }
            } while (iZzey == this.tag);
            this.zztf = iZzey;
            return;
        }
        if (i2 == 2) {
            int iZzfa2 = this.zzte.zzfa() + this.zzte.zzef();
            do {
                list.add(Long.valueOf(this.zzte.zzek()));
            } while (this.zzte.zzfa() < iZzfa2);
            zzan(iZzfa2);
            return;
        }
        throw zzhh.zzgs();
    }

    private static void zzal(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhh.zzgt();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <K, V> void zza(Map<K, V> map, zzhy<K, V> zzhyVar, zzgi zzgiVar) throws IOException {
        zzak(2);
        int iZzat = this.zzte.zzat(this.zzte.zzef());
        Object objZza = zzhyVar.zzzc;
        Object objZza2 = zzhyVar.zzgl;
        while (true) {
            try {
                int iZzdv = zzdv();
                if (iZzdv == Integer.MAX_VALUE || this.zzte.zzdu()) {
                    break;
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
            } finally {
                this.zzte.zzau(iZzat);
            }
        }
    }

    private final Object zza(zzkf zzkfVar, Class<?> cls, zzgi zzgiVar) throws IOException {
        switch (zzgc.zzsg[zzkfVar.ordinal()]) {
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
                return zzed();
            case 16:
                return Integer.valueOf(zzef());
            case 17:
                return Long.valueOf(zzdx());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzam(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzan(int i) throws IOException {
        if (this.zzte.zzfa() != i) {
            throw zzhh.zzgn();
        }
    }
}
