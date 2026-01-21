package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbwj implements zzbwq, AutoCloseable {
    private final OutputStream zza;
    private final zzbwv zzb;

    public zzbwj(OutputStream out, zzbwv timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.zza = out;
        this.zzb = timeout;
    }

    @Override // com.google.android.libraries.places.internal.zzbwq, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.close();
    }

    @Override // com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    public final void flush() throws IOException {
        this.zza.flush();
    }

    public final String toString() {
        return "sink(" + this.zza + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbwq
    public final void zzn(zzbwb source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        zzbvv.zzb(source.zzg(), 0L, j);
        while (j > 0) {
            zzbwv.zzb();
            zzbwn zzbwnVar = source.zza;
            Intrinsics.checkNotNull(zzbwnVar);
            int iMin = (int) Math.min(j, zzbwnVar.zzd - zzbwnVar.zzc);
            this.zza.write(zzbwnVar.zzb, zzbwnVar.zzc, iMin);
            zzbwnVar.zzc += iMin;
            long j2 = iMin;
            source.zzE(source.zzg() - j2);
            j -= j2;
            if (zzbwnVar.zzc == zzbwnVar.zzd) {
                source.zza = zzbwnVar.zza();
                zzbwo.zzb(zzbwnVar);
            }
        }
    }
}
