package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbhd implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbhg zzb;

    zzbhd(zzbhg zzbhgVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbhgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmt.zzp(((zzbkx) this.zzb.zzh).zza.zzP.get(), "Channel must have been shut down");
    }
}
