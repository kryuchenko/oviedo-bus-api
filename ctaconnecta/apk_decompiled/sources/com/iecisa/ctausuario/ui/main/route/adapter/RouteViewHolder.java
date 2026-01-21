package com.iecisa.ctausuario.ui.main.route.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.Leg;
import com.iecisa.ctausuario.model.routes.ResumeStepModelView;
import com.iecisa.ctausuario.model.routes.Route;
import com.iecisa.ctausuario.model.routes.Step;
import com.iecisa.ctausuario.utils.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class RouteViewHolder extends RecyclerView.ViewHolder {
    private WayListAdapter adapter;
    private Context context;

    @BindView(R.id.rowSearchRoute)
    ConstraintLayout rowSearchRoute;

    @BindView(R.id.rvResume)
    RecyclerView rvResume;

    @BindView(R.id.tvDuration)
    TextView tvDuration;

    @BindView(R.id.tvSince)
    TextView tvSince;

    @BindView(R.id.tvTime)
    TextView tvTime;

    public RouteViewHolder(View itemView, Context context) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void bindView(Route route) {
        if (route.getLegs() == null || route.getLegs().size() <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(route.getLegs().get(0).getDuration().getText()) && route.getLegs().get(0).getDuration() != null) {
            this.tvDuration.setText(route.getLegs().get(0).getDuration().getText());
        }
        if (route.getLegs().get(0).getDepartureTime() != null && route.getLegs().get(0).getArrivalTime() != null && !TextUtils.isEmpty(route.getLegs().get(0).getDepartureTime().getText()) && !TextUtils.isEmpty(route.getLegs().get(0).getArrivalTime().getText())) {
            this.tvTime.setText(String.format("%s - %s", route.getLegs().get(0).getDepartureTime().getText(), route.getLegs().get(0).getArrivalTime().getText()));
        }
        loadDeparture(route.getLegs().get(0));
        setupView(route);
    }

    private void loadDeparture(Leg leg) {
        for (Step step : leg.getSteps()) {
            if (step.getTravelMode().equals(Constants.Routes.ROUTE_TRAVEL_MODE_TRANSIT) && step.getTransitDetails() != null && step.getTransitDetails().getDepartureTime() != null) {
                this.tvSince.setText(String.format("%s desde %s", step.getTransitDetails().getDepartureTime().getText(), step.getTransitDetails().getDepartureStop().getName()));
                return;
            }
        }
    }

    private void setupView(Route route) {
        ArrayList arrayList = new ArrayList();
        if (route.getLegs() != null && route.getLegs().size() > 0) {
            for (Step step : route.getLegs().get(0).getSteps()) {
                ResumeStepModelView resumeStepModelView = new ResumeStepModelView();
                resumeStepModelView.setTravelMode(step.getTravelMode());
                resumeStepModelView.setName(step.getDuration().getText());
                if (step.getTravelMode().equals(Constants.Routes.ROUTE_TRAVEL_MODE_TRANSIT)) {
                    resumeStepModelView.setTravelMode(step.getTransitDetails().getLine().getVehicle().getType());
                    resumeStepModelView.setVehicleIcon(step.getTransitDetails().getLine().getVehicle().getIcon());
                }
                arrayList.add(resumeStepModelView);
            }
        }
        if (arrayList.size() > 0) {
            createAdapter(arrayList);
        }
    }

    private void createAdapter(List<ResumeStepModelView> modelViewList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(0);
        this.rvResume.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvResume.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(this.context.getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvResume.addItemDecoration(dividerItemDecoration);
        WayListAdapter wayListAdapter = new WayListAdapter(modelViewList);
        this.adapter = wayListAdapter;
        this.rvResume.setAdapter(wayListAdapter);
    }
}
