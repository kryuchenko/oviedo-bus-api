package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzazn implements Comparable {
    private static final zzazl zza = new zzazl(null);
    private static final long zzb;
    private static final long zzc;
    private static final long zzd;
    private final zzazm zze;
    private final long zzf;
    private volatile boolean zzg;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        zzb = nanos;
        zzc = -nanos;
        zzd = TimeUnit.SECONDS.toNanos(1L);
    }

    private zzazn(zzazm zzazmVar, long j, long j2, boolean z) {
        this.zze = zzazmVar;
        long jMin = Math.min(zzb, Math.max(zzc, j2));
        this.zzf = j + jMin;
        this.zzg = jMin <= 0;
    }

    public static zzazm zzc() {
        return zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzazn)) {
            return false;
        }
        zzazn zzaznVar = (zzazn) obj;
        return this.zze == zzaznVar.zze && this.zzf == zzaznVar.zzf;
    }

    public final int hashCode() {
        return Arrays.asList(this.zze, Long.valueOf(this.zzf)).hashCode();
    }

    public final String toString() {
        long jZzb = zzb(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jZzb);
        long j = zzd;
        long j2 = jAbs / j;
        long jAbs2 = Math.abs(jZzb) % j;
        StringBuilder sb = new StringBuilder();
        if (jZzb < 0) {
            sb.append('-');
        }
        sb.append(j2);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        zzazm zzazmVar = this.zze;
        if (zzazmVar != zza) {
            sb.append(" (ticker=" + zzazmVar.toString() + ")");
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzazn zzaznVar) {
        zzazm zzazmVar = this.zze;
        if (zzazmVar == zzaznVar.zze) {
            long j = this.zzf - zzaznVar.zzf;
            if (j < 0) {
                return -1;
            }
            return j > 0 ? 1 : 0;
        }
        throw new AssertionError("Tickers (" + zzazmVar.toString() + " and " + zzaznVar.zze.toString() + ") don't match. Custom Ticker should only be used in tests!");
    }

    public final long zzb(TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        if (!this.zzg && this.zzf - jNanoTime <= 0) {
            this.zzg = true;
        }
        return timeUnit.convert(this.zzf - jNanoTime, TimeUnit.NANOSECONDS);
    }

    public final boolean zze() {
        if (!this.zzg) {
            if (this.zzf - System.nanoTime() > 0) {
                return false;
            }
            this.zzg = true;
        }
        return true;
    }

    public static zzazn zzd(long j, TimeUnit timeUnit) {
        zzazl zzazlVar = zza;
        if (timeUnit == null) {
            throw new NullPointerException("units");
        }
        return new zzazn(zzazlVar, System.nanoTime(), timeUnit.toNanos(j), true);
    }
}
