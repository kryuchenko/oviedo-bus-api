package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbhc implements Runnable {
    final /* synthetic */ zzbmk zza;

    zzbhc(zzbhg zzbhgVar, zzbmk zzbmkVar) {
        this.zza = zzbmkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbkx zzbkxVar = (zzbkx) this.zza;
        zzmt.zzp(zzbkxVar.zza.zzP.get(), "Channel must have been shut down");
        zzbkxVar.zza.zzQ = true;
        zzbkxVar.zza.zzah(false);
        zzbma.zzQ(zzbkxVar.zza);
    }
}
