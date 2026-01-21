package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzef;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zza implements Runnable {
    private final /* synthetic */ int zzby;
    private final /* synthetic */ zzef.zzo zzbz;
    private final /* synthetic */ DynamiteClearcutLogger zzca;

    zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzef.zzo zzoVar) {
        this.zzca = dynamiteClearcutLogger;
        this.zzby = i;
        this.zzbz = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzca.zzbx.zzb(this.zzby, this.zzbz);
    }
}
