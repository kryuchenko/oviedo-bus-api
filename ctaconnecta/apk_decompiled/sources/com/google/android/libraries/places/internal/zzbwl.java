package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwl implements zzbwd, AutoCloseable {
    public final zzbws zza;
    public final zzbwb zzb;
    public boolean zzc;

    public zzbwl(zzbws source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.zza = source;
        this.zzb = new zzbwb();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbws
    public final void close() throws IOException {
        if (this.zzc) {
            return;
        }
        this.zzc = true;
        this.zza.close();
        zzbwb zzbwbVar = this.zzb;
        zzbwbVar.zzF(zzbwbVar.zzg());
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.zzc;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbwb zzbwbVar = this.zzb;
        if (zzbwbVar.zzg() == 0 && this.zza.zza(zzbwbVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.zzb.read(sink);
    }

    public final String toString() {
        return "buffer(" + this.zza + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzD(long j) throws EOFException {
        zzbwb zzbwbVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        do {
            zzbwbVar = this.zzb;
            if (zzbwbVar.zzg() >= j) {
                return;
            }
        } while (this.zza.zza(zzbwbVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        throw new EOFException(null);
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void zzF(long j) throws EOFException {
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            zzbwb zzbwbVar = this.zzb;
            if (zzbwbVar.zzg() == 0 && this.zza.zza(zzbwbVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException(null);
            }
            long jMin = Math.min(j, this.zzb.zzg());
            this.zzb.zzF(jMin);
            j -= jMin;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.zzc) {
            throw new IllegalStateException("closed");
        }
        zzbwb zzbwbVar = this.zzb;
        if (zzbwbVar.zzg() == 0 && this.zza.zza(zzbwbVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.zzb.zza(sink, Math.min(j, this.zzb.zzg()));
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final byte zzc() throws EOFException {
        zzD(1L);
        return this.zzb.zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final int zze() throws EOFException {
        zzD(4L);
        return this.zzb.zze();
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final zzbwf zzy(long j) throws EOFException {
        zzD(j);
        return this.zzb.zzy(j);
    }
}
