package com.iecisa.ctausuario.ui.main.linesrealtime.lineslist;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopItinerary;

/* loaded from: classes5.dex */
public class StopLineHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.busInfoContainer)
    View busInfoContainer;

    @BindView(R.id.dividerBusNumber)
    TextView dividerBusNumber;
    boolean firstVehicle;

    @BindView(R.id.hBus)
    View hBus;

    @BindView(R.id.ivLocationUserStop)
    ImageView ivLocationUserStop;

    @BindView(R.id.ivStopCircle)
    ImageView ivStopCircle;
    boolean lastVehicle;

    @BindView(R.id.rowStopsLine)
    ConstraintLayout rowStopsLine;

    @BindView(R.id.spacerhBus)
    View spacerhBus;

    @BindView(R.id.tvNameStop)
    TextView tvNameStop;

    @BindView(R.id.tvTimeFromStop)
    TextView tvTimeFromStop;

    @BindView(R.id.vBottom)
    View vBottom;

    @BindView(R.id.vTop)
    View vTop;
    int vehicle;

    public StopLineHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(StopItinerary stop, StopItinerary userStop, Context context, int position, Boolean firstOfVehicle, Boolean lastOfVehicle) {
        String nextRealTime = stop.getNextRealTime();
        if (nextRealTime == null || "".equals(nextRealTime)) {
            nextRealTime = "-";
        }
        this.dividerBusNumber.setText(stop.getVehicleId().toString());
        this.firstVehicle = firstOfVehicle.booleanValue();
        this.vehicle = stop.getVehicleId().intValue();
        this.lastVehicle = lastOfVehicle.booleanValue();
        this.tvTimeFromStop.setText(nextRealTime);
        this.tvNameStop.setText(stop.getName());
        setLocationUser(stop, userStop, context);
        setUpLastStop(position);
    }

    private void setLocationUser(StopItinerary stop, StopItinerary userStop, Context context) {
        if (stop.equals(userStop)) {
            this.ivLocationUserStop.setVisibility(0);
            this.tvNameStop.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        } else {
            this.ivLocationUserStop.setVisibility(8);
            this.tvNameStop.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }

    private void setUpLastStop(int position) {
        if (this.firstVehicle) {
            this.vTop.setVisibility(4);
            this.vBottom.setVisibility(0);
            this.hBus.setVisibility(0);
            this.busInfoContainer.setVisibility(0);
            this.spacerhBus.setVisibility(0);
            return;
        }
        this.hBus.setVisibility(8);
        this.busInfoContainer.setVisibility(8);
        if (this.lastVehicle) {
            this.vTop.setVisibility(0);
            this.vBottom.setVisibility(4);
        } else if (position == 0) {
            this.vTop.setVisibility(0);
            this.vBottom.setVisibility(0);
        } else if (position == 1) {
            this.vTop.setVisibility(4);
            this.vBottom.setVisibility(0);
        } else {
            this.vTop.setVisibility(0);
            this.vBottom.setVisibility(4);
        }
    }
}
