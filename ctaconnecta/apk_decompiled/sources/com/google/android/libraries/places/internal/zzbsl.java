package com.google.android.libraries.places.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbsl extends zzbeg {
    private final zzbwb zza;

    zzbsl(zzbwb zzbwbVar) {
        this.zza = zzbwbVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbeg, com.google.android.libraries.places.internal.zzbnv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        zzbwb zzbwbVar = this.zza;
        zzbwbVar.zzF(zzbwbVar.zzg());
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final int zze() {
        try {
            return this.zza.zzc() & 255;
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final int zzf() {
        return (int) this.zza.zzg();
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final zzbnv zzg(int i) {
        zzbwb zzbwbVar = new zzbwb();
        zzbwbVar.zzn(this.zza, i);
        return new zzbsl(zzbwbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzi(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzj(OutputStream outputStream, int i) throws IOException {
        this.zza.zzr(outputStream, i);
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzk(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int iZzd = this.zza.zzd(bArr, i, i2);
            if (iZzd == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i2 + " bytes");
            }
            i2 -= iZzd;
            i += iZzd;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnv
    public final void zzl(int i) {
        try {
            this.zza.zzF(i);
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }
}
