package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfy implements zzgx {
    private static final zzgi zzb = new zzfx();
    private final zzgi zza;

    public zzfy() {
        this(new zzga(zzex.zza(), zza()));
    }

    private zzfy(zzgi zzgiVar) {
        this.zza = (zzgi) zzfc.zza(zzgiVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgx
    public final <T> zzgy<T> zza(Class<T> cls) {
        zzha.zza((Class<?>) cls);
        zzgf zzgfVarZzb = this.zza.zzb(cls);
        if (zzgfVarZzb.zzb()) {
            if (zzez.class.isAssignableFrom(cls)) {
                return zzgo.zza(zzha.zzc(), zzes.zza(), zzgfVarZzb.zzc());
            }
            return zzgo.zza(zzha.zza(), zzes.zzb(), zzgfVarZzb.zzc());
        }
        if (zzez.class.isAssignableFrom(cls)) {
            if (zza(zzgfVarZzb)) {
                return zzgl.zza(cls, zzgfVarZzb, zzgs.zzb(), zzfr.zzb(), zzha.zzc(), zzes.zza(), zzgg.zzb());
            }
            return zzgl.zza(cls, zzgfVarZzb, zzgs.zzb(), zzfr.zzb(), zzha.zzc(), null, zzgg.zzb());
        }
        if (zza(zzgfVarZzb)) {
            return zzgl.zza(cls, zzgfVarZzb, zzgs.zza(), zzfr.zza(), zzha.zza(), zzes.zzb(), zzgg.zza());
        }
        return zzgl.zza(cls, zzgfVarZzb, zzgs.zza(), zzfr.zza(), zzha.zzb(), null, zzgg.zza());
    }

    private static boolean zza(zzgf zzgfVar) {
        return zzgfVar.zza() == zzez.zzf.zzh;
    }

    private static zzgi zza() {
        try {
            return (zzgi) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
