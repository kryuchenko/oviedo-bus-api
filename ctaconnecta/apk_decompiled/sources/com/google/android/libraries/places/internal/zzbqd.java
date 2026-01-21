package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbqd extends zzbpz {
    private zzbqd() {
        throw null;
    }

    /* synthetic */ zzbqd(zzbqc zzbqcVar) {
        super(null);
    }

    @Override // com.google.android.libraries.places.internal.zzbpz
    public final void zza(zzbqe zzbqeVar, int i) {
        synchronized (zzbqeVar) {
            zzbqeVar.zze = 0;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpz
    public final boolean zzb(zzbqe zzbqeVar, int i, int i2) {
        synchronized (zzbqeVar) {
            if (zzbqeVar.zze != 0) {
                return false;
            }
            zzbqeVar.zze = -1;
            return true;
        }
    }
}
