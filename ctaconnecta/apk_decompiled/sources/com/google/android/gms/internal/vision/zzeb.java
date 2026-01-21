package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzeb extends zzea {
    private final zzdz zzmu = new zzdz();

    zzeb() {
    }

    @Override // com.google.android.gms.internal.vision.zzea
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.zzmu.zza(th, true).add(th2);
    }

    @Override // com.google.android.gms.internal.vision.zzea
    public final void zza(Throwable th) {
        th.printStackTrace();
        List<Throwable> listZza = this.zzmu.zza(th, false);
        if (listZza == null) {
            return;
        }
        synchronized (listZza) {
            for (Throwable th2 : listZza) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
