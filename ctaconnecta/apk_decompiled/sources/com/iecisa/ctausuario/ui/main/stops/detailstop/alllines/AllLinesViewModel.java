package com.iecisa.ctausuario.ui.main.stops.detailstop.alllines;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.List;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public interface AllLinesViewModel {
    LiveData<Resource<ResponseBody>> addItinerary(Context context, Integer itineraryId, String deviceToken);

    LiveData<Resource<ResponseBody>> deleteItinerary(Context context, Integer itineraryId, String deviceToken);

    LiveData<Resource<List<Integer>>> getNotificationItineraries(Context context, String deviceToken);

    LiveData<Resource<List<StopItinerary>>> getStopsItineraryByMapStop(Integer idStop, Context context);
}
