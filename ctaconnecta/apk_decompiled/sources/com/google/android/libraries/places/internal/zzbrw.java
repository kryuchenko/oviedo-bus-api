package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbrw implements zzbec {
    final /* synthetic */ zzbry zza;

    zzbrw(zzbry zzbryVar) {
        this.zza = zzbryVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zza(zzbdo zzbdoVar) {
        int i = zzbvr.zza;
        synchronized (this.zza.zzf.zzc) {
            this.zza.zzf.zzQ(zzbdoVar, true, null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zzb(zzbra zzbraVar, boolean z, boolean z2, int i) {
        zzbwb zzbwbVarZze;
        int i2 = zzbvr.zza;
        if (zzbraVar == null) {
            zzbwbVarZze = zzbry.zza;
        } else {
            zzbwbVarZze = ((zzbsn) zzbraVar).zze();
            int iZzg = (int) zzbwbVarZze.zzg();
            if (iZzg > 0) {
                this.zza.zzs(iZzg);
            }
        }
        synchronized (this.zza.zzf.zzc) {
            zzbrx.zzL(this.zza.zzf, zzbwbVarZze, z, z2);
            this.zza.zze().zzd(i);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zzc(zzbcf zzbcfVar, byte[] bArr) {
        int i = zzbvr.zza;
        String str = RemoteSettings.FORWARD_SLASH_STRING + this.zza.zzb.zzf();
        synchronized (this.zza.zzf.zzc) {
            zzbrx.zzM(this.zza.zzf, zzbcfVar, str);
        }
    }
}
