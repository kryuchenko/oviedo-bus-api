package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbui {
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final String zzd;

    /* synthetic */ zzbui(zzbug zzbugVar, zzbuh zzbuhVar) {
        this.zza = zzbugVar.zza;
        this.zzb = zzbugVar.zzb;
        this.zzc = zzbugVar.zza();
        this.zzd = zzbugVar.toString();
    }

    static int zza(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    public static int zzb(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzbui) && ((zzbui) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }
}
