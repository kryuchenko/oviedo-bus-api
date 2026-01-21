package com.google.android.libraries.places.internal;

import java.text.MessageFormat;
import java.util.logging.Level;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbfh extends zzaym {
    private final zzbfi zza;
    private final zzbqt zzb;

    zzbfh(zzbfi zzbfiVar, zzbqt zzbqtVar) {
        zzmt.zzc(zzbfiVar, "tracer");
        this.zza = zzbfiVar;
        zzmt.zzc(zzbqtVar, "time");
        this.zzb = zzbqtVar;
    }

    private static Level zzc(int i) {
        int i2 = i - 1;
        return i2 != 1 ? (i2 == 2 || i2 == 3) ? Level.FINE : Level.FINEST : Level.FINER;
    }

    private final boolean zzd(int i) {
        if (i == 1) {
            return false;
        }
        this.zza.zzd();
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzaym
    public final void zza(int i, String str) {
        zzbap zzbapVarZza = this.zza.zza();
        Level levelZzc = zzc(i);
        if (zzbfi.zza.isLoggable(levelZzc)) {
            zzbfi.zzb(zzbapVarZza, levelZzc, str);
        }
        zzd(i);
    }

    @Override // com.google.android.libraries.places.internal.zzaym
    public final void zzb(int i, String str, Object... objArr) {
        Level levelZzc = zzc(i);
        zzd(i);
        zza(i, zzbfi.zza.isLoggable(levelZzc) ? MessageFormat.format(str, objArr) : null);
    }
}
