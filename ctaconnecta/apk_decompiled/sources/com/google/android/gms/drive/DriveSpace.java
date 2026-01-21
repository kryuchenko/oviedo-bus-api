package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.stats.CodePackage;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class DriveSpace extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzm();
    public static final DriveSpace zzah;
    public static final DriveSpace zzai;
    public static final DriveSpace zzaj;
    private static final Set<DriveSpace> zzak;
    private static final String zzal;
    private static final Pattern zzam;
    private final String name;

    DriveSpace(String str) {
        this.name = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.name.equals(((DriveSpace) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    static {
        DriveSpace driveSpace = new DriveSpace(CodePackage.DRIVE);
        zzah = driveSpace;
        DriveSpace driveSpace2 = new DriveSpace("APP_DATA_FOLDER");
        zzai = driveSpace2;
        DriveSpace driveSpace3 = new DriveSpace("PHOTOS");
        zzaj = driveSpace3;
        Set<DriveSpace> of = CollectionUtils.setOf(driveSpace, driveSpace2, driveSpace3);
        zzak = of;
        zzal = TextUtils.join(",", of.toArray());
        zzam = Pattern.compile("[A-Z0-9_]*");
    }
}
