package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
abstract class zzjo<T, B> {
    zzjo() {
    }

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzfm zzfmVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzkl zzklVar) throws IOException;

    abstract boolean zza(zzix zzixVar);

    abstract void zzb(B b, int i, long j);

    abstract void zzc(B b, int i, int i2);

    abstract void zzc(T t, zzkl zzklVar) throws IOException;

    abstract void zzf(Object obj, T t);

    abstract void zzg(Object obj, B b);

    abstract T zzh(T t, T t2);

    abstract void zzh(Object obj);

    abstract B zzig();

    abstract T zzo(B b);

    abstract int zzs(T t);

    abstract T zzw(Object obj);

    abstract B zzx(Object obj);

    abstract int zzy(T t);

    final boolean zza(B b, zzix zzixVar) throws IOException {
        int tag = zzixVar.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza((zzjo<T, B>) b, i, zzixVar.zzdy());
            return true;
        }
        if (i2 == 1) {
            zzb(b, i, zzixVar.zzea());
            return true;
        }
        if (i2 == 2) {
            zza((zzjo<T, B>) b, i, zzixVar.zzee());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzhh.zzgs();
            }
            zzc(b, i, zzixVar.zzeb());
            return true;
        }
        B bZzig = zzig();
        int i3 = 4 | (i << 3);
        while (zzixVar.zzdv() != Integer.MAX_VALUE && zza((zzjo<T, B>) bZzig, zzixVar)) {
        }
        if (i3 != zzixVar.getTag()) {
            throw zzhh.zzgr();
        }
        zza((zzjo<T, B>) b, i, (int) zzo(bZzig));
        return true;
    }
}
