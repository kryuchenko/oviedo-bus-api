package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfy;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzgx implements zzhw {
    private static final zzhh zzb = new zzgw();
    private final zzhh zza;

    public zzgx() {
        this(new zzgz(zzfw.zza(), zza()));
    }

    private zzgx(zzhh zzhhVar) {
        this.zza = (zzhh) zzgb.zza(zzhhVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhw
    public final <T> zzhx<T> zza(Class<T> cls) {
        zzhz.zza((Class<?>) cls);
        zzhe zzheVarZzb = this.zza.zzb(cls);
        if (zzheVarZzb.zzb()) {
            if (zzfy.class.isAssignableFrom(cls)) {
                return zzhn.zza(zzhz.zzc(), zzfr.zza(), zzheVarZzb.zzc());
            }
            return zzhn.zza(zzhz.zza(), zzfr.zzb(), zzheVarZzb.zzc());
        }
        if (zzfy.class.isAssignableFrom(cls)) {
            if (zza(zzheVarZzb)) {
                return zzhk.zza(cls, zzheVarZzb, zzhr.zzb(), zzgq.zzb(), zzhz.zzc(), zzfr.zza(), zzhf.zzb());
            }
            return zzhk.zza(cls, zzheVarZzb, zzhr.zzb(), zzgq.zzb(), zzhz.zzc(), null, zzhf.zzb());
        }
        if (zza(zzheVarZzb)) {
            return zzhk.zza(cls, zzheVarZzb, zzhr.zza(), zzgq.zza(), zzhz.zza(), zzfr.zzb(), zzhf.zza());
        }
        return zzhk.zza(cls, zzheVarZzb, zzhr.zza(), zzgq.zza(), zzhz.zzb(), null, zzhf.zza());
    }

    private static boolean zza(zzhe zzheVar) {
        return zzheVar.zza() == zzfy.zzf.zzh;
    }

    private static zzhh zza() {
        try {
            return (zzhh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
