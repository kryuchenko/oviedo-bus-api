package com.iecisa.ctausuario.ui.main.linesrealtime.linesmap;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.google.android.gms.maps.model.LatLng;
import com.iecisa.ctausuario.model.vehicles.VehicleCoordinates;
import java.util.List;

/* loaded from: classes5.dex */
public interface LinesRealTimeMapViewModel {
    LiveData<Resource<Integer>> getBusRefreshTime(Context context);

    LiveData<Resource<List<LatLng>>> getPolyline(Integer id, Context context);

    LiveData<Resource<List<VehicleCoordinates>>> getVehicleCoordinates(Context context, Integer id);

    LiveData<Resource<List<VehicleCoordinates>>> getVehiclesCoordinates(Context context, Integer id);
}
