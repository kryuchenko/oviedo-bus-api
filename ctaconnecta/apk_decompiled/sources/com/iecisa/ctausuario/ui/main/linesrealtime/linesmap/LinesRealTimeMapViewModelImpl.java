package com.iecisa.ctausuario.ui.main.linesrealtime.linesmap;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.google.android.gms.maps.model.LatLng;
import com.iecisa.ctausuario.data.LinesRepository;
import com.iecisa.ctausuario.model.vehicles.VehicleCoordinates;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LinesRealTimeMapViewModelImpl extends BaseViewModel implements LinesRealTimeMapViewModel {
    private LinesRepository linesRepository;

    @Inject
    public LinesRealTimeMapViewModelImpl(Application application, LinesRepository linesRepository) {
        super(application);
        this.linesRepository = linesRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModel
    public LiveData<Resource<List<LatLng>>> getPolyline(Integer id, Context context) {
        return this.linesRepository.getPolyline(id, context);
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModel
    public LiveData<Resource<List<VehicleCoordinates>>> getVehicleCoordinates(Context context, Integer id) {
        return this.linesRepository.getVehicleCoordinates(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModel
    public LiveData<Resource<List<VehicleCoordinates>>> getVehiclesCoordinates(Context context, Integer id) {
        return this.linesRepository.getVehiclesCoordinates(context, id);
    }

    @Override // com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapViewModel
    public LiveData<Resource<Integer>> getBusRefreshTime(Context context) {
        return this.linesRepository.getBusRefreshTime(context);
    }
}
