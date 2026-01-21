package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbri implements zzbwq, AutoCloseable {
    private final zzbqe zzc;
    private final zzbrj zzd;

    @Nullable
    private zzbwq zzh;

    @Nullable
    private Socket zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private final Object zza = new Object();
    private final zzbwb zzb = new zzbwb();
    private boolean zze = false;
    private boolean zzf = false;
    private boolean zzg = false;

    private zzbri(zzbqe zzbqeVar, zzbrj zzbrjVar, int i) {
        zzmt.zzc(zzbqeVar, "executor");
        this.zzc = zzbqeVar;
        this.zzd = zzbrjVar;
    }

    static zzbri zzc(zzbqe zzbqeVar, zzbrj zzbrjVar, int i) {
        return new zzbri(zzbqeVar, zzbrjVar, 10000);
    }

    @Override // com.google.android.libraries.places.internal.zzbwq, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.zzg) {
            return;
        }
        this.zzg = true;
        this.zzc.execute(new zzbre(this));
    }

    @Override // com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzg) {
            throw new IOException("closed");
        }
        int i = zzbvr.zza;
        synchronized (this.zza) {
            if (this.zzf) {
                return;
            }
            this.zzf = true;
            this.zzc.execute(new zzbrd(this));
        }
    }

    final void zzm(zzbwq zzbwqVar, Socket socket) {
        zzmt.zzp(this.zzh == null, "AsyncSink's becomeConnected should only be called once.");
        this.zzh = zzbwqVar;
        zzmt.zzc(socket, "socket");
        this.zzi = socket;
    }

    @Override // com.google.android.libraries.places.internal.zzbwq
    public final void zzn(zzbwb zzbwbVar, long j) throws IOException {
        if (this.zzg) {
            throw new IOException("closed");
        }
        int i = zzbvr.zza;
        synchronized (this.zza) {
            this.zzb.zzn(zzbwbVar, j);
            int i2 = this.zzl + this.zzk;
            this.zzl = i2;
            boolean z = false;
            this.zzk = 0;
            if (this.zzj || i2 <= 10000) {
                if (!this.zze && !this.zzf && this.zzb.zzf() > 0) {
                    this.zze = true;
                }
                return;
            }
            this.zzj = true;
            z = true;
            if (!z) {
                this.zzc.execute(new zzbrc(this));
                return;
            }
            try {
                this.zzi.close();
            } catch (IOException e) {
                this.zzd.zzb(e);
            }
        }
    }
}
