package com.google.android.libraries.places.internal;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbvy implements zzbws, AutoCloseable {
    final /* synthetic */ zzbvz zza;
    final /* synthetic */ zzbws zzb;

    zzbvy(zzbvz zzbvzVar, zzbws zzbwsVar) {
        this.zza = zzbvzVar;
        this.zzb = zzbwsVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbws, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzbvz zzbvzVar = this.zza;
        try {
            this.zzb.close();
            Unit unit = Unit.INSTANCE;
        } catch (IOException e) {
            throw e;
        } finally {
            zzbvw.zza(zzbvz.zza, zzbvzVar);
        }
    }

    public final String toString() {
        return "AsyncTimeout.source(" + this.zzb + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbws
    public final long zza(zzbwb sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbvz zzbvzVar = this.zza;
        try {
            return this.zzb.zza(sink, j);
        } catch (IOException e) {
            throw e;
        } finally {
            zzbvw.zza(zzbvz.zza, zzbvzVar);
        }
    }
}
