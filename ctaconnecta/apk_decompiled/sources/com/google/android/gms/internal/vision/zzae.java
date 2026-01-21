package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzae extends zzb implements zzaf {
    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.vision.zzaf
    public final zzad zza(IObjectWrapper iObjectWrapper, zzam zzamVar) throws RemoteException {
        zzad zzacVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzamVar);
        Parcel parcelZza = zza(1, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelZza.readStrongBinder();
        if (strongBinder == null) {
            zzacVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            if (iInterfaceQueryLocalInterface instanceof zzad) {
                zzacVar = (zzad) iInterfaceQueryLocalInterface;
            } else {
                zzacVar = new zzac(strongBinder);
            }
        }
        parcelZza.recycle();
        return zzacVar;
    }
}
