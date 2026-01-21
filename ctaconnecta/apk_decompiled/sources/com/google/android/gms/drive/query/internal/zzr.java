package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzr extends zza {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private List<Filter> zzls;
    private final zzx zzlz;
    private final List<FilterHolder> zzmo;

    zzr(zzx zzxVar, List<FilterHolder> list) {
        this.zzlz = zzxVar;
        this.zzmo = list;
    }

    public zzr(zzx zzxVar, Iterable<Filter> iterable) {
        this.zzlz = zzxVar;
        this.zzls = new ArrayList();
        this.zzmo = new ArrayList();
        for (Filter filter : iterable) {
            this.zzls.add(filter);
            this.zzmo.add(new FilterHolder(filter));
        }
    }

    public zzr(zzx zzxVar, Filter filter, Filter... filterArr) {
        this.zzlz = zzxVar;
        ArrayList arrayList = new ArrayList(filterArr.length + 1);
        this.zzmo = arrayList;
        arrayList.add(new FilterHolder(filter));
        ArrayList arrayList2 = new ArrayList(filterArr.length + 1);
        this.zzls = arrayList2;
        arrayList2.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzmo.add(new FilterHolder(filter2));
            this.zzls.add(filter2);
        }
    }

    @Override // com.google.android.gms.drive.query.Filter
    public final <T> T zza(zzj<T> zzjVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<FilterHolder> it = this.zzmo.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFilter().zza(zzjVar));
        }
        return zzjVar.zza(this.zzlz, arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlz, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzmo, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
