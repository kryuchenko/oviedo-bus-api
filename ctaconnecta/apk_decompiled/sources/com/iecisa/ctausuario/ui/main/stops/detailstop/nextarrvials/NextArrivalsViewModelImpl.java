package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.google.android.gms.maps.model.LatLng;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.data.StopsRepository;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class NextArrivalsViewModelImpl extends BaseViewModel implements NextArrivalsViewModel {
    private NotificationRepository notificationRepository;
    private StopsRepository stopsRepository;

    @Inject
    public NextArrivalsViewModelImpl(Application application, StopsRepository stopsRepository, NotificationRepository notificationRepository) {
        super(application);
        this.stopsRepository = stopsRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsViewModel
    public LiveData<Resource<List<StopItinerary>>> getStopsItineraryNextArrivalsByMapStop(Integer idStop, Context context, LatLng destinationCoordinates, double radiusSearch) {
        return this.stopsRepository.getStopsItineraryNextArrivalsByMapStop(idStop, context, destinationCoordinates, radiusSearch);
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsViewModel
    public LiveData<Resource<ResponseBody>> addItinerary(Context context, Integer itineraryId, String deviceToken) {
        return this.notificationRepository.addSubscriptionItinerary(context, itineraryId, deviceToken);
    }
}
