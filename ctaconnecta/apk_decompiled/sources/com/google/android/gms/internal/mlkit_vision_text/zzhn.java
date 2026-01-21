package com.google.android.gms.internal.mlkit_vision_text;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzhn<T> implements zzhx<T> {
    private final zzhg zza;
    private final zzip<?, ?> zzb;
    private final boolean zzc;
    private final zzfp<?> zzd;

    private zzhn(zzip<?, ?> zzipVar, zzfp<?> zzfpVar, zzhg zzhgVar) {
        this.zzb = zzipVar;
        this.zzc = zzfpVar.zza(zzhgVar);
        this.zzd = zzfpVar;
        this.zza = zzhgVar;
    }

    static <T> zzhn<T> zza(zzip<?, ?> zzipVar, zzfp<?> zzfpVar, zzhg zzhgVar) {
        return new zzhn<>(zzipVar, zzfpVar, zzhgVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final int zza(T t) {
        int iHashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final void zzb(T t, T t2) {
        zzhz.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhz.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final void zza(T t, zzjj zzjjVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzfs zzfsVar = (zzfs) entry.getKey();
            if (zzfsVar.zzc() != zzjg.MESSAGE || zzfsVar.zzd() || zzfsVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzgn) {
                zzjjVar.zza(zzfsVar.zza(), (Object) ((zzgn) entry).zza().zzc());
            } else {
                zzjjVar.zza(zzfsVar.zza(), entry.getValue());
            }
        }
        zzip<?, ?> zzipVar = this.zzb;
        zzipVar.zzb((zzip<?, ?>) zzipVar.zza(t), zzjjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final void zzc(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhx
    public final int zzb(T t) {
        zzip<?, ?> zzipVar = this.zzb;
        int iZzc = zzipVar.zzc(zzipVar.zza(t));
        return this.zzc ? iZzc + this.zzd.zza(t).zzg() : iZzc;
    }
}
