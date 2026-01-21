package com.iecisa.ctausuario.ui.main.route.detailroute;

import android.app.Application;
import com.cexmobility.core.ui.BaseViewModel;
import com.iecisa.ctausuario.model.routes.ResumeStepModelView;
import com.iecisa.ctausuario.model.routes.Step;
import com.iecisa.ctausuario.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class DetailRouteViewModelImpl extends BaseViewModel implements DetailRouteViewModel {
    @Inject
    public DetailRouteViewModelImpl(Application application) {
        super(application);
    }

    @Override // com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteViewModel
    public List<ResumeStepModelView> getDataRouteDetail(List<Step> steps) {
        ArrayList arrayList = new ArrayList();
        for (Step step : steps) {
            ResumeStepModelView resumeStepModelView = new ResumeStepModelView();
            resumeStepModelView.setTravelMode(step.getTravelMode());
            resumeStepModelView.setName(step.getDuration().getText());
            if (step.getTravelMode().equals(Constants.Routes.ROUTE_TRAVEL_MODE_TRANSIT)) {
                resumeStepModelView.setTravelMode(step.getTransitDetails().getLine().getVehicle().getType());
                resumeStepModelView.setVehicleIcon(step.getTransitDetails().getLine().getVehicle().getIcon());
            }
            arrayList.add(resumeStepModelView);
        }
        return arrayList;
    }
}
