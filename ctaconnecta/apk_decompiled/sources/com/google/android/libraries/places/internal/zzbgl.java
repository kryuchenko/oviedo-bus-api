package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbgl implements Runnable {
    final /* synthetic */ StringBuilder zza;
    final /* synthetic */ zzbgz zzb;

    zzbgl(zzbgz zzbgzVar, StringBuilder sb) {
        this.zza = sb;
        this.zzb = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzl(zzbdo.zze.zzg(this.zza.toString()), true);
    }
}
