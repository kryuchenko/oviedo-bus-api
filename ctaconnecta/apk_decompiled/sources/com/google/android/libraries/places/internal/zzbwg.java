package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbwg implements zzbws, AutoCloseable {
    private final InputStream zza;
    private final zzbwv zzb;

    public zzbwg(InputStream input, zzbwv timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.zza = input;
        this.zzb = timeout;
    }

    @Override // com.google.android.libraries.places.internal.zzbws, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.close();
    }

    public final String toString() {
        return "source(" + this.zza + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            zzbwv.zzb();
            zzbwn zzbwnVarZzB = sink.zzB(1);
            int i = this.zza.read(zzbwnVarZzB.zzb, zzbwnVarZzB.zzd, (int) Math.min(j, 8192 - zzbwnVarZzB.zzd));
            if (i != -1) {
                zzbwnVarZzB.zzd += i;
                long j2 = i;
                sink.zzE(sink.zzg() + j2);
                return j2;
            }
            if (zzbwnVarZzB.zzc != zzbwnVarZzB.zzd) {
                return -1L;
            }
            sink.zza = zzbwnVarZzB.zza();
            zzbwo.zzb(zzbwnVarZzB);
            return -1L;
        } catch (AssertionError e) {
            if (zzbwi.zza(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }
}
