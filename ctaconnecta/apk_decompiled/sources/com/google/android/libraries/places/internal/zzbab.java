package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbab {
    private String zza;
    private zzbac zzb;
    private Long zzc;
    private zzbau zzd;

    public final zzbab zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzbab zzb(zzbac zzbacVar) {
        this.zzb = zzbacVar;
        return this;
    }

    public final zzbab zzc(zzbau zzbauVar) {
        this.zzd = zzbauVar;
        return this;
    }

    public final zzbab zzd(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzbae zze() {
        zzmt.zzc(this.zza, "description");
        zzmt.zzc(this.zzb, "severity");
        zzmt.zzc(this.zzc, "timestampNanos");
        return new zzbae(this.zza, this.zzb, this.zzc.longValue(), null, this.zzd, null);
    }
}
