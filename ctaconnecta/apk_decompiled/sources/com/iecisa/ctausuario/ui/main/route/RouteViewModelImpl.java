package com.iecisa.ctausuario.ui.main.route;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.data.RouteRepository;
import com.iecisa.ctausuario.model.routes.RoutesModelRequest;
import com.iecisa.ctausuario.model.routes.RoutesRequest;
import com.iecisa.ctausuario.model.routes.RoutesResponse;
import java.util.Calendar;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RouteViewModelImpl extends BaseViewModel implements RouteViewModel {
    private RouteRepository routesRepository;

    @Inject
    public RouteViewModelImpl(Application application, RouteRepository routesRepository) {
        super(application);
        this.routesRepository = routesRepository;
    }

    @Override // com.iecisa.ctausuario.ui.main.route.RouteViewModel
    public LiveData<Resource<RoutesResponse>> calculateRoute(Context context, RoutesModelRequest routesModelRequest) {
        String str;
        Long lValueOf;
        Long lValueOf2;
        String str2 = routesModelRequest.getAddressOrigin().getLatitude().toString() + "," + routesModelRequest.getAddressOrigin().getLongitude().toString();
        String str3 = routesModelRequest.getAddressDestination().getLatitude().toString() + "," + routesModelRequest.getAddressDestination().getLongitude().toString();
        if (!routesModelRequest.isBus()) {
            str = "train";
        } else if (!routesModelRequest.isTrain()) {
            str = "bus";
        } else {
            str = "bus|train";
        }
        String str4 = str;
        Calendar selectedDateTime = routesModelRequest.getSelectedDateTime() != null ? routesModelRequest.getSelectedDateTime() : Calendar.getInstance();
        if (routesModelRequest.isExit()) {
            lValueOf2 = Long.valueOf(selectedDateTime.getTimeInMillis());
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(selectedDateTime.getTimeInMillis());
            lValueOf2 = null;
        }
        return this.routesRepository.calculateRoute(context, new RoutesRequest(str2, str3, lValueOf, lValueOf2, str4, routesModelRequest.getKey()));
    }
}
