package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopItinerary;

/* loaded from: classes5.dex */
public class LinesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivRingAlert)
    ImageView ivRingAlert;

    @BindView(R.id.rowLine)
    ConstraintLayout rowLine;

    @BindView(R.id.tvLabelNameCompany)
    TextView tvLabelNameCompany;

    @BindView(R.id.tvNameLine)
    TextView tvNameLine;

    @BindView(R.id.tvTimeBusToStop)
    TextView tvTimeBusToStop;

    public LinesHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(StopItinerary stopItinerary, boolean isNextArrival, Context context) {
        this.tvNameLine.setText(stopItinerary.getDirectionDesc());
        this.tvLabelNameCompany.setText(context.getString(R.string.label_name_company, stopItinerary.getCompanyName()));
        if (stopItinerary.isNotificationActive()) {
            this.ivRingAlert.setImageResource(R.drawable.ic_ring_alert_enabled);
            this.ivRingAlert.setContentDescription(context.getString(R.string.accesibility_notification_delete_subscription, stopItinerary.getItineraryDesc()));
        } else {
            this.ivRingAlert.setImageResource(R.drawable.ic_ring_alert);
            this.ivRingAlert.setContentDescription(context.getString(R.string.accesibility_notification_subscription, stopItinerary.getItineraryDesc()));
        }
        if (isNextArrival) {
            setTimeForStop(stopItinerary);
        } else {
            setAlertEnabled();
        }
    }

    private void setTimeForStop(StopItinerary line) {
        this.tvTimeBusToStop.setVisibility(0);
        this.ivRingAlert.setVisibility(4);
        String minutes = line.getMinutes();
        if (minutes == null || "".equals(minutes)) {
            minutes = "-";
        }
        this.tvTimeBusToStop.setText(minutes + " min");
    }

    private void setAlertEnabled() {
        this.tvTimeBusToStop.setVisibility(4);
        this.ivRingAlert.setVisibility(0);
    }
}
