package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbsn implements zzbra {
    private final zzbwb zza;
    private int zzb;
    private int zzc;

    zzbsn(zzbwb zzbwbVar, int i) {
        this.zza = zzbwbVar;
        this.zzb = i;
    }

    @Override // com.google.android.libraries.places.internal.zzbra
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzbra
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbra
    public final void zzc(byte b) {
        this.zza.zzm(b);
        this.zzb--;
        this.zzc++;
    }

    @Override // com.google.android.libraries.places.internal.zzbra
    public final void zzd(byte[] bArr, int i, int i2) {
        this.zza.zzl(bArr, i, i2);
        this.zzb -= i2;
        this.zzc += i2;
    }

    final zzbwb zze() {
        return this.zza;
    }
}
