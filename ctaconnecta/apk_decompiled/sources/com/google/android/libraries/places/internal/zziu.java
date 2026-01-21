package com.google.android.libraries.places.internal;

import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zziu implements zzev {
    private final zzki zza;
    private final zzfa zzb;
    private final zzfg zzc;
    private final zzjr zzd;
    private final zzdv zze;
    private final zzhv zzf;
    private final zzhz zzg;
    private final zzid zzh;
    private final zzih zzi;
    private final zzjs zzj;

    zziu(zzjs zzjsVar, zzki zzkiVar, zzfa zzfaVar, zzfg zzfgVar, zzjr zzjrVar, zzdv zzdvVar, zzhv zzhvVar, zzhz zzhzVar, zzid zzidVar, zzih zzihVar) {
        this.zzj = zzjsVar;
        this.zza = zzkiVar;
        this.zzb = zzfaVar;
        this.zzc = zzfgVar;
        this.zzd = zzjrVar;
        this.zze = zzdvVar;
        this.zzf = zzhvVar;
        this.zzg = zzhzVar;
        this.zzh = zzidVar;
        this.zzi = zzihVar;
    }

    static final /* synthetic */ FetchPlaceResponse zzi(Task task) throws Exception {
        zzhy zzhyVar = (zzhy) task.getResult();
        int iZza = zzjb.zza(zzhyVar.status);
        if (PlacesStatusCodes.isError(iZza)) {
            throw new ApiException(new Status(iZza, zzjb.zzb(zzhyVar.status, zzhyVar.errorMessage)));
        }
        zzja zzjaVar = zzhyVar.result;
        String[] strArr = zzhyVar.htmlAttributions;
        return FetchPlaceResponse.newInstance(zzix.zzg(zzjaVar, strArr != null ? zznx.zzk(strArr) : null));
    }

    static final /* synthetic */ FindCurrentPlaceResponse zzj(Task task) throws Exception {
        zzig zzigVar = (zzig) task.getResult();
        int iZza = zzjb.zza(zzigVar.status);
        if (PlacesStatusCodes.isError(iZza)) {
            throw new ApiException(new Status(iZza, zzjb.zzb(zzigVar.status, zzigVar.errorMessage)));
        }
        ArrayList arrayList = new ArrayList();
        zziz[] zzizVarArr = zzigVar.predictions;
        if (zzizVarArr != null) {
            for (zziz zzizVar : zzizVarArr) {
                if (zzizVar.zza() == null) {
                    throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a Place value"));
                }
                Double dZzb = zzizVar.zzb();
                if (dZzb == null) {
                    throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a likelihood value"));
                }
                zzja zzjaVarZza = zzizVar.zza();
                String[] strArr = zzigVar.htmlAttributions;
                arrayList.add(PlaceLikelihood.newInstance(zzix.zzg(zzjaVarZza, strArr != null ? zznx.zzk(strArr) : null), dZzb.doubleValue()));
            }
        }
        return FindCurrentPlaceResponse.newInstance(arrayList);
    }

    @Override // com.google.android.libraries.places.internal.zzev
    public final Task zza(FetchPhotoRequest fetchPhotoRequest, int i) {
        Integer maxWidth = fetchPhotoRequest.getMaxWidth();
        Integer maxHeight = fetchPhotoRequest.getMaxHeight();
        if (maxWidth == null && maxHeight == null) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Must include max width or max height in request.")));
        }
        final int i2 = 1;
        if (maxWidth != null && maxWidth.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, String.format("Max Width must not be < 1, but was: %d.", maxWidth))));
        }
        if (maxHeight != null && maxHeight.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, String.format("Max Height must not be < 1, but was: %d.", maxHeight))));
        }
        zzjs zzjsVar = this.zzj;
        String strZza = zzjsVar.zza();
        zzjsVar.zzf();
        zzhr zzhrVar = new zzhr(fetchPhotoRequest, strZza, false, this.zza);
        zzdv zzdvVar = this.zze;
        zzfg zzfgVar = this.zzc;
        final long jZza = zzdvVar.zza();
        return zzfgVar.zzb(zzhrVar, new zzhs()).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzim
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FetchPhotoResponse.newInstance(((zzhu) task.getResult()).zza);
            }
        }).continueWith(new Continuation(jZza, i2) { // from class: com.google.android.libraries.places.internal.zzin
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zze(this.zzb, 1, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzev
    public final Task zzb(FetchPlaceRequest fetchPlaceRequest, final int i) {
        if (TextUtils.isEmpty(fetchPlaceRequest.getPlaceId())) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place ID must not be empty.")));
        }
        if (fetchPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty.")));
        }
        zzjs zzjsVar = this.zzj;
        Locale localeZzb = zzjsVar.zzb();
        String strZza = zzjsVar.zza();
        zzjsVar.zzf();
        zzhx zzhxVar = new zzhx(fetchPlaceRequest, localeZzb, strZza, false, this.zza);
        zzdv zzdvVar = this.zze;
        zzfa zzfaVar = this.zzb;
        final long jZza = zzdvVar.zza();
        return zzfaVar.zza(zzhxVar, zzhy.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzis
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zziu.zzi(task);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzit
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzf(jZza, i, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzev
    public final Task zzc(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, final int i) {
        String query = findAutocompletePredictionsRequest.getQuery();
        if (query == null || TextUtils.isEmpty(query.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.newInstance(zznx.zzl()));
        }
        zzjs zzjsVar = this.zzj;
        Locale localeZzb = zzjsVar.zzb();
        String strZza = zzjsVar.zza();
        zzjsVar.zzf();
        zzib zzibVar = new zzib(findAutocompletePredictionsRequest, localeZzb, strZza, false, this.zza);
        zzdv zzdvVar = this.zze;
        zzfa zzfaVar = this.zzb;
        final long jZza = zzdvVar.zza();
        return zzfaVar.zza(zzibVar, zzic.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzio
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzid.zza((zzic) task.getResult());
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzip
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzg(jZza, i, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzev
    public final Task zzd(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zznx zznxVar, int i) {
        if (findCurrentPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty.")));
        }
        zzjs zzjsVar = this.zzj;
        Locale localeZzb = zzjsVar.zzb();
        String strZza = zzjsVar.zza();
        zzjsVar.zzf();
        zzif zzifVar = new zzif(findCurrentPlaceRequest, location, zznxVar, localeZzb, strZza, false, this.zza);
        zzdv zzdvVar = this.zze;
        zzfa zzfaVar = this.zzb;
        final long jZza = zzdvVar.zza();
        final int i2 = 1;
        return zzfaVar.zza(zzifVar, zzig.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zziq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zziu.zzj(task);
            }
        }).continueWith(new Continuation(jZza, i2) { // from class: com.google.android.libraries.places.internal.zzir
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzh(this.zzb, 1, task);
            }
        });
    }

    final /* synthetic */ FetchPhotoResponse zze(long j, int i, Task task) throws Exception {
        this.zzd.zzb(task, j, this.zze.zza(), 1);
        return (FetchPhotoResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse zzf(long j, int i, Task task) throws Exception {
        this.zzd.zzl(task, j, this.zze.zza(), 2, i);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FindAutocompletePredictionsResponse zzg(long j, int i, Task task) throws Exception {
        this.zzd.zzn(task, j, this.zze.zza(), 2, i);
        return (FindAutocompletePredictionsResponse) task.getResult();
    }

    final /* synthetic */ FindCurrentPlaceResponse zzh(long j, int i, Task task) throws Exception {
        this.zzd.zzf(task, j, this.zze.zza(), 1);
        return (FindCurrentPlaceResponse) task.getResult();
    }
}
