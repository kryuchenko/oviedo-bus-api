package com.iecisa.ctausuario.ui.main.route.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.ResumeStepModelView;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.glide.GlideApp;

/* loaded from: classes5.dex */
public class WayViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    @BindView(R.id.ivArrow)
    ImageView ivArrow;

    @BindView(R.id.ivResume)
    ImageView ivResume;

    @BindView(R.id.tvResume)
    TextView tvResume;

    public WayViewHolder(View itemView, Context context) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    public void bindView(ResumeStepModelView step, boolean isLastPosition) {
        loadImage(step, isLastPosition);
        loadTextDetails(step);
    }

    private void loadTextDetails(ResumeStepModelView step) {
        this.tvResume.setText(step.getName());
    }

    private void loadImage(ResumeStepModelView step, boolean isLastPosition) {
        if (isLastPosition) {
            this.ivArrow.setVisibility(8);
        }
        if (step.getVehicleIcon() != null) {
            String vehicleIcon = step.getVehicleIcon();
            if (!vehicleIcon.startsWith("http")) {
                vehicleIcon = Constants.Routes.ROUTE_HTTP + vehicleIcon;
            }
            GlideApp.with(this.context).load(vehicleIcon).into(this.ivResume);
            return;
        }
        Glide.with(this.context).load(this.context.getDrawable(R.drawable.ic_walking)).into(this.ivResume);
    }
}
