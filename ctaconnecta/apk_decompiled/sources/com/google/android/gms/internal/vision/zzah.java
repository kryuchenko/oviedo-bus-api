package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzag();
    private final float zzdw;
    public final String zzek;
    public final zzao[] zzep;
    public final zzab zzeq;
    private final zzab zzer;
    private final zzab zzes;
    public final String zzet;
    private final int zzeu;
    public final boolean zzev;
    public final int zzew;
    public final int zzex;

    public zzah(zzao[] zzaoVarArr, zzab zzabVar, zzab zzabVar2, zzab zzabVar3, String str, float f, String str2, int i, boolean z, int i2, int i3) {
        this.zzep = zzaoVarArr;
        this.zzeq = zzabVar;
        this.zzer = zzabVar2;
        this.zzes = zzabVar3;
        this.zzet = str;
        this.zzdw = f;
        this.zzek = str2;
        this.zzeu = i;
        this.zzev = z;
        this.zzew = i2;
        this.zzex = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzep, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzeq, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzer, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzes, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzet, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdw);
        SafeParcelWriter.writeString(parcel, 8, this.zzek, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzeu);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzev);
        SafeParcelWriter.writeInt(parcel, 11, this.zzew);
        SafeParcelWriter.writeInt(parcel, 12, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
