package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfy<T> implements zzgi<T> {
    private final zzfv zza;
    private final zzha<?, ?> zzb;
    private final boolean zzc;
    private final zzea<?> zzd;

    private zzfy(zzha<?, ?> zzhaVar, zzea<?> zzeaVar, zzfv zzfvVar) {
        this.zzb = zzhaVar;
        this.zzc = zzeaVar.zza(zzfvVar);
        this.zzd = zzeaVar;
        this.zza = zzfvVar;
    }

    static <T> zzfy<T> zza(zzha<?, ?> zzhaVar, zzea<?> zzeaVar, zzfv zzfvVar) {
        return new zzfy<>(zzhaVar, zzeaVar, zzfvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final int zza(T t) {
        int iHashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final void zzb(T t, T t2) {
        zzgk.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzgk.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final void zza(T t, zzhu zzhuVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzeh zzehVar = (zzeh) entry.getKey();
            if (zzehVar.zzc() != zzhv.MESSAGE || zzehVar.zzd() || zzehVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzey) {
                zzhuVar.zza(zzehVar.zza(), (Object) ((zzey) entry).zza().zzc());
            } else {
                zzhuVar.zza(zzehVar.zza(), entry.getValue());
            }
        }
        zzha<?, ?> zzhaVar = this.zzb;
        zzhaVar.zzb((zzha<?, ?>) zzhaVar.zza(t), zzhuVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final void zzb(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final boolean zzc(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgi
    public final int zzd(T t) {
        zzha<?, ?> zzhaVar = this.zzb;
        int iZzc = zzhaVar.zzc(zzhaVar.zza(t));
        return this.zzc ? iZzc + this.zzd.zza(t).zzg() : iZzc;
    }
}
