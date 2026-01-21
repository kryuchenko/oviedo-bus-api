package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbjt extends zzbin {
    final /* synthetic */ zzbfr zza;
    final /* synthetic */ zzbjv zzb;

    zzbjt(zzbjv zzbjvVar, zzbfr zzbfrVar) {
        this.zza = zzbfrVar;
        this.zzb = zzbjvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbin
    protected final zzbfr zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbin, com.google.android.libraries.places.internal.zzbfr
    public final void zzo(zzbft zzbftVar) {
        this.zzb.zzb.zzb();
        this.zza.zzo(new zzbjs(this, zzbftVar));
    }
}
