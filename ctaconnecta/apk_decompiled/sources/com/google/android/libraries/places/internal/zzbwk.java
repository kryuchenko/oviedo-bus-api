package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwk implements zzbwc, AutoCloseable {
    public final zzbwq zza;
    public final zzbwb zzb;
    public boolean zzc;

    public zzbwk(zzbwq sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.zza = sink;
        this.zzb = new zzbwb();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbwq
    public final void close() throws Throwable {
        Throwable th;
        if (this.zzc) {
            return;
        }
        try {
            zzbwb zzbwbVar = this.zzb;
            th = null;
            if (zzbwbVar.zzg() > 0) {
                this.zza.zzn(zzbwbVar, zzbwbVar.zzg());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.zza.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.zzc = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwc, com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        zzbwb zzbwbVar = this.zzb;
        if (zzbwbVar.zzg() > 0) {
            this.zza.zzn(zzbwbVar, zzbwbVar.zzg());
        }
        this.zza.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.zzc;
    }

    public final String toString() {
        return "buffer(" + this.zza + ")";
    }

    public final zzbwc zza() throws IOException {
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        long jZzf = this.zzb.zzf();
        if (jZzf > 0) {
            this.zza.zzn(this.zzb, jZzf);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.zzb.write(source);
        zza();
        return iWrite;
    }

    @Override // com.google.android.libraries.places.internal.zzbwq
    public final void zzn(zzbwb source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        this.zzb.zzn(source, j);
        zza();
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final zzbwc zzv(int i) throws IOException {
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        this.zzb.zzm(i);
        zza();
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final zzbwc zzw(int i) throws IOException {
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        this.zzb.zzp(i);
        zza();
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzbwc
    public final zzbwc zzx(String string) throws IOException {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        this.zzb.zzs(string);
        zza();
        return this;
    }
}
