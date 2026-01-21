package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbsx {
    private final boolean zza;
    private String[] zzb;
    private String[] zzc;
    private boolean zzd;

    public zzbsx(zzbsz zzbszVar) {
        this.zza = zzbszVar.zzd;
        this.zzb = zzbszVar.zzg;
        this.zzc = zzbszVar.zzh;
        this.zzd = zzbszVar.zze;
    }

    public zzbsx(boolean z) {
        this.zza = z;
    }

    public final zzbsx zza(zzbsw... zzbswVarArr) {
        if (!this.zza) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[zzbswVarArr.length];
        for (int i = 0; i < zzbswVarArr.length; i++) {
            strArr[i] = zzbswVarArr[i].zzbb;
        }
        this.zzb = strArr;
        return this;
    }

    public final zzbsx zzb(String... strArr) throws CloneNotSupportedException {
        if (!this.zza) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr == null) {
            this.zzb = null;
            return this;
        }
        this.zzb = (String[]) strArr.clone();
        return this;
    }

    public final zzbsx zzc(boolean z) {
        if (!this.zza) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        this.zzd = true;
        return this;
    }

    public final zzbsx zzd(zzbtn... zzbtnVarArr) {
        if (!this.zza) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        String[] strArr = new String[zzbtnVarArr.length];
        for (int i = 0; i < zzbtnVarArr.length; i++) {
            strArr[i] = zzbtnVarArr[i].zzf;
        }
        this.zzc = strArr;
        return this;
    }

    public final zzbsx zze(String... strArr) throws CloneNotSupportedException {
        if (!this.zza) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr == null) {
            this.zzc = null;
            return this;
        }
        this.zzc = (String[]) strArr.clone();
        return this;
    }

    public final zzbsz zzf() {
        return new zzbsz(this);
    }
}
