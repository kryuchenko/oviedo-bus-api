package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new zze();
    public final int height;
    public final int rotation;
    public final long timestampMillis;
    public final int width;
    private final int zza;

    public VisionImageMetadataParcel(int i, int i2, int i3, long j, int i4) {
        this.width = i;
        this.height = i2;
        this.zza = i3;
        this.timestampMillis = j;
        this.rotation = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.width);
        SafeParcelWriter.writeInt(parcel, 2, this.height);
        SafeParcelWriter.writeInt(parcel, 3, this.zza);
        SafeParcelWriter.writeLong(parcel, 4, this.timestampMillis);
        SafeParcelWriter.writeInt(parcel, 5, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public Matrix getUprightRotationMatrix() {
        if (this.rotation == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-this.width) / 2.0f, (-this.height) / 2.0f);
        matrix.postRotate(this.rotation * 90);
        boolean z = this.rotation % 2 != 0;
        matrix.postTranslate((z ? this.height : this.width) / 2.0f, (z ? this.width : this.height) / 2.0f);
        return matrix;
    }
}
