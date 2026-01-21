package com.google.android.libraries.places.internal;

import java.io.InputStream;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbhp implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ zzbhy zzb;

    zzbhp(zzbhy zzbhyVar, InputStream inputStream) {
        this.zza = inputStream;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzw(this.zza);
    }
}
