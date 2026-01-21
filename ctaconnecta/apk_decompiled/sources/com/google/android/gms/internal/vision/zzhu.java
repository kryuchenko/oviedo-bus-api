package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzhu implements zziz {
    private static final zzie zzyx = new zzhx();
    private final zzie zzyw;

    public zzhu() {
        this(new zzhw(zzgv.zzfx(), zzhc()));
    }

    private zzhu(zzie zzieVar) {
        this.zzyw = (zzie) zzgy.zza(zzieVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.vision.zziz
    public final <T> zziw<T> zze(Class<T> cls) {
        zziy.zzg(cls);
        zzif zzifVarZzb = this.zzyw.zzb(cls);
        if (zzifVarZzb.zzhk()) {
            if (zzgx.class.isAssignableFrom(cls)) {
                return zzin.zza(zziy.zzhv(), zzgo.zzfr(), zzifVarZzb.zzhl());
            }
            return zzin.zza(zziy.zzht(), zzgo.zzfs(), zzifVarZzb.zzhl());
        }
        if (zzgx.class.isAssignableFrom(cls)) {
            if (zza(zzifVarZzb)) {
                return zzil.zza(cls, zzifVarZzb, zzir.zzhn(), zzhr.zzhb(), zziy.zzhv(), zzgo.zzfr(), zzic.zzhh());
            }
            return zzil.zza(cls, zzifVarZzb, zzir.zzhn(), zzhr.zzhb(), zziy.zzhv(), (zzgk<?>) null, zzic.zzhh());
        }
        if (zza(zzifVarZzb)) {
            return zzil.zza(cls, zzifVarZzb, zzir.zzhm(), zzhr.zzha(), zziy.zzht(), zzgo.zzfs(), zzic.zzhg());
        }
        return zzil.zza(cls, zzifVarZzb, zzir.zzhm(), zzhr.zzha(), zziy.zzhu(), (zzgk<?>) null, zzic.zzhg());
    }

    private static boolean zza(zzif zzifVar) {
        return zzifVar.zzhj() == zzgx.zzf.zzxi;
    }

    private static zzie zzhc() {
        try {
            return (zzie) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzyx;
        }
    }
}
