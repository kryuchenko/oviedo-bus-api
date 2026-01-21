package com.iecisa.ctausuario.ui.main.route.detailroute.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.DetailRouteModel;
import com.iecisa.ctausuario.model.routes.Line;
import com.iecisa.ctausuario.model.routes.PolylineData;
import com.iecisa.ctausuario.model.routes.Step;
import com.iecisa.ctausuario.model.routes.TransitStop;
import com.iecisa.ctausuario.model.routes.TransitTime;
import com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.glide.GlideApp;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class DetailRouteTransitViewHolder extends DetailRouteBaseViewHolder {
    private Context context;

    @BindView(R.id.ivTitle)
    ImageView ivTitle;

    @BindView(R.id.ivTitleEnd)
    ImageView ivTitleEnd;
    private DetailRouteBaseViewHolder.OnRouteClickListener listener;
    private PolylineData polyline;

    @BindView(R.id.tvDescriptionTransport)
    TextView tvDescriptionTransport;

    @BindView(R.id.tvProgrammed)
    TextView tvProgrammed;

    @BindView(R.id.tvResumeTransport)
    TextView tvResumeTransport;

    @BindView(R.id.tvStopsTime)
    TextView tvStopsTime;

    @BindView(R.id.tvTime)
    TextView tvTime;

    @BindView(R.id.tvTimeEnd)
    TextView tvTimeEnd;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvTitleEnd)
    TextView tvTitleEnd;

    @BindView(R.id.vColor)
    View vColor;

    public DetailRouteTransitViewHolder(View itemView, DetailRouteBaseViewHolder.OnRouteClickListener listener, Context context) throws NoSuchMethodException, SecurityException {
        super(itemView, listener);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        this.context = context;
    }

    @Override // com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder
    public void bindView(Step step, DetailRouteModel startAddress, DetailRouteModel endAddress) {
        this.polyline = step.getPolyline();
        if (step.getTransitDetails() != null) {
            Line line = step.getTransitDetails().getLine();
            if (line != null && line.getName() != null) {
                this.tvDescriptionTransport.setText(line.getName());
                if (line.getShortName() == null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(this.context.getResources().getColor(R.color.colorBackgroundBus));
                    gradientDrawable.setCornerRadius(10.0f);
                    this.tvDescriptionTransport.setBackground(gradientDrawable);
                }
            }
            TransitTime departureTime = step.getTransitDetails().getDepartureTime();
            TransitTime arrivalTime = step.getTransitDetails().getArrivalTime();
            if (departureTime != null) {
                this.tvTime.setText(departureTime.getText());
                this.tvTimeEnd.setText(arrivalTime.getText());
                long jIntValue = (departureTime.getValue().intValue() * 1000) - System.currentTimeMillis();
                if (TimeUnit.MILLISECONDS.toMinutes(jIntValue) >= 60) {
                    this.tvProgrammed.setVisibility(8);
                } else {
                    this.tvProgrammed.setText(this.context.getString(R.string.programmed_in, String.valueOf(TimeUnit.MILLISECONDS.toMinutes(jIntValue))));
                }
            }
            TransitStop departureStop = step.getTransitDetails().getDepartureStop();
            TransitStop arrivalStop = step.getTransitDetails().getArrivalStop();
            if (departureStop != null && arrivalStop != null) {
                this.tvTitle.setText(departureStop.getName());
                this.tvTitleEnd.setText(arrivalStop.getName());
            }
            if (line != null && line.getVehicle() != null) {
                loadImage(line.getVehicle().getIcon());
            }
            loadResumeName(step.getTransitDetails().getLine());
            Integer numStops = step.getTransitDetails().getNumStops();
            if (numStops == null || step.getDuration() == null || step.getDuration().getText() == null) {
                return;
            }
            this.tvStopsTime.setText(this.context.getString(R.string.stops_time, String.valueOf(numStops), step.getDuration().getText()));
        }
    }

    private void loadResumeName(Line line) {
        if (line.getShortName() != null) {
            this.tvResumeTransport.setText(line.getShortName());
            if (line.getColor() != null && line.getTextColor() != null) {
                int color = Color.parseColor(line.getColor());
                int color2 = Color.parseColor(line.getTextColor());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(10.0f);
                gradientDrawable.setColor(color);
                this.tvResumeTransport.setBackground(gradientDrawable);
                this.vColor.setBackgroundColor(color);
                this.tvResumeTransport.setTextColor(color2);
            }
            this.tvResumeTransport.setVisibility(0);
            return;
        }
        this.tvResumeTransport.setVisibility(8);
    }

    private void loadImage(String photo) {
        if (photo != null) {
            if (!photo.startsWith("http")) {
                photo = Constants.Routes.ROUTE_HTTP + photo;
            }
            GlideApp.with(this.context).load(photo).into(this.ivTitle);
        }
    }

    @OnClick({R.id.rvRouteTransit})
    public void onClickMap() {
        this.listener.onClickMap(this.polyline);
    }
}
