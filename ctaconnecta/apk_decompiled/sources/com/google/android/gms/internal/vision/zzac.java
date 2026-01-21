package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzac extends zzb implements zzad {
    zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final zzah[] zza(IObjectWrapper iObjectWrapper, zzu zzuVar, zzaj zzajVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzuVar);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzajVar);
        Parcel parcelZza = zza(3, parcelObtainAndWriteInterfaceToken);
        zzah[] zzahVarArr = (zzah[]) parcelZza.createTypedArray(zzah.CREATOR);
        parcelZza.recycle();
        return zzahVarArr;
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final void zzr() throws RemoteException {
        zzb(2, obtainAndWriteInterfaceToken());
    }
}
