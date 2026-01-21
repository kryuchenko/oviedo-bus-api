package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;

/* loaded from: classes3.dex */
public class FilterHolder extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzh();
    private final Filter zzbc;
    private final zzb<?> zzmd;
    private final zzd zzme;
    private final zzr zzmf;
    private final zzv zzmg;
    private final zzp<?> zzmh;
    private final zzt zzmi;
    private final zzn zzmj;
    private final zzl zzmk;
    private final zzz zzml;

    FilterHolder(zzb<?> zzbVar, zzd zzdVar, zzr zzrVar, zzv zzvVar, zzp<?> zzpVar, zzt zztVar, zzn<?> zznVar, zzl zzlVar, zzz zzzVar) {
        this.zzmd = zzbVar;
        this.zzme = zzdVar;
        this.zzmf = zzrVar;
        this.zzmg = zzvVar;
        this.zzmh = zzpVar;
        this.zzmi = zztVar;
        this.zzmj = zznVar;
        this.zzmk = zzlVar;
        this.zzml = zzzVar;
        if (zzbVar != null) {
            this.zzbc = zzbVar;
            return;
        }
        if (zzdVar != null) {
            this.zzbc = zzdVar;
            return;
        }
        if (zzrVar != null) {
            this.zzbc = zzrVar;
            return;
        }
        if (zzvVar != null) {
            this.zzbc = zzvVar;
            return;
        }
        if (zzpVar != null) {
            this.zzbc = zzpVar;
            return;
        }
        if (zztVar != null) {
            this.zzbc = zztVar;
            return;
        }
        if (zznVar != null) {
            this.zzbc = zznVar;
        } else if (zzlVar != null) {
            this.zzbc = zzlVar;
        } else {
            if (zzzVar == null) {
                throw new IllegalArgumentException("At least one filter must be set.");
            }
            this.zzbc = zzzVar;
        }
    }

    public FilterHolder(Filter filter) {
        Preconditions.checkNotNull(filter, "Null filter.");
        zzb<?> zzbVar = filter instanceof zzb ? (zzb) filter : null;
        this.zzmd = zzbVar;
        zzd zzdVar = filter instanceof zzd ? (zzd) filter : null;
        this.zzme = zzdVar;
        zzr zzrVar = filter instanceof zzr ? (zzr) filter : null;
        this.zzmf = zzrVar;
        zzv zzvVar = filter instanceof zzv ? (zzv) filter : null;
        this.zzmg = zzvVar;
        zzp<?> zzpVar = filter instanceof zzp ? (zzp) filter : null;
        this.zzmh = zzpVar;
        zzt zztVar = filter instanceof zzt ? (zzt) filter : null;
        this.zzmi = zztVar;
        zzn zznVar = filter instanceof zzn ? (zzn) filter : null;
        this.zzmj = zznVar;
        zzl zzlVar = filter instanceof zzl ? (zzl) filter : null;
        this.zzmk = zzlVar;
        zzz zzzVar = filter instanceof zzz ? (zzz) filter : null;
        this.zzml = zzzVar;
        if (zzbVar == null && zzdVar == null && zzrVar == null && zzvVar == null && zzpVar == null && zztVar == null && zznVar == null && zzlVar == null && zzzVar == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzbc = filter;
    }

    public final Filter getFilter() {
        return this.zzbc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzme, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzmf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzmg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzmh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzmi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzmj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzmk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzml, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
