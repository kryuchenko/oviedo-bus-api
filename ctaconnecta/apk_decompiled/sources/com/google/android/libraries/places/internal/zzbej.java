package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class zzbej implements zzbqp {
    protected abstract zzbei zzc();

    protected abstract zzbis zzd();

    @Override // com.google.android.libraries.places.internal.zzbqp
    public boolean zzp() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbqp
    public final void zzr() {
        if (zzd().zzf()) {
            return;
        }
        zzd().zzc();
    }

    protected final void zzs(int i) {
        zzbei.zzn(zzc(), i);
    }

    @Override // com.google.android.libraries.places.internal.zzbqp
    public final void zzt() {
        zzc().zzv();
    }

    @Override // com.google.android.libraries.places.internal.zzbqp
    public final void zzu(int i) {
        zzbei.zzo(zzc(), 2);
    }

    @Override // com.google.android.libraries.places.internal.zzbqp
    public final void zzv(zzazc zzazcVar) {
        zzd().zza(zzazcVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbqp
    public final void zzw(InputStream inputStream) throws IOException {
        try {
            if (!zzd().zzf()) {
                zzd().zze(inputStream);
            }
        } finally {
            zzbjd.zzi(inputStream);
        }
    }
}
