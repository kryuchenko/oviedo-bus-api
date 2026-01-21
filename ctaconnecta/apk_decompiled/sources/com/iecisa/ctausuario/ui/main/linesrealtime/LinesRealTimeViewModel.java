package com.iecisa.ctausuario.ui.main.linesrealtime;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.StopItinerary;
import java.util.List;

/* loaded from: classes5.dex */
public interface LinesRealTimeViewModel {
    void deleteFavouriteStop(Integer stopId);

    LiveData<Resource<List<StopItinerary>>> getAllStopsFromLine(Integer idLine, Integer vehicleId, boolean fromAllLines, Context context);

    LiveData<Long> insertFavouriteStop(MapStop stop);
}
