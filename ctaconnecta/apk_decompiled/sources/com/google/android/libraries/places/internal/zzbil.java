package com.google.android.libraries.places.internal;

import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbil extends zzbmy {
    private boolean zzb;
    private final zzbdo zzc;
    private final zzbfs zzd;
    private final zzayx[] zze;

    public zzbil(zzbdo zzbdoVar, zzbfs zzbfsVar, zzayx[] zzayxVarArr) {
        zzmt.zzf(!zzbdoVar.zzl(), "error must not be OK");
        this.zzc = zzbdoVar;
        this.zzd = zzbfsVar;
        this.zze = zzayxVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbmy, com.google.android.libraries.places.internal.zzbfr
    public final void zzg(zzbjj zzbjjVar) {
        zzbjjVar.zzb(Constants.IPC_BUNDLE_KEY_SEND_ERROR, this.zzc);
        zzbjjVar.zzb("progress", this.zzd);
    }

    @Override // com.google.android.libraries.places.internal.zzbmy, com.google.android.libraries.places.internal.zzbfr
    public final void zzo(zzbft zzbftVar) {
        zzmt.zzp(!this.zzb, "already started");
        this.zzb = true;
        int i = 0;
        while (true) {
            zzayx[] zzayxVarArr = this.zze;
            if (i >= zzayxVarArr.length) {
                zzbftVar.zzd(this.zzc, this.zzd, new zzbcf());
                return;
            } else {
                zzayx zzayxVar = zzayxVarArr[i];
                i++;
            }
        }
    }
}
