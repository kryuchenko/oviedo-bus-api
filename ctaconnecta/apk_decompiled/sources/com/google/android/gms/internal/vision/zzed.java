package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzed extends zzea {
    zzed() {
    }

    @Override // com.google.android.gms.internal.vision.zzea
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    @Override // com.google.android.gms.internal.vision.zzea
    public final void zza(Throwable th) {
        th.printStackTrace();
    }
}
