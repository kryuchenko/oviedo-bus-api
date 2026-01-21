package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzla implements zzcz<zzkz> {
    private static zzla zzahf = new zzla();
    private final zzcz<zzkz> zzahc;

    public static boolean zzjq() {
        return ((zzkz) zzahf.get()).zzjq();
    }

    public static boolean zzjr() {
        return ((zzkz) zzahf.get()).zzjr();
    }

    private zzla(zzcz<zzkz> zzczVar) {
        this.zzahc = zzdc.zza(zzczVar);
    }

    public zzla() {
        this(zzdc.zze(new zzlb()));
    }

    @Override // com.google.android.gms.internal.vision.zzcz
    public final /* synthetic */ zzkz get() {
        return this.zzahc.get();
    }
}
