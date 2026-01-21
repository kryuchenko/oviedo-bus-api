package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzhc {
    private final zzapv zza;
    private final zzjw zzb;
    private final zzjr zzc;
    private final zzdv zzd;
    private final zzhk zze;
    private final zzhm zzf;
    private final zzgk zzg;
    private final zzgh zzh;
    private final zzgc zzi;
    private final zzho zzj;
    private final zzhe zzk;
    private final zzjs zzl;

    zzhc(zzjs zzjsVar, zzapv zzapvVar, zzjr zzjrVar, zzdv zzdvVar, zzhm zzhmVar, zzhk zzhkVar, zzgk zzgkVar, zzgh zzghVar, zzgc zzgcVar, zzhe zzheVar, zzho zzhoVar, zzjw zzjwVar) {
        this.zzl = zzjsVar;
        this.zza = zzapvVar;
        this.zzb = zzjwVar;
        this.zzc = zzjrVar;
        this.zzd = zzdvVar;
        this.zzf = zzhmVar;
        this.zze = zzhkVar;
        this.zzg = zzgkVar;
        this.zzi = zzgcVar;
        this.zzh = zzghVar;
        this.zzk = zzheVar;
        this.zzj = zzhoVar;
    }

    final /* synthetic */ Task zza(zzamn zzamnVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ArrayList arrayList = new ArrayList();
        Iterator it = zzamnVar.zzd().iterator();
        while (it.hasNext()) {
            arrayList.add(this.zzj.zza((zzamm) it.next()));
        }
        taskCompletionSource.setResult(FindAutocompletePredictionsResponse.newInstance(arrayList));
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ Task zzb(zzaps zzapsVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(FetchPlaceResponse.newInstance(this.zzk.zza(zzapsVar)));
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ Task zzc(zzarr zzarrVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        List listZzd = zzarrVar.zzd();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZzd.iterator();
        while (it.hasNext()) {
            arrayList.add(this.zzk.zza((zzaps) it.next()));
        }
        taskCompletionSource.setResult(SearchByTextResponse.newInstance(arrayList));
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ Task zzd(zzarc zzarcVar) throws Exception {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        List listZzd = zzarcVar.zzd();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZzd.iterator();
        while (it.hasNext()) {
            arrayList.add(this.zzk.zza((zzaps) it.next()));
        }
        taskCompletionSource.setResult(SearchNearbyResponse.newInstance(arrayList));
        return taskCompletionSource.getTask();
    }

    public final Task zze(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i) {
        String regionCode = findAutocompletePredictionsRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        String query = findAutocompletePredictionsRequest.getQuery();
        if (query == null) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Query must not be null.")));
        }
        if (TextUtils.isEmpty(query.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.newInstance(zznx.zzl()));
        }
        zzdv zzdvVar = this.zzd;
        zzapv zzapvVar = this.zza;
        zzjw zzjwVar = this.zzb;
        zzjs zzjsVar = this.zzl;
        final long jZza = zzdvVar.zza();
        final int i2 = 1;
        zzbur zzburVarZze = zzapvVar.zze(zzbva.zza(zzjwVar.zza("", zzjsVar.zza())));
        zzalt zzaltVarZza = zzaly.zza();
        String query2 = findAutocompletePredictionsRequest.getQuery();
        query2.getClass();
        zzaltVarZza.zzc(query2);
        Integer inputOffset = findAutocompletePredictionsRequest.getInputOffset();
        if (inputOffset != null) {
            zzaltVarZza.zzd(inputOffset.intValue());
        }
        String regionCode2 = findAutocompletePredictionsRequest.getRegionCode();
        if (regionCode2 != null) {
            zzaltVarZza.zzh(regionCode2);
        }
        LocationBias locationBias = findAutocompletePredictionsRequest.getLocationBias();
        if (locationBias != null) {
            boolean z = locationBias instanceof CircularBounds;
            zzmt.zze(z || (locationBias instanceof RectangularBounds));
            zzalu zzaluVarZza = zzalv.zza();
            if (z) {
                zzaluVarZza.zza(zzge.zza((CircularBounds) locationBias));
            }
            if (locationBias instanceof RectangularBounds) {
                zzaluVarZza.zzb(zzge.zzb((RectangularBounds) locationBias));
            }
            zzaltVarZza.zze((zzalv) zzaluVarZza.zzt());
        }
        LocationRestriction locationRestriction = findAutocompletePredictionsRequest.getLocationRestriction();
        if (locationRestriction != null) {
            boolean z2 = locationRestriction instanceof CircularBounds;
            zzmt.zze(z2 || (locationRestriction instanceof RectangularBounds));
            zzalw zzalwVarZza = zzalx.zza();
            if (z2) {
                zzalwVarZza.zza(zzge.zza((CircularBounds) locationRestriction));
            }
            if (locationRestriction instanceof RectangularBounds) {
                zzalwVarZza.zzb(zzge.zzb((RectangularBounds) locationRestriction));
            }
            zzaltVarZza.zzf((zzalx) zzalwVarZza.zzt());
        }
        LatLng origin = findAutocompletePredictionsRequest.getOrigin();
        if (origin != null) {
            zzaxo zzaxoVarZzf = zzaxp.zzf();
            zzaxoVarZzf.zza(origin.latitude);
            zzaxoVarZzf.zzb(origin.longitude);
            zzaltVarZza.zzg((zzaxp) zzaxoVarZzf.zzt());
        }
        Iterator<String> it = findAutocompletePredictionsRequest.getCountries().iterator();
        while (it.hasNext()) {
            zzaltVarZza.zzb(it.next());
        }
        AutocompleteSessionToken sessionToken = findAutocompletePredictionsRequest.getSessionToken();
        if (sessionToken != null) {
            zzaltVarZza.zzi(sessionToken.toString());
        }
        Iterator<String> it2 = findAutocompletePredictionsRequest.getTypesFilter().iterator();
        while (it2.hasNext()) {
            zzaltVarZza.zza(it2.next());
        }
        final zzaka zzakaVarZza = zzbux.zza(zzburVarZze.zzd().zza(zzapw.zzb(), zzburVarZze.zzc()), (zzaly) zzaltVarZza.zzt());
        CancellationToken cancellationToken = findAutocompletePredictionsRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgn
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzakaVarZza.cancel(true);
                }
            });
        }
        return zzed.zza(zzakaVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgt
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zza.zza((zzamn) obj);
            }
        }).continueWithTask(new Continuation(jZza, i2) { // from class: com.google.android.libraries.places.internal.zzgu
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzh(this.zzb, 1, task);
                return task;
            }
        });
    }

    public final Task zzf(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, int i) {
        final long jZza = this.zzd.zza();
        final int i2 = 1;
        zzbur zzburVarZze = this.zza.zze(zzbva.zza(this.zzb.zza("", this.zzl.zza())));
        zzanw zzanwVarZza = zzanx.zza();
        String strZza = fetchResolvedPhotoUriRequest.getPhotoMetadata().zza();
        strZza.getClass();
        zzanwVarZza.zzc(strZza.concat("/media"));
        Integer maxHeight = fetchResolvedPhotoUriRequest.getMaxHeight();
        if (maxHeight != null) {
            zzanwVarZza.zza(maxHeight.intValue());
        }
        Integer maxWidth = fetchResolvedPhotoUriRequest.getMaxWidth();
        if (maxWidth != null) {
            zzanwVarZza.zzb(maxWidth.intValue());
        }
        zzanwVarZza.zzd(true);
        final zzaka zzakaVarZza = zzbux.zza(zzburVarZze.zzd().zza(zzapw.zzc(), zzburVarZze.zzc()), (zzanx) zzanwVarZza.zzt());
        CancellationToken cancellationToken = fetchResolvedPhotoUriRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgq
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzakaVarZza.cancel(true);
                }
            });
        }
        return zzed.zza(zzakaVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgr
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(FetchResolvedPhotoUriResponse.newInstance(Uri.parse(((zzaoj) obj).zzd())));
                return taskCompletionSource.getTask();
            }
        }).continueWithTask(new Continuation(jZza, i2) { // from class: com.google.android.libraries.places.internal.zzgs
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzi(this.zzb, 1, task);
                return task;
            }
        });
    }

    public final Task zzg(FetchPlaceRequest fetchPlaceRequest, int i) {
        if (fetchPlaceRequest.getPlaceId().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place id must not be an empty string.")));
        }
        List<Place.Field> placeFields = fetchPlaceRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        String regionCode = fetchPlaceRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long jZza = this.zzd.zza();
        final int i2 = 1;
        zzbur zzburVarZze = this.zza.zze(zzbva.zza(this.zzb.zza(zzjv.zzb(zzhg.zza(placeFields)), this.zzl.zza())));
        Locale localeZzb = this.zzl.zzb();
        zzanz zzanzVarZza = zzaoa.zza();
        zzanzVarZza.zzb("places/".concat(String.valueOf(fetchPlaceRequest.getPlaceId())));
        String regionCode2 = fetchPlaceRequest.getRegionCode();
        if (regionCode2 != null) {
            zzanzVarZza.zzc(regionCode2);
        }
        AutocompleteSessionToken sessionToken = fetchPlaceRequest.getSessionToken();
        if (sessionToken != null) {
            zzanzVarZza.zzd(sessionToken.toString());
        }
        zzanzVarZza.zza(localeZzb.toLanguageTag());
        final zzaka zzakaVarZza = zzbux.zza(zzburVarZze.zzd().zza(zzapw.zzd(), zzburVarZze.zzc()), (zzaoa) zzanzVarZza.zzt());
        CancellationToken cancellationToken = fetchPlaceRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgv
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzakaVarZza.cancel(true);
                }
            });
        }
        return zzed.zza(zzakaVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgw
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zza.zzb((zzaps) obj);
            }
        }).continueWithTask(new Continuation(jZza, i2) { // from class: com.google.android.libraries.places.internal.zzgx
            public final /* synthetic */ long zzb;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzj(this.zzb, 1, task);
                return task;
            }
        });
    }

    final /* synthetic */ Task zzh(long j, int i, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzn(task, j, this.zzd.zza(), 3, 1);
        return task;
    }

    final /* synthetic */ Task zzi(long j, int i, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzd(task, j, this.zzd.zza(), 1);
        return task;
    }

    final /* synthetic */ Task zzj(long j, int i, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzl(task, j, this.zzd.zza(), 3, 1);
        return task;
    }

    final /* synthetic */ Task zzk(SearchByTextRequest searchByTextRequest, long j, int i, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzh(searchByTextRequest, task, j, this.zzd.zza(), 1);
        return task;
    }

    final /* synthetic */ Task zzl(SearchNearbyRequest searchNearbyRequest, long j, int i, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzc.zzj(searchNearbyRequest, task, j, this.zzd.zza(), 1);
        return task;
    }

    public final Task zzm(final SearchByTextRequest searchByTextRequest, int i) {
        int i2;
        List<Place.Field> placeFields = searchByTextRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        if (searchByTextRequest.getTextQuery().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Text query must not be an empty string.")));
        }
        String includedType = searchByTextRequest.getIncludedType();
        if (includedType != null && includedType.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Included type must not be an empty string.")));
        }
        String regionCode = searchByTextRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long jZza = this.zzd.zza();
        zzbur zzburVarZze = this.zza.zze(zzbva.zza(this.zzb.zza(zzjv.zza(zzhg.zza(placeFields)), this.zzl.zza())));
        Locale localeZzb = this.zzl.zzb();
        zzare zzareVarZza = zzaro.zza();
        String includedType2 = searchByTextRequest.getIncludedType();
        if (includedType2 != null) {
            zzareVarZza.zzb(includedType2);
        }
        LocationBias locationBias = searchByTextRequest.getLocationBias();
        if (locationBias != null) {
            boolean z = locationBias instanceof RectangularBounds;
            zzmt.zzf(z || (locationBias instanceof CircularBounds), "LocationBias must be of type RectangularBounds or CircularBounds.");
            zzari zzariVarZza = zzarj.zza();
            if (z) {
                zzariVarZza.zzb(zzge.zzb((RectangularBounds) locationBias));
            } else {
                zzariVarZza.zza(zzge.zza((CircularBounds) locationBias));
            }
            zzareVarZza.zzd((zzarj) zzariVarZza.zzt());
        }
        LocationRestriction locationRestriction = searchByTextRequest.getLocationRestriction();
        if (locationRestriction != null) {
            zzmt.zzf(locationRestriction instanceof RectangularBounds, "LocationRestriction must be of type RectangularBounds.");
            zzark zzarkVarZza = zzarl.zza();
            zzarkVarZza.zza(zzge.zzb((RectangularBounds) locationRestriction));
            zzareVarZza.zze((zzarl) zzarkVarZza.zzt());
        }
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zzareVarZza.zzf(maxResultCount.intValue());
        }
        Double minRating = searchByTextRequest.getMinRating();
        if (minRating != null) {
            zzareVarZza.zzg(minRating.doubleValue());
        }
        zzareVarZza.zzh(searchByTextRequest.isOpenNow());
        List<Integer> priceLevels = searchByTextRequest.getPriceLevels();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = priceLevels.iterator();
        while (true) {
            i2 = 4;
            if (!it.hasNext()) {
                break;
            }
            int iIntValue = it.next().intValue();
            if (iIntValue == 0) {
                arrayList.add(zzaqb.PRICE_LEVEL_FREE);
            } else if (iIntValue == 1) {
                arrayList.add(zzaqb.PRICE_LEVEL_INEXPENSIVE);
            } else if (iIntValue == 2) {
                arrayList.add(zzaqb.PRICE_LEVEL_MODERATE);
            } else if (iIntValue == 3) {
                arrayList.add(zzaqb.PRICE_LEVEL_EXPENSIVE);
            } else if (iIntValue == 4) {
                arrayList.add(zzaqb.PRICE_LEVEL_VERY_EXPENSIVE);
            }
        }
        zzareVarZza.zza(arrayList);
        SearchByTextRequest.RankPreference rankPreference = searchByTextRequest.getRankPreference();
        if (rankPreference == null) {
            i2 = 2;
        } else if (rankPreference.ordinal() == 0) {
            i2 = 3;
        }
        zzareVarZza.zzl(i2);
        String regionCode2 = searchByTextRequest.getRegionCode();
        if (regionCode2 != null) {
            zzareVarZza.zzi(regionCode2);
        }
        zzareVarZza.zzj(searchByTextRequest.isStrictTypeFiltering());
        zzareVarZza.zzk(searchByTextRequest.getTextQuery());
        zzareVarZza.zzc(localeZzb.toLanguageTag());
        final zzaka zzakaVarZza = zzbux.zza(zzburVarZze.zzd().zza(zzapw.zzf(), zzburVarZze.zzc()), (zzaro) zzareVarZza.zzt());
        CancellationToken cancellationToken = searchByTextRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzhb
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzakaVarZza.cancel(true);
                }
            });
        }
        final int i3 = 1;
        return zzed.zza(zzakaVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgo
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zza.zzc((zzarr) obj);
            }
        }).continueWithTask(new Continuation(searchByTextRequest, jZza, i3) { // from class: com.google.android.libraries.places.internal.zzgp
            public final /* synthetic */ SearchByTextRequest zzb;
            public final /* synthetic */ long zzc;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzk(this.zzb, this.zzc, 1, task);
                return task;
            }
        });
    }

    public final Task zzn(final SearchNearbyRequest searchNearbyRequest, int i) {
        List<Place.Field> placeFields = searchNearbyRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        String regionCode = searchNearbyRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long jZza = this.zzd.zza();
        zzbur zzburVarZze = this.zza.zze(zzbva.zza(this.zzb.zza(zzjv.zza(zzhg.zza(placeFields)), this.zzl.zza())));
        Locale localeZzb = this.zzl.zzb();
        zzaqu zzaquVarZza = zzaqz.zza();
        zzaquVarZza.zze(localeZzb.toLanguageTag());
        String regionCode2 = searchNearbyRequest.getRegionCode();
        if (regionCode2 != null) {
            zzaquVarZza.zzh(regionCode2);
        }
        List<String> includedTypes = searchNearbyRequest.getIncludedTypes();
        if (includedTypes != null) {
            zzaquVarZza.zzd(includedTypes);
        }
        List<String> excludedTypes = searchNearbyRequest.getExcludedTypes();
        if (excludedTypes != null) {
            zzaquVarZza.zzb(excludedTypes);
        }
        List<String> includedPrimaryTypes = searchNearbyRequest.getIncludedPrimaryTypes();
        if (includedPrimaryTypes != null) {
            zzaquVarZza.zzc(includedPrimaryTypes);
        }
        List<String> excludedPrimaryTypes = searchNearbyRequest.getExcludedPrimaryTypes();
        if (excludedPrimaryTypes != null) {
            zzaquVarZza.zza(excludedPrimaryTypes);
        }
        Integer maxResultCount = searchNearbyRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zzaquVarZza.zzg(maxResultCount.intValue());
        }
        zzaqx zzaqxVarZza = zzaqy.zza();
        zzaqxVarZza.zza(zzge.zza((CircularBounds) searchNearbyRequest.getLocationRestriction()));
        zzaquVarZza.zzf((zzaqy) zzaqxVarZza.zzt());
        SearchNearbyRequest.RankPreference rankPreference = searchNearbyRequest.getRankPreference();
        zzaquVarZza.zzi(rankPreference == null ? 2 : rankPreference.ordinal() != 0 ? 4 : 3);
        final zzaka zzakaVarZza = zzbux.zza(zzburVarZze.zzd().zza(zzapw.zze(), zzburVarZze.zzc()), (zzaqz) zzaquVarZza.zzt());
        CancellationToken cancellationToken = searchNearbyRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgy
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzakaVarZza.cancel(true);
                }
            });
        }
        final int i2 = 1;
        return zzed.zza(zzakaVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgz
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zza.zzd((zzarc) obj);
            }
        }).continueWithTask(new Continuation(searchNearbyRequest, jZza, i2) { // from class: com.google.android.libraries.places.internal.zzha
            public final /* synthetic */ SearchNearbyRequest zzb;
            public final /* synthetic */ long zzc;

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzl(this.zzb, this.zzc, 1, task);
                return task;
            }
        });
    }
}
