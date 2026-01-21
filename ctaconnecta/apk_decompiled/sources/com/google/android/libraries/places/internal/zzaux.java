package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzaux implements zzavu {
    private static final zzavd zza = new zzauv();
    private final zzavd zzb;

    public zzaux() {
        zzavd zzavdVar;
        zzavd[] zzavdVarArr = new zzavd[2];
        zzavdVarArr[0] = zzatn.zza();
        try {
            zzavdVar = (zzavd) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzavdVar = zza;
        }
        zzavdVarArr[1] = zzavdVar;
        zzauw zzauwVar = new zzauw(zzavdVarArr);
        byte[] bArr = zzaud.zzd;
        this.zzb = zzauwVar;
    }

    private static boolean zzb(zzavc zzavcVar) {
        return zzavcVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.libraries.places.internal.zzavu
    public final zzavt zza(Class cls) {
        zzavv.zzs(cls);
        zzavc zzavcVarZzb = this.zzb.zzb(cls);
        return zzavcVarZzb.zzb() ? zzatu.class.isAssignableFrom(cls) ? zzavj.zzi(zzavv.zzn(), zzati.zzb(), zzavcVarZzb.zza()) : zzavj.zzi(zzavv.zzm(), zzati.zza(), zzavcVarZzb.zza()) : zzatu.class.isAssignableFrom(cls) ? zzb(zzavcVarZzb) ? zzavi.zzi(cls, zzavcVarZzb, zzavm.zzb(), zzaut.zze(), zzavv.zzn(), zzati.zzb(), zzavb.zzb()) : zzavi.zzi(cls, zzavcVarZzb, zzavm.zzb(), zzaut.zze(), zzavv.zzn(), null, zzavb.zzb()) : zzb(zzavcVarZzb) ? zzavi.zzi(cls, zzavcVarZzb, zzavm.zza(), zzaut.zzd(), zzavv.zzm(), zzati.zza(), zzavb.zza()) : zzavi.zzi(cls, zzavcVarZzb, zzavm.zza(), zzaut.zzd(), zzavv.zzm(), null, zzavb.zza());
    }
}
