package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzlh implements zzla {
    public static final /* synthetic */ int zza = 0;
    private static final zznx zzb = zznx.zzn(Place.Field.ID, Place.Field.TYPES);
    private final PlacesClient zzc;
    private final zzkt zzd;
    private final AutocompleteSessionToken zze;
    private zzld zzf;
    private zzle zzg;

    public zzlh(PlacesClient placesClient, zzkt zzktVar, AutocompleteSessionToken autocompleteSessionToken) {
        this.zzc = placesClient;
        this.zzd = zzktVar;
        this.zze = autocompleteSessionToken;
    }

    @Override // com.google.android.libraries.places.internal.zzla
    public final Task zza(AutocompletePrediction autocompletePrediction) {
        if (zzb.containsAll(this.zzd.zzj())) {
            Place.Builder builder = Place.builder();
            builder.setId(autocompletePrediction.getPlaceId());
            builder.setTypes(autocompletePrediction.getPlaceTypes().isEmpty() ? null : autocompletePrediction.getPlaceTypes());
            return Tasks.forResult(FetchPlaceResponse.newInstance(builder.build()));
        }
        zzle zzleVar = this.zzg;
        if (zzleVar != null) {
            if (zzleVar.zzb().equals(autocompletePrediction.getPlaceId())) {
                Task taskZzc = zzleVar.zzc();
                taskZzc.getClass();
                return taskZzc;
            }
            zzleVar.zza().cancel();
        }
        final zzkz zzkzVar = new zzkz(new CancellationTokenSource(), autocompletePrediction.getPlaceId());
        this.zzg = zzkzVar;
        PlacesClient placesClient = this.zzc;
        FetchPlaceRequest.Builder builder2 = FetchPlaceRequest.builder(autocompletePrediction.getPlaceId(), this.zzd.zzj());
        builder2.setSessionToken(this.zze);
        builder2.setCancellationToken(zzkzVar.zza().getToken());
        Task taskContinueWithTask = placesClient.zzb(builder2.build(), 2).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzlb
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i = zzlh.zza;
                return zzkzVar.zza().getToken().isCancellationRequested() ? Tasks.forCanceled() : task;
            }
        });
        zzkzVar.zzd(taskContinueWithTask);
        return taskContinueWithTask;
    }

    @Override // com.google.android.libraries.places.internal.zzla
    public final Task zzb(String str, int i) {
        zzmt.zze(!TextUtils.isEmpty(str));
        zzld zzldVar = this.zzf;
        if (zzldVar != null) {
            if (zzldVar.zzb().equals(str)) {
                Task taskZzc = zzldVar.zzc();
                taskZzc.getClass();
                return taskZzc;
            }
            zzldVar.zza().cancel();
        }
        final zzky zzkyVar = new zzky(new CancellationTokenSource(), str);
        this.zzf = zzkyVar;
        PlacesClient placesClient = this.zzc;
        FindAutocompletePredictionsRequest.Builder builder = FindAutocompletePredictionsRequest.builder();
        builder.setQuery(str);
        builder.setLocationBias(this.zzd.zzc());
        builder.setLocationRestriction(this.zzd.zzd());
        builder.setCountries(this.zzd.zzi());
        builder.setRegionCode(this.zzd.zzn());
        builder.setInputOffset(Integer.valueOf(i));
        builder.setTypeFilter(this.zzd.zze());
        builder.setTypesFilter(this.zzd.zzk());
        builder.setSessionToken(this.zze);
        builder.setCancellationToken(zzkyVar.zza().getToken());
        Task taskContinueWithTask = placesClient.zzd(builder.build(), 2).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzlc
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i2 = zzlh.zza;
                return zzkyVar.zza().getToken().isCancellationRequested() ? Tasks.forCanceled() : task;
            }
        });
        zzkyVar.zzd(taskContinueWithTask);
        return taskContinueWithTask;
    }

    @Override // com.google.android.libraries.places.internal.zzla
    public final void zzc() {
        zzld zzldVar = this.zzf;
        if (zzldVar != null) {
            zzldVar.zza().cancel();
        }
        zzle zzleVar = this.zzg;
        if (zzleVar != null) {
            zzleVar.zza().cancel();
        }
        this.zzf = null;
        this.zzg = null;
    }
}
