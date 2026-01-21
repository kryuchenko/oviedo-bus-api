package com.google.mlkit.vision.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zze implements Parcelable.Creator<VisionImageMetadataParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisionImageMetadataParcel[] newArray(int i) {
        return new VisionImageMetadataParcel[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisionImageMetadataParcel createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 2) {
                i2 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 3) {
                i3 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 4) {
                j = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId == 5) {
                i4 = SafeParcelReader.readInt(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new VisionImageMetadataParcel(i, i2, i3, j, i4);
    }
}
