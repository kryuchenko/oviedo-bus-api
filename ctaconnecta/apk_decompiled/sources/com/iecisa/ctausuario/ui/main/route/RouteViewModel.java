package com.iecisa.ctausuario.ui.main.route;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.model.routes.RoutesModelRequest;
import com.iecisa.ctausuario.model.routes.RoutesResponse;

/* loaded from: classes5.dex */
public interface RouteViewModel {
    LiveData<Resource<RoutesResponse>> calculateRoute(Context context, RoutesModelRequest routesModelRequest);
}
