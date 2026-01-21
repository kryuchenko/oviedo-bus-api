package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzna {
    private final zznf zza = zznf.zza();
    private boolean zzb;
    private long zzc;

    zzna() {
    }

    public static zzna zzb() {
        return new zzna();
    }

    private final long zze() {
        if (this.zzb) {
            return System.nanoTime() - this.zzc;
        }
        return 0L;
    }

    public final String toString() {
        String str;
        long jZze = zze();
        TimeUnit timeUnit = TimeUnit.DAYS.convert(jZze, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.DAYS : TimeUnit.HOURS.convert(jZze, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.HOURS : TimeUnit.MINUTES.convert(jZze, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MINUTES : TimeUnit.SECONDS.convert(jZze, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS.convert(jZze, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MILLISECONDS : TimeUnit.MICROSECONDS.convert(jZze, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
        String str2 = String.format(Locale.ROOT, "%.4g", Double.valueOf(jZze / TimeUnit.NANOSECONDS.convert(1L, timeUnit)));
        switch (zzmz.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return str2 + " " + str;
    }

    public final long zza(TimeUnit timeUnit) {
        return timeUnit.convert(zze(), TimeUnit.NANOSECONDS);
    }

    public final zzna zzc() {
        this.zzb = false;
        return this;
    }

    public final zzna zzd() {
        zzmt.zzp(!this.zzb, "This stopwatch is already running.");
        this.zzb = true;
        this.zzc = System.nanoTime();
        return this;
    }
}
