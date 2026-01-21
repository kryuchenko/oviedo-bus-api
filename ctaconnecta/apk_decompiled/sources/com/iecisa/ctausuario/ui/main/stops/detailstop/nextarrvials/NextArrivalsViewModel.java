package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.google.android.gms.maps.model.LatLng;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface NextArrivalsViewModel {
    LiveData<Resource<ResponseBody>> addItinerary(Context context, Integer itineraryId, String deviceToken);

    LiveData<Resource<List<StopItinerary>>> getStopsItineraryNextArrivalsByMapStop(Integer idStop, Context context, LatLng destinationCoordinates, double radiusSearch);
}
