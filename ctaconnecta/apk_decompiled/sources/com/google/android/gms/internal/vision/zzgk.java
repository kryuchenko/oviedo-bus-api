package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgp;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
abstract class zzgk<T extends zzgp<T>> {
    zzgk() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract Object zza(zzgi zzgiVar, zzih zzihVar, int i);

    abstract <UT, UB> UB zza(zzix zzixVar, Object obj, zzgi zzgiVar, zzgn<T> zzgnVar, UB ub, zzjo<UT, UB> zzjoVar) throws IOException;

    abstract void zza(zzfm zzfmVar, Object obj, zzgi zzgiVar, zzgn<T> zzgnVar) throws IOException;

    abstract void zza(zzix zzixVar, Object obj, zzgi zzgiVar, zzgn<T> zzgnVar) throws IOException;

    abstract void zza(zzkl zzklVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zze(zzih zzihVar);

    abstract zzgn<T> zzf(Object obj);

    abstract zzgn<T> zzg(Object obj);

    abstract void zzh(Object obj);
}
