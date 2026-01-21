package com.iecisa.ctausuario.ui.main.stops.detailstop;

import androidx.lifecycle.LiveData;
import com.iecisa.ctausuario.model.MapStop;

/* loaded from: classes5.dex */
public interface DetailStopViewModel {
    void deleteFavouriteStop(Integer stopId);

    LiveData<Long> insertFavouriteStop(MapStop stop);

    LiveData<MapStop> isFavouriteStopInDB(Integer idStop);
}
