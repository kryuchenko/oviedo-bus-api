package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgo<T> implements zzgy<T> {
    private final zzgh zza;
    private final zzhq<?, ?> zzb;
    private final boolean zzc;
    private final zzeq<?> zzd;

    private zzgo(zzhq<?, ?> zzhqVar, zzeq<?> zzeqVar, zzgh zzghVar) {
        this.zzb = zzhqVar;
        this.zzc = zzeqVar.zza(zzghVar);
        this.zzd = zzeqVar;
        this.zza = zzghVar;
    }

    static <T> zzgo<T> zza(zzhq<?, ?> zzhqVar, zzeq<?> zzeqVar, zzgh zzghVar) {
        return new zzgo<>(zzhqVar, zzeqVar, zzghVar);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final int zza(T t) {
        int iHashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zzb(T t, T t2) {
        zzha.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzha.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zza(T t, zzik zzikVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzet zzetVar = (zzet) entry.getKey();
            if (zzetVar.zzc() != zzih.MESSAGE || zzetVar.zzd() || zzetVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzfo) {
                zzikVar.zza(zzetVar.zza(), (Object) ((zzfo) entry).zza().zzc());
            } else {
                zzikVar.zza(zzetVar.zza(), entry.getValue());
            }
        }
        zzhq<?, ?> zzhqVar = this.zzb;
        zzhqVar.zzb((zzhq<?, ?>) zzhqVar.zza(t), zzikVar);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final void zzc(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final int zzb(T t) {
        zzhq<?, ?> zzhqVar = this.zzb;
        int iZzc = zzhqVar.zzc(zzhqVar.zza(t));
        return this.zzc ? iZzc + this.zzd.zza(t).zzg() : iZzc;
    }
}
