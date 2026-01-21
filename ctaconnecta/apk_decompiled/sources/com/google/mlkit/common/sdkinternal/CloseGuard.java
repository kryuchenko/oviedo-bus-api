package com.google.mlkit.common.sdkinternal;

import android.util.Log;
import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.android.gms.internal.mlkit_common.zzap;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.mlkit.common.sdkinternal.Cleaner;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class CloseGuard implements Closeable, AutoCloseable {
    public static final int API_TRANSLATE = 1;
    private final AtomicBoolean zza = new AtomicBoolean();
    private final String zzb;
    private final Runnable zzc;
    private final Cleaner.Cleanable zzd;
    private final zzdb zze;
    private final zzaa.zzaj.zza zzf;

    CloseGuard(Object obj, zzaa.zzaj.zza zzaVar, Cleaner cleaner, zzdb zzdbVar, Runnable runnable) {
        this.zzf = zzaVar;
        this.zze = zzdbVar;
        this.zzb = obj.toString();
        this.zzc = runnable;
        this.zzd = cleaner.register(obj, new Runnable(this) { // from class: com.google.mlkit.common.sdkinternal.zze
            private final CloseGuard zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza();
            }
        });
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    public static class Factory {
        private final Cleaner zza;
        private final zzdb zzb;

        public Factory(Cleaner cleaner, zzdb zzdbVar) {
            this.zza = cleaner;
            this.zzb = zzdbVar;
        }

        public CloseGuard create(Object obj, int i, Runnable runnable) {
            return new CloseGuard(obj, zzaa.zzaj.zza.zza(i), this.zza, this.zzb, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.zza.set(true);
        this.zzd.clean();
    }

    final /* synthetic */ void zza() {
        if (!this.zza.get()) {
            Log.e("MlKitCloseGuard", String.format(Locale.ENGLISH, "%s has not been closed", this.zzb));
            zzaa.zzad.zza zzaVarZzb = zzaa.zzad.zzb();
            zzaVarZzb.zza(zzaa.zzaj.zza().zza(this.zzf));
            this.zze.zza(zzaVarZzb, zzap.HANDLE_LEAKED);
        }
        this.zzc.run();
    }
}
