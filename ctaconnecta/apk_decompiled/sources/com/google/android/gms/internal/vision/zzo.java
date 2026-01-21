package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzo extends zzb implements zzl {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zza(IObjectWrapper iObjectWrapper, zzu zzuVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzuVar);
        Parcel parcelZza = zza(1, parcelObtainAndWriteInterfaceToken);
        Barcode[] barcodeArr = (Barcode[]) parcelZza.createTypedArray(Barcode.CREATOR);
        parcelZza.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zzb(IObjectWrapper iObjectWrapper, zzu zzuVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzuVar);
        Parcel parcelZza = zza(2, parcelObtainAndWriteInterfaceToken);
        Barcode[] barcodeArr = (Barcode[]) parcelZza.createTypedArray(Barcode.CREATOR);
        parcelZza.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final void zzn() throws RemoteException {
        zzb(3, obtainAndWriteInterfaceToken());
    }
}
