package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zzok;
import com.google.android.material.timepicker.TimeModel;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class LocalDate implements Parcelable, Comparable<LocalDate> {
    public static LocalDate newInstance(int i, int i2, int i3) {
        zzm zzmVar = new zzm();
        zzmVar.zzc(i);
        zzmVar.zzb(i2);
        zzmVar.zza(i3);
        LocalDate localDateZzd = zzmVar.zzd();
        int month = localDateZzd.getMonth();
        zzok zzokVarZzb = zzok.zzb(1, 12);
        Integer numValueOf = Integer.valueOf(month);
        zzmt.zzh(zzokVarZzb.zzd(numValueOf), "Month must not be out of range of 1 to 12, but was: %s.", month);
        int day = localDateZzd.getDay();
        zzok zzokVarZzb2 = zzok.zzb(1, 31);
        Integer numValueOf2 = Integer.valueOf(day);
        zzmt.zzh(zzokVarZzb2.zzd(numValueOf2), "Day must not be out of range of 1 to 31, but was: %s.", day);
        if (Arrays.asList(4, 6, 9, 11).contains(numValueOf) && !zzok.zzb(1, 30).zzd(numValueOf2)) {
            throw new IllegalArgumentException(zznb.zzb("%s is not a valid day for month %s.", numValueOf2, numValueOf));
        }
        if (month == 2) {
            int year = localDateZzd.getYear();
            zzmt.zzm(zzok.zzb(1, Integer.valueOf(year % 4 == 0 ? 29 : 28)).zzd(numValueOf2), "%s is not a valid day for month %s in year %s.", numValueOf2, 2, Integer.valueOf(year));
        }
        return localDateZzd;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalDate localDate) {
        int day;
        int day2;
        zzmt.zzc(localDate, "dateToCompare must not be null.");
        if (this == localDate) {
            return 0;
        }
        if (getYear() != localDate.getYear()) {
            day = getYear();
            day2 = localDate.getYear();
        } else if (getMonth() != localDate.getMonth()) {
            day = getMonth();
            day2 = localDate.getMonth();
        } else {
            day = getDay();
            day2 = localDate.getDay();
        }
        return day - day2;
    }

    public abstract int getDay();

    public abstract int getMonth();

    public abstract int getYear();

    public final String toString() {
        return String.format(Locale.getDefault(), "%s-%s-%s", Integer.valueOf(getYear()), String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(getMonth())), String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(getDay())));
    }
}
