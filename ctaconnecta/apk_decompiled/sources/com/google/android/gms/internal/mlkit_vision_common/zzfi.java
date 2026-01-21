package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfi implements zzgl {
    private static final zzfs zzb = new zzfl();
    private final zzfs zza;

    public zzfi() {
        this(new zzfk(zzel.zza(), zza()));
    }

    private zzfi(zzfs zzfsVar) {
        this.zza = (zzfs) zzem.zza(zzfsVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgl
    public final <T> zzgi<T> zza(Class<T> cls) {
        zzgk.zza((Class<?>) cls);
        zzft zzftVarZzb = this.zza.zzb(cls);
        if (zzftVarZzb.zzb()) {
            if (zzek.class.isAssignableFrom(cls)) {
                return zzfy.zza(zzgk.zzc(), zzec.zza(), zzftVarZzb.zzc());
            }
            return zzfy.zza(zzgk.zza(), zzec.zzb(), zzftVarZzb.zzc());
        }
        if (zzek.class.isAssignableFrom(cls)) {
            if (zza(zzftVarZzb)) {
                return zzfz.zza(cls, zzftVarZzb, zzgc.zzb(), zzff.zzb(), zzgk.zzc(), zzec.zza(), zzfq.zzb());
            }
            return zzfz.zza(cls, zzftVarZzb, zzgc.zzb(), zzff.zzb(), zzgk.zzc(), null, zzfq.zzb());
        }
        if (zza(zzftVarZzb)) {
            return zzfz.zza(cls, zzftVarZzb, zzgc.zza(), zzff.zza(), zzgk.zza(), zzec.zzb(), zzfq.zza());
        }
        return zzfz.zza(cls, zzftVarZzb, zzgc.zza(), zzff.zza(), zzgk.zzb(), null, zzfq.zza());
    }

    private static boolean zza(zzft zzftVar) {
        return zzftVar.zza() == zzek.zze.zzh;
    }

    private static zzfs zza() {
        try {
            return (zzfs) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
