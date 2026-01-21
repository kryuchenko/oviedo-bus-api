package com.iecisa.ctausuario.ui.main.stops.mapstops;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.google.android.gms.maps.model.LatLng;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.SearchAddress;
import java.util.List;

/* loaded from: classes5.dex */
public interface MapStopsViewModel {
    void deleteOldSearchAddresses();

    LiveData<List<SearchAddress>> getSearchAdress(SearchAddress searchAddress);

    LiveData<Resource<List<MapStop>>> getStops(LatLng currentLocation, double visibleRegion, Context context, SearchAddress destinationCoordinates);

    LiveData<Long> insertSearchAddress(SearchAddress searchAddress);
}
