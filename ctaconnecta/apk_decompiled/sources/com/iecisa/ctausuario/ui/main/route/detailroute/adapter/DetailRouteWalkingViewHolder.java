package com.iecisa.ctausuario.ui.main.route.detailroute.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.DetailRouteModel;
import com.iecisa.ctausuario.model.routes.PolylineData;
import com.iecisa.ctausuario.model.routes.Step;
import com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder;

/* loaded from: classes5.dex */
public class DetailRouteWalkingViewHolder extends DetailRouteBaseViewHolder {
    private Context context;

    @BindView(R.id.gpEnd)
    Group gpEnd;

    @BindView(R.id.gpStart)
    Group gpStart;
    private DetailRouteBaseViewHolder.OnRouteClickListener listener;
    private PolylineData polyline;

    @BindView(R.id.tvEndLocation)
    TextView tvEndLocation;

    @BindView(R.id.tvEndTime)
    TextView tvEndTime;

    @BindView(R.id.tvStartLocation)
    TextView tvStartLocation;

    @BindView(R.id.tvStartTime)
    TextView tvStartTime;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    public DetailRouteWalkingViewHolder(View itemView, DetailRouteBaseViewHolder.OnRouteClickListener listener, Context context) throws NoSuchMethodException, SecurityException {
        super(itemView, listener);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        this.context = context;
    }

    @Override // com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder
    public void bindView(Step step, DetailRouteModel startAddress, DetailRouteModel endAddress) {
        this.polyline = step.getPolyline();
        if (step.getTransitDetails() != null && step.getTransitDetails().getLine() != null) {
            this.tvTitle.setText(step.getTransitDetails().getLine().getName());
        } else if (step.getDuration() != null && step.getDistance() != null) {
            this.tvTitle.setText(this.context.getString(R.string.walking_for, step.getDuration().getText(), step.getDistance().getText()));
        }
        if (startAddress != null) {
            this.gpStart.setVisibility(0);
            this.tvStartLocation.setText(startAddress.getLocation());
            this.tvStartTime.setText(startAddress.getTime());
        }
        if (endAddress != null) {
            this.gpEnd.setVisibility(0);
            this.tvEndLocation.setText(endAddress.getLocation());
            this.tvEndTime.setText(endAddress.getTime());
        }
    }

    @OnClick({R.id.rvRouteWalking})
    public void onClickMap() {
        this.listener.onClickMap(this.polyline);
    }
}
