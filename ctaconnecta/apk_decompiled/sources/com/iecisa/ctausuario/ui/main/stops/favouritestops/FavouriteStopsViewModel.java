package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import androidx.lifecycle.LiveData;
import com.iecisa.ctausuario.model.MapStop;
import java.util.List;

/* loaded from: classes5.dex */
public interface FavouriteStopsViewModel {
    void deleteFavouriteStop(Integer stopId);

    LiveData<List<MapStop>> getAllFavouriteStops();
}
