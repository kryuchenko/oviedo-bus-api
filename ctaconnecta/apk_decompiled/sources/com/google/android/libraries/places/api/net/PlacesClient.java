package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public interface PlacesClient {
    Task<FetchPhotoResponse> fetchPhoto(FetchPhotoRequest fetchPhotoRequest);

    Task<FetchPlaceResponse> fetchPlace(FetchPlaceRequest fetchPlaceRequest);

    Task<FetchResolvedPhotoUriResponse> fetchResolvedPhotoUri(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest);

    Task<FindAutocompletePredictionsResponse> findAutocompletePredictions(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest);

    Task<FindCurrentPlaceResponse> findCurrentPlace(FindCurrentPlaceRequest findCurrentPlaceRequest);

    Task<IsOpenResponse> isOpen(IsOpenRequest isOpenRequest);

    Task<SearchByTextResponse> searchByText(SearchByTextRequest searchByTextRequest);

    Task<SearchNearbyResponse> searchNearby(SearchNearbyRequest searchNearbyRequest);

    Task zzb(FetchPlaceRequest fetchPlaceRequest, int i);

    Task zzd(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i);
}
