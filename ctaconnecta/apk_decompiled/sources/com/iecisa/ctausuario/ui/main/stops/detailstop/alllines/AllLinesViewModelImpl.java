package com.iecisa.ctausuario.ui.main.stops.detailstop.alllines;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.data.NotificationRepository;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class AllLinesViewModelImpl extends BaseViewModel implements AllLinesViewModel {
    private LinesRepository linesRepository;
    private NotificationRepository notificationRepository;

    @Inject
    public AllLinesViewModelImpl(Application application, LinesRepository linesRepository, NotificationRepository notificationRepository) {
        super(application);
        this.linesRepository = linesRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModel
    public LiveData<Resource<List<StopItinerary>>> getStopsItineraryByMapStop(Integer idStop, Context context) {
        return this.linesRepository.getStopsItineraryByMapStop(idStop, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModel
    public LiveData<Resource<ResponseBody>> addItinerary(Context context, Integer itineraryId, String deviceToken) {
        return this.notificationRepository.addSubscriptionItinerary(context, itineraryId, deviceToken);
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModel
    public LiveData<Resource<ResponseBody>> deleteItinerary(Context context, Integer itineraryId, String deviceToken) {
        return this.notificationRepository.deleteSubscriptionItinerary(context, itineraryId, deviceToken);
    }

    @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesViewModel
    public LiveData<Resource<List<Integer>>> getNotificationItineraries(Context context, String deviceToken) {
        return this.notificationRepository.getNotificationItineraries(context, deviceToken);
    }
}
