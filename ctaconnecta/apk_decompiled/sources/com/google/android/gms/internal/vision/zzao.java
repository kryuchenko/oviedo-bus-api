package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzar();
    private final float zzdw;
    public final String zzek;
    public final zzab zzeq;
    private final zzab zzer;
    public final String zzet;
    private final zzal[] zzez;
    private final boolean zzfa;

    public zzao(zzal[] zzalVarArr, zzab zzabVar, zzab zzabVar2, String str, float f, String str2, boolean z) {
        this.zzez = zzalVarArr;
        this.zzeq = zzabVar;
        this.zzer = zzabVar2;
        this.zzet = str;
        this.zzdw = f;
        this.zzek = str2;
        this.zzfa = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzez, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzeq, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzer, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzet, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzdw);
        SafeParcelWriter.writeString(parcel, 7, this.zzek, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzfa);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
