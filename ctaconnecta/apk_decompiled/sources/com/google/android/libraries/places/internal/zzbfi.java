package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbfi {
    static final Logger zza = Logger.getLogger(zzaym.class.getName());
    private final Object zzb = new Object();
    private final zzbap zzc;

    zzbfi(zzbap zzbapVar, int i, long j, String str) {
        zzmt.zzc(zzbapVar, "logId");
        this.zzc = zzbapVar;
        zzbab zzbabVar = new zzbab();
        zzbabVar.zza(str.concat(" created"));
        zzbabVar.zzb(zzbac.CT_INFO);
        zzbabVar.zzd(j);
        zzc(zzbabVar.zze());
    }

    static void zzb(zzbap zzbapVar, Level level, String str) {
        Logger logger = zza;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + zzbapVar.toString() + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    final zzbap zza() {
        return this.zzc;
    }

    final void zzc(zzbae zzbaeVar) {
        zzbac zzbacVar = zzbac.CT_UNKNOWN;
        int iOrdinal = zzbaeVar.zzb.ordinal();
        Level level = iOrdinal != 2 ? iOrdinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.zzb) {
        }
        zzb(this.zzc, level, zzbaeVar.zza);
    }

    final boolean zzd() {
        synchronized (this.zzb) {
        }
        return false;
    }
}
